package com.bytedance.retrofit2.mime;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes.dex */
public final class FormUrlEncodedTypedOutput implements TypedOutput {
    final ByteArrayOutputStream content;

    public FormUrlEncodedTypedOutput() {
        this.content = new ByteArrayOutputStream();
    }

    public void addField(String r8, String r10) {
        addField(r8, true, r10, true);
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.content.size();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return DigestUtil.md5Hex(this.content.toByteArray());
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r8) {
        r8.write(this.content.toByteArray());
    }

    public void addField(String r8, boolean r10, String r11, boolean r12) {
        if (r8 == null) goto L20;
        if (r11 == null) goto L18;
        if (this.content.size() <= 0) goto L8;
        this.content.write(38);
    L8:
        if (r10 == true) goto L21;
    L10:
        if (r12 == false) goto L12;
        r11 = URLEncoder.encode(r11, "UTF-8");     // Catch: IOException -> L14
    L12:
        this.content.write(r8.getBytes("UTF-8"));     // Catch: IOException -> L14
        this.content.write(61);     // Catch: IOException -> L14
        this.content.write(r11.getBytes("UTF-8"));     // Catch: IOException -> L14
        return;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L21:
        r8 = URLEncoder.encode(r8, "UTF-8");     // Catch: IOException -> L14
        goto L10
    L18:
        throw new NullPointerException("value");
    L20:
        throw new NullPointerException(QesdkUtils.TAGS.JSON_TAG_NAME);
    }
}
