package com.obric.aikernel.middleware.impl.obric;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class ContextSilentUpdateServiceBinder implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<i, Intent> f4564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3<Intent, Executor, ServiceConnection, Boolean> f4565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1<ServiceConnection, Unit> f4566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f4567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f4568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f4569f;

    public static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ContextSilentUpdateServiceBinder f4570c;

        a(ContextSilentUpdateServiceBinder r10) {
            this.f4570c = r10;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r10) {
            ContextSilentUpdateServiceBinder.d(this.f4570c, false);
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r10) {
            ContextSilentUpdateServiceBinder.d(this.f4570c, false);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            ContextSilentUpdateServiceBinder.d(this.f4570c, true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            ContextSilentUpdateServiceBinder.d(this.f4570c, false);
        }
    }

    public ContextSilentUpdateServiceBinder(final Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(AnonymousClass1.INSTANCE, new AnonymousClass2(r10), new AnonymousClass3(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContextSilentUpdateServiceBinder(Function1<? super i, ? extends Intent> r10, Function3<? super Intent, ? super Executor, ? super ServiceConnection, Boolean> r11, Function1<? super ServiceConnection, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "buildIntent");
        Intrinsics.checkNotNullParameter(r11, "bindServiceCall");
        Intrinsics.checkNotNullParameter(r12, "unbindServiceCall");
        this.f4564a = r10;
        this.f4565b = r11;
        this.f4566c = r12;
        this.f4567d = new a(this);
    }

    public static final /* synthetic */ void d(ContextSilentUpdateServiceBinder r10, boolean r11) {
        r10.f4568e = r11;
    }

    @Override // com.obric.aikernel.middleware.impl.obric.g
    public void a() {
        if (this.f4569f == true) goto L14;
        return;
    L14:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        this.f4566c.invoke(this.f4567d);     // Catch: Throwable -> L7
        Object r11 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r12 = Result.m35exceptionOrNullimpl(r11);
        if (r12 == null) goto L12;
        AIKLog.INSTANCE.e(ProcessService.TAG, "unbind AIKernelService failed: " + r12);
    L12:
        this.f4569f = false;
        this.f4568e = false;
        return;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // com.obric.aikernel.middleware.impl.obric.g
    public boolean b(i r10) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.AttributesType.S_TARGET);
        if (this.f4569f == false) goto L6;
        return false;
    L6:
        Intent r11 = this.f4564a.invoke(r10);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L9
        Object r13 = Result.m32constructorimpl(Boolean.valueOf(this.f4565b.invoke(r11, m1.a(z0.b()), this.f4567d).booleanValue()));     // Catch: Throwable -> L9
    L12:
        if (Result.m39isSuccessimpl(r13) == false) goto L14;
        boolean r14 = ((Boolean) r13).booleanValue();
        this.f4569f = r14;
        this.f4568e = r14;
    L14:
        Throwable r15 = Result.m35exceptionOrNullimpl(r13);
        if (r15 == null) goto L17;
        AIKLog.INSTANCE.e(ProcessService.TAG, "bind AIKernelService failed: " + r15);
    L17:
        Boolean r16 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r13) == false) goto L21;
        r13 = r16;
    L21:
        return ((Boolean) r13).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.obric.aikernel.middleware.impl.obric.g
    public boolean c() {
        return this.f4568e;
    }
}
