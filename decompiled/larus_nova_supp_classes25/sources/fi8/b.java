package fi8;

import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u1;
import com.larus.bmhome.actionbar.model.v1;
import com.larus.bmhome.actionbar.model.w1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.nestedmenu.NestedMenuRightModel;
import com.larus.bmhome.chat.nestedmenu.d;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import di8.b0;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.g0;
import di8.n0;
import di8.p0;
import ei8.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements c {
    public final String a;

    public b() {
        this.a = "menu_selected";
    }

    @Override // ei8.c
    public final String getKey() {
        return this.a;
    }

    public static void b(List r4) {
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L30;
        d0 r0 = (d0) r5.next();
        n0 r1 = r0.getSubMenu();
        if (r1 == null) goto L4;
        Iterator<T> r2 = r1.a.values().iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        b((List) r2.next());
        goto L10
    L12:
        d0 r3 = d(r1.a.values());
        p0 r6 = null;
        if (r3 == null) goto L17;
        b0 r7 = r3.getCenter();
        if (r7 == null) goto L17;
        String r8 = r7.a;
    L18:
        if (r8 != null) goto L19;
        if (r3 == null) goto L22;
        f0 r9 = r3.c();
    L24:
        if ((r9 instanceof p0) == false) goto L26;
        r6 = (p0) r9;
    L26:
        if (r6 == null) goto L4;
        if (r6.d == null) goto L4;
        r0.getRight().c = r6.d;
        goto L4
    L22:
        r9 = null;
        goto L24
    L19:
        r0.getRight().c = r8;
    L17:
        r8 = null;
        goto L18
    }

    public static t0 c(List r3) {
        Iterator r4 = r3.iterator();
    L3:
        t0 r1 = null;
        if (r4.hasNext() == false) goto L33;
        d0 r0 = (d0) r4.next();
        if (r0.getRight().a == false) goto L20;
        f0 r2 = r0.c();
        if ((r2 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L11;
        com.larus.bmhome.chat.nestedmenu.b r5 = (com.larus.bmhome.chat.nestedmenu.b) r2;
    L16:
        if (r5 == null) goto L32;
        com.larus.bmhome.chat.nestedmenu.b.a r6 = r5.c;
        if (r6 == null) goto L32;
        r1 = r6.a;
    L32:
        if (r1 == null) goto L3;
    L11:
        if ((r2 instanceof p0) == false) goto L15;
        f0 r7 = ((p0) r2).a;
        if ((r7 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L15;
        r5 = (com.larus.bmhome.chat.nestedmenu.b) r7;
    L15:
        r5 = null;
        goto L16
    L20:
        n0 r8 = r0.getSubMenu();
        if (r8 == null) goto L32;
        Map<String, List<d0>> r9 = r8.a;
        if (r9 == null) goto L32;
        Collection<List<d0>> r10 = r9.values();
        if (r10 == null) goto L32;
        Iterator<T> r11 = r10.iterator();
    L28:
        if (r11.hasNext() == false) goto L32;
        t0 r12 = c((List) r11.next());
        if (r12 == null) goto L28;
        r1 = r12;
    L33:
        return r1;
    }

    public static d0 d(Iterable r4) {
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L21;
        Iterator r0 = ((List) r5.next()).iterator();
    L7:
        if (r0.hasNext() == false) goto L4;
        d0 r2 = (d0) r0.next();
        if (r2.getRight().a == true) goto L10;
        n0 r3 = r2.getSubMenu();
        if (r3 == null) goto L18;
        Map<String, List<d0>> r6 = r3.a;
        if (r6 == null) goto L18;
        Collection<List<d0>> r7 = r6.values();
        if (r7 == null) goto L18;
        d0 r8 = d(r7);
    L19:
        if (r8 == null) goto L7;
        return r8;
    L18:
        r8 = null;
        goto L19
    L10:
        return r2;
    L21:
        return null;
    }

    public static b2 e(List r4) {
        Iterator r5 = r4.iterator();
    L3:
        b2 r1 = null;
        if (r5.hasNext() == false) goto L30;
        d0 r0 = (d0) r5.next();
        f0 r2 = r0.c();
        if ((r2 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L8;
        com.larus.bmhome.chat.nestedmenu.b r3 = (com.larus.bmhome.chat.nestedmenu.b) r2;
    L9:
        if (r3 == null) goto L11;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r6 = r3.a;
    L12:
        if (r6 != null) goto L14;
    L17:
        n0 r7 = r0.getSubMenu();
        if (r7 == null) goto L29;
        Map<String, List<d0>> r8 = r7.a;
        if (r8 == null) goto L29;
        Collection<List<d0>> r9 = r8.values();
        if (r9 == null) goto L29;
        Iterator<T> r10 = r9.iterator();
    L25:
        if (r10.hasNext() == false) goto L29;
        b2 r11 = e((List) r10.next());
        if (r11 == null) goto L25;
        r1 = r11;
    L29:
        if (r1 == null) goto L3;
    L14:
        if (r0.getRight().a == false) goto L17;
        return r6.a;
    L11:
        r6 = null;
        goto L12
    L8:
        r3 = null;
    L30:
        return r1;
    }

    @Override // ei8.a
    public final LinkedHashMap<String, List<d0>> a(LinkedHashMap<String, List<d0>> r39, c0 r40) {
        Intrinsics.checkNotNullParameter(r39, "models");
        Intrinsics.checkNotNullParameter(r40, "config");
        ReplyOption r3 = r40.l;
        if (r3 != null) goto L5;
        return r39;
    L5:
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L8;
        r0.P();
        Fragment r5 = ChatServiceImpl.a.f();
    L123:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object r2 = Result.constructor-impl(CompatKt.findFragment(r40.c));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r2) == false) goto L16;
        r2 = null;
    L16:
        Fragment r4 = (Fragment) r2;
        if (r4 == null) goto L22;
        t1a.b r6 = s1a.a.g(r4);
        if (r6 == null) goto L22;
        be8.a r7 = (be8.a) r6.getAbility(be8.a.class);
        if (r7 == null) goto L22;
    L27:
        if (r7 == null) goto L29;
        String r8 = r7.dC();
    L30:
        Iterator<Map.Entry<String, List<d0>>> r9 = r39.entrySet().iterator();
    L32:
        if (r9.hasNext() == false) goto L34;
        Map.Entry<String, List<d0>> r10 = r9.next();
        f(r10.getKey(), r10.getValue(), r3, r8);
        goto L32
    L34:
        List<d0> r11 = r39.get("mode");
        if (r11 != null) goto L37;
        r11 = CollectionsKt.emptyList();
    L37:
        t0 r12 = c(r11);
        boolean r13 = false;
        if (r12 == null) goto L40;
        boolean r14 = Intrinsics.areEqual(r12.q, Boolean.TRUE);
    L41:
        if (r14 == false) goto L118;
        List<d0> r15 = r39.get("model");
        if (r15 != null) goto L46;
        r15 = CollectionsKt.emptyList();
    L46:
        b2 r16 = e(r15);
        z0 r17 = r40.f;
        if (r17 == null) goto L51;
        com.larus.bmhome.actionbar.model.p0 r18 = r17.o;
        if (r18 == null) goto L51;
        w1 r19 = r18.o;
    L52:
        if (r19 == null) goto L54;
        r13 = Intrinsics.areEqual(r19.a, Boolean.TRUE);
    L54:
        if (r13 == false) goto L110;
        String r20 = r19.b;
        if (r20 == null) goto L110;
        if ((!StringsKt.isBlank(r20)) == false) goto L61;
        String r110 = r20;
    L62:
        if (r110 == null) goto L110;
        if (r16 == null) goto L110;
        ModelItemIdentity r21 = r16.b();
        if (r21 == null) goto L110;
        u1 r22 = r16.t;
        if (r22 == null) goto L110;
        List<v1> r23 = r22.a;
        if (r23 != null) goto L74;
        r23 = CollectionsKt.emptyList();
    L74:
        ArrayList r111 = new ArrayList();
        Iterator<T> r24 = r23.iterator();
    L76:
        if (r24.hasNext() == false) goto L87;
        v1 r112 = (v1) r24.next();
        Integer r113 = r112.a;
        if (r113 == null) goto L84;
        int r114 = r113.intValue();
        String r25 = r112.b;
        if (r25 != null) goto L82;
        String r115 = "";
    L83:
        d r116 = new d(null, new b0(r115, null, null, null, null, null, null, null, null, null, 32766), new NestedMenuRightModel(null, null, null, null, 1023), true, null, true, null, new com.larus.bmhome.chat.nestedmenu.b(null, new com.larus.bmhome.chat.nestedmenu.b.c(r16, r21, r112, r114), null, 13), false, false, false, 1873);
    L85:
        if (r116 == null) goto L76;
        r111.add(r116);
        goto L76
    L82:
        r115 = r25;
        goto L83
    L84:
        r116 = null;
        goto L85
    L87:
        d r117 = null;
        if (r111.isEmpty() == true) goto L111;
        boolean r26 = h.a;
        if (h.b(r40.c.getContext()) == false) goto L101;
        g1 r27 = r19.d;
        if (r27 == null) goto L98;
        String r28 = r27.b;
        if (r28 == null) goto L98;
        String r29 = r28;
    L106:
        if (r29 != null) goto L108;
        String r118 = "";
    L109:
        d r30 = new d(new g0(null, r118, null, false, null, 61), new b0(r110, null, null, null, null, null, null, null, null, null, 32766), new NestedMenuRightModel(null, 2131242741, null, null, 895), true, null, true, new n0(MapsKt.mapOf(TuplesKt.to("model", r111)), CollectionsKt.listOf("model")), null, false, false, false, 1936);
    L112:
        if (r30 == null) goto L118;
        List<d0> r31 = r39.get("model");
        if (r31 != null) goto L117;
        r31 = CollectionsKt.emptyList();
    L117:
        r39.put("model", CollectionsKt.plus(r31, r30));
        f("model", CollectionsKt.listOf(r30), r3, r8);
        goto L118
    L108:
        r118 = r29;
    L98:
        g1 r32 = r19.c;
        if (r32 == null) goto L104;
        r29 = r32.b;
    L104:
        r29 = null;
        goto L106
    L101:
        g1 r33 = r19.c;
        if (r33 == null) goto L104;
        r29 = r33.b;
    L111:
        r30 = r117;
        goto L112
    L61:
        r110 = null;
    L110:
        r117 = null;
    L51:
        r19 = null;
    L118:
        Iterator<T> r34 = r39.values().iterator();
    L120:
        if (r34.hasNext() == false) goto L122;
        List r35 = (List) r34.next();
        Intrinsics.checkNotNull(r35);
        b(r35);
        goto L120
    L122:
        return r39;
    L40:
        r14 = false;
        goto L41
    L29:
        r8 = null;
    L22:
        if (r5 == null) goto L26;
        t1a.b r36 = s1a.a.g(r5);
        if (r36 == null) goto L26;
        r7 = (be8.a) r36.getAbility(be8.a.class);
    L26:
        r7 = null;
    L11:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L8:
        r5 = null;
        goto L123
    }

    public static void f(String r6, List r7, ReplyOption r8, String r9) {
        Iterator r10 = r7.iterator();
    L4:
        if (r10.hasNext() == false) goto L94;
        d0 r0 = (d0) r10.next();
        Object r3 = null;
        if (Intrinsics.areEqual(r6, "mode") == false) goto L61;
        f0 r1 = r0.c();
        if ((r1 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L10;
        com.larus.bmhome.chat.nestedmenu.b r2 = (com.larus.bmhome.chat.nestedmenu.b) r1;
    L11:
        if (r2 == null) goto L13;
        com.larus.bmhome.chat.nestedmenu.b.a r4 = r2.c;
    L14:
        if (r4 == null) goto L24;
        com.larus.bmhome.chat.nestedmenu.b.a r5 = r2.c;
        if (r5 == null) goto L20;
        t0 r11 = r5.a;
        if (r11 == null) goto L20;
        String r12 = r11.a;
    L22:
        if (Intrinsics.areEqual(r12, r8.getModeId()) == false) goto L24;
        r0.getRight().a = true;
    L86:
        n0 r13 = r0.getSubMenu();
        if (r13 == null) goto L4;
        Map<String, List<d0>> r14 = r13.a;
        if (r14 == null) goto L4;
        Iterator<Map.Entry<String, List<d0>>> r15 = r14.entrySet().iterator();
    L92:
        if (r15.hasNext() == false) goto L4;
        Map.Entry<String, List<d0>> r16 = r15.next();
        f(r16.getKey(), r16.getValue(), r8, r9);
    L20:
        r12 = null;
    L24:
        f0 r17 = r0.c();
        if ((r17 instanceof p0) == false) goto L27;
        p0 r18 = (p0) r17;
    L28:
        if (r18 == null) goto L86;
        if (r18.g == true) goto L86;
        f0 r19 = r18.a;
        if ((r19 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L35;
        com.larus.bmhome.chat.nestedmenu.b r20 = (com.larus.bmhome.chat.nestedmenu.b) r19;
    L36:
        if (r20 == null) goto L38;
        com.larus.bmhome.chat.nestedmenu.b.a r21 = r20.c;
    L39:
        if (r21 == null) goto L49;
        com.larus.bmhome.chat.nestedmenu.b.a r22 = r20.c;
        if (r22 == null) goto L45;
        t0 r23 = r22.a;
        if (r23 == null) goto L45;
        String r24 = r23.a;
    L47:
        if (Intrinsics.areEqual(r24, r8.getModeId()) == false) goto L49;
        boolean r25 = true;
    L50:
        if (r25 == false) goto L86;
        PcDevice r26 = r18.c;
        if (r26 != null) goto L55;
        if (r9 != null) goto L55;
    L59:
        r0.getRight().a = true;
    L55:
        if (r26 == null) goto L58;
        r3 = r26.getDeviceId();
    L58:
        if (Intrinsics.areEqual(r3, r9) == false) goto L86;
    L45:
        r24 = null;
    L49:
        r25 = false;
        goto L50
    L38:
        r21 = null;
        goto L39
    L35:
        r20 = null;
        goto L36
    L27:
        r18 = null;
        goto L28
    L13:
        r4 = null;
        goto L14
    L10:
        r2 = null;
        goto L11
    L61:
        if (Intrinsics.areEqual(r6, "model") == false) goto L86;
        f0 r27 = r0.c();
        if ((r27 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L65;
        com.larus.bmhome.chat.nestedmenu.b r28 = (com.larus.bmhome.chat.nestedmenu.b) r27;
    L66:
        if (r28 == null) goto L68;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r29 = r28.a;
    L69:
        if (r29 == null) goto L76;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r30 = r28.a;
        if (r30 == null) goto L73;
        ModelItemIdentity r31 = r30.b;
    L75:
        if (Intrinsics.areEqual(r31, r8.getModel()) == false) goto L76;
    L85:
        r0.getRight().a = true;
        goto L86
    L73:
        r31 = null;
    L76:
        if (r28 == null) goto L78;
        com.larus.bmhome.chat.nestedmenu.b.c r32 = r28.b;
    L79:
        if (r32 == null) goto L86;
        com.larus.bmhome.chat.nestedmenu.b.c r33 = r28.b;
        if (r33 == null) goto L84;
        r3 = Integer.valueOf(r33.d);
    L84:
        if (Intrinsics.areEqual(r3, r8.getReasoningEffort()) == false) goto L86;
    L78:
        r32 = null;
        goto L79
    L68:
        r29 = null;
        goto L69
    L65:
        r28 = null;
        goto L66
    }
}
