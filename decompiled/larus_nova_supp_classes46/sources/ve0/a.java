package ve0;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.config.vb0;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static JSONObject a(String r3) {
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r3) == false) goto L35;
    L27:
        e = move-exception;
        ALogger.e("MultiLinkSeiParseUtil", "error message: " + e);
        return null;
    L5:
        if (((Boolean) LiveSeiUtil.c.getValue()).booleanValue() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L12;
    L14:
        JSONObject r4 = new JSONObject(r3);     // Catch: JSONException -> L27
    L16:
        if (r4.has("info") == true) goto L18;
        return r4;
    L18:
        if (r4.has("source") == true) goto L20;
        return r4;
    L20:
        if (TextUtils.equals(r4.optString("source"), "zego") == false) goto L33;
        Object r5 = r4.get("info");     // Catch: JSONException -> L27
        if (r5 == null) goto L25;
        return (JSONObject) r5;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: JSONException -> L27
    L33:
        return r4;
    L12:
        if (((Boolean) vb0.a.getValue()).booleanValue() == false) goto L14;
        r4 = LiveSeiUtil.c(r3);     // Catch: JSONException -> L27
        goto L16
    L7:
        if (((Boolean) LiveSeiUtil.e.getValue()).booleanValue() == false) goto L9;
        r2 = true;
        goto L10
    L35:
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007b -> B:19:0x008e). Please report as a decompilation issue!!! */
    public static ParseSeiData b(String r18) {
        Intrinsics.checkNotNullParameter(r18, "sei");
        JSONObject r2 = a(r18);     // Catch: JSONException -> L17
        if (r2 != null) goto L6;
    L19:
        ParseSeiData r0 = null;
    L21:
        return r0;
    L6:
        if (r2.has("app_data") == false) goto L19;
        String r1 = new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r2, "app_data"), "");     // Catch: JSONException -> L17
        if (Intrinsics.areEqual(r1, "") == true) goto L19;
        if (Intrinsics.areEqual(r1, " ") == true) goto L19;
        JSONObject r3 = new JSONObject(r1);     // Catch: JSONException -> L17
        JSONObject r6 = r3.optJSONObject("canvas");     // Catch: JSONException -> L17
        int r8 = r3.optInt("ver");     // Catch: JSONException -> L17
        int r10 = r3.optInt("ui_layout");     // Catch: JSONException -> L17
        int r9 = r3.optInt("sub_scene");     // Catch: JSONException -> L17
        if (r6 != null) goto L15;
        r0 = new ParseSeiData(r8, r9, r10, null, 0, false, null, 0, 248, null);     // Catch: JSONException -> L17
        goto L21
    L15:
        r0 = new ParseSeiData(r8, r9, r10, r6, 0, false, null, 0, 240, null);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        ALogger.e("MultiLinkSeiParseUtil", "error message: " + e);
        goto L19
    }
}
