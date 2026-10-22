package com.obric.memorydata;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import com.bumptech.glide.Priority;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class b<TranscodeType> extends com.bumptech.glide.h<TranscodeType> implements Cloneable {
    b(com.bumptech.glide.c r3, com.bumptech.glide.i r4, Class<TranscodeType> r5, Context r6) {
        super(r3, r4, r5, (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"));
    }

    public b<TranscodeType> E() {
        return (b) ZeusTransformUtils.preCheckCast(super.c(), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> F() {
        return (b) ZeusTransformUtils.preCheckCast(super.d(), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> G() {
        return (b) ZeusTransformUtils.preCheckCast(super.a(), b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.h
    public /* synthetic */ com.bumptech.glide.h a() {
        return G();
    }

    @Override // com.bumptech.glide.h
    public /* synthetic */ com.bumptech.glide.h a(Uri r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.h
    public /* synthetic */ com.bumptech.glide.h a(com.bumptech.glide.request.a r1) {
        return d(r1);
    }

    @Override // com.bumptech.glide.h
    public /* synthetic */ com.bumptech.glide.h a(com.bumptech.glide.request.e r3) {
        return b((com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.e.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.h
    public /* synthetic */ com.bumptech.glide.h a(Object r1) {
        return b(r1);
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
        return b((com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(com.bumptech.glide.load.d r1, Object r2) {
        return b(r1, r2);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(com.bumptech.glide.load.engine.h r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(com.bumptech.glide.load.h r3) {
        return b((com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(Class r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(boolean r1) {
        return c(r1);
    }

    @Override // com.bumptech.glide.h, com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b() {
        return G();
    }

    @Override // com.bumptech.glide.h, com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b(com.bumptech.glide.request.a r1) {
        return d(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b(boolean r1) {
        return d(r1);
    }

    public b<TranscodeType> b(float r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> b(int r1, int r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r1, r2), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> b(Resources.Theme r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> b(Uri r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> b(Priority r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> b(com.bumptech.glide.load.c r3) {
        return (b) ZeusTransformUtils.preCheckCast(super.a((com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin")), b.class, "com.obric.memorydata.plugin");
    }

    public <Y> b<TranscodeType> b(com.bumptech.glide.load.d<Y> r1, Y r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r1, r2), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> b(com.bumptech.glide.load.engine.h r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> b(com.bumptech.glide.load.h<Bitmap> r3) {
        return (b) ZeusTransformUtils.preCheckCast(super.a((com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin")), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> b(com.bumptech.glide.request.e<TranscodeType> r3) {
        return (b) ZeusTransformUtils.preCheckCast(super.a((com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.e.class, "com.obric.memorydata.plugin")), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> b(Class<?> r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> b(Object r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a c() {
        return E();
    }

    public b<TranscodeType> c(boolean r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.h, com.bumptech.glide.request.a
    public /* synthetic */ Object clone() {
        return G();
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a d() {
        return F();
    }

    public b<TranscodeType> d(com.bumptech.glide.request.a<?> r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.memorydata.plugin");
    }

    public b<TranscodeType> d(boolean r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.b(r2), b.class, "com.obric.memorydata.plugin");
    }
}
