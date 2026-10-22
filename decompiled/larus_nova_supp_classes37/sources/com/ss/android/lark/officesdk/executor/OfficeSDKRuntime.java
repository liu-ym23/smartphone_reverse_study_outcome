package com.ss.android.lark.officesdk.executor;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.LaunchTaskFlag;
import com.ss.android.lark.officesdk.api.init.RuntimeStrategy;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKRuntime implements IOfficeSDKRuntime {
    public static final Lazy<OfficeSerialThreadExecutor> d = null;
    public static final Lazy<OfficeSerialThreadExecutor> e = null;
    public final RuntimeStrategy a;
    public final Lazy b;
    public final Lazy c;

    public static final class MainExecutor implements b {
        public MainExecutor() {
        }

        @Override // com.ss.android.lark.officesdk.executor.OfficeSDKRuntime.b
        public final void a(Function0<Unit> r8) {
            Intrinsics.checkNotNullParameter(r8, "block");
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new OfficeSDKRuntime$MainExecutor$execute$1(r8, null), 3, null);
        }
    }

    public static final class OfficeSerialThreadExecutor implements b {
        public final int a;
        public final Lazy b;

        public static final class a implements Runnable {
            public final /* synthetic */ OfficeSerialThreadExecutor a;
            public final /* synthetic */ Function0<Unit> b;

            public a(OfficeSerialThreadExecutor r1, Function0<Unit> r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Log.i("OfficeSDKRuntime", "init office sdk on thread priority = " + this.a.a);     // Catch: Throwable -> L4
                this.b.invoke();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public OfficeSerialThreadExecutor(int r2) {
            this.a = r2;
            this.b = LazyKt.lazy(32, new OfficeSDKRuntime$OfficeSerialThreadExecutor$executor$2(this));
        }

        @Override // com.ss.android.lark.officesdk.executor.OfficeSDKRuntime.b
        public final void a(Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r3, "block");
            ((Executor) this.b.getValue()).execute(new a(this, r3));
        }
    }

    public static final class a {
    }

    public interface b {
        void a(Function0<Unit> r1);
    }

    static {
        d = LazyKt.lazy(32, OfficeSDKRuntime$Companion$highPriorityExecutor$2.INSTANCE);
        e = LazyKt.lazy(32, OfficeSDKRuntime$Companion$normalPriorityExecutor$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime
    public final LaunchTaskFlag getRuntimeFlag() {
        return (LaunchTaskFlag) this.c.getValue();
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime
    public final RuntimeStrategy getStrategy() {
        return this.a;
    }

    public OfficeSDKRuntime(RuntimeStrategy r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        this.a = r2;
        this.b = LazyKt.lazy(32, new OfficeSDKRuntime$runtimeExecutor$2(this));
        this.c = LazyKt.lazy(OfficeSDKRuntime$launchTaskFlag$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime
    public final void run(final Function1<? super IOfficeSDKRuntime, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        ((b) this.b.getValue()).a(new AnonymousClass1(r3, this));
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime
    public final void runOnUI(final Function1<? super IOfficeSDKRuntime, Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "block");
        Function0<Unit> r1 = new C02121(r9, this);
        Intrinsics.checkNotNullParameter(r1, "block");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new OfficeSDKRuntime$MainExecutor$execute$1(r1, null), 3, null);
    }
}
