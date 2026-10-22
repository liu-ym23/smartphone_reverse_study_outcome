package com.larus.asr.view;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.asr.api.databinding.LarusWidgetSpeakerBinding;
import com.larus.asr.config.ChatSpeakerStatus;
import com.larus.common_ui.blur.BlurCircleWithAmplitude;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import com.larus.platform.model.SpeakStyleConfig;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import v19.l5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class v0 {
    public static final /* synthetic */ int r = 0;
    public final Context a;
    public final d0 b;
    public boolean c;
    public final c d;
    public Pair<Boolean, ? extends GradientDrawable> e;
    public final Lazy f;
    public ChatSpeakerStatus g;
    public boolean h;
    public Function1<? super Pair<Float, Float>, Unit> i;
    public Job j;
    public Job k;
    public long l;
    public boolean m;
    public Function1<? super ChatSpeakerStatus, Unit> n;
    public final Lazy o;
    public final Lazy p;
    public z48.a q;

    public static final class a {
        public static final a e = null;
        public static final a f = null;
        public final Function1<LarusWidgetSpeakerBinding, ConstraintLayout> a;
        public final Function1<LarusWidgetSpeakerBinding, ImageView> b;
        public final Function1<LarusWidgetSpeakerBinding, TextView> c;
        public final Function1<LarusWidgetSpeakerBinding, View> d;

        /* JADX INFO: renamed from: com.larus.asr.view.v0$a$a, reason: collision with other inner class name */
        public static final class C0071a {
        }

        public static final class b {
            public final ConstraintLayout a;
            public final ImageView b;
            public final TextView c;
            public final View d;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
            }

            public final String toString() {
                return "RenderGroup(group=" + this.a + ", icon=" + this.b + ", text=" + this.c + ", shadow=" + this.d + ')';
            }

            public b(ConstraintLayout r2, ImageView r3, TextView r4, View r5) {
                Intrinsics.checkNotNullParameter(r2, "group");
                Intrinsics.checkNotNullParameter(r3, "icon");
                Intrinsics.checkNotNullParameter(r4, "text");
                Intrinsics.checkNotNullParameter(r5, "shadow");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
            }
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "BindingMapping(groupMapping=" + this.a + ", iconMapping=" + this.b + ", textMapping=" + this.c + ", shadowMapping=" + this.d + ')';
        }

        static {
            e = new a(new n0(), new o0(), new p0(), new q0());
            f = new a(new r0(), new s0(), new t0(), new u0());
        }

        public final b a(LarusWidgetSpeakerBinding r6) {
            Intrinsics.checkNotNullParameter(r6, "binding");
            return new b((ConstraintLayout) this.a.invoke(r6), (ImageView) this.b.invoke(r6), (TextView) this.c.invoke(r6), (View) this.d.invoke(r6));
        }

        public a(Function1<? super LarusWidgetSpeakerBinding, ? extends ConstraintLayout> r2, Function1<? super LarusWidgetSpeakerBinding, ? extends ImageView> r3, Function1<? super LarusWidgetSpeakerBinding, ? extends TextView> r4, Function1<? super LarusWidgetSpeakerBinding, ? extends View> r5) {
            Intrinsics.checkNotNullParameter(r2, "groupMapping");
            Intrinsics.checkNotNullParameter(r3, "iconMapping");
            Intrinsics.checkNotNullParameter(r4, "textMapping");
            Intrinsics.checkNotNullParameter(r5, "shadowMapping");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b {
    }

    public static final class c {
        public final int a;
        public final Function0<Unit> b;
        public int c;

        public c(e0 r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
            this.a = 0;
            this.b = r2;
            this.c = 0;
        }
    }

    static {
    }

    public final int e() {
        if (((SpeakStyleConfig) this.f.getValue()).getEnableNewStyle() == true) goto L7;
        Context r0 = this.a;
        return ContextCompat.getColor(r0, v19.c.b(2130972082, r0, 2131103146));
    L7:
        return ContextCompat.getColor(this.a, 2131106540);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.asr.view.e0] */
    public v0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new d0(this);
        this.d = new c(new e0());
        this.e = TuplesKt.to(Boolean.FALSE, null);
        this.f = LazyKt.lazy(new f0());
        this.h = true;
        this.i = new g0();
        this.n = new h0();
        this.o = LazyKt.lazy(new i0(this));
        this.p = LazyKt.lazy(new j0(this));
    }

    public static void a(ConstraintLayout r7) {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r7, View.ALPHA, new float[]{0.0f, 1.0f});
        r0.setDuration(240);
        r0.setInterpolator(new l5());
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r7, View.SCALE_X, new float[]{1.0f, 1.05f});
        r4.setDuration(240);
        r4.setInterpolator(new l5());
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r7, View.SCALE_Y, new float[]{1.0f, 1.05f});
        r8.setDuration(240);
        r8.setInterpolator(new l5());
        AnimatorSet r2 = new AnimatorSet();
        r2.playTogether(new Animator[]{r0, r4, r8});
        r2.start();
    }

    public final GradientDrawable c(int r5) {
        return new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r5, r5, r5, ve8.d.a(R.color.transparent, this.a)});
    }

    public final Pair<Integer, Integer> d(LarusWidgetSpeakerBinding r4) {
        if (((SpeakStyleConfig) this.f.getValue()).getEnableNewStyle() == false) goto L8;
        Rect r0 = new Rect();
        r4.f.getGlobalVisibleRect(r0);
        if (r0.isEmpty() == false) goto L7;
        return null;
    L7:
        int r1 = (r0.left + r0.right) / 2;
        return new Pair(Integer.valueOf(r0.bottom - r4.f.getCircleRectHeight()), Integer.valueOf(r1));
    L8:
        Rect r2 = new Rect();
        r4.b.getGlobalVisibleRect(r2);
        if (r2.isEmpty() == false) goto L11;
        return null;
    L11:
        int r5 = (r2.left + r2.right) / 2;
        return new Pair(Integer.valueOf(r2.top), Integer.valueOf(r5));
    }

    public final void f(LarusWidgetSpeakerBinding r7) {
        if (this.m == false) goto L5;
        a r0 = a.f;
    L6:
        a.b r8 = r0.a(r7);
        r8.a.setScaleX(1.0f);
        r8.a.setScaleY(1.0f);
        r8.d.setScaleX(1.0f);
        r8.d.setScaleY(1.0f);
        com.larus.utils.e1.x(r8.a);
        if (((Boolean) this.b.invoke()).booleanValue() == false) goto L9;
    L12:
        boolean r1 = true;
    L13:
        ChatSpeakerStatus r2 = this.g;
        String r3 = null;
        if (r2 == null) goto L16;
        ChatSpeakerStatus r4 = r2.toLegacyStatus();
    L17:
        z48.b r5 = new z48.b(r1, r4);
        z48.a r6 = this.q;
        if (r6 == null) goto L27;
        b58.a r9 = r6.b;
        if (r9 == null) goto L24;
        Function1<z48.b, Integer> r10 = r9.a;
        if (r10 == null) goto L24;
        Integer r11 = (Integer) r10.invoke(r5);
    L25:
        if (r11 == null) goto L27;
        int r12 = r11.intValue();
    L30:
        z48.a r13 = this.q;
        if (r13 == null) goto L40;
        b58.a r14 = r13.b;
        if (r14 == null) goto L37;
        Function1<z48.b, Integer> r15 = r14.c;
        if (r15 == null) goto L37;
        Integer r16 = (Integer) r15.invoke(r5);
    L38:
        if (r16 == null) goto L40;
        int r17 = r16.intValue();
    L41:
        z48.a r19 = this.q;
        if (r19 == null) goto L49;
        b58.a r20 = r19.b;
        if (r20 == null) goto L48;
        Function1<z48.b, String> r21 = r20.b;
        if (r21 == null) goto L48;
        r3 = (String) r21.invoke(r5);
    L48:
        if (r3 == null) goto L49;
    L50:
        r8.b.setImageResource(r12);
        r8.c.setText(r3);
        r8.c.setTextColor(this.a.getResources().getColor(r17));
        com.larus.utils.e1.o(r8.c);
        return;
    L49:
        r3 = this.a.getString(2131899945);
    L37:
        r16 = null;
    L40:
        r17 = v19.c.b(2130970996, this.a, 2131102650);
    L24:
        r11 = null;
    L27:
        if (r1 == false) goto L29;
        r12 = 2131242825;
        goto L30
    L29:
        r12 = 2131242826;
        goto L30
    L16:
        r4 = null;
        goto L17
    L9:
        if (((Boolean) this.e.getFirst()).booleanValue() == true) goto L12;
        r1 = false;
        goto L13
    L5:
        r0 = a.e;
        goto L6
    }

    public final void g(LarusWidgetSpeakerBinding r7) {
        if (this.m == false) goto L5;
        a r0 = a.e;
    L6:
        a.b r8 = r0.a(r7);
        r8.a.setScaleX(1.0f);
        r8.a.setScaleY(1.0f);
        r8.d.setScaleX(1.0f);
        r8.d.setScaleY(1.0f);
        com.larus.utils.e1.x(r8.a);
        if (((Boolean) this.b.invoke()).booleanValue() == false) goto L9;
    L12:
        boolean r1 = true;
    L13:
        ChatSpeakerStatus r2 = this.g;
        String r3 = null;
        if (r2 == null) goto L16;
        ChatSpeakerStatus r4 = r2.toLegacyStatus();
    L17:
        z48.b r5 = new z48.b(r1, r4);
        z48.a r6 = this.q;
        if (r6 == null) goto L27;
        b58.a r9 = r6.c;
        if (r9 == null) goto L24;
        Function1<z48.b, Integer> r10 = r9.a;
        if (r10 == null) goto L24;
        Integer r11 = (Integer) r10.invoke(r5);
    L25:
        if (r11 == null) goto L27;
        int r12 = r11.intValue();
    L30:
        z48.a r13 = this.q;
        if (r13 == null) goto L40;
        b58.a r14 = r13.c;
        if (r14 == null) goto L37;
        Function1<z48.b, Integer> r15 = r14.c;
        if (r15 == null) goto L37;
        Integer r16 = (Integer) r15.invoke(r5);
    L38:
        if (r16 == null) goto L40;
        int r17 = r16.intValue();
    L41:
        z48.a r19 = this.q;
        if (r19 == null) goto L49;
        b58.a r20 = r19.c;
        if (r20 == null) goto L48;
        Function1<z48.b, String> r21 = r20.b;
        if (r21 == null) goto L48;
        r3 = (String) r21.invoke(r5);
    L48:
        if (r3 == null) goto L49;
    L50:
        r8.b.setImageResource(r12);
        r8.c.setTextColor(this.a.getResources().getColor(r17));
        r8.c.setText(r3);
        com.larus.utils.e1.o(r8.c);
        com.larus.utils.e1.o(r8.d);
        return;
    L49:
        r3 = this.a.getString(2131900478);
    L37:
        r16 = null;
    L40:
        r17 = v19.c.b(2130970958, this.a, 2131102629);
    L24:
        r11 = null;
    L27:
        if (r1 == false) goto L29;
        r12 = 2131242830;
        goto L30
    L29:
        r12 = 2131242831;
        goto L30
    L16:
        r4 = null;
        goto L17
    L9:
        if (((Boolean) this.e.getFirst()).booleanValue() == true) goto L12;
        r1 = false;
        goto L13
    L5:
        r0 = a.f;
        goto L6
    }

    public final void h(LarusWidgetSpeakerBinding r3) {
        AudioVisualizerOpt r4 = r3.b.getChildAt(0);
        if ((r4 instanceof AudioVisualizerOpt) == false) goto L5;
        AudioVisualizerOpt r5 = r4;
    L6:
        if (r5 == null) goto L9;
        r5.setPaintColor(ContextCompat.getColor(this.a, 2131103298));
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void j(ChatSpeakerStatus r4) {
        if (this.g == r4) goto L5;
        FLogger.a.i("ContinuousSpeechManager", "[currentSpeakerStatus] from " + this.g + " to " + r4 + ']');
    L5:
        this.g = r4;
    }

    public static void b(View r4, boolean r5) {
        float r0 = 1.0f;
        if (r5 == false) goto L5;
        float r2 = 0.0f;
    L6:
        r4.setAlpha(r2);
        ViewPropertyAnimator r6 = r4.animate();
        r6.setDuration(240);
        r6.setInterpolator(new l5());
        if (r5 == true) goto L10;
        r0 = 0.0f;
    L10:
        r6.alpha(r0);
        r6.start();
        return;
    L5:
        r2 = 1.0f;
        goto L6
    }

    public final void i(LarusWidgetSpeakerBinding r4, float r5, float r6) {
        if (((SpeakStyleConfig) this.f.getValue()).getEnableNewStyle() == false) goto L11;
        BlurCircleWithAmplitude r7 = r4.f;
        int[] r0 = new int[2];
        int r2 = 0;
        r0[0] = ColorProtector.parseColor("#33B4FF");
        if (((Boolean) this.b.invoke()).booleanValue() == false) goto L7;
    L10:
        r0[1] = r2;
        r7.setCircleColor(r0);
        Rect r1 = new Rect();
        r7.getGlobalVisibleRect(r1);
        r7.b(r5 - r1.left, r6 - r1.top);
        Intrinsics.checkNotNull(r7);
        return;
    L7:
        if (((Boolean) this.e.getFirst()).booleanValue() == true) goto L10;
        r2 = 704643071;
        goto L10
    L11:
        r4.b.setBackgroundResource(v19.c.b(2130970556, this.a, 2131238619));
    }

    public final boolean k(LarusWidgetSpeakerBinding r6, float r7, float r8) {
        Pair<Integer, Integer> r0 = d(r6);
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = ((Number) r0.getFirst()).intValue();
        int r1 = ((Number) r0.getSecond()).intValue();
        if (ViewCompat.getLayoutDirection(r6.a) != 1) goto L8;
        boolean r9 = true;
    L10:
        if (this.m == false) goto L13;
        r9 = !r9;
    L13:
        if (r8 >= r2) goto L25;
        if (r9 == false) goto L19;
        if (r7 > r1) goto L20;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == false) goto L26;
        return true;
    L26:
        return false;
    L20:
        r10 = true;
        goto L22
    L19:
        if (r7 > r1) goto L21;
    L25:
        return false;
    L8:
        r9 = false;
        goto L10
    }

    public final boolean l(LarusWidgetSpeakerBinding r6, float r7, float r8) {
        Pair<Integer, Integer> r0 = d(r6);
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = ((Number) r0.getFirst()).intValue();
        int r1 = ((Number) r0.getSecond()).intValue();
        if (ViewCompat.getLayoutDirection(r6.a) != 1) goto L8;
        boolean r9 = true;
    L10:
        if (this.m == false) goto L13;
        r9 = !r9;
    L13:
        if (r8 >= r2) goto L25;
        if (r9 == false) goto L19;
        if (r7 <= r1) goto L20;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == false) goto L26;
        return true;
    L26:
        return false;
    L20:
        r10 = true;
        goto L22
    L19:
        if (r7 <= r1) goto L21;
    L25:
        return false;
    L8:
        r9 = false;
        goto L10
    }

    public final boolean m(LarusWidgetSpeakerBinding r4, boolean r5, Integer r6) {
        Boolean r0 = Boolean.valueOf(r5);
        if (r6 == null) goto L5;
        int r1 = com.larus.bmhome.chat.immerse.k0.a;
        GradientDrawable r7 = c(com.larus.bmhome.chat.immerse.k0.a(r6.intValue(), 0.4f, 0.15f));
    L6:
        Pair<Boolean, ? extends GradientDrawable> r8 = TuplesKt.to(r0, r7);
        this.e = r8;
        if (r4 != null) goto L10;
        return false;
    L10:
        if (this.c == true) goto L12;
        return false;
    L12:
        if (r5 == false) goto L17;
        GradientDrawable r9 = (GradientDrawable) r8.getSecond();
        if (r9 != null) goto L16;
        return false;
    L16:
        r4.d.setImageDrawable(r9);
    L18:
        f(r4);
        g(r4);
        return true;
    L17:
        r4.d.setImageDrawable((GradientDrawable) this.o.getValue());
        goto L18
    L5:
        r7 = null;
        goto L6
    }
}
