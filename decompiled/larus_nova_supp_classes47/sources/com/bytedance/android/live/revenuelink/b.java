package com.bytedance.android.live.revenuelink;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.anchorlink.linksecurity.LinkSecurityApi;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.t3;
import com.bytedance.android.livesdk.link.model.u3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.revenue.platform.api.core.rx.p;
import fr2.i0;
import fr2.k1;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.live.revenuelink.e {
    public final CompositeDisposable b;
    public final List<String> c;
    public long d;
    public boolean e;
    public final com.bytedance.android.live.revenuelink.withroom.a f;
    public final yz0.g g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.b$b, reason: collision with other inner class name */
    public static final class C0107b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0107b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            if (r7 != null) goto L5;
            return;
        L5:
            if (((u3) r7.data).getSleepTime() <= 1) goto L7;
            b r0 = this.a;
            r0.d = ((u3) r7.data).getSleepTime();
        L7:
            b.c(this.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            b.c(this.a);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            if (r7 == null) goto L5;
            t3 r8 = (t3) r7.data;
        L6:
            if (r8 != null) goto L8;
        L10:
            b.c(this.a);
            return;
        L8:
            if (r8.getSleepSecond() <= 1) goto L10;
            b r0 = this.a;
            r0.d = r8.getSleepSecond();
            goto L10
        L5:
            r8 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ b a;

        public e(b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            b.c(this.a);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revenuelink.e
    public final void dispose() {
        this.e = false;
        ((CopyOnWriteArrayList) this.c).clear();
        if (this.b.isDisposed() == true) goto L6;
        this.b.dispose();
        return;
    }

    public static final void c(b r4) {
        r4.getClass();
        com.bytedance.revenue.platform.api.core.rx.l r0 = com.bytedance.revenue.platform.api.core.rx.l.a;
        long r1 = r4.d * ((long) WebcastRedirectException.UNKNOWN);
        int r2 = p.a;
        Scheduler r3 = Schedulers.computation();
        Disposable r5 = Observable.timer(r1, TimeUnit.MILLISECONDS, r3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revenuelink.c(r4), com.bytedance.android.live.revenuelink.d.a);
        r4.b.add(r5);
    }

    public static String d(List r4) {
        StringBuilder r0 = new StringBuilder();
        Iterator r5 = ((CopyOnWriteArrayList) r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.append((String) r5.next());
        r0.append(",");
        goto L4
    L6:
        String r6 = r0.toString();
        if (StringsKt.endsWith$default(r6, ",", false, 2, null) == true) goto L9;
        return r6;
    L9:
        return r6.substring(0, r6.length() - 1);
    }

    @Override // com.bytedance.android.live.revenuelink.e
    public final void a(boolean r1) {
        this.e = r1;
    }

    @Override // com.bytedance.android.live.revenuelink.e
    public final void b(String r33) {
        Intrinsics.checkNotNullParameter(r33, "reqSource");
        h11.a r2 = h11.a.f;
        r2.getClass();
        if (((Boolean) h11.a.d.getValue(r2, h11.a.a[2])).booleanValue() == true) goto L5;
        return;
    L5:
        IRoomBase r3 = this.g.mo444getRoom();
        this.g.getUser();
        if (this.g.isAnchor() == true) goto L8;
        return;
    L8:
        com.bytedance.android.live.revenuelink.connect.f r4 = this.f.Z0();
        if (r4 == null) goto L13;
        LiveData<ey.f> r5 = r4.connectState();
        if (r5 == null) goto L13;
        ey.f r6 = (ey.f) r5.getValue();
    L14:
        if (r6 == null) goto L16;
        long r7 = r6.a;
    L17:
        boolean r9 = false;
        if (this.f.m0() == null) goto L51;
        com.bytedance.android.live.revenuelink.rtc.f r8 = this.f.m0();
        if (r8 == null) goto L22;
        com.bytedance.android.live.revenuelink.rtc.i r10 = r8.getRtcManager();
    L23:
        if (r10 == null) goto L51;
        com.bytedance.android.live.revenuelink.rtc.f r12 = this.f.m0();
        if (r12 == null) goto L29;
        com.bytedance.android.live.revenuelink.rtc.i r13 = r12.getRtcManager();
        if (r13 == null) goto L29;
        vc0.a r14 = r13.getLiveCore();
    L30:
        if (r14 == null) goto L51;
        com.bytedance.android.live.revenuelink.rtc.f r15 = this.f.m0();
        if (r15 == null) goto L36;
        com.bytedance.android.live.revenuelink.rtc.i r16 = r15.getRtcManager();
        if (r16 == null) goto L36;
        r16.getLiveCore();
    L36:
        com.bytedance.android.live.revenuelink.rtc.f r17 = this.f.m0();
        if (r17 == null) goto L41;
        com.bytedance.android.live.revenuelink.rtc.i r18 = r17.getRtcManager();
        if (r18 == null) goto L41;
        vc0.a r19 = r18.getLiveCore();
    L42:
        if (r19 == null) goto L44;
        fr2.p r20 = i0.a(r19);
    L45:
        if (r20 == null) goto L51;
        if (r20.getBuilder() == null) goto L51;
        k1 r22 = r20.getBuilder();
        if (r22 == null) goto L51;
        int r23 = r22.e();
    L53:
        if (r23 == 0) goto L61;
        if (r23 == 1) goto L60;
        if (r23 == 2) goto L60;
        if (r23 == 5) goto L59;
        LinkSecurityApi.VideoCaptureType r24 = LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_DEVICE_UNKNOWN;
    L62:
        int r25 = r24.ordinal();
        String r110 = "";
        if (this.f.m0() == null) goto L82;
        com.bytedance.android.live.revenuelink.rtc.f r26 = this.f.m0();
        if (r26 == null) goto L67;
        com.bytedance.android.live.revenuelink.rtc.i r27 = r26.getRtcManager();
    L68:
        if (r27 == null) goto L82;
        com.bytedance.android.live.revenuelink.rtc.f r28 = this.f.m0();
        if (r28 == null) goto L74;
        com.bytedance.android.live.revenuelink.rtc.i r29 = r28.getRtcManager();
        if (r29 == null) goto L74;
        int r30 = r29.getMixType();
    L75:
        com.bytedance.android.live.revenuelink.rtc.f r111 = this.f.m0();
        if (r111 == null) goto L83;
        com.bytedance.android.live.revenuelink.rtc.i r112 = r111.getRtcManager();
        if (r112 == null) goto L83;
        String r113 = r112.getRtcExtInfo();
        if (r113 == null) goto L83;
    L85:
        if (r113.length() != 0) goto L87;
        r9 = true;
    L87:
        if (r9 == false) goto L92;
        if (r6 == null) goto L91;
        r113 = r6.f;
        if (r113 != null) goto L92;
    L91:
        r113 = "";
    L92:
        if (r6 == null) goto L97;
        String r32 = r6.e;
        if (r32 == null) goto L97;
        r110 = r32;
    L97:
        long r114 = r7;
        String r115 = r110;
        if (this.e == false) goto L125;
        if (e11.c.a == null) goto L120;
        long r34 = IRoomKtKt.getId(r3);
        String r35 = d(this.c);
        long r116 = r30;
        Intrinsics.checkNotNullParameter(r35, "linkmicIdList");
        Intrinsics.checkNotNullParameter(r33, "source");
        Intrinsics.checkNotNullParameter(r113, "rtcInfo");
        tz0.b r36 = tz0.b.a;
        uz0.c r37 = new uz0.c();
        r36.getClass();
        Intrinsics.checkNotNullParameter(r37, "$this$beforeConfigureRequest");
        Map<String, String> r38 = r37.b;
        Intrinsics.checkNotNullParameter(r38, "queriesMap");
        String r39 = Long.valueOf(r34).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r39 == null) goto L104;
        r38.put("room_id", r39);
    L104:
        Intrinsics.checkNotNullParameter("linkmic_id_list", "$this$setTo");
        if (r35 == null) goto L107;
        r38.put("linkmic_id_list", r35);
    L107:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r38.put("request_source", r33);
        String r1 = Long.valueOf(r116).toString();
        Intrinsics.checkNotNullParameter("mix_type", "$this$setTo");
        if (r1 == null) goto L110;
        r38.put("mix_type", r1);
    L110:
        Intrinsics.checkNotNullParameter("rtc_ext_info", "$this$setTo");
        r38.put("rtc_ext_info", r113);
        String r40 = Integer.valueOf(r25).toString();
        Intrinsics.checkNotNullParameter("video_capture_type", "$this$setTo");
        if (r40 == null) goto L113;
        r38.put("video_capture_type", r40);
    L113:
        Intrinsics.checkNotNullParameter(r37, "$this$afterConfigureRequest");
        Observable r42 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic_audience/check_linkers/", TypesJVMKt.getJavaType(Reflection.typeOf(u3.class)), Extra.class, r37.d, r37.a, r37.b, r37.c);
        if (r42 == null) goto L120;
        int r43 = p.a;
        Observable r44 = r42.subscribeOn(Schedulers.io());
        if (r44 == null) goto L120;
        Observable r45 = r44.observeOn(AndroidSchedulers.mainThread());
        if (r45 == null) goto L120;
        Disposable r46 = r45.subscribe(new C0107b(this), new c(this));
    L121:
        if (r46 == null) goto L139;
        this.b.add(r46);
    L139:
        return;
    L120:
        r46 = null;
        goto L121
    L125:
        if (e11.c.a == null) goto L134;
        long r117 = IRoomKtKt.getId(r3);
        String r47 = d(this.c);
        long r118 = r30;
        Intrinsics.checkNotNullParameter(r115, "ownerLinkmicId");
        Intrinsics.checkNotNullParameter(r47, "linkmicIdList");
        Intrinsics.checkNotNullParameter(r33, "source");
        Intrinsics.checkNotNullParameter(r113, "rtcInfo");
        tz0.b r48 = tz0.b.a;
        uz0.c r49 = new uz0.c();
        r48.getClass();
        Intrinsics.checkNotNullParameter(r49, "$this$beforeConfigureRequest");
        uz0.f r50 = new uz0.f(r49.b);
        r50.a("linker_id", Long.valueOf(r114).toString());
        r50.a("room_id", Long.valueOf(r117).toString());
        r50.a("owner_linkmic_id", r115);
        r50.a("linkmic_id_list", r47);
        r50.a("request_source", r33);
        r50.a("mix_type", Long.valueOf(r118).toString());
        r50.a("rtc_ext_info", r113);
        Intrinsics.checkNotNullParameter(r49, "$this$afterConfigureRequest");
        Observable r0 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/check_anchor_linkers/", TypesJVMKt.getJavaType(Reflection.typeOf(t3.class)), Extra.class, r49.d, r49.a, r49.b, r49.c);
        if (r0 == null) goto L133;
        int r52 = p.a;
        Observable r53 = r0.subscribeOn(Schedulers.io());
        if (r53 == null) goto L133;
        Observable r54 = r53.observeOn(AndroidSchedulers.mainThread());
        if (r54 == null) goto L133;
        b r55 = this;
        Disposable r56 = r54.subscribe(new d(r55), new e(r55));
    L136:
        if (r56 == null) goto L140;
        r55.b.add(r56);
        return;
    L140:
        return;
    L133:
        r55 = this;
    L135:
        r56 = null;
        goto L136
    L134:
        r55 = this;
    L83:
        r113 = "";
    L74:
        r30 = 0;
        goto L75
    L67:
        r27 = null;
    L82:
        r30 = -1;
        goto L83
    L59:
        r24 = LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_RADIO_MODE;
    L60:
        r24 = LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_VIDEO;
        goto L62
    L61:
        r24 = LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_DEVICE_NONE;
        goto L62
    L44:
        r20 = null;
    L41:
        r19 = null;
    L29:
        r14 = null;
        goto L30
    L22:
        r10 = null;
    L51:
        r23 = 0;
        goto L53
    L16:
        r7 = 0;
    L13:
        r6 = null;
        goto L14
    }

    public b(com.bytedance.android.live.revenuelink.withroom.a r3, yz0.g r4) {
        Intrinsics.checkNotNullParameter(r3, "storeService");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        this.f = r3;
        this.g = r4;
        this.b = new CompositeDisposable();
        this.c = new CopyOnWriteArrayList();
        h11.a r5 = h11.a.f;
        r5.getClass();
        this.d = ((Number) h11.a.c.getValue(r5, h11.a.a[1])).intValue();
    }
}
