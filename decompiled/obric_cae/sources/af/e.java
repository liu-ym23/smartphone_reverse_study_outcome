package af;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.cae.smartNetwork.AppQoEManager.AIMediaEventSchema;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import we.a0;
import we.k;
import we.l;
import we.q;
import we.r;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    static {
        jf.g.d("\"\\");
        jf.g.d("\t ,=");
    }

    public static long a(a0 r8) {
        String r10 = r8.f13119p.d("Content-Length");
        if (r10 != null) goto L10;
    L7:
        return -1;
    L10:
        return Long.parseLong(r10);
    }

    public static boolean b(a0 r8) {
        if (r8.f13114a.f13339c.equals(HttpMethodContrants.HEAD) == false) goto L5;
        return false;
    L5:
        int r10 = r8.f13116m;
        if (r10 < 100) goto L10;
        if (r10 >= 200) goto L10;
    L15:
        if (a(r8) == (-1)) goto L17;
    L20:
        return true;
    L17:
        if ("chunked".equalsIgnoreCase(r8.n("Transfer-Encoding")) == true) goto L20;
        return false;
    L10:
        if (r10 == 204) goto L15;
        if (r10 == 304) goto L15;
        return true;
    }

    public static int c(int r8, String r10) {
        long r11 = Long.parseLong(r10);     // Catch: NumberFormatException -> L13
        if (r11 <= 2147483647L) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r11 >= 0) goto L12;
        return 0;
    L12:
        return (int) r11;
    L16:
        return r8;
    }

    public static void d(l r33, r r34, q r35) {
        if (r33 != l.f13225a) goto L5;
        return;
    L5:
        Pattern r8 = k.f13212j;
        List<String> r10 = r35.k("Set-Cookie");
        int r11 = r10.size();
        int r12 = 0;
        int r13 = 0;
        ArrayList r14 = null;
    L6:
        if (r13 >= r11) goto L239;
        String r15 = r10.get(r13);
        long r16 = System.currentTimeMillis();
        int r17 = r15.length();
        int r18 = xe.c.k(r15, r12, r17, ';');
        int r19 = xe.c.k(r15, r12, r18, '=');
        if (r19 != r18) goto L10;
    L9:
        List<String> r26 = r10;
        int r20 = r12;
    L232:
        k r21 = null;
    L233:
        if (r21 == null) goto L238;
        if (r14 != null) goto L237;
        r14 = new ArrayList();
    L237:
        r14.add(r21);
    L238:
        r13 = r13 + 1;
        r12 = r20;
        r10 = r26;
        goto L6
    L10:
        String r110 = xe.c.y(r12, r19, r15);
        if (r110.isEmpty() == true) goto L9;
        int r22 = r110.length();
    L14:
        if (r12 >= r22) goto L21;
        char r111 = r110.charAt(r12);
        if (r111 <= 31) goto L23;
        if (r111 >= 127) goto L23;
        r12 = r12 + 1;
    L23:
        if (r12 != (-1)) goto L25;
        String r23 = xe.c.y(r19 + 1, r18, r15);
        int r24 = r23.length();
        int r112 = 0;
    L27:
        if (r112 >= r24) goto L34;
        char r113 = r23.charAt(r112);
        if (r113 <= 31) goto L36;
        if (r113 >= 127) goto L36;
        r112 = r112 + 1;
    L36:
        if (r112 != (-1)) goto L25;
        int r25 = r18 + 1;
        long r114 = 253402300799999L;
        long r27 = 253402300799999L;
        String r115 = null;
        long r28 = -1;
        boolean r29 = false;
        boolean r210 = false;
        boolean r211 = true;
        boolean r212 = false;
        String r213 = null;
    L39:
        long r214 = Long.MAX_VALUE;
        if (r25 >= r17) goto L89;
        int r116 = xe.c.k(r15, r25, r17, ';');
        int r30 = xe.c.k(r15, r25, r116, '=');
        String r31 = xe.c.y(r25, r30, r15);
        if (r30 >= r116) goto L44;
        String r32 = xe.c.y(r30 + 1, r116, r15);
    L46:
        if (r31.equalsIgnoreCase("expires") == false) goto L50;
        r27 = k.b(r32.length(), r32);     // Catch: Throwable -> L247
    L62:
        r212 = true;
    L87:
        r25 = r116 + 1;
        goto L39
    L50:
        if (r31.equalsIgnoreCase("max-age") == false) goto L65;
        r28 = Long.parseLong(r32);     // Catch: NumberFormatException -> L55
        if (r28 > 0) goto L62;
    L60:
        r28 = Long.MIN_VALUE;
    L55:
        e = move-exception;
        if (r32.matches("-?\\d+") == false) goto L63;
        if (r32.startsWith("-") == true) goto L60;
        r28 = Long.MAX_VALUE;
        goto L62
    L63:
        throw e;
    L65:
        if (r31.equalsIgnoreCase("domain") == false) goto L79;
        if (r32.endsWith(".") == true) goto L77;
        if (r32.startsWith(".") == false) goto L71;
        r32 = r32.substring(1);     // Catch: Throwable -> L247
    L71:
        String r36 = xe.c.c(r32);     // Catch: Throwable -> L247
        if (r36 == null) goto L75;
        r115 = r36;
        r211 = false;
        goto L87
    L75:
        throw new IllegalArgumentException();     // Catch: Throwable -> L247
    L77:
        throw new IllegalArgumentException();     // Catch: Throwable -> L247
    L79:
        if (r31.equalsIgnoreCase("path") == false) goto L82;
        r213 = r32;
        goto L87
    L82:
        if (r31.equalsIgnoreCase(AIMediaEventSchema.FIELD_SECURE) == false) goto L85;
        r29 = true;
        goto L87
    L85:
        if (r31.equalsIgnoreCase("httponly") == false) goto L87;
        r210 = true;
        goto L87
    L44:
        r32 = "";
        goto L46
    L89:
        if (r28 != Long.MIN_VALUE) goto L92;
        r114 = Long.MIN_VALUE;
    L104:
        String r37 = r34.f13244d;
        if (r115 != null) goto L108;
        r115 = r37;
    L124:
        if (r37.length() == r115.length()) goto L219;
        ff.a r38 = ff.a.f7429h;
        r38.getClass();
        String[] r117 = IDN.toUnicode(r115).split("\\.");
        if (r38.f7430a.get() == false) goto L128;
    L251:
        r38.f7431b.await();     // Catch: InterruptedException -> L147
    L148:
        monitor-enter(r38);
    L216:
        th = move-exception;
        throw th;
    L150:
        if (r38.f7432c == null) goto L215;
        monitor-exit(r38);     // Catch: Throwable -> L216
        int r39 = r117.length;
        byte[][] r40 = new byte[r39][];
        int r118 = 0;
    L154:
        if (r118 >= r117.length) goto L156;
        r40[r118] = r117[r118].getBytes(xe.c.f13888i);
        r118 = r118 + 1;
        goto L154
    L156:
        int r119 = 0;
    L157:
        if (r119 >= r39) goto L162;
        String r120 = ff.a.a(r38.f7432c, r40, r119);
        if (r120 != null) goto L160;
        r119 = r119 + 1;
        goto L157
    L160:
        int r121 = 1;
    L163:
        if (r39 <= r121) goto L171;
        byte[][] r122 = (byte[][]) r40.clone();
        r26 = r10;
        int r41 = 0;
    L166:
        if (r41 >= (r122.length - r121)) goto L172;
        r122[r41] = ff.a.f7426e;
        String r42 = ff.a.a(r38.f7432c, r122, r41);
        if (r42 != null) goto L173;
        r41 = r41 + 1;
        r121 = 1;
    L173:
        if (r42 == null) goto L181;
        int r43 = 0;
    L176:
        if (r43 >= (r39 - 1)) goto L181;
        String r123 = ff.a.a(r38.f7433d, r40, r43);
        if (r123 != null) goto L182;
        r43 = r43 + 1;
    L182:
        if (r123 == null) goto L184;
        String[] r44 = "!".concat(r123).split("\\.");
    L198:
        if (r117.length != r44.length) goto L202;
        int r45 = 0;
        if (r44[0].charAt(0) == '!') goto L203;
        String r46 = null;
    L212:
        if (r46 != null) goto L220;
    L213:
        r20 = 0;
    L220:
        String r47 = r213;
        if (r47 != null) goto L223;
    L226:
        String r48 = r34.e();
        int r49 = r48.lastIndexOf(47);
        r20 = 0;
        if (r49 == 0) goto L229;
        String r50 = r48.substring(0, r49);
    L230:
        String r215 = r50;
    L231:
        r21 = new k(r110, r23, r114, r115, r215, r29, r210, r211, r212);
        goto L233
    L229:
        r50 = "/";
        goto L230
    L223:
        if (r47.startsWith("/") == false) goto L226;
        r215 = r47;
        r20 = 0;
    L203:
        char r51 = r44[r45].charAt(r45);
        int r52 = r117.length;
        int r53 = r44.length;
        if (r51 == '!') goto L207;
        r53 = r53 + 1;
    L207:
        int r54 = r52 - r53;
        StringBuilder r55 = new StringBuilder();
        String[] r56 = r115.split("\\.");
    L209:
        if (r54 >= r56.length) goto L211;
        r55.append(r56[r54]);
        r55.append('.');
        r54 = r54 + 1;
        goto L209
    L211:
        r55.deleteCharAt(r55.length() - 1);
        r46 = r55.toString();
        goto L212
    L202:
        r45 = 0;
        goto L203
    L184:
        if (r120 != null) goto L187;
        if (r42 != null) goto L187;
        r44 = ff.a.f7428g;
    L187:
        if (r120 == null) goto L189;
        r44 = r120.split("\\.");
    L190:
        if (r42 == null) goto L192;
        String[] r57 = r42.split("\\.");
    L194:
        if (r44.length > r57.length) goto L198;
        r44 = r57;
        goto L198
    L192:
        r57 = ff.a.f7427f;
        goto L194
    L189:
        r44 = ff.a.f7427f;
    L181:
        r123 = null;
    L172:
        r42 = null;
        goto L173
    L171:
        r26 = r10;
        goto L172
    L162:
        r121 = 1;
        r120 = null;
        goto L163
    L215:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");     // Catch: Throwable -> L216
    L147:
        Thread.currentThread().interrupt();
        goto L148
    L128:
        if (r38.f7430a.compareAndSet(false, true) == false) goto L251;
        boolean r124 = false;
    L257:
        r38.b();     // Catch: Throwable -> L133 IOException -> L135 InterruptedIOException -> L140
    L131:
        if (r124 == false) goto L148;
    L139:
        Thread.currentThread().interrupt();
    L133:
        th = move-exception;
        if (r124 == false) goto L144;
        Thread.currentThread().interrupt();
    L144:
        throw th;
    L140:
        Thread.interrupted();     // Catch: Throwable -> L133
        r124 = true;
    L135:
        e = move-exception;
        df.f.f7097a.l(5, e, "Failed to read public suffix list");     // Catch: Throwable -> L133
        if (r124 == false) goto L148;
    L219:
        r26 = r10;
        goto L220
    L108:
        if (r37.equals(r115) == false) goto L111;
    L119:
        boolean r58 = true;
    L121:
        if (r58 == true) goto L124;
    L111:
        if (r37.endsWith(r115) == true) goto L113;
    L120:
        r58 = false;
        goto L121
    L113:
        if (r37.charAt((r37.length() - r115.length()) - 1) != '.') goto L120;
        boolean r59 = xe.c.f13896q.matcher(r37).matches();     // Catch: IllegalArgumentException -> L116
    L118:
        if (r59 == true) goto L120;
    L116:
        e = move-exception;
        e.printStackTrace();
        r59 = false;
        goto L118
    L92:
        if (r28 != (-1)) goto L94;
        r114 = r27;
        goto L104
    L94:
        if (r28 > 9223372036854775L) goto L96;
        r214 = r28 * 1000;
    L96:
        long r216 = r16 + r214;
        if (r216 < r16) goto L104;
        if (r216 > 253402300799999L) goto L104;
        r114 = r216;
        goto L104
    L34:
        r112 = -1;
    L25:
        r26 = r10;
        goto L213
    L21:
        r12 = -1;
        goto L23
    L239:
        if (r14 == null) goto L241;
        List r60 = Collections.unmodifiableList(r14);
    L243:
        if (r60.isEmpty() == false) goto L245;
        return;
    L245:
        r33.getClass();
        return;
    L241:
        r60 = Collections.emptyList();
        goto L243
    }

    public static int e(int r8, String r10, String r11) {
    L3:
        if (r8 >= r10.length()) goto L8;
        if (r11.indexOf(r10.charAt(r8)) != (-1)) goto L8;
        r8 = r8 + 1;
    L8:
        return r8;
    }
}
