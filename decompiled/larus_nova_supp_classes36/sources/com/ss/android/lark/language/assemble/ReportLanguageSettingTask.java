package com.ss.android.lark.language.assemble;

import android.content.Context;
import apb.b;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.language.service.impl.a;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ReportLanguageSettingTask extends AsyncLaunchTask {
    public ReportLanguageSettingTask() {
    }

    public final void a(Context r6) {
        e.a().getClass();
        int r7 = a.f;
        b r8 = a.b.a;
        Locale r0 = r8.getLanguageSetting();
        Locale r9 = r8.e();
        bpb.a r1 = bpb.a.a;
        Intrinsics.checkNotNullParameter(r9, "systemLocale");
        JSONObject r2 = new JSONObject();
        r2.put("os_language", r9.toString());
        if (r0 != null) goto L15;
    L8:
        bpb.a.a.getClass();     // Catch: Exception -> L10
        r2.put("app_language", bpb.a.a(r9));     // Catch: Exception -> L10
        r2.put("is_default", true);     // Catch: Exception -> L10
    L14:
    L12:
        r2.put("upload_type", "open");
        Statistics.sendEvent("setting_app_language_view", r2);
        Log.i("CoolBootGetLanguageHitPoint", r2.toString());
        return;
    L10:
        e = move-exception;
        Log.e(e.getMessage());
        goto L12
    L15:
        if (Intrinsics.areEqual(r0, r9) == true) goto L8;
        bpb.a.a.getClass();     // Catch: Exception -> L10
        r2.put("app_language", bpb.a.a(r0));     // Catch: Exception -> L10
        r2.put("is_default", false);     // Catch: Exception -> L10
        goto L14
    }
}
