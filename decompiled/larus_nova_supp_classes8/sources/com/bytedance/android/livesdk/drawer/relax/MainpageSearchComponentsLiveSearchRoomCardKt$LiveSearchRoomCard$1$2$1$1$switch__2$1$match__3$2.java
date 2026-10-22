package com.bytedance.android.livesdk.drawer.relax;

import com.relax.relaxframework.ElementAttribute;
import com.relax.relaxframework.LinearCrossGravity;
import com.relax.relaxframework.LinearOrientation;
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
public final class MainpageSearchComponentsLiveSearchRoomCardKt$LiveSearchRoomCard$1$2$1$1$switch__2$1$match__3$2 extends Lambda implements Function0<ArrayList<j5>> {
    final /* synthetic */ MainpageSearchComponentsLiveSearchRoomCardKt$LiveSearchRoomCard$1$2$1$1$switch__2$1 this$0;

    public MainpageSearchComponentsLiveSearchRoomCardKt$LiveSearchRoomCard$1$2$1$1$switch__2$1$match__3$2(MainpageSearchComponentsLiveSearchRoomCardKt$LiveSearchRoomCard$1$2$1$1$switch__2$1 r1) {
        this.this$0 = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1115invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ArrayList<j5> m1115invoke() {
        f6 r0 = (f6) RelaxFrameworkKt.C.invoke();
        int r2 = z2.a;
        r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().V(RelaxFrameworkKt.b0(8)).T(RelaxFrameworkKt.b0(4)), z2.a.d().g()}));
        r0.k0(ElementAttribute.LinearOrientation, LinearOrientation.Horizontal.getValue());
        r0.k0(ElementAttribute.LinearCrossGravity, LinearCrossGravity.Center.getValue());
        r0.R(new AnonymousClass1(this));
        ArrayList<j5> r1 = com.bytedance.rts.foundation.j.k(new f6[]{r0});
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
    }
}
