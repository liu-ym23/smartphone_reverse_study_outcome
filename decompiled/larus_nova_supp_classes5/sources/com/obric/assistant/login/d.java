package com.obric.assistant.login;

import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.platform.sdk.ones.dataanalysis.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements a {
    public final /* synthetic */ Function1<String, Unit> a;

    @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.a
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "installId");
    }

    public d(LoginReportImpl$report$1.a r1) {
        this.a = r1;
    }

    @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.a
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "did");
        this.a.invoke(r2);
        MatrixTeaManager r3 = MatrixTeaManager.o;
        MatrixTeaManager.a.a().i(this);
    }
}
