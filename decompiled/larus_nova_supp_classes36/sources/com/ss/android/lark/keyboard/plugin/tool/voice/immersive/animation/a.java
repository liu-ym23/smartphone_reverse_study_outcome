package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceView;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.CircleIconWithTitle;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceCircleButton;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceOvalBackground;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceWaveBar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final Lazy A;
    public final ViewGroup a;
    public final ViewGroup b;
    public final Fragment c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public final KeyboardFunctionEditText a() {
        return (KeyboardFunctionEditText) this.f.getValue();
    }

    public final AppCompatImageView b() {
        return (AppCompatImageView) this.h.getValue();
    }

    public final CircleIconWithTitle c() {
        return (CircleIconWithTitle) this.v.getValue();
    }

    public final VoiceCircleButton d() {
        return (VoiceCircleButton) this.p.getValue();
    }

    public final CircleIconWithTitle e() {
        return (CircleIconWithTitle) this.u.getValue();
    }

    public final FrameLayout f() {
        return (FrameLayout) this.y.getValue();
    }

    public final CircleIconWithTitle g() {
        return (CircleIconWithTitle) this.t.getValue();
    }

    public final AppCompatImageView h() {
        return (AppCompatImageView) this.m.getValue();
    }

    public final AppCompatTextView i() {
        return (AppCompatTextView) this.j.getValue();
    }

    public final CircleIconWithTitle j() {
        return (CircleIconWithTitle) this.r.getValue();
    }

    public final AppCompatTextView k() {
        return (AppCompatTextView) this.s.getValue();
    }

    public final AppCompatTextView l() {
        return (AppCompatTextView) this.k.getValue();
    }

    public final AppCompatImageView m() {
        return (AppCompatImageView) this.i.getValue();
    }

    public final AppCompatTextView n() {
        return (AppCompatTextView) this.x.getValue();
    }

    public final ConstraintLayout o() {
        return (ConstraintLayout) this.g.getValue();
    }

    public final VoiceOvalBackground p() {
        return (VoiceOvalBackground) this.o.getValue();
    }

    public final VoiceCircleButton q() {
        return (VoiceCircleButton) this.q.getValue();
    }

    public final AppCompatTextView r() {
        return (AppCompatTextView) this.e.getValue();
    }

    public final VoiceWaveBar s() {
        return (VoiceWaveBar) this.d.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(ImmersiveVoiceView r2, ViewGroup r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r2, "rootContainer");
        Intrinsics.checkNotNullParameter(r3, "decorViewGroup");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(new ImmersiveViewFinder$voiceWaveBar$2(this));
        this.e = LazyKt.lazy(new ImmersiveViewFinder$voiceRecordElapseHint$2(this));
        this.f = LazyKt.lazy(new ImmersiveViewFinder$asrResultEditText$2(this));
        this.g = LazyKt.lazy(new ImmersiveViewFinder$voiceBubbleContainer$2(this));
        this.h = LazyKt.lazy(new ImmersiveViewFinder$bubbleTriangle$2(this));
        this.i = LazyKt.lazy(new ImmersiveViewFinder$switchLanguage$2(this));
        this.j = LazyKt.lazy(new ImmersiveViewFinder$retryRecognitionText$2(this));
        this.k = LazyKt.lazy(new ImmersiveViewFinder$showOriginalText$2(this));
        this.l = LazyKt.lazy(new ImmersiveViewFinder$tipsAsrResultEditable$2(this));
        this.m = LazyKt.lazy(new ImmersiveViewFinder$recordPreparing$2(this));
        this.n = LazyKt.lazy(new ImmersiveViewFinder$tipsWeakNet$2(this));
        this.o = LazyKt.lazy(new ImmersiveViewFinder$voiceOvalBackground$2(this));
        this.p = LazyKt.lazy(new ImmersiveViewFinder$cancelRecording$2(this));
        this.q = LazyKt.lazy(new ImmersiveViewFinder$voiceRecognizing$2(this));
        this.r = LazyKt.lazy(new ImmersiveViewFinder$sendAllResult$2(this));
        this.s = LazyKt.lazy(new ImmersiveViewFinder$sendAllResultContinueTip$2(this));
        this.t = LazyKt.lazy(new ImmersiveViewFinder$onlySendAudio$2(this));
        this.u = LazyKt.lazy(new ImmersiveViewFinder$holdToSpeakBtn$2(this));
        this.v = LazyKt.lazy(new ImmersiveViewFinder$cancelAsrResult$2(this));
        this.w = LazyKt.lazy(new ImmersiveViewFinder$bubbleTriangleAnchor$2(this));
        this.x = LazyKt.lazy(new ImmersiveViewFinder$tipsRecordPreparing$2(this));
        this.y = LazyKt.lazy(new ImmersiveViewFinder$imeWrapperContainer$2(this));
        this.z = LazyKt.lazy(new ImmersiveViewFinder$holdToSpeakBarLayout$2(this));
        this.A = LazyKt.lazy(new ImmersiveViewFinder$holdToSpeakBarBkg$2(this));
    }
}
