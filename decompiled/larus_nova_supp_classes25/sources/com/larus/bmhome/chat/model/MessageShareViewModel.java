package com.larus.bmhome.chat.model;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.pipeline.direct_add.UserActiveDeleteTipHelper;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility$ActionType;
import com.larus.bmhome.chat.list.cell.text.TextCellCutType;
import com.larus.bmhome.chat.manager.ShareCvsMsgPicManager;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.share.network.MessageShareApi;
import com.larus.bmhome.share.network.PreloadMessageShareHelper;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.network.bean.BizResponse;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u001f\u0018\u0000 \u0082\u00012\u00020\u0001:\u0004\u0082\u0001\u0083\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103J\u0006\u00104\u001a\u00020\u0018J\u0006\u00105\u001a\u00020\u0018J\u000e\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\u0018J\u0006\u00108\u001a\u000201J\u0006\u00109\u001a\u00020\u0018J\u000e\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020&J\"\u0010<\u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001c0>H\u0086@¢\u0006\u0002\u0010?J×\u0001\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\b\u0010D\u001a\u0004\u0018\u00010\u001b2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020H2[\u0010I\u001aW\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001b0>¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(M\u00122\u00120\u0012\u0013\u0012\u00110\u0018¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(O\u0012\u0004\u0012\u0002010Nj\u0002`Q¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(P\u0012\u0004\u0012\u0002010J2\u0006\u0010R\u001a\u00020\u00182<\b\u0002\u0010S\u001a6\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(T\u0012\u0015\u0012\u0013\u0018\u00010U¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(V\u0012\u0004\u0012\u000201\u0018\u00010JJ\u001c\u0010W\u001a\u00020\u001b2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\b\u0010D\u001a\u0004\u0018\u00010\u001bH\u0002Jz\u0010X\u001a\u0002012\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\b\u0010D\u001a\u0004\u0018\u00010\u001b2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020H2\u0006\u0010R\u001a\u00020\u00182<\b\u0002\u0010S\u001a6\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(T\u0012\u0015\u0012\u0013\u0018\u00010U¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(V\u0012\u0004\u0012\u000201\u0018\u00010JJ@\u0010Y\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010U\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020HH\u0086@¢\u0006\u0002\u0010ZJ\"\u0010[\u001a\u0002012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001c0>2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001c0>J\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001c0>2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u001c0>H\u0002J>\u0010_\u001a\u0002012\u0006\u0010`\u001a\u00020\u001e2\b\u0010a\u001a\u0004\u0018\u00010\u001c2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010>2\u0014\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020e\u0018\u00010dJ\b\u0010f\u001a\u000201H\u0002J\u0006\u0010g\u001a\u000201J\u000e\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u00020\u001bJ\u0012\u0010j\u001a\u00020\u00182\b\u0010k\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010l\u001a\u0002012\b\u0010k\u001a\u0004\u0018\u00010\u001cH\u0002J\u001a\u0010m\u001a\u00020\u00182\b\u0010n\u001a\u0004\u0018\u00010\u001c2\b\u0010o\u001a\u0004\u0018\u00010\u001cJ$\u0010p\u001a\b\u0012\u0004\u0012\u00020\u001c0>2\b\u0010n\u001a\u0004\u0018\u00010\u001c2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001c0>JA\u0010q\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00182\b\u0010s\u001a\u0004\u0018\u00010\u000e2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010>2\b\b\u0002\u0010t\u001a\u00020\u00182\b\b\u0002\u0010q\u001a\u00020\u0018¢\u0006\u0002\u0010uJ4\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010w\u001a\u00020\u000e2\u0006\u0010x\u001a\u00020\u000e2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010>H\u0002J\u0010\u0010y\u001a\u00020\u00182\u0006\u0010z\u001a\u00020\u000eH\u0002J\u000e\u0010{\u001a\u00020\u00182\u0006\u0010|\u001a\u00020\u001cJ\u0010\u0010}\u001a\u00020\u00182\u0006\u0010|\u001a\u00020\u001cH\u0002J\u000e\u0010~\u001a\u00020\u00182\u0006\u0010|\u001a\u00020\u001cJ\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u001c0>J\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001cJ\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0>R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u000e0\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012R(\u0010%\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0006\u0012\u0004\u0018\u00010&0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010'\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0006\u0012\u0004\u0018\u00010&0\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0012R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001c0,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0084\u0001"}, d2 = {"Lcom/larus/bmhome/chat/model/MessageShareViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_shareModeFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/bmhome/setting/share/MessageSelectStatus;", "shareModeFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getShareModeFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_notifyItemRangeChangedEvent", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "notifyItemRangeChangedEvent", "Landroidx/lifecycle/LiveData;", "getNotifyItemRangeChangedEvent", "()Landroidx/lifecycle/LiveData;", "_shareMegNum", "kotlin.jvm.PlatformType", "shareMegNum", "getShareMegNum", "useImmerseStyleCheckbox", "", "shareMsgIds", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/larus/im/bean/message/Message;", "originAction", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility$ActionType;", "originSelectMessage", "_messageShareSaveLiveData", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "messageShareSaveLiveData", "getMessageShareSaveLiveData", "_messageShareSavePreloadLiveData", "Lcom/larus/platform/model/share/ShareItemConfig;", "messageShareSavePreloadLiveData", "getMessageShareSavePreloadLiveData", "preloadHelper", "Lcom/larus/bmhome/share/network/PreloadMessageShareHelper;", "shareLongImageButtonMsgIdList", "", "getShareLongImageButtonMsgIdList", "()Ljava/util/List;", "shareLongImageSourceMsgList", "init", "", "bundle", "Landroid/os/Bundle;", "useImmerseStyleCheckBox", "isSelectMode", "shareMessage", "isAllowSEO", "preloadShareMessage", "hasPreloadShareMessage", "shareMessageWithPreload", "shareItemConfig", "doRequestMessageShareApi", "messageList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shareMessageWithPic", "context", "Landroid/content/Context;", "shareUrl", "botShareUrl", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "provider", "Lcom/larus/bmhome/chat/model/MessageShareViewModel$IChatBottomComponentProvider;", "permissionCallBack", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "manifest", "Lkotlin/Function1;", "allGranted", "requestCallBack", "Lcom/larus/platform/api/RequestPermissionCallback;", "onlyMsgList", "callback", "code", "Landroid/graphics/Bitmap;", "sharePic", "getPicRealShareUrl", "doShareMessageWithPic", "shareLongImage", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Lcom/larus/bmhome/chat/model/MessageShareViewModel$IChatBottomComponentProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findRelativeMessage", "visibleMessageList", "buildLongImageMessagesWithDeleteTips", "messages", "enterSelectMode", "action", "selectMessage", "currentList", "ext", "", "", "uploadFornaxToenWhenInhouseVersion", "exitSelectMode", "isShareSelect", "localMessageId", "selectShareMsg", "message", "unselectShareMsgId", "isRelativeSelectMessage", "userChoice", "target", "getRelativeSelectMessages", "selectRelativeMessage", "isCheck", "position", "selectAllBelow", "(ZLjava/lang/Integer;Ljava/util/List;ZZ)Z", "processIndexWhenUseCutThreeCell", "startIndex", "endIndex", "isOutOfLimit", "addNum", "canSelect", "data", "canDelete", "canShare", "getSortMessages", "getOriginSelectMessage", "getSelectedMessages", "Companion", "IChatBottomComponentProvider", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageShareViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "MessageShareViewModel";
    private final MutableLiveData<BizResponse<SaveMessageShareInfo>> _messageShareSaveLiveData;
    private final MutableLiveData<Pair<BizResponse<SaveMessageShareInfo>, jr9.a>> _messageShareSavePreloadLiveData;
    private final MutableLiveData<Pair<Integer, Integer>> _notifyItemRangeChangedEvent;
    private final MutableLiveData<Integer> _shareMegNum;
    private final kotlinx.coroutines.flow.z0<rr8.a> _shareModeFlow;
    private final LiveData<BizResponse<SaveMessageShareInfo>> messageShareSaveLiveData;
    private final LiveData<Pair<BizResponse<SaveMessageShareInfo>, jr9.a>> messageShareSavePreloadLiveData;
    private final LiveData<Pair<Integer, Integer>> notifyItemRangeChangedEvent;
    private IChatMessageShareAbility$ActionType originAction;
    private Message originSelectMessage;
    private PreloadMessageShareHelper preloadHelper;
    private final List<Message> shareLongImageButtonMsgIdList;
    private final List<Message> shareLongImageSourceMsgList;
    private final LiveData<Integer> shareMegNum;
    private final kotlinx.coroutines.flow.i1<rr8.a> shareModeFlow;
    private final ConcurrentHashMap<String, Message> shareMsgIds;
    private boolean useImmerseStyleCheckbox;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        Fragment f();

        de8.c g();
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IChatMessageShareAbility$ActionType.values().length];
            r0[IChatMessageShareAbility$ActionType.UN_KNOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[IChatMessageShareAbility$ActionType.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[IChatMessageShareAbility$ActionType.COLLECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[IChatMessageShareAbility$ActionType.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$doRequestMessageShareApi$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel", f = "MessageShareViewModel.kt", i = {}, l = {225}, m = "doRequestMessageShareApi", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MessageShareViewModel this$0;

        public AnonymousClass1(MessageShareViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doRequestMessageShareApi(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$doShareMessageWithPic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel$doShareMessageWithPic$1", f = "MessageShareViewModel.kt", i = {0, 0}, l = {297}, m = "invokeSuspend", n = {"realShareUrl", "sortMessages"}, s = {"L$0", "L$1"})
    public static final class C01651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botShareUrl;
        final /* synthetic */ Function2<Integer, Bitmap, Unit> $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ wc9.e $conversation;
        final /* synthetic */ boolean $onlyMsgList;
        final /* synthetic */ b $provider;
        final /* synthetic */ String $shareUrl;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MessageShareViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$doShareMessageWithPic$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel$doShareMessageWithPic$1$1", f = "MessageShareViewModel.kt", i = {}, l = {298, 298}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Bitmap, ? extends Bitmap>>, Object> {
            final /* synthetic */ wc9.e $conversation;
            final /* synthetic */ b $provider;
            Object L$0;
            int label;

            public C00671(wc9.e r1, b r2, Continuation<? super C00671> r3) {
                this.$conversation = r1;
                this.$provider = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00671(this.$conversation, this.$provider, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Pair<Bitmap, Bitmap>> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r11) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                Object r2 = this.L$0;
                ResultKt.throwOnFailure(r11);
            L18:
                return TuplesKt.to(r2, r11);
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                ResultKt.throwOnFailure(r11);
            L13:
                String r3 = this.$provider.g().g;
                this.L$0 = r11;
                this.label = 2;
                Object r4 = ImageLoaderKt.n(r3, "message_image_share_immersive_bg", null, null, this, 124);
                if (r4 != r0) goto L16;
                return r0;
            L16:
                r2 = r11;
                r11 = r4;
                goto L18
            L10:
                ResultKt.throwOnFailure(r11);
                int r12 = ShareCvsMsgPicManager.a;
                String r5 = ShareCvsMsgPicManager.c(this.$conversation);
                this.label = 1;
                r11 = ImageLoaderKt.n(r5, "message_image_share_avatar", null, null, this, 124);
                if (r11 != r0) goto L13;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$doShareMessageWithPic$1$a */
        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r3, T r4) {
                return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01651(MessageShareViewModel r1, String r2, String r3, Context r4, b r5, wc9.e r6, boolean r7, Function2<? super Integer, ? super Bitmap, Unit> r8, Continuation<? super C01651> r9) {
            this.this$0 = r1;
            this.$shareUrl = r2;
            this.$botShareUrl = r3;
            this.$context = r4;
            this.$provider = r5;
            this.$conversation = r6;
            this.$onlyMsgList = r7;
            this.$callback = r8;
            super(2, r9);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            return new C01651(this.this$0, this.$shareUrl, this.$botShareUrl, this.$context, this.$provider, this.$conversation, this.$onlyMsgList, this.$callback, r12);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            List r2 = (List) this.L$1;
            String r3 = (String) this.L$0;
            ResultKt.throwOnFailure(r11);
            String r4 = r3;
        L12:
            Pair r12 = (Pair) r11;
            Bitmap r7 = (Bitmap) r12.component1();
            Bitmap r8 = (Bitmap) r12.component2();
            com.larus.bmhome.chat.manager.g0 r13 = new com.larus.bmhome.chat.manager.g0(this.$context, this.$provider, r4, MessageShareViewModel.access$buildLongImageMessagesWithDeleteTips(this.this$0, r2), this.$conversation, r7, r8, this.$onlyMsgList);
            int r5 = ShareCvsMsgPicManager.a;
            final Function2<Integer, Bitmap, Unit> r6 = this.$callback;
            final MessageShareViewModel r9 = this.this$0;
            ShareCvsMsgPicManager.b(r13, new m1(r6, r9));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            String r10 = MessageShareViewModel.access$getPicRealShareUrl(this.this$0, this.$shareUrl, this.$botShareUrl);
            List r14 = CollectionsKt.sortedWith(MessageShareViewModel.access$getShareMsgIds$p(this.this$0).values(), new a());
            CoroutineDispatcher r15 = Dispatchers.getIO();
            C00671 r16 = new C00671(this.$conversation, this.$provider, null);
            this.L$0 = r10;
            this.L$1 = r14;
            this.label = 1;
            Object r17 = BuildersKt.withContext(r15, r16, this);
            if (r17 != r0) goto L11;
            return r0;
        L11:
            r2 = r14;
            r4 = r10;
            r11 = r17;
            goto L12
        }
    }

    public static final class e<T> implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$enterSelectMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel$enterSelectMode$1", f = "MessageShareViewModel.kt", i = {}, l = {428}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IChatMessageShareAbility$ActionType $action;
        final /* synthetic */ List<Message> $currentList;
        final /* synthetic */ Map<String, Object> $ext;
        final /* synthetic */ Message $selectMessage;
        int label;
        final /* synthetic */ MessageShareViewModel this$0;

        public C01661(MessageShareViewModel r1, IChatMessageShareAbility$ActionType r2, Message r3, List<Message> r4, Map<String, Object> r5, Continuation<? super C01661> r6) {
            this.this$0 = r1;
            this.$action = r2;
            this.$selectMessage = r3;
            this.$currentList = r4;
            this.$ext = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C01661(this.this$0, this.$action, this.$selectMessage, this.$currentList, this.$ext, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L14:
            List<Message> r9 = this.$currentList;
            Integer r2 = null;
            if (r9 == null) goto L29;
            Message r3 = this.$selectMessage;
            Iterator<Message> r10 = r9.iterator();
            int r4 = 0;
        L18:
            if (r10.hasNext() == false) goto L27;
            String r5 = r10.next().getLocalMessageId();
            if (r3 == null) goto L22;
            String r6 = r3.getLocalMessageId();
        L24:
            if (Intrinsics.areEqual(r5, r6) == true) goto L28;
            r4 = r4 + 1;
        L28:
            r2 = Boxing.boxInt(r4);
            goto L29
        L22:
            r6 = null;
            goto L24
        L27:
            r4 = -1;
        L29:
            this.this$0.selectRelativeMessage(true, r2, this.$currentList, z2.a.getShareConfig().i(), true);
            MessageShareViewModel.access$uploadFornaxToenWhenInhouseVersion(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            MessageShareViewModel.access$setOriginAction$p(this.this$0, this.$action);
            MessageShareViewModel.access$setOriginSelectMessage$p(this.this$0, this.$selectMessage);
            MessageShareViewModel.access$getShareLongImageSourceMsgList$p(this.this$0).clear();
            List<Message> r11 = this.$currentList;
            if (r11 == null) goto L11;
            Boxing.boxBoolean(MessageShareViewModel.access$getShareLongImageSourceMsgList$p(this.this$0).addAll(r11));
        L11:
            kotlinx.coroutines.flow.z0 r12 = MessageShareViewModel.access$get_shareModeFlow$p(this.this$0);
            rr8.a r7 = new rr8.a(Boxing.boxBoolean(true), this.$action, this.$ext);
            this.label = 1;
            if (r12.emit(r7, this) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$exitSelectMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel$exitSelectMode$1", f = "MessageShareViewModel.kt", i = {}, l = {451}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MessageShareViewModel this$0;

        public C01671(MessageShareViewModel r1, Continuation<? super C01671> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01671(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            MessageShareViewModel.selectRelativeMessage$default(this.this$0, false, null, null, false, false, 16, null);
            MessageShareViewModel.access$getShareMsgIds$p(this.this$0).clear();
            MessageShareViewModel.access$getShareLongImageSourceMsgList$p(this.this$0).clear();
            MessageShareViewModel.access$setOriginSelectMessage$p(this.this$0, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            kotlinx.coroutines.flow.z0 r13 = MessageShareViewModel.access$get_shareModeFlow$p(this.this$0);
            rr8.a r2 = new rr8.a(Boxing.boxBoolean(false), MessageShareViewModel.access$getOriginAction$p(this.this$0), null);
            this.label = 1;
            if (r13.emit(r2, this) != r0) goto L11;
            return r0;
        }
    }

    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
        }
    }

    public static final class g<T> implements Comparator {
        public g() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
        }
    }

    public static final class h<T> implements Comparator {
        public h() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
        }
    }

    public static final class i implements Function2<Integer, Bitmap, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<Pair<Bitmap, Integer>> a;

        public i(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r3, Object r4) {
            int r5 = ((Number) r3).intValue();
            kotlinx.coroutines.i<Pair<Bitmap, Integer>> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(new Pair((Bitmap) r4, Integer.valueOf(r5))));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$preloadShareMessage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel$preloadShareMessage$1", f = "MessageShareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MessageShareViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$preloadShareMessage$1$a */
        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r3, T r4) {
                return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
            }
        }

        public C01681(MessageShareViewModel r1, Continuation<? super C01681> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01681(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L30;
            ResultKt.throwOnFailure(r11);
            List r12 = CollectionsKt.sortedWith(MessageShareViewModel.access$getShareMsgIds$p(this.this$0).values(), new a());
            List r0 = r12;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L12;
            String r2 = ((Message) r1.next()).getMessageId();
            if (r2 != null) goto L10;
            r2 = "";
        L10:
            r3.add(r2);
            goto L6
        L12:
            if (r12.isEmpty() == true) goto L14;
            String r4 = ((Message) ListProtector.get(r12, 0)).getConversationId();
            MessageShareViewModel r13 = this.this$0;
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L22
            PreloadMessageShareHelper r8 = MessageShareViewModel.access$getPreloadHelper$p(r13);     // Catch: Throwable -> L22
            if (r8 == null) goto L19;
            r8.a(ViewModelKt.getViewModelScope(r13), new com.larus.bmhome.share.network.f(r4, r3, Boxing.boxBoolean(z2.a.getShareConfig().g()), Boxing.boxBoolean(false), null, 16));     // Catch: Throwable -> L22
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L22
        L20:
            Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L22
        L24:
            Throwable r16 = Result.exceptionOrNull-impl(r15);
            if (r16 == null) goto L28;
            FLogger.a.i(MessageShareViewModel.TAG, r16.toString());
        L28:
            return Unit.INSTANCE;
        L19:
            r14 = null;
        L22:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L24
        L14:
            return Unit.INSTANCE;
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$shareLongImage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel", f = "MessageShareViewModel.kt", i = {0, 0, 0, 0, 1}, l = {369, 865}, m = "shareLongImage", n = {"context", "shareUrl", "conversation", "provider", "shareContext"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    public static final class C01691 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MessageShareViewModel this$0;

        public C01691(MessageShareViewModel r1, Continuation<? super C01691> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.shareLongImage(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$shareLongImage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel$shareLongImage$2", f = "MessageShareViewModel.kt", i = {}, l = {370, 370}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Bitmap, ? extends Bitmap>>, Object> {
        final /* synthetic */ wc9.e $conversation;
        final /* synthetic */ b $provider;
        Object L$0;
        int label;

        public AnonymousClass2(wc9.e r1, b r2, Continuation<? super AnonymousClass2> r3) {
            this.$conversation = r1;
            this.$provider = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$conversation, this.$provider, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Pair<Bitmap, Bitmap>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r11);
        L18:
            return TuplesKt.to(r2, r11);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
        L13:
            String r3 = this.$provider.g().g;
            this.L$0 = r11;
            this.label = 2;
            Object r4 = ImageLoaderKt.n(r3, "message_image_share_immersive_bg", null, null, this, 124);
            if (r4 != r0) goto L16;
            return r0;
        L16:
            r2 = r11;
            r11 = r4;
            goto L18
        L10:
            ResultKt.throwOnFailure(r11);
            int r12 = ShareCvsMsgPicManager.a;
            String r5 = ShareCvsMsgPicManager.c(this.$conversation);
            this.label = 1;
            r11 = ImageLoaderKt.n(r5, "message_image_share_avatar", null, null, this, 124);
            if (r11 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$shareMessage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel$shareMessage$1", f = "MessageShareViewModel.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isAllowSEO;
        int label;
        final /* synthetic */ MessageShareViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$shareMessage$1$a */
        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r3, T r4) {
                return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
            }
        }

        public C01701(MessageShareViewModel r1, boolean r2, Continuation<? super C01701> r3) {
            this.this$0 = r1;
            this.$isAllowSEO = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01701(this.this$0, this.$isAllowSEO, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L22:
            dm9.a.b r12 = (dm9.a) r11;
            if ((r12 instanceof dm9.a.b) == false) goto L26;
            MessageShareViewModel.access$get_messageShareSaveLiveData$p(this.this$0).postValue(r12.a);
        L29:
            return Unit.INSTANCE;
        L26:
            if ((r12 instanceof dm9.a.a) == false) goto L29;
            FLogger.a.i(MessageShareViewModel.TAG, String.valueOf(((dm9.a.a) r12).c));
            MessageShareViewModel.access$get_messageShareSaveLiveData$p(this.this$0).postValue(new BizResponse(-1, null, null, null, 14, null));
            goto L29
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            List r13 = CollectionsKt.sortedWith(MessageShareViewModel.access$getShareMsgIds$p(this.this$0).values(), new a());
            List r2 = r13;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L16;
            String r4 = ((Message) r3.next()).getMessageId();
            if (r4 != null) goto L14;
            r4 = "";
        L14:
            r5.add(r4);
            goto L10
        L16:
            if (r13.isEmpty() == true) goto L18;
            String r6 = ((Message) ListProtector.get(r13, 0)).getConversationId();
            MessageShareApi.Companion r14 = MessageShareApi.a;
            com.larus.bmhome.share.network.f r7 = new com.larus.bmhome.share.network.f(r6, r5, Boxing.boxBoolean(z2.a.getShareConfig().g()), Boxing.boxBoolean(this.$isAllowSEO), null, 16);
            this.label = 1;
            r14.getClass();
            r11 = MessageShareApi.Companion.a(r7, this);
            if (r11 != r0) goto L22;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$shareMessageWithPreload$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel$shareMessageWithPreload$1", f = "MessageShareViewModel.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ jr9.a $shareItemConfig;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MessageShareViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$shareMessageWithPreload$1$a */
        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r3, T r4) {
                return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
            }
        }

        public C01711(MessageShareViewModel r1, jr9.a r2, Continuation<? super C01711> r3) {
            this.this$0 = r1;
            this.$shareItemConfig = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01711(this.this$0, this.$shareItemConfig, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            jr9.a r2 = (jr9.a) this.L$1;
            MessageShareViewModel r3 = (MessageShareViewModel) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L8
        L33:
            BizResponse r16 = (BizResponse) r15;     // Catch: Throwable -> L8
            if (r16 != null) goto L37;
            jr9.a r10 = r2;
            MessageShareViewModel r17 = r3;
        L36:
            r3 = r17;
            r16 = new BizResponse(-1, null, null, null, 14, null);     // Catch: Throwable -> L8
            r2 = r10;
        L37:
            MessageShareViewModel.access$get_messageShareSavePreloadLiveData$p(r3).postValue(new Pair(r16, r2));     // Catch: Throwable -> L8
            Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L40:
            MessageShareViewModel r4 = this.this$0;
            Throwable r19 = Result.exceptionOrNull-impl(r18);
            if (r19 == null) goto L44;
            FLogger.a.i(MessageShareViewModel.TAG, r19.toString());
            MessageShareViewModel.access$get_messageShareSavePreloadLiveData$p(r4).postValue(new Pair(new BizResponse(-1, null, null, null, 14, null), null));
        L44:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r15);
            List r110 = CollectionsKt.sortedWith(MessageShareViewModel.access$getShareMsgIds$p(this.this$0).values(), new a());
            List r5 = r110;
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator r7 = r5.iterator();
        L14:
            if (r7.hasNext() == false) goto L20;
            String r8 = ((Message) r7.next()).getMessageId();
            if (r8 != null) goto L18;
            r8 = "";
        L18:
            r6.add(r8);
            goto L14
        L20:
            if (r110.isEmpty() == false) goto L24;
            return Unit.INSTANCE;
        L24:
            if (MessageShareViewModel.access$getPreloadHelper$p(this.this$0) != null) goto L26;
            MessageShareViewModel.access$setPreloadHelper$p(this.this$0, new PreloadMessageShareHelper());
        L26:
            String r9 = ((Message) ListProtector.get(r110, 0)).getConversationId();
            r17 = this.this$0;
            r10 = this.$shareItemConfig;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
            PreloadMessageShareHelper r12 = MessageShareViewModel.access$getPreloadHelper$p(r17);     // Catch: Throwable -> L8
            if (r12 == null) goto L36;
            com.larus.bmhome.share.network.f r13 = new com.larus.bmhome.share.network.f(r9, r6, Boxing.boxBoolean(z2.a.getShareConfig().g()), Boxing.boxBoolean(false), null, 16);     // Catch: Throwable -> L8
            this.L$0 = r17;     // Catch: Throwable -> L8
            this.L$1 = r10;     // Catch: Throwable -> L8
            this.label = 1;     // Catch: Throwable -> L8
            Object r14 = r12.b(r13, this);     // Catch: Throwable -> L8
            if (r14 != r0) goto L32;
            return r0;
        L32:
            r2 = r10;
            r3 = r17;
            r15 = r14;
        L8:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r18 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L40
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.MessageShareViewModel$uploadFornaxToenWhenInhouseVersion$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel$uploadFornaxToenWhenInhouseVersion$1", f = "MessageShareViewModel.kt", i = {}, l = {443}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ MessageShareViewModel this$0;

        public C01721(MessageShareViewModel r1, Continuation<? super C01721> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01721(this.this$0, r3);
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
            Iterator r2 = (Iterator) this.L$0;
            ResultKt.throwOnFailure(r6);
        L10:
            if (r2.hasNext() == false) goto L15;
            Message r7 = (Message) r2.next();
            int r3 = com.larus.security.api.g.a;
            this.L$0 = r2;
            this.label = 1;
            if (com.larus.security.api.g.a(r7, 3, null, null, this) != r0) goto L10;
            return r0;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            r2 = this.this$0.getSelectedMessages().iterator();
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit yo(MessageShareViewModel r0, Context r1, String r2, String r3, wc9.e r4, b r5, boolean r6, Function2 r7, boolean r8) {
        return shareMessageWithPic$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    private final void uploadFornaxToenWhenInhouseVersion() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.isTestChannel() == false) goto L5;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C01721(this, null), 3, null);
        return;
    L5:
        if (CollectionsKt.listOf(new String[]{"inhouse", "auto_test"}).contains(r0.getBuildChannel()) == true) goto L6;
    }

    public final List<Message> getSelectedMessages() {
        return CollectionsKt.sortedWith(this.shareMsgIds.values(), new f());
    }

    public final List<Message> getSortMessages() {
        return CollectionsKt.sortedWith(this.shareMsgIds.values(), new g());
    }

    public final boolean hasPreloadShareMessage() {
        PreloadMessageShareHelper r0 = this.preloadHelper;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.a == null) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    public final boolean isSelectMode() {
        Boolean r0 = ((rr8.a) this.shareModeFlow.getValue()).a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final void preloadShareMessage() {
        this.preloadHelper = new PreloadMessageShareHelper();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01681(this, null), 2, null);
    }

    public MessageShareViewModel() {
        Boolean r1 = Boolean.FALSE;
        IChatMessageShareAbility$ActionType r2 = IChatMessageShareAbility$ActionType.UN_KNOW;
        StateFlowImpl r0 = kotlinx.coroutines.flow.j1.a(new rr8.a(r1, r2, null));
        this._shareModeFlow = r0;
        this.shareModeFlow = r0;
        MutableLiveData<Pair<Integer, Integer>> r3 = new MutableLiveData();
        this._notifyItemRangeChangedEvent = r3;
        this.notifyItemRangeChangedEvent = r3;
        MutableLiveData<Integer> r4 = new MutableLiveData(0);
        this._shareMegNum = r4;
        this.shareMegNum = r4;
        this.shareMsgIds = new ConcurrentHashMap();
        this.originAction = r2;
        MutableLiveData<BizResponse<SaveMessageShareInfo>> r5 = new MutableLiveData();
        this._messageShareSaveLiveData = r5;
        this.messageShareSaveLiveData = r5;
        MutableLiveData<Pair<BizResponse<SaveMessageShareInfo>, jr9.a>> r6 = new MutableLiveData();
        this._messageShareSavePreloadLiveData = r6;
        this.messageShareSavePreloadLiveData = r6;
        this.shareLongImageButtonMsgIdList = new ArrayList();
        this.shareLongImageSourceMsgList = new ArrayList();
    }

    public final void exitSelectMode() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01671(this, null), 3, null);
    }

    public final LiveData<BizResponse<SaveMessageShareInfo>> getMessageShareSaveLiveData() {
        return this.messageShareSaveLiveData;
    }

    public final LiveData<Pair<BizResponse<SaveMessageShareInfo>, jr9.a>> getMessageShareSavePreloadLiveData() {
        return this.messageShareSavePreloadLiveData;
    }

    public final LiveData<Pair<Integer, Integer>> getNotifyItemRangeChangedEvent() {
        return this.notifyItemRangeChangedEvent;
    }

    public final Message getOriginSelectMessage() {
        return this.originSelectMessage;
    }

    public final List<Message> getShareLongImageButtonMsgIdList() {
        return this.shareLongImageButtonMsgIdList;
    }

    public final LiveData<Integer> getShareMegNum() {
        return this.shareMegNum;
    }

    public final kotlinx.coroutines.flow.i1<rr8.a> getShareModeFlow() {
        return this.shareModeFlow;
    }

    public final boolean useImmerseStyleCheckBox() {
        return this.useImmerseStyleCheckbox;
    }

    public static final /* synthetic */ IChatMessageShareAbility$ActionType access$getOriginAction$p(MessageShareViewModel r0) {
        return r0.originAction;
    }

    public static final /* synthetic */ PreloadMessageShareHelper access$getPreloadHelper$p(MessageShareViewModel r0) {
        return r0.preloadHelper;
    }

    public static final /* synthetic */ List access$getShareLongImageSourceMsgList$p(MessageShareViewModel r0) {
        return r0.shareLongImageSourceMsgList;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getShareMsgIds$p(MessageShareViewModel r0) {
        return r0.shareMsgIds;
    }

    public static final /* synthetic */ MutableLiveData access$get_messageShareSaveLiveData$p(MessageShareViewModel r0) {
        return r0._messageShareSaveLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_messageShareSavePreloadLiveData$p(MessageShareViewModel r0) {
        return r0._messageShareSavePreloadLiveData;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.z0 access$get_shareModeFlow$p(MessageShareViewModel r0) {
        return r0._shareModeFlow;
    }

    public static final /* synthetic */ void access$uploadFornaxToenWhenInhouseVersion(MessageShareViewModel r0) {
        r0.uploadFornaxToenWhenInhouseVersion();
    }

    private final List<Message> buildLongImageMessagesWithDeleteTips(List<Message> r15) {
        int r0 = UserActiveDeleteTipHelper.a;
        List<Message> r1 = this.shareLongImageSourceMsgList;
        if ((!r1.isEmpty()) == true) goto L6;
        r1 = null;
    L6:
        if (r1 != null) goto L8;
        r1 = r15;
    L8:
        Intrinsics.checkNotNullParameter(r15, "selectedMessages");
        Intrinsics.checkNotNullParameter(r1, "allMessages");
        int r2 = ra9.a.a;
        String r3 = ga9.a.e("delete_msg_tip_display", "0");
        if (Intrinsics.areEqual(r3, "0") == false) goto L12;
        UserActiveDeleteTipHelper.DeleteMsgTipDisplay r4 = null;
    L15:
        if (r4 != null) goto L18;
        return r15;
    L18:
        if (r15.size() > 1) goto L20;
        return r15;
    L20:
        if (r1.isEmpty() == true) goto L112;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r1.iterator();
    L23:
        boolean r7 = false;
        if (r6.hasNext() == false) goto L33;
        Object r8 = r6.next();
        Integer r9 = com.larus.bmhome.social.userchat.model.b0.c((Message) r8);
        if (r9 != null) goto L29;
    L31:
        if (r7 == true) goto L23;
        r5.add(r8);
        goto L23
    L29:
        if (r9.intValue() != 14) goto L31;
        r7 = true;
        goto L31
    L33:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r5.iterator();
    L35:
        if (r11.hasNext() == false) goto L50;
        Object r12 = r11.next();
        Message r13 = (Message) r12;
        if (com.larus.im.bean.message.a.y0(r13) == false) goto L39;
    L40:
        Map r14 = r13.getExt();
        if (r14 == null) goto L43;
        String r16 = (String) r14.get("crowd_test_delete_tip_anchor");
    L45:
        if (Intrinsics.areEqual(r16, "1") == true) goto L47;
        boolean r17 = true;
    L48:
        if (r17 == true) goto L35;
        r10.add(r12);
    L47:
        r17 = false;
        goto L48
    L43:
        r16 = null;
        goto L45
    L39:
        if (com.larus.im.bean.message.a.x0(r13) == false) goto L47;
    L50:
        List r18 = CollectionsKt.sortedWith(r10, new vd8.q());
        List r19 = CollectionsKt.sortedWith(r15, new vd8.r());
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
        int r22 = 0;
    L52:
        if (r21.hasNext() == false) goto L87;
        Object r23 = r21.next();
        int r24 = r22 + 1;
        if (r22 >= 0) goto L56;
        CollectionsKt.throwIndexOverflow();
    L56:
        Message r25 = (Message) r23;
        r20.add(r25);
        Message r26 = (Message) CollectionsKt.getOrNull(r19, r24);
        if (r26 == null) goto L85;
        Iterator r27 = r18.iterator();
        int r110 = 0;
    L60:
        boolean r111 = r27.hasNext();
        int r112 = UserActiveDeleteTipHelper.a;
        int r113 = -1;
        if (r111 == false) goto L66;
        if (UserActiveDeleteTipHelper.c((Message) r27.next(), r25) == true) goto L67;
        r110 = r110 + 1;
    L67:
        Iterator r28 = r18.iterator();
        int r114 = 0;
    L69:
        if (r28.hasNext() == false) goto L74;
        if (UserActiveDeleteTipHelper.c((Message) r28.next(), r26) == true) goto L72;
        r114 = r114 + 1;
        goto L69
    L72:
        r113 = r114;
    L74:
        if (r110 < 0) goto L85;
        if (r113 < 0) goto L85;
        if (r110 >= r113) goto L85;
        List r29 = r18.subList(r110, r113);
        ArrayList r30 = new ArrayList();
        Iterator r31 = r29.iterator();
    L80:
        if (r31.hasNext() == false) goto L82;
        CollectionsKt.addAll(r30, UserActiveDeleteTipHelper.e((Message) r31.next()));
        goto L80
    L82:
        List r32 = CollectionsKt.distinct(r30);
        if ((!r32.isEmpty()) == false) goto L85;
        r20.add(UserActiveDeleteTipHelper.a(r25, r32, r4));
        goto L85
    L66:
        r110 = -1;
    L85:
        r22 = r24;
        goto L52
    L87:
        return r20;
    L112:
        return r15;
    L12:
        if (Intrinsics.areEqual(r3, "2") == false) goto L14;
        r4 = UserActiveDeleteTipHelper.DeleteMsgTipDisplay.RECALL;
        goto L15
    L14:
        r4 = UserActiveDeleteTipHelper.DeleteMsgTipDisplay.DELETE;
        goto L15
    }

    private final boolean canDelete(Message r8) {
        String r0 = r8.getConversationId();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L13;
        FLogger.a.i(TAG, "can not delete msg#" + r8.getMessageId() + ": conversation is local");
        return false;
    L13:
        if (hp8.a.c(r8) == false) goto L19;
        if (this.originAction == IChatMessageShareAbility$ActionType.DELETE) goto L19;
        FLogger.a.i(TAG, "can not delete msg#" + r8.getMessageId() + ": dora pic");
        return false;
    L19:
        if (com.larus.im.bean.message.a.w0(r8) == false) goto L23;
        FLogger.a.i(TAG, "can not delete msg#" + r8.getMessageId() + ": message is streaming");
        return false;
    L23:
        if (CollectionsKt.listOf(new Integer[]{0, 2, 51, 1001, 1002, 1003}).contains(Integer.valueOf(r8.getContentType())) == false) goto L27;
        FLogger.a.i(TAG, "can not delete msg#" + r8.getMessageId() + ": contentType = " + r8.getContentType());
        return false;
    L27:
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"crowd_test_tab", "crowd_test_selection"}), r8.getBizContentType()) == false) goto L30;
        FLogger.a.i(TAG, "can not delete msg#" + r8.getMessageId() + ": bizContentType = " + r8.getBizContentType());
        return false;
    L30:
        return true;
    L5:
        if (ic8.n.s(r0) != true) goto L7;
        r1 = true;
        goto L9
    }

    private final boolean isOutOfLimit(int r2) {
        if ((this.shareMsgIds.size() + r2) <= z2.a.getShareConfig().t()) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean selectShareMsg(Message r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        ConcurrentHashMap<String, Message> r0 = this.shareMsgIds;
        String r1 = r3.getLocalMessageId();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r0.put(r1, r3);
        this._shareMegNum.setValue(Integer.valueOf(this.shareMsgIds.size()));
        return true;
    }

    private final void unselectShareMsgId(Message r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<String, Message> r0 = this.shareMsgIds;
        String r3 = r2.getLocalMessageId();
        TypeIntrinsics.asMutableMap(r0).remove(r3);
        this._shareMegNum.setValue(Integer.valueOf(this.shareMsgIds.size()));
    }

    public final boolean canSelect(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        IChatMessageShareAbility$ActionType r0 = this.originAction;
        int r1 = c.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return false;
    L5:
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L17;
        if (r1 != 4) goto L12;
        return canDelete(r3);
    L12:
        throw new NoWhenBranchMatchedException();
    L17:
        return canShare(r3);
    }

    public final boolean canShare(Message r14) {
        Intrinsics.checkNotNullParameter(r14, "data");
        Map r0 = r14.getExt();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.get("forbid_message_share");
    L7:
        if (Intrinsics.areEqual(r2, "1") == false) goto L10;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": forbid message share");
        return false;
    L10:
        String r3 = r14.getConversationId();
        if (r3 == null) goto L15;
        Lazy r7 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (com.larus.im.j.f(r3) != true) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L20;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": conversation is local");
        return false;
    L20:
        if (r14.getMessageStatus() != MessageStatus.MessageStatus_NOTCOMPLIANT) goto L24;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": message is not compliant");
        return false;
    L24:
        if (hp8.a.c(r14) == true) goto L26;
    L29:
        Map r5 = r14.getExt();
        if (r5 == null) goto L32;
        String r6 = (String) r5.get("need_auth_identity");
    L34:
        if (Intrinsics.areEqual(r6, "1") == false) goto L37;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": need real name auth");
        return false;
    L37:
        Map r8 = r14.getExt();
        if (r8 == null) goto L44;
        String r9 = (String) r8.get("widget_content");
        if (r9 == null) goto L44;
        if (com.larus.utils.o0.d(r9) != true) goto L44;
        boolean r10 = true;
    L45:
        if (r10 == false) goto L49;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": widget");
        return false;
    L49:
        if (lr8.c.a(r14) == false) goto L67;
        NestedFileContent r11 = com.larus.bmhome.chat.bean.d.f(r14);
        if (yc9.v0.h(r11) != 1) goto L67;
        List r12 = r11.getEntities();
        if (r12 == null) goto L62;
        UplinkFileEntity r13 = (UplinkFileEntity) ListProtector.get(r12, 0);
        if (r13 == null) goto L62;
        Integer r15 = r13.getFileReviewStatus();
        int r16 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r15 == null) goto L62;
        if (r15.intValue() != r16) goto L62;
        boolean r17 = true;
    L63:
        if (r17 == false) goto L67;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": nested file is not compliant");
        return false;
    L62:
        r17 = false;
    L67:
        if (r14.getSourceFromAsr() == false) goto L77;
        if (r14.getMessageStatusLocal() != 0) goto L77;
        Map r18 = r14.getBusinessExt();
        if (r18 == null) goto L74;
        r1 = (String) r18.get("is_real_audio_text");
    L74:
        if (Intrinsics.areEqual(r1, "1") == true) goto L87;
        return false;
    L87:
        if (com.larus.bmhome.chat.bean.d.y0(r14) == false) goto L91;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": old crowd test message");
        return false;
    L91:
        if (r14.getContentType() != 8) goto L97;
        if (com.larus.bmhome.chat.search.a.d(r14) == false) goto L97;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": search list with ugc card");
        return false;
    L97:
        if (com.larus.im.bean.message.a.i0(r14) == false) goto L101;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": mock answer");
        return false;
    L101:
        if (com.larus.bmhome.chat.bean.d.a0(r14) == false) goto L139;
        CreationMsgContentData r19 = dp8.e.c(r14);
        if (r19 == null) goto L135;
        CreationInfo r20 = r19.creationInfo;
        if (r20 == null) goto L135;
        Map r21 = r20.taskInfo;
        if (r21 == null) goto L135;
        Collection r22 = r21.values();
        if (r22 == null) goto L135;
        Collection r23 = r22;
        if (r23.isEmpty() == true) goto L132;
        Iterator r24 = r23.iterator();
    L115:
        if (r24.hasNext() == false) goto L132;
        CreationTask r110 = (CreationTask) r24.next();
        if (r110 == null) goto L124;
        Integer r111 = r110.loadingAssetType;
        if (r111 == null) goto L124;
        if (r111.intValue() != 7) goto L124;
        boolean r112 = true;
    L125:
        if (r112 == true) goto L127;
    L129:
        boolean r113 = false;
    L130:
        if (r113 == false) goto L115;
        boolean r25 = true;
    L133:
        if (r25 != true) goto L135;
        boolean r26 = true;
    L136:
        if (r26 == false) goto L139;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": video creation is loading");
        return false;
    L127:
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{4, 5}), r110.status) == true) goto L129;
        r113 = true;
    L124:
        r112 = false;
    L132:
        r25 = false;
    L135:
        r26 = false;
    L139:
        z2 r27 = z2.a;
        List r114 = r27.getShareConfig().l();
        if (r114 != null) goto L142;
    L145:
        boolean r115 = true;
    L146:
        if (r115 == false) goto L148;
        List r28 = CollectionsKt.listOf(new Integer[]{1, 6, 2022, 8, 7, 70, 9999});
    L149:
        List r29 = r27.getShareConfig().k();
        if (r29 != null) goto L152;
    L155:
        boolean r30 = true;
    L156:
        if (r30 == false) goto L158;
        List r31 = CollectionsKt.listOf("flow_nested");
    L160:
        if (r14.getContentType() != 800) goto L169;
        if (r31 != null) goto L163;
    L165:
        boolean r32 = false;
    L166:
        if (r32 == true) goto L175;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": bizContentType = " + r14.getBizContentType());
        return false;
    L175:
        return true;
    L163:
        if (r31.contains(r14.getBizContentType()) != true) goto L165;
        r32 = true;
        goto L166
    L169:
        if (r28 != null) goto L171;
    L173:
        boolean r33 = false;
    L174:
        if (r33 == true) goto L175;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": contentType = " + r14.getContentType());
        return false;
    L171:
        if (r28.contains(Integer.valueOf(r14.getContentType())) != true) goto L173;
        r33 = true;
        goto L174
    L158:
        r31 = r27.getShareConfig().k();
        goto L160
    L152:
        if (r29.isEmpty() == true) goto L155;
        r30 = false;
        goto L156
    L148:
        r28 = r27.getShareConfig().l();
        goto L149
    L142:
        if (r114.isEmpty() == true) goto L145;
        r115 = false;
    L77:
        if (r14.getMessageStatusLocal() == 21) goto L87;
        if (r14.getMessageStatusLocal() == 11) goto L87;
        if (r14.getMessageStatusLocal() == 13) goto L87;
        if (r14.getMessageStatusLocal() == 23) goto L87;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": messageStatusLocal = " + r14.getMessageStatusLocal());
        return false;
    L44:
        r10 = false;
        goto L45
    L32:
        r6 = null;
        goto L34
    L26:
        if (z2.a.e3().a == true) goto L29;
        FLogger.a.i(TAG, "can not share msg#" + r14.getMessageId() + ": dora pic");
        return false;
    L15:
        r4 = false;
        goto L16
    L5:
        r2 = null;
        goto L7
    }

    public final void init(Bundle r6) {
        if (r6 == null) goto L5;
        boolean r7 = r6.getBoolean("is_in_immers_fragment", false);
    L6:
        this.useImmerseStyleCheckbox = r7;
        this._shareModeFlow.setValue(new rr8.a(Boolean.FALSE, this.originAction, null));
        this._shareMegNum.setValue(0);
        return;
    L5:
        r7 = false;
        goto L6
    }

    public final boolean isShareSelect(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMessageId");
        return this.shareMsgIds.containsKey(r2);
    }

    public final void shareMessage(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01701(this, r7, null), 2, null);
    }

    public final void shareMessageWithPreload(jr9.a r8) {
        Intrinsics.checkNotNullParameter(r8, "shareItemConfig");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01711(this, r8, null), 2, null);
    }

    public static final /* synthetic */ List access$buildLongImageMessagesWithDeleteTips(MessageShareViewModel r0, List r1) {
        return r0.buildLongImageMessagesWithDeleteTips(r1);
    }

    public static final /* synthetic */ void access$setOriginAction$p(MessageShareViewModel r0, IChatMessageShareAbility$ActionType r1) {
        r0.originAction = r1;
    }

    public static final /* synthetic */ void access$setOriginSelectMessage$p(MessageShareViewModel r0, Message r1) {
        r0.originSelectMessage = r1;
    }

    public static final /* synthetic */ void access$setPreloadHelper$p(MessageShareViewModel r0, PreloadMessageShareHelper r1) {
        r0.preloadHelper = r1;
    }

    private final String getPicRealShareUrl(String r4, String r5) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        return r4;
    L11:
        if (r5 != null) goto L13;
    L14:
        r0 = true;
    L15:
        if (r0 == true) goto L18;
        return r5;
    L18:
        return AppHost.a.d();
    L13:
        if (r5.length() != 0) goto L15;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final Object doRequestMessageShareApi(List<Message> r23, Continuation<? super BizResponse<SaveMessageShareInfo>> r24) {
        if ((r24 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) r24;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L28:
        dm9.a.b r5 = (dm9.a) r0;
        if ((r5 instanceof dm9.a.b) == false) goto L32;
        return r5.a;
    L32:
        if ((r5 instanceof dm9.a.a) == false) goto L36;
        FLogger.a.i(TAG, String.valueOf(((dm9.a.a) r5).c));
        return new BizResponse(-1, null, null, null, 14, null);
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        List r6 = CollectionsKt.sortedWith(r23, new d());
        List r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L16:
        if (r9.hasNext() == false) goto L22;
        String r10 = ((Message) r9.next()).getMessageId();
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        r8.add(r10);
        goto L16
    L22:
        if (r6.isEmpty() == true) goto L24;
        String r11 = ((Message) ListProtector.get(r6, 0)).getConversationId();
        MessageShareApi.Companion r12 = MessageShareApi.a;
        com.larus.bmhome.share.network.f r13 = new com.larus.bmhome.share.network.f(r11, r8, Boxing.boxBoolean(z2.a.getShareConfig().g()), Boxing.boxBoolean(false), null, 16);
        r1.label = 1;
        r12.getClass();
        r0 = MessageShareApi.Companion.a(r13, r1);
        if (r0 != r3) goto L28;
        return r3;
    L24:
        return new BizResponse(-1, null, null, new SaveMessageShareInfo(null, null, null, null, null, 31, null), 6, null);
    L7:
        r1 = new AnonymousClass1(this, r24);
        goto L8
    }

    public final void findRelativeMessage(List<Message> r5, List<Message> r6) {
        Intrinsics.checkNotNullParameter(r5, "visibleMessageList");
        Intrinsics.checkNotNullParameter(r6, "messageList");
        this.shareLongImageButtonMsgIdList.clear();
        this.shareLongImageButtonMsgIdList.addAll(r5);
        this.shareLongImageSourceMsgList.clear();
        this.shareLongImageSourceMsgList.addAll(r6);
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        Message r0 = (Message) r7.next();
        Iterator<T> r1 = r5.iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        Message r2 = (Message) r1.next();
        if (canSelect(r0) == false) goto L7;
        if (isRelativeSelectMessage(r0, r2) == false) goto L7;
        if (this.shareLongImageButtonMsgIdList.contains(r0) == true) goto L7;
        this.shareLongImageButtonMsgIdList.add(r0);
        goto L7
    }

    public final List<Message> getRelativeSelectMessages(Message r10, List<Message> r11) {
        Intrinsics.checkNotNullParameter(r11, "currentList");
        if (r10 == null) goto L5;
        List<Message> r12 = r11;
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r1 = r12.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if (isRelativeSelectMessage(r10, (Message) r2) == false) goto L8;
        r0.add(r2);
        goto L8
    L12:
        int r13 = r0.size();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r0.iterator();
    L13:
        boolean r5 = false;
        if (r4.hasNext() == false) goto L25;
        String r6 = com.larus.im.bean.message.a.g((Message) r4.next());
        if (r6 != null) goto L18;
    L22:
        r6 = null;
    L23:
        if (r6 == null) goto L13;
        r3.add(r6);
        goto L13
    L18:
        if (r6.length() <= 0) goto L20;
        r5 = true;
    L20:
        if (r5 == false) goto L22;
    L25:
        Set r7 = CollectionsKt.toSet(r3);
        if ((!r7.isEmpty()) == false) goto L38;
        Iterator<T> r8 = r12.iterator();
    L29:
        if (r8.hasNext() == false) goto L38;
        Object r9 = r8.next();
        Message r14 = (Message) r9;
        if (com.larus.bmhome.social.userchat.model.b0.f(r14) == false) goto L33;
    L35:
        boolean r15 = false;
    L36:
        if (r15 == false) goto L29;
        r0.add(r9);
        goto L29
    L33:
        if (CollectionsKt.contains(r7, com.larus.im.bean.message.a.g(r14)) == false) goto L35;
        r15 = true;
    L38:
        int r16 = r0.size();
        List r17 = CollectionsKt.toList(r0);
        Iterator<T> r18 = r12.iterator();
    L40:
        if (r18.hasNext() == false) goto L55;
        Object r19 = r18.next();
        Message r20 = (Message) r19;
        List r21 = r17;
        if ((r21 instanceof Collection) == true) goto L44;
    L46:
        Iterator r22 = r21.iterator();
    L48:
        if (r22.hasNext() == false) goto L45;
        if (isRelativeSelectMessage((Message) r22.next(), r20) == false) goto L48;
        boolean r23 = true;
    L52:
        if (r23 == false) goto L40;
        r0.add(r19);
    L45:
        r23 = false;
        goto L52
    L44:
        if (r21.isEmpty() == false) goto L46;
    L55:
        if (r0.size() <= r13) goto L58;
        FLogger.a.i(TAG, "getRelativeSelectMessages expanded: direct=" + r13 + ", batch=" + r16 + ", result=" + r0.size());
    L58:
        return CollectionsKt.sortedWith(r0, new e());
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean isRelativeSelectMessage(Message r5, Message r6) {
        if (r5 == null) goto L48;
        if (r6 == null) goto L48;
        if (com.larus.bmhome.social.userchat.model.b0.f(r6) == false) goto L15;
        if (Intrinsics.areEqual(r5, r6) == true) goto L11;
    L13:
        return false;
    L11:
        if (com.larus.bmhome.chat.bean.d.v0(r5) == false) goto L13;
        return true;
    L15:
        if (ObricFeatureServiceDelegate.b.c() == false) goto L32;
        if (Intrinsics.areEqual(r5, r6) == true) goto L30;
        String r1 = r6.getMessageId();
        if (r1 != null) goto L21;
    L26:
        boolean r2 = false;
    L27:
        if (r2 == false) goto L37;
        if (Intrinsics.areEqual(r5.getMessageId(), r6.getMessageId()) == true) goto L30;
    L37:
        if (Intrinsics.areEqual(r5.getMessageId(), r6.getReplyId()) == false) goto L40;
        return true;
    L40:
        if (com.larus.bmhome.chat.bean.d.A(r5) == true) goto L42;
    L46:
        return false;
    L42:
        if (Intrinsics.areEqual(r5.getReplyId(), r6.getReplyId()) == false) goto L44;
    L45:
        return true;
    L44:
        if (Intrinsics.areEqual(r5.getReplyId(), r6.getMessageId()) == false) goto L46;
    L21:
        if (r1.length() <= 0) goto L23;
        boolean r3 = true;
    L24:
        if (r3 != true) goto L26;
        r2 = true;
        goto L27
    L23:
        r3 = false;
    L30:
        return true;
    L32:
        if (Intrinsics.areEqual(r5, r6) == false) goto L34;
    L47:
        return true;
    L34:
        if (Intrinsics.areEqual(r5.getMessageId(), r6.getMessageId()) == false) goto L37;
    L48:
        return false;
    }

    public static final /* synthetic */ String access$getPicRealShareUrl(MessageShareViewModel r0, String r1, String r2) {
        return r0.getPicRealShareUrl(r1, r2);
    }

    private final Pair<Integer, Integer> processIndexWhenUseCutThreeCell(int r9, int r10, List<Message> r11) {
        Pair<Integer, Integer> r0 = new Pair(Integer.valueOf(r9), Integer.valueOf(r10));
        TextCellCutType.Companion.getClass();
        if (TextCellCutType.NewTextCell == TextCellCutType.NewCutThreeTextCell) goto L5;
        return r0;
    L5:
        if (r11 == null) goto L7;
        Message r2 = (Message) CollectionsKt.getOrNull(r11, r9);
    L8:
        if (r11 == null) goto L10;
        Message r3 = (Message) CollectionsKt.getOrNull(r11, r10);
    L11:
        int r4 = r9;
    L13:
        if ((-1) >= r9) goto L25;
        if (r11 == null) goto L25;
        Message r5 = (Message) CollectionsKt.getOrNull(r11, r9);
        if (r5 == null) goto L25;
        String r6 = r5.getMessageId();
        if (r2 == null) goto L21;
        String r7 = r2.getMessageId();
    L23:
        if (Intrinsics.areEqual(r6, r7) == false) goto L25;
        r4 = r9;
        r9 = r9 - 1;
        goto L13
    L21:
        r7 = null;
    L25:
        if (r11 == null) goto L27;
        int r12 = r11.size();
    L28:
        int r13 = r12 - 1;
    L29:
        int r8 = r10;
        r10 = r10 + 1;
        if (r10 >= r13) goto L42;
        if (r11 == null) goto L42;
        Message r14 = (Message) CollectionsKt.getOrNull(r11, r10);
        if (r14 == null) goto L42;
        String r15 = r14.getMessageId();
        if (r3 == null) goto L38;
        String r16 = r3.getMessageId();
    L40:
        if (Intrinsics.areEqual(r15, r16) == false) goto L42;
    L38:
        r16 = null;
    L42:
        if (r8 < 0) goto L62;
        if (r8 >= r13) goto L64;
        if (r4 < 0) goto L63;
        if (r4 >= r13) goto L65;
        if (r8 >= r4) goto L51;
        return r0;
    L51:
        return new Pair(Integer.valueOf(r4), Integer.valueOf(r8));
    L65:
        return r0;
    L63:
        return r0;
    L64:
        return r0;
    L62:
        return r0;
    L27:
        r12 = 0;
        goto L28
    L10:
        r3 = null;
        goto L11
    L7:
        r2 = null;
        goto L8
    }

    public final void enterSelectMode(IChatMessageShareAbility$ActionType r12, Message r13, List<Message> r14, Map<String, Object> r15) {
        Intrinsics.checkNotNullParameter(r12, "action");
        FLogger.a.i(TAG, "enterSelectMode, action=" + r12 + ", selectMessage=" + r13);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01661(this, r12, r13, r14, r15, null), 3, null);
    }

    public final boolean selectRelativeMessage(boolean r23, Integer r24, List<Message> r25, boolean r26, boolean r27) {
        if (r24 == null) goto L89;
        List<Message> r7 = r25;
        if (r7 != null) goto L7;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == true) goto L109;
        Message r9 = (Message) CollectionsKt.getOrNull(r25, r24.intValue());
        if (r9 != null) goto L16;
        return false;
    L16:
        HashSet r10 = new HashSet();
        int r11 = r25.size();
        if (r27 == false) goto L19;
    L22:
        int r12 = z2.a.getShareConfig().s();
    L24:
        if ((r24.intValue() - r12) < 0) goto L26;
        int r13 = r24.intValue() - r12;
    L28:
        if ((r24.intValue() + r12) >= r11) goto L30;
        int r14 = r24.intValue() + r12;
    L31:
        FLogger.a.i(TAG, "selectRelativeMessage " + r26 + ' ' + r27 + " isCheck=" + r23 + " pos=" + r24 + " range=" + r12 + " [" + r13 + ',' + r14 + ']');
        Iterator<T> r5 = getRelativeSelectMessages(r9, r25.subList(r13, r14 + 1)).iterator();
    L33:
        if (r5.hasNext() == false) goto L38;
        Object r6 = r5.next();
        if (canSelect((Message) r6) == false) goto L33;
        r10.add(r6);
        goto L33
    L38:
        if (com.larus.bmhome.chat.bean.d.t0(r9) == true) goto L40;
    L58:
        if (r23 == true) goto L60;
    L63:
        if (r26 == false) goto L80;
        int r2 = r24.intValue();
    L66:
        if ((-1) >= r2) goto L80;
        if (isOutOfLimit(r10.size() + 1) == true) goto L80;
        Message r4 = (Message) CollectionsKt.getOrNull(r25, r2);
        if (r4 == null) goto L79;
        if (canSelect(r4) == false) goto L79;
        if (z2.a.getShareConfig().c() == false) goto L77;
    L78:
        r10.add(r4);
        goto L79
    L77:
        if (Intrinsics.areEqual(r9.getSectionId(), r4.getSectionId()) == true) goto L78;
    L79:
        r13 = Math.min(r13, r2);
        r2 = r2 - 1;
    L80:
        Iterator r3 = r10.iterator();
    L82:
        if (r3.hasNext() == false) goto L87;
        Message r15 = (Message) r3.next();
        if (r23 == true) goto L85;
        unselectShareMsgId(r15);
        goto L82
    L85:
        selectShareMsg(r15);
        goto L82
    L87:
        Pair<Integer, Integer> r1 = processIndexWhenUseCutThreeCell(r13, r14, r25);
        this._notifyItemRangeChangedEvent.postValue(new Pair(r1.getFirst(), Integer.valueOf((((Number) r1.getSecond()).intValue() - ((Number) r1.getFirst()).intValue()) + 1)));
        return true;
    L60:
        if (isOutOfLimit(r10.size()) == false) goto L63;
        t19.s r16 = t19.s.a;
        AppHost.Companion r17 = AppHost.a;
        Application r18 = r17.getApplication();
        StringCompanionObject r19 = StringCompanionObject.INSTANCE;
        t19.s.j(r16, r18, String.format(r17.getApplication().getString(2131900871), Arrays.copyOf(new Object[]{Integer.valueOf(z2.a.getShareConfig().t())}, 1)), null, false, 28);
        this._notifyItemRangeChangedEvent.postValue(new Pair(r24, 1));
        return false;
    L40:
        if ((r24.intValue() - 1) < 0) goto L42;
        r13 = r24.intValue() - 1;
    L44:
        if ((r24.intValue() + 1) >= r11) goto L46;
        r14 = r24.intValue() + 1;
    L47:
        if (r13 > r14) goto L58;
        int r20 = r13;
    L49:
        Message r21 = (Message) CollectionsKt.getOrNull(r25, r20);
        if (r21 != null) goto L52;
    L56:
        if (r20 == r14) goto L58;
        r20 = r20 + 1;
        goto L49
    L52:
        if (com.larus.bmhome.chat.bean.d.t0(r21) == false) goto L56;
        if (canSelect(r21) == false) goto L56;
        r10.add(r21);
        goto L56
    L46:
        r14 = r11 - 1;
        goto L47
    L42:
        r13 = 0;
        goto L44
    L30:
        r14 = r11 - 1;
        goto L31
    L26:
        r13 = 0;
        goto L28
    L19:
        if (z2.a.getShareConfig().b() == false) goto L22;
        r12 = 0;
        goto L24
    L109:
        return false;
    L7:
        if (r7.isEmpty() == true) goto L10;
        r8 = false;
        goto L11
    L89:
        return false;
    }

    public final Object shareLongImage(Context r20, String r21, wc9.e r22, b r23, Continuation<? super Pair<Bitmap, Integer>> r24) {
        if ((r24 instanceof C01691) == false) goto L7;
        C01691 r4 = (C01691) r24;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        com.larus.bmhome.chat.manager.g0 r1 = (com.larus.bmhome.chat.manager.g0) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L25:
        return r3;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        b r2 = (b) r4.L$3;
        wc9.e r8 = (wc9.e) r4.L$2;
        String r9 = (String) r4.L$1;
        Context r10 = (Context) r4.L$0;
        ResultKt.throwOnFailure(r3);
        b r12 = r2;
        wc9.e r15 = r8;
        String r13 = r9;
    L20:
        Pair r11 = (Pair) r3;
        Bitmap r16 = (Bitmap) r11.component1();
        Bitmap r17 = (Bitmap) r11.component2();
        com.larus.bmhome.chat.manager.g0 r14 = new com.larus.bmhome.chat.manager.g0(r10, r12, r13, buildLongImageMessagesWithDeleteTips(CollectionsKt.sortedWith(this.shareLongImageButtonMsgIdList, new h())), r15, r16, r17, false);
        r4.L$0 = r14;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.L$3 = null;
        r4.label = 2;
        kotlinx.coroutines.j r18 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r18.C();
        ShareCvsMsgPicManager.b(r14, new i(r18));
        r3 = r18.B();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L23:
        if (r3 != r6) goto L25;
        return r6;
    L16:
        ResultKt.throwOnFailure(r3);
        CoroutineDispatcher r19 = Dispatchers.getIO();
        AnonymousClass2 r25 = new AnonymousClass2(r22, r23, null);
        r10 = r20;
        r4.L$0 = r10;
        r4.L$1 = r21;
        r4.L$2 = r22;
        r4.L$3 = r23;
        r4.label = 1;
        r3 = BuildersKt.withContext(r19, r25, r4);
        if (r3 != r6) goto L19;
        return r6;
    L19:
        r15 = r22;
        r12 = r23;
        r13 = r21;
    L7:
        r4 = new C01691(this, r24);
        goto L8
    }

    public final void doShareMessageWithPic(Context r15, String r16, String r17, wc9.e r18, b r19, boolean r20, Function2<? super Integer, ? super Bitmap, Unit> r21) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r19, "provider");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01651(this, r16, r17, r15, r19, r18, r20, r21, null), 3, null);
    }

    public static /* synthetic */ boolean selectRelativeMessage$default(MessageShareViewModel r7, boolean r8, Integer r9, List r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r13 & 16) == 0) goto L9;
        boolean r6 = false;
    L11:
        return r7.selectRelativeMessage(r8, r9, r10, r5, r6);
    L9:
        r6 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public final void shareMessageWithPic(final Context r13, final String r14, final String r15, final wc9.e r16, final b r17, Function2<? super List<String>, ? super Function1<? super Boolean, Unit>, Unit> r18, final boolean r19, final Function2<? super Integer, ? super Bitmap, Unit> r20) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r17, "provider");
        Intrinsics.checkNotNullParameter(r18, "permissionCallBack");
        if (Build.VERSION.SDK_INT <= 29) goto L5;
        doShareMessageWithPic(r13, r14, r15, r16, r17, r19, r20);
        return;
    L5:
        if (ContextCompat.checkSelfPermission(r13, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L7;
        doShareMessageWithPic(r13, r14, r15, r16, r17, r19, r20);
        return;
    L7:
        r18.invoke(CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new l1(this, r13, r14, r15, r16, r17, r19, r20));
    }

    private static final Unit shareMessageWithPic$lambda$2(MessageShareViewModel r0, Context r1, String r2, String r3, wc9.e r4, b r5, boolean r6, Function2 r7, boolean r8) {
        if (r8 == false) goto L4;
        r0.doShareMessageWithPic(r1, r2, r3, r4, r5, r6, r7);
    L7:
        return Unit.INSTANCE;
    L4:
        if (r7 == null) goto L7;
        r7.invoke(-1, null);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doShareMessageWithPic$default(MessageShareViewModel r9, Context r10, String r11, String r12, wc9.e r13, b r14, boolean r15, Function2 r16, int r17, Object r18) {
        if ((r17 & 64) == 0) goto L5;
        Function2 r8 = null;
    L6:
        r9.doShareMessageWithPic(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void shareMessageWithPic$default(MessageShareViewModel r10, Context r11, String r12, String r13, wc9.e r14, b r15, Function2 r16, boolean r17, Function2 r18, int r19, Object r20) {
        if ((r19 & 128) == 0) goto L5;
        Function2 r9 = null;
    L6:
        r10.shareMessageWithPic(r11, r12, r13, r14, r15, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }
}
