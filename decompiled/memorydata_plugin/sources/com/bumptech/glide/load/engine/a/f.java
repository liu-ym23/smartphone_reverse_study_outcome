package com.bumptech.glide.load.engine.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d {
    public f(Context r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "image_manager_disk_cache", 262144000);
    }

    public f(Context r3, final String r4, long r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(new AnonymousClass1(r6, r4), r5);
    }
}
