package cj;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f1187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1188c;
    public final ConcurrentHashMap d;
    public final WeakReference e;

    public a(String r5, ViewGroup r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "containerID");
        Intrinsics.checkNotNullParameter(r10, "engineView");
        Intrinsics.checkNotNullParameter(r11, "namespace");
        this.f1186a = r5;
        this.f1187b = r10;
        this.f1188c = r11;
        this.d = new ConcurrentHashMap();
        this.e = new WeakReference(r10);
    }

    @Override // cj.e
    public final Object a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        c r10 = (c) this.d.get(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        switch(r10.f1192a) {
            case 0: goto L11;
            default: goto L6;
        };
    L6:
        WeakReference r11 = (WeakReference) r10.f1193b;
        if (r11 != null) goto L14;
        return null;
    L14:
        return r11.get();
    L11:
        return (rb.b) r10.f1193b;
    }

    @Override // cj.e
    /* JADX INFO: renamed from: c */
    public final Activity mo118c() {
        View r5 = (View) this.e.get();
        if (r5 == null) goto L5;
        Context r10 = r5.getContext();
    L6:
        if (r10 == null) goto L15;
        if ((r10 instanceof Activity) == true) goto L10;
        if ((r10 instanceof ContextWrapper) == false) goto L14;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L6
    L14:
        Log.w("ViewUtils", "find non-ContextWrapper in view: " + r10);
        goto L15
    L10:
        return (Activity) r10;
    L15:
        return null;
    L5:
        r10 = null;
        goto L6
    }

    public final void d() {
        ConcurrentHashMap r5 = this.d;
        Iterator r10 = r5.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        c r11 = (c) r10.next();
        switch(r11.f1192a) {
            case 0: goto L11;
            default: goto L7;
        };
    L11:
        r11.f1193b = null;
        goto L4
    L7:
        WeakReference r12 = (WeakReference) r11.f1193b;
        if (r12 == null) goto L10;
        r12.clear();
    L10:
        r11.f1193b = null;
        goto L4
    L12:
        r5.clear();
    }
}
