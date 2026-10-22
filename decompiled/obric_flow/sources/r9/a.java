package r9;

import com.bytedance.frameworks.baselib.network.dispatcher.IRequest$Priority;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f21698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21700c;
    public final Runnable d;
    public final IRequest$Priority e;

    public a(IRequest$Priority r5, int r10, Runnable r11) {
        new AtomicBoolean(false);
        this.f21698a = new AtomicBoolean(false);
        this.e = r5;
        this.f21699b = r10;
        this.d = r11;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        a r10 = (a) r5;
        IRequest$Priority r11 = r10.e;
        IRequest$Priority r12 = this.e;
        if (r12 != null) goto L5;
        r12 = IRequest$Priority.NORMAL;
    L5:
        if (r11 != null) goto L7;
        r11 = IRequest$Priority.NORMAL;
    L7:
        if (r12 != r11) goto L10;
        int r13 = this.f21700c;
        int r14 = r10.f21700c;
    L11:
        return r13 - r14;
    L10:
        r13 = r11.ordinal();
        r14 = r12.ordinal();
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable r5 = this.d;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.f21698a.get() == true) goto L9;
        r5.run();
        return;
    }
}
