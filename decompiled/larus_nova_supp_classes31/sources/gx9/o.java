package gx9;

import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public o() {
    }

    public static String a() {
        return IAIChatControlTraceService.a.Hb();
    }

    public static String b() {
        return IAIChatControlTraceService.a.Db();
    }

    public static String c() {
        return IAIChatControlTraceService.a.Rb();
    }

    public static String d(long r1) {
        return IAIChatControlTraceService.a.h(r1);
    }

    public static JSONObject h(Map r3) {
        JSONObject r0 = new JSONObject();
        if (r3 == null) goto L10;
        Iterator r4 = r3.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r4.next();
        String r2 = (String) r1.getKey();
        String r5 = (String) r1.getValue();
        if (r5 == null) goto L6;
        r0.put(r2, r5);
    L10:
        return r0;
    }

    public static void i(long r1, String r3, Function1 r4) {
        com.larus.bmhome.chat.trace.a r2 = IAIChatControlTraceService.a.gc(r1);
        if (r2 != null) goto L6;
        FLogger.a.d("PromptControlTrace", r3.concat(" chatKey not found"));
        return;
    L6:
        r4.invoke(r2);
    }

    public static void g(final String r14, final String r15, final int r16, final int r17, final String r18, final long r19, final String r21, final String r22, final String r23, final String r24, final String r25) {
        Intrinsics.checkNotNullParameter(r14, "messageId");
        Intrinsics.checkNotNullParameter(r18, "suggestedType");
        i(r19, "onShowSuggestedPrompt", new k(r18, r14, r15, r19, r21, r16, r17, r24, r22, r23, r25));
    }

    public static void e(final String r32, final Long r33, Long r34, final String r35, final String r36, String r37, final long r38, String r40, String r41, String r42, String r43, Integer r44, String r45, String r46, String r47, String r48, Integer r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, Map r60, int r61) {
        if ((r61 & 4) == 0) goto L5;
        final Long r6 = null;
    L6:
        final String r10 = null;
        if ((r61 & 64) == 0) goto L9;
        final String r7 = null;
    L11:
        if ((r61 & 256) == 0) goto L13;
        final String r11 = null;
    L15:
        if ((r61 & 512) == 0) goto L17;
        final String r12 = null;
    L19:
        if ((r61 & 1024) == 0) goto L21;
        final String r13 = null;
    L23:
        if ((r61 & 2048) == 0) goto L25;
        final String r14 = null;
    L27:
        if ((r61 & 4096) == 0) goto L29;
        final Integer r15 = null;
    L31:
        if ((r61 & 8192) == 0) goto L33;
        final String r16 = null;
    L35:
        if ((r61 & 16384) == 0) goto L37;
        final String r17 = null;
    L39:
        if ((32768 & r61) == 0) goto L41;
        final String r18 = null;
    L43:
        if ((65536 & r61) == 0) goto L45;
        final String r19 = null;
    L47:
        if ((131072 & r61) == 0) goto L49;
        final Integer r20 = null;
    L51:
        if ((262144 & r61) == 0) goto L53;
        final String r21 = null;
    L55:
        if ((524288 & r61) == 0) goto L57;
        final String r23 = null;
    L59:
        if ((1048576 & r61) == 0) goto L61;
        final String r22 = null;
    L63:
        if ((2097152 & r61) == 0) goto L65;
        final String r24 = null;
    L67:
        if ((4194304 & r61) == 0) goto L69;
        final String r25 = null;
    L71:
        if ((8388608 & r61) == 0) goto L73;
        final String r26 = null;
    L75:
        if ((16777216 & r61) == 0) goto L77;
        final String r27 = null;
    L79:
        if ((33554432 & r61) == 0) goto L81;
        final String r28 = null;
    L83:
        if ((67108864 & r61) == 0) goto L85;
        final String r29 = null;
    L87:
        if ((134217728 & r61) == 0) goto L89;
        final String r30 = null;
    L91:
        if ((r61 & 268435456) == 0) goto L93;
        final Map r4 = null;
    L94:
        if (r32 != null) goto L97;
        return;
    L97:
        if (StringsKt.endsWith$default(r32, "onBoarding-msg", false, 2, null) == true) goto L102;
        i(r38, "onClickOnboardingCard", new g(r32, r38, r4, r33, r6, r7, r36, r35, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30));
        return;
    L102:
        return;
    L93:
        r4 = r60;
        goto L94
    L89:
        r30 = r59;
        goto L91
    L85:
        r29 = r58;
        goto L87
    L81:
        r28 = r57;
        goto L83
    L77:
        r27 = r56;
        goto L79
    L73:
        r26 = r55;
        goto L75
    L69:
        r25 = r54;
        goto L71
    L65:
        r24 = r53;
        goto L67
    L61:
        r22 = r52;
        goto L63
    L57:
        r23 = r51;
        goto L59
    L53:
        r21 = r50;
        goto L55
    L49:
        r20 = r49;
        goto L51
    L45:
        r19 = r48;
        goto L47
    L41:
        r18 = r47;
        goto L43
    L37:
        r17 = r46;
        goto L39
    L33:
        r16 = r45;
        goto L35
    L29:
        r15 = r44;
        goto L31
    L25:
        r14 = r43;
        goto L27
    L21:
        r13 = r42;
        goto L23
    L17:
        r12 = r41;
        goto L19
    L13:
        r11 = r40;
        goto L15
    L9:
        r7 = r37;
        goto L11
    L5:
        r6 = r34;
        goto L6
    }

    public static void f(final String r34, final String r35, final String r36, final String r37, Long r38, Long r39, String r40, final long r41, String r43, String r44, String r45, String r46, Integer r47, String r48, String r49, String r50, String r51, Integer r52, String r53, String r54, String r55, String r56, String r57, String r58, int r59, String r60, String r61, String r62, Map r63, int r64) {
        if ((r64 & 16) == 0) goto L5;
        final Long r13 = null;
    L7:
        if ((r64 & 32) == 0) goto L9;
        final Long r14 = null;
    L11:
        if ((r64 & 64) == 0) goto L13;
        final String r9 = null;
    L15:
        if ((r64 & 256) == 0) goto L17;
        final String r15 = null;
    L19:
        if ((r64 & 512) == 0) goto L21;
        final String r16 = null;
    L23:
        if ((r64 & 1024) == 0) goto L25;
        final String r17 = null;
    L27:
        if ((r64 & 2048) == 0) goto L29;
        final String r18 = null;
    L31:
        if ((r64 & 4096) == 0) goto L33;
        final Integer r19 = null;
    L35:
        if ((r64 & 8192) == 0) goto L37;
        final String r20 = null;
    L39:
        if ((r64 & 16384) == 0) goto L41;
        final String r21 = null;
    L43:
        if ((32768 & r64) == 0) goto L45;
        final String r22 = null;
    L47:
        if ((65536 & r64) == 0) goto L49;
        final String r23 = null;
    L51:
        if ((131072 & r64) == 0) goto L53;
        final Integer r24 = null;
    L55:
        if ((262144 & r64) == 0) goto L57;
        final String r25 = null;
    L59:
        if ((524288 & r64) == 0) goto L61;
        final String r27 = null;
    L63:
        if ((1048576 & r64) == 0) goto L65;
        final String r26 = null;
    L67:
        if ((2097152 & r64) == 0) goto L69;
        final String r28 = null;
    L71:
        if ((4194304 & r64) == 0) goto L73;
        final String r29 = null;
    L75:
        if ((8388608 & r64) == 0) goto L77;
        final String r30 = null;
    L79:
        if ((16777216 & r64) == 0) goto L81;
        final int r31 = 0;
    L83:
        if ((33554432 & r64) == 0) goto L85;
        final String r33 = null;
    L87:
        if ((67108864 & r64) == 0) goto L89;
        final String r12 = null;
    L91:
        if ((134217728 & r64) == 0) goto L93;
        final String r32 = null;
    L95:
        if ((r64 & 268435456) == 0) goto L97;
        final Map r8 = null;
    L98:
        i(r41, "onShowSingleOnboardingQuestion", new j(r34, r35, r41, r8, r9, r37, r36, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33));
        return;
    L97:
        r8 = r63;
        goto L98
    L93:
        r32 = r62;
        goto L95
    L89:
        r12 = r61;
        goto L91
    L85:
        r33 = r60;
        goto L87
    L81:
        r31 = r59;
        goto L83
    L77:
        r30 = r58;
        goto L79
    L73:
        r29 = r57;
        goto L75
    L69:
        r28 = r56;
        goto L71
    L65:
        r26 = r55;
        goto L67
    L61:
        r27 = r54;
        goto L63
    L57:
        r25 = r53;
        goto L59
    L53:
        r24 = r52;
        goto L55
    L49:
        r23 = r51;
        goto L51
    L45:
        r22 = r50;
        goto L47
    L41:
        r21 = r49;
        goto L43
    L37:
        r20 = r48;
        goto L39
    L33:
        r19 = r47;
        goto L35
    L29:
        r18 = r46;
        goto L31
    L25:
        r17 = r45;
        goto L27
    L21:
        r16 = r44;
        goto L23
    L17:
        r15 = r43;
        goto L19
    L13:
        r9 = r40;
        goto L15
    L9:
        r14 = r39;
        goto L11
    L5:
        r13 = r38;
        goto L7
    }
}
