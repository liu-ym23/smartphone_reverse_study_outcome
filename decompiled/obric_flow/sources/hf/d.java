package hf;

import com.obric.android.agilelogger.ALog;
import java.util.Iterator;
import so.k;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f17312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f17313c;

    public /* synthetic */ d(String r5, String r10, int r11) {
        this.f17311a = r11;
        this.f17312b = r5;
        this.f17313c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f17311a) {
            case 0: goto L18;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ALog.access$300(this.f17312b, this.f17313c);
        return;
    L6:
        Iterator<k> r5 = ALog.getNativeFuncAddrCallbackList().iterator();
    L8:
        if (r5.hasNext() == false) goto L21;
        if (r5.next() == null) goto L8;
        throw new ClassCastException();
    L21:
        Thread.sleep(15000);     // Catch: Exception -> L20
    L16:
        ALog.access$300(this.f17312b, this.f17313c);
        return;
    L18:
        dn.a.M(this.f17312b, this.f17313c);
    }
}
