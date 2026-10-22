package com.bumptech.glide.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set<Activity> f916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f917b;

    h() {
        this.f916a = Collections.newSetFromMap(new WeakHashMap());
    }

    static void a(View r2, ViewTreeObserver.OnDrawListener r3) {
        ViewTreeObserver.OnDrawListener r4 = (ViewTreeObserver.OnDrawListener) ZeusTransformUtils.wrapperContextForParams(r3, ViewTreeObserver.OnDrawListener.class, "com.obric.memorydata.plugin");
        r2.getViewTreeObserver().removeOnDrawListener(r4);
    }

    @Override // com.bumptech.glide.manager.i
    public void a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (this.f917b == false) goto L6;
        return;
    L6:
        if (this.f916a.add(r4) == true) goto L8;
        return;
    L8:
        final View r5 = ZeusTransformUtils.getWindow(r4, "com.obric.memorydata.plugin").getDecorView();
        r5.getViewTreeObserver().addOnDrawListener(new AnonymousClass1(this, r5));
    }
}
