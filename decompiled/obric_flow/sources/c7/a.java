package c7;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f1128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f1129c;
    public final /* synthetic */ d d;

    public a(d r5, String r10, HashMap r11, float r12) {
        this.d = r5;
        this.f1127a = r10;
        this.f1128b = r11;
        this.f1129c = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r5 = this.d;
        HashMap r10 = r5.f1135b;
        String r11 = this.f1127a;
        b r12 = (b) r10.get(r11);
        float r13 = this.f1129c;
        if (r12 != null) goto L5;
        b r14 = new b();
        r14.f1130a = this.f1128b;
        r14.f1131b = r13;
        r14.f1132c = System.currentTimeMillis();
        r14.d = 1;
        r5.f1135b.put(r11, r14);
        return;
    L5:
        r12.f1131b += r13;
        r12.d++;
    }
}
