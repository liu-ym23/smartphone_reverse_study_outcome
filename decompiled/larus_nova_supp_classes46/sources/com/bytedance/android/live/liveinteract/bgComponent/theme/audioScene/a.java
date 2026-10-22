package com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene;

import android.graphics.Path;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView;
import com.bytedance.android.live.ui.ClipImageView;
import com.bytedance.android.live.ui.o;
import com.bytedance.android.livesdk.config.s11;
import com.bytedance.android.livesdk.model.k;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import kotlin.jvm.internal.Intrinsics;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.android.live.ui.c {

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a$a, reason: collision with other inner class name */
    public static final class C0021a {
    }

    static {
    }

    public final void f() {
        ClipImageView r0 = ((com.bytedance.android.live.ui.c) this).o;
        if ((r0 instanceof ClipImageView) == false) goto L8;
        if (r0 == null) goto L7;
        r0.setMClipPath(null);
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ui.ClipImageView");
    L8:
        ClipImageView r1 = ((com.bytedance.android.live.ui.c) this).p;
        if ((r1 instanceof ClipImageView) == false) goto L14;
        if (r1 == null) goto L13;
        r1.setMClipPath(null);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ui.ClipImageView");
    }

    public final int h() {
        if (((s11) d.w7.getValue(null, d.a[435(0x1b3, float:6.1E-43)])).audioPlaceHolder == false) goto L5;
        return 0;
    L5:
        return 2131248875;
    }

    public final boolean q() {
        if (((com.bytedance.android.live.ui.c) this).l == false) goto L5;
    L8:
        return true;
    L5:
        if (k.c(((com.bytedance.android.live.ui.c) this).m) == true) goto L8;
        return false;
    }

    public final IVoiceLiveTheme g() {
        return k.a();
    }

    public final void o(Path r4) {
        Intrinsics.checkNotNullParameter(r4, "clipPath");
        ClipImageView r0 = ((com.bytedance.android.live.ui.c) this).o;
        if ((r0 instanceof ClipImageView) == false) goto L8;
        if (r0 == null) goto L7;
        r0.setMClipPath(r4);
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ui.ClipImageView");
    L8:
        ClipImageView r1 = ((com.bytedance.android.live.ui.c) this).p;
        if ((r1 instanceof ClipImageView) == false) goto L14;
        if (r1 == null) goto L13;
        r1.setMClipPath(r4);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ui.ClipImageView");
    }

    public final void r(boolean r3, String r4) {
        ALogger.i("[VoiceTalk]BaseLiveBackground", "setVisibility: visible=" + r3 + " & source=" + r4);
        if (r3 == false) goto L19;
        HSImageView r5 = ((com.bytedance.android.live.ui.c) this).o;
        if (r5 == null) goto L7;
        r5.setAlpha(1.0f);
    L7:
        HSImageView r6 = ((com.bytedance.android.live.ui.c) this).p;
        if (r6 == null) goto L10;
        r6.setAlpha(1.0f);
    L10:
        o r7 = ((com.bytedance.android.live.ui.c) this).q;
        if (r7 == null) goto L13;
        r7.setThemeViewAlpha(1.0f);
    L13:
        HSImageView r8 = ((com.bytedance.android.live.ui.c) this).r;
        if (r8 == null) goto L16;
        r8.setAlpha(1.0f);
    L16:
        ImageView r9 = ((com.bytedance.android.live.ui.c) this).s;
        if (r9 == null) goto L35;
        r9.setAlpha(1.0f);
        return;
    L35:
        return;
    L19:
        HSImageView r10 = ((com.bytedance.android.live.ui.c) this).o;
        if (r10 == null) goto L22;
        r10.setAlpha(0.0f);
    L22:
        HSImageView r11 = ((com.bytedance.android.live.ui.c) this).p;
        if (r11 == null) goto L25;
        r11.setAlpha(0.0f);
    L25:
        o r12 = ((com.bytedance.android.live.ui.c) this).q;
        if (r12 == null) goto L28;
        r12.setThemeViewAlpha(0.0f);
    L28:
        HSImageView r13 = ((com.bytedance.android.live.ui.c) this).r;
        if (r13 == null) goto L31;
        r13.setAlpha(0.0f);
    L31:
        ImageView r14 = ((com.bytedance.android.live.ui.c) this).s;
        if (r14 == null) goto L37;
        r14.setAlpha(0.0f);
        return;
    }

    public a(boolean r10, ClipImageView r11, ClipImageView r12, VideoThemeView r13, HSImageView r14, ImageView r15, com.bytedance.android.live.ui.a r16) {
        super(r10, false, r11, r12, r13, r14, r15, r16);
    }
}
