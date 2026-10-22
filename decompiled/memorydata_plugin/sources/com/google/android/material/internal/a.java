package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.internal.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a<T extends g<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, T> f3962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Integer> f3963b;
    private InterfaceC0185a c;
    private boolean d;
    private boolean e;

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    public interface InterfaceC0185a {
        void a(Set<Integer> r1);
    }

    public a() {
        this.f3962a = new HashMap();
        this.f3963b = new HashSet();
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.e;
    }

    static /* synthetic */ boolean a(a r2, g r3) {
        return r2.c((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean a(a r2, g r3, boolean r4) {
        return r2.a((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"), r4);
    }

    private boolean a(g<T> r5, boolean r6) {
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
        int r0 = r7.getId();
        if (this.f3963b.contains(Integer.valueOf(r0)) == true) goto L5;
        return false;
    L5:
        if (r6 == true) goto L7;
    L12:
        boolean r4 = this.f3963b.remove(Integer.valueOf(r0));
        if (r7.isChecked() == false) goto L15;
        r7.setChecked(false);
    L15:
        return r4;
    L7:
        if (this.f3963b.size() != 1) goto L12;
        if (this.f3963b.contains(Integer.valueOf(r0)) == false) goto L12;
        r7.setChecked(true);
        return false;
    }

    static /* synthetic */ void b(a r0) {
        r0.e();
    }

    private boolean c(g<T> r6) {
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
        int r0 = r7.getId();
        if (this.f3963b.contains(Integer.valueOf(r0)) == false) goto L5;
        return false;
    L5:
        g<T> r1 = (g) ZeusTransformUtils.preCheckCast(this.f3962a.get(Integer.valueOf(c())), g.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        a(r1, false);
    L8:
        boolean r5 = this.f3963b.add(Integer.valueOf(r0));
        if (r7.isChecked() == true) goto L11;
        r7.setChecked(true);
    L11:
        return r5;
    }

    private void e() {
        InterfaceC0185a r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(d());
        return;
    }

    public List<Integer> a(ViewGroup r5) {
        Set<Integer> r4 = d();
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r5.getChildCount()) goto L11;
        View r2 = r5.getChildAt(r1);
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L10;
        if (r4.contains(Integer.valueOf(r2.getId())) == false) goto L10;
        r0.add(Integer.valueOf(r2.getId()));
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    public void a(int r3) {
        g<T> r4 = (g) ZeusTransformUtils.preCheckCast(this.f3962a.get(Integer.valueOf(r3)), g.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (c(r4) == false) goto L9;
        e();
        return;
    }

    public void a(InterfaceC0185a r3) {
        this.c = (InterfaceC0185a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0185a.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(T r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        this.f3962a.put(Integer.valueOf(r4.getId()), (T) r4);
        if (r4.isChecked() == false) goto L5;
        c(r4);
    L5:
        r4.setInternalOnCheckedChangeListener(new AnonymousClass1(this));
    }

    public void a(boolean r2) {
        if (this.d == r2) goto L6;
        this.d = r2;
        b();
        return;
    }

    public boolean a() {
        return this.d;
    }

    public void b() {
        boolean r0 = !this.f3963b.isEmpty();
        Iterator<T> r1 = this.f3962a.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a((g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.memorydata.plugin"), false);
        goto L4
    L6:
        if (r0 == false) goto L10;
        e();
        return;
    }

    public void b(T r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        r4.setInternalOnCheckedChangeListener(null);
        this.f3962a.remove(Integer.valueOf(r4.getId()));
        this.f3963b.remove(Integer.valueOf(r4.getId()));
    }

    public void b(boolean r1) {
        this.e = r1;
    }

    public int c() {
        if (this.d == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.f3963b.isEmpty() == true) goto L7;
        return ((Integer) ZeusTransformUtils.preCheckCast(this.f3963b.iterator().next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public Set<Integer> d() {
        return new HashSet(this.f3963b);
    }
}
