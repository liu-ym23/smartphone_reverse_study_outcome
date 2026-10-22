package com.bytedance.applog.monitor;

import com.bytedance.applog.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<l> f1667a;

    public a() {
        this.f1667a = new CopyOnWriteArraySet();
    }

    public void a(l r3) {
        l r4 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.f1667a.add(r4);
    }

    public void a(String r4, String r5) {
        Iterator<l> r3 = this.f1667a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((l) ZeusTransformUtils.preCheckCast(r3.next(), l.class, "com.obric.memorydata.plugin")).a(r4, r5);
        goto L4
    }

    public void a(String r4, Throwable r5) {
        if (this.f1667a.isEmpty() == true) goto L10;
        if (r5 == null) goto L12;
        String r6 = r5.toString();
        Iterator<l> r3 = this.f1667a.iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        ((l) ZeusTransformUtils.preCheckCast(r3.next(), l.class, "com.obric.memorydata.plugin")).b(r4, r6);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public void b(String r4, String r5) {
        if (this.f1667a.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<l> r3 = this.f1667a.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((l) ZeusTransformUtils.preCheckCast(r3.next(), l.class, "com.obric.memorydata.plugin")).b(r4, r5);
        goto L7
    }
}
