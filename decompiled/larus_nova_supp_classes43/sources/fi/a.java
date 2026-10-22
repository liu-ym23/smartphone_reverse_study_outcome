package fi;

import android.content.Context;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.c0;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.common.lib.MobClickCombiner;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public static final List<String> a = null;
    public static final a b = null;

    public a() {
    }

    static {
        b = new a();
        a = CollectionsKt.listOf(new String[]{"slice_create_view", "slice_bind_data", "slice_layout", "slice_hit_click_debounce", "slice_normal_error", "slice_render_error", "slice_sdk_error", "slice_sdk_init_error", "slice_sdk_exception_monitor", "slice_load_template", "slice_load_template_error"});
    }

    @Override // fi.b
    public final String getSessionKey() {
        return AppLog.g0.getSessionKey();
    }

    @Override // fi.b
    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "abSDKVersion");
        AppLog.N = r10;
        AppLog.g0.a(r10);
    }

    @Override // fi.b
    public final String addCommonParams(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        boolean r0 = AppLog.L;
        return c0.b(r10, true);
    }

    @Override // fi.b
    public final void onEventV3(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "params");
        if ((!a.contains(r10)) == true) goto L5;
    L10:
        AppLogNewUtils.onEventV3(r10, r11);
        return;
    L5:
        if (StringsKt.startsWith$default(r10, "tobsdk_", false, 2, null) == true) goto L10;
        if (StringsKt.startsWith$default(r10, "livesdk", false, 2, null) == false) goto L9;
        r10 = "tobsdk_" + r10;
        goto L10
    L9:
        r10 = "tobsdk_livesdk_" + r10;
        goto L10
    }

    @Override // fi.b
    public final void b(Context r11, String r12, String r13, String r14, long r15, JSONObject r17) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "eventName");
        Intrinsics.checkNotNullParameter(r13, "labelName");
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        Intrinsics.checkNotNullParameter(r17, "ext_json");
        Long r10 = StringsKt.toLongOrNull(r14);
        if (r10 == null) goto L5;
        long r16 = r10.longValue();
    L6:
        MobClickCombiner.onEvent(r11, "", r12, r13, r16, r15, r17);
        return;
    L5:
        r16 = 0;
        goto L6
    }
}
