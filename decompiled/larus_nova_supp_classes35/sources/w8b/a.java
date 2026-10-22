package w8b;

import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Comparable<a> {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public TenantNameStatus g;
    public ChatterDescription h;
    public String i;
    public Long j;
    public boolean k;
    public boolean l;
    public String m;
    public CertificationInfo n;

    public a() {
    }

    public static int a(char r4) {
        if (r4 != ' ') goto L5;
        return 36;
    L5:
        boolean r0 = false;
        if ('a' <= r4) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L14;
        return 35 - (r4 - 'a');
    L14:
        if ('0' <= r4) goto L16;
    L18:
        if (r0 == true) goto L24;
        return -1;
    L24:
        return 9 - (r4 - '0');
    L16:
        if (r4 >= ':') goto L18;
        r0 = true;
        goto L18
    L8:
        if (r4 >= '{') goto L10;
        r3 = true;
        goto L11
    }

    public final String b() {
        String r0 = this.b;
        char r1 = '#';
        boolean r2 = true;
        if (r0 == null) goto L12;
        if (r0.length() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L12;
        r1 = r0.charAt(0);
        goto L12
    L7:
        r4 = false;
    L12:
        if ('A' <= r1) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L20;
        return String.valueOf(r1);
    L20:
        if ('a' <= r1) goto L22;
    L24:
        r2 = false;
    L25:
        if (r2 == true) goto L30;
        return "#";
    L30:
        return String.valueOf(Character.toUpperCase(r1));
    L22:
        if (r1 >= '{') goto L24;
    L14:
        if (r1 >= '[') goto L16;
        r3 = true;
        goto L17
    }

    public final int hashCode() {
        String r0 = this.e;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    L7:
        return 0;
    }

    @Override // java.lang.Comparable
    public final int compareTo(a r9) {
        a r10 = r9;
        Intrinsics.checkNotNullParameter(r10, "other");
        String r0 = b();
        boolean r2 = r0.equals("#");
        if ((r10.b().equals("#") ^ r2) == false) goto L6;
        if (r2 == true) goto L14;
    L11:
        return -1;
    L14:
        return 1;
    L6:
        int r3 = 0;
        if (r0.equals(r10.b()) == false) goto L39;
        String r1 = this.b;
        if (r1 == null) goto L11;
        String r4 = r10.b;
        if (r4 == null) goto L14;
        int r5 = r1.length();
        int r6 = r4.length();
        int r7 = Math.min(r5, r6);
    L16:
        if (r3 >= r7) goto L24;
        char r8 = r1.charAt(r3);
        char r11 = r4.charAt(r3);
        if (r8 == r11) goto L22;
        int r12 = a(r8);
        int r13 = a(r11);
        if (r12 == r13) goto L22;
        return -(r12 - r13);
    L22:
        r3 = r3 + 1;
        goto L16
    L24:
        if (r5 != r6) goto L34;
        Long r14 = this.j;
        long r15 = 0;
        if (r14 == null) goto L28;
        long r16 = r14.longValue();
    L29:
        Long r17 = r10.j;
        if (r17 == null) goto L43;
        r15 = r17.longValue();
    L43:
        return -((int) (r16 - r15));
    L28:
        r16 = 0;
        goto L29
    L34:
        return r5 - r6;
    L39:
        return r0.charAt(0) - r10.b().charAt(0);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof a) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.e, ((a) r2).e);
    }
}
