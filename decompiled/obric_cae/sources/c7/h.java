package c7;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Serializable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f3404m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient d f3405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3406b;

    public h(d r8) {
        this.f3405a = r8;
        this.f3406b = System.currentTimeMillis();
    }

    public static h a(String r8) {
        int r10 = r8.length();
        byte[] r11 = new byte[r10 / 2];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L14;
        int r13 = Character.digit(r8.charAt(r12), 16) << 4;
        r11[r12 / 2] = (byte) (Character.digit(r8.charAt(r12 + 1), 16) + r13);
        r12 = r12 + 2;
        goto L3
    L14:
        return (h) new ObjectInputStream(new ByteArrayInputStream(r11)).readObject();
    L10:
        e = e;
        String r14 = "IOException in decodeCookie";
    L12:
        Log.d("h", r14, e);
        return null;
    L8:
        e = e;
        r14 = "ClassNotFoundException in decodeCookie";
        goto L12
    }

    public final String b() {
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        new ObjectOutputStream(r8).writeObject(this);     // Catch: IOException -> L12
        byte[] r10 = r8.toByteArray();
        StringBuilder r11 = new StringBuilder(r10.length * 2);
        int r12 = r10.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        int r14 = r10[r13] & 255;
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
        Log.d("h", "IOException in encodeCookie", e);
        return null;
    }

    public final boolean equals(Object r8) {
        boolean r10 = r8 instanceof d;
        d r11 = this.f3405a;
        if (r10 == false) goto L7;
        return r11.equals(r8);
    L7:
        if ((r8 instanceof h) == true) goto L9;
        return false;
    L9:
        return r11.equals(((h) r8).f3405a);
    }

    public final int hashCode() {
        return this.f3405a.hashCode();
    }
}
