package ko8;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotSourceType;
import com.larus.im.bean.conversation.BotConversationType;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final LruCache<String, e> a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final long e = 0;

    public a() {
    }

    static {
        IAIChatControlTraceService.Companion r0 = IAIChatControlTraceService.a;
        a = r0.ac();
        b = r0.Hb();
        c = r0.Rb();
        d = r0.Db();
        e = r0.gb();
    }

    public static long g() {
        return IAIChatControlTraceService.a.Na();
    }

    public static String c(Message r1) {
        return IAIChatControlTraceService.a.tb(r1);
    }

    public static String d(Message r1) {
        return IAIChatControlTraceService.a.Kb(r1);
    }

    public static String e(long r1) {
        return IAIChatControlTraceService.a.h(r1);
    }

    public static String h(long r1) {
        return IAIChatControlTraceService.a.bb(r1);
    }

    public static JSONObject i(Message r1, JSONObject r2) {
        return IAIChatControlTraceService.a.Ua(r1, r2);
    }

    public static void k(String r1, String r2) {
        IAIChatControlTraceService.a.sb(r1, r2);
    }

    public static String f(@BotConversationType Integer r1, @BotSourceType Integer r2, boolean r3) {
        return IAIChatControlTraceService.a.g(r1, r2, r3);
    }

    public static void a(String r12, String r13, Integer r14, String r15, String r16, String r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r6 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r18 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r18 & 128) == 0) goto L25;
        String r11 = null;
    L26:
        IAIChatControlTraceService.a.ec(r4, r5, r6, r7, null, null, r10, r11);
        return;
    L25:
        r11 = r17;
        goto L26
    L21:
        r10 = r16;
        goto L23
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    public static void l(List r9, Message r10, BotModel r11, by7.e r12, String r13, String r14, JSONObject r15) {
        Intrinsics.checkNotNullParameter(r9, "menuItems");
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r14, "triggerFrom");
        Intrinsics.checkNotNullParameter(r15, "extraParams");
        IAIChatControlTraceService.a.jc(r9, r10, r11, r12, r13, r14, r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(String r15, Message r16, by7.e r17, long r18, List r20, CustomMarkdownTextView r21, String r22, SelectionRangeType r23, String r24, int r25) {
        if ((r25 & 64) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r25 & 128) == 0) goto L9;
        SelectionRangeType r11 = null;
    L11:
        if ((r25 & 256) == 0) goto L13;
        String r12 = null;
    L14:
        Intrinsics.checkNotNullParameter(r15, "clickFrom");
        Intrinsics.checkNotNullParameter(r16, "msg");
        Intrinsics.checkNotNullParameter(r20, "markdownContentList");
        IAIChatControlTraceService.a.d(IAIChatControlTraceService.a, r15, r16, r17, r18, r20, r21, r10, r11, r12, null, 512);
        return;
    L13:
        r12 = r24;
        goto L14
    L9:
        r11 = r23;
        goto L11
    L5:
        r10 = r22;
        goto L7
    }

    public static void b(String r16, String r17, long r18, String r20, Integer r21, String r22, String r23, String r24, String r25, by7.e r26, String r27, int r28) {
        if ((r28 & 8) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r28 & 16) == 0) goto L9;
        Integer r9 = null;
    L11:
        if ((r28 & 32) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r28 & 64) == 0) goto L17;
        String r11 = null;
    L19:
        if ((r28 & 128) == 0) goto L21;
        String r12 = null;
    L23:
        if ((r28 & 256) == 0) goto L25;
        String r13 = null;
    L27:
        if ((r28 & 512) == 0) goto L29;
        by7.e r14 = null;
    L31:
        if ((r28 & 1024) == 0) goto L33;
        String r15 = null;
    L34:
        Intrinsics.checkNotNullParameter(r16, "exportActionId");
        Intrinsics.checkNotNullParameter(r17, "clickFrom");
        IAIChatControlTraceService.a.Da(r16, r17, r18, r8, r9, r10, r11, r12, r13, r14, r15);
        return;
    L33:
        r15 = r27;
        goto L34
    L29:
        r14 = r26;
        goto L31
    L25:
        r13 = r25;
        goto L27
    L21:
        r12 = r24;
        goto L23
    L17:
        r11 = r23;
        goto L19
    L13:
        r10 = r22;
        goto L15
    L9:
        r9 = r21;
        goto L11
    L5:
        r8 = r20;
        goto L7
    }

    public static void m(String r35, String r36, boolean r37, String r38, boolean r39, boolean r40, boolean r41, boolean r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, Boolean r52, Boolean r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60, String r61, Long r62, String r63, String r64, String r65, int r66) {
        if ((r66 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r66 & 2) == 0) goto L9;
        String r5 = "chat";
    L11:
        if ((r66 & 8) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r66 & 256) == 0) goto L17;
        String r12 = null;
    L19:
        if ((r66 & 512) == 0) goto L21;
        String r13 = null;
    L23:
        if ((r66 & 1024) == 0) goto L25;
        String r14 = null;
    L27:
        if ((r66 & 2048) == 0) goto L29;
        String r15 = null;
    L31:
        if ((r66 & 4096) == 0) goto L33;
        String r16 = null;
    L35:
        if ((r66 & 8192) == 0) goto L37;
        String r17 = null;
    L39:
        if ((r66 & 16384) == 0) goto L41;
        String r18 = null;
    L43:
        if ((32768 & r66) == 0) goto L45;
        String r19 = null;
    L47:
        if ((65536 & r66) == 0) goto L49;
        String r20 = "-1";
    L51:
        if ((131072 & r66) == 0) goto L53;
        Boolean r21 = Boolean.FALSE;
    L55:
        if ((262144 & r66) == 0) goto L57;
        Boolean r22 = Boolean.FALSE;
    L59:
        if ((524288 & r66) == 0) goto L61;
        String r23 = null;
    L63:
        if ((1048576 & r66) == 0) goto L65;
        String r24 = null;
    L67:
        if ((2097152 & r66) == 0) goto L69;
        String r25 = null;
    L71:
        if ((4194304 & r66) == 0) goto L73;
        String r26 = null;
    L75:
        if ((8388608 & r66) == 0) goto L77;
        String r27 = null;
    L79:
        if ((16777216 & r66) == 0) goto L81;
        String r28 = null;
    L83:
        if ((33554432 & r66) == 0) goto L85;
        String r29 = null;
    L87:
        if ((67108864 & r66) == 0) goto L89;
        String r30 = null;
    L91:
        if ((134217728 & r66) == 0) goto L93;
        Long r31 = null;
    L95:
        if ((268435456 & r66) == 0) goto L97;
        String r32 = null;
    L99:
        if ((536870912 & r66) == 0) goto L101;
        String r33 = null;
    L103:
        if ((r66 & 1073741824) == 0) goto L105;
        String r34 = null;
    L106:
        Intrinsics.checkNotNullParameter(r5, "currentPage");
        IAIChatControlTraceService.a.Tb(r4, r5, r37, r7, r39, r40, r41, r42, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
        return;
    L105:
        r34 = r65;
        goto L106
    L101:
        r33 = r64;
        goto L103
    L97:
        r32 = r63;
        goto L99
    L93:
        r31 = r62;
        goto L95
    L89:
        r30 = r61;
        goto L91
    L85:
        r29 = r60;
        goto L87
    L81:
        r28 = r59;
        goto L83
    L77:
        r27 = r58;
        goto L79
    L73:
        r26 = r57;
        goto L75
    L69:
        r25 = r56;
        goto L71
    L65:
        r24 = r55;
        goto L67
    L61:
        r23 = r54;
        goto L63
    L57:
        r22 = r53;
        goto L59
    L53:
        r21 = r52;
        goto L55
    L49:
        r20 = r51;
        goto L51
    L45:
        r19 = r50;
        goto L47
    L41:
        r18 = r49;
        goto L43
    L37:
        r17 = r48;
        goto L39
    L33:
        r16 = r47;
        goto L35
    L29:
        r15 = r46;
        goto L31
    L25:
        r14 = r45;
        goto L27
    L21:
        r13 = r44;
        goto L23
    L17:
        r12 = r43;
        goto L19
    L13:
        r7 = r38;
        goto L15
    L9:
        r5 = r36;
        goto L11
    L5:
        r4 = r35;
        goto L7
    }
}
