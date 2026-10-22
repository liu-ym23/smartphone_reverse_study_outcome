package of;

import android.content.Context;
import android.view.Surface;
import com.bytedance.common.utility.collection.WeakHandler;
import com.lynx.base.log.LynxLog;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoModel;
import java.util.Map;
import m.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements VideoEngineInfoListener, VideoEngineCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile TTVideoEngine f20558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f20560c;
    public final pf.b d;
    public DataSource e;
    public f0 f;
    public final PlaybackParams g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public uf.b f20561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f20562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f20563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WeakHandler f20566m;

    public e(Context r5, pf.b r10) {
        this.f20559b = new Object();
        this.f20562i = false;
        this.f20563j = false;
        this.f20564k = false;
        this.f20565l = false;
        this.f20566m = new WeakHandler(new g8.a());
        this.f20560c = r5;
        this.d = r10;
        this.g = new PlaybackParams();
    }

    public final void a() {
        Object r5 = this.f20559b;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f20558a != null) goto L9;
        g();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r5);     // Catch: Throwable -> L7
        if (this.f20558a == null) goto L42;
        f0 r10 = this.f;
        if (r10 == null) goto L15;
        r10.h(this.f20558a, this.d);
    L15:
        this.f20558a.setIntOption(160, 1);
        this.f20558a.setIntOption(509, 1);
        this.f20558a.setIntOption(402, 1);
        pf.b r11 = this.d;
        String r12 = r11.f21331b;
        if (r11.f == null) goto L20;
        TTVideoEngine r13 = this.f20558a;
        pf.b r14 = this.d;
        r13.setDirectUrlUseDataLoader(r14.f, r14.e);
        return;
    L20:
        if (r11.g == null) goto L23;
        this.f20558a.setLocalURL(this.d.g);
        return;
    L23:
        if (r12 == null) goto L31;
        VideoModel r15 = r11.a();
        if (r15 == null) goto L43;
        this.f20558a.setVideoModel(r15);
        if (r15.hasFormat(IVideoModel.Format.DASH) == false) goto L44;
        this.f20558a.setIntOption(17, 1);
        this.f20558a.setIntOption(33, 1);
        this.f20558a.setIntOption(473, 3);
        return;
    L44:
        return;
    L43:
        return;
    L31:
        if (r11.f21330a == null) goto L45;
        this.f20558a.setIntOption(21, 1);
        this.f20558a.setVideoID(this.d.f21330a);
        if (this.d.f21332c == null) goto L46;
        this.f20558a.setPlayAPIVersion(2, this.d.f21332c);
        if (this.d.d == null) goto L47;
        TTVideoEngine r16 = this.f20558a;
        pf.b r17 = this.d;
        r16.setDataSource(new nf.a(r17.f21332c, r17.d));
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    }

    public final void b(float r5) {
        if (this.f20558a == null) goto L6;
        PlaybackParams r10 = k();
        r10.setSpeed(r5);
        this.f20558a.setPlaybackParams(r10);
        return;
    }

    public final void c(int r5, int r10) {
        if (this.f20558a != null) goto L5;
        return;
    L5:
        this.f20558a.setIntOption(341, r5);
        this.f20558a.setIntOption(342, r10);
    }

    public final void d(Surface r5) {
        if (r5 != null) goto L6;
        this.f20564k = false;
        return;
    L6:
        if (this.f20558a != null) goto L8;
        return;
    L8:
        if (this.f20564k == true) goto L12;
        this.f20564k = true;
        LynxLog.b(2, "VideoController", "Set surface to video engine");
        this.f20558a.setSurface(r5);
        return;
    }

    public final void e(Resolution r5) {
        if (this.f20558a == null) goto L6;
        Resolution r10 = Resolution.Auto;
        this.f20558a.configResolution(r5);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [of.d, uf.b] */
    /* JADX WARN: Type inference failed for: r1v5, types: [of.d, uf.b] */
    public final void f() {
        if (this.f20562i == false) goto L5;
    L26:
        LynxLog.b(2, "VideoController", "Failed to trigger prepare in videoController for prepareCalled or preparing");
        return;
    L5:
        if (this.f20563j == true) goto L26;
        this.f20563j = true;
        a();
        if (this.f20558a != null) goto L12;
        LynxLog.b(2, "VideoController", "VideoEngine not initialized");
        this.f20563j = false;
        return;
    L12:
        if (this.f20562i == true) goto L17;
        ?? r5 = this.f20561h;
        if (r5 == 0) goto L17;
        r5.a();
    L17:
        if (n() == false) goto L21;
        ?? r10 = this.f20561h;
        if (r10 == 0) goto L21;
        r10.a(new b(this));
    L24:
        this.f20562i = true;
        this.f20563j = false;
        return;
    L21:
        TTVideoEngine r11 = this.f20558a;
        if (r11 == null) goto L24;
        r11.prepare();
        goto L24
    }

    public final void g() {
        TTVideoEngine.setReportLogByEngine(true, this.f20560c);
        if (this.f20558a != null) goto L15;
        VideoEventManager.instance.setLoggerVersion(2);
        f0 r5 = this.f;
        if (r5 != null) goto L7;
    L9:
        int r10 = 0;
    L10:
        this.f20558a = new TTVideoEngine(this.f20560c, r10);
        this.f20558a.setVideoEngineCallback(this);
        this.f20558a.setVideoEngineInfoListener(this);
        if (this.e == null) goto L13;
        this.f20558a.setDataSource(this.e);
    L13:
        this.f20558a.setIntOption(12, 0);
        this.f20558a.setIntOption(492, 1);
        this.f20558a.setIntOption(471, 3);
        this.f20558a.setIntOption(7, 0);
        this.f20558a.setIntOption(5, 5);
        return;
    L7:
        if (r5.a() < 0) goto L9;
        r10 = this.f.a();
        goto L10
    }

    public final void h(boolean r5) {
        if (this.f20558a == null) goto L6;
        this.f20558a.setLooping(r5);
        return;
    }

    public final int i() {
        if (this.f20558a != null) goto L5;
        return 0;
    L5:
        return this.f20558a.getDuration();
    }

    public final void j(boolean r5) {
        if (this.f20558a == null) goto L6;
        this.f20558a.setIsMute(r5);
        return;
    }

    public final PlaybackParams k() {
        if (this.g.getSpeed() != (-1.0f)) goto L6;
        this.g.setSpeed(1.0f);
    L6:
        return this.g;
    }

    public final void l() {
        if (this.f20558a == null) goto L6;
        this.f20558a.pause();
        return;
    }

    public final void m() {
        if (this.f20558a != null) goto L5;
        return;
    L5:
        WeakHandler r5 = this.f20566m;
        if (r5 == null) goto L8;
        r5.removeMessages(201);
    L8:
        this.f20564k = false;
        this.f20558a.releaseAsync();
        this.f20558a = null;
    }

    public final boolean n() {
        pf.b r5 = this.d;
        if (r5 == null) goto L5;
        pf.a r10 = r5.f21339n;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        Map r11 = r10.f21329h;
        if (r11 != null) goto L12;
        return false;
    L12:
        String r12 = (String) r11.get("experimental-force-prepare-play-after-surface-available");
        if (r12 != null) goto L16;
        return false;
    L16:
        return "true".equalsIgnoreCase(r12);
    L5:
        r10 = null;
        goto L7
    }

    public final void o() {
        if (this.f20558a == null) goto L6;
        this.f20558a.stop();
        return;
    }
}
