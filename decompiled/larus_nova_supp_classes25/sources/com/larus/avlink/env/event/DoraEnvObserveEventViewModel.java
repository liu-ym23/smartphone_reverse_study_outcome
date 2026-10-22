package com.larus.avlink.env.event;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.avlink.env.event.model.EnvObserveMemoryEvent;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.network.http.AsyncThrowable;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010 \u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u001eH\u0002J\u0006\u0010$\u001a\u00020!J\u000e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020!J\u0006\u0010(\u001a\u00020!J\b\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u000fH\u0002J$\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010+\u001a\u00020\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\bH\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0002J\u000e\u00102\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001f¨\u00063"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObserveEventViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "_eventList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/avlink/env/event/model/EnvObserveMemoryItem;", "eventList", "Landroidx/lifecycle/LiveData;", "getEventList", "()Landroidx/lifecycle/LiveData;", "_isLoading", "", "isLoading", "_isRefreshing", "isRefreshing", "_isLoadDataLoading", "isLoadDataLoading", "_error", "error", "getError", "_deleteSuccess", "deleteSuccess", "getDeleteSuccess", "nextCursor", "hasMore", "productId", "", "Ljava/lang/Integer;", "setProductId", "", "(Ljava/lang/Integer;)V", "getDoraSubBiz", "resetDeleteSuccess", "onEventDeleted", "eventId", "refresh", "loadMore", "isRefreshInProgress", "loadEvents", "isRefresh", "mergeResults", "memoryDataList", "Lcom/larus/avlink/env/event/model/EnvObserveMemoryEvent;", "getStartOfDayMillis", "", "timestamp", "deleteMemory", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveEventViewModel extends ViewModel {
    public static final int $stable = 8;
    private final String TAG;
    private final MutableLiveData<Boolean> _deleteSuccess;
    private final MutableLiveData<String> _error;
    private final MutableLiveData<List<o98.c>> _eventList;
    private final MutableLiveData<Boolean> _isLoadDataLoading;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<Boolean> _isRefreshing;
    private final LiveData<Boolean> deleteSuccess;
    private final LiveData<String> error;
    private final LiveData<List<o98.c>> eventList;
    private boolean hasMore;
    private final LiveData<Boolean> isLoadDataLoading;
    private final LiveData<Boolean> isLoading;
    private final LiveData<Boolean> isRefreshing;
    private String nextCursor;
    private Integer productId;

    /* JADX INFO: renamed from: com.larus.avlink.env.event.DoraEnvObserveEventViewModel$deleteMemory$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.event.DoraEnvObserveEventViewModel$deleteMemory$1", f = "DoraEnvObserveEventViewModel.kt", i = {}, l = {DoraCallStateCode.HARMORY_BG_STATE_CHANGE}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $eventId;
        int label;
        final /* synthetic */ DoraEnvObserveEventViewModel this$0;

        public AnonymousClass1(DoraEnvObserveEventViewModel r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$eventId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$eventId, r4);
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
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L20
        L13:
            com.larus.network.http.f r14 = (com.larus.network.http.a) r13;     // Catch: Throwable -> L20
            if ((r14 instanceof com.larus.network.http.y) == false) goto L17;
            this.this$0.onEventDeleted(this.$eventId);     // Catch: Throwable -> L20
            DoraEnvObserveEventViewModel.access$get_deleteSuccess$p(this.this$0).postValue(Boxing.boxBoolean(true));     // Catch: Throwable -> L20
        L23:
            return Unit.INSTANCE;
        L17:
            if ((r14 instanceof com.larus.network.http.f) == false) goto L23;
            DoraEnvObserveEventViewModel.access$get_deleteSuccess$p(this.this$0).postValue(Boxing.boxBoolean(false));     // Catch: Throwable -> L20
            FLogger.a.e(DoraEnvObserveEventViewModel.access$getTAG$p(this.this$0), "Error deleting event", r14.d);     // Catch: Throwable -> L20
            goto L23
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L20
            DoraEnvObserveEventViewModel r15 = this.this$0;     // Catch: Throwable -> L20
            String r2 = this.$eventId;     // Catch: Throwable -> L20
            r8.put("dora_sub_biz", DoraEnvObserveEventViewModel.access$getDoraSubBiz(r15));     // Catch: Throwable -> L20
            r8.put("event_ids", new JSONArray().put(r2));     // Catch: Throwable -> L20
            com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L20
            this.label = 1;     // Catch: Throwable -> L20
            r13 = com.larus.dora.api.network.a.c(r5, Object.class, "/alice/wearable/event/delete_user_event", r8, null, this, 248);     // Catch: Throwable -> L20
            if (r13 != r0) goto L13;
            return r0;
        L20:
            th = move-exception;
            DoraEnvObserveEventViewModel.access$get_deleteSuccess$p(this.this$0).postValue(Boxing.boxBoolean(false));
            FLogger.a.e(DoraEnvObserveEventViewModel.access$getTAG$p(this.this$0), "Error deleting event", th);
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.event.DoraEnvObserveEventViewModel$loadEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.event.DoraEnvObserveEventViewModel$loadEvents$1", f = "DoraEnvObserveEventViewModel.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isInitialLoad;
        final /* synthetic */ boolean $isRefresh;
        int label;
        final /* synthetic */ DoraEnvObserveEventViewModel this$0;

        public C01101(DoraEnvObserveEventViewModel r1, boolean r2, boolean r3, Continuation<? super C01101> r4) {
            this.this$0 = r1;
            this.$isRefresh = r2;
            this.$isInitialLoad = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01101(this.this$0, this.$isRefresh, this.$isInitialLoad, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            String r3 = "Failed to load events";
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L8;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L41
        L13:
            com.larus.network.http.y r16 = (com.larus.network.http.a) r15;     // Catch: Throwable -> L41
            if ((r16 instanceof com.larus.network.http.y) == false) goto L27;
            o98.a r17 = (o98.a) ((com.larus.network.http.a) r16).b;     // Catch: Throwable -> L41
            if (r17 == null) goto L23;
            List<EnvObserveMemoryEvent> r0 = r17.b();     // Catch: Throwable -> L41
            if (r0 == null) goto L21;
            List r4 = CollectionsKt.filterNotNull(r0);     // Catch: Throwable -> L41
            if (r4 == null) goto L21;
        L22:
            List r5 = DoraEnvObserveEventViewModel.access$mergeResults(this.this$0, this.$isRefresh, r4);     // Catch: Throwable -> L41
            DoraEnvObserveEventViewModel.access$get_eventList$p(this.this$0).postValue(r5);     // Catch: Throwable -> L41
            DoraEnvObserveEventViewModel.access$setHasMore$p(this.this$0, Intrinsics.areEqual(r17.a(), Boxing.boxBoolean(true)));     // Catch: Throwable -> L41
            DoraEnvObserveEventViewModel.access$setNextCursor$p(this.this$0, r17.c());     // Catch: Throwable -> L41
            DoraEnvObserveEventViewModel.access$get_error$p(this.this$0).postValue(null);     // Catch: Throwable -> L41
        L37:
            if (this.$isRefresh == true) goto L39;
        L55:
            DoraEnvObserveEventViewModel.access$get_isLoading$p(this.this$0).postValue(Boxing.boxBoolean(false));
        L57:
            return Unit.INSTANCE;
        L39:
            if (this.$isInitialLoad == true) goto L53;
        L54:
            DoraEnvObserveEventViewModel.access$get_isRefreshing$p(this.this$0).postValue(Boxing.boxBoolean(false));
        L53:
            DoraEnvObserveEventViewModel.access$get_isLoadDataLoading$p(this.this$0).postValue(Boxing.boxBoolean(false));
        L21:
            r4 = CollectionsKt.emptyList();     // Catch: Throwable -> L41
            goto L22
        L23:
            FLogger.a.e(DoraEnvObserveEventViewModel.access$getTAG$p(this.this$0), "Error loading events: responseBody is null");     // Catch: Throwable -> L41
            if (this.$isInitialLoad == false) goto L37;
            DoraEnvObserveEventViewModel.access$get_error$p(this.this$0).postValue("Error loading events: responseBody is null");     // Catch: Throwable -> L41
            goto L37
        L27:
            if ((r16 instanceof com.larus.network.http.f) == false) goto L37;
            FLogger.a.e(DoraEnvObserveEventViewModel.access$getTAG$p(this.this$0), "Error loading events", ((com.larus.network.http.f) r16).d);     // Catch: Throwable -> L41
            if (this.$isInitialLoad == false) goto L37;
            MutableLiveData r6 = DoraEnvObserveEventViewModel.access$get_error$p(this.this$0);     // Catch: Throwable -> L41
            AsyncThrowable r18 = ((com.larus.network.http.f) r16).d;     // Catch: Throwable -> L41
            if (r18 == null) goto L34;
            String r19 = r18.getMessage();     // Catch: Throwable -> L41
            if (r19 == null) goto L34;
        L35:
            r6.postValue(r19);     // Catch: Throwable -> L41
        L34:
            r19 = "Failed to load events";
            goto L35
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r15);
            JSONObject r10 = new JSONObject();     // Catch: Throwable -> L41
            DoraEnvObserveEventViewModel r110 = this.this$0;     // Catch: Throwable -> L41
            r10.put("dora_sub_biz", DoraEnvObserveEventViewModel.access$getDoraSubBiz(r110));     // Catch: Throwable -> L41
            r10.put("size", 20);     // Catch: Throwable -> L41
            r10.put("cursor", DoraEnvObserveEventViewModel.access$getNextCursor$p(r110));     // Catch: Throwable -> L41
            com.larus.dora.api.network.a r7 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L41
            this.label = 1;     // Catch: Throwable -> L41
            r15 = com.larus.dora.api.network.a.c(r7, o98.a.class, "/alice/wearable/event/list_user_event", r10, null, this, 248);     // Catch: Throwable -> L41
            if (r15 != r1) goto L13;
            return r1;
        L41:
            th = move-exception;
            FLogger.a.e(DoraEnvObserveEventViewModel.access$getTAG$p(this.this$0), "Error loading events", th);     // Catch: Throwable -> L58
            if (this.$isInitialLoad == false) goto L50;
            MutableLiveData r8 = DoraEnvObserveEventViewModel.access$get_error$p(this.this$0);     // Catch: Throwable -> L58
            String r111 = th.getMessage();     // Catch: Throwable -> L58
            if (r111 == null) goto L48;
            r3 = r111;
        L48:
            r8.postValue(r3);     // Catch: Throwable -> L58
        L50:
            if (this.$isRefresh == false) goto L55;
            if (this.$isInitialLoad == false) goto L54;
        L58:
            th = move-exception;
            if (this.$isRefresh == true) goto L62;
            DoraEnvObserveEventViewModel.access$get_isLoading$p(this.this$0).postValue(Boxing.boxBoolean(false));
        L66:
            throw th;
        L62:
            if (this.$isInitialLoad == false) goto L64;
            DoraEnvObserveEventViewModel.access$get_isLoadDataLoading$p(this.this$0).postValue(Boxing.boxBoolean(false));
            goto L66
        L64:
            DoraEnvObserveEventViewModel.access$get_isRefreshing$p(this.this$0).postValue(Boxing.boxBoolean(false));
            goto L66
        }
    }

    private final int getDoraSubBiz() {
        FlowDoraSubBizType.a r0 = FlowDoraSubBizType.Companion;
        Integer r1 = this.productId;
        r0.getClass();
        return FlowDoraSubBizType.a.b(r1);
    }

    private final boolean isRefreshInProgress() {
        Object r0 = this._isRefreshing.getValue();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this._isLoadDataLoading.getValue(), r1) == true) goto L8;
        return false;
    }

    public final void loadMore() {
        if (this.hasMore == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this._isLoading.getValue(), Boolean.TRUE) == false) goto L7;
        return;
    L7:
        if (isRefreshInProgress() == true) goto L12;
        loadEvents(false);
        return;
    }

    public final void resetDeleteSuccess() {
        this._deleteSuccess.setValue(null);
    }

    public DoraEnvObserveEventViewModel() {
        this.TAG = "DoraEnvObserveMemoryData";
        MutableLiveData<List<o98.c>> r0 = new MutableLiveData();
        this._eventList = r0;
        this.eventList = r0;
        MutableLiveData<Boolean> r1 = new MutableLiveData();
        this._isLoading = r1;
        this.isLoading = r1;
        MutableLiveData<Boolean> r2 = new MutableLiveData();
        this._isRefreshing = r2;
        this.isRefreshing = r2;
        MutableLiveData<Boolean> r3 = new MutableLiveData();
        this._isLoadDataLoading = r3;
        this.isLoadDataLoading = r3;
        MutableLiveData<String> r4 = new MutableLiveData();
        this._error = r4;
        this.error = r4;
        MutableLiveData<Boolean> r5 = new MutableLiveData();
        this._deleteSuccess = r5;
        this.deleteSuccess = r5;
        this.hasMore = true;
    }

    public final void refresh() {
        if (isRefreshInProgress() == false) goto L5;
        return;
    L5:
        loadEvents(true);
    }

    public final LiveData<Boolean> getDeleteSuccess() {
        return this.deleteSuccess;
    }

    public final LiveData<String> getError() {
        return this.error;
    }

    public final LiveData<List<o98.c>> getEventList() {
        return this.eventList;
    }

    public final LiveData<Boolean> isLoadDataLoading() {
        return this.isLoadDataLoading;
    }

    public final LiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    public final LiveData<Boolean> isRefreshing() {
        return this.isRefreshing;
    }

    public static final /* synthetic */ int access$getDoraSubBiz(DoraEnvObserveEventViewModel r0) {
        return r0.getDoraSubBiz();
    }

    public static final /* synthetic */ String access$getNextCursor$p(DoraEnvObserveEventViewModel r0) {
        return r0.nextCursor;
    }

    public static final /* synthetic */ String access$getTAG$p(DoraEnvObserveEventViewModel r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ MutableLiveData access$get_deleteSuccess$p(DoraEnvObserveEventViewModel r0) {
        return r0._deleteSuccess;
    }

    public static final /* synthetic */ MutableLiveData access$get_error$p(DoraEnvObserveEventViewModel r0) {
        return r0._error;
    }

    public static final /* synthetic */ MutableLiveData access$get_eventList$p(DoraEnvObserveEventViewModel r0) {
        return r0._eventList;
    }

    public static final /* synthetic */ MutableLiveData access$get_isLoadDataLoading$p(DoraEnvObserveEventViewModel r0) {
        return r0._isLoadDataLoading;
    }

    public static final /* synthetic */ MutableLiveData access$get_isLoading$p(DoraEnvObserveEventViewModel r0) {
        return r0._isLoading;
    }

    public static final /* synthetic */ MutableLiveData access$get_isRefreshing$p(DoraEnvObserveEventViewModel r0) {
        return r0._isRefreshing;
    }

    private final long getStartOfDayMillis(long r4) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r4 * ((long) 1000));
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        return r0.getTimeInMillis();
    }

    private final void loadEvents(boolean r10) {
        List r0 = (List) this._eventList.getValue();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        if (r10 == true) goto L7;
    L9:
        boolean r1 = false;
    L11:
        if (r10 == false) goto L16;
        if (r1 == false) goto L14;
        this._isLoadDataLoading.postValue(Boolean.TRUE);
        this._isRefreshing.postValue(Boolean.FALSE);
    L15:
        this.nextCursor = null;
    L17:
        if (r1 == false) goto L19;
        this._error.postValue(null);
    L19:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01101(this, r10, r1, null), 2, null);
        return;
    L14:
        this._isRefreshing.postValue(Boolean.TRUE);
        goto L15
    L16:
        this._isRefreshing.postValue(Boolean.FALSE);
        this._isLoading.postValue(Boolean.TRUE);
        goto L17
    L7:
        if (r0.isEmpty() == false) goto L9;
        r1 = true;
        goto L11
    }

    public final void deleteMemory(String r8) {
        Intrinsics.checkNotNullParameter(r8, "eventId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r8, null), 2, null);
    }

    public final void onEventDeleted(String r7) {
        Intrinsics.checkNotNullParameter(r7, "eventId");
        List r0 = (List) this._eventList.getValue();
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();
    L6:
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L9:
        int r3 = 0;
        if (r2.hasNext() == false) goto L18;
        Object r4 = r2.next();
        o98.c r5 = (o98.c) r4;
        if ((r5 instanceof EnvObserveMemoryEvent) == true) goto L14;
    L16:
        if (r3 != 0) goto L9;
        r1.add(r4);
        goto L9
    L14:
        if (Intrinsics.areEqual(((EnvObserveMemoryEvent) r5).getId(), r7) == false) goto L16;
        r3 = 1;
        goto L16
    L18:
        ArrayList r8 = new ArrayList();
        Iterator r6 = r1.iterator();
    L20:
        if (r6.hasNext() == false) goto L31;
        Object r9 = r6.next();
        int r10 = r3 + 1;
        if (r3 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        o98.c r11 = (o98.c) r9;
        if ((r11 instanceof o98.b) == true) goto L27;
        r8.add(r11);
    L30:
        r3 = r10;
        goto L20
    L27:
        if ((((o98.c) CollectionsKt.getOrNull(r1, r10)) instanceof EnvObserveMemoryEvent) == false) goto L30;
        r8.add(r11);
        goto L30
    L31:
        this._eventList.postValue(r8);
    }

    public final void setProductId(Integer r1) {
        this.productId = r1;
    }

    public static final /* synthetic */ void access$setHasMore$p(DoraEnvObserveEventViewModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setNextCursor$p(DoraEnvObserveEventViewModel r0, String r1) {
        r0.nextCursor = r1;
    }

    private final List<o98.c> mergeResults(boolean r9, List<EnvObserveMemoryEvent> r10) {
        if (r9 == false) goto L4;
        List r0 = new ArrayList();
    L9:
        if (r10.isEmpty() == false) goto L12;
        return r0;
    L12:
        if (r9 == true) goto L30;
        ListIterator r11 = r0.listIterator(r0.size());
    L15:
        EnvObserveMemoryEvent r4 = null;
        if (r11.hasPrevious() == false) goto L20;
        Object r3 = r11.previous();
        if ((((o98.c) r3) instanceof EnvObserveMemoryEvent) == false) goto L15;
    L22:
        if ((r3 instanceof EnvObserveMemoryEvent) == false) goto L24;
        r4 = (EnvObserveMemoryEvent) r3;
    L24:
        if (r4 == null) goto L30;
        Long r12 = r4.getStartTime();
        if (r12 == null) goto L28;
        long r5 = r12.longValue();
    L29:
        long r6 = getStartOfDayMillis(r5);
    L31:
        Iterator<T> r13 = r10.iterator();
    L33:
        if (r13.hasNext() == false) goto L42;
        EnvObserveMemoryEvent r14 = (EnvObserveMemoryEvent) r13.next();
        Long r7 = r14.getStartTime();
        if (r7 == null) goto L37;
        long r8 = r7.longValue();
    L38:
        long r15 = getStartOfDayMillis(r8);
        if (r15 == r6) goto L41;
        r0.add(new o98.b(ia8.d.b(r15)));
        r6 = r15;
    L41:
        r0.add(r14);
        goto L33
    L37:
        r8 = 0;
        goto L38
    L42:
        return r0;
    L28:
        r5 = 0;
        goto L29
    L20:
        r3 = null;
    L30:
        r6 = 0;
        goto L31
    L4:
        List r1 = (List) this._eventList.getValue();
        if (r1 != null) goto L7;
        r1 = CollectionsKt.emptyList();
    L7:
        r0 = CollectionsKt.toMutableList(r1);
        goto L9
    }

    public static final /* synthetic */ List access$mergeResults(DoraEnvObserveEventViewModel r0, boolean r1, List r2) {
        return r0.mergeResults(r1, r2);
    }
}
