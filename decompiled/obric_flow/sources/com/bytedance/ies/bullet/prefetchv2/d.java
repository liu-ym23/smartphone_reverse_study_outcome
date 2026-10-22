package com.bytedance.ies.bullet.prefetchv2;

import android.text.TextUtils;
import com.lynx.tasm.ui.image.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5841c;

    public d(String r5, int r10) {
        this.f5839a = r10;
        switch(r10) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "name");
        this.f5841c = r5;
        this.f5840b = new AtomicInteger();
        return;
    L6:
        this.f5841c = "APM_".concat(r5);
        return;
    L8:
        this.f5840b = new AtomicInteger(1);
        this.f5841c = "ApiExecutor";
        if (TextUtils.isEmpty(r5) == true) goto L12;
        this.f5841c = r5;
        return;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        switch(this.f5839a) {
            case 0: goto L9;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        am.a r10 = new am.a(r5, this.f5841c + "#" + ((AtomicInteger) this.f5840b).getAndIncrement(), 5);
        r10.setDaemon(false);
        return r10;
    L5:
        return new Thread(new v(22, this, r5), this.f5841c);
    L9:
        return new Thread(r5, this.f5841c + '-' + ((AtomicInteger) this.f5840b).incrementAndGet());
    }
}
