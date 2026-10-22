package com.ss.android.lark.flow.threadwindow;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.auditsdk.v2.receivecheck.ImFileAuthorityChecker;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.ThreadStateInfo;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.b1;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.d0;
import com.ss.android.lark.biz.im.api.f0;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.biz.im.api.h1;
import com.ss.android.lark.biz.im.api.o0;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.u0;
import com.ss.android.lark.biz.im.api.v0;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chat.base.model.dispatch.ActionDispatcher;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatFileAuthorityPushHandler;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.c0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import com.ss.android.lark.chat.utils.r0;
import com.ss.android.lark.chat.utils.w;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.flow.chat.message.image.model.FlowImageSet;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.message.lynxcard.settings.CardMessageUserLynxRenderSettings;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u008e\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 û\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0002û\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001J\n\u0010\u0089\u0001\u001a\u00030\u0086\u0001H\u0002J\u0013\u0010\u008a\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0016J\n\u0010\u008c\u0001\u001a\u00030\u0086\u0001H\u0002J\u0014\u0010\u008d\u0001\u001a\u00030\u0086\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0007\u0010\u0090\u0001\u001a\u00020\tJ\u0007\u0010\u0091\u0001\u001a\u00020\tJ+\u0010\u0092\u0001\u001a\u00030\u0086\u00012!\b\u0002\u0010\u0093\u0001\u001a\u001a\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0086\u00010\u0095\u0001\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010\u0094\u0001J+\u0010\u0096\u0001\u001a\u00030\u0086\u00012!\b\u0002\u0010\u0093\u0001\u001a\u001a\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0086\u00010\u0095\u0001\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010\u0094\u0001J\u0019\u0010\u0097\u0001\u001a\u00030\u0086\u00012\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140CH\u0002J\u0019\u0010\u0099\u0001\u001a\u00030\u0086\u00012\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140CH\u0002J$\u0010\u009a\u0001\u001a\u00030\u0086\u00012\r\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140C2\t\b\u0002\u0010\u009c\u0001\u001a\u00020\tH\u0002J\u0014\u0010\u009d\u0001\u001a\u00030\u0086\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0014\u0010 \u0001\u001a\u00030\u0086\u00012\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0016J\u0013\u0010£\u0001\u001a\u00030\u0086\u00012\u0007\u0010¤\u0001\u001a\u00020HH\u0016J,\u0010¥\u0001\u001a\u00030\u0086\u00012\u0007\u0010¤\u0001\u001a\u00020H2\u0017\u0010¦\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0007\b\u0001\u0012\u00030¨\u00010§\u0001H\u0016J\u0013\u0010©\u0001\u001a\u00030\u0086\u00012\u0007\u0010¤\u0001\u001a\u00020HH\u0016J\u0013\u0010ª\u0001\u001a\u00030\u0086\u00012\u0007\u0010«\u0001\u001a\u00020HH\u0002J\u0013\u0010¬\u0001\u001a\u00030\u0086\u00012\u0007\u0010¤\u0001\u001a\u00020HH\u0002J\u0013\u0010\u00ad\u0001\u001a\u00030\u0086\u00012\u0007\u0010¤\u0001\u001a\u00020HH\u0002J\u0014\u0010®\u0001\u001a\u00030\u0086\u00012\b\u0010¯\u0001\u001a\u00030°\u0001H\u0016J\u0013\u0010±\u0001\u001a\u00030\u0086\u00012\u0007\u0010²\u0001\u001a\u00020WH\u0016J\u0014\u0010³\u0001\u001a\u00030\u0086\u00012\b\u0010¯\u0001\u001a\u00030°\u0001H\u0016J@\u0010´\u0001\u001a\u00020\t2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\u000f\u0010µ\u0001\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010C2\u000f\u0010¶\u0001\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010C2\u0007\u0010·\u0001\u001a\u00020\u0017H\u0002J\u0012\u0010¸\u0001\u001a\u00020\t2\u0007\u0010¹\u0001\u001a\u00020\u0014H\u0002J\u001e\u0010º\u0001\u001a\u0002042\b\u0010¡\u0001\u001a\u00030¢\u00012\t\u0010»\u0001\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010¼\u0001\u001a\u0002042\u0007\u0010»\u0001\u001a\u00020\u001cH\u0002J\u0017\u0010½\u0001\u001a\u00020\t*\u00020\u00142\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0002J\u001c\u0010¾\u0001\u001a\u00030\u0086\u00012\u0007\u0010¿\u0001\u001a\u00020\u00142\u0007\u0010À\u0001\u001a\u00020\u0014H\u0002J\n\u0010Á\u0001\u001a\u00030\u0086\u0001H\u0002J\u0019\u0010Â\u0001\u001a\u00030\u0086\u00012\r\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140CH\u0002J;\u0010Ä\u0001\u001a\u00020\t2\u0014\u0010Å\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0094\u00012\u001a\u0010Æ\u0001\u001a\u0015\u0012\u0007\u0012\u0005\u0018\u00010Ç\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ç\u00010\u0094\u0001H\u0002J\u0013\u0010È\u0001\u001a\u00030\u0086\u00012\u0007\u0010É\u0001\u001a\u00020\u001cH\u0016J\u001c\u0010Ê\u0001\u001a\u00030\u0086\u00012\u0007\u0010É\u0001\u001a\u00020\u001c2\u0007\u0010Ë\u0001\u001a\u00020\u0017H\u0016J\u0013\u0010Ì\u0001\u001a\u00030\u0086\u00012\u0007\u0010É\u0001\u001a\u00020\u001cH\u0016J\n\u0010Í\u0001\u001a\u00030\u0086\u0001H\u0002J\u0012\u0010Î\u0001\u001a\u00020\t2\u0007\u0010É\u0001\u001a\u00020\u001cH\u0002J\u001a\u0010Ï\u0001\u001a\u00030\u0086\u00012\u000e\u0010Ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170Ñ\u0001H\u0002J\u001d\u0010Ò\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030D0C*\b\u0012\u0004\u0012\u00020\u00140CH\u0002J\u0012\u0010Ó\u0001\u001a\u00030\u0086\u0001*\u0006\u0012\u0002\b\u00030DH\u0002J\u0013\u0010Ô\u0001\u001a\u00030\u0086\u00012\u0007\u0010Ë\u0001\u001a\u00020\u0017H\u0002J\u000f\u0010Õ\u0001\u001a\u0004\u0018\u00010W*\u00020\u0014H\u0002J\u000f\u0010Ö\u0001\u001a\b\u0012\u0004\u0012\u00020W0CH\u0002J:\u0010×\u0001\u001a\u00030\u0086\u00012\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00172\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u00012\u0007\u0010Û\u0001\u001a\u00020\t2\u0010\u0010Ü\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010Ý\u0001J\n\u0010Þ\u0001\u001a\u00030\u0086\u0001H\u0014J\n\u0010ß\u0001\u001a\u00030\u0086\u0001H\u0016J\u0016\u0010à\u0001\u001a\u00030\u0086\u00012\n\u0010á\u0001\u001a\u0005\u0018\u00010â\u0001H\u0016J\u0014\u0010ã\u0001\u001a\u00030\u0086\u00012\b\u0010ä\u0001\u001a\u00030å\u0001H\u0016J\u0014\u0010æ\u0001\u001a\u00030\u0086\u00012\b\u0010á\u0001\u001a\u00030ç\u0001H\u0016J(\u0010è\u0001\u001a\u00030\u0086\u00012\u0012\u0010é\u0001\u001a\r\u0012\t\u0012\u0007\u0012\u0002\b\u00030ê\u00010C2\b\u0010ë\u0001\u001a\u00030ì\u0001H\u0016J\u0011\u0010í\u0001\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0003\u0010î\u0001J\t\u0010ï\u0001\u001a\u00020\tH\u0016J\t\u0010ð\u0001\u001a\u00020\tH\u0016J\u0012\u0010ñ\u0001\u001a\u00020\t2\u0007\u0010ò\u0001\u001a\u000204H\u0016J\u0014\u0010ó\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010ò\u0001\u001a\u000204H\u0016J\u001b\u0010ô\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010ò\u0001\u001a\u000204H\u0096@¢\u0006\u0003\u0010õ\u0001J&\u0010ö\u0001\u001a\u00030\u0086\u00012\u0007\u0010ò\u0001\u001a\u0002042\u0011\u0010Ü\u0001\u001a\f\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010Ý\u0001H\u0016J\u001b\u0010\u0092\u0001\u001a\u00030\u0086\u00012\u000f\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030\u0086\u00010Ý\u0001H\u0016J\u001d\u0010\u0096\u0001\u001a\u00030\u0086\u00012\u0011\u0010Ü\u0001\u001a\f\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010Ý\u0001H\u0016J\u0013\u0010÷\u0001\u001a\u00030\u0086\u00012\u0007\u0010Ë\u0001\u001a\u00020\u0017H\u0016J\u0014\u0010ø\u0001\u001a\u00030\u0086\u00012\b\u0010ù\u0001\u001a\u00030ú\u0001H\u0016J\u0014\u0010û\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010ü\u0001\u001a\u00020\u0017H\u0016J\u0014\u0010ý\u0001\u001a\u00030\u0086\u00012\b\u0010þ\u0001\u001a\u00030Ç\u0001H\u0016J+\u0010ÿ\u0001\u001a\u00030\u0086\u00012\u000e\u0010\u0080\u0002\u001a\t\u0012\u0004\u0012\u00020\u00170\u0081\u00022\u000f\u0010Æ\u0001\u001a\n\u0012\u0005\u0012\u00030Ç\u00010\u0082\u0002H\u0016J'\u0010\u0083\u0002\u001a\u00030\u0086\u00012\u001b\u0010\u0084\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030Ç\u00010\u0085\u00020CH\u0016J\u001f\u0010\u0086\u0002\u001a\b\u0012\u0004\u0012\u00020W0C2\u000e\u0010\u0087\u0002\u001a\t\u0012\u0004\u0012\u00020\u00170Ñ\u0001H\u0016J\u001a\u0010\u0088\u0002\u001a\u00030\u0086\u00012\u000e\u0010Ü\u0001\u001a\t\u0012\u0004\u0012\u0002040Ý\u0001H\u0016J@\u0010\u0089\u0002\u001a\t\u0012\u0005\u0012\u00030\u008a\u00020C2\u0007\u0010\u008b\u0002\u001a\u00020\u00172\u0007\u0010\u008c\u0002\u001a\u00020\t2\u0010\u0010\u008d\u0002\u001a\u000b\u0012\u0005\u0012\u00030\u008e\u0002\u0018\u00010C2\n\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u0090\u0002H\u0016J@\u0010\u0091\u0002\u001a\t\u0012\u0005\u0012\u00030\u008a\u00020C2\u0007\u0010\u008b\u0002\u001a\u00020\u00172\u0007\u0010\u008c\u0002\u001a\u00020\t2\u000e\u0010\u008d\u0002\u001a\t\u0012\u0005\u0012\u00030\u008e\u00020C2\f\b\u0002\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u0090\u0002H\u0002JY\u0010\u0092\u0002\u001a\u00030\u0086\u00012\u0007\u0010\u008b\u0002\u001a\u00020\u00172\u0007\u0010\u008c\u0002\u001a\u00020\t2\r\u0010\u0093\u0002\u001a\b\u0012\u0004\u0012\u00020W0C2\u000e\u0010\u0094\u0002\u001a\t\u0012\u0005\u0012\u00030\u008a\u00020\u00132\u000e\u0010\u008d\u0002\u001a\t\u0012\u0005\u0012\u00030\u008e\u00020C2\f\b\u0002\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u0090\u0002H\u0002J\u0013\u0010\u0095\u0002\u001a\u00030\u0086\u00012\u0007\u0010ü\u0001\u001a\u00020\u0017H\u0016J3\u0010\u0096\u0002\u001a\u00030\u0086\u00012\u0007\u0010ü\u0001\u001a\u00020\u00172\t\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u00172\t\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u00172\b\u0010\u0099\u0002\u001a\u00030\u009a\u0002H\u0016J.\u0010\u009b\u0002\u001a\u00030\u0086\u00012\u0007\u0010\u009c\u0002\u001a\u00020\u00172\u0007\u0010\u009d\u0002\u001a\u00020\u00172\n\u0010\u009e\u0002\u001a\u0005\u0018\u00010\u009f\u0002H\u0016¢\u0006\u0003\u0010 \u0002J\u0013\u0010¡\u0002\u001a\u00030\u0086\u00012\u0007\u0010Ë\u0001\u001a\u00020\u0017H\u0016J\u0013\u0010¢\u0002\u001a\u00030\u0086\u00012\u0007\u0010£\u0002\u001a\u00020\u0017H\u0016J\u001d\u0010¤\u0002\u001a\u00030\u0086\u00012\u0007\u0010¥\u0002\u001a\u0002042\b\u0010Ü\u0001\u001a\u00030¦\u0002H\u0016J\u0013\u0010§\u0002\u001a\u00030\u0086\u00012\u0007\u0010Ë\u0001\u001a\u00020\u0017H\u0016J\u001e\u0010¨\u0002\u001a\u00030\u0086\u00012\u0007\u0010©\u0002\u001a\u00020\u00172\t\u0010ª\u0002\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010«\u0002\u001a\u00030\u0086\u0001H\u0016J\u001c\u0010¬\u0002\u001a\u00030\u0086\u00012\u0007\u0010\u00ad\u0002\u001a\u00020\u00172\u0007\u0010®\u0002\u001a\u000204H\u0016J5\u0010¯\u0002\u001a\u00030\u0086\u00012\b\u0010;\u001a\u0004\u0018\u00010\u00172\r\u0010°\u0002\u001a\b\u0012\u0004\u0012\u00020\u00170C2\u0010\u0010±\u0002\u001a\u000b\u0012\u0005\u0012\u00030²\u0002\u0018\u00010CH\u0016J\u0013\u0010³\u0002\u001a\u00030\u0086\u00012\u0007\u0010´\u0002\u001a\u00020\u0017H\u0016J%\u0010µ\u0002\u001a\u00030\u0086\u00012\u0007\u0010¶\u0002\u001a\u0002042\u0007\u0010·\u0002\u001a\u00020\u001c2\u0007\u0010Ë\u0001\u001a\u00020\u0017H\u0002J\u0012\u0010¸\u0002\u001a\u0002042\u0007\u0010¹\u0002\u001a\u00020\u0017H\u0002J\u0013\u0010º\u0002\u001a\u00030\u0086\u00012\u0007\u0010ü\u0001\u001a\u00020\u0017H\u0016J\u0013\u0010»\u0002\u001a\u00030\u0086\u00012\u0007\u0010ü\u0001\u001a\u00020\u0017H\u0016J\u0013\u0010¼\u0002\u001a\u00030\u0086\u00012\u0007\u0010ü\u0001\u001a\u00020\u0017H\u0016J%\u0010½\u0002\u001a\u00030\u0086\u00012\u0007\u0010ü\u0001\u001a\u00020\u00172\u0007\u0010¾\u0002\u001a\u00020\u00172\u0007\u0010¿\u0002\u001a\u00020\tH\u0016JC\u0010À\u0002\u001a\u00030\u0086\u00012\u0006\u0010;\u001a\u00020\u00172\u0019\u0010°\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u00170Á\u0002j\t\u0012\u0004\u0012\u00020\u0017`Â\u00022\u0014\u0010Ü\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00130Ý\u0001H\u0016J?\u0010Ã\u0002\u001a\u00030\u0086\u00012\b\u0010;\u001a\u0004\u0018\u00010\u00172\u0010\u0010Ä\u0002\u001a\u000b\u0012\u0005\u0012\u00030Å\u0002\u0018\u00010\u00132\u0017\u0010Ü\u0001\u001a\u0012\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Å\u00020C\u0018\u00010Ý\u0001H\u0016J\u0013\u0010Æ\u0002\u001a\u00030\u0086\u00012\u0007\u0010ü\u0001\u001a\u00020\u0017H\u0016J\u0013\u0010Ç\u0002\u001a\u00030\u0086\u00012\u0007\u0010ü\u0001\u001a\u00020\u0017H\u0016J\u001c\u0010È\u0002\u001a\u00030\u0086\u00012\u0007\u0010ü\u0001\u001a\u00020\u00172\u0007\u0010É\u0002\u001a\u00020\tH\u0016J\t\u0010Ê\u0002\u001a\u00020pH\u0016J\n\u0010Ë\u0002\u001a\u00030\u0086\u0001H\u0016J\u000b\u0010Ì\u0002\u001a\u0004\u0018\u00010WH\u0016J.\u0010Í\u0002\u001a\u00030\u0086\u00012\u0007\u0010Î\u0002\u001a\u0002042\u0007\u0010Ï\u0002\u001a\u0002042\u0007\u0010Ð\u0002\u001a\u0002042\u0007\u0010Ñ\u0002\u001a\u000204H\u0016J\n\u0010Ò\u0002\u001a\u00030\u0086\u0001H\u0016J\u0011\u0010Ó\u0002\u001a\n\u0012\u0005\u0012\u00030Ç\u00010Ô\u0002H\u0016JV\u0010Õ\u0002\u001a\u00030\u0086\u00012$\u0010Ö\u0002\u001a\u001f\u0012\u0004\u0012\u00020\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030×\u00020§\u0001\u0018\u00010§\u00012$\u0010Ø\u0002\u001a\u001f\u0012\u0004\u0012\u00020\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030Ù\u00020§\u0001\u0018\u00010§\u0001H\u0016J\u001a\u0010Ú\u0002\u001a\u00030\u0086\u00012\u000e\u0010Û\u0002\u001a\t\u0012\u0005\u0012\u00030Ü\u00020CH\u0016J!\u0010Ý\u0002\u001a\u00030\u0086\u00012\u0015\u0010Þ\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030ß\u00020§\u0001H\u0016J\"\u0010à\u0002\u001a\u00030\u0086\u00012\u0016\u0010á\u0002\u001a\u0011\u0012\u0005\u0012\u00030\u009f\u0002\u0012\u0005\u0012\u00030â\u00020§\u0001H\u0016J\"\u0010ã\u0002\u001a\u00030\u0086\u00012\r\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020W0C2\u0007\u0010ä\u0002\u001a\u00020\tH\u0016J\n\u0010å\u0002\u001a\u00030\u0086\u0001H\u0016J\u0013\u0010æ\u0002\u001a\u00030\u0086\u00012\u0007\u0010ç\u0002\u001a\u00020\tH\u0016J\u0013\u0010è\u0002\u001a\u00030\u0086\u00012\u0007\u0010é\u0002\u001a\u00020\u0017H\u0016J\u0013\u0010ê\u0002\u001a\u00030\u0086\u00012\u0007\u0010ë\u0002\u001a\u00020\tH\u0016J\u0013\u0010ì\u0002\u001a\u00030\u0086\u00012\u0007\u0010í\u0002\u001a\u00020\tH\u0016J\u0014\u0010î\u0002\u001a\u00030\u0086\u00012\b\u0010ï\u0002\u001a\u00030¨\u0001H\u0016J\u001c\u0010ð\u0002\u001a\u00030\u0086\u00012\u0007\u0010ñ\u0002\u001a\u00020\u00172\u0007\u0010ò\u0002\u001a\u00020\u0017H\u0016J\u0014\u0010ó\u0002\u001a\u00030\u0086\u00012\b\u0010ï\u0002\u001a\u00030¨\u0001H\u0016J\u0013\u0010ô\u0002\u001a\u00030\u0086\u00012\u0007\u0010²\u0001\u001a\u00020WH\u0016J\u001e\u0010õ\u0002\u001a\u00030\u0086\u00012\t\u0010ö\u0002\u001a\u0004\u0018\u00010\u00172\u0007\u0010÷\u0002\u001a\u000204H\u0016J\u0013\u0010ø\u0002\u001a\u00030\u0086\u00012\u0007\u0010¹\u0001\u001a\u00020\u0014H\u0016J!\u0010ù\u0002\u001a\u00030\u0086\u00012\u0015\u0010Þ\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030ú\u00020§\u0001H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bj\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c`\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b+\u0010,R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0004\n\u0002\u00105R\u0012\u00106\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0004\n\u0002\u00105R\u000e\u00107\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R$\u0010A\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030D0C0BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020H0BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010FR\u001c\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010K0BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010FR\u001c\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010K0BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010FR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00170BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010FR*\u0010Q\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00170R0BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010FR\u001c\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010FR \u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0C0BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010FR \u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0C0BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010FR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\t0BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010FR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\t0BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010FR\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001f\u0010e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010C0B¢\u0006\b\n\u0000\u001a\u0004\bf\u0010FR\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\t0B¢\u0006\b\n\u0000\u001a\u0004\bh\u0010FR\u0017\u0010i\u001a\b\u0012\u0004\u0012\u00020\t0B¢\u0006\b\n\u0000\u001a\u0004\bj\u0010FR\u0019\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010l0B¢\u0006\b\n\u0000\u001a\u0004\bm\u0010FR\u000e\u0010n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020pX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010s\u001a\u00020t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010#\u001a\u0004\bu\u0010vR\u001b\u0010x\u001a\u00020y8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b|\u0010#\u001a\u0004\bz\u0010{R\u0015\u0010}\u001a\u00020~X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0081\u0001\u001a\u00030\u0082\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001¨\u0006ü\u0002"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowListViewModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListViewModel;", "Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowPushListener;", "Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowListCommands;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "enableMessageFolding", "", "<init>", "(Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Z)V", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "repository", "Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowRepository;", "threads", "", "Lcom/ss/android/lark/chat/entity/thread/ThreadInfo;", "threadsById", "", "", "mainHandler", "Landroid/os/Handler;", "pendingRootPlaceholders", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/chat/entity/message/Message;", "Lkotlin/collections/LinkedHashMap;", "messageMapper", "Lcom/ss/android/lark/chat/chatwindow/chat/data/convert/ChatMessageDataMapper;", "getMessageMapper", "()Lcom/ss/android/lark/chat/chatwindow/chat/data/convert/ChatMessageDataMapper;", "messageMapper$delegate", "Lkotlin/Lazy;", "fileAuthorityChecker", "Lcom/ss/android/lark/auditsdk/v2/receivecheck/ImFileAuthorityChecker;", "getFileAuthorityChecker", "()Lcom/ss/android/lark/auditsdk/v2/receivecheck/ImFileAuthorityChecker;", "fileAuthorityChecker$delegate", "mediaRootStateHandler", "Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowMediaRootStateHandler;", "getMediaRootStateHandler", "()Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowMediaRootStateHandler;", "mediaRootStateHandler$delegate", "pushManager", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/PushHandlerManager;", "pushRegistered", "loadingNextPage", "loadingPrePage", "loadedFirstPosition", "", "Ljava/lang/Integer;", "loadedLastPosition", "quitGroupBySelf", "dissolveGroupByLocalFlag", "destroyed", "initDataApplied", "chatId", "getChatId", "()Ljava/lang/String;", "showPosition", "getShowPosition", "()I", "messageList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "getMessageList", "()Landroidx/lifecycle/MutableLiveData;", "currentChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getCurrentChat", "selfChatterLiveData", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "getSelfChatterLiveData", "p2pChatterLiveData", "getP2pChatterLiveData", "toastInfo", "getToastInfo", "dialogInfo", "Lkotlin/Pair;", "getDialogInfo", "closePageInfo", "getClosePageInfo", "newMessageItems", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "getNewMessageItems", "newMessageItemsAppend", "getNewMessageItemsAppend", "needRelocateMessage", "getNeedRelocateMessage", "messageReadable", "getMessageReadable", "pinExtraLoader", "Lcom/ss/android/lark/chat/chatwindow/chat/model/pin/MessageListPinExtraLoader;", "getPinExtraLoader", "()Lcom/ss/android/lark/chat/chatwindow/chat/model/pin/MessageListPinExtraLoader;", "setPinExtraLoader", "(Lcom/ss/android/lark/chat/chatwindow/chat/model/pin/MessageListPinExtraLoader;)V", "threadList", "getThreadList", "loading", "getLoading", "hasMoreLiveData", "getHasMoreLiveData", "error", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getError", "hasMore", "uiModel", "Lcom/ss/android/lark/chat/chatwindow/chat/ChatWindowUIModel;", "dataStoreExecutor", "Lcom/ss/android/lark/chat/core/model/SerialExecutor;", "topicMaxHeightFactor", "Lcom/ss/android/lark/widget/EllipsizeFrameLayout$EllipsizeMaxHeightFactor;", "getTopicMaxHeightFactor", "()Lcom/ss/android/lark/widget/EllipsizeFrameLayout$EllipsizeMaxHeightFactor;", "topicMaxHeightFactor$delegate", "dataStore", "Lcom/ss/android/lark/chat/chatwindow/chat/model/ChatWindowDataStore;", "getDataStore", "()Lcom/ss/android/lark/chat/chatwindow/chat/model/ChatWindowDataStore;", "dataStore$delegate", "mMessageReader", "Lcom/ss/android/lark/biz/im/api/IMessageReader;", "getMMessageReader", "()Lcom/ss/android/lark/biz/im/api/IMessageReader;", "dependency", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;", "getDependency", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;", "bindInitData", "", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "registerPushIfNeeded", "loadFirstPage", "isFromOfflinePush", "reloadServerChat", "onFirstPageError", "err", "", "canLoadNextPage", "canLoadPrePage", "loadNextPage", "onComplete", "Lkotlin/Function1;", "Lkotlin/Result;", "loadPrePage", "mergeThreads", "newItems", "replaceLocalPreMediaRoots", "updateLoadedRange", "items", "reset", "onPushThreadReactions", "reactions", "Lcom/bytedance/lark/pb/im/v1/PushMessageReactions;", "onPushThreadTopic", "threadTopic", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "onPushChat", "chat", "onPushChatRemoveChatters", "chatterMap", "", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "onPushChatRemoveMe", "handleChatChange", "newChat", "handleQuitGroup", "scheduleQuitGroup", "onPushRootThread", "pushMessageDTO", "Lcom/ss/android/lark/biz/im/api/PushMessageDTO;", "onPushRootMessage", "messageInfo", "onPushThreadReply", "patchThreadRepliesFromPush", "lastReplyMessages", "lastAtMessages", "source", "addOrReplaceThreadFromPush", "threadInfo", "findExistingThreadIndex", "rootMessage", "findExistingRootMessageIndex", "matchesThreadTopic", "preserveTranslatingState", "oldItem", "newItem", "publishThreads", "syncDataStoreSnapshot", "snapshot", "patchLoadedThreads", "predicate", "updater", "Lcom/ss/android/lark/chat/entity/message/IChatMessage;", "insertSendingRootPlaceholder", "preMessage", "markRootSendSuccess", "messageId", "markRootSendFailed", "drainPendingRootPlaceholders", "insertRootPlaceholder", "readThreads", "threadIds", "", "toChatMessageVOList", "applyThreadWindowUIModel", "refreshMessageItem", "toMessageInfo", "allThreadMessageInfos", "sendNewTopic", "title", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "isAnonymous", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "onCleared", "destroy", "setWindowDataPreLoadTaskProvider", "provider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IChatWindowPreLoadTaskProvider;", "setActionDispatch", "dispatcher", "Lcom/ss/android/lark/chat/base/model/dispatch/ActionDispatcher;", "setScreenItemProvider", "Lcom/ss/android/lark/chat/chatwindow/chat/model/ChatWindowDataStore$ILastScreenItemProvider;", "readMessage", "intervalMessages", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "context", "Landroid/content/Context;", "getExpiredPeriodTime", "()Ljava/lang/Integer;", "canLoadPre", "canLoadMore", "containsPosition", "position", "getDataOnPosition", "loadSpecialPosition", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSpecialPage", "toggleItemShowTime", "executeMessage", "runnable", "Ljava/lang/Runnable;", "getMessageInfoById", "msgId", "batchUpdate", "needUpdateMessage", "updateMsg", TabAppInfo.IMAGE_JSON_KEY, "Lcom/ss/android/lark/biz/im/api/extension/store/ItemTwoKey;", "Lcom/ss/android/lark/biz/im/api/extension/store/IItemPatch;", "batchUpdateMsg", "patchProviderList", "Lcom/ss/android/lark/biz/im/api/extension/store/PatchProvider;", "getMessageInfoByIds", "msgIds", "ensureLastPageDataLoaded", "getAllImage", "Lcom/ss/android/lark/chat/entity/image/ImageSet;", "clickedMsgId", "isClickTranslated", "messageTypeList", "Lcom/ss/android/lark/chat/entity/message/Message$Type;", "externalHandler", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageDataExternalHandler;", "getAllImageInner", "parseImageSetFromMsgInfoList", "messageInfoList", "imageSetList", "readAudioMsg", "prepareAudioData", "previewId", "msgLinkToken", "successState", "Lcom/ss/android/lark/chat/entity/message/content/AudioContent$AudioState;", "sendSignRequest", "description", "sourceId", "privateDescriptionId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "addSticker", "onAuditedFailed", "msg", "checkToClearDataStore", "newFirstMsgPosition", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageClearedCallback;", "deleteUrlPreview", "cancelUploadMediaMsg", "cId", "compressPath", "notifyDataChange", "onFollowFold", "foldId", "count", "recallMembers", "chatterIds", "entityList", "Lcom/ss/android/lark/chat/entity/chat/PickChatEntity;", "retrySendMessage", "preMsgId", "markRetryRootSendSuccess", "index", "fallbackMessage", "findRootIndexByLocalId", "id", "invalidGroupShare", "burnMsg", "updatePreviewByMessageId", "handleInteractiveState", "eleId", "inProcessing", "checkChatterInChat", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCheckMembersInChat", "entities", "Lcom/ss/android/lark/dto/group/GroupRecallEntity;", "registerImmediateMsg", "handleShowMoreTextClick", "handleCollapsingUrlPreview", "isCollapsed", "getUIModel", "changeMessageAlignIfNeed", "getTopicMessageInfo", "onTrimMemory", "level", "javaHeapUsed", "nativeHeapUsed", "maxJavaHeapMem", "onJavaMemoryReachTop", "stream", "Lcom/ss/android/lark/chatbase/Stream;", "onPushPreview", "previews", "Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;", "messageLinkMap", "Lcom/bytedance/lark/pb/basic/v1/MessageLink;", "onPushSignUrlPreview", "entriesList", "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "onPushFileAuthority", "map", "Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/ValidateIMFileResult;", "onPushUserGroup", "userGroups", "Lcom/bytedance/lark/pb/im/v1/UserGroupEntity;", "onPushMessage", "updateImmediate", "onFileDownloadFail", "onSwitchToCellularDataNetwork", "isPause", "onSendChatAnnouncement", "content", "updateDissolveGroupLocalFlag", "localFlag", "onQuitGroup", "byMySelf", "onPushUpdatedChatter", "chatter", "onPushUpdatedNickname", "chatterId", "nickname", "onUpdateSelfInfo", "onPushDingMessage", "onPushUploadProgress", "cid", "progress", "onThreadRepliesUpdate", "onPushMyAIVote", "Lcom/bytedance/lark/pb/basic/v1/Message$AIMessageLikeFeedbackStatus;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowThreadWindowListViewModel extends IMessageListViewModel implements com.ss.android.lark.flow.threadwindow.t, com.ss.android.lark.flow.threadwindow.j {
    public static final int $stable = 0;
    public static final b Companion = null;
    private static final String TAG = "FlowThreadWindowListVM";
    private final fxa.b chatBundle;
    private final v chatContainer;
    private final String chatId;
    private final MutableLiveData<String> closePageInfo;
    private final MutableLiveData<Chat> currentChat;
    private final Lazy dataStore$delegate;
    private final x4b.n dataStoreExecutor;
    private final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p dependency;
    private boolean destroyed;
    private final MutableLiveData<Pair<String, String>> dialogInfo;
    private boolean dissolveGroupByLocalFlag;
    private final boolean enableMessageFolding;
    private final MutableLiveData<ErrorResult> error;
    private final Lazy fileAuthorityChecker$delegate;
    private boolean hasMore;
    private final MutableLiveData<Boolean> hasMoreLiveData;
    private boolean initDataApplied;
    private Integer loadedFirstPosition;
    private Integer loadedLastPosition;
    private final MutableLiveData<Boolean> loading;
    private boolean loadingNextPage;
    private boolean loadingPrePage;
    private final f0 mMessageReader;
    private final Handler mainHandler;
    private final Lazy mediaRootStateHandler$delegate;
    private final MutableLiveData<List<y6b.c<?>>> messageList;
    private final Lazy messageMapper$delegate;
    private final MutableLiveData<Boolean> messageReadable;
    private final MutableLiveData<Boolean> needRelocateMessage;
    private final MutableLiveData<List<MessageInfo>> newMessageItems;
    private final MutableLiveData<List<MessageInfo>> newMessageItemsAppend;
    private final MutableLiveData<ChatChatter> p2pChatterLiveData;
    private final LinkedHashMap<String, Message> pendingRootPlaceholders;
    private MessageListPinExtraLoader pinExtraLoader;
    private final c0 pushManager;
    private boolean pushRegistered;
    private boolean quitGroupBySelf;
    private final FlowThreadWindowRepository repository;
    private final MutableLiveData<ChatChatter> selfChatterLiveData;
    private final int showPosition;
    private final MutableLiveData<List<n5b.a>> threadList;
    private final List<n5b.a> threads;
    private final Map<String, n5b.a> threadsById;
    private final MutableLiveData<String> toastInfo;
    private final Lazy topicMaxHeightFactor$delegate;
    private final s2b.e uiModel;

    public static final class a implements s2b.e.a {
        public final /* synthetic */ FlowThreadWindowListViewModel a;

        public a(FlowThreadWindowListViewModel r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            FlowThreadWindowListViewModel r0 = this.a;
            Intrinsics.checkNotNull(r2);
            FlowThreadWindowListViewModel.access$refreshMessageItem(r0, r2);
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            ThreadTopic r4 = ((n5b.a) r2).b;
            int r0 = Integer.MAX_VALUE;
            if (r4 == null) goto L5;
            int r5 = r4.getPosition();
        L6:
            Integer r6 = Integer.valueOf(r5);
            ThreadTopic r7 = ((n5b.a) r3).b;
            if (r7 == null) goto L10;
            r0 = r7.getPosition();
        L10:
            return ComparisonsKt.compareValues(r6, Integer.valueOf(r0));
        L5:
            r5 = Integer.MAX_VALUE;
            goto L6
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ FlowThreadWindowListViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(FlowThreadWindowListViewModel r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.cancelUploadMediaMsg(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p {
        public final /* synthetic */ FlowThreadWindowListViewModel a;

        public final /* bridge */ /* synthetic */ m2b.a a() {
            return null;
        }

        public final /* synthetic */ s0 b() {
            return null;
        }

        public final /* bridge */ /* synthetic */ d0 c() {
            return null;
        }

        public final /* bridge */ /* synthetic */ Map d() {
            return null;
        }

        public final void e(BasePageStore r2) {
            Intrinsics.checkNotNullParameter(r2, "store");
        }

        public final /* bridge */ /* synthetic */ q4b.a getMessageSender() {
            return null;
        }

        public final /* bridge */ /* synthetic */ a1 h() {
            return null;
        }

        public final /* bridge */ /* synthetic */ w0 i() {
            return null;
        }

        public final /* bridge */ /* synthetic */ z0 j() {
            return null;
        }

        public final /* bridge */ /* synthetic */ f0 m() {
            return null;
        }

        public final Boolean n() {
            return null;
        }

        public final /* bridge */ /* synthetic */ v0 p() {
            return null;
        }

        public final /* bridge */ /* synthetic */ jya.b q() {
            return null;
        }

        public final /* bridge */ /* synthetic */ z2b.a r() {
            return null;
        }

        public final Boolean t() {
            return null;
        }

        public final /* bridge */ /* synthetic */ y6b.e u() {
            return null;
        }

        public final Integer v() {
            return null;
        }

        public final boolean o() {
            return FlowThreadWindowListViewModel.access$getEnableMessageFolding$p(this.a);
        }

        public final List<b1> k() {
            return CollectionsKt.emptyList();
        }

        public final List<com.ss.android.lark.chatbase.i<MessageInfo>> l() {
            return CollectionsKt.emptyList();
        }

        public final List<h1> s() {
            return CollectionsKt.emptyList();
        }

        public final List<u0> w() {
            return CollectionsKt.emptyList();
        }

        public final List<y3b.a> x() {
            return CollectionsKt.emptyList();
        }

        public e(FlowThreadWindowListViewModel r1) {
            this.a = r1;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ FlowThreadWindowListViewModel a;
        public final /* synthetic */ Chat b;

        public g(FlowThreadWindowListViewModel r1, Chat r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getCurrentChat().setValue(this.b);     // Catch: Throwable -> L4
            FlowThreadWindowListViewModel.access$drainPendingRootPlaceholders(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h<T> implements Comparator {
        public h() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            ThreadTopic r4 = ((n5b.a) r2).b;
            int r0 = Integer.MAX_VALUE;
            if (r4 == null) goto L5;
            int r5 = r4.getPosition();
        L6:
            Integer r6 = Integer.valueOf(r5);
            ThreadTopic r7 = ((n5b.a) r3).b;
            if (r7 == null) goto L10;
            r0 = r7.getPosition();
        L10:
            return ComparisonsKt.compareValues(r6, Integer.valueOf(r0));
        L5:
            r5 = Integer.MAX_VALUE;
            goto L6
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ FlowThreadWindowListViewModel a;
        public final /* synthetic */ Message b;

        public i(FlowThreadWindowListViewModel r1, Message r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.insertSendingRootPlaceholder(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements f0 {
        public j() {
        }

        public final void a(MessageInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "messageInfo");
        }

        public final void b() {
        }

        public final void c(List<? extends MessageInfo> r2) {
            Intrinsics.checkNotNullParameter(r2, LocationHitPoint$ResultType.LIST);
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ FlowThreadWindowListViewModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Message c;
        public final /* synthetic */ String d;

        public k(FlowThreadWindowListViewModel r1, int r2, Message r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FlowThreadWindowListViewModel.access$markRetryRootSendSuccess(this.a, this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l<T> implements Comparator {
        public l() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            ThreadTopic r4 = ((n5b.a) r2).b;
            int r0 = Integer.MAX_VALUE;
            if (r4 == null) goto L5;
            int r5 = r4.getPosition();
        L6:
            Integer r6 = Integer.valueOf(r5);
            ThreadTopic r7 = ((n5b.a) r3).b;
            if (r7 == null) goto L10;
            r0 = r7.getPosition();
        L10:
            return ComparisonsKt.compareValues(r6, Integer.valueOf(r0));
        L5:
            r5 = Integer.MAX_VALUE;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.threadwindow.FlowThreadWindowListViewModel$loadFirstPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.threadwindow.FlowThreadWindowListViewModel$loadFirstPage$1", f = "FlowThreadWindowListViewModel.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowThreadWindowListViewModel this$0;

        public C03631(FlowThreadWindowListViewModel r1, Continuation<? super C03631> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03631(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
            Object r7 = ((Result) r6).unbox-impl();
        L11:
            this.this$0.getLoading().postValue(Boxing.boxBoolean(false));
            FlowThreadWindowListViewModel r2 = this.this$0;
            if (Result.isSuccess-impl(r7) == false) goto L14;
            List r3 = (List) r7;
            Log.i(FlowThreadWindowListViewModel.TAG, "loadFirstPage success, chatId:" + r2.getChatId() + ", threadCount:" + r3.size());
            FlowThreadWindowListViewModel.access$getThreads$p(r2).clear();
            List r4 = r3;
            FlowThreadWindowListViewModel.access$getThreads$p(r2).addAll(r4);
            FlowThreadWindowListViewModel.access$updateLoadedRange(r2, r3, true);
            FlowThreadWindowListViewModel.access$setHasMore$p(r2, !r4.isEmpty());
            FlowThreadWindowListViewModel.access$publishThreads(r2);
            r2.getHasMoreLiveData().postValue(Boxing.boxBoolean(FlowThreadWindowListViewModel.access$getHasMore$p(r2)));
            FlowThreadWindowListViewModel.access$reloadServerChat(r2);
        L14:
            FlowThreadWindowListViewModel r5 = this.this$0;
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L18;
            FlowThreadWindowListViewModel.access$onFirstPageError(r5, r8);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            FlowThreadWindowRepository r9 = FlowThreadWindowListViewModel.access$getRepository$p(this.this$0);
            String r10 = this.this$0.getChatId();
            this.label = 1;
            r7 = r9.b(r10, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.threadwindow.FlowThreadWindowListViewModel$loadNextPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.threadwindow.FlowThreadWindowListViewModel$loadNextPage$1", f = "FlowThreadWindowListViewModel.kt", i = {}, l = {372}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Unit>, Unit> $onComplete;
        int label;
        final /* synthetic */ FlowThreadWindowListViewModel this$0;

        public C03641(FlowThreadWindowListViewModel r1, Function1<? super Result<Unit>, Unit> r2, Continuation<? super C03641> r3) {
            this.this$0 = r1;
            this.$onComplete = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03641(this.this$0, this.$onComplete, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
            Object r7 = ((Result) r6).unbox-impl();
        L18:
            FlowThreadWindowListViewModel r2 = this.this$0;
            if (Result.isSuccess-impl(r7) == false) goto L25;
            List r3 = (List) r7;
            if ((true ^ r3.isEmpty()) == false) goto L23;
            FlowThreadWindowListViewModel.access$mergeThreads(r2, r3);
            FlowThreadWindowListViewModel.updateLoadedRange$default(r2, r3, false, 2, null);
        L24:
            FlowThreadWindowListViewModel.access$publishThreads(r2);
            r2.getHasMoreLiveData().postValue(Boxing.boxBoolean(FlowThreadWindowListViewModel.access$getHasMore$p(r2)));
            goto L25
        L23:
            FlowThreadWindowListViewModel.access$setHasMore$p(r2, false);
        L25:
            Throwable r4 = Result.exceptionOrNull-impl(r7);
            if (r4 == null) goto L28;
            Log.w(FlowThreadWindowListViewModel.TAG, "load next page failed", r4);
        L28:
            FlowThreadWindowListViewModel r5 = this.this$0;
            Function1<Result<Unit>, Unit> r8 = this.$onComplete;
            FlowThreadWindowListViewModel.access$setLoadingNextPage$p(r5, false);
            if (r8 == null) goto L35;
            if (Result.isSuccess-impl(r7) == false) goto L33;
            List r9 = (List) r7;
            r7 = Unit.INSTANCE;
        L33:
            r8.invoke(Result.box-impl(Result.constructor-impl(r7)));
        L35:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Integer r10 = FlowThreadWindowListViewModel.access$getLoadedLastPosition$p(this.this$0);
            if (r10 != null) goto L15;
            FlowThreadWindowListViewModel.access$setLoadingNextPage$p(this.this$0, false);
            Function1<Result<Unit>, Unit> r11 = this.$onComplete;
            if (r11 == null) goto L14;
            Result.Companion r12 = Result.Companion;
            r11.invoke(Result.box-impl(Result.constructor-impl(Unit.INSTANCE)));
        L14:
            return Unit.INSTANCE;
        L15:
            FlowThreadWindowRepository r13 = FlowThreadWindowListViewModel.access$getRepository$p(this.this$0);
            String r14 = this.this$0.getChatId();
            int r15 = r10.intValue();
            this.label = 1;
            r7 = r13.c(r14, r15, this);
            if (r7 != r0) goto L18;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.threadwindow.FlowThreadWindowListViewModel$loadPrePage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.threadwindow.FlowThreadWindowListViewModel$loadPrePage$1", f = "FlowThreadWindowListViewModel.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Unit>, Unit> $onComplete;
        int label;
        final /* synthetic */ FlowThreadWindowListViewModel this$0;

        public C03651(FlowThreadWindowListViewModel r1, Function1<? super Result<Unit>, Unit> r2, Continuation<? super C03651> r3) {
            this.this$0 = r1;
            this.$onComplete = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03651(this.this$0, this.$onComplete, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
            Object r7 = ((Result) r6).unbox-impl();
        L18:
            FlowThreadWindowListViewModel r2 = this.this$0;
            if (Result.isSuccess-impl(r7) == false) goto L23;
            List r3 = (List) r7;
            if ((true ^ r3.isEmpty()) == false) goto L23;
            FlowThreadWindowListViewModel.access$mergeThreads(r2, r3);
            FlowThreadWindowListViewModel.updateLoadedRange$default(r2, r3, false, 2, null);
            FlowThreadWindowListViewModel.access$publishThreads(r2);
            r2.getHasMoreLiveData().postValue(Boxing.boxBoolean(FlowThreadWindowListViewModel.access$getHasMore$p(r2)));
        L23:
            Throwable r4 = Result.exceptionOrNull-impl(r7);
            if (r4 == null) goto L26;
            Log.w(FlowThreadWindowListViewModel.TAG, "load previous page failed", r4);
        L26:
            FlowThreadWindowListViewModel r5 = this.this$0;
            Function1<Result<Unit>, Unit> r8 = this.$onComplete;
            FlowThreadWindowListViewModel.access$setLoadingPrePage$p(r5, false);
            if (r8 == null) goto L33;
            if (Result.isSuccess-impl(r7) == false) goto L31;
            List r9 = (List) r7;
            r7 = Unit.INSTANCE;
        L31:
            r8.invoke(Result.box-impl(Result.constructor-impl(r7)));
        L33:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Integer r10 = FlowThreadWindowListViewModel.access$getLoadedFirstPosition$p(this.this$0);
            if (r10 != null) goto L15;
            FlowThreadWindowListViewModel.access$setLoadingPrePage$p(this.this$0, false);
            Function1<Result<Unit>, Unit> r11 = this.$onComplete;
            if (r11 == null) goto L14;
            Result.Companion r12 = Result.Companion;
            r11.invoke(Result.box-impl(Result.constructor-impl(Unit.INSTANCE)));
        L14:
            return Unit.INSTANCE;
        L15:
            FlowThreadWindowRepository r13 = FlowThreadWindowListViewModel.access$getRepository$p(this.this$0);
            String r14 = this.this$0.getChatId();
            int r15 = r10.intValue();
            this.label = 1;
            r7 = r13.d(r14, r15, this);
            if (r7 != r0) goto L18;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.threadwindow.FlowThreadWindowListViewModel$loadSpecialPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.threadwindow.FlowThreadWindowListViewModel$loadSpecialPage$1", f = "FlowThreadWindowListViewModel.kt", i = {}, l = {1045}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IGetDataCallback<Unit> $callback;
        final /* synthetic */ int $position;
        int label;
        final /* synthetic */ FlowThreadWindowListViewModel this$0;

        public C03671(FlowThreadWindowListViewModel r1, int r2, IGetDataCallback<Unit> r3, Continuation<? super C03671> r4) {
            this.this$0 = r1;
            this.$position = r2;
            this.$callback = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03671(this.this$0, this.$position, this.$callback, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
            Object r7 = ((Result) r6).unbox-impl();
        L11:
            FlowThreadWindowListViewModel r2 = this.this$0;
            IGetDataCallback<Unit> r3 = this.$callback;
            if (Result.isSuccess-impl(r7) == false) goto L18;
            List r4 = (List) r7;
            if ((true ^ r4.isEmpty()) == false) goto L16;
            FlowThreadWindowListViewModel.access$mergeThreads(r2, r4);
            FlowThreadWindowListViewModel.access$publishThreads(r2);
            r2.getHasMoreLiveData().postValue(Boxing.boxBoolean(FlowThreadWindowListViewModel.access$getHasMore$p(r2)));
        L16:
            if (r3 == null) goto L18;
            r3.onSuccess(Unit.INSTANCE);
        L18:
            int r5 = this.$position;
            IGetDataCallback<Unit> r8 = this.$callback;
            ErrorResult r9 = Result.exceptionOrNull-impl(r7);
            if (r9 == null) goto L33;
            Log.w(FlowThreadWindowListViewModel.TAG, "loadSpecialPage failed, position:" + r5, r9);
            if (r8 == null) goto L33;
            if ((r9 instanceof ErrorResult) == false) goto L25;
            ErrorResult r10 = r9;
        L26:
            if (r10 != null) goto L31;
            String r11 = r9.getMessage();
            if (r11 != null) goto L30;
            r11 = "load special page failed";
        L30:
            r10 = new ErrorResult(r11);
        L31:
            r8.onError(r10);
            goto L33
        L25:
            r10 = null;
        L33:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            FlowThreadWindowRepository r12 = FlowThreadWindowListViewModel.access$getRepository$p(this.this$0);
            String r13 = this.this$0.getChatId();
            int r14 = this.$position;
            this.label = 1;
            r7 = r12.e(r13, r14, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public static final class m<T> implements Comparator {
        public m() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            ThreadTopic r4 = ((n5b.a) r2).b;
            int r0 = Integer.MAX_VALUE;
            if (r4 == null) goto L5;
            int r5 = r4.getPosition();
        L6:
            Integer r6 = Integer.valueOf(r5);
            ThreadTopic r7 = ((n5b.a) r3).b;
            if (r7 == null) goto L10;
            r0 = r7.getPosition();
        L10:
            return ComparisonsKt.compareValues(r6, Integer.valueOf(r0));
        L5:
            r5 = Integer.MAX_VALUE;
            goto L6
        }
    }

    public static final class n implements Runnable {
        public final /* synthetic */ FlowThreadWindowListViewModel a;
        public final /* synthetic */ MessageInfo b;

        public n(FlowThreadWindowListViewModel r1, MessageInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getNewMessageItems().setValue(CollectionsKt.listOf(this.b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class o implements Runnable {
        public final /* synthetic */ Map<String, PushMessageReactions.Reactions> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PushMessageReactions c;
        public final /* synthetic */ FlowThreadWindowListViewModel d;

        public static final class a implements Runnable {
            public final /* synthetic */ Map<String, List<ReactionInfo>> a;
            public final /* synthetic */ FlowThreadWindowListViewModel b;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Map<String, ? extends List<ReactionInfo>> r1, FlowThreadWindowListViewModel r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                Map<String, List<ReactionInfo>> r0 = this.a;
                FlowThreadWindowListViewModel r1 = this.b;
                Iterator<Map.Entry<String, List<ReactionInfo>>> r2 = r0.entrySet().iterator();
                boolean r3 = false;
            L4:
                if (r2.hasNext() == false) goto L28;
                Map.Entry<String, List<ReactionInfo>> r4 = r2.next();
                String r5 = r4.getKey();
                List<ReactionInfo> r6 = r4.getValue();
                Iterator r7 = FlowThreadWindowListViewModel.access$getThreads$p(r1).iterator();
                int r8 = 0;
            L7:
                if (r7.hasNext() == false) goto L25;
                n5b.a r9 = (n5b.a) r7.next();
                Message r10 = r9.c;
                String r11 = null;
                if (r10 == null) goto L11;
                String r12 = r10.getId();
            L13:
                if (Intrinsics.areEqual(r12, r5) == true) goto L21;
                ThreadTopic r13 = r9.b;
                if (r13 == null) goto L18;
                r11 = r13.getId();
            L18:
                if (Intrinsics.areEqual(r11, r5) == true) goto L21;
                boolean r14 = false;
            L22:
                if (r14 == true) goto L26;
                r8 = r8 + 1;
            L26:
                if (r8 < 0) goto L4;
                ((n5b.a) ListProtector.get(FlowThreadWindowListViewModel.access$getThreads$p(r1), r8)).d = r6;
                Log.i(FlowThreadWindowListViewModel.TAG, "patchReactionsFromPush success, msgId:" + r5);
                r3 = true;
            L21:
                r14 = true;
                goto L22
            L11:
                r12 = null;
                goto L13
            L25:
                r8 = -1;
                goto L26
            L28:
                if (r3 == false) goto L38;
                FlowThreadWindowListViewModel.access$publishThreads(this.b);
                return;
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

        public o(Map<String, PushMessageReactions.Reactions> r1, String r2, PushMessageReactions r3, FlowThreadWindowListViewModel r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            Map<String, PushMessageReactions.Reactions> r0 = this.a;
            String r1 = this.b;
            PushMessageReactions r2 = this.c;
            LinkedHashMap r3 = new LinkedHashMap(MapsKt.mapCapacity(r0.size()));
            Iterator<T> r4 = r0.entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            Map.Entry r5 = (Map.Entry) r4.next();
            r3.put(r5.getKey(), k7b.a.a(r1, (PushMessageReactions.Reactions) r5.getValue(), r2.entity));
            goto L4
        L6:
            CoreThreadPool.getDefault().getUIExecutor().execute(new a(r3, this.d));
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

    public static final class p implements Runnable {
        public final /* synthetic */ Chat a;
        public final /* synthetic */ List<n5b.a> b;
        public final /* synthetic */ o0 c;

        public p(Chat r1, List<? extends n5b.a> r2, o0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            Log.i(FlowThreadWindowListViewModel.TAG, "readThreads, chat:" + this.a.getId() + ", size:" + this.b.size());
            this.c.q5(this.b, this.a.getReadThreadPosition(), this.a.getReadThreadPositionBadgeCount());
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

    public static final class q implements Runnable {
        public final /* synthetic */ FlowThreadWindowListViewModel a;

        public static final class a implements Runnable {
            public final /* synthetic */ FlowThreadWindowListViewModel a;
            public final /* synthetic */ Chat b;

            public a(FlowThreadWindowListViewModel r1, Chat r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L14;
                throw th;
            L14:
                return;
            L3:
                if (FlowThreadWindowListViewModel.access$getDestroyed$p(this.a) == true) goto L10;
                this.a.onPushChat(this.b);     // Catch: Throwable -> L7
                return;
            }
        }

        public q(FlowThreadWindowListViewModel r1) {
            this.a = r1;
        }

        public final void a() {
            FlowThreadWindowListViewModel r0 = this.a;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            Object r2 = Result.constructor-impl(r0.getChatContainer().B().B2(r0.getChatId()));     // Catch: Throwable -> L5
        L7:
            FlowThreadWindowListViewModel r3 = this.a;
            Throwable r4 = Result.exceptionOrNull-impl(r2);
            if (r4 == null) goto L11;
            Log.w(FlowThreadWindowListViewModel.TAG, "reloadServerChat failed, chatId:" + r3.getChatId(), r4);
        L11:
            if (Result.isFailure-impl(r2) == false) goto L13;
            r2 = null;
        L13:
            Chat r5 = (Chat) r2;
            if (r5 != null) goto L16;
            return;
        L16:
            FlowThreadWindowListViewModel.access$getMainHandler$p(this.a).post(new a(this.a, r5));
            return;
        L5:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r2 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
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

    public static final class r implements Runnable {
        public final /* synthetic */ FlowThreadWindowListViewModel a;
        public final /* synthetic */ String b;

        public r(FlowThreadWindowListViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.retrySendMessage(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class s implements Runnable {
        public final /* synthetic */ FlowThreadWindowListViewModel a;
        public final /* synthetic */ Chat b;

        public s(FlowThreadWindowListViewModel r1, Chat r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.chat.entity.chat.b r0 = this.a.getChatContainer().j0().I0(this.b.getId());     // Catch: Throwable -> L17
            if (r0 == null) goto L14;
            String r1 = r0.b;     // Catch: Throwable -> L17
            if (r1 == null) goto L14;
            if (r1.length() <= 0) goto L9;
            boolean r2 = true;
        L10:
            if (r2 == true) goto L13;
            r1 = null;
        L13:
            if (r1 == null) goto L14;
        L15:
            this.a.getClosePageInfo().postValue(r1);     // Catch: Throwable -> L17
            return;
        L9:
            r2 = false;
        L14:
            r1 = UIHelper.getString(2131891449);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L21;
            return;
        L21:
            throw th;
        }
    }

    public static final class t implements Runnable {
        public final /* synthetic */ FlowThreadWindowListViewModel a;
        public final /* synthetic */ List<MessageInfo> b;

        public t(FlowThreadWindowListViewModel r1, List<? extends MessageInfo> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.m525getDataStore().A(new q3b.e(this.b, CollectionsKt.emptyList(), CollectionsKt.emptyList(), -1, MapsKt.emptyMap()));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class u implements Runnable {
        public final /* synthetic */ FlowThreadWindowListViewModel a;
        public final /* synthetic */ hya.b<String> b;
        public final /* synthetic */ hya.a<f5b.b> c;

        public u(FlowThreadWindowListViewModel r1, hya.b<String> r2, hya.a<f5b.b> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.updateMsg(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new b();
        $stable = 8;
    }

    public void addSticker(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
    }

    public void burnMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
    }

    public void changeMessageAlignIfNeed() {
    }

    public Integer getExpiredPeriodTime() {
        return null;
    }

    public MessageInfo getTopicMessageInfo() {
        return null;
    }

    public void handleInteractiveState(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "msgId");
        Intrinsics.checkNotNullParameter(r2, "eleId");
    }

    public void handleShowMoreTextClick(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
    }

    public void invalidGroupShare(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
    }

    public void notifyDataChange() {
    }

    public void onAuditedFailed(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public void onFileDownloadFail() {
    }

    public void onFollowFold(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "foldId");
    }

    public void onJavaMemoryReachTop() {
    }

    public void onPushDingMessage(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
    }

    public void onPushMessage(List<? extends MessageInfo> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "messageInfo");
    }

    public void onPushMyAIVote(Map<String, ? extends com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public void onPushUpdatedChatter(Chatter r2) {
        Intrinsics.checkNotNullParameter(r2, "chatter");
    }

    public void onPushUpdatedNickname(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r3, "nickname");
    }

    public void onPushUserGroup(Map<Long, UserGroupEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "userGroups");
    }

    public void onSendChatAnnouncement(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }

    public void onSwitchToCellularDataNetwork(boolean r1) {
    }

    public void onTrimMemory(int r1, int r2, int r3, int r4) {
    }

    public void onUpdateSelfInfo(Chatter r2) {
        Intrinsics.checkNotNullParameter(r2, "chatter");
    }

    public void prepareAudioData(String r1, String r2, String r3, AudioContent.AudioState r4) {
        Intrinsics.checkNotNullParameter(r1, "msgId");
        Intrinsics.checkNotNullParameter(r4, "successState");
    }

    public void readAudioMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
    }

    public void recallMembers(String r1, List<String> r2, List<? extends PickChatEntity> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterIds");
    }

    public void registerImmediateMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
    }

    public void setActionDispatch(ActionDispatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "dispatcher");
    }

    public void setScreenItemProvider(q3b.m.c r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
    }

    public void setWindowDataPreLoadTaskProvider(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.l r1) {
    }

    public void toggleItemShowTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
    }

    private final List<MessageInfo> allThreadMessageInfos() {
        List<n5b.a> r0 = this.threads;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        MessageInfo r3 = toMessageInfo((n5b.a) r2.next());
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    private final void drainPendingRootPlaceholders() {
        if (this.destroyed == false) goto L7;
        this.pendingRootPlaceholders.clear();
        return;
    L7:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L11;
        this.mainHandler.post(new f(this));
        return;
    L11:
        if (getCurrentChat().getValue() != null) goto L13;
        return;
    L13:
        if (getSelfChatterLiveData().getValue() == null) goto L21;
        List r0 = CollectionsKt.toList(this.pendingRootPlaceholders.values());
        this.pendingRootPlaceholders.clear();
        Iterator r1 = r0.iterator();
    L17:
        if (r1.hasNext() == false) goto L22;
        insertRootPlaceholder((Message) r1.next());
        goto L17
    L22:
        return;
    }

    private final ImFileAuthorityChecker getFileAuthorityChecker() {
        return (ImFileAuthorityChecker) this.fileAuthorityChecker$delegate.getValue();
    }

    private final FlowThreadWindowMediaRootStateHandler getMediaRootStateHandler() {
        return (FlowThreadWindowMediaRootStateHandler) this.mediaRootStateHandler$delegate.getValue();
    }

    private final u2b.c getMessageMapper() {
        return (u2b.c) this.messageMapper$delegate.getValue();
    }

    private final EllipsizeFrameLayout.a getTopicMaxHeightFactor() {
        return (EllipsizeFrameLayout.a) this.topicMaxHeightFactor$delegate.getValue();
    }

    private final void publishThreads() {
        List<? extends n5b.a> r0 = CollectionsKt.toList(this.threads);
        this.threadsById.clear();
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        n5b.a r2 = (n5b.a) r1.next();
        ThreadTopic r3 = r2.b;
        if (r3 == null) goto L4;
        String r4 = r3.getId();
        if (r4 == null) goto L4;
        this.threadsById.put(r4, r2);
        goto L4
    L10:
        syncDataStoreSnapshot(r0);
        this.threadList.postValue(r0);
        getMessageList().postValue(toChatMessageVOList(r0));
    }

    private final void registerPushIfNeeded() {
        if (this.pushRegistered == false) goto L5;
        return;
    L5:
        if (getChatId().length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        this.pushRegistered = true;
        c0 r1 = this.pushManager;
        r1.a(new com.ss.android.lark.flow.threadwindow.r(getChatId(), getChatContainer(), this));
        FlowThreadWindowMediaRootStateHandler r2 = getMediaRootStateHandler();
        r2.getClass();
        r1.a(new com.ss.android.lark.flow.threadwindow.o(r2.a, new FlowThreadWindowMediaRootStateHandler$createUploadPushHandler$1(r2), new FlowThreadWindowMediaRootStateHandler$createUploadPushHandler$2(r2)));
        r1.a(new com.ss.android.lark.chat.chatwindow.chat.v2.push.i(getChatContainer().z(), this));
        r1.a(new com.ss.android.lark.chat.chatwindow.chat.v2.push.g(this));
        r1.a(new ChatFileAuthorityPushHandler(getFileAuthorityChecker(), this));
        r1.a(new com.ss.android.lark.chat.chatwindow.chat.v2.push.q(getChatId(), this));
        r1.b();
        return;
    L13:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final boolean canLoadNextPage() {
        if (this.hasMore == true) goto L5;
    L7:
        return false;
    L5:
        if (this.loadingNextPage == true) goto L7;
        return true;
    }

    public final boolean canLoadPrePage() {
        if (this.loadingPrePage == false) goto L5;
        return false;
    L5:
        Chat r0 = (Chat) getCurrentChat().getValue();
        if (r0 != null) goto L8;
        return false;
    L8:
        Integer r2 = this.loadedFirstPosition;
        if (r2 == null) goto L17;
        int r3 = r2.intValue();
        if (r3 <= (r0.getFirstMessagePosition() + 1)) goto L18;
        if (r3 > 0) goto L14;
        return false;
    L14:
        if (r3 == Integer.MAX_VALUE) goto L20;
        return true;
    L20:
        return false;
    L18:
        return false;
    L17:
        return false;
    }

    public void destroy() {
        if (this.destroyed == false) goto L5;
        return;
    L5:
        this.destroyed = true;
        this.mainHandler.removeCallbacksAndMessages(null);
        this.pendingRootPlaceholders.clear();
        this.pushManager.c();
        this.pushRegistered = false;
        this.dataStoreExecutor.shutdown();
    }

    /* JADX INFO: renamed from: getDataStore, reason: collision with other method in class */
    public q3b.m m525getDataStore() {
        return (q3b.m) this.dataStore$delegate.getValue();
    }

    private final void reloadServerChat() {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new q(this));
    }

    public boolean canLoadMore() {
        return canLoadNextPage();
    }

    public boolean canLoadPre() {
        return canLoadPrePage();
    }

    public void onCleared() {
        super/*androidx.lifecycle.ViewModel*/.onCleared();
        destroy();
    }

    public com.ss.android.lark.chatbase.l<f5b.b> stream() {
        return m525getDataStore().N();
    }

    public fxa.b getChatBundle() {
        return this.chatBundle;
    }

    public v getChatContainer() {
        return this.chatContainer;
    }

    public String getChatId() {
        return this.chatId;
    }

    public MutableLiveData<String> getClosePageInfo() {
        return this.closePageInfo;
    }

    public MutableLiveData<Chat> getCurrentChat() {
        return this.currentChat;
    }

    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p getDependency() {
        return this.dependency;
    }

    public MutableLiveData<Pair<String, String>> getDialogInfo() {
        return this.dialogInfo;
    }

    public final MutableLiveData<ErrorResult> getError() {
        return this.error;
    }

    public final MutableLiveData<Boolean> getHasMoreLiveData() {
        return this.hasMoreLiveData;
    }

    public final MutableLiveData<Boolean> getLoading() {
        return this.loading;
    }

    public f0 getMMessageReader() {
        return this.mMessageReader;
    }

    public MutableLiveData<List<y6b.c<?>>> getMessageList() {
        return this.messageList;
    }

    public MutableLiveData<Boolean> getMessageReadable() {
        return this.messageReadable;
    }

    public MutableLiveData<Boolean> getNeedRelocateMessage() {
        return this.needRelocateMessage;
    }

    public MutableLiveData<List<MessageInfo>> getNewMessageItems() {
        return this.newMessageItems;
    }

    public MutableLiveData<List<MessageInfo>> getNewMessageItemsAppend() {
        return this.newMessageItemsAppend;
    }

    public MutableLiveData<ChatChatter> getP2pChatterLiveData() {
        return this.p2pChatterLiveData;
    }

    public MessageListPinExtraLoader getPinExtraLoader() {
        return this.pinExtraLoader;
    }

    public MutableLiveData<ChatChatter> getSelfChatterLiveData() {
        return this.selfChatterLiveData;
    }

    public int getShowPosition() {
        return this.showPosition;
    }

    public final MutableLiveData<List<n5b.a>> getThreadList() {
        return this.threadList;
    }

    public MutableLiveData<String> getToastInfo() {
        return this.toastInfo;
    }

    public s2b.e getUIModel() {
        return this.uiModel;
    }

    public /* bridge */ /* synthetic */ BasePageStore getDataStore() {
        return m525getDataStore();
    }

    public static final /* synthetic */ void access$drainPendingRootPlaceholders(FlowThreadWindowListViewModel r0) {
        r0.drainPendingRootPlaceholders();
    }

    public static final /* synthetic */ x4b.n access$getDataStoreExecutor$p(FlowThreadWindowListViewModel r0) {
        return r0.dataStoreExecutor;
    }

    public static final /* synthetic */ boolean access$getDestroyed$p(FlowThreadWindowListViewModel r0) {
        return r0.destroyed;
    }

    public static final /* synthetic */ boolean access$getEnableMessageFolding$p(FlowThreadWindowListViewModel r0) {
        return r0.enableMessageFolding;
    }

    public static final /* synthetic */ boolean access$getHasMore$p(FlowThreadWindowListViewModel r0) {
        return r0.hasMore;
    }

    public static final /* synthetic */ Integer access$getLoadedFirstPosition$p(FlowThreadWindowListViewModel r0) {
        return r0.loadedFirstPosition;
    }

    public static final /* synthetic */ Integer access$getLoadedLastPosition$p(FlowThreadWindowListViewModel r0) {
        return r0.loadedLastPosition;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(FlowThreadWindowListViewModel r0) {
        return r0.mainHandler;
    }

    public static final /* synthetic */ FlowThreadWindowMediaRootStateHandler access$getMediaRootStateHandler(FlowThreadWindowListViewModel r0) {
        return r0.getMediaRootStateHandler();
    }

    public static final /* synthetic */ LinkedHashMap access$getPendingRootPlaceholders$p(FlowThreadWindowListViewModel r0) {
        return r0.pendingRootPlaceholders;
    }

    public static final /* synthetic */ FlowThreadWindowRepository access$getRepository$p(FlowThreadWindowListViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ List access$getThreads$p(FlowThreadWindowListViewModel r0) {
        return r0.threads;
    }

    public static final /* synthetic */ void access$publishThreads(FlowThreadWindowListViewModel r0) {
        r0.publishThreads();
    }

    public static final /* synthetic */ void access$reloadServerChat(FlowThreadWindowListViewModel r0) {
        r0.reloadServerChat();
    }

    private final boolean addOrReplaceThreadFromPush(n5b.a r8) {
        ThreadTopic r0 = r8.b;
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r2 = r0.getId();
        if (r2 != null) goto L8;
    L39:
        return false;
    L8:
        if (r2.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L39;
        int r4 = findExistingThreadIndex(r0, r8.c);
        if (r8.isNoTraceDelete() == false) goto L28;
        if (r4 < 0) goto L20;
        ListProtector.remove(this.threads, r4);
        publishThreads();
    L20:
        StringBuilder r9 = new StringBuilder("removeThreadFromPush, threadId:");
        r9.append(r2);
        r9.append(", existed:");
        if (r4 < 0) goto L23;
        boolean r5 = true;
    L24:
        r9.append(r5);
        Log.i(TAG, r9.toString());
        if (r4 < 0) goto L40;
        return true;
    L40:
        return false;
    L23:
        r5 = false;
        goto L24
    L28:
        if (r4 < 0) goto L30;
        preserveTranslatingState((n5b.a) ListProtector.get(this.threads, r4), r8);
        ListProtector.set(this.threads, r4, r8);
    L31:
        List<n5b.a> r10 = this.threads;
        if (r10.size() <= 1) goto L34;
        CollectionsKt.sortWith(r10, new c());
    L34:
        publishThreads();
        StringBuilder r11 = new StringBuilder("addOrReplaceThreadFromPush success, threadId:");
        r11.append(r2);
        r11.append(", existed:");
        if (r4 < 0) goto L37;
        r1 = true;
    L37:
        r11.append(r1);
        Log.i(TAG, r11.toString());
        return true;
    L30:
        this.threads.add(r8);
        goto L31
    L10:
        r3 = false;
        goto L11
    }

    private final void applyThreadWindowUIModel(y6b.c<?> r5) {
        String r0 = r5.c;
        BaseTextContentVO r6 = r5.o;
        if ((r6 instanceof BaseTextContentVO) == false) goto L14;
        this.uiModel.b(r0);
        BaseTextContentVO r7 = r6;
        s2b.e.b r1 = (s2b.e.b) ((HashMap) this.uiModel.b).get(r0);
        r7.p = -1;
        EllipsizeFrameLayout.a r2 = getTopicMaxHeightFactor();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r7.s = r2;
        r7.q = this.uiModel.c(r0);
        s2b.e.b r3 = (s2b.e.b) ((HashMap) this.uiModel.b).get(r0);
        if (r3 == null) goto L7;
        boolean r4 = r3.b;
    L8:
        r7.r = r4;
        s2b.e.b r8 = (s2b.e.b) ((HashMap) this.uiModel.b).get(r0);
        if (r8 == null) goto L11;
        Boolean r9 = r8.f;
    L12:
        r7.D = r9;
        return;
    L11:
        r9 = null;
        goto L12
    L7:
        r4 = false;
        goto L8
    L14:
        if ((r6 instanceof LynxCardContentVO) == false) goto L20;
        CardMessageUserLynxRenderSettings r10 = lrb.a.a;
        if (com.ss.android.lark.message.card.b.a().getFgValue("im.message_card.auto_fold") == false) goto L21;
        this.uiModel.b(r0);
        LynxCardContentVO r11 = (LynxCardContentVO) r6;
        EllipsizeFrameLayout.a r12 = getTopicMaxHeightFactor();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.m = r12;
        r11.l = this.uiModel.c(r0);
        return;
    L21:
        return;
    }

    private final int findExistingRootMessageIndex(Message r5) {
        Iterator<n5b.a> r0 = this.threads.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        n5b.a r2 = r0.next();
        getMediaRootStateHandler().getClass();
        if (FlowThreadWindowMediaRootStateHandler.j(r2, r5) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < 0) goto L12;
        return r1;
    L12:
        FlowThreadWindowMediaRootStateHandler r3 = getMediaRootStateHandler();
        int r4 = FlowThreadWindowMediaRootStateHandler.h;
        return r3.c(r5, null);
    L9:
        r1 = -1;
        goto L10
    }

    private final int findRootIndexByLocalId(String r7) {
        Iterator<n5b.a> r0 = this.threads.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L34;
        n5b.a r3 = r0.next();
        Message r4 = r3.c;
        String r5 = null;
        if (r4 == null) goto L8;
        String r6 = r4.getcId();
    L10:
        if (Intrinsics.areEqual(r6, r7) == true) goto L30;
        Message r8 = r3.c;
        if (r8 == null) goto L14;
        String r9 = r8.getId();
    L16:
        if (Intrinsics.areEqual(r9, r7) == true) goto L30;
        ThreadTopic r10 = r3.b;
        if (r10 == null) goto L20;
        String r11 = r10.getId();
    L22:
        if (Intrinsics.areEqual(r11, r7) == true) goto L30;
        ThreadTopic r12 = r3.b;
        if (r12 == null) goto L27;
        r5 = r12.getRootMsgId();
    L27:
        if (Intrinsics.areEqual(r5, r7) == true) goto L30;
        boolean r13 = false;
    L31:
        if (r13 == true) goto L38;
        r2 = r2 + 1;
        goto L4
    L38:
        return r2;
    L20:
        r11 = null;
        goto L22
    L14:
        r9 = null;
    L30:
        r13 = true;
        goto L31
    L8:
        r6 = null;
        goto L10
    L34:
        return -1;
    }

    private final void handleChatChange(Chat r3) {
        if (Intrinsics.areEqual(r3.getId(), getChatId()) == true) goto L5;
        return;
    L5:
        Log.i(TAG, "onPushChat:" + r3);
        this.mainHandler.post(new g(this, r3));
    }

    private final void handleQuitGroup(Chat r2) {
        if (this.dissolveGroupByLocalFlag == false) goto L5;
    L8:
        getClosePageInfo().postValue("");
        return;
    L5:
        if (this.quitGroupBySelf == true) goto L8;
        scheduleQuitGroup(r2);
    }

    private final boolean insertRootPlaceholder(Message r10) {
        Chat r0 = (Chat) getCurrentChat().getValue();
        if (r0 != null) goto L5;
        return false;
    L5:
        ChatChatter r2 = (ChatChatter) getSelfChatterLiveData().getValue();
        if (r2 != null) goto L8;
        return false;
    L8:
        String r3 = r10.getcId();
        if (r3 != null) goto L11;
    L57:
        return true;
    L11:
        if (r3.length() <= 0) goto L13;
        boolean r5 = true;
    L15:
        if (r5 == true) goto L18;
        r3 = null;
    L18:
        if (r3 == null) goto L57;
        List<n5b.a> r6 = this.threads;
        if ((r6 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r7 = r6.iterator();
    L27:
        if (r7.hasNext() == false) goto L24;
        n5b.a r8 = (n5b.a) r7.next();
        ThreadTopic r9 = r8.b;
        if (r9 == null) goto L31;
        String r11 = r9.getId();
    L33:
        if (Intrinsics.areEqual(r11, r3) == true) goto L48;
        Message r12 = r8.c;
        if (r12 == null) goto L37;
        String r13 = r12.getId();
    L39:
        if (Intrinsics.areEqual(r13, r3) == true) goto L48;
        Message r14 = r8.c;
        if (r14 == null) goto L43;
        String r15 = r14.getcId();
    L45:
        if (Intrinsics.areEqual(r15, r3) == true) goto L48;
        boolean r16 = false;
    L49:
        if (r16 == false) goto L27;
        boolean r17 = true;
    L51:
        if (r17 == false) goto L53;
        return true;
    L53:
        int r18 = r0.getLastThreadPosition();
        r10.setThreadPosition(r18);
        r10.setSendStatus(SendStatus.SENDING);
        ThreadTopic r19 = new ThreadTopic();
        r19.setId(r3);
        r19.setPosition(r18);
        r19.setRootMsgId(r3);
        r19.setOwnerId(r2.getId());
        r19.setReplyCount(0);
        r19.setVisible(true);
        List<n5b.a> r1 = this.threads;
        n5b.a r20 = new n5b.a(r2, r19, r10);
        r20.l = r0;
        r20.a = r2;
        r1.add(r20);
        List<n5b.a> r110 = this.threads;
        if (r110.size() <= 1) goto L56;
        CollectionsKt.sortWith(r110, new h());
    L56:
        Log.i(TAG, "insertSendingRootPlaceholder, cId:" + r3 + ", position:" + r18);
        publishThreads();
        goto L57
    L43:
        r15 = null;
        goto L45
    L37:
        r13 = null;
    L48:
        r16 = true;
        goto L49
    L31:
        r11 = null;
    L24:
        r17 = false;
        goto L51
    L23:
        if (r6.isEmpty() == false) goto L25;
    L13:
        r5 = false;
        goto L15
    }

    private final void mergeThreads(List<? extends n5b.a> r6) {
        replaceLocalPreMediaRoots(r6);
        List r7 = CollectionsKt.plus(this.threads, r6);
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        Object r1 = r8.next();
        if (((n5b.a) r1).b == null) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r2 = false;
        goto L9
    L11:
        HashSet r9 = new HashSet();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r0.iterator();
    L13:
        if (r4.hasNext() == false) goto L22;
        Object r5 = r4.next();
        n5b.a r10 = (n5b.a) r5;
        ThreadTopic r11 = r10.b;
        if (r11 == null) goto L18;
        String r12 = r11.getId();
        if (r12 == null) goto L18;
    L20:
        if (r9.add(r12) == false) goto L13;
        r3.add(r5);
    L18:
        r12 = r10.getId();
        goto L20
    L22:
        List r13 = CollectionsKt.sortedWith(r3, new l());
        this.threads.clear();
        this.threads.addAll(r13);
    }

    private final void onFirstPageError(Throwable r3) {
        Log.w(TAG, "loadFirstPage thread failed, chatId:" + getChatId(), r3);
        MutableLiveData<ErrorResult> r0 = this.error;
        if ((r3 instanceof ErrorResult) == false) goto L5;
        ErrorResult r1 = (ErrorResult) r3;
    L6:
        if (r1 != null) goto L11;
        String r4 = r3.getMessage();
        if (r4 != null) goto L10;
        r4 = "load thread window failed";
    L10:
        r1 = new ErrorResult(r4);
    L11:
        r0.postValue(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void readThreads(Collection<String> r7) {
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        Chat r0 = (Chat) getCurrentChat().getValue();
        if (r0 != null) goto L8;
        return;
    L8:
        o0 r1 = getChatContainer().K();
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r7.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        n5b.a r4 = this.threadsById.get((String) r2.next());
        if (r4 == null) goto L10;
        r3.add(r4);
        goto L10
    L15:
        if (r3.isEmpty() == false) goto L18;
        Log.i(TAG, "readThreads skip, no thread info, chat:" + r0.getId() + ", ids:" + r7.size());
        return;
    L18:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new p(r0, r3, r1));
    }

    private final void refreshMessageItem(String r1) {
        publishThreads();
    }

    private final void replaceLocalPreMediaRoots(List<? extends n5b.a> r5) {
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        n5b.a r0 = (n5b.a) r6.next();
        if (r0.b == null) goto L4;
        int r1 = getMediaRootStateHandler().c(r0.c, r0.b);
        if (r1 < 0) goto L4;
        preserveTranslatingState((n5b.a) ListProtector.get(this.threads, r1), r0);
        ListProtector.set(this.threads, r1, r0);
        goto L4
    }

    private final void scheduleQuitGroup(Chat r3) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new s(this, r3));
    }

    private final void syncDataStoreSnapshot(List<? extends n5b.a> r3) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        MessageInfo r1 = toMessageInfo((n5b.a) r4.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        this.dataStoreExecutor.execute(new t(this, r0));
    }

    private final List<y6b.c<?>> toChatMessageVOList(List<? extends n5b.a> r9) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L55;
        n5b.a r1 = (n5b.a) r10.next();
        ThreadTopic r2 = r1.b;
        Object r3 = null;
        if (r2 != null) goto L56;
    L53:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L56:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L43
        MessageInfo r5 = toMessageInfo(r1);     // Catch: Throwable -> L43
        if (r5 != null) goto L11;
        y6b.c<?> r6 = null;
    L39:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L43
    L45:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L49;
        Log.w(TAG, "create ChatMessageVO failed, id:" + r2.getId(), r8);
    L49:
        if (Result.isFailure-impl(r7) == true) goto L52;
        r3 = r7;
    L52:
        r3 = (y6b.c) r3;
        goto L53
    L11:
        Message r11 = r5.getMessage();     // Catch: Throwable -> L43
        int r12 = r11.getBadgeCount();     // Catch: Throwable -> L43
        r11.setBadgeCount(r2.getBadgeCount());     // Catch: Throwable -> L40
        boolean r13 = true;
        r6 = getMessageMapper().d(r5, true);     // Catch: Throwable -> L40
        r11.setBadgeCount(r12);     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L43
        applyThreadWindowUIModel(r6);     // Catch: Throwable -> L43
        String r14 = r2.getId();     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r14, "threadId");     // Catch: Throwable -> L43
        r6.Q1 = r14;     // Catch: Throwable -> L43
        String r15 = r2.getOwnerId();     // Catch: Throwable -> L43
        ChatChatter r16 = (ChatChatter) getSelfChatterLiveData().getValue();     // Catch: Throwable -> L43
        if (r16 == null) goto L16;
        String r17 = r16.getId();     // Catch: Throwable -> L43
    L18:
        if (Intrinsics.areEqual(r15, r17) == true) goto L29;
        String r18 = r2.getAnonymousId();     // Catch: Throwable -> L43
        if (r18 != null) goto L22;
    L25:
        boolean r19 = true;
    L26:
        if (r19 == false) goto L28;
    L30:
        r6.l = r2.getReplyCount();     // Catch: Throwable -> L43
        r6.U2 = true;     // Catch: Throwable -> L43
        ThreadStateInfo r20 = r2.getStateInfo();     // Catch: Throwable -> L43
        if (r20 == null) goto L33;
        ThreadStateInfo.ThreadState r21 = r20.getState();     // Catch: Throwable -> L43
    L35:
        if (r21 == ThreadStateInfo.ThreadState.CLOSED) goto L38;
        r13 = false;
    L38:
        r6.V2 = r13;     // Catch: Throwable -> L43
        r6.W2 = r2.getPosition();     // Catch: Throwable -> L43
        goto L39
    L33:
        r21 = null;
        goto L35
    L28:
        if (Intrinsics.areEqual(r2.getAnonymousId(), r5.getMessage().getFromId()) == false) goto L30;
    L22:
        if (r18.length() == 0) goto L25;
        r19 = false;
    L29:
        r6.i = true;     // Catch: Throwable -> L43
        goto L30
    L16:
        r17 = null;
        goto L18
    L40:
        th = move-exception;
        r11.setBadgeCount(r12);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L55:
        return r0;
    }

    private final MessageInfo toMessageInfo(n5b.a r5) {
        Message r0 = r5.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        ThreadTopic r2 = r5.b;
        if (r2 == null) goto L8;
        r0.putExtra(ThreadTopic.class, r2);
    L8:
        MessageInfo r3 = new MessageInfo(r0, r5.a);
        r3.setReactionInfoList(r5.d);
        r3.setPin(r5.g);
        r3.setOriginalSender(r5.i);
        r3.setRecallUser(r5.o);
        r3.setTranslateInfo(r5.h);
        r3.setNeedToAutoTranslate(r5.j);
        ThreadTopic r1 = r5.b;
        if (r1 == null) goto L11;
        int r4 = r1.getReplyCount();
    L12:
        r3.setReplyInThreadCount(r4);
        r3.setLatestRepliesInThread(r5.e);
        r3.setMyAIThreadInfo(null);
        r3.setForceUpdate(r5.m);
        return r3;
    L11:
        r4 = 0;
        goto L12
    }

    public void batchUpdate(f5b.b r10) {
        Intrinsics.checkNotNullParameter(r10, "needUpdateMessage");
        String r0 = r10.getId();
        String r1 = r10.getcId();
        Iterator<n5b.a> r2 = this.threads.iterator();
        int r4 = 0;
    L3:
        n5b.a r6 = null;
        if (r2.hasNext() == false) goto L31;
        n5b.a r5 = r2.next();
        boolean r8 = true;
        if (Intrinsics.areEqual(r5.getId(), r0) == true) goto L28;
        Message r7 = r5.c;
        if (r7 == null) goto L10;
        String r9 = r7.getId();
    L12:
        if (Intrinsics.areEqual(r9, r0) == true) goto L28;
        if (r1 != null) goto L15;
    L18:
        boolean r11 = true;
    L19:
        if (r11 == true) goto L27;
        Message r12 = r5.c;
        if (r12 == null) goto L23;
        String r13 = r12.getcId();
    L25:
        if (Intrinsics.areEqual(r13, r1) == false) goto L27;
    L23:
        r13 = null;
    L27:
        r8 = false;
        goto L28
    L15:
        if (r1.length() == 0) goto L18;
        r11 = false;
        goto L19
    L10:
        r9 = null;
    L28:
        if (r8 == true) goto L32;
        r4 = r4 + 1;
    L32:
        if (r4 >= 0) goto L35;
        return;
    L35:
        if ((r10 instanceof n5b.a) == false) goto L37;
        r6 = (n5b.a) r10;
    L37:
        if (r6 == null) goto L39;
        ListProtector.set(this.threads, r4, r6);
    L40:
        publishThreads();
        return;
    L39:
        ((n5b.a) ListProtector.get(this.threads, r4)).c = r10.getMessage();
        goto L40
    L31:
        r4 = -1;
        goto L32
    }

    public void batchUpdateMsg(List<? extends hya.c<String, f5b.b>> r12) {
        Intrinsics.checkNotNullParameter(r12, "patchProviderList");
        Iterator<T> r13 = r12.iterator();
        boolean r1 = false;
    L4:
        if (r13.hasNext() == false) goto L50;
        hya.c r2 = (hya.c) r13.next();
        hya.b r3 = r2.b();
        Iterator<n5b.a> r4 = this.threads.iterator();
        int r5 = 0;
    L6:
        n5b.a r7 = null;
        if (r4.hasNext() == false) goto L42;
        n5b.a r6 = r4.next();
        if (Intrinsics.areEqual(r6.getId(), r3.a()) == true) goto L38;
        Message r9 = r6.c;
        if (r9 == null) goto L13;
        String r10 = r9.getId();
    L15:
        if (Intrinsics.areEqual(r10, r3.a()) == true) goto L38;
        Message r11 = r6.c;
        if (r11 == null) goto L19;
        String r14 = r11.getcId();
    L21:
        if (Intrinsics.areEqual(r14, r3.a()) == true) goto L38;
        CharSequence r15 = (CharSequence) r3.b();
        if (r15 != null) goto L25;
    L28:
        boolean r16 = true;
    L29:
        if (r16 == true) goto L37;
        Message r8 = r6.c;
        if (r8 == null) goto L33;
        String r17 = r8.getcId();
    L35:
        if (Intrinsics.areEqual(r17, r3.b()) == false) goto L37;
    L33:
        r17 = null;
    L37:
        boolean r18 = false;
    L39:
        if (r18 == true) goto L43;
        r5 = r5 + 1;
    L43:
        if (r5 < 0) goto L4;
        Object r19 = r2.a().a(ListProtector.get(this.threads, r5));
        if ((r19 instanceof n5b.a) == false) goto L47;
        r7 = (n5b.a) r19;
    L47:
        if (r7 == null) goto L4;
        ListProtector.set(this.threads, r5, r7);
        r1 = true;
        goto L4
    L25:
        if (r15.length() == 0) goto L28;
        r16 = false;
        goto L29
    L19:
        r14 = null;
        goto L21
    L13:
        r10 = null;
    L38:
        r18 = true;
        goto L39
    L42:
        r5 = -1;
        goto L43
    L50:
        if (r1 == false) goto L62;
        publishThreads();
        return;
    }

    public final void bindInitData(i7b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "initData");
        if (this.initDataApplied == false) goto L5;
        return;
    L5:
        this.initDataApplied = true;
        Chat r0 = r3.f;
        if (r0 == null) goto L8;
        getCurrentChat().setValue(r0);
        registerPushIfNeeded();
    L8:
        getSelfChatterLiveData().setValue(r3.h);
        getP2pChatterLiveData().setValue(r3.g);
        drainPendingRootPlaceholders();
    }

    public boolean containsPosition(int r5) {
        List<n5b.a> r0 = this.threads;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L25;
        ThreadTopic r2 = ((n5b.a) r1.next()).b;
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L9;
        return true;
    L13:
        if (r2.getPosition() != r5) goto L15;
        r3 = true;
        goto L16
    L25:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public void deleteUrlPreview(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        MessageInfo r0 = getMessageInfoById(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        final MessageUrlPreview r1 = r0.d(r0);
        if (r1 != null) goto L8;
        return;
    L8:
        String r2 = r1.getMessageId();
        r1.getSequenceId();
        a2b.b r3 = new a2b.b(r2);
        getChatContainer().P().ba(r3, new AnonymousClass1(r1, this, r5));
    }

    public void ensureLastPageDataLoaded(final IGetDataCallback<Integer> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Chat r0 = (Chat) getCurrentChat().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        final int r1 = r0.getLastThreadPosition();
        if (this.loadedLastPosition != null) goto L8;
        return;
    L8:
        if (containsPosition(r1) == true) goto L13;
        loadSpecialPage(r1, new C03621(this, r1, r3));
        return;
    }

    public void executeMessage(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        this.dataStoreExecutor.execute(r2);
    }

    public MessageInfo getDataOnPosition(int r6) {
        Iterator<T> r0 = this.threads.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Object r1 = r0.next();
        ThreadTopic r3 = ((n5b.a) r1).b;
        boolean r4 = false;
        if (r3 == null) goto L10;
        if (r3.getPosition() != r6) goto L10;
        r4 = true;
    L10:
        if (r4 == false) goto L4;
    L13:
        n5b.a r2 = (n5b.a) r1;
        if (r2 != null) goto L16;
        return null;
    L16:
        return toMessageInfo(r2);
    L12:
        r1 = null;
        goto L13
    }

    public MessageInfo getMessageInfoById(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        n5b.a r0 = this.threadsById.get(r5);
        if (r0 != null) goto L16;
        Iterator<T> r1 = this.threads.iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        Message r3 = ((n5b.a) r2).c;
        if (r3 == null) goto L10;
        String r4 = r3.getId();
    L12:
        if (Intrinsics.areEqual(r4, r5) == false) goto L6;
    L15:
        r0 = (n5b.a) r2;
        goto L16
    L10:
        r4 = null;
        goto L12
    L14:
        r2 = null;
    L16:
        if (r0 != null) goto L18;
        return null;
    L18:
        return toMessageInfo(r0);
    }

    public List<MessageInfo> getMessageInfoByIds(Collection<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "msgIds");
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        MessageInfo r1 = getMessageInfoById((String) r4.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    @Override // com.ss.android.lark.flow.threadwindow.j
    public void insertSendingRootPlaceholder(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "preMessage");
        if (this.destroyed == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L9;
        this.mainHandler.post(new i(this, r3));
        return;
    L9:
        String r0 = r3.getcId();
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.length() <= 0) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L18;
        r0 = null;
    L18:
        if (r0 != null) goto L21;
        return;
    L21:
        if (insertRootPlaceholder(r3) == false) goto L23;
        return;
    L23:
        if (this.pendingRootPlaceholders.containsKey(r0) == true) goto L28;
        this.pendingRootPlaceholders.put(r0, r3);
        return;
    L28:
        return;
    L14:
        r1 = false;
        goto L15
    }

    public void loadFirstPage(boolean r8) {
        if (getChatId().length() != 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L9;
        Log.w(TAG, "loadFirstPage failed, chatId is empty");
        this.error.postValue(new ErrorResult("open thread window failed, chatId is empty"));
        return;
    L9:
        this.loading.postValue(Boolean.TRUE);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03631(this, null), 3, null);
        return;
    L5:
        r9 = false;
        goto L6
    }

    public final void loadNextPage(Function1<? super Result<Unit>, Unit> r9) {
        if (getChatId().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L12:
        if (r9 == null) goto L15;
        Result.Companion r1 = Result.Companion;
        r9.invoke(Result.box-impl(Result.constructor-impl(Unit.INSTANCE)));
        return;
    L15:
        return;
    L8:
        if (canLoadNextPage() == false) goto L12;
        this.loadingNextPage = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03641(this, r9, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void loadPrePage(Function1<? super Result<Unit>, Unit> r9) {
        if (getChatId().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L12:
        if (r9 == null) goto L15;
        Result.Companion r1 = Result.Companion;
        r9.invoke(Result.box-impl(Result.constructor-impl(Unit.INSTANCE)));
        return;
    L15:
        return;
    L8:
        if (canLoadPrePage() == false) goto L12;
        this.loadingPrePage = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03651(this, r9, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.flow.threadwindow.j
    public void markRootSendFailed(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "preMessage");
        getMediaRootStateHandler().g(r2);
    }

    @Override // com.ss.android.lark.flow.threadwindow.t
    public void onPushChat(Chat r3) {
        Intrinsics.checkNotNullParameter(r3, "chat");
        if (Intrinsics.areEqual(r3.getId(), getChatId()) == true) goto L5;
        return;
    L5:
        handleChatChange(r3);
        if (r3.isDissolved() == false) goto L9;
        handleQuitGroup(r3);
        return;
    }

    @Override // com.ss.android.lark.flow.threadwindow.t
    public void onPushChatRemoveMe(Chat r3) {
        Intrinsics.checkNotNullParameter(r3, "chat");
        if (Intrinsics.areEqual(r3.getId(), getChatId()) == true) goto L5;
        return;
    L5:
        handleChatChange(r3);
        handleQuitGroup(r3);
    }

    public void onPushFileAuthority(final Map<String, ValidateIMFileResult> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC03681(this, r3));
    }

    @Override // com.ss.android.lark.flow.threadwindow.t
    public void onPushRootMessage(MessageInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "messageInfo");
        Message r0 = r6.getMessage();
        String r1 = r0.getId();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L27;
        int r3 = findExistingRootMessageIndex(r0);
        if (r3 >= 0) goto L17;
        Log.i(TAG, "patchRootMessageFromPush skip, not in current page, messageId:".concat(r1));
        return;
    L17:
        n5b.a r4 = (n5b.a) ListProtector.get(this.threads, r3);
        r4.c = r0;
        ChatChatter r5 = r6.getMessageSender();
        if (r5 == null) goto L20;
        r4.a = r5;
    L20:
        r4.d = r6.getReactionInfoList();
        r4.g = r6.getPin();
        r4.h = r6.getTranslateInfo();
        r4.i = r6.getOriginalSender();
        r4.o = r6.getRecallUser();
        if (((n5b.a) ListProtector.get(this.threads, r3)).isNoTraceDelete() == false) goto L24;
        ListProtector.remove(this.threads, r3);
        publishThreads();
        Log.i(TAG, "removeRootMessageFromPush, messageId:".concat(r1));
        return;
    L24:
        publishThreads();
        Log.i(TAG, "patchRootMessageFromPush success, messageId:".concat(r1));
        return;
    L27:
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.ss.android.lark.flow.threadwindow.t
    public void onPushRootThread(g1 r10) {
        Intrinsics.checkNotNullParameter(r10, "pushMessageDTO");
        MessageInfo r0 = r10.a;
        Message r1 = r0.getMessage();
        ThreadTopic r2 = r10.c;
        if (r2 != null) goto L5;
        return;
    L5:
        String r3 = r2.getId();
        if (r3 == null) goto L44;
        boolean r5 = false;
        if (r3.length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L45;
        ChatChatter r6 = r0.getMessageSender();
        if (r6 != null) goto L21;
        r6 = (ChatChatter) getSelfChatterLiveData().getValue();
        if (r6 != null) goto L21;
        return;
    L21:
        int r7 = findExistingThreadIndex(r2, r1);
        if (r7 >= 0) goto L24;
        r5 = true;
    L24:
        n5b.a r8 = new n5b.a(r6, r2, r1);
        r8.d = r0.getReactionInfoList();
        r8.g = r0.getPin();
        r8.h = r0.getTranslateInfo();
        r8.e = r10.d;
        r8.f = r10.e;
        Chat r11 = r10.b;
        if (r11 != null) goto L27;
        r11 = (Chat) getCurrentChat().getValue();
    L27:
        r8.l = r11;
        r8.i = r0.getOriginalSender();
        r8.o = r0.getRecallUser();
        if (r8.isNoTraceDelete() == false) goto L33;
        if (r7 < 0) goto L31;
        ListProtector.remove(this.threads, r7);
        publishThreads();
    L31:
        Log.i(TAG, "removeRootThreadFromPush, threadId:" + r3 + ", isNew:" + r5);
        return;
    L33:
        if (r7 < 0) goto L35;
        ListProtector.set(this.threads, r7, r8);
    L36:
        List<n5b.a> r12 = this.threads;
        if (r12.size() <= 1) goto L39;
        CollectionsKt.sortWith(r12, new m());
    L39:
        publishThreads();
        if (r5 == false) goto L42;
        CoreThreadPool.getDefault().getUIExecutor().execute(new n(this, r0));
    L42:
        Log.i(TAG, "addOrReplaceRootThreadFromPush, threadId:" + r3 + ", isNew:" + r5);
        return;
    L35:
        this.threads.add(r8);
        goto L36
    L45:
        return;
    L10:
        r4 = false;
        goto L11
    }

    public void onPushSignUrlPreview(final List<UrlPreViewEntries> r4) {
        Intrinsics.checkNotNullParameter(r4, "entriesList");
        Chat r0 = (Chat) getCurrentChat().getValue();
        if (r0 == null) goto L5;
        Chat.Type r1 = r0.getType();
    L7:
        if (r1 != Chat.Type.P2P) goto L9;
        return;
    L9:
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r4.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        String r5 = ((UrlPreViewEntries) r3.next()).getSourceId();
        if (r5 == null) goto L11;
        r2.add(r5);
        goto L11
    L15:
        final Set r6 = CollectionsKt.toSet(r2);
        if (r6.isEmpty() == false) goto L18;
        return;
    L18:
        CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC03701(this, r4, r6));
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.ss.android.lark.flow.threadwindow.t
    public void onPushThreadReactions(PushMessageReactions r5) {
        Intrinsics.checkNotNullParameter(r5, "reactions");
        String r0 = r5.chat_id;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0, getChatId()) == true) goto L8;
        return;
    L8:
        Map r1 = r5.msg_id2reactions;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.isEmpty() == false) goto L14;
        return;
    L14:
        CoreThreadPool.getBackgroundHandler().post(new o(r1, r0, r5, this));
    }

    @Override // com.ss.android.lark.flow.threadwindow.t
    public void onPushThreadReply(g1 r6) {
        Intrinsics.checkNotNullParameter(r6, "pushMessageDTO");
        ThreadTopic r0 = r6.c;
        if (r0 != null) goto L5;
        return;
    L5:
        Message r1 = r6.a.getMessage();
        if (Intrinsics.areEqual(r1.getChatId(), getChatId()) == true) goto L8;
        return;
    L8:
        if (com.ss.android.lark.flow.threadwindow.s.a(r0, r1.getId()) == true) goto L13;
        patchThreadRepliesFromPush(r0, r6.d, r6.e, "message:" + r1.getId());
        return;
    }

    @Override // com.ss.android.lark.flow.threadwindow.t
    public void onPushThreadTopic(ThreadTopic r5) {
        Intrinsics.checkNotNullParameter(r5, "threadTopic");
        String r0 = r5.getId();
        if (r0 == null) goto L33;
        int r2 = 0;
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L34;
        Iterator<n5b.a> r3 = this.threads.iterator();
    L15:
        if (r3.hasNext() == false) goto L20;
        if (matchesThreadTopic(r3.next(), r5) == true) goto L22;
        r2 = r2 + 1;
    L22:
        if (r2 >= 0) goto L25;
        Log.i(TAG, "patchThreadTopicFromPush skip, not in current page, threadId:".concat(r0));
        return;
    L25:
        ((n5b.a) ListProtector.get(this.threads, r2)).b = r5;
        if (((n5b.a) ListProtector.get(this.threads, r2)).isNoTraceDelete() == false) goto L29;
        ListProtector.remove(this.threads, r2);
        Log.i(TAG, "removeThreadTopicFromPush, threadId:".concat(r0));
        publishThreads();
        return;
    L29:
        Log.i(TAG, "patchThreadTopicFromPush success, threadId:".concat(r0));
        publishThreads();
        return;
    L20:
        r2 = -1;
        goto L22
    L34:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void onQuitGroup(boolean r3) {
        Log.i(TAG, "event Quit Group: " + r3);
        this.quitGroupBySelf = r3;
    }

    @Override // com.ss.android.lark.flow.threadwindow.t
    public void onThreadRepliesUpdate(n5b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "threadInfo");
        addOrReplaceThreadFromPush(r2);
    }

    public void retrySendMessage(final String r12) {
        Intrinsics.checkNotNullParameter(r12, "preMsgId");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.mainHandler.post(new r(this, r12));
        return;
    L6:
        boolean r1 = false;
        if (r12.length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r12 = null;
    L13:
        if (r12 != null) goto L15;
        return;
    L15:
        final int r2 = findRootIndexByLocalId(r12);
        if (r2 >= 0) goto L19;
        Log.w(TAG, "retrySendMessage skip, not in current page, id:".concat(r12));
        return;
    L19:
        final Message r4 = ((n5b.a) ListProtector.get(this.threads, r2)).c;
        if (r4 != null) goto L22;
        return;
    L22:
        FlowThreadWindowMediaRootStateHandler r5 = getMediaRootStateHandler();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, INotificationHitPoint.NoticeType.MESSAGE);
        Message.Type r7 = r4.getType();
        Message.Type r8 = Message.Type.MEDIA;
        if (r7 != r8) goto L41;
        MediaContent r9 = r4.getContent();
        if (r9 == null) goto L41;
        String r10 = r9.getOriginPath();
        if (r10 != null) goto L32;
        r10 = "";
    L32:
        if (r10.length() != 0) goto L34;
        boolean r11 = true;
    L35:
        if (r11 == true) goto L41;
        if (com.suite.lark.component.storage.ext.b.b(com.ss.android.lark.im.base.a.b().z(r10)) == true) goto L40;
        r5.e.postValue(UIHelper.getString(2131892310));
    L42:
        if (r1 == true) goto L44;
        return;
    L44:
        r4.setUpdateTime(com.larksuite.framework.utils.e.e());
        r4.setSendStatus(SendStatus.SENDING);
        publishThreads();
        Log.i(TAG, "retrySendMessage, id:".concat(r12));
        com.ss.android.lark.im.sdk.service.p r3 = ImSdkService.f();
        FlowThreadWindowMediaRootStateHandler r6 = getMediaRootStateHandler();
        IGetDataCallback<String> r13 = new C03722(r12, this, r2, r4);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (r4.getType() != r8) goto L47;
        r13 = new RetryMediaMessageCallback(r13, new FlowThreadWindowMediaRootStateHandler$wrapRetryMessageCallback$1(r6));
    L47:
        r3.X3(r4, r13);
        return;
    L40:
        r9.setFileState(FileState.COMPRESSING);
        goto L41
    L34:
        r11 = false;
    L41:
        r1 = true;
        goto L42
    L9:
        r0 = false;
        goto L10
    }

    public void setPinExtraLoader(MessageListPinExtraLoader r1) {
        this.pinExtraLoader = r1;
    }

    public void updateDissolveGroupLocalFlag(boolean r1) {
        this.dissolveGroupByLocalFlag = r1;
    }

    public void updatePreviewByMessageId(String r7) {
        Intrinsics.checkNotNullParameter(r7, "msgId");
        Iterator<T> r0 = this.threads.iterator();
    L3:
        Object r3 = null;
        if (r0.hasNext() == false) goto L17;
        Object r1 = r0.next();
        n5b.a r4 = (n5b.a) r1;
        if (Intrinsics.areEqual(r4.getId(), r7) == true) goto L14;
        Message r5 = r4.c;
        if (r5 == null) goto L11;
        r3 = r5.getId();
    L11:
        if (Intrinsics.areEqual(r3, r7) == true) goto L14;
        boolean r6 = false;
    L15:
        if (r6 == false) goto L3;
        r3 = r1;
    L14:
        r6 = true;
    L17:
        n5b.a r8 = (n5b.a) r3;
        if (r8 != null) goto L20;
        return;
    L20:
        r8.m = true;
        publishThreads();
    }

    public void loadNextPage(final IGetDataCallback<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        loadNextPage(new AnonymousClass2(r2));
    }

    public void loadPrePage(final IGetDataCallback<Unit> r2) {
        loadPrePage(new C03662(r2));
    }

    public static final /* synthetic */ void access$mergeThreads(FlowThreadWindowListViewModel r0, List r1) {
        r0.mergeThreads(r1);
    }

    public static final /* synthetic */ void access$onFirstPageError(FlowThreadWindowListViewModel r0, Throwable r1) {
        r0.onFirstPageError(r1);
    }

    public static final /* synthetic */ void access$refreshMessageItem(FlowThreadWindowListViewModel r0, String r1) {
        r0.refreshMessageItem(r1);
    }

    public static final /* synthetic */ void access$setHasMore$p(FlowThreadWindowListViewModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setLoadingNextPage$p(FlowThreadWindowListViewModel r0, boolean r1) {
        r0.loadingNextPage = r1;
    }

    public static final /* synthetic */ void access$setLoadingPrePage$p(FlowThreadWindowListViewModel r0, boolean r1) {
        r0.loadingPrePage = r1;
    }

    private final int findExistingThreadIndex(ThreadTopic r9, Message r10) {
        if (r10 == null) goto L12;
        String r3 = r10.getId();
        if (r3 == null) goto L12;
        if (r3.length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L13:
        Iterator<n5b.a> r5 = this.threads.iterator();
        int r6 = 0;
    L15:
        if (r5.hasNext() == false) goto L34;
        n5b.a r7 = r5.next();
        if (matchesThreadTopic(r7, r9) == true) goto L30;
        if (r3 == null) goto L25;
        Message r8 = r7.c;
        if (r8 == null) goto L22;
        String r11 = r8.getId();
    L24:
        if (Intrinsics.areEqual(r11, r3) == true) goto L30;
    L22:
        r11 = null;
    L25:
        if (r10 == null) goto L29;
        getMediaRootStateHandler().getClass();
        if (FlowThreadWindowMediaRootStateHandler.j(r7, r10) == true) goto L30;
    L29:
        boolean r12 = false;
    L31:
        if (r12 == true) goto L35;
        r6 = r6 + 1;
    L35:
        if (r6 < 0) goto L38;
        return r6;
    L38:
        return getMediaRootStateHandler().c(r10, r9);
    L30:
        r12 = true;
        goto L31
    L34:
        r6 = -1;
        goto L35
    L9:
        r4 = false;
    L12:
        r3 = null;
        goto L13
    }

    private final boolean matchesThreadTopic(n5b.a r7, ThreadTopic r8) {
        String r0 = r8.getId();
        String r3 = null;
        if (r0 != null) goto L5;
    L10:
        r0 = null;
    L11:
        String r9 = r8.getRootMsgId();
        if (r9 != null) goto L14;
    L19:
        r9 = null;
    L20:
        if (r0 == null) goto L28;
        ThreadTopic r4 = r7.b;
        if (r4 == null) goto L24;
        String r5 = r4.getId();
    L26:
        if (Intrinsics.areEqual(r5, r0) == false) goto L28;
        boolean r6 = true;
    L29:
        if (r9 == null) goto L43;
        ThreadTopic r10 = r7.b;
        if (r10 == null) goto L33;
        String r11 = r10.getRootMsgId();
    L35:
        if (Intrinsics.areEqual(r11, r9) == true) goto L42;
        Message r12 = r7.c;
        if (r12 == null) goto L39;
        String r13 = r12.getId();
    L41:
        if (Intrinsics.areEqual(r13, r9) == false) goto L43;
    L39:
        r13 = null;
    L42:
        boolean r14 = true;
    L44:
        if (r9 != null) goto L52;
        if (r0 == null) goto L52;
        Message r15 = r7.c;
        if (r15 == null) goto L50;
        r3 = r15.getId();
    L50:
        if (Intrinsics.areEqual(r3, r0) == false) goto L52;
        boolean r16 = true;
    L53:
        if (r6 == true) goto L59;
        if (r14 == true) goto L60;
        if (r16 == true) goto L61;
        return false;
    L61:
        return true;
    L60:
        return true;
    L59:
        return true;
    L52:
        r16 = false;
        goto L53
    L33:
        r11 = null;
    L43:
        r14 = false;
        goto L44
    L24:
        r5 = null;
    L28:
        r6 = false;
        goto L29
    L14:
        if (r9.length() <= 0) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == false) goto L19;
    L16:
        r17 = false;
        goto L17
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r18 = true;
    L8:
        if (r18 == false) goto L10;
    L7:
        r18 = false;
        goto L8
    }

    private final boolean patchLoadedThreads(Function1<? super n5b.a, Boolean> r6, Function1<? super f5b.b, ? extends f5b.b> r7) {
        IntIterator r0 = CollectionsKt.getIndices(this.threads).iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L14;
        int r2 = r0.nextInt();
        n5b.a r3 = (n5b.a) ListProtector.get(this.threads, r2);
        if (((Boolean) r6.invoke(r3)).booleanValue() == false) goto L4;
        Object r4 = r7.invoke(r3);
        if ((r4 instanceof n5b.a) == false) goto L10;
        n5b.a r5 = (n5b.a) r4;
    L11:
        if (r5 == null) goto L4;
        ListProtector.set(this.threads, r2, r5);
        r1 = true;
        goto L4
    L10:
        r5 = null;
        goto L11
    L14:
        if (r1 == false) goto L16;
        publishThreads();
    L16:
        return r1;
    }

    private final void preserveTranslatingState(n5b.a r2, n5b.a r3) {
        if (r3.h == null) goto L6;
        r3.setIsTranslating(false);
        return;
    L6:
        if (r3.isTranslatingInited() == true) goto L10;
        r3.setIsTranslating(r2.isTranslating());
        return;
    }

    private final void updateLoadedRange(List<? extends n5b.a> r3, boolean r4) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        ThreadTopic r1 = ((n5b.a) r5.next()).b;
        if (r1 == null) goto L8;
        Integer r2 = Integer.valueOf(r1.getPosition());
    L9:
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r2 = null;
        goto L9
    L11:
        if (r4 == false) goto L14;
        this.loadedFirstPosition = (Integer) CollectionsKt.minOrNull(r0);
        this.loadedLastPosition = (Integer) CollectionsKt.maxOrNull(r0);
        return;
    L14:
        Integer r6 = (Integer) CollectionsKt.minOrNull(r0);
        if (r6 == null) goto L21;
        int r7 = r6.intValue();
        Integer r8 = this.loadedFirstPosition;
        if (r8 == null) goto L19;
        int r9 = r8.intValue();
    L20:
        this.loadedFirstPosition = Integer.valueOf(Math.min(r9, r7));
        goto L21
    L19:
        r9 = r7;
    L21:
        Integer r10 = (Integer) CollectionsKt.maxOrNull(r0);
        if (r10 == null) goto L34;
        int r11 = r10.intValue();
        Integer r12 = this.loadedLastPosition;
        if (r12 == null) goto L26;
        int r13 = r12.intValue();
    L27:
        this.loadedLastPosition = Integer.valueOf(Math.max(r13, r11));
        return;
    L26:
        r13 = r11;
        goto L27
    }

    public void cancelUploadMediaMsg(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "cId");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L7;
        this.mainHandler.post(new d(this, r4, r5));
        return;
    L7:
        if (r4.length() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r4 = null;
    L13:
        if (r4 != null) goto L15;
        return;
    L15:
        int r7 = findRootIndexByLocalId(r4);
        if (r7 >= 0) goto L19;
        Log.w(TAG, "cancelUploadMediaMsg skip, not in current page, cId:".concat(r4));
        return;
    L19:
        Message r8 = ((n5b.a) ListProtector.get(this.threads, r7)).c;
        if (r8 != null) goto L22;
        return;
    L22:
        r8.setUpdateTime(com.larksuite.framework.utils.e.e());
        r8.setSendStatus(SendStatus.FAIL);
        MediaContent r9 = r8.getContent();
        if (r9 == null) goto L25;
        r9.setProgress(0);
        r9.setFileState(FileState.PAUSE);
    L25:
        publishThreads();
        ImSdkService.f().mb(r4);
        return;
    L9:
        r6 = false;
        goto L10
    }

    public void checkToClearDataStore(final int r3, IMessageListComponent.c r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (CollectionsKt.removeAll(this.threads, new FlowThreadWindowListViewModel$checkToClearDataStore$removed$1(r3)) == true) goto L5;
        return;
    L5:
        publishThreads();
        r4.a();
        Log.i(TAG, "checkToClearDataStore, firstPosition:" + r3);
    }

    public void handleCollapsingUrlPreview(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        this.uiModel.g(r2, r3);
    }

    public void loadSpecialPage(int r7, IGetDataCallback<Unit> r8) {
        if (getChatId().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if (r8 == null) goto L17;
        r8.onError(new ErrorResult("load special page failed, chatId is empty"));
        return;
    L17:
        return;
    L11:
        if (containsPosition(r7) == false) goto L15;
        if (r8 == null) goto L18;
        r8.onSuccess(Unit.INSTANCE);
        return;
    L18:
        return;
    L15:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03671(this, r7, r8, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public Object loadSpecialPosition(int r1, Continuation<? super MessageInfo> r2) {
        return getDataOnPosition(r1);
    }

    @Override // com.ss.android.lark.flow.threadwindow.j
    public void markRootSendSuccess(Message r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "preMessage");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        getMediaRootStateHandler().h(r2, r3);
    }

    @Override // com.ss.android.lark.flow.threadwindow.t
    public void onPushChatRemoveChatters(Chat r3, Map<String, ? extends Chatter> r4) {
        Intrinsics.checkNotNullParameter(r3, "chat");
        Intrinsics.checkNotNullParameter(r4, "chatterMap");
        if (Intrinsics.areEqual(r3.getId(), getChatId()) == true) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L18;
        String r0 = getChatContainer().getUserId();
        if (r0 != null) goto L11;
        r0 = "";
    L11:
        if (r4.containsKey(r0) == false) goto L13;
    L14:
        handleChatChange(r3);
        handleQuitGroup(r3);
        return;
    L13:
        if (r4.containsKey(r3.getAnonymousId()) == true) goto L14;
        return;
    }

    public void onPushPreview(final Map<String, ? extends Map<String, UrlCardPreviewEntity>> r4, final Map<String, ? extends Map<String, MessageLink>> r5) {
        if (r4 == null) goto L4;
        final Set<String> r0 = r4.keySet();
    L5:
        if (r0 != null) goto L8;
        r0 = SetsKt.emptySet();
    L8:
        if (r0.isEmpty() == false) goto L10;
        return;
    L10:
        CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC03691(this, r4, r5, r0));
        return;
    L4:
        r0 = null;
        goto L5
    }

    public void onPushUploadProgress(final String r3, final int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L15;
        CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC03711(this, r3, r4));
        return;
    L15:
        return;
    L6:
        r0 = false;
        goto L7
    }

    public void readMessage(List<? extends y6b.a<?>> r7, Context r8) {
        Intrinsics.checkNotNullParameter(r7, "intervalMessages");
        Intrinsics.checkNotNullParameter(r8, "context");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedHashSet r9 = new LinkedHashSet();
        Iterator<T> r10 = r7.iterator();
    L7:
        if (r10.hasNext() == false) goto L30;
        y6b.a r0 = (y6b.a) r10.next();
        String r1 = r0.M();
        boolean r2 = true;
        String r4 = null;
        if (r1 != null) goto L11;
    L20:
        String r3 = r0.getId();
        if (r3 != null) goto L23;
    L28:
        if (r4 == null) goto L7;
        r9.add(r4);
        goto L7
    L23:
        if (r3.length() > 0) goto L26;
        r2 = false;
    L26:
        if (r2 == false) goto L28;
        r4 = r3;
        goto L28
    L11:
        if (r1.length() <= 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L17;
        r1 = null;
    L17:
        if (r1 == null) goto L20;
        r4 = r1;
        goto L28
    L13:
        r5 = false;
        goto L14
    L30:
        readThreads(r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateMsg(hya.b<String> r10, hya.a<f5b.b> r11) {
        Intrinsics.checkNotNullParameter(r10, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r11, "updater");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.mainHandler.post(new u(this, r10, r11));
        return;
    L6:
        String[] r0 = new String[2];
        Object r1 = r10.a();
        String r2 = (String) r1;
        Intrinsics.checkNotNull(r2);
        if (r2.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        SendStatus r5 = null;
        if (r3 == true) goto L14;
        r1 = null;
    L14:
        r0[0] = r1;
        String r12 = (String) r10.b();
        if (r12 != null) goto L17;
    L22:
        r12 = null;
    L23:
        r0[1] = r12;
        List r13 = CollectionsKt.listOfNotNull(r0);
        if (r13.isEmpty() == false) goto L26;
        return;
    L26:
        Iterator<n5b.a> r4 = this.threads.iterator();
        int r6 = 0;
    L28:
        if (r4.hasNext() == false) goto L44;
        n5b.a r7 = r4.next();
        List r8 = r13;
        if ((r8 instanceof Collection) == true) goto L32;
    L34:
        Iterator r9 = r8.iterator();
    L36:
        if (r9.hasNext() == false) goto L40;
        String r14 = (String) r9.next();
        getMediaRootStateHandler().getClass();
        if (FlowThreadWindowMediaRootStateHandler.i(r7, r14) == false) goto L36;
        boolean r15 = true;
    L41:
        if (r15 == true) goto L46;
        r6 = r6 + 1;
    L46:
        if (r6 >= 0) goto L49;
        Log.i(TAG, "updateMsg skip, not in current page, keys:" + r13);
        return;
    L49:
        n5b.a r16 = (n5b.a) ListProtector.get(this.threads, r6);
        MessageInfo r17 = toMessageInfo(r16);
        if (r17 != null) goto L52;
        return;
    L52:
        f5b.b r18 = (f5b.b) r11.a(r17);
        if (r18 == null) goto L57;
        Message r19 = r18.getMessage();
        if (r19 == null) goto L57;
        r16.c = r19;
    L57:
        StringBuilder r110 = new StringBuilder("updateMsg success, keys:");
        r110.append(r13);
        r110.append(", status:");
        Message r111 = r16.c;
        if (r111 == null) goto L60;
        r5 = r111.getSendStatus();
    L60:
        r110.append(r5);
        Log.i(TAG, r110.toString());
        publishThreads();
        return;
    L40:
        r15 = false;
        goto L41
    L32:
        if (r8.isEmpty() == false) goto L34;
    L44:
        r6 = -1;
        goto L46
    L17:
        if (r12.length() <= 0) goto L19;
        boolean r20 = true;
    L20:
        if (r20 == false) goto L22;
    L19:
        r20 = false;
        goto L20
    L9:
        r3 = false;
        goto L10
    }

    public FlowThreadWindowListViewModel(fxa.b r3, v r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "chatBundle");
        Intrinsics.checkNotNullParameter(r4, "chatContainer");
        this.chatBundle = r3;
        this.chatContainer = r4;
        this.enableMessageFolding = r5;
        ChatBundle r6 = getChatBundle();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.ss.android.lark.biz.im.api.bundle.ChatBundle");
        this.repository = new FlowThreadWindowRepository(r6, getChatContainer());
        this.threads = new ArrayList();
        this.threadsById = new LinkedHashMap();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.pendingRootPlaceholders = new LinkedHashMap();
        LazyThreadSafetyMode r7 = LazyThreadSafetyMode.NONE;
        this.messageMapper$delegate = LazyKt.lazy(r7, new FlowThreadWindowListViewModel$messageMapper$2(this));
        this.fileAuthorityChecker$delegate = LazyKt.lazy(r7, FlowThreadWindowListViewModel$fileAuthorityChecker$2.INSTANCE);
        this.mediaRootStateHandler$delegate = LazyKt.lazy(r7, new FlowThreadWindowListViewModel$mediaRootStateHandler$2(this));
        this.pushManager = new c0();
        String r8 = getChatBundle().getChatId();
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        this.chatId = r8;
        this.showPosition = getChatBundle().o();
        this.messageList = new MutableLiveData();
        this.currentChat = new MutableLiveData();
        this.selfChatterLiveData = new MutableLiveData();
        this.p2pChatterLiveData = new MutableLiveData();
        this.toastInfo = new MutableLiveData();
        this.dialogInfo = new MutableLiveData();
        this.closePageInfo = new MutableLiveData();
        this.newMessageItems = new MutableLiveData();
        this.newMessageItemsAppend = new MutableLiveData();
        this.needRelocateMessage = new MutableLiveData();
        Boolean r9 = Boolean.TRUE;
        this.messageReadable = new MutableLiveData(r9);
        this.threadList = new MutableLiveData(null);
        this.loading = new MutableLiveData(Boolean.FALSE);
        this.hasMoreLiveData = new MutableLiveData(r9);
        this.error = new MutableLiveData();
        this.hasMore = true;
        s2b.e r10 = new s2b.e();
        this.uiModel = r10;
        this.dataStoreExecutor = new x4b.n(CoreThreadPool.getDefault().getSingleScheduledThreadPool("flow-thread-window"));
        this.topicMaxHeightFactor$delegate = LazyKt.lazy(r7, FlowThreadWindowListViewModel$topicMaxHeightFactor$2.INSTANCE);
        r10.c = new a(this);
        this.dataStore$delegate = LazyKt.lazy(new FlowThreadWindowListViewModel$dataStore$2(this));
        this.mMessageReader = new j();
        this.dependency = new e(this);
    }

    public static final /* synthetic */ boolean access$patchLoadedThreads(FlowThreadWindowListViewModel r0, Function1 r1, Function1 r2) {
        return r0.patchLoadedThreads(r1, r2);
    }

    public static final /* synthetic */ void access$updateLoadedRange(FlowThreadWindowListViewModel r0, List r1, boolean r2) {
        r0.updateLoadedRange(r1, r2);
    }

    private final void markRetryRootSendSuccess(int r3, Message r4, String r5) {
        if (this.destroyed == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L9;
        this.mainHandler.post(new k(this, r3, r4, r5));
        return;
    L9:
        n5b.a r6 = (n5b.a) CollectionsKt.getOrNull(this.threads, r3);
        if (r6 == null) goto L15;
        Message r7 = r6.c;
        if (r7 == null) goto L15;
        r4 = r7;
    L15:
        markRootSendSuccess(r4, r5);
    }

    public void checkChatterInChat(String r2, ArrayList<String> r3, IGetDataCallback<List<String>> r4) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "chatterIds");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.onSuccess(new ArrayList());
    }

    public void onCheckMembersInChat(String r1, List<GroupRecallEntity> r2, IGetDataCallback<List<GroupRecallEntity>> r3) {
        if (r3 == null) goto L5;
        r3.onSuccess(CollectionsKt.emptyList());
        return;
    }

    public void sendSignRequest(String r3, String r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "description");
        Intrinsics.checkNotNullParameter(r4, "sourceId");
        UserStatusParseUrlPreViewUtils.b r6 = new UserStatusParseUrlPreViewUtils.b(r3, r4, new String(w28.a.a(x28.a.a(r3))), null);
        UserStatusParseUrlPreViewUtils.b(getChatContainer().P(), CollectionsKt.listOf(r6), new C03731(this));
    }

    public static final /* synthetic */ void access$markRetryRootSendSuccess(FlowThreadWindowListViewModel r0, int r1, Message r2, String r3) {
        r0.markRetryRootSendSuccess(r1, r2, r3);
    }

    private final List<ImageSet> getAllImageInner(String r9, boolean r10, List<? extends Message.Type> r11, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m r12) {
        List<MessageInfo> r3 = allThreadMessageInfos();
        ArrayList r7 = new ArrayList();
        if (r3.isEmpty() == false) goto L5;
        return r7;
    L5:
        new com.ss.android.lark.chat.chatwindow.chat.model.viewdata.b(getFileAuthorityChecker(), getChatContainer().C(), getChatContainer().M()).a((Chat) getCurrentChat().getValue(), r3);
        parseImageSetFromMsgInfoList(r9, r10, r3, r7, r11, r12);
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadNextPage$default(FlowThreadWindowListViewModel r0, Function1 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.loadNextPage(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadPrePage$default(FlowThreadWindowListViewModel r0, Function1 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.loadPrePage(r1);
    }

    private final boolean patchThreadRepliesFromPush(ThreadTopic r7, List<? extends MessageInfo> r8, List<? extends MessageInfo> r9, String r10) {
        if (r7 == null) goto L29;
        String r1 = r7.getId();
        if (r1 == null) goto L29;
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L29;
        Iterator<n5b.a> r3 = this.threads.iterator();
        int r4 = 0;
    L17:
        if (r3.hasNext() == false) goto L22;
        if (matchesThreadTopic(r3.next(), r7) == true) goto L24;
        r4 = r4 + 1;
    L24:
        if (r4 >= 0) goto L27;
        Log.i(TAG, "patchThreadRepliesFromPush skip, not in current page, source:" + r10 + ", threadId:" + r1);
        return false;
    L27:
        n5b.a r0 = (n5b.a) ListProtector.get(this.threads, r4);
        r0.b = r7;
        r0.e = r8;
        r0.f = r9;
        Log.i(TAG, "patchThreadRepliesFromPush success, source:" + r10 + ", threadId:" + r1);
        publishThreads();
        return true;
    L22:
        r4 = -1;
        goto L24
    L9:
        r2 = false;
    L29:
        return false;
    }

    public List<ImageSet> getAllImage(String r4, boolean r5, List<? extends Message.Type> r6, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m r7) {
        Intrinsics.checkNotNullParameter(r4, "clickedMsgId");
        List<? extends Message.Type> r0 = r6;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6 = CollectionsKt.listOf(new Message.Type[]{Message.Type.IMAGE, Message.Type.MEDIA, Message.Type.POST, Message.Type.STICKER});
    L12:
        return getAllImageInner(r4, r5, r6, r7);
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void sendNewTopic(String r4, RichText r5, boolean r6, IGetDataCallback<String> r7) {
        Chat r0 = (Chat) getCurrentChat().getValue();
        if (r0 == null) goto L11;
        if (r5 == null) goto L11;
        com.ss.android.lark.im.sdk.service.p r1 = ImSdkService.f();
        kya.a.a r2 = new kya.a.a();
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r2.A = r4;
        r2.B = r5;
        ((MessageParams.a) r2).c = r0.getId();
        ((MessageParams.a) r2).k = r6;
        r1.sendMessage(r2.b(), r7);
        return;
    L11:
        if (r7 == null) goto L14;
        r7.onError(new ErrorResult("send new topic failed, chat or content is null"));
        return;
    }

    public static /* synthetic */ void updateLoadedRange$default(FlowThreadWindowListViewModel r0, List r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.updateLoadedRange(r1, r2);
    }

    private final void parseImageSetFromMsgInfoList(String r16, boolean r17, List<? extends MessageInfo> r18, List<ImageSet> r19, List<? extends Message.Type> r20, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m r21) {
        ArrayList r4 = new ArrayList();
        Iterator<T> r3 = r18.iterator();
    L3:
        boolean r6 = false;
        if (r3.hasNext() == false) goto L12;
        Object r5 = r3.next();
        MessageInfo r8 = (MessageInfo) r5;
        if (r20.contains(r8.getMessage().getType()) == true) goto L8;
    L10:
        if (r6 == false) goto L3;
        r4.add(r5);
        goto L3
    L8:
        if (r8.getMessage().getStatus() == Message.Status.DELETED) goto L10;
        r6 = true;
        goto L10
    L12:
        Iterator r7 = r4.iterator();
    L14:
        if (r7.hasNext() == false) goto L110;
        MessageInfo r9 = (MessageInfo) r7.next();
        Message r10 = r9.getMessage();
        Message.Type r11 = r10.getType();
        Chat r12 = (Chat) getCurrentChat().getValue();
        ValidateIMFileResult r13 = r10.getValidateIMFileResult();
        Content r14 = null;
        if (r13 == null) goto L18;
        IMFileResult r15 = r13.getResultType();
    L19:
        int r110 = MessagePermissionUtil.h(r15).getValue();
        if (r12 != null) goto L22;
    L24:
        boolean r22 = false;
    L25:
        if (r22 == false) goto L27;
        boolean r23 = true;
    L28:
        boolean r111 = lpc.a.c(r10);
        ResourceCleanScene r112 = lpc.a.a(r10);
        if (r11 == Message.Type.IMAGE) goto L31;
        if (r11 == Message.Type.MEDIA) goto L46;
        if (r11 == Message.Type.POST) goto L59;
        if (r11 == Message.Type.STICKER) goto L79;
        if (r11 == Message.Type.DOUBAO) goto L93;
        if (r11 != Message.Type.TEXT) goto L14;
        if (r21 == null) goto L14;
        Content r24 = r10.getContent();
        if (r24 == null) goto L14;
        FlowImageSet r25 = r21.b(r10.getId(), r24);
        if (r25 == null) goto L14;
        r19.add(r25);
        goto L14
    L93:
        if (r21 == null) goto L14;
        Content r26 = r10.getContent();
        if (r26 == null) goto L14;
        List r27 = r21.a(r10.getId(), r26);
        if (r27 == null) goto L14;
        Iterator r28 = r27.iterator();
    L100:
        if (r28.hasNext() == false) goto L14;
        r19.add((ImageSet) r28.next());
        goto L100
    L79:
        StickerContent r29 = r10.getContent();
        if ((r29 instanceof StickerContent) == false) goto L14;
        StickerContent r30 = r29;
        String r31 = r30.getStickerSetId();
        if (r31 != null) goto L84;
    L87:
        boolean r32 = true;
    L88:
        if (r32 == false) goto L14;
        r19.add(com.ss.android.lark.chat.utils.v0.f(r9, r30, r23));
        goto L14
    L84:
        if (r31.length() == 0) goto L87;
        r32 = false;
        goto L88
    L59:
        if (TextUtils.equals(r16, r10.getId()) == false) goto L63;
        if (r17 == false) goto L66;
        Content r33 = r9.getTranslateContent();
    L65:
        r14 = r33;
        boolean r34 = true;
    L67:
        if (r14 != null) goto L69;
        r14 = r10.getContent();
    L69:
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        PostContent r113 = (PostContent) r14;
        if (r113.isGroupAnnouncement() == true) goto L14;
        List r114 = CollectionsKt.filterNotNull(com.ss.android.lark.chat.utils.v0.e(r113.getRichText(), r10.isFromMe(), r10.getFromChatterTenantId()));
        Iterator r115 = r114.iterator();
    L74:
        if (r115.hasNext() == false) goto L76;
        ImageSet r116 = (ImageSet) r115.next();
        r116.setMessageIdentity(r0.c(r9));
        r116.setTranslated(r34);
        r116.setHasPreviewPermission(r23);
        w.a(r116, r10.getValidateIMFileResult());
        goto L74
    L76:
        r19.addAll(r114);
    L66:
        r34 = false;
        goto L67
    L63:
        if (r10.isTranslatedByDisplayRule() == false) goto L66;
        r33 = r9.getTranslateContent();
        goto L65
    L46:
        MediaImageSet r35 = com.ss.android.lark.parser.internal.d.b(r10.getContent());
        r35.setMessageIdentity(r0.c(r9));
        String r36 = r35.getMessageIdentity().getSourceId();
        if (r36 != null) goto L49;
    L52:
        boolean r37 = true;
    L53:
        if (r37 == false) goto L55;
        r35.getMessageIdentity().setSourceId(r35.getMessageIdentity().getMessageId());
    L55:
        r35.setHasPreviewPermission(r23);
        r35.setReceiveAuthorizationStateValue(r110);
        r35.setValidateIMFileResult(r10.getValidateIMFileResult());
        r35.setResourceIsCleaned(r111);
        r35.setResourceCleanScene(r112);
        r19.add(r35);
        goto L14
    L49:
        if (r36.length() == 0) goto L52;
        r37 = false;
        goto L53
    L31:
        if (TextUtils.equals(r16, r10.getId()) == false) goto L35;
        if (r17 == false) goto L38;
        Content r38 = r9.getTranslateContent();
    L37:
        r14 = r38;
        boolean r39 = true;
    L39:
        if (r14 != null) goto L41;
        r14 = r10.getContent();
    L41:
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.ImageContent");
        ImageSet r117 = ((ImageContent) r14).getImageSet();
        if (r117 == null) goto L14;
        r117.setMessageIdentity(r0.c(r9));
        r117.setTranslated(r39);
        r117.setHasPreviewPermission(r23);
        r117.setReceiveAuthorizationStateValue(r110);
        r117.setValidateIMFileResult(r10.getValidateIMFileResult());
        r117.setResourceIsCleaned(r111);
        r117.setResourceCleanScene(r112);
        r19.add(r117);
    L38:
        r39 = false;
        goto L39
    L35:
        if (r10.isTranslatedByDisplayRule() == false) goto L38;
        r38 = r9.getTranslateContent();
        goto L37
    L27:
        r23 = MessagePermissionUtil.c(r10, (Chat) getCurrentChat().getValue(), null);
        goto L28
    L22:
        if (r12.isSecret() != true) goto L24;
        r22 = true;
        goto L25
    L18:
        r15 = null;
        goto L19
    }

    public static /* synthetic */ List getAllImageInner$default(FlowThreadWindowListViewModel r0, String r1, boolean r2, List r3, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.getAllImageInner(r1, r2, r3, r4);
    }

    public static /* synthetic */ void parseImageSetFromMsgInfoList$default(FlowThreadWindowListViewModel r7, String r8, boolean r9, List r10, List r11, List r12, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        r7.parseImageSetFromMsgInfoList(r8, r9, r10, r11, r12, r13);
    }
}
