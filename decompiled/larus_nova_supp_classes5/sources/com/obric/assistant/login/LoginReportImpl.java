package com.obric.assistant.login;

import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.utils.m;
import com.obric.assistant.reporter.IObricSystemReporter;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import n38.a;
import n38.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0007\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\f\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/login/LoginReportImpl;", "Lcom/obric/assistant/login/ILoginReport;", "<init>", "()V", "init", "", "accountStatusListener", "com/obric/assistant/login/LoginReportImpl$accountStatusListener$1", "Lcom/obric/assistant/login/LoginReportImpl$accountStatusListener$1;", "report", "getDoubaoDid", "", "acquireOMatrixDeviceId", "acquirer", "Lkotlin/Function1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginReportImpl implements ILoginReport {
    public static final /* synthetic */ int b = 0;
    public final b a;

    public static final class b implements j {
        public final /* synthetic */ LoginReportImpl a;

        public final void a(a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public b(LoginReportImpl r1) {
            this.a = r1;
        }

        public final void b(a r8) {
            Intrinsics.checkNotNullParameter(r8, "event");
            FLogger.a.i("LoginReportImpl", "onUserDidOnline: accountStatus = " + r8.a + ", businessScene = " + r8.d);
            LoginReportImpl r9 = this.a;
            int r0 = LoginReportImpl.b;
            r9.getClass();
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LoginReportImpl$report$1(r9, null), 3, null);
        }
    }

    static {
    }

    public final void init() {
        m.a.getClass();
        if (m.a() == false) goto L7;
        IObricSystemReporter.a.getClass();
        IObricSystemReporter r0 = IObricSystemReporter.a.a();
        if (r0 == null) goto L8;
        r0.init();
    L8:
        ILoginService.a.f(this.a, Boolean.TRUE);
        return;
    L7:
        AppHost.Companion r1 = AppHost.a;
        String r2 = r1.getApplication().getPackageName();
        Intrinsics.checkNotNullParameter(r2, "pkgName");
        int r3 = r1.getVersionCode();
        String r4 = r1.getVersionName();
        Intrinsics.checkNotNullParameter(r4, "versionName");
        com.obric.matrix.platform.sdk.ones.dataanalysis.b r5 = new com.obric.matrix.platform.sdk.ones.dataanalysis.b(r2, r3, r4, false);
        MatrixTeaManager r6 = MatrixTeaManager.o;
        MatrixTeaManager.a.b(r1.getApplication(), r5);
        goto L8
    }

    public LoginReportImpl() {
        this.a = new b(this);
    }
}
