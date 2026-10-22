package vd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerEnterTrigger;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerTransitionType;
import com.larus.bmhome.chat.bubble.floating.ReachSpacerState;
import com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService;
import com.larus.bmhome.chat.list.cell.spacer.SpacerAnimationState;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements td8.c {
    public static final Set<String> b = null;
    public final td8.d a;

    /* JADX INFO: renamed from: vd8.a$a, reason: collision with other inner class name */
    public static final class C0088a {
    }

    static {
        b = new LinkedHashSet();
    }

    public a(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    @Override // td8.c
    public final boolean a(int r2, xc8.b r3, xc8.b r4, List<? extends xc8.b> r5) {
        Intrinsics.checkNotNullParameter(r4, "current");
        Intrinsics.checkNotNullParameter(r5, "input");
        wc9.e r6 = this.a.g();
        if (r6 == null) goto L40;
        String r7 = r6.a;
        if (r7 == null) goto L42;
        List<? extends xc8.b> r8 = r5;
        if ((r8 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L18;
        if ((((xc8.b) r9.next()) instanceof com.larus.bmhome.chat.list.cell.spacer.j) == false) goto L14;
        boolean r10 = true;
    L19:
        if (r10 == true) goto L35;
        int r11 = o.a;
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        pc8.l r12 = pc8.k.a;
        pc8.l r13 = pc8.k.a;
        if (r13 == null) goto L23;
        pc8.m r14 = r13.a(r7);
    L24:
        if (r14 == null) goto L26;
        boolean r15 = true;
    L27:
        if (r15 == true) goto L35;
        h.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        int r16 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        IBubbleBannerRuntimeService r17 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r17 != null) goto L31;
    L33:
        boolean r18 = false;
    L34:
        if (r18 == true) goto L35;
        return false;
    L31:
        if (r17.c(r7) != true) goto L33;
        r18 = true;
        goto L34
    L26:
        r15 = false;
        goto L27
    L23:
        r14 = null;
    L35:
        return true;
    L18:
        r10 = false;
        goto L19
    L10:
        if (r8.isEmpty() == false) goto L12;
    L42:
        return false;
    L40:
        return false;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r25, xc8.b r26, xc8.b r27, List<xc8.b> r28) {
        Intrinsics.checkNotNullParameter(r27, "current");
        Intrinsics.checkNotNullParameter(r28, "input");
        wc9.e r3 = this.a.g();
        if (r3 == null) goto L451;
        String r4 = r3.a;
        if (r4 == null) goto L451;
        ArrayList r5 = new ArrayList();
        Iterator<T> r1 = r28.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        Object r6 = r1.next();
        if ((((xc8.b) r6) instanceof com.larus.bmhome.chat.list.cell.spacer.j) == true) goto L9;
        r5.add(r6);
        goto L9
    L13:
        List<xc8.b> r2 = CollectionsKt.toMutableList(r5);
        int r7 = o.a;
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        pc8.l r8 = pc8.k.a;
        pc8.l r9 = pc8.k.a;
        if (r9 == null) goto L16;
        pc8.m r10 = r9.a(r4);
    L18:
        if (r10 == null) goto L20;
        boolean r11 = true;
    L22:
        if (r11 == false) goto L146;
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r2, "input");
        pc8.l r12 = pc8.k.a;
        if (r12 == null) goto L268;
        pc8.m r13 = r12.a(r4);
        if (r13 == null) goto L268;
        Message r14 = c.c(r2);
        ReachSpacerState r15 = r13.h;
        ReachSpacerState r16 = ReachSpacerState.WAITING;
        if (r15 == r16) goto L35;
        if (r13.d == false) goto L268;
    L35:
        if (StringsKt.isBlank(r13.c) == false) goto L37;
    L40:
        boolean r17 = true;
    L41:
        if (r17 == false) goto L45;
        if (r14 == null) goto L44;
        String r18 = c.d(r14);
    L46:
        if (r18 == null) goto L48;
        Message r20 = c.a(r2, r18);
    L49:
        if (r20 == null) goto L51;
        if (r14 == null) goto L58;
        Set r19 = c.j(r14);
    L59:
        if (r19 != null) goto L62;
        r19 = SetsKt.emptySet();
    L62:
        if (r13.h != r16) goto L64;
    L98:
        Set r21 = c.j(r20);
        boolean r22 = c.f(r2, r21);
        boolean r23 = c.b(r2, r21);
        int r24 = r13.g;
        if (r24 == 1) goto L103;
        if (r24 == 3) goto L102;
        boolean r29 = false;
    L104:
        if (r29 == false) goto L112;
        r12.c(r13.a);
        if (r13.h == ReachSpacerState.WAITING) goto L268;
        r13 = r12.a(r4);
        if (r13 == null) goto L268;
    L112:
        if (r13.h != ReachSpacerState.WAITING) goto L122;
        int r30 = r13.f;
        if (r30 == 1) goto L117;
        if (r30 == 3) goto L118;
        r22 = true;
    L118:
        if (r22 == false) goto L268;
        r12.h(r13.a, r18);
        goto L122
    L117:
        r22 = r23;
    L122:
        if (r13.h != ReachSpacerState.ENTERING) goto L124;
        r12.d(r13.a);
    L124:
        String r31 = r13.a;
        int r32 = r13.e;
        int r33 = o.b.a[r13.h.ordinal()];
        if (r33 == 1) goto L134;
        if (r33 == 2) goto L133;
        if (r33 == 3) goto L133;
        if (r33 != 4) goto L132;
        SpacerAnimationState r34 = SpacerAnimationState.COLLAPSE;
    L135:
        SpacerAnimationState r210 = r34;
        Long r35 = Long.valueOf(r13.i);
        if (r35.longValue() <= 0) goto L138;
        boolean r36 = true;
    L139:
        if (r36 == true) goto L142;
        r35 = null;
    L142:
        if (r35 == null) goto L144;
        long r110 = r35.longValue();
        com.larus.bmhome.chat.list.cell.spacer.a r211 = new com.larus.bmhome.chat.list.cell.spacer.a(r13.h.name() + '_' + r13.a + '_' + r110, r110, r13.j);
    L145:
        p r37 = new p(r31, r32, r20, r210, r211, o.a.a);
    L269:
        r2 = r2;
    L416:
        if (r37 != null) goto L418;
        return r2;
    L418:
        xc8.b r0 = (xc8.b) CollectionsKt.firstOrNull(r2);
        if (r0 == null) goto L421;
        Message r38 = r0.getMessage();
    L422:
        if (r38 == null) goto L426;
        boolean r39 = true;
        if (com.larus.bmhome.chat.bean.d.O0(r38) != true) goto L427;
        boolean r40 = true;
    L428:
        if (r40 == true) goto L436;
        if (r38 != null) goto L431;
    L433:
        boolean r41 = false;
    L434:
        if (r41 == true) goto L436;
        boolean r111 = true;
    L438:
        if (r37.d == SpacerAnimationState.EXPAND) goto L440;
    L442:
        boolean r112 = false;
    L443:
        String r42 = r37.a;
        int r43 = r37.b;
        wc9.e r44 = this.a.g();
        if (r44 == null) goto L446;
        String r45 = r44.a;
    L447:
        if (r45 != null) goto L449;
        r45 = "";
    L449:
        com.larus.bmhome.chat.list.cell.spacer.j r46 = new com.larus.bmhome.chat.list.cell.spacer.j(r42, r43, r45, r37.c, r37.d, r112, r37.e, r111, new b(r37));
        List<xc8.b> r47 = r2;
        ListProtector.add(r47, 0, r46);
        return r47;
    L446:
        r45 = null;
        goto L447
    L440:
        if (b.contains(r37.a) == false) goto L442;
        r112 = true;
        goto L443
    L431:
        if (com.larus.bmhome.chat.bean.d.E0(r38) != r39) goto L433;
        r41 = true;
    L436:
        r111 = false;
    L427:
        r40 = false;
        goto L428
    L426:
        r39 = true;
        goto L427
    L421:
        r38 = null;
        goto L422
    L144:
        r211 = null;
        goto L145
    L138:
        r36 = false;
        goto L139
    L132:
        throw new NoWhenBranchMatchedException();
    L133:
        r34 = SpacerAnimationState.EXPAND;
        goto L135
    L134:
        r34 = SpacerAnimationState.WAITING;
        goto L135
    L102:
        r29 = r22;
        goto L104
    L103:
        r29 = r23;
        goto L104
    L64:
        if ((!r19.isEmpty()) == false) goto L98;
        if (r19.contains(r18) == true) goto L98;
        Iterator<xc8.b> r113 = r2.iterator();
        int r114 = 0;
    L69:
        if (r113.hasNext() == false) goto L74;
        if (c.i(r113.next().getMessage(), r18) == true) goto L75;
        r114 = r114 + 1;
    L75:
        Iterator<xc8.b> r48 = r2.iterator();
        int r115 = 0;
    L77:
        if (r48.hasNext() == false) goto L93;
        xc8.b r116 = r48.next();
        Set r117 = r19;
        if ((r117 instanceof Collection) == true) goto L81;
    L83:
        Iterator r49 = r117.iterator();
    L85:
        if (r49.hasNext() == false) goto L89;
        if (c.i(r116.getMessage(), (String) r49.next()) == false) goto L85;
        boolean r50 = true;
    L90:
        if (r50 == true) goto L91;
        r115 = r115 + 1;
        goto L77
    L91:
        int r118 = r115;
    L94:
        if (r114 < 0) goto L98;
        if (r118 < 0) goto L98;
        if (r118 >= r114) goto L98;
        r12.b(r13.a);
    L89:
        r50 = false;
        goto L90
    L81:
        if (r117.isEmpty() == false) goto L83;
    L93:
        r118 = -1;
        goto L94
    L74:
        r114 = -1;
        goto L75
    L58:
        r19 = null;
        goto L59
    L51:
        if (r13.h != r16) goto L268;
        if (r17 == false) goto L55;
        if (r14 != null) goto L55;
        r12.g(r13.a);
    L55:
        r12.b(r13.a);
        goto L268
    L48:
        r20 = null;
        goto L49
    L44:
        r18 = null;
        goto L46
    L45:
        r18 = r13.c;
        goto L46
    L37:
        if (Intrinsics.areEqual(r13.c, "-1") == true) goto L40;
        r17 = false;
    L268:
        r37 = null;
        goto L269
    L146:
        h.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r2, "input");
        Message r51 = c.c(r2);
        int r52 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        IBubbleBannerRuntimeService r53 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r53 == null) goto L149;
        pc8.e r54 = r53.q(r4);
    L150:
        if (r54 == null) goto L212;
        if (r51 == null) goto L154;
        Set r55 = c.j(r51);
    L155:
        if (r55 != null) goto L158;
        r55 = SetsKt.emptySet();
    L158:
        if (r55.isEmpty() == true) goto L212;
        BubbleBannerState r56 = r54.c;
        if (r56 == BubbleBannerState.EXITING) goto L212;
        pc8.f r57 = r54.d;
        if (r57 == null) goto L165;
        String r58 = r57.a;
    L166:
        if (r58 == null) goto L168;
    L174:
        boolean r59 = false;
    L175:
        if (r59 == false) goto L178;
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r54.a, BubbleBannerDismissReason.NEW_MESSAGE);
        goto L212
    L178:
        if (r55.contains(r54.b()) == true) goto L212;
        Iterator<xc8.b> r60 = r2.iterator();
        int r61 = 0;
    L182:
        if (r60.hasNext() == false) goto L187;
        if (c.i(r60.next().getMessage(), r54.b()) == true) goto L188;
        r61 = r61 + 1;
    L188:
        Iterator<xc8.b> r62 = r2.iterator();
        int r119 = 0;
    L190:
        if (r62.hasNext() == false) goto L207;
        xc8.b r120 = r62.next();
        Set r121 = r55;
        if ((r121 instanceof Collection) == true) goto L194;
    L196:
        Iterator r122 = r121.iterator();
    L198:
        if (r122.hasNext() == false) goto L203;
        if (c.i(r120.getMessage(), (String) r122.next()) == false) goto L198;
        boolean r123 = true;
    L204:
        if (r123 == true) goto L208;
        r119 = r119 + 1;
    L208:
        if (r61 < 0) goto L212;
        if (r119 < 0) goto L212;
        if (r119 >= r61) goto L212;
        int r63 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r54.a, BubbleBannerDismissReason.NEW_MESSAGE);
    L203:
        r123 = false;
        goto L204
    L194:
        if (r121.isEmpty() == false) goto L196;
    L207:
        r119 = -1;
        goto L208
    L187:
        r61 = -1;
        goto L188
    L168:
        if (r56 != BubbleBannerState.RESOLVED) goto L170;
    L173:
        r59 = true;
        goto L175
    L170:
        if (r56 == BubbleBannerState.ENTERING) goto L173;
        if (r56 != BubbleBannerState.VISIBLE) goto L174;
    L165:
        r58 = null;
        goto L166
    L154:
        r55 = null;
    L212:
        if (r54 == null) goto L232;
        if (r51 == null) goto L216;
        Set r64 = c.j(r51);
    L217:
        if (r64 != null) goto L220;
        r64 = SetsKt.emptySet();
    L220:
        if (r64.isEmpty() == true) goto L232;
        if (c.b(r2, r64) == false) goto L232;
        if (r54.c == BubbleBannerState.EXITING) goto L232;
        if (r54.b.f.b != 1) goto L232;
        if (r64.contains(r54.b()) == false) goto L232;
        int r65 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r54.a, BubbleBannerDismissReason.NEW_MESSAGE);
        goto L232
    L216:
        r64 = null;
    L232:
        if (r54 == null) goto L263;
        if (r51 == null) goto L236;
        Set r66 = c.j(r51);
    L237:
        if (r66 != null) goto L240;
        r66 = SetsKt.emptySet();
    L240:
        if (r66.isEmpty() == true) goto L263;
        List<xc8.b> r67 = r2;
        if ((r67 instanceof Collection) == true) goto L245;
    L247:
        Iterator<T> r68 = r67.iterator();
    L249:
        if (r68.hasNext() == false) goto L253;
        if (c.h(((xc8.b) r68.next()).getMessage(), r66) == false) goto L249;
        boolean r69 = true;
    L254:
        if (r69 == false) goto L263;
        if (r54.c == BubbleBannerState.EXITING) goto L263;
        if (r54.b.f.b != 3) goto L263;
        if (r66.contains(r54.b()) == false) goto L263;
        int r70 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r54.a, BubbleBannerDismissReason.NEW_MESSAGE);
    L253:
        r69 = false;
        goto L254
    L245:
        if (r67.isEmpty() == false) goto L247;
    L236:
        r66 = null;
    L263:
        int r71 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        IBubbleBannerRuntimeService r72 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r72 == null) goto L266;
        pc8.e r73 = r72.q(r4);
    L267:
        if (r73 == null) goto L268;
        BubbleBannerState r74 = r73.c;
        BubbleBannerState r75 = BubbleBannerState.ENTERING;
        if (r74 != r75) goto L273;
    L278:
        boolean r76 = true;
    L279:
        Intrinsics.checkNotNullParameter(r73, "<this>");
        pc8.f r77 = r73.d;
        if (r77 != null) goto L282;
        boolean r78 = true;
    L283:
        if (r78 == false) goto L286;
        if (r51 == null) goto L288;
        String r79 = c.d(r51);
    L289:
        if (r79 == null) goto L291;
        p r80 = null;
        Message r124 = c.a(r2, r79);
        if (r124 != null) goto L320;
        if (r73.c != BubbleBannerState.EXITING) goto L310;
        Intrinsics.checkNotNullParameter(r73, "<this>");
        pc8.f r81 = r73.d;
        if (r81 == null) goto L306;
        Set<BubbleBannerRenderPart> r82 = r81.c;
        if (r82 == null) goto L306;
        if (r82.contains(BubbleBannerRenderPart.SPACER) != true) goto L306;
        boolean r83 = true;
    L307:
        if (r83 == false) goto L310;
        h.a(r73);
    L383:
        r2 = r2;
        r37 = r80;
    L306:
        r83 = false;
    L310:
        if (pc8.g.a(r73.b) == null) goto L312;
        boolean r84 = true;
    L313:
        if (r84 == false) goto L383;
        BubbleBannerState r85 = r73.c;
        if (r85 == r75) goto L383;
        if (r85 == BubbleBannerState.VISIBLE) goto L383;
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r73.a, BubbleBannerDismissReason.NEW_MESSAGE);
        goto L383
    L312:
        r84 = false;
        goto L313
    L320:
        if (r73.c == BubbleBannerState.EXITING) goto L361;
        Set r86 = c.j(r124);
        if (r86.isEmpty() == false) goto L324;
    L360:
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r73.a, BubbleBannerDismissReason.NEW_MESSAGE);
        goto L383
    L324:
        if (r86.contains(r79) == false) goto L360;
        if (r76 == true) goto L356;
        int r87 = r73.b.f.a;
        if (r87 == 1) goto L332;
        if (r87 != 3) goto L352;
        boolean r88 = c.f(r2, c.j(r124));
    L354:
        if (r88 == true) goto L356;
        int r89 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        com.larus.bmhome.chat.bubble.floating.runtime.k.d(r73.a, r79);
    L352:
        r88 = true;
        goto L354
    L332:
        Set r90 = c.j(r124);
        Iterator<T> r91 = r2.iterator();
    L334:
        if (r91.hasNext() == false) goto L345;
        Object r125 = r91.next();
        Message r126 = ((xc8.b) r125).getMessage();
        if (c.g(r126) == false) goto L338;
    L342:
        boolean r127 = false;
    L343:
        if (r127 == false) goto L334;
    L346:
        xc8.b r128 = (xc8.b) r125;
        if (r128 == null) goto L353;
        Message r92 = r128.getMessage();
        if (r92 == null) goto L353;
        if (c.e(r92) == true) goto L352;
    L353:
        r88 = false;
        goto L354
    L338:
        if (com.larus.bmhome.chat.bean.d.G0(r126) == true) goto L342;
        if (CollectionsKt.contains(r90, r126.getReplyId()) == false) goto L342;
        r127 = true;
        goto L343
    L345:
        r125 = null;
    L356:
        if (r76 == true) goto L361;
        int r93 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        com.larus.bmhome.chat.bubble.floating.runtime.k.d(r73.a, r79);
        String r94 = r73.a;
        BubbleBannerEnterTrigger r95 = BubbleBannerEnterTrigger.SPACER_READY;
        Intrinsics.checkNotNullParameter(r94, "promptId");
        Intrinsics.checkNotNullParameter(r95, "trigger");
        IBubbleBannerRuntimeService r96 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r96 == null) goto L361;
        r96.d(r94, r95);
    L361:
        int r97 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        pc8.e r99 = com.larus.bmhome.chat.bubble.floating.runtime.k.b(r73.a);
        if (r99 == null) goto L365;
        r73 = r99;
    L365:
        BubbleBannerState r100 = r73.c;
        if (r100 != BubbleBannerState.ENTERING) goto L368;
    L371:
        String r101 = r73.a;
        Intrinsics.checkNotNullParameter(r101, "promptId");
        IBubbleBannerRuntimeService r102 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r102 == null) goto L374;
        r102.n(r101);
    L374:
        Intrinsics.checkNotNullParameter(r73, "<this>");
        pc8.f r103 = r73.d;
        if (r103 == null) goto L381;
        Set<BubbleBannerRenderPart> r104 = r103.c;
        if (r104 == null) goto L381;
        if (r104.contains(BubbleBannerRenderPart.SPACER) != true) goto L381;
        boolean r105 = true;
    L382:
        if (r105 == false) goto L383;
        String r129 = r73.a;
        int r130 = c7.b(92);
        pc8.i r106 = r73.j;
        if (r106 == null) goto L387;
        BubbleBannerTransitionType r107 = r106.getType();
    L388:
        if (r107 != null) goto L390;
        int r108 = -1;
    L392:
        if (r108 == (-1)) goto L400;
        if (r108 != 1) goto L395;
        SpacerAnimationState r109 = SpacerAnimationState.EXPAND;
    L411:
        pc8.i r131 = r73.j;
        if (r131 != null) goto L414;
        com.larus.bmhome.chat.list.cell.spacer.a r132 = null;
    L415:
        r37 = new p(r129, r130, r124, r109, r132, h.a.a);
        goto L416
    L414:
        r132 = new com.larus.bmhome.chat.list.cell.spacer.a(r131.a, r131.c, r131.d);
        goto L415
    L395:
        if (r108 != 2) goto L398;
        r109 = SpacerAnimationState.COLLAPSE;
        goto L411
    L398:
        throw new NoWhenBranchMatchedException();
    L400:
        int r133 = h.b.a[r73.c.ordinal()];
        if (r133 != 1) goto L403;
        r109 = SpacerAnimationState.WAITING;
        goto L411
    L403:
        if (r133 == 2) goto L409;
        if (r133 == 3) goto L409;
        if (r133 == 4) goto L408;
        r109 = SpacerAnimationState.NONE;
        goto L411
    L408:
        r109 = SpacerAnimationState.COLLAPSE;
    L409:
        r109 = SpacerAnimationState.EXPAND;
        goto L411
    L390:
        r108 = h.b.b[r107.ordinal()];
        goto L392
    L387:
        r107 = null;
    L381:
        r105 = false;
        goto L382
    L368:
        if (r100 == BubbleBannerState.VISIBLE) goto L371;
        if (r100 != BubbleBannerState.EXITING) goto L374;
    L291:
        if (r73.c == BubbleBannerState.EXITING) goto L294;
        if (r76 == true) goto L294;
        r80 = null;
        com.larus.bmhome.chat.bubble.floating.runtime.k.d(r73.a, null);
    L294:
        r80 = null;
    L288:
        r79 = null;
        goto L289
    L286:
        if (r77 == null) goto L288;
        r79 = r77.a;
        goto L289
    L282:
        r78 = false;
        goto L283
    L273:
        if (r74 == BubbleBannerState.VISIBLE) goto L278;
        if (r74 == BubbleBannerState.EXITING) goto L278;
        r76 = false;
        goto L279
    L266:
        r73 = null;
        goto L267
    L149:
        r54 = null;
        goto L150
    L20:
        r11 = false;
        goto L22
    L16:
        r10 = null;
    L451:
        return r28;
    }
}
