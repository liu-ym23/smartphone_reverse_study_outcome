package com.obric.memorydata;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.Priority;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends com.bumptech.glide.request.f implements Cloneable {
    public a() {
    }

    public a E() {
        return (a) ZeusTransformUtils.preCheckCast(super.c(), a.class, "com.obric.memorydata.plugin");
    }

    public a F() {
        return (a) ZeusTransformUtils.preCheckCast(super.d(), a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(float r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(int r1, int r2) {
        return b(r1, r2);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(Resources.Theme r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(Priority r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(com.bumptech.glide.load.c r3) {
        return c((com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(com.bumptech.glide.load.d r1, Object r2) {
        return b(r1, r2);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(com.bumptech.glide.load.engine.h r1) {
        return c(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(com.bumptech.glide.load.h r3) {
        return b((com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(Class r1) {
        return c(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(boolean r1) {
        return c(r1);
    }

    public a a() {
        return (a) ZeusTransformUtils.preCheckCast(super.b(), a.class, "com.obric.memorydata.plugin");
    }

    public a a(com.bumptech.glide.request.a<?> r2) {
        return (a) ZeusTransformUtils.preCheckCast(super.b(r2), a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b() {
        return a();
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b(com.bumptech.glide.request.a r1) {
        return a(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b(boolean r1) {
        return d(r1);
    }

    public a b(float r2) {
        return (a) ZeusTransformUtils.preCheckCast(super.a(r2), a.class, "com.obric.memorydata.plugin");
    }

    public a b(int r1, int r2) {
        return (a) ZeusTransformUtils.preCheckCast(super.a(r1, r2), a.class, "com.obric.memorydata.plugin");
    }

    public a b(Resources.Theme r2) {
        return (a) ZeusTransformUtils.preCheckCast(super.a(r2), a.class, "com.obric.memorydata.plugin");
    }

    public a b(Priority r2) {
        return (a) ZeusTransformUtils.preCheckCast(super.a(r2), a.class, "com.obric.memorydata.plugin");
    }

    public <Y> a b(com.bumptech.glide.load.d<Y> r1, Y r2) {
        return (a) ZeusTransformUtils.preCheckCast(super.a(r1, r2), a.class, "com.obric.memorydata.plugin");
    }

    public a b(com.bumptech.glide.load.h<Bitmap> r3) {
        return (a) ZeusTransformUtils.preCheckCast(super.a((com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin")), a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a c() {
        return E();
    }

    public a c(com.bumptech.glide.load.c r3) {
        return (a) ZeusTransformUtils.preCheckCast(super.a((com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin")), a.class, "com.obric.memorydata.plugin");
    }

    public a c(com.bumptech.glide.load.engine.h r2) {
        return (a) ZeusTransformUtils.preCheckCast(super.a(r2), a.class, "com.obric.memorydata.plugin");
    }

    public a c(Class<?> r2) {
        return (a) ZeusTransformUtils.preCheckCast(super.a(r2), a.class, "com.obric.memorydata.plugin");
    }

    public a c(boolean r2) {
        return (a) ZeusTransformUtils.preCheckCast(super.a(r2), a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ Object clone() {
        return a();
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a d() {
        return F();
    }

    public a d(boolean r2) {
        return (a) ZeusTransformUtils.preCheckCast(super.b(r2), a.class, "com.obric.memorydata.plugin");
    }
}
