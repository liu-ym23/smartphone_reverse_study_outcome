package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.load.engine.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.bumptech.glide.util.g<com.bumptech.glide.load.c, s<?>> implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h.a f727a;

    public g(long r1) {
        super(r1);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public int a2(s<?> r3) {
        s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return super.a(null);
    L7:
        return r4.e();
    }

    @Override // com.bumptech.glide.util.g
    public /* synthetic */ int a(s<?> r3) {
        return a2((s) ZeusTransformUtils.preCheckCast(r3, s.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.load.engine.a.h
    public /* synthetic */ s a(com.bumptech.glide.load.c r3) {
        return (s) ZeusTransformUtils.preCheckCast(super.c((com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin")), s.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.engine.a.h
    public void a(int r5) {
        if (r5 < 40) goto L6;
        a();
        return;
    L6:
        if (r5 < 20) goto L8;
    L9:
        a(b() / 2);
        return;
    L8:
        if (r5 == 15) goto L9;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(com.bumptech.glide.load.c r3, s<?> r4) {
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        s<?> r6 = (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin");
        h.a r2 = this.f727a;
        if (r2 == null) goto L7;
        if (r6 == null) goto L8;
        r2.b(r6);
        return;
    L8:
        return;
    }

    @Override // com.bumptech.glide.load.engine.a.h
    public void a(h.a r3) {
        this.f727a = (h.a) ZeusTransformUtils.wrapperContextForParams(r3, h.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.util.g
    public /* synthetic */ void a(com.bumptech.glide.load.c r3, s<?> r4) {
        a2((com.bumptech.glide.load.c) ZeusTransformUtils.preCheckCast(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin"), (s) ZeusTransformUtils.preCheckCast(r4, s.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.load.engine.a.h
    public /* synthetic */ s b(com.bumptech.glide.load.c r3, s r4) {
        return (s) ZeusTransformUtils.preCheckCast(super.b((com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin"), (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin")), s.class, "com.obric.memorydata.plugin");
    }
}
