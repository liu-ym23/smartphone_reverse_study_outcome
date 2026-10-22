package z;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    public static class a {
        public static int a(TypedArray r8, int r10) {
            return r8.getType(r10);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0201d[] f14134a;

        public c(C0201d[] r8) {
            this.f14134a = r8;
        }
    }

    /* JADX INFO: renamed from: z.d$d, reason: collision with other inner class name */
    public static final class C0201d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f14136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f14137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f14138d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f14139e;

        public C0201d(int r8, int r10, int r11, String r12, String r13, boolean r14) {
            this.f14135a = r8;
            this.f14136b = r14;
            this.f14137c = r13;
            this.f14138d = r10;
            this.f14139e = r11;
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0.f f14140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f14143d;

        public e(g0.f r8, int r10, int r11, String r12) {
            this.f14140a = r8;
            this.f14142c = r10;
            this.f14141b = r11;
            this.f14143d = r12;
        }
    }

    public static b a(XmlResourceParser r23, Resources r24) {
    L3:
        int r8 = r23.next();
        if (r8 == 2) goto L7;
        if (r8 != 1) goto L3;
    L7:
        if (r8 != 2) goto L64;
        r23.require(2, null, "font-family");
        if (r23.getName().equals("font-family") == false) goto L60;
        TypedArray r10 = r24.obtainAttributes(Xml.asAttributeSet(r23), y.a.f13900b);
        String r11 = r10.getString(0);
        String r12 = r10.getString(4);
        String r13 = r10.getString(5);
        int r14 = r10.getResourceId(1, 0);
        int r15 = r10.getInteger(2, 1);
        int r16 = r10.getInteger(3, 500);
        String r17 = r10.getString(6);
        r10.recycle();
        if (r11 == null) goto L18;
        if (r12 == null) goto L18;
        if (r13 == null) goto L18;
    L15:
        if (r23.next() == 3) goto L78;
        c(r23);
        goto L15
    L78:
        return new e(new g0.f(r11, r12, r13, b(r24, r14)), r15, r16, r17);
    L18:
        ArrayList r18 = new ArrayList();
    L20:
        if (r23.next() == 3) goto L57;
        if (r23.getEventType() != 2) goto L20;
        if (r23.getName().equals("font") == true) goto L26;
        c(r23);
        goto L20
    L26:
        TypedArray r19 = r24.obtainAttributes(Xml.asAttributeSet(r23), y.a.f13901c);
        int r20 = 8;
        if (r19.hasValue(8) == true) goto L30;
        r20 = 1;
    L30:
        int r110 = r19.getInt(r20, 400);
        if (r19.hasValue(6) == false) goto L33;
        int r21 = 6;
    L35:
        if (1 != r19.getInt(r21, 0)) goto L37;
        boolean r22 = true;
    L38:
        int r25 = 9;
        if (r19.hasValue(9) == true) goto L42;
        r25 = 3;
    L42:
        int r26 = 7;
        if (r19.hasValue(7) == true) goto L46;
        r26 = 4;
    L46:
        String r27 = r19.getString(r26);
        int r111 = r19.getInt(r25, 0);
        if (r19.hasValue(5) == false) goto L49;
        int r28 = 5;
    L50:
        int r112 = r19.getResourceId(r28, 0);
        String r29 = r19.getString(r28);
        r19.recycle();
    L52:
        if (r23.next() == 3) goto L54;
        c(r23);
        goto L52
    L54:
        r18.add(new C0201d(r110, r111, r112, r29, r27, r22));
        goto L20
    L49:
        r28 = 0;
        goto L50
    L37:
        r22 = false;
        goto L38
    L33:
        r21 = 2;
        goto L35
    L57:
        if (r18.isEmpty() == false) goto L79;
    L61:
        return null;
    L79:
        return new c((C0201d[]) r18.toArray(new C0201d[0]));
    L60:
        c(r23);
        goto L61
    L64:
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> b(Resources r8, int r10) {
        if (r10 == 0) goto L4;
        TypedArray r11 = r8.obtainTypedArray(r10);
    L29:
        th = move-exception;
        r11.recycle();
        throw th;
    L7:
        if (r11.length() != 0) goto L11;
        List<List<byte[]>> r12 = Collections.emptyList();     // Catch: Throwable -> L29
        r11.recycle();
        return r12;
    L11:
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L29
        if (a.a(r11, 0) != 1) goto L23;
        int r14 = 0;
    L15:
        if (r14 >= r11.length()) goto L27;
        int r15 = r11.getResourceId(r14, 0);     // Catch: Throwable -> L29
        if (r15 == 0) goto L22;
        String[] r16 = r8.getStringArray(r15);     // Catch: Throwable -> L29
        ArrayList r17 = new ArrayList();     // Catch: Throwable -> L29
        int r18 = r16.length;     // Catch: Throwable -> L29
        int r19 = 0;
    L19:
        if (r19 >= r18) goto L21;
        r17.add(Base64.decode(r16[r19], 0));     // Catch: Throwable -> L29
        r19 = r19 + 1;     // Catch: Throwable -> L29
        goto L19
    L21:
        r13.add(r17);     // Catch: Throwable -> L29
    L22:
        r14 = r14 + 1;     // Catch: Throwable -> L29
    L27:
        r11.recycle();
        return r13;
    L23:
        String[] r20 = r8.getStringArray(r10);     // Catch: Throwable -> L29
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L29
        int r22 = r20.length;     // Catch: Throwable -> L29
        int r23 = 0;
    L24:
        if (r23 >= r22) goto L26;
        r21.add(Base64.decode(r20[r23], 0));     // Catch: Throwable -> L29
        r23 = r23 + 1;     // Catch: Throwable -> L29
        goto L24
    L26:
        r13.add(r21);     // Catch: Throwable -> L29
        goto L27
    L4:
        return Collections.emptyList();
    }

    public static void c(XmlResourceParser r8) {
        int r10 = 1;
    L3:
        if (r10 <= 0) goto L11;
        int r11 = r8.next();
        if (r11 != 2) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        if (r11 != 3) goto L3;
        r10 = r10 - 1;
        goto L3
    }
}
