package hs1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements e {
    public final ArrayList<e> a;
    public View b;
    public Map<Integer, View> c;

    @Override // hs1.e
    public final void onCreate() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).onCreate();
        goto L4
    }

    @Override // hs1.e
    public final void onDestroy() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).onDestroy();
        goto L4
    L6:
        ((LinkedHashMap) this.c).clear();
    }

    @Override // hs1.e
    public final void onPause() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).onPause();
        goto L4
    }

    @Override // hs1.e
    public final void onResume() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).onResume();
        goto L4
    }

    @Override // hs1.e
    public final void onStart() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).onStart();
        goto L4
    }

    @Override // hs1.e
    public final void onStop() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).onStop();
        goto L4
    }

    public d() {
        this.a = new ArrayList();
        this.c = new LinkedHashMap();
    }

    public final void a(e r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.add(r2);
    }

    @Override // hs1.e
    public final void c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).c(r3);
        goto L4
    }

    @Override // hs1.e
    public final void b(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).b(r3, r4);
        goto L4
    }
}
