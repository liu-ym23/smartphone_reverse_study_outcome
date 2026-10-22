package com.ss.ugc.live.barrage.util;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class d {
    public a a;
    public int b;
    public long c;
    public long d;
    public boolean e;
    public final Handler f;
    public final String g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;

    public static final class a implements Choreographer.FrameCallback {
        public final /* synthetic */ d a;

        public final String toString() {
            return "Scheduled " + this.a;
        }

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r7) {
            d r8 = this.a;
            if (r8.e == false) goto L5;
            r8.e = false;
            r8.c = System.currentTimeMillis() - r8.d;
            r8.b();
        L22:
            a r9 = this.a.a;
            if (r9 == null) goto L26;
            Choreographer.getInstance().postFrameCallback(r9);
            return;
        L26:
            return;
        L5:
            double r1 = System.currentTimeMillis() - r8.c;
            if (r1 < 0) goto L22;
            int r10 = r8.h;
            long r0 = (long) ((r1 * ((double) r10)) / ((double) r8.i));
            boolean r2 = r8.j;
            if (r2 == false) goto L12;
            r0 = r0 % ((long) r10);
        L12:
            if (r0 == r8.b) goto L22;
            if (r2 == false) goto L16;
        L21:
            r8.b = (int) r0;
            r8.b();
            goto L22
        L16:
            if (r0 < r10) goto L21;
            a r11 = r8.a;
            if (r11 == null) goto L20;
            Choreographer.getInstance().removeFrameCallback(r11);
            r8.a = null;
        L20:
            r8.f.post(new c(r8));
            goto L22
        }
    }

    public abstract void a(int r1, int r2);

    public final void b() {
        if (this.k == false) goto L5;
        int r0 = this.b;
    L6:
        a(r0, this.h);
        return;
    L5:
        r0 = (this.h - this.b) - 1;
        goto L6
    }

    public final void c() {
        if (this.i != 0) goto L9;
        this.b = this.h - 1;
        b();
        a r0 = this.a;
        if (r0 == null) goto L7;
        Choreographer.getInstance().removeFrameCallback(r0);
        this.a = null;
    L7:
        this.f.post(new c(this));
        return;
    L9:
        if (this.a != null) goto L13;
        this.a = new a(this);
        Choreographer.getInstance().postFrameCallback(this.a);
        return;
    }

    public final String toString() {
        a r0 = this.a;
        StringBuilder r1 = new StringBuilder("FrameAnimator '");
        r1.append(this.g);
        r1.append("' @");
        r1.append(System.identityHashCode(this));
        if (r0 != null) goto L5;
        String r2 = " (stopped)";
    L6:
        r1.append(r2);
        return r1.toString();
    L5:
        r2 = " (running " + this.b + '/' + this.h + " frame)";
        goto L6
    }

    public d() {
        this.g = "BarrageAnimator";
        this.h = 60;
        this.i = AudioViewModel.ASR_SESSION_IDLE;
        this.j = true;
        this.k = true;
        this.f = new Handler(Looper.getMainLooper());
        this.b = 0;
        this.d = 0;
        this.e = true;
    }
}
