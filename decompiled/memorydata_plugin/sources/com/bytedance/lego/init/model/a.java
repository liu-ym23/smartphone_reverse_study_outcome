package com.bytedance.lego.init.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2782b;
    public int c;
    public BaseIdleTask d;

    public int a(a r3) {
        if (r3 == null) goto L15;
        BaseIdleTask r0 = this.d;
        if (r0 == null) goto L17;
        int r2 = this.c;
        int r1 = r3.c;
        if (r2 <= r1) goto L10;
        return -1;
    L10:
        if (r2 >= r1) goto L14;
        return 1;
    L14:
        return r0.getClass().getSimpleName().compareTo(r3.d.getClass().getSimpleName());
    L17:
        return 0;
    L15:
        return 0;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(a r3) {
        return a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
    }

    public String toString() {
        return "priority:" + this.c + " taskClassName:" + this.d.getClass().getSimpleName() + " mustRunInMainThread:" + this.f2782b;
    }
}
