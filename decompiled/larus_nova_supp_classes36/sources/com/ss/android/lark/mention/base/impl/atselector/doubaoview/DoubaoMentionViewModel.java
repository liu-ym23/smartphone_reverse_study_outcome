package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.open_app_android.l;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.MentionUtils;
import com.ss.android.lark.mention.base.impl.atselector.bean.AtDoubaoBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.AtSelectInitData;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.LabelAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.UserGroupBean;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.viewmodel.KeyboardModel;
import com.ss.android.lark.mention.base.impl.atselector.model.ChatAtModel;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.picker.base.reporter.SearchConsistencyReporter;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 s2\u00020\u0001:\u0003stuB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00103\u001a\u000204H\u0014J\u000e\u00105\u001a\u0002042\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000204J\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020;\u0018\u00010:J\u0016\u0010<\u001a\u00020\u00162\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0002J\u0010\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020?H\u0002J\u0010\u0010B\u001a\u00020\u00162\u0006\u0010A\u001a\u00020?H\u0002J7\u0010C\u001a\b\u0012\u0004\u0012\u00020?0>2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020?0>2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010G\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010HJ\u000e\u0010I\u001a\u0002042\u0006\u0010J\u001a\u00020\u0016J\u0010\u0010K\u001a\u00020\u00162\u0006\u0010A\u001a\u00020?H\u0002J\"\u0010L\u001a\b\u0012\u0004\u0012\u00020?0>2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020?0>H\u0082@¢\u0006\u0002\u0010MJ(\u0010N\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0O2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020-0>H\u0082@¢\u0006\u0002\u0010MJ\f\u0010Q\u001a\u00020;*\u00020RH\u0002J\u0010\u0010S\u001a\u00020\u00162\b\u0010A\u001a\u0004\u0018\u00010?J\u0006\u0010T\u001a\u000204J\u0006\u0010U\u001a\u000204J\u0010\u0010V\u001a\u0002042\b\u0010W\u001a\u0004\u0018\u00010-J.\u0010X\u001a\u0002042\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>2\u0014\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020?\u0018\u00010OH\u0002J\u001e\u0010Z\u001a\b\u0012\u0004\u0012\u00020?0>2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>H\u0002J\u001c\u0010\\\u001a\u0002042\f\u0010D\u001a\b\u0012\u0004\u0012\u00020?0>H\u0082@¢\u0006\u0002\u0010MJ6\u0010]\u001a\b\u0012\u0004\u0012\u00020?0>2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>2\u0006\u0010^\u001a\u00020\u00162\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010>H\u0002J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010b\u001a\u00020cH\u0002J$\u0010d\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010b\u001a\u00020c2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020?0>H\u0002J\u001e\u0010f\u001a\u0002042\f\u0010g\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010h\u001a\u00020-H\u0002J\u001e\u0010i\u001a\u0002042\f\u0010D\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010h\u001a\u00020-H\u0002J\u0018\u0010j\u001a\b\u0012\u0004\u0012\u00020?0>*\u00020\tH\u0082@¢\u0006\u0002\u0010kJ\"\u0010l\u001a\u00020c*\u00020\t2\u0006\u0010W\u001a\u00020-2\u0006\u0010h\u001a\u00020-H\u0082@¢\u0006\u0002\u0010mJ\"\u0010n\u001a\u00020c*\u00020\t2\u0006\u0010W\u001a\u00020-2\u0006\u0010h\u001a\u00020-H\u0082@¢\u0006\u0002\u0010mJ(\u0010o\u001a\u00020p*\u00020\t2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010q\u001a\u00020-H\u0082@¢\u0006\u0002\u0010rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0015\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0017R\u0014\u0010/\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0017R\u0014\u00101\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0017¨\u0006v"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionViewModel;", "Landroidx/lifecycle/ViewModel;", "initData", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtSelectInitData;", "<init>", "(Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtSelectInitData;)V", "getInitData", "()Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtSelectInitData;", "model", "Lcom/ss/android/lark/mention/base/impl/atselector/model/ChatAtModel;", "keyboardModel", "Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/viewmodel/KeyboardModel;", "getKeyboardModel", "()Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/viewmodel/KeyboardModel;", "keyboardModel$delegate", "Lkotlin/Lazy;", "recommendDataLoader", "Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionRecommendDataLoader;", "getRecommendDataLoader", "()Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionRecommendDataLoader;", "recommendDataLoader$delegate", "isDoubaoBUser", "", "()Z", "isDoubaoBUser$delegate", "doubaoChatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "getDoubaoChatter", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "setDoubaoChatter", "(Lcom/ss/android/lark/chat/entity/chatter/Chatter;)V", "enableDoubaoMention", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "searchJob", "Lkotlinx/coroutines/Job;", "loadDoubaoChatterJob", "excludeOutChatUser", "openIdMappings", "Ljava/util/concurrent/ConcurrentHashMap;", "", "isFromDoubaoBot", "shouldShowDepartmentInSearch", "getShouldShowDepartmentInSearch", "shouldTransformOpenId", "getShouldTransformOpenId", "onCleared", "", "loadDoubaoChatter", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loadRecommend", "getSelectedResult", "", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "isEmptyAfterOpenIdTransform", "data", "", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/BaseAtBean;", "isPersonMentionItem", "item", "isDoubaoMentionItem", "applyDoubaoMentionPolicy", "items", "insertPosition", "", "allowInsertIntoEmpty", "(Ljava/util/List;Ljava/lang/Integer;Z)Ljava/util/List;", "updateDoubaoMentionEnabled", "enabled", "requiresOpenId", "transformOpenIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOpenIds", "", "userIds", "toChatChatter", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/SearchBean;", "setSelectedResult", "resetSelectedResult", "clearSearch", LocationHitPoint$ResultType.SEARCH, "searchKey", "setSelectedStatus", "selected", "handleLocalSearchData", "inChatUsers", "enrichTagStateFromLocalChatters", "handleInChatSearchDataAndUserGroup", "hasOutChatResult", "userGroupList", "Lcom/ss/android/lark/dto/usergroup/UserGroupEntity;", "handleNetSearchData", "response", "Lcom/ss/android/lark/dto/chat/MentionChatChatterResponse;", "handleNetSearchDataWithMergeOld", "oldData", "updateSensitiveInfoIfNeeded", "beans", "requestId", "emitSearchSuccess", "awaitRecommendData", "(Lcom/ss/android/lark/mention/base/impl/atselector/model/ChatAtModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLocalSearch", "(Lcom/ss/android/lark/mention/base/impl/atselector/model/ChatAtModel;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNetSearch", "awaitSensitiveInfo", "Lcom/ss/android/lark/dto/chat/ChatterSensitiveInfoResponse;", "sensitiveRequestId", "(Lcom/ss/android/lark/mention/base/impl/atselector/model/ChatAtModel;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "RequestStatus", "OpenIdTransformException", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DoubaoMentionViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DoubaoMentionVM";
    private final z0<j> _uiState;
    private Chatter doubaoChatter;
    private boolean enableDoubaoMention;
    private boolean excludeOutChatUser;
    private final AtSelectInitData initData;
    private final Lazy isDoubaoBUser$delegate;
    private final Lazy keyboardModel$delegate;
    private Job loadDoubaoChatterJob;
    private final ChatAtModel model;
    private final ConcurrentHashMap<String, String> openIdMappings;
    private final Lazy recommendDataLoader$delegate;
    private Job searchJob;
    private final i1<j> uiState;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionViewModel$OpenIdTransformException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", INotificationHitPoint.NoticeType.MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class OpenIdTransformException extends RuntimeException {
        public OpenIdTransformException(String r2) {
            Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionViewModel$RequestStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_ARRIVE", "AVAILABLE", "EMPTY", "ERROR", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum RequestStatus extends Enum<RequestStatus> {
        public static final RequestStatus AVAILABLE = null;
        public static final RequestStatus EMPTY = null;
        public static final RequestStatus ERROR = null;
        public static final RequestStatus NOT_ARRIVE = null;
        public static final /* synthetic */ RequestStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<RequestStatus> getEntries() {
            return b;
        }

        static {
            RequestStatus r0 = new RequestStatus("NOT_ARRIVE", 0);
            NOT_ARRIVE = r0;
            RequestStatus r1 = new RequestStatus("AVAILABLE", 1);
            AVAILABLE = r1;
            RequestStatus r3 = new RequestStatus("EMPTY", 2);
            EMPTY = r3;
            RequestStatus r5 = new RequestStatus("ERROR", 3);
            ERROR = r5;
            RequestStatus[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static RequestStatus[] values() {
            return (RequestStatus[]) a.clone();
        }

        public static RequestStatus valueOf(String r1) {
            return (RequestStatus) r27.a.a(RequestStatus.class, r1);
        }

        public RequestStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.lark.open_app_android.d {
        public final /* synthetic */ kotlinx.coroutines.i<Map<String, String>> a;

        public b(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onSuccess(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r2));
            return;
        }

        public final void onFailed(int r5, String r6) {
            Intrinsics.checkNotNullParameter(r6, "errorMsg");
            if (this.a.isActive() == false) goto L6;
            kotlinx.coroutines.i<Map<String, String>> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(new OpenIdTransformException("fetch openIds failed, code=" + r5 + ", message=" + r6))));
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$enrichTagStateFromLocalChatters$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel", f = "DoubaoMentionViewModel.kt", i = {0, 0}, l = {567}, m = "enrichTagStateFromLocalChatters", n = {"searchBeans", "chatterIds"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoubaoMentionViewModel this$0;

        public AnonymousClass1(DoubaoMentionViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Target.SIZE_ORIGINAL;
            return DoubaoMentionViewModel.access$enrichTagStateFromLocalChatters(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$loadDoubaoChatter$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$loadDoubaoChatter$1", f = "DoubaoMentionViewModel.kt", i = {}, l = {128, 136}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoubaoMentionViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$loadDoubaoChatter$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        @DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$loadDoubaoChatter$1$1", f = "DoubaoMentionViewModel.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DoubaoMentionViewModel this$0;

            public C01741(DoubaoMentionViewModel r1, Continuation<? super C01741> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C01741 r0 = new C01741(this.this$0, r4);
                r0.L$0 = r3;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Result<Unit>> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L10;
                if (r1 != 1) goto L9;
                DoubaoMentionViewModel r2 = (DoubaoMentionViewModel) this.L$0;
                ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L17
            L15:
                r2.setDoubaoChatter((Chatter) r5);     // Catch: Throwable -> L17
                Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
            L19:
                Throwable r3 = Result.exceptionOrNull-impl(r6);
                if (r3 == null) goto L23;
                Log.e(DoubaoMentionViewModel.TAG, "loadDoubaoChatter failed", r3);
            L23:
                return Result.box-impl(r6);
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                ResultKt.throwOnFailure(r5);
                CoroutineScope r7 = (CoroutineScope) this.L$0;
                DoubaoMentionViewModel r8 = this.this$0;
                Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
                KeyboardModel r9 = DoubaoMentionViewModel.access$getKeyboardModel(r8);     // Catch: Throwable -> L17
                SyncDataStrategy r10 = SyncDataStrategy.TRY_LOCAL;     // Catch: Throwable -> L17
                this.L$0 = r8;     // Catch: Throwable -> L17
                this.label = 1;     // Catch: Throwable -> L17
                Object r11 = r9.a(r10, this);     // Catch: Throwable -> L17
                if (r11 != r0) goto L14;
                return r0;
            L14:
                r2 = r8;
                r5 = r11;
            L17:
                th = move-exception;
                Result.Companion r12 = Result.Companion;
                r6 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L19
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$loadDoubaoChatter$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        @DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$loadDoubaoChatter$1$2", f = "DoubaoMentionViewModel.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DoubaoMentionViewModel this$0;

            public AnonymousClass2(DoubaoMentionViewModel r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
                r0.L$0 = r3;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L10;
                if (r1 != 1) goto L9;
                DoubaoMentionViewModel r2 = (DoubaoMentionViewModel) this.L$0;
                ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L21
            L15:
                Chatter r6 = (Chatter) r5;     // Catch: Throwable -> L21
                if (r6 == null) goto L18;
                r2.setDoubaoChatter(r6);     // Catch: Throwable -> L21
            L19:
                Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L21
            L23:
                Throwable r8 = Result.exceptionOrNull-impl(r7);
                if (r8 == null) goto L27;
                Log.e(DoubaoMentionViewModel.TAG, "loadDoubaoChatter failed", r8);
            L27:
                return Unit.INSTANCE;
            L18:
                r6 = null;
                goto L19
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                ResultKt.throwOnFailure(r5);
                CoroutineScope r9 = (CoroutineScope) this.L$0;
                DoubaoMentionViewModel r10 = this.this$0;
                Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
                KeyboardModel r4 = DoubaoMentionViewModel.access$getKeyboardModel(r10);     // Catch: Throwable -> L21
                SyncDataStrategy r11 = SyncDataStrategy.FORCE_SERVER;     // Catch: Throwable -> L21
                this.L$0 = r10;     // Catch: Throwable -> L21
                this.label = 1;     // Catch: Throwable -> L21
                Object r12 = r4.a(r11, this);     // Catch: Throwable -> L21
                if (r12 != r0) goto L14;
                return r0;
            L14:
                r2 = r10;
                r5 = r12;
            L21:
                th = move-exception;
                Result.Companion r13 = Result.Companion;
                r7 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L23
            }
        }

        public C04331(DoubaoMentionViewModel r1, Continuation<? super C04331> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04331(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L13:
            CoroutineDispatcher r8 = Dispatchers.getIO();
            AnonymousClass2 r2 = new AnonymousClass2(this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r8, r2, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            CoroutineDispatcher r9 = Dispatchers.getIO();
            C01741 r3 = new C01741(this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r9, r3, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$loadRecommend$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$loadRecommend$1", f = "DoubaoMentionViewModel.kt", i = {1}, l = {163, 165, 166, 168}, m = "invokeSuspend", n = {"recommendData"}, s = {"L$1"})
    public static final class C04341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DoubaoMentionViewModel this$0;

        public C04341(DoubaoMentionViewModel r1, Continuation<? super C04341> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04341 r0 = new C04341(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
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
            if (r1 == 0) goto L20;
            if (r1 == 1) goto L17;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            if (r1 != 4) goto L11;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L40
        L37:
            List r16 = (List) r15;     // Catch: Throwable -> L40
        L38:
            Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L40
        L42:
            DoubaoMentionViewModel r6 = this.this$0;
            if (Result.isSuccess-impl(r17) == false) goto L57;
            List r2 = (List) r17;
            if (DoubaoMentionViewModel.access$getShouldTransformOpenId(r6) == false) goto L47;
            List r3 = DoubaoMentionViewModel.applyDoubaoMentionPolicy$default(r6, r2, null, false, 6, null);
        L49:
            if (DoubaoMentionViewModel.access$getShouldTransformOpenId(r6) == false) goto L51;
            boolean r4 = DoubaoMentionViewModel.access$isEmptyAfterOpenIdTransform(r6, r3);
        L52:
            z0 r5 = DoubaoMentionViewModel.access$get_uiState$p(r6);
            j r7 = (j) DoubaoMentionViewModel.access$get_uiState$p(r6).getValue();
            if (r4 == false) goto L55;
            com.ss.android.lark.mention.base.impl.atselector.doubaoview.b r8 = com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.a.a;
        L56:
            r5.setValue(j.a(r7, r8, null, null, null, 0, false, false, 254));
            goto L57
        L55:
            r8 = new com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.e(r3);
            goto L56
        L51:
            r4 = r3.isEmpty();
            goto L52
        L47:
            r3 = DoubaoMentionViewModel.access$applyDoubaoMentionPolicy(r6, r2, Boxing.boxInt(DoubaoMentionViewModel.access$getModel$p(r6).p() ? 1 : 0), false);
        L57:
            DoubaoMentionViewModel r9 = this.this$0;
            Throwable r18 = Result.exceptionOrNull-impl(r17);
            if (r18 == null) goto L61;
            DoubaoMentionViewModel.access$get_uiState$p(r9).setValue(j.a((j) DoubaoMentionViewModel.access$get_uiState$p(r9).getValue(), new com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.C0175b(r18), null, null, null, 0, false, false, 254));
        L61:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L40
        L33:
            r16 = (List) r15;     // Catch: Throwable -> L40
            goto L38
        L14:
            List r10 = (List) this.L$1;
            DoubaoMentionViewModel r11 = (DoubaoMentionViewModel) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L40
        L30:
            this.L$0 = null;     // Catch: Throwable -> L40
            this.L$1 = null;     // Catch: Throwable -> L40
            this.label = 3;     // Catch: Throwable -> L40
            r15 = DoubaoMentionViewModel.access$transformOpenIds(r11, r10, this);     // Catch: Throwable -> L40
            if (r15 != r0) goto L33;
            return r0;
        L17:
            DoubaoMentionViewModel r12 = (DoubaoMentionViewModel) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L40
            Object r19 = ((Result) r15).unbox-impl();     // Catch: Throwable -> L40
            r11 = r12;
        L27:
            ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L40
            r10 = (List) r19;     // Catch: Throwable -> L40
            this.L$0 = r11;     // Catch: Throwable -> L40
            this.L$1 = r10;     // Catch: Throwable -> L40
            this.label = 2;     // Catch: Throwable -> L40
            if (DoubaoMentionViewModel.access$enrichTagStateFromLocalChatters(r11, r10, this) != r0) goto L30;
            return r0;
        L20:
            ResultKt.throwOnFailure(r15);
            CoroutineScope r110 = (CoroutineScope) this.L$0;
            DoubaoMentionViewModel r111 = this.this$0;
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L40
            if (DoubaoMentionViewModel.access$getShouldTransformOpenId(r111) == false) goto L34;
            DoubaoMentionRecommendDataLoader r14 = DoubaoMentionViewModel.access$getRecommendDataLoader(r111);     // Catch: Throwable -> L40
            this.L$0 = r111;     // Catch: Throwable -> L40
            this.label = 1;     // Catch: Throwable -> L40
            Object r20 = r14.a(this);     // Catch: Throwable -> L40
            if (r20 != r0) goto L26;
            return r0;
        L26:
            r11 = r111;
            r19 = r20;
            goto L27
        L34:
            ChatAtModel r21 = DoubaoMentionViewModel.access$getModel$p(r111);     // Catch: Throwable -> L40
            this.label = 4;     // Catch: Throwable -> L40
            r15 = DoubaoMentionViewModel.access$awaitRecommendData(r111, r21, this);     // Catch: Throwable -> L40
            if (r15 != r0) goto L37;
            return r0;
        L40:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r17 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L42
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$search$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$search$1", f = "DoubaoMentionViewModel.kt", i = {}, l = {457, 460}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $requestId;
        final /* synthetic */ String $searchKey;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoubaoMentionViewModel this$0;

        public C04351(DoubaoMentionViewModel r1, String r2, String r3, Continuation<? super C04351> r4) {
            this.this$0 = r1;
            this.$requestId = r2;
            this.$searchKey = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C04351 r0 = new C04351(this.this$0, this.$requestId, this.$searchKey, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L22
        L20:
            Object r14 = Result.constructor-impl((List) r13);     // Catch: Throwable -> L22
        L24:
            DoubaoMentionViewModel r2 = this.this$0;
            String r4 = this.$requestId;
            if (Result.isSuccess-impl(r14) == false) goto L43;
            List r5 = (List) r14;
            if (Intrinsics.areEqual(((j) DoubaoMentionViewModel.access$get_uiState$p(r2).getValue()).d, r4) == false) goto L43;
            List<BaseAtBean> r6 = DoubaoMentionViewModel.applyDoubaoMentionPolicy$default(r2, r5, null, false, 6, null);
            DoubaoMentionViewModel.access$getModel$p(r2).U0(r4, r6);
            List<BaseAtBean> r7 = r6;
            if ((r7 instanceof Collection) == true) goto L31;
        L33:
            Iterator<T> r8 = r7.iterator();
        L35:
            if (r8.hasNext() == false) goto L39;
            if (DoubaoMentionViewModel.access$isPersonMentionItem(r2, (BaseAtBean) r8.next()) == false) goto L35;
        L40:
            if (r3 == false) goto L42;
            DoubaoMentionViewModel.access$emitSearchSuccess(r2, r6, r4);
            goto L43
        L42:
            DoubaoMentionViewModel.access$get_uiState$p(r2).setValue(j.a((j) DoubaoMentionViewModel.access$get_uiState$p(r2).getValue(), null, com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.a.a, null, null, 0, false, false, 253));
        L39:
            r3 = false;
            goto L40
        L31:
            if (r7.isEmpty() == false) goto L33;
        L43:
            DoubaoMentionViewModel r9 = this.this$0;
            String r10 = this.$requestId;
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L49;
            if (Intrinsics.areEqual(((j) DoubaoMentionViewModel.access$get_uiState$p(r9).getValue()).d, r10) == false) goto L49;
            DoubaoMentionViewModel.access$search$emitSearchError(r9, r15);
        L49:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            DoubaoMentionViewModel r11 = (DoubaoMentionViewModel) this.L$0;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L22
            Object r16 = ((Result) r13).unbox-impl();     // Catch: Throwable -> L22
        L17:
            ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L22
            List r17 = (List) r16;     // Catch: Throwable -> L22
            DoubaoMentionViewModel.access$setSelectedStatus(r11, r17, DoubaoMentionViewModel.access$getModel$p(r11).f);     // Catch: Throwable -> L22
            this.L$0 = null;     // Catch: Throwable -> L22
            this.label = 2;     // Catch: Throwable -> L22
            r13 = DoubaoMentionViewModel.access$transformOpenIds(r11, r17, this);     // Catch: Throwable -> L22
            if (r13 != r0) goto L20;
            return r0;
        L13:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r18 = (CoroutineScope) this.L$0;
            r11 = this.this$0;
            String r19 = this.$requestId;
            String r12 = this.$searchKey;
            Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L22
            DoubaoMentionRecommendDataLoader r21 = DoubaoMentionViewModel.access$getRecommendDataLoader(r11);     // Catch: Throwable -> L22
            Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L22
            this.L$0 = r11;     // Catch: Throwable -> L22
            this.label = 1;     // Catch: Throwable -> L22
            r16 = r21.b(r19, r12, this);     // Catch: Throwable -> L22
            if (r16 != r0) goto L17;
            return r0;
        L22:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L24
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$search$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$search$2", f = "DoubaoMentionViewModel.kt", i = {0, 2}, l = {488, 514, 518}, m = "invokeSuspend", n = {"net", "data"}, s = {"L$0", "L$5"})
    public static final class C04362 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<RequestStatus> $localStatus;
        final /* synthetic */ Ref.ObjectRef<RequestStatus> $netStatus;
        final /* synthetic */ String $requestId;
        final /* synthetic */ String $searchKey;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ DoubaoMentionViewModel this$0;

        public C04362(DoubaoMentionViewModel r1, String r2, String r3, Ref.ObjectRef<RequestStatus> r4, Ref.ObjectRef<RequestStatus> r5, Continuation<? super C04362> r6) {
            this.this$0 = r1;
            this.$searchKey = r2;
            this.$requestId = r3;
            this.$netStatus = r4;
            this.$localStatus = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            C04362 r7 = new C04362(this.this$0, this.$searchKey, this.$requestId, this.$netStatus, this.$localStatus, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L13;
            if (r2 == 1) goto L12;
            if (r2 == 2) goto L11;
            if (r2 != 3) goto L10;
            List r3 = (List) this.L$5;
            Ref.ObjectRef<RequestStatus> r4 = (Ref.ObjectRef) this.L$4;
            Ref.ObjectRef<RequestStatus> r5 = (Ref.ObjectRef) this.L$3;
            String r6 = (String) this.L$2;
            DoubaoMentionViewModel r7 = (DoubaoMentionViewModel) this.L$1;
            Object r8 = this.L$0;
            ResultKt.throwOnFailure(r18);
            DoubaoMentionViewModel r11 = r7;
        L8:
            Object r12 = r8;
            if (Intrinsics.areEqual(((j) DoubaoMentionViewModel.access$get_uiState$p(r11).getValue()).d, r6) == false) goto L81;
            ArrayList r9 = new ArrayList();
            Iterator r10 = r3.iterator();
        L66:
            if (r10.hasNext() == false) goto L77;
            Object r13 = r10.next();
            BaseAtBean r14 = (BaseAtBean) r13;
            if ((r14 instanceof SearchBean) == true) goto L70;
        L74:
            boolean r15 = false;
        L75:
            if (r15 == false) goto L66;
            r9.add(r13);
            goto L66
        L70:
            if (((SearchBean) r14).isOutChatUser() == true) goto L72;
        L73:
            r15 = true;
            goto L75
        L72:
            if (DoubaoMentionViewModel.access$isDoubaoBUser(r11) == false) goto L74;
        L77:
            DoubaoMentionViewModel r16 = r11;
            List<BaseAtBean> r17 = DoubaoMentionViewModel.applyDoubaoMentionPolicy$default(r16, r9, Boxing.boxInt(0), false, 4, null);
            DoubaoMentionViewModel.access$setSelectedStatus(r11, r17, DoubaoMentionViewModel.access$getModel$p(r11).f);
            DoubaoMentionViewModel.access$getModel$p(r11).U0(r6, r17);
            if (r17.isEmpty() == false) goto L80;
            r5.element = RequestStatus.EMPTY;
            DoubaoMentionViewModel.access$search$maybeEmitEmptyOrError(r5, r4, r11);
            goto L81
        L80:
            r5.element = RequestStatus.AVAILABLE;
            DoubaoMentionViewModel.access$emitSearchSuccess(r11, r17, r6);
        L81:
            r8 = r12;
        L82:
            DoubaoMentionViewModel r19 = this.this$0;
            String r20 = this.$requestId;
            Ref.ObjectRef<RequestStatus> r21 = this.$netStatus;
            Ref.ObjectRef<RequestStatus> r22 = this.$localStatus;
            if (Result.exceptionOrNull-impl(r8) == null) goto L88;
            if (Intrinsics.areEqual(((j) DoubaoMentionViewModel.access$get_uiState$p(r19).getValue()).d, r20) == false) goto L88;
            r21.element = RequestStatus.ERROR;
            DoubaoMentionViewModel.access$search$maybeEmitEmptyOrError(r21, r22, r19);
        L88:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r18);
            Object r23 = r18;
        L51:
            r8 = ((Result) r23).unbox-impl();
            DoubaoMentionViewModel r24 = this.this$0;
            r6 = this.$requestId;
            r5 = this.$netStatus;
            r4 = this.$localStatus;
            if (Result.isSuccess-impl(r8) == false) goto L82;
            ccb.d r25 = (ccb.d) r8;
            if (Intrinsics.areEqual(((j) DoubaoMentionViewModel.access$get_uiState$p(r24).getValue()).d, r6) == false) goto L82;
            if (Intrinsics.areEqual(r25.f, r6) == false) goto L82;
            List r26 = DoubaoMentionViewModel.access$handleNetSearchDataWithMergeOld(r24, r25, DoubaoMentionViewModel.access$getModel$p(r24).e);
            this.L$0 = r8;
            this.L$1 = r24;
            this.L$2 = r6;
            this.L$3 = r5;
            this.L$4 = r4;
            this.L$5 = r26;
            this.label = 3;
            if (DoubaoMentionViewModel.access$enrichTagStateFromLocalChatters(r24, r26, this) != r1) goto L61;
            return r1;
        L61:
            r11 = r24;
            r3 = r26;
            goto L8
        L12:
            Deferred r27 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r28 = r18;
        L16:
            Object r29 = ((Result) r28).unbox-impl();
            DoubaoMentionViewModel r110 = this.this$0;
            String r111 = this.$requestId;
            Ref.ObjectRef<RequestStatus> r112 = this.$netStatus;
            Ref.ObjectRef<RequestStatus> r113 = this.$localStatus;
            if (Result.isSuccess-impl(r29) == false) goto L43;
            ccb.d r30 = (ccb.d) r29;
            if (Intrinsics.areEqual(((j) DoubaoMentionViewModel.access$get_uiState$p(r110).getValue()).d, r111) == false) goto L43;
            if (Intrinsics.areEqual(r30.f, r111) == false) goto L43;
            if (r112.element == RequestStatus.AVAILABLE) goto L43;
            List r31 = DoubaoMentionViewModel.access$handleLocalSearchData(r110, r30.b);
            ArrayList r114 = new ArrayList();
            Iterator r32 = r31.iterator();
        L27:
            if (r32.hasNext() == false) goto L39;
            Object r115 = r32.next();
            BaseAtBean r33 = (BaseAtBean) r115;
            if ((r33 instanceof SearchBean) == true) goto L31;
        L35:
            boolean r34 = false;
        L36:
            if (r34 == false) goto L27;
            r114.add(r115);
            goto L27
        L31:
            if (((SearchBean) r33).isOutChatUser() == true) goto L33;
        L34:
            r34 = true;
            goto L36
        L33:
            if (DoubaoMentionViewModel.access$isDoubaoBUser(r110) == false) goto L35;
        L39:
            List<BaseAtBean> r35 = DoubaoMentionViewModel.applyDoubaoMentionPolicy$default(r110, r114, Boxing.boxInt(0), false, 4, null);
            DoubaoMentionViewModel.access$setSelectedStatus(r110, r35, DoubaoMentionViewModel.access$getModel$p(r110).f);
            DoubaoMentionViewModel.access$getModel$p(r110).U0(r111, r35);
            if (r35.isEmpty() == false) goto L42;
            r113.element = RequestStatus.EMPTY;
            DoubaoMentionViewModel.access$search$maybeEmitEmptyOrError(r112, r113, r110);
            goto L43
        L42:
            r113.element = RequestStatus.AVAILABLE;
            DoubaoMentionViewModel.access$emitSearchSuccess(r110, r35, r111);
        L43:
            DoubaoMentionViewModel r36 = this.this$0;
            String r37 = this.$requestId;
            Ref.ObjectRef<RequestStatus> r38 = this.$localStatus;
            Ref.ObjectRef<RequestStatus> r39 = this.$netStatus;
            if (Result.exceptionOrNull-impl(r29) != null) goto L46;
        L48:
            this.L$0 = null;
            this.label = 2;
            r23 = r27.await(this);
            if (r23 != r1) goto L51;
            return r1;
        L46:
            if (Intrinsics.areEqual(((j) DoubaoMentionViewModel.access$get_uiState$p(r36).getValue()).d, r37) == false) goto L48;
            r38.element = RequestStatus.ERROR;
            DoubaoMentionViewModel.access$search$maybeEmitEmptyOrError(r39, r38, r36);
            goto L48
        L13:
            ResultKt.throwOnFailure(r18);
            CoroutineScope r40 = (CoroutineScope) this.L$0;
            Deferred r116 = BuildersKt.async$default(r40, null, null, new DoubaoMentionViewModel$search$2$local$1(this.this$0, this.$searchKey, this.$requestId, null), 3, null);
            r27 = BuildersKt.async$default(r40, null, null, new DoubaoMentionViewModel$search$2$net$1(this.this$0, this.$searchKey, this.$requestId, null), 3, null);
            this.L$0 = r27;
            this.label = 1;
            r28 = r116.await(this);
            if (r28 != r1) goto L16;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$transformOpenIds$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel", f = "DoubaoMentionViewModel.kt", i = {0}, l = {331}, m = "transformOpenIds", n = {"items"}, s = {"L$0"})
    public static final class C04371 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoubaoMentionViewModel this$0;

        public C04371(DoubaoMentionViewModel r1, Continuation<? super C04371> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Target.SIZE_ORIGINAL;
            return DoubaoMentionViewModel.access$transformOpenIds(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$updateSensitiveInfoIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$updateSensitiveInfoIfNeeded$1", f = "DoubaoMentionViewModel.kt", i = {}, l = {709}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<BaseAtBean> $beans;
        final /* synthetic */ String $requestId;
        final /* synthetic */ List<SearchBean> $searchBeans;
        final /* synthetic */ String $sensitiveReqId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoubaoMentionViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C04391(DoubaoMentionViewModel r1, List<? extends SearchBean> r2, String r3, String r4, List<? extends BaseAtBean> r5, Continuation<? super C04391> r6) {
            this.this$0 = r1;
            this.$searchBeans = r2;
            this.$sensitiveReqId = r3;
            this.$requestId = r4;
            this.$beans = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            C04391 r7 = new C04391(this.this$0, this.$searchBeans, this.$sensitiveReqId, this.$requestId, this.$beans, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L8;
            ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L15
            Object r3 = r20;
        L13:
            Object r1 = Result.constructor-impl((ccb.b) r3);     // Catch: Throwable -> L15
        L17:
            DoubaoMentionViewModel r8 = this.this$0;
            String r4 = this.$requestId;
            String r5 = this.$sensitiveReqId;
            List<SearchBean> r6 = this.$searchBeans;
            List<BaseAtBean> r7 = this.$beans;
            if (Result.isSuccess-impl(r1) == false) goto L30;
            ccb.b r9 = (ccb.b) r1;
            if (Intrinsics.areEqual(((j) DoubaoMentionViewModel.access$get_uiState$p(r8).getValue()).d, r4) == false) goto L30;
            if (Intrinsics.areEqual(r9.a, r5) == false) goto L30;
            if (CollectionUtils.isEmpty(r6) == true) goto L30;
            DoubaoMentionViewModel.access$getModel$p(r8).d1(r9.b, r6);
            if (DoubaoMentionViewModel.access$getShouldTransformOpenId(r8) == false) goto L28;
            Integer r10 = null;
        L29:
            List r11 = DoubaoMentionViewModel.applyDoubaoMentionPolicy$default(r8, r7, r10, false, 4, null);
            z0 r12 = DoubaoMentionViewModel.access$get_uiState$p(r8);
            int r13 = h.a;
            j r14 = (j) DoubaoMentionViewModel.access$get_uiState$p(r8).getValue();
            boolean r16 = DoubaoMentionViewModel.access$getShouldShowDepartmentInSearch(r8);
            Intrinsics.checkNotNullParameter(r14, "state");
            Intrinsics.checkNotNullParameter(r11, "items");
            r12.setValue(j.a(r14, null, new com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.e(r11), null, null, r14.e + 1, r16, false, 205));
            goto L30
        L28:
            r10 = Boxing.boxInt(0);
        L30:
            Throwable r15 = Result.exceptionOrNull-impl(r1);
            if (r15 == null) goto L34;
            Log.e(DoubaoMentionViewModel.TAG, "sensitive info error", r15);
        L34:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r20);
            CoroutineScope r17 = (CoroutineScope) this.L$0;
            DoubaoMentionViewModel r18 = this.this$0;
            List<SearchBean> r19 = this.$searchBeans;
            String r21 = this.$sensitiveReqId;
            Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L15
            ChatAtModel r23 = DoubaoMentionViewModel.access$getModel$p(r18);     // Catch: Throwable -> L15
            Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            r3 = DoubaoMentionViewModel.access$awaitSensitiveInfo(r18, r23, r19, r21, this);     // Catch: Throwable -> L15
            if (r3 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r24 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        }
    }

    static {
        Companion = new a();
    }

    private final KeyboardModel getKeyboardModel() {
        return (KeyboardModel) this.keyboardModel$delegate.getValue();
    }

    private final DoubaoMentionRecommendDataLoader getRecommendDataLoader() {
        return (DoubaoMentionRecommendDataLoader) this.recommendDataLoader$delegate.getValue();
    }

    private final boolean getShouldTransformOpenId() {
        if (this.initData.getAppId().length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isDoubaoBUser() {
        return ((Boolean) this.isDoubaoBUser$delegate.getValue()).booleanValue();
    }

    private final boolean isFromDoubaoBot() {
        if (this.initData.getAppId().length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void clearSearch() {
        Job r0 = this.searchJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        ChatAtModel r1 = this.model;
        r1.g = "";
        r1.h = "";
        ((ArrayList) r1.e).clear();
        z0<j> r2 = this._uiState;
        r2.setValue(j.a((j) r2.getValue(), null, com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.c.a, "", "", 0, getShouldShowDepartmentInSearch(), false, 193));
    }

    public final Map<String, ChatChatter> getSelectedResult() {
        Map<String, ChatChatter> r0 = this.model.N4();
        if (getShouldTransformOpenId() == false) goto L31;
        Collection r1 = ((LinkedHashMap) this.model.f).values();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if ((r4 instanceof SearchBean) == false) goto L6;
        r2.add(r4);
        goto L6
    L10:
        Iterator r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        SearchBean r6 = (SearchBean) r5.next();
        HashMap r7 = (HashMap) r0;
        if (r7.containsKey(r6.getId()) == true) goto L12;
        r7.put(r6.getId(), toChatChatter(r6));
        goto L12
    L16:
        Iterator r8 = ((HashMap) r0).values().iterator();
    L18:
        if (r8.hasNext() == false) goto L31;
        ChatChatter r9 = (ChatChatter) r8.next();
        String r10 = this.openIdMappings.get(r9.getId());
        if (r10 == null) goto L30;
        if (r10.length() <= 0) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == true) goto L28;
        r10 = null;
    L28:
        if (r10 == null) goto L30;
        r9.setOpenId(r10);
        goto L30
    L24:
        r11 = false;
    L30:
        r9.getChatter().setOpenAppId(this.initData.getAppId());
    L31:
        return r0;
    }

    public final void loadRecommend() {
        z0<j> r0 = this._uiState;
        j r2 = (j) r0.getValue();
        boolean r9 = getShouldShowDepartmentInSearch();
        r0.setValue(j.a(r2, com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.d.a, null, "", "", 0, r9, false, 210));
        if (getShouldTransformOpenId() == true) goto L5;
        loadDoubaoChatter(ViewModelKt.getViewModelScope(this));
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04341(this, null), 3, null);
    }

    public void onCleared() {
        this.model.destroy();
        Job r0 = this.searchJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Job r1 = this.loadDoubaoChatterJob;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        super.onCleared();
    }

    public final void resetSelectedResult() {
        ((LinkedHashMap) this.model.f).clear();
    }

    private final boolean getShouldShowDepartmentInSearch() {
        if (isDoubaoBUser() == false) goto L5;
    L8:
        return true;
    L5:
        if (isFromDoubaoBot() == true) goto L8;
        return false;
    }

    public final Chatter getDoubaoChatter() {
        return this.doubaoChatter;
    }

    public final AtSelectInitData getInitData() {
        return this.initData;
    }

    public final i1<j> getUiState() {
        return this.uiState;
    }

    public DoubaoMentionViewModel(AtSelectInitData r4) {
        Intrinsics.checkNotNullParameter(r4, "initData");
        this.initData = r4;
        ChatAtModel r0 = new ChatAtModel(r4);
        r0.create();
        this.model = r0;
        this.keyboardModel$delegate = LazyKt.lazy(DoubaoMentionViewModel$keyboardModel$2.INSTANCE);
        this.recommendDataLoader$delegate = LazyKt.lazy(DoubaoMentionViewModel$recommendDataLoader$2.INSTANCE);
        this.isDoubaoBUser$delegate = LazyKt.lazy(new AnonymousClass2(this));
        this.enableDoubaoMention = r4.isEnableDoubaoMention();
        StateFlowImpl r5 = j1.a(new j(isFromDoubaoBot(), this.enableDoubaoMention, 63));
        this._uiState = r5;
        this.uiState = r5;
        this.excludeOutChatUser = true;
        this.openIdMappings = new ConcurrentHashMap();
    }

    public static final /* synthetic */ KeyboardModel access$getKeyboardModel(DoubaoMentionViewModel r0) {
        return r0.getKeyboardModel();
    }

    public static final /* synthetic */ ChatAtModel access$getModel$p(DoubaoMentionViewModel r0) {
        return r0.model;
    }

    public static final /* synthetic */ DoubaoMentionRecommendDataLoader access$getRecommendDataLoader(DoubaoMentionViewModel r0) {
        return r0.getRecommendDataLoader();
    }

    public static final /* synthetic */ boolean access$getShouldShowDepartmentInSearch(DoubaoMentionViewModel r0) {
        return r0.getShouldShowDepartmentInSearch();
    }

    public static final /* synthetic */ boolean access$getShouldTransformOpenId(DoubaoMentionViewModel r0) {
        return r0.getShouldTransformOpenId();
    }

    public static final /* synthetic */ z0 access$get_uiState$p(DoubaoMentionViewModel r0) {
        return r0._uiState;
    }

    public static final /* synthetic */ boolean access$isDoubaoBUser(DoubaoMentionViewModel r0) {
        return r0.isDoubaoBUser();
    }

    private final List<BaseAtBean> handleLocalSearchData(List<? extends ChatChatter> r3) {
        return brb.a.a(handleInChatSearchDataAndUserGroup(r3, false, null));
    }

    private final List<BaseAtBean> handleNetSearchData(ccb.d r6) {
        List<? extends ChatChatter> r0 = r6.b;
        List r1 = r6.c;
        List<UserGroupEntity> r7 = r6.g;
        ArrayList r2 = new ArrayList();
        if (CollectionUtils.isEmpty(r1) == false) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r2.addAll(handleInChatSearchDataAndUserGroup(r0, r3, r7));
        if (CollectionUtils.isEmpty(r1) == false) goto L13;
        return brb.a.a(r2);
    L13:
        if (this.model.T0() == false) goto L15;
        LabelAtBean r8 = new LabelAtBean(UIHelper.getString(2131890339), UIHelper.getString(2131890857));
    L16:
        r2.add(r8);
        if (r1 != null) goto L19;
        r1 = CollectionsKt.emptyList();
    L19:
        Iterator r9 = r1.iterator();
    L21:
        if (r9.hasNext() == false) goto L24;
        SearchBean r4 = new SearchBean(com.ss.android.lark.mention.base.impl.atselector.bean.b.a((ChatChatter) r9.next()));
        r4.setOutChatUser(true);
        r2.add(r4);
        goto L21
    L24:
        return brb.a.a(r2);
    L15:
        r8 = new LabelAtBean(UIHelper.getString(2131890339), UIHelper.getString(2131890340));
        goto L16
    L5:
        if (this.excludeOutChatUser == true) goto L7;
        r3 = true;
        goto L8
    }

    private final boolean isDoubaoMentionItem(BaseAtBean r2) {
        int r0 = com.ss.android.lark.mention.base.impl.atselector.doubaoview.a.a;
        Chatter r1 = this.doubaoChatter;
        if (r1 == null) goto L5;
        String r3 = r1.getId();
    L6:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        return com.ss.android.lark.mention.base.impl.atselector.doubaoview.a.a(r2, r3);
    L5:
        r3 = null;
        goto L6
    }

    private final boolean isEmptyAfterOpenIdTransform(List<? extends BaseAtBean> r3) {
        List<? extends BaseAtBean> r4 = r3;
        if ((r4 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (isPersonMentionItem((BaseAtBean) r5.next()) == false) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r4.isEmpty() == false) goto L7;
        return true;
    }

    private final boolean isPersonMentionItem(BaseAtBean r3) {
        if (r3.getType() != 0) goto L5;
    L10:
        return true;
    L5:
        if (r3.getType() == 2) goto L10;
        if (r3.getType() == 4) goto L10;
        return false;
    }

    private final boolean requiresOpenId(BaseAtBean r3) {
        if (r3.getType() != 0) goto L5;
    L12:
        return true;
    L5:
        if (r3.getType() == 2) goto L12;
        if (r3.getType() == 4) goto L12;
        if (r3.getType() == 8) goto L12;
        return false;
    }

    private final ChatChatter toChatChatter(SearchBean r3) {
        com.ss.android.lark.mention.base.impl.atselector.bean.a r4 = r3.getChatterInfo();
        Chatter r0 = new Chatter();
        r0.setId(r4.a);
        r0.setName(r4.c);
        r0.setLocalizedName(r4.c);
        r0.setAvatarKey(r4.b);
        r0.setDescription(r4.h);
        r0.setType(r4.g);
        r0.setRegistered(r4.i);
        return new ChatChatter(r0);
    }

    public final void loadDoubaoChatter(CoroutineScope r10) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        if (this.doubaoChatter == null) goto L5;
        return;
    L5:
        Job r0 = this.loadDoubaoChatterJob;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        this.loadDoubaoChatterJob = BuildersKt.launch$default(r10, null, null, new C04331(this, null), 3, null);
    }

    public final void search(String r19) {
        Job r0 = this.searchJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        ChatAtModel r1 = this.model;
        r1.g = "";
        r1.h = "";
        ((ArrayList) r1.e).clear();
        if (r19 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L15;
        loadRecommend();
        return;
    L15:
        String r5 = com.ss.android.lark.sdk.a.a();
        SearchConsistencyReporter r6 = SearchConsistencyReporter.INSTANCE;
        Intrinsics.checkNotNull(r5);
        r6.beginReport(r5, 0);
        z0<j> r2 = this._uiState;
        j r8 = (j) r2.getValue();
        boolean r15 = getShouldShowDepartmentInSearch();
        r2.setValue(j.a(r8, null, com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.d.a, r19, r5, 0, r15, false, 209));
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        RequestStatus r3 = RequestStatus.NOT_ARRIVE;
        r7.element = r3;
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = r3;
        arb.a.b.d0(true);
        if (getShouldTransformOpenId() == false) goto L19;
        this.searchJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04351(this, r5, r19, null), 3, null);
        return;
    L19:
        this.searchJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04362(this, r19, r5, r7, r9, null), 3, null);
        return;
    L8:
        if (r19.length() == 0) goto L11;
        r4 = false;
        goto L12
    }

    public final void setDoubaoChatter(Chatter r1) {
        this.doubaoChatter = r1;
    }

    public final boolean setSelectedResult(BaseAtBean r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (this.enableDoubaoMention == false) goto L6;
    L8:
        this.model.h(r2);
        return true;
    L6:
        if (isDoubaoMentionItem(r2) == false) goto L8;
        return false;
    }

    public final void updateDoubaoMentionEnabled(boolean r12) {
        if (this.enableDoubaoMention != r12) goto L5;
        return;
    L5:
        Log.i(TAG, "updateDoubaoMentionEnabled old=" + this.enableDoubaoMention + ", new=" + r12 + ", recommend=" + ((j) this._uiState.getValue()).a.getClass().getSimpleName() + ", search=" + ((j) this._uiState.getValue()).b.getClass().getSimpleName());
        this.enableDoubaoMention = r12;
        if (r12 == true) goto L8;
        CollectionsKt.removeAll(((LinkedHashMap) this.model.f).entrySet(), new C04381(this));
    L8:
        j r1 = (j) this._uiState.getValue();
        com.ss.android.lark.mention.base.impl.atselector.doubaoview.b r0 = r1.a;
        Integer r4 = null;
        if (getShouldTransformOpenId() == false) goto L12;
        Integer r2 = null;
    L15:
        com.ss.android.lark.mention.base.impl.atselector.doubaoview.b r3 = updateDoubaoMentionEnabled$updateLoadState(this, r0, r2);
        com.ss.android.lark.mention.base.impl.atselector.doubaoview.b r5 = r1.b;
        if (getShouldTransformOpenId() == true) goto L19;
        r4 = 0;
    L19:
        com.ss.android.lark.mention.base.impl.atselector.doubaoview.b r6 = updateDoubaoMentionEnabled$updateLoadState(this, r5, r4);
        if ((r6 instanceof com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.e) == false) goto L22;
        this.model.U0(r1.d, ((com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.e) r6).a);
    L22:
        this._uiState.setValue(j.a(r1, r3, r6, null, null, 0, false, r12, 124));
        return;
    L12:
        if (this.model.p() == false) goto L14;
        r2 = 1;
        goto L15
    L14:
        r2 = 0;
        goto L15
    }

    public static final /* synthetic */ List access$handleLocalSearchData(DoubaoMentionViewModel r0, List r1) {
        return r0.handleLocalSearchData(r1);
    }

    public static final /* synthetic */ boolean access$isDoubaoMentionItem(DoubaoMentionViewModel r0, BaseAtBean r1) {
        return r0.isDoubaoMentionItem(r1);
    }

    public static final /* synthetic */ boolean access$isEmptyAfterOpenIdTransform(DoubaoMentionViewModel r0, List r1) {
        return r0.isEmptyAfterOpenIdTransform(r1);
    }

    public static final /* synthetic */ boolean access$isPersonMentionItem(DoubaoMentionViewModel r0, BaseAtBean r1) {
        return r0.isPersonMentionItem(r1);
    }

    public static final /* synthetic */ void access$search$emitSearchError(DoubaoMentionViewModel r0, Throwable r1) {
        search$emitSearchError(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object awaitRecommendData(ChatAtModel r4, Continuation<? super List<? extends BaseAtBean>> r5) {
        final kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r5), 1);
        r0.C();
        r4.U7(new DoubaoMentionViewModel$awaitRecommendData$2$1(r0));
        Object r6 = r0.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    private final void emitSearchSuccess(List<? extends BaseAtBean> r13, String r14) {
        if (getShouldTransformOpenId() == false) goto L5;
        Integer r0 = null;
    L6:
        List<BaseAtBean> r15 = applyDoubaoMentionPolicy$default(this, r13, r0, false, 4, null);
        this.model.U0(r14, r15);
        z0<j> r1 = this._uiState;
        j r2 = (j) r1.getValue();
        if (r15.isEmpty() == false) goto L9;
        com.ss.android.lark.mention.base.impl.atselector.doubaoview.b r3 = com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.a.a;
    L10:
        r1.setValue(j.a(r2, null, r3, null, null, 0, getShouldShowDepartmentInSearch(), false, 221));
        updateSensitiveInfoIfNeeded(r15, r14);
        return;
    L9:
        r3 = new com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.e(r15);
        goto L10
    L5:
        r0 = 0;
        goto L6
    }

    private final Object enrichTagStateFromLocalChatters(List<? extends BaseAtBean> r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        List r12 = (List) r0.L$1;
        List r4 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
        r4 = r4;
    L57:
        Object r13 = Result.constructor-impl((Map) r11);     // Catch: Throwable -> L14
        List r5 = r4;
    L63:
        Throwable r6 = Result.exceptionOrNull-impl(r13);
        if (r6 != null) goto L93;
        Map r14 = (Map) r13;
        Iterator r15 = r5.iterator();
    L67:
        if (r15.hasNext() == false) goto L92;
        SearchBean r7 = (SearchBean) r15.next();
        Chatter r8 = (Chatter) r14.get(r7.getId());
        if (r8 == null) goto L67;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r16 = r7.getChatterInfo();
        if (r16.j == false) goto L74;
    L77:
        boolean r17 = true;
    L78:
        r16.j = r17;
        if (r16.k == false) goto L81;
    L84:
        boolean r18 = true;
    L85:
        r16.k = r18;
        ChatterCustomStatus.a r19 = ChatterCustomStatus.Companion;
        List r20 = r8.getCustomStatus();
        r19.getClass();
        List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r21 = ChatterCustomStatus.a.c(r20);
        if (r21 != null) goto L88;
        r21 = CollectionsKt.emptyList();
    L88:
        r16.r = r21;
        if (r16.s != null) goto L67;
        r16.s = r8.getTagData();
        goto L67
    L81:
        if (r8.isFrozen() == true) goto L84;
        r18 = false;
        goto L85
    L74:
        if (r8.isDimission() == true) goto L77;
        r17 = false;
        goto L78
    L92:
        return Unit.INSTANCE;
    L93:
        Log.e(TAG, "get local chatter tag state failed, count=" + r12.size(), r6);
        return Unit.INSTANCE;
    L14:
        Throwable th = th;
        List r22 = r4;
        List r23 = r12;
        List r24 = r22;
    L62:
        Result.Companion r25 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        List r26 = r23;
        r5 = r24;
        r12 = r26;
        goto L63
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        ArrayList r110 = new ArrayList();
        Iterator<T> r27 = r9.iterator();
    L20:
        if (r27.hasNext() == false) goto L24;
        Object r28 = r27.next();
        if ((r28 instanceof SearchBean) == false) goto L20;
        r110.add(r28);
        goto L20
    L24:
        ArrayList r29 = new ArrayList();
        Iterator r111 = r110.iterator();
    L26:
        if (r111.hasNext() == false) goto L36;
        Object r30 = r111.next();
        List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r31 = ((SearchBean) r30).getChatterInfo().r;
        if (r31 != null) goto L30;
    L33:
        boolean r32 = true;
    L34:
        if (r32 == false) goto L26;
        r29.add(r30);
        goto L26
    L30:
        if (r31.isEmpty() == true) goto L33;
        r32 = false;
        goto L34
    L36:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator r33 = r29.iterator();
    L38:
        if (r33.hasNext() == false) goto L40;
        r112.add(((SearchBean) r33.next()).getId());
        goto L38
    L40:
        ArrayList r34 = new ArrayList();
        Iterator r113 = r112.iterator();
    L42:
        if (r113.hasNext() == false) goto L49;
        Object r35 = r113.next();
        if (((String) r35).length() <= 0) goto L46;
        boolean r36 = true;
    L47:
        if (r36 == false) goto L42;
        r34.add(r35);
        goto L42
    L46:
        r36 = false;
        goto L47
    L49:
        List r114 = CollectionsKt.distinct(r34);
        if (r114.isEmpty() == true) goto L52;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L60
        CoroutineDispatcher r38 = Dispatchers.getIO();     // Catch: Throwable -> L60
        DoubaoMentionViewModel$enrichTagStateFromLocalChatters$localChatters$1$1 r39 = new DoubaoMentionViewModel$enrichTagStateFromLocalChatters$localChatters$1$1(r114, null);     // Catch: Throwable -> L60
        r0.L$0 = r29;     // Catch: Throwable -> L60
        r0.L$1 = r114;     // Catch: Throwable -> L60
        r0.label = 1;     // Catch: Throwable -> L60
        Object r40 = BuildersKt.withContext(r38, r39, r0);     // Catch: Throwable -> L60
        if (r40 != r2) goto L56;
        return r2;
    L56:
        r4 = r29;
        r12 = r114;
        r11 = r40;
    L60:
        th = move-exception;
        r23 = r114;
        th = th;
        r24 = r29;
        goto L62
    L52:
        return Unit.INSTANCE;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    private final Object fetchOpenIds(List<String> r5, Continuation<? super Map<String, String>> r6) {
        boolean r2 = true;
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r6), 1);
        r0.C();
        String r1 = com.ss.android.lark.mention.base.b.a().d();
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        if (r1.length() == 0) goto L9;
        r2 = false;
    L9:
        if (r2 == false) goto L11;
        Result.Companion r7 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(new OpenIdTransformException("current uid is empty"))));
    L12:
        Object r8 = r0.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L15:
        return r8;
    L11:
        new l(r1).b(r5, getInitData().getAppId(), new b(r0));
        goto L12
    }

    private final List<BaseAtBean> handleNetSearchDataWithMergeOld(ccb.d r7, List<? extends BaseAtBean> r8) {
        List<? extends ChatChatter> r0 = r7.b;
        List r1 = r7.c;
        List<UserGroupEntity> r9 = r7.g;
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        MentionUtils.f(r8, r3, r4);
        r2.addAll(MentionUtils.e(r3, handleInChatSearchDataAndUserGroup(r0, !CollectionUtils.isEmpty(r1), r9), false));
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        List r5 = r1;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r11 = r5.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        SearchBean r6 = new SearchBean(com.ss.android.lark.mention.base.impl.atselector.bean.b.a((ChatChatter) r11.next()));
        r6.setOutChatUser(true);
        r10.add(r6);
        goto L7
    L9:
        List r12 = MentionUtils.e(r4, r10, true);
        if (CollectionUtils.isEmpty(r12) == true) goto L12;
        r2.addAll(r12);
        return brb.a.a(r2);
    L12:
        return brb.a.a(r2);
    }

    private static final void search$emitSearchError(DoubaoMentionViewModel r11, Throwable r12) {
        z0<j> r13 = r11._uiState;
        r13.setValue(j.a((j) r13.getValue(), null, new com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.C0175b(r12), null, null, 0, false, false, 253));
    }

    private final void setSelectedStatus(List<? extends BaseAtBean> r3, Map<String, ? extends BaseAtBean> r4) {
        if (r3 == null) goto L9;
        if (r4 == null) goto L11;
        Iterator<? extends BaseAtBean> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        BaseAtBean r0 = r5.next();
        r0.setSelected(r4.containsKey(r0.getId()));
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private final Object transformOpenIds(List<? extends BaseAtBean> r9, Continuation<? super List<? extends BaseAtBean>> r10) {
        if ((r10 instanceof C04371) == false) goto L7;
        Continuation<? super Map<String, String>> r0 = (C04371) r10;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L48:
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r12 = ((Map) r11).entrySet().iterator();
    L50:
        if (r12.hasNext() == false) goto L57;
        Map.Entry r5 = (Map.Entry) r12.next();
        if (((String) r5.getValue()).length() <= 0) goto L54;
        boolean r6 = true;
    L55:
        if (r6 == false) goto L50;
        r4.put(r5.getKey(), r5.getValue());
        goto L50
    L54:
        r6 = false;
        goto L55
    L57:
        this.openIdMappings.putAll(r4);
    L58:
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r9.iterator();
    L60:
        if (r14.hasNext() == false) goto L77;
        Object r7 = r14.next();
        BaseAtBean r8 = (BaseAtBean) r7;
        String r15 = r8.getId();
        if (requiresOpenId(r8) == false) goto L74;
        if (r15 != null) goto L65;
    L68:
        boolean r16 = true;
    L69:
        if (r16 == false) goto L71;
    L73:
        boolean r17 = false;
    L75:
        if (r17 == false) goto L60;
        r13.add(r7);
        goto L60
    L71:
        if (this.openIdMappings.containsKey(r15) == false) goto L73;
    L65:
        if (StringsKt.isBlank(r15) == true) goto L68;
        r16 = false;
    L74:
        r17 = true;
        goto L75
    L77:
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (getShouldTransformOpenId() == true) goto L17;
        return r9;
    L17:
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r9.iterator();
    L19:
        if (r19.hasNext() == false) goto L23;
        Object r20 = r19.next();
        if (requiresOpenId((BaseAtBean) r20) == false) goto L19;
        r18.add(r20);
        goto L19
    L23:
        ArrayList r110 = new ArrayList();
        Iterator r21 = r18.iterator();
    L25:
        if (r21.hasNext() == false) goto L34;
        String r22 = ((BaseAtBean) r21.next()).getId();
        if (r22 != null) goto L29;
    L31:
        r22 = null;
    L32:
        if (r22 == null) goto L25;
        r110.add(r22);
        goto L25
    L29:
        if ((!StringsKt.isBlank(r22)) == false) goto L31;
    L34:
        List r111 = CollectionsKt.distinct(r110);
        if (r111.isEmpty() == false) goto L37;
        return r9;
    L37:
        ConcurrentHashMap<String, String> r23 = this.openIdMappings;
        ArrayList r24 = new ArrayList();
        Iterator r112 = r111.iterator();
    L39:
        if (r112.hasNext() == false) goto L44;
        Object r25 = r112.next();
        if (r23.containsKey((String) r25) == true) goto L39;
        r24.add(r25);
        goto L39
    L44:
        if ((!r24.isEmpty()) == false) goto L58;
        r0.L$0 = r9;
        r0.label = 1;
        r11 = fetchOpenIds(r24, r0);
        if (r11 != r2) goto L48;
        return r2;
    L7:
        r0 = new C04371(this, r10);
        goto L8
    }

    private final void updateSensitiveInfoIfNeeded(List<? extends BaseAtBean> r12, String r13) {
        ArrayList r3 = new ArrayList();
        Iterator<T> r0 = r12.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r1 = r0.next();
        if ((r1 instanceof SearchBean) == false) goto L4;
        r3.add(r1);
        goto L4
    L9:
        if (r3.isEmpty() == false) goto L11;
        return;
    L11:
        int r2 = h.a;
        boolean r4 = getShouldShowDepartmentInSearch();
        Intrinsics.checkNotNullParameter(r3, "items");
        boolean r5 = false;
        if (r4 == true) goto L15;
    L23:
        if (r5 == true) goto L25;
        return;
    L25:
        String r6 = com.ss.android.lark.sdk.a.a();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04391(this, r3, r6, r13, r12, null), 3, null);
        return;
    L15:
        if (r3.isEmpty() == true) goto L23;
        Iterator r7 = r3.iterator();
    L19:
        if (r7.hasNext() == false) goto L23;
        if ((((BaseAtBean) r7.next()) instanceof SearchBean) == false) goto L19;
        r5 = true;
        goto L23
    }

    public static final /* synthetic */ Object access$awaitRecommendData(DoubaoMentionViewModel r0, ChatAtModel r1, Continuation r2) {
        return r0.awaitRecommendData(r1, r2);
    }

    public static final /* synthetic */ void access$emitSearchSuccess(DoubaoMentionViewModel r0, List r1, String r2) {
        r0.emitSearchSuccess(r1, r2);
    }

    public static final /* synthetic */ Object access$enrichTagStateFromLocalChatters(DoubaoMentionViewModel r0, List r1, Continuation r2) {
        return r0.enrichTagStateFromLocalChatters(r1, r2);
    }

    public static final /* synthetic */ Object access$fetchOpenIds(DoubaoMentionViewModel r0, List r1, Continuation r2) {
        return r0.fetchOpenIds(r1, r2);
    }

    public static final /* synthetic */ List access$handleNetSearchDataWithMergeOld(DoubaoMentionViewModel r0, ccb.d r1, List r2) {
        return r0.handleNetSearchDataWithMergeOld(r1, r2);
    }

    public static final /* synthetic */ void access$search$maybeEmitEmptyOrError(Ref.ObjectRef r0, Ref.ObjectRef r1, DoubaoMentionViewModel r2) {
        search$maybeEmitEmptyOrError(r0, r1, r2);
    }

    public static final /* synthetic */ void access$setSelectedStatus(DoubaoMentionViewModel r0, List r1, Map r2) {
        r0.setSelectedStatus(r1, r2);
    }

    public static final /* synthetic */ Object access$transformOpenIds(DoubaoMentionViewModel r0, List r1, Continuation r2) {
        return r0.transformOpenIds(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<BaseAtBean> applyDoubaoMentionPolicy(List<? extends BaseAtBean> r8, Integer r9, boolean r10) {
        if (getShouldTransformOpenId() == true) goto L5;
    L7:
        Chatter r0 = this.doubaoChatter;
        AtDoubaoBean r1 = null;
        if (r0 == null) goto L10;
        String r2 = r0.getId();
    L11:
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        Chatter r3 = this.doubaoChatter;
        if (r3 == null) goto L18;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r4 = com.ss.android.lark.mention.base.impl.atselector.bean.b.a(new ChatChatter(r3));
        if (r4 == null) goto L18;
        r1 = new AtDoubaoBean(r4);
    L18:
        int r5 = com.ss.android.lark.mention.base.impl.atselector.doubaoview.a.a;
        boolean r6 = this.enableDoubaoMention;
        Intrinsics.checkNotNullParameter(r8, "items");
        Intrinsics.checkNotNullParameter(r2, "doubaoChatterId");
        ArrayList r7 = new ArrayList();
        Iterator r11 = r8.iterator();
    L20:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();
        if (com.ss.android.lark.mention.base.impl.atselector.doubaoview.a.a((BaseAtBean) r12, r2) == true) goto L20;
        r7.add(r12);
        goto L20
    L24:
        List<BaseAtBean> r13 = CollectionsKt.toMutableList(r7);
        if (r6 == false) goto L34;
        if (r1 == null) goto L34;
        if (r9 == null) goto L34;
        if (r10 == false) goto L30;
    L32:
        ListProtector.add(r13, RangesKt.coerceAtMost(r9.intValue(), r13.size()), r1);
        goto L34
    L30:
        if (r13.isEmpty() == false) goto L32;
    L34:
        if (r13.size() == r8.size()) goto L36;
        Log.d(TAG, "applyDoubaoMentionPolicy enabled=" + this.enableDoubaoMention + ", inputSize=" + r8.size() + ", outputSize=" + r13.size());
    L36:
        return r13;
    L10:
        r2 = null;
        goto L11
    L5:
        if (this.enableDoubaoMention == false) goto L7;
        return r8;
    }

    private final List<BaseAtBean> handleInChatSearchDataAndUserGroup(List<? extends ChatChatter> r5, boolean r6, List<UserGroupEntity> r7) {
        ArrayList r0 = new ArrayList();
        List<? extends ChatChatter> r1 = r5;
        if (CollectionUtils.isEmpty(r1) == true) goto L5;
    L9:
        if (r6 == false) goto L12;
        r0.add(new LabelAtBean(UIHelper.getString(2131890337)));
    L12:
        if (CollectionUtils.isEmpty(r1) == true) goto L25;
        if (r5 != null) goto L15;
        r5 = CollectionsKt.emptyList();
    L15:
        Iterator<? extends ChatChatter> r8 = r5.iterator();
    L17:
        if (r8.hasNext() == false) goto L25;
        ChatChatter r9 = r8.next();
        if (com.ss.android.lark.mention.base.a.a() == false) goto L23;
        if (r9.getChatter().isDimission() == true) goto L17;
    L23:
        r0.add(new SearchBean(com.ss.android.lark.mention.base.impl.atselector.bean.b.a(r9)));
    L25:
        if (CollectionUtils.isEmpty(r7) == true) goto L37;
        StringBuilder r10 = new StringBuilder("user group in search size is ");
        if (r7 == null) goto L29;
        Integer r2 = Integer.valueOf(r7.size());
    L30:
        r10.append(r2);
        Log.i(TAG, r10.toString());
        if (r7 != null) goto L33;
        r7 = CollectionsKt.emptyList();
    L33:
        Iterator<UserGroupEntity> r11 = r7.iterator();
    L35:
        if (r11.hasNext() == false) goto L38;
        r0.add(new UserGroupBean(r11.next()));
    L38:
        return r0;
    L29:
        r2 = null;
        goto L30
    L37:
        Log.i(TAG, "user group in search is empty");
        goto L38
    L5:
        if (CollectionUtils.isEmpty(r7) == false) goto L9;
        if (r6 == false) goto L8;
        r0.add(new LabelAtBean(UIHelper.getString(2131890337)));
        r0.add(MentionUtils.b());
    L8:
        return r0;
    }

    private static final void search$maybeEmitEmptyOrError(Ref.ObjectRef<RequestStatus> r10, Ref.ObjectRef<RequestStatus> r11, DoubaoMentionViewModel r12) {
        Object r13 = r10.element;
        RequestStatus r0 = RequestStatus.ERROR;
        if (r13 == r0) goto L5;
    L8:
        RequestStatus r1 = RequestStatus.EMPTY;
        if (r13 == r1) goto L11;
        if (r13 == r0) goto L11;
        return;
    L11:
        Object r14 = r11.element;
        if (r14 == r1) goto L14;
        if (r14 == r0) goto L14;
        return;
    L14:
        z0<j> r15 = r12._uiState;
        r15.setValue(j.a((j) r15.getValue(), null, com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.a.a, null, null, 0, false, false, 253));
        return;
    L5:
        if (r11.element != r0) goto L8;
        search$emitSearchError(r12, new IllegalStateException(""));
    }

    private static final com.ss.android.lark.mention.base.impl.atselector.doubaoview.b updateDoubaoMentionEnabled$updateLoadState(DoubaoMentionViewModel r6, com.ss.android.lark.mention.base.impl.atselector.doubaoview.b r7, Integer r8) {
        if ((r7 instanceof com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.e) == true) goto L5;
        return r7;
    L5:
        List r9 = applyDoubaoMentionPolicy$default(r6, ((com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.e) r7).a, r8, false, 4, null);
        if (r9.isEmpty() == false) goto L9;
        return com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.a.a;
    L9:
        return new com.ss.android.lark.mention.base.impl.atselector.doubaoview.b.e(r9);
    }

    public static final /* synthetic */ List access$applyDoubaoMentionPolicy(DoubaoMentionViewModel r0, List r1, Integer r2, boolean r3) {
        return r0.applyDoubaoMentionPolicy(r1, r2, r3);
    }

    private final Object awaitLocalSearch(ChatAtModel r4, String r5, String r6, Continuation<? super ccb.d> r7) {
        final kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r7), 1);
        r0.C();
        r4.z1(r5, r6, new DoubaoMentionViewModel$awaitLocalSearch$2$1(r0));
        Object r8 = r0.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r8;
    }

    private final Object awaitNetSearch(ChatAtModel r4, String r5, String r6, Continuation<? super ccb.d> r7) {
        final kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r7), 1);
        r0.C();
        r4.N2(r5, r6, new DoubaoMentionViewModel$awaitNetSearch$2$1(r0));
        Object r8 = r0.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r8;
    }

    private final Object awaitSensitiveInfo(ChatAtModel r4, List<? extends BaseAtBean> r5, String r6, Continuation<? super ccb.b> r7) {
        final kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r7), 1);
        r0.C();
        r4.m2(r5, r6, new DoubaoMentionViewModel$awaitSensitiveInfo$2$1(r0));
        Object r8 = r0.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r8;
    }

    public static final /* synthetic */ Object access$awaitLocalSearch(DoubaoMentionViewModel r0, ChatAtModel r1, String r2, String r3, Continuation r4) {
        return r0.awaitLocalSearch(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$awaitNetSearch(DoubaoMentionViewModel r0, ChatAtModel r1, String r2, String r3, Continuation r4) {
        return r0.awaitNetSearch(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$awaitSensitiveInfo(DoubaoMentionViewModel r0, ChatAtModel r1, List r2, String r3, Continuation r4) {
        return r0.awaitSensitiveInfo(r1, r2, r3, r4);
    }

    public static /* synthetic */ List applyDoubaoMentionPolicy$default(DoubaoMentionViewModel r0, List r1, Integer r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = true;
    L9:
        return r0.applyDoubaoMentionPolicy(r1, r2, r3);
    }
}
