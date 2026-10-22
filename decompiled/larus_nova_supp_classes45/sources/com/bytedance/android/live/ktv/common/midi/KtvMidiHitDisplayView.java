package com.bytedance.android.live.ktv.common.midi;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/KtvMidiHitDisplayView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lqb0/a;", "", "getPerfectBg", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiHitDisplayView extends ConstraintLayout implements qb0.a {
    public HSImageView a;
    public HSImageView b;
    public TextView c;
    public TextView d;
    public AnimatorSet e;
    public AnimatorSet f;
    public HSImageView g;
    public g h;
    public final CompositeDisposable i;

    public static final class a {
    }

    static {
    }

    public KtvMidiHitDisplayView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvMidiHitDisplayView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final String getPerfectBg() {
        String r0 = c.a;
        return c.a;
    }

    public final void onDetach() {
        this.i.dispose();
        AnimatorSet r0 = this.e;
        if (r0 != null) goto L5;
    L9:
        AnimatorSet r1 = this.f;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.isRunning() != true) goto L18;
        AnimatorSet r2 = this.f;
        if (r2 == null) goto L19;
        r2.end();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r0.isRunning() != true) goto L9;
        AnimatorSet r3 = this.e;
        if (r3 == null) goto L9;
        r3.end();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvMidiHitDisplayView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.i = new CompositeDisposable();
        LayoutInflater.from(r6).inflate(2131566673, this);
        this.a = (HSImageView) findViewById(2131374431);
        this.b = (HSImageView) findViewById(2131374433);
        this.c = (TextView) findViewById(2131367260);
        this.d = (TextView) findViewById(2131367261);
        this.g = (HSImageView) findViewById(2131374429);
        Typeface r9 = Typeface.createFromAsset(getContext().getAssets(), "font/ttlive_ktv_midi_combo_font.ttf");     // Catch: Exception -> L10
        TextView r11 = this.c;     // Catch: Exception -> L10
        if (r11 == null) goto L6;
        r11.setTypeface(r9);     // Catch: Exception -> L10
    L6:
        TextView r12 = this.d;     // Catch: Exception -> L10
        if (r12 == null) goto L12;
        r12.setTypeface(r9);     // Catch: Exception -> L10
    L12:
        g r13 = this.h;
        ViewGroup.LayoutParams r14 = null;
        if (r13 == null) goto L44;
        if (r13.getCurrentMode() != 1) goto L44;
        TextView r15 = this.c;
        if (r15 == null) goto L19;
        r15.setTextSize(s1.f(4.0f));
    L19:
        TextView r16 = this.c;
        if (r16 == null) goto L22;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
    L24:
        if (r17 == null) goto L42;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
        TextView r1 = this.c;
        if (r1 == null) goto L28;
        a1.l(this, s1.f(5.0f));
        a1.n(this, s1.f(1.0f));
        r18.setMarginEnd(s1.f(1.0f));
        Unit r4 = Unit.INSTANCE;
        r1.setLayoutParams(r18);
    L28:
        TextView r19 = this.d;
        if (r19 == null) goto L31;
        r19.setTextSize(s1.f(4.0f));
    L31:
        TextView r21 = this.c;
        if (r21 == null) goto L34;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
    L35:
        if (r22 == null) goto L40;
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r22;
        TextView r24 = this.d;
        if (r24 == null) goto L44;
        a1.l(this, s1.f(5.0f));
        a1.n(this, s1.f(1.0f));
        r23.setMarginEnd(s1.f(1.0f));
        Unit r0 = Unit.INSTANCE;
        r24.setLayoutParams(r23);
        goto L44
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L34:
        r22 = null;
        goto L35
    L42:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L22:
        r17 = null;
    L44:
        if (KtvSettingHelper.z() == false) goto L69;
        TextView r25 = this.c;
        if (r25 == null) goto L56;
        TextPaint r26 = r25.getPaint();
        if (r26 == null) goto L56;
        float r27 = r26.measureText("x444");
        TextView r2 = this.c;
        if (r2 == null) goto L56;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L54;
        r3.width = (int) r27;
        Unit r28 = Unit.INSTANCE;
    L55:
        r2.setLayoutParams(r3);
        goto L56
    L54:
        r3 = null;
    L56:
        TextView r29 = this.d;
        if (r29 == null) goto L70;
        TextPaint r31 = r29.getPaint();
        if (r31 == null) goto L71;
        float r32 = r31.measureText("x444");
        TextView r33 = this.d;
        if (r33 == null) goto L72;
        ViewGroup.LayoutParams r5 = r33.getLayoutParams();
        if (r5 == null) goto L65;
        r5.width = (int) r32;
        Unit r34 = Unit.INSTANCE;
        r14 = r5;
    L65:
        r33.setLayoutParams(r14);
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L69:
        return;
    L10:
        e = move-exception;
        ALogger.e("KtvRoomMidiHitDisplayView", "load font asset exception: " + e.getMessage());
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qb0.a
    public final void C4(int r22, int r23, boolean r24) {
        e.b("KtvRoomMidiHitDisplayView", "showHitAnimation hitType " + r22 + " comboCount " + r23 + "  isAdvanced " + r24);
        g r4 = this.h;
        if (r4 != null) goto L5;
        return;
    L5:
        String r3 = r4.K(r22, r24);
        if (r3 != null) goto L8;
        return;
    L8:
        g r5 = this.h;
        if (r5 == null) goto L11;
        String r6 = r5.J();
    L13:
        if (r22 == 1) goto L178;
        if (r22 == 2) goto L178;
        if (r22 != 3) goto L195;
        g r1 = this.h;
        Intrinsics.checkNotNull(r1);
        r1.H();
        g r2 = this.h;
        Intrinsics.checkNotNull(r2);
        if (r23 < r2.C()) goto L97;
        if (r6 != null) goto L22;
        r6 = getPerfectBg();
    L22:
        if (this.d == null) goto L196;
        TextView r7 = this.c;
        if (r7 != null) goto L28;
        return;
    L28:
        if (this.g == null) goto L198;
        r7.setText("x" + r23);
        TextView r8 = this.d;
        if (r8 == null) goto L33;
        r8.setText("x" + r23);
    L33:
        TextView r9 = this.c;
        if (r9 == null) goto L36;
        r9.setVisibility(0);
    L36:
        TextView r11 = this.d;
        if (r11 == null) goto L40;
        r11.setVisibility(0);
    L40:
        if (KtvSettingHelper.z() == false) goto L42;
        ValueAnimator r12 = LiveDegradeFpsAnimator.ofFloat(this.c, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L43:
        r12.setStartDelay(400);
        r12.setDuration(300);
        r12.setInterpolator(new LinearInterpolator());
        if (KtvSettingHelper.z() == false) goto L46;
        ValueAnimator r13 = LiveDegradeFpsAnimator.ofFloat(this.c, LiveDegradeFpsAnimator.SCALE_X, new float[]{2.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L47:
        r13.setStartDelay(400);
        r13.setDuration(300);
        r13.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L50;
        ValueAnimator r14 = LiveDegradeFpsAnimator.ofFloat(this.c, LiveDegradeFpsAnimator.SCALE_Y, new float[]{2.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L51:
        r14.setStartDelay(400);
        r14.setDuration(300);
        r14.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L54;
        ValueAnimator r15 = LiveDegradeFpsAnimator.ofFloat(this.c, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
    L55:
        r15.setStartDelay(1800);
        r15.setDuration(200);
        r15.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L58;
        ValueAnimator r16 = LiveDegradeFpsAnimator.ofFloat(this.d, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L59:
        r16.setStartDelay(700);
        r16.setDuration(300);
        r16.setInterpolator(new LinearInterpolator());
        if (KtvSettingHelper.z() == false) goto L62;
        ValueAnimator r17 = LiveDegradeFpsAnimator.ofFloat(this.d, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
    L63:
        r17.setStartDelay(700);
        r17.setDuration(300);
        r17.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L66;
        ValueAnimator r18 = LiveDegradeFpsAnimator.ofFloat(this.d, LiveDegradeFpsAnimator.SCALE_X, new float[]{2.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L67:
        ValueAnimator r19 = r14;
        r18.setStartDelay(700);
        r18.setDuration(300);
        String r110 = r6;
        r18.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L70;
        ValueAnimator r21 = LiveDegradeFpsAnimator.ofFloat(this.d, LiveDegradeFpsAnimator.SCALE_Y, new float[]{2.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L71:
        r21.setStartDelay(700);
        r21.setDuration(300);
        r21.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L74;
        ValueAnimator r25 = LiveDegradeFpsAnimator.ofFloat(this.g, LiveDegradeFpsAnimator.SCALE_X, new float[]{3.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L75:
        r25.setStartDelay(200);
        r25.setDuration(200);
        r25.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L78;
        int r26 = 2;
        ValueAnimator r27 = LiveDegradeFpsAnimator.ofFloat(this.g, LiveDegradeFpsAnimator.SCALE_Y, new float[]{3.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L79:
        r27.setStartDelay(200);
        r27.setDuration(200);
        r27.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L82;
        float[] r111 = new float[r26];
        r111 = {x0a4a: FILL_ARRAY_DATA  (LINE:50334282), data: [0, 1065353216} // fill-array;
        ValueAnimator r112 = LiveDegradeFpsAnimator.ofFloat(this.g, LiveDegradeFpsAnimator.ALPHA, r111).setFpsConfig(KtvSettingHelper.k());
    L83:
        ValueAnimator r113 = r15;
        ValueAnimator r114 = r112;
        r114.setStartDelay(200);
        r114.setDuration(200);
        r114.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.0f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L86;
        ValueAnimator r28 = LiveDegradeFpsAnimator.ofFloat(this.g, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
    L87:
        r28.setStartDelay(1800);
        r28.setDuration(200);
        r28.setInterpolator(new LinearInterpolator());
        if (KtvSettingHelper.z() == false) goto L90;
        ValueAnimator r115 = LiveDegradeFpsAnimator.ofFloat(this.a, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L91:
        ValueAnimator r116 = r115;
        r116.setDuration(200);
        r116.setInterpolator(new LinearInterpolator());
        if (KtvSettingHelper.z() == false) goto L94;
        ValueAnimator r29 = LiveDegradeFpsAnimator.ofFloat(this.a, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
    L95:
        r29.setStartDelay(2000);
        r29.setDuration(200);
        r29.setInterpolator(new LinearInterpolator());
        AnimatorSet r117 = new AnimatorSet();
        r117.playTogether(new Animator[]{r12, r13, r19, r25, r27, r114, r28, r113, r16, r17, r21, r18});
        Unit r31 = Unit.INSTANCE;
        this.e = r117;
        AnimatorSet r32 = new AnimatorSet();
        r32.playTogether(new Animator[]{r29, r116});
        this.f = r32;
        FrescoLoader.with(getContext()).load(r110).actualScaleType(ImageView.ScaleType.FIT_CENTER).controllerListener(e.a(this, new KtvMidiHitDisplayView$showAdvancedPerfectCombo$3(this))).into(this.a);
        FrescoLoader.with(getContext()).load(r3).actualScaleType(ImageView.ScaleType.FIT_CENTER).controllerListener(e.a(this, new KtvMidiHitDisplayView$showAdvancedPerfectCombo$4(this))).into(this.g);
        return;
    L94:
        r29 = ObjectAnimator.ofFloat(this.a, View.ALPHA, new float[]{1.0f, 0.0f});
        goto L95
    L90:
        r115 = ObjectAnimator.ofFloat(this.a, View.ALPHA, new float[]{0.0f, 1.0f});
        goto L91
    L86:
        r28 = ObjectAnimator.ofFloat(this.g, View.ALPHA, new float[]{1.0f, 0.0f});
        goto L87
    L82:
        float[] r118 = new float[r26];
        r118 = {x0a52: FILL_ARRAY_DATA  (LINE:50334290), data: [0, 1065353216} // fill-array;
        r112 = ObjectAnimator.ofFloat(this.g, View.ALPHA, r118);
        goto L83
    L78:
        r26 = 2;
        r27 = ObjectAnimator.ofFloat(this.g, View.SCALE_Y, new float[]{3.0f, 1.0f});
        goto L79
    L74:
        r25 = ObjectAnimator.ofFloat(this.g, View.SCALE_X, new float[]{3.0f, 1.0f});
        goto L75
    L70:
        r21 = ObjectAnimator.ofFloat(this.d, View.SCALE_Y, new float[]{2.0f, 1.0f});
        goto L71
    L66:
        r18 = ObjectAnimator.ofFloat(this.d, View.SCALE_X, new float[]{2.0f, 1.0f});
        goto L67
    L62:
        r17 = ObjectAnimator.ofFloat(this.d, View.ALPHA, new float[]{1.0f, 0.0f});
        goto L63
    L58:
        r16 = ObjectAnimator.ofFloat(this.d, View.ALPHA, new float[]{0.0f, 1.0f});
        goto L59
    L54:
        r15 = ObjectAnimator.ofFloat(this.c, View.ALPHA, new float[]{1.0f, 0.0f});
        goto L55
    L50:
        r14 = ObjectAnimator.ofFloat(this.c, View.SCALE_Y, new float[]{2.0f, 1.0f});
        goto L51
    L46:
        r13 = ObjectAnimator.ofFloat(this.c, View.SCALE_X, new float[]{2.0f, 1.0f});
        goto L47
    L42:
        r12 = ObjectAnimator.ofFloat(this.c, View.ALPHA, new float[]{0.0f, 1.0f});
        goto L43
    L198:
        return;
    L196:
        return;
    L97:
        if (r23 <= 1) goto L148;
        TextView r33 = this.c;
        if (r33 != null) goto L102;
        return;
    L102:
        if (this.b == null) goto L200;
        r33.setText("x" + r23);
        TextView r34 = this.c;
        if (r34 == null) goto L108;
        r34.setVisibility(0);
    L108:
        if (KtvSettingHelper.z() == false) goto L110;
        int r35 = 2;
        ValueAnimator r36 = LiveDegradeFpsAnimator.ofFloat(this.c, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L111:
        r36.setDuration(300);
        r36.setInterpolator(new LinearInterpolator());
        if (KtvSettingHelper.z() == false) goto L114;
        float[] r37 = new float[r35];
        r37 = {x0a9a: FILL_ARRAY_DATA  (LINE:50334362), data: [1073741824, 1065353216} // fill-array;
        ValueAnimator r38 = LiveDegradeFpsAnimator.ofFloat(this.c, LiveDegradeFpsAnimator.SCALE_X, r37).setFpsConfig(KtvSettingHelper.k());
    L115:
        r38.setDuration(300);
        r38.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L118;
        float[] r39 = new float[r35];
        r39 = {x0aaa: FILL_ARRAY_DATA  (LINE:50334378), data: [1073741824, 1065353216} // fill-array;
        ValueAnimator r41 = LiveDegradeFpsAnimator.ofFloat(this.c, LiveDegradeFpsAnimator.SCALE_Y, r39).setFpsConfig(KtvSettingHelper.k());
    L119:
        r41.setDuration(300);
        r41.setInterpolator(PathInterpolatorCompat.create(0.63f, 0.0f, 0.8f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L122;
        float[] r42 = new float[r35];
        r42 = {x0aba: FILL_ARRAY_DATA  (LINE:50334394), data: [1065353216, 1067869798} // fill-array;
        ValueAnimator r43 = LiveDegradeFpsAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.SCALE_X, r42).setFpsConfig(KtvSettingHelper.k());
    L123:
        r43.setStartDelay(150);
        r43.setDuration(90);
        r43.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L126;
        int r119 = 2;
        ValueAnimator r44 = LiveDegradeFpsAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.3f}).setFpsConfig(KtvSettingHelper.k());
    L127:
        r44.setStartDelay(150);
        r44.setDuration(90);
        r44.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L130;
        float[] r45 = new float[r119];
        r45 = {x0ada: FILL_ARRAY_DATA  (LINE:50334426), data: [1067869798, 1065353216} // fill-array;
        ValueAnimator r46 = LiveDegradeFpsAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.SCALE_X, r45).setFpsConfig(KtvSettingHelper.k());
    L131:
        r46.setStartDelay(270);
        r46.setDuration(80);
        r46.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L134;
        int r120 = 2;
        ValueAnimator r47 = LiveDegradeFpsAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L135:
        r47.setDuration(300);
        r47.setInterpolator(new LinearInterpolator());
        if (KtvSettingHelper.z() == false) goto L138;
        float[] r121 = new float[r120];
        r121 = {x0afa: FILL_ARRAY_DATA  (LINE:50334458), data: [1067869798, 1065353216} // fill-array;
        ValueAnimator r122 = LiveDegradeFpsAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.SCALE_Y, r121).setFpsConfig(KtvSettingHelper.k());
    L139:
        r122.setStartDelay(270);
        r122.setDuration(80);
        r122.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L142;
        float[] r123 = new float[r120];
        r123 = {x0b0a: FILL_ARRAY_DATA  (LINE:50334474), data: [1065353216, 0} // fill-array;
        ValueAnimator r124 = LiveDegradeFpsAnimator.ofFloat(this.c, LiveDegradeFpsAnimator.ALPHA, r123).setFpsConfig(KtvSettingHelper.k());
    L143:
        r124.setStartDelay(1300);
        r124.setDuration(200);
        r124.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L146;
        ValueAnimator r48 = LiveDegradeFpsAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
    L147:
        r48.setStartDelay(1300);
        r48.setDuration(200);
        r48.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        AnimatorSet r125 = new AnimatorSet();
        r125.playTogether(new Animator[]{r36, r38, r41, r43, r47, r44, r46, r122, r124, r48});
        Unit r49 = Unit.INSTANCE;
        this.e = r125;
        FrescoLoader.with(getContext()).load(r3).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(e.a(this, new KtvMidiHitDisplayView$showPerfectCombo$2(this))).into(this.b);
        return;
    L146:
        r48 = ObjectAnimator.ofFloat(this.b, View.ALPHA, new float[]{1.0f, 0.0f});
        goto L147
    L142:
        float[] r126 = new float[r120];
        r126 = {x0b12: FILL_ARRAY_DATA  (LINE:50334482), data: [1065353216, 0} // fill-array;
        r124 = ObjectAnimator.ofFloat(this.c, View.ALPHA, r126);
        goto L143
    L138:
        float[] r127 = new float[r120];
        r127 = {x0b02: FILL_ARRAY_DATA  (LINE:50334466), data: [1067869798, 1065353216} // fill-array;
        r122 = ObjectAnimator.ofFloat(this.b, View.SCALE_Y, r127);
        goto L139
    L134:
        r120 = 2;
        r47 = ObjectAnimator.ofFloat(this.b, View.ALPHA, new float[]{0.0f, 1.0f});
        goto L135
    L130:
        float[] r128 = new float[r119];
        r128 = {x0ae2: FILL_ARRAY_DATA  (LINE:50334434), data: [1067869798, 1065353216} // fill-array;
        r46 = ObjectAnimator.ofFloat(this.b, View.SCALE_X, r128);
        goto L131
    L126:
        r119 = 2;
        r44 = ObjectAnimator.ofFloat(this.b, View.SCALE_Y, new float[]{1.0f, 1.3f});
        goto L127
    L122:
        float[] r51 = new float[r35];
        r51 = {x0ac2: FILL_ARRAY_DATA  (LINE:50334402), data: [1065353216, 1067869798} // fill-array;
        r43 = ObjectAnimator.ofFloat(this.b, View.SCALE_X, r51);
        goto L123
    L118:
        float[] r52 = new float[r35];
        r52 = {x0ab2: FILL_ARRAY_DATA  (LINE:50334386), data: [1073741824, 1065353216} // fill-array;
        r41 = ObjectAnimator.ofFloat(this.c, View.SCALE_Y, r52);
        goto L119
    L114:
        float[] r53 = new float[r35];
        r53 = {x0aa2: FILL_ARRAY_DATA  (LINE:50334370), data: [1073741824, 1065353216} // fill-array;
        r38 = ObjectAnimator.ofFloat(this.c, View.SCALE_X, r53);
        goto L115
    L110:
        r35 = 2;
        r36 = ObjectAnimator.ofFloat(this.c, View.ALPHA, new float[]{0.0f, 1.0f});
        goto L111
    L200:
        return;
    L148:
        AnimatorSet r54 = this.e;
        if (r54 == null) goto L153;
        boolean r55 = true;
        if (r54.isRunning() == true) goto L201;
    L154:
        AnimatorSet r56 = this.f;
        if (r56 == null) goto L160;
        if (r56.isRunning() != r55) goto L160;
        return;
    L160:
        if (KtvSettingHelper.z() == false) goto L162;
        int r57 = 2;
        ValueAnimator r58 = LiveDegradeFpsAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L163:
        r58.setDuration(200);
        r58.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.0f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L166;
        float[] r59 = new float[r57];
        r59 = {x0b3a: FILL_ARRAY_DATA  (LINE:50334522), data: [1073741824, 1065353216} // fill-array;
        ValueAnimator r61 = LiveDegradeFpsAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.SCALE_X, r59).setFpsConfig(KtvSettingHelper.k());
    L167:
        r61.setDuration(200);
        r61.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        Unit r62 = Unit.INSTANCE;
        if (KtvSettingHelper.z() == false) goto L170;
        float[] r63 = new float[r57];
        r63 = {x0b4a: FILL_ARRAY_DATA  (LINE:50334538), data: [1073741824, 1065353216} // fill-array;
        ValueAnimator r64 = LiveDegradeFpsAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.SCALE_Y, r63).setFpsConfig(KtvSettingHelper.k());
    L171:
        r64.setDuration(200);
        r64.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        if (KtvSettingHelper.z() == false) goto L174;
        float[] r65 = new float[r57];
        r65 = {x0b5a: FILL_ARRAY_DATA  (LINE:50334554), data: [1065353216, 0} // fill-array;
        ValueAnimator r66 = LiveDegradeFpsAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.ALPHA, r65).setFpsConfig(KtvSettingHelper.k());
    L175:
        r66.setDuration(200);
        r66.setStartDelay(1500);
        r66.setInterpolator(new LinearInterpolator());
        AnimatorSet r67 = new AnimatorSet();
        r67.playTogether(new Animator[]{r64, r61, r58, r66});
        this.e = r67;
        FrescoLoader.with(getContext()).load(r3).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(e.a(this, new KtvMidiHitDisplayView$showPerfectHit$2(this))).into(this.b);
        AnimatorSet r68 = this.e;
        if (r68 == null) goto L193;
        r68.start();
        return;
    L193:
        return;
    L174:
        float[] r69 = new float[r57];
        r69 = {x0b62: FILL_ARRAY_DATA  (LINE:50334562), data: [1065353216, 0} // fill-array;
        r66 = ObjectAnimator.ofFloat(this.b, View.ALPHA, r69);
        goto L175
    L170:
        float[] r71 = new float[r57];
        r71 = {x0b52: FILL_ARRAY_DATA  (LINE:50334546), data: [1073741824, 1065353216} // fill-array;
        r64 = ObjectAnimator.ofFloat(this.b, View.SCALE_Y, r71);
        goto L171
    L166:
        float[] r72 = new float[r57];
        r72 = {x0b42: FILL_ARRAY_DATA  (LINE:50334530), data: [1073741824, 1065353216} // fill-array;
        r61 = ObjectAnimator.ofFloat(this.b, View.SCALE_X, r72);
        goto L167
    L162:
        r57 = 2;
        r58 = ObjectAnimator.ofFloat(this.b, View.ALPHA, new float[]{0.0f, 1.0f});
        goto L163
    L201:
        return;
    L153:
        r55 = true;
        goto L154
    L195:
        return;
    L178:
        AnimatorSet r73 = this.e;
        if (r73 == null) goto L183;
        boolean r74 = true;
        if (r73.isRunning() == true) goto L203;
    L184:
        AnimatorSet r75 = this.f;
        if (r75 != null) goto L187;
    L189:
        ObjectAnimator r76 = ObjectAnimator.ofFloat(this.b, View.ALPHA, new float[]{0.0f, 1.0f});
        r76.setDuration(200);
        r76.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.0f, 1.0f));
        Unit r77 = Unit.INSTANCE;
        ObjectAnimator r78 = ObjectAnimator.ofFloat(this.b, View.SCALE_X, new float[]{1.6f, 1.0f});
        r78.setDuration(200);
        r78.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        ObjectAnimator r129 = ObjectAnimator.ofFloat(this.b, View.SCALE_Y, new float[]{1.6f, 1.0f});
        r129.setDuration(200);
        r129.setInterpolator(PathInterpolatorCompat.create(0.18f, 0.0f, 0.0f, 1.0f));
        ObjectAnimator r79 = ObjectAnimator.ofFloat(this.b, View.ALPHA, new float[]{1.0f, 0.0f});
        r79.setDuration(200);
        r79.setStartDelay(1500);
        r79.setInterpolator(new LinearInterpolator());
        final Ref.ObjectRef r81 = new Ref.ObjectRef();
        AnimatorSet r82 = new AnimatorSet();
        r82.playTogether(new Animator[]{r129, r78, r76, r79});
        r81.element = r82;
        FrescoLoader.with(getContext()).load(r3).actualScaleType(ImageView.ScaleType.FIT_CENTER).controllerListener(e.a(this, new KtvMidiHitDisplayView$showGoodOrGreatHit$1(this, r81))).into(this.b);
        return;
    L187:
        if (r75.isRunning() != r74) goto L189;
        return;
    L203:
        return;
    L183:
        r74 = true;
        goto L184
    L11:
        r6 = null;
        goto L13
    }

    public /* synthetic */ KtvMidiHitDisplayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
