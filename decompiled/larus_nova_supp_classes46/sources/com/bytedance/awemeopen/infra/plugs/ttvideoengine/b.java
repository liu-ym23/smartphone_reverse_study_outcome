package com.bytedance.awemeopen.infra.plugs.ttvideoengine;

import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.PreloaderURLItem;
import com.ss.ttvideoengine.PreloaderVideoModelItem;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements r64.f {
    public static final /* synthetic */ int l = 0;
    public Surface a;
    public boolean b;
    public float c;
    public final Lazy d;
    public r64.b e;
    public String f;
    public r64.d g;
    public boolean h;
    public volatile int i;
    public final f j;
    public int k;

    public static final class a {
    }

    static {
    }

    @Override // r64.f
    public final void g() {
    }

    @Override // r64.f
    public final void pause() {
        this.i = 5;
        k().pause();
    }

    @Override // r64.f
    public final void release() {
        this.i = 7;
        k().release();
        this.b = true;
        this.e = null;
        this.f = null;
        this.k = 0;
    }

    @Override // r64.f
    public final void resume() {
        this.i = 4;
        k().play();
    }

    @Override // r64.f
    public final String getPlayId() {
        r64.b r0 = this.e;
        if (r0 == null) goto L6;
        String r1 = r0.b;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // r64.f
    public final boolean h() {
        if (TTVideoEngine.getCacheFileSize(this.f) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final TTVideoEngine k() {
        return (TTVideoEngine) this.d.getValue();
    }

    @Override // r64.f
    public final void stop() {
        r64.d r0 = this.g;
        if (r0 == null) goto L9;
        r64.b r1 = this.e;
        if (r1 == null) goto L7;
        String r2 = r1.b;
    L8:
        r0.c(r2);
        goto L9
    L7:
        r2 = null;
    L9:
        this.i = 6;
        k().stop();
    }

    public b() {
        this.b = true;
        this.c = 1.0f;
        this.d = LazyKt.lazy(new AoTTVideoEnginePlayer$mVideoEngine$2(this));
        this.i = -1;
        this.j = new f(this);
    }

    @Override // r64.f
    public final long getCurrentPosition() {
        return k().getCurrentPlaybackTime();
    }

    @Override // r64.f
    public final long getDuration() {
        return k().getDuration();
    }

    @Override // r64.f
    public final long getWatchDuration() {
        return k().getWatchedDuration();
    }

    @Override // r64.f
    public final boolean isPlaying() {
        if (k().getPlaybackState() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // r64.f
    public final int c() {
        return this.i;
    }

    @Override // r64.f
    public final float e() {
        return this.c;
    }

    @Override // r64.f
    public final void getPlayerType() {
    }

    @Override // r64.f
    public final void a(Surface r4) {
        this.a = r4;
        boolean r1 = true;
        this.h = !Intrinsics.areEqual(k().getSurface(), r4);
        StringBuilder r0 = new StringBuilder("setRenderTarget: change: ");
        r0.append(this.h);
        r0.append(", surfaceIsNull:");
        if (r4 == null) goto L6;
        r1 = false;
    L6:
        r0.append(r1);
        r0.append(", ");
        r0.append(r4);
        g.a(r0.toString());
        k().setSurface(r4);
    }

    @Override // r64.f
    public final void d(float r3) {
        TTVideoEngine r0 = k();
        PlaybackParams r1 = new PlaybackParams();
        r1.setSpeed(r3);
        r0.setPlaybackParams(r1);
        this.c = r3;
    }

    @Override // r64.f
    public final void f(r64.b r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        long r0 = r10.a;
        String r4 = "";
        if (this.b == true) goto L12;
        r64.d r2 = this.g;
        if (r2 == null) goto L13;
        r64.b r5 = this.e;
        if (r5 == null) goto L10;
        String r6 = r5.b;
        if (r6 == null) goto L10;
    L11:
        r2.h(r6);
    L10:
        r6 = "";
    L13:
        this.e = r10;
        String r3 = r10.e;
        boolean r7 = true;
        if (r3 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == false) goto L58;
    L24:
        k().setLooping(r10.g);
        k().setStartTime((int) r0);
        k().setVideoEngineCallback(this.j);
        List<r64.a> r1 = r10.c;
        if (r1 != null) goto L27;
        String r9 = "";
    L44:
        g.a("doPrepare: url=".concat(r4));
        if (TextUtils.isEmpty(r4) == true) goto L47;
        k().setDirectUrlUseDataLoader(r4, r9);
        g.a("doPrepare: call play() ");
        k().play();
        return;
    L47:
        String r11 = r10.f;
        if (r11 == null) goto L62;
        VideoRef r12 = new VideoRef();
        r12.extractFields(new JSONObject(r11));     // Catch: JSONException -> L52
    L54:
        VideoModel r13 = new VideoModel();
        r13.setVideoRef(r12);
        k().setVideoModel(r13);
        k().configResolution(Resolution.ExtremelyHigh);
        g.a("handleVideoModel: call play() ");
        k().play();
        return;
    L52:
        e = move-exception;
        e.toString();
        goto L54
    L62:
        return;
    L27:
        if (r1.isEmpty() == true) goto L60;
        List<String> r14 = ((r64.a) ListProtector.get(r1, 0)).c;
        if (r14 != null) goto L31;
    L33:
        r7 = false;
    L34:
        if (r7 == true) goto L63;
        List<String> r15 = ((r64.a) ListProtector.get(r1, 0)).c;
        if (r15 == null) goto L42;
        String r16 = (String) ListProtector.get(r15, 0);
        if (r16 == null) goto L42;
        r4 = r16;
    L42:
        r9 = ((r64.a) ListProtector.get(r1, 0)).b;
        this.f = r9;
        goto L44
    L63:
        return;
    L31:
        if (r14.isEmpty() != true) goto L33;
    L60:
        return;
    L58:
        JsonObject r17 = new JsonParser().parse(r10.e).getAsJsonObject();     // Catch: Exception -> L23
        float r18 = r17.get("loudness").getAsFloat();     // Catch: Exception -> L23
        float r19 = r17.get("peak").getAsFloat();     // Catch: Exception -> L23
        k().setFloatOption(345, r18);     // Catch: Exception -> L23
        k().setFloatOption(346, r19);     // Catch: Exception -> L23
        TTVideoEngine r20 = k();     // Catch: Exception -> L23
        int r21 = j64.b.a;     // Catch: Exception -> L23
        r20.setFloatOption(344, j64.b.a(AoHostService.class).b());     // Catch: Exception -> L23
        goto L24
    L16:
        if (r3.length() == 0) goto L19;
        r8 = false;
        goto L20
    L12:
        this.b = false;
        goto L13
    }

    @Override // r64.f
    public final void i(r64.b r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        k().setIntOption(100, 1);
        int r0 = this.k;
        if (r0 >= 3) goto L6;
        this.k = r0 + 1;
        g.a("count=" + this.k + ", preRender: " + r4.b);
        return;
    }

    @Override // r64.f
    public final void j(com.bytedance.awemeopen.infra.base.player.a r1) {
        this.g = r1;
    }

    @Override // r64.f
    public final void seekTo(long r2) {
        k().seekTo((int) r2, new com.bytedance.awemeopen.infra.plugs.ttvideoengine.a());
    }

    @Override // r64.f
    public final void setIsMute(boolean r2) {
        k().setIsMute(r2);
    }

    @Override // r64.f
    public final void b(List r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "preloadList");
        Intrinsics.checkNotNullParameter(r18, "sceneId");
        StringBuilder r0 = new StringBuilder("AoTTVideoEnginePlayer preload: ");
        r64.b r2 = (r64.b) CollectionsKt.firstOrNull(r17);
        if (r2 == null) goto L5;
        String r3 = r2.b;
    L6:
        r0.append(r3);
        g.b(r0.toString());
        Iterator r1 = r17.iterator();
    L8:
        if (r1.hasNext() == false) goto L42;
        r64.b r4 = (r64.b) r1.next();
        List<r64.a> r5 = r4.c;
        boolean r6 = true;
        if (r5 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == true) goto L8;
        List<r64.a> r8 = r4.c;
        if (r8 == null) goto L8;
        r64.a r9 = (r64.a) ListProtector.get(r8, 0);
        if (r9 == null) goto L8;
        List<String> r10 = r9.c;
        if (r10 != null) goto L25;
    L27:
        r6 = false;
    L28:
        if (r6 == true) goto L29;
        String r11 = r4.f;
        if (r11 == null) goto L8;
        VideoRef r12 = new VideoRef();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L39
        r12.extractFields(new JSONObject(r11));     // Catch: Throwable -> L39
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        VideoModel r14 = new VideoModel();
        r14.setVideoRef(r12);
        PreloaderVideoModelItem r15 = new PreloaderVideoModelItem(r14, Resolution.Standard, 512000, false);
        r15.setCallBackListener(new e());
        TTVideoEngine.addTask(r15);
    L39:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L29:
        long r19 = RangesKt.coerceAtMost(r9.a, 819200);
        String r110 = r9.b;
        List<String> r20 = r9.c;
        if (r20 == null) goto L32;
        String[] r111 = (String[]) r20.toArray(new String[0]);
    L33:
        PreloaderURLItem r21 = new PreloaderURLItem(r110, null, r19, r111);
        r21.setPriorityLevel(0);
        r21.setCallBackListener(new d());
        TTVideoEngine.addTask(r21);
        goto L8
    L32:
        r111 = null;
        goto L33
    L25:
        if ((!r10.isEmpty()) != true) goto L27;
    L12:
        if (r5.isEmpty() == true) goto L15;
        r7 = false;
        goto L16
    L42:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
