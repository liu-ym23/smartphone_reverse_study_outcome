package com.bytedance.ai.bridge.method.sqlite;

import android.database.sqlite.SQLiteDatabase;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.lynx.tasm.ui.image.f0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.sqlite.DBOperation$closeDatabase$1", f = "DBOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DBOperation$closeDatabase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f1971c;

    public DBOperation$closeDatabase$1(d r5, f r10, Continuation r11) {
        this.f1970b = r5;
        this.f1971c = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        DBOperation$closeDatabase$1 r11 = new DBOperation$closeDatabase$1(this.f1970b, this.f1971c, r10);
        r11.f1969a = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((DBOperation$closeDatabase$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.f1969a;
        d r12 = this.f1970b;
        SQLiteDatabase r5 = r12.f1994c;
        if (r5 == null) goto L25;
        f r13 = this.f1971c;
        if (r5.isOpen() == true) goto L28;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class, "<this>");
        r13.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class), "");
    L27:
        return Unit.INSTANCE;
    L28:
    L12:
        e = move-exception;
        StringBuilder r14 = new StringBuilder("Failed to close db(");
        r14.append(r12.f1993b);
        r14.append("): ");
        String r15 = f0.d(e, r14, "ExecuteSqliteActionMethod");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L23;
        r16.e("ExecuteSqliteActionMethod", r15);
    L23:
        Intrinsics.checkNotNullParameter(r15, "msg");
        r13.f1995a.a(r15);
        goto L27
    L8:
        if (r12.d == false) goto L15;
        Intrinsics.checkNotNullParameter("ExecuteSqliteActionMethod", "tag");     // Catch: Exception -> L12
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L12
        if (r17 == null) goto L14;
        r17.w("ExecuteSqliteActionMethod", "The transaction is not completed. Force to rollback");     // Catch: Exception -> L12
    L14:
        r5.endTransaction();     // Catch: Exception -> L12
        r12.d = false;     // Catch: Exception -> L12
    L15:
        r5.close();     // Catch: Exception -> L12
        String r18 = "db status. isOpened: " + r5.isOpen();     // Catch: Exception -> L12
        Intrinsics.checkNotNullParameter("ExecuteSqliteActionMethod", "tag");     // Catch: Exception -> L12
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L12
        if (r19 == null) goto L18;
        r19.e("ExecuteSqliteActionMethod", r18);     // Catch: Exception -> L12
    L18:
        r12.f1994c = null;     // Catch: Exception -> L12
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class, "<this>");     // Catch: Exception -> L12
        r13.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class), "");     // Catch: Exception -> L12
        goto L27
    L25:
        f r20 = this.f1971c;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class, "<this>");
        r20.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class), "");
        goto L27
    }
}
