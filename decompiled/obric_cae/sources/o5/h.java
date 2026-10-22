package o5;

import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f9704a;

    public h(g r8) {
        this.f9704a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r8 = this.f9704a;
        Iterator<BDLocationExtraDataServer> r10 = r8.f9687k.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        BDLocationExtraDataServer r11 = r10.next();
        if (r11 == null) goto L4;
        r11.stopCollectExtraData();
        goto L4
    L8:
        r8.f9687k.clear();
    }
}
