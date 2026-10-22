package v4;

import com.bytedance.apm6.util.BatchLogWrapUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static JSONArray a(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        JSONArray r11 = r10.optJSONArray(BatchLogWrapUtils.KEY_WRAPPER_ARRAY_DATA);
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11;
    }
}
