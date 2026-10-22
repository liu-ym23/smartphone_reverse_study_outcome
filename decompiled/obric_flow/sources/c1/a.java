package c1;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f1101b;

    public /* synthetic */ a(Runnable r5, int r10, boolean r11) {
        this.f1100a = r10;
        this.f1101b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable r5 = this.f1101b;
        switch(this.f1100a) {
            case 0: goto L30;
            case 1: goto L19;
            case 2: goto L26;
            default: goto L4;
        };
    L4:
        if (r5 == null) goto L33;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        r5.run();     // Catch: Throwable -> L8
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L32;
        ConcurrentHashMap r13 = tl.b.f22138a;
        tl.b.b("SafeWrapper", "fail to execute runnable = " + r5 + " error = " + Log.getStackTraceString(r12));
        return;
    L32:
        return;
    L8:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L10
    L33:
        return;
    L19:
        Process.setThreadPriority(10);
        r5.run();
        return;
    L26:
        r5.run();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        h.g("default_handle", e);
        return;
    L30:
        r5.run();     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        String r15 = "fail to execute runnable = " + r5 + " error = " + Log.getStackTraceString(e);
        Intrinsics.checkNotNullParameter("SafeWrapper", "tag");
        Intrinsics.checkNotNullParameter(r15, "msg");
        a1.a.f43a.e("SafeWrapper", r15, null);
    }

    public a(Runnable r5, int r10) {
        this.f1100a = r10;
        switch(r10) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "target");
        this.f1101b = r5;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "realRunnable");
        this.f1101b = r5;
    }
}
