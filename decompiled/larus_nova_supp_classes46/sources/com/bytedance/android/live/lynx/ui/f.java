package com.bytedance.android.live.lynx.ui;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.base.LLog;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<V> implements Callable {
    public final /* synthetic */ LiveLynxAlphaPlayer a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public f(LiveLynxAlphaPlayer r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.concurrent.Callable
    public final e76.c<String> call() {
        PolarisFileWrapper r3 = new PolarisFileWrapper(this.b);     // Catch: Exception -> L21
        if (r3.isDirectory() == false) goto L8;
        LLog.i("x-alpha-video", "try to load resource which is already unzip, directUrl is " + this.c);     // Catch: Exception -> L21
        LiveLynxAlphaPlayer r0 = this.a;     // Catch: Exception -> L21
        String r1 = r3.getAbsolutePath() + File.separator;     // Catch: Exception -> L21
        int r2 = LiveLynxAlphaPlayer.h;     // Catch: Exception -> L21
        r0.c = r0.O(r1);     // Catch: Exception -> L21
        return new e76.c("success");
    L8:
        if (StringsKt.endsWith$default(this.b, ".zip", false, 2, null) == false) goto L29;
        LLog.i("x-alpha-video", "try to load .zip resource, directUrl is " + this.c);     // Catch: Exception -> L21
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L21
        r4.append(this.a.getLynxContext().getCacheDir().getAbsolutePath());     // Catch: Exception -> L21
        String r5 = File.separator;     // Catch: Exception -> L21
        r4.append(r5);     // Catch: Exception -> L21
        r4.append(UUID.randomUUID().toString());     // Catch: Exception -> L21
        String r6 = r4.toString();     // Catch: Exception -> L21
        String r7 = e76.f.a(r3, r6);     // Catch: Exception -> L16
    L12:
        if (Intrinsics.areEqual(r7, "") == false) goto L14;
        String r8 = r6 + r5;     // Catch: Exception -> L21
    L15:
        LiveLynxAlphaPlayer r9 = this.a;     // Catch: Exception -> L21
        int r10 = LiveLynxAlphaPlayer.h;     // Catch: Exception -> L21
        r9.c = r9.O(r8);     // Catch: Exception -> L21
        return new e76.c("success");
    L14:
        r8 = r6 + r5 + r7;     // Catch: Exception -> L21
    L16:
        e = move-exception;
        this.a.Q("unzip resource failed, error msg is " + e.getMessage(), this.a.g, -2);     // Catch: Exception -> L21
        throw null;     // Catch: Exception -> L21
    L29:
        return new e76.c("fail, resource type is not support");
    L21:
        e = move-exception;
        return new e76.c("fail, error msg is " + e);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
