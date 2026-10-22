package com.obric.aikernel;

import android.content.Context;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.request.track.VMStartupInfo;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class InferEntryHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InferEntryHolder f4392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile InferServiceWrapper f4393b;

    static {
        f4392a = new InferEntryHolder();
    }

    private InferEntryHolder() {
    }

    public static /* synthetic */ InferServiceWrapper b(InferEntryHolder r10, Context r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = AppContext.INSTANCE.getContext();
    L6:
        return r10.a(r11);
    }

    public final InferServiceWrapper a(final Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (f4393b != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f4393b != null) goto L8;
        VMStartupInfo r11 = VMStartupInfo.f4878a;     // Catch: Throwable -> L11
        r11.h();     // Catch: Throwable -> L11
        f4393b = new InferServiceWrapper(r10, new InferEntryHolder$getInferBinder$2$2(r10));     // Catch: Throwable -> L11
        r11.g();     // Catch: Throwable -> L11
    L8:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        InferServiceWrapper r13 = f4393b;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ins");
        return null;
    L20:
        return r13;
    }
}
