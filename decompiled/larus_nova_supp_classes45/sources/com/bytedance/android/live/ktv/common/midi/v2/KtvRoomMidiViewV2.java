package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView;
import com.bytedance.android.live.ktv.common.midi.KtvMidiHitDisplayView;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.facebook.drawee.view.SimpleDraweeView;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/v2/KtvRoomMidiViewV2;", "Lcom/bytedance/android/live/ktv/common/midi/AbsKtvMidiView;", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "config", "", "setConfig", "", "v", "Z", "getEnableFontScale", "()Z", "enableFontScale", "Lqb0/c;", "getMidiHit", "()Lqb0/c;", "midiHit", "Lqb0/b;", "getMidiLine", "()Lqb0/b;", "midiLine", "Lqb0/a;", "getMidiHitDisplay", "()Lqb0/a;", "midiHitDisplay", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomMidiViewV2 extends AbsKtvMidiView {
    public static final /* synthetic */ int w = 0;
    public final float c;
    public ImageView d;
    public KtvMidiHitDisplayView e;
    public TextView f;
    public KtvMidiViewV2 g;
    public KtvHitAnimationViewV2 h;
    public TextView i;
    public HSImageView j;
    public Animator k;
    public Animator l;
    public float m;
    public long n;
    public int o;
    public final int p;
    public final int q;
    public boolean r;
    public int s;
    public final d t;
    public MidiSkinDressInfo u;
    public final boolean v;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ KtvRoomMidiViewV2 a;

        public b(KtvRoomMidiViewV2 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            KtvRoomMidiViewV2 r0 = this.a;
            int r1 = KtvRoomMidiViewV2.w;
            if (r0.V5() == false) goto L13;
            KtvRoomMidiViewV2 r2 = this.a;
            ImageView r3 = r2.d;
            MidiSkinDressInfo r5 = r2.u;
            if (r5 == null) goto L11;
            MidiSkinMaterial r6 = r5.getMaterial();
            if (r6 == null) goto L11;
            BackgroundMaterial r7 = r6.getBg();
            if (r7 == null) goto L11;
            k r8 = r7.getScoreboardBg();
        L12:
            ImageUtil.loadImage(r3, r8, 0);
        L16:
            super.onAnimationStart(r4);
            return;
        L11:
            r8 = null;
            goto L12
        L13:
            ImageView r9 = this.a.d;
            if (r9 == null) goto L16;
            r9.setImageResource(2131252088);
            goto L16
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ KtvRoomMidiViewV2 a;

        public c(KtvRoomMidiViewV2 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            ImageView r0 = this.a.d;
            if (r0 == null) goto L5;
            r0.setImageResource(2131252089);
        L5:
            super.onAnimationStart(r3);
        }
    }

    static {
    }

    public KtvRoomMidiViewV2(Context r7) {
        this(r7, null, 0, false, 14);
    }

    public KtvRoomMidiViewV2(Context r7, AttributeSet r8) {
        this(r7, r8, 0, false, 12);
    }

    public KtvRoomMidiViewV2(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, false, 8);
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void R5() {
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void U5(long r1, long r3) {
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void onResume() {
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public void setConfig(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void A1() {
        Animator r0 = this.k;
        if (r0 != null) goto L5;
    L9:
        Animator r1 = this.l;
        if (r1 != null) goto L12;
    L16:
        this.r = false;
        SimpleDraweeView r2 = this.j;
        if (r2 == null) goto L20;
        r2.setVisibility(8);
        return;
    L20:
        return;
    L12:
        if (r1.isRunning() != true) goto L16;
        Animator r3 = this.l;
        if (r3 == null) goto L16;
        r3.cancel();
        goto L16
    L5:
        if (r0.isRunning() != true) goto L9;
        Animator r4 = this.k;
        if (r4 == null) goto L9;
        r4.cancel();
        goto L9
    }

    public final boolean V5() {
        MidiSkinDressInfo r0 = this.u;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getDressId();
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        MidiSkinDressInfo r3 = this.u;
        if (r3 == null) goto L12;
        r1 = r3.getDressId();
    L12:
        if ((!Intrinsics.areEqual(r1, "0")) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void reset() {
        TextView r0 = this.i;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        TextView r1 = this.f;
        if (r1 == null) goto L8;
        r1.setText("评分");
    L8:
        ImageView r2 = this.d;
        if (r2 == null) goto L11;
        r2.setImageResource(2131252089);
    L11:
        this.r = false;
        this.m = 0.0f;
        qb0.b r3 = getMidiLine();
        if (r3 == null) goto L14;
        r3.clear();
    L14:
        this.o = -1;
        this.s = 0;
        Animator r4 = this.k;
        if (r4 != null) goto L17;
    L21:
        Animator r5 = this.l;
        if (r5 != null) goto L24;
    L28:
        SimpleDraweeView r6 = this.j;
        if (r6 == null) goto L32;
        r6.setVisibility(8);
        return;
    L32:
        return;
    L24:
        if (r5.isRunning() != true) goto L28;
        Animator r7 = this.l;
        if (r7 == null) goto L28;
        r7.cancel();
        goto L28
    L17:
        if (r4.isRunning() != true) goto L21;
        Animator r8 = this.k;
        if (r8 == null) goto L21;
        r8.cancel();
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void onDetach() {
        reset();
        KtvHitAnimationViewV2 r0 = this.h;
        if (r0 == null) goto L10;
        KtvHitAnimationViewV2.d r1 = r0.b;
        if (r1 == null) goto L7;
        r1.clear();
    L7:
        KtvHitAnimationViewV2.d r2 = r0.a;
        if (r2 == null) goto L10;
        r2.clear();
    L10:
        KtvMidiHitDisplayView r3 = this.e;
        if (r3 == null) goto L13;
        r3.onDetach();
    L13:
        qb0.b r4 = getMidiLine();
        if (r4 == null) goto L16;
        r4.detach();
    L16:
        d r5 = this.t;
        if (r5 == null) goto L19;
        r5.clear();
    L19:
        setVisibility(8);
    }

    private final qb0.c getMidiHit() {
        return this.h;
    }

    private final qb0.a getMidiHitDisplay() {
        return this.e;
    }

    private final qb0.b getMidiLine() {
        return this.g;
    }

    public final boolean getEnableFontScale() {
        return this.v;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void R2(long r2) {
        qb0.b r0 = getMidiLine();
        if (r0 == null) goto L5;
        r0.show();
    L5:
        qb0.b r1 = getMidiLine();
        if (r1 == null) goto L9;
        r1.D3(r2);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void T5(db0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        qb0.b r0 = getMidiLine();
        if (r0 == null) goto L5;
        r0.f0(r3, this.t);
    L5:
        qb0.b r4 = getMidiLine();
        if (r4 == null) goto L9;
        r4.setScoreInterval(vm2.h.D());
        return;
    }

    public final void Y5(boolean r3) {
        TextView r0 = this.i;
        if (r0 == null) goto L8;
        if (r3 == false) goto L6;
        int r1 = 0;
    L7:
        r0.setVisibility(r1);
        goto L8
    L6:
        r1 = 8;
    L8:
        if (r3 == false) goto L12;
        qb0.b r4 = getMidiLine();
        if (r4 == null) goto L16;
        r4.show();
        return;
    L16:
        return;
    L12:
        qb0.b r5 = getMidiLine();
        if (r5 == null) goto L18;
        r5.hide();
        return;
    }

    public final void Z5(com.bytedance.android.live.ktv.common.midi.k r4) {
        Intrinsics.checkNotNullParameter(r4, "scoreInfo");
        int r0 = this.o;
        int r1 = r4.e;
        if (r0 == r1) goto L8;
        if (r4.d <= 0) goto L8;
        if (r1 < 0) goto L8;
    L10:
        if (r4.d == 0.0f) goto L12;
        return;
    L12:
        if (r4.h == false) goto L22;
        TextView r5 = this.f;
        if (r5 == null) goto L16;
        r5.setText(s1.B(2131918567));
    L16:
        qb0.b r6 = getMidiLine();
        if (r6 == null) goto L23;
        r6.clear();
        return;
    L23:
        return;
    L22:
        return;
    L8:
        if (r4.h == true) goto L10;
    }

    public final void b6(boolean r12) {
        ImageView r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r12 == false) goto L8;
        Intrinsics.checkNotNull(r0);
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this.j, View.TRANSLATION_X, new float[]{0.0f, 0 - r0.getX()});
        r13.setDuration(500);
        r13.setInterpolator(PathInterpolatorCompat.create(0.07f, 0.0f, 0.43f, 1.0f));
        r13.addListener(new b(this));
        r13.start();
        return;
    L8:
        Intrinsics.checkNotNull(r0);
        ObjectAnimator r14 = ObjectAnimator.ofFloat(this.j, View.TRANSLATION_X, new float[]{0.0f, 0 - r0.getX()});
        r14.setDuration(500);
        r14.setInterpolator(PathInterpolatorCompat.create(0.07f, 0.0f, 0.43f, 1.0f));
        r14.addListener(new c(this));
        r14.start();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void xc(Pair<Integer, Integer> r3) {
        if (r3 == null) goto L7;
        qb0.b r0 = getMidiLine();
        if (r0 == null) goto L8;
        r0.D5(((Number) r3.getFirst()).intValue(), ((Number) r3.getSecond()).intValue());
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void y(MidiSkinDressInfo r3) {
        this.u = r3;
        this.t.y(r3);
        qb0.b r0 = getMidiLine();
        if (r0 == null) goto L6;
        r0.y(r3);
    L6:
        if (V5() == true) goto L8;
        return;
    L8:
        if (this.m <= this.c) goto L30;
        MidiSkinDressInfo r4 = this.u;
        if (r4 == null) goto L31;
        MidiSkinMaterial r5 = r4.getMaterial();
        if (r5 == null) goto L32;
        BackgroundMaterial r6 = r5.getBg();
        if (r6 == null) goto L33;
        k r7 = r6.getScoreboardBg();
        if (r7 != null) goto L18;
        return;
    L18:
        if (r7.isValid() != true) goto L35;
        ImageView r8 = this.d;
        MidiSkinDressInfo r1 = this.u;
        if (r1 == null) goto L26;
        MidiSkinMaterial r2 = r1.getMaterial();
        if (r2 == null) goto L26;
        BackgroundMaterial r9 = r2.getBg();
        if (r9 == null) goto L26;
        k r11 = r9.getScoreboardBg();
    L27:
        ImageUtil.loadImage(r8, r11, 0);
        return;
    L26:
        r11 = null;
        goto L27
    L35:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void S5(com.bytedance.android.live.ktv.common.midi.k r17, Long r18) {
        Intrinsics.checkNotNullParameter(r17, "scoreInfo");
        if (r18 == null) goto L7;
        qb0.b r2 = getMidiLine();
        if (r2 == null) goto L7;
        r2.J3(r18.longValue());
    L7:
        qb0.b r5 = getMidiLine();
        if (r5 == null) goto L11;
        Pair r3 = qb0.b.a.a(r5, r17.a, r17.b, 0.0f, r17.h, false, 20);
        if (r3 == null) goto L11;
    L12:
        int r4 = this.o;
        int r6 = r17.e;
        if (r4 == r6) goto L18;
        if (r17.d <= 0) goto L18;
        if (r6 < 0) goto L18;
    L19:
        Integer r7 = r17.f;
        if (r7 == null) goto L22;
        int r8 = r7.intValue();
    L23:
        int r9 = r17.g;
        com.bytedance.android.live.ktv.common.midi.e.b("KtvRoomMidiViewV2", "showHitAnimation hitType " + r8 + " comboCount " + r9);
        if (r8 == 3) goto L26;
    L30:
        if (r8 != 3) goto L32;
    L36:
        qb0.a r11 = getMidiHitDisplay();
        if (r11 == null) goto L40;
        r11.C4(r8, r9, this.r);
    L40:
        if (this.r == false) goto L61;
        Animator r12 = this.k;
        if (r12 != null) goto L44;
    L45:
        Animator r13 = this.l;
        if (r13 != null) goto L48;
    L49:
        ObjectAnimator r14 = ObjectAnimator.ofFloat(this.j, View.ALPHA, new float[]{0.0f, 1.0f});
        r14.setDuration(500);
        r14.setInterpolator(new LinearInterpolator());
        r14.addListener(new e(this));
        Unit r15 = Unit.INSTANCE;
        this.k = r14;
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.j, View.ALPHA, new float[]{1.0f, 0.0f});
        r16.setDuration(500);
        r16.setInterpolator(new LinearInterpolator());
        r16.addListener(new f(this));
        this.l = r16;
        if (V5() == false) goto L60;
        FrescoLoader r19 = FrescoLoader.with(getContext());
        MidiSkinDressInfo r21 = this.u;
        if (r21 == null) goto L58;
        MidiSkinMaterial r22 = r21.getMaterial();
        if (r22 == null) goto L58;
        BackgroundMaterial r23 = r22.getBg();
        if (r23 == null) goto L58;
        k r24 = r23.getGlobalBg();
    L59:
        r19.load(r24).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvRoomMidiViewV2$playMidiBgAnimation$3(this))).into(this.j);
    L75:
        float r25 = this.m;
        float r26 = r17.d;
        boolean r110 = r17.h;
        if (r26 != 0.0f) goto L85;
        if (r110 == false) goto L85;
        TextView r111 = this.f;
        if (r111 == null) goto L81;
        r111.setText(s1.B(2131918567));
    L81:
        qb0.b r112 = getMidiLine();
        if (r112 == null) goto L85;
        r112.clear();
    L85:
        if (r25 != r26) goto L87;
    L100:
        this.o = r17.e;
        Integer r27 = r17.f;
        if (r27 == null) goto L103;
        int r113 = r27.intValue();
    L104:
        if (r113 <= 0) goto L106;
        Integer r28 = r17.f;
        Intrinsics.checkNotNull(r28);
        this.s = r28.intValue();
    L106:
        float r29 = r17.a;
        float r31 = 0;
        if (r29 <= r31) goto L121;
        float r1 = r17.b;
        if (r1 > r31) goto L111;
        return;
    L111:
        if (Math.abs(r29 - r1) > this.q) goto L123;
        qb0.b r32 = getMidiLine();
        if (r32 == null) goto L115;
        r32.S3();
    L115:
        long r33 = this.n % ((long) this.p);
        this.n = 1 + r33;
        if (r33 != 0) goto L124;
        qb0.c r34 = getMidiHit();
        if (r34 == null) goto L125;
        qb0.c.a.a(r34, ((Number) r3.getFirst()).floatValue(), ((Number) r3.getSecond()).floatValue(), Integer.valueOf(this.s), this.r);
        return;
    L125:
        return;
    L124:
        return;
    L123:
        return;
    L121:
        return;
    L103:
        r113 = 0;
        goto L104
    L87:
        if (r26 <= 0) goto L100;
        float r114 = this.m;
        float r115 = this.c;
        if (r114 < r115) goto L92;
    L94:
        float r116 = this.c;
        if (r25 >= r116) goto L97;
    L99:
        this.m = r26;
        ObjectAnimator r117 = ObjectAnimator.ofFloat(this.f, View.SCALE_X, new float[]{1.0f, 1.3f});
        r117.setDuration(280);
        r117.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        Unit r35 = Unit.INSTANCE;
        ObjectAnimator r36 = ObjectAnimator.ofFloat(this.f, View.SCALE_Y, new float[]{1.0f, 1.3f});
        r36.setDuration(280);
        r36.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        ObjectAnimator r37 = ObjectAnimator.ofFloat(this.f, View.SCALE_X, new float[]{1.3f, 1.0f});
        r37.setStartDelay(480);
        r37.setDuration(120);
        r37.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        ObjectAnimator r38 = ObjectAnimator.ofFloat(this.f, View.SCALE_Y, new float[]{1.3f, 1.0f});
        r38.setStartDelay(480);
        r38.setDuration(120);
        r38.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        ValueAnimator r39 = ValueAnimator.ofFloat(new float[]{r25, r26});
        r39.setDuration(280);
        r39.setInterpolator(new LinearInterpolator());
        r39.setEvaluator(new h());
        r39.addUpdateListener(new g(new DecimalFormat("#.#"), this, r110));
        AnimatorSet r41 = new AnimatorSet();
        r41.playTogether(new Animator[]{r117, r36, r37, r38, r39});
        r41.start();
        goto L100
    L97:
        if (r26 >= r116) goto L99;
        b6(false);
        goto L99
    L92:
        if (r26 < r115) goto L94;
        b6(true);
    L58:
        r24 = null;
        goto L59
    L60:
        FrescoLoader.with(getContext()).load(com.bytedance.android.live.ktv.common.midi.c.b).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvRoomMidiViewV2$playMidiBgAnimation$4(this))).into(this.j);
        goto L75
    L48:
        if (r13.isRunning() == true) goto L75;
    L44:
        if (r12.isRunning() == true) goto L75;
    L61:
        Animator r42 = this.k;
        if (r42 != null) goto L64;
    L65:
        Animator r43 = this.l;
        if (r43 == null) goto L75;
        if (r43.isRunning() != true) goto L75;
    L69:
        Animator r44 = this.k;
        if (r44 == null) goto L72;
        r44.end();
    L72:
        Animator r45 = this.l;
        if (r45 == null) goto L75;
        r45.end();
        goto L75
    L64:
        if (r42.isRunning() == true) goto L69;
    L32:
        if (this.r == false) goto L36;
        if (r9 >= vm2.h.x()) goto L36;
        this.r = false;
        goto L36
    L26:
        if (this.r == true) goto L30;
        if (r9 < vm2.h.x()) goto L30;
        this.r = true;
        goto L36
    L22:
        r8 = 0;
    L18:
        if (r17.h == false) goto L106;
    L11:
        r3 = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvRoomMidiViewV2(Context r3, AttributeSet r4, int r5, boolean r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = false;
    L11:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.v = r6;
        this.c = vm2.h.z();
        this.o = -1;
        this.p = vm2.h.G();
        this.q = vm2.h.I();
        d r8 = new d();
        this.t = r8;
        if (r6 == false) goto L14;
        int r9 = 2131566676;
    L15:
        LayoutInflater.from(r3).inflate(r9, this);
        this.g = (KtvMidiViewV2) findViewById(2131380109);
        this.h = (KtvHitAnimationViewV2) findViewById(2131374430);
        KtvMidiHitDisplayView r11 = (KtvMidiHitDisplayView) findViewById(2131374432);
        this.e = r11;
        Intrinsics.checkNotNull(r11);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r8, "strategy");
        r11.h = r8;
        this.d = (ImageView) findViewById(2131380106);
        this.f = (TextView) findViewById(2131380105);
        this.i = (TextView) findViewById(2131377034);
        this.j = (HSImageView) findViewById(2131376979);
        qb0.c r12 = getMidiHit();
        if (r12 == null) goto L18;
        r12.b(r8);
    L18:
        qb0.c r13 = getMidiHit();
        if (r13 == null) goto L22;
        r13.setAnimGap(0);
        return;
    L22:
        return;
    L14:
        r9 = 2131566675;
        goto L15
    }
}
