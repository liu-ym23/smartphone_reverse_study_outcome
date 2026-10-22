package com.bytedance.android.live.ktv.common.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.q1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.io.File;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l<T> implements SingleOnSubscribe {
    public final /* synthetic */ String a;

    public l(String r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        String r8 = this.a;
        monitor-enter(n.class);
        PolarisFileWrapper r2 = new PolarisFileWrapper(r8);     // Catch: Throwable -> L29
        if (r2.exists() == true) goto L7;
    L27:
        monitor-exit(n.class);
        return;
    L7:
        if (r2.isDirectory() == false) goto L27;
        List r9 = ArraysKt.toList(r2.listFiles());     // Catch: Throwable -> L29
        int r3 = r9.size();     // Catch: Throwable -> L29
        if (r3 > 300) goto L13;
        monitor-exit(n.class);
        return;
    L13:
        ALogger.i("SpeechFileUtils", "delete same files, fileNum: " + r3);     // Catch: Throwable -> L29
        int r4 = r3 - 300;     // Catch: Throwable -> L29
        if ((!r9.isEmpty()) == false) goto L27;
        List r0 = CollectionsKt.sortedWith(r9, new m());     // Catch: Throwable -> L29
        if (r4 <= r9.size()) goto L19;
        monitor-exit(n.class);
        return;
    L19:
        int r11 = 0;
    L20:
        if (r11 >= r4) goto L27;
        File r5 = (File) ListProtector.get(r0, r11);     // Catch: Throwable -> L29
        if (r5 == null) goto L26;
        if (r5.exists() == false) goto L26;
        q1.a(r5);     // Catch: Throwable -> L29
    L26:
        r11 = r11 + 1;
    L29:
        th = move-exception;
        throw th;
    }
}
