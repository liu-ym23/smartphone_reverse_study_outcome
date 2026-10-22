package tqa;

import android.content.Context;
import com.bytedance.common.support.PushCommonSupport;
import com.ss.alive.monitor.services.impl.AssociationStartMonitorEventServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements b {
    public static volatile a b;
    public static volatile rqa.a c;
    public static volatile AssociationStartMonitorEventServiceImpl d;
    public Context a;

    public static b c() {
        if (b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public final sqa.a a() {
        if (d != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (d != null) goto L12;
        Context r1 = this.a;     // Catch: Throwable -> L14
        if (r1 != null) goto L11;
        r1 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication;     // Catch: Throwable -> L14
    L11:
        d = new AssociationStartMonitorEventServiceImpl(r1);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
    L18:
        return d;
    }

    public a() {
    }

    public final sqa.b b(Context r2) {
        this.a = r2;
        if (c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (c != null) goto L8;
        c = new rqa.a(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return c;
    }
}
