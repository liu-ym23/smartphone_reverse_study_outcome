package com.larus.bmhome.chat.component.trace;

import android.os.Bundle;
import androidx.collection.LruCache;
import androidx.lifecycle.LifecycleOwnerKt;
import ce8.a;
import com.google.gson.Gson;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.BotRecommendMobInfo;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.manager.PromptCacheManager;
import com.larus.bmhome.chat.mode.b;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.conversation.IconImage;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import ic8.n;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import s1a.d;
import tx9.e1;
import ve8.c;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ ChatTraceComponent a;

    public w(ChatTraceComponent r1) {
        this.a = r1;
    }

    public final void c(Object r54) {
        BotModel r0 = (BotModel) r54;
        Intrinsics.checkNotNullParameter(r0, "new");
        ChatTraceComponent r2 = this.a;
        int r3 = ChatTraceComponent.L;
        e r4 = r2.P2();
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("handleBotChange: ");
        r6.append(r0.getBotId());
        r6.append(", ");
        if (r4 == null) goto L5;
        String r8 = r4.a;
    L6:
        r6.append(r8);
        r5.d("ChatTraceComponent ", r6.toString());
        if (r4 == null) goto L9;
        BotInfoCache.INSTANCE.put(r4.a, r0);
    L9:
        if (r4 == null) goto L14;
        String r7 = r4.a;
        ChatControlTrace.b.getClass();
        LruCache r9 = ChatControlTrace.o;
        e r10 = (e) r9.get(r7);
        if (r10 == null) goto L14;
        boolean r20 = c.c(r0);
        String r11 = r10.a;
        IconImage r13 = r10.b;
        String r14 = r10.c;
        Long r15 = r10.d;
        Integer r12 = r10.e;
        Integer r16 = r10.f;
        ConversationPage r17 = r10.g;
        List r18 = r10.h;
        Integer r19 = r10.j;
        Integer r21 = r10.k;
        Integer r22 = r10.l;
        Integer r23 = r10.m;
        String r24 = r10.n;
        Long r25 = r10.o;
        Long r26 = r10.p;
        Long r27 = r10.q;
        String r28 = r10.r;
        String r29 = r10.s;
        Integer r30 = r10.t;
        long r1 = r10.u;
        Integer r31 = r10.v;
        Long r32 = r10.w;
        Map r33 = r10.x;
        Map r34 = r10.y;
        String r35 = r10.z;
        Boolean r36 = r10.A;
        String r37 = r10.B;
        Integer r38 = r10.C;
        Integer r39 = r10.D;
        Integer r40 = r10.E;
        int r41 = r10.F;
        int r42 = r10.G;
        String r43 = r10.H;
        String r44 = r10.I;
        String r45 = r10.J;
        long r46 = r10.K;
        long r47 = r10.L;
        Intrinsics.checkNotNullParameter(r11, "conversationId");
        e r48 = (e) r9.put(r7, new e(r11, r13, r14, r15, r12, r16, r17, r18, r20, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r1, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47));
    L14:
        StringBuilder r49 = new StringBuilder("update info ");
        r49.append(r0.getBotId());
        r49.append(", ");
        if (r4 == null) goto L17;
        String r50 = r4.a;
    L18:
        r49.append(r50);
        r5.d("ChatTraceComponent ", r49.toString());
        if (z2.a.showNewTopicMainBotEnable() == true) goto L21;
    L26:
        ChatControlTrace r51 = ChatControlTrace.b;
        if (r4 == null) goto L29;
        Integer r52 = r4.v;
    L30:
        String r53 = r51.g(r52, r0.getBotType(), a.a(r0));
        de8.c r55 = r2.f1();
        if (r55 == null) goto L38;
        Bundle r56 = r55.b;
        if (r56 == null) goto L35;
        boolean r57 = r56.getBoolean("is_from_ug", false);
    L36:
        if (r57 != true) goto L38;
        boolean r58 = true;
    L40:
        if (r58 == false) goto L60;
        de8.c r59 = r2.f1();
        if (r59 == null) goto L44;
        RecommendFrom r60 = r59.d;
    L45:
        JSONObject r61 = r51.Xb(r60);
        de8.c r62 = r2.f1();
        if (r62 == null) goto L50;
        BotRecommendMobInfo r63 = r62.m;
        if (r63 == null) goto L50;
        r63.a(r61);
    L50:
        String r64 = r0.getBotId();
        String r210 = r0.getBotId();
        de8.c r65 = r2.f1();
        if (r65 == null) goto L53;
        String r66 = r65.p();
    L54:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        by7.e r110 = com.larus.ui.arch.component.internal.attach.a.b(r2, r2);
        if ((r110 instanceof by7.e) == false) goto L57;
        by7.e r211 = r110;
    L58:
        e1.a(r64, r53, null, null, "ug_landing", null, r66, null, null, null, null, null, null, "private", r210, r61, r211, 523961);
        goto L60
    L57:
        r211 = null;
        goto L58
    L53:
        r66 = null;
        goto L54
    L44:
        r60 = null;
    L60:
        ChatParam r67 = (ChatParam) r2.s.getValue();
        if (r4 == null) goto L63;
        String r68 = r4.a;
    L64:
        r67.a = r68;
        r67.b = r0.getBotId();
        r67.e = r53;
        r2.B3();
        String r69 = r0.getBotId();
        if (r69 != null) goto L67;
        String r70 = "";
    L69:
        if (r2.v == false) goto L71;
        return;
    L71:
        if (r2.X2() == true) goto L106;
        de8.c r71 = r2.f1();
        if (r71 == null) goto L77;
        boolean r72 = true;
        if (r71.z() != true) goto L78;
        boolean r111 = true;
    L80:
        if ((!r111) == false) goto L107;
        r2.v = r72;
        com.larus.bmhome.chat.mode.e r73 = d.a(r2).getAbility(com.larus.bmhome.chat.mode.e.class);
        com.larus.bmhome.chat.component.cvs.y r74 = r2.u0();
        if (r74 == null) goto L84;
        e r75 = r74.h();
    L86:
        if (n.r(r75) == false) goto L99;
        com.larus.bmhome.chat.component.cvs.y r76 = r2.u0();
        if (r76 == null) goto L90;
        e r77 = r76.h();
    L92:
        if (n.v(r77) == true) goto L99;
        if (b.a() == null) goto L99;
        if (r73 == null) goto L99;
        if (r73.Si().getValue() != null) goto L99;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(r2, r2)), null, null, new ChatTraceComponent$reportChatEnter$1(r2, r70, r73, null), 3, null);
        return;
    L90:
        r77 = null;
    L99:
        de8.c r78 = r2.f1();
        if (r78 == null) goto L102;
        boolean r79 = r78.B();
    L103:
        z$a.a(r2, r70, null, null, null, r79, false, 94);
        return;
    L102:
        r79 = false;
        goto L103
    L84:
        r75 = null;
        goto L86
    L107:
        return;
    L78:
        r111 = false;
        goto L80
    L77:
        r72 = true;
        goto L78
    L106:
        return;
    L67:
        r70 = r69;
        goto L69
    L63:
        r68 = null;
        goto L64
    L35:
        r57 = false;
    L38:
        r58 = false;
        goto L40
    L29:
        r52 = null;
        goto L30
    L21:
        if (com.larus.bmhome.utils.i.f(r4) == false) goto L26;
        Gson r80 = PromptCacheManager.a;
        String r81 = r0.getBotId();
        if (r81 != null) goto L25;
        r81 = "";
    L25:
        PromptCacheManager.b(r81);
        goto L26
    L17:
        r50 = null;
        goto L18
    L5:
        r8 = null;
        goto L6
    }
}
