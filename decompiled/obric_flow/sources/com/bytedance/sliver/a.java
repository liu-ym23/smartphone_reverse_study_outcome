package com.bytedance.sliver;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f7512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7513c;
    public final /* synthetic */ Thread d;
    public final /* synthetic */ boolean e;

    public a(String r5, b r10, String r11, Thread r12, boolean r13) {
        this.f7511a = r5;
        this.f7512b = r10;
        this.f7513c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r5 = this.f7511a;
        if (TextUtils.isEmpty(r5) == true) goto L7;
        Long r10 = (Long) Sliver.access$100().get(r5);
        if (r10 == null) goto L7;
        long r11 = r10.longValue();
    L8:
        Sliver.access$200(this.f7512b.f7514a, this.f7513c, r11);
        StringBuilder r12 = new StringBuilder();
        r12.append(this.d);
        r12.append(" dump ");
        if (this.e == false) goto L11;
        String r13 = "sync";
    L12:
        r12.append(r13);
        r12.append(" success");
        Sliver.onStep(r12.toString());
        return;
    L11:
        r13 = "async";
    L7:
        r11 = -1;
        goto L8
    }
}
