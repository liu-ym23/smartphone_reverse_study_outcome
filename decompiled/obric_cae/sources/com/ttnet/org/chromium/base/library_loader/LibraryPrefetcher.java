package com.ttnet.org.chromium.base.library_loader;

import android.annotation.SuppressLint;
import com.ttnet.org.chromium.base.CommandLine;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.SysUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import com.ttnet.org.chromium.base.task.PostTask;
import com.ttnet.org.chromium.base.task.TaskTraits;
import java.util.concurrent.atomic.AtomicBoolean;
import o5.r;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class LibraryPrefetcher {
    private static final String TAG = "LibraryPrefetcher";
    private static final AtomicBoolean sPrefetchLibraryHasBeenCalled = null;

    public static final class OrderedCodeInfo {
        public final String filename;
        public final long length;
        public final long startOffset;

        @CalledByNative("OrderedCodeInfo")
        public OrderedCodeInfo(String r8, long r10, long r11) {
            this.filename = r8;
            this.startOffset = r10;
            this.length = r11;
        }

        public String toString() {
            return "filename = " + this.filename + " startOffset = " + this.startOffset + " length = " + this.length;
        }
    }

    private static /* synthetic */ void $closeResource(Throwable r8, AutoCloseable r10) {
        if (r8 != null) goto L9;
        r10.close();
        return;
    L9:
        r10.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r8.addSuppressed(th);
    }

    static {
        sPrefetchLibraryHasBeenCalled = new AtomicBoolean();
    }

    public LibraryPrefetcher() {
    }

    public static /* synthetic */ void a(boolean r8) {
        lambda$asyncPrefetchLibrariesToMemory$0(r8);
    }

    public static void asyncPrefetchLibrariesToMemory() {
        SysUtils.logPageFaultCountToTracing();
        final boolean r8 = sPrefetchLibraryHasBeenCalled.compareAndSet(false, true);
        if (r8 == true) goto L5;
    L8:
        PostTask.postTask(TaskTraits.USER_BLOCKING, new a(r8));
        return;
    L5:
        if (CommandLine.getInstance().hasSwitch("log-native-library-residency") == false) goto L8;
        new Thread(new r(5)).start();
    }

    public static /* synthetic */ void b() {
        nativePeriodicallyCollectResidency();
    }

    private static /* synthetic */ void lambda$asyncPrefetchLibrariesToMemory$0(boolean r8) {
        int r10 = nativePercentageOfResidentNativeLibraryCode();
        TraceEvent r11 = TraceEvent.scoped("LibraryPrefetcher.asyncPrefetchLibrariesToMemory", Integer.toString(r10));
        if (r8 == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L13;
        nativeForkAndPrefetchNativeLibrary();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        if (r11 == null) goto L24;
        $closeResource(th, r11);
    L24:
        throw th;
    L13:
        if (r10 != (-1)) goto L15;
    L25:
        if (r11 == null) goto L27;
        $closeResource(null, r11);
    L27:
        ContextUtils.getAppSharedPreferences().edit().remove("dont_prefetch_libraries").apply();
        return;
    L15:
        if (r8 == false) goto L17;
        String r13 = ".ColdStartup";
    L18:
        RecordHistogram.recordPercentageHistogram("LibraryLoader.PercentageOfResidentCodeBeforePrefetch".concat(r13), r10);     // Catch: Throwable -> L10
        goto L25
    L17:
        r13 = ".WarmStartup";
        goto L18
    L5:
        if (r10 >= 90) goto L7;
        r12 = true;
        goto L8
    }

    @SuppressLint({"WrongConstant"})
    public static void maybePinOrderedCodeInMemory() {
        TraceEvent r8 = TraceEvent.scoped("LibraryPrefetcher::maybePinOrderedCodeInMemory");
        OrderedCodeInfo r10 = nativeGetOrderedCodeInfo();     // Catch: Throwable -> L26
        if (r10 != null) goto L9;
        if (r8 == null) goto L38;
        $closeResource(null, r8);
        return;
    L38:
        return;
    L9:
        TraceEvent.instant("pinOrderedCodeInMemory", r10.toString());     // Catch: Throwable -> L26
        Object r11 = ContextUtils.getApplicationContext().getSystemService("pinner");     // Catch: Throwable -> L26
        if (r11 != null) goto L36;
        Log.w(TAG, "Cannot get PinnerService.", new Object[0]);     // Catch: Throwable -> L26
        if (r8 == null) goto L39;
        $closeResource(null, r8);
        return;
    L39:
        return;
    L36:
        Class<?> r12 = r11.getClass();     // Catch: Throwable -> L21 Throwable -> L26
        Class<?> r13 = Integer.TYPE;     // Catch: Throwable -> L21 Throwable -> L26
        if (((Boolean) r12.getMethod("pinRangeFromFile", new Class[]{String.class, r13, r13}).invoke(r11, new Object[]{r10.filename, Integer.valueOf((int) r10.startOffset), Integer.valueOf((int) r10.length)})).booleanValue() == true) goto L19;
        Log.e(TAG, "Not allowed to call the method, should not happen", new Object[0]);     // Catch: Throwable -> L21 Throwable -> L26
    L35:
    L23:
        if (r8 == null) goto L40;
        $closeResource(null, r8);
        return;
    L40:
        return;
    L19:
        Log.i(TAG, "Successfully pinned ordered code", new Object[0]);     // Catch: Throwable -> L21 Throwable -> L26
    L21:
        e = move-exception;
        Log.w(TAG, "Error invoking the method. " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        if (r8 == null) goto L31;
        $closeResource(th, r8);
    L31:
        throw th;
    }

    private static native void nativeForkAndPrefetchNativeLibrary();

    private static native OrderedCodeInfo nativeGetOrderedCodeInfo();

    private static native int nativePercentageOfResidentNativeLibraryCode();

    private static native void nativePeriodicallyCollectResidency();
}
