package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public interface l {

    public static class a implements l {
        public a() {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public long a(boolean r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public Context a() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(double r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(ac r2) {
            ac r1 = (ac) ZeusTransformUtils.wrapperContextForParams(r2, ac.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(ae r2) {
            ae r1 = (ae) ZeusTransformUtils.wrapperContextForParams(r2, ae.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(com.ss.android.socialbase.downloader.depend.m r2) {
            com.ss.android.socialbase.downloader.depend.m r1 = (com.ss.android.socialbase.downloader.depend.m) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.m.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(com.ss.android.socialbase.downloader.downloader.f r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(com.ss.android.socialbase.downloader.downloader.k r2) {
            com.ss.android.socialbase.downloader.downloader.k r1 = (com.ss.android.socialbase.downloader.downloader.k) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.downloader.k.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(com.ss.android.socialbase.downloader.downloader.q r2) {
            com.ss.android.socialbase.downloader.downloader.q r1 = (com.ss.android.socialbase.downloader.downloader.q) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.downloader.q.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(DownloadInfo r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(Runnable r2) {
            Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(String[] r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void a(String[] r1, long r2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public JSONObject b() {
            return com.ss.android.socialbase.downloader.constants.b.g;
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void b(com.ss.android.socialbase.downloader.downloader.f r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public y c() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public boolean d() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void e() {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void f() {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public com.ss.android.socialbase.downloader.downloader.q g() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public com.ss.android.socialbase.downloader.downloader.t h() {
            return new com.ss.android.socialbase.downloader.downloader.t.a();
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void i() {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void j() {
        }

        @Override // com.ss.android.socialbase.downloader.service.l
        public void k() {
        }
    }

    long a(boolean r1);

    Context a();

    void a(double r1);

    void a(Context r1);

    void a(ac r1);

    void a(ae r1);

    void a(com.ss.android.socialbase.downloader.depend.m r1);

    void a(com.ss.android.socialbase.downloader.downloader.f r1);

    void a(com.ss.android.socialbase.downloader.downloader.k r1);

    void a(com.ss.android.socialbase.downloader.downloader.q r1);

    void a(DownloadInfo r1);

    void a(Runnable r1);

    void a(String[] r1);

    void a(String[] r1, long r2);

    JSONObject b();

    void b(com.ss.android.socialbase.downloader.downloader.f r1);

    y c();

    boolean d();

    void e();

    void f();

    com.ss.android.socialbase.downloader.downloader.q g();

    com.ss.android.socialbase.downloader.downloader.t h();

    void i();

    void j();

    void k();
}
