package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t<T> implements SingleOnSubscribe {
    public final /* synthetic */ w a;

    public t(w r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        Iterator<Map.Entry<String, Integer>> r0 = this.a.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, Integer> r1 = r0.next();
        String r2 = r1.getKey();
        int r3 = r1.getValue().intValue();
        Downloader.getInstance(com.bytedance.android.live.core.utils.s1.getContext()).cancel(r3);
        goto L4
    L6:
        this.a.getClass();
        int r4 = 0;
        PolarisFileWrapper r5 = new PolarisFileWrapper(com.bytedance.android.live.core.utils.s1.getContext().getDir("activity_image", 0).getAbsolutePath());
        if (r5.exists() == true) goto L9;
        return;
    L9:
        if (r5.isDirectory() == false) goto L25;
        File[] r7 = r5.listFiles();
        if (r7 == null) goto L18;
        int r8 = r7.length;
    L13:
        if (r4 >= r8) goto L18;
        File r9 = r7[r4];
        if (r9.exists() == false) goto L17;
        com.bytedance.android.live.revenue.common.c0.b(r9);
    L17:
        r4 = r4 + 1;
    L18:
        r6.onSuccess(Unit.INSTANCE);
        return;
    }
}
