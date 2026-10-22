package com.bytedance.ai.bridge.method.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.sqlite.DBOperation$safeRun$1", f = "DBOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DBOperation$safeRun$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f1980c;
    public final /* synthetic */ o1.f d;

    public DBOperation$safeRun$1(d r5, Function1 r10, o1.f r11, Continuation r12) {
        this.f1979b = r5;
        this.f1980c = r10;
        this.d = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        DBOperation$safeRun$1 r11 = new DBOperation$safeRun$1(this.f1979b, this.f1980c, this.d, r10);
        r11.f1978a = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((DBOperation$safeRun$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.f1978a;
        d r12 = this.f1979b;
        SQLiteDatabase r5 = r12.f1994c;
        String r13 = r12.f1993b;
        if (r5 == null) goto L11;
        Function1 r14 = this.f1980c;
        o1.f r15 = this.d;
        if (r5.isOpen() == false) goto L7;
        r14.invoke(r5);
    L16:
        return Unit.INSTANCE;
    L7:
        String r16 = "db is not open: " + r13;
        Intrinsics.checkNotNullParameter("ExecuteSqliteActionMethod", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L10;
        r17.e("ExecuteSqliteActionMethod", r16);
    L10:
        r15.a(r16);
        goto L16
    L11:
        o1.f r18 = this.d;
        String r19 = "db is not open: " + r13;
        Intrinsics.checkNotNullParameter("ExecuteSqliteActionMethod", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L14;
        r20.e("ExecuteSqliteActionMethod", r19);
    L14:
        r18.a(r19);
        goto L16
    }
}
