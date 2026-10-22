package com.bytedance.android.livesdk.drawer.relax;

import com.relax.relaxframework.ElementAttribute;
import com.relax.relaxframework.LinearCrossGravity;
import com.relax.relaxframework.LinearGravity;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.e6;
import com.relax.relaxframework.f6;
import com.relax.relaxframework.j5;
import com.relax.relaxframework.p6;
import com.relax.relaxframework.z2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0000j\b\u0012\u0004\u0012\u00020\u0004`\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Function0;", "Lcom/bytedance/android/livesdk/drawer/relax/l0;", "Lcom/relax/relaxframework/StateGetter;", "item", "", "index", "Lcom/relax/relaxframework/j5;", "invoke", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageDrawerTabKt$LiveDrawerMainTab$1$2$2$3$for__0$2 extends Lambda implements Function2<Function0<? extends l0>, Function0<? extends Integer>, j5> {
    final /* synthetic */ MainpageDrawerTabKt$LiveDrawerMainTab$1.AnonymousClass2.C02202.AnonymousClass3 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageDrawerTabKt$LiveDrawerMainTab$1$2$2$3$for__0$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/j5;", "invoke", "()Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<j5> {
        final /* synthetic */ Function0 $index;
        final /* synthetic */ Function0 $item;
        final /* synthetic */ MainpageDrawerTabKt$LiveDrawerMainTab$1$2$2$3$for__0$2 this$0;

        public AnonymousClass1(MainpageDrawerTabKt$LiveDrawerMainTab$1$2$2$3$for__0$2 r1, Function0 r2, Function0 r3) {
            this.this$0 = r1;
            this.$index = r2;
            this.$item = r3;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m928invoke() {
            return invoke();
        }

        public final j5 invoke() {
            f6 r0 = (f6) RelaxFrameworkKt.C.invoke();
            Function1<e6, Unit> r1 = new C02221(this);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "refFn");
            r0.T(r0, r1);
            r0.k0(ElementAttribute.LinearGravity, LinearGravity.Center.getValue());
            r0.k0(ElementAttribute.LinearCrossGravity, LinearCrossGravity.Center.getValue());
            int r2 = z2.a;
            r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().O(RelaxFrameworkKt.Z(100)).V(RelaxFrameworkKt.b0(20)), z2.a.b(new AnonymousClass2(this)), z2.a.b(new AnonymousClass3(this))}));
            r0.g0(new AnonymousClass4(this));
            r0.R(new AnonymousClass5(this));
            return r0;
        }
    }

    public MainpageDrawerTabKt$LiveDrawerMainTab$1$2$2$3$for__0$2(MainpageDrawerTabKt$LiveDrawerMainTab$1.AnonymousClass2.C02202.AnonymousClass3 r1) {
        this.this$0 = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Function0) r1, (Function0) r2);
    }

    public final j5 invoke(Function0<? extends l0> r2, Function0<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "index");
        return (j5) new AnonymousClass1(this, r3, r2).invoke();
    }
}
