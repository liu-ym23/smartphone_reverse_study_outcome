package com.bytedance.android.bst.api.saas;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.api.ext.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SaasService {
    public volatile boolean a;
    public final Map<c<Activity>, List<b>> b;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final int b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof b) == false) goto L10;
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r11.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + this.b;
        L5:
            r1 = 0;
            goto L7
        }

        public final String toString() {
            return "SimpleNode(itemHash=" + this.a + ", businessTag=" + this.b + ")";
        }

        public b(String r1, int r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    static {
    }

    public SaasService() {
        this.b = new LinkedHashMap();
    }

    public final synchronized void b(View r10) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (this.a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.a = true;     // Catch: Throwable -> L24
        Context r11 = r10.getContext().getApplicationContext();     // Catch: Throwable -> L24
        if (r11 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        if ((r11 instanceof Application) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        com.bytedance.android.bst.api.ext.b r0 = new com.bytedance.android.bst.api.ext.b(null);     // Catch: Throwable -> L24
        ((Application) r11).registerActivityLifecycleCallbacks(r0.c);     // Catch: Throwable -> L24
        Function1<Activity, Unit> r12 = new SaasService$registerActivityMonitorIfNeed$1(this);     // Catch: Throwable -> L24
        HashMap<String, ArrayList<Function1<Activity, Unit>>> r1 = r0.a;     // Catch: Throwable -> L24
        ArrayList<Function1<Activity, Unit>> r13 = r1.get("onActivityCreated");     // Catch: Throwable -> L24
        if (r13 != null) goto L17;
        r13 = new ArrayList();     // Catch: Throwable -> L24
        r1.put("onActivityCreated", r13);     // Catch: Throwable -> L24
    L17:
        r13.add(r12);     // Catch: Throwable -> L24
        Function1<Activity, Boolean> r14 = new SaasService$registerActivityMonitorIfNeed$2(this);     // Catch: Throwable -> L24
        if (r0.b.contains(r14) == true) goto L20;
        r0.b.add(r14);     // Catch: Throwable -> L24
    L20:
        monitor-exit(this);
    }

    public final void a(RecyclerView r10, final int r11) {
        boolean r1 = false;
        if ((r11 >>> 24) < 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
        if (r11 == (-1)) goto L10;
        r1 = true;
    L10:
        if (r1 == false) goto L18;
        ExtKt.b("SaasService", "--clearViewStatusCache--\n businessTag:" + r10.getResources().getResourceEntryName(r11));
        Activity r12 = ExtKt.getActivity(r10);
        if (r12 == null) goto L21;
        List r13 = (List) ((LinkedHashMap) this.b).get(new c(r12));
        if (r13 == null) goto L22;
        CollectionsKt.removeAll(r13, new SaasService$clearViewStatusCache$3(r11));
        return;
    L22:
        return;
    L21:
        return;
    L18:
        throw new IllegalArgumentException("The key must can not be empty business tag".toString());
    L20:
        throw new IllegalArgumentException("The key must be an application-specific resource id.".toString());
    L5:
        r0 = false;
        goto L6
    }
}
