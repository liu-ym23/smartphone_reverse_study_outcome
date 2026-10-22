package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import com.google.android.material.internal.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@UiThread
public class a<T extends g<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, T> f3377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Integer> f3378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f3379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3381e;

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    class C0081a implements g.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f3382a;

        C0081a(a r10) {
            this.f3382a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.internal.g.a
        public /* bridge */ /* synthetic */ void a(Object r10, boolean r11) {
            b((g) r10, r11);
        }

        public void b(T r10, boolean r11) {
            if (r11 == true) goto L4;
            a r12 = this.f3382a;
            if (a.c(r12, r10, a.b(r12)) == false) goto L11;
        L8:
            a.d(this.f3382a);
            return;
        L11:
            return;
        L4:
            if (a.a(this.f3382a, r10) == true) goto L8;
        }
    }

    public interface b {
        void a(@NonNull Set<Integer> r10);
    }

    public a() {
        this.f3377a = new HashMap();
        this.f3378b = new HashSet();
    }

    static /* synthetic */ boolean a(a r10, g r11) {
        return r10.g(r11);
    }

    static /* synthetic */ boolean b(a r10) {
        return r10.f3381e;
    }

    static /* synthetic */ boolean c(a r10, g r11, boolean r12) {
        return r10.r(r11, r12);
    }

    static /* synthetic */ void d(a r10) {
        r10.m();
    }

    private boolean g(@NonNull g<T> r10) {
        int r11 = r10.getId();
        if (this.f3378b.contains(Integer.valueOf(r11)) == false) goto L5;
        return false;
    L5:
        T r12 = this.f3377a.get(Integer.valueOf(k()));
        if (r12 == null) goto L8;
        r(r12, false);
    L8:
        boolean r13 = this.f3378b.add(Integer.valueOf(r11));
        if (r10.isChecked() == true) goto L11;
        r10.setChecked(true);
    L11:
        return r13;
    }

    private void m() {
        b r10 = this.f3379c;
        if (r10 == null) goto L6;
        r10.a(i());
        return;
    }

    private boolean r(@NonNull g<T> r10, boolean r11) {
        int r12 = r10.getId();
        if (this.f3378b.contains(Integer.valueOf(r12)) == true) goto L5;
        return false;
    L5:
        if (r11 == true) goto L7;
    L12:
        boolean r13 = this.f3378b.remove(Integer.valueOf(r12));
        if (r10.isChecked() == false) goto L15;
        r10.setChecked(false);
    L15:
        return r13;
    L7:
        if (this.f3378b.size() != 1) goto L12;
        if (this.f3378b.contains(Integer.valueOf(r12)) == false) goto L12;
        r10.setChecked(true);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(T r10) {
        this.f3377a.put(Integer.valueOf(r10.getId()), r10);
        if (r10.isChecked() == false) goto L5;
        g(r10);
    L5:
        r10.setInternalOnCheckedChangeListener(new C0081a(this));
    }

    public void f(@IdRes int r10) {
        T r11 = this.f3377a.get(Integer.valueOf(r10));
        if (r11 != null) goto L6;
        return;
    L6:
        if (g(r11) == false) goto L9;
        m();
        return;
    }

    public void h() {
        boolean r10 = !this.f3378b.isEmpty();
        Iterator<T> r11 = this.f3377a.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r(r11.next(), false);
        goto L4
    L6:
        if (r10 == false) goto L10;
        m();
        return;
    }

    @NonNull
    public Set<Integer> i() {
        return new HashSet(this.f3378b);
    }

    @NonNull
    public List<Integer> j(@NonNull ViewGroup r10) {
        Set<Integer> r11 = i();
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L4:
        if (r13 >= r10.getChildCount()) goto L11;
        View r14 = r10.getChildAt(r13);
        if ((r14 instanceof g) == false) goto L10;
        if (r11.contains(Integer.valueOf(r14.getId())) == false) goto L10;
        r12.add(Integer.valueOf(r14.getId()));
    L10:
        r13 = r13 + 1;
        goto L4
    L11:
        return r12;
    }

    @IdRes
    public int k() {
        if (this.f3380d == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.f3378b.isEmpty() == true) goto L7;
        return this.f3378b.iterator().next().intValue();
    }

    public boolean l() {
        return this.f3380d;
    }

    public void n(T r10) {
        r10.setInternalOnCheckedChangeListener(null);
        this.f3377a.remove(Integer.valueOf(r10.getId()));
        this.f3378b.remove(Integer.valueOf(r10.getId()));
    }

    public void o(@Nullable b r10) {
        this.f3379c = r10;
    }

    public void p(boolean r10) {
        this.f3381e = r10;
    }

    public void q(boolean r10) {
        if (this.f3380d == r10) goto L6;
        this.f3380d = r10;
        h();
        return;
    }
}
