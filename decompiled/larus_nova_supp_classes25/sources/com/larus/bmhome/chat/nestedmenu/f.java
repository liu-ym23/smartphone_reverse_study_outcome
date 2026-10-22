package com.larus.bmhome.chat.nestedmenu;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.nestedmenu.provider.officetask.OfficeTaskNestedMenuProvider;
import com.larus.bmhome.chat.nestedmenu.ui.NestedMenuPopup;
import com.larus.bmhome.chat.nestedmenu.ui.q;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.m0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final List<ei8.c> a = null;
    public static final fi8.a b = null;
    public static final OfficeTaskNestedMenuProvider c = null;
    public static m0 d;
    public static boolean e;

    static {
        a = new ArrayList();
        fi8.a r0 = new fi8.a();
        b = r0;
        OfficeTaskNestedMenuProvider r1 = new OfficeTaskNestedMenuProvider();
        c = r1;
        g(r0);
        g(new gi8.b());
        g(r1);
        g(new com.larus.bmhome.chat.nestedmenu.provider.officetask.a());
        g(new hi8.a());
        g(new fi8.b());
    }

    public static void b() {
        c();
        m0 r0 = d;
        if (r0 == null) goto L5;
        c0 r2 = r0.a;
    L7:
        if (e == false) goto L9;
        return;
    L9:
        boolean r3 = true;
        e = true;
        if (r0 == null) goto L19;
        NestedMenuPopup r1 = r0.c;
        if (r1 == null) goto L19;
        Balloon r4 = r1.h;
        if (r4 == null) goto L16;
        r4.h();
    L16:
        r1.o = null;
        Balloon r5 = r1.g;
        if (r5 == null) goto L19;
        r5.h();
    L19:
        if (r2 != null) goto L22;
        r3 = false;
    L22:
        a(r2, r3);
        return;
    L5:
        r2 = null;
        goto L7
    }

    public static void c() {
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("NestedMenuManager must be called on main thread".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.util.ArrayList] */
    public static LinkedHashMap d(c0 r7) {
        Intrinsics.checkNotNullParameter(r7, "config");
        if (r7.g.a == false) goto L18;
        List<ei8.c> r1 = a;
        ?? r3 = new ArrayList();
        Iterator r2 = ((ArrayList) r1).iterator();
    L6:
        if (r2.hasNext() == false) goto L19;
        Object r4 = r2.next();
        ei8.c r5 = (ei8.c) r4;
        if ((r5 instanceof fi8.a) == false) goto L10;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L6;
        r3.add(r4);
        goto L6
    L10:
        if (r7.g.d == true) goto L12;
    L14:
        r6 = false;
        goto L16
    L12:
        if ((r5 instanceof OfficeTaskNestedMenuProvider) == false) goto L14;
    L19:
        Intrinsics.checkNotNullParameter(r3, "providers");
        Intrinsics.checkNotNullParameter(r7, "config");
        LinkedHashMap<String, List<d0>> r0 = new LinkedHashMap();
        Iterator r8 = ((Iterable) r3).iterator();
    L21:
        if (r8.hasNext() == false) goto L23;
        r0 = ((ei8.c) r8.next()).a(r0, r7);
        goto L21
    L23:
        List<String> r9 = r7.h;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r11 = r9.iterator();
    L25:
        if (r11.hasNext() == false) goto L34;
        String r12 = (String) r11.next();
        List<d0> r13 = r0.get(r12);
        if (r13 == null) goto L25;
        if ((!r13.isEmpty()) == true) goto L32;
        r13 = null;
    L32:
        if (r13 == null) goto L25;
        r10.put(r12, r13);
        goto L25
    L34:
        Iterator<Map.Entry<String, List<d0>>> r14 = r0.entrySet().iterator();
    L36:
        if (r14.hasNext() == false) goto L42;
        Map.Entry<String, List<d0>> r15 = r14.next();
        String r16 = r15.getKey();
        List<d0> r17 = r15.getValue();
        if (r10.containsKey(r16) == true) goto L36;
        if ((!r17.isEmpty()) == false) goto L36;
        r10.put(r16, r17);
        goto L36
    L42:
        return r10;
    L18:
        r3 = CollectionsKt.toList(a);
        goto L19
    }

    public static void g(ei8.c r3) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        List<ei8.c> r0 = a;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((ei8.c) r1.next()).getKey(), r3.getKey()) == false) goto L9;
        boolean r2 = false;
    L14:
        if (r2 == false) goto L20;
        ((ArrayList) a).add(r3);
        return;
    L20:
        return;
    L13:
        r2 = true;
        goto L14
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public static void h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "enterFrom");
        c();
        m0 r6 = d;
        if (r6 != null) goto L5;
        return;
    L5:
        c0 r0 = r6.a;
        if (e == true) goto L31;
        Balloon r1 = r6.c.g;
        if (r1 == null) goto L10;
        boolean r2 = r1.g;
    L11:
        if (r2 == false) goto L38;
        LinkedHashMap<String, List<d0>> r3 = d(r0);
        int r4 = com.larus.bmhome.chat.nestedmenu.ui.a.a;
        List<? extends q> r7 = com.larus.bmhome.chat.nestedmenu.ui.a.a(r3, r0.g.j, r3);
        if (((ArrayList) r7).isEmpty() == false) goto L18;
        b();
        return;
    L18:
        if (r6.c.update(r7) == true) goto L21;
        b();
        return;
    L21:
        d = m0.a(r6, r3);
        List<ei8.c> r8 = a;
        ArrayList r9 = new ArrayList();
        Iterator r10 = ((ArrayList) r8).iterator();
    L23:
        if (r10.hasNext() == false) goto L27;
        Object r11 = r10.next();
        if ((r11 instanceof ei8.b) == false) goto L23;
        r9.add(r11);
        goto L23
    L27:
        Iterator r12 = r9.iterator();
    L29:
        if (r12.hasNext() == false) goto L39;
        ((ei8.b) r12.next()).d(r3, r0);
        goto L29
    L39:
        return;
    L38:
        return;
    L10:
        r2 = false;
        goto L11
    }

    public static void a(c0 r4, boolean r5) {
        if (r5 == false) goto L10;
        m0 r6 = d;
        if (r6 == null) goto L7;
        c0 r7 = r6.a;
    L8:
        if (r7 != r4) goto L10;
        boolean r8 = true;
    L11:
        m0 r2 = d;
        d = null;
        e = false;
        if (r8 == false) goto L32;
        if (r4 == null) goto L41;
        Function0<Unit> r9 = r4.k;
        if (r9 == null) goto L17;
        r9.invoke();
    L17:
        List<ei8.c> r10 = a;
        ArrayList r0 = new ArrayList();
        Iterator r11 = ((ArrayList) r10).iterator();
    L19:
        if (r11.hasNext() == false) goto L23;
        Object r1 = r11.next();
        if ((r1 instanceof ei8.b) == false) goto L19;
        r0.add(r1);
        goto L19
    L23:
        Iterator r12 = r0.iterator();
    L25:
        if (r12.hasNext() == false) goto L42;
        ei8.b r3 = (ei8.b) r12.next();
        if (r2 == null) goto L30;
        LinkedHashMap<String, List<d0>> r13 = r2.b;
        if (r13 == null) goto L30;
    L31:
        r3.e(r13, r4);
    L30:
        r13 = new LinkedHashMap();
        goto L31
    L42:
        return;
    L41:
        return;
    L32:
        return;
    L7:
        r7 = null;
    L10:
        r8 = false;
        goto L11
    }

    public static List e(View r18, z0 r19) {
        Intrinsics.checkNotNullParameter(r18, "hostView");
        Intrinsics.checkNotNullParameter(r19, "actionBarItem");
        fi8.a r1 = b;
        Context r3 = r18.getContext();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "context");
        Object r4 = null;
        List r0 = fi8.a.g(r3, a.a(r19, null).a, false, null);
        OfficeTaskNestedMenuProvider r5 = c;
        Context r2 = r18.getContext();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r0, "modeModels");
        Iterator r6 = ((ArrayList) r0).iterator();
    L4:
        if (r6.hasNext() == false) goto L23;
        Object r7 = r6.next();
        f0 r8 = ((d0) r7).c();
        if ((r8 instanceof b) == false) goto L8;
        b r9 = (b) r8;
    L9:
        if (r9 == null) goto L20;
        b.a r10 = r9.c;
        if (r10 == null) goto L20;
        t0 r11 = r10.a;
        if (r11 == null) goto L20;
        Integer r12 = r11.j;
        int r13 = AgentMode.MOA.getValue();
        if (r12 == null) goto L20;
        if (r12.intValue() != r13) goto L20;
        boolean r14 = true;
    L21:
        if (r14 == false) goto L4;
        r4 = r7;
    L20:
        r14 = false;
        goto L21
    L8:
        r9 = null;
    L23:
        d0 r15 = (d0) r4;
        if (r15 == null) goto L49;
        bs8.e r16 = r5.g().b();
        if (r16 == null) goto L29;
        r5.d = r16;
    L32:
        List r17 = r16.a();
        String r20 = OfficeTaskNestedMenuProvider.i(r15);
        f0 r21 = r15.c();
        String r110 = OfficeTaskNestedMenuProvider.h(r2, 2131241906);
        List r22 = r16.a;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r112 = r22.iterator();
    L34:
        if (r112.hasNext() == false) goto L36;
        String r113 = r110;
        String r114 = r110;
        ArrayList r115 = r111;
        r115.add(OfficeTaskNestedMenuProvider.j(r5, (PcDevice) r112.next(), r2, r21, r20, true, r17.size(), r113, true));
        r111 = r115;
        r110 = r114;
        goto L34
    L36:
        String r116 = r110;
        ArrayList r117 = r111;
        List r23 = r16.b;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r24 = r23.iterator();
    L38:
        if (r24.hasNext() == false) goto L41;
        Iterator r119 = r24;
        ArrayList r25 = r118;
        r25.add(OfficeTaskNestedMenuProvider.j(r5, (PcDevice) r24.next(), r2, r21, r20, false, r17.size(), r116, true));
        r118 = r25;
        r24 = r119;
        goto L38
    L41:
        return CollectionsKt.plus(r117, r118);
    L29:
        r16 = r5.d;
        if (r16 != null) goto L32;
        r16 = new bs8.e(0);
        goto L32
    L49:
        return CollectionsKt.emptyList();
    }

    public static void f(List r4, c0 r5) {
        List<ei8.c> r0 = a;
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((ArrayList) r0).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof ei8.b) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r6 = r1.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((ei8.b) r6.next()).c(r4, r5);
        goto L10
    }
}
