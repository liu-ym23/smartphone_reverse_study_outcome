package com.bytedance.android.live.revlink.impl.multianchor.connect;

import android.view.SurfaceView;
import android.view.TextureView;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenuelink.utils.MultiChannelOptManager;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z1;
import com.bytedance.android.livesdk.link.model.c4;
import com.bytedance.android.livesdk.link.model.g6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.q;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class UnexpectedFrameMonitor extends com.bytedance.android.live.revlink.impl.multianchor.utils.e {
    public static final ReadOnlyProperty p = null;
    public static final ReadOnlyProperty q = null;
    public static final ReadOnlyProperty r = null;
    public static final a s = null;
    public final com.bytedance.android.live.revenuelink.rtc.i e;
    public final yz0.l f;
    public final CompositeDisposable g;
    public Disposable h;
    public Disposable i;
    public Disposable j;
    public MultiChannelOptManager k;
    public final boolean l;
    public b2 m;
    public final c n;
    public final d o;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "missingFrameCheckTime", "getMissingFrameCheckTime()J", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "illegalFrameCheckTime", "getIllegalFrameCheckTime()J", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "waitingFrameCheckTime", "getWaitingFrameCheckTime()J", 0))};
        }

        public a() {
        }

        public static void a(String r12, JSONObject r13, int r14, String r15) {
            int r0 = y50.b.a;
            com.bytedance.android.live.revlink.impl.global.c r1 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r1 == null) goto L7;
            com.bytedance.android.live.revlink.impl.utils.a r2 = r1.B8();
            if (r2 == null) goto L7;
            String r3 = r2.b();
        L8:
            y50.b.a.d(r13, "link_type", r3);
            v r4 = com.bytedance.android.live.revlink.impl.global.b.C();
            if (r4 == null) goto L11;
            r4.c(r13);
        L11:
            jy0.b.c("ttlive_anchor_link_frame", r12 + ": " + r13, null, 4);
            HashMap r9 = new HashMap();
            r9.put("business_api_name", r12);
            r9.put("android_event_key", r12);
            com.bytedance.android.live.revenuelink.f r5 = com.bytedance.android.live.revlink.impl.global.b.g0();
            if (r5 == null) goto L15;
            r5.c0("ttlive_multilinker_business_api_call", LiveTracingMonitorKt.EventModule.MULTI_LINKER, r14, r15, r9, r13);
            return;
        L15:
            return;
        L7:
            r3 = null;
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(UnexpectedFrameMonitor r8) {
            super(1, r8, UnexpectedFrameMonitor.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r9) {
            final UnexpectedFrameMonitor r0 = (UnexpectedFrameMonitor) ((CallableReference) this).receiver;
            ReadOnlyProperty r1 = UnexpectedFrameMonitor.p;
            r0.getClass();
            if ((r9 instanceof h1) == false) goto L58;
            i6 r10 = ((h1) r9).castTo(i6.class);
            long r2 = r10.getLinkerId();
            com.bytedance.android.live.revenuelink.connect.g r3 = com.bytedance.android.live.revlink.impl.global.b.b();
            if (r3 != null) goto L8;
            return;
        L8:
            if (r2 != r3.getChannelId()) goto L59;
            com.bytedance.android.live.revenuelink.connect.g r4 = com.bytedance.android.live.revlink.impl.global.b.b();
            if (r4 != null) goto L13;
            return;
        L13:
            if (r4.u1() == true) goto L15;
            return;
        L15:
            if (((int) r10.getScene()) != 7) goto L60;
            int r5 = (int) r10.getType2();
            if (r5 != 7) goto L20;
            ILinkerLeaveContentBridge r12 = r10.getLeave();
            if (r12 == null) goto L52;
            g6 r13 = r12.castTo(g6.class);
            if (r13 == null) goto L53;
            r0.q(r13.getPreRtcInfo());
            i11.b r6 = com.bytedance.android.live.revlink.impl.global.b.e();
            if (r6 == null) goto L54;
            String r7 = null;
            com.bytedance.android.livesdk.link.model.p r14 = r6.getGuestInfo(r13.getUserId(), null);
            if (r14 == null) goto L55;
            final String r15 = r14.getLinkMicIdStr();
            if (r15 == null) goto L56;
            com.bytedance.android.live.revenuelink.connect.g r8 = com.bytedance.android.live.revlink.impl.global.b.b();
            if (r8 == null) goto L44;
            r7 = r8.getLinkMicId();
        L44:
            if ((!Intrinsics.areEqual(r7, r15)) == false) goto L57;
            UtilityKotlinExtentionsKt.s(0, false, true, new UnexpectedFrameMonitor$onMessage$$inlined$let$lambda$1(r15, r0), 3);
            return;
        L57:
            return;
        L56:
            return;
        L55:
            return;
        L54:
            return;
        L53:
            return;
        L52:
            return;
        L20:
            if (r5 != 49) goto L61;
            com.bytedance.android.live.revenuelink.connect.g r16 = com.bytedance.android.live.revlink.impl.global.b.b();
            if (r16 != null) goto L25;
        L27:
            c4 r17 = r10.getCrossRoomRTCInfoContent();
            if (r17 == null) goto L50;
            r0.q(r17.getPreRtcInfo());
            return;
        L50:
            return;
        L25:
            if (r16.v1() != true) goto L27;
            return;
        L61:
            return;
        L60:
            return;
        L59:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ UnexpectedFrameMonitor a;

        public b(UnexpectedFrameMonitor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            o r3 = (o) sh6.c.b((sh6.b) r2);
            if (r3 != null) goto L6;
            return;
        L6:
            if (y.c() == false) goto L9;
            this.a.o(r3.b);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ UnexpectedFrameMonitor a;

        public c(UnexpectedFrameMonitor r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            ey.f r6 = (ey.f) r5;
            jy0.b.f("ttlive_anchor_link_frame", "connectState changed to " + r6, null, 4);
            if (r6.d != 0) goto L6;
            this.a.m = null;
            return;
        }
    }

    public static final class d extends com.bytedance.android.live.revenuelink.rtc.e {
        public final /* synthetic */ UnexpectedFrameMonitor a;

        public d(UnexpectedFrameMonitor r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void L0(String r1, TextureView r2, int r3, int r4) {
            this.a.p(r1, "firstFrameRender");
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void T3(String r1, vc0.a r2, int r3, int r4) {
            this.a.p(r1, "firstFrameRender");
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void h1(String r1, SurfaceView r2, int r3, int r4) {
            this.a.p(r1, "firstFrameRender");
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ UnexpectedFrameMonitor a;
        public final /* synthetic */ String b;

        public f(UnexpectedFrameMonitor r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v6 */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v11, types: [java.util.ArrayList] */
        public final void accept(Object r20) {
            Long r1 = (Long) r20;
            if (y.c() == false) goto L139;
            UnexpectedFrameMonitor r2 = this.a;
            String r3 = this.b;
            com.bytedance.android.live.revenuelink.rtc.i r4 = r2.e;
            if (r4 == null) goto L14;
            com.bytedance.android.live.revenuelink.rtc.p r5 = r4.L();
            if (r5 == null) goto L14;
            List<com.bytedance.android.live.revenuelink.rtc.o> r6 = r5.l();
            if (r6 == null) goto L14;
            List<com.bytedance.android.live.revenuelink.rtc.o> r7 = r6;
            ?? r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r9 = r7.iterator();
        L12:
            if (r9.hasNext() == false) goto L15;
            r8.add(((com.bytedance.android.live.revenuelink.rtc.o) r9.next()).b);
        L15:
            ArrayList r10 = new ArrayList();
            Map<Long, z1> r12 = r2.n();
            if (r12 == null) goto L41;
            Iterator<Map.Entry<Long, z1>> r13 = r12.entrySet().iterator();
        L19:
            if (r13.hasNext() == false) goto L41;
            Map.Entry<Long, z1> r14 = r13.next();
            long r15 = r14.getKey().longValue();
            z1 r16 = r14.getValue();
            if (r15 == u.d()) goto L19;
            String r17 = r16.getLinkmicIdStr();
            com.bytedance.android.live.revenuelink.connect.g r18 = com.bytedance.android.live.revlink.impl.global.b.b();
            if (r18 == null) goto L25;
            String r19 = r18.getLinkMicId();
        L27:
            if (Intrinsics.areEqual(r17, r19) == true) goto L19;
            if (AnchorRtcConnectUtilsKt.d(r16) == false) goto L19;
            Iterator<T> r110 = ((Iterable) r8).iterator();
        L33:
            if (r110.hasNext() == false) goto L37;
            T r111 = r110.next();
            if (Intrinsics.areEqual((String) r111, r16.getLinkmicIdStr()) == false) goto L33;
        L39:
            if (r111 != null) goto L19;
            r10.add(TuplesKt.to(Long.valueOf(r15), r16.getLinkmicIdStr()));
            goto L19
        L37:
            r111 = (T) null;
            goto L39
        L25:
            r19 = null;
        L41:
            jy0.b.a("ttlive_anchor_link_frame", "check missing frame source=" + r3 + ", missingFrames=" + r10);
            boolean r22 = false;
            if (r10.isEmpty() == false) goto L45;
        L59:
            this.a.getClass();
            com.bytedance.android.live.revlink.impl.global.c r23 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r23 == null) goto L62;
            AnchorRtcConnectModel r24 = r23.Hb();
        L63:
            if (r24 == null) goto L140;
            com.bytedance.live.datacontext.n<Map<Long, z1>> r25 = r24.getPreRtcInfoMap();
            if (r25 == null) goto L141;
            Map r26 = (Map) r25.getValue();
            if (r26 == null) goto L142;
            com.bytedance.android.live.revlink.impl.global.c r27 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r27 == null) goto L71;
            g0 r28 = r27.Rn();
        L72:
            if (r28 == null) goto L143;
            Intrinsics.checkNotNullParameter(r26, "preRtcInfoMap");
            StringBuilder r29 = new StringBuilder();
            Collection r30 = r26.values();
            ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
            Iterator<T> r33 = r30.iterator();
        L75:
            if (r33.hasNext() == false) goto L77;
            r32.add(((z1) r33.next()).getLinkmicIdStr());
            goto L75
        L77:
            com.bytedance.android.live.revlink.impl.global.c r34 = r28.d;
            if (r34 == null) goto L80;
            com.bytedance.android.live.revenuelink.rtc.f r35 = r34.m0();
        L82:
            if (r35 == null) goto L105;
            com.bytedance.android.live.revenuelink.rtc.i r36 = r35.getRtcManager();
            if (r36 == null) goto L105;
            com.bytedance.android.live.revenuelink.rtc.p r37 = r36.L();
            if (r37 == null) goto L105;
            List<com.bytedance.android.live.revenuelink.rtc.o> r38 = r37.l();
            if (r38 == null) goto L105;
            Iterator<T> r39 = r38.iterator();
        L91:
            if (r39.hasNext() == false) goto L105;
            com.bytedance.android.live.revenuelink.rtc.o r40 = (com.bytedance.android.live.revenuelink.rtc.o) r39.next();
            if (r32.contains(r40.b) == true) goto L91;
            if (r28.p(r40.b) == true) goto L91;
            if (r40.d == true) goto L103;
            if ((!Intrinsics.areEqual(r40.l, Boolean.FALSE)) == true) goto L103;
            jy0.b.c("ttlive_anchor_connect", "rtc user not in preRtcInfo, " + r40, null, 4);
        L103:
            r29.append(" ");
            r29.append(r40.b);
            jy0.b.c("ttlive_anchor_connect", "rtc user not in preRtcInfo but rendered! " + r40, null, 4);
        L105:
            if (r29.length() <= 0) goto L107;
            r22 = true;
        L107:
            if (r22 == false) goto L144;
            JSONObject r42 = new JSONObject();
            int r43 = y50.b.a;
            y50.b.a.d(r42, "errorInfo", r29.toString());
            v r44 = r28.o();
            if (r44 == null) goto L145;
            r44.I("unexpected_remote_render_status", r42, true);
            return;
        L145:
            return;
        L144:
            return;
        L80:
            r35 = null;
            goto L82
        L143:
            return;
        L71:
            r28 = null;
            goto L72
        L142:
            return;
        L141:
            return;
        L140:
            return;
        L62:
            r24 = null;
            goto L63
        L45:
            if (r2.l == false) goto L49;
            MultiChannelOptManager r45 = r2.k;
            if (r45 == null) goto L49;
            r45.a(3, r3, "unexpected_less_frame");
        L49:
            JSONObject r46 = new JSONObject();
            int r47 = y50.b.a;
            y50.b.a.d(r46, "source", r3);
            y50.b.a.d(r46, "frame_uids", r10.toString());
            y50.b.a.b(r46, "frame_count", r10.size());
            y50.b.a.d(r46, "business_api_name", "unexpected_less_frame");
            if (r2.l == true) goto L56;
            b2 r48 = r2.m;
            if (r48 == null) goto L54;
            String r49 = c2.a(r48);
        L55:
            y50.b.a.d(r46, "pre_rtc_info", r49);
            goto L56
        L54:
            r49 = null;
        L56:
            UnexpectedFrameMonitor.s.getClass();
            a.a("unexpected_less_frame", r46, 0, "");
            d31.f r50 = com.bytedance.android.live.revlink.impl.global.b.e0();
            if (r50 == null) goto L59;
            d31.f.f(r50, "unexpected_less_frame", r10.size(), null, 0, 0, null, null, null, 252);
        L14:
            r8 = CollectionsKt.emptyList();
            goto L15
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ UnexpectedFrameMonitor a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public g(UnexpectedFrameMonitor r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            if (y.c() == false) goto L6;
            UnexpectedFrameMonitor.m(this.a, this.b, 1, this.c);
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ UnexpectedFrameMonitor a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public h(UnexpectedFrameMonitor r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            if (y.c() == false) goto L6;
            UnexpectedFrameMonitor.m(this.a, this.b, 2, this.c);
            return;
        }
    }

    static {
        s = new a();
        Class r2 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_missing_frame_check_time", 10L, r2, false);
        KProperty[] r3 = a.a;
        KProperty r10 = r3[0];
        p = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_illegal_frame_check_time", 10L, r2, false);
        KProperty r12 = r3[1];
        q = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r12);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_waiting_frame_check_time", 20L, r2, false);
        KProperty r9 = r3[2];
        r = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r9);
    }

    public final void attach() {
        com.bytedance.android.live.revenuelink.connect.f r0 = com.bytedance.android.live.revlink.impl.global.b.a();
        if (r0 == null) goto L7;
        LiveData<ey.f> r1 = r0.connectState();
        if (r1 == null) goto L7;
        r1.observeForever(this.n);
    L7:
        yz0.l r2 = this.f;
        if (r2 == null) goto L15;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r3 = yz0.h.a.a(r2, com.bytedance.android.live.revenue.common.message.b.b, false, 6);
        if (r3 == null) goto L15;
        final AnonymousClass1 r4 = new AnonymousClass1(this);
        Disposable r5 = r3.subscribe(new e(r4));
        if (r5 == null) goto L15;
        RxUtilKt.c(r5, this.g);
    L15:
        if (this.l == false) goto L29;
        com.bytedance.android.live.revlink.impl.global.c r6 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r6 == null) goto L19;
        AnchorRtcConnectModel r7 = r6.Hb();
    L20:
        if (r7 == null) goto L30;
        com.bytedance.live.datacontext.n<o> r8 = r7.getRtcForwardData();
        if (r8 == null) goto L31;
        Observable r9 = r8.a();
        if (r9 == null) goto L32;
        Disposable r10 = r9.subscribe(new b(this));
        if (r10 == null) goto L33;
        RxUtilKt.c(r10, this.g);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L19:
        r7 = null;
        goto L20
    }

    public final Map<Long, z1> n() {
        com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r0 == null) goto L5;
        AnchorRtcConnectModel r1 = r0.Hb();
    L6:
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.n<Map<Long, z1>> r2 = r1.getPreRtcInfoMap();
        if (r2 == null) goto L13;
        Map<Long, z1> r3 = (Map) r2.getValue();
        if (r3 == null) goto L13;
        return r3;
    L13:
        b2 r4 = this.m;
        if (r4 != null) goto L16;
        return null;
    L16:
        return r4.getPreRtcUserInfo();
    L5:
        r1 = null;
        goto L6
    }

    public final void o(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reqSrc");
        if (Intrinsics.areEqual(r5, "getCrossRoomRtcInfo") == false) goto L5;
        return;
    L5:
        Disposable r0 = this.h;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        a r1 = s;
        r1.getClass();
        this.h = Observable.timer(((Number) p.getValue(r1, a.a[0])).longValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r5));
    }

    public final void q(b2 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        b2 r0 = this.m;
        if (r0 == null) goto L7;
        long r1 = r0.getVersion();
    L9:
        if (r1 < r6.getVersion()) goto L11;
        return;
    L11:
        this.m = r6;
        if (this.l == true) goto L15;
        jy0.b.a("ttlive_anchor_link_frame", "update preRtcInfo: " + c2.a(r6));
        return;
    L15:
        return;
    L7:
        r1 = -1;
        goto L9
    }

    public final void p(String r6, String r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        Map<Long, z1> r0 = n();
        if (r0 == null) goto L16;
        Collection<z1> r1 = r0.values();
        if (r1 == null) goto L16;
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((z1) r3).getLinkmicIdStr(), r6) == false) goto L10;
    L15:
        z1 r4 = (z1) r3;
    L17:
        if (r4 != null) goto L24;
        Disposable r5 = this.i;
        if (r5 == null) goto L21;
        r5.dispose();
    L21:
        a r8 = s;
        r8.getClass();
        this.i = Observable.timer(((Number) q.getValue(r8, a.a[1])).longValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r6, r7));
        jy0.b.f("ttlive_anchor_link_frame", "received frame " + r6 + " not in preRtcUser, start timer check", null, 4);
        return;
    L24:
        if (AnchorRtcConnectUtilsKt.d(r4) == true) goto L33;
        Disposable r9 = this.j;
        if (r9 == null) goto L28;
        r9.dispose();
    L28:
        a r10 = s;
        r10.getClass();
        this.j = Observable.timer(((Number) r.getValue(r10, a.a[2])).longValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, r6, r7));
        return;
    L33:
        return;
    L14:
        r3 = null;
    L16:
        r4 = null;
        goto L17
    }

    public UnexpectedFrameMonitor(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        super(r1, r2, r3);
        com.bytedance.android.live.revenuelink.rtc.f r4 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r4 == null) goto L5;
        com.bytedance.android.live.revenuelink.rtc.i r5 = r4.getRtcManager();
    L6:
        this.e = r5;
        this.f = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        this.g = new CompositeDisposable();
        this.l = AnchorRtcConnectUtilsKt.f();
        this.n = new c(this);
        this.o = new d(this);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static final void m(UnexpectedFrameMonitor r12, String r13, int r14, String r15) {
        com.bytedance.android.live.revenuelink.rtc.i r2 = r12.e;
        if (r2 == null) goto L8;
        com.bytedance.android.live.revenuelink.rtc.p r3 = r2.L();
        if (r3 == null) goto L8;
        List<com.bytedance.android.live.revenuelink.rtc.o> r4 = r3.l();
        if (r4 == null) goto L8;
    L9:
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L10:
        z1 r7 = null;
        Object r8 = null;
        r7 = null;
        if (r6.hasNext() == false) goto L32;
        com.bytedance.android.live.revenuelink.rtc.o r9 = (com.bytedance.android.live.revenuelink.rtc.o) r6.next();
        Map<Long, z1> r10 = r12.n();
        if (r10 == null) goto L23;
        Collection<z1> r16 = r10.values();
        if (r16 == null) goto L23;
        Iterator<T> r17 = r16.iterator();
    L18:
        if (r17.hasNext() == false) goto L22;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((z1) r18).getLinkmicIdStr(), r9.b) == false) goto L18;
        r8 = r18;
    L22:
        r7 = (z1) r8;
    L23:
        if (r14 != 1) goto L27;
        if (r7 != null) goto L27;
        r5.add(r9.b);
    L27:
        if (r14 != 2) goto L10;
        if (r7 == null) goto L10;
        if (AnchorRtcConnectUtilsKt.d(r7) == true) goto L10;
        r5.add(r9.b);
        goto L10
    L32:
        jy0.b.a("ttlive_anchor_link_frame", "check received frame link_id=" + r13 + ", checkType=" + r14 + ", source=" + r15 + ", unexpectedFrames=" + r5);
        if (r5.isEmpty() == false) goto L36;
        return;
    L36:
        if (r12.l == false) goto L43;
        if (r14 != 1) goto L39;
        Pair r19 = TuplesKt.to(4, "unexpected_illegal_frame");
    L40:
        int r20 = ((Number) r19.component1()).intValue();
        String r22 = (String) r19.component2();
        MultiChannelOptManager r23 = r12.k;
        if (r23 == null) goto L43;
        r23.a(r20, r22, r22);
        goto L43
    L39:
        r19 = TuplesKt.to(5, "unexpected_waiting_frame");
    L43:
        JSONObject r24 = new JSONObject();
        y50.b.a.b(r24, "check_type", r14);
        y50.b.a.d(r24, "frame_uids", r5.toString());
        y50.b.a.b(r24, "frame_count", r5.size());
        y50.b.a.d(r24, "business_api_name", "unexpected_more_frame");
        y50.b.a.d(r24, "source", r15);
        if (r12.l == true) goto L50;
        b2 r0 = r12.m;
        if (r0 == null) goto L48;
        String r1 = c2.a(r0);
    L49:
        y50.b.a.d(r24, "pre_rtc_info", r1);
        goto L50
    L48:
        r1 = null;
    L50:
        ArrayList r25 = new ArrayList();
        Iterator r26 = r5.iterator();
    L52:
        if (r26.hasNext() == false) goto L68;
        Object r27 = r26.next();
        String r110 = (String) r27;
        Intrinsics.checkNotNullParameter(r110, "linkmicId");
        if (((Boolean) AnchorRtcConnectUtilsKt.b.getValue()).booleanValue() == false) goto L64;
        i11.b r111 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r111 == null) goto L61;
        com.bytedance.android.livesdk.link.model.p r112 = r111.v(r110);
        if (r112 == null) goto L61;
        com.bytedance.android.livesdk.link.model.bridge.j r113 = q.b(r112);
    L62:
        if (r113 == null) goto L64;
        boolean r114 = true;
    L65:
        if (r114 == false) goto L52;
        r25.add(r27);
    L61:
        r113 = null;
    L64:
        r114 = false;
        goto L65
    L68:
        if ((!r25.isEmpty()) == false) goto L70;
        s.getClass();
        a.a("main_backup_stream_frame", r24, r14, r15);
        return;
    L70:
        s.getClass();
        a.a("unexpected_more_frame", r24, r14, r15);
        d31.f r28 = com.bytedance.android.live.revlink.impl.global.b.e0();
        if (r28 == null) goto L92;
        d31.f.f(r28, "unexpected_more_frame", r5.size(), null, 0, 0, String.valueOf(r14), r15, null, 156);
        return;
    L92:
        return;
    L8:
        r4 = CollectionsKt.emptyList();
        goto L9
    }
}
