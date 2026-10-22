package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w {
    public final CopyOnWriteArrayList<p.a> a;
    public final p b;
    public final p c;
    public final p d;
    public final p e;
    public final p f;
    public final p g;

    public final boolean a() {
        if ((!this.b.b) == true) goto L5;
    L15:
        return false;
    L5:
        if ((!this.c.b) == false) goto L15;
        if ((!this.d.b) == false) goto L15;
        if ((!this.e.b) == false) goto L15;
        if ((!this.f.b) == false) goto L15;
        if ((!this.g.b) == false) goto L15;
        return true;
    }

    public final void d() {
        r.a("MusicPanelDownloader#pauseAll");
        this.b.e();
        this.c.e();
        this.d.e();
        this.e.e();
        this.f.e();
        this.g.e();
    }

    public final void f() {
        r.a("MusicPanelDownloader#resetAll");
        this.b.f();
        this.c.f();
        this.d.f();
        this.e.f();
        this.f.f();
        this.g.f();
        this.a.clear();
    }

    public final Pair<Boolean, MusicPanel> g() {
        r.a("MusicPanelDownloader#resumeAll");
        List r0 = CollectionsKt.listOf(new p[]{this.b, this.c, this.d, this.e, this.f, this.g});
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L30;
        p r4 = (p) r2.next();
        r4.getClass();
        if (((Boolean) KtvSettingHelper.h.getValue()).booleanValue() == false) goto L13;
        if (r4.d == null) goto L13;
        if (Downloader.getInstance(s1.getContext()).isDownloading(r4.d.getDownloadId()) == false) goto L13;
        android.util.Pair r5 = new android.util.Pair(Boolean.TRUE, r4.c);
    L28:
        r1.add(r5);
    L13:
        if (r4.d != null) goto L15;
        ALogger.e("KtvMusicDownloader", "resume failed: task is null");
        r5 = new android.util.Pair(Boolean.FALSE, r4.c);
        goto L28
    L15:
        Downloader r6 = Downloader.getInstance(s1.getContext());
        boolean r7 = r4.b;
        if (r7 == true) goto L18;
    L23:
        if (r7 == true) goto L25;
        String r8 = "not downloading";
    L26:
        ALogger.w("KtvMusicDownloader", "resume failed: ".concat(r8));
    L27:
        r4.f();
        r5 = new android.util.Pair(Boolean.FALSE, r4.c);
        goto L28
    L25:
        r8 = "not paused";
        goto L26
    L18:
        if (r4.e == false) goto L23;
        if (r6.canResume(r4.d.getDownloadId()) == false) goto L22;
        ALogger.i("KtvMusicDownloader", "resume: downloadId= " + r4.d.getDownloadId());
        r6.resume(r4.d.getDownloadId());
        r4.e = false;
        r5 = new android.util.Pair(Boolean.TRUE, r4.c);
        goto L28
    L22:
        ALogger.w("KtvMusicDownloader", "resume failed: downloadId=" + r4.d.getDownloadId() + "cannot be resumed");
        goto L27
    L30:
        if (r1.isEmpty() == true) goto L38;
        Iterator r3 = r1.iterator();
    L34:
        if (r3.hasNext() == false) goto L38;
        if (((Boolean) ((android.util.Pair) r3.next()).first).booleanValue() == true) goto L34;
        boolean r9 = false;
    L39:
        Iterator r11 = r1.iterator();
    L40:
        MusicPanel r12 = null;
        if (r11.hasNext() == false) goto L48;
        Object r13 = r11.next();
        if (((android.util.Pair) r13).second == null) goto L45;
        boolean r14 = true;
    L46:
        if (r14 == false) goto L40;
    L49:
        android.util.Pair r15 = (android.util.Pair) r13;
        if (r15 == null) goto L53;
        r12 = (MusicPanel) r15.second;
    L53:
        return new Pair(Boolean.valueOf(r9), r12);
    L45:
        r14 = false;
        goto L46
    L48:
        r13 = null;
    L38:
        r9 = true;
        goto L39
    }

    public final boolean b(long r2) {
        if (this.b.c(r2) == false) goto L5;
    L16:
        return true;
    L5:
        if (this.c.c(r2) == true) goto L16;
        if (this.d.c(r2) == true) goto L16;
        if (this.e.c(r2) == true) goto L16;
        if (this.f.c(r2) == true) goto L16;
        if (this.g.c(r2) == true) goto L16;
        return false;
    }

    public final Boolean c(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        if (this.b.d(r2).booleanValue() == false) goto L5;
    L16:
        boolean r3 = true;
    L18:
        return Boolean.valueOf(r3);
    L5:
        if (this.c.d(r2).booleanValue() == true) goto L16;
        if (this.d.d(r2).booleanValue() == true) goto L16;
        if (this.e.d(r2).booleanValue() == true) goto L16;
        if (this.f.d(r2).booleanValue() == true) goto L16;
        if (this.g.d(r2).booleanValue() == true) goto L16;
        r3 = false;
        goto L18
    }

    public final void e(p.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (this.a.contains(r2) == false) goto L5;
        return;
    L5:
        this.a.add(r2);
    }

    public w(p r2, p r3, p r4, p r5, p r6, p r7) {
        Intrinsics.checkNotNullParameter(r2, "lrcDownloader");
        Intrinsics.checkNotNullParameter(r3, "fullTrackDownloader");
        Intrinsics.checkNotNullParameter(r4, "accompanimentTrackDownloader");
        Intrinsics.checkNotNullParameter(r5, "midiDownloader");
        Intrinsics.checkNotNullParameter(r6, "videoDownloader");
        Intrinsics.checkNotNullParameter(r7, "vocalDownloader");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.a = new CopyOnWriteArrayList();
    }
}
