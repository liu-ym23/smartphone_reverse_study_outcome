package com.bytedance.apm.impl;

import android.text.TextUtils;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class b implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f1374b;
    private final String c;

    public b(String r3, String r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.f1373a = r3;
        this.f1374b = r6;
        if (TextUtils.isEmpty(r4) == false) goto L7;
        JSONObject r7 = new JSONObject();
        r7.put("defaultData", "none commonParams");     // Catch: JSONException -> L9
    L6:
        this.c = r7.toString();
        return;
    L7:
        this.c = r4;
    }

    private String a(String r5, Map<String, String> r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder(r5).append("\"");
        Iterator r8 = r4.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        r7.append("; ").append(r2).append("=\"").append((String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin")).append("\"");
        goto L4
    L6:
        r7.deleteCharAt(r7.length() - 1);
        return r7.toString();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return a(this.f1373a, this.f1374b);
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.c.getBytes().length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "text/plain";
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r1) {
        r1.write(this.c.getBytes());
    }
}
