package com.bytedance.ai.bridge.method.sqlite;

import android.database.sqlite.SQLiteDatabase;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.lynx.tasm.ui.image.f0;
import java.io.File;
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
@DebugMetadata(c = "com.bytedance.ai.bridge.method.sqlite.DBOperation$openDatabase$1", f = "DBOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DBOperation$openDatabase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o1.f f1976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1977c;

    public DBOperation$openDatabase$1(d r5, o1.f r10, String r11, Continuation r12) {
        this.f1975a = r5;
        this.f1976b = r10;
        this.f1977c = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new DBOperation$openDatabase$1(this.f1975a, this.f1976b, this.f1977c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((DBOperation$openDatabase$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        SQLiteDatabase r10 = this.f1975a.f1994c;
        if (r10 != null) goto L5;
    L10:
        String r11 = this.f1975a.f1992a.getFilesDir() + '/' + this.f1977c;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        File r12 = new File(r11);
        if (r12.exists() == true) goto L13;
        r12.mkdirs();
    L13:
        File r13 = new File(r11, this.f1975a.f1993b);
        this.f1975a.f1994c = SQLiteDatabase.openOrCreateDatabase(r13.getAbsolutePath(), null);     // Catch: Exception -> L16
        o1.f r14 = this.f1976b;     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class, "<this>");     // Catch: Exception -> L16
        r14.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class), "");     // Catch: Exception -> L16
    L22:
        return Unit.INSTANCE;
    L16:
        e = move-exception;
        StringBuilder r15 = new StringBuilder("Failed to open db(");
        r15.append(this.f1975a.f1993b);
        r15.append("): ");
        String r16 = f0.d(e, r15, "ExecuteSqliteActionMethod");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L20;
        r17.e("ExecuteSqliteActionMethod", r16);
    L20:
        this.f1976b.a(r16);
        goto L22
    L5:
        if (r10.isOpen() != true) goto L10;
        Intrinsics.checkNotNullParameter("ExecuteSqliteActionMethod", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L9;
        r18.e("ExecuteSqliteActionMethod", "Database already open");
    L9:
        this.f1976b.a("Database already open");
        goto L22
    }
}
