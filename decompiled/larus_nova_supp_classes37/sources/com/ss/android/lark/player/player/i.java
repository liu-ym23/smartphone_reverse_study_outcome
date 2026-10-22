package com.ss.android.lark.player.player;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.ttvideoengine.TTVideoEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements Runnable {
    public final /* synthetic */ String a;

    public i(String r1) {
        this.a = r1;
    }

    public final void a() {
        VFSFile r1 = VFSFiles.b.i(z0c.a.b());     // Catch: Exception -> L12
        LinkedHashSet r2 = new LinkedHashSet();     // Catch: Exception -> L12
        Object r3 = ebb.e.a;     // Catch: Exception -> L12
        Iterator r4 = ((ArrayList) ebb.e.e(r1, this.a)).iterator();     // Catch: Exception -> L12
    L5:
        if (r4.hasNext() == false) goto L7;
        String r5 = ((File) r4.next()).getName();     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L12
        r2.add(r5.substring(0, StringsKt.lastIndexOf$default(r5, ".", 0, false, 6, null)));     // Catch: Exception -> L12
        goto L5
    L7:
        String r6 = this.a;     // Catch: Exception -> L12
        Iterator r7 = r2.iterator();     // Catch: Exception -> L12
    L8:
        if (r7.hasNext() == false) goto L19;
        String r8 = (String) r7.next();     // Catch: Exception -> L12
        Log.i("LarkPlayerUtils", "removeCache, cacheKeyPrefix:" + r6 + ", mdlCacheKey:" + r8);     // Catch: Exception -> L12
        TTVideoEngine.removeCacheFile(r8);     // Catch: Exception -> L12
        goto L8
    L19:
        return;
    L12:
        e = move-exception;
        Log.e("LarkPlayerUtils", "removeCache error:" + e);
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
