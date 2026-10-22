package obric.flow.overlay;

import android.os.IBinder;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f20531a;

    public a(b r5) {
        this.f20531a = r5;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        b r5 = this.f20531a;
        cq.c r10 = r5.f20534c;
        if (r10 == null) goto L5;
        IBinder r11 = r10.asBinder();
    L6:
        if (r11 != null) goto L12;
    L9:
        r5.f20534c = null;
        return;
    L12:
        r11.unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L11
        goto L9
    L5:
        r11 = null;
        goto L6
    }
}
