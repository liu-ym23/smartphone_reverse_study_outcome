package com.bytedance.frameworks.baselib.network.http.impl;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cookie.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class SerializableHttpCookie implements Serializable {
    private static final String TAG = "SerializableHttpCookie";
    private static final long serialVersionUID = 6374381323722046734L;
    private transient e cookie;

    static {
    }

    public SerializableHttpCookie(e r1) {
        this.cookie = r1;
    }

    public static SerializableHttpCookie decode(String r5, String r6, String r7, boolean r8, byte[] r9) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L13:
        return null;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L13;
        if (r9 == null) goto L13;
        SerializableHttpCookie r10 = (SerializableHttpCookie) ZeusTransformUtils.preCheckCast(new com.bytedance.frameworks.baselib.network.http.b.a(new ByteArrayInputStream(r9), new Class[]{SerializableHttpCookie.class}).readObject(), SerializableHttpCookie.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r10.cookie.a(r5, r8);     // Catch: Throwable -> L11
        r10.cookie.a(r6);     // Catch: Throwable -> L11
        r10.cookie.b(r7);     // Catch: Throwable -> L11
        return r10;
    L11:
        th = move-exception;
        Logger.e(TAG, "decodeCookie failed", th);
        goto L13
    }

    private void readObject(ObjectInputStream r5) {
        e r0 = new e();
        this.cookie = r0;
        r0.c((String) ZeusTransformUtils.preCheckCast(r5.readObject(), String.class, "com.obric.memorydata.plugin"));
        this.cookie.a(r5.readLong());
        this.cookie.a(r5.readBoolean());
        this.cookie.b((String) ZeusTransformUtils.preCheckCast(r5.readObject(), String.class, "com.obric.memorydata.plugin"), false);
    }

    private void writeObject(ObjectOutputStream r3) {
        r3.writeObject(this.cookie.f());
        r3.writeLong(this.cookie.g());
        r3.writeBoolean(this.cookie.e());
        r3.writeObject(this.cookie.h());
    }

    public byte[] encode() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        new ObjectOutputStream(r0).writeObject(this);     // Catch: IOException -> L6
        return r0.toByteArray();
    L6:
        e = move-exception;
        Logger.e(TAG, "encodeCookie failed", e);
        return null;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L8;
        e r2 = this.cookie;
    L6:
        return r2.equals(r3);
    L8:
        if (ZeusTransformUtils.instanceOf(r3, SerializableHttpCookie.class) == false) goto L10;
        r2 = this.cookie;
        r3 = ((SerializableHttpCookie) ZeusTransformUtils.preCheckCast(r3, SerializableHttpCookie.class, "com.obric.memorydata.plugin")).cookie;
        goto L6
    L10:
        return false;
    }

    public e getHttpCookie() {
        return this.cookie;
    }

    public int hashCode() {
        return this.cookie.hashCode();
    }
}
