package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.VoiceBubbleMotionScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceBubbleAreaUseCase {
    public static final /* synthetic */ int y = 0;
    public final ConstraintLayout a;
    public final Fragment b;
    public final VoiceImeWrapperUseCase c;
    public final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a d;
    public final String e;
    public final Lazy f;
    public final ConstraintSet g;
    public final ConstraintSet h;
    public final Lazy i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public SpannableStringUtils.a u;
    public final AudioAsrLanguageSwitcher v;
    public final VoiceBubbleMotionScene w;
    public final Lazy x;

    public static final class a {
    }

    static {
    }

    public final ImmersiveVoiceViewModel f() {
        return (ImmersiveVoiceViewModel) this.x.getValue();
    }

    public final int h() {
        return ((Number) this.s.getValue()).intValue();
    }

    public static final int a(VoiceBubbleAreaUseCase r0) {
        return ((Number) r0.r.getValue()).intValue();
    }

    public static final int b(VoiceBubbleAreaUseCase r0) {
        return ((Number) r0.q.getValue()).intValue();
    }

    public static final int c(VoiceBubbleAreaUseCase r0) {
        return ((Number) r0.n.getValue()).intValue();
    }

    public static final int d(VoiceBubbleAreaUseCase r0) {
        return ((Number) r0.i.getValue()).intValue();
    }

    public final Pair<Integer, Integer> g(int r5) {
        Pair<Integer, Integer> r0 = (Pair) f().getBeforeInsetSelection().getValue();
        if (r0 != null) goto L6;
        r0 = new Pair(0, 0);
    L6:
        if (((Number) r0.getFirst()).intValue() >= 0) goto L8;
    L13:
        Log.w(this.e, "invalid beforeInsetSelection:" + r0 + ", editableLength:" + r5);
        return null;
    L8:
        if (((Number) r0.getSecond()).intValue() < ((Number) r0.getFirst()).intValue()) goto L13;
        if (((Number) r0.getSecond()).intValue() > r5) goto L13;
        return r0;
    }

    public final void i(long r5) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        VibrationEffect r6 = VibrationEffect.createOneShot(r5, -1);
        Object r7 = this.a.getContext().getSystemService("vibrator");
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) r7).vibrate(r6);
        return;
    L5:
        Object r0 = this.a.getContext().getSystemService("vibrator");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) r0).vibrate(r5);
    }

    public static final void e(VoiceBubbleAreaUseCase r2, List r3, List r4) {
        r2.getClass();
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        int r0 = ((Number) r5.next()).intValue();
        r2.a.findViewById(r0).setVisibility(0);
        goto L4
    L6:
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        int r7 = ((Number) r6.next()).intValue();
        r2.a.findViewById(r7).setVisibility(8);
        goto L8
    }

    public VoiceBubbleAreaUseCase(ConstraintLayout r2, Fragment r3, VoiceImeWrapperUseCase r4, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r5) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "imeWrapperUseCase");
        Intrinsics.checkNotNullParameter(r5, "viewFinder");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = "VoiceBubbleAreaUseCase";
        this.f = LazyKt.lazy(new VoiceBubbleAreaUseCase$loadingAnimation$2(this));
        ConstraintSet r6 = new ConstraintSet();
        r6.clone(r2);
        this.g = r6;
        ConstraintSet r7 = new ConstraintSet();
        r7.clone(r5.o());
        this.h = r7;
        this.i = LazyKt.lazy(new VoiceBubbleAreaUseCase$waveBarWidthInRecording$2(this));
        this.j = UIUtils.dp2px(r2.getContext(), 8.0f);
        this.k = UIUtils.dp2px(r2.getContext(), 10.0f);
        this.l = UIUtils.dp2px(r2.getContext(), 12.0f);
        this.m = UIUtils.dp2px(r2.getContext(), 20.0f);
        this.n = LazyKt.lazy(new VoiceBubbleAreaUseCase$waveBarWidthInRecognizing$2(this));
        this.o = LazyKt.lazy(new VoiceBubbleAreaUseCase$waveBarWidthInCanceling$2(this));
        this.p = LazyKt.lazy(new VoiceBubbleAreaUseCase$bubbleWidthInPreparing$2(this));
        this.q = LazyKt.lazy(new VoiceBubbleAreaUseCase$bubbleWidthInRecording$2(this));
        this.r = LazyKt.lazy(new VoiceBubbleAreaUseCase$bubbleWidthInCanceling$2(this));
        this.s = LazyKt.lazy(VoiceBubbleAreaUseCase$waveBarColor$2.INSTANCE);
        this.t = LazyKt.lazy(VoiceBubbleAreaUseCase$waveBarColorInCancel$2.INSTANCE);
        this.v = new AudioAsrLanguageSwitcher(r2.getContext());
        this.w = new VoiceBubbleMotionScene(r2, r5.o(), r5);
        this.x = LazyKt.lazy(new VoiceBubbleAreaUseCase$immersiveVoiceViewModel$2(this));
    }
}
