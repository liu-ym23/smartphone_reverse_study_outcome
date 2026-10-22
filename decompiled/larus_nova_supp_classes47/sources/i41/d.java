package i41;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.livesdk.link.model.RandomMatchStrategy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ boolean e;

    public d(a r1, Function1 r2, int r3, long r4, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void accept(Object r18) {
        ApiServerException r10 = (Throwable) r18;
        Function1 r1 = this.b;
        boolean r12 = false;
        if (r1 == null) goto L9;
        String r3 = this.a.d;
        long r4 = RandomMatchStrategy.Normal.ordinal();
        if (this.c != 13) goto L7;
        boolean r6 = true;
    L8:
        Unit r2 = (Unit) r1.invoke(new com.bytedance.android.live.revlink.impl.pk.vm.linkout.p(r3, r4, r6));
        goto L9
    L7:
        r6 = false;
    L9:
        h41.b.a(r10);
        a r13 = this.a;
        long r5 = this.d;
        boolean r14 = this.e;
        com.bytedance.android.live.revlink.impl.global.c r7 = r13.k;
        if (r7 == null) goto L12;
        LiveFullLinkPKMonitor r8 = r7.getLiveFullLinkPKMonitor();
    L13:
        if (r8 == null) goto L15;
        i97.a r9 = i97.a.a;
        LiveFullLinkPKMonitor.r(r8, "linkmic/battle/auto_match", r10, System.currentTimeMillis() - r5, 0, 0, null, 56);
    L15:
        Disposable r15 = r13.e;
        if (r15 == null) goto L18;
        r15.dispose();
        r13.e = null;
    L18:
        Disposable r16 = r13.i;
        if (r16 == null) goto L22;
        r16.dispose();
        r13.i = null;
    L22:
        if ((r10 instanceof ApiServerException) == false) goto L47;
        ApiServerException r17 = r10;
        if (r17.getErrorCode() != 31012) goto L34;
        r31.a r19 = r13.c();
        if (r19 == null) goto L43;
        Observable<ExtraResponse<bf2.a, Extra>> r20 = r19.getLatestBanRecord(14);
        if (r20 == null) goto L43;
        int r22 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r23 = r20.subscribeOn(Schedulers.io());
        if (r23 == null) goto L43;
        Observable r24 = r23.observeOn(AndroidSchedulers.mainThread());
        if (r24 == null) goto L43;
        r24.subscribe(new e(r13), new f(r13));
    L43:
        Iterator r25 = ((ArrayList) r13.a).iterator();
    L45:
        if (r25.hasNext() == false) goto L51;
        p r26 = (p) r25.next();
        r26.Bl();
        r26.qn(r14, r12, AutoMatchSource.APIServerError);
        goto L45
    L51:
        return;
    L34:
        String r27 = r17.getPrompt();
        if (r27 != null) goto L37;
    L42:
        r12 = true;
        goto L43
    L37:
        if (r27.length() <= 0) goto L39;
        boolean r28 = true;
    L40:
        if (r28 != true) goto L42;
        int r29 = ToastUtil.a;
        ToastUtil.b(r17.getPrompt(), 0);
        goto L43
    L39:
        r28 = false;
        goto L40
    L47:
        Iterator r30 = ((ArrayList) r13.a).iterator();
    L49:
        if (r30.hasNext() == false) goto L54;
        ((p) r30.next()).qn(r14, false, AutoMatchSource.APIClientError);
        goto L49
    L54:
        return;
    L12:
        r8 = null;
        goto L13
    }
}
