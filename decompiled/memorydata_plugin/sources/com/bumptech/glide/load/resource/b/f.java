package com.bumptech.glide.load.resource.b;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.bumptech.glide.load.f<Drawable, Drawable> {
    public f() {
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public s<Drawable> a2(Drawable r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return d.a(r1);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ s<Drawable> a(Drawable r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Drawable r1, com.bumptech.glide.load.e r2) {
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(Drawable r3, com.bumptech.glide.load.e r4) {
        return a2((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.memorydata.plugin"), r4);
    }
}
