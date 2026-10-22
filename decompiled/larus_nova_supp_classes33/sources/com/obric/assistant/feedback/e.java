package com.obric.assistant.feedback;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e implements w8a.a {
    public final /* synthetic */ ObricSystemFeedbackImpl a;

    public /* synthetic */ e(ObricSystemFeedbackImpl r1) {
        this.a = r1;
    }

    public final Map a() {
        ObricSystemFeedbackImpl r0 = this.a;
        LinkedHashMap r1 = new LinkedHashMap();
        AppHost.Companion r3 = AppHost.a;
        r1.put("nova_log", new PolarisFileWrapper(r3.getApplication().getApplicationContext().getFilesDir(), "logs"));
        r1.put("aiagent_log", new PolarisFileWrapper(r3.getApplication().getApplicationContext().getFilesDir(), "zeus_com.obric.aiagent.plugin/logs"));
        r1.put("memorydata_log", new PolarisFileWrapper(r3.getApplication().getApplicationContext().getFilesDir(), "zeus_com.obric.memorydata.plugin/logs"));
        FLogger.a.i(r0.b, "ObricSystemFeedbackImpl init paths: " + r1);
        return r1;
    }
}
