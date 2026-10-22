package com.obric.assistant.feedback.upload;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.feedback.upload.bean.ReportUploadTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static final d a = null;
    public static final b b = null;
    public static final Lazy c = null;

    public d() {
    }

    static {
        a = new d();
        a.a.getClass();
        b = new b();
        c = LazyKt.lazy(new c());
    }

    public static void a() {
        FLogger r0 = FLogger.a;
        r0.i("ReportUploadManager", "triggerUpload");
        ReportUploadTask r2 = b.b.pollFirst();
        boolean r3 = true;
        if (r2 == null) goto L8;
        r3 = ((Boolean) BuildersKt.runBlocking$default(null, new ReportUploadManager$triggerUpload$1(r2, null), 1, null)).booleanValue();
        Function1<Boolean, Unit> r4 = r2.i;
        if (r4 == null) goto L8;
        r4.invoke(Boolean.valueOf(r3));
    L8:
        r0.i("ReportUploadManager", "triggerUpload isUploadOk=" + r3);
    }
}
