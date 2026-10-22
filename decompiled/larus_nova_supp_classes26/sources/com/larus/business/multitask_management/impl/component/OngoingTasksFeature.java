package com.larus.business.multitask_management.impl.component;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.multitask_management.api.PullType;
import com.larus.utils.j0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kl9.u;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/larus/business/multitask_management/impl/component/OngoingTasksFeature;", "Lcom/larus/business/multitask_management/impl/component/BaseTaskSectionFeature;", "Lcom/larus/business/multitask_management/impl/component/IOngoingTasksAbility;", "<init>", "()V", "tasks", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "getTasks", "()Lkotlinx/coroutines/flow/StateFlow;", "onAttach", "", "onCreate", "getOngoingTasks", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OngoingTasksFeature extends BaseTaskSectionFeature implements b {
    public static final j i = null;
    public final i1<List<u>> h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.component.OngoingTasksFeature$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.component.OngoingTasksFeature$onCreate$1", f = "OngoingTasksFeature.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
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
        L13:
            List r5 = (List) r4;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            il9.a r6 = (il9.a) ServiceManager.get().getService(il9.a.class);
            if (r6 == null) goto L15;
            PullType r2 = PullType.ADDITIONAL;
            this.label = 1;
            r4 = r6.p2(false, false, r2, this);
            if (r4 != r0) goto L13;
            return r0;
        }
    }

    static {
        int r1 = j0.a;
        i = new j(j0.d(2131899754), true, 2, SectionCardStyle.LARGE, 0, 112);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, b.class);
    }

    public OngoingTasksFeature() {
        i1<List<u>> r0 = g.a;
        this.h = g.a;
    }

    public final void onCreate() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // com.larus.business.multitask_management.impl.component.b
    public final i1<List<u>> jc() {
        return this.h;
    }
}
