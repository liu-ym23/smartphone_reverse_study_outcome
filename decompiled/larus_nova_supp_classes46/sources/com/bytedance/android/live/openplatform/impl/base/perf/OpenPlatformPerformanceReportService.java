package com.bytedance.android.live.openplatform.impl.base.perf;

import com.bytedance.android.live.core.utils.h0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zo0.b;
import zo0.e;
import zo0.f;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/perf/OpenPlatformPerformanceReportService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lzo0/b$a;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformPerformanceReportService extends OpenPlatformContextService implements b.a {

    public static final class a implements f.b<f> {
        public final /* synthetic */ String a;

        @Override // zo0.f.b
        public final void onFailure() {
        }

        public a(String r1) {
            this.a = r1;
        }

        @Override // zo0.f.b
        public final void a(f r10) {
            Intrinsics.checkNotNullParameter(r10, "timeline");
            long r2 = r10.d("finish", "start");
            long r0 = r10.d("view_created", "start");
            g r4 = u.l();
            String r5 = this.a;
            Intrinsics.checkNotNullParameter(r10, "$this$getClickSource");
            int r7 = f.d;
            r4.e(r5, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("_param_for_special", "micro_app"), TuplesKt.to("click_source", r10.i("")), TuplesKt.to("duration", String.valueOf(r2)), TuplesKt.to("ui_init_duration", String.valueOf(r0))}), new Object[]{Room.class});
        }
    }

    @Override // zo0.b.a
    public final void d(PerformanceScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
    }

    public OpenPlatformPerformanceReportService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public static Map g(boolean r10) {
        if (r10 == false) goto L7;
        HashMap<String, f> r2 = zo0.g.a;
        if (h.b(PerformanceScene.SHELF_REQUEST).c("audience_is_backend_sucess") == false) goto L7;
        boolean r3 = true;
    L8:
        e r4 = null;
        if (r10 == false) goto L20;
        HashMap<String, f> r11 = zo0.g.a;
        f r12 = h.b(PerformanceScene.SHELF_REQUEST);
        monitor-enter(r12);
        Intrinsics.checkNotNullParameter("audience_backend_end", "event");     // Catch: Throwable -> L17
        int r5 = r12.j("audience_backend_end");     // Catch: Throwable -> L17
        if (r5 == (-1)) goto L15;
        r4 = (e) ListProtector.get(r12.a, r5);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r12);
    L17:
        th = move-exception;
        throw th;
    L20:
        long r6 = 0;
        if (r4 == null) goto L23;
        long r7 = r4.b;
        HashMap<String, f> r13 = zo0.g.a;
        long r8 = r7 - h.b(PerformanceScene.SHELF_REQUEST).h();
    L24:
        if (r3 == true) goto L28;
        HashMap<String, f> r14 = zo0.g.a;
        r6 = h.b(PerformanceScene.SHELF_REQUEST).d("finish", "audience_request_start");
    L28:
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("request_duration", String.valueOf(r6)), TuplesKt.to("backend_duration", String.valueOf(r8)), TuplesKt.to("is_backend_success", String.valueOf(r3))});
    L23:
        r8 = 0;
    L7:
        r3 = false;
        goto L8
    }

    public static void j(boolean r2) {
        if (r2 == false) goto L4;
        String r3 = "mp_entrance_anchor_shelf_popup_fp_cost";
    L5:
        HashMap<String, f> r0 = zo0.g.a;
        f r1 = h.b(PerformanceScene.SHELF_DIALOG);
        r1.b();
        f.a(r1, new a(r3));
        return;
    L4:
        r3 = "mp_entrance_audience_shelf_popup_fp_cost";
        goto L5
    }

    public final void k(boolean r24) {
        HashMap<String, f> r0 = zo0.g.a;
        PerformanceScene r1 = PerformanceScene.SNOW_FLAKE;
        h.b(r1).b();
        boolean r2 = h.b(r1).c("is_from_enter");
        PerformanceScene r3 = PerformanceScene.MINI_APP_CONTEXT;
        long r4 = h.b(r3).d("context_initialized", "start");
        long r5 = f.e(h.b(r1));
        if (r24 == false) goto L47;
        PerformanceScene r12 = PerformanceScene.SHELF_REQUEST;
        f r13 = h.b(r12);
        monitor-enter(r13);
        Intrinsics.checkNotNullParameter("anchor_request_source", "key");     // Catch: Throwable -> L44
        int r14 = r13.b.getInt("anchor_request_source", 0);     // Catch: Throwable -> L44
        monitor-exit(r13);
        f r15 = h.b(r12);
        e r16 = (e) CollectionsKt.lastOrNull(r15.a);
        if (r16 == null) goto L11;
        String r17 = r16.a;
    L13:
        if (Intrinsics.areEqual(r17, "finish") == true) goto L16;
        r15 = null;
    L16:
        if (r15 == null) goto L18;
        long r18 = f.e(r15);
    L19:
        if (r2 == true) goto L24;
        if (r14 == 1) goto L24;
        if (r14 == 2) goto L24;
        boolean r8 = false;
    L25:
        long r19 = h.b(r1).g("anchor_data_source");
        if (r8 == false) goto L29;
        long r110 = h.b(r1).f() - h.b(r3).h();
    L32:
        Map r6 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(r110)), TuplesKt.to("context_init_duration", String.valueOf(r4)), TuplesKt.to("request_duration", String.valueOf(r18)), TuplesKt.to("draw_duration", String.valueOf(r5))});
        Pair[] r7 = new Pair[3];
        if (r2 == false) goto L35;
        String r9 = "enter";
    L36:
        r7[0] = TuplesKt.to("toolbar_im_source", r9);
        r7[1] = TuplesKt.to("request_source", String.valueOf(r14));
        r7[2] = TuplesKt.to("data_source", String.valueOf(r19));
        h(r1, r6, MapsKt.mutableMapOf(r7));
        g r10 = u.l();
        Pair[] r11 = new Pair[2];
        r11[0] = TuplesKt.to("_param_for_special", "micro_app");
        if (r8 == false) goto L40;
        String r20 = "mount_before_start";
    L43:
        r11[1] = TuplesKt.to("mount_data_source", r20);
        Map r21 = MapsKt.mutableMapOf(r11);
        r21.putAll(r6);
        Unit r22 = Unit.INSTANCE;
        r10.e("mp_entrance_anchor_snow_icon_fp_cost", r21, new Object[]{Room.class});
        return;
    L40:
        if (r19 != 0) goto L42;
        r20 = "mount_in_live";
        goto L43
    L42:
        r20 = "mount_in_live_with_pc";
        goto L43
    L35:
        r9 = "msg";
        goto L36
    L29:
        if (r19 != 0) goto L31;
        r110 = h.b(r1).f() - h.b(r12).h();
        goto L32
    L31:
        r110 = f.e(h.b(r1));
    L24:
        r8 = true;
        goto L25
    L18:
        r18 = -1;
        goto L19
    L11:
        r17 = null;
    L44:
        th = move-exception;
        throw th;
    L47:
        long r23 = h.b(r3).g("audience_enter_room_duration");
        if (r2 == false) goto L50;
        long r111 = h.b(r1).f();
        long r112 = h.b(r3).h();
    L51:
        long r113 = r111 - r112;
        if (r2 == false) goto L54;
        long r114 = r23 + r113;
    L55:
        Pair[] r25 = new Pair[6];
        if (r2 == false) goto L58;
        String r115 = "enter";
    L59:
        r25[0] = TuplesKt.to("toolbar_im_source", r115);
        r25[1] = TuplesKt.to("duration", String.valueOf(r113));
        r25[2] = TuplesKt.to("total_duration", String.valueOf(r114));
        if (r2 == false) goto L62;
        String r26 = String.valueOf(r23);
    L63:
        r25[3] = TuplesKt.to("enter_room_duration", r26);
        r25[4] = TuplesKt.to("context_init_duration", String.valueOf(r4));
        r25[5] = TuplesKt.to("draw_duration", String.valueOf(r5));
        Map r27 = MapsKt.mutableMapOf(r25);
        r27.putAll(g(r2));
        h(r1, r27, MapsKt.emptyMap());
        g r28 = u.l();
        Map r29 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("_param_for_special", "micro_app"), TuplesKt.to("room_id", String.valueOf(getOpenPlatformContext().getRoomId()))});
        r29.putAll(r27);
        Unit r30 = Unit.INSTANCE;
        r28.e("mp_entrance_audience_snow_icon_fp_cost", r29, new Object[0]);
        return;
    L62:
        r26 = "0";
        goto L63
    L58:
        r115 = "msg";
        goto L59
    L54:
        r114 = r113;
        goto L55
    L50:
        r111 = h.b(r1).f();
        r112 = h.b(PerformanceScene.SHELF_REQUEST).h();
        goto L51
    }

    public static void h(PerformanceScene r2, Map r3, Map r4) {
        if (v.a() == false) goto L16;
        Iterator r5 = r3.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) r5.next();
        String r1 = (String) r0.getKey();
        String r6 = (String) r0.getValue();
        goto L6
    L8:
        Iterator r7 = r4.entrySet().iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        Map.Entry r8 = (Map.Entry) r7.next();
        String r9 = (String) r8.getKey();
        String r10 = (String) r8.getValue();
        goto L10
    L12:
        r2.getValue();
        return;
    }

    @Override // zo0.b.a
    public final void e(PerformanceScene r17, long r18, double r20, JSONObject r22) {
        Intrinsics.checkNotNullParameter(r17, "scene");
        Pair[] r3 = new Pair[4];
        r3[0] = TuplesKt.to("_param_for_special", "micro_app");
        r3[1] = TuplesKt.to("scene", r17.getValue());
        if (r20 <= 60) goto L5;
        String r1 = "60";
    L6:
        r3[2] = TuplesKt.to("fps", r1);
        r3[3] = TuplesKt.to("duration", String.valueOf(r18));
        Map r2 = MapsKt.mutableMapOf(r3);
        if (r22 == null) goto L35;
        Iterator<String> r4 = r22.keys();
        if (r4 == null) goto L35;
        float r6 = h0.a();
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L14:
        if (r4.hasNext() == false) goto L34;
        String r14 = r4.next();
        int r15 = CastIntegerProtector.parseInt(r14);
        int r16 = r22.optInt(r14);
        if (r16 <= 0) goto L14;
        if (r12 >= r15) goto L20;
        r12 = r15;
    L20:
        if (r15 < 3) goto L22;
        r13 = r13 + ((int) ((r16 * r15) * r6));
    L22:
        if (r15 == 0) goto L33;
        if (r15 >= 3) goto L27;
        r8 = r8 + r16;
        goto L33
    L27:
        if (r15 >= 7) goto L30;
        r9 = r9 + r16;
        goto L33
    L30:
        if (r15 >= 14) goto L32;
        r10 = r10 + r16;
        goto L33
    L32:
        r11 = r11 + r16;
    L33:
        r7 = r7 + r16;
        goto L14
    L34:
        r2.put("total_frames", String.valueOf(r7));
        r2.put("level_1", String.valueOf(r8));
        r2.put("level_2", String.valueOf(r9));
        r2.put("level_3", String.valueOf(r10));
        r2.put("level_4", String.valueOf(r11));
        r2.put("drop_count", String.valueOf(((r8 + r9) + r10) + r11));
        r2.put("drop_max", String.valueOf(r12));
        r2.put("block_duration", String.valueOf(r13));
    L35:
        u.l().e("mp_entrance_performance_fluency", r2, new Object[]{Room.class});
        return;
    L5:
        r1 = String.valueOf(((double) ((int) (((double) 100) * r20))) / 100.0d);
        goto L6
    }

    public final void f(String r8, String r9, long r10, long r12, long r14) {
        HashMap<String, f> r0 = zo0.g.a;
        long r1 = f.e(h.b(PerformanceScene.CHOOSE_PAGE));
        if (r1 > 0) goto L5;
        return;
    L5:
        g r2 = u.l();
        Pair[] r3 = new Pair[8];
        r3[0] = TuplesKt.to("_param_for_special", "micro_app");
        if (getOpenPlatformContext().isInLive() == false) goto L8;
        String r4 = "in_live";
    L9:
        r3[1] = TuplesKt.to("live_status", r4);
        r3[2] = TuplesKt.to("click_source", r9);
        r3[3] = TuplesKt.to("type", r8);
        r3[4] = TuplesKt.to("context_init_duration", String.valueOf(r1));
        r3[5] = TuplesKt.to("ui_init_duration", String.valueOf(r10));
        r3[6] = TuplesKt.to("request_duration", String.valueOf(r12));
        r3[7] = TuplesKt.to("duration", String.valueOf(r1 + r14));
        r2.e("mp_entrance_choose_list_fp_cost", MapsKt.mutableMapOf(r3), new Object[]{Room.class});
        return;
    L8:
        r4 = "before_live";
        goto L9
    }

    public static void i(long r5, int r7, String r8, long r9, String r11, long r12) {
        Intrinsics.checkNotNullParameter(r8, "desc");
        g r1 = u.l();
        Pair[] r2 = new Pair[7];
        r2[0] = TuplesKt.to("_param_for_special", "micro_app");
        r2[1] = TuplesKt.to("room_id", String.valueOf(r5));
        r2[2] = TuplesKt.to("state", String.valueOf(r7));
        r2[3] = TuplesKt.to("desc", r8);
        r2[4] = TuplesKt.to("err_code", String.valueOf(r9));
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r2[5] = TuplesKt.to("err_msg", r11);
        r2[6] = TuplesKt.to("duration", String.valueOf(r12));
        r1.e("mp_audience_backend_monitor", MapsKt.mutableMapOf(r2), new Object[0]);
    }
}
