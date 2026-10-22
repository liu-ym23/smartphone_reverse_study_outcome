package com.obric.aikernel.multiusr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.UserHandle;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.multiproc.MultiProcBridge;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiUsrAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MultiUsrAdapter f4720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f4721b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static a f4722c;

    static {
        f4720a = new MultiUsrAdapter();
        f4721b = LazyKt.lazy(MultiUsrAdapter$convertorMap$2.INSTANCE);
    }

    private MultiUsrAdapter() {
    }

    private final ConcurrentHashMap<Integer, a.b> a() {
        return (ConcurrentHashMap) f4721b.getValue();
    }

    public final ParcelFileDescriptor b(String r10, UserHandle r11) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "usrHandle");
        a.b r12 = a().get(Integer.valueOf(r11.hashCode()));
        if (r12 == null) goto L7;
        return r12.a(r10);
    L7:
        throw new IllegalArgumentException("get convertor".toString());
    }

    public final a c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        a r11 = f4722c;
        if (r11 != null) goto L16;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (f4722c != null) goto L8;
        f4722c = new a(r10);     // Catch: Throwable -> L13
    L8:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        a r13 = f4722c;
        if (r13 != null) goto L21;
    L17:
        Intrinsics.throwUninitializedPropertyAccessException("localRef");
        return null;
    L21:
        return r13;
    L16:
        if (r11 == null) goto L17;
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(Bundle r11, final UserHandle r12) {
        Intrinsics.checkNotNullParameter(r11, "args");
        Intrinsics.checkNotNullParameter(r12, "callerUsr");
        if (r11.containsKey("filePath") == true) goto L5;
        return;
    L5:
        if (r11.getString("filePath") == null) goto L27;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L16
        final String r13 = r11.getString("filePath");     // Catch: Throwable -> L16
        if (r13 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r13, "requireNotNull(args.getString(Params.FILE_PATH))");     // Catch: Throwable -> L16
        final Ref.ObjectRef r14 = new Ref.ObjectRef();     // Catch: Throwable -> L16
        MultiProcBridge.f4548a.a("MultiUsrAdapter", "getFd", new MultiUsrAdapter$processArgs$1$1(r14, this, r13, r12), new MultiUsrAdapter$processArgs$1$2(r13, r12), new MultiUsrAdapter$processArgs$1$3(r14));     // Catch: Throwable -> L16
        T r15 = r14.element;     // Catch: Throwable -> L16
        if (r15 == 0) goto L13;
        Object r16 = Result.m32constructorimpl((ParcelFileDescriptor) r15);     // Catch: Throwable -> L16
    L19:
        if (Result.m39isSuccessimpl(r16) == false) goto L21;
        r11.putParcelable("fdObject", (ParcelFileDescriptor) r16);
        r11.putBoolean("_mark_recycle_fd_from_internal", true);
        r11.remove("filePath");
    L21:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);
        if (r17 == null) goto L28;
        AIKLog.INSTANCE.w("MultiUsrAdapter", "processArgs failed by " + r17);
        return;
    L28:
        return;
    L13:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L16
    L15:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public final void e(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        if (r10.getBoolean("_mark_recycle_fd_from_internal") == false) goto L8;
        ParcelFileDescriptor r11 = (ParcelFileDescriptor) r10.getParcelable("fdObject");
        if (r11 == null) goto L9;
        r11.close();
        return;
    L9:
        return;
    }

    public final void f(UserHandle r10, IBinder r11) {
        Intrinsics.checkNotNullParameter(r10, "userHandle");
        Intrinsics.checkNotNullParameter(r11, "binder");
        monitor-enter(this);
        MultiUsrAdapter r12 = f4720a;     // Catch: Throwable -> L15
        a.b r13 = r12.a().get(Integer.valueOf(r10.hashCode()));     // Catch: Throwable -> L15
        boolean r14 = true;
        if (r13 != null) goto L7;
    L9:
        r14 = false;
    L10:
        if (r14 == true) goto L12;
        r12.a().put(Integer.valueOf(r10.hashCode()), new a.b(r11));     // Catch: Throwable -> L15
    L12:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L7:
        if (r13.b() != true) goto L9;
    L15:
        th = move-exception;
        throw th;
    }
}
