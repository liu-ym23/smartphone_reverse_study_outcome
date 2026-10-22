package com.larus.contextwindow.impl.ui;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.impl.data.ContextWindowSnapshotStore;
import com.larus.contextwindow.impl.membership.k;
import com.larus.contextwindow.impl.membership.l;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.h1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/larus/contextwindow/impl/ui/ContextWindowUsageViewModel;", "Landroidx/lifecycle/ViewModel;", "contextSnapshot", "Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "membershipQuotaStore", "Lcom/larus/contextwindow/impl/membership/MembershipQuotaStore;", "<init>", "(Lcom/larus/contextwindow/api/ContextWindowSnapshot;Lcom/larus/contextwindow/impl/membership/MembershipQuotaStore;)V", "contextSnapshots", "Lkotlinx/coroutines/flow/StateFlow;", "compressionStabilizer", "Lcom/larus/contextwindow/impl/ui/ContextWindowCompressionStabilizer;", "state", "Lcom/larus/contextwindow/impl/ui/ContextWindowPanelState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "ensureMembershipRuntimeInitialized", "", "refreshMembershipQuota", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowUsageViewModel extends ViewModel {
    public static final a Companion = null;
    private final ContextWindowCompressionStabilizer compressionStabilizer;
    private final ContextWindowSnapshot contextSnapshot;
    private final i1<ContextWindowSnapshot> contextSnapshots;
    private final l membershipQuotaStore;
    private final i1<com.larus.contextwindow.impl.ui.a> state;

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.ui.ContextWindowUsageViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.contextwindow.impl.ui.ContextWindowUsageViewModel$1", f = "ContextWindowUsageViewModel.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextWindowUsageViewModel this$0;

        /* JADX INFO: renamed from: com.larus.contextwindow.impl.ui.ContextWindowUsageViewModel$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ContextWindowUsageViewModel a;

            public a(ContextWindowUsageViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                ContextWindowUsageViewModel.access$getCompressionStabilizer$p(this.a).update(((ContextWindowSnapshot) r1).k);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(ContextWindowUsageViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            i1 r6 = ContextWindowUsageViewModel.access$getContextSnapshots$p(this.this$0);
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final void ensureMembershipRuntimeInitialized() {
        k.a();
    }

    public final i1<com.larus.contextwindow.impl.ui.a> getState() {
        return this.state;
    }

    public static final /* synthetic */ ContextWindowCompressionStabilizer access$getCompressionStabilizer$p(ContextWindowUsageViewModel r0) {
        return r0.compressionStabilizer;
    }

    public static final /* synthetic */ i1 access$getContextSnapshots$p(ContextWindowUsageViewModel r0) {
        return r0.contextSnapshots;
    }

    public final Object refreshMembershipQuota(Continuation<? super Unit> r2) {
        Object r3 = this.membershipQuotaStore.a(r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    public ContextWindowUsageViewModel(ContextWindowSnapshot r12, l r13) {
        Intrinsics.checkNotNullParameter(r12, "contextSnapshot");
        Intrinsics.checkNotNullParameter(r13, "membershipQuotaStore");
        this.contextSnapshot = r12;
        this.membershipQuotaStore = r13;
        Flow r0 = ContextWindowSnapshotStore.a(r12);
        CoroutineScope r1 = ViewModelKt.getViewModelScope(this);
        g1.a.getClass();
        h1 r2 = g1.a.b;
        b1 r3 = kotlinx.coroutines.flow.e.F(r0, r1, r2, r12);
        this.contextSnapshots = r3;
        ContextWindowCompressionStabilizer r4 = new ContextWindowCompressionStabilizer(ViewModelKt.getViewModelScope(this), r12.k);
        this.compressionStabilizer = r4;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        FlowKt__ZipKt$combine$.inlined.combineUnsafe.FlowKt__ZipKt.1 r5 = kotlinx.coroutines.flow.e.j(r3, r4.f, r13.getState(), new ContextWindowUsageViewModel$state$1(null));
        CoroutineScope r6 = ViewModelKt.getViewModelScope(this);
        int r7 = b.a;
        this.state = kotlinx.coroutines.flow.e.F(r5, r6, r2, b.a(r12, (com.larus.contextwindow.impl.membership.h) r13.getState().getValue(), r12.k));
    }
}
