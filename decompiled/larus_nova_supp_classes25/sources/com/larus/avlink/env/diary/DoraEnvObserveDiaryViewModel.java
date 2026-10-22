package com.larus.avlink.env.diary;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.account.base.api.ILoginService;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;
import org.json.JSONArray;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0015\u0010*\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020%H\u0002J\u0006\u0010.\u001a\u00020\u000fJ\u0006\u0010/\u001a\u00020\u000fJ\u001e\u00100\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u0001022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\bJ\u000e\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u0005J\u0010\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&¨\u00068"}, d2 = {"Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "_diaries", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/avlink/env/diary/model/DiaryItem;", "diaries", "Landroidx/lifecycle/LiveData;", "getDiaries", "()Landroidx/lifecycle/LiveData;", "_isLoading", "", "isLoading", "_isRefreshing", "isRefreshing", "_deletedIds", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "deletedIds", "Lkotlinx/coroutines/flow/SharedFlow;", "getDeletedIds", "()Lkotlinx/coroutines/flow/SharedFlow;", "_nextUpdateTime", "nextUpdateTime", "getNextUpdateTime", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "Lkotlin/Lazy;", "nextCursor", "hasMore", "jumpProductId", "", "Ljava/lang/Integer;", "refresh", "", "loadMore", "setJumpProductId", "productId", "(Ljava/lang/Integer;)V", "getDoraSubBiz", "isEnvObserveEnable", "inEnvObserveScene", "deleteDiary", "context", "Landroid/content/Context;", "diaryIds", "onDiaryDeleted", "diaryId", "loadDiaries", "isRefresh", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveDiaryViewModel extends ViewModel {
    public static final int $stable = 8;
    private final String TAG;
    private final MutableSharedFlow<List<String>> _deletedIds;
    private final MutableLiveData<List<l98.a>> _diaries;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<Boolean> _isRefreshing;
    private final MutableSharedFlow<String> _nextUpdateTime;
    private final d1<List<String>> deletedIds;
    private final LiveData<List<l98.a>> diaries;
    private final Lazy doraPageConfig$delegate;
    private boolean hasMore;
    private final LiveData<Boolean> isLoading;
    private final LiveData<Boolean> isRefreshing;
    private Integer jumpProductId;
    private String nextCursor;
    private final d1<String> nextUpdateTime;

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.DoraEnvObserveDiaryViewModel$deleteDiary$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.DoraEnvObserveDiaryViewModel$deleteDiary$1", f = "DoraEnvObserveDiaryViewModel.kt", i = {}, l = {MessageCellStateTransformerType.DOWNLOAD_APP_V2_ENTITY, 109}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<String> $diaryIds;
        int label;
        final /* synthetic */ DoraEnvObserveDiaryViewModel this$0;

        public AnonymousClass1(DoraEnvObserveDiaryViewModel r1, List<String> r2, Context r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$diaryIds = r2;
            this.$context = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$diaryIds, this.$context, r5);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            ResultKt.throwOnFailure(r12);     // Catch: Exception -> L25
        L28:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r12);     // Catch: Exception -> L25
        L16:
            com.larus.network.http.f r13 = (com.larus.network.http.a) r12;     // Catch: Exception -> L25
            if ((r13 instanceof y) == false) goto L22;
            FLogger.a.i(DoraEnvObserveDiaryViewModel.access$getTAG$p(this.this$0), "deleteDiary success");     // Catch: Exception -> L25
            MutableSharedFlow r14 = DoraEnvObserveDiaryViewModel.access$get_deletedIds$p(this.this$0);     // Catch: Exception -> L25
            List<String> r2 = this.$diaryIds;     // Catch: Exception -> L25
            this.label = 2;     // Catch: Exception -> L25
            if (r14.emit(r2, this) != r0) goto L28;
            return r0;
        L22:
            if ((r13 instanceof com.larus.network.http.f) == false) goto L28;
            s r3 = s.a;     // Catch: Exception -> L25
            Context r4 = this.$context;     // Catch: Exception -> L25
            r3.getClass();     // Catch: Exception -> L25
            s.b(r4, 2131904086, false);     // Catch: Exception -> L25
            FLogger.a.e(DoraEnvObserveDiaryViewModel.access$getTAG$p(this.this$0), "Error deleting diary", r13.d);     // Catch: Exception -> L25
            goto L28
        L12:
            ResultKt.throwOnFailure(r12);
            JSONObject r7 = new JSONObject();     // Catch: Exception -> L25
            r7.put("diary_ids", new JSONArray(this.$diaryIds));     // Catch: Exception -> L25
            com.larus.dora.api.network.a r15 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L25
            this.label = 1;     // Catch: Exception -> L25
            r12 = com.larus.dora.api.network.a.c(r15, Object.class, "/alice/wearable/diary/delete_user_diary", r7, null, this, 248);     // Catch: Exception -> L25
            if (r12 != r0) goto L16;
            return r0;
        L25:
            e = move-exception;
            FLogger.a.e(DoraEnvObserveDiaryViewModel.access$getTAG$p(this.this$0), "Error deleting diary", e);
            goto L28
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.DoraEnvObserveDiaryViewModel$loadDiaries$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.DoraEnvObserveDiaryViewModel$loadDiaries$1", f = "DoraEnvObserveDiaryViewModel.kt", i = {}, l = {DoraCallStateCode.DOUBAO_ENV_OBE_STOP_CONVERSATION}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isRefresh;
        int label;
        final /* synthetic */ DoraEnvObserveDiaryViewModel this$0;

        public C01001(boolean r1, DoraEnvObserveDiaryViewModel r2, Continuation<? super C01001> r3) {
            this.$isRefresh = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01001(this.$isRefresh, this.this$0, r4);
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
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L67 Exception -> L69
        L13:
            y r14 = (com.larus.network.http.a) r13;     // Catch: Throwable -> L67 Exception -> L69
            if ((r14 instanceof y) == false) goto L62;
            l98.c r15 = (l98.c) ((com.larus.network.http.a) r14).b;     // Catch: Throwable -> L67 Exception -> L69
            if (r15 == null) goto L60;
            List<l98.a> r2 = r15.b();     // Catch: Throwable -> L67 Exception -> L69
            if (r2 != null) goto L21;
            r2 = CollectionsKt.emptyList();     // Catch: Throwable -> L67 Exception -> L69
        L21:
            if (this.$isRefresh == false) goto L23;
            List r3 = new ArrayList();     // Catch: Throwable -> L67 Exception -> L69
        L28:
            if (r2 == null) goto L32;
            List r4 = CollectionsKt.filterNotNull(r2);     // Catch: Throwable -> L67 Exception -> L69
            if (r4 == null) goto L32;
            Boxing.boxBoolean(r3.addAll(r4));     // Catch: Throwable -> L67 Exception -> L69
        L32:
            Iterator r5 = r3.iterator();     // Catch: Throwable -> L67 Exception -> L69
        L34:
            if (r5.hasNext() == false) goto L38;
            Object r6 = r5.next();     // Catch: Throwable -> L67 Exception -> L69
            int r7 = ia8.d.a;     // Catch: Throwable -> L67 Exception -> L69
            if (ia8.d.f(((l98.a) r6).c()) == false) goto L34;
        L39:
            l98.a r8 = (l98.a) r6;     // Catch: Throwable -> L67 Exception -> L69
            if (r8 == null) goto L42;
            DoraEnvObserveDiaryViewModel.access$get_nextUpdateTime$p(this.this$0).tryEmit(r8.f());     // Catch: Throwable -> L67 Exception -> L69
        L42:
            MutableLiveData r9 = DoraEnvObserveDiaryViewModel.access$get_diaries$p(this.this$0);     // Catch: Throwable -> L67 Exception -> L69
            ArrayList r10 = new ArrayList();     // Catch: Throwable -> L67 Exception -> L69
            Iterator r11 = r3.iterator();     // Catch: Throwable -> L67 Exception -> L69
        L44:
            if (r11.hasNext() == false) goto L59;
            Object r12 = r11.next();     // Catch: Throwable -> L67 Exception -> L69
            l98.a r16 = (l98.a) r12;     // Catch: Throwable -> L67 Exception -> L69
            int r17 = ia8.d.a;     // Catch: Throwable -> L67 Exception -> L69
            if (ia8.d.f(r16.c()) == false) goto L56;
            List<String> r18 = r16.b();     // Catch: Throwable -> L67 Exception -> L69
            if (r18 != null) goto L50;
        L53:
            boolean r19 = true;
        L54:
            if (r19 == false) goto L56;
            boolean r20 = true;
        L57:
            if (r20 == true) goto L44;
            r10.add(r12);     // Catch: Throwable -> L67 Exception -> L69
            goto L44
        L50:
            if (r18.isEmpty() == true) goto L53;
            r19 = false;
        L56:
            r20 = false;
            goto L57
        L59:
            r9.postValue(r10);     // Catch: Throwable -> L67 Exception -> L69
            DoraEnvObserveDiaryViewModel.access$setHasMore$p(this.this$0, Intrinsics.areEqual(r15.a(), Boxing.boxBoolean(true)));     // Catch: Throwable -> L67 Exception -> L69
            DoraEnvObserveDiaryViewModel.access$setNextCursor$p(this.this$0, r15.c());     // Catch: Throwable -> L67 Exception -> L69
        L65:
            if (this.$isRefresh == true) goto L73;
        L74:
            DoraEnvObserveDiaryViewModel.access$get_isLoading$p(this.this$0).postValue(Boxing.boxBoolean(false));
        L76:
            return Unit.INSTANCE;
        L73:
            DoraEnvObserveDiaryViewModel.access$get_isRefreshing$p(this.this$0).postValue(Boxing.boxBoolean(false));
            goto L76
        L38:
            r6 = null;
            goto L39
        L23:
            List r21 = (List) DoraEnvObserveDiaryViewModel.access$get_diaries$p(this.this$0).getValue();     // Catch: Throwable -> L67 Exception -> L69
            if (r21 == null) goto L27;
            r3 = CollectionsKt.toMutableList(r21);     // Catch: Throwable -> L67 Exception -> L69
            if (r3 != null) goto L28;
        L27:
            r3 = new ArrayList();     // Catch: Throwable -> L67 Exception -> L69
            goto L28
        L60:
            FLogger.a.e(DoraEnvObserveDiaryViewModel.access$getTAG$p(this.this$0), "Error loading diaries: responseBody is null");     // Catch: Throwable -> L67 Exception -> L69
            goto L65
        L62:
            if ((r14 instanceof com.larus.network.http.f) == false) goto L65;
            FLogger.a.e(DoraEnvObserveDiaryViewModel.access$getTAG$p(this.this$0), "Error loading diaries", ((com.larus.network.http.f) r14).d);     // Catch: Throwable -> L67 Exception -> L69
            goto L65
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
            JSONObject r22 = new JSONObject();     // Catch: Throwable -> L67 Exception -> L69
            DoraEnvObserveDiaryViewModel r110 = this.this$0;     // Catch: Throwable -> L67 Exception -> L69
            r22.put("user_id", ILoginService.a.getAccountInfo().d);     // Catch: Throwable -> L67 Exception -> L69
            r22.put("biz_id", DoraEnvObserveDiaryViewModel.access$getDoraSubBiz(r110));     // Catch: Throwable -> L67 Exception -> L69
            r22.put("cursor", DoraEnvObserveDiaryViewModel.access$getNextCursor$p(r110));     // Catch: Throwable -> L67 Exception -> L69
            com.larus.dora.api.network.a r23 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L67 Exception -> L69
            this.label = 1;     // Catch: Throwable -> L67 Exception -> L69
            r13 = com.larus.dora.api.network.a.c(r23, l98.c.class, "/alice/wearable/diary/list_user_diary_v2", r22, null, this, 248);     // Catch: Throwable -> L67 Exception -> L69
            if (r13 != r0) goto L13;
            return r0;
        L67:
            th = move-exception;
            if (this.$isRefresh == false) goto L80;
            DoraEnvObserveDiaryViewModel.access$get_isRefreshing$p(this.this$0).postValue(Boxing.boxBoolean(false));
        L81:
            throw th;
        L80:
            DoraEnvObserveDiaryViewModel.access$get_isLoading$p(this.this$0).postValue(Boxing.boxBoolean(false));
        L69:
            e = move-exception;
            FLogger.a.e(DoraEnvObserveDiaryViewModel.access$getTAG$p(this.this$0), "Error loading diaries", e);     // Catch: Throwable -> L67
            if (this.$isRefresh == false) goto L74;
            goto L73
        }
    }

    public static /* synthetic */ IDoraPageConfig yo() {
        return doraPageConfig_delegate$lambda$0();
    }

    public final boolean inEnvObserveScene() {
        return b98.b.b(2);
    }

    public final void refresh() {
        loadDiaries(true);
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$0() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    private final int getDoraSubBiz() {
        Integer r0 = this.jumpProductId;
        if (r0 != null) goto L5;
    L7:
        FlowDoraSubBizType.Companion.getClass();
        int r1 = FlowDoraSubBizType.a.a();
    L8:
        if (r1 != 0) goto L12;
        FlowDoraSubBizType.Companion.getClass();
        return FlowDoraSubBizType.a.b(17);
    L12:
        return r1;
    L5:
        if (r0.intValue() <= 0) goto L7;
        FlowDoraSubBizType.Companion.getClass();
        r1 = FlowDoraSubBizType.a.b(r0);
        goto L8
    }

    public final void loadMore() {
        if (this.hasMore == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this._isLoading.getValue(), Boolean.TRUE) == true) goto L9;
        loadDiaries(false);
        return;
    }

    public DoraEnvObserveDiaryViewModel() {
        this.TAG = "DoraEnvObserveDiary";
        MutableLiveData<List<l98.a>> r0 = new MutableLiveData();
        this._diaries = r0;
        this.diaries = r0;
        MutableLiveData<Boolean> r1 = new MutableLiveData();
        this._isLoading = r1;
        this.isLoading = r1;
        MutableLiveData<Boolean> r2 = new MutableLiveData();
        this._isRefreshing = r2;
        this.isRefreshing = r2;
        MutableSharedFlow<List<String>> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._deletedIds = r3;
        this.deletedIds = r3;
        MutableSharedFlow<String> r4 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._nextUpdateTime = r4;
        this.nextUpdateTime = r4;
        this.doraPageConfig$delegate = LazyKt.lazy(new r());
        this.hasMore = true;
    }

    public final boolean isEnvObserveEnable() {
        IDoraPageConfig r0 = getDoraPageConfig();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.d("dora_g_config_key_env_observe_enable", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final d1<List<String>> getDeletedIds() {
        return this.deletedIds;
    }

    public final LiveData<List<l98.a>> getDiaries() {
        return this.diaries;
    }

    public final d1<String> getNextUpdateTime() {
        return this.nextUpdateTime;
    }

    public final LiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    public final LiveData<Boolean> isRefreshing() {
        return this.isRefreshing;
    }

    public static final /* synthetic */ int access$getDoraSubBiz(DoraEnvObserveDiaryViewModel r0) {
        return r0.getDoraSubBiz();
    }

    public static final /* synthetic */ String access$getNextCursor$p(DoraEnvObserveDiaryViewModel r0) {
        return r0.nextCursor;
    }

    public static final /* synthetic */ String access$getTAG$p(DoraEnvObserveDiaryViewModel r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_deletedIds$p(DoraEnvObserveDiaryViewModel r0) {
        return r0._deletedIds;
    }

    public static final /* synthetic */ MutableLiveData access$get_diaries$p(DoraEnvObserveDiaryViewModel r0) {
        return r0._diaries;
    }

    public static final /* synthetic */ MutableLiveData access$get_isLoading$p(DoraEnvObserveDiaryViewModel r0) {
        return r0._isLoading;
    }

    public static final /* synthetic */ MutableLiveData access$get_isRefreshing$p(DoraEnvObserveDiaryViewModel r0) {
        return r0._isRefreshing;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_nextUpdateTime$p(DoraEnvObserveDiaryViewModel r0) {
        return r0._nextUpdateTime;
    }

    private final void loadDiaries(boolean r10) {
        FLogger.a.i(this.TAG, "loadDiaries isRefresh: " + r10);
        if (r10 == false) goto L5;
        this._isRefreshing.postValue(Boolean.TRUE);
        this.nextCursor = null;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01001(r10, this, null), 2, null);
        return;
    L5:
        this._isLoading.postValue(Boolean.TRUE);
        goto L6
    }

    public final void onDiaryDeleted(String r2) {
        Intrinsics.checkNotNullParameter(r2, "diaryId");
        this._deletedIds.tryEmit(CollectionsKt.listOf(r2));
    }

    public final void setJumpProductId(Integer r1) {
        this.jumpProductId = r1;
    }

    public static final /* synthetic */ void access$setHasMore$p(DoraEnvObserveDiaryViewModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setNextCursor$p(DoraEnvObserveDiaryViewModel r0, String r1) {
        r0.nextCursor = r1;
    }

    public final void deleteDiary(Context r14, List<String> r15) {
        Intrinsics.checkNotNullParameter(r15, "diaryIds");
        FLogger.a.i(this.TAG, "deleteDiary: " + CollectionsKt.joinToString$default(r15, ",", null, null, 0, null, null, 62, null));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r15, r14, null), 2, null);
    }
}
