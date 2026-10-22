package com.ss.android.lark.player.player;

import android.os.Bundle;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class v {
    public final s a;
    public DataSource b;
    public final t c;
    public n d;
    public m e;
    public VideoEngineInfoListener f;
    public com.ss.android.lark.player.player.b.a g;
    public final a h;
    public final b i;
    public final c j;
    public final d k;
    public final e l;

    public class a implements t.b {
        public final /* synthetic */ v a;

        public a(v r1) {
            this.a = r1;
        }
    }

    public class b implements n {
        public final /* synthetic */ v a;

        public b(v r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.player.player.n
        public final void a(int r7, Bundle r8) {
            t r0 = this.a.c;
            switch(r7) {
                case -99016: goto L7;
                case -99015: goto L5;
                case -99014: goto L5;
                case -99013: goto L8;
                case -99012: goto L8;
                case -99011: goto L5;
                case -99010: goto L5;
                case -99009: goto L7;
                case -99008: goto L7;
                case -99007: goto L7;
                case -99006: goto L5;
                case -99005: goto L5;
                case -99004: goto L8;
                case -99003: goto L8;
                case -99002: goto L8;
                case -99001: goto L5;
                default: goto L8;
            };
        L5:
            r0.c = true;
            boolean r3 = true;
        L6:
            boolean r4 = false;
        L10:
            if (r0.d == false) goto L16;
            if (r3 == false) goto L14;
            r0.b = true;
            r0.f.removeMessages(1);
            r0.f.sendEmptyMessage(1);
        L14:
            if (r4 == false) goto L16;
            r0.b = false;
            r0.f.removeMessages(1);
        L16:
            n r1 = this.a.d;
            if (r1 == null) goto L20;
            r1.a(r7, r8);
            return;
        L20:
            return;
        L7:
            r0.c = false;
            r3 = false;
            r4 = true;
            goto L10
        L8:
            r0.getClass();
            Log.i("TimerCounterProxy", "unknown event int proxyPlayEvent");
            r3 = false;
            goto L6
        }
    }

    public class c implements m {
        public final /* synthetic */ v a;

        public c(v r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.player.player.m
        public final void h(int r3, Bundle r4) {
            t r0 = this.a.c;
            r0.c = false;
            r0.b = false;
            r0.f.removeMessages(1);
            m r1 = this.a.e;
            if (r1 == null) goto L6;
            r1.h(r3, r4);
            return;
        }
    }

    public class d implements l {
        public final /* synthetic */ v a;

        public d(v r1) {
            this.a = r1;
        }
    }

    public class e implements VideoEngineInfoListener {
        public final /* synthetic */ v a;

        public e(v r1) {
            this.a = r1;
        }

        public final void onVideoEngineInfos(VideoEngineInfos r2) {
            VideoEngineInfoListener r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.onVideoEngineInfos(r2);
            return;
        }
    }

    public final boolean f() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public v() {
        this.h = new a(this);
        this.i = new b(this);
        this.j = new c(this);
        this.k = new d(this);
        com.ss.android.lark.player.player.b.a r0 = new u(this);
        this.l = new e(this);
        this.c = new t();
        s r1 = new s();
        this.a = r1;
        r1.f = r0;
    }

    public final int a() {
        if (f() == true) goto L5;
        return 0;
    L5:
        return this.a.c();
    }

    public final int b() {
        if (f() == true) goto L5;
        return 0;
    L5:
        return this.a.d();
    }

    public final int c() {
        if (f() == true) goto L5;
        return 0;
    L5:
        return this.a.a;
    }

    public final boolean g() {
        if (f() == false) goto L9;
        s r0 = this.a;
        if (r0.b() == false) goto L9;
        if (r0.g.getIntOption(43) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public final void h() {
        if (f() == false) goto L15;
        s r0 = this.a;
        r0.getClass();
        Log.i("TTEnginePlayer", "pause: " + r0.p);
    L9:
        e = move-exception;
        r0.e(e);
    L11:
        r0.i = 4;
        return;
    L6:
        if (r0.b() == false) goto L11;
        r0.g.pause();     // Catch: Exception -> L9
        r0.n(4);     // Catch: Exception -> L9
        r0.a(-99005, null);     // Catch: Exception -> L9
        goto L11
    }

    public final void d(DataSource r2) {
        if (f() == false) goto L6;
        this.a.i(r2);
        return;
    }

    public final void e(int r2) {
        if (f() == false) goto L6;
        this.a.k(r2);
        return;
    }

    public final void i(int r5) {
        if (f() == false) goto L20;
        s r0 = this.a;
        if (r0.b() == false) goto L21;
        int r1 = r0.a;
        if (r1 != 2) goto L9;
    L18:
        r0.g.seekTo(r5, r0.n);
        Bundle r2 = w0c.a.a();
        r2.putInt("int_data", r5);
        r0.a(-99013, r2);
        return;
    L9:
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L18;
        if (r1 == 6) goto L18;
        if (r1 != 5) goto L22;
        r0.n(2);
        r0.k(r5);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void j(DataSource r4) {
        this.b = r4;
        t r0 = this.c;
        r0.e = this.h;
        s r1 = this.a;
        if (r1 == null) goto L8;
        r1.b = this.i;
        r1.c = this.j;
        r1.d = this.k;
        e r2 = this.l;
        if (r1.b() == false) goto L8;
        r1.g.setVideoEngineInfoListener(r2);
    L8:
        d(r4);
    }

    public final void k(boolean r3) {
        if (f() == false) goto L8;
        s r0 = this.a;
        if (r0.b() == false) goto L9;
        r0.g.setIsMute(r3);
        return;
    L9:
        return;
    }

    public final void l(float r3) {
        if (f() == false) goto L8;
        s r0 = this.a;
        if (r0.b() == false) goto L9;
        PlaybackParams r1 = new PlaybackParams();
        r1.setSpeed(r3);
        r0.g.setPlaybackParams(r1);
        return;
    L9:
        return;
    }

    public final void m(boolean r4) {
        t r0 = this.c;
        r0.d = r4;
        if (r4 == true) goto L5;
        r0.b = false;
        r0.f.removeMessages(1);
        Log.e("TimerCounterProxy", "Timer Stopped");
        return;
    L5:
        r0.b = true;
        r0.f.removeMessages(1);
        r0.f.sendEmptyMessage(1);
        Log.e("TimerCounterProxy", "Timer Started");
    }
}
