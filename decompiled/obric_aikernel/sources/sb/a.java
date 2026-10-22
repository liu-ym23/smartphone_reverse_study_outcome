package sb;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ThreadFactory {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12776c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f12777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f12778h;

    public a(String r10, boolean r11) {
        this.f12777g = new AtomicInteger();
        this.f12776c = r10;
        this.f12778h = r11;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r10) {
        Thread r11 = new Thread(r10, this.f12776c + "-" + this.f12777g.incrementAndGet());
        if (this.f12778h == false) goto L5;
    L10:
        return r11;
    L5:
        if (r11.isDaemon() == false) goto L8;
        r11.setDaemon(false);
    L8:
        if (r11.getPriority() == 5) goto L10;
        r11.setPriority(5);
        goto L10
    }
}
