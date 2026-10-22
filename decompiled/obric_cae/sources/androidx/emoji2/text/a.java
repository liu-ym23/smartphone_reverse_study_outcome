package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1741b;

    public /* synthetic */ a(Object r8, int r10) {
        this.f1740a = r10;
        this.f1741b = r8;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r8) {
        int r10 = this.f1740a;
        Object r11 = this.f1741b;
        switch(r10) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        Thread r12 = new Thread(r8, (String) r11);
        r12.setPriority(10);
        return r12;
    L7:
        f2.a r13 = (f2.a) r11;
        he.i.f(r13, "this$0");
        Thread r14 = new Thread(r8, "WorkerScheduler-" + r13);
        r14.setDaemon(true);
        return r14;
    }
}
