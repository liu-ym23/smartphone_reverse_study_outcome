package com.bytedance.awemeopen.infra.base.player;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.view.Surface;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.infra.base.debug.AoDebug;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoRequestType;
import com.bytedance.awemeopen.infra.base.net.download.AoDownloadCallback;
import com.bytedance.awemeopen.infra.base.net.download.AoDownloadRequest;
import com.bytedance.awemeopen.infra.base.net.download.BdpDownloadModule;
import com.bytedance.awemeopen.infra.base.net.download.BdpDownloadTask;
import com.bytedance.awemeopen.servicesapi.player.AoPlayerService;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoDefaultPlayer implements g {
    public final r64.f a;
    public PlayState b;
    public final Lazy c;
    public final Lazy d;
    public final e e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public final AtomicBoolean h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final boolean b() {
        return this.h.get();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final String g() {
        return this.a.getPlayId();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final long getCurrentPosition() {
        return this.a.getCurrentPosition();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final long getDuration() {
        return this.a.getDuration();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final float getPlaySpeed() {
        return this.a.e();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final String getPlayerType() {
        this.a.getPlayerType();
        return "ttvideoengine_0";
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final long getWatchDuration() {
        return this.a.getWatchDuration();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final boolean isPlaying() {
        return this.a.isPlaying();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void pause() {
        this.a.pause();
        this.b = PlayState.STATE_PAUSE;
        if (this.g.get() == true) goto L6;
        this.f.set(true);
        return;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void release() {
        this.a.release();
        this.b = PlayState.STATE_RELEASE;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void resume() {
        this.a.resume();
        this.b = PlayState.STATE_START;
        if (this.g.get() == true) goto L6;
        this.f.set(true);
        return;
    }

    public AoDefaultPlayer() {
        int r0 = j64.b.a;
        AoPlayerService r1 = j64.b.a(AoPlayerService.class);
        r64.e r2 = new r64.e();
        AoDebug.b();
        Intrinsics.checkNotNullParameter(AoEnv.b(), "<set-?>");
        this.a = r1.Z0(r2);
        this.b = PlayState.STATE_RESET;
        this.c = LazyKt.lazy(AoDefaultPlayer$isPreRender$2.INSTANCE);
        this.d = LazyKt.lazy(AoDefaultPlayer$skipDoublePrepare$2.INSTANCE);
        this.e = new e();
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final PlayState getPlayState() {
        return this.b;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void a(Surface r2) {
        this.a.a(r2);
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void d(float r2) {
        this.a.d(r2);
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void e(j r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        this.f.set(false);
        this.g.set(false);
        this.h.set(false);
        this.b = PlayState.STATE_PREPARE;
        this.a.f(c.c(r3));
        if (Intrinsics.areEqual(AoEnv.d(), "1967") == true) goto L5;
        return;
    L5:
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L8;
        return;
    L8:
        if (this.a.c() != 5) goto L10;
    L11:
        this.a.stop();
        this.b = PlayState.STATE_STOP;
        this.a.f(c.c(r3));
        this.b = PlayState.STATE_START;
        return;
    L10:
        if (this.a.c() == 6) goto L11;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void f(m r26) {
        Intrinsics.checkNotNullParameter(r26, "videoThumbInfo");
        final e r3 = this.e;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r26, "videoThumbInfo");
        r3.b = r26;
        if (r26.a == null) goto L82;
        String r1 = r26.b;
        boolean r4 = false;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L85;
        Map<String, m> r5 = r3.c;
        String r6 = r26.b;
        Intrinsics.checkNotNull(r6);
        m r7 = (m) ((LinkedHashMap) r5).get(r6);
        if (r7 == null) goto L24;
        Integer r8 = r7.h;
        if (r8 != null) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 != true) goto L24;
        boolean r10 = true;
    L25:
        if (r10 == true) goto L86;
        PolarisFileWrapper r11 = r3.d;
        String r12 = r26.a;
        Intrinsics.checkNotNull(r12);
        final PolarisFileWrapper r13 = new PolarisFileWrapper(r11, r12);
        PolarisFileWrapper r14 = r3.d;
        long r15 = 0;
        if (r14 == null) goto L48;
        if (r14.exists() == false) goto L48;
        if (r14.isDirectory() == false) goto L46;
        LinkedList r16 = new LinkedList();
        r16.add(r14);
    L36:
        if (r16.size() <= 0) goto L48;
        File r17 = (File) r16.pollLast();
        if (r17 == null) goto L36;
        if (r17.isDirectory() == true) goto L42;
        r15 = r15 + r17.length();
        goto L36
    L42:
        File[] r18 = r17.listFiles();
        if (r18 == null) goto L36;
        Collections.addAll(r16, r18);
        goto L36
    L46:
        r15 = r14.length();
    L48:
        if (r15 <= 10485760) goto L50;
        com.bytedance.awemeopen.infra.util.f.delete(r3.d);
        ((LinkedHashMap) r3.c).clear();
    L50:
        String r19 = r26.b;
        Intrinsics.checkNotNull(r19);
        r3.c.put(r19, r26);
        if ((System.currentTimeMillis() - r3.a) <= 500) goto L83;
        m r20 = (m) ((LinkedHashMap) r3.c).get(r19);
        if (r20 == null) goto L69;
        Integer r21 = r20.h;
        if (r21 != null) goto L58;
    L59:
        Integer r22 = r20.h;
        if (r22 != null) goto L63;
    L65:
        boolean r23 = false;
    L67:
        if (r23 != true) goto L69;
        r4 = true;
        goto L69
    L63:
        if (r22.intValue() != 3) goto L65;
    L66:
        r23 = true;
        goto L67
    L58:
        if (r21.intValue() == 0) goto L66;
    L69:
        if (r4 == false) goto L84;
        r3.a = System.currentTimeMillis();
        r26.h = 1;
        Function0<String> r0 = AoNet.a;
        AoFromSource r24 = AoFromSource.download;
        Intrinsics.checkNotNullParameter(r24, "from");
        AoRequestType r110 = AoRequestType.HOST;
        ArrayList r25 = new ArrayList();
        Intrinsics.checkNotNullParameter(r19, "url");
        Intrinsics.checkNotNullParameter(r13, "targetFile");
        AoDownloadRequest r27 = new AoDownloadRequest(r19, r13, r24, null, new q64.c(r25), false, false, false, r110, 60000, 0, null, true, true, 0, null);
        AoDownloadCallback r28 = new AoVideoThumbFetcher$downLoadThumb$1(r3, r13);
        Intrinsics.checkNotNullParameter(r27, "request");
        ConcurrentHashMap<Integer, BdpDownloadTask> r29 = BdpDownloadModule.a;
        BdpDownloadModule.a((Application) AoNet.c.getValue(), r27, r28);
        return;
    L84:
        return;
    L83:
        return;
    L86:
        return;
    L19:
        if (r8.intValue() != 2) goto L21;
        r9 = true;
    L24:
        r10 = false;
        goto L25
    L85:
        return;
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
        goto L11
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final Bitmap h(long r9) {
        e r0 = this.e;
        m r1 = r0.b;
        if (r1 == null) goto L82;
        Integer r2 = r1.g;
        if (r2 == null) goto L80;
        boolean r3 = true;
        if (r2.intValue() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L81;
        m r5 = r0.b;
        if (r5 == null) goto L15;
        String r6 = r5.b;
    L16:
        if (r6 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == true) goto L83;
        Map<String, m> r8 = r0.c;
        m r10 = r0.b;
        Intrinsics.checkNotNull(r10);
        String r11 = r10.b;
        Intrinsics.checkNotNull(r11);
        m r12 = (m) ((LinkedHashMap) r8).get(r11);
        if (r12 == null) goto L35;
        Integer r13 = r12.h;
        if (r13 != null) goto L30;
    L32:
        boolean r14 = false;
    L33:
        if (r14 != true) goto L35;
    L36:
        if (r3 == false) goto L84;
        int r15 = ((int) r9) / 1000;
        m r16 = r0.b;
        if (r16 == null) goto L41;
        Integer r17 = r16.g;
    L42:
        Intrinsics.checkNotNull(r17);
        int r18 = r15 / r17.intValue();
        Rect r19 = new Rect();
        m r20 = r0.b;
        if (r20 == null) goto L47;
        Integer r21 = r20.e;
        if (r21 == null) goto L47;
        int r22 = r21.intValue();
    L48:
        m r23 = r0.b;
        if (r23 == null) goto L53;
        Integer r24 = r23.d;
        if (r24 == null) goto L53;
        int r25 = r24.intValue();
    L54:
        m r26 = r0.b;
        if (r26 == null) goto L59;
        Integer r27 = r26.c;
        if (r27 == null) goto L59;
        int r28 = r27.intValue();
    L60:
        m r29 = r0.b;
        if (r29 == null) goto L65;
        Integer r30 = r29.f;
        if (r30 == null) goto L65;
        int r31 = r30.intValue();
    L67:
        if ((r18 + 1) <= r31) goto L69;
        r18 = r31 - 1;
    L69:
        int r32 = (r18 % r22) * r25;
        r19.left = r32;
        int r110 = (r18 / r22) * r28;
        r19.top = r110;
        r19.right = r32 + r25;
        r19.bottom = r110 + r28;
        StringBuilder r111 = new StringBuilder();     // Catch: Exception -> L77
        r111.append(new PolarisFileWrapper(y54.a.a().getCacheDir(), "video_thumb").getPath());     // Catch: Exception -> L77
        r111.append('/');     // Catch: Exception -> L77
        m r33 = r0.b;     // Catch: Exception -> L77
        if (r33 == null) goto L73;
        String r34 = r33.a;     // Catch: Exception -> L77
    L74:
        r111.append(r34);     // Catch: Exception -> L77
        BitmapRegionDecoder r112 = BitmapRegionDecoder.newInstance(r111.toString(), false);     // Catch: Exception -> L77
        Bitmap r35 = r112.decodeRegion(r19, null);     // Catch: Exception -> L77
        r112.recycle();     // Catch: Exception -> L77
        return r35;
    L73:
        r34 = null;
    L85:
        return null;
    L65:
        r31 = 0;
    L59:
        r28 = 0;
    L53:
        r25 = 0;
    L47:
        r22 = 0;
        goto L48
    L41:
        r17 = null;
        goto L42
    L84:
        return null;
    L30:
        if (r13.intValue() != 2) goto L32;
        r14 = true;
    L35:
        r3 = false;
        goto L36
    L83:
        return null;
    L18:
        if (r6.length() == 0) goto L21;
        r7 = false;
        goto L22
    L15:
        r6 = null;
        goto L16
    L81:
        return null;
    L10:
        r4 = false;
        goto L11
    L80:
        return null;
    L82:
        return null;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void i(FrameLayout r1) {
        this.a.g();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void k(k r3) {
        r64.f r0 = this.a;
        if (r3 != null) goto L5;
        com.bytedance.awemeopen.infra.base.player.a r4 = null;
    L6:
        r0.j(r4);
        return;
    L5:
        r4 = new com.bytedance.awemeopen.infra.base.player.a(this, r3);
        goto L6
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void seekTo(long r2) {
        this.a.seekTo(r2);
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void setIsMute(boolean r2) {
        this.a.setIsMute(r2);
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void c(Surface r1, j r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L6;
        this.a.i(c.c(r2));
        return;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.g
    public final void j(List<j> r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "preloadList");
        r64.f r4 = this.a;
        List r5 = c.b(r1);
        if (r3 != null) goto L5;
        r3 = "ao_simplayer";
    L5:
        r4.b(r5, r3);
    }
}
