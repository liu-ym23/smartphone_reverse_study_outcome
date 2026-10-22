package mb0;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class b extends BaseMonitor {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static int a(Throwable r1) {
            if ((r1 instanceof ApiServerException) == false) goto L6;
            return ((ApiServerException) r1).getErrorCode();
        L6:
            if ((r1 instanceof NetworkErrorException) == false) goto L9;
            return ((NetworkErrorException) r1).statusCode;
        L9:
            if ((r1 instanceof ApiException) == true) goto L15;
            return 0;
        L15:
            return ((ApiException) r1).getErrorCode();
        }

        public static String b(Throwable r1) {
            if ((r1 instanceof ApiServerException) == false) goto L6;
            return ((ApiServerException) r1).getErrorMsg();
        L6:
            if ((r1 instanceof NetworkErrorException) == false) goto L9;
            return r1.getMessage();
        L9:
            if ((r1 instanceof Exception) == true) goto L15;
            return null;
        L15:
            return r1.getMessage();
        }
    }

    static {
    }

    public b() {
    }

    public static void l(JSONObject r2, MusicPanel r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$putAllPath");
        if (r3 == null) goto L6;
        r2.put("full_track_path", r3.n);
        r2.put("accompaniment_track_path", r3.o);
        r2.put("midi_path", r3.q);
        r2.put("lyrics_path", r3.l);
        return;
    }

    public static JSONObject m(JSONObject r1, Number r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$putErrorCode");
        Intrinsics.checkNotNullParameter(r2, "errorCode");
        return r1.put(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r2);
    }

    public static JSONObject n(JSONObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$putErrorMsg");
        Intrinsics.checkNotNullParameter(r2, "errorMsg");
        return r1.put(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r2);
    }

    public static JSONObject o(JSONObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$putLyricsUrl");
        Intrinsics.checkNotNullParameter(r2, "lyricsUrl");
        return r1.put("lyrics_url", r2);
    }

    public static JSONObject p(JSONObject r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$putMusicId");
        return r1.put("music_id", String.valueOf(r2));
    }

    public static JSONObject q(JSONObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$putMusicName");
        Intrinsics.checkNotNullParameter(r2, "musicName");
        return r1.put("music_name", r2);
    }

    public static JSONObject r(JSONObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$putProcess");
        Intrinsics.checkNotNullParameter(r2, "process");
        return r1.put("in_process", r2);
    }
}
