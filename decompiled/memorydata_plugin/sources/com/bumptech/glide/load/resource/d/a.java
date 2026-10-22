package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f889b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(Bitmap.CompressFormat r1, int r2) {
        this.f888a = r1;
        this.f889b = r2;
    }

    @Override // com.bumptech.glide.load.resource.d.e
    public s<byte[]> a(s<Bitmap> r4, com.bumptech.glide.load.e r5) {
        s r6 = (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin");
        ByteArrayOutputStream r7 = new ByteArrayOutputStream();
        ((Bitmap) ZeusTransformUtils.preCheckCast(r6.d(), Bitmap.class, "com.obric.memorydata.plugin")).compress(this.f888a, this.f889b, r7);
        r6.f();
        return new com.bumptech.glide.load.resource.a.b(r7.toByteArray());
    }
}
