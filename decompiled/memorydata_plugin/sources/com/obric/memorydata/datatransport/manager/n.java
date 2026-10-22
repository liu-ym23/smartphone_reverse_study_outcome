package com.obric.memorydata.datatransport.manager;

import android.content.Context;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportProcessKeepAlive;", "", "<init>", "()V", "TAG", "", "SERVICE_CLASS", "acquire", "", "release", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f9785a = null;

    static {
        f9785a = new n();
    }

    private n() {
    }

    public final void a() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        n r6 = (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(ZeusTransformUtils.forName("com.obric.memorydata.plugin_api.service.MemoryForegroundService", "com.obric.memorydata.plugin").getMethod("syncShouldRun", new Class[]{Context.class}).invoke(null, new Object[]{r0}));     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L13;
        RunLog.INSTANCE.error("DataExportKeepAlive", "acquire keep-alive failed", r8);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void b() {
        RunLog.INSTANCE.debug("DataExportKeepAlive", "export finished; keep host service state unchanged");
    }
}
