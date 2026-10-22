package eq1;

import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.schema.helper.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import j40.x3;
import j40.y3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final boolean a;
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public final Map<String, String> c() {
        HashMap r0 = new HashMap();
        r0.put("type", "popup");
        r0.put("gravity", "bottom");
        if (this.a == true) goto L6;
        r0.put("horizontal_width", "375");
        r0.put("horizontal_width_percent", "0");
    L6:
        if (PadConfigUtils.c() == false) goto L9;
        r0.put("pad_use_player_bottom_height", "1");
    L13:
        if (this.b == false) goto L15;
    L17:
        String r1 = "8";
    L18:
        r0.put("radius", r1);
        if (FoldScreenUtils.f() == true) goto L21;
    L23:
        return r0;
    L21:
        if (FoldScreenUtils.e() == false) goto L23;
        r0.put("use_player_bottom_height", "0");
        r0.put("pad_use_player_bottom_height", "0");
        goto L23
    L15:
        if (this.a == false) goto L17;
        r1 = "0";
        goto L18
    L9:
        if (this.b == false) goto L11;
        r0.put("height", "494");
        r0.put("height_percent", "0");
        r0.put("use_player_bottom_height", "0");
        goto L13
    L11:
        r0.put("use_player_bottom_height", "1");
        goto L13
    }

    public final Uri a(String r6) {
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L26;
        ALogger.d("VSSchemaHandler", "schema is null or empty");
        return null;
    L26:
        Uri r7 = UriProtector.parse(r6);     // Catch: Exception -> L23
        ALogger.d("VSSchemaHandler", "previous: " + r7);     // Catch: Exception -> L23
        if (((Boolean) y3.a.getValue()).booleanValue() == true) goto L17;
        ALogger.d("VSSchemaHandler", "LIVE_VS_HANDLE_SCHEMA false");     // Catch: Exception -> L23
        return r7;
    L17:
        Iterator r0 = ((HashMap) c()).entrySet().iterator();     // Catch: Exception -> L23
    L19:
        if (r0.hasNext() == false) goto L21;
        Map.Entry r2 = (Map.Entry) r0.next();     // Catch: Exception -> L23
        r7 = h.b(r7, (String) r2.getKey(), (String) r2.getValue());     // Catch: Exception -> L23
        goto L19
    L21:
        ALogger.d("VSSchemaHandler", "after: " + r7);     // Catch: Exception -> L23
        return r7;
    L23:
        e = move-exception;
        ALogger.e("VSSchemaHandler", e);
        return null;
    L5:
        if (r6.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public final String b(String r3) {
        if (((Boolean) x3.a.getValue()).booleanValue() == true) goto L6;
        ALogger.d("VSSchemaHandler", "LIVE_VS_BANNER_HANDLE_SCHEMA false");
        return r3;
    L6:
        Uri r0 = a(r3);
        if (r0 == null) goto L13;
        String r1 = r0.toString();
        if (r1 != null) goto L12;
        return r3;
    L12:
        return r1;
    L13:
        return r3;
    }

    public b(boolean r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
