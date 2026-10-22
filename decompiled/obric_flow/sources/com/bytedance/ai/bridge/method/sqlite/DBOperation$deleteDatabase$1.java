package com.bytedance.ai.bridge.method.sqlite;

import android.database.sqlite.SQLiteDatabase;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
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
@DebugMetadata(c = "com.bytedance.ai.bridge.method.sqlite.DBOperation$deleteDatabase$1", f = "DBOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DBOperation$deleteDatabase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o1.f f1974c;

    public DBOperation$deleteDatabase$1(d r5, String r10, o1.f r11, Continuation r12) {
        this.f1972a = r5;
        this.f1973b = r10;
        this.f1974c = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new DBOperation$deleteDatabase$1(this.f1972a, this.f1973b, this.f1974c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((DBOperation$deleteDatabase$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        SQLiteDatabase r10 = this.f1972a.f1994c;
        if (r10 == null) goto L8;
        if (r10.isOpen() == false) goto L8;
        r10.close();
    L8:
        if (SQLiteDatabase.deleteDatabase(new File(this.f1972a.f1992a.getFilesDir() + '/' + this.f1973b + '/' + this.f1972a.f1993b)) == false) goto L10;
        o1.f r11 = this.f1974c;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class, "<this>");
        r11.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class), "");
    L15:
        return Unit.INSTANCE;
    L10:
        StringBuilder r12 = new StringBuilder("Failed to delete db: ");
        r12.append(this.f1973b);
        r12.append('/');
        String r13 = androidx.room.jarjarred.org.antlr.runtime.a.v(r12, this.f1972a.f1993b, "ExecuteSqliteActionMethod", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L13;
        r14.e("ExecuteSqliteActionMethod", r13);
    L13:
        this.f1974c.a(r13);
        goto L15
    }
}
