package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class a implements l {
    public a() {
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public long a(boolean r1) {
        return com.ss.android.socialbase.downloader.downloader.b.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public Context a() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(final double r2) {
        com.ss.android.socialbase.downloader.downloader.b.b(new AnonymousClass1(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(Context r2) {
        com.ss.android.socialbase.downloader.downloader.b.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(ac r2) {
        com.ss.android.socialbase.downloader.downloader.b.a((ac) ZeusTransformUtils.wrapperContextForParams(r2, ac.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(ae r2) {
        com.ss.android.socialbase.downloader.downloader.b.a((ae) ZeusTransformUtils.wrapperContextForParams(r2, ae.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(com.ss.android.socialbase.downloader.depend.m r2) {
        com.ss.android.socialbase.downloader.downloader.b.a((com.ss.android.socialbase.downloader.depend.m) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.m.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(com.ss.android.socialbase.downloader.downloader.f r1) {
        com.ss.android.socialbase.downloader.downloader.b.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(com.ss.android.socialbase.downloader.downloader.k r2) {
        com.ss.android.socialbase.downloader.downloader.b.a((com.ss.android.socialbase.downloader.downloader.k) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.downloader.k.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(com.ss.android.socialbase.downloader.downloader.q r2) {
        com.ss.android.socialbase.downloader.downloader.b.a((com.ss.android.socialbase.downloader.downloader.q) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.downloader.q.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(DownloadInfo r1) {
        com.ss.android.socialbase.downloader.utils.c.c("updateDownloadInfo");
        com.ss.android.socialbase.downloader.downloader.b.C().a(r1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(Runnable r2) {
        com.ss.android.socialbase.downloader.downloader.b.d((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(String[] r1) {
        com.ss.android.socialbase.downloader.downloader.b.P().a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void a(String[] r1, long r2) {
        com.ss.android.socialbase.downloader.downloader.b.P().a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public JSONObject b() {
        return com.ss.android.socialbase.downloader.downloader.b.G();
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void b(com.ss.android.socialbase.downloader.downloader.f r1) {
        com.ss.android.socialbase.downloader.downloader.b.b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public y c() {
        return com.ss.android.socialbase.downloader.downloader.b.Q();
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public boolean d() {
        return com.ss.android.socialbase.downloader.downloader.b.W();
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void e() {
        com.ss.android.socialbase.downloader.downloader.b.a();
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void f() {
        com.ss.android.socialbase.downloader.downloader.b.b();
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public com.ss.android.socialbase.downloader.downloader.q g() {
        return com.ss.android.socialbase.downloader.downloader.b.V();
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public com.ss.android.socialbase.downloader.downloader.t h() {
        return com.ss.android.socialbase.downloader.downloader.b.P();
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void i() {
        com.ss.android.socialbase.downloader.downloader.b.M();
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void j() {
        com.ss.android.socialbase.downloader.downloader.b.Z();
    }

    @Override // com.ss.android.socialbase.downloader.service.l
    public void k() {
        com.ss.android.socialbase.downloader.downloader.h r2 = com.ss.android.socialbase.downloader.downloader.b.C();
        if (ZeusTransformUtils.instanceOf(r2, com.ss.android.socialbase.downloader.impls.b.class) == false) goto L6;
        ((com.ss.android.socialbase.downloader.impls.b) ZeusTransformUtils.preCheckCast(r2, com.ss.android.socialbase.downloader.impls.b.class, "com.obric.memorydata.plugin")).j();
        return;
    }
}
