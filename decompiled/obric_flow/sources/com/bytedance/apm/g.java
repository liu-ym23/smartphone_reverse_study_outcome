package com.bytedance.apm;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f3877c;

    public g(String r5, String r10, float r11) {
        this.f3875a = r5;
        this.f3876b = r10;
        this.f3877c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i6.a r5 = i6.a.i();
        String r10 = this.f3876b;
        float r11 = this.f3877c;
        r5.b(new j6.d(this.f3875a, r10, r11));
    }
}
