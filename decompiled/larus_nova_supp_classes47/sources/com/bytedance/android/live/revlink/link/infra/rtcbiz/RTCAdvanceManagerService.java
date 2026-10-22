package com.bytedance.android.live.revlink.link.infra.rtcbiz;

import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenuelink.rtc.e;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j5;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.p;
import ey.l;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yz0.f;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RTCAdvanceManagerService extends e implements o, k {
    public static final /* synthetic */ int k = 0;
    public final NextLiveData<Long> a;
    public Disposable b;
    public final CompositeDisposable c;
    public long d;
    public final b e;
    public final com.bytedance.android.live.revlink.impl.global.c f;
    public final i g;
    public final ld.a h;
    public final u51.a i;
    public final f j;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.live.revenuelink.connect.d {
        public final /* synthetic */ RTCAdvanceManagerService a;

        public b(RTCAdvanceManagerService r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void A3(d11.d r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r3, "params");
            this.a.a.setValue(0L);
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Tg(int r10, i6 r12, l r13) {
            Intrinsics.checkNotNullParameter(r12, "_linkerMessage");
            i6 r14 = r12.castTo(i6.class);
            k6 r15 = r14.getReply();
            String r16 = null;
            if (r15 == null) goto L5;
            Integer r17 = Integer.valueOf(r15.getToBizType());
        L6:
            int r0 = BizType.PK.ordinal();
            if (r17 != null) goto L10;
        L11:
            int r1 = BizType.OpenGame.ordinal();
            if (r17 != null) goto L15;
            return;
        L15:
            if (r17.intValue() == r1) goto L17;
            return;
        L17:
            k6 r18 = r14.getReply();
            if (r18 == null) goto L54;
            boolean r2 = true;
            if (((int) r18.getReplyStatus()) != 1) goto L55;
            JSONObject r19 = new JSONObject();
            i97.a r3 = i97.a.a;
            r19.put("ts", System.currentTimeMillis());
            r19.put("channel_id", this.a.i.Ud());
            r19.put("status", 1);
            Disposable r4 = this.a.b;
            if (r4 == null) goto L25;
            r4.dispose();
        L25:
            com.bytedance.android.live.revlink.impl.settings.live.c r5 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
            r5.getClass();
            int r6 = ((Number) com.bytedance.android.live.revlink.impl.settings.live.c.p.getValue(r5, com.bytedance.android.live.revlink.impl.settings.live.c.a[14])).intValue();
            k6 r7 = r14.getReply();
            if (r7 == null) goto L31;
            j5 r8 = r7.getFromLinkmicInfo();
            if (r8 == null) goto L31;
            r16 = r8.getInteractIdStr();
        L31:
            if (r16 != null) goto L33;
        L36:
            if (r2 == false) goto L44;
            k6 r110 = r14.getReply();
            if (r110 == null) goto L50;
            j5 r111 = r110.getToLinkmicInfo();
            if (r111 == null) goto L50;
            String r112 = String.valueOf(r111.getInteractId());
            if (r112 == null) goto L50;
        L51:
            RTCAdvanceManagerService r113 = this.a;
            com.bytedance.revenue.platform.api.core.rx.l r9 = com.bytedance.revenue.platform.api.core.rx.l.a;
            int r20 = p.a;
            r113.b = Observable.interval(0, r6, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.link.infra.rtcbiz.c(this, r19, r112));
            return;
        L50:
            r112 = "";
            goto L51
        L44:
            k6 r114 = r14.getReply();
            if (r114 == null) goto L50;
            j5 r115 = r114.getToLinkmicInfo();
            if (r115 == null) goto L50;
            r112 = r115.getInteractIdStr();
            if (r112 != null) goto L51;
        L33:
            if (r16.length() == 0) goto L36;
            r2 = false;
            goto L36
        L55:
            return;
        L54:
            return;
        L10:
            if (r17.intValue() == r0) goto L17;
        L5:
            r17 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void ej(int r1, i6 r2, l r3) {
            Intrinsics.checkNotNullParameter(r2, "linkerMessage");
            this.a.a.setValue(0L);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.infra.rtcbiz.RTCAdvanceManagerService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass1(RTCAdvanceManagerService r8) {
            super(1, r8, RTCAdvanceManagerService.class, "onRTCDataChanged", "onRTCDataChanged(Ljava/lang/String;)V", 0);
        }

        public final void invoke(String r6) {
            RTCAdvanceManagerService r0 = (RTCAdvanceManagerService) ((CallableReference) this).receiver;
            int r1 = RTCAdvanceManagerService.k;
            r0.getClass();
            v41.a r2 = v41.a.m;
            r2.getClass();
            if (((Boolean) v41.a.b.getValue(r2, v41.a.a[0])).booleanValue() == false) goto L23;
            if (r6 != null) goto L8;
            return;
        L8:
            if (StringsKt.contains$default(r6, "pk_rts_key", false, 2, null) == false) goto L10;
        L20:
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
            r0.j(new JSONObject(r6), IPKLinkBizDataService.OpenBattleSource.SEIAck.getSource());     // Catch: Throwable -> L14
            Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L16:
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L22;
            jy0.b.c("RTCAdvanceManagerService", "parse rtc sei error: " + r8.getMessage(), null, 4);
            return;
        L22:
            return;
        L14:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        L10:
            if (StringsKt.contains$default(r6, "pk_rtc_sei_key", false, 2, null) == true) goto L20;
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.infra.rtcbiz.RTCAdvanceManagerService$onStart$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/r0;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/bridge/r0;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<r0, Unit> {
        public AnonymousClass2(RTCAdvanceManagerService r8) {
            super(1, r8, RTCAdvanceManagerService.class, "onLinkMicBattleMsg", "onLinkMicBattleMsg(Lcom/bytedance/android/livesdk/link/model/bridge/ILinkMicBattleMessageBridge;)V", 0);
        }

        public final void invoke(r0 r4) {
            Intrinsics.checkNotNullParameter(r4, "p1");
            RTCAdvanceManagerService r0 = (RTCAdvanceManagerService) ((CallableReference) this).receiver;
            int r1 = RTCAdvanceManagerService.k;
            r0.getClass();
            c5 r5 = r4.castTo(c5.class);
            Disposable r6 = r0.b;
            if (r6 == null) goto L5;
            r6.dispose();
        L5:
            jy0.b.c("RTCAdvanceManagerService", "resetStatus", null, 4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((r0) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void onStart() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(this.h.e(), new AnonymousClass1(this)), this.c);
        this.g.g1(this);
        com.bytedance.android.live.revenuelink.connect.f r0 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r0 == null) goto L5;
        r0.addLinkOutListener(1, this.e);
    L5:
        com.bytedance.android.live.revenuelink.connect.f r1 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r1 == null) goto L8;
        r1.addLinkOutListener(7, this.e);
    L8:
        Observable r2 = h.a.a(this.j, CommonMessageTypeKt.b(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        final AnonymousClass2 r3 = new AnonymousClass2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r2.subscribe(new c(r3)), this.c);
    }

    public final void onStop() {
        this.c.clear();
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.g.i1(this);
        com.bytedance.android.live.revenuelink.connect.f r1 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r1 == null) goto L8;
        r1.removeLinkOutListener(1, this.e);
    L8:
        com.bytedance.android.live.revenuelink.connect.f r2 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r2 == null) goto L12;
        r2.removeLinkOutListener(7, this.e);
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.f;
    }

    public final void j(JSONObject r7, String r8) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L23
        jy0.b.c("RTCAdvanceManagerService", "receive " + r8 + "  " + r7 + ' ' + this.i.Ud(), null, 4);     // Catch: Throwable -> L23
        if (r7.has("pk_rts_key") == true) goto L10;
        if (r7.has("pk_rtc_sei_key") == true) goto L10;
        return;
    L10:
        if (r7.has("pk_rts_key") == false) goto L12;
        JSONObject r9 = r7.optJSONObject("pk_rts_key");     // Catch: Throwable -> L23
    L13:
        if (r9 != null) goto L15;
        return;
    L15:
        long r0 = r9.optLong("channel_id");     // Catch: Throwable -> L23
        int r10 = r9.optInt("status");     // Catch: Throwable -> L23
        if (r0 == this.i.Ud()) goto L18;
        return;
    L18:
        if (r10 != 1) goto L36;
        this.a.setValue(Long.valueOf(r0));     // Catch: Throwable -> L23
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L37;
        g0 r14 = this.f.Rn();
        r14.getClass();
        JSONObject r1 = new JSONObject();
        int r3 = y50.b.a;
        String r15 = ExceptionsKt.stackTraceToString(r13);
        if (r15 != null) goto L30;
        r15 = "";
    L30:
        y50.b.a.d(r1, "throwable", r15);
        v r16 = r14.o();
        if (r16 == null) goto L38;
        int r17 = v.i;
        r16.I("rtc_sei_parse_failure", r1, false);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L12:
        r9 = JSONObjectProtectorUtils.getJSONObject(r7, "pk_rtc_sei_key");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void u1(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        j(new JSONObject(r2), IPKLinkBizDataService.OpenBattleSource.RTSAck.getSource());     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public RTCAdvanceManagerService(RTCBizManagerService r2, com.bytedance.android.live.revlink.impl.global.c r3, i r4, ld.a r5, u51.a r6, f r7) {
        Intrinsics.checkNotNullParameter(r2, "bizManagerService");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r4, "anchorRtcManager");
        Intrinsics.checkNotNullParameter(r5, "linkInternalDataSet");
        Intrinsics.checkNotNullParameter(r6, "revLinkHostService");
        Intrinsics.checkNotNullParameter(r7, "messageManagerService");
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        NextLiveData<Long> r8 = new NextLiveData();
        r8.setValue(0L);
        Unit r9 = Unit.INSTANCE;
        this.a = r8;
        this.c = new CompositeDisposable();
        this.d = -3;
        this.e = new b(this);
    }
}
