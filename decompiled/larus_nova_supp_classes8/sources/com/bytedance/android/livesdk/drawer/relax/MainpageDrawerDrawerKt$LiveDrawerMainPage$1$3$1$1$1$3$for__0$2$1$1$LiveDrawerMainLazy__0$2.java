package com.bytedance.android.livesdk.drawer.relax;

import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.j5;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageDrawerDrawerKt$LiveDrawerMainPage$1$3$1$1$1$3$for__0$2$1$1$LiveDrawerMainLazy__0$2 extends Lambda implements Function0<ArrayList<j5>> {
    final /* synthetic */ MainpageDrawerDrawerKt$LiveDrawerMainPage$1$3$1$1$1$3$for__0$2.AnonymousClass1.C01411 this$0;

    public MainpageDrawerDrawerKt$LiveDrawerMainPage$1$3$1$1$1$3$for__0$2$1$1$LiveDrawerMainLazy__0$2(MainpageDrawerDrawerKt$LiveDrawerMainPage$1$3$1$1$1$3$for__0$2.AnonymousClass1.C01411 r1) {
        this.this$0 = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m586invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ArrayList<j5> m586invoke() {
        Function2<f0, Function0<? extends ArrayList<j5>>, j5> r0 = MainpageDrawerRefreshViewKt.a;
        l0 r3 = this.this$0.this$0.$item;
        Long r2 = r3.a;
        Function0 r5 = RelaxFrameworkKt.y(new MainpageDrawerDrawerKt$LiveDrawerMainPage$1$3$1$1$1$3$for__0$2$1$1$LiveDrawerMainLazy__0$2$LiveDrawerMainRefreshView__0$1(this));
        MainpageDrawerDrawerKt$LiveDrawerMainPage$1.AnonymousClass3 r1 = this.this$0.this$0.this$0.this$0.this$0.this$0.this$0.this$0;
        ArrayList<j5> r4 = com.bytedance.rts.foundation.j.k(new j5[]{RelaxFrameworkKt.z(r0, new f0(r2, r3, r1.$recommendTab, r5, r1.$setShowOpenLiveComp, r1.$selectedIndex), null)});
        if (r4 == null) goto L6;
        return r4;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
    }
}
