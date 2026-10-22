package h7;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Hashtable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Externalizable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7918b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b9.a f7919m;

    public a(String r8) {
        d(r8);
    }

    public static boolean c(String r8) {
        int r10 = r8.length();
        if (r10 <= 0) goto L19;
        int r11 = 0;
    L5:
        boolean r12 = true;
        if (r11 >= r10) goto L18;
        char r13 = r8.charAt(r11);
        if (r13 > ' ') goto L10;
    L14:
        r12 = false;
    L15:
        if (r12 == false) goto L16;
        r11 = r11 + 1;
        goto L5
    L16:
        return false;
    L10:
        if (r13 >= 127) goto L14;
        if ("()<>@,;:/[]?=\\\"".indexOf(r13) >= 0) goto L14;
    L18:
        return true;
    L19:
        return false;
    }

    public final String a() {
        return this.f7917a + "/" + this.f7918b;
    }

    public final String b() {
        return (String) ((Hashtable) this.f7919m.f3135b).get("charset".toLowerCase(Locale.ENGLISH));
    }

    public final void d(String r8) {
        int r10 = r8.indexOf(47);
        int r11 = r8.indexOf(59);
        if (r10 >= 0) goto L8;
        if (r11 >= 0) goto L8;
        throw new b("Unable to find a sub type.");
    L8:
        if (r10 >= 0) goto L14;
        if (r11 < 0) goto L14;
        throw new b("Unable to find a sub type.");
    L14:
        if (r10 < 0) goto L17;
        if (r11 >= 0) goto L17;
        String r12 = r8.substring(0, r10).trim();
        Locale r13 = Locale.ENGLISH;
        this.f7917a = r12.toLowerCase(r13);
        this.f7918b = r8.substring(r10 + 1).trim().toLowerCase(r13);
        this.f7919m = new b9.a(3);
    L20:
        if (c(this.f7917a) == false) goto L27;
        if (c(this.f7918b) == false) goto L25;
        return;
    L25:
        throw new b("Sub type is invalid.");
    L27:
        throw new b("Primary type is invalid.");
    L17:
        if (r10 >= r11) goto L29;
        String r14 = r8.substring(0, r10).trim();
        Locale r15 = Locale.ENGLISH;
        this.f7917a = r14.toLowerCase(r15);
        this.f7918b = r8.substring(r10 + 1, r11).trim().toLowerCase(r15);
        this.f7919m = new b9.a(r8.substring(r11), 3);
        goto L20
    L29:
        throw new b("Unable to find a sub type.");
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput r8) {
        d(r8.readUTF());     // Catch: b -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.toString());
    }

    public final String toString() {
        return a() + this.f7919m.toString();
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput r8) {
        r8.writeUTF(toString());
        r8.flush();
    }
}
