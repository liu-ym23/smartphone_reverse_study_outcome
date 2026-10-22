package com.bytedance.ai.model.widgets;

import android.view.View;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageStatus;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements w0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletRuntime f2329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PageInfo f2330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2331c;
    public final String d;

    public a(AppletRuntime r5, PageInfo r10) {
        Intrinsics.checkNotNullParameter(r5, "appletRuntime");
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        this.f2329a = r5;
        this.f2330b = r10;
        String r11 = UUID.randomUUID().toString();
        this.f2330b.setPageId(r11);
        this.f2331c = r11;
        LazyKt.lazy(new a3.f(8));
        PageStatus r12 = PageStatus.f2286a;
        List r13 = r5.f2197h.G;
        Page r14 = null;
        Object r15 = null;
        if (r13 == null) goto L11;
        Iterator r16 = r13.iterator();
    L6:
        if (r16.hasNext() == false) goto L10;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((Page) r17).pageId(), this.f2330b.getPageName()) == false) goto L6;
        r15 = r17;
    L10:
        r14 = (Page) r15;
    L11:
        if (r14 == null) goto L14;
        String r18 = r14.getRenderType();
        if (r18 == null) goto L14;
    L15:
        this.d = r18;
        Lazy r19 = com.bytedance.ai.model.p.f2292a;
        Intrinsics.checkNotNullParameter(this, "page");
        com.bytedance.ai.model.p.f2293b.put(this.f2331c, this);
        Iterator r20 = com.bytedance.ai.model.p.d.iterator();
        if (r20.hasNext() == true) goto L20;
        PageStatus r21 = PageStatus.f2286a;
        z2.d.e("applet_create_container", new w8.f(this));
        return;
    L20:
        throw mn.h.c(r20);
    L14:
        r18 = this.f2329a.f2197h.f2268o;
        goto L15
    }

    @Override // w0.i
    public void a(long r5, long r10) {
    }

    @Override // w0.g
    public void b() {
    }

    @Override // w0.f
    public void c(double r5, double r10) {
    }

    public void e(String r5) {
        Intrinsics.checkNotNullParameter("AIContainerViewBase", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L5;
        r10.i("AIContainerViewBase", "onViewFinish");
    L5:
        PageStatus r11 = PageStatus.f2286a;
        androidx.fragment.app.d r12 = new androidx.fragment.app.d(this, 10);
        SoftReference r13 = c1.b.f1102a;
        Intrinsics.checkNotNullParameter(r12, "runnable");
        c1.b.c().postDelayed(r12, 100);
        z2.d.e("applet_view_load_finish", new w8.f(this));
    }

    @Override // w0.e
    public final String g() {
        return this.f2331c;
    }

    @Override // w0.e
    public final String getAppletId() {
        return this.f2329a.f2197h.F;
    }

    public String h() {
        return this.d;
    }

    public View b(PageInfo r5, com.bytedance.ai.model.k r10, com.bytedance.ai.model.k r11) {
        Intrinsics.checkNotNullParameter(r5, "pageInfo");
        AppletRuntime r12 = this.f2329a;
        r12.f2197h.g();
        r12.i();
        Intrinsics.checkNotNullParameter("AIContainerViewBase", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L7;
        r13.i("AIContainerViewBase", "onHostCreate");
        return null;
    L7:
        return null;
    }
}
