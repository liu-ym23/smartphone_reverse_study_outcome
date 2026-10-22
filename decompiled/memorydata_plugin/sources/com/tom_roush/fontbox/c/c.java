package com.tom_roush.fontbox.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f15955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15956b;

    /* JADX INFO: renamed from: com.tom_roush.fontbox.c.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f15957a;

        private a(String r1) {
            this.f15957a = r1;
        }

        /* synthetic */ a(String r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ String a(a r0) {
            return r0.f15957a;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f15958a;

        private b(String r1) {
            this.f15958a = r1;
        }

        /* synthetic */ b(String r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ String a(b r0) {
            return r0.f15958a;
        }
    }

    public c() {
        this.f15955a = new byte[512];
        this.f15956b = false;
    }

    public c(boolean r2) {
        this.f15955a = new byte[512];
        this.f15956b = false;
        this.f15956b = r2;
    }

    private int a(byte[] r3) {
        int r2 = r3[0] & 255;
        if (r3.length == 2) goto L5;
        return r2;
    L5:
        return (r2 << 8) + (r3[1] & 255);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v22, types: [com.tom_roush.fontbox.c.c$b] */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.lang.Object] */
    private Object a(PushbackInputStream r11) {
    L2:
        int r0 = r11.read();
        if (r0 == 9) goto L2;
        if (r0 == 32) goto L2;
        if (r0 == 13) goto L2;
        if (r0 == 10) goto L2;
        AnonymousClass1 r3 = null;
        if (r0 == (-1)) goto L130;
        if (r0 != 37) goto L16;
        StringBuilder r1 = new StringBuilder();
        r1.append((char) r0);
        a(r11, r1);
        return r1.toString();
    L16:
        if (r0 != 40) goto L18;
        StringBuilder r10 = new StringBuilder();
    L122:
        int r2 = r11.read();
        if (r2 == (-1)) goto L170;
        if (r2 == 41) goto L170;
        r10.append((char) r2);
    L170:
        return r10.toString();
    L18:
        if (r0 == 60) goto L78;
        if (r0 == 62) goto L74;
        if (r0 != 91) goto L23;
        ArrayList r4 = new ArrayList();
    L68:
        Object r5 = a(r11);
        if (r5 == null) goto L173;
        if ("]".equals(r5) == true) goto L174;
        r4.add(r5);
        goto L68
    L174:
        return r4;
    L173:
        return r4;
    L23:
        if (r0 == 93) goto L167;
        switch(r0) {
            case 47: goto L56;
            case 48: goto L40;
            case 49: goto L40;
            case 50: goto L40;
            case 51: goto L40;
            case 52: goto L40;
            case 53: goto L40;
            case 54: goto L40;
            case 55: goto L40;
            case 56: goto L40;
            case 57: goto L40;
            default: goto L25;
        };
    L25:
        StringBuilder r6 = new StringBuilder();
    L26:
        r6.append((char) r0);
        r0 = r11.read();
        if (a(r0) == true) goto L34;
        if (b(r0) == true) goto L34;
        if (Character.isDigit(r0) == false) goto L26;
    L34:
        if (b(r0) == false) goto L36;
    L37:
        r11.unread(r0);
    L38:
        ?? r12 = new b(r6.toString(), r3);
    L165:
        return r12;
    L36:
        if (Character.isDigit(r0) == false) goto L38;
    L40:
        StringBuilder r7 = new StringBuilder();
        r7.append((char) r0);
    L41:
        int r8 = r11.read();
        if (a(r8) == true) goto L47;
        char r9 = (char) r8;
        if (Character.isDigit(r9) == true) goto L46;
        if (r8 != 46) goto L47;
    L46:
        r7.append(r9);
    L47:
        r11.unread(r8);
        r12 = r7.toString();
    L53:
        e = move-exception;
        throw new IOException("Invalid number '" + r12 + "'", e);
    L49:
        if (r12.indexOf(46) < 0) goto L51;
        r12 = Double.valueOf(r12);     // Catch: NumberFormatException -> L53
    L131:
        goto L165
    L51:
        r12 = Integer.valueOf(r12);     // Catch: NumberFormatException -> L53
        goto L131
    L56:
        StringBuilder r13 = new StringBuilder();
    L57:
        int r14 = r11.read();
        if (a(r14) == true) goto L63;
        if (b(r14) == true) goto L63;
        r13.append((char) r14);
    L63:
        if (b(r14) == false) goto L166;
        r11.unread(r14);
    L166:
        return new a(r13.toString(), r3);
    L167:
        return "]";
    L74:
        if (r11.read() != 62) goto L77;
        return ">>";
    L77:
        throw new IOException("Error: expected the end of a dictionary.");
    L78:
        int r15 = r11.read();
        if (r15 != 60) goto L87;
        HashMap r16 = new HashMap();
    L81:
        Object r17 = a(r11);
        if (ZeusTransformUtils.instanceOf(r17, a.class) == false) goto L168;
        if (">>".equals(r17) == true) goto L168;
        r16.put(a.a((a) ZeusTransformUtils.preCheckCast(r17, a.class, "com.obric.memorydata.plugin")), a(r11));
    L168:
        return r16;
    L87:
        int r18 = 16;
        int r19 = -1;
    L89:
        if (r15 == (-1)) goto L120;
        if (r15 == 62) goto L120;
        if (r15 >= 48) goto L94;
    L96:
        int r20 = 65;
        if (r15 >= 65) goto L99;
    L101:
        r20 = 97;
        if (r15 < 97) goto L116;
        if (r15 > 102) goto L116;
    L100:
        int r21 = (r15 + 10) - r20;
    L106:
        int r22 = r21 * r18;
        if (r18 != 16) goto L113;
        r19 = r19 + 1;
        byte[] r23 = this.f15955a;
        if (r19 >= r23.length) goto L112;
        r23[r19] = 0;
        r18 = 1;
    L114:
        byte[] r24 = this.f15955a;
        r24[r19] = (byte) (r24[r19] + r22);
    L117:
        r15 = r11.read();
        goto L89
    L112:
        throw new IOException("cmap token ist larger than buffer size " + this.f15955a.length);
    L113:
        r18 = 16;
    L116:
        if (a(r15) == true) goto L117;
        throw new IOException("Error: expected hex character and not " + ((char) r15) + ParameterizedMessage.ERROR_MSG_SEPARATOR + r15);
    L99:
        if (r15 > 70) goto L101;
    L94:
        if (r15 > 57) goto L96;
        r21 = r15 - 48;
    L120:
        int r25 = r19 + 1;
        byte[] r26 = new byte[r25];
        System.arraycopy(this.f15955a, 0, r26, 0, r25);
        return r26;
    L130:
        return null;
    }

    private void a(int r11, PushbackInputStream r12, com.tom_roush.fontbox.c.b r13) {
        int r2 = 0;
    L3:
        if (r2 >= r11) goto L29;
        Object r3 = a(r12);
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L6;
        if ((r3 instanceof byte[]) == false) goto L21;
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin");
        int r5 = a(r4);
        byte[] r6 = (byte[]) ZeusTransformUtils.preCheckCast(a(r12), byte[].class, "com.obric.memorydata.plugin");
        int r7 = a(r6);
        int r8 = ((Integer) ZeusTransformUtils.preCheckCast(a(r12), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r4.length <= 2) goto L12;
    L16:
        int r9 = (r7 + r8) - r5;
    L17:
        if (r8 > r9) goto L19;
        r13.a(r8, a(r4));
        a(r4, r4.length - 1, false);
        r8 = r8 + 1;
    L19:
        r2 = r2 + 1;
        goto L3
    L12:
        if (r6.length > 2) goto L16;
        if (r7 != r5) goto L15;
        r13.a(r8, r5);
        goto L19
    L15:
        r13.a((char) r5, (char) r7, r8);
        goto L19
    L21:
        throw new IOException("start range missing");
    L6:
        a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"), "endcidrange", "cidrange");
        return;
    }

    private void a(com.tom_roush.fontbox.c.b r5, byte[] r6, int r7, byte[] r8) {
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L8;
        r5.a(r6, b(r8));
        if (a(r8, r8.length - 1, this.f15956b) == false) goto L11;
        a(r6, r6.length - 1, false);
        r1 = r1 + 1;
        goto L3
    L11:
        return;
    }

    private void a(com.tom_roush.fontbox.c.b r4, byte[] r5, List<byte[]> r6) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r4.a(r5, b((byte[]) ZeusTransformUtils.preCheckCast(r7.next(), byte[].class, "com.obric.memorydata.plugin")));
        a(r5, r5.length - 1, false);
        goto L4
    }

    private void a(a r1, com.tom_roush.fontbox.c.b r2) {
        r2.a(a(b(a.a(r1))));
    }

    private void a(a r4, PushbackInputStream r5, com.tom_roush.fontbox.c.b r6) {
        if ("WMode".equals(a.a(r4)) == false) goto L8;
        Object r3 = a(r5);
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L42;
        r6.c(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L42:
        return;
    L8:
        if ("CMapName".equals(a.a(r4)) == false) goto L13;
        Object r7 = a(r5);
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L44;
        r6.a(a.a((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin")));
        return;
    L44:
        return;
    L13:
        if ("CMapVersion".equals(a.a(r4)) == false) goto L22;
        Object r8 = a(r5);
        if (ZeusTransformUtils.instanceOf(r8, Number.class) == false) goto L19;
        String r9 = r8.toString();
    L17:
        r6.b(r9);
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L47;
        r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
        goto L17
    L47:
        return;
    L22:
        if ("CMapType".equals(a.a(r4)) == false) goto L27;
        Object r10 = a(r5);
        if (ZeusTransformUtils.instanceOf(r10, Integer.class) == false) goto L48;
        r6.d(((Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L48:
        return;
    L27:
        if ("Registry".equals(a.a(r4)) == false) goto L32;
        Object r11 = a(r5);
        if (ZeusTransformUtils.instanceOf(r11, String.class) == false) goto L50;
        r6.c((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin"));
        return;
    L50:
        return;
    L32:
        if ("Ordering".equals(a.a(r4)) == false) goto L37;
        Object r12 = a(r5);
        if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L52;
        r6.d((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin"));
        return;
    L52:
        return;
    L37:
        if ("Supplement".equals(a.a(r4)) == false) goto L54;
        Object r13 = a(r5);
        if (ZeusTransformUtils.instanceOf(r13, Integer.class) == false) goto L55;
        r6.e(((Integer) ZeusTransformUtils.preCheckCast(r13, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L55:
        return;
    }

    private void a(b r2, String r3, String r4) {
        if (b.a(r2).equals(r3) == false) goto L6;
        return;
    L6:
        throw new IOException("Error : ~" + r4 + " contains an unexpected operator : " + b.a(r2));
    }

    private void a(InputStream r2, StringBuilder r3) {
    L2:
        int r1 = r2.read();
        if (r1 == (-1)) goto L9;
        if (r1 == 13) goto L13;
        if (r1 == 10) goto L14;
        r3.append((char) r1);
        goto L2
    L14:
        return;
    L13:
        return;
    }

    private void a(Number r6, PushbackInputStream r7, com.tom_roush.fontbox.c.b r8) {
        int r1 = 0;
    L4:
        if (r1 >= r6.intValue()) goto L24;
        Object r2 = a(r7);
        if (ZeusTransformUtils.instanceOf(r2, b.class) == true) goto L7;
        if ((r2 instanceof byte[]) == false) goto L17;
        r8.a(new d((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(a(r7), byte[].class, "com.obric.memorydata.plugin")));     // Catch: IllegalArgumentException -> L13
        r1 = r1 + 1;
    L13:
        e = move-exception;
        throw new IOException(e);
    L17:
        throw new IOException("start range missing");
    L7:
        a((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin"), "endcodespacerange", "codespacerange");
        return;
    }

    private boolean a(int r1) {
        if (r1 != (-1)) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 32) goto L12;
        if (r1 == 13) goto L12;
        if (r1 == 10) goto L12;
        return false;
    }

    private boolean a(byte[] r4, int r5, boolean r6) {
        if (r5 > 0) goto L5;
    L10:
        r4[r5] = (byte) (r4[r5] + 1);
    L11:
        return true;
    L5:
        if ((r4[r5] & 255) != 255) goto L10;
        if (r6 == false) goto L9;
        return false;
    L9:
        r4[r5] = 0;
        a(r4, r5 - 1, r6);
        goto L11
    }

    private String b(byte[] r3) {
        if (r3.length != 1) goto L5;
        Charset r0 = com.tom_roush.fontbox.g.b.f16026a;
    L7:
        return new String(r3, r0);
    L5:
        r0 = com.tom_roush.fontbox.g.b.c;
        goto L7
    }

    private void b(Number r7, PushbackInputStream r8, com.tom_roush.fontbox.c.b r9) {
        int r1 = 0;
    L4:
        if (r1 >= r7.intValue()) goto L27;
        Object r2 = a(r8);
        if (ZeusTransformUtils.instanceOf(r2, b.class) == true) goto L7;
        if ((r2 instanceof byte[]) == false) goto L21;
        byte[] r3 = (byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin");
        Object r4 = a(r8);
        if ((r4 instanceof byte[]) == false) goto L15;
        String r5 = b((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
    L13:
        r9.a(r3, r5);
        r1 = r1 + 1;
        goto L4
    L15:
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L19;
        r5 = a.a((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin"));
        goto L13
    L19:
        throw new IOException("Error parsing CMap beginbfchar, expected{COSString or COSName} and not " + r4);
    L21:
        throw new IOException("input code missing");
    L7:
        a((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin"), "endbfchar", "bfchar");
        return;
    }

    private boolean b(int r1) {
        if (r1 != 37) goto L5;
        return true;
    L5:
        if (r1 != 47) goto L7;
        return true;
    L7:
        if (r1 != 60) goto L9;
        return true;
    L9:
        if (r1 != 62) goto L11;
        return true;
    L11:
        if (r1 != 91) goto L13;
        return true;
    L13:
        if (r1 != 93) goto L15;
        return true;
    L15:
        if (r1 != 123) goto L17;
        return true;
    L17:
        if (r1 != 125) goto L19;
        return true;
    L19:
        if (r1 != 40) goto L21;
        return true;
    L21:
        if (r1 == 41) goto L34;
        return false;
    L34:
        return true;
    }

    private void c(Number r6, PushbackInputStream r7, com.tom_roush.fontbox.c.b r8) {
        int r0 = 0;
    L4:
        if (r0 >= r6.intValue()) goto L17;
        Object r1 = a(r7);
        if (ZeusTransformUtils.instanceOf(r1, b.class) == true) goto L7;
        if ((r1 instanceof byte[]) == false) goto L12;
        byte[] r2 = (byte[]) ZeusTransformUtils.preCheckCast(r1, byte[].class, "com.obric.memorydata.plugin");
        r8.a(((Integer) ZeusTransformUtils.preCheckCast(a(r7), Integer.class, "com.obric.memorydata.plugin")).intValue(), a(r2));
        r0 = r0 + 1;
        goto L4
    L12:
        throw new IOException("start code missing");
    L7:
        a((b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin"), "endcidchar", "cidchar");
        return;
    }

    private void d(Number r11, PushbackInputStream r12, com.tom_roush.fontbox.c.b r13) {
        int r2 = 0;
    L4:
        if (r2 >= r11.intValue()) goto L63;
        Object r3 = a(r12);
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L7;
        if ((r3 instanceof byte[]) == false) goto L48;
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin");
        Object r5 = a(r12);
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L13;
        if ((r5 instanceof byte[]) == false) goto L46;
        byte[] r6 = (byte[]) ZeusTransformUtils.preCheckCast(r5, byte[].class, "com.obric.memorydata.plugin");
        int r7 = com.tom_roush.fontbox.c.b.a(r4, r4.length);
        int r8 = com.tom_roush.fontbox.c.b.a(r6, r6.length);
        if (r8 < r7) goto L64;
        Object r9 = a(r12);
        if (ZeusTransformUtils.instanceOf(r9, List.class) == false) goto L27;
        List<byte[]> r10 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        if (r10.isEmpty() == true) goto L44;
        if (r10.size() < (r8 - r7)) goto L44;
        a(r13, r4, r10);
    L44:
        r2 = r2 + 1;
        goto L4
    L27:
        if ((r9 instanceof byte[]) == false) goto L44;
        byte[] r14 = (byte[]) ZeusTransformUtils.preCheckCast(r9, byte[].class, "com.obric.memorydata.plugin");
        if (r14.length <= 0) goto L44;
        if (r14.length != 2) goto L43;
        if (r7 != 0) goto L43;
        if (r8 != 65535) goto L43;
        if (r14[0] != 0) goto L43;
        if (r14[1] != 0) goto L43;
        int r15 = 0;
    L41:
        if (r15 >= 256) goto L44;
        byte r16 = (byte) r15;
        r4[0] = r16;
        r4[1] = 0;
        r14[0] = r16;
        r14[1] = 0;
        a(r13, r4, 256, r14);
        r15 = r15 + 1;
    L43:
        a(r13, r4, (r8 - r7) + 1, r14);
        goto L44
    L64:
        return;
    L46:
        throw new IOException("end code missing");
    L13:
        Object r17 = ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
    L8:
        a((b) r17, "endbfrange", "bfrange");
        return;
    L48:
        throw new IOException("start code missing");
    L7:
        r17 = ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
        goto L8
    }

    public com.tom_roush.fontbox.c.b a(InputStream r8) {
        PushbackInputStream r0 = new PushbackInputStream(r8);
        com.tom_roush.fontbox.c.b r9 = new com.tom_roush.fontbox.c.b();
        Object r1 = null;
    L3:
        Object r2 = a(r0);
        if (r2 == null) goto L39;
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L36;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin");
        if (b.a(r3).equals("endcmap") == true) goto L39;
        if (r1 == null) goto L38;
        if (b.a(r3).equals("usecmap") == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L17;
        a((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin"), r9);
    L17:
        if (ZeusTransformUtils.instanceOf(r1, Number.class) == false) goto L38;
        if (b.a(r3).equals("begincodespacerange") == false) goto L22;
        a((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin"), r0, r9);
        goto L38
    L22:
        if (b.a(r3).equals("beginbfchar") == false) goto L25;
        b((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin"), r0, r9);
        goto L38
    L25:
        if (b.a(r3).equals("beginbfrange") == false) goto L28;
        d((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin"), r0, r9);
        goto L38
    L28:
        if (b.a(r3).equals("begincidchar") == false) goto L31;
        c((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin"), r0, r9);
        goto L38
    L31:
        if (b.a(r3).equals("begincidrange") == false) goto L38;
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L38;
        a(((Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.memorydata.plugin")).intValue(), r0, r9);
    L38:
        r1 = r2;
        goto L3
    L36:
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L38;
        a((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin"), r0, r9);
    L39:
        return r9;
    }

    public com.tom_roush.fontbox.c.b a(String r2) {
        InputStream r3 = b(r2);     // Catch: Throwable -> L10
        this.f15956b = false;     // Catch: Throwable -> L8
        com.tom_roush.fontbox.c.b r1 = a(r3);     // Catch: Throwable -> L8
        if (r3 == null) goto L7;
        r3.close();
    L7:
        return r1;
    L8:
        th = th;
    L12:
        if (r3 == null) goto L14;
        r3.close();
    L14:
        throw th;
    L10:
        th = th;
        r3 = null;
        goto L12
    }

    public InputStream b(String r3) {
        if (com.tom_roush.pdfbox.android.a.a() == true) goto L5;
        InputStream r2 = getClass().getResourceAsStream("/com/tom_roush/fontbox/resources/cmap/" + r3);
        if (r2 == null) goto L11;
        return new BufferedInputStream(r2);
    L11:
        throw new IOException("Error: Could not find referenced cmap stream " + r3);
    L5:
        return new BufferedInputStream(com.tom_roush.pdfbox.android.a.a("com/tom_roush/fontbox/resources/cmap/" + r3));
    }
}
