package i0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(@NonNull y.e r10, boolean r11) {
        r10.f(e.a().b(r11));
    }

    public static void b(@NonNull JSONObject r10, String r11) {
        r10.put("timestamp", System.currentTimeMillis());
        r10.put("crash_time", System.currentTimeMillis());
        r10.put("is_main_process", com.bytedance.apm.d.I());
        r10.put("process_name", com.bytedance.apm.d.h());
        r10.put(Constants.EVENT_TYPE, r11);
        r10.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    @NonNull
    public static void c(@NonNull y.e r10) {
        String r11 = e.a().c();
        JSONObject r12 = r10.f13619e;
        if (r12 != null) goto L14;
        r12 = new JSONObject();
    L14:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        r11 = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: JSONException -> L13
    L8:
        r12.put("scene", r11);     // Catch: JSONException -> L13
        r12.put("process_name", com.bytedance.apm.d.h());     // Catch: JSONException -> L13
        r12.put("is_main_process", com.bytedance.apm.d.I());     // Catch: JSONException -> L13
        if (r12.isNull("is_front") == false) goto L11;
        r12.put("is_front", ActivityLifeObserver.getInstance().isForeground());     // Catch: JSONException -> L13
    L11:
        r10.f13619e = r12;     // Catch: JSONException -> L13
        return;
    }
}
