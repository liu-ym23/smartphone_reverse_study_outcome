package sbb;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.contact.base.entity.api.ContactMobileApi$From;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class b {
    public Pattern a;
    public Pattern b;
    public Map<String, String> c;
    public String d;
    public Map<String, String> e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public final void e() {
        Set<Map.Entry<String, String>> r0 = this.e.entrySet();
        if (r0 != null) goto L5;
    L39:
        StringBuilder r1 = new StringBuilder("updateDocumentTypeName()...");
        r1.append("doc = " + e.g.c + ", sheet = " + e.h.c + ", folder = " + e.f.c + ", bitable = " + e.i.c + ", baseAdd = " + e.j.c + ", mindnote = " + e.k.c + ", file = " + e.l.c + ", slide = " + e.m.c + ", docx = " + e.o.c + ", wiki = " + e.n.c);
        Log.i("BaseDomainConfigParser", r1.toString());
        return;
    L5:
        if (CollectionUtils.isEmpty(r0) == true) goto L39;
        Iterator<Map.Entry<String, String>> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L39;
        Map.Entry<String, String> r3 = r2.next();
        if (TextUtils.equals(r3.getKey(), ContactMobileApi$From.DOC) == true) goto L11;
        if (TextUtils.equals(r3.getKey(), "sheet") == true) goto L14;
        if (TextUtils.equals(r3.getKey(), "folder") == true) goto L17;
        if (TextUtils.equals(r3.getKey(), "bitable") == true) goto L20;
        if (TextUtils.equals(r3.getKey(), "baseAdd") == true) goto L23;
        if (TextUtils.equals(r3.getKey(), "mindnote") == true) goto L26;
        if (TextUtils.equals(r3.getKey(), "file") == true) goto L29;
        if (TextUtils.equals(r3.getKey(), "slides") == true) goto L32;
        if (TextUtils.equals(r3.getKey(), "wiki") == true) goto L35;
        if (TextUtils.equals(r3.getKey(), ContactMobileApi$From.DOC) == false) goto L8;
        e.o.c = r3.getValue();
        goto L8
    L35:
        e.n.c = r3.getValue();
        goto L8
    L32:
        e.m.c = r3.getValue();
        goto L8
    L29:
        e.l.c = r3.getValue();
        goto L8
    L26:
        e.k.c = r3.getValue();
        goto L8
    L23:
        e.j.c = r3.getValue();
        goto L8
    L20:
        e.i.c = r3.getValue();
        goto L8
    L17:
        e.f.c = r3.getValue();
        goto L8
    L14:
        e.h.c = r3.getValue();
        goto L8
    L11:
        e.g.c = r3.getValue();
        goto L8
    }

    public b(String r3) {
        this.a = PatternProtector.compile("/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/");
        this.b = PatternProtector.compile("/([\\w]{14,})");
        this.c = f.j;
        this.d = "/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/";
        this.e = f.i;
        this.f = "typeReg";
        this.g = "tokenReg";
        this.h = "tokenPattern";
        this.i = "lateastMap";
        this.j = "productMap";
        Log.i("BaseDomainConfigParser", "domainConfigStr = $domainConfigStr");
        a(r3);
        c(r3);
        e();
    }

    public void a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L11;
        Log.e("BaseDomainConfigParser", "parseDomainConfig()... json is empty");
        return;
    L11:
        d(new JSONObject(r3));     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        Log.e("BaseDomainConfigParser", e);
    }

    public final void c(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L16;
        Log.e("BaseDomainConfigParser", "parsePathChangeConfigStr()... json is empty");
        return;
    L16:
        JSONObject r0 = new JSONObject(r3);     // Catch: JSONException -> L13
        HashMap r4 = b(r0, this.i);     // Catch: JSONException -> L13
        if (r4 == null) goto L9;
        this.e = r4;     // Catch: JSONException -> L13
    L9:
        HashMap r5 = b(r0, this.j);     // Catch: JSONException -> L13
        if (r5 == null) goto L18;
        this.c = r5;     // Catch: JSONException -> L13
        return;
    L18:
        return;
    L13:
        e = move-exception;
        Log.e("BaseDomainConfigParser", e);
    }

    public void d(JSONObject r5) {
        JSONObject r6 = r5.optJSONObject(this.h);
        String r1 = "/([\\w]{14,})";
        if (r6 == null) goto L11;
        this.d = r6.optString(this.f, "/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/");
        r1 = r6.optString(this.g, "/([\\w]{14,})");
    L11:
        this.a = PatternProtector.compile(this.d);     // Catch: Exception -> L7
        this.b = PatternProtector.compile(r1);     // Catch: Exception -> L7
    L9:
        Log.i("BaseDomainConfigParser", String.format("parseProductPattern()... mTypeReg = %s\n mTokenReg = %s", new Object[]{this.d, r1}));
        return;
    L7:
        e = move-exception;
        Log.e("BaseDomainConfigParser", e);
        goto L9
    }

    public static HashMap b(JSONObject r4, String r5) {
        HashMap r0 = new HashMap();
        JSONObject r6 = r4.optJSONObject(r5);
        if (r6 != null) goto L6;
        Log.i("BaseDomainConfigParser", "parseJsonObj2Map()...jsonObject = null , key = $jsonKey");
        return null;
    L6:
        Iterator<String> r1 = r6.keys();
    L8:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        r0.put(r2, r6.optString(r2));
        goto L8
    L10:
        Log.i("BaseDomainConfigParser", "parseJsonObj2Map()...map = $productMap");
        return r0;
    }
}
