package com.bytedance.android.bst.api.ext;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final HashMap<String, ArrayList<Function1<Activity, Unit>>> a;
    public final ArrayList<Function1<Activity, Boolean>> b;
    public final a c;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ b a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r10) {
            ArrayList r0 = new ArrayList();
            Iterator<Function1<Activity, Boolean>> r1 = this.a.b.iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            Function1<Activity, Boolean> r11 = r1.next();
            if (((Boolean) r11.invoke(r10)).booleanValue() == false) goto L4;
            r0.add(r11);
            goto L4
        L8:
            this.a.b.removeAll(CollectionsKt.toSet(r0));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r10) {
            ArrayList<Function1<Activity, Unit>> r0 = this.a.a.get("onActivityPaused");
            if (r0 == null) goto L8;
            Iterator<T> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((Function1) r1.next()).invoke(r10);
            goto L6
        L10:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r10) {
            ArrayList<Function1<Activity, Unit>> r0 = this.a.a.get("onActivityResumed");
            if (r0 == null) goto L8;
            Iterator<T> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((Function1) r1.next()).invoke(r10);
            goto L6
        L10:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r10) {
            ArrayList<Function1<Activity, Unit>> r0 = this.a.a.get("onActivityStarted");
            if (r0 == null) goto L8;
            Iterator<T> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((Function1) r1.next()).invoke(r10);
            goto L6
        L10:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r10) {
            ArrayList<Function1<Activity, Unit>> r0 = this.a.a.get("onActivityStopped");
            if (r0 == null) goto L8;
            Iterator<T> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((Function1) r1.next()).invoke(r10);
            goto L6
        L10:
            return;
        }

        public a(b r1, com.bytedance.android.bst.api.ext.a r10) {
            this.a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r10, Bundle r11) {
            ArrayList<Function1<Activity, Unit>> r12 = this.a.a.get("onActivityCreated");
            if (r12 == null) goto L8;
            Iterator<T> r13 = r12.iterator();
        L6:
            if (r13.hasNext() == false) goto L10;
            ((Function1) r13.next()).invoke(r10);
            goto L6
        L10:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
            ArrayList<Function1<Activity, Unit>> r12 = this.a.a.get("onActivitySaveInstanceState");
            if (r12 == null) goto L8;
            Iterator<T> r13 = r12.iterator();
        L6:
            if (r13.hasNext() == false) goto L10;
            ((Function1) r13.next()).invoke(r10);
            goto L6
        L10:
            return;
        }
    }

    public b(com.bytedance.android.bst.api.ext.a r10) {
        this.a = new HashMap();
        this.b = new ArrayList();
        this.c = new a(this, r10);
    }
}
