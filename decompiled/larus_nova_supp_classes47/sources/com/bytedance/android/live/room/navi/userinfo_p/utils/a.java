package com.bytedance.android.live.room.navi.userinfo_p.utils;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.navi.userinfo.model.AnchorTabType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.alog.middleware.ALogService;
import g81.f;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(int r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        if (r8 != 4) goto L9;
        if (a0.d(r9, false) == false) goto L9;
        ALogService.wSafely("LabelParseUtil", "filter server anchor tab type; current user is anchor, but type is " + r8);
        return 1;
    L9:
        if (((ArrayList) AnchorTabType.a).contains(Integer.valueOf(r8)) == false) goto L22;
        IRoom r4 = a0.n(r9);
        if (r4 == null) goto L22;
        IRoomAuthStatus r5 = r4.getRoomAuthStatus();
        if (r5 == null) goto L22;
        if (r5.getEnableDigg() == true) goto L22;
        ALogService.wSafely("LabelParseUtil", "filter server anchor tab type; current room does't support dig");
        if (a0.d(r9, false) == true) goto L83;
        return 4;
    L83:
        return 1;
    L22:
        if (((ArrayList) AnchorTabType.c).contains(Integer.valueOf(r8)) == false) goto L28;
        if (a0.d(r9, false) == false) goto L84;
        return 5;
    L84:
        return 3;
    L28:
        if (r8 != (-1)) goto L34;
        ALogger.i("LabelParseUtil", "filter server anchor tab type; current room is using local_fallback strategy");
        if (a0.d(r9, false) == true) goto L85;
        return 3;
    L85:
        return 1;
    L34:
        if (r8 == 0) goto L36;
        Integer r3 = (Integer) f.a.getValue();
        if (r8 == 8) goto L44;
        if (r8 == 9) goto L44;
    L76:
        if (r8 > 11) goto L79;
        if (r8 < 0) goto L79;
        return r8;
    L79:
        if (a0.d(r9, false) == false) goto L81;
        return 1;
    L81:
        return 3;
    L44:
        if (a0.d(r9, false) == false) goto L50;
        ALogService.wSafely("LabelParseUtil", "filter server anchor tab type; the room doesn't has certification info");
        if (a0.d(r9, false) == true) goto L87;
        return 3;
    L87:
        return 1;
    L50:
        if (r8 != 8) goto L59;
        if (r3 == null) goto L59;
        if (r3.intValue() != 0) goto L59;
        if (a0.d(r9, false) == false) goto L88;
        return 5;
    L88:
        return 3;
    L59:
        if (r3 != null) goto L62;
    L63:
        IRoom r0 = a0.n(r9);
        if (r0 != null) goto L66;
    L68:
        boolean r1 = false;
    L69:
        if (r1 == true) goto L76;
        if (a0.d(r9, false) == true) goto L89;
        return 3;
    L89:
        return 1;
    L66:
        if (r0.getAnchorTabLabel() == null) goto L68;
        r1 = true;
        goto L69
    L62:
        if (r3.intValue() == 0) goto L76;
    L36:
        if (a0.d(r9, false) == false) goto L86;
        return 5;
    L86:
        return 3;
    }

    public static int b(JSONObject r4, IRoom r5) {
        Intrinsics.checkNotNullParameter(r4, "contentJson");
        String r1 = r4.optString("degrade_tab_type");
    L23:
        e = move-exception;
        ALogger.e("LabelParseUtil", e);
        return -1;
    L4:
        if (TextUtils.isEmpty(r1) == true) goto L31;
        if (r5 == null) goto L32;
        Map r2 = JsonUtil.jsonObjectToMap(new JSONObject(r1));     // Catch: JSONException -> L23
        if (r2.size() <= 0) goto L15;
        String r6 = (String) r2.get(String.valueOf(r5.getAnchorTabType()));     // Catch: JSONException -> L23
    L13:
        e = move-exception;
        ALogger.e("LabelParseUtil", e);     // Catch: JSONException -> L23
        return -1;
    L10:
        if (TextUtils.isEmpty(r6) == true) goto L33;
        Intrinsics.checkNotNull(r6);     // Catch: NumberFormatException -> L13 JSONException -> L23
        int r7 = CastIntegerProtector.parseInt(r6);     // Catch: NumberFormatException -> L13 JSONException -> L23
    L34:
        return r7;
    L33:
        return -1;
    L15:
        String r8 = r4.optString("fallback_tab_type");     // Catch: JSONException -> L23
    L20:
        e = move-exception;
        ALogger.e("LabelParseUtil", e);     // Catch: JSONException -> L23
        return -1;
    L17:
        if (TextUtils.isEmpty(r8) == true) goto L36;
        Intrinsics.checkNotNull(r8);     // Catch: NumberFormatException -> L20 JSONException -> L23
        r7 = CastIntegerProtector.parseInt(r8);     // Catch: NumberFormatException -> L20 JSONException -> L23
    L36:
        return -1;
    L32:
        return -1;
    L31:
        return -1;
    }
}
