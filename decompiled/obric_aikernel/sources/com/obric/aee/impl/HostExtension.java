package com.obric.aee.impl;

import com.obric.aee.impl.loop.TaskQueueThread;
import com.obric.pap.base.PythonHost;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class HostExtension {
    public static final HostExtension INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f4318a = null;

    public static final class a extends TaskQueueThread {
        a() {
            super("PapLooper");
        }

        @Override // com.obric.aee.impl.loop.TaskQueueThread
        protected void d() {
            HostExtension.a(HostExtension.INSTANCE);
        }

        @Override // com.obric.aee.impl.loop.TaskQueueThread
        protected void e() {
            if (PythonHost.f7778a.isInitialized() == true) goto L5;
            return;
        L5:
            HostExtension.b(HostExtension.INSTANCE);
        }
    }

    static {
        INSTANCE = new HostExtension();
        System.loadLibrary("aee_core");
        f4318a = new a();
    }

    private HostExtension() {
    }

    public static final /* synthetic */ void a(HostExtension r10) {
        r10.nativeLoopBreak();
    }

    public static final /* synthetic */ void b(HostExtension r10) {
        r10.nativeLoopRun();
    }

    private final native void createPythonPipe(String r10);

    private final native void freePythonPipe(String r10);

    private final native void nativeLoopBreak();

    private final native void nativeLoopInit();

    private final native void nativeLoopRun();

    private final native void nativeSetCb(Object r10);

    private final native boolean writePythonPipe(String r10, byte[] r11);

    private final native long writeRawPythonPipe(int r10, byte[] r11);

    public final void c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        createPythonPipe(r10);
    }

    public final <T> Object d(Function0<? extends T> r10, Continuation<? super T> r11) {
        return f4318a.f(r10, r11);
    }

    public final void e(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "cb");
        nativeSetCb(r10);
    }

    public final void f() {
        nativeLoopInit();
        InvokeUtils.INSTANCE.k();
    }

    public final boolean g(String r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "data");
        return writePythonPipe(r10, r11);
    }

    public final long h(int r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r11, "data");
        return writeRawPythonPipe(r10, r11);
    }

    public final native List<String> tracebackNative();

    public final native String tracebackPython(boolean r10);
}
