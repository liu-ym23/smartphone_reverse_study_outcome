package com.bytedance.android.live.revenuelink.utils;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.n;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revenuelink.rtc.o;
import com.bytedance.android.live.revenuelink.rtc.p;
import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.a7;
import com.bytedance.revenue.platform.api.core.rx.l;
import fr2.g;
import fr2.g0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import y41.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiChannelOptManager {
    public final int a;
    public final CompositeDisposable b;
    public Disposable c;
    public final MutableLiveData<a7> d;
    public final MutableLiveData e;
    public final com.bytedance.android.live.revenuelink.utils.b f;
    public final c g;
    public final i h;
    public final i11.b i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiChannelOptManager a;
        public final /* synthetic */ String b;

        public b(MultiChannelOptManager r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r6v18, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r9v0 */
        public final void accept(Object r13) {
            Long r14 = (Long) r13;
            MultiChannelOptManager r15 = this.a;
            i r0 = r15.h;
            p r2 = null;
            String r3 = "";
            if (r0 == null) goto L26;
            List<vc0.a> r1 = r0.L0();
            if (r1 == null) goto L26;
            List<vc0.a> r4 = r1;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator<T> r6 = r4.iterator();
        L8:
            if (r6.hasNext() == false) goto L24;
            vc0.a r7 = (vc0.a) r6.next();
            Object r8 = r7.b;
            if ((r8 instanceof xh6.c) == true) goto L12;
            xh6.c r9 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(g.class), r7.a);
            if ((r9 instanceof g) == true) goto L18;
            r9 = null;
        L18:
            g r10 = (g) r9;
        L19:
            if (r10 == null) goto L22;
            String r12 = r10.getRoomId();
            if (r12 == null) goto L22;
        L23:
            r5.add(r12);
        L22:
            r12 = "";
            goto L23
        L12:
            if ((r8 instanceof g) == true) goto L14;
            r8 = null;
        L14:
            r10 = (g) r8;
            goto L19
        L24:
            List r16 = CollectionsKt.sorted(r5);
            if (r16 == null) goto L26;
        L27:
            i r17 = r15.h;
            if (r17 == null) goto L39;
            p r18 = r17.L();
            if (r18 == null) goto L39;
            List<o> r19 = r18.l();
            if (r19 == null) goto L39;
            List<o> r20 = r19;
            ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
            Iterator<T> r23 = r20.iterator();
        L35:
            if (r23.hasNext() == false) goto L37;
            r22.add(((o) r23.next()).b);
            goto L35
        L37:
            List r24 = CollectionsKt.sorted(r22);
            if (r24 == null) goto L39;
        L40:
            i11.b r110 = r15.i;
            boolean r25 = true;
            if (r110 == null) goto L54;
            List<com.bytedance.android.livesdk.link.model.p> r111 = r110.getOnlineUserList();
            if (r111 == null) goto L54;
            ?? r26 = new ArrayList();
            Iterator<T> r112 = r111.iterator();
        L46:
            if (r112.hasNext() == false) goto L56;
            T r27 = r112.next();
            IBaseUser r28 = ((com.bytedance.android.livesdk.link.model.p) r27).getUser();
            if (r28 == null) goto L50;
            String r29 = r28.getIdString();
        L52:
            if ((!Intrinsics.areEqual(r29, com.bytedance.android.live.revenuelink.connect.b.d())) == false) goto L46;
            r26.add(r27);
            goto L46
        L50:
            r29 = null;
        L56:
            if (r16.size() <= r24.size()) goto L59;
            r3 = "forward_more";
        L91:
            if (r3.length() > 0) goto L95;
            r25 = false;
        L95:
            if (r25 == false) goto L136;
            StringBuilder r30 = new StringBuilder("need fetch data for ");
            r30.append(r3);
            r30.append(", forward=");
            i r32 = this.a.h;
            if (r32 == null) goto L117;
            List<vc0.a> r33 = r32.L0();
            if (r33 == null) goto L117;
            List<vc0.a> r34 = r33;
            ArrayList r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));
            Iterator<T> r36 = r34.iterator();
        L102:
            if (r36.hasNext() == false) goto L118;
            vc0.a r37 = (vc0.a) r36.next();
            Object r38 = r37.b;
            if ((r38 instanceof xh6.c) == true) goto L106;
            xh6.c r39 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(g.class), r37.a);
            if ((r39 instanceof g) == true) goto L112;
            r39 = null;
        L112:
            g r40 = (g) r39;
        L113:
            if (r40 == null) goto L115;
            String r42 = r40.getRoomId();
        L116:
            r35.add(r42);
            goto L102
        L115:
            r42 = null;
            goto L116
        L106:
            if ((r38 instanceof g) == true) goto L108;
            r38 = null;
        L108:
            r40 = (g) r38;
        L118:
            r30.append(r35);
            r30.append(", rtc=");
            i r113 = this.a.h;
            if (r113 == null) goto L121;
            p r114 = r113.L();
        L122:
            r30.append(r114);
            r30.append(", online=");
            i11.b r115 = this.a.i;
            if (r115 == null) goto L130;
            List<com.bytedance.android.livesdk.link.model.p> r116 = r115.getOnlineUserList();
            if (r116 == null) goto L130;
            List<com.bytedance.android.livesdk.link.model.p> r117 = r116;
            ArrayList r43 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
            Iterator<T> r118 = r117.iterator();
        L128:
            if (r118.hasNext() == false) goto L131;
            r43.add(((com.bytedance.android.livesdk.link.model.p) r118.next()).toSimpleString());
        L131:
            r30.append(r43);
            jy0.b.c("ttlive_anchor_link_MultiChannelOpt", r30.toString(), null, 4);
            MultiChannelOptManager r119 = this.a;
            int r44 = r119.a;
            if (r44 != 2) goto L134;
        L135:
            r119.a(2, this.b, r3);
            return;
        L134:
            if (r44 == 3) goto L135;
            return;
        L130:
            r43 = null;
            goto L131
        L121:
            r114 = null;
        L117:
            r35 = null;
            goto L118
        L136:
            StringBuilder r45 = new StringBuilder("no need fetch data ");
            r45.append(this.b);
            r45.append(", forward=");
            i r46 = this.a.h;
            if (r46 == null) goto L157;
            List<vc0.a> r47 = r46.L0();
            if (r47 == null) goto L157;
            List<vc0.a> r48 = r47;
            ArrayList r49 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r48, 10));
            Iterator<T> r50 = r48.iterator();
        L142:
            if (r50.hasNext() == false) goto L158;
            vc0.a r52 = (vc0.a) r50.next();
            Object r53 = r52.b;
            if ((r53 instanceof xh6.c) == true) goto L146;
            xh6.c r54 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(g.class), r52.a);
            if ((r54 instanceof g) == true) goto L152;
            r54 = null;
        L152:
            g r55 = (g) r54;
        L153:
            if (r55 == null) goto L155;
            String r56 = r55.getRoomId();
        L156:
            r49.add(r56);
            goto L142
        L155:
            r56 = null;
            goto L156
        L146:
            if ((r53 instanceof g) == true) goto L148;
            r53 = null;
        L148:
            r55 = (g) r53;
        L158:
            r45.append(r49);
            r45.append(", rtc=");
            i r120 = this.a.h;
            if (r120 == null) goto L161;
            r2 = r120.L();
        L161:
            r45.append(r2);
            jy0.b.d("ttlive_anchor_link_MultiChannelOpt", r45.toString());
            return;
        L157:
            r49 = null;
            goto L158
        L59:
            if (r16.size() >= r24.size()) goto L62;
            r3 = "forward_less";
            goto L91
        L62:
            if (f.N.h() == true) goto L91;
            List r121 = r24;
            ArrayList r57 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
            Iterator<T> r122 = r121.iterator();
        L66:
            if (r122.hasNext() == false) goto L82;
            String r58 = (String) r122.next();
            Iterator<T> r59 = ((Iterable) r26).iterator();
        L69:
            if (r59.hasNext() == false) goto L73;
            T r123 = r59.next();
            if (Intrinsics.areEqual(((com.bytedance.android.livesdk.link.model.p) r123).getLinkMicIdStr(), r58) == false) goto L69;
        L74:
            com.bytedance.android.livesdk.link.model.p r124 = (com.bytedance.android.livesdk.link.model.p) r123;
            if (r124 == null) goto L79;
            IBaseUser r60 = r124.getUser();
            if (r60 == null) goto L79;
            Long r62 = Long.valueOf(n.a(r60));
        L80:
            r57.add(String.valueOf(r62));
        L79:
            r62 = null;
            goto L80
        L73:
            r123 = null;
            goto L74
        L82:
            if ((!Intrinsics.areEqual(CollectionsKt.sorted(r57), r16)) == false) goto L85;
            r3 = "forward_rtc_content_diff";
            goto L91
        L85:
            if (r16.size() == r26.size()) goto L88;
            r3 = "forward_diff_online";
            goto L91
        L88:
            if (r24.size() == r26.size()) goto L91;
            r3 = "rtc_diff_online";
        L54:
            r26 = CollectionsKt.emptyList();
        L39:
            r24 = CollectionsKt.emptyList();
        L26:
            r16 = CollectionsKt.emptyList();
            goto L27
        }
    }

    static {
    }

    public final void b(String r5) {
        if (this.a != 0) goto L6;
        return;
    L6:
        if (f.N.h() == false) goto L8;
        return;
    L8:
        Disposable r0 = this.c;
        if (r0 == null) goto L11;
        r0.dispose();
    L11:
        int r1 = ((Number) g11.a.c.getValue(null, g11.a.a[1])).intValue() * WebcastRedirectException.UNKNOWN;
        l r2 = l.a;
        int r3 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r6 = Observable.timer(r1, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r5));
        com.bytedance.revenue.platform.api.core.rx.f.a(r6, this.b);
        this.c = r6;
    }

    public MultiChannelOptManager(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r2, i r3, AnchorLinkUserCenterV2 r4) {
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.a = ((Number) g11.a.b.getValue(null, g11.a.a[0])).intValue();
        this.b = new CompositeDisposable();
        MutableLiveData<a7> r5 = new MutableLiveData();
        this.d = r5;
        this.e = r5;
        com.bytedance.android.live.revenuelink.utils.b r6 = new com.bytedance.android.live.revenuelink.utils.b(this);
        this.f = r6;
        if (r3 == null) goto L6;
        r3.g1(r6);
        return;
    }

    public final void a(int r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r14, "reason");
        if (this.a != 0) goto L5;
        return;
    L5:
        com.bytedance.android.live.revenuelink.connect.f r2 = null;
        jy0.b.c("ttlive_anchor_link_MultiChannelOpt", "fetchMultiChannelInfo " + r12 + " reqSrc=" + r13 + " reason=" + r14, null, 4);
        c r0 = this.g;
        if (r0 == null) goto L8;
        r2 = r0.Z0();
    L8:
        com.bytedance.android.live.revenuelink.connect.f r3 = r2;
        if (r3 == null) goto L12;
        r3.fetchMultiChannelInfo(r12, false, r13, r14, new MultiChannelOptManager$fetchMultiChannelInfo$1(this), MultiChannelOptManager$fetchMultiChannelInfo$2.INSTANCE);
        return;
    }
}
