package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import android.content.Context;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.larksuite.framework.utils.UIUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceBubbleMotionScene {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final a c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final long l;
    public final LinearInterpolator m;
    public final Interpolator n;
    public boolean o;
    public final b p;
    public final b q;
    public final b r;

    public final void d(final int r9, int r10) {
        a r0 = this.c;
        r0.o().getBackground().setTint(r10);
        r0.b().getBackground().setTint(r10);
        c r1 = new c(this.a);
        final int r11 = this.c.s().getId();
        final int r2 = this.c.o().getId();
        final int r3 = this.c.b().getId();
        if (this.c.p().getVisibility() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        c.a(r1, this.a, new VoiceBubbleMotionScene$secondVoiceInputSetContainer$2$1(r2, r3, this));
    L8:
        c.a(r1, this.b, new VoiceBubbleMotionScene$secondVoiceInputSetContainer$2$2(r11, r9, this));
        c.c(r1, null, null, 0, null, 15);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public VoiceBubbleMotionScene(ConstraintLayout r5, ConstraintLayout r6, a r7) {
        Intrinsics.checkNotNullParameter(r5, "rootContainer");
        Intrinsics.checkNotNullParameter(r6, "bubbleContainer");
        Intrinsics.checkNotNullParameter(r7, "viewFinder");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        Context r8 = r5.getContext();
        this.d = UIUtils.dp2px(r8, 10.0f);
        this.e = UIUtils.dp2px(r8, 12.0f);
        this.f = UIUtils.dp2px(r8, 18.0f);
        this.g = UIUtils.dp2px(r8, 20.0f);
        this.h = UIUtils.dp2px(r8, 22.0f);
        this.i = UIUtils.dp2px(r8, 36.0f);
        this.j = UIUtils.dp2px(r8, 80.0f);
        this.k = UIUtils.dp2px(r8, 14.0f);
        int r9 = UIUtils.dp2px(r8, 186.0f);
        this.l = 150;
        this.m = new LinearInterpolator();
        this.n = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        this.o = true;
        b r10 = new b(2131364936, "releaseSend");
        r10.h();
        r10.i();
        r10.u(2131365131);
        r10.o(2131383922);
        r10.c(2131392735);
        r10.a(r9);
        this.p = r10;
        b r11 = new b(2131364936, "releaseCancel");
        r11.j();
        r11.g();
        r11.p(2131365131);
        r11.q(2131365131);
        r11.c(2131392735);
        r11.a(r9);
        this.q = r11;
        b r12 = new b(2131364936, "voiceWithAsr");
        r12.j();
        r12.g();
        r12.p(2131383922);
        r12.q(2131383922);
        r12.c(2131392735);
        r12.a(r9);
        this.r = r12;
    }

    public final void e(final boolean r8, boolean r9, final Integer r10, final boolean r11) {
        c r0 = new c(this.a);
        c.a(r0, this.b, new VoiceBubbleMotionScene$voiceWaveAndElapseTransition$1$1(r10, r8, r11, this));
        r0.b(new VoiceBubbleMotionScene$voiceWaveAndElapseTransition$1$2(r10, this, r11));
        c.c(r0, null, null, 250, this.n, 3);
        if (r9 == false) goto L6;
        this.a.requestLayout();
        return;
    }

    public static void a(final VoiceBubbleMotionScene r13, final AppCompatTextView r14, final b r15, final int r16, int r17, final int r18, final int r19, final Function0 r20) {
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "anchor");
        Intrinsics.checkNotNullParameter(r15, "anchorConstraint");
        a r1 = r13.c;
        r1.o().getBackground().setTint(r17);
        r1.b().getBackground().setTint(r17);
        c r10 = new c(r13.a);
        final int r2 = r13.c.o().getId();
        final int r3 = r13.c.b().getId();
        c.a(r10, r13.a, new VoiceBubbleMotionScene$motion2AsrIfNeed$2$1(r2, r3, r15, r18, r19, r13, r14));
        final int r0 = r13.c.s().getId();
        c.a(r10, r13.b, new VoiceBubbleMotionScene$motion2AsrIfNeed$2$2(r0, r16, r13));
        r10.b(new VoiceBubbleMotionScene$motion2AsrIfNeed$2$3(r13, r14, r18, r19));
        c.c(r10, null, new VoiceBubbleMotionScene$motion2AsrIfNeed$2$4(r13, r20), 0, null, 13);
    }

    public static /* synthetic */ void c(VoiceBubbleMotionScene r9, AppCompatTextView r10, b r11, int r12, int r13, int r14, int r15, int r16) {
        r9.b(r10, r11, r12, r13, r14, r15, r16, null);
    }

    public final void b(final AppCompatTextView r17, final b r18, final int r19, final int r20, int r21, final int r22, final int r23, final Function0<Unit> r24) {
        Intrinsics.checkNotNullParameter(r17, "anchor");
        Intrinsics.checkNotNullParameter(r18, "anchorConstraint");
        a r1 = this.c;
        r1.o().getBackground().setTint(r21);
        r1.b().getBackground().setTint(r21);
        final int r11 = this.c.b().getId();
        final int r12 = this.c.s().getId();
        final int r2 = this.c.o().getId();
        c r13 = new c(this.a);
        c.a(r13, this.a, new VoiceBubbleMotionScene$recordingOrCancel$2$1(r2, r11, r18, r22, r23, r19, this, r17));
        c.a(r13, this.b, new VoiceBubbleMotionScene$recordingOrCancel$2$2(r12, r20, this));
        r13.b(new VoiceBubbleMotionScene$recordingOrCancel$2$3(this, r11, r17, r22, r23));
        c.c(r13, null, new VoiceBubbleMotionScene$recordingOrCancel$2$4(r24), 0, null, 13);
    }
}
