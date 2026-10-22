package com.obric.aee.impl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.pap.base.PythonHost;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0082 J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0082 J%\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0007H\u0082 J\t\u0010\u0013\u001a\u00020\u0007H\u0082 J\t\u0010\u0014\u001a\u00020\u0007H\u0082 J!\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082 J\u001e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u0007J\u0014\u0010\u001d\u001a\u00020\u00182\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0086 J\u0013\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\u0018H\u0086 J\u0016\u0010\"\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020$J\u0019\u0010%\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020$H\u0082 J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$J\u0019\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020$H\u0082 R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/obric/aee/impl/HostExtension;", "", "()V", "_cmdThread", "com/obric/aee/impl/HostExtension$_cmdThread$1", "Lcom/obric/aee/impl/HostExtension$_cmdThread$1;", "createPipe", "", "key", "", "createPythonPipe", "freePipe", "freePythonPipe", "launchInLoop", ExifInterface.GPS_DIRECTION_TRUE, "task", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nativeLoopBreak", "nativeLoopInit", "nativeLoopRun", "nativeSetCb", f.c, "disableLogDispatcher", "", "minLogPriority", "", "setupGlobalCallback", "setupPythonEnv", "submitInLoop", "tracebackNative", "", "tracebackPython", "allThread", "writePipe", "data", "", "writePythonPipe", EventBody.KEY_VALUE, "writeRawPipe", "", "fd", "writeRawPythonPipe", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HostExtension {
    public static final HostExtension INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f5877a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0014¨\u0006\u0005"}, d2 = {"com/obric/aee/impl/HostExtension$_cmdThread$1", "Lcom/obric/aee/impl/loop/TaskQueueThread;", "active", "", "idle", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends com.obric.aee.impl.loop.a {
        a() {
            super("PapLooper");
        }

        @Override // com.obric.aee.impl.loop.a
        public void a() {
            HostExtension.a(HostExtension.INSTANCE);
        }

        @Override // com.obric.aee.impl.loop.a
        public void b() {
            if (PythonHost.f14917a.isInitialized() == true) goto L5;
            return;
        L5:
            HostExtension.b(HostExtension.INSTANCE);
        }
    }

    static {
        INSTANCE = new HostExtension();
        System.loadLibrary("aee_core");
        f5877a = new a();
    }

    private HostExtension() {
    }

    public static final /* synthetic */ void a(HostExtension r0) {
        r0.nativeLoopBreak();
    }

    public static final /* synthetic */ void b(HostExtension r0) {
        r0.nativeLoopRun();
    }

    private final native void createPythonPipe(String r1);

    private final native void freePythonPipe(String r1);

    private final native void nativeLoopBreak();

    private final native void nativeLoopInit();

    private final native void nativeLoopRun();

    private final native void nativeSetCb(Object r1, boolean r2, int r3);

    private final native boolean writePythonPipe(String r1, byte[] r2);

    private final native long writeRawPythonPipe(int r1, byte[] r2);

    public final long a(int r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        return writeRawPythonPipe(r2, r3);
    }

    public final <T> Object a(Function0<? extends T> r2, Continuation<? super T> r3) {
        Function0<? extends T> r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Continuation<? super T> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return f5877a.a(r1, r4);
    }

    public final void a() {
        nativeLoopInit();
        InvokeUtils.INSTANCE.a();
    }

    public final void a(Object r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, f.c);
        nativeSetCb(r2, r3, r4);
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        createPythonPipe(r2);
    }

    public final boolean a(String r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "data");
        return writePythonPipe(r2, r3);
    }

    public final native List<String> tracebackNative();

    public final native String tracebackPython(boolean r1);
}
