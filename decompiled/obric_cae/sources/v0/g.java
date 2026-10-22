package v0;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f12692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f12693b = null;

    static {
        f12692a = new byte[]{112, 114, 111, 0};
        f12693b = new byte[]{112, 114, 109, 0};
    }

    public static byte[] a(b[] r8, byte[] r10) {
        int r11 = r8.length;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L5;
        b r15 = r8[r13];
        r14 = r14 + ((((((r15.f12679g * 2) + 8) - 1) & (-8)) / 8) + (((r15.f12677e * 2) + (b(r15.f12673a, r10, r15.f12674b).getBytes(StandardCharsets.UTF_8).length + 16)) + r15.f12678f));
        r13 = r13 + 1;
        goto L3
    L5:
        ByteArrayOutputStream r16 = new ByteArrayOutputStream(r14);
        if (Arrays.equals(r10, h.f12696c) == false) goto L10;
        int r17 = r8.length;
    L8:
        if (r12 >= r17) goto L17;
        b r18 = r8[r12];
        m(r16, r18, b(r18.f12673a, r10, r18.f12674b));
        l(r16, r18);
        r12 = r12 + 1;
    L17:
        if (r16.size() != r14) goto L21;
        return r16.toByteArray();
    L21:
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + r16.size() + " expected=" + r14);
    L10:
        int r19 = r8.length;
        int r20 = 0;
    L11:
        if (r20 >= r19) goto L13;
        b r21 = r8[r20];
        m(r16, r21, b(r21.f12673a, r10, r21.f12674b));
        r20 = r20 + 1;
        goto L11
    L13:
        int r22 = r8.length;
    L14:
        if (r12 >= r22) goto L17;
        l(r16, r8[r12]);
        r12 = r12 + 1;
        goto L14
    }

    public static String b(String r8, byte[] r10, String r11) {
        byte[] r12 = h.f12698e;
        boolean r13 = Arrays.equals(r10, r12);
        byte[] r14 = h.f12697d;
        String r15 = "!";
        if (r13 == false) goto L6;
    L7:
        Object r16 = BdimCategoryConstants.SEPARATOR_COLON;
    L10:
        if (r8.length() > 0) goto L20;
        if ("!".equals(r16) == false) goto L15;
        return r11.replace(BdimCategoryConstants.SEPARATOR_COLON, "!");
    L15:
        if (BdimCategoryConstants.SEPARATOR_COLON.equals(r16) == false) goto L18;
        r11 = r11.replace("!", BdimCategoryConstants.SEPARATOR_COLON);
    L18:
        return r11;
    L20:
        if (r11.equals("classes.dex") == false) goto L23;
        return r8;
    L23:
        if (r11.contains("!") == true) goto L39;
        if (r11.contains(BdimCategoryConstants.SEPARATOR_COLON) == true) goto L39;
        if (r11.endsWith(".apk") == false) goto L30;
        return r11;
    L30:
        StringBuilder r17 = android.aimedia.a.j(r8);
        if (Arrays.equals(r10, r12) == false) goto L34;
    L35:
        r15 = BdimCategoryConstants.SEPARATOR_COLON;
    L37:
        return android.aimedia.a.i(r17, r15, r11);
    L34:
        if (Arrays.equals(r10, r14) == false) goto L37;
    L39:
        if ("!".equals(r16) == false) goto L42;
        return r11.replace(BdimCategoryConstants.SEPARATOR_COLON, "!");
    L42:
        if (BdimCategoryConstants.SEPARATOR_COLON.equals(r16) == false) goto L45;
        r11 = r11.replace("!", BdimCategoryConstants.SEPARATOR_COLON);
    L45:
        return r11;
    L6:
        if (Arrays.equals(r10, r14) == true) goto L7;
        r16 = "!";
        goto L10
    }

    public static int c(int r8, int r10, int r11) {
        if (r8 == 1) goto L14;
        if (r8 != 2) goto L7;
        return r10;
    L7:
        if (r8 != 4) goto L11;
        return r10 + r11;
    L11:
        throw new IllegalStateException(defpackage.a.d("Unexpected flag: ", r8));
    L14:
        throw new IllegalStateException("HOT methods are not stored in the bitmap");
    }

    public static int[] d(ByteArrayInputStream r8, int r10) {
        int[] r11 = new int[r10];
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r13 = r13 + l6.a.F0(r8);
        r11[r12] = r13;
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    public static b[] e(FileInputStream r8, byte[] r10, byte[] r11, b[] r12) {
        byte[] r13 = h.f12699f;
        if (Arrays.equals(r10, r13) == false) goto L27;
        if (Arrays.equals(h.f12694a, r11) == true) goto L25;
        if (Arrays.equals(r10, r13) == false) goto L23;
        int r14 = (int) l6.a.E0(r8, 1);
        long r15 = l6.a.E0(r8, 4);
        byte[] r16 = l6.a.D0(r8, (int) l6.a.E0(r8, 4), (int) r15);
        if (r8.read() > 0) goto L21;
        ByteArrayInputStream r17 = new ByteArrayInputStream(r16);
        b[] r18 = f(r17, r14, r12);     // Catch: Throwable -> L14
        r17.close();
        return r18;
    L14:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L21:
        throw new IllegalStateException("Content found after the end of file");
    L23:
        throw new IllegalStateException("Unsupported meta version");
    L25:
        throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
    L27:
        if (Arrays.equals(r10, h.f12700g) == false) goto L43;
        int r19 = l6.a.F0(r8);
        long r20 = l6.a.E0(r8, 4);
        byte[] r21 = l6.a.D0(r8, (int) l6.a.E0(r8, 4), (int) r20);
        if (r8.read() > 0) goto L41;
        ByteArrayInputStream r22 = new ByteArrayInputStream(r21);
        b[] r23 = g(r22, r11, r19, r12);     // Catch: Throwable -> L34
        r22.close();
        return r23;
    L34:
        th = move-exception;
        r22.close();     // Catch: Throwable -> L37
    L39:
        throw th;
    L37:
        th = move-exception;
        th.addSuppressed(th);
        goto L39
    L41:
        throw new IllegalStateException("Content found after the end of file");
    L43:
        throw new IllegalStateException("Unsupported meta version");
    }

    public static b[] f(ByteArrayInputStream r8, int r10, b[] r11) {
        int r12 = 0;
        if (r8.available() != 0) goto L7;
        return new b[0];
    L7:
        if (r10 != r11.length) goto L19;
        String[] r13 = new String[r10];
        int[] r14 = new int[r10];
        int r15 = 0;
    L9:
        if (r15 >= r10) goto L11;
        int r16 = l6.a.F0(r8);
        r14[r15] = l6.a.F0(r8);
        r13[r15] = new String(l6.a.C0(r8, r16), StandardCharsets.UTF_8);
        r15 = r15 + 1;
    L11:
        if (r12 >= r10) goto L17;
        b r17 = r11[r12];
        if (r17.f12674b.equals(r13[r12]) == false) goto L16;
        int r18 = r14[r12];
        r17.f12677e = r18;
        r17.f12680h = d(r8, r18);
        r12 = r12 + 1;
        goto L11
    L16:
        throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
    L17:
        return r11;
    L19:
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static b[] g(ByteArrayInputStream r10, byte[] r11, int r12, b[] r13) {
        if (r10.available() != 0) goto L7;
        return new b[0];
    L7:
        if (r12 != r13.length) goto L36;
        int r8 = 0;
    L9:
        if (r8 >= r12) goto L34;
        l6.a.F0(r10);
        String r14 = new String(l6.a.C0(r10, l6.a.F0(r10)), StandardCharsets.UTF_8);
        long r15 = l6.a.E0(r10, 4);
        int r16 = l6.a.F0(r10);
        if (r13.length <= 0) goto L26;
        int r17 = r14.indexOf("!");
        if (r17 >= 0) goto L16;
        r17 = r14.indexOf(BdimCategoryConstants.SEPARATOR_COLON);
    L16:
        if (r17 <= 0) goto L18;
        String r18 = r14.substring(r17 + 1);
    L19:
        int r19 = 0;
    L21:
        if (r19 >= r13.length) goto L26;
        if (r13[r19].f12674b.equals(r18) == true) goto L24;
        r19 = r19 + 1;
        goto L21
    L24:
        b r20 = r13[r19];
    L27:
        if (r20 == null) goto L33;
        r20.f12676d = r15;
        int[] r21 = d(r10, r16);
        if (Arrays.equals(r11, h.f12698e) == false) goto L31;
        r20.f12677e = r16;
        r20.f12680h = r21;
    L31:
        r8 = r8 + 1;
        goto L9
    L33:
        throw new IllegalStateException("Missing profile key: ".concat(r14));
    L18:
        r18 = r14;
    L26:
        r20 = null;
        goto L27
    L34:
        return r13;
    L36:
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static b[] h(FileInputStream r8, byte[] r10, String r11) {
        if (Arrays.equals(r10, h.f12695b) == false) goto L19;
        int r12 = (int) l6.a.E0(r8, 1);
        long r13 = l6.a.E0(r8, 4);
        byte[] r14 = l6.a.D0(r8, (int) l6.a.E0(r8, 4), (int) r13);
        if (r8.read() > 0) goto L17;
        ByteArrayInputStream r15 = new ByteArrayInputStream(r14);
        b[] r16 = i(r15, r11, r12);     // Catch: Throwable -> L10
        r15.close();
        return r16;
    L10:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw new IllegalStateException("Content found after the end of file");
    L19:
        throw new IllegalStateException("Unsupported version");
    }

    public static b[] i(ByteArrayInputStream r17, String r18, int r19) {
        if (r17.available() == 0) goto L5;
        b[] r8 = new b[r19];
        int r10 = 0;
    L8:
        if (r10 >= r19) goto L10;
        int r11 = l6.a.F0(r17);
        int r12 = l6.a.F0(r17);
        long r13 = l6.a.E0(r17, 4);
        r8[r10] = new b(r18, new String(l6.a.C0(r17, r11), StandardCharsets.UTF_8), l6.a.E0(r17, 4), r12, (int) r13, (int) l6.a.E0(r17, 4), new int[r12], new TreeMap());
        r10 = r10 + 1;
        goto L8
    L10:
        int r14 = 0;
    L11:
        if (r14 >= r19) goto L49;
        b r15 = r8[r14];
        int r16 = r17.available() - r15.f12678f;
        int r20 = 0;
    L13:
        int r21 = r17.available();
        TreeMap<Integer, Integer> r110 = r15.f12681i;
        if (r21 <= r16) goto L30;
        r20 = r20 + l6.a.F0(r17);
        r110.put(Integer.valueOf(r20), 1);
        int r22 = l6.a.F0(r17);
    L16:
        if (r22 <= 0) goto L13;
        l6.a.F0(r17);
        int r111 = (int) l6.a.E0(r17, 1);
        if (r111 != 6) goto L21;
    L28:
        r22 = r22 - 1;
        goto L16
    L21:
        if (r111 == 7) goto L28;
    L23:
        if (r111 <= 0) goto L28;
        l6.a.E0(r17, 1);
        int r112 = (int) l6.a.E0(r17, 1);
    L25:
        if (r112 <= 0) goto L27;
        l6.a.F0(r17);
        r112 = r112 - 1;
        goto L25
    L27:
        r111 = r111 - 1;
        goto L23
    L30:
        if (r17.available() != r16) goto L48;
        r15.f12680h = d(r17, r15.f12677e);
        int r23 = r15.f12679g;
        BitSet r24 = BitSet.valueOf(l6.a.C0(r17, ((((r23 * 2) + 8) - 1) & (-8)) / 8));
        int r25 = 0;
    L32:
        if (r25 >= r23) goto L46;
        int r26 = 2;
        if (r24.get(c(2, r25, r23)) == true) goto L38;
        r26 = 0;
    L38:
        if (r24.get(c(4, r25, r23)) == false) goto L40;
        r26 = r26 | 4;
    L40:
        if (r26 == 0) goto L45;
        Integer r113 = r110.get(Integer.valueOf(r25));
        if (r113 != null) goto L44;
        r113 = 0;
    L44:
        r110.put(Integer.valueOf(r25), Integer.valueOf(r26 | r113.intValue()));
    L45:
        r25 = r25 + 1;
        goto L32
    L46:
        r14 = r14 + 1;
        goto L11
    L48:
        throw new IllegalStateException("Read too much data during profile line parse");
    L49:
        return r8;
    L5:
        return new b[0];
    }

    public static boolean j(ByteArrayOutputStream r18, byte[] r19, b[] r20) {
        byte[] r8 = h.f12694a;
        int r10 = 0;
        if (Arrays.equals(r19, r8) == false) goto L93;
        ArrayList r11 = new ArrayList(3);
        ArrayList r12 = new ArrayList(3);
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();
        l6.a.e1(r13, r20.length);     // Catch: Throwable -> L86
        int r14 = 2;
        int r15 = 0;
        int r16 = 2;
    L7:
        if (r15 >= r20.length) goto L9;
        b r17 = r20[r15];     // Catch: Throwable -> L86
        l6.a.d1(r13, r17.f12675c, 4);     // Catch: Throwable -> L86
        l6.a.d1(r13, r17.f12676d, 4);     // Catch: Throwable -> L86
        l6.a.d1(r13, r17.f12679g, 4);     // Catch: Throwable -> L86
        String r110 = b(r17.f12673a, r8, r17.f12674b);     // Catch: Throwable -> L86
        int r111 = r110.getBytes(StandardCharsets.UTF_8).length;     // Catch: Throwable -> L86
        l6.a.e1(r13, r111);     // Catch: Throwable -> L86
        r16 = ((((r16 + 4) + 4) + 4) + 2) + (r111 * 1);     // Catch: Throwable -> L86
        r13.write(r110.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L86
        r15 = r15 + 1;     // Catch: Throwable -> L86
        goto L7
    L9:
        byte[] r21 = r13.toByteArray();     // Catch: Throwable -> L86
        if (r16 != r21.length) goto L85;
        i r112 = new i(c.f12682b, r21, false);     // Catch: Throwable -> L86
        r13.close();
        r11.add(r112);
        ByteArrayOutputStream r22 = new ByteArrayOutputStream();
        int r23 = 0;
        int r113 = 0;
    L143:
    L77:
        th = move-exception;
        r22.close();     // Catch: Throwable -> L81
        throw th;
    L81:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L15:
        if (r23 >= r20.length) goto L17;
        b r114 = r20[r23];     // Catch: Throwable -> L77
        l6.a.e1(r22, r23);     // Catch: Throwable -> L77
        l6.a.e1(r22, r114.f12677e);     // Catch: Throwable -> L77
        r113 = ((r113 + 2) + 2) + (r114.f12677e * 2);     // Catch: Throwable -> L77
        k(r22, r114);     // Catch: Throwable -> L77
        r23 = r23 + 1;     // Catch: Throwable -> L77
        goto L143
    L17:
        byte[] r24 = r22.toByteArray();     // Catch: Throwable -> L77
        if (r113 != r24.length) goto L76;
        i r115 = new i(c.f12683m, r24, true);     // Catch: Throwable -> L77
        r22.close();
        r11.add(r115);
        ByteArrayOutputStream r25 = new ByteArrayOutputStream();
        int r26 = 0;
        int r116 = 0;
    L133:
    L68:
        th = move-exception;
        r25.close();     // Catch: Throwable -> L72
        throw th;
    L72:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L22:
        if (r26 >= r20.length) goto L49;
        b r117 = r20[r26];     // Catch: Throwable -> L68
        Iterator<Map.Entry<Integer, Integer>> r118 = r117.f12681i.entrySet().iterator();     // Catch: Throwable -> L68
        int r119 = r10;
    L25:
        if (r118.hasNext() == false) goto L27;
        r119 = r119 | r118.next().getValue().intValue();     // Catch: Throwable -> L68
        goto L25
    L27:
        ByteArrayOutputStream r120 = new ByteArrayOutputStream();     // Catch: Throwable -> L68
        n(r120, r119, r117);     // Catch: Throwable -> L41
        byte[] r27 = r120.toByteArray();     // Catch: Throwable -> L41
        r120.close();     // Catch: Throwable -> L68
        ByteArrayOutputStream r121 = new ByteArrayOutputStream();     // Catch: Throwable -> L68
        o(r121, r117);     // Catch: Throwable -> L33
        byte[] r122 = r121.toByteArray();     // Catch: Throwable -> L33
        r121.close();     // Catch: Throwable -> L68
        l6.a.e1(r25, r26);     // Catch: Throwable -> L68
        int r123 = (r27.length + r14) + r122.length;     // Catch: Throwable -> L68
        int r124 = (r116 + 2) + 4;     // Catch: Throwable -> L68
        ArrayList r125 = r12;
        l6.a.d1(r25, r123, 4);     // Catch: Throwable -> L68
        l6.a.e1(r25, r119);     // Catch: Throwable -> L68
        r25.write(r27);     // Catch: Throwable -> L68
        r25.write(r122);     // Catch: Throwable -> L68
        r116 = r124 + r123;
        r26 = r26 + 1;
        r12 = r125;
        r10 = 0;
        r14 = 2;
        goto L133
    L33:
        th = move-exception;
        r121.close();     // Catch: Throwable -> L37
    L162:
        throw th;     // Catch: Throwable -> L68
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L68
        throw th;     // Catch: Throwable -> L68
    L41:
        th = move-exception;
        r120.close();     // Catch: Throwable -> L45
    L163:
        throw th;     // Catch: Throwable -> L68
    L45:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L68
        throw th;     // Catch: Throwable -> L68
    L49:
        ArrayList r126 = r12;
        byte[] r28 = r25.toByteArray();     // Catch: Throwable -> L68
        if (r116 != r28.length) goto L67;
        i r29 = new i(c.f12684n, r28, true);     // Catch: Throwable -> L68
        r25.close();
        r11.add(r29);
        long r30 = 4;
        long r31 = ((r30 + r30) + 4) + ((long) (r11.size() * 16));
        l6.a.d1(r18, r11.size(), 4);
        int r32 = 0;
    L54:
        if (r32 >= r11.size()) goto L60;
        i r33 = (i) r11.get(r32);
        l6.a.d1(r18, r33.f12701a.f12686a, 4);
        l6.a.d1(r18, r31, 4);
        boolean r34 = r33.f12703c;
        byte[] r35 = r33.f12702b;
        if (r34 == false) goto L58;
        long r36 = r35.length;
        byte[] r37 = l6.a.z(r35);
        ArrayList r127 = r126;
        r127.add(r37);
        l6.a.d1(r18, r37.length, 4);
        l6.a.d1(r18, r36, 4);
        int r38 = r37.length;
    L59:
        r31 = r31 + ((long) r38);
        r32 = r32 + 1;
        r126 = r127;
        goto L54
    L58:
        r127 = r126;
        r127.add(r35);
        l6.a.d1(r18, r35.length, 4);
        l6.a.d1(r18, 0, 4);
        r38 = r35.length;
        goto L59
    L60:
        ArrayList r128 = r126;
        int r39 = 0;
    L62:
        if (r39 >= r128.size()) goto L64;
        r18.write((byte[]) r128.get(r39));
        r39 = r39 + 1;
        goto L62
    L64:
        return true;
    L67:
        throw new IllegalStateException("Expected size " + r116 + ", does not match actual size " + r28.length);     // Catch: Throwable -> L68
    L76:
        throw new IllegalStateException("Expected size " + r113 + ", does not match actual size " + r24.length);     // Catch: Throwable -> L77
    L85:
        throw new IllegalStateException("Expected size " + r16 + ", does not match actual size " + r21.length);     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L90
        throw th;
    L90:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L93:
        byte[] r40 = h.f12695b;
        if (Arrays.equals(r19, r40) == false) goto L97;
        byte[] r41 = a(r20, r40);
        l6.a.d1(r18, r20.length, 1);
        l6.a.d1(r18, r41.length, 4);
        byte[] r42 = l6.a.z(r41);
        l6.a.d1(r18, r42.length, 4);
        r18.write(r42);
        return true;
    L97:
        byte[] r43 = h.f12697d;
        if (Arrays.equals(r19, r43) == false) goto L111;
        l6.a.d1(r18, r20.length, 1);
        int r44 = r20.length;
        int r45 = 0;
    L100:
        if (r45 >= r44) goto L109;
        b r46 = r20[r45];
        int r47 = r46.f12681i.size() * 4;
        String r48 = b(r46.f12673a, r43, r46.f12674b);
        l6.a.e1(r18, r48.getBytes(StandardCharsets.UTF_8).length);
        l6.a.e1(r18, r46.f12680h.length);
        l6.a.d1(r18, r47, 4);
        l6.a.d1(r18, r46.f12675c, 4);
        r18.write(r48.getBytes(StandardCharsets.UTF_8));
        Iterator<Integer> r49 = r46.f12681i.keySet().iterator();
    L103:
        if (r49.hasNext() == false) goto L105;
        l6.a.e1(r18, r49.next().intValue());
        l6.a.e1(r18, 0);
        goto L103
    L105:
        int[] r50 = r46.f12680h;
        int r51 = r50.length;
        int r52 = 0;
    L106:
        if (r52 >= r51) goto L108;
        l6.a.e1(r18, r50[r52]);
        r52 = r52 + 1;
        goto L106
    L108:
        r45 = r45 + 1;
        goto L100
    L109:
        return true;
    L111:
        byte[] r53 = h.f12696c;
        if (Arrays.equals(r19, r53) == false) goto L115;
        byte[] r54 = a(r20, r53);
        l6.a.d1(r18, r20.length, 1);
        l6.a.d1(r18, r54.length, 4);
        byte[] r55 = l6.a.z(r54);
        l6.a.d1(r18, r55.length, 4);
        r18.write(r55);
        return true;
    L115:
        byte[] r56 = h.f12698e;
        if (Arrays.equals(r19, r56) == false) goto L129;
        l6.a.e1(r18, r20.length);
        int r57 = r20.length;
        int r58 = 0;
    L118:
        if (r58 >= r57) goto L127;
        b r59 = r20[r58];
        String r60 = b(r59.f12673a, r56, r59.f12674b);
        l6.a.e1(r18, r60.getBytes(StandardCharsets.UTF_8).length);
        TreeMap<Integer, Integer> r61 = r59.f12681i;
        l6.a.e1(r18, r61.size());
        l6.a.e1(r18, r59.f12680h.length);
        l6.a.d1(r18, r59.f12675c, 4);
        r18.write(r60.getBytes(StandardCharsets.UTF_8));
        Iterator<Integer> r62 = r61.keySet().iterator();
    L121:
        if (r62.hasNext() == false) goto L123;
        l6.a.e1(r18, r62.next().intValue());
        goto L121
    L123:
        int[] r63 = r59.f12680h;
        int r64 = r63.length;
        int r65 = 0;
    L124:
        if (r65 >= r64) goto L126;
        l6.a.e1(r18, r63[r65]);
        r65 = r65 + 1;
        goto L124
    L126:
        r58 = r58 + 1;
        goto L118
    L127:
        return true;
    L129:
        return false;
    }

    public static void k(ByteArrayOutputStream r8, b r10) {
        int[] r11 = r10.f12680h;
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Integer r15 = Integer.valueOf(r11[r13]);
        l6.a.e1(r8, r15.intValue() - r14);
        r14 = r15.intValue();
        r13 = r13 + 1;
        goto L3
    }

    public static void l(ByteArrayOutputStream r8, b r10) {
        o(r8, r10);
        k(r8, r10);
        int r11 = r10.f12679g;
        byte[] r12 = new byte[((((r11 * 2) + 8) - 1) & (-8)) / 8];
        Iterator<Map.Entry<Integer, Integer>> r13 = r10.f12681i.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Map.Entry<Integer, Integer> r14 = r13.next();
        int r15 = r14.getKey().intValue();
        int r16 = r14.getValue().intValue();
        if ((r16 & 2) == 0) goto L9;
        int r17 = c(2, r15, r11);
        int r18 = r17 / 8;
        r12[r18] = (byte) ((1 << (r17 % 8)) | r12[r18]);
    L9:
        if ((r16 & 4) == 0) goto L4;
        int r19 = c(4, r15, r11);
        int r20 = r19 / 8;
        r12[r20] = (byte) ((1 << (r19 % 8)) | r12[r20]);
        goto L4
    L11:
        r8.write(r12);
    }

    public static void m(ByteArrayOutputStream r8, b r10, String r11) {
        l6.a.e1(r8, r11.getBytes(StandardCharsets.UTF_8).length);
        l6.a.e1(r8, r10.f12677e);
        l6.a.d1(r8, r10.f12678f, 4);
        l6.a.d1(r8, r10.f12675c, 4);
        l6.a.d1(r8, r10.f12679g, 4);
        r8.write(r11.getBytes(StandardCharsets.UTF_8));
    }

    public static void n(ByteArrayOutputStream r10, int r11, b r12) {
        int r8 = Integer.bitCount(r11 & (-2));
        int r13 = r12.f12679g;
        byte[] r14 = new byte[((((r8 * r13) + 8) - 1) & (-8)) / 8];
        Iterator<Map.Entry<Integer, Integer>> r15 = r12.f12681i.entrySet().iterator();
    L4:
        if (r15.hasNext() == false) goto L18;
        Map.Entry<Integer, Integer> r16 = r15.next();
        int r17 = r16.getKey().intValue();
        int r18 = r16.getValue().intValue();
        int r19 = 0;
        int r20 = 1;
    L7:
        if (r20 > 4) goto L4;
        if (r20 == 1) goto L17;
        if ((r20 & r11) == 0) goto L17;
        if ((r20 & r18) != r20) goto L16;
        int r21 = (r13 * r19) + r17;
        int r22 = r21 / 8;
        r14[r22] = (byte) ((1 << (r21 % 8)) | r14[r22]);
    L16:
        r19 = r19 + 1;
    L17:
        r20 = r20 << 1;
        goto L7
    L18:
        r10.write(r14);
    }

    public static void o(ByteArrayOutputStream r8, b r10) {
        Iterator<Map.Entry<Integer, Integer>> r11 = r10.f12681i.entrySet().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<Integer, Integer> r13 = r11.next();
        int r14 = r13.getKey().intValue();
        if ((r13.getValue().intValue() & 1) == 0) goto L4;
        l6.a.e1(r8, r14 - r12);
        l6.a.e1(r8, 0);
        r12 = r14;
        goto L4
    }
}
