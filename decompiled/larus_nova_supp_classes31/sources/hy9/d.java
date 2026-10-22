package hy9;

import com.larus.im.bean.message.Message;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void b(d r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, Boolean r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, int r43) {
            JSONObject r2 = null;
            if ((r43 & 1) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r43 & 2) == 0) goto L9;
            String r5 = null;
        L11:
            if ((r43 & 4) == 0) goto L13;
            String r6 = null;
        L15:
            if ((r43 & 8) == 0) goto L17;
            String r7 = null;
        L19:
            if ((r43 & 16) == 0) goto L21;
            String r8 = null;
        L23:
            if ((r43 & 32) == 0) goto L25;
            String r9 = null;
        L27:
            if ((r43 & 64) == 0) goto L29;
            String r10 = null;
        L31:
            if ((r43 & 128) == 0) goto L33;
            String r11 = null;
        L35:
            if ((r43 & 256) == 0) goto L37;
            String r12 = null;
        L39:
            if ((r43 & 512) == 0) goto L41;
            String r13 = null;
        L43:
            if ((r43 & 1024) == 0) goto L45;
            Boolean r14 = null;
        L47:
            if ((r43 & 2048) == 0) goto L49;
            String r15 = null;
        L51:
            if ((r43 & 4096) == 0) goto L53;
            String r16 = "no_tab";
        L55:
            if ((r43 & 8192) == 0) goto L57;
            String r17 = null;
        L59:
            if ((r43 & 16384) == 0) goto L61;
            String r18 = null;
        L63:
            if ((32768 & r43) == 0) goto L65;
            String r19 = null;
        L67:
            if ((65536 & r43) == 0) goto L69;
            String r20 = null;
        L71:
            if ((131072 & r43) == 0) goto L73;
            String r21 = null;
        L75:
            if ((r43 & 262144) == 0) goto L77;
            r2 = new JSONObject();
        L77:
            r24.g(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r2, null);
            return;
        L73:
            r21 = r42;
            goto L75
        L69:
            r20 = r41;
            goto L71
        L65:
            r19 = r40;
            goto L67
        L61:
            r18 = r39;
            goto L63
        L57:
            r17 = r38;
            goto L59
        L53:
            r16 = r37;
            goto L55
        L49:
            r15 = r36;
            goto L51
        L45:
            r14 = r35;
            goto L47
        L41:
            r13 = r34;
            goto L43
        L37:
            r12 = r33;
            goto L39
        L33:
            r11 = r32;
            goto L35
        L29:
            r10 = r31;
            goto L31
        L25:
            r9 = r30;
            goto L27
        L21:
            r8 = r29;
            goto L23
        L17:
            r7 = r28;
            goto L19
        L13:
            r6 = r27;
            goto L15
        L9:
            r5 = r26;
            goto L11
        L5:
            r4 = r25;
            goto L7
        }

        public static /* synthetic */ void a(d r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, Boolean r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, JSONObject r47, int r48) {
            if ((r48 & 1) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r48 & 2) == 0) goto L9;
            String r5 = null;
        L11:
            if ((r48 & 4) == 0) goto L13;
            String r6 = null;
        L15:
            if ((r48 & 8) == 0) goto L17;
            String r7 = null;
        L19:
            if ((r48 & 16) == 0) goto L21;
            String r8 = null;
        L23:
            if ((r48 & 32) == 0) goto L25;
            String r9 = null;
        L27:
            if ((r48 & 64) == 0) goto L29;
            String r10 = null;
        L31:
            if ((r48 & 128) == 0) goto L33;
            String r11 = null;
        L35:
            if ((r48 & 256) == 0) goto L37;
            String r12 = null;
        L39:
            if ((r48 & 512) == 0) goto L41;
            String r13 = null;
        L43:
            if ((r48 & 1024) == 0) goto L45;
            Boolean r14 = null;
        L47:
            if ((r48 & 2048) == 0) goto L49;
            String r15 = null;
        L51:
            if ((r48 & 4096) == 0) goto L53;
            String r16 = null;
        L55:
            if ((r48 & 8192) == 0) goto L57;
            String r17 = null;
        L59:
            if ((r48 & 16384) == 0) goto L61;
            String r18 = null;
        L63:
            if ((32768 & r48) == 0) goto L65;
            String r19 = null;
        L67:
            if ((65536 & r48) == 0) goto L69;
            String r20 = "no_tab";
        L71:
            if ((131072 & r48) == 0) goto L73;
            String r21 = null;
        L75:
            if ((262144 & r48) == 0) goto L77;
            String r22 = null;
        L79:
            if ((524288 & r48) == 0) goto L81;
            String r23 = null;
        L83:
            if ((r48 & 1048576) == 0) goto L85;
            JSONObject r24 = new JSONObject();
        L86:
            r26.i(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, null);
            return;
        L85:
            r24 = r47;
            goto L86
        L81:
            r23 = r46;
            goto L83
        L77:
            r22 = r45;
            goto L79
        L73:
            r21 = r44;
            goto L75
        L69:
            r20 = r43;
            goto L71
        L65:
            r19 = r42;
            goto L67
        L61:
            r18 = r41;
            goto L63
        L57:
            r17 = r40;
            goto L59
        L53:
            r16 = r39;
            goto L55
        L49:
            r15 = r38;
            goto L51
        L45:
            r14 = r37;
            goto L47
        L41:
            r13 = r36;
            goto L43
        L37:
            r12 = r35;
            goto L39
        L33:
            r11 = r34;
            goto L35
        L29:
            r10 = r33;
            goto L31
        L25:
            r9 = r32;
            goto L27
        L21:
            r8 = r31;
            goto L23
        L17:
            r7 = r30;
            goto L19
        L13:
            r6 = r29;
            goto L15
        L9:
            r5 = r28;
            goto L11
        L5:
            r4 = r27;
            goto L7
        }
    }

    void a(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9);

    ky9.a b();

    void c(String r1);

    void d(int r1, String r2, String r3, String r4, String r5);

    ky9.b e();

    void f(String r1, String r2, String r3, String r4, String r5);

    void g(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Boolean r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, JSONObject r19, by7.e r20);

    void h(String r1, Integer r2, String r3, String r4, String r5, String r6, String r7, String r8, JSONObject r9, by7.e r10, String r11);

    void i(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Boolean r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, JSONObject r21, by7.e r22);

    void j(Message r1, String r2);

    void k(String r1, String r2, String r3, String r4);
}
