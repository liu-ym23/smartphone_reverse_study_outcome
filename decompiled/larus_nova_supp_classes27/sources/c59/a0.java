package c59;

import com.larus.dora.impl.dynamic.dsl.DslNodeType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a0 {
    static {
    }

    public static l a(z r7) {
        Intrinsics.checkNotNullParameter(r7, "rootNode");
        l r0 = new l(0);
        List<z> r2 = r7.c();
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        g49.d.b("DSLPageParser", "parseDeviceListPage: rootNode.nodes is null or empty");
        return r0;
    L13:
        Iterator<z> r8 = r7.c().iterator();
    L15:
        if (r8.hasNext() == false) goto L34;
        z r4 = r8.next();
        if (r4 == null) goto L15;
        if (r4.b() == DslNodeType.NAV_BAR) goto L20;
        if (r4.b() == DslNodeType.LAYER) goto L23;
        g49.d.b("DSLPageParser", "parseDeviceManagementPage: unrecognized node type " + r4.b());
        goto L15
    L23:
        List<z> r5 = r4.c();
        if (r5 == null) goto L26;
        z r6 = (z) CollectionsKt.getOrNull(r5, 0);
    L27:
        if (r6 == null) goto L28;
        if (r6.b() != DslNodeType.CARD) goto L31;
        r0.b.add(new i(r6.d(), r6.a()));
        goto L15
    L31:
        g49.d.b("DSLPageParser", "parseDeviceListPage: unrecognized node type " + r6.b());
        goto L15
    L28:
        g49.d.b("DSLPageParser", "parseDeviceListPage: cardNode is null");
        goto L15
    L26:
        r6 = null;
        goto L27
    L20:
        r0.a = c(r4);
        goto L15
    L34:
        return r0;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L10
    }

    public static m b(z r16) {
        Intrinsics.checkNotNullParameter(r16, "rootNode");
        m r0 = new m();
        List<z> r2 = r16.c();
        int r4 = 0;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        g49.d.b("DSLPageParser", "parseDeviceManagementPage: rootNode.nodes is null or empty");
        return r0;
    L13:
        Iterator<z> r1 = r16.c().iterator();
    L15:
        if (r1.hasNext() == false) goto L126;
        z r5 = r1.next();
        if (r5 == null) goto L125;
        if (r5.b() != DslNodeType.NAV_BAR) goto L22;
        r0.a = c(r5);
        goto L125
    L22:
        if (r5.b() != DslNodeType.SUBPAGES) goto L124;
        Intrinsics.checkNotNullParameter(r5, "subpagesNode");
        List<z> r6 = r5.c();
        if (r6 != null) goto L26;
    L29:
        boolean r7 = true;
    L30:
        ArrayList r8 = null;
        if (r7 == false) goto L33;
        g49.d.b("DSLPageParser", "parseDeviceManagementSubpages: subpagesNode.nodes is null or empty");
    L122:
        if (r8 == null) goto L125;
        ((ArrayList) r0.b).addAll(r8);
        goto L125
    L33:
        ArrayList r9 = new ArrayList();
        Iterator<z> r10 = r5.c().iterator();
    L35:
        if (r10.hasNext() == false) goto L121;
        z r11 = r10.next();
        if (r11 == null) goto L120;
        if (r11.b() == DslNodeType.SUBPAGE) goto L41;
        g49.d.b("DSLPageParser", "parseDeviceManagementSubpages: unrecognized node type " + r11.b());
        goto L120
    L41:
        Intrinsics.checkNotNullParameter(r11, "subPageNode");
        List<z> r12 = r11.c();
        if (r12 != null) goto L44;
    L47:
        boolean r13 = true;
    L48:
        if (r13 == false) goto L50;
        g49.d.b("DSLPageParser", "parseSubPageInfo: subPageNode.nodes is null or empty");
        n r14 = null;
    L118:
        if (r14 == null) goto L120;
        r9.add(r14);
        goto L120
    L50:
        r14 = new n(null);
        Iterator<z> r15 = r11.c().iterator();
    L52:
        if (r15.hasNext() == false) goto L118;
        z r17 = r15.next();
        if (r17 == null) goto L55;
        if (r17.b() == DslNodeType.LAYER) goto L62;
        if (r17.b() == DslNodeType.TABS) goto L62;
        g49.d.b("DSLPageParser", "parseSubPageInfo: unrecognized node type " + r17.b());
    L62:
        if (r17.b() != DslNodeType.TABS) goto L63;
        Intrinsics.checkNotNullParameter(r17, "tabsNode");
        ArrayList r18 = new ArrayList();
        List<z> r110 = r17.c();
        if (r110 != null) goto L76;
    L79:
        boolean r111 = true;
    L80:
        if (r111 == false) goto L82;
        g49.d.b("DSLPageParser", "parseTabInfo: tabsNode.nodes is null or empty");
    L117:
        r14.b.addAll(r18);
        r4 = 0;
        goto L52
    L82:
        Iterator<z> r112 = r17.c().iterator();
    L84:
        if (r112.hasNext() == false) goto L117;
        z r113 = r112.next();
        if (r113 == null) goto L87;
        if (r113.b() != DslNodeType.TAB) goto L90;
        e0 r114 = new e0(r113.a());
        List<z> r115 = r113.c();
        if (r115 != null) goto L94;
    L97:
        boolean r116 = true;
    L98:
        if (r116 == true) goto L99;
        Iterator<z> r117 = r113.c().iterator();
    L102:
        if (r117.hasNext() == false) goto L116;
        z r118 = r117.next();
        if (r118 == null) goto L115;
        List<z> r119 = r118.c();
        if (r119 == null) goto L108;
        z r120 = (z) CollectionsKt.getOrNull(r119, r4);
    L109:
        if (r120 != null) goto L112;
        g49.d.b("DSLPageParser", "parseTabInfo: tabInnerNode is null");
        goto L115
    L112:
        if (r120.b() == DslNodeType.CARD) goto L114;
        g49.d.b("DSLPageParser", "parseTabInfo: tabInnerNode is not card");
        goto L115
    L114:
        ((ArrayList) r114.b).add(new i(r120.d(), r120.a()));
        goto L115
    L108:
        r120 = null;
    L115:
        r4 = 0;
        goto L102
    L116:
        r18.add(r114);
        r4 = 0;
        goto L84
    L99:
        g49.d.b("DSLPageParser", "parseTabInfo: tabNode.nodes is null or empty");
        r18.add(r114);
        goto L84
    L94:
        if (r115.isEmpty() == true) goto L97;
        r116 = false;
        goto L98
    L90:
        g49.d.b("DSLPageParser", "parseTabInfo: unrecognized node type " + r113.b());
        goto L84
    L87:
        g49.d.b("DSLPageParser", "parseTabInfo: tabNode is null");
        goto L84
    L76:
        if (r110.isEmpty() == true) goto L79;
        r111 = false;
        goto L80
    L63:
        List<z> r121 = r17.c();
        if (r121 == null) goto L66;
        z r122 = (z) CollectionsKt.getOrNull(r121, r4);
    L67:
        if (r122 == null) goto L68;
        if (r122.b() != DslNodeType.CARD) goto L71;
        r14.a.add(new i(r122.d(), r122.a()));
        goto L52
    L71:
        g49.d.b("DSLPageParser", "parseSubPageInfo: subpage innerNode is not card");
        goto L52
    L68:
        g49.d.b("DSLPageParser", "parseSubPageInfo: subpage innerNode is null");
        goto L52
    L66:
        r122 = null;
        goto L67
    L55:
        g49.d.b("DSLPageParser", "parseSubPageInfo: childNode is null");
        goto L52
    L44:
        if (r12.isEmpty() == true) goto L47;
        r13 = false;
    L120:
        r4 = 0;
        goto L35
    L121:
        r8 = r9;
        goto L122
    L26:
        if (r6.isEmpty() == true) goto L29;
        r7 = false;
        goto L30
    L124:
        g49.d.b("DSLPageParser", "parseDeviceManagementPage: unrecognized node type " + r5.b());
    L125:
        r4 = 0;
        goto L15
    L126:
        return r0;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L10
    }

    public static v c(z r1) {
        Intrinsics.checkNotNullParameter(r1, "navBarNode");
        return new v(r1.a());
    }

    public static c0 d(z r9) {
        Intrinsics.checkNotNullParameter(r9, "rootNode");
        r9.getClass();
        c0 r0 = new c0();
        List<z> r1 = r9.c();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        g49.d.b("DSLPageParser", "parseSimplePage: rootNode.nodes is null or empty");
        return r0;
    L13:
        Iterator<z> r10 = r9.c().iterator();
        boolean r3 = false;
    L15:
        if (r10.hasNext() == false) goto L36;
        z r5 = r10.next();
        if (r5 == null) goto L15;
        if (r5.b() == DslNodeType.NAV_BAR) goto L20;
        if (r5.b() == DslNodeType.LAYER) goto L23;
        g49.d.b("DSLPageParser", "parseSimplePage: unrecognized node type " + r5.b());
        goto L15
    L23:
        if (r3 == true) goto L24;
        List<z> r6 = r5.c();
        if (r6 == null) goto L28;
        z r7 = (z) CollectionsKt.getOrNull(r6, 0);
    L29:
        if (r7 == null) goto L30;
        if (r7.b() != DslNodeType.CARD) goto L33;
        r0.a = new i(r7.d(), r7.a());
        r3 = true;
        goto L15
    L33:
        g49.d.b("DSLPageParser", "parseSimplePage: unrecognized node type " + r7.b());
        goto L15
    L30:
        g49.d.b("DSLPageParser", "parseSimplePage: cardNode is null");
        goto L15
    L28:
        r7 = null;
        goto L29
    L24:
        g49.d.b("DSLPageParser", "parseSimplePage: more than one card");
        goto L15
    L20:
        c(r5);
        goto L15
    L36:
        return r0;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L10
    }
}
