package com.bytedance.android.live.ktv.common.midi;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.model.api.q0;
import com.bytedance.android.live.ktv.common.util.p;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/KtvRoomMidiView;", "Lcom/bytedance/android/live/ktv/common/midi/AbsKtvMidiView;", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "config", "", "setConfig", "Landroid/view/animation/AnimationSet;", "t", "Lkotlin/Lazy;", "getScoreHitAnimationSet", "()Landroid/view/animation/AnimationSet;", "scoreHitAnimationSet", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomMidiView extends AbsKtvMidiView {
    public View c;
    public HSImageView d;
    public TextView e;
    public KtvMidiView f;
    public ImageView g;
    public KtvHitAnimationView h;
    public TextView i;
    public KtvComponentProgressView j;
    public m k;
    public final AnimatorSet l;
    public long m;
    public int n;
    public final int o;
    public final int p;
    public g0 q;
    public ObjectAnimator r;
    public boolean s;
    public final Lazy t;

    public static final class a implements Runnable {
        public final /* synthetic */ KtvRoomMidiView a;
        public final /* synthetic */ int b;

        public a(KtvRoomMidiView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KtvHitAnimationView r0 = this.a.h;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.b(this.b + s1.e(27.0f), true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public KtvRoomMidiView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvRoomMidiView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final AnimationSet getScoreHitAnimationSet() {
        return (AnimationSet) this.t.getValue();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void onResume() {
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void A1() {
        KtvComponentProgressView r0 = this.j;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void R5() {
        View r0 = this.c;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void reset() {
        TextView r0 = this.i;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        ImageView r1 = this.g;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        TextView r2 = this.e;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        TextView r3 = this.e;
        if (r3 == null) goto L14;
        r3.setText("");
    L14:
        KtvComponentProgressView r4 = this.j;
        if (r4 == null) goto L17;
        r4.setProgress(100.0f);
    L17:
        ObjectAnimator r5 = this.r;
        if (r5 == null) goto L20;
        r5.cancel();
    L20:
        KtvMidiView r6 = this.f;
        if (r6 == null) goto L23;
        ((KSongToneLinesView) r6.a(2131389045)).a();
        r6.c(0.0f);
    L23:
        m r7 = this.k;
        if (r7 == null) goto L32;
        r7.a.setCurrentText("0.0分");
        View r8 = r7.a.getNextView();
        if ((r8 instanceof TextView) == true) goto L28;
        r8 = null;
    L28:
        TextView r9 = (TextView) r8;
        if (r9 == null) goto L31;
        r9.setText("0.0分");
    L31:
        r7.a.setVisibility(8);
    L32:
        AnimatorSet r11 = this.l;
        if (r11 != null) goto L35;
        return;
    L35:
        if (r11.isStarted() != true) goto L41;
        AnimatorSet r12 = this.l;
        if (r12 == null) goto L42;
        r12.end();
        return;
    L42:
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
        ALogger.i("KtvRoomMidiView", "onAttachedToWindow");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void onDetach() {
        reset();
        KtvMidiView r0 = this.f;
        if (r0 == null) goto L5;
        r0.c = null;
    L5:
        setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.s = false;
        ALogger.i("KtvRoomMidiView", "onDetachedFromWindow");
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void R2(long r3) {
        KtvMidiView r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L15;
        r0.b(r3);
        return;
    L15:
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void T5(db0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        KtvMidiView r0 = this.f;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "midiDataHolder");
        r0.c = r3;
    L5:
        KtvMidiView r4 = this.f;
        if (r4 == null) goto L9;
        r4.setScoreInterval(vm2.h.D());
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public void setConfig(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.q = r2;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void xc(Pair<Integer, Integer> r4) {
        if (r4 == null) goto L7;
        KtvMidiView r0 = this.f;
        if (r0 == null) goto L8;
        int r1 = ((Number) r4.getFirst()).intValue();
        int r5 = ((Number) r4.getSecond()).intValue();
        r0.f = r1;
        r0.g = r5;
        KSongToneLinesView r2 = (KSongToneLinesView) r0.a(2131389045);
        r2.g = r1;
        r2.h = r5;
        r2.m = r2.n / (r5 - r1);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void S5(k r13, Long r14) {
        Intrinsics.checkNotNullParameter(r13, "scoreInfo");
        if (this.s == true) goto L5;
        return;
    L5:
        if (r14 == null) goto L9;
        KtvMidiView r0 = this.f;
        if (r0 == null) goto L9;
        r0.b = r14.longValue();
    L9:
        KtvMidiView r15 = this.f;
        if (r15 == null) goto L12;
        int r16 = r15.c(r13.a);
    L13:
        m r1 = this.k;
        if (r1 == null) goto L16;
        r1.a.setVisibility(0);
    L16:
        int r2 = this.n;
        int r3 = r13.e;
        if (r2 == r3) goto L24;
        float r6 = 0;
        if (r13.c < r6) goto L24;
        if (r13.d <= r6) goto L24;
        if (r3 < 1) goto L24;
    L25:
        float r4 = r13.c;
        Integer r5 = r13.f;
        g0 r7 = this.q;
        AnimatorSet r8 = null;
        if (r7 == null) goto L28;
        Map<String, q0> r9 = r7.b();
    L29:
        Map<String, q0> r11 = p.a;
        if (r5 != null) goto L32;
        if (r9 != null) goto L42;
        r9 = p.b;
    L42:
        Iterator<Map.Entry<String, q0>> r12 = r9.entrySet().iterator();
    L44:
        if (r12.hasNext() == false) goto L54;
        Map.Entry<String, q0> r17 = r12.next();
        Long r18 = r17.getValue().a();
        Long r19 = r17.getValue().b();
        if (r18 == null) goto L44;
        if (r19 == null) goto L44;
        if (r4 > r18.longValue()) goto L44;
        if (r4 < r19.longValue()) goto L44;
        Integer r21 = p.c.get(r17.getKey());
    L55:
        ImageView r22 = this.g;
        if (r22 == null) goto L68;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L67;
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        float r25 = r16;
        if (r25 > s1.e(6.5f)) goto L62;
        r24.bottomMargin = (int) (s1.e(19.0f) - r25);
    L63:
        r22.clearAnimation();
        if (r21 == null) goto L68;
        r21.intValue();
        r22.setImageResource(r21.intValue());
        r22.startAnimation(getScoreHitAnimationSet());
        goto L68
    L62:
        r24.bottomMargin = (int) (s1.e(63.0f) - r25);
        goto L63
    L67:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L68:
        String r26 = new DecimalFormat("#.#").format(Float.valueOf(r13.d));
        m r27 = this.k;
        if (r27 == null) goto L71;
        String r28 = r26 + 20998;
        Intrinsics.checkNotNullParameter(r28, "score");
        ValueAnimator r29 = ValueAnimator.ofInt(new int[]{0, 1});
        r29.setDuration(350);
        r29.setStartDelay(0);
        r29.addListener(new l(r27, r28));
        r8 = new AnimatorSet();
        r8.play(r29);
    L71:
        this.l.play(r8);
        this.l.start();
        this.n = r13.e;
    L72:
        float r31 = r13.a;
        float r32 = 0;
        if (r31 <= r32) goto L97;
        float r110 = r13.b;
        if (r110 > r32) goto L77;
        return;
    L77:
        if (Math.abs(r31 - r110) > this.p) goto L99;
        KtvMidiView r111 = this.f;
        if (r111 == null) goto L81;
        r111.d();
    L81:
        long r33 = this.m % ((long) this.o);
        this.m = 1 + r33;
        if (r33 != 0) goto L100;
        KtvHitAnimationView r112 = this.h;
        if (r112 == null) goto L101;
        r112.post(new a(this, r16));
        return;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L97:
        return;
    L54:
        r21 = null;
        goto L55
    L32:
        if (r5.intValue() != 1) goto L35;
        r21 = p.c.get("Good");
        goto L55
    L35:
        if (r5.intValue() != 2) goto L38;
        r21 = p.c.get("Great");
        goto L55
    L38:
        if (r5.intValue() != 3) goto L54;
        r21 = p.c.get("Perfect");
        goto L55
    L28:
        r9 = null;
    L24:
        if (r13.h == false) goto L72;
    L12:
        r16 = 0;
        goto L13
    }

    @Override // com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView
    public final void U5(long r3, long r5) {
        KtvComponentProgressView r0 = this.j;
        if (r0 == null) goto L12;
        ValueAnimator r1 = r0.g;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 != true) goto L12;
        return;
    L7:
        if (r1.isRunning() != true) goto L9;
        r2 = true;
    L12:
        KtvComponentProgressView r4 = this.j;
        if (r4 == null) goto L15;
        r4.setProgress(0.0f);
    L15:
        KtvComponentProgressView r6 = this.j;
        if (r6 == null) goto L19;
        r6.c(r3, r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvRoomMidiView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.l = new AnimatorSet();
        this.o = vm2.h.F();
        this.p = vm2.h.I();
        this.s = true;
        LayoutInflater.from(r3).inflate(2131566674, this);
        this.f = (KtvMidiView) findViewById(2131380109);
        this.g = (ImageView) findViewById(2131370482);
        this.h = (KtvHitAnimationView) findViewById(2131374430);
        SimpleDraweeView r6 = findViewById(2131376969);
        this.c = findViewById(2131376968);
        this.d = (HSImageView) findViewById(2131376970);
        this.e = (TextView) findViewById(2131376971);
        this.i = (TextView) findViewById(2131377034);
        this.j = (KtvComponentProgressView) findViewById(2131377040);
        this.k = new m(this);
        KtvComponentProgressView r7 = this.j;
        if (r7 == null) goto L5;
        r7.setProgress(100.0f);
    L5:
        KtvHitAnimationView r8 = this.h;
        if (r8 == null) goto L8;
        r8.setAnimGap(0);
    L8:
        HSImageView r9 = this.d;
        if (r9 == null) goto L16;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r9, LiveDegradeFpsAnimator.ROTATION, new float[]{0.0f, 360.0f}).setDuration(2000);
        this.r = r11;
        if (r11 == null) goto L13;
        r11.setRepeatMode(1);
    L13:
        ObjectAnimator r12 = this.r;
        if (r12 == null) goto L16;
        r12.setRepeatCount(-1);
    L16:
        this.t = InfraKotlinExtsKt.mainThreadLazy(new KtvRoomMidiView$scoreHitAnimationSet$2(this));
    }

    public /* synthetic */ KtvRoomMidiView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
