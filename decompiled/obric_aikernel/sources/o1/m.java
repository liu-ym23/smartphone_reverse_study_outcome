package o1;

import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.oaid.OaidModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static JSONObject a(JSONObject r10) {
        if (r10 == null) goto L17;
        JSONObject r11 = new JSONObject();
        p.c(r11, r10);
        JSONObject r12 = r11.optJSONObject(Oaid.KEY_OAID_ID);     // Catch: Exception -> L11
        if (r12 == null) goto L14;
        String r13 = r12.optString(OaidModel.KEY_ID, null);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r13) == true) goto L14;
        r11.put(Oaid.KEY_OAID_ID, r13);     // Catch: Exception -> L11
    L14:
        return r11;
    L11:
        e = move-exception;
        f1.n.B().j("transferHeader failed", e, new Object[0]);
        goto L14
    L17:
        return null;
    }
}
