package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class c<T> implements h<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h<?> f887b = null;

    static {
        f887b = new c();
    }

    private c() {
    }

    public static <T> c<T> a() {
        return (c) ZeusTransformUtils.preCheckCast(f887b, c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.h
    public s<T> a(Context r1, s<T> r2, int r3, int r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r1) {
    }
}
