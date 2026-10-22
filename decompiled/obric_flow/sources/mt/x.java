package mt;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f20178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SequentialDisposable f20179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20180c;
    public long d;
    public long e;
    public long f;
    public final /* synthetic */ y g;

    public x(y r5, long r10, Runnable r11, long r12, SequentialDisposable r13, long r14) {
        this.g = r5;
        this.f20178a = r11;
        this.f20179b = r13;
        this.f20180c = r14;
        this.e = r12;
        this.f = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f20178a.run();
        SequentialDisposable r5 = this.f20179b;
        if (r5.isDisposed() == true) goto L13;
        TimeUnit r10 = TimeUnit.NANOSECONDS;
        y r11 = this.g;
        r11.getClass();
        long r12 = r10.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        long r13 = z.f20181a;
        long r14 = r12 + r13;
        long r15 = this.e;
        long r16 = this.f20180c;
        if (r14 >= r15) goto L7;
    L10:
        long r17 = r12 + r16;
        long r18 = this.d + 1;
        this.d = r18;
        this.f = r17 - (r16 * r18);
    L11:
        this.e = r12;
        r5.replace(r11.b(this, r17 - r12, r10));
        return;
    L7:
        if (r12 >= ((r15 + r16) + r13)) goto L10;
        long r19 = this.f;
        long r20 = this.d + 1;
        this.d = r20;
        r17 = (r20 * r16) + r19;
        goto L11
    }
}
