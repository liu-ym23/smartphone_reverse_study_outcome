package com.bytedance.frameworks.baselib.network.http.impl;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SerializableHttpCookie implements Serializable {
    private static final char[] HEX_ARRAY = null;
    private static final String TAG = null;
    private static final long serialVersionUID = 6374381323722046732L;
    private transient f cookie;
    private long whenCreated;

    static {
        TAG = SerializableHttpCookie.class.getSimpleName();
        HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    }

    public SerializableHttpCookie(f r10) {
        this.cookie = r10;
        this.whenCreated = System.currentTimeMillis();
    }

    private String byteArrayToHexString(byte[] r10) {
        char[] r11 = new char[r10.length * 2];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L7;
        int r13 = r10[r12] & 255;
        int r14 = r12 * 2;
        char[] r15 = HEX_ARRAY;
        r11[r14] = r15[r13 >>> 4];
        r11[r14 + 1] = r15[r13 & 15];
        r12 = r12 + 1;
        goto L4
    L7:
        return new String(r11);
    }

    public static SerializableHttpCookie decode(String r10) {
        if (r10 != null) goto L5;
    L15:
        return null;
    L5:
        if (r10.isEmpty() == true) goto L15;
        return (SerializableHttpCookie) new t2.a(new ByteArrayInputStream(hexStringToByteArray(r10)), new Class[]{SerializableHttpCookie.class}).readObject();
    L12:
        e = e;
        String r11 = TAG;
        String r12 = "IOException in decodeCookie";
    L14:
        Log.d(r11, r12, e);
    L10:
        e = e;
        r11 = TAG;
        r12 = "ClassNotFoundException in decodeCookie";
        goto L14
    }

    public static int getEffectivePort(String r10, int r11) {
        if (r11 == (-1)) goto L6;
        return r11;
    L6:
        if ("http".equalsIgnoreCase(r10) == false) goto L10;
        return 80;
    L10:
        if ("https".equalsIgnoreCase(r10) == false) goto L13;
        return 443;
    L13:
        return -1;
    }

    private boolean getHttpOnly() {
        return this.cookie.z();
    }

    private static byte[] hexStringToByteArray(String r10) {
        int r11 = r10.length();
        byte[] r12 = new byte[r11 / 2];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13 / 2] = (byte) ((Character.digit(r10.charAt(r13), 16) << 4) + Character.digit(r10.charAt(r13 + 1), 16));
        r13 = r13 + 2;
        goto L3
    L5:
        return r12;
    }

    private void readObject(ObjectInputStream r10) {
        f r11 = new f((String) r10.readObject(), (String) r10.readObject());
        this.cookie = r11;
        r11.R((String) r10.readObject());
        this.cookie.S((String) r10.readObject());
        this.cookie.U((String) r10.readObject());
        this.cookie.X(r10.readLong());
        this.cookie.Y((String) r10.readObject());
        this.cookie.Z((String) r10.readObject());
        this.cookie.b0(r10.readInt());
        this.cookie.a0(r10.readBoolean());
        this.cookie.T(r10.readBoolean());
        setHttpOnly(r10.readBoolean());
        this.whenCreated = r10.readLong();
    }

    private void setHttpOnly(boolean r10) {
        this.cookie.W(r10);
    }

    private void writeObject(ObjectOutputStream r10) {
        r10.writeObject(this.cookie.B());
        r10.writeObject(this.cookie.F());
        r10.writeObject(this.cookie.v());
        r10.writeObject(this.cookie.w());
        r10.writeObject(this.cookie.y());
        r10.writeLong(this.cookie.A());
        r10.writeObject(this.cookie.C());
        r10.writeObject(this.cookie.D());
        r10.writeInt(this.cookie.G());
        r10.writeBoolean(this.cookie.E());
        r10.writeBoolean(this.cookie.x());
        r10.writeBoolean(getHttpOnly());
        r10.writeLong(this.whenCreated);
    }

    public String encode() {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        new ObjectOutputStream(r10).writeObject(this);     // Catch: IOException -> L6
        return byteArrayToHexString(r10.toByteArray());
    L6:
        e = move-exception;
        Log.d(TAG, "IOException in encodeCookie", e);
        return null;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof f) == false) goto L8;
        f r11 = this.cookie;
    L6:
        return r11.equals(r10);
    L8:
        if ((r10 instanceof SerializableHttpCookie) == false) goto L10;
        r11 = this.cookie;
        r10 = ((SerializableHttpCookie) r10).cookie;
        goto L6
    L10:
        return false;
    }

    public f getHttpCookie() {
        return this.cookie;
    }

    public Long getWhenCreated() {
        return Long.valueOf(this.whenCreated);
    }

    public boolean hasExpired() {
        long r10 = this.cookie.A();
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        if (((System.currentTimeMillis() - this.whenCreated) / 1000) <= r10) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return this.cookie.hashCode();
    }
}
