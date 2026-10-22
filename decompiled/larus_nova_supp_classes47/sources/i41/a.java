package i41;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final List<p> a;
    public int b;
    public int c;
    public String d;
    public Disposable e;
    public boolean f;
    public String g;
    public int h;
    public Disposable i;
    public Disposable j;
    public final com.bytedance.android.live.revlink.impl.global.c k;

    /* JADX INFO: renamed from: i41.a$a, reason: collision with other inner class name */
    public static final class C0250a {
    }

    static {
    }

    public final r31.a c() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkNetwork();
    }

    public a(LinkFakeGlobalService r1) {
        this.k = r1;
        this.h = 1;
        this.b = 10000;
        this.a = new ArrayList();
    }

    public final void a(p r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        int r1 = ((ArrayList) this.a).size();
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (((ArrayList) this.a).size() >= r1) goto L5;
        r1 = ((ArrayList) this.a).size();
    L5:
        ListProtector.add(this.a, r1, r3);
    }

    public final void b(AutoMatchSource r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter("", "activityName");
        Intrinsics.checkNotNullParameter(r5, "source");
        if (r41.b.a == true) goto L5;
        this.d = "";
        if (this.f == false) goto L57;
        boolean r0 = false;
        this.f = false;
        Disposable r2 = this.e;
        if (r2 == null) goto L16;
        r2.dispose();
        this.e = null;
    L16:
        Disposable r3 = this.j;
        if (r3 == null) goto L19;
        r3.dispose();
        this.j = null;
    L19:
        Disposable r4 = this.i;
        if (r4 == null) goto L22;
        r4.dispose();
        this.i = null;
    L22:
        String r6 = this.g;
        if (r6 != null) goto L25;
    L26:
        r0 = true;
    L27:
        if (r0 == true) goto L36;
        r31.a r1 = c();
        if (r1 == null) goto L51;
        String r7 = this.g;
        Intrinsics.checkNotNull(r7);
        Observable r8 = r1.s(r7, 12);
        if (r8 == null) goto L51;
        int r9 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r10 = r8.subscribeOn(Schedulers.io());
        if (r10 == null) goto L51;
        r10.subscribe(h.a, i.a);
    L51:
        Iterator r12 = ((ArrayList) this.a).iterator();
    L53:
        if (r12.hasNext() == false) goto L60;
        ((p) r12.next()).F8(r5);
        goto L53
    L60:
        return;
    L36:
        if (this.h < 0) goto L44;
        r31.a r13 = c();
        if (r13 == null) goto L51;
        Observable r14 = r13.s("", this.h);
        if (r14 == null) goto L51;
        int r15 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r16 = r14.subscribeOn(Schedulers.io());
        if (r16 == null) goto L51;
        r16.subscribe(j.a, k.a);
        goto L51
    L44:
        r31.a r17 = c();
        if (r17 == null) goto L51;
        Observable r18 = r17.b();
        if (r18 == null) goto L51;
        int r19 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r20 = r18.subscribeOn(Schedulers.io());
        if (r20 == null) goto L51;
        r20.subscribe(l.a, m.a);
        goto L51
    L25:
        if (r6.length() != 0) goto L27;
    L57:
        return;
    L5:
        if (r5 != AutoMatchSource.ReceiveMultiInviteWhenMatching) goto L8;
        return;
    L8:
        if (this.f == false) goto L59;
        JSONObject r22 = new JSONObject();
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r24);
        ((vy0.b) ((f80.a) r24)).sendEventToAllJsBridges("H5_stopAutoMatch", r22);
        return;
    }

    public static /* synthetic */ void e(a r10, long r12, boolean r13) {
        r10.d(r12, r13, false, 0, 0, "", "", null);
    }

    public final void d(long r19, boolean r22, boolean r23, int r24, int r25, String r26, String r27, Function1 r28) {
        String r9 = r27;
        Intrinsics.checkNotNullParameter("", "activityName");
        Intrinsics.checkNotNullParameter(r26, "activityId");
        if (r41.b.a == false) goto L10;
        long r3 = r24;
        if (r9 != null) goto L7;
        r9 = "";
    L7:
        JSONObject r2 = new JSONObject();
        r2.put("match_type", r3);
        r2.put("game_id", r9);
        r2.put("sub_type", 0);
        r2.put("default_limit_time", 60);
        r2.put("accelerate_limit_time", 15);
        r2.put("invite_limit_time", 10);
        r2.put("wait_time_level", 0);
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r1);
        ((vy0.b) ((f80.a) r1)).sendEventToAllJsBridges("H5_startAutoMatch", r2);
        return;
    L10:
        if (this.f == false) goto L12;
        return;
    L12:
        this.g = r9;
        this.h = r24;
        this.c = 0;
        this.f = true;
        Iterator r4 = ((ArrayList) this.a).iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        ((p) r4.next()).aq();
        goto L14
    L16:
        Disposable r5 = this.e;
        if (r5 == null) goto L19;
        r5.dispose();
        this.e = null;
    L19:
        Disposable r6 = this.i;
        if (r6 == null) goto L22;
        r6.dispose();
        this.i = null;
    L22:
        this.b = 10000;
        if (r22 == false) goto L25;
        x41.a r7 = x41.a.f;
        r7.getClass();
        this.b = ((Number) x41.a.b.getValue(r7, x41.a.a[0])).intValue();
        int r8 = 1;
    L26:
        int r10 = r8 * WebcastRedirectException.UNKNOWN;
        com.bytedance.revenue.platform.api.core.rx.l r12 = com.bytedance.revenue.platform.api.core.rx.l.a;
        long r14 = r10;
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.e = Observable.interval(0, r14, TimeUnit.MILLISECONDS, Schedulers.computation()).take(this.b + 1).map(new n(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this, r19, r22, r23, r24, r25, r26, r27, r28));
        return;
    L25:
        r8 = 3;
        goto L26
    }
}
