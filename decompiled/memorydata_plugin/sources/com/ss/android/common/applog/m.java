package com.ss.android.common.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes6.dex */
public class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile m f15089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet<l> f15090b;

    private m() {
        this.f15090b = new CopyOnWriteArraySet();
    }

    public static m a() {
        if (f15089a != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15089a != null) goto L9;
        f15089a = new m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f15089a;
    }

    @Override // com.ss.android.common.applog.l
    public void a(String r4, long r5, boolean r7) {
        Iterator<l> r3 = this.f15090b.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        ((l) ZeusTransformUtils.preCheckCast(r3.next(), l.class, "com.obric.memorydata.plugin")).a(r4, r5, r7);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L4
    }
}
