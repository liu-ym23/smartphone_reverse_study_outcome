package com.bytedance.android.live.revlink.link.streaminteract.biz;

import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.y;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g;
import com.bytedance.android.livesdk.link.model.bridge.j1;
import com.bytedance.android.livesdk.link.model.bridge.o1;
import com.bytedance.android.livesdk.link.model.bridge.p1;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.j;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import o51.e;
import org.json.JSONObject;
import r11.h;
import yz0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PushModeManagerService implements o, com.bytedance.android.live.revlink.link.biz.service.a {
    public final CompositeDisposable a;
    public Map<Long, String> b;
    public Map<Long, String> c;
    public Map<Long, String> d;
    public Map<Long, String> e;
    public int f;
    public int g;
    public long h;
    public final Lazy i;
    public final PushModeManagerService$onPartnerEnableObserver$1 j;
    public final com.bytedance.android.livesdk.revenue.service.room.c k;
    public final f l;
    public final g m;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.streaminteract.biz.PushModeManagerService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i6;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/i6;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<i6, Unit> {
        public AnonymousClass1(PushModeManagerService r8) {
            super(1, r8, PushModeManagerService.class, "onLinkerMessage", "onLinkerMessage(Lcom/bytedance/android/livesdk/link/model/ILinkerMessage;)V", 0);
        }

        public final void invoke(i6 r8) {
            Intrinsics.checkNotNullParameter(r8, "p1");
            PushModeManagerService r1 = (PushModeManagerService) ((CallableReference) this).receiver;
            r1.getClass();
            ILinkerChangeMediaInfoContent r9 = r8.getLinkerChangeMediaInfoContent();
            if (r9 == null) goto L35;
            ILinkmicMediaParam r10 = r9.getLinkmicMediaParam();
            if (r10 == null) goto L36;
            j1 r12 = r10.getLinkmicMediaInfo();
            if (r12 == null) goto L37;
            v1 r0 = r12.getMultiRtcInfo();
            if (r0 == null) goto L14;
            o1 r2 = r0.getMultiAnchorLinkMicRtcInfo();
            if (r2 == null) goto L14;
            Map r3 = r2.getPushStreamModeRTCMap();
        L15:
            u1 r4 = r12.getMultiLiveCoreInfo();
            if (r4 == null) goto L20;
            p1 r5 = r4.getMultiAnchorLiveCoreInfo();
            if (r5 == null) goto L20;
            Map r6 = r5.getPushStreamModeLiveCoreMap();
        L21:
            v1 r7 = r12.getMultiRtcInfo();
            if (r7 == null) goto L26;
            o1 r13 = r7.getMultiAnchorLinkMicRtcInfo();
            if (r13 == null) goto L26;
            Map r14 = r13.getRtcInfoMap();
        L27:
            u1 r15 = r12.getMultiLiveCoreInfo();
            if (r15 == null) goto L32;
            p1 r16 = r15.getMultiAnchorLiveCoreInfo();
            if (r16 == null) goto L32;
            Map r17 = r16.getLiveCoreExtInfoMap();
        L33:
            PushModeManagerService.d(r1, r3, r6, r14, r17, "linker_message");
            return;
        L32:
            r17 = null;
        L26:
            r14 = null;
        L20:
            r6 = null;
        L14:
            r3 = null;
            goto L15
        L37:
            return;
        L36:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i6) r1);
            return Unit.INSTANCE;
        }
    }

    public final void c() {
        com.bytedance.android.live.revlink.impl.multianchor.service.g r0 = a();
        if (r0 == null) goto L5;
        long r2 = r0.d();
    L6:
        String r4 = null;
        boolean r7 = true;
        if (r2 < 0) goto L71;
        Map<Long, String> r1 = this.c;
        if (r1 == null) goto L11;
        String r3 = r1.get(Long.valueOf(r2));
    L12:
        Map<Long, String> r9 = this.b;
        if (r9 == null) goto L15;
        String r10 = r9.get(Long.valueOf(r2));
    L16:
        jy0.b.c("testPusher", "handlePushModeChange1 key" + r2 + ' ' + r3 + ' ' + r10, null, 4);
        if (r3 != null) goto L19;
    L22:
        boolean r12 = true;
    L23:
        if (r12 == true) goto L37;
        if (r10 != null) goto L26;
    L29:
        boolean r13 = true;
    L30:
        if (r13 == true) goto L37;
        i r5 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r5 == null) goto L34;
        r5.T(r3, "handlePushModeChange");
    L34:
        i r6 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r6 == null) goto L64;
        r6.Q(r10, "handlePushModeChange");
    L64:
        i r8 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r8 == null) goto L229;
        i r14 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r14 == null) goto L69;
        r4 = r14.getRtcExtInfo();
    L69:
        i.a.a(r8, r4, "handlePushModeChange");
        return;
    L229:
        return;
    L26:
        if (r10.length() == 0) goto L29;
        r13 = false;
    L37:
        jy0.b.c("testPusher", "handlePushModeChange2 key" + r2 + ' ' + r3 + ' ' + r10, null, 4);
        Map<Long, String> r15 = this.e;
        if (r15 == null) goto L40;
        String r16 = r15.get(Long.valueOf(r2));
    L41:
        Map<Long, String> r17 = this.d;
        if (r17 == null) goto L44;
        String r18 = r17.get(Long.valueOf(r2));
    L45:
        if (r16 != null) goto L47;
    L50:
        boolean r19 = true;
    L51:
        if (r19 == true) goto L64;
        if (r18 != null) goto L54;
    L57:
        if (r7 == true) goto L64;
        i r20 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r20 == null) goto L61;
        r20.T(r16, "handlePushModeChange");
    L61:
        i r22 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r22 == null) goto L64;
        r22.Q(r18, "handlePushModeChange");
        goto L64
    L54:
        if (r18.length() == 0) goto L57;
        r7 = false;
        goto L57
    L47:
        if (r16.length() == 0) goto L50;
        r19 = false;
        goto L51
    L44:
        r18 = null;
        goto L45
    L40:
        r16 = null;
        goto L41
    L19:
        if (r3.length() == 0) goto L22;
        r12 = false;
        goto L23
    L15:
        r10 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L71:
        long r23 = this.h;
        if (r23 < 0) goto L95;
        Map<Long, String> r24 = this.c;
        if (r24 == null) goto L83;
        String r25 = r24.get(Long.valueOf(r23));
        if (r25 == null) goto L83;
        if (this.h != 2) goto L80;
        r25 = ((y) this.i.getValue()).d(r25);
    L80:
        i r26 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r26 == null) goto L83;
        r26.T(r25, "handlePushModeChange");
    L83:
        Map<Long, String> r27 = this.b;
        if (r27 == null) goto L230;
        String r28 = r27.get(Long.valueOf(this.h));
        if (r28 != null) goto L88;
        return;
    L88:
        if (this.h != 2) goto L90;
        ((y) this.i.getValue()).getClass();
        r28 = y.e(r28);
    L90:
        i r29 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r29 == null) goto L232;
        r29.Q(r28, "handlePushModeChange");
        return;
    L232:
        return;
    L230:
        return;
    L95:
        if ((((e) getContext().d.i.getValue()) instanceof e.C0283e) == false) goto L98;
        com.bytedance.android.live.revlink.impl.settings.live.a r30 = com.bytedance.android.live.revlink.impl.settings.live.a.j;
        r30.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.a.i.getValue(r30, com.bytedance.android.live.revlink.impl.settings.live.a.a[7])).booleanValue() == true) goto L98;
    L142:
        Map<Long, String> r32 = this.d;
        if (r32 == null) goto L211;
        String r33 = r32.get(Long.valueOf(this.g));
        if (r33 == null) goto L211;
        i r34 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r34 == null) goto L211;
        y r35 = (y) this.i.getValue();
        int r36 = this.g;
        r35.getClass();
        Intrinsics.checkNotNullParameter(r33, "rtcExtInfo");
        com.bytedance.android.live.revlink.impl.settings.live.b r110 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        h r37 = r110.a();
        Intrinsics.checkNotNullParameter(r37, "$this$isRtcEnable");
        if (r37.getEnable() == false) goto L155;
        Map<Integer, h.b> r38 = r37.k();
        if (r38 == null) goto L155;
        boolean r39 = true;
        if ((!r38.isEmpty()) != true) goto L155;
    L156:
        if (r39 == true) goto L159;
    L168:
        i r111 = r34;
        String r112 = "handlePushModeChange";
    L192:
        i r40 = r111;
        String r42 = r112;
        String r43 = null;
    L210:
        r40.Q(r33, r42);
    L212:
        i r44 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r44 == null) goto L233;
        i r45 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r45 == null) goto L217;
        r43 = r45.getRtcExtInfo();
    L217:
        i.a.a(r44, r43, r42);
        return;
    L233:
        return;
    L159:
        if (y.b() == false) goto L168;
        Map<Integer, h.b> r46 = r110.a().k();
        if (r46 == null) goto L206;
        h.b r47 = r46.get(Integer.valueOf(r36));
        if (r47 == null) goto L206;
        if (r11.i.b(r47) == false) goto L168;
        JSONObject r48 = new JSONObject(r33);     // Catch: Exception -> L199
        JSONObject r49 = r48.optJSONObject("live_rtc_video_param");     // Catch: Exception -> L199
        if (r49 == null) goto L206;
        JSONObject r113 = r49.optJSONObject("rtc_video_param_1v1_client");     // Catch: Exception -> L199
        if (r113 == null) goto L206;
        String r114 = r33;
        String r115 = "";
        int r50 = r113.optInt("width", -1);     // Catch: Exception -> L197
        r111 = r34;
        int r52 = r113.optInt("height", -1);     // Catch: Exception -> L195
        int r116 = r113.optInt("bitparseLiveRtcOtherrate_kbps", -1);     // Catch: Exception -> L195
        int r53 = r113.optInt("bitrate_kbps", -1);     // Catch: Exception -> L195
        if (r50 <= 0) goto L207;
        if (r52 <= 0) goto L207;
        if (r116 <= 0) goto L207;
        if (r53 <= 0) goto L207;
        r112 = "handlePushModeChange";
    L193:
        e = e;
    L201:
        String r54 = e.getMessage();
        if (r54 != null) goto L204;
        String r55 = r115;
    L205:
        r43 = null;
        jy0.b.c("RevLinkParamsAdjustUtils", "interceptRtcExt error".concat(r55), null, 4);
    L209:
        r33 = r114;
        r40 = r111;
        r42 = r112;
        goto L210
    L204:
        r55 = r54;
        goto L205
    L183:
        if (r47.getW() < r50) goto L185;
    L208:
        r43 = null;
        goto L209
    L185:
        if (r47.getH() >= r52) goto L208;
        if (r47.j() >= r53) goto L208;
        r113.put("width", r47.getW());     // Catch: Exception -> L193
        r113.put("height", r47.getH());     // Catch: Exception -> L193
        r113.put("bitparseLiveRtcOtherrate_kbps", r47.j());     // Catch: Exception -> L193
        r113.put("bitrate_kbps", r47.j());     // Catch: Exception -> L193
        r49.put("rtc_video_param_1v1_client", r113);     // Catch: Exception -> L193
        JSONObject r56 = r49.optJSONObject("rtc_video_param_1v1_server");     // Catch: Exception -> L193
        if (r56 == null) goto L191;
        r56.put("width", r47.getW());     // Catch: Exception -> L193
        r56.put("height", r47.getH());     // Catch: Exception -> L193
        r56.put("bitparseLiveRtcOtherrate_kbps", r47.j());     // Catch: Exception -> L193
        r56.put("bitrate_kbps", r47.j());     // Catch: Exception -> L193
        r49.put("rtc_video_param_1v1_server", r56);     // Catch: Exception -> L193
    L191:
        r48.put("live_rtc_video_param", r49);     // Catch: Exception -> L193
        r33 = r48.toString();     // Catch: Exception -> L193
    L207:
        r112 = "handlePushModeChange";
    L195:
        e = e;
    L196:
        r112 = "handlePushModeChange";
    L197:
        e = e;
    L198:
        r111 = r34;
    L199:
        e = e;
        r114 = r33;
        r115 = "";
    L206:
        r114 = r33;
        r111 = r34;
    L155:
        r39 = false;
    L211:
        r42 = "handlePushModeChange";
        r43 = null;
    L98:
        Map<Long, String> r57 = this.e;
        if (r57 == null) goto L142;
        String r117 = r57.get(Long.valueOf(this.f));
        if (r117 == null) goto L142;
        i r118 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r118 == null) goto L142;
        y r58 = (y) this.i.getValue();
        int r119 = this.f;
        r58.getClass();
        Intrinsics.checkNotNullParameter(r117, "liveCoreInfo");
        com.bytedance.android.live.revlink.impl.settings.live.b r59 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        h r60 = r59.a();
        Intrinsics.checkNotNullParameter(r60, "$this$isLiveCoreEnable");
        if (r60.getEnable() == false) goto L111;
        Map<Integer, h.b> r62 = r60.n4();
        if (r62 == null) goto L111;
        if ((!r62.isEmpty()) != true) goto L111;
        boolean r63 = true;
    L112:
        if (r63 == true) goto L114;
    L140:
        r117 = r58.a(r117);
    L141:
        r118.T(r117, "handlePushModeChange");
        goto L142
    L114:
        if (y.b() == false) goto L140;
        Map<Integer, h.b> r64 = r59.a().n4();
        if (r64 == null) goto L141;
        h.b r65 = r64.get(Integer.valueOf(r119));
        if (r65 == null) goto L141;
        if (r11.i.b(r65) == false) goto L141;
        JSONObject r66 = new JSONObject(r117);     // Catch: Exception -> L135
        JSONObject r67 = r66.optJSONObject("PushBase");     // Catch: Exception -> L135
        if (r67 == null) goto L141;
        int r68 = r67.optInt("cap_adapted_width", -1);     // Catch: Exception -> L135
        int r120 = r67.optInt("cap_adapted_height", -1);     // Catch: Exception -> L135
        if (r68 <= 0) goto L141;
        if (r120 <= 0) goto L141;
        if (r65.getW() >= r68) goto L141;
        if (r65.getH() >= r120) goto L141;
        r67.put("cap_adapted_width", r65.getW());     // Catch: Exception -> L135
        r67.put("cap_adapted_height", r65.getH());     // Catch: Exception -> L135
        r66.put("PushBase", r67);     // Catch: Exception -> L135
        r117 = r66.toString();     // Catch: Exception -> L135
    L135:
        e = move-exception;
        String r69 = e.getMessage();
        if (r69 != null) goto L139;
        r69 = "";
    L139:
        jy0.b.c("RevLinkParamsAdjustUtils", "interceptLiveCoreExt error".concat(r69), null, 4);
    L111:
        r63 = false;
        goto L112
    L5:
        r2 = -1;
        goto L6
    }

    public final void onStart() {
        Observable r0 = yz0.h.a.a(this.l, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        final AnonymousClass1 r1 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribe(new a(r1)), this.a);
        d(this, getContext().e, getContext().f, getContext().g, getContext().h, "start");
        com.bytedance.android.live.revlink.impl.multianchor.service.g r2 = a();
        if (r2 == null) goto L8;
        NextLiveData<String> r3 = r2.mo697d();
        if (r3 == null) goto L9;
        r3.observeForever(this.j);
        return;
    L9:
        return;
    }

    public final void onStop() {
        this.a.clear();
        com.bytedance.android.live.revlink.impl.multianchor.service.g r0 = a();
        if (r0 == null) goto L8;
        NextLiveData<String> r1 = r0.mo697d();
        if (r1 == null) goto L9;
        r1.removeObserver(this.j);
        return;
    L9:
        return;
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.service.g a() {
        RevLinkWindowRegionContext r0 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this);
        if (r0 == null) goto L7;
        j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r1 = r0.getPartnerService();
        if (r1 == null) goto L7;
        return (com.bytedance.android.live.revlink.impl.multianchor.service.g) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public g getContext() {
        return this.m;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.revlink.link.streaminteract.biz.PushModeManagerService$onPartnerEnableObserver$1] */
    public PushModeManagerService(com.bytedance.android.livesdk.revenue.service.room.c r2, f r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "revRoomService");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.a = new CompositeDisposable();
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = LazyKt.lazy(new PushModeManagerService$adjuster$2(this));
        this.j = new PushModeManagerService$onPartnerEnableObserver$1(this);
    }

    public static void d(PushModeManagerService r9, Map r10, Map r12, Map r13, Map r14, String r15) {
        r9.getClass();
        Intrinsics.checkNotNullParameter(r15, "source");
        Intrinsics.checkNotNullParameter("", "logID");
        if (r10 == null) goto L5;
        r9.d = r10;
    L5:
        if (r12 == null) goto L7;
        r9.e = r12;
    L7:
        if (r13 == null) goto L9;
        r9.b = r13;
    L9:
        if (r14 == null) goto L11;
        r9.c = r14;
    L11:
        ArrayList r16 = new ArrayList();
        int r17 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.b;
        Iterator r18 = CollectionsKt.listOf(new com.bytedance.android.live.revlink.link.streaminteract.biz.a[]{com.bytedance.android.live.revlink.link.streaminteract.biz.a.s.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.b.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.e.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.c.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.d.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.C0204a.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.p.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.q.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.f.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.g.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.h.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.i.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.k.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.j.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.l.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.n.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.m.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.o.c, com.bytedance.android.live.revlink.link.streaminteract.biz.a.r.c}).iterator();
    L12:
        Map r6 = null;
        String r7 = null;
        if (r18.hasNext() == false) goto L38;
        com.bytedance.android.live.revlink.link.streaminteract.biz.a r3 = (com.bytedance.android.live.revlink.link.streaminteract.biz.a) r18.next();
        if (Intrinsics.areEqual(r3, com.bytedance.android.live.revlink.link.streaminteract.biz.a.s.c) == true) goto L12;
        if (r12 == null) goto L19;
        String r8 = (String) r12.get(Long.valueOf(r3.a));
    L20:
        if (r8 != null) goto L22;
    L25:
        boolean r19 = true;
    L26:
        if (r19 == true) goto L36;
        if (r10 == null) goto L29;
        r7 = (String) r10.get(Long.valueOf(r3.a));
    L29:
        if (r7 != null) goto L31;
    L34:
        boolean r20 = true;
    L35:
        if (r20 == false) goto L12;
    L31:
        if (r7.length() == 0) goto L34;
        r20 = false;
    L36:
        r16.add(Integer.valueOf(r3.a));
        goto L12
    L22:
        if (r8.length() == 0) goto L25;
        r19 = false;
        goto L26
    L19:
        r8 = null;
        goto L20
    L38:
        if (r16.size() == 0) goto L55;
        v r110 = com.bytedance.android.live.revlink.link.biz.service.i.H(r9);
        if (r12 == null) goto L47;
        LinkedHashMap r4 = new LinkedHashMap(MapsKt.mapCapacity(r12.size()));
        Iterator r111 = r12.entrySet().iterator();
    L44:
        if (r111.hasNext() == false) goto L46;
        Map.Entry r5 = (Map.Entry) r111.next();
        r4.put(Long.valueOf(((Number) r5.getKey()).longValue()), r5.getValue());
        goto L44
    L46:
        Map r112 = MapsKt.toMap(r4);
    L48:
        if (r10 == null) goto L54;
        LinkedHashMap r22 = new LinkedHashMap(MapsKt.mapCapacity(r10.size()));
        Iterator r113 = r10.entrySet().iterator();
    L51:
        if (r113.hasNext() == false) goto L53;
        Map.Entry r23 = (Map.Entry) r113.next();
        r22.put(Long.valueOf(((Number) r23.getKey()).longValue()), r23.getValue());
        goto L51
    L53:
        r6 = MapsKt.toMap(r22);
    L54:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r16, "missMode");
        Intrinsics.checkNotNullParameter(r15, "source");
        Intrinsics.checkNotNullParameter("", "logID");
        LinkedHashMap r114 = new LinkedHashMap();
        r114.put("live_core_data", String.valueOf(r112));
        r114.put("rtc_data", String.valueOf(r6));
        r114.put("miss_mode", r16);
        r114.put("source", r15);
        r114.put("log_id", "");
        r110.H("miss_live_core_rtc_data", r114);
        goto L55
    L47:
        r112 = null;
    L55:
        r9.c();
    }
}
