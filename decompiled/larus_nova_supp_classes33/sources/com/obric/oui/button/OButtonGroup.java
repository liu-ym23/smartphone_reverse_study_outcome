package com.obric.oui.button;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.common.style.q;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0006%&'()*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u001f\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u001e\u001a\u00020\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u000f\u0010#\u001a\u00020\u0002H\u0000¢\u0006\u0004\b!\u0010\"J\b\u0010$\u001a\u00020\u0002H\u0014¨\u0006+"}, d2 = {"Lcom/obric/oui/button/OButtonGroup;", "Lcom/obric/oui/button/OShadowFrame;", "", "alpha", "", "setGroupAlpha", "", "Landroid/view/View;", "children", "settleChildrenVisualState", "scale", "setGroupScaleForAnimation", "radius", "setGroupBlur", "setGroupBlurForAnimation", "Lkotlin/Function0;", "listener", "setGroupAlphaAnimationUpdateListener$OUI_standardRelease", "(Lkotlin/jvm/functions/Function0;)V", "setGroupAlphaAnimationUpdateListener", "setAnimationUpdateListener$OUI_standardRelease", "setAnimationUpdateListener", "", "minWidth", "setWidthMin", "", "blocked", "setTouchEventBlocked$OUI_standardRelease", "(Z)V", "setTouchEventBlocked", "getItemCount", "enabled", "setEnabled", "getRawGroupAlphaForTitleBarTransition$OUI_standardRelease", "()F", "getRawGroupAlphaForTitleBarTransition", "getCurrentPressScaleForAnimation", "a", "b", "c", "ContentAnimationState", "GroupAnimationState", "d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OButtonGroup extends OShadowFrame {
    public static final /* synthetic */ int k0 = 0;
    public LinearLayout D;
    public final int E;
    public final int F;
    public final int G;
    public View H;
    public boolean I;
    public final List<fja.d> J;
    public final List<fja.d> K;
    public ContentAnimationState L;
    public float M;
    public List<? extends Object> N;
    public Function0<Unit> O;
    public Function0<Unit> P;
    public final List<Function0<Unit>> Q;
    public final List<Function0<Unit>> R;
    public float S;
    public float T;
    public float U;
    public boolean V;
    public GroupAnimationState W;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$ContentAnimationState;", "", "IDLE", "OUT", "IN", "SETTLING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum ContentAnimationState extends Enum<ContentAnimationState> {
        public static final ContentAnimationState IDLE = null;
        public static final ContentAnimationState IN = null;
        public static final ContentAnimationState OUT = null;
        public static final ContentAnimationState SETTLING = null;
        public static final /* synthetic */ ContentAnimationState[] a = null;

        public static ContentAnimationState valueOf(String r1) {
            return (ContentAnimationState) r27.a.a(ContentAnimationState.class, r1);
        }

        public static ContentAnimationState[] values() {
            return (ContentAnimationState[]) a.clone();
        }

        static {
            ContentAnimationState r0 = new ContentAnimationState("IDLE", 0);
            IDLE = r0;
            ContentAnimationState r1 = new ContentAnimationState("OUT", 1);
            OUT = r1;
            ContentAnimationState r3 = new ContentAnimationState("IN", 2);
            IN = r3;
            ContentAnimationState r5 = new ContentAnimationState("SETTLING", 3);
            SETTLING = r5;
            a = new ContentAnimationState[]{r0, r1, r3, r5};
        }

        public ContentAnimationState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$GroupAnimationState;", "", "IDLE", "APPEARING", "DISAPPEARING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum GroupAnimationState extends Enum<GroupAnimationState> {
        public static final GroupAnimationState APPEARING = null;
        public static final GroupAnimationState DISAPPEARING = null;
        public static final GroupAnimationState IDLE = null;
        public static final /* synthetic */ GroupAnimationState[] a = null;

        public static GroupAnimationState valueOf(String r1) {
            return (GroupAnimationState) r27.a.a(GroupAnimationState.class, r1);
        }

        public static GroupAnimationState[] values() {
            return (GroupAnimationState[]) a.clone();
        }

        static {
            GroupAnimationState r0 = new GroupAnimationState("IDLE", 0);
            IDLE = r0;
            GroupAnimationState r1 = new GroupAnimationState("APPEARING", 1);
            APPEARING = r1;
            GroupAnimationState r3 = new GroupAnimationState("DISAPPEARING", 2);
            DISAPPEARING = r3;
            a = new GroupAnimationState[]{r0, r1, r3};
        }

        public GroupAnimationState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final Function0<Unit> a;
        public final List<Function1<Function0<Unit>, Unit>> b;
        public int c;
        public boolean d;
        public boolean e;

        public a(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "onFinished");
            this.a = r2;
            this.b = new ArrayList();
        }

        public final void a(Function1<? super Function0<Unit>, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "starter");
            ((ArrayList) this.b).add(r2);
        }
    }

    public static final class b {
        public final int a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final int f;
        public final List<d> g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.b), Float.valueOf(r6.b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.d), Float.valueOf(r6.d)) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r6.e)) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.a * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f) * 31) + this.g.hashCode();
        }

        public final String toString() {
            return "AnimationState(visibility=" + this.a + ", alpha=" + this.b + ", scaleX=" + this.c + ", scaleY=" + this.d + ", groupBlur=" + this.e + ", groupWidth=" + this.f + ", items=" + this.g + ')';
        }

        public b(int r2, float r3, float r4, float r5, float r6, int r7, List<d> r8) {
            Intrinsics.checkNotNullParameter(r8, "items");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public static final class c {

        public static final class a {
            public static final b a = null;
            public static final b b = null;
            public static final b c = null;
            public static final b d = null;
            public static final b e = null;
            public static final b f = null;
            public static final b g = null;
            public static final b h = null;
            public static final b i = null;
            public static final b j = null;
            public static final b k = null;
            public static final b l = null;
            public static final b m = null;
            public static final b n = null;
            public static final b o = null;
            public static final b p = null;
            public static final b q = null;
            public static final b r = null;
            public static final b s = null;
            public static final b t = null;
            public static final b u = null;
            public static final b v = null;
            public static final b w = null;
            public static final b x = null;
            public static final b y = null;
            public static final b z = null;

            static {
                Token$Bounce r1 = Token$Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4;
                Token$Duration r2 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2;
                a = new b(r1, r2);
                Token$Duration r3 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
                b = new b(r1, r3);
                Token$Bounce r4 = Token$Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_1;
                c = new b(r4, r2);
                d = new b(r4, r3);
                Token$Bounce r5 = Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH;
                e = new b(r5, r2);
                f = new b(r5, r3);
                Token$Duration r6 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_1;
                g = new b(r1, r6);
                Token$Duration r7 = Token$Duration.OUI_ANIMATION_DURATION_SHORT_2;
                h = new b(r5, r7);
                i = new b(r5, r2);
                j = new b(r5, r3);
                k = new b(r4, r2);
                l = new b(r4, r3);
                m = new b(r5, r2);
                n = new b(r5, r3);
                o = new b(r5, r2);
                p = new b(r5, r2);
                q = new b(r5, r7);
                r = new b(r1, r2);
                Token$Bounce r8 = Token$Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_2;
                s = new b(r8, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_4);
                t = new b(r8, Token$Duration.OUI_ANIMATION_DURATION_LONG_1);
                u = new b(r5, r7);
                v = new b(r5, r7);
                w = new b(r5, r7);
                x = new b(r5, r2);
                y = new b(r1, r6);
                z = new b(r5, r2);
            }
        }

        public static final class b {
            public final Token$Bounce a;
            public final Token$Duration b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "SpringTokenConfig(bounce=" + this.a + ", duration=" + this.b + ')';
            }

            public final com.obric.common.oea.foundation.animation.spec.spring.b a() {
                return gja.b.a(this.a, this.b, Token$Delay.OUI_ANIMATION_DELAY_NONE);
            }

            public b(Token$Bounce r2, Token$Duration r3) {
                Intrinsics.checkNotNullParameter(r2, "bounce");
                Intrinsics.checkNotNullParameter(r3, "duration");
                this.a = r2;
                this.b = r3;
            }
        }
    }

    public static final class d {
        public final Object a;
        public final int b;
        public final float c;
        public final float d;
        public final float e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.d), Float.valueOf(r6.d)) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r6.e)) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Object r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((((r1 * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "ItemAnimationState(key=" + this.a + ", visibility=" + this.b + ", alpha=" + this.c + ", scaleX=" + this.d + ", scaleY=" + this.e + ')';
        }

        public d(Object r1, int r2, float r3, float r4, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
    }

    public OButtonGroup(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public OButtonGroup(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public OButtonGroup(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public final void I() {
        Iterator r0 = ((ArrayList) this.K).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        fja.d r1 = (fja.d) r0.next();
        int r2 = fja.d.d;
        r1.a(false);
        goto L4
    L6:
        ((ArrayList) this.K).clear();
        this.L = ContentAnimationState.IDLE;
    }

    public final void J() {
        Iterator r0 = ((ArrayList) this.J).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        fja.d r1 = (fja.d) r0.next();
        int r2 = fja.d.d;
        r1.a(false);
        goto L4
    L6:
        ((ArrayList) this.J).clear();
        this.W = GroupAnimationState.IDLE;
    }

    public final List<View> N() {
        LinearLayout r0 = this.D;
        if (r0 == null) goto L5;
        ArrayList r1 = new ArrayList(r0.getChildCount());
        int r2 = r0.getChildCount();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        int r4 = r3 + 1;
        r1.add(r0.getChildAt(r3));
        r3 = r4;
        goto L7
    L9:
        return r1;
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean Q() {
        if (this.W == GroupAnimationState.IDLE) goto L5;
    L8:
        return true;
    L5:
        if (this.L != ContentAnimationState.IDLE) goto L8;
        return false;
    }

    public final void X() {
        F(1.0f, 1.0f, 0.0f);
        P(-2);
        LinearLayout r1 = this.D;
        if (r1 == null) goto L12;
        int r2 = r1.getChildCount();
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L16;
        int r5 = r4 + 1;
        View r6 = r1.getChildAt(r4);
        if (r6.isEnabled() == false) goto L10;
        r6.setAlpha(1.0f);
    L11:
        r6.setScaleX(1.0f);
        r6.setScaleY(1.0f);
        r4 = r5;
        goto L6
    L10:
        r6.setEnabled(false);
        goto L11
    L16:
        return;
    }

    public final void Z() {
        KeyEvent.Callback r0 = this.H;
        if (r0 != null) goto L5;
    L13:
        this.H = null;
        this.I = false;
        return;
    L5:
        if (this.I == false) goto L13;
        if ((r0 instanceof com.obric.oui.common.style.a) == false) goto L9;
        com.obric.oui.common.style.a r1 = (com.obric.oui.common.style.a) r0;
    L10:
        if (r1 == null) goto L13;
        r1.setChangeAlphaWhenPress(true);
        goto L13
    L9:
        r1 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b a0() {
        LinearLayout r0 = this.D;
        ArrayList r8 = new ArrayList();
        if (r0 == null) goto L7;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        int r3 = r2 + 1;
        View r4 = r0.getChildAt(r2);
        r8.add(new d(r4.getTag(), r4.getVisibility(), r4.getAlpha(), r4.getScaleX(), r4.getScaleY()));
        r2 = r3;
    L7:
        int r5 = getVisibility();
        float r6 = getContentView().getAlpha();
        float r7 = this.T;
        float r9 = this.M;
        ViewGroup.LayoutParams r10 = getLayoutParams();
        if (r10 != null) goto L10;
        int r11 = -2;
    L12:
        return new b(r5, r6, r7, r7, r9, r11, r8);
    L10:
        r11 = r10.width;
        goto L12
    }

    public final int getItemCount() {
        LinearLayout r0 = this.D;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getChildCount();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i0() {
        LinearLayout r0 = this.D;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (r0.getChildCount() != 1) goto L24;
        View r1 = r0.getChildAt(0);
        if (this.H == r1) goto L11;
        Z();
        this.H = r1;
    L11:
        if ((r1 instanceof com.obric.oui.common.style.a) == false) goto L13;
        com.obric.oui.common.style.a r3 = (com.obric.oui.common.style.a) r1;
    L14:
        if (r3 == null) goto L17;
        r3.setChangeAlphaWhenPress(false);
        this.I = true;
    L17:
        OUIFrameLayout r4 = getContentView();
        if (isEnabled() == true) goto L20;
    L22:
        r2 = false;
    L23:
        r4.setChangeAlphaWhenPress(r2);
        return;
    L20:
        if (r1.isEnabled() == false) goto L22;
    L13:
        r3 = null;
        goto L14
    L24:
        getContentView().setChangeAlphaWhenPress(false);
        Z();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final boolean r() {
        if (this.W == GroupAnimationState.IDLE) goto L5;
        return false;
    L5:
        if (this.S >= 1.0f) goto L7;
        return false;
    L7:
        if (getItemCount() != 1) goto L21;
        LinearLayout r0 = this.D;
        if (r0 != null) goto L11;
        View r1 = null;
    L12:
        if (r1 != null) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == true) goto L21;
        boolean r3 = false;
    L22:
        if (r3 == false) goto L27;
        return true;
    L27:
        return false;
    L15:
        if (r1.isEnabled() != true) goto L17;
        r2 = true;
        goto L18
    L11:
        r1 = r0.getChildAt(0);
    L21:
        r3 = true;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K() {
        if (getItemCount() != 0) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
    }

    public final void O() {
        if (Q() == false) goto L5;
        return;
    L5:
        if (((ArrayList) this.R).isEmpty() == true) goto L13;
        List r0 = CollectionsKt.toList(this.R);
        ((ArrayList) this.R).clear();
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        ((Function0) r1.next()).invoke();
        goto L9
    L14:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean R() {
        if (getItemCount() == 0) goto L5;
        LinearLayout r0 = this.D;
        if (r0 != null) goto L13;
        return true;
    L13:
        if (getVisibility() == 0) goto L15;
    L44:
        return false;
    L15:
        if (V() == true) goto L44;
        ViewGroup.LayoutParams r3 = getLayoutParams();
        if (r3 != null) goto L20;
        int r4 = -2;
    L21:
        if (r4 == (-2)) goto L23;
        return false;
    L23:
        int r5 = r0.getChildCount();
        int r6 = 0;
    L24:
        if (r6 >= r5) goto L43;
        int r7 = r6 + 1;
        View r8 = r0.getChildAt(r6);
        if (Math.abs(r8.getAlpha() - L(r8)) >= 0.001f) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == false) goto L42;
        if (r8.getScaleX() != 1.0f) goto L33;
        boolean r10 = true;
    L34:
        if (r10 == false) goto L42;
        if (r8.getScaleY() != 1.0f) goto L38;
        boolean r11 = true;
    L39:
        if (r11 == false) goto L42;
        r6 = r7;
        goto L24
    L38:
        r11 = false;
        goto L39
    L33:
        r10 = false;
    L42:
        return false;
    L28:
        r9 = false;
        goto L29
    L43:
        return true;
    L20:
        r4 = r3.width;
        goto L21
    L5:
        if (getVisibility() != 0) goto L49;
        return false;
    L49:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean V() {
        if (getContentView().getAlpha() >= 1.0f) goto L5;
        return true;
    L5:
        if (getScaleX() != 1.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return true;
    L10:
        if (getScaleY() != 1.0f) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return true;
    L15:
        if (this.M > 0.0f) goto L22;
        return false;
    L22:
        return true;
    L12:
        r1 = false;
        goto L13
    L7:
        r0 = false;
        goto L8
    }

    @Override // com.obric.oui.button.OShadowFrame
    public float getCurrentPressScaleForAnimation() {
        return this.U;
    }

    public final float getRawGroupAlphaForTitleBarTransition$OUI_standardRelease() {
        return this.S;
    }

    public static float L(View r2) {
        if (r2.isEnabled() == false) goto L6;
        return 1.0f;
    L6:
        if ((r2 instanceof com.obric.oui.common.style.a) == true) goto L8;
        return 1.0f;
    L8:
        float r0 = r2.getAlpha();
        r2.setAlpha(1.0f);
        r2.setEnabled(false);
        float r1 = r2.getAlpha();
        r2.setAlpha(r0);
        return r1;
    }

    public static boolean M(View r5) {
        if ((r5 instanceof TextView) == false) goto L6;
        return true;
    L6:
        if ((r5 instanceof ViewGroup) == false) goto L13;
        ViewGroup r6 = (ViewGroup) r5;
        int r0 = r6.getChildCount();
        int r3 = 0;
    L8:
        if (r3 >= r0) goto L13;
        int r4 = r3 + 1;
        if (M(r6.getChildAt(r3)) == true) goto L11;
        r3 = r4;
        goto L8
    L11:
        return true;
    L13:
        return false;
    }

    public static List T(List r3) {
        List r4 = r3;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        View r1 = (View) r5.next();
        Object r2 = r1.getTag();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        r0.add(r1);
        goto L4
    L10:
        return r0;
    }

    private final void setGroupAlpha(float r2) {
        this.S = r2;
        getContentView().setAlpha(r2);
        setContentShadowAlphaProgress(r2);
    }

    private final void setGroupBlur(float r1) {
        setContentSelfBlur(r1);
    }

    private final void setGroupBlurForAnimation(float r1) {
        this.M = r1;
        setGroupBlur(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setGroupScaleForAnimation(float r2) {
        this.T = r2;
        float r3 = r2 * this.U;
        setScaleX(r3);
        setScaleY(r3);
    }

    private final void settleChildrenVisualState(List<? extends View> r4) {
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        View r0 = (View) r5.next();
        if (r0.isEnabled() == false) goto L8;
        r0.setAlpha(1.0f);
    L9:
        r0.setScaleX(1.0f);
        r0.setScaleY(1.0f);
        goto L4
    L8:
        r0.setEnabled(false);
        goto L9
    }

    public static final void u(OButtonGroup r1) {
        if ((!((ArrayList) r1.Q).isEmpty()) == false) goto L8;
        List r0 = CollectionsKt.toList(r1.Q);
        ((ArrayList) r1.Q).clear();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        ((Function0) r2.next()).invoke();
        goto L6
    L10:
        return;
    }

    public final void C(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (Q() == true) goto L6;
        r2.invoke();
        return;
    L6:
        ((ArrayList) this.R).add(r2);
    }

    public final void H(boolean r2) {
        J();
        I();
        ((ArrayList) this.Q).clear();
        ((ArrayList) this.R).clear();
        if (r2 == false) goto L6;
        this.N = null;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P(int r2) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.width = r2;
        setLayoutParams(r0);
    }

    public final int U(List<? extends View> r9) {
        if (r9.isEmpty() == false) goto L5;
        return 0;
    L5:
        int r0 = getContentContainer().getPaddingLeft() + getContentContainer().getPaddingRight();
        Iterator<T> r10 = r9.iterator();
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r10.hasNext() == false) goto L21;
        Object r4 = r10.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        View r6 = (View) r4;
        int r7 = r6.getMinimumHeight();
        if (r7 > 0) goto L14;
    L16:
        r6.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r2 = r2 + r6.getMeasuredWidth();
        if (r3 <= 0) goto L19;
        r2 = r2 + this.E;
    L19:
        r3 = r5;
        goto L7
    L14:
        if (r6.getMinimumWidth() >= r7) goto L16;
        r6.setMinimumWidth(r7);
        goto L16
    L21:
        return Math.max(r2 + r0, this.F);
    }

    public final void W(List<? extends View> r9) {
        LinearLayout r0 = this.D;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeAllViews();
        Iterator<T> r10 = r9.iterator();
        int r2 = 0;
    L7:
        if (r10.hasNext() == false) goto L32;
        Object r3 = r10.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        View r5 = (View) r3;
        ViewParent r6 = r5.getParent();
        ViewGroup.MarginLayoutParams r7 = null;
        if ((r6 instanceof ViewGroup) == false) goto L14;
        ViewGroup r8 = (ViewGroup) r6;
    L15:
        if (r8 == null) goto L18;
        r8.removeView(r5);
    L18:
        int r11 = r5.getMinimumHeight();
        if (r11 > 0) goto L21;
    L23:
        ViewGroup.LayoutParams r12 = r5.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        r7 = (ViewGroup.MarginLayoutParams) r12;
    L26:
        if (r7 != null) goto L28;
        r7 = new ViewGroup.MarginLayoutParams(-2, -2);
    L28:
        if (r2 != 0) goto L30;
        int r13 = 0;
    L31:
        r7.setMarginStart(r13);
        r0.addView(r5, r7);
        r2 = r4;
        goto L7
    L30:
        r13 = this.E;
        goto L31
    L21:
        if (r5.getMinimumWidth() >= r11) goto L23;
        r5.setMinimumWidth(r11);
        goto L23
    L14:
        r8 = null;
        goto L15
    L32:
        i0();
        K();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.oui.button.OShadowFrame
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        boolean r1 = true;
        if (this.V == false) goto L6;
        return true;
    L6:
        if (getItemCount() != 1) goto L8;
        boolean r0 = true;
    L9:
        boolean r3 = super.dispatchTouchEvent(r8);
        if (r0 == false) goto L37;
        boolean r2 = r();
        int r4 = r8.getActionMasked();
        if (r4 == 0) goto L36;
        if (r4 != 1) goto L15;
    L35:
        getContentView().setPressed(false);
        goto L37
    L15:
        if (r4 == 2) goto L20;
        if (r4 == 3) goto L35;
    L20:
        if (r8.getX() >= 0.0f) goto L22;
    L28:
        boolean r9 = false;
    L29:
        OUIFrameLayout r5 = getContentView();
        if (r2 == false) goto L33;
        if (r9 == false) goto L33;
    L34:
        r5.setPressed(r1);
    L33:
        r1 = false;
        goto L34
    L22:
        if (r8.getX() >= getWidth()) goto L28;
        if (r8.getY() < 0.0f) goto L28;
        if (r8.getY() >= getHeight()) goto L28;
        r9 = true;
        goto L29
    L36:
        getContentView().setPressed(r2);
    L37:
        return r3;
    L8:
        r0 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.oui.button.OShadowFrame
    public final void e(float r2) {
        this.U = r2;
        float r0 = this.T * r2;
        setScaleX(r0);
        setScaleY(r0);
    }

    public final void setAnimationUpdateListener$OUI_standardRelease(Function0<Unit> r1) {
        this.O = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.oui.button.OShadowFrame
    public void setEnabled(boolean r6) {
        if (Q() == false) goto L5;
        b r0 = a0();
    L6:
        super.setEnabled(r6);
        LinearLayout r1 = this.D;
        if (r1 == null) goto L13;
        r1.setEnabled(r6);
        Iterator r2 = ViewGroupKt.getChildren(r1).iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        ((View) r2.next()).setEnabled(r6);
    L13:
        i0();
        if (r0 == null) goto L30;
        setVisibility(r0.a);
        F(r0.b, r0.c, r0.e);
        P(r0.f);
        LinearLayout r7 = this.D;
        if (r7 == null) goto L35;
        Iterator<T> r3 = r0.g.iterator();
        int r4 = 0;
    L21:
        if (r3.hasNext() == false) goto L36;
        Object r5 = r3.next();
        int r8 = r4 + 1;
        if (r4 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        d r9 = (d) r5;
        View r10 = r7.getChildAt(r4);
        if (r10 == null) goto L29;
        r10.setVisibility(r9.b);
        r10.setAlpha(r9.c);
        r10.setScaleX(r9.d);
        r10.setScaleY(r9.e);
    L29:
        r4 = r8;
        goto L21
    L36:
        return;
    L35:
        return;
    L30:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void setGroupAlphaAnimationUpdateListener$OUI_standardRelease(Function0<Unit> r1) {
        this.P = r1;
    }

    public final void setTouchEventBlocked$OUI_standardRelease(boolean r1) {
        this.V = r1;
    }

    public void setWidthMin(int r2) {
        getLayoutHelper().setWidthMin(r2);
    }

    public static void b0(Function0 r2, Function1 r3) {
        a r0 = new a(r2);
        r3.invoke(r0);
        if (((ArrayList) r0.b).isEmpty() == true) goto L5;
        r0.c = ((ArrayList) r0.b).size();
        r0.d = true;
        Iterator r4 = ((ArrayList) r0.b).iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        ((Function1) r4.next()).invoke(new OButtonGroup$AnimationBatch$start$1$1(r0));
        goto L10
    L15:
        return;
    L5:
        if (r0.e == true) goto L14;
        r0.e = true;
        r0.a.invoke();
        return;
    }

    public static final /* synthetic */ void w(OButtonGroup r0, float r1) {
        r0.setGroupBlurForAnimation(r1);
    }

    public static final /* synthetic */ void x(OButtonGroup r0, float r1) {
        r0.setGroupScaleForAnimation(r1);
    }

    public static final /* synthetic */ void y(OButtonGroup r0, List r1) {
        r0.settleChildrenVisualState(r1);
    }

    public final void D(View r3, ViewGroup.MarginLayoutParams r4) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "layoutParams");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "layoutParams");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "layoutParams");
        r3.setLayoutParams(r4);
        List<? extends View> r5 = CollectionsKt.toMutableList(N());
        ListProtector.add(r5, r5.size(), r3);
        h0(r5, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(final boolean r6, final Function0<Unit> r7) {
        boolean r1 = false;
        getContentView().setPressed(false);
        f();
        if (getContentView().getAlpha() > 0.0f) goto L5;
        o();
    L5:
        setVisibility(0);
        if (r6 == false) goto L11;
        c.b r0 = c.a.a;
        F(0.0f, 1.1f, 7);
        Iterator<T> r2 = N().iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        View r3 = (View) r2.next();
        r3.setAlpha(0.0f);
        c.b r4 = c.a.a;
        r3.setScaleX(1.5f);
        r3.setScaleY(1.5f);
    L11:
        LinearLayout r5 = this.D;
        if (r5 != null) goto L14;
        return;
    L14:
        Integer r8 = Integer.valueOf(r5.getWidth());
        if (r8.intValue() <= 0) goto L17;
        r1 = true;
    L17:
        if (r1 == true) goto L20;
        r8 = null;
    L20:
        if (r8 != null) goto L22;
        final int r9 = r5.getMeasuredWidth();
    L23:
        if (r6 == false) goto L25;
        final List<View> r10 = N();
    L26:
        this.W = GroupAnimationState.APPEARING;
        ((ArrayList) this.J).clear();
        b0(new OButtonGroup$animateGroupAppear$1(this, r6, r10, r7), new OButtonGroup$animateGroupAppear$2(r10, this, r9));
        return;
    L25:
        r10 = CollectionsKt.emptyList();
        goto L26
    L22:
        r9 = r8.intValue();
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(b r6, Function1<? super d, ? extends View> r7) {
        Intrinsics.checkNotNullParameter(r6, "state");
        Intrinsics.checkNotNullParameter(r7, "itemFactory");
        H(true);
        List<d> r0 = r6.g;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        View r3 = null;
        if (r2.hasNext() == false) goto L11;
        d r4 = (d) r2.next();
        View r5 = (View) r7.invoke(r4);
        if (r5 == null) goto L9;
        r5.setVisibility(r4.b);
        r5.setAlpha(r4.c);
        r5.setScaleX(r4.d);
        r5.setScaleY(r4.e);
        r3 = r5;
    L9:
        if (r3 == null) goto L3;
        r1.add(r3);
        goto L3
    L11:
        W(r1);
        this.N = null;
        P(r6.f);
        setVisibility(r6.a);
        F(r6.b, r6.c, r6.e);
        i0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h0(final List<? extends View> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "views");
        LinearLayout r0 = this.D;
        if (r0 != null) goto L7;
        wma.b.b("OButtonGroup", "itemContainer is null");
        return;
    L7:
        if (r13.size() <= this.G) goto L9;
        wma.b.h("OButtonGroup", "views size exceeds capacity: " + this.G + ", truncated");
        r13 = CollectionsKt.take(r13, this.G);
    L9:
        int r1 = r0.getChildCount();
        int r2 = r13.size();
        List<? extends Object> r3 = T(r13);
        List r4 = T(N());
        if (Intrinsics.areEqual(r3, r4) == false) goto L15;
        if (R() == false) goto L15;
        return;
    L15:
        if (Q() == true) goto L17;
    L19:
        final boolean r5 = true;
        Integer r6 = null;
        if (r14 == true) goto L23;
        H(true);
        W(r13);
        X();
        K();
        this.N = null;
        return;
    L23:
        this.N = r3;
        if (Intrinsics.areEqual(r3, r4) == true) goto L26;
    L77:
        if (r2 != 0) goto L94;
        GroupAnimationState r15 = this.W;
        GroupAnimationState r16 = GroupAnimationState.DISAPPEARING;
        if (r15 == r16) goto L121;
        I();
        J();
        final Function0<Unit> r17 = new OButtonGroup$transitionToEmpty$1(this);
        LinearLayout r7 = this.D;
        if (r7 == null) goto L122;
        Integer r8 = Integer.valueOf(r7.getWidth());
        if (r8.intValue() <= 0) goto L87;
        boolean r9 = true;
    L88:
        if (r9 == false) goto L90;
        r6 = r8;
    L90:
        if (r6 != null) goto L92;
        final int r10 = r7.getMeasuredWidth();
    L93:
        final List<View> r11 = N();
        getContentView().setPressed(false);
        f();
        this.W = r16;
        ((ArrayList) this.J).clear();
        b0(new OButtonGroup$animateGroupDisappear$1(this, r17, r5), new OButtonGroup$animateGroupDisappear$2(r11, this, r10));
        return;
    L92:
        r10 = r6.intValue();
        goto L93
    L87:
        r9 = false;
        goto L88
    L122:
        return;
    L121:
        return;
    L94:
        if (r1 != 0) goto L97;
        H(false);
        W(r13);
        E(true, new OButtonGroup$transitionFromEmpty$1(this));
        return;
    L97:
        if (this.W == GroupAnimationState.IDLE) goto L99;
        J();
    L99:
        I();
        final boolean r12 = V();
        final List<View> r18 = N();
        Integer r19 = Integer.valueOf(getWidth());
        if (r19.intValue() > 0) goto L103;
        r5 = false;
    L103:
        if (r5 == false) goto L105;
        r6 = r19;
    L105:
        if (r6 != null) goto L107;
        int r110 = getMeasuredWidth();
    L108:
        final int r111 = U(r13);
        P(r110);
        this.L = ContentAnimationState.OUT;
        ((ArrayList) this.K).clear();
        final Ref.BooleanRef r20 = new Ref.BooleanRef();
        final Ref.BooleanRef r21 = new Ref.BooleanRef();
        g0(r110, r111, new OButtonGroup$animateContentChange$1(r20, this, r13, r21));
        if (r12 == false) goto L111;
        setVisibility(0);
    L111:
        final boolean r22 = !r12;
        b0(new OButtonGroup$animateContentChange$2(this, r13, r21, r20), new OButtonGroup$animateContentChange$3(r12, r22, r18, this, r111));
        return;
    L107:
        r110 = r6.intValue();
        goto L108
    L26:
        if (R() == true) goto L77;
        final List<View> r112 = N();
        if (r112.isEmpty() == false) goto L30;
        X();
        K();
        return;
    L30:
        H(false);
        if (V() == false) goto L33;
    L34:
        E(false, null);
    L35:
        LinearLayout r113 = this.D;
        if (r113 == null) goto L64;
        ViewGroup.LayoutParams r23 = getLayoutParams();
        if (r23 != null) goto L41;
        int r24 = -2;
    L42:
        if (r24 != (-2)) goto L63;
        int r25 = r113.getChildCount();
        int r26 = 0;
    L45:
        if (r26 >= r25) goto L64;
        int r27 = r26 + 1;
        View r28 = r113.getChildAt(r26);
        if (Math.abs(r28.getAlpha() - L(r28)) >= 0.001f) goto L49;
        boolean r29 = true;
    L50:
        if (r29 == false) goto L63;
        if (r28.getScaleX() != 1.0f) goto L54;
        boolean r30 = true;
    L55:
        if (r30 == false) goto L63;
        if (r28.getScaleY() != 1.0f) goto L59;
        boolean r31 = true;
    L60:
        if (r31 == false) goto L63;
        r26 = r27;
        goto L45
    L59:
        r31 = false;
        goto L60
    L54:
        r30 = false;
        goto L55
    L49:
        r29 = false;
    L63:
        boolean r114 = true;
    L65:
        if (r114 == false) goto L118;
        Integer r115 = Integer.valueOf(getWidth());
        if (r115.intValue() > 0) goto L70;
        r5 = false;
    L70:
        if (r5 == false) goto L72;
        r6 = r115;
    L72:
        if (r6 != null) goto L74;
        final int r116 = getMeasuredWidth();
    L75:
        final int r32 = U(r112);
        P(r116);
        this.L = ContentAnimationState.SETTLING;
        ((ArrayList) this.K).clear();
        b0(new OButtonGroup$animateContentSettle$1(this, r112), new OButtonGroup$animateContentSettle$2(r112, this, r116, r32));
        return;
    L74:
        r116 = r6.intValue();
        goto L75
    L118:
        return;
    L41:
        r24 = r23.width;
    L64:
        r114 = false;
        goto L65
    L33:
        if (getVisibility() == 0) goto L35;
    L17:
        if (Intrinsics.areEqual(r3, this.N) == false) goto L19;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F(float r1, float r2, float r3) {
        setGroupAlpha(r1);
        this.T = r2;
        float r4 = r2 * this.U;
        setScaleX(r4);
        setScaleY(r4);
        setGroupBlurForAnimation(r3);
    }

    public final Function1<Float, Unit> G(final float r11, float r12, final Function1<? super Float, Unit> r13) {
        final float r4 = RangesKt.coerceIn(r12, 0.0f, 1.0f);
        if (r4 != 1.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
    L10:
        final boolean r5 = false;
    L12:
        if (r4 != 0.0f) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == true) goto L17;
    L19:
        final boolean r6 = false;
    L20:
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        return new OButtonGroup$boundedAlphaUpdater$1(r3, r4, r5, r6, this, r11, r13);
    L17:
        if (r11 <= r4) goto L19;
        r6 = true;
        goto L20
    L14:
        r0 = false;
        goto L15
    L8:
        if (r11 >= r4) goto L10;
        r5 = true;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public final void g0(int r9, final int r10, final Function0<Unit> r11) {
        List<fja.d> r0 = this.K;
        float r2 = r9;
        float r3 = r10;
        c.b r12 = c.a.a;
        if (r10 >= 150) goto L5;
        c.b r13 = c.a.s;
    L6:
        ((ArrayList) r0).add(c0(r2, r3, r13.a(), 10.0f, new OButtonGroup$startWidthChangeAnimation$1(this), new OButtonGroup$startWidthChangeAnimation$2(this, r10, r11)));
        return;
    L5:
        r13 = c.a.t;
        goto L6
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void k(Context r3, OUIFrameLayout r4, TypedArray r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "contentView");
        r4.removeAllViews();
        setChangeAlphaWhenPress(false);
        getContentView().setDuplicateParentStateEnabled(false);
        LinearLayout r1 = new LinearLayout(r3);
        r1.setOrientation(0);
        r1.setGravity(17);
        this.D = r1;
        r4.addView(r1);
        setWidthMin(this.F);
        getContentView().setWidthMin(this.F);
        i0();
        K();
        if (getEnableMaterial() == false) goto L6;
        l(r3, r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OButtonGroup(Context r8, AttributeSet r9, int r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r11 & 4) == 0) goto L8;
        int r3 = 0;
    L9:
        Intrinsics.checkNotNullParameter(r8, "context");
        AttributeSet r2 = r9;
        super(r8, r2, r3, 8, 0);
        this.G = 5;
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.L = ContentAnimationState.IDLE;
        this.Q = new ArrayList();
        this.R = new ArrayList();
        this.S = 1.0f;
        this.T = 1.0f;
        this.U = 1.0f;
        this.W = GroupAnimationState.IDLE;
        setClipChildren(false);
        setClipToPadding(false);
        TypedArray r12 = r8.obtainStyledAttributes(r9, new int[]{R.attr.layout_height, 2130973014, 2130973374, 2130973382, 2130973383, 2130973386, 2130973390, 2130973391, 2130973392, 2130973394, 2130973395}, 0, 0);
        this.F = r12.getDimensionPixelSize(6, 0);
        this.E = r12.getDimensionPixelSize(3, 0);
        this.G = r12.getDimensionPixelSize(1, 5);
        r12.recycle();
        return;
    L8:
        r3 = r10;
        goto L9
    }

    public static final void B(final OButtonGroup r8, com.obric.common.oea.foundation.animation.spec.spring.b r9, Function0 r10, List r11) {
        final List<q> r0 = r8.i();
        final float r1 = 1.0f;
        final List<q> r2 = r8.n(1.0f);
        final Function1<Float, Unit> r3 = r8.G(0.0f, 1.0f, new OButtonGroup$startGroupShadowAnimation$updateFraction$1(r8, r1, r0, r2));
        ArrayList r12 = (ArrayList) r11;
        r12.add(r8.c0(0.0f, 1.0f, r9, 0.390625f, new OButtonGroup$startGroupShadowAnimation$1(r3), r10));
    }

    public static final void v(OButtonGroup r0, List r1, boolean r2, boolean r3) {
        r0.getClass();
        if (r2 == false) goto L8;
        if (r3 == false) goto L9;
        ((ArrayList) r0.K).clear();
        r0.L = ContentAnimationState.IDLE;
        r0.settleChildrenVisualState(r1);
        r0.P(-2);
        r0.setGroupScaleForAnimation(1.0f);
        r0.setGroupBlurForAnimation(0.0f);
        r0.N = null;
        r0.O();
        return;
    L9:
        return;
    }

    public final void d0(final float r9, com.obric.common.oea.foundation.animation.spec.spring.b r10, Function0 r11, List r12) {
        final float r0 = getContentView().getAlpha();
        final List<q> r5 = i();
        final List<q> r6 = n(r9);
        final Function1<Float, Unit> r1 = G(r0, r9, new OButtonGroup$startGroupAlphaAnimation$updateAlpha$1(this, r9, r0, r5, r6));
        r12.add(c0(r0, r9, r10, 0.390625f, new OButtonGroup$startGroupAlphaAnimation$1(this, r1), r11));
    }

    public final void e0(float r8, com.obric.common.oea.foundation.animation.spec.spring.b r9, Function0 r10, List r11) {
        r11.add(c0(this.M, r8, r9, 10.0f, new OButtonGroup$startGroupBlurAnimation$1(this), r10));
    }

    public final void f0(float r8, com.obric.common.oea.foundation.animation.spec.spring.b r9, final Function0 r10, List r11) {
        r11.add(c0(this.T, r8, r9, 0.390625f, new OButtonGroup$startGroupScaleAnimation$1(this), new OButtonGroup$startGroupScaleAnimation$2(r10)));
    }

    public static final void A(OButtonGroup r7, final View r8, float r9, com.obric.common.oea.foundation.animation.spec.spring.b r10, final Function0 r11, List r12) {
        r7.getClass();
        ArrayList r13 = (ArrayList) r12;
        r13.add(r7.c0(r8.getScaleX(), r9, r10, 0.390625f, new OButtonGroup$startChildScaleAnimation$1(r8), new OButtonGroup$startChildScaleAnimation$2(r11)));
    }

    public static final void z(OButtonGroup r8, final View r9, float r10, com.obric.common.oea.foundation.animation.spec.spring.b r11, Function0 r12, List r13) {
        r8.getClass();
        final Function1<Float, Unit> r0 = r8.G(r9.getAlpha(), r10, new OButtonGroup$startChildAlphaAnimation$updateAlpha$1(r9));
        ArrayList r14 = (ArrayList) r13;
        r14.add(r8.c0(r9.getAlpha(), r10, r11, 0.390625f, new OButtonGroup$startChildAlphaAnimation$1(r0), r12));
    }

    public final fja.d c0(float r3, float r4, com.obric.common.oea.foundation.animation.spec.spring.b r5, float r6, final Function1 r7, final Function0 r8) {
        com.obric.common.oea.foundation.animation.builder.d.a r0 = new com.obric.common.oea.foundation.animation.builder.d.a();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.b = r6;
        r0.b(r3, r4, r5, null);
        Function3<String, Object, Object, Unit> r9 = new OButtonGroup$startFloatAnimation$1(r7, this);
        Intrinsics.checkNotNullParameter(r9, "callback");
        r0.d = r9;
        Function2<Boolean, Throwable, Unit> r10 = new OButtonGroup$startFloatAnimation$2(r8);
        Intrinsics.checkNotNullParameter(r10, "callback");
        r0.e = r10;
        return r0.a().a();
    }
}
