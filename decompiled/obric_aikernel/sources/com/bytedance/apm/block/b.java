package com.bytedance.apm.block;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public class b extends a implements t4.d, com.bytedance.apm.i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l f747i;

    public b() {
        this.f747i = l.v();
    }

    @Override // com.bytedance.apm.i
    public void a(u.e r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        long r11 = r10.b();
        long r12 = r10.c();
        boolean r13 = r10.h();
        boolean r14 = r10.e();
        this.f747i.L(r13);
        this.f747i.I(r11);
        this.f747i.Q(r12);
        this.f747i.K(r14);
        this.f747i.O(r10.f());
        l r15 = this.f747i;
        if (com.bytedance.apm.d.K() == false) goto L7;
    L10:
        boolean r16 = true;
    L11:
        r15.P(r16);
        return;
    L7:
        if (r10.i() == true) goto L10;
        r16 = false;
        goto L11
    }

    @Override // com.bytedance.apm.block.a
    public void c(String r10) {
        super.c(r10);
        if (this.f746h == false) goto L6;
        this.f747i.D(r10);
        return;
    }

    @Override // com.bytedance.apm.block.a
    public void d(long r10, long r11, long r12, long r13, boolean r14) {
        super.d(r10, r11, r12, r13, r14);
        if (this.f746h == false) goto L6;
        this.f747i.C(r14);
        return;
    }

    public void i() {
        ActivityLifeObserver.getInstance().register(this);
        com.bytedance.apm.j.a(this);
        this.f747i.y();
        t.e.B().v(this);
        t.e.B().O();
        this.f745g = true;
        if (com.bytedance.apm.d.D() == false) goto L6;
        e0.e.b("BlockDetector", new String[]{"BlockDetector init: "});
        return;
    }

    public void j(d0.c r10) {
        this.f747i.J(r10);
    }

    public void k(long r10) {
        this.f747i.I(r10);
    }

    public void l(boolean r10) {
        this.f747i.N(r10);
    }

    public void m(boolean r10) {
        this.f747i.R(r10);
    }

    public void n(boolean r10) {
        this.f747i.S(r10);
    }

    public void o() {
        if (this.f745g == true) goto L5;
        return;
    L5:
        if (this.f746h == true) goto L13;
        this.f746h = true;
        if (com.bytedance.apm.d.D() == false) goto L12;
        e0.e.b("BlockDetector", new String[]{"BlockDetector start: "});
        return;
    L12:
        return;
    }

    @Override // t4.d
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // t4.d
    public void onActivityPause(Activity r10) {
    }

    @Override // t4.d
    public void onActivityResume(Activity r10) {
    }

    @Override // t4.d
    public void onActivityStarted(Activity r10) {
    }

    @Override // t4.d
    public void onBackground(Activity r10) {
        p();
    }

    @Override // t4.d
    public void onChange(Activity r10, Fragment r11) {
    }

    @Override // t4.d
    public void onFront(Activity r10) {
        o();
    }

    public void p() {
        if (this.f746h == true) goto L5;
        return;
    L5:
        this.f746h = false;
        this.f747i.C(false);
        if (com.bytedance.apm.d.D() == false) goto L9;
        e0.e.b("BlockDetector", new String[]{"BlockDetector stop: "});
        return;
    }
}
