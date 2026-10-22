package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnTouchListener {
    public final /* synthetic */ AudioKBPlugin a;
    public final /* synthetic */ View.OnClickListener b;

    public d(AudioKBPlugin r1, AudioKBPlugin.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(final View r6, MotionEvent r7) {
        int r0 = r7.getAction() & 255;
        if (r0 == 0) goto L21;
        if (r0 != 1) goto L6;
        r6.setPressed(false);
        AudioKBPlugin r1 = this.a;
        AppCompatImageView r2 = r1.m;
        if (r2 == null) goto L14;
        r2.removeCallbacks(r1.n);
    L14:
        int r3 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.g(this.a.H()) == true) goto L17;
    L19:
        h r8 = this.a.J();
        Intrinsics.checkNotNull(r7);
        r8.j(r7);
        return true;
    L17:
        if (this.a.J().e(null).isShown() == true) goto L19;
        this.b.onClick(r6);
        goto L19
    L6:
        if (r0 != 3) goto L19;
        r6.setPressed(false);
        AudioKBPlugin r9 = this.a;
        AppCompatImageView r4 = r9.m;
        if (r4 == null) goto L19;
        r4.removeCallbacks(r9.n);
        goto L19
    L21:
        AudioKBPlugin r5 = this.a;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNull(r7);
        final View.OnClickListener r10 = this.b;
        r5.getClass();
        r6.setPressed(true);
        r7.getX();
        r7.getY();
        int r11 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.g(r5.H()) == true) goto L24;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.j(r5.H(), new AudioKBPlugin$onActionDown$1(r10, r6));
        return false;
    L24:
        AppCompatImageView r12 = r5.m;
        if (r12 != null) goto L27;
    L29:
        boolean r13 = false;
    L30:
        if (r13 == true) goto L38;
        f r14 = new f(r5, r7);
        r5.n = r14;
        AppCompatImageView r15 = r5.m;
        if (r15 == null) goto L35;
        r15.postDelayed(r14, 500);
    L35:
        return true;
    L38:
        return false;
    L27:
        if (r12.isSelected() != true) goto L29;
        r13 = true;
        goto L30
    }
}
