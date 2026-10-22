package mb0;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public f() {
    }

    static {
    }

    public static void c(MusicPanel r7) {
        JSONObject r5 = new JSONObject();
        if (r7 == null) goto L14;
        KtvMusic r0 = r7.a;
        if (r0 == null) goto L7;
        Long r1 = Long.valueOf(r0.getId());
    L8:
        e.a(r5, r1.longValue());
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L12;
        String r9 = r8.getTitle();
        if (r9 == null) goto L12;
    L13:
        e.b(r5, r9);
    L12:
        r9 = "";
        goto L13
    L7:
        r1 = null;
    L14:
        int r11 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "liveCoreStartBgm", 0, null, r5, 88);
    }

    public static void d(MusicPanel r7) {
        JSONObject r5 = new JSONObject();
        if (r7 == null) goto L14;
        KtvMusic r0 = r7.a;
        if (r0 == null) goto L7;
        Long r1 = Long.valueOf(r0.getId());
    L8:
        e.a(r5, r1.longValue());
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L12;
        String r9 = r8.getTitle();
        if (r9 == null) goto L12;
    L13:
        e.b(r5, r9);
    L12:
        r9 = "";
        goto L13
    L7:
        r1 = null;
    L14:
        int r11 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "liveCoreStopBgm", 0, null, r5, 88);
    }

    public static void i(MusicPanel r8) {
        Intrinsics.checkNotNullParameter(r8, "musicPanel");
        JSONObject r6 = new JSONObject();
        b(r8, r6);
        int r9 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.AddSongChain, "musicDownload", 0, null, r6, 88);
    }

    public static void o(MusicPanel r8) {
        Intrinsics.checkNotNullParameter(r8, "musicPanel");
        JSONObject r6 = new JSONObject();
        b(r8, r6);
        int r9 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "setBgmResourceError", -1, "resources are unavailable", r6, 64);
    }

    public static void b(MusicPanel r4, JSONObject r5) {
        KtvMusic r0 = r4.a;
        Integer r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.getId());
    L6:
        e.a(r5, r2.longValue());
        KtvMusic r3 = r4.a;
        if (r3 == null) goto L10;
        String r6 = r3.getTitle();
        if (r6 == null) goto L10;
    L11:
        e.b(r5, r6);
        KtvMusic r7 = r4.a;
        if (r7 == null) goto L14;
        r1 = Integer.valueOf(r7.getMLyricType());
    L14:
        int r8 = r1.intValue();
        Intrinsics.checkNotNullParameter(r5, "$this$putLyricsType");
        r5.put("lyrics_type", r8);
        Intrinsics.checkNotNullParameter(r5, "$this$putAllPath");
        r5.put("full_track_path", r4.n);
        r5.put("accompaniment_track_path", r4.o);
        r5.put("midi_path", r4.q);
        r5.put("lyrics_path", r4.l);
        return;
    L10:
        r6 = "";
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static void p(MusicPanel r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "musicPanel");
        Intrinsics.checkNotNullParameter(r9, "msg");
        JSONObject r6 = new JSONObject();
        b(r8, r6);
        r6.put("track", r8.h());
        int r11 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "setTrackError", -1, r9, r6, 64);
    }

    public static void q(Long r7, String r8) {
        JSONObject r5 = new JSONObject();
        if (r7 == null) goto L5;
        r7.longValue();
        r5.put("songId", r7.longValue());
    L5:
        if (r8 != null) goto L7;
    L10:
        boolean r9 = true;
    L11:
        if (r9 == true) goto L13;
        r5.put("musicName", r8);
    L13:
        int r11 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "transitionBeginSing", 0, null, r5, 88);
        return;
    L7:
        if (r8.length() == 0) goto L10;
        r9 = false;
        goto L11
    }

    public static void a(String r8, boolean r9, String r11) {
        Intrinsics.checkNotNullParameter(r8, "buttonType");
        JSONObject r6 = new JSONObject();
        r6.put("buttonType", r8);
        r6.put("checked", r9);
        if (r11 == null) goto L5;
        r6.put("musicName", r11);
    L5:
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.KtvFeatureSwitch, "tonePanelSubSwitchClick", 0, null, r6, 88);
    }

    public static void f(long r7, int r9, int r11) {
        JSONObject r5 = new JSONObject();
        e.a(r5, r7);
        r5.put("lyrics_type", r9);
        r5.put("lyrics_size", r11);
        int r8 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "lyricsShow", 0, null, r5, 88);
    }

    public static void h(MusicPanel r8, int r9, String r11) {
        Intrinsics.checkNotNullParameter(r8, "musicPanel");
        Intrinsics.checkNotNullParameter(r11, "errMsg");
        JSONObject r6 = new JSONObject();
        b(r8, r6);
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.AddSongChain, "musicDownload", r9, r11, r6, 64);
    }

    public static void k(MusicPanel r8, Throwable r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "musicPanel");
        Intrinsics.checkNotNullParameter(r9, "throwable");
        JSONObject r6 = new JSONObject();
        b(r8, r6);
        r6.put("online", String.valueOf(r11));
        nd0.c.a.getClass();
        Pair r12 = nd0.c.t(r9, r6);
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.SongControl, "removeSong", ((Number) r12.getFirst()).intValue(), (String) r12.getSecond(), r6, 64);
    }

    public static void l(MusicPanel r8, String r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "musicPanel");
        Intrinsics.checkNotNullParameter(r9, "logId");
        JSONObject r6 = new JSONObject();
        b(r8, r6);
        r6.put("logId", r9);
        r6.put("online", String.valueOf(r11));
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.SongControl, "removeSong", 0, null, r6, 88);
    }

    public static void m(MusicPanel r8, float r9, Throwable r11) {
        Intrinsics.checkNotNullParameter(r11, "throwable");
        JSONObject r6 = new JSONObject();
        if (r8 == null) goto L7;
        KtvMusic r0 = r8.a;
        if (r0 == null) goto L7;
        long r1 = r0.getMId();
    L8:
        e.a(r6, r1);
        if (r8 == null) goto L14;
        KtvMusic r12 = r8.a;
        if (r12 == null) goto L14;
        String r13 = r12.getTitle();
        if (r13 == null) goto L14;
    L15:
        e.b(r6, r13);
        r6.put("score", Float.valueOf(r9));
        nd0.c.a.getClass();
        Pair r14 = nd0.c.t(r11, r6);
        int r15 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "reportMidiScore", ((Number) r14.getFirst()).intValue(), (String) r14.getSecond(), r6, 64);
        return;
    L14:
        r13 = "";
    L7:
        r1 = 0;
        goto L8
    }

    public static void r(long r8, Throwable r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "throwable");
        JSONObject r6 = new JSONObject();
        e.a(r6, r8);
        r6.put("action", r12);
        nd0.c.a.getClass();
        Pair r9 = nd0.c.t(r11, r6);
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.SingFlow, "updateSingerState", ((Number) r9.getFirst()).intValue(), (String) r9.getSecond(), r6, 64);
    }

    public static void s(long r8, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "logId");
        JSONObject r6 = new JSONObject();
        e.a(r6, r8);
        r6.put("logId", r11);
        r6.put("action", r12);
        int r9 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.SingFlow, "updateSingerState", 0, null, r6, 88);
    }

    public static void j(String r7, Map r8, Throwable r9, int r11) {
        if ((r11 & 4) == 0) goto L5;
        r9 = null;
    L5:
        Intrinsics.checkNotNullParameter(r7, "step");
        Intrinsics.checkNotNullParameter(r8, "extraParams");
        JSONObject r5 = new JSONObject();
        Iterator r12 = r8.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) r12.next();
        r5.put((String) r13.getKey(), r13.getValue());
        goto L7
    L9:
        nd0.c.a.getClass();
        Pair r14 = nd0.c.t(r9, r5);
        int r3 = ((Number) r14.getFirst()).intValue();
        String r4 = (String) r14.getSecond();
        int r15 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.OPEN_ORDER_SONG_PANEL, r7, r3, r4, r5, 64);
    }

    @JvmStatic
    public static final void e(long r9, String r11, int r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "lyricsUrl");
        Intrinsics.checkNotNullParameter(r14, "errorMsg");
        JSONObject r7 = new JSONObject();
        e.a(r7, r9);
        Intrinsics.checkNotNullParameter(r7, "$this$putLyricsUrl");
        Intrinsics.checkNotNullParameter(r11, "lyricsUrl");
        r7.put("lyrics_url", r11);
        Intrinsics.checkNotNullParameter(r7, "$this$putLyricsType");
        r7.put("lyrics_type", r12);
        int r15 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "lyricsParse", r13, r14, r7, 64);
    }

    public static void g(Long r8, String r9, String r11, float r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "nickname");
        JSONObject r6 = new JSONObject();
        if (r8 == null) goto L5;
        long r1 = r8.longValue();
    L6:
        e.a(r6, r1);
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        e.b(r6, r9);
        r6.put("nickname", r11);
        r6.put("score", Float.valueOf(r12));
        r6.put("isHighScoreSong", r13);
        int r14 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "midiFeedbackShow", 0, null, r6, 88);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public static void n(MusicPanel r7, boolean r8, boolean r9, Long r11, float r12) {
        JSONObject r5 = new JSONObject();
        long r0 = 0;
        if (r7 == null) goto L7;
        KtvMusic r2 = r7.a;
        if (r2 == null) goto L7;
        long r3 = r2.getMId();
    L8:
        e.a(r5, r3);
        if (r7 == null) goto L14;
        KtvMusic r13 = r7.a;
        if (r13 == null) goto L14;
        String r14 = r13.getTitle();
        if (r14 == null) goto L14;
    L15:
        e.b(r5, r14);
        r5.put("enoughTime", r8);
        r5.put("isHighScoreSong", r9);
        if (r11 == null) goto L18;
        r0 = r11.longValue();
    L18:
        r5.put("rank", r0);
        r5.put("score", Float.valueOf(r12));
        int r15 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "reportMidiScore", 0, null, r5, 88);
        return;
    L14:
        r14 = "";
    L7:
        r3 = 0;
        goto L8
    }
}
