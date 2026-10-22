package h40;

import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ c a;
    public final /* synthetic */ Throwable b;

    public b(c r1, Throwable r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r5) {
        Integer r6 = (Integer) r5;
        Intrinsics.checkNotNullParameter(r6, "retryCount");
        if (Intrinsics.compare(r6.intValue(), this.a.a.a) < 0) goto L5;
    L19:
        l r7 = l.a;
        return Observable.error(this.b);
    L5:
        if (this.a.a.b == null) goto L19;
        Throwable r0 = this.b;
        int r8 = r6.intValue();
        Intrinsics.checkNotNullParameter(r0, "t");
        jy0.b.f("ObservableRetryFunction", "exception=" + r0.getMessage() + " retryCount=" + r8, null, 4);
        Intrinsics.checkNotNullParameter(r0, "$this$networkErrorCode");
        if ((r0 instanceof NetworkErrorException) == false) goto L9;
        int r9 = ((NetworkErrorException) r0).getStatusCode();
    L11:
        if (500 <= r9) goto L13;
    L16:
        boolean r11 = true;
    L17:
        if (r11 != true) goto L19;
        l r12 = l.a;
        long r1 = this.a.a.c;
        int r13 = p.a;
        return Observable.timer(r1, TimeUnit.MILLISECONDS, Schedulers.computation());
    L13:
        if (599 < r9) goto L16;
        r11 = false;
        goto L17
    L9:
        r9 = -1;
        goto L11
    }
}
