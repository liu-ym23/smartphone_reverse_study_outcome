package com.obric.assistant.task.skill;

import ada.c;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.util.r2;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public static final CopyOnWriteArraySet<a> a = null;
    public static final AtomicBoolean b = null;
    public static volatile AtomicReference<ReplyOption> c;
    public static volatile AtomicBoolean d;
    public static volatile Set<String> e;

    public interface a {
        void b5(boolean r1);
    }

    static {
        a = new CopyOnWriteArraySet();
        b = new AtomicBoolean(false);
        c = new AtomicReference(null);
        d = new AtomicBoolean(false);
        e = SetsKt.emptySet();
    }

    public static void c() {
        boolean r0 = d.get();
        FLogger.a.i("ObricTaskSkillModeController", "exit: wasActive=" + r0 + ", selectedOption=" + c.get());
        c.set(null);
        if (r0 == true) goto L5;
        return;
    L5:
        if (d.getAndSet(false) == false) goto L7;
        b.set(false);
    L7:
        com.larus.bmhome.view.actionbar.api.a.b("obric_task_skill_mode_filter");
        e(false);
    }

    public static boolean d() {
        return d.get();
    }

    public static boolean f() {
        if (d.get() == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(ObricInteractDelegate.b.isAiKeyPressing(), Boolean.TRUE) == false) goto L7;
        return false;
    L7:
        if (b.compareAndSet(false, true) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static void a(a r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        a.add(r1);
        r1.b5(d());
    }

    public static void b(ReplyOption r4) {
        Intrinsics.checkNotNullParameter(r4, "option");
        boolean r0 = d.get();
        FLogger.a.i("ObricTaskSkillModeController", "enter: " + r4 + ", wasActive=" + r0 + ", selectedOption=" + c.get());
        c.set(r4);
        if (r0 == false) goto L5;
        return;
    L5:
        if (d.getAndSet(true) == true) goto L7;
        b.set(false);
    L7:
        CopyOnWriteArrayList r5 = com.larus.bmhome.view.actionbar.api.a.a;
        com.larus.bmhome.view.actionbar.api.a.a(new g());
        e(true);
    }

    public static void e(boolean r2) {
        b r0 = r2.a();
        if (r0 == null) goto L7;
        c r1 = r0.getAbility(c.class);
        if (r1 == null) goto L7;
        r1.b5(r2);
    L7:
        Iterator<a> r3 = a.iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        r3.next().b5(r2);
        goto L9
    }
}
