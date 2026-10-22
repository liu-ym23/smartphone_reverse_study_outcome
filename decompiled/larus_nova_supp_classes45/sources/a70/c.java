package a70;

import com.bytedance.android.live.core.setting.d6;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(int r5, String r6, String r7, Long r8, int r9, int r11, String r12) {
        JSONObject r0 = new JSONObject();
        r0.put("status_code", r5);
        r0.put("data_type", r6);
        r0.put("update_type", r7);
        JSONObject r1 = new JSONObject();
        if (r8 == null) goto L5;
        r1.put("update_time", r8.longValue());
    L5:
        JSONObject r2 = new JSONObject();
        r2.put("update_size", r9);
        r2.put("delete_size", r11);
        r2.put("msg", r12);
        d6.d("ttlive_setting_update_v2", r0, r1, r2);
        b.e("_SLADAR", "statusCode = " + r5 + ", dataType = " + r6 + ", updateType = " + r7 + ", time = " + r8 + ", updateSize = " + r9 + ",  deleteSize = " + r11 + ", msg = " + r12);
    }
}
