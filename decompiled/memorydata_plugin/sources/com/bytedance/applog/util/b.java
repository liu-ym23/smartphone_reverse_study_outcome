package com.bytedance.applog.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.applog.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<com.bytedance.applog.g> f1878a;

    public b() {
        this.f1878a = new CopyOnWriteArraySet();
    }

    public void a() {
        this.f1878a.clear();
    }

    public void a(com.bytedance.applog.g r3) {
        com.bytedance.applog.g r4 = (com.bytedance.applog.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.g.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.f1878a.add(r4);
        return;
    }

    @Override // com.bytedance.applog.g
    public void a(String r4, String r5, String r6) {
        Iterator<com.bytedance.applog.g> r3 = this.f1878a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bytedance.applog.g) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.applog.g.class, "com.obric.memorydata.plugin")).a(r4, r5, r6);
        goto L4
    }

    @Override // com.bytedance.applog.g
    public void a(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<com.bytedance.applog.g> r0 = this.f1878a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.applog.g) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.applog.g.class, "com.obric.memorydata.plugin")).a(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }

    @Override // com.bytedance.applog.g
    public void a(boolean r4, JSONObject r5) {
        Iterator<com.bytedance.applog.g> r3 = this.f1878a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bytedance.applog.g) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.applog.g.class, "com.obric.memorydata.plugin")).a(r4, r5);
        goto L4
    }

    public void b(com.bytedance.applog.g r3) {
        com.bytedance.applog.g r4 = (com.bytedance.applog.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.g.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.f1878a.remove(r4);
        return;
    }
}
