package ms.bd.c;

import android.text.TextUtils;
import android.view.Display;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r3 {
    public static r3 j;
    public long a;
    public long b;
    public long c;
    public int d;
    public long e;
    public String f;
    public String g;
    public String h;
    public boolean i;

    public final JSONObject c() {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L14
        r1.put((String) p2.a(16777217, 0, 0, "e3d03f", new byte[]{117, 37}), this.a);     // Catch: Exception -> L14
        r1.put((String) p2.a(16777217, 0, 0, "2883e4", new byte[]{49, 46}), this.b);     // Catch: Exception -> L14
        r1.put((String) p2.a(16777217, 0, 0, "43c9f0", new byte[]{33, 60}), this.d);     // Catch: Exception -> L14
        r1.put((String) p2.a(16777217, 0, 0, "9a8558", new byte[]{44, 119}), this.e);     // Catch: Exception -> L14
        r1.put((String) p2.a(16777217, 0, 0, "f92e31", new byte[]{116, 58, 69}), this.i ? 1 : 0);     // Catch: Exception -> L14
        r1.put((String) p2.a(16777217, 0, 0, "f7ddf8", new byte[]{122, 49}), this.f);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(this.g) == true) goto L7;
        r1.put((String) p2.a(16777217, 0, 0, "9dc04f", new byte[]{56, 109}), this.g);     // Catch: Exception -> L14
    L7:
        if (TextUtils.isEmpty(this.h) == true) goto L9;
        r1.put((String) p2.a(16777217, 0, 0, "033488", new byte[]{37, 56}), this.h);     // Catch: Exception -> L14
    L9:
        this.c = System.currentTimeMillis();     // Catch: Exception -> L14
        r1.put((String) p2.a(16777217, 0, 0, "2d9c91", new byte[]{32, 114}), this.c / 1000);     // Catch: Exception -> L14
        if (r1.length() <= 0) goto L12;
        return r1;
    L12:
        return null;
    L17:
        return null;
    }

    public r3() {
        this.d = 1;
    }

    public static String b(Display[] r35) {
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L18
        int r2 = r35.length;     // Catch: Exception -> L18
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L13;
        Display r5 = r35[r4];     // Catch: Exception -> L18
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L18
        Object r7 = a(r5, (String) p2.a(16777217, 0, 0, "ea21a1", new byte[]{121, 71, 72, 86, 78, 42, 103, 89, 74, 111, 114, 108}));     // Catch: Exception -> L18
        r6.append(a(r7, (String) p2.a(16777217, 0, 0, "f22b10", new byte[]{120, 39, 79, 19, 28, 23, 100, 16, 104, 51, 112, 53, 111, 23, 3, 34})));     // Catch: Exception -> L18
        r6.append((String) p2.a(16777217, 0, 0, "4ba1b2", new byte[]{105}));     // Catch: Exception -> L18
        r6.append(a(r7, (String) p2.a(16777217, 0, 0, "28fc58", new byte[]{37, 54, 20, 16, 25})));     // Catch: Exception -> L18
        r6.append((String) p2.a(16777217, 0, 0, "56b230", new byte[]{104}));     // Catch: Exception -> L18
        r6.append(a(r7, (String) p2.a(16777217, 0, 0, "cd029e", new byte[]{124, 103, 78, 67})));     // Catch: Exception -> L18
        r6.append((String) p2.a(16777217, 0, 0, "fb719f", new byte[]{59}));     // Catch: Exception -> L18
        r6.append(a(r7, (String) p2.a(16777217, 0, 0, "ed6bca", new byte[]{96, ByteCompanionObject.MAX_VALUE, 85, 19})));     // Catch: Exception -> L18
        if (r1.toString().contains(r6.toString()) == true) goto L11;
        if (r1.length() <= 0) goto L10;
        r1.append((String) p2.a(16777217, 0, 0, "880e3e", new byte[]{114}));     // Catch: Exception -> L18
    L10:
        r1.append(r6);     // Catch: Exception -> L18
    L11:
        r4 = r4 + 1;     // Catch: Exception -> L18
        goto L4
    L13:
        if (r1.length() <= 0) goto L16;
        return r1.toString();
    L16:
        return null;
    L24:
        return null;
    }

    public static String d(Display[] r17) {
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L17
        int r2 = r17.length;     // Catch: Exception -> L17
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L12;
        Object r5 = a(r17[r4], (String) p2.a(16777217, 0, 0, "7c6225", new byte[]{43, 78, 82, 72, 8, 48, 4, 67, 100, 105, 39, 102, 64, 104, 12, 47, 49}));     // Catch: Exception -> L17
        if (r5 == null) goto L10;
        if (r1.toString().contains(r5.toString()) == true) goto L10;
        r1.append(r5);     // Catch: Exception -> L17
        r1.append((String) p2.a(16777217, 0, 0, "97fc79", new byte[]{115}));     // Catch: Exception -> L17
    L10:
        r4 = r4 + 1;     // Catch: Exception -> L17
        goto L4
    L12:
        if (r1.length() <= 0) goto L15;
        return r1.toString();
    L15:
        return null;
    L24:
        return null;
    }

    public static Object a(Object r11, String r12) {
        Method r0 = Class.class.getDeclaredMethod((String) p2.a(16777217, 0, 0, "9e49b9", new byte[]{47, 98, 83, 105, 88, 45, 54, 69, 119, 108, 44, 65, 78, 72, 81, 42}), new Class[]{String.class});     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        Field r13 = (Field) r0.invoke(r11.getClass(), new Object[]{r12});     // Catch: Throwable -> L10
        if (r13 == null) goto L13;
        r13.setAccessible(true);     // Catch: Throwable -> L10
        return r13.get(r11);
    L13:
        return null;
    L8:
        return null;
    L14:
        return null;
    }
}
