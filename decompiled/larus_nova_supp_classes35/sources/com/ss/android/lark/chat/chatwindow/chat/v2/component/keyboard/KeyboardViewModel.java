package com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.ResourceFile;
import com.bytedance.lark.pb.basic.v1.URL;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.bytedance.lark.pb.im.v1.CancelAsyncUploadRequest;
import com.bytedance.lark.pb.im.v1.PushUploadResourceStatus;
import com.bytedance.lark.pb.im.v1.UploadResourceRequest;
import com.bytedance.lark.pb.im.v1.UploadResourceResponse;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.k0;
import com.larksuite.rucket.job.RucketJob;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.DoubaoFileInfo;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.Image;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.ImageObj;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkEntityContent;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileInfo;
import com.ss.android.lark.biz.im.api.k;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;
import com.ss.android.lark.chat.service.impl.EditMessageService;
import com.ss.android.lark.chat.service.impl.b2;
import com.ss.android.lark.chat.service.impl.r;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.b1;
import com.ss.android.lark.chat.utils.x;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.keyboard.base.ChatAttachmentEntity;
import com.ss.android.lark.keyboard.base.ImageCompressInfo;
import com.ss.android.lark.keyboard.base.ResourceUploadInfo;
import com.ss.android.lark.keyboard.base.p;
import com.ss.android.lark.keyboard.base.q;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.n;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.utils.Error;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import z5c.p3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000¸\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0018\u0018\u0000  \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u009f\u0001 \u0001B1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>J\u000e\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u00020BJ\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020GH\u0016J\u000e\u0010H\u001a\b\u0012\u0004\u0012\u00020I0DH\u0016J\u0010\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020LH\u0016J(\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020>H\u0016J \u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020L2\u0006\u0010S\u001a\u00020TH\u0016J(\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020L2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020>H\u0016J*\u0010V\u001a\u00020:2\u0006\u0010W\u001a\u00020X2\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020L2\b\u00107\u001a\u0004\u0018\u000108H\u0016JB\u0010Y\u001a\u00020:2\u0006\u0010Z\u001a\u00020L2\u0006\u0010S\u001a\u00020T2\u0006\u0010[\u001a\u00020L2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010aH\u0016J\u0010\u0010c\u001a\u00020:2\u0006\u0010d\u001a\u00020LH\u0016J\u0010\u0010e\u001a\u00020:2\u0006\u0010d\u001a\u00020LH\u0016J\u0018\u0010f\u001a\u00020:2\u0006\u0010g\u001a\u00020>2\u0006\u0010d\u001a\u00020LH\u0002J(\u0010h\u001a\u00020:2\u0006\u0010P\u001a\u00020Q2\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020L2\u0006\u0010R\u001a\u00020>H\u0016J\u0010\u0010i\u001a\u00020>2\u0006\u0010P\u001a\u00020QH\u0016J\u0016\u0010j\u001a\u00020:2\u0006\u0010\\\u001a\u00020]2\u0006\u0010P\u001a\u00020QJJ\u0010k\u001a\u00020:2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020L0a2\u0006\u0010m\u001a\u00020>2\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020L2\u0006\u0010n\u001a\u00020B2\b\u0010o\u001a\u0004\u0018\u00010L2\b\u00107\u001a\u0004\u0018\u00010pH\u0016J6\u0010q\u001a\u00020:2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020r0a2\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020L2\u0006\u0010n\u001a\u00020B2\b\u00107\u001a\u0004\u0018\u00010pJ\u0016\u0010s\u001a\u00020:2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020u0aH\u0016J\u0016\u0010v\u001a\u00020:2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020x0aH\u0016J\u0016\u0010y\u001a\u00020:2\u0006\u0010z\u001a\u00020>2\u0006\u0010{\u001a\u00020|J\u000e\u0010}\u001a\u00020:2\u0006\u0010{\u001a\u00020|J\u0010\u0010~\u001a\u00020\u007f2\u0006\u0010z\u001a\u00020>H\u0002J*\u0010\u0080\u0001\u001a\u00020:2\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020>2\u000e\u0010{\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u0001J(\u0010\u0086\u0001\u001a\u00020:2\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0015\u0010{\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u007f\u0012\u0004\u0012\u00020:0\u0087\u0001J\u0012\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J!\u0010\u008a\u0001\u001a\u00020:2\u0006\u0010d\u001a\u00020L2\u0010\u0010{\u001a\f\u0012\u0005\u0012\u00030\u0085\u0001\u0018\u00010\u0084\u0001J\u0014\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u007f2\u0007\u0010\u008c\u0001\u001a\u00020LH\u0002J\t\u0010\u008d\u0001\u001a\u00020\u007fH\u0002J\u0010\u0010\u008e\u0001\u001a\u00020\u007f2\u0007\u0010\u008f\u0001\u001a\u00020<J\t\u0010\u0090\u0001\u001a\u00020\u007fH\u0002J\u0010\u0010\u0091\u0001\u001a\u00020:2\u0007\u0010\u0092\u0001\u001a\u00020\bJ\u0012\u0010\u0093\u0001\u001a\u00020:2\u0007\u0010\u0094\u0001\u001a\u000204H\u0016J\t\u0010\u0095\u0001\u001a\u00020\bH\u0016J\u0007\u0010\u0096\u0001\u001a\u00020:J\u0007\u0010\u0097\u0001\u001a\u00020:J\t\u0010\u0098\u0001\u001a\u00020:H\u0014J\u0012\u0010\u0099\u0001\u001a\u00020:2\u0007\u0010\u009a\u0001\u001a\u00020!H\u0016J\u001b\u0010\u009b\u0001\u001a\u00020:2\u0007\u0010\u009c\u0001\u001a\u00020L2\u0007\u0010\u009d\u0001\u001a\u00020LH\u0016J\u0012\u0010\u009e\u0001\u001a\u00020:2\u0007\u0010\u009a\u0001\u001a\u00020!H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001e\u001a\u0004\b,\u0010-R\u001c\u0010/\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u000e0\u000e00X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¡\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardViewModel;", "Lcom/ss/android/lark/keyboard/base/ChatAttachmentUploadDependency;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ChatChatterPushHandler$IChatterPushListener;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "currentChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "initP2PChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "chatReplyDigestCreator", "Lcom/ss/android/lark/chat/chatwindow/chat/data/reply/IReplyMsgDigestCreator;", "dependency", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModelDependency;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Lcom/ss/android/lark/chat/entity/chat/Chat;Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;Lcom/ss/android/lark/chat/chatwindow/chat/data/reply/IReplyMsgDigestCreator;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModelDependency;)V", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getCurrentChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "setCurrentChat", "(Lcom/ss/android/lark/chat/entity/chat/Chat;)V", "getDependency", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModelDependency;", "tempEditText", "Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;", "getTempEditText", "()Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;", "tempEditText$delegate", "Lkotlin/Lazy;", "p2pChatterLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "getP2pChatterLiveData", "()Landroidx/lifecycle/MutableLiveData;", "chatterPushHandler", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ChatChatterPushHandler;", "mDraftService", "Lcom/ss/android/lark/chat/service/IDraftService;", "mEditMsgService", "Lcom/ss/android/lark/chat/service/impl/EditMessageService;", "mReplyService", "Lcom/ss/android/lark/chat/chatwindow/chat/data/reply/IReplyService;", "getMReplyService", "()Lcom/ss/android/lark/chat/chatwindow/chat/data/reply/IReplyService;", "mReplyService$delegate", "mDependencyRefs", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "chatUpdateListeners", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardViewModel$IChatUpdateListener;", "mCallbackManager", "Lcom/larksuite/framework/callback/CallbackManager;", "partialReplyInfo", "Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;", "saveAllDraft", BuildConfig.FLAVOR, "draft", "Lcom/ss/android/lark/dto/draft/Draft;", "updateLastDraft", BuildConfig.FLAVOR, "updateRemoteDraft", "removeCurrentChatDraft", "draftType", BuildConfig.FLAVOR, "uploadAttachmentResource", "Lcom/larksuite/rucket/job/RucketJob;", "Lcom/bytedance/lark/pb/im/v1/UploadResourceResponse;", "request", "Lcom/bytedance/lark/pb/im/v1/UploadResourceRequest;", "pushAttachmentUploadResourceStatus", "Lcom/bytedance/lark/pb/im/v1/PushUploadResourceStatus;", "cancelAttachmentUpload", "uploadId", BuildConfig.FLAVOR, "sendTextMsg", "rootMsgId", "parentMsgId", "sendInfo", "Lcom/ss/android/lark/keyboard/base/SendInfo;", "transmitToChat", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "isMentionDoubao", "sendStickerMsg", "stickerFileInfo", "Lcom/ss/android/lark/chat/entity/sticker/StickerFileInfo;", "reEditMsg", "title", "msgId", "context", "Landroid/content/Context;", "extras", "Lcom/ss/android/lark/statistics/extensions/IParam;", "fileAttachments", BuildConfig.FLAVOR, "Lcom/ss/android/lark/keyboard/base/ChatAttachmentEntity;", "recallMsg", "messageId", "cancelRecallMessage", "sendRecallMessageEvent", "isConfirm", "sendPostMsg", "onSendRichText", "sendAttachments", "sendImageMsg", "photos", "keepOrigin", "totalResourceCount", "chooseImageSource", "Lcom/bytedance/lark/pb/basic/v1/Message$PartialReplyInfo;", "sendMediaMsg", "Lcom/ss/android/lark/widget/photopicker/entity/Photo;", "sendFileMsg", "files", "Ljava/io/File;", "sendFileMsgByUri", "uris", "Landroid/net/Uri;", "resetChatDraft", "resetOnStart", "callback", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModel$IResetDraftCallback;", "syncChatDraft", "getChatDraft", "Lcom/ss/android/lark/chatbase/model/data/ComposeDrafts;", "getReplyInfo", "messageInfo", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "needPrefix", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chatwindow/model/data/ReplyInfo;", "getDraftById", "Lkotlin/Function1;", "getReplyDigest", BuildConfig.FLAVOR, "getReEditReplyInfo", "getLastDraft", "lastDraftId", "getDraftInChat", "packDraftToComposeDrafts", "postDraft", "fetchChatInputDraft", "updateChat", "chat", "addChatUpdateListener", "listener", "getChat", "clearChatGeneralDraft", "clearChatScheduleDraft", "onCleared", "onPushUpdatedChatter", "chatter", "onPushUpdatedNickname", "chatterId", "nickname", "onUpdateSelfInfo", "IResetDraftCallback", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardViewModel extends ViewModel implements j2b.b, com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a {
    public static final a Companion = null;
    private static final String TAG = "KeyboardViewModel";
    private final v chatContainer;
    private final com.ss.android.lark.chat.chatwindow.chat.data.reply.a chatReplyDigestCreator;
    private final Set<j2b.b.a> chatUpdateListeners;
    private final com.ss.android.lark.chat.chatwindow.chat.v2.push.d chatterPushHandler;
    private Chat currentChat;
    private final com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a dependency;
    private final CallbackManager mCallbackManager;
    private final WeakReference<com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a> mDependencyRefs;
    private final m6b.g mDraftService;
    private final EditMessageService mEditMsgService;
    private final Lazy mReplyService$delegate;
    private final MutableLiveData<Chatter> p2pChatterLiveData;
    private PartialReplyInfo partialReplyInfo;
    private final Lazy tempEditText$delegate;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a(a7b.a r1);
    }

    public static final class c implements Runnable {
        public final /* synthetic */ String[] a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ KeyboardViewModel c;

        public c(String[] r1, boolean r2, KeyboardViewModel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String[] r0 = this.a;     // Catch: Throwable -> L9
            KeyboardViewModel r1 = this.c;     // Catch: Throwable -> L9
            int r2 = r0.length;     // Catch: Throwable -> L9
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L6;
            String r4 = r0[r3];     // Catch: Throwable -> L9
            KeyboardViewModel.access$getMDraftService$p(r1).a8(r4);     // Catch: Throwable -> L9
            r3 = r3 + 1;     // Catch: Throwable -> L9
            goto L3
        L6:
            if (this.b == false) goto L12;
            KeyboardViewModel.access$getMDraftService$p(this.c).Mb(this.c.getCurrentChat().getId(), BuildConfig.FLAVOR);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ KeyboardViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public d(KeyboardViewModel r1, String r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KeyboardViewModel.access$getMDraftService$p(this.a).a8(this.b);     // Catch: Throwable -> L6
            if (this.c == false) goto L9;
            KeyboardViewModel.access$getMDraftService$p(this.a).Mb(this.a.getCurrentChat().getId(), BuildConfig.FLAVOR);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ m6b.g a;
        public final /* synthetic */ String b;
        public final /* synthetic */ KeyboardViewModel c;
        public final /* synthetic */ MessageInfo d;
        public final /* synthetic */ Function1<a7b.a, Unit> e;

        /* JADX WARN: Multi-variable type inference failed */
        public e(m6b.g r1, String r2, KeyboardViewModel r3, MessageInfo r4, Function1<? super a7b.a, Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            Draft r0 = this.a.Pc(this.b);
            if (r0 != null) goto L6;
            this.e.invoke(null);
            return;
        L6:
            a7b.a r1 = new a7b.a(r0.contentRichText, r0.title, r0.postRichText);
            r1.l = r0.queryStatusInfo;
            String r2 = r0.messageId;
            boolean r3 = true;
            if (r2 != null) goto L9;
        L12:
            boolean r5 = true;
        L13:
            if (r5 == true) goto L15;
            r1.g = BuildConfig.FLAVOR;
            r1.f = r2;
            r1.h = this.c.getReplyDigest(this.d);
        L15:
            String r4 = r0.reEditMessageId;
            if (r4 != null) goto L18;
        L21:
            if (r3 == true) goto L27;
            r1.d = r4;
            Message r6 = ImSdkService.f().za(r4);
            if (r6 == null) goto L25;
            long r7 = r6.getCreateTime();
        L26:
            r1.e = r7;
            goto L27
        L25:
            r7 = 0;
        L27:
            this.e.invoke(r1);
            return;
        L18:
            if (r4.length() == 0) goto L21;
            r3 = false;
            goto L21
        L9:
            if (r2.length() == 0) goto L12;
            r5 = false;
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ KeyboardViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public f(KeyboardViewModel r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KeyboardViewModel.access$getMDraftService$p(this.a).M8(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ KeyboardViewModel a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ b c;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ a7b.a b;

            public a(b r1, a7b.a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public g(KeyboardViewModel r1, boolean r2, b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            Log.d(TitlebarViewModel.LOG_TAG, "Executing reset draft on Thread: " + ThreadMethodProxy.currentThread());
            UICallbackExecutor.execute(new a(this.c, KeyboardViewModel.access$getChatDraft(this.a, this.b)));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ Draft a;
        public final /* synthetic */ KeyboardViewModel b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public static final class a implements r.a {
            public final /* synthetic */ boolean a;
            public final /* synthetic */ KeyboardViewModel b;

            public a(boolean r1, KeyboardViewModel r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.ss.android.lark.chat.service.impl.r.a
            public final Boolean a() {
                if (this.a == true) goto L5;
            L9:
                boolean r0 = false;
            L11:
                return Boolean.valueOf(r0);
            L5:
                if (this.b.getCurrentChat().isSecret() == true) goto L9;
                if (this.b.getChatContainer().C().isEnable("lark.chat.reset.sync") == false) goto L9;
                r0 = true;
                goto L11
            }
        }

        public h(Draft r1, KeyboardViewModel r2, boolean r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            Log.d(TitlebarViewModel.LOG_TAG, "Executing save draft on Thread: " + ThreadMethodProxy.currentThread());
            if (this.a.type != 7) goto L8;
            m6b.g r0 = KeyboardViewModel.access$getMDraftService$p(this.b);
            String r1 = this.b.getCurrentChat().getId();
            Draft r2 = this.a;
            boolean r3 = this.c;
            String r4 = this.b.getCurrentChat().getScheduleDraftId();
            if (r4 != null) goto L7;
            r4 = BuildConfig.FLAVOR;
        L7:
            r0.tc(r1, r2, r3, r4);
            return;
        L8:
            String r5 = KeyboardViewModel.access$getMDraftService$p(this.b).x8(this.b.getCurrentChat(), this.a, this.c);
            boolean r6 = this.d;
            KeyboardViewModel r7 = this.b;
            a r8 = new a(r6, r7);
            if (this.c == true) goto L11;
            r5 = r7.getCurrentChat().getLastDraftId();
        L11:
            m6b.g r9 = KeyboardViewModel.access$getMDraftService$p(this.b);
            String r10 = this.b.getCurrentChat().getId();
            if (r5 != null) goto L14;
        L17:
            boolean r11 = true;
        L18:
            if (r11 == false) goto L20;
            r5 = null;
        L20:
            r9.o5(new b2.a(r10, r5), ChatParamUtils.c(this.b.getCurrentChat()), ChatParamUtils.d(this.b.getCurrentChat()), r8);
            return;
        L14:
            if (StringsKt.isBlank(r5) == true) goto L17;
            r11 = false;
            goto L18
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ s5c.d b;

        public i(String r1, s5c.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Message r0 = ImSdkService.f().za(this.a);
            if (r0 != null) goto L5;
            return;
        L5:
            s5c.d r1 = this.b.plus(p3.c).plus(ChatParamUtils.g(r0));
            Lazy r2 = ChatHitPointNew.a;
            Intrinsics.checkNotNullParameter(r1, "param");
            JSONObject r3 = r1.plus(ChatParamUtils.e()).toJson();
            ChatHitPointNew.d().sendEvent("im_msg_withdraw_confirm_click", r3);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ KeyboardViewModel a;
        public final /* synthetic */ b b;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ a7b.a b;

            public a(b r1, a7b.a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public j(KeyboardViewModel r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a7b.a r0 = KeyboardViewModel.access$fetchChatInputDraft(this.a);     // Catch: Throwable -> L4
            UICallbackExecutor.execute(new a(this.b, r0));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel$recallMsg$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel$recallMsg$2", f = "KeyboardViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ KeyboardViewModel this$0;

        public AnonymousClass2(KeyboardViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ErrorResult) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r4);
            ErrorResult r5 = (ErrorResult) this.L$0;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r0 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a) KeyboardViewModel.access$getMDependencyRefs$p(this.this$0).get();
            if (r0 == null) goto L7;
            Context r1 = r0.getContext();
        L8:
            Log.w(TitlebarViewModel.LOG_TAG, r5.getDisplayMsg());
            if (r1 == null) goto L15;
            String r6 = r5.getDisplayMsg();
            if (r6 != null) goto L13;
            r6 = BuildConfig.FLAVOR;
        L13:
            UDToast.show(r1, r6);
        L15:
            return Unit.INSTANCE;
        L7:
            r1 = null;
            goto L8
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public final void clearChatGeneralDraft() {
        String[] r0 = {this.currentChat.getTextDraftId(), this.currentChat.getPostDraftId()};
        this.mDraftService.getExecutor().execute(new c(r0, ArraysKt.contains(r0, this.currentChat.getLastDraftId()), this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public void onPushUpdatedNickname(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r3, "nickname");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public void onUpdateSelfInfo(Chatter r2) {
        Intrinsics.checkNotNullParameter(r2, "chatter");
    }

    private final a7b.a getDraftInChat() {
        ArrayList r0 = new ArrayList();
        String r1 = this.currentChat.getTextDraftId();
        String r2 = this.currentChat.getPostDraftId();
        if (TextUtils.isEmpty(r1) == true) goto L6;
        r0.add(r1);
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r0.add(r2);
    L8:
        Log.i(TitlebarViewModel.LOG_TAG, "getDraftInChat: post draft id: " + r2 + " , text draft id: " + r1);
        Map<String, Draft> r3 = this.mDraftService.se(r0);
        Draft r4 = r3.get(r1);
        RichText r5 = com.ss.android.lark.widget.richtext.c.a();
        if (r4 != null) goto L11;
        RichText r6 = r5;
    L12:
        Draft r7 = r3.get(r2);
        if (r7 != null) goto L15;
        String r8 = BuildConfig.FLAVOR;
    L16:
        if (r7 != null) goto L18;
        RichText r9 = r5;
    L20:
        if (this.currentChat.isAllowPost() == false) goto L29;
        a7b.a r10 = new a7b.a(r6, r8, r9);
        DraftAttachmentSnapshot r11 = null;
        if (r7 == null) goto L24;
        QueryStatusInfo r12 = r7.queryStatusInfo;
    L25:
        r10.l = r12;
        r10.o = a7b.b.c;
        if (r7 == null) goto L28;
        r11 = r7.attachmentSnapshot;
    L28:
        r10.m = r11;
        return r10;
    L24:
        r12 = null;
        goto L25
    L29:
        a7b.a r13 = new a7b.a(r5, BuildConfig.FLAVOR, r5);
        r13.o = a7b.b.c;
        return r13;
    L18:
        r9 = r7.postRichText;
        goto L20
    L15:
        r8 = r7.title;
        goto L16
    L11:
        r6 = r4.contentRichText;
        goto L12
    }

    private final com.ss.android.lark.chat.chatwindow.chat.data.reply.b getMReplyService() {
        return (com.ss.android.lark.chat.chatwindow.chat.data.reply.b) this.mReplyService$delegate.getValue();
    }

    private final KeyboardFunctionEditText getTempEditText() {
        return (KeyboardFunctionEditText) this.tempEditText$delegate.getValue();
    }

    public final void clearChatScheduleDraft() {
        String r0 = this.currentChat.getScheduleDraftId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        boolean r2 = Intrinsics.areEqual(this.currentChat.getLastDraftId(), r0);
        this.mDraftService.getExecutor().execute(new d(this, r0, r2));
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public RucketJob<PushUploadResourceStatus> pushAttachmentUploadResourceStatus() {
        return ((m6b.h) ((c38.a) this.mEditMsgService).a.create(m6b.h.class)).pushUploadResourceStatus();
    }

    private final a7b.a fetchChatInputDraft() {
        RichText r0 = com.ss.android.lark.widget.richtext.c.a();
        if (this.currentChat.isAllowPost() == false) goto L5;
        Draft r1 = this.mDraftService.b6(this.currentChat.getId());
        if (r1 == null) goto L11;
        a7b.a r2 = packDraftToComposeDrafts(r1);
        if (r2 == null) goto L11;
        return r2;
    L11:
        return getChatDraft(true);
    L5:
        return new a7b.a(r0, BuildConfig.FLAVOR, r0);
    }

    public void onCleared() {
        super.onCleared();
        this.mCallbackManager.cancelCallbacks();
        this.chatterPushHandler.unRegister();
    }

    public Chat getChat() {
        return this.currentChat;
    }

    public final v getChatContainer() {
        return this.chatContainer;
    }

    public final Chat getCurrentChat() {
        return this.currentChat;
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a getDependency() {
        return this.dependency;
    }

    public final MutableLiveData<Chatter> getP2pChatterLiveData() {
        return this.p2pChatterLiveData;
    }

    public static final /* synthetic */ a7b.a access$fetchChatInputDraft(KeyboardViewModel r0) {
        return r0.fetchChatInputDraft();
    }

    public static final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.data.reply.a access$getChatReplyDigestCreator$p(KeyboardViewModel r0) {
        return r0.chatReplyDigestCreator;
    }

    public static final /* synthetic */ WeakReference access$getMDependencyRefs$p(KeyboardViewModel r0) {
        return r0.mDependencyRefs;
    }

    public static final /* synthetic */ m6b.g access$getMDraftService$p(KeyboardViewModel r0) {
        return r0.mDraftService;
    }

    private final a7b.a getChatDraft(boolean r2) {
        if (r2 == false) goto L4;
        String r3 = this.currentChat.getLastDraftId();
        if (r3 != null) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        a7b.a r4 = getDraftInChat();
    L15:
        if (r4 == null) goto L17;
        return r4;
    L17:
        return getDraftInChat();
    L14:
        r4 = getLastDraft(r3);
        goto L15
    L8:
        if (r3.length() == 0) goto L11;
        r0 = false;
        goto L12
    L4:
        return getDraftInChat();
    }

    private final a7b.a getLastDraft(String r10) {
        Log.i(TitlebarViewModel.LOG_TAG, "getLastDraft: last draft id : " + r10);
        Draft r0 = this.mDraftService.Pc(r10);
        String r2 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        String r3 = r0.messageId;
        boolean r4 = true;
        if (r3 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L25;
        String r6 = r0.reEditMessageId;
        if (r6 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == false) goto L25;
        if (r0.scheduleDraftInfo != null) goto L25;
        Log.e(TitlebarViewModel.LOG_TAG, "both draft message id && draft reedit message id && schedule info are null, method return");
        return null;
    L16:
        if (r6.length() == 0) goto L19;
        r7 = false;
    L25:
        a7b.a r8 = new a7b.a(r0.contentRichText, r0.title, r0.postRichText);
        r8.l = r0.queryStatusInfo;
        r8.o = a7b.b.c;
        String r9 = r0.messageId;
        if (r9 == null) goto L50;
        Message r11 = r0.message;
        if (r11 == null) goto L33;
        ChatChatter r12 = r0.sender;
        if (r12 == null) goto L33;
        MessageInfo r13 = new MessageInfo(r11, r12);
    L34:
        if (r13 == null) goto L36;
        r13.setPartialReplyInfo(r0.partialReplyInfo);
    L36:
        com.ss.android.lark.chat.chatwindow.chat.data.reply.a r1 = this.chatReplyDigestCreator;
        if (r13 == null) goto L39;
        ChatChatter r14 = r13.getMessageSender();
    L40:
        CharSequence r15 = r1.a(r14, r13, false, null);
        r8.f = r9;
        r8.h = r15;
        if (r13 == null) goto L46;
        Message r16 = r13.getMessage();
        if (r16 == null) goto L46;
        r2 = r16.getRootId();
    L46:
        if (TextUtils.isEmpty(r2) == true) goto L49;
        r9 = r2;
    L49:
        r8.g = r9;
        goto L50
    L39:
        r14 = null;
    L33:
        Log.e(TitlebarViewModel.LOG_TAG, "get lastDraft，message or chatter is null, lastDraftId:" + r10 + ", message:" + r0.message + ", chatter:" + r0.sender);
        r13 = (MessageInfo) ImSdkService.f().W5(CollectionsKt.listOf(r9)).get(r9);
    L50:
        String r17 = r0.reEditMessageId;
        if (r17 != null) goto L53;
    L56:
        if (r4 == true) goto L62;
        r8.d = r17;
        Message r18 = ImSdkService.f().za(r17);
        if (r18 == null) goto L60;
        long r19 = r18.getCreateTime();
    L61:
        r8.e = r19;
        goto L62
    L60:
        r19 = 0;
    L62:
        r8.i = r0.scheduleDraftInfo;
        r8.j = new p(this.currentChat.getId());
        r8.k = r0.partialReplyInfo;
        r8.m = r0.attachmentSnapshot;
        return r8;
    L53:
        if (r17.length() == 0) goto L56;
        r4 = false;
        goto L56
    L8:
        if (r3.length() == 0) goto L11;
        r5 = false;
        goto L12
    }

    public void addChatUpdateListener(j2b.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.chatUpdateListeners.add(r2);
    }

    public void cancelAttachmentUpload(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uploadId");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        EditMessageService r1 = this.mEditMsgService;
        CancelAsyncUploadRequest r4 = new CancelAsyncUploadRequest.Builder().upload_ids(CollectionsKt.listOf(r3)).build();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "request");
        ((m6b.h) ((c38.a) r1).a.create(m6b.h.class)).cancelAsyncUpload(r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void cancelRecallMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        sendRecallMessageEvent(false, r2);
    }

    public final CharSequence getReplyDigest(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return getMReplyService().a(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public void onPushUpdatedChatter(Chatter r3) {
        Intrinsics.checkNotNullParameter(r3, "chatter");
        if (this.currentChat.isP2PChat() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3.getId(), this.currentChat.getP2pChatterId()) == false) goto L9;
        this.p2pChatterLiveData.postValue(r3);
        return;
    }

    public boolean onSendRichText(q r18) {
        Intrinsics.checkNotNullParameter(r18, "sendInfo");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r2 = this.mDependencyRefs.get();
        Map r3 = null;
        if (r2 == null) goto L5;
        q4b.a r4 = r2.getMessageSender();
    L7:
        if (r4 != null) goto L11;
        Log.e(TitlebarViewModel.LOG_TAG, "onSendRichText: sender is null");
        return false;
    L11:
        if (Intrinsics.areEqual(r4.m(), this.currentChat.getId()) == true) goto L14;
        Log.e(TitlebarViewModel.LOG_TAG, "onSendRichText: chat not match, sendMsgChatId=" + r4.m() + ", currentChatId=" + this.currentChat.getId());
        return false;
    L14:
        m5b.d r5 = b1.a(r18);
        com.ss.android.lark.keyboard.base.r r6 = r18.j;
        if (r6 == null) goto L21;
        List r7 = r6.k;
        if (r7 == null) goto L21;
        if ((!r7.isEmpty()) != true) goto L21;
        boolean r8 = true;
    L22:
        com.ss.android.lark.keyboard.base.r r9 = r18.j;
        if (r9 == null) goto L66;
        RichText r10 = r9.u;
        if (r10 == null) goto L66;
        if ((!r8) == true) goto L30;
        r10 = null;
    L30:
        if (r10 == null) goto L66;
        m5b.e r11 = r5.e;
        if (r11 == null) goto L66;
        int r12 = cdb.b.a;
        Intrinsics.checkNotNullParameter(r10, "richText");
        LinkedHashMap r13 = new LinkedHashMap();
        LinkedHashMap r14 = new LinkedHashMap();
        RichText.RichTextElements r15 = r10.getElements();
        if (r15 == null) goto L36;
        r3 = r15.getDictionary();
    L36:
        if (r3 != null) goto L38;
    L41:
        boolean r16 = true;
    L42:
        if (r16 == false) goto L44;
        xcb.a r17 = new xcb.a(r13, r14);
    L65:
        r11.z = r17;
        goto L66
    L44:
        List r19 = r10.getAnchorIds();
        if (r19 == null) goto L64;
        Iterator r20 = r19.iterator();
    L48:
        if (r20.hasNext() == false) goto L64;
        String r110 = (String) r20.next();
        RichTextElement r111 = (RichTextElement) r3.get(r110);
        if (r111 == null) goto L48;
        RichTextElement.AnchorProperty r112 = r111.getProperty();
        if (r112 == null) goto L48;
        if (r112.isUrlPreview() == false) goto L48;
        String r113 = new k0().toString();
        String r114 = r112.getHref();
        if (r114 != null) goto L60;
        r114 = BuildConfig.FLAVOR;
    L60:
        UrlPreviewHangPoint.Builder r115 = new UrlPreviewHangPoint.Builder().url(r114).preview_id(r113);
        Boolean r21 = Boolean.FALSE;
        r13.put(r110, r115.need_local_preview(r21).is_lazy_load(r21).send_scene(UrlPreviewHangPoint.SendScene.DEFAULT).build());
        UrlPreviewEntity.Builder r22 = new UrlPreviewEntity.Builder().is_sdk_preview(r21).source_id(r113).preview_id(r113).url(new URL.Builder().url(r114).build());
        String r116 = r112.getDisplayTitle();
        if (r116 != null) goto L63;
        r116 = r112.getContent();
    L63:
        r14.put(r113, r22.server_title(r116).server_icon_key(r112.getIconKey()).version(Integer.valueOf(r112.getVersion())).need_reload(r21).use_color_icon(r21).build());
    L64:
        r17 = new xcb.a(r13, r14);
        goto L65
    L38:
        if (r3.isEmpty() == true) goto L41;
        r16 = false;
    L66:
        m5b.e r23 = r5.e;
        if (r23 == null) goto L73;
        List<File> r24 = r23.A;
        if (r24 == null) goto L73;
        boolean r25 = true;
        if ((!r24.isEmpty()) != true) goto L74;
        boolean r26 = true;
    L75:
        if (r26 == false) goto L79;
        r4.l(r5);
        return r25;
    L79:
        if (x.b(r18.c, r18.a) == false) goto L82;
        r4.g(r5);
        return r25;
    L82:
        m5b.e r1 = r5.e;
        if (r1 != null) goto L85;
    L87:
        boolean r117 = false;
    L88:
        if (r117 == false) goto L91;
        r4.g(r5);
        return r25;
    L91:
        r4.l(r5);
        return r25;
    L85:
        if (r1.c != r25) goto L87;
        r117 = true;
    L74:
        r26 = false;
    L73:
        r25 = true;
    L21:
        r8 = false;
        goto L22
    L5:
        r4 = null;
        goto L7
    }

    public final a7b.a packDraftToComposeDrafts(Draft r8) {
        Intrinsics.checkNotNullParameter(r8, "postDraft");
        RichText r0 = r8.contentRichText;
        if (r0 != null) goto L5;
        r0 = com.ss.android.lark.widget.richtext.c.a();
    L5:
        String r1 = r8.title;
        if (r1 != null) goto L8;
        r1 = BuildConfig.FLAVOR;
    L8:
        RichText r2 = r8.postRichText;
        if (r2 != null) goto L11;
        r2 = com.ss.android.lark.widget.richtext.c.a();
    L11:
        a7b.a r3 = new a7b.a(r0, r1, r2);
        r3.l = r8.queryStatusInfo;
        r3.m = r8.attachmentSnapshot;
        Boolean r4 = r8.isReloadUrl;
        Boolean r5 = Boolean.TRUE;
        r3.n = Intrinsics.areEqual(r4, r5);
        if (Intrinsics.areEqual(r8.isReloadUrl, r5) == false) goto L14;
        a7b.b r6 = a7b.b.d;
    L15:
        r3.o = r6;
        if (n.a(r8.messageId) == false) goto L18;
    L23:
        String r7 = r8.messageId;
        if (r7 != null) goto L26;
    L51:
        String r9 = r8.reEditMessageId;
        if (n.a(r9) == false) goto L58;
        r3.d = r9;
        com.ss.android.lark.im.sdk.service.p r10 = ImSdkService.f();
        Intrinsics.checkNotNull(r9);
        Message r11 = r10.za(r9);
        if (r11 == null) goto L56;
        long r12 = r11.getCreateTime();
    L57:
        r3.e = r12;
        goto L58
    L56:
        r12 = 0;
    L58:
        r3.i = r8.scheduleDraftInfo;
        r3.j = new p(this.currentChat.getId());
        r3.k = r8.partialReplyInfo;
        return r3;
    L26:
        if (n.a(r7) == false) goto L51;
        Message r13 = r8.message;
        if (r13 == null) goto L34;
        ChatChatter r14 = r8.sender;
        if (r14 == null) goto L34;
        MessageInfo r15 = new MessageInfo(r13, r14);
    L35:
        if (r15 == null) goto L37;
        r15.setPartialReplyInfo(r8.partialReplyInfo);
    L37:
        com.ss.android.lark.chat.chatwindow.chat.data.reply.a r16 = this.chatReplyDigestCreator;
        String r17 = null;
        if (r15 == null) goto L40;
        ChatChatter r18 = r15.getMessageSender();
    L41:
        CharSequence r19 = r16.a(r18, r15, false, null);
        r3.f = r7;
        r3.h = r19;
        if (r15 == null) goto L47;
        Message r20 = r15.getMessage();
        if (r20 == null) goto L47;
        r17 = r20.getRootId();
    L47:
        if (TextUtils.isEmpty(r17) == true) goto L50;
        r7 = r17;
    L50:
        r3.g = r7;
        goto L51
    L40:
        r18 = null;
    L34:
        Log.e(TitlebarViewModel.LOG_TAG, "get lastDraft，message or chatter is null, lastDraftId:" + r8.id + ", message id:" + r8.messageId + "chat id:" + r8.chatId + "thread id:" + r8.threadId);
        r15 = (MessageInfo) ImSdkService.f().W5(CollectionsKt.listOf(r7)).get(r7);
        goto L35
    L18:
        if (n.a(r8.reEditMessageId) == true) goto L23;
        if (r8.scheduleDraftInfo != null) goto L23;
        Log.e(TitlebarViewModel.LOG_TAG, "both draft message id && draft reedit message id && schedule info are null, method return");
        return r3;
    L14:
        r6 = a7b.b.c;
        goto L15
    }

    public void recallMsg(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        sendRecallMessageEvent(true, r4);
        com.larksuite.rucket.job.compat.f.a(new AnonymousClass1(this, r4)).error(Dispatchers.getMain(), new AnonymousClass2(this, null));
    }

    public final void removeCurrentChatDraft(int r4) {
        String r0 = this.currentChat.getId();
        Log.i(TitlebarViewModel.LOG_TAG, "removeCurrentChatDraft: chat id is : " + r0);
        this.mDraftService.getExecutor().execute(new f(this, r0, r4));
    }

    public void sendFileMsg(List<? extends java.io.File> r2) {
        Intrinsics.checkNotNullParameter(r2, "files");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r0 = this.mDependencyRefs.get();
        if (r0 == null) goto L8;
        q4b.a r1 = r0.getMessageSender();
        if (r1 == null) goto L9;
        r1.i(r2);
        return;
    L9:
        return;
    }

    public void sendFileMsgByUri(List<? extends Uri> r2) {
        Intrinsics.checkNotNullParameter(r2, "uris");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r0 = this.mDependencyRefs.get();
        if (r0 == null) goto L8;
        q4b.a r1 = r0.getMessageSender();
        if (r1 == null) goto L9;
        r1.q(r2);
        return;
    L9:
        return;
    }

    public final void setCurrentChat(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.currentChat = r2;
    }

    public final void syncChatDraft(b r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.mDraftService.getExecutor().execute(new j(this, r3));
    }

    public final void updateChat(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        this.currentChat = r2;
        Iterator<T> r3 = this.chatUpdateListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((j2b.b.a) r3.next()).a();
        goto L4
    }

    public RucketJob<UploadResourceResponse> uploadAttachmentResource(UploadResourceRequest r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        EditMessageService r1 = this.mEditMsgService;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "request");
        return ((m6b.h) ((c38.a) r1).a.create(m6b.h.class)).uploadResource(r3);
    }

    public static final /* synthetic */ a7b.a access$getChatDraft(KeyboardViewModel r0, boolean r1) {
        return r0.getChatDraft(r1);
    }

    private final void sendRecallMessageEvent(boolean r3, String r4) {
        if (r3 == false) goto L4;
        s5c.a r5 = z5c.r.e;
    L5:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new i(r4, r5));
        return;
    L4:
        r5 = z5c.r.h;
        goto L5
    }

    public final void getDraftById(MessageInfo r8, final Function1<? super a7b.a, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "messageInfo");
        Intrinsics.checkNotNullParameter(r9, "callback");
        String r3 = r8.getMessage().getEditInfo().getEditDraftId();
        Function1<a7b.a, Unit> r6 = new KeyboardViewModel$getDraftById$invokeResult$1(r9);
        m6b.g r2 = this.mDraftService;
        r2.getExecutor().execute(new e(r2, r3, this, r8, r6));
    }

    public final void getReEditReplyInfo(String r5, IGetDataCallback<i7b.c> r6) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        MessageInfo r0 = ImSdkService.f().p(r5);
        if (r0 != null) goto L8;
        Exception r1 = new Exception("unknown error");
        ErrorResult r2 = new ErrorResult(0);
        ErrorResult.access$002(r2, -1);
        ErrorResult.access$102(r2, Error.ParameterNull);
        ErrorResult.access$202(r2, 0);
        ErrorResult.access$302(r2, r1);
        ErrorResult.access$402(r2, BuildConfig.FLAVOR);
        ErrorResult.access$502(r2, "getLocalMessageInfo for " + r5 + " returns null");
        ErrorResult.access$602(r2, BuildConfig.FLAVOR);
        ErrorResult.access$702(r2, BuildConfig.FLAVOR);
        ErrorResult.access$802(r2, 0);
        ErrorResult.access$902(r2, null);
        ErrorResult.access$1002(r2, null);
        ErrorResult.access$1102(r2, null);
        if (r6 == null) goto L10;
        r6.onError(r2);
        return;
    L10:
        return;
    L8:
        getMReplyService().c(r0, (IGetDataCallback) this.mCallbackManager.wrapAndAddCallback(r6));
    }

    public final void resetChatDraft(boolean r3, b r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.mDraftService.getExecutor().execute(new g(this, r3, r4));
    }

    public final void sendAttachments(Context r25, q r26) {
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r26, "sendInfo");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r4 = this.mDependencyRefs.get();
        if (r4 == null) goto L5;
        q4b.a r5 = r4.getMessageSender();
    L6:
        com.ss.android.lark.keyboard.base.r r6 = r26.j;
        if (r6 == null) goto L9;
        List r7 = r6.j;
    L10:
        List r8 = r7;
        if (r8 != null) goto L13;
    L16:
        boolean r9 = true;
    L18:
        if (r9 == true) goto L262;
        if (r5 == null) goto L262;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r7.iterator();
    L23:
        if (r11.hasNext() == false) goto L59;
        Object r12 = r11.next();
        UplinkFileEntity r13 = (UplinkFileEntity) r12;
        if (r13.getDoubaoFileInfo() == null) goto L43;
        if (wxa.f.a(r13) == false) goto L53;
        UplinkEntityContent r14 = r13.getUplinkEntityContent();
        if (r14 == null) goto L33;
        UplinkFileInfo r15 = r14.getUplinkFileInfo();
        if (r15 == null) goto L33;
        String r16 = r15.getFileName();
    L34:
        if (r16 != null) goto L36;
    L39:
        boolean r17 = true;
    L40:
        if (r17 == true) goto L53;
    L52:
        boolean r18 = true;
    L54:
        if (r18 == true) goto L56;
        Log.e(TAG, "sendAttachments: attachment cannot be dispatched, attachment = " + r13.getFileIdentifier());
    L56:
        if (r18 == false) goto L23;
        r10.add(r12);
        goto L23
    L36:
        if (StringsKt.isBlank(r16) == true) goto L39;
        r17 = false;
    L33:
        r16 = null;
    L53:
        r18 = false;
        goto L54
    L43:
        if (r13.getUri() == null) goto L53;
        if (wxa.f.b(r13) == true) goto L52;
        if (wxa.f.d(r13) == true) goto L52;
        if (wxa.f.c(r13) == true) goto L52;
        if (wxa.f.e(r13) == false) goto L53;
    L59:
        if (r26.b.length() <= 0) goto L61;
        boolean r19 = true;
    L62:
        Iterator r110 = r10.iterator();
        int r111 = 0;
    L64:
        if (r110.hasNext() == false) goto L261;
        Object r112 = r110.next();
        int r113 = r111 + 1;
        if (r111 >= 0) goto L68;
        CollectionsKt.throwIndexOverflow();
    L68:
        UplinkFileEntity r114 = (UplinkFileEntity) r112;
        if (r19 == false) goto L71;
    L73:
        boolean r115 = false;
    L74:
        com.ss.android.lark.keyboard.base.r r116 = r26.j;
        if (r116 == null) goto L77;
        r116.e = Boolean.valueOf(r115);
    L77:
        StringBuilder r20 = new StringBuilder("[MessageBatch] dispatch attachment, queueId=");
        com.ss.android.lark.keyboard.base.r r117 = r26.j;
        if (r117 == null) goto L80;
        Long r118 = r117.d;
    L81:
        r20.append(r118);
        r20.append(", index=");
        r20.append(r113);
        r20.append('/');
        r20.append(r10.size());
        r20.append(", isLastInBatch=");
        r20.append(r115);
        Log.i(TAG, r20.toString());
        com.ss.android.lark.keyboard.base.r r21 = r26.j;
        if (r21 == null) goto L85;
        r21.q = r114.getUri();
    L85:
        if (wxa.f.a(r114) == false) goto L105;
        DoubaoFileInfo r22 = r114.getDoubaoFileInfo();
        if (r22 != null) goto L89;
    L88:
        boolean r119 = r19;
    L260:
        r111 = r113;
        r19 = r119;
        goto L64
    L89:
        String r120 = r22.getResourceUri();
        if (r120 == null) goto L88;
        Integer r23 = r22.getStorageType();
        if (r23 == null) goto L88;
        int r24 = r23.intValue();
        UplinkEntityContent r121 = r114.getUplinkEntityContent();
        if (r121 == null) goto L88;
        UplinkFileInfo r122 = r121.getUplinkFileInfo();
        if (r122 == null) goto L88;
        String r27 = r122.getFileName();
        if (r27 == null) goto L88;
        m5b.d r28 = b1.a(r26);
        m5b.e r3 = r28.e;
        if (r3 == null) goto L88;
        r119 = r19;
        r3.C = new k(r120, r27, r24);
        Log.i(TAG, "[DoubaoFile] dispatch attachment, attachment=" + r114.getFileIdentifier() + ", storageType=" + r24 + ", isLastInBatch=" + r3.e);
        r5.n(r28);
        goto L260
    L105:
        r119 = r19;
        if (wxa.f.b(r114) == false) goto L128;
        KeyboardFunctionEditText r29 = getTempEditText();
        if (r29 == null) goto L260;
        r29.setText(null);
        wxa.e r30 = r114.getUplinkFileDriveContent();
        if (r30 == null) goto L260;
        String r31 = r30.e;
        if (r31 == null) goto L260;
        String r32 = r30.c;
        if (r32 != null) goto L119;
        String r210 = r31;
    L120:
        ExtensionEditTextCompatKt.h(r29, r31, r210, r30.d, true, BuildConfig.FLAVOR);
        String r33 = ExtensionEditTextCompatKt.g(r29);
        RichText r34 = ExtensionEditTextCompatKt.b(r29);
        String r35 = (String) CollectionsKt.getOrNull(r34.getAnchorIds(), 0);
        if (r35 == null) goto L260;
        xcb.a r36 = ChatCoreModule.a().getUrlPreviewDependency().c(MapsKt.mapOf(TuplesKt.to(r35, r30)));
        com.ss.android.lark.keyboard.base.r r37 = r26.j;
        if (r37 == null) goto L126;
        r37.s = r36;
    L126:
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        r26.b = r33;
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        r26.c = r34;
        r5.g(b1.a(r26));
        goto L260
    L119:
        r210 = r32;
        goto L120
    L128:
        if (wxa.f.d(r114) == false) goto L207;
        String r38 = r114.getFileIdentifier();
        if (com.ss.android.lark.message.lynxcard.message.r.a(r38) == false) goto L140;
        com.ss.android.lark.keyboard.base.r r39 = r26.j;
        if (r39 == null) goto L140;
        Map r40 = r39.w;
        if (r40 == null) goto L140;
        ResourceUploadInfo r41 = (ResourceUploadInfo) r40.get(r38);
        if (r41 == null) goto L140;
        if (r41.getSendFileType() != ResourceFile.FileType.FILE) goto L141;
        boolean r42 = true;
    L142:
        if (r42 == false) goto L155;
        Log.i(TAG, "send image by sendFileMessage");
        com.ss.android.lark.keyboard.base.r r43 = r26.j;
        if (r43 == null) goto L146;
        r43.g = r114.getFileIdentifier();
    L146:
        com.ss.android.lark.keyboard.base.r r44 = r26.j;
        if (r44 == null) goto L154;
        int r45 = com.ss.android.lark.utils.b1.a;
        Uri r46 = r114.getUri();
        UplinkEntityContent r47 = r114.getUplinkEntityContent();
        if (r47 == null) goto L153;
        UplinkFileInfo r48 = r47.getUplinkFileInfo();
        if (r48 == null) goto L153;
        r48.getLocalResPath();
    L153:
        r44.p = com.ss.android.lark.utils.b1.b(r25, r46);
    L154:
        r5.n(b1.a(r26));
        goto L260
    L155:
        com.ss.android.lark.keyboard.base.r r49 = r26.j;
        if (r49 == null) goto L158;
        r49.f = r114.getFileIdentifier();
    L158:
        if (r41 == null) goto L160;
        ImageCompressInfo r50 = r41.getImageCompressInfo();
    L161:
        if (r50 == null) goto L171;
        com.ss.android.lark.keyboard.base.r r51 = r26.j;
        if (r51 == null) goto L165;
        r51.p = r50.getCompressPath();
    L165:
        com.ss.android.lark.keyboard.base.r r52 = r26.j;
        if (r52 == null) goto L168;
        r52.n = Integer.valueOf(r50.getWidth());
    L168:
        com.ss.android.lark.keyboard.base.r r53 = r26.j;
        if (r53 == null) goto L202;
        r53.o = Integer.valueOf(r50.getHeight());
    L202:
        com.ss.android.lark.keyboard.base.r r54 = r26.j;
        if (r54 == null) goto L205;
        r54.r = Intrinsics.areEqual(r114.isOriginalImageChecked(), Boolean.TRUE);
    L205:
        r5.j(b1.a(r26));
        goto L260
    L171:
        com.ss.android.lark.keyboard.base.r r55 = r26.j;
        if (r55 == null) goto L180;
        int r56 = com.ss.android.lark.utils.b1.a;
        Uri r57 = r114.getUri();
        UplinkEntityContent r58 = r114.getUplinkEntityContent();
        if (r58 == null) goto L178;
        Image r59 = r58.getUplinkImageInfo();
        if (r59 == null) goto L178;
        String r60 = r59.localResPath;
    L179:
        Intrinsics.checkNotNullParameter(r25, "context");
        r55.p = com.ss.android.lark.utils.b1.c(r25, r57, r60);
    L178:
        r60 = null;
    L180:
        com.ss.android.lark.keyboard.base.r r61 = r26.j;
        if (r61 == null) goto L191;
        UplinkEntityContent r62 = r114.getUplinkEntityContent();
        if (r62 == null) goto L189;
        Image r63 = r62.getUplinkImageInfo();
        if (r63 == null) goto L189;
        ImageObj r64 = r63.imageOri;
        if (r64 == null) goto L189;
        int r65 = Integer.valueOf(r64.width);
    L190:
        r61.n = r65;
    L189:
        r65 = 50;
    L191:
        com.ss.android.lark.keyboard.base.r r66 = r26.j;
        if (r66 == null) goto L202;
        UplinkEntityContent r67 = r114.getUplinkEntityContent();
        if (r67 == null) goto L200;
        Image r68 = r67.getUplinkImageInfo();
        if (r68 == null) goto L200;
        ImageObj r69 = r68.imageOri;
        if (r69 == null) goto L200;
        int r70 = Integer.valueOf(r69.height);
    L201:
        r66.o = r70;
    L200:
        r70 = 50;
        goto L201
    L160:
        r50 = null;
    L141:
        r42 = false;
    L140:
        r41 = null;
        goto L141
    L207:
        if (wxa.f.c(r114) == false) goto L221;
        com.ss.android.lark.keyboard.base.r r71 = r26.j;
        if (r71 == null) goto L211;
        r71.g = r114.getFileIdentifier();
    L211:
        com.ss.android.lark.keyboard.base.r r72 = r26.j;
        if (r72 == null) goto L219;
        int r73 = com.ss.android.lark.utils.b1.a;
        Uri r74 = r114.getUri();
        UplinkEntityContent r75 = r114.getUplinkEntityContent();
        if (r75 == null) goto L218;
        UplinkFileInfo r76 = r75.getUplinkFileInfo();
        if (r76 == null) goto L218;
        r76.getLocalResPath();
    L218:
        r72.p = com.ss.android.lark.utils.b1.b(r25, r74);
    L219:
        r5.n(b1.a(r26));
        goto L260
    L221:
        if (wxa.f.e(r114) == false) goto L260;
        String r77 = r114.getFileIdentifier();
        if (com.ss.android.lark.message.lynxcard.message.r.a(r77) == false) goto L233;
        com.ss.android.lark.keyboard.base.r r78 = r26.j;
        if (r78 == null) goto L233;
        Map r79 = r78.w;
        if (r79 == null) goto L233;
        ResourceUploadInfo r80 = (ResourceUploadInfo) r79.get(r77);
        if (r80 == null) goto L233;
        if (r80.getSendFileType() != ResourceFile.FileType.FILE) goto L233;
        boolean r81 = true;
    L234:
        if (r81 == false) goto L247;
        Log.i(TAG, "send video by sendFileMessage");
        com.ss.android.lark.keyboard.base.r r82 = r26.j;
        if (r82 == null) goto L238;
        r82.g = r114.getFileIdentifier();
    L238:
        com.ss.android.lark.keyboard.base.r r83 = r26.j;
        if (r83 == null) goto L246;
        int r84 = com.ss.android.lark.utils.b1.a;
        Uri r85 = r114.getUri();
        UplinkEntityContent r86 = r114.getUplinkEntityContent();
        if (r86 == null) goto L245;
        UplinkFileInfo r87 = r86.getUplinkFileInfo();
        if (r87 == null) goto L245;
        r87.getLocalResPath();
    L245:
        r83.p = com.ss.android.lark.utils.b1.b(r25, r85);
    L246:
        r5.n(b1.a(r26));
        goto L260
    L247:
        com.ss.android.lark.keyboard.base.r r88 = r26.j;
        if (r88 == null) goto L250;
        r88.h = r114.getFileIdentifier();
    L250:
        com.ss.android.lark.keyboard.base.r r89 = r26.j;
        if (r89 == null) goto L259;
        int r90 = com.ss.android.lark.utils.b1.a;
        Uri r91 = r114.getUri();
        UplinkEntityContent r92 = r114.getUplinkEntityContent();
        if (r92 == null) goto L257;
        UplinkFileInfo r93 = r92.getUplinkFileInfo();
        if (r93 == null) goto L257;
        String r94 = r93.getLocalResPath();
    L258:
        Intrinsics.checkNotNullParameter(r25, "context");
        r89.p = com.ss.android.lark.utils.b1.c(r25, r91, r94);
    L257:
        r94 = null;
    L259:
        r5.p(b1.a(r26));
    L233:
        r81 = false;
        goto L234
    L80:
        r118 = null;
        goto L81
    L71:
        if (r111 != CollectionsKt.getLastIndex(r10)) goto L73;
        r115 = true;
        goto L74
    L261:
        return;
    L61:
        r19 = false;
    L262:
        Log.e(TAG, "sendAttachments: attachments is empty or sender is null");
        return;
    L13:
        if (r8.isEmpty() == true) goto L16;
        r9 = false;
        goto L18
    L9:
        r7 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void getReplyInfo(MessageInfo r3, boolean r4, IGetDataCallback<i7b.c> r5) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.partialReplyInfo = r3.getPartialReplyInfo();
        if (this.currentChat.isSecret() == true) goto L5;
        getMReplyService().b(r3, r4, (IGetDataCallback) this.mCallbackManager.wrapAndAddCallback(r5));
        return;
    L5:
        getMReplyService().d(r3, (IGetDataCallback) this.mCallbackManager.wrapAndAddCallback(r5));
    }

    public final void saveAllDraft(Draft r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "draft");
        this.mDraftService.getExecutor().execute(new h(r3, this, r4, r5));
    }

    public void sendTextMsg(String r2, String r3, RichText r4) {
        Intrinsics.checkNotNullParameter(r2, "rootMsgId");
        Intrinsics.checkNotNullParameter(r3, "parentMsgId");
        Intrinsics.checkNotNullParameter(r4, "richText");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r0 = this.mDependencyRefs.get();
        if (r0 == null) goto L8;
        q4b.a r1 = r0.getMessageSender();
        if (r1 == null) goto L9;
        r1.d(r2, r3, r4);
        return;
    L9:
        return;
    }

    public void sendPostMsg(q r11, String r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "sendInfo");
        Intrinsics.checkNotNullParameter(r12, "rootMsgId");
        Intrinsics.checkNotNullParameter(r13, "parentMsgId");
        if (x.b(r11.c, r11.a) == false) goto L5;
        sendTextMsg(r12, r13, r11, r14);
        return;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r0 = this.mDependencyRefs.get();
        if (r0 == null) goto L12;
        q4b.a r1 = r0.getMessageSender();
        if (r1 == null) goto L13;
        r1.t(r11.a, r11.b, r11.c, r12, r13, Boolean.valueOf(r14), r11.d, r11.e);
        return;
    L13:
        return;
    }

    public void sendStickerMsg(StickerFileInfo r2, String r3, String r4, PartialReplyInfo r5) {
        Intrinsics.checkNotNullParameter(r2, "stickerFileInfo");
        Intrinsics.checkNotNullParameter(r3, "rootMsgId");
        Intrinsics.checkNotNullParameter(r4, "parentMsgId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r0 = this.mDependencyRefs.get();
        if (r0 == null) goto L8;
        q4b.a r1 = r0.getMessageSender();
        if (r1 == null) goto L9;
        r1.r(r2, r3, r4, r5);
        return;
    L9:
        return;
    }

    public void sendTextMsg(String r10, String r11, q r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "rootMsgId");
        Intrinsics.checkNotNullParameter(r11, "parentMsgId");
        Intrinsics.checkNotNullParameter(r12, "sendInfo");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r0 = this.mDependencyRefs.get();
        if (r0 == null) goto L8;
        q4b.a r1 = r0.getMessageSender();
        if (r1 == null) goto L9;
        r1.o(r10, r11, r12.c, r13, r12.d, r12.e, false);
        return;
    L9:
        return;
    }

    public void sendTextMsg(String r2, String r3, RichText r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "rootMsgId");
        Intrinsics.checkNotNullParameter(r3, "parentMsgId");
        Intrinsics.checkNotNullParameter(r4, "richText");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r0 = this.mDependencyRefs.get();
        if (r0 == null) goto L8;
        q4b.a r1 = r0.getMessageSender();
        if (r1 == null) goto L9;
        r1.u(r2, r3, r4, r5);
        return;
    L9:
        return;
    }

    public KeyboardViewModel(v r2, Chat r3, ChatChatter r4, com.ss.android.lark.chat.chatwindow.chat.data.reply.a r5, com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r6) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "currentChat");
        Intrinsics.checkNotNullParameter(r5, "chatReplyDigestCreator");
        Intrinsics.checkNotNullParameter(r6, "dependency");
        this.chatContainer = r2;
        this.currentChat = r3;
        this.chatReplyDigestCreator = r5;
        this.dependency = r6;
        this.tempEditText$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new KeyboardViewModel$tempEditText$2(this));
        this.p2pChatterLiveData = new MutableLiveData(r4);
        com.ss.android.lark.chat.chatwindow.chat.v2.push.d r7 = new com.ss.android.lark.chat.chatwindow.chat.v2.push.d(this.currentChat.getId(), this);
        this.chatterPushHandler = r7;
        this.mDraftService = r2.D();
        this.mEditMsgService = r2.S();
        this.mReplyService$delegate = LazyKt.lazy(new KeyboardViewModel$mReplyService$2(this));
        this.mDependencyRefs = new WeakReference(this.dependency);
        this.chatUpdateListeners = new LinkedHashSet();
        this.mCallbackManager = new CallbackManager();
        r7.register();
    }

    public final void sendMediaMsg(List<? extends Photo> r8, String r9, String r10, int r11, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r12) {
        Intrinsics.checkNotNullParameter(r8, "photos");
        Intrinsics.checkNotNullParameter(r9, "rootMsgId");
        Intrinsics.checkNotNullParameter(r10, "parentMsgId");
        Log.i(TAG, "sendMediaMsg: method called");
        if (r12 == null) goto L5;
        Log.i(TAG, "partialReplyInfo is not null.");
    L6:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r0 = this.mDependencyRefs.get();
        if (r0 == null) goto L12;
        q4b.a r1 = r0.getMessageSender();
        if (r1 == null) goto L13;
        r1.h(r8, r9, r10, r11, r12);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        Log.i(TAG, "partialReplyInfo is null.");
        goto L6
    }

    @Override // j2b.b
    public void reEditMsg(String r10, RichText r11, String r12, Context r13, s5c.d r14, List<ChatAttachmentEntity> r15) {
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "richText");
        Intrinsics.checkNotNullParameter(r12, "msgId");
        Intrinsics.checkNotNullParameter(r13, "context");
        EditMessageService r1 = this.mEditMsgService;
        Chat r5 = this.currentChat;
        if (r15 == null) goto L9;
        List<ChatAttachmentEntity> r16 = r15;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L6:
        if (r17.hasNext() == false) goto L8;
        r0.add(((ChatAttachmentEntity) r17.next()).toSendPbFile());
        goto L6
    L8:
        ArrayList r8 = r0;
    L10:
        r1.b(r10, r11, r12, r5, r13, r14, r8);
        return;
    L9:
        r8 = null;
        goto L10
    }

    public void sendImageMsg(List<String> r10, boolean r11, String r12, String r13, int r14, String r15, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r16) {
        Intrinsics.checkNotNullParameter(r10, "photos");
        Intrinsics.checkNotNullParameter(r12, "rootMsgId");
        Intrinsics.checkNotNullParameter(r13, "parentMsgId");
        Log.i(TAG, "sendImageMsg: method called");
        if (r16 == null) goto L5;
        Log.i(TAG, "partialReplyInfo is not null.");
    L6:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a r1 = this.mDependencyRefs.get();
        if (r1 == null) goto L12;
        q4b.a r2 = r1.getMessageSender();
        if (r2 == null) goto L13;
        r2.f(r10, r11, r12, r13, r14, r15, r16);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        Log.i(TAG, "partialReplyInfo is null.");
        goto L6
    }
}
