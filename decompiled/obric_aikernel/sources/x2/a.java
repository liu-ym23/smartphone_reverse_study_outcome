package x2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends l2.b<d> {
    public a() {
    }

    private Map<String, String> k(JSONObject r10) {
        HashMap r11 = new HashMap();
        if (r10 != null) goto L5;
    L15:
        return r11;
    L5:
        if (r10.length() == 0) goto L15;
        Iterator<String> r12 = r10.keys();
    L9:
        if (r12.hasNext() == false) goto L15;
        String r13 = r12.next();
        String r14 = r10.optString(r13);
        if (TextUtils.isEmpty(r13) == true) goto L9;
        if (TextUtils.isEmpty(r14) == true) goto L9;
        r11.put(r13, r14);
        goto L9
    }

    @Override // l2.b
    public String a() {
        return "ttnet_req_meta_dp";
    }

    @Override // l2.b
    public /* bridge */ /* synthetic */ l2.c e(Object r10) {
        return j(r10);
    }

    public d j(Object r10) {
        if ((r10 instanceof JSONObject) == false) goto L5;
        JSONObject r11 = (JSONObject) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        d r12 = new d();
        r12.f13493a = k(r11.optJSONObject("query_add"));
        r12.f13494b = f(r11.optJSONArray("query_rm"));
        r12.f13495c = k(r11.optJSONObject("header_add"));
        r12.f13496d = f(r11.optJSONArray("header_rm"));
        return r12;
    L5:
        r11 = null;
        goto L6
    }
}
