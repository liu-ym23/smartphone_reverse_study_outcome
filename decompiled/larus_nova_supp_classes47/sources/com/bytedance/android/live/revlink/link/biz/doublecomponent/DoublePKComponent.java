package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.link.biz.service.e;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoublePKComponent implements e {
    public final CompositeDisposable a;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d b;
    public final PkBaseDataContext c;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doublecomponent.DoublePKComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<PkBaseStateMachine.c, Unit> {
        public AnonymousClass1(DoublePKComponent r8) {
            super(1, r8, DoublePKComponent.class, "onPKStateChange", "onPKStateChange(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$State;)V", 0);
        }

        public final void invoke(PkBaseStateMachine.c r2) {
            ((DoublePKComponent) ((CallableReference) this).receiver).getClass();
            if ((r2 instanceof PkBaseStateMachine.c.C0130c) == false) goto L6;
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.gift.a.class).v3();
            return;
        L6:
            if ((r2 instanceof PkBaseStateMachine.c.b) == false) goto L10;
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.gift.a.class).Ek();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((PkBaseStateMachine.c) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return "DoublePKComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        LiveData<PkBaseStateMachine.c> r0 = this.c.getPkBaseState();
        AnonymousClass1 r1 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r0, "$this$subscribeWithNotify");
        Intrinsics.checkNotNullParameter(r1, "onChange");
        Disposable r2 = UtilsKt.d(r0, r1);
        r1.invoke(r0.getValue());
        f.a(r2, this.a);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.a.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.b;
    }

    public DoublePKComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, PkBaseDataContext r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pkBaseDataContext");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }
}
