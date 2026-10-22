package com.bytedance.apm.impl;

import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class c implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TypedFile f1375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f1376b;

    public c(Map<String, String> r3, TypedFile r4) {
        this.f1376b = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.f1375a = r4;
    }

    private String a() {
        StringBuilder r0 = new StringBuilder(this.f1375a.fileName()).append("\"");
        Iterator<Map.Entry<String, String>> r6 = this.f1376b.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        r0.append("; ").append(r3).append("=\"").append((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")).append("\"");
        goto L4
    L6:
        r0.deleteCharAt(r0.length() - 1);
        return r0.toString();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return a();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.f1375a.length();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return this.f1375a.md5Stub();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return this.f1375a.mimeType();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r1) {
        this.f1375a.writeTo(r1);
    }
}
