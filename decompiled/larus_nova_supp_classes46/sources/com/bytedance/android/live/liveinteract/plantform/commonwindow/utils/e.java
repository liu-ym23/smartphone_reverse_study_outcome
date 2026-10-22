package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.js;
import com.bytedance.android.livesdk.config.la1;
import com.bytedance.android.livesdk.config.qa1;
import com.bytedance.android.livesdk.config.va1;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSuperResolutionMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import yb6.j;
import zf2.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final Map<String, Integer> a = null;
    public static long b;
    public static final a c = null;

    public static final class a {
        public a() {
        }

        public static boolean b(j1 r12) {
            boolean r0 = Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE);
            if (r0 == true) goto L5;
        L7:
            if (r0 == false) goto L9;
        L11:
            Map r2 = (Map) va1.a.getValue();
            if (r0 == false) goto L14;
            String r1 = "1";
        L15:
            Map r3 = (Map) r2.get(r1);
            if (r3 != null) goto L19;
            return false;
        L19:
            if (r3.isEmpty() == false) goto L23;
            ALogger.w("MultiLinkSRUtils", "config is empty");
            return false;
        L23:
            if (Intrinsics.areEqual(r3.get("enable"), Boolean.FALSE) == false) goto L26;
            ALogger.w("MultiLinkSRUtils", "config is not enable");
            return false;
        L26:
            Object r4 = r3.get("ui_layouts_exclude_enable");
            Object r5 = null;
            if ((r4 instanceof Boolean) == true) goto L29;
            r4 = null;
        L29:
            Boolean r6 = (Boolean) r4;
            if (r6 == null) goto L32;
            boolean r7 = r6.booleanValue();
        L33:
            Object r8 = r3.get("ui_layouts");
            if ((r8 instanceof List) == true) goto L36;
            r8 = null;
        L36:
            List r9 = (List) r8;
            Integer r10 = je0.d.h();
            double r11 = 0.0d;
            if (r10 == null) goto L39;
            double r13 = r10.intValue();
        L41:
            if (r7 == true) goto L52;
            if (r9 != null) goto L44;
        L50:
            ALogger.w("MultiLinkSRUtils", "ui layouts is invalid");
            return false;
        L44:
            if (r9.isEmpty() == true) goto L50;
            if (r9.contains(Double.valueOf(r13)) == true) goto L57;
            c("unsupported ui layouts", null, r12);
            return false;
        L57:
            Object r14 = r3.get("sr_config_list");
            if ((r14 instanceof List) == true) goto L60;
            r14 = null;
        L60:
            List r15 = (List) r14;
            if (r15 != null) goto L63;
        L92:
            ALogger.w("MultiLinkSRUtils", "sr config list is invalid");
            return false;
        L63:
            if (r15.isEmpty() == true) goto L92;
            if (r12 == null) goto L73;
            cg6.a r16 = r12.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r16 == null) goto L73;
            vb6.g r17 = r16.O5();
            if (r17 == null) goto L73;
            yb6.e r18 = r17.j();
            if (r18 == null) goto L73;
            Map r19 = r18.m();
        L74:
            if (r19 != null) goto L76;
        L90:
            ALogger.w("MultiLinkSRUtils", "remote view map " + r19 + " is empty");
            return false;
        L76:
            if (r19.isEmpty() == true) goto L90;
            Object r110 = r3.get("interval");
            if ((r110 instanceof Double) == false) goto L82;
            r5 = r110;
        L82:
            Double r20 = (Double) r5;
            if (r20 == null) goto L86;
            r11 = r20.doubleValue();
        L86:
            if ((System.currentTimeMillis() - e.b) > (((int) r11) * 1000)) goto L88;
            return false;
        L88:
            e.b = System.currentTimeMillis();
            return true;
        L73:
            r19 = null;
            goto L74
        L52:
            if (r9 == null) goto L57;
            if (r9.contains(Double.valueOf(r13)) != true) goto L57;
            c("unsupported ui layouts", null, r12);
            return false;
        L39:
            r13 = 0.0d;
            goto L41
        L32:
            r7 = false;
            goto L33
        L14:
            r1 = "0";
            goto L15
        L9:
            if (((Boolean) qa1.a.getValue()).booleanValue() == true) goto L11;
            return false;
        L5:
            if (((Boolean) la1.a.getValue()).booleanValue() == true) goto L7;
            return false;
        }

        public static k0 d(String r7) {
            List r0 = StringsKt.split$default(r7, new String[]{":"}, false, 0, 6, null);
            if (r0.size() >= 2) goto L7;
            ALogger.e("MultiLinkSRUtils", "invalid record key " + r7);
            return null;
        L7:
            return new k0((String) ListProtector.get(r0, 0), (String) ListProtector.get(r0, 1), LiveWrappedStreamIndex.STREAM_INDEX_MAIN);
        }

        public static void f(List r13, j1 r14) {
            Intrinsics.checkNotNullParameter(r13, "regionList");
            if (b(r14) == true) goto L5;
            return;
        L5:
            com.bytedance.live.datacontext.m r0 = m.i().getRoom();
            int r1 = 0;
            if (r0 == null) goto L12;
            IRoom r2 = (IRoom) r0.getValue();
            if (r2 == null) goto L12;
            IStreamUrlExtra r3 = r2.getStreamUrlExtra();
            if (r3 == null) goto L12;
            int r4 = r3.getWidth();
        L13:
            com.bytedance.live.datacontext.m r5 = m.i().getRoom();
            if (r5 == null) goto L20;
            IRoom r6 = (IRoom) r5.getValue();
            if (r6 == null) goto L20;
            IStreamUrlExtra r7 = r6.getStreamUrlExtra();
            if (r7 == null) goto L20;
            r1 = r7.getHeight();
        L20:
            Iterator r15 = r13.iterator();
        L22:
            if (r15.hasNext() == false) goto L27;
            ti6.f r8 = (ti6.f) r15.next();
            if (Intrinsics.areEqual(r8.c, je0.d.b0()) == true) goto L22;
            double r9 = (((double) r4) * r8.f) * 1.0d;
            double r10 = (((double) r1) * r8.g) * 1.0d;
            a(r8.b, r9, r10, r14);
            goto L22
        L27:
            return;
        L12:
            r4 = 0;
            goto L13
        }

        public static void g(List r3, Function0 r4) {
            Intrinsics.checkNotNullParameter(r3, "regionList");
            Intrinsics.checkNotNullParameter(r4, "getIMultiLinkComponentService");
            if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L25;
            cg6.a r5 = (cg6.a) r4.invoke();
            if (r5 == null) goto L15;
            vb6.g r6 = r5.O5();
            if (r6 == null) goto L15;
            yb6.e r7 = r6.j();
            if (r7 == null) goto L15;
            ei6.a r8 = r7.Z0();
            if (r8 == null) goto L15;
            fi6.a r9 = r8.g();
            if (r9 == null) goto L15;
            boolean r10 = r9.b();
        L16:
            if (r10 == false) goto L18;
            return;
        L18:
            if (((Boolean) js.a.getValue()).booleanValue() == false) goto L32;
            Iterator r11 = r3.iterator();
        L21:
            if (r11.hasNext() == false) goto L33;
            ti6.f r12 = (ti6.f) r11.next();
            if (r12.a != 1) goto L21;
            LiveWrappedVideoSuperResolutionMode r1 = LiveWrappedVideoSuperResolutionMode.SCALE_AUTO;
            Intrinsics.checkNotNullParameter(r1, "mode");
            r12.B = r1;
            goto L21
        L33:
            return;
        L32:
            return;
        L15:
            r10 = true;
            goto L16
        }

        public static void c(String r5, String r6, j1 r7) {
            Intrinsics.checkNotNullParameter(r5, "source");
            ConcurrentHashMap r0 = (ConcurrentHashMap) e.a;
            if ((!r0.isEmpty()) == false) goto L23;
            StringBuilder r1 = new StringBuilder("clear SR from [");
            r1.append(r5);
            r1.append("] for ");
            if (r6 != null) goto L7;
            String r3 = "all";
        L8:
            r1.append(r3);
            ALogger.i("MultiLinkSRUtils", r1.toString());
            if (r6 != null) goto L11;
        L16:
            Iterator r8 = r0.keySet().iterator();
        L18:
            if (r8.hasNext() == false) goto L22;
            String r2 = (String) r8.next();
            ALogger.i("MultiLinkSRUtils", "clear SR for " + r2 + " from " + r5);
            k0 r4 = d(r2);
            if (r4 == null) goto L18;
            e.c.getClass();
            e(r4, 0, r7);
            goto L18
        L22:
            ((ConcurrentHashMap) e.a).clear();
            goto L23
        L11:
            if ((!StringsKt.isBlank(r6)) != true) goto L16;
            String r9 = String.valueOf(je0.d.a0());
            String r10 = String.valueOf(r9) + ':' + r6 + ':' + LiveWrappedStreamIndex.STREAM_INDEX_MAIN.value();
            k0 r11 = d(r10);
            if (r11 == null) goto L15;
            e.c.getClass();
            e(r11, 0, r7);
        L15:
            r0.remove(r10);
            goto L23
        L7:
            r3 = r6;
        L23:
            e.b = 0;
        }

        public static void e(k0 r2, int r3, j1 r4) {
            ALogger.i("MultiLinkSRUtils", "setRemoteVideoSuperResolution streamInfo " + r2 + " srMode " + r3);
            if (r4 == null) goto L12;
            cg6.a r5 = r4.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r5 == null) goto L13;
            vb6.g r6 = r5.O5();
            if (r6 == null) goto L14;
            yb6.e r7 = r6.j();
            if (r7 == null) goto L15;
            r7.u(r2, r3);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }

        public static void a(String r23, double r24, double r26, j1 r28) {
            j1 r5 = r28;
            com.bytedance.live.datacontext.m r7 = m.i().getRoom();
            Object r8 = null;
            if (r7 == null) goto L7;
            IRoom r9 = (IRoom) r7.getValue();
            if (r9 == null) goto L7;
            Long r10 = Long.valueOf(r9.getRoomId());
        L8:
            k0 r6 = new k0(String.valueOf(r10), r23, LiveWrappedStreamIndex.STREAM_INDEX_MAIN);
            String r11 = r6.a + ':' + r6.b + ':' + r6.c.value();
            Map r12 = (Map) va1.a.getValue();
            if (r12 != null) goto L11;
            Map r13 = null;
        L16:
            if (r13 != null) goto L18;
            return;
        L18:
            Object r14 = r13.get("is_auto_sr");
            if ((r14 instanceof Boolean) == true) goto L21;
            r14 = null;
        L21:
            Boolean r15 = (Boolean) r14;
            if (r15 == null) goto L24;
            boolean r16 = r15.booleanValue();
        L26:
            if (r16 == false) goto L34;
            ConcurrentHashMap r17 = (ConcurrentHashMap) e.a;
            Integer r18 = (Integer) r17.get(r11);
            if (r18 != null) goto L31;
        L32:
            e(r6, 1, r5);
            ALogger.d("MultiLinkSRUtils", "set VideoSR key " + r11 + " to auto mode");
            r17.put(r11, 1);
            return;
        L31:
            if (r18.intValue() != 1) goto L32;
        L34:
            if (r5 == null) goto L42;
            cg6.a r19 = r5.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r19 == null) goto L42;
            vb6.g r110 = r19.O5();
            if (r110 == null) goto L42;
            yb6.e r111 = r110.j();
            if (r111 == null) goto L42;
            Map r112 = r111.m();
        L43:
            if (r112 != null) goto L45;
            return;
        L45:
            j r0 = (j) r112.get(r23);
            if (r0 == null) goto L48;
            int r113 = r0.b;
        L49:
            if (r0 == null) goto L51;
            int r1 = r0.c;
        L53:
            if ((r1 * r113) != 0) goto L55;
            return;
        L55:
            String r114 = "set VideoSR key ";
            double r115 = RangesKt.coerceAtLeast(r24 / ((double) r113), r26 / ((double) r1));
            Object r20 = r13.get("sr_config_list");
            if ((r20 instanceof List) == false) goto L59;
            r8 = r20;
        L59:
            List r21 = (List) r8;
            if (r21 != null) goto L62;
            return;
        L62:
            Iterator r22 = r21.iterator();
        L64:
            if (r22.hasNext() == false) goto L93;
            Map r116 = (Map) r22.next();
            Double r117 = (Double) r116.get("sr_range_min");
            if (r117 == null) goto L68;
            double r118 = r117.doubleValue();
        L69:
            k0 r119 = r6;
            Iterator r25 = r22;
            double r27 = r118;
            Double r29 = (Double) r116.get("sr_range_max");
            if (r29 == null) goto L72;
            double r120 = r29.doubleValue();
        L73:
            int r121 = r113;
            double r30 = r120;
            if (r115 <= r27) goto L92;
            if (r115 > r30) goto L92;
            Double r122 = (Double) r116.get("sr_mode");
            if (r122 == null) goto L80;
            int r123 = (int) r122.doubleValue();
        L81:
            ConcurrentHashMap r124 = (ConcurrentHashMap) e.a;
            if (r124.containsKey(r11) == false) goto L91;
            Integer r125 = (Integer) r124.get(r11);
            if (r125 == null) goto L91;
            if (r125.intValue() != r123) goto L91;
            j1 r31 = r28;
            k0 r32 = r119;
        L94:
            if (r123 != 0) goto L106;
            ConcurrentHashMap r2 = (ConcurrentHashMap) e.a;
            Integer r3 = (Integer) r2.get(r11);
            if (r3 == null) goto L98;
            int r4 = r3.intValue();
        L99:
            if (r4 <= 0) goto L107;
            e(r32, 0, r31);
            r2.remove(r11);
            ALogger.i("MultiLinkSRUtils", "cancel VideoSR " + r11 + ' ');
            return;
        L107:
            return;
        L98:
            r4 = 0;
            goto L99
        L106:
            return;
        L91:
            ALogger.i("MultiLinkSRUtils", "startSRIfNeeded config " + r21);
            ALogger.i("MultiLinkSRUtils", r114 + r11 + " mode " + r123 + " expVideoSize(" + r24 + ',' + r26 + "),remoteVideoSize(" + r121 + ',' + r1 + ")  scaleRatio" + r115 + " in range(" + r27 + ',' + r30 + ')');
            r31 = r28;
            r32 = r119;
            e(r32, r123, r31);
            r124.put(r11, Integer.valueOf(r123));
            goto L94
        L80:
            r123 = 0;
        L92:
            r113 = r121;
            r114 = r114;
            r22 = r25;
            r6 = r119;
            r5 = r28;
            goto L64
        L72:
            r120 = Double.MIN_VALUE;
            goto L73
        L68:
            r118 = Double.MAX_VALUE;
            goto L69
        L93:
            k0 r210 = r6;
            r31 = r5;
            r32 = r210;
            r123 = 0;
            goto L94
        L51:
            r1 = 0;
            goto L53
        L48:
            r113 = 0;
        L42:
            r112 = null;
            goto L43
        L24:
            r16 = false;
            goto L26
        L11:
            if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L13;
            String r126 = "1";
        L14:
            r13 = (Map) r12.get(r126);
            goto L16
        L13:
            r126 = "0";
        L7:
            r10 = null;
            goto L8
        }
    }

    static {
        c = new a();
        a = new ConcurrentHashMap();
    }
}
