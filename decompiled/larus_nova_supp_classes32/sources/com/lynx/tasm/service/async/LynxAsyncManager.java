package com.lynx.tasm.service.async;

import android.util.LruCache;
import com.lynx.tasm.base.LLog;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxAsyncManager<T> {
    public ExecutorService a;

    public static final enum AsyncCallbackCode extends Enum<AsyncCallbackCode> {
        public static final AsyncCallbackCode ASYNC_MANAGER_LOAD_FAIL = null;
        public static final AsyncCallbackCode ASYNC_MANAGER_TIMEOUT = null;
        public static final /* synthetic */ AsyncCallbackCode[] a = null;

        static {
            AsyncCallbackCode r0 = new AsyncCallbackCode("ASYNC_MANAGER_LOAD_FAIL", 0);
            ASYNC_MANAGER_LOAD_FAIL = r0;
            AsyncCallbackCode r1 = new AsyncCallbackCode("ASYNC_MANAGER_TIMEOUT", 1);
            ASYNC_MANAGER_TIMEOUT = r1;
            a = new AsyncCallbackCode[]{r0, r1};
        }

        public static AsyncCallbackCode[] values() {
            return (AsyncCallbackCode[]) a.clone();
        }

        public static AsyncCallbackCode valueOf(String r1) {
            return (AsyncCallbackCode) r27.a.a(AsyncCallbackCode.class, r1);
        }

        public AsyncCallbackCode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a<T> {
        public final String toString() {
            return "Builder{lruSize=10, enableUseCreateExecutor=true, enableUseLoadExecutor=true, slidingWindowsSize=5}";
        }

        public a() {
        }
    }

    static {
    }

    public LynxAsyncManager(a r2) {
        LLog.i("LynxAsyncManager", "Create LynxAsyncManager, address:" + this);
        new LruCache(10);
        new LruCache(10);
        new LinkedList();
    }
}
