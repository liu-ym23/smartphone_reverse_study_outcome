package com.bytedance.api.location.a;

import android.os.Looper;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppExecutors f1016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<com.bytedance.api.location.b> f1017b;

    public a(AppExecutors r2) {
        this.f1017b = new CopyOnWriteArrayList();
        this.f1016a = r2;
    }

    private void b(BDLocation r4) {
        Logger.i("ByteLocationListenerWrapper: handleLocationChanged() is executed.");
        Iterator<com.bytedance.api.location.b> r3 = this.f1017b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bytedance.api.location.b) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.api.location.b.class, "com.obric.memorydata.plugin")).onLocationChanged(r4);
        goto L4
    }

    private void b(BDLocationException r4) {
        Logger.i("ByteLocationListenerWrapper: handleLocationFailed()!");
        Iterator<com.bytedance.api.location.b> r3 = this.f1017b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bytedance.api.location.b) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.api.location.b.class, "com.obric.memorydata.plugin")).onError(r4);
        goto L4
    }

    private boolean b() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void c(BDLocation r1) {
        b(r1);
    }

    private /* synthetic */ void c(BDLocationException r1) {
        b(r1);
    }

    /* JADX INFO: renamed from: lambda$UFOcv1LcV_mLVj6X6bzQAhCA_-Y, reason: not valid java name */
    public static /* synthetic */ void m74lambda$UFOcv1LcV_mLVj6X6bzQAhCA_Y(a r0, BDLocationException r1) {
        r0.c(r1);
    }

    /* JADX INFO: renamed from: lambda$zQX1pmsWILBE4QgOEYJBfkad-0s, reason: not valid java name */
    public static /* synthetic */ void m75lambda$zQX1pmsWILBE4QgOEYJBfkad0s(a r0, BDLocation r1) {
        r0.c(r1);
    }

    public void a() {
        this.f1017b.clear();
    }

    public void a(com.bytedance.api.location.b r3) {
        com.bytedance.api.location.b r4 = (com.bytedance.api.location.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.api.location.b.class, "com.obric.memorydata.plugin");
        if (this.f1017b.contains(r4) == true) goto L6;
        this.f1017b.add(r4);
        return;
    }

    public void a(final BDLocation r3) {
        if (b() == false) goto L5;
        b(r3);
        return;
    L5:
        this.f1016a.mainThread().execute(new $$Lambda$a$zQX1pmsWILBE4QgOEYJBfkad0s(this, r3));
    }

    public void a(final BDLocationException r3) {
        if (b() == false) goto L5;
        b(r3);
        return;
    L5:
        this.f1016a.mainThread().execute(new $$Lambda$a$UFOcv1LcV_mLVj6X6bzQAhCA_Y(this, r3));
    }

    public void b(com.bytedance.api.location.b r3) {
        com.bytedance.api.location.b r4 = (com.bytedance.api.location.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.api.location.b.class, "com.obric.memorydata.plugin");
        this.f1017b.remove(r4);
    }
}
