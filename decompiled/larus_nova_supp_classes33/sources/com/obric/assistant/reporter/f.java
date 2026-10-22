package com.obric.assistant.reporter;

import com.obric.assistant.login.LoginReportImpl;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements com.obric.matrix.platform.sdk.ones.dataanalysis.a {
    public final /* synthetic */ Function1<String, Unit> a;

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "installId");
    }

    public f(LoginReportImpl.report.1.a r1) {
        this.a = r1;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "did");
        this.a.invoke(r2);
        MatrixTeaManager r3 = MatrixTeaManager.o;
        MatrixTeaManager.a.a().i(this);
    }
}
