package com.larus.bmhome.chat.component.trace;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.BotRecommendMobInfo;
import com.larus.bmhome.chat.manager.Gpt4SwitchManager;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.internal.attach.a;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import de8.c;
import ic8.n;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import ry8.b;
import tx9.e1;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x implements com.larus.bmhome.chat.component.cvs.y.a<e> {
    public final /* synthetic */ ChatTraceComponent a;

    public x(ChatTraceComponent r1) {
        this.a = r1;
    }

    public final void c(Object r27) {
        e r0 = (e) r27;
        Intrinsics.checkNotNullParameter(r0, "new");
        ChatTraceComponent r2 = this.a;
        int r3 = ChatTraceComponent.L;
        r2.getClass();
        FLogger.a.d("ChatTraceComponent ", "handleConversationChange: " + r0.a);
        r2.B3();
        boolean r4 = true;
        r2.p3(true);
        boolean r5 = com.larus.bmhome.utils.i.f(r0);
        c r6 = r2.f1();
        boolean r7 = false;
        if (r6 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == true) goto L18;
        CoroutineScope r9 = Gpt4SwitchManager.a;
        if (Gpt4SwitchManager.c() == false) goto L18;
        if (r5 == true) goto L13;
    L14:
        if (r5 == true) goto L18;
        if (z2.a.enableSubscriberMultiBotNewSkin() == false) goto L18;
    L17:
        boolean r10 = true;
    L19:
        ((ChatParam) r2.s.getValue()).f = r10;
        c r11 = r2.f1();
        by7.e r12 = null;
        if (r11 == null) goto L22;
        String r13 = r11.i();
    L24:
        if (o0.d(r13) == false) goto L30;
        ChatControlTrace r14 = ChatControlTrace.b;
        String r15 = r0.a;
        c r16 = r2.f1();
        if (r16 == null) goto L28;
        String r17 = r16.i();
    L29:
        Pair r18 = new Pair(r15, r17);
        r14.getClass();
        ChatControlTrace.E = r18;
        goto L30
    L28:
        r17 = "";
    L30:
        ChatControlTrace r19 = ChatControlTrace.b;
        r19.getClass();
        ChatControlTrace.o.put(r0.a, r0);
        com.larus.bmhome.chat.component.cvs.y r20 = r2.u0();
        if (r20 == null) goto L33;
        String r22 = r20.getBotId();
    L34:
        e r21 = r2.w;
        if (r21 == null) goto L44;
        Lazy r23 = n.a;
        Map r24 = r21.x;
        if (r24 != null) goto L39;
    L41:
        boolean r25 = false;
    L42:
        if (r25 != true) goto L44;
    L45:
        if (r4 == true) goto L47;
    L89:
        r2.w = r0;
        return;
    L47:
        if (r2.L2() == true) goto L89;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Intrinsics.areEqual(a.b(r2, r2).getActivity(), AppHost.a.a().getCurrentActivity()) == false) goto L89;
        c r26 = r2.f1();
        if (r26 == null) goto L55;
        RecommendFrom r28 = r26.d;
        if (r28 == null) goto L55;
        String r110 = r28.b;
    L56:
        c r29 = r2.f1();
        if (r29 == null) goto L61;
        RecommendFrom r30 = r29.d;
        if (r30 == null) goto L61;
        String r111 = r30.a;
    L62:
        c r31 = r2.f1();
        if (r31 == null) goto L65;
        RecommendFrom r32 = r31.d;
    L66:
        JSONObject r33 = r19.Xb(r32);
        c r34 = r2.f1();
        if (r34 == null) goto L71;
        BotRecommendMobInfo r35 = r34.m;
        if (r35 == null) goto L71;
        r35.a(r33);
    L71:
        String r36 = r19.g(r0.v, r2.N2(), r2.L2());
        Intrinsics.checkNotNullParameter(r2, "<this>");
        b r37 = s1a.a.g(a.b(r2, r2)).getAbility(b.class);
        if (r37 == null) goto L74;
        String r112 = r37.nM();
    L75:
        c r38 = r2.f1();
        if (r38 == null) goto L78;
        r7 = r38.C();
    L78:
        if (r7 == false) goto L80;
        String r39 = "1";
    L81:
        String r113 = r39;
        c r40 = r2.f1();
        if (r40 == null) goto L84;
        String r114 = r40.p();
    L85:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Fragment r41 = a.b(r2, r2);
        if ((r41 instanceof by7.e) == false) goto L88;
        r12 = (by7.e) r41;
    L88:
        e1.a(r22, r36, null, null, r112, r113, r114, null, r111, r110, null, null, null, "private", r22, r33, r12, 511545);
        goto L89
    L84:
        r114 = null;
        goto L85
    L80:
        r39 = "0";
        goto L81
    L74:
        r112 = null;
        goto L75
    L65:
        r32 = null;
    L61:
        r111 = null;
    L55:
        r110 = null;
        goto L56
    L39:
        if (r24.containsKey("is_from_local_discovery") != true) goto L41;
        r25 = true;
    L44:
        r4 = false;
        goto L45
    L33:
        r22 = null;
        goto L34
    L22:
        r13 = null;
        goto L24
    L13:
        if (z2.a.enableSubscriberMainBotNewSkin() == true) goto L17;
    L18:
        r10 = false;
        goto L19
    L5:
        if (r6.C() != true) goto L7;
        r8 = true;
        goto L8
    }
}
