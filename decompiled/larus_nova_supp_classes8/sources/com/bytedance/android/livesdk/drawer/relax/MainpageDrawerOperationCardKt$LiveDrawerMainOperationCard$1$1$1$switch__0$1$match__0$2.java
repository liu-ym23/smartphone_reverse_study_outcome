package com.bytedance.android.livesdk.drawer.relax;

import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.f6;
import com.relax.relaxframework.j5;
import com.relax.relaxframework.p6;
import com.relax.relaxframework.z2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1$match__0$2 extends Lambda implements Function0<ArrayList<j5>> {
    final /* synthetic */ MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1 this$0;

    public MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1$match__0$2(MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1 r1) {
        this.this$0 = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m732invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ArrayList<j5> m732invoke() {
        f6 r0 = (f6) RelaxFrameworkKt.C.invoke();
        int r3 = z2.a;
        r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.Z(100)).O(RelaxFrameworkKt.Z(100)).z(RelaxFrameworkKt.b0(2)).f(4279638051L), z2.a.e().m()}));
        r0.g0(new AnonymousClass1(this));
        r0.R(new AnonymousClass2(this));
        ArrayList<j5> r1 = com.bytedance.rts.foundation.j.k(new f6[]{r0});
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
    }
}
