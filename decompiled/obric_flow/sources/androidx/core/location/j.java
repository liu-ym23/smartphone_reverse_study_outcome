package androidx.core.location;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Executor f481c;

    public /* synthetic */ j(LocationManagerCompat.PreRGnssStatusTransport r5, Executor r10, int r11) {
        this.f479a = r11;
        this.f480b = r5;
        this.f481c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f479a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        LocationManagerCompat.PreRGnssStatusTransport.c(this.f480b, this.f481c);
        return;
    L6:
        LocationManagerCompat.PreRGnssStatusTransport.a(this.f480b, this.f481c);
    }
}
