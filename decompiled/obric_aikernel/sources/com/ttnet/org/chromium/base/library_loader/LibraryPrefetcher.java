package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.CommandLine;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.SysUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import com.ttnet.org.chromium.base.task.PostTask;
import com.ttnet.org.chromium.base.task.TaskTraits;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class LibraryPrefetcher {
    private static final String TAG = "LibraryPrefetcher";
    private static final AtomicBoolean sPrefetchLibraryHasBeenCalled = null;

    interface Natives {
        void forkAndPrefetchNativeLibrary();

        int percentageOfResidentNativeLibraryCode();

        void periodicallyCollectResidency();
    }

    static {
        sPrefetchLibraryHasBeenCalled = new AtomicBoolean();
    }

    public LibraryPrefetcher() {
    }

    public static /* synthetic */ void a() {
        lambda$asyncPrefetchLibrariesToMemory$0();
    }

    public static void asyncPrefetchLibrariesToMemory() {
        SysUtils.logPageFaultCountToTracing();
        final boolean r10 = sPrefetchLibraryHasBeenCalled.compareAndSet(false, true);
        if (r10 == true) goto L5;
    L8:
        PostTask.postTask(TaskTraits.USER_BLOCKING, new a(r10));
        return;
    L5:
        if (CommandLine.getInstance().hasSwitch("log-native-library-residency") == false) goto L8;
        new Thread(b.f8419c).start();
    }

    public static /* synthetic */ void b(boolean r10) {
        lambda$asyncPrefetchLibrariesToMemory$1(r10);
    }

    private static /* synthetic */ void lambda$asyncPrefetchLibrariesToMemory$0() {
        LibraryPrefetcherJni.get().periodicallyCollectResidency();
    }

    private static /* synthetic */ void lambda$asyncPrefetchLibrariesToMemory$1(boolean r10) {
        int r11 = LibraryPrefetcherJni.get().percentageOfResidentNativeLibraryCode();
        TraceEvent r12 = TraceEvent.scoped("LibraryPrefetcher.asyncPrefetchLibrariesToMemory", Integer.toString(r11));
        if (r10 == true) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L13;
        LibraryPrefetcherJni.get().forkAndPrefetchNativeLibrary();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r12 != null) goto L32;
    L25:
        throw th;
    L32:
        r12.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
    L13:
        if (r11 == (-1)) goto L26;
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L10
        r14.append("LibraryLoader.PercentageOfResidentCodeBeforePrefetch");     // Catch: Throwable -> L10
        if (r10 == false) goto L17;
        String r15 = ".ColdStartup";
    L18:
        r14.append(r15);     // Catch: Throwable -> L10
        RecordHistogram.recordPercentageHistogram(r14.toString(), r11);     // Catch: Throwable -> L10
        goto L26
    L17:
        r15 = ".WarmStartup";
    L26:
        if (r12 == null) goto L28;
        r12.close();
    L28:
        ContextUtils.getAppSharedPreferences().edit().remove("dont_prefetch_libraries").apply();
        return;
    L5:
        if (r11 >= 90) goto L7;
        r13 = true;
        goto L8
    }
}
