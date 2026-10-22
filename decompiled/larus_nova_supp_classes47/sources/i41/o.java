package i41;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.r4;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ long b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ Function1 j;

    public o(a r1, long r2, boolean r4, boolean r5, int r6, int r7, String r8, String r9, Function1 r10) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = "";
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public final void accept(Object r32) {
        a r14 = this.a;
        long r2 = this.b;
        long r9 = ((Long) r32).longValue();
        boolean r1 = this.c;
        String r12 = this.d;
        boolean r8 = this.e;
        int r13 = this.f;
        int r4 = this.g;
        String r5 = this.h;
        String r6 = this.i;
        Function1 r15 = this.j;
        if (r9 != r14.b) goto L5;
        int r7 = 1;
    L6:
        i97.a r10 = i97.a.a;
        long r29 = System.currentTimeMillis();
        if (r13 != 0) goto L9;
        int r19 = 1;
    L10:
        r31.a r16 = r14.c();
        if (r16 == null) goto L22;
        int r17 = r14.c;
        String r0 = r14.d;
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        Observable<ExtraResponse<r4, com.bytedance.android.livesdk.link.model.a>> r3 = r16.t(r2, r7, r19, 0, r1, r12, r17, null, r4, r0, r5, r6);
        if (r3 == null) goto L22;
        int r18 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r20 = r3.subscribeOn(Schedulers.io());
        if (r20 == null) goto L22;
        Observable r22 = r20.observeOn(AndroidSchedulers.mainThread());
        if (r22 == null) goto L22;
        Disposable r23 = r22.subscribe(new c(r14, r7, r15, r13, r1, r8, r9, r12, r29), new d(r14, r15, r13, r29, r1));
    L23:
        r14.j = r23;
        return;
    L22:
        r23 = null;
        goto L23
    L9:
        r19 = r13;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }
}
