package com.ss.android.lark.forseti.global;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements yua.d {
    public final List<yua.a> a;
    public final yua.a b;
    public final Fragment c;

    public final List<Fragment> g() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        Iterator r2 = ((yua.a) r1.next()).a().iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        Iterator r3 = ((yua.c) r2.next()).getPieces().iterator();
    L10:
        if (r3.hasNext() == false) goto L7;
        r0.add(((yua.b) r3.next()).getFragment());
        goto L10
    L12:
        return r0;
    }

    public final /* bridge */ /* synthetic */ Collection d() {
        return g();
    }

    public final yua.a a() {
        return this.b;
    }

    public final Fragment o2() {
        return this.c;
    }

    public final Fragment e(Fragment r6) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        Iterator r2 = ((yua.a) r1.next()).a().iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        Iterator r3 = ((yua.c) r2.next()).getPieces().iterator();
    L10:
        if (r3.hasNext() == false) goto L7;
        r0.add((yua.b) r3.next());
        goto L10
    L13:
        return f(r6, r0);
    }

    public h(List<? extends yua.a> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "chains");
        this.a = r5;
        Fragment r1 = null;
        if (r6 == false) goto L5;
        yua.a r7 = (yua.a) CollectionsKt.getOrNull(r5, 0);
    L6:
        this.b = r7;
        if (r7 == null) goto L13;
        yua.c r8 = r7.b();
        if (r8 == null) goto L13;
        yua.b r9 = r8.a();
        if (r9 == null) goto L13;
        r1 = r9.getFragment();
    L13:
        this.c = r1;
        List<Fragment> r10 = g();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L15:
        if (r12.hasNext() == false) goto L22;
        Object r2 = r12.next();
        if (((Fragment) r2).getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L15;
        r11.add(r2);
        goto L15
    L19:
        r3 = false;
        goto L20
    L22:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static Fragment f(Fragment r2, List r3) {
        if (r3.isEmpty() == true) goto L11;
        Iterator r0 = r3.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(((yua.b) r0.next()).getFragment(), r2) == false) goto L7;
        boolean r1 = false;
    L12:
        if (r1 == false) goto L22;
        Fragment r4 = r2.getParentFragment();
        if (r4 != null) goto L16;
        return null;
    L16:
        return f(r4, r3);
    L22:
        return r2;
    L11:
        r1 = true;
        goto L12
    }

    public final ViewModelStoreOwner b(FragmentActivity r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "fragment");
        if (ForsetiConfig.a(r6) == true) goto L5;
        return r6;
    L5:
        Fragment r8 = e(r7);
        Iterator<T> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L23;
        Iterator r1 = ((yua.a) r0.next()).a().iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        Iterator r2 = ((yua.c) r1.next()).getPieces().iterator();
    L13:
        if (r2.hasNext() == false) goto L10;
        yua.b r3 = (yua.b) r2.next();
        if (Intrinsics.areEqual(r3.getFragment(), r8) == false) goto L13;
        return r3.getFragment();
    L23:
        return r6;
    }

    public final FragmentManager c(FragmentActivity r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "fragment");
        if (ForsetiConfig.a(r6) == false) goto L5;
        Fragment r8 = e(r7);
        Iterator<T> r0 = this.a.iterator();
    L8:
        if (r0.hasNext() == false) goto L20;
        Iterator r1 = ((yua.a) r0.next()).a().iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        Iterator r2 = ((yua.c) r1.next()).getPieces().iterator();
    L14:
        if (r2.hasNext() == false) goto L11;
        yua.b r3 = (yua.b) r2.next();
        if (Intrinsics.areEqual(r3.getFragment(), r8) == false) goto L14;
        return r3.getFragment().getChildFragmentManager();
    L20:
        return r6.getSupportFragmentManager();
    L5:
        return r6.getSupportFragmentManager();
    }
}
