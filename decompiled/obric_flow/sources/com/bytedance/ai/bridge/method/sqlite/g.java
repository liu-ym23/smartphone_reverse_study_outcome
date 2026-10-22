package com.bytedance.ai.bridge.method.sqlite;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements o1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1.f f1998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o1.f f1999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2000c;

    public g(o1.f r5, String r10) {
        this.f1999b = r5;
        this.f2000c = r10;
        this.f1998a = r5;
    }

    @Override // o1.f
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        this.f1998a.a(r5);
    }

    @Override // o1.f
    public final void b(ResultModel r5, String r10) {
        AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel r11 = (AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel) r5;
        Intrinsics.checkNotNullParameter(r11, "result");
        Intrinsics.checkNotNullParameter(r10, "msg");
        i.f2004a.remove(this.f2000c);
        fj.a.e(this.f1999b, r11);
    }

    @Override // o1.f
    public final void c(String r5, ResultModel r10) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        o1.f r11 = this.f1998a;
        r11.c(r5, (AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel) r10);
    }

    @Override // o1.f
    public final void a(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        this.f1998a.a(r5, r10);
    }
}
