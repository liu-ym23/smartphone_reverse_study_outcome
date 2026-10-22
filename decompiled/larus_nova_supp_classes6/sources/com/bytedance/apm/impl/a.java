package com.bytedance.apm.impl;

import android.text.TextUtils;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a implements TypedOutput {
    public final String a;
    public final Map<String, String> b;
    public final String c;

    public final String md5Stub() {
        return null;
    }

    public final String mimeType() {
        return "text/plain";
    }

    public final String fileName() {
        String r0 = this.a;
        Map<String, String> r1 = this.b;
        StringBuilder r2 = new StringBuilder(r0);
        r2.append("\"");
        Iterator<Map.Entry<String, String>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry<String, String> r4 = r3.next();
        String r5 = r4.getKey();
        String r6 = r4.getValue();
        r2.append("; ");
        r2.append(r5);
        r2.append("=\"");
        r2.append(r6);
        r2.append("\"");
        goto L4
    L6:
        r2.deleteCharAt(r2.length() - 1);
        return r2.toString();
    }

    public final long length() {
        return this.c.getBytes().length;
    }

    public final void writeTo(OutputStream r2) throws IOException {
        r2.write(this.c.getBytes());
    }

    public a(String r2, Map r3) {
        this.a = "params.txt";
        this.b = r3;
        if (TextUtils.isEmpty(r2) == false) goto L7;
        JSONObject r4 = new JSONObject();
        r4.put("defaultData", "none commonParams");     // Catch: JSONException -> L9
    L6:
        this.c = r4.toString();
        return;
    L7:
        this.c = r2;
    }
}
