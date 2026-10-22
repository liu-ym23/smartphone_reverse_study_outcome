package nbb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements MemoryCallbackManager.MemoryCallback {
    public a() {
    }

    public final void onJavaMemoryReachTop() {
        Log.i("DOCS_ICON_DocMetaDataManager", "Clean the offline memory cache because the java heap reached the memory top.");
        b.c.evictAll();
    }

    public final void onTrimMemory(int r2, int r3, int r4, int r5) {
        Log.i("DOCS_ICON_DocMetaDataManager", "level: " + r2 + "--javaHeapUsed: " + r3 + "--maxJavaHeapMem: " + r5);
    }
}
