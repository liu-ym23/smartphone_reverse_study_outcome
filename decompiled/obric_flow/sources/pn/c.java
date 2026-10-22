package pn;

import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f21372c;

    public /* synthetic */ c(Map r5, int r10, int r11) {
        this.f21370a = r11;
        this.f21371b = r10;
        this.f21372c = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f21370a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        LynxEventReporter.f(this.f21371b, this.f21372c);
        return;
    L6:
        LynxEventReporter.g(this.f21371b, this.f21372c);
    }
}
