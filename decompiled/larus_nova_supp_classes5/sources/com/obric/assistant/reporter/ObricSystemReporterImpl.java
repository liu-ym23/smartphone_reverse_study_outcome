package com.obric.assistant.reporter;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.utils.m;
import com.obric.assistant.login.LoginReportImpl$report$1;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.platform.sdk.ones.dataanalysis.a;
import com.obric.matrix.platform.sdk.ones.dataanalysis.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/reporter/ObricSystemReporterImpl;", "Lcom/obric/assistant/reporter/IObricSystemReporter;", "<init>", "()V", "init", "", "reportSystemEvent", "eventName", "", "params", "Lorg/json/JSONObject;", "acquireDeviceId", "acquirer", "Lkotlin/Function1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSystemReporterImpl implements IObricSystemReporter {
    static {
    }

    public ObricSystemReporterImpl() {
    }

    public final void init() {
        m.a.getClass();
        if (m.a() == true) goto L6;
        return;
    L6:
        if (MatrixTeaManager.p.get() == false) goto L8;
        return;
    L8:
        AppHost.Companion r0 = AppHost.a;
        String r1 = r0.getApplication().getPackageName();
        Intrinsics.checkNotNullParameter(r1, "pkgName");
        int r2 = r0.getVersionCode();
        String r3 = r0.getVersionName();
        Intrinsics.checkNotNullParameter(r3, "versionName");
        b r4 = new b(r1, r2, r3, false);
        MatrixTeaManager.a.b(r0.getApplication(), r4);
    }

    public final void a(LoginReportImpl$report$1.a r3) {
        Intrinsics.checkNotNullParameter(r3, "acquirer");
        m.a.getClass();
        if (m.a() == true) goto L6;
        r3.invoke("");
        return;
    L6:
        init();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        MatrixTeaManager r1 = MatrixTeaManager.o;     // Catch: Throwable -> L9
        Object r2 = Result.constructor-impl(MatrixTeaManager.a.a().e());     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r2) == false) goto L14;
        r2 = null;
    L14:
        String r4 = (String) r2;
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L23;
    L26:
        a r6 = new f(r3);
        MatrixTeaManager r7 = MatrixTeaManager.o;
        MatrixTeaManager.a.a().b(r6);
        return;
    L23:
        if (Intrinsics.areEqual(r4, "0") == true) goto L26;
        r3.invoke(r4);
        return;
    L17:
        if (StringsKt.isBlank(r4) == true) goto L20;
        r5 = false;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void b(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        m.a.getClass();
        if (m.a() == true) goto L5;
        return;
    L5:
        init();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        MatrixTeaManager r1 = MatrixTeaManager.o;     // Catch: Throwable -> L8
        MatrixTeaManager.a.a().f(r3, r4);     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L16;
        FLogger.a.e("ObricSystemReporterImpl", "reportSystemEvent failed, eventName=".concat(r3), r6);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
