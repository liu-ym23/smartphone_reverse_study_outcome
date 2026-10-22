package com.bytedance.android.live.platformplayer.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.net.URL;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class StreamVersionDiffUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(StreamVersionDiffUtils$enable$2.INSTANCE);
        b = LazyKt.lazy(StreamVersionDiffUtils$enableRePullByStreamId$2.INSTANCE);
    }

    public static String a(String r3) {
        JSONObject r4 = new JSONObject(r3).optJSONObject("data");     // Catch: Exception -> L28
        if (r4 == null) goto L8;
        JSONObject r5 = r4.optJSONObject("origin");     // Catch: Exception -> L28
        if (r5 == null) goto L8;
        JSONObject r6 = r5.optJSONObject("main");     // Catch: Exception -> L28
    L9:
        if (r6 == null) goto L13;
        Object r1 = r6.get("flv");     // Catch: Exception -> L28
        if (r1 == null) goto L13;
        String r2 = r1.toString();     // Catch: Exception -> L28
    L14:
        if (r2 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == false) goto L26;
        if (r6 == null) goto L25;
        Object r8 = r6.get("hls");     // Catch: Exception -> L28
        if (r8 == null) goto L25;
        r2 = r8.toString();     // Catch: Exception -> L28
    L25:
        r2 = null;
    L26:
        return new URL(r2).getHost();
    L16:
        if (r2.length() == 0) goto L19;
        r7 = false;
    L13:
        r2 = null;
    L8:
        r6 = null;
    L28:
        com.bytedance.android.live.player.utils.b.d("[StreamVersionDiffUtils::getStreamUrlFromStreamData]: error parsing streamData");
        return null;
    }

    public static boolean b(IBaseStreamUrl r6, StreamUrl r7, ILivePlayerClient r8) {
        if (((Boolean) b.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r6 == null) goto L26;
        if (r7 == null) goto L29;
        long r2 = r6.getId();
        long r9 = r7.getId();
        if (r2 != 0) goto L18;
        if (r8 == null) goto L16;
        String r10 = r8.getPlayerStreamId();
        if (r10 == null) goto L16;
        Long r11 = StringsKt.toLongOrNull(r10);
        if (r11 == null) goto L16;
        r2 = r11.longValue();
    L16:
        r2 = 0;
    L18:
        if (r2 != 0) goto L20;
        return false;
    L20:
        if (r9 != 0) goto L23;
        return false;
    L23:
        if (r2 == r9) goto L28;
        return true;
    L28:
        return false;
    L29:
        return false;
    L26:
        return false;
    }
}
