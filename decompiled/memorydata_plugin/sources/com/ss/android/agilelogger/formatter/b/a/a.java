package com.ss.android.agilelogger.formatter.b.a;

import com.ss.android.agilelogger.formatter.FormatException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a implements b {
    public a() {
    }

    @Override // com.ss.android.agilelogger.formatter.a
    public /* synthetic */ String a(Object r3) {
        return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public String a(String r4) {
        if (r4 == null) goto L18;
        if (r4.trim().length() == 0) goto L18;
    L14:
        e = move-exception;
        throw new FormatException("Parse JSON error. JSON string:" + r4, e);
    L6:
        if (r4.startsWith("{") == false) goto L9;
        return new JSONObject(r4).toString(4);
    L9:
        if (r4.startsWith("[") == false) goto L13;
        return new JSONArray(r4).toString(4);
    L13:
        throw new FormatException("JSON should start with { or [, but found " + r4);     // Catch: Exception -> L14
    L18:
        throw new FormatException("JSON empty.");
    }
}
