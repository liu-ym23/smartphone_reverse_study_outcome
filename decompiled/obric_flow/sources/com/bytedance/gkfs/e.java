package com.bytedance.gkfs;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f4831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f4832b = null;

    static {
        f4831a = LazyKt.lazy(UtilsKt$debuggable$2.f4800a);
        f4832b = LazyKt.lazy(UtilsKt$isMainProcess$2.f4801a);
    }

    public static final void a(File r5, Function1 r10) {
        ArrayDeque r11 = new ArrayDeque();
        r11.offer(r5);
        ArrayList r12 = new ArrayList();
    L4:
        if (r11.size() <= 0) goto L17;
        File r13 = (File) r11.poll();
        if (r12.contains(r13) == true) goto L4;
        r12.add(r13);
        if (r13.isDirectory() == true) goto L10;
        if (r13.isFile() == false) goto L4;
        r10.invoke(r13);
        goto L4
    L10:
        File[] r14 = r13.listFiles();
        int r15 = r14.length;
        int r16 = 0;
    L11:
        if (r16 >= r15) goto L4;
        r11.offer(r14[r16]);
        r16 = r16 + 1;
        goto L11
    }

    public static final void b(final String r5) {
        final Context r10 = df.c.c();
        if (r10 == null) goto L9;
        Handler r11 = com.bytedance.geckox.utils.e.f4795a;
        Function0<Unit> r12 = new UtilsKt$showToast$1(r10, r5);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        r12.invoke();
        return;
    L7:
        com.bytedance.geckox.utils.e.f4795a.post(new com.bytedance.android.monitorV2.executor.a(2, r12));
        return;
    }
}
