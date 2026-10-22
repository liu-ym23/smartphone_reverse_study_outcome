package x72;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.o0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.common.utility.Lists;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements b {
    public h() {
    }

    @Override // x72.b
    public final boolean a(a r4, k32.a r5) {
        if (r5 == null) goto L12;
        va.a r0 = r5.k;
        if (r0 == null) goto L12;
        if (r0.getText() == null) goto L12;
        a5 r1 = r0.getText();
        if (Lists.isEmpty(sb2.a.d(r1)) == true) goto L12;
        ALogger.d("TextParseInterceptor", "intercept message due to downloading img");
        new o0().a(sb2.a.d(r1), new f(this, r4, r5));
        return true;
    L12:
        return r4.a(r5);
    }

    public static void b(h r1, b.a r2, k32.a r3) {
        r1.getClass();
        Observable.just(0).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r2, r3));
    }
}
