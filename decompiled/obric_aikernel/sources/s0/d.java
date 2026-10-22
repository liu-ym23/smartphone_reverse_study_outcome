package s0;

import com.bytedance.apm.trace.model.cross.NativeSpan;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u0.a f12718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12720c;

    public synchronized void a(String r10, ArrayList<NativeSpan> r11) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f12720c == false) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (this.f12719b == false) goto L21;
        boolean r12 = true;
        Iterator<NativeSpan> r13 = r11.iterator();     // Catch: Throwable -> L23
    L9:
        if (r13.hasNext() == false) goto L19;
        NativeSpan r14 = r13.next();     // Catch: Throwable -> L23
        if (r14 == null) goto L9;
        c r15 = r14.parseToSpan(this.f12718a);     // Catch: Throwable -> L23
        if (r12 == false) goto L17;
        r15.a(Long.parseLong(r10));     // Catch: Throwable -> L23
    L17:
        r15.c(r14.getStartTime(), r14.getFinishTime());     // Catch: Throwable -> L23
        r12 = false;
        goto L9
    L19:
        monitor-exit(this);
    }

    public synchronized void b(String r10, ArrayList<NativeSpan> r11) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f12720c == false) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (this.f12719b == false) goto L21;
        boolean r12 = true;
        Iterator<NativeSpan> r13 = r11.iterator();     // Catch: Throwable -> L23
    L9:
        if (r13.hasNext() == false) goto L19;
        NativeSpan r14 = r13.next();     // Catch: Throwable -> L23
        if (r14 == null) goto L9;
        c r15 = r14.parseToSpan(this.f12718a);     // Catch: Throwable -> L23
        if (r12 == false) goto L17;
        r15.b(Long.parseLong(r10));     // Catch: Throwable -> L23
    L17:
        r15.c(r14.getStartTime(), r14.getFinishTime());     // Catch: Throwable -> L23
        r12 = false;
        goto L9
    L19:
        monitor-exit(this);
    }
}
