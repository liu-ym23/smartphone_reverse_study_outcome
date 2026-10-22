package fi8;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.c2;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.nestedmenu.NestedMenuRightModel;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.nestedmenu.d;
import com.larus.bmhome.chat.nestedmenu.ui.q;
import com.larus.bmhome.instruction.e;
import com.larus.bmhome.instruction.g;
import com.larus.bmhome.view.actionbar.custom.CustomActionBar;
import com.larus.bmhome.view.actionbar.custom.s1;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import di8.b0;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.g0;
import ei8.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import wa8.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements c, ei8.b {
    @Override // ei8.c
    public final String getKey() {
        return "action_bar";
    }

    public a() {
    }

    public static c2 h(List r9) {
        Object r0 = null;
        if (r9 == null) goto L36;
        Iterator r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L30;
        Object r1 = r10.next();
        c2 r2 = (c2) r1;
        Integer r3 = r2.getType();
        if (r3 != null) goto L11;
    L21:
        if (r3 != null) goto L24;
    L26:
        boolean r4 = false;
    L27:
        if (r4 == false) goto L6;
        r0 = r1;
        goto L30
    L24:
        if (r3.intValue() != 5) goto L26;
    L25:
        r4 = true;
        goto L27
    L11:
        if (r3.intValue() != 6) goto L21;
        Long r5 = r2.g;
        if (r5 == null) goto L15;
        long r6 = r5.longValue();
    L17:
        if (r6 <= 0) goto L25;
        if ((AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000)) >= r6) goto L26;
    L15:
        r6 = 0;
    L30:
        return (c2) r0;
    L36:
        return null;
    }

    @Override // ei8.a
    public final LinkedHashMap<String, List<d0>> a(LinkedHashMap<String, List<d0>> r31, c0 r32) {
        Intrinsics.checkNotNullParameter(r31, "models");
        Intrinsics.checkNotNullParameter(r32, "config");
        String r4 = r32.g.h;
        Float r18 = Float.valueOf(1.0f);
        String r3 = "mode";
        boolean r21 = false;
        if (r4 == null) goto L6;
        r31.put("mode", CollectionsKt.listOf(new d[]{new d(null, new b0(r32.c.getContext().getString(2131906581), null, null, 2131103143, null, null, null, null, null, null, 32758), null, false, r18, false, null, null, false, true, true, 229), new d(null, new b0(r4, null, null, 2131103143, null, null, null, null, null, null, 32758), null, false, r18, false, null, null, false, false, false, 1765)}));
        return r31;
    L6:
        z0 r5 = r32.f;
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        List r7 = null;
        if (r6 == null) goto L11;
        r6.P();
        Fragment r8 = ChatServiceImpl.a.f();
        if (r8 == null) goto L11;
        t1a.b r9 = s1a.a.g(r8);
    L12:
        if (r9 == null) goto L14;
        g r10 = (g) r9.getAbility(g.class);
    L15:
        if (r10 == null) goto L17;
        CustomActionBar.d r11 = r10.vp();
    L18:
        di8.a r12 = com.larus.bmhome.chat.nestedmenu.a.a(r5, null);
        ObricTaskSkillDelegate.b.h(r12.a);
        if (r5 == null) goto L23;
        p0 r13 = r5.o;
        if (r13 == null) goto L23;
        boolean r14 = Intrinsics.areEqual(r13.k, Boolean.TRUE);
    L24:
        if (r14 == false) goto L32;
        List r15 = g(r32.c.getContext(), r12.a, r32.g.a, r32.a);
        if ((!((ArrayList) r15).isEmpty()) == false) goto L32;
        List<d0> r16 = r31.get("mode");
        if (r16 != null) goto L30;
        r16 = CollectionsKt.emptyList();
    L30:
        r31.put("mode", CollectionsKt.plus(r16, r15));
    L32:
        if (r32.g.a == false) goto L39;
        if (r5 == null) goto L37;
        p0 r17 = r5.o;
        if (r17 == null) goto L37;
        boolean r19 = Intrinsics.areEqual(r17.k, Boolean.TRUE);
    L38:
        if (r19 == false) goto L39;
    L81:
        if (r32.g.a == false) goto L95;
        if (r5 == null) goto L86;
        p0 r20 = r5.o;
        if (r20 == null) goto L86;
        r21 = Intrinsics.areEqual(r20.k, Boolean.TRUE);
    L86:
        if (r21 == true) goto L88;
    L90:
        r3 = "model";
    L91:
        List r1 = CollectionsKt.listOf(new d(null, new b0(r32.c.getContext().getString(2131906581), null, null, 2131103143, null, null, null, null, null, null, 32758), null, false, r18, false, null, null, false, true, true, 229));
        List<d0> r2 = r31.get(r3);
        if (r2 != null) goto L94;
        r2 = CollectionsKt.emptyList();
    L94:
        r31.put(r3, CollectionsKt.plus(r1, r2));
        goto L95
    L88:
        if ((!r12.a.isEmpty()) == false) goto L90;
    L95:
        return r31;
    L37:
        r19 = false;
    L39:
        List<b2> r22 = r12.c;
        if (r5 == null) goto L42;
        p0 r23 = r5.o;
    L43:
        if (r23 == null) goto L45;
        boolean r110 = Intrinsics.areEqual(r23.k, Boolean.TRUE);
    L46:
        if (r110 == false) goto L79;
        s0 r111 = r23.j;
        if (r111 == null) goto L50;
        boolean r112 = Intrinsics.areEqual(r111.d, Boolean.TRUE);
    L51:
        if (r112 == false) goto L79;
        s0 r24 = r23.j;
        if (r24 == null) goto L57;
        u0 r25 = r24.a;
        if (r25 == null) goto L57;
        List r26 = r25.a;
    L58:
        if (r26 != null) goto L60;
        r26 = CollectionsKt.emptyList();
    L60:
        Iterator r27 = r26.iterator();
    L62:
        if (r27.hasNext() == false) goto L70;
        Object r28 = r27.next();
        String r113 = ((t0) r28).a;
        ReplyOption r114 = r32.l;
        if (r114 == null) goto L66;
        String r115 = r114.getModeId();
    L68:
        if (Intrinsics.areEqual(r113, r115) == false) goto L62;
    L71:
        t0 r29 = (t0) r28;
        if (r29 == null) goto L76;
        a2 r30 = r29.r;
        if (r30 == null) goto L76;
        r7 = r30.a;
    L76:
        if (r7 != null) goto L78;
        r7 = CollectionsKt.emptyList();
    L78:
        f(r32, r31, r7, r5, r11);
        goto L81
    L66:
        r115 = null;
        goto L68
    L70:
        r28 = null;
    L57:
        r26 = null;
        goto L58
    L50:
        r112 = false;
    L79:
        f(r32, r31, r22, r5, r11);
        goto L81
    L45:
        r110 = false;
        goto L46
    L42:
        r23 = null;
    L23:
        r14 = false;
        goto L24
    L17:
        r11 = null;
        goto L18
    L14:
        r10 = null;
    L11:
        r9 = null;
        goto L12
    }

    @Override // ei8.b
    public final void b(LinkedHashMap<String, List<d0>> r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "models");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    @Override // ei8.b
    public final void c(List<? extends q> r5, c0 r6) {
        Intrinsics.checkNotNullParameter(r5, "nodes");
        Intrinsics.checkNotNullParameter(r6, "config");
        if (r6.a == NestedMenuScene.ACTION_BAR) goto L5;
        return;
    L5:
        z0 r7 = r6.f;
        if (r7 != null) goto L8;
        return;
    L8:
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L13;
        r0.P();
        Fragment r1 = ChatServiceImpl.a.f();
        if (r1 == null) goto L13;
        t1a.b r2 = s1a.a.g(r1);
    L14:
        if (r2 == null) goto L16;
        g r3 = (g) r2.getAbility(g.class);
    L17:
        if (r3 == null) goto L19;
        CustomActionBar.d r4 = r3.vp();
    L20:
        Iterator<T> r8 = r5.iterator();
    L22:
        if (r8.hasNext() == false) goto L40;
        q r9 = (q) r8.next();
        if ((r9 instanceof q.a) == false) goto L26;
        q.a r10 = (q.a) r9;
    L27:
        if (r10 == null) goto L22;
        f0 r11 = r10.c.c();
        if ((r11 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L32;
        com.larus.bmhome.chat.nestedmenu.b r12 = (com.larus.bmhome.chat.nestedmenu.b) r11;
    L33:
        if (r12 == null) goto L22;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r13 = r12.a;
        if (r13 == null) goto L22;
        if (r4 == null) goto L22;
        r4.c(r7, r13.a);
        goto L22
    L32:
        r12 = null;
        goto L33
    L26:
        r10 = null;
        goto L27
    L40:
        return;
    L19:
        r4 = null;
        goto L20
    L16:
        r3 = null;
    L13:
        r2 = null;
        goto L14
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
        if (r3.a == NestedMenuScene.ACTION_BAR) goto L5;
        return;
    L5:
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        CustomActionBar.d r5 = null;
        if (r4 == null) goto L10;
        r4.P();
        Fragment r6 = ChatServiceImpl.a.f();
        if (r6 == null) goto L10;
        t1a.b r7 = s1a.a.g(r6);
    L11:
        if (r7 == null) goto L13;
        g r8 = (g) r7.getAbility(g.class);
    L14:
        if (r8 == null) goto L16;
        r5 = r8.vp();
    L16:
        if (r5 == null) goto L19;
        s1.a();
        return;
    L19:
        return;
    L13:
        r8 = null;
    L10:
        r7 = null;
        goto L11
    }

    public static List g(Context r35, List r36, boolean r37, NestedMenuScene r38) {
        ArrayList r2 = new ArrayList();
        Iterator r1 = r36.iterator();
    L4:
        if (r1.hasNext() == false) goto L110;
        t0 r3 = (t0) r1.next();
        String r4 = r3.a;
        boolean r5 = false;
        if (r4 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        d r7 = null;
        if (r6 == false) goto L15;
        d r8 = null;
    L105:
        if (r8 == null) goto L108;
        r7 = r8;
    L108:
        if (r7 == null) goto L4;
        r2.add(r7);
        goto L4
    L15:
        c2 r9 = h(r3.h);
        if (r38 == null) goto L22;
        ObricTaskSkillDelegate r10 = ObricTaskSkillDelegate.b;
        String r11 = r3.a;
        if (r38 != NestedMenuScene.SETTINGS) goto L20;
        boolean r12 = true;
    L21:
        String r13 = r10.a(r11, null, "mode", r12);
    L23:
        if (r13 != null) goto L29;
        if (r9 == null) goto L28;
        r13 = r9.b;
        g1 r14 = r9.c;
        if (r14 == null) goto L29;
        String r15 = r14.b;
    L30:
        boolean r16 = h.a;
        if (h.b(r35) == false) goto L49;
        g1 r17 = r3.d;
        if (r17 == null) goto L36;
        String r18 = r17.b;
        if (r18 == null) goto L36;
    L67:
        String r19 = r18;
    L68:
        g0 r110 = new g0(null, r19, null, false, null, 61);
        String r20 = r3.b;
        if (r37 == true) goto L89;
        List<c2> r111 = r3.h;
        if (r111 == null) goto L89;
        Iterator<T> r112 = r111.iterator();
    L75:
        if (r112.hasNext() == false) goto L85;
        Object r113 = r112.next();
        Integer r114 = ((c2) r113).getType();
        if (r114 != null) goto L80;
    L82:
        boolean r115 = false;
    L83:
        if (r115 == false) goto L75;
    L86:
        c2 r116 = (c2) r113;
        if (r116 == null) goto L89;
        String r22 = r116.b;
    L90:
        if (r37 == false) goto L92;
        String r23 = null;
    L93:
        if (r37 == true) goto L97;
        if (r13 != null) goto L96;
        if (r15 == null) goto L97;
    L96:
        r5 = true;
    L97:
        Boolean r24 = Boolean.valueOf(r5);
        if (r37 == false) goto L100;
        String r25 = null;
    L101:
        if (r37 == false) goto L103;
        String r26 = null;
    L104:
        r8 = new d(r110, new b0(r20, null, null, null, r22, r23, r24, r25, r26, null, 21182), new NestedMenuRightModel(null, null, null, null, 1023), false, null, false, null, new com.larus.bmhome.chat.nestedmenu.b(null, null, new com.larus.bmhome.chat.nestedmenu.b.a(r3), 11), false, false, false, 1912);
        goto L105
    L103:
        r26 = r15;
        goto L104
    L100:
        r25 = r13;
        goto L101
    L92:
        r23 = r13;
        goto L93
    L80:
        if (r114.intValue() != 2) goto L82;
        r115 = true;
        goto L83
    L85:
        r113 = null;
    L89:
        r22 = null;
    L36:
        g1 r21 = r3.f;
        if (r21 == null) goto L39;
        r18 = r21.b;
    L40:
        if (r18 != null) goto L67;
        g1 r27 = r3.c;
        if (r27 == null) goto L44;
        r18 = r27.b;
    L45:
        if (r18 != null) goto L67;
        g1 r28 = r3.e;
        if (r28 == null) goto L66;
        r18 = r28.b;
    L66:
        r19 = null;
        goto L68
    L44:
        r18 = null;
        goto L45
    L39:
        r18 = null;
        goto L40
    L49:
        g1 r29 = r3.c;
        if (r29 == null) goto L53;
        r18 = r29.b;
        if (r18 != null) goto L67;
    L53:
        g1 r30 = r3.e;
        if (r30 == null) goto L56;
        r18 = r30.b;
    L57:
        if (r18 != null) goto L67;
        g1 r31 = r3.d;
        if (r31 == null) goto L61;
        r18 = r31.b;
    L62:
        if (r18 != null) goto L67;
        g1 r32 = r3.f;
        if (r32 == null) goto L66;
        r18 = r32.b;
        goto L67
    L61:
        r18 = null;
        goto L62
    L56:
        r18 = null;
        goto L57
    L28:
        r15 = null;
        r13 = null;
    L29:
        r15 = null;
        goto L30
    L20:
        r12 = false;
        goto L21
    L22:
        r13 = null;
        goto L23
    L8:
        if (r4.length() == 0) goto L11;
        r6 = false;
        goto L12
    L110:
        return r2;
    }

    public static void f(c0 r36, LinkedHashMap r37, List r38, z0 r39, e r40) {
        if (r38.isEmpty() == false) goto L5;
        return;
    L5:
        if (r40 == null) goto L7;
        r40.b(r39, r38);
    L7:
        ArrayList r4 = new ArrayList();
        Iterator r2 = r38.iterator();
    L9:
        if (r2.hasNext() == false) goto L93;
        b2 r5 = (b2) r2.next();
        if (r36.g.a == true) goto L20;
        if (r40 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L20;
        boolean r14 = false;
    L21:
        Context r8 = r36.c.getContext();
        boolean r10 = r36.g.a;
        NestedMenuScene r11 = r36.a;
        ModelItemIdentity r12 = r5.b();
        if (r12 != null) goto L24;
        d r13 = null;
    L89:
        if (r13 == null) goto L9;
        r4.add(r13);
        goto L9
    L24:
        c2 r15 = h(r5.j);
        ObricTaskSkillDelegate r9 = ObricTaskSkillDelegate.b;
        String r16 = r12.getKey();
        if (r11 != NestedMenuScene.SETTINGS) goto L27;
        boolean r17 = true;
    L28:
        String r6 = r9.a(null, r16, "model", r17);
        if (r6 != null) goto L38;
        if (r15 == null) goto L35;
        String r18 = r15.b;
        g1 r19 = r15.c;
        if (r19 == null) goto L39;
        String r20 = r19.b;
    L40:
        boolean r21 = h.a;
        if (h.b(r8) == false) goto L45;
        g1 r22 = r5.d;
        if (r22 == null) goto L49;
        String r23 = r22.b;
    L48:
        String r110 = r23;
    L50:
        g0 r111 = new g0(null, r110, null, false, null, 61);
        String r24 = r5.b;
        if (r10 == true) goto L72;
        List<c2> r25 = r5.j;
        if (r25 == null) goto L72;
        Iterator<T> r26 = r25.iterator();
    L57:
        if (r26.hasNext() == false) goto L68;
        Object r27 = r26.next();
        Integer r112 = ((c2) r27).getType();
        if (r112 != null) goto L62;
    L64:
        boolean r0 = false;
    L65:
        if (r0 == false) goto L57;
    L69:
        c2 r28 = (c2) r27;
        if (r28 == null) goto L72;
        String r29 = r28.b;
    L73:
        if (r10 == false) goto L75;
        String r30 = null;
    L76:
        if (r10 == true) goto L80;
        if (r18 != null) goto L79;
        if (r20 == null) goto L80;
    L79:
        boolean r31 = true;
    L81:
        Boolean r32 = Boolean.valueOf(r31);
        if (r10 == false) goto L84;
        String r33 = null;
    L85:
        if (r10 == false) goto L87;
        String r34 = null;
    L88:
        r13 = new d(r111, new b0(r24, null, null, null, r29, r30, r32, r33, r34, null, 21182), new NestedMenuRightModel(null, null, null, null, 1023), r14, null, true, null, new com.larus.bmhome.chat.nestedmenu.b(new com.larus.bmhome.chat.nestedmenu.b.C0068b(r5, r12), null, null, 14), false, false, false, 1872);
        goto L89
    L87:
        r34 = r20;
        goto L88
    L84:
        r33 = r18;
    L80:
        r31 = false;
        goto L81
    L75:
        r30 = r18;
        goto L76
    L62:
        if (r112.intValue() != 2) goto L64;
        r0 = true;
        goto L65
    L68:
        r27 = null;
    L72:
        r29 = null;
    L49:
        r110 = null;
        goto L50
    L45:
        g1 r35 = r5.c;
        if (r35 == null) goto L49;
        r23 = r35.b;
    L39:
        r20 = null;
        goto L40
    L35:
        if (r5.u == false) goto L37;
        r18 = n0.a();
        goto L39
    L37:
        r18 = null;
        goto L39
    L38:
        r18 = r6;
        goto L39
    L27:
        r17 = false;
        goto L28
    L14:
        if (r40.a(r5) == true) goto L16;
        r7 = true;
    L20:
        r14 = true;
        goto L21
    L93:
        if (r4.isEmpty() == false) goto L95;
        return;
    L95:
        List r1 = (List) r37.get("model");
        if (r1 != null) goto L98;
        r1 = CollectionsKt.emptyList();
    L98:
        r37.put("model", CollectionsKt.plus(r1, r4));
    }
}
