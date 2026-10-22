package sq1;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.JvmStatic;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final jq1.c a(long r6) {
        jq1.c r7 = (jq1.c) new Gson().fromJson(jc1.a.b().getSharedPreferences("live_vs_sp_play_progress_cache", 0).getString(String.valueOf(r6), ""), jq1.c.class);     // Catch: Exception -> L7
        if (r7 != null) goto L11;
        return new jq1.c(0, 0);
    L11:
        return r7;
    L8:
        return new jq1.c(0, 0);
    }

    @JvmStatic
    public static final void b(long r4, long r6) {
        SharedPreferences.Editor r0 = jc1.a.b().getSharedPreferences("live_vs_sp_play_progress_cache", 0).edit();
        r0.putString(String.valueOf(r4), GsonProtectorUtils.toJson(new Gson(), new jq1.c(r6, System.currentTimeMillis())));     // Catch: JSONException -> L5
    L7:
        r0.apply();
        return;
    L5:
        e = move-exception;
        ALogger.e("VSVideoProgressUtil", "save local progress failed " + e);
        goto L7
    }
}
