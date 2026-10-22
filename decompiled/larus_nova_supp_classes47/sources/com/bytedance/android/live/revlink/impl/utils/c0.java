package com.bytedance.android.live.revlink.impl.utils;

import android.net.Uri;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseQuality;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlKt_androidKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ d0 a;

    public c0(d0 r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        Integer r14 = (Integer) r13;
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r0).b(or2.d.class);
        Intrinsics.checkNotNull(r15);
        boolean r16 = ((com.bytedance.live.kmp.core.c) r15).isPlaying();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.a.d;
        if (r1 == null) goto L8;
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = r1.Do();
        if (r2 == null) goto L8;
        if (r2.dc() != true) goto L8;
        return;
    L8:
        if (r16 == false) goto L100;
        d0 r17 = this.a;
        com.bytedance.android.live.revlink.impl.global.c r3 = r17.d;
        com.bytedance.android.live.revenuelink.f r4 = null;
        if (r3 == null) goto L12;
        s r5 = r3.getRevLinkCommonUtil();
    L13:
        if (r5 == null) goto L101;
        IRoom r6 = r5.a();
        if (r6 == null) goto L102;
        IBaseStreamUrl r7 = IRoomKt_androidKt.getStreamUrlKt(r6);
        if (r7 == null) goto L103;
        List r8 = IBaseStreamUrlKt_androidKt.getQualityListEx(r7);
        if (r8 == null) goto L104;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r8.iterator();
    L22:
        if (r10.hasNext() == false) goto L29;
        T r12 = r10.next();
        if (((IBaseQuality) r12).getDisable() != 0) goto L26;
        boolean r18 = true;
    L27:
        if (r18 == false) goto L22;
        r9.add(r12);
        goto L22
    L26:
        r18 = false;
        goto L27
    L29:
        List r19 = CollectionsKt.reversed(r9);
        if (r19 == null) goto L105;
        JSONObject r20 = new JSONObject();
        cy0.e.a.getClass();
        cy0.j r22 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r22).b(or2.d.class);
        Intrinsics.checkNotNull(r23);
        or2.d r24 = (com.bytedance.live.kmp.core.c) r23;
        String r25 = r24.getCurrentResolution();
        if (((Number) r17.f.invoke()).intValue() != 1) goto L34;
        LiveTracingMonitorKt.EventModule r26 = LiveTracingMonitorKt.EventModule.PK;
    L35:
        com.bytedance.android.live.revlink.impl.global.c r27 = r17.d;
        if (r27 == null) goto L38;
        s r28 = r27.getRevLinkCommonUtil();
    L39:
        if (r28 == null) goto L43;
        vh7.c r29 = r28.a();
        if (r29 == null) goto L43;
        IMainRoom r30 = (IMainRoom) r29.castTo(IMainRoom.class);
    L44:
        String r32 = r24.u2();
        if (r32 == null) goto L63;
        int r33 = com.bytedance.revenue.platform.api.core.e.a;
        Intrinsics.checkNotNullParameter(r32, "schemeString");
        Uri r34 = UriProtector.parse(r32);
        String r35 = r34.getPath();
        String r110 = "";
        if (r35 != null) goto L49;
        r35 = "";
    L49:
        r20.put("stream_url", r35);
        String r36 = r34.getHost();
        if (r36 != null) goto L52;
        r36 = "";
    L52:
        r20.put("host", r36);
        if (r25 == null) goto L56;
        r110 = r25;
    L56:
        r20.put("resolution", r110);
        if (r30 == null) goto L60;
        String r37 = String.valueOf(r30.getPlatform());
        if (r37 == null) goto L60;
    L61:
        r20.put("anchor_platform", r37);
    L60:
        r37 = "-1";
    L63:
        if (Intrinsics.areEqual(r25, "origin") == false) goto L70;
        com.bytedance.android.live.revlink.impl.global.c r38 = r17.d;
        if (r38 == null) goto L67;
        r4 = r38.getRevenueLinkTraceMonitor();
    L67:
        com.bytedance.android.live.revenuelink.f r39 = r4;
        if (r39 == null) goto L106;
        r39.Z("pk_stream_sei_opt", r26, new HashMap(), r20, r17.e);
        return;
    L106:
        return;
    L70:
        Iterator r40 = r19.iterator();
    L72:
        if (r40.hasNext() == false) goto L111;
        IBaseQuality r42 = (IBaseQuality) r40.next();
        if (Intrinsics.areEqual(r42.getSdkKey(), "origin") == true) goto L75;
        if ((!Intrinsics.areEqual(r42.getSdkKey(), r25)) == false) goto L72;
        r17.a = r25;
        r24.on(r42.getSdkKey());
        r20.put("change", r42.getSdkKey());
        com.bytedance.android.live.revlink.impl.global.c r43 = r17.d;
        if (r43 == null) goto L86;
        r4 = r43.getRevenueLinkTraceMonitor();
    L86:
        com.bytedance.android.live.revenuelink.f r44 = r4;
        if (r44 == null) goto L110;
        r44.Z("pk_stream_sei_opt", r26, new HashMap(), r20, r17.e);
        return;
    L110:
        return;
    L75:
        r17.a = r25;
        r24.on(r42.getSdkKey());
        r20.put("change", r42.getSdkKey());
        com.bytedance.android.live.revlink.impl.global.c r45 = r17.d;
        if (r45 == null) goto L78;
        r4 = r45.getRevenueLinkTraceMonitor();
    L78:
        com.bytedance.android.live.revenuelink.f r46 = r4;
        if (r46 == null) goto L108;
        r46.Z("pk_stream_sei_opt", r26, new HashMap(), r20, r17.e);
        return;
    L108:
        return;
    L111:
        return;
    L43:
        r30 = null;
        goto L44
    L38:
        r28 = null;
        goto L39
    L34:
        r26 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
        goto L35
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L101:
        return;
    L12:
        r5 = null;
        goto L13
    }
}
