package com.larus.bmhome.chat.list.trace;

import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.larus.bmhome.chat.api.a0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockMetaInfo;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.l1;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements a0 {
    public static final c a = null;
    public static final boolean b = false;
    public static final Regex c = null;

    public c() {
    }

    static {
        a = new c();
        b = z2.a.enableTrackerOptimize();
        c = new Regex("\\[(.*?)]\\((.*?)\\)");
    }

    public static Pair b(String r4) {
        String r3 = null;
        MatchResult r5 = Regex.find$default(c, r4, 0, 2, null);
        if (r5 == null) goto L7;
        List r0 = r5.getGroupValues();
        if (r0 == null) goto L7;
        String r1 = (String) CollectionsKt.getOrNull(r0, 1);
    L8:
        if (r5 == null) goto L13;
        List r6 = r5.getGroupValues();
        if (r6 == null) goto L13;
        r3 = (String) CollectionsKt.getOrNull(r6, 2);
    L13:
        return TuplesKt.to(r1, r3);
    L7:
        r1 = null;
        goto L8
    }

    public static List c(Block r5) {
        List r6 = r5.getMetaInfo();
        if (r6 == null) goto L44;
        ArrayList r1 = new ArrayList();
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L13;
        Object r2 = r7.next();
        boolean r4 = true;
        if (((BlockMetaInfo) r2).type == 1) goto L11;
        r4 = false;
    L11:
        if (r4 == false) goto L6;
        r1.add(r2);
        goto L6
    L13:
        ArrayList r8 = new ArrayList();
        Iterator r3 = r1.iterator();
    L15:
        if (r3.hasNext() == false) goto L31;
        BlockMetaInfo r9 = (BlockMetaInfo) r3.next();
        Gson r10 = HttpExtKt.f;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L22
        String r12 = r9.getRealInfo();     // Catch: Throwable -> L22
        if (r12 != null) goto L20;
        r12 = "{}";
    L20:
        Object r13 = Result.constructor-impl((IMMetaInfo.f) r10.fromJson(r12, IMMetaInfo.f.class));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r13) == false) goto L27;
        r13 = null;
    L27:
        IMMetaInfo.f r14 = (IMMetaInfo.f) r13;
        if (r14 == null) goto L15;
        r8.add(r14);
    L22:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L31:
        return r8;
    L44:
        return null;
    }

    public static void d(Message r40) {
        int r1 = r40.getContentType();
        if (r1 != 1) goto L5;
    L7:
        String r10 = "1";
        String r11 = "0";
        String r13 = "link_type";
        String r14 = "";
        if (com.larus.im.bean.message.a.b0(r40) == false) goto L99;
        Intrinsics.checkNotNullParameter(r40, "<this>");     // Catch: Throwable -> L43
        Iterator r2 = r.a(r40).iterator();     // Catch: Throwable -> L43
    L10:
        if (r2.hasNext() == false) goto L113;
        List r6 = c((Block) r2.next());     // Catch: Throwable -> L43
        if (r6 == null) goto L10;
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L43
        int r3 = 0;
    L16:
        if (r7.hasNext() == false) goto L10;
        Object r18 = r7.next();     // Catch: Throwable -> L43
        int r19 = r3 + 1;     // Catch: Throwable -> L43
        if (r3 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L43
    L20:
        IMMetaInfo.f r110 = (IMMetaInfo.f) r18;     // Catch: Throwable -> L43
        String r20 = r110.d();     // Catch: Throwable -> L43
        if (r20 != null) goto L23;
        r20 = "";
    L23:
        Pair r21 = b(r20);     // Catch: Throwable -> L43
        String r27 = (String) r21.getFirst();     // Catch: Throwable -> L43
        String r4 = (String) r21.getSecond();     // Catch: Throwable -> L43
        Set<String> r5 = a.a;     // Catch: Throwable -> L43
        String r8 = a.c(r4).optString("link_type");     // Catch: Throwable -> L43
        ChatControlTrace r9 = ChatControlTrace.b;     // Catch: Throwable -> L43
        Iterator r22 = r2;
        JSONObject r12 = r9.Ua(r40, r9.Gb(r4, null));     // Catch: Throwable -> L43
        if (r12 != null) goto L26;
        r12 = new JSONObject();     // Catch: Throwable -> L43
    L26:
        JSONObject r15 = r9.Ta(r110.c());     // Catch: Throwable -> L43
        String r23 = r40.getSenderId();     // Catch: Throwable -> L43
        String r24 = r40.getConversationId();     // Catch: Throwable -> L43
        String r25 = r40.getMessageId();     // Catch: Throwable -> L43
        String r38 = r10;
        String r39 = r11;
        long r16 = ((long) r3) + 1;     // Catch: Throwable -> L43
        String r34 = r110.a();     // Catch: Throwable -> L43
        String r28 = r110.g();     // Catch: Throwable -> L43
        String r17 = r110.h();     // Catch: Throwable -> L43
        if (r17 != null) goto L29;
    L33:
        r17 = r9.Za(r40);     // Catch: Throwable -> L43
        if (r17 != null) goto L36;
        String r29 = r8;
    L37:
        String r30 = r9.pb(r15);     // Catch: Throwable -> L43
        String r31 = r9.Ya(r15);     // Catch: Throwable -> L43
        String r32 = r9.tb(r40);     // Catch: Throwable -> L43
        if (d.z0(r40) == false) goto L40;
        String r26 = r38;
    L41:
        r12.put("is_onboarding", r26);     // Catch: Throwable -> L43
        r12.put("agent_tool", r12.optString("fpa_agent_tool"));     // Catch: Throwable -> L43
        l1.a(r23, r24, "chat", r25, Long.valueOf(r16), r27, r28, r29, r30, r31, r32, r4, r34, r12, 16384);     // Catch: Throwable -> L43
        r3 = r19;
        r2 = r22;
        r10 = r38;
        r11 = r39;
        goto L16
    L40:
        r26 = r39;
    L36:
        r29 = r17;
        goto L37
    L29:
        if ((!StringsKt.isBlank(r17)) == true) goto L32;
        r17 = null;
    L32:
        if (r17 != null) goto L36;
    L113:
        return;
    L43:
        th = move-exception;
        FLogger.a.d("MessageCellTrace", "err when mobHighlightWordShow! msg=" + th.getMessage());
        return;
    L99:
        FLogger r33 = FLogger.a;     // Catch: Throwable -> L96
        StringBuilder r35 = new StringBuilder("in text holder createTime >>> ");     // Catch: Throwable -> L96
        r35.append(r40.getCreateTime());     // Catch: Throwable -> L96
        r35.append(", messageId >>> ");     // Catch: Throwable -> L96
        r35.append(r40.getMessageId());     // Catch: Throwable -> L96
        r35.append(", conversationId >>> ");     // Catch: Throwable -> L96
        r35.append(r40.getConversationId());     // Catch: Throwable -> L96
        r35.append(", content >>> ");     // Catch: Throwable -> L96
        Regex r36 = d.a;     // Catch: Throwable -> L96
        Intrinsics.checkNotNullParameter(r40, "<this>");     // Catch: Throwable -> L96
        Intrinsics.checkNotNullParameter(r40, "<this>");     // Catch: Throwable -> L96
        TextContent r37 = r.b(r40);     // Catch: Throwable -> L96
        if (r37 == null) goto L51;
        String r41 = r37.text;     // Catch: Throwable -> L96
    L52:
        r35.append(g2a.d.b(r41));     // Catch: Throwable -> L96
        r33.d("TextBindSourceTest", r35.toString());     // Catch: Throwable -> L96
        Iterator r42 = d.c1(r40).iterator();     // Catch: Throwable -> L96
        int r43 = 0;
    L53:
        if (r42.hasNext() == false) goto L112;
        Object r44 = r42.next();     // Catch: Throwable -> L96
        int r45 = r43 + 1;     // Catch: Throwable -> L96
        if (r43 >= 0) goto L58;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L96
    L58:
        IMMetaInfo.f r46 = (IMMetaInfo.f) r44;     // Catch: Throwable -> L96
        if (r46 == null) goto L61;
        String r47 = r46.d();     // Catch: Throwable -> L96
    L62:
        if (r47 != null) goto L64;
        r47 = r14;
    L64:
        Pair r48 = b(r47);     // Catch: Throwable -> L96
        String r210 = (String) r48.getFirst();     // Catch: Throwable -> L96
        String r49 = (String) r48.getSecond();     // Catch: Throwable -> L96
        Set<String> r50 = a.a;     // Catch: Throwable -> L96
        String r51 = a.c(r49).optString(r13);     // Catch: Throwable -> L96
        ChatControlTrace r111 = ChatControlTrace.b;     // Catch: Throwable -> L96
        Iterator r112 = r42;
        String r113 = null;
        JSONObject r52 = r111.Ua(r40, r111.Gb(r49, null));     // Catch: Throwable -> L96
        if (r52 != null) goto L67;
        r52 = new JSONObject();     // Catch: Throwable -> L96
    L67:
        if (r46 == null) goto L69;
        r113 = r46.c();     // Catch: Throwable -> L96
    L69:
        JSONObject r114 = r111.Ta(r113);     // Catch: Throwable -> L96
        String r211 = r40.getSenderId();     // Catch: Throwable -> L96
        String r212 = r40.getConversationId();     // Catch: Throwable -> L96
        String r213 = r40.getMessageId();     // Catch: Throwable -> L96
        String r115 = r13;
        String r116 = r14;
        long r117 = ((long) r43) + 1;     // Catch: Throwable -> L96
        if (r46 == null) goto L72;
        String r310 = r46.a();     // Catch: Throwable -> L96
    L73:
        if (r46 == null) goto L75;
        String r214 = r46.g();     // Catch: Throwable -> L96
    L76:
        if (r46 == null) goto L86;
        String r53 = r46.h();     // Catch: Throwable -> L96
        if (r53 == null) goto L86;
        if ((!StringsKt.isBlank(r53)) == true) goto L83;
        r53 = null;
    L83:
        if (r53 == null) goto L86;
    L89:
        String r215 = r53;
    L90:
        String r216 = r111.pb(r114);     // Catch: Throwable -> L96
        String r311 = r111.Ya(r114);     // Catch: Throwable -> L96
        String r312 = r111.tb(r40);     // Catch: Throwable -> L96
        if (d.z0(r40) == false) goto L93;
        Object r54 = "1";
    L94:
        r52.put("is_onboarding", r54);     // Catch: Throwable -> L96
        r52.put("agent_tool", r52.optString("fpa_agent_tool"));     // Catch: Throwable -> L96
        l1.a(r211, r212, "chat", r213, Long.valueOf(r117), r210, r214, r215, r216, r311, r312, r49, r310, r52, 16384);     // Catch: Throwable -> L96
        r43 = r45;
        r42 = r112;
        r13 = r115;
        r14 = r116;
        goto L53
    L93:
        r54 = "0";
    L86:
        r53 = r111.Za(r40);     // Catch: Throwable -> L96
        if (r53 != null) goto L89;
        r215 = r51;
        goto L90
    L75:
        r214 = null;
        goto L76
    L72:
        r310 = null;
        goto L73
    L61:
        r47 = null;
        goto L62
    L112:
        return;
    L51:
        r41 = null;
    L96:
        th = move-exception;
        FLogger.a.d("MessageCellTrace", "err when mobHighlightWordShow! msg=" + th.getMessage());
        return;
    L5:
        if (r1 == 9999) goto L7;
    }

    @Override // com.larus.bmhome.chat.api.a0
    public final void a(final Message r4, final Fragment r5, q0 r6) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (r4.getMessageStatusLocal() == 21) goto L5;
        return;
    L5:
        if (d.Q0(r4) == true) goto L10;
        Set<String> r0 = a.a;
        a.e(HighlightWordShowScene.LINK_META_INFO, r6, r4.getMessageId(), null, new b(r5, r4));
        return;
    }
}
