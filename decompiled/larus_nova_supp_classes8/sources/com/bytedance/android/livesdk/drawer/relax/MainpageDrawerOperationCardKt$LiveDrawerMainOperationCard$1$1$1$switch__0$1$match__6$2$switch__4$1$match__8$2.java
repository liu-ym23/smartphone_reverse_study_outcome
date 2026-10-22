package com.bytedance.android.livesdk.drawer.relax;

import com.relax.relaxframework.ElementAttribute;
import com.relax.relaxframework.ImageMode;
import com.relax.relaxframework.LinearCrossGravity;
import com.relax.relaxframework.LinearOrientation;
import com.relax.relaxframework.ModifierValuePattern;
import com.relax.relaxframework.ModifierValue_FontWeight;
import com.relax.relaxframework.ModifierValue_Overflow;
import com.relax.relaxframework.ModifierValue_TextOverflow;
import com.relax.relaxframework.ModifierValue_WhiteSpace;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.RxTextImpl;
import com.relax.relaxframework.d3;
import com.relax.relaxframework.f6;
import com.relax.relaxframework.j5;
import com.relax.relaxframework.p6;
import com.relax.relaxframework.v5;
import com.relax.relaxframework.z2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1$match__6$2$switch__4$1$match__8$2 extends Lambda implements Function0<ArrayList<j5>> {
    final /* synthetic */ MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1$match__6$2$switch__4$1 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1$match__6$2$switch__4$1$match__8$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function0<ArrayList<j5>> {
        final /* synthetic */ MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1$match__6$2$switch__4$1$match__8$2 this$0;

        public AnonymousClass2(MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1$match__6$2$switch__4$1$match__8$2 r1) {
            this.this$0 = r1;
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m765invoke();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final ArrayList<j5> m765invoke() {
            v5 r0 = (v5) RelaxFrameworkKt.P.invoke();
            r0.q0(ElementAttribute.Src, new AnonymousClass1(this));
            r0.m0(ElementAttribute.Mode, ImageMode.AspectFill.getValue());
            int r3 = z2.a;
            r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.Z(100)).O(RelaxFrameworkKt.Z(100)).z(RelaxFrameworkKt.b0(2)), z2.a.e().e()}));
            Function0 r2 = RelaxFrameworkKt.C;
            f6 r4 = (f6) r2.invoke();
            com.relax.relaxframework.d0 r5 = z2.a.g().r0(RelaxFrameworkKt.Z(100)).O(RelaxFrameworkKt.Z(100)).z(RelaxFrameworkKt.b0(2));
            com.relax.relaxframework.v r8 = RelaxFrameworkKt.c();
            int r9 = com.bytedance.rts.foundation.d.a;
            r8.b = 180;
            r8.b(0, 0.2711d);
            r8.c(3003121664L, 1);
            r4.r0(com.bytedance.rts.foundation.j.k(new p6[]{r5.h(r8), z2.a.e().e()}));
            RxTextImpl r6 = (RxTextImpl) RelaxFrameworkKt.T.invoke();
            com.relax.relaxframework.y r11 = z2.a.f().j(RelaxFrameworkKt.b0(14)).m(ModifierValue_FontWeight.k500).e(4294967295L).q(ModifierValue_TextOverflow.Ellipsis).s(ModifierValue_WhiteSpace.Nowrap);
            com.relax.relaxframework.z r12 = RelaxFrameworkKt.j0();
            r12.d(new com.relax.relaxframework.s0.c(0), new com.relax.relaxframework.s0.c(0));
            d3 r10 = RelaxFrameworkKt.b0(2);
            Intrinsics.checkNotNullParameter(r10, "value");
            r12.c = r10.a;
            ModifierValuePattern r13 = r10.b;
            Intrinsics.checkNotNullParameter(r13, "<set-?>");
            r12.d = r13;
            r12.c(new com.relax.relaxframework.s0.c(2147483648L));
            r6.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.b0(127)).d0(ModifierValue_Overflow.Hidden), r11.r(r12), z2.a.e().f(RelaxFrameworkKt.e(RelaxFrameworkKt.b0(58), RelaxFrameworkKt.b0(10)))}));
            r6.x0(new C01902(this));
            f6 r7 = (f6) r2.invoke();
            r7.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.e().f(RelaxFrameworkKt.e(RelaxFrameworkKt.b0(8), RelaxFrameworkKt.b0(10)))}));
            r7.k0(ElementAttribute.LinearCrossGravity, LinearCrossGravity.Center.getValue());
            r7.k0(ElementAttribute.LinearOrientation, LinearOrientation.Horizontal.getValue());
            r7.R(new AnonymousClass3(this));
            ArrayList<j5> r1 = com.bytedance.rts.foundation.j.k(new Object[]{r0, r4, r6, r7});
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
        }
    }

    public MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1$match__6$2$switch__4$1$match__8$2(MainpageDrawerOperationCardKt$LiveDrawerMainOperationCard$1$1$1$switch__0$1$match__6$2$switch__4$1 r1) {
        this.this$0 = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m764invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ArrayList<j5> m764invoke() {
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
