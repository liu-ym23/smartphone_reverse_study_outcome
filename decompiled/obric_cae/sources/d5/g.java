package d5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import x4.j0;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class g extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0 f6791e;

    public g(j0 r8) {
        super(false, true);
        this.f6791e = r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.Map] */
    @Override // d5.d
    public final boolean a(JSONObject r8) {
        j0 r10 = this.f6791e;
        r8.put("channel", r10.f13469g);
        r8.put("not_request_sender", 1);
        r8.put(WsConstants.KEY_APP_ID, r10.f13463a);
        String r11 = r10.f13471i;
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r8.put("release_build", r11);
        ?? r12 = 0;
        boolean r13 = TextUtils.isEmpty(null);
        Context r14 = r10.f13465c;
        if (r13 == true) goto L8;
        String r15 = null;
    L9:
        x0.h(r8, "user_agent", r15);
        x0.h(r8, "ab_version", null);
        String r16 = r10.f13472j;
        if (TextUtils.isEmpty(r16) == false) goto L14;
        r16 = k5.a.a(r14, r10).getString("app_language", null);
    L14:
        if (TextUtils.isEmpty(r16) == false) goto L16;
        r16 = r10.b().getString("app_language", null);
    L16:
        x0.h(r8, "app_language", r16);
        String r17 = r10.f13473k;
        if (TextUtils.isEmpty(r17) == false) goto L21;
        r17 = k5.a.a(r14, r10).getString("app_region", null);
    L21:
        if (TextUtils.isEmpty(r17) == false) goto L23;
        r17 = r10.b().getString("app_region", null);
    L23:
        x0.h(r8, "app_region", r17);
        String r18 = k5.a.a(r14, r10).getString("app_track", null);
        if (r18 != null) goto L64;
    L27:
        JSONObject r19 = null;
    L28:
        if (r19 != null) goto L66;
    L32:
        JSONObject r20 = r8.optJSONObject("custom");
        if (r20 != null) goto L36;
        r20 = new JSONObject();
    L36:
        if (TextUtils.isEmpty(r10.f13467e) == true) goto L62;
        r20.put("real_package_name", r14.getPackageName());
    L62:
        x4.w r21 = r10.f13485w;     // Catch: Throwable -> L57
        if (r21 == null) goto L49;
        JSONObject r22 = ((u3.f) r21).a();     // Catch: Throwable -> L57
        if (r22 != null) goto L43;
        r12 = Collections.emptyMap();     // Catch: Throwable -> L57
        goto L49
    L43:
        r12 = new HashMap();     // Catch: Throwable -> L57
        Iterator<String> r23 = r22.keys();     // Catch: Throwable -> L57
    L45:
        if (r23.hasNext() == false) goto L49;
        String r24 = r23.next();     // Catch: Throwable -> L57
        if (r24 == null) goto L45;
        r12.put(r24, r22.opt(r24));     // Catch: Throwable -> L57
    L49:
        if (r12 != 0) goto L51;
    L59:
        r8.put("custom", r20);
        return true;
    L51:
        if (r12.size() <= 0) goto L59;
        Iterator r25 = r12.keySet().iterator();     // Catch: Throwable -> L57
    L53:
        if (r25.hasNext() == false) goto L59;
        String r26 = (String) r25.next();     // Catch: Throwable -> L57
        r20.put(r26, r12.get(r26));     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        th.printStackTrace();
        goto L59
    L66:
        r8.put("app_track", r19);     // Catch: Throwable -> L31
    L31:
        int r27 = x4.r.f13543a;
        goto L32
    L64:
        r19 = new JSONObject(r18);     // Catch: JSONException -> L61
    L8:
        r15 = k5.a.a(r14, r10).getString("user_agent", null);
        goto L9
    }

    @Override // d5.d
    public final void b(JSONObject r8) {
        r8.remove("channel");
        r8.remove("not_request_sender");
        r8.remove(WsConstants.KEY_APP_ID);
        r8.remove("release_build");
        r8.remove("user_agent");
        r8.remove("ab_version");
        r8.remove("app_language");
        r8.remove("app_region");
        r8.remove("app_track");
        r8.remove("custom");
    }
}
