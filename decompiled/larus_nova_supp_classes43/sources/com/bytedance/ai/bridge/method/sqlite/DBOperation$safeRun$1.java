package com.bytedance.ai.bridge.method.sqlite;

import android.database.sqlite.SQLiteDatabase;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.sqlite.DBOperation$safeRun$1", f = "DBOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DBOperation$safeRun$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<SQLiteDatabase, Unit> $block;
    final /* synthetic */ f3.h<AbsExecuteSqliteActionMethodIDL.b> $callback;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DBOperation this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public DBOperation$safeRun$1(DBOperation r1, Function1<? super SQLiteDatabase, Unit> r10, f3.h<AbsExecuteSqliteActionMethodIDL.b> r11, Continuation<? super DBOperation$safeRun$1> r12) {
        this.this$0 = r1;
        this.$block = r10;
        this.$callback = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        DBOperation$safeRun$1 r0 = new DBOperation$safeRun$1(this.this$0, this.$block, this.$callback, r11);
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
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        DBOperation r12 = this.this$0;
        SQLiteDatabase r0 = r12.c;
        if (r0 == null) goto L10;
        Function1<SQLiteDatabase, Unit> r13 = this.$block;
        f3.h<AbsExecuteSqliteActionMethodIDL.b> r14 = this.$callback;
        if (r0.isOpen() == false) goto L9;
        r13.invoke(r0);
    L12:
        return Unit.INSTANCE;
    L9:
        String r15 = "db is not open: " + r12.b;
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r15);
        f3.h.a.a(r14, r15, null, null, 14);
        goto L12
    L10:
        f3.h<AbsExecuteSqliteActionMethodIDL.b> r1 = this.$callback;
        String r16 = "db is not open: " + r12.b;
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r16);
        f3.h.a.a(r1, r16, null, null, 14);
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
