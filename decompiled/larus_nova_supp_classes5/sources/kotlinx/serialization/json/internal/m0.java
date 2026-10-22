package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class m0 extends a {
    public final String e;

    @Override // kotlinx.serialization.json.internal.a
    public boolean b() {
        int r0 = this.a;
        if (r0 != (-1)) goto L5;
        return false;
    L5:
        String r1 = this.e;
    L7:
        if (r0 >= r1.length()) goto L32;
        char r3 = r1.charAt(r0);
        if (r3 != ' ') goto L11;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == false) goto L21;
        r0 = r0 + 1;
        goto L7
    L21:
        this.a = r0;
        if (r3 != '}') goto L24;
        return false;
    L24:
        if (r3 != ']') goto L26;
        return false;
    L26:
        if (r3 != ':') goto L28;
        return false;
    L28:
        if (r3 == ',') goto L39;
        return true;
    L39:
        return false;
    L11:
        if (r3 == '\n') goto L18;
        if (r3 == '\r') goto L18;
        if (r3 == '\t') goto L18;
        r4 = false;
        goto L19
    L32:
        this.a = r0;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.a
    public final String d() {
        g('\"');
        int r7 = this.a;
        int r1 = StringsKt.indexOf$default(this.e, '\"', r7, false, 4, null);
        if (r1 == (-1)) goto L47;
        int r6 = r7;
    L5:
        if (r6 >= r1) goto L45;
        if (this.e.charAt(r6) == '\\') goto L8;
        r6 = r6 + 1;
        goto L5
    L8:
        String r2 = this.e;
        int r8 = this.a;
        Intrinsics.checkNotNullParameter(r2, "source");
        char r9 = r2.charAt(r6);
        boolean r10 = false;
    L9:
        if (r9 == '\"') goto L39;
        if (r9 != '\\') goto L31;
        this.d.append(p(), r8, r6);
        int r11 = t(r6 + 1);
        if (r11 == (-1)) goto L29;
        int r12 = r11 + 1;
        char r13 = this.e.charAt(r11);
        if (r13 != 'u') goto L17;
        r12 = a(this.e, r12);
    L22:
        r6 = t(r12);
        if (r6 == (-1)) goto L25;
    L35:
        r8 = r6;
        r10 = true;
    L38:
        r9 = r2.charAt(r6);
        goto L9
    L25:
        a.m(this, "Unexpected EOF", r6, null, 4);
        throw null;
    L17:
        if (r13 >= 'u') goto L19;
        char r14 = k.a[r13];
    L20:
        if (r14 == 0) goto L27;
        this.d.append(r14);
        goto L22
    L27:
        a.m(this, "Invalid escaped char '" + r13 + '\'', 0, null, 6);
        throw null;
    L19:
        r14 = 0;
        goto L20
    L29:
        a.m(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
        throw null;
    L31:
        r6 = r6 + 1;
        if (r6 < r2.length()) goto L38;
        this.d.append(p(), r8, r6);
        r6 = t(r6);
        if (r6 != (-1)) goto L35;
        a.m(this, "Unexpected EOF", r6, null, 4);
        throw null;
    L39:
        if (r10 == true) goto L41;
        String r0 = ((String) p()).subSequence(r8, r6).toString();
    L42:
        this.a = r6 + 1;
        return r0;
    L41:
        this.d.append(p(), r8, r6);
        r0 = this.d.toString();
        this.d.setLength(0);
        goto L42
    L45:
        this.a = r1 + 1;
        return this.e.substring(r7, r1);
    L47:
        j();
        n((byte) 1, false);
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.a
    public byte e() {
        String r0 = this.e;
        int r1 = this.a;
    L4:
        if (r1 == (-1)) goto L21;
        if (r1 >= r0.length()) goto L21;
        int r2 = r1 + 1;
        char r3 = r0.charAt(r1);
        if (r3 == ' ') goto L16;
        if (r3 == '\n') goto L16;
        if (r3 == '\r') goto L16;
        if (r3 == '\t') goto L16;
        boolean r4 = false;
    L17:
        if (r4 == false) goto L18;
        r1 = r2;
        goto L4
    L18:
        this.a = r2;
        return b.a(r3);
    L16:
        r4 = true;
    L21:
        this.a = r0.length();
        return 10;
    }

    @Override // kotlinx.serialization.json.internal.a
    public int u() {
        int r0 = this.a;
        if (r0 != (-1)) goto L5;
        return r0;
    L5:
        String r1 = this.e;
    L7:
        if (r0 >= r1.length()) goto L21;
        char r2 = r1.charAt(r0);
        if (r2 != ' ') goto L11;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L21;
        r0 = r0 + 1;
        goto L7
    L11:
        if (r2 == '\n') goto L18;
        if (r2 == '\r') goto L18;
        if (r2 == '\t') goto L18;
        r3 = false;
    L21:
        this.a = r0;
        return r0;
    }

    @Override // kotlinx.serialization.json.internal.a
    public final CharSequence p() {
        return this.e;
    }

    public m0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        this.e = r2;
    }

    @Override // kotlinx.serialization.json.internal.a
    public void g(char r7) {
        int r0 = this.a;
        if (r0 == (-1)) goto L27;
        String r3 = this.e;
    L6:
        if (r0 >= r3.length()) goto L25;
        int r4 = r0 + 1;
        char r1 = r3.charAt(r0);
        if (r1 != ' ') goto L10;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L19;
        r0 = r4;
        goto L6
    L19:
        this.a = r4;
        if (r1 != r7) goto L22;
        return;
    L22:
        x(r7);
        throw null;
    L10:
        if (r1 == '\n') goto L17;
        if (r1 == '\r') goto L17;
        if (r1 == '\t') goto L17;
        r5 = false;
        goto L18
    L25:
        this.a = -1;
        x(r7);
        throw null;
    L27:
        x(r7);
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.a
    public final int t(int r2) {
        if (r2 < this.e.length()) goto L7;
        return -1;
    L7:
        return r2;
    }

    @Override // kotlinx.serialization.json.internal.a
    public final String q(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "keyToMatch");
        int r0 = this.a;
    L17:
        th = move-exception;
        this.a = r0;
        this.c = null;
        throw th;
    L5:
        if (e() == 6) goto L9;
    L6:
        this.a = r0;
        this.c = null;
        return null;
    L9:
        if (Intrinsics.areEqual(s(r6), r5) == false) goto L6;
        this.c = null;     // Catch: Throwable -> L17
        if (e() != 5) goto L6;
        String r7 = s(r6);     // Catch: Throwable -> L17
        this.a = r0;
        this.c = null;
        return r7;
    }
}
