package jd;

import gd.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {
    @Override // gd.b
    public final String a(Object r8) {
        String r10 = (String) r8;
        if (r10 == null) goto L19;
        if (r10.trim().length() == 0) goto L19;
    L15:
        e = move-exception;
        throw new gd.a("Parse JSON error. JSON string:".concat(r10), e);
    L7:
        if (r10.startsWith("{") == false) goto L10;
        return new JSONObject(r10).toString(4);
    L10:
        if (r10.startsWith("[") == false) goto L14;
        return new JSONArray(r10).toString(4);
    L14:
        throw new gd.a("JSON should start with { or [, but found ".concat(r10));     // Catch: Exception -> L15
    L19:
        throw new gd.a("JSON empty.");
    }
}
