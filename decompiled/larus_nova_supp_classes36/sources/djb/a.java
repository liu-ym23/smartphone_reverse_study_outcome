package djb;

import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a implements xwa.b, bxa.a.a {
    public final IAppStateSyncService a;
    public final CopyOnWriteArraySet<xwa.b.a> b;
    public bxa.a c;

    /* JADX INFO: renamed from: djb.a$a, reason: collision with other inner class name */
    public static final class C0250a implements y {
        public final /* synthetic */ a a;

        public C0250a(a r1) {
            this.a = r1;
        }

        public final void f(y.a r2, y.a r3) {
            Intrinsics.checkNotNullParameter(r2, "oldState");
            Intrinsics.checkNotNullParameter(r3, "newState");
            a r4 = this.a;
            bxa.a r5 = r4.c;
            if (r5 == null) goto L5;
            r5.I1(r4);
        L5:
            bxa.a r6 = OfficeSDKManager.getHostGlobalService(bxa.a.class);
            r4.c = r6;
            if (r6 == null) goto L9;
            r6.h0(r4);
        L9:
            if (r4.c == null) goto L11;
            boolean r7 = true;
        L12:
            if (r7 == false) goto L15;
            com.ss.android.lark.appcontext.applifecycle2.api.a.d(this);
            Log.i("OfficeBatteryMonitor", "registerDozeModeCallback success");
            return;
        L15:
            return;
        L11:
            r7 = false;
            goto L12
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean a() {
        bxa.a r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.l1() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Inject
    public a(IAppStateSyncService r2) {
        Intrinsics.checkNotNullParameter(r2, "appStateSyncService");
        this.a = r2;
        this.b = new CopyOnWriteArraySet();
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(new C0250a(this));
    }

    public final void onStateChanged(boolean r3) {
        Log.i("OfficeBatteryMonitor", "onStateChanged, isDozeMode=" + r3);
        this.a.c(r3);
        Iterator<xwa.b.a> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        xwa.b.a r1 = r0.next();
        if (r3 == true) goto L7;
        r1.a();
        goto L4
    L7:
        r1.b();
        goto L4
    }
}
