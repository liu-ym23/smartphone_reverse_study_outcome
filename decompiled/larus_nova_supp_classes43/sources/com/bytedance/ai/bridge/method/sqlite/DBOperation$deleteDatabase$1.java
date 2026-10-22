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
@DebugMetadata(c = "com.bytedance.ai.bridge.method.sqlite.DBOperation$deleteDatabase$1", f = "DBOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DBOperation$deleteDatabase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f3.h<AbsExecuteSqliteActionMethodIDL.b> $callback;
    final /* synthetic */ String $parentFolder;
    int label;
    final /* synthetic */ DBOperation this$0;

    public DBOperation$deleteDatabase$1(DBOperation r1, String r10, f3.h<AbsExecuteSqliteActionMethodIDL.b> r11, Continuation<? super DBOperation$deleteDatabase$1> r12) {
        this.this$0 = r1;
        this.$parentFolder = r10;
        this.$callback = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DBOperation$deleteDatabase$1(this.this$0, this.$parentFolder, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r10);
        SQLiteDatabase r11 = this.this$0.c;
        if (r11 == null) goto L10;
        if (r11.isOpen() == false) goto L10;
        r11.close();
    L10:
        if (SQLiteDatabase.deleteDatabase(new PolarisFileWrapper(this.this$0.a.getFilesDir() + '/' + this.$parentFolder + '/' + this.this$0.b)) == false) goto L12;
        f3.h<AbsExecuteSqliteActionMethodIDL.b> r12 = this.$callback;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.b.class, "<this>");
        f3.h.a.b(r12, (ResultModel) k3.c.a(AbsExecuteSqliteActionMethodIDL.b.class));
    L14:
        return Unit.INSTANCE;
    L12:
        String r13 = "Failed to delete db: " + this.$parentFolder + '/' + this.this$0.b;
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r13);
        f3.h.a.a(this.$callback, r13, null, null, 14);
        goto L14
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
