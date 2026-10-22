package com.bytedance.sdk.account;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ug.cloud.g;
import com.bytedance.ug.cloud.k;
import com.bytedance.ug.cloud.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f3097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f3098b;
    private boolean c;

    private b() {
        if (this.f3098b != null) goto L6;
        this.f3098b = r.a(g.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.account.d.a().b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(false).a("account").b(BuildConfig.VERSION_NAME).a(0).a());
        return;
    }

    public static b a() {
        if (f3097a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3097a != null) goto L9;
        f3097a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f3097a;
    }

    public void a(boolean r2, String r3, Bundle r4) {
        k r0 = this.f3098b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.c == false) goto L12;
        int r1 = 0;
        if (r2 == true) goto L9;
        r1 = 301;
    L9:
        r0.a("1003", r1, r3, r4);
        return;
    }

    public void b(boolean r2, String r3, Bundle r4) {
        k r0 = this.f3098b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.c == false) goto L12;
        int r1 = 0;
        if (r2 == true) goto L9;
        r1 = 401;
    L9:
        r0.a("1004", r1, r3, r4);
        return;
    }
}
