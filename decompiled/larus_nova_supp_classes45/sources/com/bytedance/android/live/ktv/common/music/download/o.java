package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o extends AbsDownloadListener {
    public final /* synthetic */ p.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ p d;

    public final void onProgress(DownloadInfo r3) {
        super.onProgress(r3);
        if (r3 == null) goto L6;
        this.a.c(this.d.c, r3.getDownloadProcess());
        return;
    }

    public final void onSuccessed(DownloadInfo r18) {
        super.onSuccessed(r18);
        p r1 = this.d;
        r1.b = false;
        this.a.a(r1.c, this.b, r1.a.getType());
        String r2 = "";
        if (r18 == null) goto L5;
        String r3 = r18.getUrl();
    L6:
        p r4 = this.d;
        v r5 = r4.a;
        if ((r5 instanceof x) == false) goto L10;
        mb0.d.d(r4.c, "song", r3, System.currentTimeMillis() - this.c.longValue());
        return;
    L10:
        if ((r5 instanceof d) == false) goto L13;
        mb0.d.d(r4.c, "full_track", r3, System.currentTimeMillis() - this.c.longValue());
        return;
    L13:
        if ((r5 instanceof a) == false) goto L16;
        mb0.d.d(r4.c, "accompaniment_track", r3, System.currentTimeMillis() - this.c.longValue());
        return;
    L16:
        if ((r5 instanceof t) == false) goto L32;
        mb0.d.d(r4.c, KtvSubElement.LYRIC, r3, System.currentTimeMillis() - this.c.longValue());
        long r6 = this.d.c.a.getId();
        long r7 = System.currentTimeMillis() - this.c.longValue();
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        mb0.c r8 = mb0.d.a;
        if (r8 == null) goto L20;
        r8.g(r6, r3, r7);
    L20:
        MusicPanel r9 = this.d.c;
        int r11 = mb0.f.a;
        Intrinsics.checkNotNullParameter(r9, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        JSONObject r15 = new JSONObject();
        KtvMusic r12 = r9.a;
        if (r12 == null) goto L23;
        Long r13 = Long.valueOf(r12.getId());
    L24:
        mb0.e.a(r15, r13.longValue());
        KtvMusic r14 = r9.a;
        if (r14 == null) goto L30;
        String r16 = r14.getTitle();
        if (r16 == null) goto L30;
        r2 = r16;
    L30:
        mb0.e.b(r15, r2);
        r15.put(LiveSlardarConstants.EXTRA_KEY_URL, r3);
        int r17 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "lyricsDownload", 0, null, r15, 88);
        return;
    L23:
        r13 = null;
        goto L24
    L32:
        if ((r5 instanceof u) == false) goto L39;
        mb0.d.d(r4.c, KtvSubElement.MIDI, r3, System.currentTimeMillis() - this.c.longValue());
        return;
    L39:
        return;
    L5:
        r3 = "";
        goto L6
    }

    public final void onFailed(DownloadInfo r13, BaseException r14) {
        super.onFailed(r13, r14);
        int r1 = 0;
        this.d.b = false;
        if (r14 == null) goto L5;
        int r0 = r14.getErrorCode();
    L6:
        p.a r2 = this.a;
        MusicPanel r3 = this.d.c;
        String r4 = "";
        if (r14 == null) goto L9;
        String r5 = r14.getErrorMessage();
    L10:
        r2.b(r3, r0, r5);
        if (r13 == null) goto L13;
        String r15 = r13.getUrl();
    L14:
        p r6 = this.d;
        v r7 = r6.a;
        if ((r7 instanceof x) == false) goto L23;
        MusicPanel r8 = r6.c;
        if (r14 == null) goto L19;
        r1 = r14.getErrorCode();
    L19:
        if (r14 == null) goto L21;
        r4 = r14.getErrorMessage();
    L21:
        mb0.d.c(r8, "song", r15, r1, r4);
        return;
    L23:
        if ((r7 instanceof d) == false) goto L31;
        MusicPanel r9 = r6.c;
        if (r14 == null) goto L27;
        r1 = r14.getErrorCode();
    L27:
        if (r14 == null) goto L29;
        r4 = r14.getErrorMessage();
    L29:
        mb0.d.c(r9, "full_track", r15, r1, r4);
        return;
    L31:
        if ((r7 instanceof a) == false) goto L39;
        MusicPanel r11 = r6.c;
        if (r14 == null) goto L35;
        r1 = r14.getErrorCode();
    L35:
        if (r14 == null) goto L37;
        r4 = r14.getErrorMessage();
    L37:
        mb0.d.c(r11, "accompaniment_track", r15, r1, r4);
        return;
    L39:
        if ((r7 instanceof t) == false) goto L68;
        long r12 = r6.c.a.getId();
        if (r14 == null) goto L43;
        int r16 = r14.getErrorCode();
    L44:
        if (r14 == null) goto L46;
        String r17 = r14.getErrorMessage();
    L47:
        mb0.c r18 = mb0.d.a;
        Intrinsics.checkNotNullParameter(r15, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r17, "errorMsg");
        mb0.c r19 = mb0.d.a;
        if (r19 == null) goto L50;
        r19.c(r12, r15, r16, r17);
    L50:
        MusicPanel r21 = this.d.c;
        if (r14 == null) goto L53;
        r1 = r14.getErrorCode();
    L53:
        if (r14 == null) goto L55;
        String r22 = r14.getErrorMessage();
    L56:
        mb0.d.c(r21, KtvSubElement.LYRIC, r15, r1, r22);
        MusicPanel r23 = this.d.c;
        int r24 = mb0.f.a;
        Intrinsics.checkNotNullParameter(r23, "musicPanel");
        Intrinsics.checkNotNullParameter(r14, "throwable");
        Intrinsics.checkNotNullParameter(r15, LiveSlardarConstants.EXTRA_KEY_URL);
        JSONObject r110 = new JSONObject();
        KtvMusic r25 = r23.a;
        if (r25 == null) goto L59;
        Long r26 = Long.valueOf(r25.getId());
    L60:
        mb0.e.a(r110, r26.longValue());
        KtvMusic r27 = r23.a;
        if (r27 == null) goto L66;
        String r28 = r27.getTitle();
        if (r28 == null) goto L66;
        r4 = r28;
    L66:
        mb0.e.b(r110, r4);
        r110.put(LiveSlardarConstants.EXTRA_KEY_URL, r15);
        nd0.c.a.getClass();
        Pair r111 = nd0.c.t(r14, r110);
        int r112 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "lyricsDownload", ((Number) r111.getFirst()).intValue(), (String) r111.getSecond(), r110, 64);
        return;
    L59:
        r26 = null;
        goto L60
    L55:
        r22 = "";
        goto L56
    L46:
        r17 = "";
        goto L47
    L43:
        r16 = 0;
        goto L44
    L68:
        if ((r7 instanceof u) == false) goto L80;
        MusicPanel r29 = r6.c;
        if (r14 == null) goto L72;
        r1 = r14.getErrorCode();
    L72:
        if (r14 == null) goto L74;
        r4 = r14.getErrorMessage();
    L74:
        mb0.d.c(r29, KtvSubElement.MIDI, r15, r1, r4);
        return;
    L80:
        return;
    L13:
        r15 = "";
        goto L14
    L9:
        r5 = "";
        goto L10
    L5:
        r0 = 0;
        goto L6
    }

    public o(p r1, q r2, String r3, Long r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
