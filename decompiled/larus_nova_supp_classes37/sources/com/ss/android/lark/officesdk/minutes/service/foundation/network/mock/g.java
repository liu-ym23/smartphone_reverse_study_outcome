package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static final a h = null;
    public final Function0<mub.a> a;
    public final Function0<Boolean> b;
    public final Function0<i> c;
    public final CoroutineScope d;
    public final ConcurrentHashMap<b, MutableSharedFlow<Object>> e;
    public final ConcurrentHashMap<b, List<c>> f;
    public final ConcurrentHashMap<b, List<Job>> g;

    public static final class a {
        public a() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");
        L12:
            throw th;
        L34:
            Class<?> r3 = Class.forName("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");     // Catch: Throwable -> L17
        L16:
            return r3;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");
        }
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "MockPushKey(type=" + this.a + ", key=" + this.b + ')';
        }

        public final String getType() {
            return this.a;
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "key");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
    }

    public g() {
        throw null;
    }

    static {
        h = new a();
    }

    public final void a() {
        mub.a r0 = (mub.a) this.a.invoke();
        if (r0 != null) goto L6;
        return;
    L6:
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L8;
        return;
    L8:
        if (r0.isEnabled() == false) goto L16;
        i r1 = (i) this.c.invoke();
        if (r1 == null) goto L15;
        r1.build();
        return;
    L15:
        return;
    }

    public g(Function0 r4) {
        MmRecordingNetworkMockEngine$1 r0 = MmRecordingNetworkMockEngine$1.INSTANCE;
        MmRecordingNetworkMockEngine$2 r1 = MmRecordingNetworkMockEngine$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "providerProvider");
        Intrinsics.checkNotNullParameter(r0, "debugEnabledProvider");
        Intrinsics.checkNotNullParameter(r1, "scenarioProviderProvider");
        this.a = r4;
        this.b = r0;
        this.c = r1;
        this.d = CoroutineScopeKt.CoroutineScope(MMCoroutines.b("MmRecordingNetworkMockEngine"));
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
    }

    public final e b(d r6, Continuation r7) {
        if ((r7 instanceof MmRecordingNetworkMockEngine$mockRequest$1) == false) goto L7;
        MmRecordingNetworkMockEngine$mockRequest$1 r0 = (MmRecordingNetworkMockEngine$mockRequest$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        String r3 = null;
        if (r2 != 0) goto L11;
        ResultKt.throwOnFailure(r8);
        a();
        c(r6.getType(), r6.b, false, null);
        return e.b.a;
    L11:
        if (r2 != 1) goto L13;
        h r4 = (h) r0.L$2;
        Class r5 = (Class) r0.L$1;
        d r9 = (d) r0.L$0;
        ResultKt.throwOnFailure(r8);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L17
        r4.getClass();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r9, "request");     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Object r12 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isSuccess-impl(r12) == true) goto L28;
        String r13 = r9.getType();
        String r14 = r9.b;
        if (Result.isSuccess-impl(r12) == false) goto L23;
        r4.getClass();
        r3 = "scenario=null";
    L26:
        c(r13, r14, true, r3);
        return new e.a(r12);
    L23:
        Throwable r15 = Result.exceptionOrNull-impl(r12);
        if (r15 == null) goto L26;
        r3 = r15.getMessage();
        goto L26
    L28:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Any");
        r4.getClass();
        throw null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new MmRecordingNetworkMockEngine$mockRequest$1(this, r7);
        goto L8
    }

    public final boolean d(String r4, String r5) {
        b r0 = new b(r4, r5);
        boolean r6 = true;
        if (this.e.remove(r0) == null) goto L5;
    L16:
        a();
        return r6;
    L5:
        if (this.f.remove(r0) != null) goto L16;
        List<Job> r7 = this.g.remove(r0);
        if (r7 == null) goto L12;
        Iterator<T> r1 = r7.iterator();
    L10:
        if (r1.hasNext() == false) goto L13;
        Job.DefaultImpls.cancel$default((Job) r1.next(), null, 1, null);
    L13:
        if (r7 != null) goto L16;
        r6 = false;
        goto L16
    L12:
        r7 = null;
        goto L13
    }

    public final void c(String r1, String r2, boolean r3, String r4) {
        mub.a r5 = (mub.a) this.a.invoke();
        if (r5 == null) goto L6;
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, "key");
        r5.M1();
        return;
    }
}
