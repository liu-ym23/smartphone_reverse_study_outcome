package com.bytedance.android.live.revenuelink.rtc;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.anchorlink.linksecurity.LinkSecurityApi;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public final CompositeDisposable a;
    public final IRoom b;
    public final com.bytedance.android.live.revenuelink.withroom.a c;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final void a(String r14) {
        Intrinsics.checkNotNullParameter(r14, "reqSrc");
        String r2 = null;
        if (((Boolean) g11.a.e.getValue(null, g11.a.a[3])).booleanValue() == true) goto L5;
        return;
    L5:
        long r6 = IRoomKtKt.getId(this.b);
        com.bytedance.android.live.revenuelink.connect.f r0 = this.c.Z0();
        if (r0 == null) goto L10;
        LiveData<ey.f> r1 = r0.connectState();
        if (r1 == null) goto L10;
        ey.f r3 = (ey.f) r1.getValue();
    L11:
        if (r3 == null) goto L13;
        String r4 = r3.e;
    L14:
        long r5 = 0;
        if (r3 == null) goto L17;
        long r8 = r3.a;
    L18:
        f r7 = this.c.m0();
        if (r7 == null) goto L23;
        i r9 = r7.getRtcManager();
        if (r9 == null) goto L23;
        r5 = r9.getMixType();
    L23:
        long r10 = r5;
        f r12 = this.c.m0();
        if (r12 == null) goto L31;
        i r13 = r12.getRtcManager();
        if (r13 == null) goto L31;
        String r15 = r13.getRtcExtInfo();
        if (r15 == null) goto L31;
        r2 = r15;
    L33:
        String r16 = "";
        if (r2 != null) goto L37;
        r2 = "";
    L37:
        if (r2.length() != 0) goto L39;
        boolean r17 = true;
    L40:
        if (r17 == false) goto L42;
        return;
    L42:
        e11.b r18 = e11.c.a(e11.b.a);
        if (r4 == null) goto L46;
        r16 = r4;
    L46:
        Observable<ExtraResponse<Object, Extra>> r19 = ((e11.a) r18).b(r8, r6, r16, r2, r10, r14);
        int r20 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.a.add(r19.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(a.a, b.a));
        return;
    L39:
        r17 = false;
    L31:
        if (r3 == null) goto L33;
        r2 = r3.f;
        goto L33
    L17:
        r8 = 0;
        goto L18
    L13:
        r4 = null;
    L10:
        r3 = null;
        goto L11
    }

    public l(IRoom r2, com.bytedance.android.live.revenuelink.withroom.a r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "storeService");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
        LinkSecurityApi.VideoCaptureType r4 = LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_DEVICE_UNKNOWN;
    }
}
