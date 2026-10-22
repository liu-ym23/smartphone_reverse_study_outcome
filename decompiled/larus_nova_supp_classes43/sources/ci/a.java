package ci;

import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pi.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(long r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        int r1 = ECSdk.a;
        b r14 = (b) ECSdk.a(b.class);
        if (r14 == null) goto L11;
        JSONObject r15 = new JSONObject();
        r15.put("scene", r11);
        if (r12 == null) goto L7;
        r15.put(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r12);
    L7:
        if (r13 == null) goto L9;
        r15.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_TYPE, r13);
    L9:
        Unit r16 = Unit.INSTANCE;
        JSONObject r17 = new JSONObject();
        r17.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r10);
        r14.monitorEvent("livesdk_vmsdk_init_time", r15, r17, null);
        return;
    }

    public static void a(String r10, String r11, String r12, String r13, String r14) {
        JSONObject r0 = new JSONObject();
        if (r10 == null) goto L5;
        r0.put("init_script_error", r10);
    L5:
        if (r11 == null) goto L7;
        r0.put("script_error", r11);
    L7:
        if (r12 == null) goto L9;
        r0.put("script_exce_error", r12);
    L9:
        if (r13 == null) goto L11;
        r0.put("scene", r13);
    L11:
        if (r14 == null) goto L13;
        r0.put("error_info", r14);
    L13:
        int r15 = ECSdk.a;
        b r16 = (b) ECSdk.a(b.class);
        if (r16 != null) goto L16;
        return;
    L16:
        if (r0.length() > 0) goto L19;
        r0 = null;
    L19:
        r16.monitorEvent("livesdk_vmsdk_init_error", null, null, r0);
    }
}
