package com.bytedance.apm.doctor;

import c8.e;
import c8.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f3762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3763b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3764m;

    public a(ArrayList r8) {
        this.f3762a = r8;
        this.f3763b = "APM_SETTING_READY";
        this.f3764m = null;
    }

    @Override // c8.g
    public final e A() {
        return e.f3420m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r8 = this.f3762a.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ((DoctorManager.ApmListener) r8.next()).onEvent(this.f3763b, this.f3764m);
        goto L4
    }
}
