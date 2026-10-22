package com.larus.reach.runtime;

import com.larus.common.apphost.AppHost;
import com.larus.reach.api.ReachButtonStyle;
import com.larus.reach.api.ReachButtonType;
import com.larus.reach.api.ReachPageScope;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRequestSource;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.reach.api.ReachType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r {
    public static final void a(w r25) {
        q.a.getClass();
        Integer r1 = r25.a;
        if (r1 == null) goto L215;
        int r2 = r1.intValue();
        ns9.m r3 = r25.b;
        if (r3 != null) goto L7;
        FLogger.a.w("ReachDataHandler", "reach parse failed, cmd_type=" + r2 + ", reason=reach_notify_missing");
        return;
    L7:
        ReachRequestSource r10 = r25.c;
        if (r3.b() == null) goto L15;
        Integer r0 = r3.b();
        int r4 = AppHost.a.getAppId();
        if (r0 != null) goto L13;
    L14:
        FLogger.a.w("ReachDataHandler", "reach parse ignored, cmd_type=" + r2 + ", reason=app_id_mismatch");
        return;
    L13:
        if (r0.intValue() != r4) goto L14;
    L15:
        String r5 = r3.o();
        if (r5 != null) goto L18;
    L20:
        String r6 = null;
    L21:
        String r7 = q.b(r3.getType());
        if (Intrinsics.areEqual(r7, "banner") == false) goto L25;
        ReachType r8 = ReachType.BANNER;
    L27:
        ReachType r9 = r8;
    L29:
        if (r9 != null) goto L32;
        q.c(r3, r2, r10, "unsupported_type");
    L205:
        ns9.t r11 = null;
    L206:
        if (r11 == null) goto L225;
        x.a.getClass();
        ns9.u r12 = x.b(r11, null);
        if ((r12 instanceof ns9.u.a) == false) goto L211;
        return;
    L211:
        if ((r12 instanceof ns9.u.b) == false) goto L214;
        ConcurrentHashMap<String, Long> r13 = com.larus.reach.impl.b.a;
        ns9.u.b r14 = (ns9.u.b) r12;
        com.larus.reach.impl.b.d(r11, r14.b);
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r15 = y.a;
        y.c(r11, r14.b);
        return;
    L214:
        throw new NoWhenBranchMatchedException();
    L225:
        return;
    L32:
        if (r9 != ReachType.TOAST) goto L60;
        String r16 = r3.p();
        if (r16 != null) goto L36;
        String r17 = "";
    L37:
        String r18 = r3.r();
        if (r18 != null) goto L40;
    L42:
        String r19 = null;
    L43:
        String r20 = r3.j();
        if (r20 == null) goto L52;
        String r21 = StringsKt.trim(r20).toString();
        if (r21 == null) goto L52;
        String r22 = r21.toLowerCase(Locale.ROOT);
        if (r22 == null) goto L52;
        if ((!StringsKt.isBlank(r22)) == false) goto L52;
        String r23 = r22;
    L53:
        ns9.l r110 = new ns9.l(r6, r9, r17, r19, r23, r10, null, 64);
        ns9.s r24 = new ns9.s(0, r3.f(), null, 5);
        String r26 = r3.s();
        if (r26 != null) goto L56;
    L58:
        String r27 = null;
    L59:
        r11 = new ns9.t(r110, null, r24, new ns9.f(r27, null, null, null, null, 61), 18);
        goto L206
    L56:
        if ((!StringsKt.isBlank(r26)) == false) goto L58;
        r27 = r26;
    L52:
        r23 = null;
        goto L53
    L40:
        if ((!StringsKt.isBlank(r18)) == false) goto L42;
        r19 = r18;
        goto L43
    L36:
        r17 = r16;
        goto L37
    L60:
        Integer r28 = r3.n();
        if (r28 == null) goto L63;
        int r29 = r28.intValue();
    L64:
        String r30 = q.b(r3.m());
        if (Intrinsics.areEqual(r30, "top") == false) goto L68;
        ReachPosition r31 = ReachPosition.TOP;
    L70:
        ReachPosition r111 = r31;
    L72:
        if (r111 != null) goto L74;
        q.c(r3, r2, r10, "unsupported_position");
        goto L205
    L74:
        ns9.q r32 = r3.q();
        if (r32 == null) goto L77;
        String r33 = r32.c();
    L78:
        String r34 = q.b(r33);
        if (Intrinsics.areEqual(r34, "global") == false) goto L82;
        ReachPageScope r35 = ReachPageScope.Global;
    L84:
        ReachPageScope r112 = r35;
    L86:
        if (r112 != null) goto L88;
        q.c(r3, r2, r10, "unsupported_reach_page");
        goto L205
    L88:
        Integer r36 = r3.i();
        if (r36 != null) goto L92;
    L93:
        if (r36 != null) goto L96;
    L98:
        r36 = null;
    L99:
        if (r36 == null) goto L204;
        int r37 = r36.intValue();
        LinkedHashMap r113 = new LinkedHashMap();
        r113.putAll(q.a(r3.l()));
        String r38 = r3.p();
        if (r38 != null) goto L103;
        r38 = "";
    L103:
        String r39 = r3.r();
        if (r39 != null) goto L106;
    L108:
        String r40 = null;
    L109:
        ns9.l r210 = new ns9.l(r6, r9, r38, r40, null, r10, r3.k(), 16);
        ns9.q r41 = r3.q();
        int r42 = q.a.a[r112.ordinal()];
        if (r42 == 1) goto L143;
        if (r42 != 2) goto L142;
        if (r41 == null) goto L114;
        Map<String, String> r43 = r41.d();
    L115:
        Map r114 = q.a(r43);
        if (r41 == null) goto L118;
        String r44 = r41.e();
    L119:
        String r45 = q.b(r44);
        String r46 = "keep";
        if (Intrinsics.areEqual(r45, "keep") == true) goto L123;
        r46 = "discard";
        Intrinsics.areEqual(r45, "discard");
    L123:
        String r115 = r46;
        long r47 = 0;
        if (r41 == null) goto L136;
        Long r48 = r41.b();
        if (r48 == null) goto L136;
        if (r48.longValue() <= 0) goto L130;
        boolean r49 = true;
    L131:
        if (r49 == true) goto L134;
        r48 = null;
    L134:
        if (r48 == null) goto L136;
        r47 = r48.longValue();
        goto L136
    L130:
        r49 = false;
    L136:
        long r116 = r47;
        if (r41 == null) goto L139;
        Map<String, String> r50 = r41.a();
    L140:
        ns9.v r51 = new ns9.w(r111, r114, r115, r116, q.a(r50));
    L144:
        ns9.v r211 = r51;
        Long r52 = r3.f();
        String r53 = r3.e();
        if (r53 != null) goto L147;
    L149:
        r53 = null;
    L150:
        ns9.s r54 = new ns9.s(r29, r52, r53);
        Integer r55 = Integer.valueOf(r37);
        String r56 = r3.s();
        if (r56 != null) goto L153;
    L155:
        String r57 = null;
    L156:
        String r58 = r3.h();
        if (r58 != null) goto L159;
    L161:
        String r117 = null;
    L162:
        String r59 = r3.d();
        if (r59 != null) goto L165;
    L167:
        String r118 = null;
    L168:
        List r119 = q.d(r3.a());
        List<ns9.o> r60 = r3.c();
        if (r60 == null) goto L199;
        ArrayList r61 = new ArrayList();
        Iterator<T> r62 = r60.iterator();
    L172:
        if (r62.hasNext() == false) goto L200;
        ns9.o r63 = (ns9.o) r62.next();
        if (r63 == null) goto L196;
        q r64 = q.a;
        String r65 = r63.getType();
        r64.getClass();
        String r66 = q.b(r65);
        if (Intrinsics.areEqual(r66, "normal") == false) goto L180;
        ReachButtonType r67 = ReachButtonType.NORMAL;
    L182:
        String r68 = q.b(r63.b());
        if (Intrinsics.areEqual(r68, "primary") == false) goto L186;
        ReachButtonStyle r69 = ReachButtonStyle.PRIMARY;
    L189:
        String r120 = r63.c();
        if (r120 != null) goto L192;
    L194:
        r120 = null;
    L195:
        ns9.d r121 = new ns9.d(r67, r69, r120, q.d(r63.a()));
    L197:
        if (r121 == null) goto L172;
        r61.add(r121);
        goto L172
    L192:
        if ((!StringsKt.isBlank(r120)) == false) goto L194;
    L186:
        if (Intrinsics.areEqual(r68, "plain") == false) goto L188;
        r69 = ReachButtonStyle.PLAIN;
        goto L189
    L188:
        r69 = null;
        goto L189
    L180:
        if (Intrinsics.areEqual(r66, "close") == false) goto L196;
        r67 = ReachButtonType.CLOSE;
    L196:
        r121 = null;
    L200:
        if (r61 != null) goto L202;
        List r122 = CollectionsKt.emptyList();
    L203:
        r11 = new ns9.t(r210, r211, r54, new ns9.f(r55, r57, r117, r118, r119, r122), new ns9.r(r113, q.a(r3.g())));
        goto L206
    L202:
        r122 = r61;
        goto L203
    L199:
        r61 = null;
        goto L200
    L165:
        if ((!StringsKt.isBlank(r59)) == false) goto L167;
        r118 = r59;
        goto L168
    L159:
        if ((!StringsKt.isBlank(r58)) == false) goto L161;
        r117 = r58;
        goto L162
    L153:
        if ((!StringsKt.isBlank(r56)) == false) goto L155;
        r57 = r56;
        goto L156
    L147:
        if ((!StringsKt.isBlank(r53)) == false) goto L149;
    L139:
        r50 = null;
        goto L140
    L118:
        r44 = null;
        goto L119
    L114:
        r43 = null;
        goto L115
    L142:
        throw new NoWhenBranchMatchedException();
    L143:
        r51 = new ns9.a(r111);
        goto L144
    L106:
        if ((!StringsKt.isBlank(r39)) == false) goto L108;
        r40 = r39;
        goto L109
    L204:
        q.c(r3, r2, r10, "unsupported_layout");
        goto L205
    L96:
        if (r36.intValue() != 2) goto L98;
    L92:
        if (r36.intValue() == 1) goto L99;
    L82:
        if (Intrinsics.areEqual(r34, "target") == false) goto L85;
        r35 = ReachPageScope.TargetPage;
        goto L84
    L85:
        r112 = null;
        goto L86
    L77:
        r33 = null;
        goto L78
    L68:
        if (Intrinsics.areEqual(r30, "bottom") == false) goto L71;
        r31 = ReachPosition.BOTTOM;
        goto L70
    L71:
        r111 = null;
        goto L72
    L63:
        r29 = 0;
        goto L64
    L25:
        if (Intrinsics.areEqual(r7, "toast") == false) goto L28;
        r8 = ReachType.TOAST;
        goto L27
    L28:
        r9 = null;
        goto L29
    L18:
        if ((!StringsKt.isBlank(r5)) == false) goto L20;
        r6 = r5;
        goto L21
    }
}
