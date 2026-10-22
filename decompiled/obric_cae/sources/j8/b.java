package j8;

import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Printer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Printer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HandlerThread f8744a;

    public b(i8.a.HandlerThreadC0091a r8) {
        this.f8744a = r8;
    }

    @Override // android.util.Printer
    public final void println(String r8) {
        if (r8.startsWith(">>>>> Dispatching") == false) goto L6;
        SystemClock.currentThreadTimeMillis();
        SystemClock.elapsedRealtime();
        return;
    L6:
        if (r8.startsWith("<<<<< Finished") == false) goto L12;
        SystemClock.currentThreadTimeMillis();
        SystemClock.elapsedRealtime();
        String r10 = this.f8744a.getName();
        ConcurrentHashMap r11 = c.f8746b;
        if (((a) r11.get(r10)) != null) goto L13;
        r11.put(r10, new a());
        return;
    L13:
        return;
    }
}
