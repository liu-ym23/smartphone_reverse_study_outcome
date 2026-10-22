package com.bytedance.android.accessibilityLib_Core.helper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class AbstractActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
    public final Map<String, Boolean> a;
    public final AbstractActivityLifecycleCallback$fragmentLifecycleCallbacks$1 b;

    public abstract void a(Fragment r1, View r10);

    public abstract void b(Fragment r1);

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.accessibilityLib_Core.helper.AbstractActivityLifecycleCallback$fragmentLifecycleCallbacks$1] */
    public AbstractActivityLifecycleCallback() {
        this.a = new LinkedHashMap();
        this.b = new AbstractActivityLifecycleCallback$fragmentLifecycleCallbacks$1(this);
    }

    public final void c(Activity r10) {
        Context r0 = a.a;
        if ((r10 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r11 = (FragmentActivity) r10;
        r11.getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.b, true);
        String r12 = r11.getClass().getCanonicalName();
        if (r12 == null) goto L9;
        this.a.put(r12, Boolean.TRUE);
        return;
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
        Context r0 = a.a;
        if ((r10 instanceof FragmentActivity) == false) goto L6;
        ((FragmentActivity) r10).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.b);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r1) {
        Context r10 = a.a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r10) {
        Context r0 = a.a;
        if ((r10 instanceof FragmentActivity) == false) goto L11;
        String r1 = ((FragmentActivity) r10).getClass().getCanonicalName();
        if (r1 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.a).get(r1), Boolean.TRUE) == false) goto L9;
        return;
    L9:
        c(r10);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r1) {
        Context r10 = a.a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r1) {
        Context r10 = a.a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r10) {
        Context r11 = a.a;
        c(r1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r1, Bundle r10) {
        Context r11 = a.a;
    }
}
