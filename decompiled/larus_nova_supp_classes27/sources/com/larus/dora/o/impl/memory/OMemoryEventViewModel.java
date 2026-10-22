package com.larus.dora.o.impl.memory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
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
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0017J*\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0!H\u0002J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u0002082\u0006\u0010:\u001a\u000208H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\nR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*RL\u0010+\u001a4\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u0017\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006<"}, d2 = {"Lcom/larus/dora/o/impl/memory/OMemoryEventViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_listState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/o/impl/memory/OMemoryEventViewModel$ListState;", "listState", "Lkotlinx/coroutines/flow/StateFlow;", "getListState", "()Lkotlinx/coroutines/flow/StateFlow;", "_refreshFinished", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "refreshFinished", "Lkotlinx/coroutines/flow/SharedFlow;", "getRefreshFinished", "()Lkotlinx/coroutines/flow/SharedFlow;", "_deleteFailed", "", "deleteFailed", "getDeleteFailed", "nextCursor", "", "hasMore", "loading", "resetDeleteFailed", "refresh", "loadMore", "deleteEvent", "eventId", "onEventDeleted", "merge", "", "Lcom/larus/dora/o/impl/memory/OMemoryListItem;", "base", "incoming", "Lcom/larus/dora/o/impl/memory/OMemoryEvent;", "todayGroupTitle", "getTodayGroupTitle", "()Ljava/lang/String;", "setTodayGroupTitle", "(Ljava/lang/String;)V", "monthDayGroupTitleProvider", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "month", "day", "getMonthDayGroupTitleProvider", "()Lkotlin/jvm/functions/Function2;", "setMonthDayGroupTitleProvider", "(Lkotlin/jvm/functions/Function2;)V", "formatGroupTitle", "dayMillis", "", "startOfDayMillis", "timestampSeconds", "ListState", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OMemoryEventViewModel extends ViewModel {
    private final z0<Boolean> _deleteFailed;
    private final z0<a> _listState;
    private final MutableSharedFlow<Unit> _refreshFinished;
    private final i1<Boolean> deleteFailed;
    private boolean hasMore;
    private final i1<a> listState;
    private boolean loading;
    private Function2<? super Integer, ? super Integer, String> monthDayGroupTitleProvider;
    private String nextCursor;
    private final d1<Unit> refreshFinished;
    private String todayGroupTitle;

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryEventViewModel$a$a, reason: collision with other inner class name */
        public static final class C0096a extends a {
            public final List<b0> a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0096a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0096a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Content(items=" + this.a + ')';
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0096a(List<? extends b0> r2) {
                Intrinsics.checkNotNullParameter(r2, "items");
                this.a = r2;
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryEventViewModel$deleteEvent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryEventViewModel$deleteEvent$1", f = "OMemoryEventViewModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $eventId;
        int label;
        final /* synthetic */ OMemoryEventViewModel this$0;

        public AnonymousClass1(String r1, OMemoryEventViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$eventId = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$eventId, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            if (((Boolean) r4).booleanValue() == false) goto L14;
            this.this$0.onEventDeleted(this.$eventId);
        L16:
            return Unit.INSTANCE;
        L14:
            OMemoryEventViewModel.access$get_deleteFailed$p(this.this$0).setValue(Boxing.boxBoolean(true));
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            OMemoryRepo r5 = OMemoryRepo.a;
            String r2 = this.$eventId;
            this.label = 1;
            r4 = r5.c(r2, this);
            if (r4 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryEventViewModel$loadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryEventViewModel$loadMore$1", f = "OMemoryEventViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<b0> $current;
        int label;
        final /* synthetic */ OMemoryEventViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C04511(OMemoryEventViewModel r1, List<? extends b0> r2, Continuation<? super C04511> r3) {
            this.this$0 = r1;
            this.$current = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04511(this.this$0, this.$current, r4);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            a0 r6 = (a0) r5;
            OMemoryEventViewModel.access$setLoading$p(this.this$0, false);
            if (r6 == null) goto L14;
            OMemoryEventViewModel.access$setHasMore$p(this.this$0, Intrinsics.areEqual(r6.a(), Boxing.boxBoolean(true)));
            OMemoryEventViewModel.access$setNextCursor$p(this.this$0, r6.c());
            z0 r2 = OMemoryEventViewModel.access$get_listState$p(this.this$0);
            OMemoryEventViewModel r3 = this.this$0;
            List<b0> r4 = this.$current;
            List<n> r7 = r6.b();
            if (r7 == null) goto L19;
            List r8 = CollectionsKt.filterNotNull(r7);
            if (r8 == null) goto L19;
        L20:
            r2.setValue(new a.C0096a(OMemoryEventViewModel.access$merge(r3, r4, r8)));
            return Unit.INSTANCE;
        L19:
            r8 = CollectionsKt.emptyList();
            goto L20
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            OMemoryRepo r9 = OMemoryRepo.a;
            String r10 = OMemoryEventViewModel.access$getNextCursor$p(this.this$0);
            this.label = 1;
            r5 = r9.e(r10, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryEventViewModel$refresh$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryEventViewModel$refresh$1", f = "OMemoryEventViewModel.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OMemoryEventViewModel this$0;

        public C04521(OMemoryEventViewModel r1, Continuation<? super C04521> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04521(this.this$0, r3);
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
            List<b0> r2 = null;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            a0 r6 = (a0) r5;
            OMemoryEventViewModel.access$setLoading$p(this.this$0, false);
            if (r6 != null) goto L29;
            Object r7 = OMemoryEventViewModel.access$get_listState$p(this.this$0).getValue();
            if ((r7 instanceof a.C0096a) == false) goto L16;
            a.C0096a r8 = (a.C0096a) r7;
        L17:
            if (r8 == null) goto L19;
            r2 = r8.a;
        L19:
            List<b0> r4 = r2;
            if (r4 != null) goto L22;
        L25:
            if (r3 == false) goto L27;
            OMemoryEventViewModel.access$get_listState$p(this.this$0).setValue(a.b.a);
        L27:
            MutableSharedFlow r9 = OMemoryEventViewModel.access$get_refreshFinished$p(this.this$0);
            Unit r10 = Unit.INSTANCE;
            r9.tryEmit(r10);
            return r10;
        L22:
            if (r4.isEmpty() == true) goto L25;
            r3 = false;
            goto L25
        L16:
            r8 = null;
            goto L17
        L29:
            OMemoryEventViewModel.access$setHasMore$p(this.this$0, Intrinsics.areEqual(r6.a(), Boxing.boxBoolean(true)));
            OMemoryEventViewModel.access$setNextCursor$p(this.this$0, r6.c());
            z0 r11 = OMemoryEventViewModel.access$get_listState$p(this.this$0);
            OMemoryEventViewModel r12 = this.this$0;
            List r13 = CollectionsKt.emptyList();
            List<n> r14 = r6.b();
            if (r14 == null) goto L33;
            List r15 = CollectionsKt.filterNotNull(r14);
            if (r15 == null) goto L33;
        L34:
            r11.setValue(new a.C0096a(OMemoryEventViewModel.access$merge(r12, r13, r15)));
            MutableSharedFlow r16 = OMemoryEventViewModel.access$get_refreshFinished$p(this.this$0);
            Unit r17 = Unit.INSTANCE;
            r16.tryEmit(r17);
            return r17;
        L33:
            r15 = CollectionsKt.emptyList();
            goto L34
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            OMemoryRepo r18 = OMemoryRepo.a;
            this.label = 1;
            r5 = r18.e(null, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public final void loadMore() {
        if (this.loading == false) goto L5;
        return;
    L5:
        if (this.hasMore == false) goto L19;
        Object r0 = this._listState.getValue();
        if ((r0 instanceof a.C0096a) == false) goto L10;
        a.C0096a r1 = (a.C0096a) r0;
    L11:
        if (r1 == null) goto L18;
        List<b0> r2 = r1.a;
        if (r2 == null) goto L20;
        this.loading = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04511(this, r2, null), 2, null);
        return;
    L20:
        return;
    L18:
        return;
    L10:
        r1 = null;
        goto L11
    }

    public final void refresh() {
        if (this.loading == false) goto L6;
        this._refreshFinished.tryEmit(Unit.INSTANCE);
        return;
    L6:
        boolean r0 = true;
        this.loading = true;
        Object r1 = this._listState.getValue();
        if ((r1 instanceof a.C0096a) == false) goto L9;
        a.C0096a r2 = (a.C0096a) r1;
    L10:
        if (r2 == null) goto L12;
        List<b0> r3 = r2.a;
    L13:
        List<b0> r4 = r3;
        if (r4 != null) goto L16;
    L19:
        if (r0 == false) goto L21;
        this._listState.setValue(a.c.a);
    L21:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04521(this, null), 2, null);
        return;
    L16:
        if (r4.isEmpty() == true) goto L19;
        r0 = false;
        goto L19
    L12:
        r3 = null;
        goto L13
    L9:
        r2 = null;
        goto L10
    }

    public final void resetDeleteFailed() {
        this._deleteFailed.setValue(Boolean.FALSE);
    }

    public OMemoryEventViewModel() {
        StateFlowImpl r0 = j1.a(a.c.a);
        this._listState = r0;
        this.listState = r0;
        MutableSharedFlow<Unit> r1 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this._refreshFinished = r1;
        this.refreshFinished = r1;
        StateFlowImpl r2 = j1.a(Boolean.FALSE);
        this._deleteFailed = r2;
        this.deleteFailed = r2;
        this.hasMore = true;
        this.todayGroupTitle = "";
    }

    public final i1<Boolean> getDeleteFailed() {
        return this.deleteFailed;
    }

    public final i1<a> getListState() {
        return this.listState;
    }

    public final Function2<Integer, Integer, String> getMonthDayGroupTitleProvider() {
        return this.monthDayGroupTitleProvider;
    }

    public final d1<Unit> getRefreshFinished() {
        return this.refreshFinished;
    }

    public final String getTodayGroupTitle() {
        return this.todayGroupTitle;
    }

    public static final /* synthetic */ String access$getNextCursor$p(OMemoryEventViewModel r0) {
        return r0.nextCursor;
    }

    public static final /* synthetic */ z0 access$get_deleteFailed$p(OMemoryEventViewModel r0) {
        return r0._deleteFailed;
    }

    public static final /* synthetic */ z0 access$get_listState$p(OMemoryEventViewModel r0) {
        return r0._listState;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_refreshFinished$p(OMemoryEventViewModel r0) {
        return r0._refreshFinished;
    }

    private final String formatGroupTitle(long r5) {
        if (r5 == startOfDayMillis(System.currentTimeMillis() / ((long) 1000))) goto L5;
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r5);
        int r1 = r0.get(2) + 1;
        int r2 = r0.get(5);
        Function2<? super Integer, ? super Integer, String> r3 = this.monthDayGroupTitleProvider;
        if (r3 == null) goto L11;
        String r4 = (String) r3.invoke(Integer.valueOf(r1), Integer.valueOf(r2));
        if (r4 == null) goto L11;
        return r4;
    L11:
        return new SimpleDateFormat("M/d", Locale.getDefault()).format(Long.valueOf(r5));
    L5:
        return this.todayGroupTitle;
    }

    private final long startOfDayMillis(long r4) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r4 * ((long) 1000));
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        return r0.getTimeInMillis();
    }

    public final void deleteEvent(String r8) {
        Intrinsics.checkNotNullParameter(r8, "eventId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r8, this, null), 2, null);
    }

    public final void onEventDeleted(String r8) {
        Intrinsics.checkNotNullParameter(r8, "eventId");
        Object r0 = this._listState.getValue();
        if ((r0 instanceof a.C0096a) == false) goto L5;
        a.C0096a r1 = (a.C0096a) r0;
    L6:
        if (r1 == null) goto L47;
        List<b0> r2 = r1.a;
        if (r2 == null) goto L48;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L11:
        boolean r5 = true;
        if (r4.hasNext() == false) goto L21;
        Object r6 = r4.next();
        b0 r7 = (b0) r6;
        if ((r7 instanceof n) == true) goto L16;
    L18:
        r5 = false;
    L19:
        if (r5 == true) goto L11;
        r3.add(r6);
        goto L11
    L16:
        if (Intrinsics.areEqual(((n) r7).c(), r8) == false) goto L18;
    L21:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r3.iterator();
        int r11 = 0;
    L23:
        if (r10.hasNext() == false) goto L37;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        if ((((b0) r12) instanceof z) == true) goto L30;
    L33:
        boolean r14 = true;
    L34:
        if (r14 == false) goto L36;
        r9.add(r12);
    L36:
        r11 = r13;
        goto L23
    L30:
        if ((CollectionsKt.getOrNull(r3, r13) instanceof n) == true) goto L33;
        r14 = false;
        goto L34
    L37:
        this._listState.setValue(new a.C0096a(r9));
        return;
    L48:
        return;
    L47:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setMonthDayGroupTitleProvider(Function2<? super Integer, ? super Integer, String> r1) {
        this.monthDayGroupTitleProvider = r1;
    }

    public final void setTodayGroupTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.todayGroupTitle = r2;
    }

    public static final /* synthetic */ void access$setHasMore$p(OMemoryEventViewModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setLoading$p(OMemoryEventViewModel r0, boolean r1) {
        r0.loading = r1;
    }

    public static final /* synthetic */ void access$setNextCursor$p(OMemoryEventViewModel r0, String r1) {
        r0.nextCursor = r1;
    }

    private final List<b0> merge(List<? extends b0> r9, List<n> r10) {
        List<b0> r11 = CollectionsKt.toMutableList(r9);
        ListIterator<b0> r0 = r11.listIterator(r11.size());
    L3:
        n r2 = null;
        if (r0.hasPrevious() == false) goto L8;
        b0 r1 = r0.previous();
        if ((r1 instanceof n) == false) goto L3;
    L10:
        if ((r1 instanceof n) == false) goto L13;
        r2 = (n) r1;
    L13:
        if (r2 == null) goto L19;
        Long r3 = r2.d();
        if (r3 == null) goto L17;
        long r4 = r3.longValue();
    L18:
        long r5 = startOfDayMillis(r4);
    L20:
        Iterator<T> r12 = r10.iterator();
    L22:
        if (r12.hasNext() == false) goto L31;
        n r6 = (n) r12.next();
        Long r7 = r6.d();
        if (r7 == null) goto L26;
        long r8 = r7.longValue();
    L27:
        long r13 = startOfDayMillis(r8);
        if (r13 == r5) goto L30;
        r11.add(new z(formatGroupTitle(r13)));
        r5 = r13;
    L30:
        r11.add(r6);
        goto L22
    L26:
        r8 = 0;
        goto L27
    L31:
        return r11;
    L17:
        r4 = 0;
        goto L18
    L19:
        r5 = 0;
        goto L20
    L8:
        r1 = null;
        goto L10
    }

    public static final /* synthetic */ List access$merge(OMemoryEventViewModel r0, List r1, List r2) {
        return r0.merge(r1, r2);
    }
}
