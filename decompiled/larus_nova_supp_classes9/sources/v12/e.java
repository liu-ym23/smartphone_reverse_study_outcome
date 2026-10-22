package v12;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.h;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.i;
import com.bytedance.bdlocation.BuildConfig;
import cy0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final ConcurrentHashMap<String, Map<String, Long>> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void c(EffectMessage r9) {
        Intrinsics.checkNotNullParameter(r9, "effectMessage");
        if (h.p() == true) goto L6;
        return;
    L6:
        if (r9.w == true) goto L8;
        return;
    L8:
        String r0 = r9.y;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        return;
    L17:
        f(r9.y);
        g(r9.y, r9.l, r9.b, r9.x, "effect");
        return;
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
        goto L15
    }

    public static void d(NormalGiftMessage r9) {
        Intrinsics.checkNotNullParameter(r9, "normalGiftMessage");
        if (h.p() == true) goto L6;
        return;
    L6:
        if (r9.v == true) goto L9;
        return;
    L9:
        if ((r9.t instanceof o7) == false) goto L24;
        o7 r0 = r9.r();
        if (r0 != null) goto L13;
        return;
    L13:
        String r1 = r0.getTraceId();
        if (r1 != null) goto L16;
    L19:
        boolean r2 = true;
    L20:
        if (r2 == false) goto L22;
        return;
    L22:
        f(r0.getTraceId());
        g(r9.getTraceId(), r9.b, r9.getAssetId(), r9.G, "normal");
        return;
    L16:
        if (r1.length() == 0) goto L19;
        r2 = false;
        goto L20
    }

    public static void f(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        a.remove(r1);
        return;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void a(Map r38, EffectMessage r39) {
        Intrinsics.checkNotNullParameter(r38, "paramsMap");
        Intrinsics.checkNotNullParameter(r39, "effectMessage");
        if (h.p() == true) goto L93;
        return;
    L93:
        h2 r3 = GiftManagerKt.l(r39.l);     // Catch: Exception -> L7
    L9:
        if (r3 != null) goto L11;
        String r4 = "-1";
    L15:
        long r6 = r39.x;
        long r8 = e(r39.y, "open_dialog");
        if (r8 != 0) goto L18;
        r8 = r6;
    L18:
        long r13 = e(r39.y, "send_success");
        Long r14 = (Long) ((HashMap) r39.B).get(2);
        if (r14 == null) goto L21;
        long r15 = r14.longValue();
    L22:
        Long r2 = (Long) ((HashMap) r39.B).get(3);
        if (r2 == null) goto L25;
        long r10 = r2.longValue();
    L26:
        Long r5 = (Long) ((HashMap) r39.B).get(4);
        if (r5 == null) goto L29;
        r5.longValue();
    L29:
        Long r7 = (Long) ((HashMap) r39.B).get(6);
        if (r7 == null) goto L32;
        long r20 = r7.longValue();
    L33:
        Long r9 = (Long) ((HashMap) r39.B).get(8);
        if (r9 == null) goto L36;
        long r23 = r9.longValue();
    L37:
        Long r11 = (Long) ((HashMap) r39.B).get(5);
        if (r11 == null) goto L40;
        long r24 = r11.longValue();
    L41:
        Long r16 = (Long) ((HashMap) r39.B).get(10);
        if (r16 == null) goto L44;
        long r26 = r16.longValue();
    L45:
        long r17 = r6 - r8;
        long r28 = r13 - r6;
        long r30 = r15 - r13;
        long r33 = r10 - r15;
        long r18 = r20 - r10;
        long r21 = r23 - r20;
        long r34 = r23 - r23;
        long r25 = r24 - r23;
        long r27 = r26 - r24;
        long r36 = r26 - r6;
        long r29 = r26 - r15;
        IBaseUser r19 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b();
        if (r19 == null) goto L48;
        String r31 = r19.getIdString();
    L50:
        if (r13 <= 0) goto L52;
        ((HashMap) r38).put("msg_dispatch", String.valueOf(r30));
    L53:
        int r35 = 0;
        if (r31.length() <= 0) goto L56;
        boolean r37 = true;
    L58:
        if (r37 == false) goto L66;
        IBaseUser r40 = r39.i;
        if (r40 == null) goto L62;
        String r41 = r40.getIdString();
    L64:
        if (Intrinsics.areEqual(r31, r41) == false) goto L66;
        HashMap r43 = (HashMap) r38;
        r43.put("presend_duration", String.valueOf(r17));
        r43.put("send_api_duration", String.valueOf(r28));
    L67:
        HashMap r0 = (HashMap) r38;
        r0.put("start_send_gift", String.valueOf(r17));
        r0.put("before_queue", String.valueOf(r30));
        r0.put("effect_before_queue", String.valueOf(r34));
        r0.put("effect_msg_dispatch", String.valueOf(r18));
        r0.put("effect_queue_duration", String.valueOf(r25));
        r0.put("start_play", String.valueOf(r27));
        r0.put("free_display", r4);
        h1 r44 = r39.C;
        if (r44 == null) goto L70;
        r35 = r44.getType();
    L70:
        r0.put("gift_type", String.valueOf(r35));
        r0.put("gift_id", String.valueOf(r39.l));
        r0.put("asset_id", String.valueOf(r39.b));
        String r45 = r39.y;
        if (r45 != null) goto L73;
        r45 = "0";
    L73:
        r0.put("trace_id", r45);
        r0.put("asset_type", String.valueOf(r39.f));
        r0.put("asset_predownload", String.valueOf(r39.I));
        r0.put("dequeue_duration", String.valueOf(r33));
        r0.put("receive_mock_msg", String.valueOf(r33));
        r0.put("fetch_assets_duration", String.valueOf(r21));
        r0.put("download_callback", String.valueOf(r21));
        Long r46 = (Long) ((HashMap) r39.B).get(11);
        long r47 = -1;
        if (r46 == null) goto L76;
        long r48 = r46.longValue();
    L77:
        r0.put("all_queue_size", String.valueOf(r48));
        Long r49 = (Long) ((HashMap) r39.B).get(12);
        if (r49 == null) goto L80;
        long r50 = r49.longValue();
    L81:
        r0.put("self_queue_size", String.valueOf(r50));
        Long r51 = (Long) ((HashMap) r39.B).get(14);
        if (r51 == null) goto L84;
        long r53 = r51.longValue();
    L85:
        r0.put("effect_queue_size", String.valueOf(r53));
        Long r54 = (Long) ((HashMap) r39.B).get(13);
        if (r54 == null) goto L88;
        r47 = r54.longValue();
    L88:
        r0.put("play_now", String.valueOf(r47));
        r0.put("gift_source", String.valueOf(e(r39.y, "send_source")));
        r0.put("rev_all_time", String.valueOf(r29));
        r0.put("send_all_time", String.valueOf(r36));
        r0.put("all_duration", String.valueOf(r36));
        r0.put("gift_page", String.valueOf(e(r39.y, "page_type")));
        r0.put("gift_index", String.valueOf(e(r39.y, "absolute_index")));
        if (r39.K == false) goto L91;
        r0.put("quick_play", "1");
        return;
    L91:
        r0.put("quick_play", "0");
        return;
    L84:
        r53 = -1;
        goto L85
    L80:
        r50 = -1;
        goto L81
    L76:
        r48 = -1;
        goto L77
    L62:
        r41 = null;
    L66:
        HashMap r55 = (HashMap) r38;
        r55.put("presend_duration", "0");
        r55.put("send_api_duration", "0");
        goto L67
    L56:
        r37 = false;
        goto L58
    L52:
        ((HashMap) r38).put("msg_dispatch", String.valueOf(r15 - r6));
        goto L53
    L48:
        r31 = BuildConfig.FLAVOR;
        goto L50
    L44:
        r26 = 0;
        goto L45
    L40:
        r24 = 0;
        goto L41
    L36:
        r23 = 0;
        goto L37
    L32:
        r20 = 0;
        goto L33
    L25:
        r10 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L11:
        if (l0.e(r3) == false) goto L13;
        r4 = "1";
        goto L15
    L13:
        r4 = "0";
    L7:
        r3 = null;
        goto L9
    }

    public static long e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "timeKey");
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return 0;
    L12:
        Map<String, Long> r5 = a.get(r3);
        if (r5 == null) goto L18;
        Long r6 = r5.get(r4);
        if (r6 != null) goto L17;
        return 0;
    L17:
        return r6.longValue();
    L18:
        return 0;
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L10
    }

    public static void b(String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        boolean r0 = true;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return;
    L12:
        if (h.p() == true) goto L14;
        return;
    L14:
        ConcurrentHashMap<String, Map<String, Long>> r3 = a;
        if (r3.get(r4) != null) goto L18;
        r3.put(r4, new LinkedHashMap());
    L18:
        if (r5.length() == 0) goto L21;
        r0 = false;
    L21:
        if (r0 == false) goto L23;
        return;
    L23:
        Map<String, Long> r7 = r3.get(r4);
        if (r7 == null) goto L27;
        r7.put(r5, Long.valueOf(r6));
        return;
    L27:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static void g(String r4, long r5, long r7, long r9, String r11) {
        if (h.p() == true) goto L5;
        return;
    L5:
        long r0 = com.bytedance.live.kmp.util.e.b();
        HashMap r2 = new HashMap();
        if (r4 != null) goto L8;
        r4 = "0";
    L8:
        r2.put("trace_id", r4);
        r2.put("gift_id", String.valueOf(r5));
        r2.put("asset_id", String.valueOf(r7));
        r2.put("msg_type", r11);
        r2.put("wait_time", String.valueOf(r0 - r9));
        n r6 = new n();
        Map r8 = r6.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r8.putAll(r2);
        m r10 = new m();
        i r13 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r13, "pageSourceLog");
        List r14 = r10.a;
        ArrayList r15 = (ArrayList) r14;
        r15.add(r13.a);
        r10.b(LogCommon.ROOM);
        List r16 = r6.b;
        ArrayList r17 = (ArrayList) r16;
        r17.addAll(r10.a);
        cy0.e.a.getClass();
        j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r19);
        ((f80.a) r19).w3("livesdk_rd_gift_send_exception", r6.a, r6.b);
    }
}
