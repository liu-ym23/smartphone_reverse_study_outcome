package mb0;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(int r8, boolean r9, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "interactId");
        JSONObject r6 = new JSONObject();
        r6.put("buffer_size", r8);
        r6.put("isRetry", r9);
        r6.put("interact_id", r11);
        r6.put("anchor_is_singer", r12);
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.AILyricsRecognize, MultiTraceData.TraceEvent.LyricsRecognize, "startRecognize", 0, null, r6, 88);
    }

    public static void b(boolean r7, String r8, String r9, Integer r11) {
        JSONObject r5 = new JSONObject();
        r5.put("is_recognizing", r7);
        boolean r0 = true;
        if (r8.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L9;
        r5.put("song_id", r8);
    L9:
        if (r9.length() == 0) goto L12;
        r0 = false;
    L12:
        if (r0 == true) goto L14;
        r5.put("song_name", r9);
    L14:
        if (r11 == null) goto L16;
        r5.put("similarity", r11.intValue());
    L16:
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.AILyricsRecognize, MultiTraceData.TraceEvent.LyricsRecognize, "stopRecognize", 0, null, r5, 88);
        return;
    L5:
        r12 = false;
        goto L6
    }
}
