package com.obric.pap.base;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import ja.b;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class PythonHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PythonHost f7778a = null;

    static {
        f7778a = new PythonHost();
        System.loadLibrary("pap_jni");
    }

    private PythonHost() {
    }

    private final long a() {
        return Debug.getPss();
    }

    private final native int nativeInit(boolean r10, String r11, String r12);

    public final int b(Context r10, File r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "home");
        if (r13 == false) goto L5;
        Long r14 = Long.valueOf(a());
    L6:
        String r15 = new File(r11, "python").getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r15, "File(home, \"python\").absolutePath");
        int r16 = nativeInit(r12, r15, null);
        if (r16 == 0) goto L9;
        return r16;
    L9:
        if (r13 == false) goto L12;
        if (r14 == null) goto L12;
        long r17 = a();
        Log.i("PythonHost", "MemTrace(nativeInit.pss) before=" + (r14.longValue() / 1024.0d) + "MB after=" + (r17 / 1024.0d) + "MB delta=" + ((r17 - r14.longValue()) / 1024.0d) + "MB");
    L12:
        if (r13 == false) goto L14;
        String r18 = "import tracemalloc\ntracemalloc.start()\nprint(f\"MemTrace(first) = {tracemalloc.get_traced_memory()[0]/1048576:.2f}MB\")\n";
    L15:
        runString(r18 + b.f9792a.b(r10));
        return 0;
    L14:
        r18 = "";
        goto L15
    L5:
        r14 = null;
        goto L6
    }

    public final native int finalize();

    public final native int[] getVersion();

    public final native boolean isInitialized();

    public final native int runFile(String r10);

    public final native int runMain();

    public final native int runString(String r10);
}
