package qw0;

import android.os.SystemClock;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.v;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.t;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<Upstream, Downstream> implements t {
    public final /* synthetic */ List a;
    public final /* synthetic */ int b;

    public static final class a<V> implements Callable {
        public final /* synthetic */ b a;
        public final /* synthetic */ Single b;

        /* JADX INFO: renamed from: qw0.b$a$a, reason: collision with other inner class name */
        public static final class C0304a<T> implements Consumer {
            public final /* synthetic */ a a;
            public final /* synthetic */ long b;

            public C0304a(a r1, long r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(T r6) {
                int r7 = c.a;
                long r0 = SystemClock.uptimeMillis() - this.b;
                b r8 = this.a.a;
                List r2 = r8.a;
                int r9 = r8.b;
                HashMap r3 = new HashMap();
                c.a(r3);
                r3.put("cost", String.valueOf(r0));
                r3.put("from", String.valueOf(r9));
                r3.put("price_list", new JSONArray(r2).toString());
                r3.put("status", DataType.FALSE);
                LiveSlardarMonitor.monitorStatus("ttlive_recharge_query_pre_pay_cashier_info_all", 0, r3);
                int r1 = v.a;
                v.d("ttlive_recharge_query_pre_pay_cashier_info_all", r3);
            }
        }

        /* JADX INFO: renamed from: qw0.b$a$b, reason: collision with other inner class name */
        public static final class C0305b<T> implements Consumer {
            public final /* synthetic */ a a;
            public final /* synthetic */ long b;

            public C0305b(a r1, long r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r7) {
                ApiException r8 = (Throwable) r7;
                int r0 = c.a;
                long r1 = SystemClock.uptimeMillis() - this.b;
                b r2 = this.a.a;
                List r3 = r2.a;
                int r4 = r2.b;
                HashMap r5 = new HashMap();
                r5.put("cost", String.valueOf(r1));
                r5.put("from", String.valueOf(r4));
                r5.put("price_list", new JSONArray(r3).toString());
                r5.put("status", DataType.TRUE);
                c.a(r5);
                if (r8 != null) goto L5;
            L8:
                LiveSlardarMonitor.monitorStatus("ttlive_recharge_query_pre_pay_cashier_info_all", 1, r5);
                int r9 = v.a;
                v.d("ttlive_recharge_query_pre_pay_cashier_info_all", r5);
                return;
            L5:
                if ((r8 instanceof ApiException) == false) goto L7;
                r5.put("error_code", String.valueOf(r8.getErrorCode()));
            L7:
                r5.put("error_message", String.valueOf(r8.getMessage()));
                goto L8
            }
        }

        public a(b r1, Single r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.concurrent.Callable
        public final SingleSource<Object> call() {
            long r0 = SystemClock.uptimeMillis();
            return this.b.doOnSuccess(new C0304a(this, r0)).doOnError(new C0305b(this, r0));
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public b(List r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final SingleSource<Object> apply(Single<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "upstream");
        return Single.defer(new a(this, r2));
    }
}
