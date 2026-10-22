package com.bytedance.android.live.revlink.impl.audience;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.UriProtector;
import cy0.j;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ boolean b;

    public b(a r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r20) {
        Long r0 = (Long) r20;
        if (this.b == false) goto L89;
        a r2 = this.a;
        String r1 = r2.d.toString();
        r2.d.clear();
        if (r2.f <= 0) goto L8;
        r2.e |= 8;
    L8:
        cy0.e.a.getClass();
        j r4 = cy0.e.a.a;
        m.e.getClass();
        Object r3 = m.b(r4).b(or2.d.class);
        Intrinsics.checkNotNull(r3);
        if (((com.bytedance.live.kmp.core.c) r3).isPlaying() == true) goto L11;
        r2.e |= 16;
    L11:
        Object r5 = m.b(r4).b(or2.d.class);
        Intrinsics.checkNotNull(r5);
        if (((com.bytedance.live.kmp.core.c) r5).getPlayPrepared() == true) goto L14;
        r2.e |= 32;
    L14:
        Object r6 = m.b(r4).b(or2.d.class);
        Intrinsics.checkNotNull(r6);
        if (((com.bytedance.live.kmp.core.c) r6).getHasFirstFrame() == true) goto L17;
        r2.e |= 64;
    L17:
        com.bytedance.android.live.revlink.impl.service.internal.a r7 = null;
        jy0.b.c("ttlive_anchor_link_audience", "reportForSeiTimeout multi=" + r2.h + " errorCode=" + r2.e + " sei=" + r1, null, 4);
        String r8 = "";
        if (r2.h == false) goto L52;
        com.bytedance.android.live.revlink.impl.global.c r9 = r2.g;
        if (r9 == null) goto L22;
        v r10 = r9.getMultiLinkMonitor();
    L23:
        if (r10 == null) goto L58;
        int r12 = r2.e;
        Intrinsics.checkNotNullParameter(r1, "sei");
        JSONObject r15 = new JSONObject();
        int r13 = y50.b.a;
        y50.b.a.d(r15, "business_api_name", "live_pk_audience_sei_timeout");
        y50.b.a.d(r15, "sei", r1);
        y50.b.a.d(r15, "player_is_playing", String.valueOf(r10.r().isPlaying()));
        y50.b.a.d(r15, "player_has_first_frame", String.valueOf(r10.r().getHasFirstFrame()));
        y50.b.a.d(r15, "player_play_prepared", String.valueOf(r10.r().getPlayPrepared()));
        String r14 = r10.r().u2();
        if (r14 != null) goto L27;
        String r16 = "";
    L28:
        y50.b.a.d(r15, "stream_cdn_play_url", r16);
        r10.e(r15);
        jy0.b.c("ttlive_anchor_link_audience", "live_pk_audience_sei_timeout: " + r15, null, 4);
        com.bytedance.android.live.revlink.impl.global.c r17 = r10.d;
        if (r17 == null) goto L31;
        com.bytedance.android.live.revlink.impl.service.internal.a r18 = r17.Do();
    L32:
        if (r18 != null) goto L34;
    L36:
        HashMap r19 = new HashMap();
        r19.put("business_api_name", "live_pk_audience_sei_timeout");
        r19.put("android_event_key", "live_pk_audience_sei_timeout");
        if (r14 != null) goto L87;
    L46:
        com.bytedance.android.live.revlink.impl.global.c r22 = r10.d;
        if (r22 == null) goto L49;
        com.bytedance.android.live.revenuelink.f r23 = r22.getRevenueLinkTraceMonitor();
    L50:
        if (r23 == null) goto L58;
        r23.c0("ttlive_pk_business_api_call", LiveTracingMonitorKt.EventModule.MULTI_LINKER, r12, "", r19, r15);
        goto L58
    L49:
        r23 = null;
        goto L50
    L87:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L43
        int r25 = com.bytedance.revenue.platform.api.core.e.a;     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r14, "schemeString");     // Catch: Throwable -> L43
        String r26 = UriProtector.parse(r14).getPath();     // Catch: Throwable -> L43
        if (r26 != null) goto L41;
        r26 = "";
    L41:
        r19.put("server_api_name", r26);     // Catch: Throwable -> L43
        Object r27 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L45:
        Result.box-impl(r27);
    L43:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L34:
        if (r18.dc() != true) goto L36;
    L31:
        r18 = null;
        goto L32
    L27:
        r16 = r14;
    L58:
        com.bytedance.android.live.revlink.impl.global.c r29 = r2.g;
        if (r29 == null) goto L61;
        d31.f r30 = r29.y2();
    L62:
        if (r30 == null) goto L85;
        int r110 = r2.e;
        if (r2.h == false) goto L66;
        int r111 = 7;
    L67:
        com.bytedance.android.live.revlink.impl.global.c r32 = r2.g;
        if (r32 == null) goto L70;
        LinkRevInternalServiceContext r33 = r32.Cj();
    L71:
        if (r33 == null) goto L77;
        com.bytedance.live.datacontext.m<Boolean> r34 = r33.isAppBackground();
        if (r34 == null) goto L77;
        if (((Boolean) r34.getValue()).booleanValue() != true) goto L77;
        r8 = "background";
    L84:
        d31.f.f(r30, "live_pk_audience_sei_timeout", r110, null, r111, 0, r8, null, null, 212);
    L77:
        com.bytedance.android.live.revlink.impl.global.c r35 = r2.g;
        if (r35 == null) goto L80;
        r7 = r35.Do();
    L80:
        if (r7 == null) goto L84;
        if (r7.dc() != true) goto L84;
        r8 = "live_background";
        goto L84
    L70:
        r33 = null;
        goto L71
    L66:
        r111 = 1;
    L85:
        this.a.c = false;
        return;
    L61:
        r30 = null;
        goto L62
    L22:
        r10 = null;
        goto L23
    L52:
        com.bytedance.android.live.revlink.impl.global.c r36 = r2.g;
        if (r36 == null) goto L55;
        LiveFullLinkPKMonitor r37 = r36.getLiveFullLinkPKMonitor();
    L56:
        if (r37 == null) goto L58;
        r37.j(r2.e, r1);
        goto L58
    L55:
        r37 = null;
        goto L56
    }
}
