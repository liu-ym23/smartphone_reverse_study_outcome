package com.lynx.tasm.ui.image;

import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.BaseControllerListener;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f11095b;

    public /* synthetic */ p0(q0 r5, int r10) {
        this.f11094a = r10;
        this.f11095b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f11094a) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        q0 r5 = this.f11095b;
        n0 r10 = r5.d;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.f11061l != r5.f11098c) goto L30;
        r10.f11056c = false;
        b r11 = r10.f11054a;
        if (r11.f11025a.add(r10) == true) goto L12;
        return;
    L12:
        if (r11.f11025a.size() != 1) goto L31;
        a r12 = r11.f11026b;
        com.lynx.tasm.utils.j.a().post(r12);
        return;
    L31:
        return;
    L30:
        return;
    L15:
        n0 r13 = this.f11095b.d;
        if (r13 != null) goto L18;
        return;
    L18:
        if (r13.f11061l == null) goto L34;
        r13.f11054a.f11025a.remove(r13);
        r13.f11056c = true;
        if (r13.d == true) goto L35;
        BaseControllerListener r14 = r13.f11060k;
        if (r14 != null) goto L24;
        r14 = BaseControllerListener.f7804a;
    L24:
        r14.a(r13.f11064o, null);
        r13.d = true;
        r13.e = false;
        DataSource r15 = (DataSource) r13.f11084q.get();
        r13.g = r15;
        String r16 = r13.f11064o;
        if (r15 == null) goto L27;
        AbstractDataSource r17 = (AbstractDataSource) r15;
        r17.a(new g0(r13, r16, r15.a()), r13.f11055b);
        return;
    L27:
        com.lynx.tasm.behavior.ui.utils.e.i(new StringBuilder("request after dataSource release url= "), r13.f11063n, 2, "LynxImage");
        return;
    L35:
        return;
    }
}
