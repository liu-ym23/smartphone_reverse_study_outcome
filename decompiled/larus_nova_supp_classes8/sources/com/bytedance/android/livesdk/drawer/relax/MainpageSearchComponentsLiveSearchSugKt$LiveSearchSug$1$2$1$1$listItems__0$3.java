package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.rts.util.ComponentsRTSLiveImageKt;
import com.relax.relaxframework.AlignItems;
import com.relax.relaxframework.ElementAttribute;
import com.relax.relaxframework.FlexDirection;
import com.relax.relaxframework.LinearOrientation;
import com.relax.relaxframework.ModifierValue_BoxSizing;
import com.relax.relaxframework.ModifierValue_Overflow;
import com.relax.relaxframework.ModifierValue_TextOverflow;
import com.relax.relaxframework.ModifierValue_WhiteSpace;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.RxTextImpl;
import com.relax.relaxframework.f6;
import com.relax.relaxframework.j5;
import com.relax.relaxframework.m5;
import com.relax.relaxframework.p6;
import com.relax.relaxframework.z2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0000j\b\u0012\u0004\u0012\u00020\u0004`\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Function0;", "Lvt1/f;", "Lcom/relax/relaxframework/StateGetter;", "item", "", "index", "Lcom/relax/relaxframework/j5;", "invoke", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageSearchComponentsLiveSearchSugKt$LiveSearchSug$1$2$1$1$listItems__0$3 extends Lambda implements Function2<Function0<? extends vt1.f>, Function0<? extends Integer>, j5> {
    final /* synthetic */ MainpageSearchComponentsLiveSearchSugKt$LiveSearchSug$1.AnonymousClass2.AnonymousClass1.C02851 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageSearchComponentsLiveSearchSugKt$LiveSearchSug$1$2$1$1$listItems__0$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/j5;", "invoke", "()Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<j5> {
        final /* synthetic */ Function0 $index;
        final /* synthetic */ Function0 $item;
        final /* synthetic */ MainpageSearchComponentsLiveSearchSugKt$LiveSearchSug$1$2$1$1$listItems__0$3 this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageSearchComponentsLiveSearchSugKt$LiveSearchSug$1$2$1$1$listItems__0$3$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
        public static final class AnonymousClass2 extends Lambda implements Function0<ArrayList<j5>> {
            final /* synthetic */ AnonymousClass1 this$0;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageSearchComponentsLiveSearchSugKt$LiveSearchSug$1$2$1$1$listItems__0$3$1$2$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
            public static final class C02871 extends Lambda implements Function0<ArrayList<j5>> {
                final /* synthetic */ AnonymousClass2 this$0;

                public C02871(AnonymousClass2 r1) {
                    this.this$0 = r1;
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    return m1145invoke();
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final ArrayList<j5> m1145invoke() {
                    Function2 r0 = ComponentsRTSLiveImageKt.b;
                    int r2 = z2.a;
                    ArrayList r4 = com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.b0(16)).O(RelaxFrameworkKt.b0(16)).T(RelaxFrameworkKt.b0(18)), z2.a.d().g()});
                    int r1 = w0.a;
                    j5 r3 = RelaxFrameworkKt.z(r0, new com.bytedance.android.rts.util.b("res:///2131252269", null, r4, null, null, null, null, 2042), null);
                    j5 r5 = (RxTextImpl) RelaxFrameworkKt.T.invoke();
                    r5.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().T(RelaxFrameworkKt.b0(14)).d0(ModifierValue_Overflow.Hidden), z2.a.f().j(RelaxFrameworkKt.b0(17)).e(4294967295L).q(ModifierValue_TextOverflow.Ellipsis).s(ModifierValue_WhiteSpace.Nowrap), z2.a.d().f(1)}));
                    r5.R(new C02881(this));
                    ArrayList<j5> r6 = com.bytedance.rts.foundation.j.k(new j5[]{r3, r5, RelaxFrameworkKt.z(r0, new com.bytedance.android.rts.util.b("res:///2131252268", null, com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.b0(16)).O(RelaxFrameworkKt.b0(16)).V(RelaxFrameworkKt.b0(18)).T(RelaxFrameworkKt.b0(4)), z2.a.d().g()}), null, null, null, null, 2042), null)});
                    if (r6 == null) goto L6;
                    return r6;
                L6:
                    throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
                }
            }

            public AnonymousClass2(AnonymousClass1 r1) {
                this.this$0 = r1;
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                return m1144invoke();
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final ArrayList<j5> m1144invoke() {
                m5 r0 = (m5) RelaxFrameworkKt.B.invoke();
                int r3 = z2.a;
                r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.Z(100)).O(RelaxFrameworkKt.b0(24)).R(RelaxFrameworkKt.b0(10)).X(RelaxFrameworkKt.b0(10))}));
                r0.k0(ElementAttribute.FlexDirection, FlexDirection.Row.getValue());
                r0.k0(ElementAttribute.AlignItems, AlignItems.Center.getValue());
                r0.R(new C02871(this));
                f6 r2 = (f6) RelaxFrameworkKt.C.invoke();
                r2.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.Z(100)).O(RelaxFrameworkKt.a0(0.5d)).j0(RelaxFrameworkKt.b0(18)).l0(RelaxFrameworkKt.b0(5)).f(352321535).N(ModifierValue_BoxSizing.ContentBox)}));
                ArrayList<j5> r1 = com.bytedance.rts.foundation.j.k(new Object[]{r0, r2});
                if (r1 == null) goto L6;
                return r1;
            L6:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
            }
        }

        public AnonymousClass1(MainpageSearchComponentsLiveSearchSugKt$LiveSearchSug$1$2$1$1$listItems__0$3 r1, Function0 r2, Function0 r3) {
            this.this$0 = r1;
            this.$index = r2;
            this.$item = r3;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1143invoke() {
            return invoke();
        }

        public final j5 invoke() {
            f6 r0 = (f6) RelaxFrameworkKt.C.invoke();
            int r2 = z2.a;
            r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.Z(100))}));
            r0.k0(ElementAttribute.LinearOrientation, LinearOrientation.Vertical.getValue());
            r0.g0(new C02861(this));
            r0.R(new AnonymousClass2(this));
            return r0;
        }
    }

    public MainpageSearchComponentsLiveSearchSugKt$LiveSearchSug$1$2$1$1$listItems__0$3(MainpageSearchComponentsLiveSearchSugKt$LiveSearchSug$1.AnonymousClass2.AnonymousClass1.C02851 r1) {
        this.this$0 = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Function0) r1, (Function0) r2);
    }

    public final j5 invoke(Function0<vt1.f> r2, Function0<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "index");
        return (j5) new AnonymousClass1(this, r3, r2).invoke();
    }
}
