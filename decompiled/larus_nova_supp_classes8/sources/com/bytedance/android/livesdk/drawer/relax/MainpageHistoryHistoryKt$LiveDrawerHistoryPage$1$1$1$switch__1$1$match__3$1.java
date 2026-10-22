package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.rts.util.ComponentsRTSLiveImageKt;
import com.relax.relaxframework.AlignItems;
import com.relax.relaxframework.ElementAttribute;
import com.relax.relaxframework.JustifyContent;
import com.relax.relaxframework.ModifierValue_BackgroundClip;
import com.relax.relaxframework.ModifierValue_BackgroundSize;
import com.relax.relaxframework.ModifierValue_BorderStyle;
import com.relax.relaxframework.ModifierValue_BoxSizing;
import com.relax.relaxframework.ModifierValue_FontWeight;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.RxTextImpl;
import com.relax.relaxframework.j5;
import com.relax.relaxframework.m5;
import com.relax.relaxframework.p6;
import com.relax.relaxframework.z2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$1$1$switch__1$1$match__3$1 extends Lambda implements Function0<ArrayList<j5>> {
    final /* synthetic */ MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$1$1$switch__1$1 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$1$1$switch__1$1$match__3$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<ArrayList<j5>> {
        final /* synthetic */ MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$1$1$switch__1$1$match__3$1 this$0;

        public AnonymousClass1(MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$1$1$switch__1$1$match__3$1 r1) {
            this.this$0 = r1;
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m965invoke();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final ArrayList<j5> m965invoke() {
            Function2 r1 = ComponentsRTSLiveImageKt.b;
            Function0<String> r4 = new MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$1$1$switch__1$1$match__3$1$1$RTSLiveImage__0$1(this);
            int r5 = z2.a;
            j5 r2 = RelaxFrameworkKt.z(r1, new com.bytedance.android.rts.util.b("", r4, com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.b0(20)).O(RelaxFrameworkKt.b0(20)).j(RelaxFrameworkKt.b0(8), ModifierValue_BorderStyle.Solid, 0), z2.a.g().N(ModifierValue_BoxSizing.ContentBox), z2.a.g().i(RelaxFrameworkKt.p(ModifierValue_BackgroundSize.Cover)), z2.a.g().e(ModifierValue_BackgroundClip.PaddingBox)}), null, new MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$1$1$switch__1$1$match__3$1$1$RTSLiveImage__0$2(this), null, null, 2024), null);
            j5 r3 = (RxTextImpl) RelaxFrameworkKt.T.invoke();
            r3.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.f().m(ModifierValue_FontWeight.k500).j(RelaxFrameworkKt.b0(13)).e(4294967295L).n(RelaxFrameworkKt.b0(18))}));
            r3.R(C02291.INSTANCE);
            j5 r6 = (m5) RelaxFrameworkKt.B.invoke();
            r6.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.e().f(RelaxFrameworkKt.h(RelaxFrameworkKt.b0(9), RelaxFrameworkKt.b0(14))), z2.a.g().r0(RelaxFrameworkKt.b0(86)).O(RelaxFrameworkKt.b0(36)).z(RelaxFrameworkKt.b0(4)), z2.a.g().f(4294847573L), z2.a.b(new AnonymousClass2(this))}));
            r6.k0(ElementAttribute.JustifyContent, JustifyContent.Center.getValue());
            r6.k0(ElementAttribute.AlignItems, AlignItems.Center.getValue());
            r6.g0(new AnonymousClass3(this));
            r6.R(new AnonymousClass4(this));
            ArrayList<j5> r7 = com.bytedance.rts.foundation.j.k(new j5[]{r2, r3, r6});
            if (r7 == null) goto L6;
            return r7;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
        }
    }

    public MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$1$1$switch__1$1$match__3$1(MainpageHistoryHistoryKt$LiveDrawerHistoryPage$1$1$1$switch__1$1 r1) {
        this.this$0 = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m964invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ArrayList<j5> m964invoke() {
        m5 r0 = (m5) RelaxFrameworkKt.B.invoke();
        r0.k0(ElementAttribute.AlignItems, AlignItems.Center.getValue());
        int r2 = z2.a;
        r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.e().f(RelaxFrameworkKt.e(RelaxFrameworkKt.b0(0), RelaxFrameworkKt.b0(0))), z2.a.g().r0(RelaxFrameworkKt.Z(100)).O(RelaxFrameworkKt.b0(56)).h0(RelaxFrameworkKt.b0(34)), z2.a.g().f(4279374354L), z2.a.g().N(ModifierValue_BoxSizing.ContentBox)}));
        r0.R(new AnonymousClass1(this));
        ArrayList<j5> r1 = com.bytedance.rts.foundation.j.k(new m5[]{r0});
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
    }
}
