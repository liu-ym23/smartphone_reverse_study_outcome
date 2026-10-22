package com.bumptech.glide.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends d implements b {
    public a() {
    }

    public void a(Context r1, com.bumptech.glide.d r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
    }

    public boolean c() {
        return true;
    }
}
