package com.bumptech.glide.e;

import android.content.Context;
import com.bumptech.glide.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.bumptech.glide.load.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f549b;
    private final com.bumptech.glide.load.c c;

    private a(int r3, com.bumptech.glide.load.c r4) {
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        this.f549b = r3;
        this.c = r5;
    }

    public static com.bumptech.glide.load.c a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r0 = b.a(r3);
        return new a(ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48, r0);
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r2) {
        this.c.a(r2);
        r2.update(ByteBuffer.allocate(4).putInt(this.f549b).array());
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L10;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
        if (this.f549b == r5.f549b) goto L7;
        return false;
    L7:
        if (this.c.equals(r5.c) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return k.a(this.c, this.f549b);
    }
}
