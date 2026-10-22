package com.bytedance.apm.impl;

import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypedFile f3765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f3766b;

    public a(HashMap r8, TypedFile r10) {
        this.f3766b = r8;
        this.f3765a = r10;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String fileName() {
        StringBuilder r8 = new StringBuilder(this.f3765a.fileName());
        r8.append("\"");
        Iterator<Map.Entry<String, String>> r10 = this.f3766b.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<String, String> r11 = r10.next();
        String r12 = r11.getKey();
        String r13 = r11.getValue();
        r8.append("; ");
        r8.append(r12);
        r8.append("=\"");
        r8.append(r13);
        r8.append("\"");
        goto L4
    L6:
        r8.deleteCharAt(r8.length() - 1);
        return r8.toString();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final long length() {
        return this.f3765a.length();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String md5Stub() {
        return this.f3765a.md5Stub();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String mimeType() {
        return this.f3765a.mimeType();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final void writeTo(OutputStream r8) {
        this.f3765a.writeTo(r8);
    }
}
