package d40;

import a40.d;
import a40.k;
import a40.o;
import android.os.SystemClock;
import com.bytedance.android.live.cloudgrouplive.api.CloudGroupLiveApi;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.c;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public Disposable a;
    public final k b;

    /* JADX INFO: renamed from: d40.a$a, reason: collision with other inner class name */
    public static final class C0223a {
    }

    public static final class b implements o {
        public final /* synthetic */ a a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        @Override // a40.o
        public final void a(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
        }

        @Override // a40.o
        public final void onPingSuccess() {
            a r0 = this.a;
            r0.a = Observable.timer(20, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new d40.b(this));
        }

        public b(a r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    static {
    }

    public final void b() {
        int r0 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.PING_MANAGER, "stopPing", 0, null, 28);
        Disposable r1 = this.a;
        if (r1 == null) goto L6;
        r1.dispose();
        return;
    }

    public a(k r1) {
        this.b = r1;
    }

    public final void a(long r8, long r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "source");
        if (this.b != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r12, "join_success") == false) goto L8;
        int r0 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.PING_MANAGER, "startPing", 0, "cloudGroupLiveRoomId=" + r8 + ", userRoomId=" + r11, 20);
    L8:
        ALogger.i("CloudGroupLivePingManager", "startPing source=".concat(r12));
        k r13 = this.b;
        b r6 = new b(this, r8, r11);
        r13.getClass();
        long r1 = SystemClock.elapsedRealtime();
        RxUtilKt.c(((CloudGroupLiveApi) c.b().e(CloudGroupLiveApi.class)).cloudGroupLivePing(r8, r11).compose(RxUtil.rxSchedulerHelper()).subscribe(new a40.c(r6, r1), new d(r6, r1)), r13.a);
    }
}
