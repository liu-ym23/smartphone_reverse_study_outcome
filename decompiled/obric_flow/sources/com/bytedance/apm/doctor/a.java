package com.bytedance.apm.doctor;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.ArrayList;
import java.util.Iterator;
import mg.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3868c;

    public a(String r5, String r10, ArrayList r11) {
        this.f3866a = r11;
        this.f3867b = r5;
        this.f3868c = r10;
    }

    @Override // mg.d
    public final AsyncTaskType p() {
        return AsyncTaskType.LIGHT_WEIGHT;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r5 = this.f3866a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((DoctorManager.ApmListener) r5.next()).onEvent(this.f3867b, this.f3868c);
        goto L4
    }
}
