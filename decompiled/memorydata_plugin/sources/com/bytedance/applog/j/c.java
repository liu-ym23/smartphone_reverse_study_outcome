package com.bytedance.applog.j;

import com.bytedance.applog.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<n> f1612a;

    public c() {
        this.f1612a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.applog.n
    public void a(long r4, String r6) {
        Iterator<n> r3 = this.f1612a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.memorydata.plugin")).a(r4, r6);
        goto L4
    }

    @Override // com.bytedance.applog.n
    public void a(long r4, String r6, JSONObject r7) {
        Iterator<n> r3 = this.f1612a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.memorydata.plugin")).a(r4, r6, r7);
        goto L4
    }

    public void a(n r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.f1612a.add(r4);
        return;
    }

    @Override // com.bytedance.applog.n
    public void b(long r4, String r6, JSONObject r7) {
        Iterator<n> r3 = this.f1612a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.memorydata.plugin")).b(r4, r6, r7);
        goto L4
    }

    public void b(n r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.f1612a.remove(r4);
        return;
    }
}
