package com.bytedance.android.livesdk.feedback.relax;

import com.relax.relaxframework.AlignItems;
import com.relax.relaxframework.ElementAttribute;
import com.relax.relaxframework.FlexDirection;
import com.relax.relaxframework.JustifyContent;
import com.relax.relaxframework.LinearGravity;
import com.relax.relaxframework.LinearOrientation;
import com.relax.relaxframework.ModifierValue_Overflow;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.f6;
import com.relax.relaxframework.j5;
import com.relax.relaxframework.m5;
import com.relax.relaxframework.p6;
import com.relax.relaxframework.z2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class DiscussFeedbackContainerMainIndexKt$RelaxFeedbackDiscussContainerMain$1$1$1$switch__0$1$match__0$2 extends Lambda implements Function0<ArrayList<j5>> {
    final /* synthetic */ DiscussFeedbackContainerMainIndexKt$RelaxFeedbackDiscussContainerMain$1$1$1$switch__0$1 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.relax.DiscussFeedbackContainerMainIndexKt$RelaxFeedbackDiscussContainerMain$1$1$1$switch__0$1$match__0$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<ArrayList<j5>> {
        final /* synthetic */ DiscussFeedbackContainerMainIndexKt$RelaxFeedbackDiscussContainerMain$1$1$1$switch__0$1$match__0$2 this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.relax.DiscussFeedbackContainerMainIndexKt$RelaxFeedbackDiscussContainerMain$1$1$1$switch__0$1$match__0$2$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
        public static final class AnonymousClass2 extends Lambda implements Function0<ArrayList<j5>> {
            final /* synthetic */ AnonymousClass1 this$0;

            public AnonymousClass2(AnonymousClass1 r1) {
                this.this$0 = r1;
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                return m1316invoke();
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final ArrayList<j5> m1316invoke() {
                ArrayList<j5> r0 = com.bytedance.rts.foundation.j.k(new j5[]{RelaxFrameworkKt.D(this.this$0.this$0.this$0.this$0.this$0.$options, new DiscussFeedbackContainerMainIndexKt$RelaxFeedbackDiscussContainerMain$1$1$1$switch__0$1$match__0$2$1$2$for__0$1(this))});
                if (r0 == null) goto L6;
                return r0;
            L6:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
            }
        }

        public AnonymousClass1(DiscussFeedbackContainerMainIndexKt$RelaxFeedbackDiscussContainerMain$1$1$1$switch__0$1$match__0$2 r1) {
            this.this$0 = r1;
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m1314invoke();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final ArrayList<j5> m1314invoke() {
            Function0 r0 = RelaxFrameworkKt.B;
            m5 r1 = (m5) r0.invoke();
            ElementAttribute r2 = ElementAttribute.FlexDirection;
            r1.k0(r2, FlexDirection.Column.getValue());
            ElementAttribute r3 = ElementAttribute.JustifyContent;
            r1.k0(r3, JustifyContent.Start.getValue());
            ElementAttribute r4 = ElementAttribute.AlignItems;
            r1.k0(r4, AlignItems.Start.getValue());
            int r7 = z2.a;
            r1.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().s0(RelaxFrameworkKt.f0(574))}));
            r1.R(new C03271(this));
            m5 r5 = (m5) r0.invoke();
            r5.k0(r2, FlexDirection.Row.getValue());
            r5.k0(r3, JustifyContent.SpaceBetween.getValue());
            r5.k0(r4, AlignItems.Center.getValue());
            r5.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().s0(RelaxFrameworkKt.f0(640)).P(RelaxFrameworkKt.f0(80)).Y(RelaxFrameworkKt.f0(56)).S(RelaxFrameworkKt.f0(40))}));
            r5.n0(ElementAttribute.AccessibilityElement, false);
            r5.R(new AnonymousClass2(this));
            f6 r6 = (f6) RelaxFrameworkKt.C.invoke();
            r6.k0(ElementAttribute.LinearOrientation, LinearOrientation.Vertical.getValue());
            r6.k0(ElementAttribute.LinearGravity, LinearGravity.Center.getValue());
            r6.g0(new AnonymousClass3(this));
            r6.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().s0(RelaxFrameworkKt.f0(32)).P(RelaxFrameworkKt.f0(32)), z2.a.e().g(RelaxFrameworkKt.i(RelaxFrameworkKt.f0(40), RelaxFrameworkKt.f0(32)))}));
            r6.R(AnonymousClass4.INSTANCE);
            ArrayList<j5> r8 = com.bytedance.rts.foundation.j.k(new Object[]{r1, r5, r6});
            if (r8 == null) goto L6;
            return r8;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
        }
    }

    public DiscussFeedbackContainerMainIndexKt$RelaxFeedbackDiscussContainerMain$1$1$1$switch__0$1$match__0$2(DiscussFeedbackContainerMainIndexKt$RelaxFeedbackDiscussContainerMain$1$1$1$switch__0$1 r1) {
        this.this$0 = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1313invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ArrayList<j5> m1313invoke() {
        m5 r0 = (m5) RelaxFrameworkKt.B.invoke();
        r0.k0(ElementAttribute.FlexDirection, FlexDirection.Column.getValue());
        r0.k0(ElementAttribute.JustifyContent, JustifyContent.Center.getValue());
        r0.k0(ElementAttribute.AlignItems, AlignItems.Start.getValue());
        int r2 = z2.a;
        r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().s0(RelaxFrameworkKt.f0(702)).o0(RelaxFrameworkKt.f0(32)).i0(RelaxFrameworkKt.f0(32)).U(RelaxFrameworkKt.f0(24)).W(RelaxFrameworkKt.f0(24)).k0(RelaxFrameworkKt.f0(32)).m0(RelaxFrameworkKt.f0(32)), z2.a.g().f(2148931619L).A(RelaxFrameworkKt.f0(16)), z2.a.e().m(), z2.a.g().d0(ModifierValue_Overflow.Hidden)}));
        r0.R(new AnonymousClass1(this));
        ArrayList<j5> r1 = com.bytedance.rts.foundation.j.k(new m5[]{r0});
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
    }
}
