package e1;

import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.crash.entity.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    @NonNull
    public static String a(DataIsolateKey r10, l1.a r11, String r12) {
        if (r11 == null) goto L9;
        if (r10 == null) goto L9;
        if (r10 != DataIsolateKey.USER_ID) goto L9;
        return String.valueOf(r11.f10831j);
    L9:
        return r12;
    }

    @NonNull
    public static String b(DataIsolateKey r10, JSONObject r11, String r12) {
        if (r11 == null) goto L9;
        if (r10 == null) goto L9;
        if (r10 != DataIsolateKey.USER_ID) goto L9;
        return r11.optString(Header.KEY_USER_ID, NetConst.NOT_ENCRYPT_VERISON_CODE);
    L9:
        return r12;
    }
}
