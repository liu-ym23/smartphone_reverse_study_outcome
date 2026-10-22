package com.larus.bmhome.taskskill;

import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.instruction.core.model.ActionBarInstructionKey;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.actionbar.api.IActionBarFilter;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g2 implements IActionBarFilter {
    public static final Object c = null;
    public static final LinkedHashMap<String, String> d = null;
    public final IActionBarFilter.FilterMode a;
    public final int b;

    public static final class a {
        public static void a(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "ownerId");
            Intrinsics.checkNotNullParameter(r9, MusicAppletPage.KEY_SOURCE);
            Object r1 = g2.c;
            monitor-enter(r1);
            LinkedHashMap<String, String> r2 = g2.d;     // Catch: Throwable -> L18
            boolean r4 = false;
            if (r2.remove(r8) == null) goto L7;
            boolean r3 = true;
        L8:
            if (r3 == true) goto L10;
        L12:
            FLogger.a.d("TaskSkillActionBarFilter", "[release] source=" + r9 + ", owner=" + r8 + ", removed=" + r3 + ", owners=" + r2.size() + ", shouldRemove=" + r4);     // Catch: Throwable -> L18
            if (r4 == false) goto L15;
            com.larus.bmhome.view.actionbar.api.a.b("task_skill_action_bar_filter");     // Catch: Throwable -> L18
        L15:
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L18
            monitor-exit(r1);
            return;
        L10:
            if (r2.isEmpty() == false) goto L12;
            r4 = true;
            goto L12
        L7:
            r3 = false;
        L18:
            th = move-exception;
            throw th;
        }

        public static void b(String r9, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r9, "ownerId");
            Intrinsics.checkNotNullParameter(r10, MusicAppletPage.KEY_SOURCE);
            Intrinsics.checkNotNullParameter(r11, "actionBarScopeId");
            if (StringsKt.isBlank(r11) == false) goto L6;
            FLogger.a.w("TaskSkillActionBarFilter", "[retain] skip blank scope, source=" + r10 + ", owner=" + r9);
            return;
        L6:
            Object r0 = g2.c;
            monitor-enter(r0);
            LinkedHashMap<String, String> r1 = g2.d;     // Catch: Throwable -> L34
            boolean r3 = false;
            if (r1.containsKey(r9) == true) goto L11;
            boolean r2 = true;
        L12:
            r1.put(r9, r11);     // Catch: Throwable -> L34
            List r4 = CollectionsKt.toList(com.larus.bmhome.view.actionbar.api.a.a);     // Catch: Throwable -> L34
            if ((r4 instanceof Collection) == true) goto L15;
        L17:
            Iterator r5 = r4.iterator();     // Catch: Throwable -> L34
        L19:
            if (r5.hasNext() == false) goto L23;
            if (Intrinsics.areEqual(((IActionBarFilter) r5.next()).b(), "task_skill_action_bar_filter") == false) goto L19;
            boolean r6 = true;
        L24:
            LinkedHashMap<String, String> r7 = g2.d;     // Catch: Throwable -> L34
            if ((!r7.isEmpty()) == false) goto L28;
            if (r6 == true) goto L28;
            r3 = true;
        L28:
            FLogger.a.d("TaskSkillActionBarFilter", "[retain] source=" + r10 + ", owner=" + r9 + ", added=" + r2 + ", scope=" + r11 + ", owners=" + r7.size() + ", isInjected=" + r6 + ", shouldInject=" + r3);     // Catch: Throwable -> L34
            if (r3 == false) goto L31;
            CopyOnWriteArrayList<IActionBarFilter> r12 = com.larus.bmhome.view.actionbar.api.a.a;     // Catch: Throwable -> L34
            com.larus.bmhome.view.actionbar.api.a.a(new g2());     // Catch: Throwable -> L34
        L31:
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L34
            monitor-exit(r0);
            return;
        L23:
            r6 = false;
            goto L24
        L15:
            if (r4.isEmpty() == false) goto L17;
        L11:
            r2 = false;
        L34:
            th = move-exception;
            throw th;
        }
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final String b() {
        return "task_skill_action_bar_filter";
    }

    static {
        c = new Object();
        d = new LinkedHashMap();
    }

    public g2() {
        this.a = IActionBarFilter.FilterMode.WHITELIST;
        this.b = 100;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final IActionBarFilter.FilterMode getMode() {
        return this.a;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final int getPriority() {
        return this.b;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final boolean a(com.larus.bmhome.actionbar.model.z0 r8, ss8.d r9) {
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r9, "context");
        Object r0 = c;
        monitor-enter(r0);
        LinkedHashMap<String, String> r1 = d;     // Catch: Throwable -> L84
        ArrayList r5 = null;
        if (r1.isEmpty() == false) goto L9;
        monitor-exit(r0);
        boolean r2 = false;
    L35:
        if (r2 == true) goto L37;
        return false;
    L37:
        FLogger.a.d("TaskSkillActionBarFilter", "[shouldFilter] context = " + r9 + ", item = " + r8);
        Map r3 = r8.H;
        if (r3 == null) goto L44;
        String r4 = (String) r3.get("retain_in_task_mode");
        if (r4 == null) goto L44;
        if (Boolean.parseBoolean(r4) != true) goto L44;
        boolean r6 = true;
    L45:
        if (r6 == false) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(r8.b, ActionBarInstructionKey.COCO_DEEP_THINKING.getKey()) == true) goto L50;
        int r10 = be8.g.a;
        return !be8.g.a(r8.b);
    L50:
        if (r9.e == true) goto L52;
        return false;
    L52:
        com.larus.bmhome.actionbar.model.p0 r11 = r8.o;
        if (r11 == null) goto L70;
        a2 r12 = r11.d();
        if (r12 == null) goto L70;
        ArrayList r13 = r12.a;
        if (r13 == null) goto L70;
        r5 = new ArrayList();
        Iterator r14 = r13.iterator();
    L60:
        if (r14.hasNext() == false) goto L70;
        Object r7 = r14.next();
        Integer r15 = ((com.larus.bmhome.actionbar.model.b2) r7).l;
        int r16 = AgentMode.MOA.getValue();
        if (r15 != null) goto L65;
    L67:
        boolean r17 = false;
    L68:
        if (r17 == false) goto L60;
        r5.add(r7);
        goto L60
    L65:
        if (r15.intValue() != r16) goto L67;
        r17 = true;
    L70:
        com.larus.bmhome.actionbar.model.p0 r18 = r8.o;
        if (r18 == null) goto L73;
        boolean r19 = Intrinsics.areEqual(r18.k, Boolean.TRUE);
    L74:
        if (r19 == true) goto L80;
        if (r5 != null) goto L78;
        return true;
    L78:
        if (r5.size() > 1) goto L80;
        return true;
    L80:
        return false;
    L73:
        r19 = false;
    L44:
        r6 = false;
        goto L45
    L9:
        Object r20 = r9.f.get("action_bar_scope_id");     // Catch: Throwable -> L84
        if ((r20 instanceof String) == false) goto L12;
        String r21 = (String) r20;     // Catch: Throwable -> L84
    L13:
        if (r21 != null) goto L15;
    L17:
        boolean r22 = false;
    L18:
        if (r22 == false) goto L33;
        Collection<String> r23 = r1.values();     // Catch: Throwable -> L84
        if ((r23 instanceof Collection) == true) goto L22;
    L24:
        Iterator<T> r24 = r23.iterator();     // Catch: Throwable -> L84
    L25:
        if (r24.hasNext() == false) goto L30;
        if (Intrinsics.areEqual((String) r24.next(), r21) == false) goto L25;
        boolean r25 = true;
    L31:
        if (r25 == false) goto L33;
        r2 = true;
    L34:
        monitor-exit(r0);
    L30:
        r25 = false;
        goto L31
    L22:
        if (r23.isEmpty() == false) goto L24;
    L33:
        r2 = false;
        goto L34
    L15:
        if ((!StringsKt.isBlank(r21)) != true) goto L17;
        r22 = true;
        goto L18
    L12:
        r21 = null;
    L84:
        th = move-exception;
        throw th;
    }
}
