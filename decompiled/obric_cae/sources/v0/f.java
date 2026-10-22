package v0;

import android.content.Context;
import com.obric.cae.CaeApplication;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12691b;

    public /* synthetic */ f(Context r8, int r10) {
        this.f12690a = r10;
        this.f12691b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f12690a;
        Context r10 = this.f12691b;
        switch(r8) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        CaeApplication.e(r10);
        return;
    L7:
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new androidx.appcompat.app.g(r10, 1));
        return;
    L9:
        CaeApplication.a(r10);
    }
}
