package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.rts.util.ComponentsRTSLiveImageKt;
import com.relax.relaxframework.AlignItems;
import com.relax.relaxframework.ElementAttribute;
import com.relax.relaxframework.FlexDirection;
import com.relax.relaxframework.LinearCrossGravity;
import com.relax.relaxframework.LinearGravity;
import com.relax.relaxframework.ModifierValue_Overflow;
import com.relax.relaxframework.ModifierValue_TextOverflow;
import com.relax.relaxframework.ModifierValue_WhiteSpace;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.RxTextImpl;
import com.relax.relaxframework.TapEvent;
import com.relax.relaxframework.f6;
import com.relax.relaxframework.j5;
import com.relax.relaxframework.m5;
import com.relax.relaxframework.p6;
import com.relax.relaxframework.t5;
import com.relax.relaxframework.z2;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0000j\b\u0012\u0004\u0012\u00020\u0004`\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Function0;", "", "Lcom/relax/relaxframework/StateGetter;", "item", "", "index", "Lcom/relax/relaxframework/j5;", "invoke", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageSearchComponentsLiveSearchRecordKt$LiveSearchRecord$1$1$1$1$listItems__0$2 extends Lambda implements Function2<Function0<? extends String>, Function0<? extends Integer>, j5> {
    final /* synthetic */ MainpageSearchComponentsLiveSearchRecordKt$LiveSearchRecord$1.AnonymousClass1.C02651.C02661 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageSearchComponentsLiveSearchRecordKt$LiveSearchRecord$1$1$1$1$listItems__0$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/j5;", "invoke", "()Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<j5> {
        final /* synthetic */ Function0 $index;
        final /* synthetic */ Function0 $item;
        final /* synthetic */ MainpageSearchComponentsLiveSearchRecordKt$LiveSearchRecord$1$1$1$1$listItems__0$2 this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageSearchComponentsLiveSearchRecordKt$LiveSearchRecord$1$1$1$1$listItems__0$2$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
        public static final class C02691 extends Lambda implements Function0<ArrayList<j5>> {
            final /* synthetic */ AnonymousClass1 this$0;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageSearchComponentsLiveSearchRecordKt$LiveSearchRecord$1$1$1$1$listItems__0$2$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
            public static final class C02701 extends Lambda implements Function0<ArrayList<j5>> {
                final /* synthetic */ C02691 this$0;

                /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageSearchComponentsLiveSearchRecordKt$LiveSearchRecord$1$1$1$1$listItems__0$2$1$1$1$2, reason: invalid class name */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "", "e", "Lcom/relax/relaxframework/TapEvent;", "Lcom/relax/relaxframework/CommonEvent_Tap;", "invoke"}, k = 3, mv = {1, 4, 3})
                public static final class AnonymousClass2 extends Lambda implements Function1<TapEvent, Unit> {
                    final /* synthetic */ C02701 this$0;

                    public AnonymousClass2(C02701 r1) {
                        this.this$0 = r1;
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                        invoke((TapEvent) r1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(TapEvent r7) {
                        Intrinsics.checkNotNullParameter(r7, "e");
                        LiveDrawerLog.Companion r8 = LiveDrawerLog.a;
                        Map r0 = com.bytedance.rts.foundation.m.a(com.bytedance.rts.foundation.j.k(new Object[][]{new Object[]{"action_type", "clear"}, new Object[]{"search_keyword", this.this$0.this$0.this$0.$item.invoke()}, new Object[]{"order", Integer.valueOf(((Number) this.this$0.this$0.this$0.$index.invoke()).intValue() + 1)}}));
                        r8.getClass();
                        LiveDrawerLog.Companion.a("search_history", r0, null);
                        p0 r9 = this.this$0.this$0.this$0.this$0.this$0.this$0.this$0.$searchData;
                        if (r9 == null) goto L8;
                        Function1<? super Function1<? super ArrayList<String>, ? extends ArrayList<String>>, Unit> r10 = r9.k;
                        if (r10 == null) goto L9;
                        Unit r11 = (Unit) r10.invoke(new C02721(this));
                        return;
                    L9:
                        return;
                    }
                }

                public C02701(C02691 r1) {
                    this.this$0 = r1;
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    return m1059invoke();
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final ArrayList<j5> m1059invoke() {
                    Function2 r1 = ComponentsRTSLiveImageKt.b;
                    int r2 = w0.a;
                    int r5 = z2.a;
                    j5 r3 = RelaxFrameworkKt.z(r1, new com.bytedance.android.rts.util.b("res:///2131252264", null, com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.b0(24)).O(RelaxFrameworkKt.b0(24)).T(RelaxFrameworkKt.b0(12)), z2.a.d().g()}), null, null, null, null, 2042), null);
                    j5 r4 = (RxTextImpl) RelaxFrameworkKt.T.invoke();
                    r4.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().T(RelaxFrameworkKt.b0(4)).d0(ModifierValue_Overflow.Hidden), z2.a.f().j(RelaxFrameworkKt.b0(15)).e(4294967295L).q(ModifierValue_TextOverflow.Ellipsis).s(ModifierValue_WhiteSpace.Nowrap), z2.a.d().f(1)}));
                    r4.g0(new C02711(this));
                    r4.x0(this.this$0.this$0.$item);
                    j5 r6 = (f6) RelaxFrameworkKt.C.invoke();
                    r6.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.b0(24)).O(RelaxFrameworkKt.b0(24)).V(RelaxFrameworkKt.b0(12)).T(RelaxFrameworkKt.b0(4)), z2.a.d().g()}));
                    r6.k0(ElementAttribute.LinearGravity, LinearGravity.Center.getValue());
                    r6.k0(ElementAttribute.LinearCrossGravity, LinearCrossGravity.Center.getValue());
                    r6.g0(new AnonymousClass2(this));
                    r6.R(AnonymousClass3.INSTANCE);
                    ArrayList<j5> r7 = com.bytedance.rts.foundation.j.k(new j5[]{r3, r4, r6});
                    if (r7 == null) goto L6;
                    return r7;
                L6:
                    throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
                }
            }

            public C02691(AnonymousClass1 r1) {
                this.this$0 = r1;
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                return m1058invoke();
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final ArrayList<j5> m1058invoke() {
                m5 r0 = (m5) RelaxFrameworkKt.B.invoke();
                int r3 = z2.a;
                r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.Z(100)).O(RelaxFrameworkKt.b0(24)).R(RelaxFrameworkKt.b0(25))}));
                r0.k0(ElementAttribute.FlexDirection, FlexDirection.Row.getValue());
                r0.k0(ElementAttribute.AlignItems, AlignItems.Center.getValue());
                r0.R(new C02701(this));
                ArrayList<j5> r1 = com.bytedance.rts.foundation.j.k(new m5[]{r0});
                if (r1 == null) goto L6;
                return r1;
            L6:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
            }
        }

        public AnonymousClass1(MainpageSearchComponentsLiveSearchRecordKt$LiveSearchRecord$1$1$1$1$listItems__0$2 r1, Function0 r2, Function0 r3) {
            this.this$0 = r1;
            this.$item = r2;
            this.$index = r3;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1057invoke() {
            return invoke();
        }

        public final j5 invoke() {
            t5 r0 = (t5) RelaxFrameworkKt.Y.invoke();
            r0.R(new C02691(this));
            return r0;
        }
    }

    public MainpageSearchComponentsLiveSearchRecordKt$LiveSearchRecord$1$1$1$1$listItems__0$2(MainpageSearchComponentsLiveSearchRecordKt$LiveSearchRecord$1.AnonymousClass1.C02651.C02661 r1) {
        this.this$0 = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Function0) r1, (Function0) r2);
    }

    public final j5 invoke(Function0<String> r2, Function0<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "index");
        return (j5) new AnonymousClass1(this, r2, r3).invoke();
    }
}
