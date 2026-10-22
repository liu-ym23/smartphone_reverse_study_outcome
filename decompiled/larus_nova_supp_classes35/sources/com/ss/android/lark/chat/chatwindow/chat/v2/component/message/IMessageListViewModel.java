package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.f0;
import com.ss.android.lark.chat.base.model.dispatch.ActionDispatcher;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatFileAuthorityPushHandler;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.l0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.q;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.s;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.y;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000ô\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\tB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010QH&J\u0010\u0010R\u001a\u00020O2\u0006\u0010S\u001a\u00020TH&J\u0010\u0010U\u001a\u00020O2\u0006\u0010P\u001a\u00020VH&J\"\u0010W\u001a\u00020O2\u0010\u0010X\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030Y0\u000e2\u0006\u0010Z\u001a\u00020[H&J\u0010\u0010\\\u001a\u00020O2\u0006\u0010]\u001a\u00020(H&J\b\u0010^\u001a\u00020OH&J\u000f\u0010_\u001a\u0004\u0018\u00010HH&¢\u0006\u0002\u0010`J\b\u0010a\u001a\u00020(H&J\b\u0010b\u001a\u00020(H&J\u0010\u0010c\u001a\u00020(2\u0006\u0010d\u001a\u00020HH&J\u0012\u0010e\u001a\u0004\u0018\u00010#2\u0006\u0010d\u001a\u00020HH&J\u0018\u0010f\u001a\u0004\u0018\u00010#2\u0006\u0010d\u001a\u00020HH¦@¢\u0006\u0002\u0010gJ \u0010h\u001a\u00020O2\u0006\u0010d\u001a\u00020H2\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010jH&J\u0016\u0010k\u001a\u00020O2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020O0jH&J\u0018\u0010l\u001a\u00020O2\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010jH&J\u0010\u0010m\u001a\u00020O2\u0006\u0010n\u001a\u00020\u001bH&J\u0010\u0010o\u001a\u00020O2\u0006\u0010p\u001a\u00020qH&J\u0012\u0010r\u001a\u0004\u0018\u00010#2\u0006\u0010s\u001a\u00020\u001bH&J\u0010\u0010t\u001a\u00020O2\u0006\u0010u\u001a\u00020vH&J$\u0010w\u001a\u00020O2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u001b0y2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020v0{H&J\"\u0010|\u001a\u00020O2\u0018\u0010}\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020v0~0\u000eH&J\u001e\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0081\u0001H&J\u0017\u0010\u0082\u0001\u001a\u00020O2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020H0jH&JD\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0084\u00010\u000e2\u0007\u0010\u0085\u0001\u001a\u00020\u001b2\u0007\u0010\u0086\u0001\u001a\u00020(2\u0012\b\u0002\u0010\u0087\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0088\u0001\u0018\u00010\u000e2\f\b\u0002\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H&J\u0011\u0010\u008b\u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u001bH&J3\u0010\u008c\u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u001b2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u008f\u0001\u001a\u00030\u0090\u0001H&J/\u0010\u0091\u0001\u001a\u00020O2\u0007\u0010\u0092\u0001\u001a\u00020\u001b2\u0007\u0010\u0093\u0001\u001a\u00020\u001b2\f\b\u0002\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H&¢\u0006\u0003\u0010\u0096\u0001J\u0011\u0010\u0097\u0001\u001a\u00020O2\u0006\u0010n\u001a\u00020\u001bH&J\u0012\u0010\u0098\u0001\u001a\u00020O2\u0007\u0010\u0099\u0001\u001a\u00020\u001bH&J\u001b\u0010\u009a\u0001\u001a\u00020O2\u0007\u0010\u009b\u0001\u001a\u00020H2\u0007\u0010i\u001a\u00030\u009c\u0001H&J\u0011\u0010\u009d\u0001\u001a\u00020O2\u0006\u0010n\u001a\u00020\u001bH&J\u001d\u0010\u009e\u0001\u001a\u00020O2\u0007\u0010\u009f\u0001\u001a\u00020\u001b2\t\u0010 \u0001\u001a\u0004\u0018\u00010\u001bH&J\t\u0010¡\u0001\u001a\u00020OH&J\u001b\u0010¢\u0001\u001a\u00020O2\u0007\u0010£\u0001\u001a\u00020\u001b2\u0007\u0010¤\u0001\u001a\u00020HH&J8\u0010¥\u0001\u001a\u00020O2\b\u0010K\u001a\u0004\u0018\u00010\u001b2\u000f\b\u0002\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\u0012\b\u0002\u0010§\u0001\u001a\u000b\u0012\u0005\u0012\u00030¨\u0001\u0018\u00010\u000eH&J\u0012\u0010©\u0001\u001a\u00020O2\u0007\u0010ª\u0001\u001a\u00020\u001bH&J\u0011\u0010«\u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u001bH&J\u0011\u0010¬\u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u001bH&J\u0011\u0010\u00ad\u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u001bH&J#\u0010®\u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u001b2\u0007\u0010¯\u0001\u001a\u00020\u001b2\u0007\u0010°\u0001\u001a\u00020(H&JA\u0010±\u0001\u001a\u00020O2\u0006\u0010K\u001a\u00020\u001b2\u0019\u0010¦\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001b0²\u0001j\t\u0012\u0004\u0012\u00020\u001b`³\u00012\u0013\u0010i\u001a\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u001b0´\u00010jH&J=\u0010µ\u0001\u001a\u00020O2\b\u0010K\u001a\u0004\u0018\u00010\u001b2\u0011\u0010¶\u0001\u001a\f\u0012\u0005\u0012\u00030·\u0001\u0018\u00010´\u00012\u0015\u0010i\u001a\u0011\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030·\u00010\u000e\u0018\u00010jH&J\u0011\u0010¸\u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u001bH&J\u0011\u0010¹\u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u001bH&J\u001a\u0010º\u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u001b2\u0007\u0010»\u0001\u001a\u00020(H&J\n\u0010¼\u0001\u001a\u00030½\u0001H&J\u0013\u0010¾\u0001\u001a\u00020O2\b\u0010¿\u0001\u001a\u00030À\u0001H\u0016J\u0013\u0010Á\u0001\u001a\u00020O2\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0016J\u000b\u0010Ä\u0001\u001a\u0004\u0018\u00010#H&J\t\u0010Ç\u0001\u001a\u00020OH&J\u0010\u0010È\u0001\u001a\t\u0012\u0005\u0012\u00030É\u00010\u000eH\u0016R\"\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R(\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001e0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u001a\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u001e\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u000e0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0011R\u001e\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u000e0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0011R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0011R\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0011R\u001a\u0010,\u001a\u0004\u0018\u00010-X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0403X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0012\u00107\u001a\u000208X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0012\u0010;\u001a\u00020<X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0012\u0010?\u001a\u00020@X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0012\u0010C\u001a\u00020DX¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0012\u0010G\u001a\u00020HX¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0012\u0010K\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001a\u0010Å\u0001\u001a\t\u0012\u0005\u0012\u00030À\u00010\r¢\u0006\t\n\u0000\u001a\u0005\bÆ\u0001\u0010\u0011¨\u0006Ê\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListPushListener;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IStreamProvider;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ChatPreviewPushHandler$IPreviewPushListener;", "Lcom/ss/android/lark/monitor/callback/MemoryCallbackManager$MemoryCallback;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ChatFileAuthorityPushHandler$IPushFileAuthorityListener;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ChatUserGroupPushHandler$IChatUserGroupPushListener;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ThreadDetailPushHandler$IThreadDetailPushListener;", "Lcom/ss/android/lark/biz/im/api/message/audit/IAuthResourceProvider;", "<init>", "()V", "messageList", "Landroidx/lifecycle/MutableLiveData;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "getMessageList", "()Landroidx/lifecycle/MutableLiveData;", "currentChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getCurrentChat", "selfChatterLiveData", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "getSelfChatterLiveData", "p2pChatterLiveData", "getP2pChatterLiveData", "toastInfo", BuildConfig.FLAVOR, "getToastInfo", "dialogInfo", "Lkotlin/Pair;", "getDialogInfo", "closePageInfo", "getClosePageInfo", "newMessageItems", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "getNewMessageItems", "newMessageItemsAppend", "getNewMessageItemsAppend", "needRelocateMessage", BuildConfig.FLAVOR, "getNeedRelocateMessage", "messageReadable", "getMessageReadable", "pinExtraLoader", "Lcom/ss/android/lark/chat/chatwindow/chat/model/pin/MessageListPinExtraLoader;", "getPinExtraLoader", "()Lcom/ss/android/lark/chat/chatwindow/chat/model/pin/MessageListPinExtraLoader;", "setPinExtraLoader", "(Lcom/ss/android/lark/chat/chatwindow/chat/model/pin/MessageListPinExtraLoader;)V", "dataStore", "Lcom/ss/android/lark/chatbase/BasePageStore;", "Lcom/ss/android/lark/chat/core/model/BasePageData;", "getDataStore", "()Lcom/ss/android/lark/chatbase/BasePageStore;", "mMessageReader", "Lcom/ss/android/lark/biz/im/api/IMessageReader;", "getMMessageReader", "()Lcom/ss/android/lark/biz/im/api/IMessageReader;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "dependency", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;", "getDependency", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;", "showPosition", BuildConfig.FLAVOR, "getShowPosition", "()I", "chatId", "getChatId", "()Ljava/lang/String;", "setWindowDataPreLoadTaskProvider", BuildConfig.FLAVOR, "provider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IChatWindowPreLoadTaskProvider;", "setActionDispatch", "dispatcher", "Lcom/ss/android/lark/chat/base/model/dispatch/ActionDispatcher;", "setScreenItemProvider", "Lcom/ss/android/lark/chat/chatwindow/chat/model/ChatWindowDataStore$ILastScreenItemProvider;", "readMessage", "intervalMessages", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "context", "Landroid/content/Context;", "loadFirstPage", "isFromOfflinePush", "destroy", "getExpiredPeriodTime", "()Ljava/lang/Integer;", "canLoadPre", "canLoadMore", "containsPosition", "position", "getDataOnPosition", "loadSpecialPosition", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSpecialPage", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "loadNextPage", "loadPrePage", "toggleItemShowTime", "messageId", "executeMessage", "runnable", "Ljava/lang/Runnable;", "getMessageInfoById", "msgId", "batchUpdate", "needUpdateMessage", "Lcom/ss/android/lark/chat/entity/message/IChatMessage;", "updateMsg", "key", "Lcom/ss/android/lark/biz/im/api/extension/store/ItemTwoKey;", "updater", "Lcom/ss/android/lark/biz/im/api/extension/store/IItemPatch;", "batchUpdateMsg", "patchProviderList", "Lcom/ss/android/lark/biz/im/api/extension/store/PatchProvider;", "getMessageInfoByIds", "msgIds", BuildConfig.FLAVOR, "ensureLastPageDataLoaded", "getAllImage", "Lcom/ss/android/lark/chat/entity/image/ImageSet;", "clickedMsgId", "isClickTranslated", "messageTypeList", "Lcom/ss/android/lark/chat/entity/message/Message$Type;", "externalHandler", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageDataExternalHandler;", "readAudioMsg", "prepareAudioData", "previewId", "msgLinkToken", "successState", "Lcom/ss/android/lark/chat/entity/message/content/AudioContent$AudioState;", "sendSignRequest", "description", "sourceId", "privateDescriptionId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "addSticker", "onAuditedFailed", "msg", "checkToClearDataStore", "newFirstMsgPosition", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageClearedCallback;", "deleteUrlPreview", "cancelUploadMediaMsg", "cId", "compressPath", "notifyDataChange", "onFollowFold", "foldId", "count", "recallMembers", "chatterIds", "entityList", "Lcom/ss/android/lark/chat/entity/chat/PickChatEntity;", "retrySendMessage", "preMsgId", "invalidGroupShare", "burnMsg", "updatePreviewByMessageId", "handleInteractiveState", "eleId", "inProcessing", "checkChatterInChat", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BuildConfig.FLAVOR, "onCheckMembersInChat", "entities", "Lcom/ss/android/lark/dto/group/GroupRecallEntity;", "registerImmediateMsg", "handleShowMoreTextClick", "handleCollapsingUrlPreview", "isCollapsed", "getUIModel", "Lcom/ss/android/lark/chat/chatwindow/chat/ChatWindowUIModel;", "onPushThreadTopic", "threadTopic", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "onPushUpdateThreadInfo", "threadInfo", "Lcom/ss/android/lark/chat/entity/thread/ThreadInfo;", "getTopicMessageInfo", "currentThreadTopic", "getCurrentThreadTopic", "changeMessageAlignIfNeed", "getAuthFileEntities", "Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/AuthorityParam;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class IMessageListViewModel extends ViewModel implements com.ss.android.lark.chat.chatwindow.chat.v2.push.o.d, com.ss.android.lark.chat.chatwindow.chat.v2.push.f.a, q.a, com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a, com.ss.android.lark.chat.chatwindow.chat.v2.push.e.a, com.ss.android.lark.chat.chatwindow.chat.v2.push.g.a, com.ss.android.lark.chat.chatwindow.chat.v2.push.p.b, y, com.ss.android.lark.chat.chatwindow.chat.v2.push.i.b, MemoryCallbackManager.MemoryCallback, ChatFileAuthorityPushHandler.b, s.b, l0.d, com.ss.android.lark.biz.im.api.message.audit.e {
    private final MutableLiveData<ThreadTopic> currentThreadTopic;

    public abstract void addSticker(String r1);

    public abstract void batchUpdate(f5b.b r1);

    public abstract void batchUpdateMsg(List<? extends hya.c<String, f5b.b>> r1);

    public abstract void burnMsg(String r1);

    public abstract boolean canLoadMore();

    public abstract boolean canLoadPre();

    public abstract void cancelUploadMediaMsg(String r1, String r2);

    public abstract void changeMessageAlignIfNeed();

    public abstract void checkChatterInChat(String r1, ArrayList<String> r2, IGetDataCallback<List<String>> r3);

    public abstract void checkToClearDataStore(int r1, IMessageListComponent.c r2);

    public abstract boolean containsPosition(int r1);

    public abstract void deleteUrlPreview(String r1);

    public abstract void destroy();

    public abstract void ensureLastPageDataLoaded(IGetDataCallback<Integer> r1);

    public abstract void executeMessage(Runnable r1);

    public abstract List<ImageSet> getAllImage(String r1, boolean r2, List<? extends Message.Type> r3, m r4);

    public abstract fxa.b getChatBundle();

    public abstract v getChatContainer();

    public abstract String getChatId();

    public abstract MutableLiveData<String> getClosePageInfo();

    public abstract MutableLiveData<Chat> getCurrentChat();

    public abstract MessageInfo getDataOnPosition(int r1);

    public abstract BasePageStore<MessageInfo, x4b.a<MessageInfo>> getDataStore();

    public abstract p getDependency();

    public abstract MutableLiveData<Pair<String, String>> getDialogInfo();

    public abstract Integer getExpiredPeriodTime();

    public abstract f0 getMMessageReader();

    public abstract MessageInfo getMessageInfoById(String r1);

    public abstract List<MessageInfo> getMessageInfoByIds(Collection<String> r1);

    public abstract MutableLiveData<List<y6b.c<?>>> getMessageList();

    public abstract MutableLiveData<Boolean> getMessageReadable();

    public abstract MutableLiveData<Boolean> getNeedRelocateMessage();

    public abstract MutableLiveData<List<MessageInfo>> getNewMessageItems();

    public abstract MutableLiveData<List<MessageInfo>> getNewMessageItemsAppend();

    public abstract MutableLiveData<ChatChatter> getP2pChatterLiveData();

    public abstract MessageListPinExtraLoader getPinExtraLoader();

    public abstract MutableLiveData<ChatChatter> getSelfChatterLiveData();

    public abstract int getShowPosition();

    public abstract MutableLiveData<String> getToastInfo();

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.l0.d
    public abstract MessageInfo getTopicMessageInfo();

    public abstract s2b.e getUIModel();

    public abstract void handleCollapsingUrlPreview(String r1, boolean r2);

    public abstract void handleInteractiveState(String r1, String r2, boolean r3);

    public abstract void handleShowMoreTextClick(String r1);

    public abstract void invalidGroupShare(String r1);

    public abstract void loadFirstPage(boolean r1);

    public abstract void loadNextPage(IGetDataCallback<Unit> r1);

    public abstract void loadPrePage(IGetDataCallback<Unit> r1);

    public abstract void loadSpecialPage(int r1, IGetDataCallback<Unit> r2);

    public abstract Object loadSpecialPosition(int r1, Continuation<? super MessageInfo> r2);

    public abstract void notifyDataChange();

    public abstract void onAuditedFailed(String r1);

    public abstract void onCheckMembersInChat(String r1, List<GroupRecallEntity> r2, IGetDataCallback<List<GroupRecallEntity>> r3);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.f.a
    public abstract /* synthetic */ void onFileDownloadFail();

    public abstract void onFollowFold(String r1, int r2);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.o.d
    public abstract /* synthetic */ void onPushChat(Chat r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.o.d
    public abstract /* synthetic */ void onPushChatRemoveChatters(Chat r1, Map<String, ? extends Chatter> r2);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.o.d
    public abstract /* synthetic */ void onPushChatRemoveMe(Chat r1);

    public abstract /* synthetic */ void onPushDingMessage(MessageInfo r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatFileAuthorityPushHandler.b
    public abstract /* synthetic */ void onPushFileAuthority(Map<String, ValidateIMFileResult> r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.o.d
    public abstract /* synthetic */ void onPushMessage(List<MessageInfo> r1, boolean r2);

    public abstract /* synthetic */ void onPushMyAIVote(Map<String, ? extends com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus> r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.i.b
    public abstract /* synthetic */ void onPushPreview(Map<String, ? extends Map<String, UrlCardPreviewEntity>> r1, Map<String, ? extends Map<String, MessageLink>> r2);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.i.b
    public abstract /* synthetic */ void onPushSignUrlPreview(List<UrlPreViewEntries> r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.l0.d
    public void onPushThreadTopic(ThreadTopic r2) {
        Intrinsics.checkNotNullParameter(r2, "threadTopic");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.l0.d
    public void onPushUpdateThreadInfo(n5b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "threadInfo");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public abstract /* synthetic */ void onPushUpdatedChatter(Chatter r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public abstract /* synthetic */ void onPushUpdatedNickname(String r1, String r2);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.g.a
    public abstract /* synthetic */ void onPushUploadProgress(String r1, int r2);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.s.b
    public abstract /* synthetic */ void onPushUserGroup(Map<Long, UserGroupEntity> r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.q.a
    public abstract /* synthetic */ void onQuitGroup(boolean r1);

    public abstract /* synthetic */ void onSendChatAnnouncement(String r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.f.a
    public abstract /* synthetic */ void onSwitchToCellularDataNetwork(boolean r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.p.b
    public abstract /* synthetic */ void onThreadRepliesUpdate(n5b.a r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public abstract /* synthetic */ void onUpdateSelfInfo(Chatter r1);

    public abstract void prepareAudioData(String r1, String r2, String r3, AudioContent.AudioState r4);

    public abstract void readAudioMsg(String r1);

    public abstract void readMessage(List<? extends y6b.a<?>> r1, Context r2);

    public abstract void recallMembers(String r1, List<String> r2, List<? extends PickChatEntity> r3);

    public abstract void registerImmediateMsg(String r1);

    public abstract void retrySendMessage(String r1);

    public abstract void sendSignRequest(String r1, String r2, Long r3);

    public abstract void setActionDispatch(ActionDispatcher r1);

    public abstract void setPinExtraLoader(MessageListPinExtraLoader r1);

    public abstract void setScreenItemProvider(q3b.m.c r1);

    public abstract void setWindowDataPreLoadTaskProvider(l r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.f.a, com.ss.android.lark.chat.chatwindow.chat.v2.push.y
    public abstract /* synthetic */ com.ss.android.lark.chatbase.l<f5b.b> stream();

    public abstract void toggleItemShowTime(String r1);

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.q.a
    public abstract /* synthetic */ void updateDissolveGroupLocalFlag(boolean r1);

    public abstract void updateMsg(hya.b<String> r1, hya.a<f5b.b> r2);

    public abstract void updatePreviewByMessageId(String r1);

    public IMessageListViewModel() {
        this.currentThreadTopic = new MutableLiveData();
    }

    public List<AuthorityParam> getAuthFileEntities() {
        String r0 = getChatContainer().M().userId();
        String r1 = getChatContainer().M().fe();
        List r2 = (List) getMessageList().getValue();
        if (r2 == null) goto L81;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L5:
        boolean r5 = false;
        if (r4.hasNext() == false) goto L56;
        Object r6 = r4.next();
        y6b.c r7 = (y6b.c) r6;
        switch(y6b.a.b.a[r7.getType().ordinal()]) {
            case 1: goto L53;
            case 2: goto L53;
            case 3: goto L53;
            case 4: goto L53;
            case 5: goto L53;
            case 6: goto L32;
            case 7: goto L10;
            default: goto L54;
        };
    L10:
        T r8 = r7.o;
        if ((r8 instanceof PostContentVO) == false) goto L54;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.PostContentVO");
        PostContentVO r9 = (PostContentVO) r8;
        RichText r10 = r9.g();
        if (r10 == null) goto L19;
        List r11 = r10.getImageIds();
        if (r11 == null) goto L19;
        if ((!r11.isEmpty()) != true) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == true) goto L53;
        if (r10 == null) goto L27;
        List r13 = r10.getMediaIds();
        if (r13 == null) goto L27;
        if ((!r13.isEmpty()) != true) goto L27;
        boolean r14 = true;
    L28:
        if (r14 == true) goto L53;
        if ((!r9.f().isEmpty()) == false) goto L54;
    L27:
        r14 = false;
    L19:
        r12 = false;
        goto L20
    L32:
        T r15 = r7.o;
        if ((r15 instanceof com.ss.android.lark.chat.base.view.vo.message.e) == false) goto L54;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.TextContentVO");
        com.ss.android.lark.chat.base.view.vo.message.e r16 = (com.ss.android.lark.chat.base.view.vo.message.e) r15;
        RichText r17 = r16.g();
        if (r17 == null) goto L41;
        List r18 = r17.getImageIds();
        if (r18 == null) goto L41;
        if ((!r18.isEmpty()) != true) goto L41;
        boolean r19 = true;
    L42:
        if (r19 == true) goto L53;
        if (r17 == null) goto L49;
        List r20 = r17.getMediaIds();
        if (r20 == null) goto L49;
        if ((!r20.isEmpty()) != true) goto L49;
        boolean r21 = true;
    L50:
        if (r21 == true) goto L53;
        if ((!r16.f().isEmpty()) == false) goto L54;
    L49:
        r21 = false;
    L41:
        r19 = false;
    L53:
        r5 = true;
    L54:
        if (r5 == false) goto L5;
        r3.add(r6);
        goto L5
    L56:
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r23 = r3.iterator();
    L58:
        if (r23.hasNext() == false) goto L90;
        y6b.c r24 = (y6b.c) r23.next();
        r24.getClass();
        long r25 = 0;
        if (r0 == null) goto L64;
        Long r26 = StringsKt.toLongOrNull(r0);
        if (r26 == null) goto L64;
        long r27 = r26.longValue();
    L65:
        if (r1 == null) goto L69;
        Long r110 = StringsKt.toLongOrNull(r1);
        if (r110 == null) goto L69;
        r25 = r110.longValue();
    L69:
        AuthorityParam.a r111 = new AuthorityParam.a();
        r111.a = r24.c;
        int r112 = AuthorityParam.j;
        String r113 = r24.g;
        AuthorityParam.Companion.AuthScene r114 = AuthorityParam.Companion.AuthScene.IM_FILE_LIST_AUTH;
        r111.d = Long.valueOf(AuthorityParam.Companion.a(r113, r114));
        y6b.b r115 = r24.t;
        if (r115 == null) goto L74;
        String r116 = r115.w;
        if (r116 == null) goto L74;
        Long r117 = Long.valueOf(AuthorityParam.Companion.a(r116, r114));
    L75:
        r111.c = r117;
        r111.f = r27;
        r111.e = r25;
        boolean r28 = r24.isPreMessage();
        boolean r29 = r24.i;
        if (((ArrayList) r24.p()).size() <= 1) goto L78;
        boolean r118 = true;
    L79:
        AuthorityParam.AuthorityExtraParam r30 = new AuthorityParam.AuthorityExtraParam(r28, r29, r118);
        Intrinsics.checkNotNullParameter(r30, "authorityExtraParam");
        r111.i = r30;
        r111.b = r24.e;
        List<String> r31 = r24.p();
        Intrinsics.checkNotNullParameter(r31, "fileKeys");
        r111.h = r31;
        r22.add(r111.a());
        goto L58
    L78:
        r118 = false;
    L74:
        r117 = null;
    L64:
        r27 = 0;
        goto L65
    L90:
        return r22;
    L81:
        return CollectionsKt.emptyList();
    }

    public final MutableLiveData<ThreadTopic> getCurrentThreadTopic() {
        return this.currentThreadTopic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void recallMembers$default(IMessageListViewModel r0, String r1, List r2, List r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = CollectionsKt.emptyList();
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = CollectionsKt.emptyList();
    L9:
        r0.recallMembers(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recallMembers");
    }

    public static /* synthetic */ void sendSignRequest$default(IMessageListViewModel r0, String r1, String r2, Long r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.sendSignRequest(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendSignRequest");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List getAllImage$default(IMessageListViewModel r1, String r2, boolean r3, List r4, m r5, int r6, Object r7) {
        if (r7 != null) goto L12;
        if ((r6 & 4) == 0) goto L7;
        r4 = null;
    L7:
        if ((r6 & 8) == 0) goto L10;
        r5 = null;
    L10:
        return r1.getAllImage(r2, r3, r4, r5);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllImage");
    }

    public static /* synthetic */ void prepareAudioData$default(IMessageListViewModel r0, String r1, String r2, String r3, AudioContent.AudioState r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L6;
        r4 = AudioContent.AudioState.DONE_OPEN;
    L6:
        r0.prepareAudioData(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepareAudioData");
    }
}
