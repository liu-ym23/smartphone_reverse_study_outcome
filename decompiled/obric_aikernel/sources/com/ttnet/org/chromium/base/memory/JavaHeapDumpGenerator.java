package com.ttnet.org.chromium.base.memory;

import android.os.Debug;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class JavaHeapDumpGenerator {
    private static final String TAG = "JavaHprofGenerator";

    private JavaHeapDumpGenerator() {
    }

    @CalledByNative
    public static boolean generateHprof(String r10) {
        Debug.dumpHprofData(r10);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        Log.i(TAG, "Error writing to file " + r10 + ". Error: " + e.getMessage(), new Object[0]);
        return false;
    }
}
