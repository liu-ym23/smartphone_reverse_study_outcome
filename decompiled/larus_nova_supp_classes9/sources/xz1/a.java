package xz1;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.revenue.network.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import cy0.e;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import mz0.i;
import mz0.n;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends com.bytedance.android.livesdk.revenue.network.a implements o, c {
    public final CompositeDisposable a;
    public int b;
    public int c;
    public final PublishSubject<Integer> d;
    public final PublishSubject<Integer> e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;
    public final INetworkService j;

    /* JADX INFO: renamed from: xz1.a$a, reason: collision with other inner class name */
    public static final class C0298a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0298a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.b += ((Integer) r3).intValue();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.c += ((Integer) r3).intValue();
        }
    }

    public final void onStop() {
        this.a.dispose();
        if (xz1.b.a() == true) goto L5;
        return;
    L5:
        this.j.K0(INetworkService.Biz.Revenue, this);
        if (this.b != this.c) goto L8;
        return;
    L8:
        k r1 = f.d(j.C0.a(), k.class);
        if (r1 == null) goto L13;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L13;
        long r3 = r2.getId();
    L14:
        if (r1 == null) goto L19;
        IBaseUser r4 = r1.getUser();
        if (r4 == null) goto L19;
        String r5 = r4.getIdString();
        if (r5 == null) goto L19;
    L21:
        if (v.a() == false) goto L23;
        f2.c("GiftExtra request frequency error!", 0);
    L23:
        String r6 = this.g;
        n r7 = new n();
        Map r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        String r9 = String.valueOf(r3);
        Intrinsics.checkNotNullParameter("room_id", "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        r8.put("room_id", r9);
        Intrinsics.checkNotNullParameter("user_id", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        r8.put("user_id", r5);
        String r13 = String.valueOf(this.b);
        Intrinsics.checkNotNullParameter("extra_request_posted_count", "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        r8.put("extra_request_posted_count", r13);
        String r14 = String.valueOf(this.c);
        Intrinsics.checkNotNullParameter("extra_action_count", "key");
        Intrinsics.checkNotNullParameter(r14, "value");
        r8.put("extra_action_count", r14);
        e.a.getClass();
        cy0.j r10 = e.a.a;
        m.e.getClass();
        Object r15 = m.b(r10).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r15);
        ((f80.a) r15).w3(r6, r7.a, r7.b);
        String r11 = this.h;
        JSONObject r16 = new JSONObject();
        JSONObject r17 = new JSONObject();
        JSONObject r18 = new JSONObject();
        Intrinsics.checkNotNullParameter(r18, "extra");
        Intrinsics.checkNotNullParameter(r17, "metric");
        EventModule r19 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r19, "eventModule");
        String r110 = r19.getValue();
        r17.put("status", String.valueOf(this.i));
        Intrinsics.checkNotNullParameter(r16, "map");
        if (this.b <= this.c) goto L26;
        Intrinsics.checkNotNullParameter("error_type", "key");
        Intrinsics.checkNotNullParameter("extra_request_posted_exceed", "value");
        r16.put("error_type", "extra_request_posted_exceed");
    L27:
        Intrinsics.checkNotNullParameter(r18, "map");
        Long r20 = Long.valueOf(r3);
        Intrinsics.checkNotNullParameter("room_id", "key");
        Intrinsics.checkNotNullParameter(r20, "value");
        r18.put("room_id", r20);
        Intrinsics.checkNotNullParameter("user_id", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        r18.put("user_id", r5);
        Integer r21 = Integer.valueOf(this.b);
        Intrinsics.checkNotNullParameter("extra_request_posted_count", "key");
        Intrinsics.checkNotNullParameter(r21, "value");
        r18.put("extra_request_posted_count", r21);
        Integer r23 = Integer.valueOf(this.c);
        Intrinsics.checkNotNullParameter("extra_action_count", "key");
        Intrinsics.checkNotNullParameter(r23, "value");
        r18.put("extra_action_count", r23);
        Object r24 = m.b(r10).b(n97.a.class);
        Intrinsics.checkNotNull(r24);
        ((com.bytedance.live.kmp.core.c) r24).g(r11, r110, "bussiness_api_call", r16, r17, r18);
        return;
    L26:
        Intrinsics.checkNotNullParameter("error_type", "key");
        Intrinsics.checkNotNullParameter("extra_request_action_exceed", "value");
        r16.put("error_type", "extra_request_action_exceed");
    L19:
        r5 = BuildConfig.FLAVOR;
    L13:
        r3 = 0;
        goto L14
    }

    @Override // xz1.c
    public final void a() {
        if (xz1.b.a() == true) goto L5;
        return;
    L5:
        this.d.onNext(1);
    }

    @Override // xz1.c
    public final void f() {
        if (xz1.b.a() == true) goto L5;
        return;
    L5:
        this.e.onNext(1);
    }

    public final void onStart() {
        if (xz1.b.a() == true) goto L5;
        return;
    L5:
        RxUtilKt.c(this.e.subscribeOn(AndroidSchedulers.mainThread()).subscribe(new C0298a(this)), this.a);
        RxUtilKt.c(this.d.subscribeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), this.a);
        this.j.s(INetworkService.Biz.Revenue, this);
    }

    public a(INetworkService r2) {
        Intrinsics.checkNotNullParameter(r2, "networkService");
        this.j = r2;
        this.a = new CompositeDisposable();
        this.d = PublishSubject.create();
        this.e = PublishSubject.create();
        this.f = "gift/extra/";
        this.g = "livesdk_gift_extra_frequency_error";
        this.h = "ttlive_gift_extra_frequency_error";
        this.i = 1;
    }

    public final d x(String r5, d r6) {
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "originalRequest");
        if (xz1.b.a() == true) goto L5;
    L8:
        return r6;
    L5:
        if (StringsKt.contains$default(r5, this.f, false, 2, null) == false) goto L8;
        this.e.onNext(1);
        goto L8
    }
}
