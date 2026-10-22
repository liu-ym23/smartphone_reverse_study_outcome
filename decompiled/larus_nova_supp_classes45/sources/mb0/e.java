package mb0;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final void a(JSONObject r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$putMusicId");
        r1.put("music_id", String.valueOf(r2));
    }

    public static final void b(JSONObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$putMusicName");
        Intrinsics.checkNotNullParameter(r2, "musicName");
        r1.put("music_name", r2);
    }
}
