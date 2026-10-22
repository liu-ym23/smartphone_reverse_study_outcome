package com.bytedance.ai.widget;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        LinkedHashMap r10 = i1.b.f17481a;
        Intrinsics.checkNotNullParameter(r5, "context");
        Iterator r11 = i1.b.f17481a.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L17;
        i1.c r12 = (i1.c) r11.next();
        if (Intrinsics.areEqual((Context) r12.f17483b.get(), r5) == true) goto L9;
        if (((Context) r12.f17483b.get()) != null) goto L4;
    L9:
        i1.a r13 = (i1.a) i1.b.f17481a.get(r12);
        if (r13 == null) goto L16;
        r13.f17480c = true;
        StringBuilder r14 = new StringBuilder("destroy: pool size = ");
        ArrayDeque r15 = r13.f17479b;
        r14.append(r15.size());
        String r16 = r14.toString();
        Intrinsics.checkNotNullParameter("RenderViewPool", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        a1.a.f43a.i("RenderViewPool", r16);
        Iterator<E> r17 = r15.iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        ((g1.b) r17.next()).destroy();
        goto L13
    L15:
        r15.clear();
    L16:
        r11.remove();
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostDestroyed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        super.onActivityPostDestroyed(r5);
        c.a(new j(r5, 1));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
    }
}
