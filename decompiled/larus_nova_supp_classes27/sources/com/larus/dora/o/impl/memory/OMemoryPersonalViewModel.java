package com.larus.dora.o.impl.memory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.List;
import java.util.UUID;
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
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0006\u0010\u001d\u001a\u00020\u0017J\u0016\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013J\u0016\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u000e\u0010'\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\n¨\u0006)"}, d2 = {"Lcom/larus/dora/o/impl/memory/OMemoryPersonalViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_listState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/o/impl/memory/OMemoryPersonalViewModel$ListState;", "listState", "Lkotlinx/coroutines/flow/StateFlow;", "getListState", "()Lkotlinx/coroutines/flow/StateFlow;", "_saveFailed", "", "saveFailed", "getSaveFailed", "_deleteFailed", "deleteFailed", "getDeleteFailed", "_saveRejectCode", "", "saveRejectCode", "getSaveRejectCode", "resetSaveRejectCode", "", "resetSaveFailed", "resetDeleteFailed", "currentEntries", "", "Lcom/larus/dora/o/impl/memory/OPersonalMemoryEntry;", "loadData", "addMemory", "content", "", "maxEntries", "updateMemory", "entryId", "applySaveResult", "result", "Lcom/larus/dora/o/impl/memory/OPersonalMemoryMutationResult;", "deleteMemory", "ListState", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OMemoryPersonalViewModel extends ViewModel {
    private final z0<Boolean> _deleteFailed;
    private final z0<a> _listState;
    private final z0<Boolean> _saveFailed;
    private final z0<Long> _saveRejectCode;
    private final i1<Boolean> deleteFailed;
    private final i1<a> listState;
    private final i1<Boolean> saveFailed;
    private final i1<Long> saveRejectCode;

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryPersonalViewModel$a$a, reason: collision with other inner class name */
        public static final class C0097a extends a {
            public final List<o0> a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0097a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0097a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Content(entries=" + this.a + ')';
            }

            public C0097a(List<o0> r2) {
                Intrinsics.checkNotNullParameter(r2, "entries");
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

    /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryPersonalViewModel$addMemory$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryPersonalViewModel$addMemory$1", f = "OMemoryPersonalViewModel.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ long $maxEntries;
        Object L$0;
        int label;
        final /* synthetic */ OMemoryPersonalViewModel this$0;

        public AnonymousClass1(OMemoryPersonalViewModel r1, String r2, long r3, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$content = r2;
            this.$maxEntries = r3;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$content, this.$maxEntries, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            OMemoryPersonalViewModel r2 = (OMemoryPersonalViewModel) this.L$0;
            ResultKt.throwOnFailure(r10);
        L12:
            OMemoryPersonalViewModel.access$applySaveResult(r2, (q0) r10);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            OMemoryPersonalViewModel r11 = this.this$0;
            OMemoryRepo r3 = OMemoryRepo.a;
            String r4 = this.$content;
            long r5 = this.$maxEntries;
            String r7 = UUID.randomUUID().toString();
            this.L$0 = r11;
            this.label = 1;
            Object r6 = r3.a(r4, r5, r7, this);
            if (r6 != r0) goto L11;
            return r0;
        L11:
            r2 = r11;
            r10 = r6;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryPersonalViewModel$deleteMemory$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryPersonalViewModel$deleteMemory$1", f = "OMemoryPersonalViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $entryId;
        int label;
        final /* synthetic */ OMemoryPersonalViewModel this$0;

        public C04531(long r1, OMemoryPersonalViewModel r3, Continuation<? super C04531> r4) {
            this.$entryId = r1;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04531(this.$entryId, this.this$0, r5);
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
        L11:
            p0 r7 = (p0) r6;
            if (r7 != null) goto L14;
            OMemoryPersonalViewModel.access$get_deleteFailed$p(this.this$0).setValue(Boxing.boxBoolean(true));
        L21:
            return Unit.INSTANCE;
        L14:
            z0 r2 = OMemoryPersonalViewModel.access$get_listState$p(this.this$0);
            List<o0> r8 = r7.a();
            if (r8 == null) goto L18;
            List r9 = CollectionsKt.filterNotNull(r8);
            if (r9 == null) goto L18;
        L19:
            r2.setValue(new a.C0097a(r9));
        L18:
            r9 = CollectionsKt.emptyList();
            goto L19
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            OMemoryRepo r10 = OMemoryRepo.a;
            long r3 = this.$entryId;
            this.label = 1;
            r6 = r10.d(r3, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryPersonalViewModel$loadData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryPersonalViewModel$loadData$1", f = "OMemoryPersonalViewModel.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OMemoryPersonalViewModel this$0;

        public C04541(OMemoryPersonalViewModel r1, Continuation<? super C04541> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04541(this.this$0, r3);
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
        L11:
            p0 r5 = (p0) r4;
            z0 r2 = OMemoryPersonalViewModel.access$get_listState$p(this.this$0);
            if (r5 != null) goto L14;
            Object r6 = a.b.a;
        L20:
            r2.setValue(r6);
            return Unit.INSTANCE;
        L14:
            List<o0> r7 = r5.a();
            if (r7 == null) goto L18;
            List r8 = CollectionsKt.filterNotNull(r7);
            if (r8 == null) goto L18;
        L19:
            r6 = new a.C0097a(r8);
        L18:
            r8 = CollectionsKt.emptyList();
            goto L19
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            OMemoryRepo r9 = OMemoryRepo.a;
            this.label = 1;
            r4 = r9.f(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryPersonalViewModel$updateMemory$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryPersonalViewModel$updateMemory$1", f = "OMemoryPersonalViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ long $entryId;
        Object L$0;
        int label;
        final /* synthetic */ OMemoryPersonalViewModel this$0;

        public C04551(OMemoryPersonalViewModel r1, long r2, String r4, Continuation<? super C04551> r5) {
            this.this$0 = r1;
            this.$entryId = r2;
            this.$content = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C04551(this.this$0, this.$entryId, this.$content, r8);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            OMemoryPersonalViewModel r2 = (OMemoryPersonalViewModel) this.L$0;
            ResultKt.throwOnFailure(r7);
        L12:
            OMemoryPersonalViewModel.access$applySaveResult(r2, (q0) r7);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            OMemoryPersonalViewModel r8 = this.this$0;
            OMemoryRepo r3 = OMemoryRepo.a;
            long r4 = this.$entryId;
            String r5 = this.$content;
            this.L$0 = r8;
            this.label = 1;
            Object r6 = r3.g(r4, r5, this);
            if (r6 != r0) goto L11;
            return r0;
        L11:
            r2 = r8;
            r7 = r6;
            goto L12
        }
    }

    public final List<o0> currentEntries() {
        Object r0 = this._listState.getValue();
        if ((r0 instanceof a.C0097a) == false) goto L5;
        a.C0097a r1 = (a.C0097a) r0;
    L6:
        if (r1 == null) goto L10;
        List<o0> r2 = r1.a;
        if (r2 == null) goto L10;
        return r2;
    L10:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }

    public final void loadData() {
        this._listState.setValue(a.c.a);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04541(this, null), 2, null);
    }

    public final void resetDeleteFailed() {
        this._deleteFailed.setValue(Boolean.FALSE);
    }

    public final void resetSaveFailed() {
        this._saveFailed.setValue(Boolean.FALSE);
    }

    public final void resetSaveRejectCode() {
        this._saveRejectCode.setValue(null);
    }

    public OMemoryPersonalViewModel() {
        StateFlowImpl r0 = j1.a(a.c.a);
        this._listState = r0;
        this.listState = r0;
        Boolean r1 = Boolean.FALSE;
        StateFlowImpl r2 = j1.a(r1);
        this._saveFailed = r2;
        this.saveFailed = r2;
        StateFlowImpl r3 = j1.a(r1);
        this._deleteFailed = r3;
        this.deleteFailed = r3;
        StateFlowImpl r4 = j1.a(null);
        this._saveRejectCode = r4;
        this.saveRejectCode = r4;
    }

    public final i1<Boolean> getDeleteFailed() {
        return this.deleteFailed;
    }

    public final i1<a> getListState() {
        return this.listState;
    }

    public final i1<Boolean> getSaveFailed() {
        return this.saveFailed;
    }

    public final i1<Long> getSaveRejectCode() {
        return this.saveRejectCode;
    }

    public static final /* synthetic */ z0 access$get_deleteFailed$p(OMemoryPersonalViewModel r0) {
        return r0._deleteFailed;
    }

    public static final /* synthetic */ z0 access$get_listState$p(OMemoryPersonalViewModel r0) {
        return r0._listState;
    }

    private final void applySaveResult(q0 r6) {
        if (r6 != null) goto L5;
        this._saveFailed.setValue(Boolean.TRUE);
        return;
    L5:
        Long r0 = r6.b;
        if (r0 == null) goto L8;
        long r3 = r0.longValue();
    L10:
        if (r3 == 0) goto L13;
        this._saveRejectCode.setValue(Long.valueOf(r3));
        return;
    L13:
        p0 r7 = r6.a;
        if (r7 == null) goto L22;
        z0<a> r1 = this._listState;
        List<o0> r8 = r7.a();
        if (r8 == null) goto L19;
        List r9 = CollectionsKt.filterNotNull(r8);
        if (r9 == null) goto L19;
    L20:
        r1.setValue(new a.C0097a(r9));
        return;
    L19:
        r9 = CollectionsKt.emptyList();
        goto L20
    L22:
        return;
    L8:
        r3 = 0;
        goto L10
    }

    public final void deleteMemory(long r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04531(r7, this, null), 2, null);
    }

    public static final /* synthetic */ void access$applySaveResult(OMemoryPersonalViewModel r0, q0 r1) {
        r0.applySaveResult(r1);
    }

    public final void addMemory(String r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "content");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r11, r12, null), 2, null);
    }

    public final void updateMemory(long r11, String r13) {
        Intrinsics.checkNotNullParameter(r13, "content");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04551(this, r11, r13, null), 2, null);
    }
}
