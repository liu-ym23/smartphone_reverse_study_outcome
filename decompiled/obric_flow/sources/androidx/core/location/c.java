package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f461c;

    public /* synthetic */ c(int r5, Object r10, Object r11) {
        this.f459a = r5;
        this.f460b = r10;
        this.f461c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f459a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        LocationManagerCompat.LocationListenerTransport.c((LocationManagerCompat.LocationListenerTransport) this.f460b, (Location) this.f461c);
        return;
    L6:
        LocationManagerCompat.LocationListenerTransport.d((LocationManagerCompat.LocationListenerTransport) this.f460b, (List) this.f461c);
        return;
    L8:
        LocationManagerCompat.CancellableLocationListener.b((Consumer) this.f460b, (Location) this.f461c);
    }
}
