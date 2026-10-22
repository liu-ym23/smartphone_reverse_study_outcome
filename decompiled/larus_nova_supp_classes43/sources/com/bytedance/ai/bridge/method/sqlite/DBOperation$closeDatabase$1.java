package com.bytedance.ai.bridge.method.sqlite;

import android.database.sqlite.SQLiteDatabase;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.sqlite.DBOperation$closeDatabase$1", f = "DBOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DBOperation$closeDatabase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f3.h<AbsExecuteSqliteActionMethodIDL.b> $callback;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DBOperation this$0;

    public DBOperation$closeDatabase$1(DBOperation r1, f3.h<AbsExecuteSqliteActionMethodIDL.b> r10, Continuation<? super DBOperation$closeDatabase$1> r11) {
        this.this$0 = r1;
        this.$callback = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        DBOperation$closeDatabase$1 r0 = new DBOperation$closeDatabase$1(this.this$0, this.$callback, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        DBOperation r12 = this.this$0;
        SQLiteDatabase r13 = r12.c;
        if (r13 == null) goto L17;
        f3.h<AbsExecuteSqliteActionMethodIDL.b> r14 = this.$callback;
        if (r13.isOpen() == true) goto L22;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.b.class, "<this>");
        f3.h.a.b(r14, (ResultModel) k3.c.a(AbsExecuteSqliteActionMethodIDL.b.class));
    L19:
        return Unit.INSTANCE;
    L22:
    L14:
        e = move-exception;
        String r15 = "Failed to close db(" + r12.b + "): " + e.getMessage();
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r15);
        f3.h.a.a(r14, r15, null, null, 14);
        goto L19
    L10:
        if (r12.d == false) goto L12;
        com.bytedance.ai.utils.g.a.w("ExecuteSqliteActionMethod", "The transaction is not completed. Force to rollback");     // Catch: Exception -> L14
        r13.endTransaction();     // Catch: Exception -> L14
        r12.d = false;     // Catch: Exception -> L14
    L12:
        r13.close();     // Catch: Exception -> L14
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", "db status. isOpened: " + r13.isOpen());     // Catch: Exception -> L14
        r12.c = null;     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.b.class, "<this>");     // Catch: Exception -> L14
        f3.h.a.b(r14, (ResultModel) k3.c.a(AbsExecuteSqliteActionMethodIDL.b.class));     // Catch: Exception -> L14
        goto L19
    L17:
        f3.h<AbsExecuteSqliteActionMethodIDL.b> r16 = this.$callback;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.b.class, "<this>");
        f3.h.a.b(r16, (ResultModel) k3.c.a(AbsExecuteSqliteActionMethodIDL.b.class));
        goto L19
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
