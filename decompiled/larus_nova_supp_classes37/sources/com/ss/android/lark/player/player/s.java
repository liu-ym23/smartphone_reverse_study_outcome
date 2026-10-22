package com.ss.android.lark.player.player;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.perf.ResourcePerfMonitor;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.SARChangeListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.utils.Error;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class s extends b {
    public static final boolean r = false;
    public TTVideoEngine g;
    public com.ss.android.lark.player.player.a h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public final k m;
    public final j n;
    public DataSource o;
    public String p;
    public String q;

    public class a implements VideoEngineListener, SARChangeListener {
        public float a;
        public final /* synthetic */ s b;

        public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r1) {
            VideoEngineListener.-CC.$default$onFirstAVSyncFrame(this, r1);
        }

        public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
            VideoEngineListener.-CC.$default$onRefreshSurface(this, r1);
        }

        public final /* synthetic */ int onSetSurface(TTVideoEngine r1, VideoSurface r2, Surface r3) {
            return VideoEngineListener.-CC.$default$onSetSurface(this, r1, r2, r3);
        }

        public final /* synthetic */ void onSilenceDetected(TTVideoEngine r1) {
            VideoEngineListener.-CC.$default$onSilenceDetected(this, r1);
        }

        public final void onStreamChanged(TTVideoEngine r1, int r2) {
        }

        public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r1) {
            VideoEngineListener.-CC.$default$onVideoSecondFrame(this, r1);
        }

        public final void onVideoStatusException(int r1) {
        }

        public a(s r1) {
            this.b = r1;
            this.a = 1.0f;
        }

        public final void onCompletion(TTVideoEngine r3) {
            this.b.n(6);
            this.b.i = 6;
            Bundle r4 = w0c.a.a();
            r4.putInt("int_arg1", this.b.d());
            this.b.a(-99016, r4);
        }

        public final void onError(Error r5) {
            Log.i("TTEnginePlayer", "Error: " + r5);
            this.b.n(-1);
            this.b.i = -1;
            int r0 = r5.code;
            if (r0 != (-499896)) goto L5;
            int r1 = -88015;
        L9:
            Bundle r2 = w0c.a.a();
            r2.putInt("int_arg1", r5.code);
            r2.putString("string_data", r5.description);
            m r6 = this.b.c;
            if (r6 == null) goto L13;
            r6.h(r1, r2);
            return;
        L13:
            return;
        L5:
            if (r0 == (-499894)) goto L7;
            r1 = -88011;
            goto L9
        L7:
            r1 = -88019;
            goto L9
        }

        public final void onPrepare(TTVideoEngine r3) {
            Log.i("TTEnginePlayer", "onPrepare: " + r3.getCurrentPlayPath());
            this.b.a(-99053, null);
        }

        public final void onPrepared(TTVideoEngine r4) {
            Log.i("TTEnginePlayer", "onPrepared...");
            this.b.n(2);
            this.b.j = r4.getVideoWidth();
            this.b.k = r4.getVideoHeight();
            Bundle r5 = w0c.a.a();
            r5.putInt("int_arg1", this.b.j);
            r5.putInt("int_arg2", this.b.k);
            r5.putInt("int_arg3", this.b.d());
            r5.putInt("int_arg4", this.b.c());
            this.b.a(-99018, r5);
            Log.i("TTEnginePlayer", "mTargetState = " + this.b.i);
        }

        public final void onRenderStart(TTVideoEngine r3) {
            s r4 = this.b;
            if (r4.b() == false) goto L5;
            r4.g.setStartTime(0);
        L5:
            this.b.a(-99015, null);
        }

        public final void onBufferingUpdate(TTVideoEngine r1, int r2) {
            s r3 = this.b;
            r3.e = r2;
            l r4 = r3.d;
            if (r4 == null) goto L6;
            ((v.d) r4).a.getClass();
            return;
        }

        public final void onLoadStateChanged(TTVideoEngine r2, int r3) {
            if (r3 != 1) goto L5;
            Bundle r4 = w0c.a.a();
            this.b.a(-99011, r4);
            return;
        L5:
            if (r3 != 2) goto L11;
            Bundle r5 = w0c.a.a();
            this.b.a(-99010, r5);
            return;
        }

        public final void onPlaybackStateChanged(TTVideoEngine r1, int r2) {
            if (r2 != 1) goto L5;
            this.b.n(3);
            return;
        L5:
            if (r2 != 2) goto L11;
            this.b.n(4);
            return;
        }

        public final void onSARChanged(int r1, int r2) {
            if (r2 == 0) goto L6;
            if (r1 == 0) goto L7;
            this.a = r1 / r2;
            return;
        L7:
            return;
        }

        public final void onVideoSizeChanged(TTVideoEngine r3, int r4, int r5) {
            float r6 = this.a;
            if (r6 == 1.0f) goto L5;
            float r0 = r4;
            r5 = (int) (r0 / ((r0 / r5) * r6));
        L5:
            b.a r7 = this.b.f;
            if (r7 == null) goto L8;
            r7.a(r4, r5);
        L8:
            s r8 = this.b;
            r8.j = r4;
            r8.k = r5;
            Bundle r9 = w0c.a.a();
            r9.putInt("int_arg1", this.b.j);
            r9.putInt("int_arg2", this.b.k);
            this.b.a(-99017, r9);
        }
    }

    public final boolean b() {
        if (this.g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f() {
        Log.i("TTEnginePlayer", "playWithCheck: " + this.p);
        if (TextUtils.isEmpty(this.p) == true) goto L6;
        this.g.play();
        return;
    }

    public final void g() {
        Log.i("TTEnginePlayer", "reset: " + this.p);
        if (b() == false) goto L5;
        n(0);
        a(-99008, null);
    L5:
        this.i = 0;
    }

    public final void h() {
        Log.i("TTEnginePlayer", "resume: " + this.p);
    L13:
        e = move-exception;
        e(e);
    L15:
        this.i = 3;
        return;
    L4:
        if (b() == false) goto L15;
        int r1 = this.a;     // Catch: Exception -> L13
        if (r1 != 4) goto L8;
    L11:
        f();     // Catch: Exception -> L13
        n(3);     // Catch: Exception -> L13
        a(-99006, null);     // Catch: Exception -> L13
        goto L15
    L8:
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L15;
        goto L11
    }

    public final void l() {
        Log.i("TTEnginePlayer", "stop: " + this.p);
        if (b() == false) goto L13;
        int r0 = this.a;
        if (r0 != 2) goto L7;
    L12:
        this.g.stop();
        n(5);
        a(-99007, null);
        goto L13
    L7:
        if (r0 == 3) goto L12;
        if (r0 == 4) goto L12;
        if (r0 == 6) goto L12;
    L13:
        this.i = 5;
    }

    public final void m() {
        if (this.h != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.p) == true) goto L9;
        com.ss.android.lark.player.player.a r0 = this.h;
        String r1 = this.p;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "url");
        r0.a.b(r1);
        return;
    }

    static {
        boolean r1 = true;
        if (IMPlayerSettings.a().getUseCacheFromBiz() == 1) goto L6;
        r1 = false;
    L6:
        r = r1;
    }

    public s() {
        this.l = true;
        k r0 = new k(this);
        this.m = r0;
        this.n = new j(this);
        this.p = "";
        this.q = "";
        com.ss.android.lark.playerconfig.a.b("IM", "");
        TTVideoEngine r1 = com.ss.android.lark.playerconfig.a.a("IM", "", null);
        this.g = r1;
        r1.setVideoEngineCallback(r0);
    }

    public final int c() {
        if (b() == false) goto L14;
        int r0 = this.a;
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L13;
        if (r0 == 6) goto L13;
        return 0;
    L13:
        return this.g.getCurrentPlaybackTime();
    L14:
        return 0;
    }

    public final int d() {
        if (b() == false) goto L11;
        int r0 = this.a;
        if (r0 != (-1)) goto L7;
        return 0;
    L7:
        if (r0 == 1) goto L14;
        if (r0 != 0) goto L10;
        return 0;
    L10:
        return this.g.getDuration();
    L14:
        return 0;
    L11:
        return 0;
    }

    public final void e(Exception r3) {
        Log.e("TTEnginePlayer", "exception in player:" + r3);
        g();
    }

    public final void i(DataSource r9) {
    L21:
        e = move-exception;
        e.printStackTrace();
        n(-1);
        this.i = -1;
        return;
    L3:
        if (b() == true) goto L5;
        com.ss.android.lark.playerconfig.a.b("IM", "");     // Catch: Exception -> L21
        TTVideoEngine r0 = com.ss.android.lark.playerconfig.a.a("IM", "", null);     // Catch: Exception -> L21
        this.g = r0;     // Catch: Exception -> L21
        r0.setVideoEngineCallback(this.m);     // Catch: Exception -> L21
    L9:
        a r1 = new a(this);     // Catch: Exception -> L21
        this.g.setSARChangeListener(r1);     // Catch: Exception -> L21
        this.g.setListener(r1);     // Catch: Exception -> L21
        n(1);     // Catch: Exception -> L21
        String r2 = r9.getData();     // Catch: Exception -> L21
        Uri r3 = r9.getUri();     // Catch: Exception -> L21
        FileDescriptor r4 = r9.getFileDescriptor();     // Catch: Exception -> L21
        if (r2 == null) goto L12;
        j(r9, r2);     // Catch: Exception -> L21
    L19:
        Bundle r5 = w0c.a.a();     // Catch: Exception -> L21
        r5.putSerializable("serializable_data", r9);     // Catch: Exception -> L21
        a(-99001, r5);     // Catch: Exception -> L21
        return;
    L12:
        if (r3 == null) goto L14;
        j(r9, r3.toString());     // Catch: Exception -> L21
        goto L19
    L14:
        if (r4 == null) goto L19;
        com.ss.android.lark.player.player.a r6 = this.h;     // Catch: Exception -> L21
        if (r6 == null) goto L18;
        r6.a.a();     // Catch: Exception -> L21
    L18:
        this.g.setDataSource(r4, r9.getStartPos(), 0);     // Catch: Exception -> L21
        goto L19
    L5:
        l();     // Catch: Exception -> L21
        g();     // Catch: Exception -> L21
        if (b() == false) goto L9;
        this.g.setListener(null);     // Catch: Exception -> L21
        goto L9
    }

    public final void k(int r3) {
        if (b() == false) goto L27;
        if (r3 > 0) goto L6;
    L8:
        Log.i("TTEnginePlayer", "start: " + this.p);
    L21:
        e = move-exception;
        e(e);
    L23:
        this.i = 3;
        return;
    L10:
        if (b() == false) goto L23;
        int r0 = this.a;     // Catch: Exception -> L21
        if (r0 != 2) goto L14;
    L19:
        f();     // Catch: Exception -> L21
        n(3);     // Catch: Exception -> L21
        a(-99004, null);     // Catch: Exception -> L21
        goto L23
    L14:
        if (r0 == 4) goto L19;
        if (r0 == 1) goto L19;
        if (r0 != 6) goto L23;
    L6:
        if (b() == false) goto L8;
        this.g.setStartTime(r3);
        goto L8
    }

    public final void n(int r5) {
        this.a = r5;
        Bundle r0 = w0c.a.a();
        r0.putInt("int_data", r5);
        a(-99031, r0);
        k r1 = this.m;
        r1.getClass();
        if (r5 != (-2)) goto L5;
    L11:
        Log.i("LarkVideoEngineCallback", "remove task");
        r1.b.removeCallbacksAndMessages(null);
    L12:
        if (r5 != (-2)) goto L14;
        ResourcePerfMonitor.VIDEO_PLAY.onEnd();
        return;
    L14:
        if (r5 != 1) goto L20;
        ResourcePerfMonitor.VIDEO_PLAY.onStart();
        return;
    L20:
        return;
    L5:
        if (r5 == (-1)) goto L11;
        if (r5 == 5) goto L11;
        if (r5 == 6) goto L11;
        goto L11
    }

    public final void j(DataSource r4, String r5) {
        Log.i("TTEnginePlayer", "setEngineUrl, dataSource: " + r4.toString() + ", urlLog: " + LarkPlayerUtils.i(r5));
        this.o = r4;
        this.p = r5;
        this.q = r4.getCacheKeyPrefix();
        if (r5.startsWith("http") == true) goto L5;
        this.g.setLocalURL(r5);
    L17:
        m();
        return;
    L5:
        if (r == true) goto L7;
    L9:
        this.g.setDirectURL(r5);
    L10:
        HashMap<String, String> r6 = r4.getExtra();
        if (r6 == null) goto L17;
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L14:
        if (r7.hasNext() == false) goto L17;
        Map.Entry<String, String> r8 = r7.next();
        this.g.setCustomHeader(r8.getKey(), r8.getValue());
        goto L14
    L7:
        if (this.l == false) goto L9;
        this.g.setDirectUrlUseDataLoader(r5, LarkPlayerUtils.b(this.q, this.p));
        goto L10
    }
}
