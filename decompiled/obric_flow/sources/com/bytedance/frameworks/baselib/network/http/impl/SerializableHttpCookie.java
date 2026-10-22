package com.bytedance.frameworks.baselib.network.http.impl;

import ai.j0;
import android.util.Log;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import kotlin.UByte;
import v9.a;

/* JADX INFO: loaded from: classes2.dex */
public class SerializableHttpCookie implements Serializable {
    private static final long serialVersionUID = 6374381323722046732L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient a f4674a;
    private long whenCreated;

    public SerializableHttpCookie(a r5) {
        this.f4674a = r5;
        this.whenCreated = System.currentTimeMillis();
    }

    public static SerializableHttpCookie decode(String r10) {
        int r5 = r10.length();
        byte[] r11 = new byte[r5 / 2];
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L16;
        int r13 = Character.digit(r10.charAt(r12), 16) << 4;
        r11[r12 / 2] = (byte) (Character.digit(r10.charAt(r12 + 1), 16) + r13);
        r12 = r12 + 2;
        goto L3
    L16:
        return (SerializableHttpCookie) new ObjectInputStream(new ByteArrayInputStream(r11)).readObject();
    L10:
        e = move-exception;
        Log.d("SerializableHttpCookie", "IOException in decodeCookie", e);
        return null;
    L8:
        e = move-exception;
        Log.d("SerializableHttpCookie", "ClassNotFoundException in decodeCookie", e);
        return null;
    }

    public static int getEffectivePort(String r5, int r10) {
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        if ("http".equalsIgnoreCase(r5) == false) goto L10;
        return 80;
    L10:
        if (IIvyAIPackageResourceService.SCHEMA.equalsIgnoreCase(r5) == false) goto L13;
        return 443;
    L13:
        return -1;
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        a r10 = new a((String) r5.readObject(), (String) r5.readObject());
        this.f4674a = r10;
        r10.f22555a = (String) r5.readObject();
        a r11 = this.f4674a;
        r11.f22556b = (String) r5.readObject();
        a r12 = this.f4674a;
        String r13 = (String) r5.readObject();
        if (r13 != null) goto L5;
        String r14 = null;
    L6:
        r12.d = r14;
        a r15 = this.f4674a;
        r15.e = r5.readLong();
        a r16 = this.f4674a;
        r16.g = (String) r5.readObject();
        a r17 = this.f4674a;
        r17.f22558h = (String) r5.readObject();
        a r18 = this.f4674a;
        int r19 = r5.readInt();
        r18.getClass();
        if (r19 != 0) goto L9;
    L13:
        r18.f22562l = r19;
        a r20 = this.f4674a;
        r20.f22559i = r5.readBoolean();
        a r21 = this.f4674a;
        r21.f22557c = r5.readBoolean();
        this.f4674a.f22560j = r5.readBoolean();
        this.whenCreated = r5.readLong();
        return;
    L9:
        if (r19 == 1) goto L13;
        throw new IllegalArgumentException(j0.g(r19, "Bad version: "));
    L5:
        r12.getClass();
        r14 = r13.toLowerCase(Locale.US);
        goto L6
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.writeObject(this.f4674a.f);
        r5.writeObject(this.f4674a.f22561k);
        r5.writeObject(this.f4674a.f22555a);
        r5.writeObject(this.f4674a.f22556b);
        r5.writeObject(this.f4674a.d);
        r5.writeLong(this.f4674a.e);
        r5.writeObject(this.f4674a.g);
        r5.writeObject(this.f4674a.f22558h);
        r5.writeInt(this.f4674a.f22562l);
        r5.writeBoolean(this.f4674a.f22559i);
        r5.writeBoolean(this.f4674a.f22557c);
        r5.writeBoolean(this.f4674a.f22560j);
        r5.writeLong(this.whenCreated);
    }

    public String encode() {
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();
        new ObjectOutputStream(r5).writeObject(this);     // Catch: IOException -> L12
        byte[] r10 = r5.toByteArray();
        StringBuilder r11 = new StringBuilder(r10.length * 2);
        int r12 = r10.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        int r14 = r10[r13] & UByte.MAX_VALUE;
        if (r14 >= 16) goto L9;
        r11.append('0');
    L9:
        r11.append(Integer.toHexString(r14));
        r13 = r13 + 1;
        goto L5
    L11:
        return r11.toString();
    L12:
        e = move-exception;
        Log.d("SerializableHttpCookie", "IOException in encodeCookie", e);
        return null;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof a) == false) goto L7;
        return this.f4674a.equals(r5);
    L7:
        if ((r5 instanceof SerializableHttpCookie) == true) goto L9;
        return false;
    L9:
        return this.f4674a.equals(((SerializableHttpCookie) r5).f4674a);
    }

    public a getHttpCookie() {
        return this.f4674a;
    }

    public Long getWhenCreated() {
        return Long.valueOf(this.whenCreated);
    }

    public boolean hasExpired() {
        long r5 = this.f4674a.e;
        if (r5 != (-1)) goto L6;
        return false;
    L6:
        if (((System.currentTimeMillis() - this.whenCreated) / 1000) <= r5) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return this.f4674a.hashCode();
    }
}
