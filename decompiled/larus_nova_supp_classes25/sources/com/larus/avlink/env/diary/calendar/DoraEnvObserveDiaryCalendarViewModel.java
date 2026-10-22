package com.larus.avlink.env.diary.calendar;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0005J\b\u0010\u001d\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/avlink/env/diary/calendar/DoraEnvObserveDiaryCalendarViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "_calendarEmotions", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lcom/larus/avlink/env/diary/calendar/DiaryEmotionItem;", "calendarEmotions", "Lkotlinx/coroutines/flow/SharedFlow;", "getCalendarEmotions", "()Lkotlinx/coroutines/flow/SharedFlow;", "calendarNextCursor", "calendarHasMore", "", "jumpProductId", "", "Ljava/lang/Integer;", "setJumpProductId", "", "productId", "(Ljava/lang/Integer;)V", "getDoraSubBiz", "loadCalendarEmotions", "loadMoreCalendarEmotions", "onDiaryDeleted", "diaryId", "loadCalendarEmotionsInternal", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveDiaryCalendarViewModel extends ViewModel {
    public static final int $stable = 8;
    private final String TAG;
    private final MutableSharedFlow<List<j>> _calendarEmotions;
    private final d1<List<j>> calendarEmotions;
    private boolean calendarHasMore;
    private String calendarNextCursor;
    private Integer jumpProductId;

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.calendar.DoraEnvObserveDiaryCalendarViewModel$loadCalendarEmotionsInternal$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.calendar.DoraEnvObserveDiaryCalendarViewModel$loadCalendarEmotionsInternal$1", f = "DoraEnvObserveDiaryCalendarViewModel.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraEnvObserveDiaryCalendarViewModel this$0;

        public AnonymousClass1(DoraEnvObserveDiaryCalendarViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = this.label;
            if (r3 == 0) goto L9;
            if (r3 != 1) goto L8;
            ResultKt.throwOnFailure(r14);     // Catch: Exception -> L34
        L13:
            y r15 = (com.larus.network.http.a) r14;     // Catch: Exception -> L34
            if ((r15 instanceof y) == false) goto L31;
            k r16 = (k) ((com.larus.network.http.a) r15).b;     // Catch: Exception -> L34
            if (r16 == null) goto L29;
            List<j> r1 = r16.b();     // Catch: Exception -> L34
            if (r1 != null) goto L20;
            r1 = CollectionsKt.emptyList();     // Catch: Exception -> L34
        L20:
            FLogger.a.i(DoraEnvObserveDiaryCalendarViewModel.access$getTAG$p(this.this$0), "loadCalendarEmotionsInternal: success, newItems size=" + r1.size());     // Catch: Exception -> L34
            if (DoraEnvObserveDiaryCalendarViewModel.access$getCalendarNextCursor$p(this.this$0) != null) goto L23;
            List r0 = new ArrayList();     // Catch: Exception -> L34
        L28:
            r0.addAll(CollectionsKt.filterNotNull(r1));     // Catch: Exception -> L34
            DoraEnvObserveDiaryCalendarViewModel.access$get_calendarEmotions$p(this.this$0).tryEmit(r0);     // Catch: Exception -> L34
            DoraEnvObserveDiaryCalendarViewModel.access$setCalendarHasMore$p(this.this$0, Intrinsics.areEqual(r16.a(), Boxing.boxBoolean(true)));     // Catch: Exception -> L34
            DoraEnvObserveDiaryCalendarViewModel.access$setCalendarNextCursor$p(this.this$0, r16.c());     // Catch: Exception -> L34
        L37:
            return Unit.INSTANCE;
        L23:
            List r4 = (List) CollectionsKt.lastOrNull(DoraEnvObserveDiaryCalendarViewModel.access$get_calendarEmotions$p(this.this$0).getReplayCache());     // Catch: Exception -> L34
            if (r4 == null) goto L27;
            r0 = CollectionsKt.toMutableList(r4);     // Catch: Exception -> L34
            if (r0 != null) goto L28;
        L27:
            r0 = new ArrayList();     // Catch: Exception -> L34
            goto L28
        L29:
            FLogger.a.e(DoraEnvObserveDiaryCalendarViewModel.access$getTAG$p(this.this$0), "Error loading calendar emotions: responseBody is null");     // Catch: Exception -> L34
            goto L37
        L31:
            if ((r15 instanceof com.larus.network.http.f) == false) goto L37;
            FLogger.a.e(DoraEnvObserveDiaryCalendarViewModel.access$getTAG$p(this.this$0), "Error loading calendar emotions", ((com.larus.network.http.f) r15).d);     // Catch: Exception -> L34
            goto L37
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
            FLogger.a.i(DoraEnvObserveDiaryCalendarViewModel.access$getTAG$p(this.this$0), "loadCalendarEmotionsInternal: start loading, cursor=" + DoraEnvObserveDiaryCalendarViewModel.access$getCalendarNextCursor$p(this.this$0));     // Catch: Exception -> L34
            JSONObject r9 = new JSONObject();     // Catch: Exception -> L34
            DoraEnvObserveDiaryCalendarViewModel r17 = this.this$0;     // Catch: Exception -> L34
            r9.put("biz_id", DoraEnvObserveDiaryCalendarViewModel.access$getDoraSubBiz(r17));     // Catch: Exception -> L34
            r9.put("cursor", DoraEnvObserveDiaryCalendarViewModel.access$getCalendarNextCursor$p(r17));     // Catch: Exception -> L34
            com.larus.dora.api.network.a r6 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L34
            this.label = 1;     // Catch: Exception -> L34
            r14 = com.larus.dora.api.network.a.c(r6, k.class, "/alice/wearable/diary/list_user_diary_brief", r9, null, this, 248);     // Catch: Exception -> L34
            if (r14 != r2) goto L13;
            return r2;
        L34:
            e = move-exception;
            FLogger.a.e(DoraEnvObserveDiaryCalendarViewModel.access$getTAG$p(this.this$0), "Error loading calendar emotions", e);
            goto L37
        }
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

    private final void loadCalendarEmotionsInternal() {
        if (this.calendarHasMore == true) goto L7;
        FLogger.a.i(this.TAG, "loadCalendarEmotionsInternal: no more data");
        return;
    L7:
        if (this.calendarNextCursor != null) goto L9;
        this._calendarEmotions.tryEmit(CollectionsKt.emptyList());
    L9:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final void loadCalendarEmotions() {
        FLogger.a.i(this.TAG, "loadCalendarEmotions");
        this.calendarNextCursor = null;
        this.calendarHasMore = true;
        loadCalendarEmotionsInternal();
    }

    public final void loadMoreCalendarEmotions() {
        FLogger.a.i(this.TAG, "loadMoreCalendarEmotions");
        loadCalendarEmotionsInternal();
    }

    public DoraEnvObserveDiaryCalendarViewModel() {
        this.TAG = "DoraEnvObserveDiaryCalendar";
        FLogger.a.i("DoraEnvObserveDiaryCalendar", "init: hash=" + hashCode());
        MutableSharedFlow<List<j>> r0 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._calendarEmotions = r0;
        this.calendarEmotions = r0;
        this.calendarHasMore = true;
    }

    public final d1<List<j>> getCalendarEmotions() {
        return this.calendarEmotions;
    }

    public static final /* synthetic */ String access$getCalendarNextCursor$p(DoraEnvObserveDiaryCalendarViewModel r0) {
        return r0.calendarNextCursor;
    }

    public static final /* synthetic */ int access$getDoraSubBiz(DoraEnvObserveDiaryCalendarViewModel r0) {
        return r0.getDoraSubBiz();
    }

    public static final /* synthetic */ String access$getTAG$p(DoraEnvObserveDiaryCalendarViewModel r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_calendarEmotions$p(DoraEnvObserveDiaryCalendarViewModel r0) {
        return r0._calendarEmotions;
    }

    public final void onDiaryDeleted(String r5) {
        Intrinsics.checkNotNullParameter(r5, "diaryId");
        FLogger.a.i(this.TAG, "onDiaryDeleted: diaryId=" + r5);
        List r0 = (List) CollectionsKt.lastOrNull(this._calendarEmotions.getReplayCache());
        if (r0 != null) goto L5;
        return;
    L5:
        List r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        j r4 = (j) r3.next();
        if (Intrinsics.areEqual(r4.c(), r5) == false) goto L11;
        r4 = j.a(r4, Boolean.FALSE);
    L11:
        r2.add(r4);
        goto L7
    L12:
        this._calendarEmotions.tryEmit(r2);
    }

    public final void setJumpProductId(Integer r1) {
        this.jumpProductId = r1;
    }

    public static final /* synthetic */ void access$setCalendarHasMore$p(DoraEnvObserveDiaryCalendarViewModel r0, boolean r1) {
        r0.calendarHasMore = r1;
    }

    public static final /* synthetic */ void access$setCalendarNextCursor$p(DoraEnvObserveDiaryCalendarViewModel r0, String r1) {
        r0.calendarNextCursor = r1;
    }
}
