package com.bytedance.ai.bridge.method.sqlite;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements f3.h<AbsExecuteSqliteActionMethodIDL.b> {
    public final /* synthetic */ f3.h<AbsExecuteSqliteActionMethodIDL.b> a;
    public final /* synthetic */ f3.h<AbsExecuteSqliteActionMethodIDL.b> b;
    public final /* synthetic */ String c;

    @Override // f3.h
    public final void a(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.a.a(r10, r11);
    }

    @Override // f3.h
    public final void c(String r10, int r11, f3.a r12, JsonObject r13) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.c(r10, r11, r12, r13);
    }

    public k(f3.h<AbsExecuteSqliteActionMethodIDL.b> r1, String r10) {
        this.b = r1;
        this.c = r10;
        this.a = r1;
    }

    @Override // f3.h
    public final void b(ResultModel r10, String r11) {
        AbsExecuteSqliteActionMethodIDL.b r12 = (AbsExecuteSqliteActionMethodIDL.b) r10;
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        SqliteActionManager.b.remove(this.c);
        f3.h.a.b(this.b, r12);
    }
}
