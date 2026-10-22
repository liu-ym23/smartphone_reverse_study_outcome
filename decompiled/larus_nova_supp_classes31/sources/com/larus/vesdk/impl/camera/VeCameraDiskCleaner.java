package com.larus.vesdk.impl.camera;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.settings.value.e10;
import com.larus.settings.value.gn;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VeCameraDiskCleaner {
    public static final int a = 0;

    public VeCameraDiskCleaner() {
    }

    static {
        e10 r0 = e10.a;
        int r1 = l0.a;
        a = ((Number) l0.a(7, new gn())).intValue();
    }

    public static void b() {
        pq9.k.a.getClass();
        String r0 = pq9.k.e;
        String r1 = pq9.k.g;
        FLogger.a.i("VeCameraDiskCleaner", "[cleanAsync] clean days: " + a);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new VeCameraDiskCleaner$cleanAsync$1(r0, r1, null), 2, null);
    }

    public static final void a(String r5) {
        FLogger.a.i("VeCameraDiskCleaner", "deleteFile, filePath:" + r5);
    L9:
        e = move-exception;
        FLogger.a.e("VeCameraDiskCleaner", "deleteFile, filePath:" + r5 + ",failed:" + e);
        return;
    L4:
        if (r5 != null) goto L6;
        String r1 = "";
    L7:
        new PolarisFileWrapper(r1).delete();     // Catch: Exception -> L9
        return;
    L6:
        r1 = r5;
        goto L7
    }

    public static List c(File r5) {
        ArrayList r0 = new ArrayList();
        if (r5.exists() == true) goto L5;
    L21:
        return r0;
    L5:
        if (r5.isDirectory() == false) goto L21;
        File[] r6 = r5.listFiles();
        if (r6 != null) goto L10;
        return r0;
    L10:
        int r1 = r6.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L21;
        File r3 = r6[r2];
        if (r3.exists() == false) goto L20;
        if (r3.isFile() == false) goto L18;
        Intrinsics.checkNotNull(r3);
        r0.add(r3);
    L18:
        if (r3.isDirectory() == false) goto L20;
        r0.addAll(c(r3));
    L20:
        r2 = r2 + 1;
        goto L11
    }
}
