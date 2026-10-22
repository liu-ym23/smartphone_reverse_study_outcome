package j49;

import com.larus.avlink.api.DoraGResourceServiceDelegate;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.model.GestureSettingsKey;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import t39.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final c a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GestureSettingsKey.values().length];
            r0[GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static String a(byte r1) {
        if (r1 != 16) goto L6;
        return "play_and_pause";
    L6:
        if (r1 != 19) goto L9;
        return "play_previous";
    L9:
        if (r1 != 20) goto L12;
        return "play_next";
    L12:
        if (r1 != 1) goto L15;
        return "pickup_and_hangup";
    L15:
        if (r1 != 2) goto L18;
        return "pickup";
    L18:
        if (r1 != 3) goto L20;
        return "hangup";
    L20:
        if (r1 != 0) goto L23;
        return "none";
    L23:
        if (r1 != (-1)) goto L25;
        return "query_note_content";
    L25:
        return "";
    }

    public static String l(boolean r0) {
        if (r0 == false) goto L4;
        return "on";
    L4:
        return "off";
    }

    static {
        a = new c();
    }

    public static void b() {
        DoraBuryPointManager.J(DoraBuryPointManager.a, "d_device_fail_close_btn_tap", MapsKt.emptyMap(), false, 12);
    }

    public static void c() {
        DoraBuryPointManager.J(DoraBuryPointManager.a, "d_device_fail_retry_btn_tap", MapsKt.emptyMap(), false, 12);
    }

    public static void d() {
        DoraBuryPointManager.J(DoraBuryPointManager.a, "d_device_fail_retry_show", MapsKt.emptyMap(), false, 12);
    }

    public static void h(boolean r4) {
        a.c(0, r4);
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dm_notification_switch", MapsKt.mapOf(new Pair[]{TuplesKt.to("notification_switch", l(r4)), TuplesKt.to("result", FlowDoraConnectReason.SUCCESS)}), false, 12);
    }

    public static String k(int r2) {
        if (r2 != 0) goto L5;
        return FlowDoraConnectReason.SUCCESS;
    L5:
        return "failed(" + r2 + ')';
    }

    public static void g(boolean r3, int r4) {
        DoraBuryPointManager.a.L("dora_device_management_settings", MapsKt.mapOf(new Pair[]{TuplesKt.to("multi_device_connection", l(r3)), TuplesKt.to("status", "save"), TuplesKt.to("result", k(r4))}));
    }

    public static void j(boolean r3, int r4) {
        DoraBuryPointManager r0 = DoraBuryPointManager.a;
        Pair[] r1 = new Pair[2];
        int r2 = 0;
        r1[0] = TuplesKt.to("settings_detail", l(r3));
        if (r4 != 0) goto L5;
        r2 = 1;
    L5:
        r1[1] = TuplesKt.to("is_success", Integer.valueOf(r2));
        r0.L("dora_wear_detection_settiings", MapsKt.mapOf(r1));
    }

    public static void f(String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "newName");
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dm_modify_name", MapsKt.mapOf(new Pair[]{TuplesKt.to("name", r4), TuplesKt.to("new_name", r5), TuplesKt.to("result", k(r6))}), false, 12);
        DoraGResourceServiceDelegate.b.d(r5);
    }

    public static void i(String r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r6, "result");
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dm_dora_switch_settings", MapsKt.mapOf(new Pair[]{TuplesKt.to("action", r4), TuplesKt.to("switch_status", l(r5)), TuplesKt.to("result", r6)}), false, 12);
    }

    public static void e(GestureSettingsKey r15, byte r16, byte r17, int r18) {
        Intrinsics.checkNotNullParameter(r15, "key");
        int r0 = a.a[r15.ordinal()];
        if (r0 != 1) goto L5;
        Map r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", "media"), TuplesKt.to("gesture", "double_click_left_ear"), TuplesKt.to("gesture_effect", a(r16)), TuplesKt.to("from_gesture_effect", a(r17)), TuplesKt.to("result", k(r18))});
    L14:
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dm_dora_gesture_settings", r1, false, 12);
        return;
    L5:
        if (r0 != 2) goto L7;
        r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", "media"), TuplesKt.to("gesture", "double_click_right_ear"), TuplesKt.to("gesture_effect", a(r16)), TuplesKt.to("from_gesture_effect", a(r17)), TuplesKt.to("result", k(r18))});
        goto L14
    L7:
        if (r0 == 3) goto L11;
        if (r0 == 4) goto L10;
        return;
    L10:
        r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", "call"), TuplesKt.to("gesture", "double_click_right_ear"), TuplesKt.to("gesture_effect", a(r16)), TuplesKt.to("from_gesture_effect", a(r17)), TuplesKt.to("result", k(r18))});
        goto L14
    L11:
        r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", "call"), TuplesKt.to("gesture", "double_click_left_ear"), TuplesKt.to("gesture_effect", a(r16)), TuplesKt.to("from_gesture_effect", a(r17)), TuplesKt.to("result", k(r18))});
        goto L14
    }
}
