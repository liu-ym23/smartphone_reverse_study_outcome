package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c1 implements n56.c {
    public final WeakReference<Context> a;

    public c1(WeakReference<Context> r1) {
        this.a = r1;
    }

    public void call(n56.f r10, JSONObject r11) throws Exception {
        r11.put("code", 0);
        String r12 = r10.d.optString("type");
        if (TextUtils.isEmpty(r12) == false) goto L7;
        r11.put("code", 0);
        return;
    L7:
        if (r10.d.has("args") == false) goto L9;
        JSONObject r13 = JSONObjectProtectorUtils.getJSONObject(r10.d, "args");
    L11:
        if (com.bytedance.android.ec.core.event.a.KEY_SCHEME.equals(r12) == false) goto L18;
        if (r13 != null) goto L14;
        r11.put("code", 0);
        return;
    L14:
        String r14 = JSONObjectProtectorUtils.getString(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        Context r15 = this.a.get();
        if (r15 == null) goto L20;
        w9.a.a.j0(r15, UriProtector.parse(r14), null, null);
        return;
    L20:
        return;
    L18:
        return;
    L9:
        r13 = null;
        goto L11
    }
}
