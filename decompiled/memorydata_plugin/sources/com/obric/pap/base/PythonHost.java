package com.obric.pap.base;

import android.content.Context;
import android.os.Debug;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\t\u0010\u0007\u001a\u00020\bH\u0086 J\t\u0010\t\u001a\u00020\nH\u0086 J4\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\t\u0010\u0015\u001a\u00020\u0011H\u0086 J#\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0082 J\u0011\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0086 J\t\u0010\u001a\u001a\u00020\bH\u0086 J\u0011\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0086 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/pap/base/PythonHost;", "", "()V", "TAG", "", "currentPssKb", "", "finalize", "", "getVersion", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "ctx", "Landroid/content/Context;", "home", "Ljava/io/File;", "frozen", "", "enableMemTrace", "logger", "Lcom/obric/pap/base/HostLogger;", "isInitialized", "nativeInit", "runModule", "runFile", "filename", "runMain", "runString", AILabCheckPermissionTask.KEY_SOURCE, "PythonBase_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PythonHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PythonHost f14917a = null;

    static {
        f14917a = new PythonHost();
        System.loadLibrary("pap_jni");
    }

    private PythonHost() {
    }

    private final long a() {
        return Debug.getPss();
    }

    private final native int nativeInit(boolean r1, String r2, String r3);

    public final int a(Context r10, File r11, boolean r12, boolean r13, a r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        a r16 = (a) ZeusTransformUtils.wrapperContextForParams(r14, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "ctx");
        Intrinsics.checkNotNullParameter(r11, "home");
        if (r13 == false) goto L5;
        final Long r4 = Long.valueOf(a());
    L6:
        String r17 = new File(r11, "python").getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r17, "File(home, \"python\").absolutePath");
        int r18 = nativeInit(r12, r17, null);
        if (r18 == 0) goto L9;
        return r18;
    L9:
        if (r13 == false) goto L14;
        if (r4 == null) goto L14;
        final long r5 = a();
        final long r7 = r5 - r4.longValue();
        if (r16 == null) goto L14;
        r16.logI("PythonHost", (Function0) ZeusTransformUtils.preCheckCast(new PythonHost$init$1(r4, r5, r7), Function0.class, "com.obric.memorydata.plugin"));
    L14:
        if (r13 == false) goto L16;
        String r19 = "import tracemalloc\ntracemalloc.start()\nprint(f\"MemTrace(first) = {tracemalloc.get_traced_memory()[0]/1048576:.2f}MB\")\n";
    L17:
        runString(r19 + com.obric.pap.base.a.b.f14919a.a(r15));
        return 0;
    L16:
        r19 = "";
        goto L17
    L5:
        r4 = null;
        goto L6
    }

    public final native int finalize();

    public final native int[] getVersion();

    public final native boolean isInitialized();

    public final native int runFile(String r1);

    public final native int runMain();

    public final native int runString(String r1);
}
