package com.bytedance.android.live.room.discovery.stable;

import com.bytedance.android.live.broadcast.api.stable.AbsAnchorFactor;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.di;
import com.bytedance.android.livesdk.config.ei;
import com.bytedance.android.livesdk.config.fi;
import com.bytedance.android.livesdk.config.gi;
import com.bytedance.android.livesdk.config.hi;
import com.bytedance.android.livesdk.config.ii;
import com.bytedance.android.livesdk.config.iq0;
import com.bytedance.android.livesdk.config.vh;
import com.bytedance.android.livesdk.config.y71;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorStreamFPSLevelFactor extends AbsAnchorFactor<Double> {
    public int b;
    public final DataCenter c;

    public final String a() {
        return "anchor_stream_fps";
    }

    public final Object b() {
        IPerformanceManager r0 = k.f(IPerformanceManager.class);
        if (r0 == null) goto L128;
        double r3 = r0.getStreamRealFps();
        RoomSpecificSceneTypeInfo r1 = z.o(this.c).getSceneTypeInfo();
        int r6 = 1;
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L12:
        if (v.a() == false) goto L31;
        String r9 = (String) ii.a.getValue();
        if (r9 == null) goto L31;
        if (r9.length() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 != true) goto L31;
        if (this.b != 0) goto L23;
        ALogger.i("AnchorStableMode", "mock fps list = ".concat(r9));
    L23:
        List r4 = StringsKt.split$default(r9, new String[]{","}, false, 0, 6, null);
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r8 = r4.iterator();
    L25:
        if (r8.hasNext() == false) goto L28;
        r5.add(Integer.valueOf(CastIntegerProtector.parseInt((String) r8.next())));
        goto L25
    L28:
        if (this.b < r5.size()) goto L30;
        this.b = 0;
    L30:
        int r10 = this.b;
        this.b = r10 + 1;
        r3 = ((Number) ListProtector.get(r5, r10)).intValue();
        goto L31
    L18:
        r7 = false;
    L31:
        ALogger.i("AnchorStableMode", "get cur fps = " + r3);
        ALogger.i("AnchorPerfMonitorWidget", "isVerticalLandscape:" + r2);
        if (r3 == (-1.0d)) goto L112;
        List<Integer> r12 = com.bytedance.android.live.room.discovery.a.a;
        ArrayList r13 = (ArrayList) r12;
        if (r13.size() < ((((Number) hi.a.getValue()).intValue() * 3) / 2)) goto L36;
        ListProtector.remove(r12, 0);
    L36:
        LiveMode r14 = null;
        if (((Boolean) vh.a.getValue()).booleanValue() == false) goto L56;
        RoomContext.a r15 = RoomContext.Companion;
        RoomContext r16 = RoomContext.a.c(r15, null, 0, 3);
        if (r16 == null) goto L43;
        i r17 = r16.getLiveMode();
        if (r17 == null) goto L43;
        LiveMode r18 = (LiveMode) r17.getValue();
    L45:
        if (r18 == LiveMode.VIDEO) goto L54;
        RoomContext r19 = RoomContext.a.c(r15, null, 0, 3);
        if (r19 == null) goto L51;
        i r20 = r19.getLiveMode();
        if (r20 == null) goto L51;
        LiveMode r22 = (LiveMode) r20.getValue();
    L53:
        if (r22 != LiveMode.MEDIA) goto L56;
    L51:
        r22 = null;
    L54:
        if (r2 == true) goto L56;
        boolean r23 = true;
    L58:
        if (((y71) iq0.a.getValue()).a() == false) goto L68;
        RoomContext r24 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r24 == null) goto L65;
        i r25 = r24.getLiveMode();
        if (r25 == null) goto L65;
        r14 = (LiveMode) r25.getValue();
    L65:
        if (r14 != LiveMode.SCREEN_RECORD) goto L68;
        if (r2 == true) goto L68;
        boolean r26 = true;
    L70:
        if (r3 >= ((Float) di.a.getValue()).floatValue()) goto L73;
        int r27 = 4;
    L82:
        if (r23 == true) goto L86;
        if (r26 == true) goto L86;
        if (r27 != 4) goto L86;
        r27 = 3;
    L86:
        if (r27 == 2) goto L88;
    L90:
        r6 = r27;
    L91:
        r13.add(Integer.valueOf(r6));
        Iterator r28 = r13.iterator();
        int r29 = 0;
        int r30 = 0;
        int r32 = 0;
        int r33 = 0;
    L93:
        if (r28.hasNext() == false) goto L104;
        int r34 = ((Number) r28.next()).intValue();
        if (r34 != 0) goto L96;
        r29 = r29 + 1;
        goto L93
    L96:
        if (r34 != 2) goto L97;
        r30 = r30 + 1;
        goto L93
    L97:
        if (r34 != 3) goto L98;
        r32 = r32 + 1;
        goto L93
    L98:
        if (r34 != 4) goto L93;
        r33 = r33 + 1;
        goto L93
    L104:
        HashMap<Integer, Integer> r35 = com.bytedance.android.live.room.discovery.a.b;
        r35.put(0, Integer.valueOf(r29));
        r35.put(2, Integer.valueOf(r30));
        r35.put(3, Integer.valueOf(r32));
        r35.put(4, Integer.valueOf(r33));
        hi r36 = hi.a;
        if (r33 >= ((Integer) r36.getValue()).intValue()) goto L112;
        if ((r32 + r33) >= ((Integer) r36.getValue()).intValue()) goto L112;
        ((Integer) r36.getValue()).intValue();
        goto L112
    L88:
        if (com.bytedance.android.livesdk.config.setting.b.a() == true) goto L90;
    L73:
        if (r3 >= ((Float) fi.a.getValue()).floatValue()) goto L76;
        r27 = 3;
        goto L82
    L76:
        if (r3 >= ((Float) gi.a.getValue()).floatValue()) goto L79;
        r27 = 2;
        goto L82
    L79:
        if (r3 < ((Float) ei.a.getValue()).floatValue()) goto L81;
        r27 = 0;
        goto L82
    L81:
        r27 = 1;
    L68:
        r26 = false;
    L43:
        r18 = null;
    L56:
        r23 = false;
    L112:
        return Double.valueOf(r3);
    L8:
        if (r1.isLandscapeVertical() != true) goto L10;
        r2 = true;
        goto L12
    L128:
        return Double.valueOf(-1.0d);
    }

    public AnchorStreamFPSLevelFactor(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.c = r3;
        List<Integer> r4 = com.bytedance.android.live.room.discovery.a.a;
        ((ArrayList) com.bytedance.android.live.room.discovery.a.a).clear();
        com.bytedance.android.live.room.discovery.a.b.clear();
        new com.bytedance.android.live.broadcast.api.stable.c("anchor_stream_fps_good_count", AnchorStreamFPSLevelFactor$goodCountFactor$1.INSTANCE);
        new com.bytedance.android.live.broadcast.api.stable.c("anchor_stream_fps_risk_count", AnchorStreamFPSLevelFactor$riskCountFactor$1.INSTANCE);
        new com.bytedance.android.live.broadcast.api.stable.c("anchor_stream_fps_poor_count", AnchorStreamFPSLevelFactor$poorCountFactor$1.INSTANCE);
        new com.bytedance.android.live.broadcast.api.stable.c("anchor_stream_fps_bad_count", AnchorStreamFPSLevelFactor$badCountFactor$1.INSTANCE);
    }
}
