package pn;

import com.lynx.tasm.eventreport.LynxEventReporter;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21369b;

    public /* synthetic */ b(int r5, int r10) {
        this.f21368a = r10;
        this.f21369b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f21368a;
        int r10 = this.f21369b;
        switch(r5) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        LynxEventReporter.c(r10);
        return;
    L6:
        LynxEventReporter.a(r10);
    }
}
