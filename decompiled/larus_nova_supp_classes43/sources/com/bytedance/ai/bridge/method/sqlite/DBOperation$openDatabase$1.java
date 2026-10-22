package com.bytedance.ai.bridge.method.sqlite;

import android.database.sqlite.SQLiteDatabase;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
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
@DebugMetadata(c = "com.bytedance.ai.bridge.method.sqlite.DBOperation$openDatabase$1", f = "DBOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DBOperation$openDatabase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f3.h<AbsExecuteSqliteActionMethodIDL.b> $callback;
    final /* synthetic */ String $parentFolder;
    int label;
    final /* synthetic */ DBOperation this$0;

    public DBOperation$openDatabase$1(DBOperation r1, f3.h<AbsExecuteSqliteActionMethodIDL.b> r10, String r11, Continuation<? super DBOperation$openDatabase$1> r12) {
        this.this$0 = r1;
        this.$callback = r10;
        this.$parentFolder = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DBOperation$openDatabase$1(this.this$0, this.$callback, this.$parentFolder, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r10);
        SQLiteDatabase r11 = this.this$0.c;
        if (r11 == null) goto L12;
        boolean r12 = true;
        if (r11.isOpen() == true) goto L10;
        r12 = false;
    L10:
        if (r12 == false) goto L12;
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", "Database already open");
        f3.h.a.a(this.$callback, "Database already open", null, null, 14);
    L18:
        return Unit.INSTANCE;
    L12:
        String r13 = this.this$0.a.getFilesDir() + '/' + this.$parentFolder;
        com.bytedance.ai.utils.f.h(r13);
        PolarisFileWrapper r14 = new PolarisFileWrapper(r13, this.this$0.b);
        this.this$0.c = SQLiteDatabase.openOrCreateDatabase(r14.getAbsolutePath(), null);     // Catch: Exception -> L15
        f3.h<AbsExecuteSqliteActionMethodIDL.b> r15 = this.$callback;     // Catch: Exception -> L15
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.b.class, "<this>");     // Catch: Exception -> L15
        f3.h.a.b(r15, (ResultModel) k3.c.a(AbsExecuteSqliteActionMethodIDL.b.class));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        String r16 = "Failed to open db(" + this.this$0.b + "): " + e.getMessage();
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r16);
        f3.h.a.a(this.$callback, r16, null, null, 14);
        goto L18
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
