package com.ss.android.lark.integrator.ccm.core.image;

import com.ss.android.lark.image.entity.DocImage;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements vkb.a<DocImage, InputStream> {
    public c() {
    }

    @Override // vkb.a
    public final b.a a() {
        return new b.a();
    }

    @Override // vkb.a
    public final Class getModelClass() {
        return DocImage.class;
    }

    @Override // vkb.a
    public final Class<InputStream> getResourceClass() {
        return InputStream.class;
    }
}
