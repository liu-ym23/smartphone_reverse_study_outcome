package com.bumptech.glide.load.resource.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f890a;

    public b(Resources r3) {
        this.f890a = (Resources) ZeusTransformUtils.preCheckCast(j.a(r3), Resources.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.resource.d.e
    public s<BitmapDrawable> a(s<Bitmap> r2, com.bumptech.glide.load.e r3) {
        s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin");
        return q.a(this.f890a, r4);
    }
}
