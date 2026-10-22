package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.HandlerCompat;
import com.ss.android.lark.utils.s0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AudioPopupWindowImpl implements com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b {
    public final d b;
    public final b c;
    public final FrameLayout d;
    public com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a e;
    public Drawable f;
    public boolean g;
    public boolean h;
    public Runnable i;
    public final Handler j;

    public static final class a {
    }

    public static final class b extends ViewGroup {
        public final int[] a;

        public static final class a extends ViewGroup.LayoutParams {
            public final int a;
            public final int b;

            public a(int r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.a = r3;
                this.b = r4;
            }
        }

        @Override // android.view.ViewGroup
        public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
            return new a(-1, -2, 0, 0);
        }

        public b(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.a = new int[2];
        }

        @Override // android.view.View
        public final void onMeasure(int r1, int r2) {
            measureChildren(r1, r2);
            super.onMeasure(r1, r2);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
            int r10 = getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L19;
            View r0 = getChildAt(r11);
            if (r0 == null) goto L18;
            if (8 == r0.getVisibility()) goto L18;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.AudioPopupWindowImpl.PopupDecorView.LayoutConfig");
            a r2 = (a) r1;
            if ((r2.a & 112) == 80) goto L13;
            int r3 = r2.b;
        L17:
            r0.layout(0, r3, r0.getMeasuredWidth(), r0.getMeasuredHeight() + r3);
            goto L18
        L13:
            if (r2.b != 0) goto L15;
            r3 = (r9 - r7) - r0.getMeasuredHeight();
            goto L17
        L15:
            getLocationInWindow(this.a);
            r3 = ((r9 - this.a[1]) - r0.getMeasuredHeight()) - r2.b;
        L18:
            r11 = r11 + 1;
            goto L3
        }
    }

    static {
    }

    public final void a() {
        this.g = true;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.t5(new AudioPopupWindowImpl$dismiss$1(this));
        return;
    }

    public final void c() {
        this.j.removeCallbacksAndMessages(null);
        this.g = false;
        this.h = true;
        c r0 = new c(this);
        this.i = r0;
        this.j.post(new s0.a(r0));
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b
    public final boolean isShown() {
        if (this.c.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b
    public final b s7() {
        return this.c;
    }

    public final void b(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a r2) {
        Intrinsics.checkNotNullParameter(r2, "audioPopupView");
        if (isShown() == true) goto L6;
        this.e = r2;
        return;
    }

    public AudioPopupWindowImpl(Context r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerProvider");
        this.b = r3;
        b r4 = new b(r2);
        this.c = r4;
        this.d = new FrameLayout(r4.getContext());
        this.j = HandlerCompat.createAsync(Looper.getMainLooper());
    }
}
