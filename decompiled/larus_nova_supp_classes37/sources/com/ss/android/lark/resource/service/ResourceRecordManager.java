package com.ss.android.lark.resource.service;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ResourceRecordManager {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static void a() {
            Lazy r0 = ResourceRecordManager.a;
            Log.i("ResourceRecordManager", "start trimRecords");
            ResourceRecordManager.c((KVRepo) ResourceRecordManager.a.getValue());     // Catch: Exception -> L5
            ResourceRecordManager.c((KVRepo) ResourceRecordManager.b.getValue());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("ResourceRecordManager", "trimRecords failed:" + e);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        a = LazyKt.lazy(ResourceRecordManager$rustKVRepo$2.INSTANCE);
        b = LazyKt.lazy(ResourceRecordManager$glideKVRepo$2.INSTANCE);
        CoreThreadPool.getDefault().getCachedThreadPool().execute(a.a);
    }

    @JvmStatic
    public static final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Log.i("ResourceRecordManager", "start findResource");
        String r1 = b((KVRepo) a.getValue(), r3);     // Catch: Exception -> L7
        if (r1 != null) goto L12;
        return b((KVRepo) b.getValue(), r3);
    L12:
        return r1;
    L7:
        e = move-exception;
        Log.e("ResourceRecordManager", "findResource failed:" + e);
        return null;
    }

    public static void c(KVRepo r7) {
        String[] r0 = r7.b();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        String r3 = r0[r2];
        String r4 = r7.getString(r3, null);
        if (r4 == null) goto L9;
        if (FileUtils.r(r4) == true) goto L9;
        r7.remove(r3);
        Log.i("ResourceRecordManager", "remove record key:" + r3 + ", path:" + r4);
    L9:
        r2 = r2 + 1;
        goto L3
    }

    public static String b(KVRepo r4, String r5) {
        String r6 = r4.getString(r5, null);
        if (r6 != null) goto L5;
    L9:
        return null;
    L5:
        if (FileUtils.r(r6) == false) goto L8;
        Log.i("ResourceRecordManager", "findResourceInner success, key:" + r5 + ", path:" + r6 + ", length:" + new PolarisFileWrapper(r6).length());
        return r6;
    L8:
        ((KVRepo) a.getValue()).remove(r5);
        goto L9
    }
}
