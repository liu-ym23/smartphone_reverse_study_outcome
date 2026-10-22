package com.ss.android.lark.appcontext.applifecycle;

import android.app.Activity;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ActivityRecorder {
    public final LinkedList<a<Activity>> a;

    public final Activity a() {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        c(new getTopActivity.1(r0));
        return (Activity) r0.element;
    }

    public ActivityRecorder() {
        this.a = new LinkedList();
    }

    public final void c(Function1<? super Activity, Boolean> r4) {
        LinkedList<a<Activity>> r0 = this.a;
        monitor-enter(r0);
        Iterator<a<Activity>> r1 = this.a.iterator();     // Catch: Throwable -> L17
    L6:
        if (r1.hasNext() == false) goto L14;
        Activity r2 = (Activity) r1.next().get();     // Catch: Throwable -> L17
        if (r2 != null) goto L10;
        r1.remove();     // Catch: Throwable -> L17
        goto L6
    L10:
        if (((Boolean) r4.invoke(r2)).booleanValue() == false) goto L6;
        monitor-exit(r0);
        return;
    L14:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static void b(LinkedList r0, a r1) {
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L6
        monitor-exit(r0);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
