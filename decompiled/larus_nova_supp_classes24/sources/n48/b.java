package n48;

import com.larus.api.serviceimpl.AoEcomServiceImpl;
import com.larus.e_commerce.api.IECommerceService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ IECommerceService c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ Function0 e;

    public /* synthetic */ b(AtomicBoolean r1, a r2, IECommerceService r3, Ref.ObjectRef r4, Function0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke() {
        AtomicBoolean r0 = this.a;
        Function0 r1 = this.b;
        IECommerceService r2 = this.c;
        Ref.ObjectRef r3 = this.d;
        Function0 r4 = this.e;
        int r5 = AoEcomServiceImpl.a;
        if (r0.compareAndSet(false, true) == false) goto L10;
        r1.invoke();
        Object r6 = r3.element;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("listener");
        com.larus.e_commerce.api.d r7 = null;
    L8:
        r2.o(r7);
        r4.invoke();
        goto L10
    L7:
        r7 = (com.larus.e_commerce.api.d) r6;
    L10:
        return Unit.INSTANCE;
    }
}
