package com.bytedance.android.livesdk.drawer.relax;

import com.relax.relaxframework.ElementAttribute;
import com.relax.relaxframework.LinearOrientation;
import com.relax.relaxframework.PositionOffset_Type___;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.d3;
import com.relax.relaxframework.f6;
import com.relax.relaxframework.j5;
import com.relax.relaxframework.p3;
import com.relax.relaxframework.p6;
import com.relax.relaxframework.z2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2 extends Lambda implements Function0<ArrayList<j5>> {
    final /* synthetic */ MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<ArrayList<j5>> {
        final /* synthetic */ MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2 this$0;

        public AnonymousClass1(MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2 r1) {
            this.this$0 = r1;
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m723invoke();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final ArrayList<j5> m723invoke() {
            ArrayList<j5> r0 = com.bytedance.rts.foundation.j.k(new j5[]{RelaxFrameworkKt.D(new MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2$1$for__1$1(this), new MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2$1$for__1$2(this))});
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
        }
    }

    public MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2(MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1 r1) {
        this.this$0 = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m722invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ArrayList<j5> m722invoke() {
        f6 r0 = (f6) RelaxFrameworkKt.C.invoke();
        int r3 = z2.a;
        com.relax.relaxframework.w r4 = z2.a.e();
        d3 r5 = RelaxFrameworkKt.b0(12);
        d3 r6 = RelaxFrameworkKt.b0(12);
        Intrinsics.checkNotNullParameter(r5, "bottom");
        Intrinsics.checkNotNullParameter(r6, "right");
        r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{r4.f(new p3(PositionOffset_Type___.BottomRight, r5, r6))}));
        r0.k0(ElementAttribute.LinearOrientation, LinearOrientation.Horizontal.getValue());
        r0.R(new AnonymousClass1(this));
        ArrayList<j5> r1 = com.bytedance.rts.foundation.j.k(new f6[]{r0});
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
    }
}
