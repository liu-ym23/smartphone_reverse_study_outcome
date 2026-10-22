package com.obric.memorydata.intelligence.b;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/ScheduleTask;", "", "<init>", "()V", "TAG", "", "MINUTE_OF_HOUR", "", "HOUR_OF_DAY", "nextHour", "", "task", "Ljava/lang/Runnable;", "nextDay", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f9949a = null;

    static {
        f9949a = new h();
    }

    private h() {
    }

    public final void a(Runnable r8) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "task");
        long r0 = System.currentTimeMillis();
        Calendar r9 = Calendar.getInstance();
        r9.setTimeInMillis(r0);
        r9.add(12, 60 - r9.get(12));
        RunLog.INSTANCE.debug("PredictTask", "schedule next hour " + new Date(r9.getTimeInMillis()));
        GlobalHandlerUtil.Companion.getInstance().postDelay(r7, r9.getTimeInMillis() - r0);
    }
}
