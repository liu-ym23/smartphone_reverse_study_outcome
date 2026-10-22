package com.bytedance.ai.bridge.method.sqlite;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements o1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1.f f2001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o1.f f2002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2003c;

    public h(o1.f r5, String r10) {
        this.f2002b = r5;
        this.f2003c = r10;
        this.f2001a = r5;
    }

    @Override // o1.f
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        this.f2001a.a(r5);
    }

    @Override // o1.f
    public final void b(ResultModel r5, String r10) {
        AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel r11 = (AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel) r5;
        Intrinsics.checkNotNullParameter(r11, "result");
        Intrinsics.checkNotNullParameter(r10, "msg");
        i.f2004a.remove(this.f2003c);
        fj.a.e(this.f2002b, r11);
    }

    @Override // o1.f
    public final void c(String r5, ResultModel r10) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        o1.f r11 = this.f2001a;
        r11.c(r5, (AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel) r10);
    }

    @Override // o1.f
    public final void a(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        this.f2001a.a(r5, r10);
    }
}
