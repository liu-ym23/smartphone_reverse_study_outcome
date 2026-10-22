package a9;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.ies.bullet.service.monitor.standard.ContainerStandardMonitor;
import l9.l;
import org.json.JSONObject;
import sj.k;
import z8.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f148c;
    public final /* synthetic */ String d;

    public /* synthetic */ a(String r5, String r10, String r11, int r12) {
        this.f146a = r12;
        this.f147b = r5;
        this.f148c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f146a) {
            case 0: goto L14;
            default: goto L12;
        };
    L12:
        ContainerStandardMonitor.INSTANCE.addContext(this.f147b, this.f148c, this.d);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L14:
        c r5 = c.d(n.f4057a, this.f147b, this.f148c, this.d);     // Catch: Throwable -> L8
        c r10 = l.f().g(CrashType.GAME, r5, null, false);     // Catch: Throwable -> L8
        k r11 = k.g();     // Catch: Throwable -> L8
        JSONObject r12 = r10.f23416a;     // Catch: Throwable -> L8
        r11.getClass();     // Catch: Throwable -> L8
        k.l(r12);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
    }
}
