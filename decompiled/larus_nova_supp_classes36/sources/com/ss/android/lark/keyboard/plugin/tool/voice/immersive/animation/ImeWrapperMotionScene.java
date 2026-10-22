package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.Transition;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImeWrapperMotionScene {
    public final ConstraintLayout a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final long h;

    public ImeWrapperMotionScene(ConstraintLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        this.a = r3;
        this.b = UIUtils.dp2px(r3.getContext(), 160.0f);
        this.c = UIUtils.dp2px(r3.getContext(), 16.0f);
        this.d = UIUtils.dp2px(r3.getContext(), 27.0f);
        this.e = UIUtils.dp2px(r3.getContext(), 35.0f);
        this.f = UIUtils.dp2px(r3.getContext(), 40.0f);
        this.g = UIUtils.dp2px(r3.getContext(), 75.0f);
        this.h = 120;
    }

    public final void b(final boolean r8, Function1<? super Transition, Unit> r9) {
        c r0 = new c(this.a);
        c.a(r0, this.a, new ImeWrapperMotionScene$whenImeWrapperChange$1$1(r8, this));
        r0.b(ImeWrapperMotionScene$whenImeWrapperChange$1$2.INSTANCE);
        c.c(r0, r9, null, 0, null, 14);
    }

    public static final b a(ImeWrapperMotionScene r1, int r2, String r3, boolean r4, boolean r5) {
        r1.getClass();
        b r0 = new b(r2, r3);
        r0.e();
        if (r2 != 2131374440) goto L6;
        r0.v(2131385903);
        r0.n(2131385903);
        r0.y(2131385903);
        r0.b(2131385903);
    L9:
        r0.r(!r4);
        return r0;
    L6:
        if (r5 == false) goto L8;
        r0.u(2131385901);
        r0.n(0);
        r0.c(2131375111);
        r0.a(r1.c);
        r0.t(r1.d);
        r0.c.put(12, 0);
        goto L9
    L8:
        r0.u(2131365121);
        r0.n(0);
        r0.y(2131365121);
        r0.b(2131365121);
        r0.t(r1.g);
        r0.a(0);
        goto L9
    }

    public static void d(ImeWrapperMotionScene r7, boolean r8, Long r9, VoiceInputScene r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r11 & 4) == 0) goto L9;
        r9 = null;
    L9:
        Long r4 = r9;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r10, "scene");
        KeyboardVoiceFGUtils r12 = KeyboardVoiceFGUtils.a;
        if (KeyboardVoiceFGUtils.b() == false) goto L12;
        r7.c(false, null, r3, r4, r10, false);
        return;
    L12:
        r7.b(false, null);
        return;
    L5:
        r3 = r8;
        goto L7
    }

    public final void c(final boolean r15, Function1<? super Transition, Unit> r16, final boolean r17, final Long r18, final VoiceInputScene r19, final boolean r20) {
        c r7 = new c(this.a);
        c.a(r7, this.a, new ImeWrapperMotionScene$whenImeWrapperChangeNew$1$1(this, r19, r15, r20, r17));
        r7.b(new ImeWrapperMotionScene$whenImeWrapperChangeNew$1$2(r18, this));
        c.c(r7, r16, null, 0, null, 14);
    }
}
