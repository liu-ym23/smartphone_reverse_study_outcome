package com.larus.bmhome.chat.nestedmenu.provider.officetask;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.o1;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.nestedmenu.ui.q;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.p0;
import ic8.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements ei8.c, ei8.b {
    @Override // ei8.c
    public final String getKey() {
        return "office_filter_task";
    }

    public static t1a.b i() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L7;
        r0.P();
        Fragment r1 = ChatServiceImpl.a.f();
        if (r1 == null) goto L7;
        return s1a.a.g(r1);
    L7:
        return null;
    }

    public a() {
    }

    public static List h(List r5) {
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L32;
        d0 r1 = (d0) r6.next();
        f0 r2 = r1.c();
        if ((r2 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L8;
        com.larus.bmhome.chat.nestedmenu.b r3 = (com.larus.bmhome.chat.nestedmenu.b) r2;
    L9:
        if (r3 == null) goto L14;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r4 = r3.a;
        if (r4 == null) goto L14;
        b2 r7 = r4.a;
        if (r7 == null) goto L14;
    L19:
        if (r7 == null) goto L30;
        Integer r8 = r7.l;
        int r9 = AgentMode.MOA.getValue();
        if (r8 != null) goto L24;
    L26:
        boolean r10 = false;
    L27:
        if (r10 == true) goto L30;
        r1 = null;
        goto L30
    L24:
        if (r8.intValue() != r9) goto L26;
        r10 = true;
    L30:
        if (r1 == null) goto L4;
        r0.add(r1);
    L14:
        if (r3 == null) goto L18;
        com.larus.bmhome.chat.nestedmenu.b.c r11 = r3.b;
        if (r11 == null) goto L18;
        r7 = r11.a;
    L18:
        r7 = null;
        goto L19
    L8:
        r3 = null;
        goto L9
    L32:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static Set j(d0 r2) {
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        if (r2 == null) goto L5;
        f0 r3 = r2.c();
    L7:
        if ((r3 instanceof p0) == false) goto L12;
        f0 r4 = ((p0) r3).a;
        if ((r4 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L14;
        com.larus.bmhome.chat.nestedmenu.b r5 = (com.larus.bmhome.chat.nestedmenu.b) r4;
    L15:
        if (r5 == null) goto L26;
        com.larus.bmhome.chat.nestedmenu.b.a r6 = r5.c;
        if (r6 == null) goto L26;
        t0 r7 = r6.a;
        if (r7 == null) goto L26;
        List<o1> r8 = r7.n;
        if (r8 == null) goto L26;
        r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L24:
        if (r9.hasNext() == false) goto L26;
        r0.add(((o1) r9.next()).a());
    L26:
        if (r0 != 0) goto L29;
        r0 = CollectionsKt.emptyList();
    L29:
        return CollectionsKt.toSet((Iterable) r0);
    L14:
        r5 = null;
        goto L15
    L12:
        if ((r3 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L14;
        r5 = (com.larus.bmhome.chat.nestedmenu.b) r3;
        goto L15
    L5:
        r3 = null;
        goto L7
    }

    public static List f(List r5, String r6) {
        if (r6 == null) goto L26;
        if ((!StringsKt.isBlank(r6)) == true) goto L7;
        r6 = null;
    L7:
        if (r6 == null) goto L26;
        ArrayList r0 = new ArrayList();
        Iterator r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L24;
        Object r2 = r7.next();
        f0 r3 = ((d0) r2).c();
        if ((r3 instanceof p0) == false) goto L15;
        p0 r4 = (p0) r3;
    L16:
        if (r4 == null) goto L20;
        PcDevice r8 = r4.c;
        if (r8 == null) goto L20;
        String r9 = r8.getDeviceId();
    L22:
        if (Intrinsics.areEqual(r9, r6) == false) goto L11;
        r0.add(r2);
    L20:
        r9 = null;
        goto L22
    L15:
        r4 = null;
        goto L16
    L24:
        return r0;
    L26:
        return CollectionsKt.emptyList();
    }

    public static List g(List r5, Set r6) {
        ArrayList r0 = new ArrayList();
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L24;
        d0 r1 = (d0) r7.next();
        f0 r2 = r1.c();
        if ((r2 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L8;
        com.larus.bmhome.chat.nestedmenu.b r3 = (com.larus.bmhome.chat.nestedmenu.b) r2;
    L9:
        if (r3 == null) goto L14;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r4 = r3.a;
        if (r4 == null) goto L14;
        ModelItemIdentity r8 = r4.b;
        if (r8 == null) goto L14;
    L20:
        if (CollectionsKt.contains(r6, r8) == true) goto L22;
        r1 = null;
    L22:
        if (r1 == null) goto L4;
        r0.add(r1);
    L14:
        if (r3 == null) goto L18;
        com.larus.bmhome.chat.nestedmenu.b.c r9 = r3.b;
        if (r9 == null) goto L18;
        r8 = r9.b;
    L18:
        r8 = null;
        goto L20
    L8:
        r3 = null;
        goto L9
    L24:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v34, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v40, types: [java.util.ArrayList] */
    @Override // ei8.a
    public final LinkedHashMap<String, List<d0>> a(LinkedHashMap<String, List<d0>> r10, c0 r11) {
        Intrinsics.checkNotNullParameter(r10, "models");
        Intrinsics.checkNotNullParameter(r11, "config");
        if (r11.a != NestedMenuScene.SETTINGS) goto L5;
        return r10;
    L5:
        t1a.b r0 = i();
        boolean r1 = true;
        boolean r2 = false;
        if (r0 == null) goto L12;
        be8.a r3 = r0.getAbility(be8.a.class);
        if (r3 == null) goto L12;
        if (r3.YD() != true) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L15;
        return r10;
    L15:
        t1a.b r5 = i();
        String r6 = null;
        if (r5 == null) goto L20;
        y r7 = r5.getAbility(y.class);
        if (r7 == null) goto L20;
        e r8 = r7.h();
    L22:
        if (n.t(r8) == false) goto L83;
        List<d0> r9 = r10.get("mode");
        if (r9 != null) goto L27;
        r9 = CollectionsKt.emptyList();
    L27:
        if (Intrinsics.areEqual(qa9.a.a().a(), "1") == true) goto L36;
        t1a.b r12 = i();
        if (r12 == null) goto L34;
        be8.a r13 = r12.getAbility(be8.a.class);
        if (r13 == null) goto L34;
        String r14 = r13.dC();
    L35:
        r9 = f(r9, r14);
    L34:
        r14 = null;
    L36:
        z0 r15 = r11.f;
        if (r15 == null) goto L41;
        com.larus.bmhome.actionbar.model.p0 r16 = r15.o;
        if (r16 == null) goto L41;
        boolean r17 = Intrinsics.areEqual(r16.k, Boolean.TRUE);
    L42:
        if (r17 == false) goto L79;
        k(r10, "mode", r9);
        List<d0> r18 = r10.get("mode");
        if (r18 != null) goto L47;
        r18 = CollectionsKt.emptyList();
    L47:
        if (Intrinsics.areEqual(qa9.a.a().a(), "1") == false) goto L70;
        ?? r19 = new ArrayList();
        Iterator r110 = r18.iterator();
    L50:
        if (r110.hasNext() == false) goto L76;
        Object r20 = r110.next();
        f0 r21 = ((d0) r20).c();
        if ((r21 instanceof p0) == false) goto L54;
        p0 r22 = (p0) r21;
    L55:
        if (r22 == null) goto L57;
        PcDevice r23 = r22.c;
    L58:
        if (r23 != null) goto L67;
        if (r22 != null) goto L61;
    L63:
        boolean r24 = false;
    L64:
        if (r24 == true) goto L67;
        boolean r25 = false;
    L68:
        if (r25 == false) goto L50;
        r19.add(r20);
        goto L50
    L61:
        if (r22.b != true) goto L63;
        r24 = true;
    L67:
        r25 = true;
        goto L68
    L57:
        r23 = null;
        goto L58
    L54:
        r22 = null;
    L76:
        Set r111 = j((d0) CollectionsKt.firstOrNull(r19));
        List<d0> r26 = r10.get("model");
        if (r26 == null) goto L82;
        k(r10, "model", g(r26, r111));
    L82:
        return r10;
    L70:
        t1a.b r27 = i();
        if (r27 == null) goto L75;
        be8.a r28 = r27.getAbility(be8.a.class);
        if (r28 == null) goto L75;
        r6 = r28.dC();
    L75:
        r19 = f(r18, r6);
        goto L76
    L79:
        List<d0> r112 = r10.get("model");
        if (r112 == null) goto L82;
        k(r10, "model", h(r112));
    L41:
        r17 = false;
        goto L42
    L83:
        t1a.b r29 = i();
        if (r29 == null) goto L88;
        y r30 = r29.getAbility(y.class);
        if (r30 == null) goto L88;
        e r31 = r30.h();
    L89:
        bs8.a.a r32 = bs8.a.h;
        if (r31 == null) goto L92;
        r6 = r31.r;
    L92:
        r32.getClass();
        bs8.a r33 = bs8.a.a.a(r6);
        if (r33 != null) goto L95;
    L97:
        r1 = false;
    L98:
        if (r1 == false) goto L118;
        List<d0> r34 = r10.get("mode");
        if (r34 != null) goto L102;
        r34 = CollectionsKt.emptyList();
    L102:
        k(r10, "mode", r34);
        z0 r113 = r11.f;
        if (r113 == null) goto L107;
        com.larus.bmhome.actionbar.model.p0 r114 = r113.o;
        if (r114 == null) goto L107;
        r2 = Intrinsics.areEqual(r114.k, Boolean.TRUE);
    L107:
        if (r2 == false) goto L115;
        ArrayList r115 = new ArrayList();
        Iterator r35 = r34.iterator();
    L110:
        if (r35.hasNext() == false) goto L112;
        CollectionsKt.addAll(r115, j((d0) r35.next()));
        goto L110
    L112:
        Set r116 = CollectionsKt.toSet(r115);
        List<d0> r36 = r10.get("model");
        if (r36 == null) goto L118;
        k(r10, "model", g(r36, r116));
        goto L118
    L115:
        List<d0> r117 = r10.get("model");
        if (r117 == null) goto L118;
        k(r10, "model", h(r117));
    L118:
        return r10;
    L95:
        if (r33.b() != true) goto L97;
    L88:
        r31 = null;
    L20:
        r8 = null;
    L12:
        r4 = false;
        goto L13
    }

    @Override // ei8.b
    public final void b(LinkedHashMap<String, List<d0>> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "models");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    @Override // ei8.b
    public final void c(List<? extends q> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    @Override // ei8.b
    public final void d(LinkedHashMap<String, List<d0>> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "models");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    @Override // ei8.b
    public final void e(LinkedHashMap<String, List<d0>> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "models");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    public static void k(LinkedHashMap r1, String r2, List r3) {
        if (r3.isEmpty() == false) goto L5;
        r1.remove(r2);
        return;
    L5:
        r1.put(r2, r3);
    }
}
