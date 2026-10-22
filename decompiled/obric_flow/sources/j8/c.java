package j8;

import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f18275b;

    public /* synthetic */ c(e r5, int r10) {
        this.f18274a = r10;
        this.f18275b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f18274a) {
            case 0: goto L13;
            case 1: goto L11;
            default: goto L4;
        };
    L4:
        e r5 = this.f18275b;
    L9:
        r5.f18286l.a();
        return;
    L6:
        if (r5.f18285k == null) goto L8;
        Logger.d("WsChannelSdk_ok", "send ping");     // Catch: Throwable -> L9
        r5.f18285k.getClass();     // Catch: Throwable -> L9
    L8:
        r5.f18286l.a();
        return;
    L11:
        e r10 = this.f18275b;
        r10.getClass();
        c r11 = new c(r10, 0);
        r10.f18283i.post(r11);
        return;
    L13:
        e r12 = this.f18275b;
        r12.g = true;
        r12.f18283i.removeMessages(2);
        r12.f18283i.removeMessages(1);
        r12.f18283i.removeMessages(3);
        r12.f18283i.removeMessages(5);
        fn.c r13 = r12.f18281c;
        if (r13 == null) goto L22;
        monitor-enter(r13);
        k8.a r14 = (k8.a) r13.f16949c;     // Catch: Throwable -> L19
        r14.f18625b = 0;     // Catch: Throwable -> L19
        r14.f18626c = 0;     // Catch: Throwable -> L19
        r13.d = null;     // Catch: Throwable -> L19
        r13.f16947a = 0;     // Catch: Throwable -> L19
        monitor-exit(r13);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        r12.f18283i.removeMessages(1);
        r12.g();
    }
}
