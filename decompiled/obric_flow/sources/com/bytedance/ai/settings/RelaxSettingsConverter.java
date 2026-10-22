package com.bytedance.ai.settings;

import com.bytedance.ai.settings.provider.RelaxConfig;
import com.bytedance.ai.settings.provider.WidgetDegradeSetting;
import com.bytedance.ai.utils.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t0.d;
import z0.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/settings/RelaxSettingsConverter;", "", "Lcom/bytedance/ai/settings/provider/RelaxConfig;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RelaxSettingsConverter {
    public RelaxSettingsConverter() {
    }

    public static RelaxConfig a(String r10) {
        Intrinsics.checkNotNullParameter("RelaxSettingsConverter", "tag");     // Catch: Exception -> L6
        d r5 = c.f2846a;     // Catch: Exception -> L6
        if (r5 == null) goto L8;
        r5.d("RelaxSettingsConverter", r10);     // Catch: Exception -> L6
    L8:
        JSONObject r11 = new JSONObject(r10);     // Catch: Exception -> L6
        String r12 = r11.optString("degrade_stragety");     // Catch: Exception -> L6
        if (c.l(r12) == false) goto L11;
        List r13 = ArraysKt.toList((Object[]) a.a().fromJson(r12, WidgetDegradeSetting[].class));     // Catch: Exception -> L6
    L12:
        String r14 = r11.optString("relaxSettings", "");     // Catch: Exception -> L6
        String r15 = r11.optString("render_mode", "");     // Catch: Exception -> L6
        String r16 = r11.optString("rts_worker_package");     // Catch: Exception -> L6
        if (c.l(r16) == false) goto L15;
        List r17 = ArraysKt.toList((Object[]) a.a().fromJson(r16, String[].class));     // Catch: Exception -> L6
    L16:
        Intrinsics.checkNotNull(r15);     // Catch: Exception -> L6
        return new RelaxConfig(r13, r14, r15, r17);
    L15:
        r17 = new ArrayList();     // Catch: Exception -> L6
        goto L16
    L11:
        r13 = new ArrayList();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Intrinsics.checkNotNullParameter("RelaxSettingsConverter", "tag");
        d r18 = c.f2846a;
        if (r18 == null) goto L22;
        r18.e("RelaxSettingsConverter", "failed to parse relax settings", e);
    L22:
        return new RelaxConfig(0);
    }
}
