package com.larus.chat.job.impl.page;

import com.larus.chat.job.impl.experiment.ChatJobLarkEventSettings;
import com.larus.im.bean.job.AIJob;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(int r1) {
        if (r1 != 3) goto L5;
        return "lark_event_job";
    L5:
        return "cron_job";
    }

    public static boolean b(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 != 3) goto L9;
        ChatJobLarkEventSettings.a.getClass();
        if (ChatJobLarkEventSettings.a() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean c(AIJob r3) {
        Intrinsics.checkNotNullParameter(r3, "job");
        if (r3.getJobType() != 1) goto L5;
        return true;
    L5:
        if (r3.getJobType() != 3) goto L13;
        ChatJobLarkEventSettings.a.getClass();
        if (ChatJobLarkEventSettings.a() == false) goto L13;
        if (r3.getStatus() != 1) goto L11;
        return true;
    L11:
        if (r3.getStatus() != 2) goto L13;
        return true;
    L13:
        return false;
    }
}
