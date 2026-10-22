package com.obric.memorydata.database.entity;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0007\u0012\u0004\u0012\u0002H\n0\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u0007¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/entity/SemanticIndexCommitScope;", "", "<init>", "()V", "pending", "Ljava/lang/ThreadLocal;", "", "Lkotlin/Function0;", "", "transaction", ExifInterface.GPS_DIRECTION_TRUE, "commit", "Lkotlin/Function1;", "write", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "afterCommit", "action", "isActive", "", "isActive$database_obricRelease", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final id f9213a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<List<Function0<Unit>>> f9214b = null;

    static {
        f9213a = new id();
        f9214b = new ThreadLocal();
    }

    private id() {
    }

    public final <T> T a(Function1<? super Function0<? extends T>, ? extends T> r9, Function0<? extends T> r10) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "commit");
        Intrinsics.checkNotNullParameter(r11, "write");
        ThreadLocal<List<Function0<Unit>>> r12 = f9214b;
        if (r12.get() != null) goto L5;
        List<Function0<Unit>> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r12.set(r1);
        T r13 = (T) r8.invoke(r11);
        r12.remove();
        Iterator<T> r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r14.hasNext() == false) goto L19;
        Function0 r15 = (Function0) ZeusTransformUtils.preCheckCast(r14.next(), Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        Object r16 = Result.m1421constructorimpl(r15.invoke());     // Catch: Throwable -> L14
    L16:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SemanticIndexCommitScope", "index registration failed error_class=" + r17.getClass().getSimpleName(), null, 4, null);
    L14:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    L19:
        return r13;
    L20:
        th = move-exception;
        f9214b.remove();
        throw th;
    L5:
        return (T) r8.invoke(r11);
    }

    public final void a(Function0<Unit> r3) {
        Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "action");
        List r4 = (List) ZeusTransformUtils.preCheckCast(f9214b.get(), List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        r2.invoke();
        return;
    L5:
        r4.add(r2);
    }

    public final boolean a() {
        if (f9214b.get() == null) goto L5;
        return true;
    L5:
        return false;
    }
}
