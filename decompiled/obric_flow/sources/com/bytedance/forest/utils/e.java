package com.bytedance.forest.utils;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.utils.io.ForestWebStreamingBuffer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.forest.b f4619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f4621c;
    public final ConcurrentHashMap d;
    public String e;
    public final ConcurrentHashMap f;
    public final d g;

    public e(Application r5) {
        this.g = new d();
        this.f4619a = new com.bytedance.forest.b(this);
        this.f4620b = Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread());
        this.f4621c = r5.getApplicationContext();
        this.d = new ConcurrentHashMap();
        this.e = "";
        this.f = new ConcurrentHashMap();
    }

    public final com.bytedance.forest.model.q a(com.bytedance.forest.model.a r5, Request r10) {
        if (r10.getStreamingLoad() == false) goto L11;
        if (r10.getUseConcurrentBuffer() == false) goto L9;
        return new com.bytedance.forest.utils.io.d(r5, this);
    L9:
        return new ForestWebStreamingBuffer(r5, this);
    L11:
        if (r10.getUseConcurrentBuffer() == false) goto L15;
        return new com.bytedance.forest.utils.io.b(r5, this);
    L15:
        return new ForestBuffer(r5, this);
    }

    public final void b(String[] r10) {
        long r5 = System.currentTimeMillis();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        String r13 = r10[r12];
        this.d.put(StringsKt.A(this.e + '_' + r13, "_"), Long.valueOf(r5));
        r12 = r12 + 1;
        goto L3
    }
}
