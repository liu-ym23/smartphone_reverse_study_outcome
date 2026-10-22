package com.bytedance.android.live.liveinteract.videotalk.ui.theme;

import android.graphics.Path;
import android.widget.ImageView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ui.ClipImageView;
import com.bytedance.android.live.ui.c;
import com.bytedance.android.live.ui.o;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.DefaultVoiceLiveThemeResource;
import je0.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class a extends c {
    public final int h() {
        return 0;
    }

    public final void f() {
        ClipImageView r0 = ((c) this).o;
        if ((r0 instanceof ClipImageView) == false) goto L8;
        if (r0 == null) goto L7;
        r0.setMClipPath(null);
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ui.ClipImageView");
    L8:
        ClipImageView r1 = ((c) this).p;
        if ((r1 instanceof ClipImageView) == false) goto L14;
        if (r1 == null) goto L13;
        r1.setMClipPath(null);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ui.ClipImageView");
    }

    public boolean q() {
        return d.i0(((c) this).m, false);
    }

    public final IVoiceLiveTheme g() {
        return DefaultVoiceLiveThemeResource.videoTalkRoomDefaultTheme();
    }

    public final void c(IVoiceLiveTheme r1) {
        super.c(r1);
        f();
    }

    public final void o(Path r4) {
        Intrinsics.checkNotNullParameter(r4, "clipPath");
        ClipImageView r0 = ((c) this).o;
        if ((r0 instanceof ClipImageView) == false) goto L8;
        if (r0 == null) goto L7;
        r0.setMClipPath(r4);
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ui.ClipImageView");
    L8:
        ClipImageView r1 = ((c) this).p;
        if ((r1 instanceof ClipImageView) == false) goto L14;
        if (r1 == null) goto L13;
        r1.setMClipPath(r4);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ui.ClipImageView");
    }

    public a(boolean r10, ClipImageView r11, ClipImageView r12, com.bytedance.android.live.ui.a r13) {
        super(r10, false, r11, r12, null, null, null, r13);
    }

    public a(boolean r10, HSImageView r11, HSImageView r12, o r13, HSImageView r14, ImageView r15, com.bytedance.android.live.ui.a r16) {
        super(r10, true, r11, r12, r13, r14, r15, r16);
    }
}
