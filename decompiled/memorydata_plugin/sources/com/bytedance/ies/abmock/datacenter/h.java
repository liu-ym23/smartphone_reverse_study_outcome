package com.bytedance.ies.abmock.datacenter;

import com.bytedance.ies.abmock.datacenter.storage.o;
import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class h implements DataStorageProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<DataStorageProvider.a> f2686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.ies.abmock.datacenter.storage.e f2687b;
    private com.bytedance.ies.abmock.datacenter.storage.e c;
    private com.bytedance.ies.abmock.datacenter.storage.e d;
    private com.bytedance.ies.abmock.datacenter.storage.e e;
    private com.bytedance.ies.abmock.datacenter.storage.e f;
    private com.bytedance.ies.abmock.datacenter.storage.e g;
    private com.bytedance.ies.abmock.datacenter.storage.e h;
    private com.bytedance.ies.abmock.datacenter.storage.e i;
    private com.bytedance.ies.abmock.datacenter.storage.e j;
    private com.bytedance.ies.abmock.datacenter.storage.e k;

    public h() {
        this.f2686a = new CopyOnWriteArraySet();
    }

    private Keva a(String r1) {
        return Keva.getRepoSync(r1, 1);
    }

    private /* synthetic */ Integer k() {
        this.k = new f(a("abmock_cdn_config_center_info_repo"));
        return 0;
    }

    private /* synthetic */ Integer l() {
        this.j = new f(a("abmock_cdn_row_config_center_repo"));
        return 0;
    }

    public static /* synthetic */ Integer lambda$8FPnW3CPulqIPD8mplgCdDvWH9A(h r0) {
        return r0.q();
    }

    public static /* synthetic */ Integer lambda$BNOysWSez8LWucXIhCjGr8Ep83E(h r0) {
        return r0.n();
    }

    public static /* synthetic */ Integer lambda$MDv6wbZz__k83PHQO4j1cAWlJ70(h r0) {
        return r0.k();
    }

    public static /* synthetic */ Integer lambda$NogGSbEL0VlTfvowkhXw9zUyvWU(h r0) {
        return r0.t();
    }

    public static /* synthetic */ Integer lambda$WRhHy95bWjfdlDCQ9FpkhJPINCY(h r0) {
        return r0.m();
    }

    public static /* synthetic */ Integer lambda$jdeLE8w9NAXd6Rch1JT7DcD0EBY(h r0) {
        return r0.o();
    }

    public static /* synthetic */ Integer lambda$kKyYXIeQBtziA6bGpgCj_SGUpek(h r0) {
        return r0.r();
    }

    /* JADX INFO: renamed from: lambda$ocrB4Nzl-9Bhj-zX2XHKsiGn40M, reason: not valid java name */
    public static /* synthetic */ Integer m106lambda$ocrB4Nzl9BhjzX2XHKsiGn40M(h r0) {
        return r0.p();
    }

    /* JADX INFO: renamed from: lambda$xWJvVWhMSs7IgVg-FdRqMg6PXa4, reason: not valid java name */
    public static /* synthetic */ Integer m107lambda$xWJvVWhMSs7IgVgFdRqMg6PXa4(h r0) {
        return r0.s();
    }

    public static /* synthetic */ Integer lambda$zsnoNFIoZscdQkWKgp0jF209Zgw(h r0) {
        return r0.l();
    }

    private /* synthetic */ Integer m() {
        this.i = new f(a("abmock_cdn_config_center_repo"));
        return 0;
    }

    private /* synthetic */ Integer n() {
        this.h = new f(a("hybrid_config_center_repo"));
        return 0;
    }

    private /* synthetic */ Integer o() {
        this.g = new f(Keva.getRepoSync("launch_center_repo", 0));
        return 0;
    }

    private /* synthetic */ Integer p() {
        this.f = new f(Keva.getRepoSync("config_center_meta_repo", 1));
        return 0;
    }

    private /* synthetic */ Integer q() {
        this.e = new f(Keva.getRepoSync("precise_exposure_repo_v2", 1));
        return 0;
    }

    private /* synthetic */ Integer r() {
        this.d = new f(o.a());
        return 0;
    }

    private /* synthetic */ Integer s() {
        Keva r0 = a("libra_config_center_repo");
        com.bytedance.ies.abmock.datacenter.storage.h.f2719a.a();
        this.c = new f(r0);
        return 0;
    }

    private /* synthetic */ Integer t() {
        this.f2687b = new f(a("config_center_repo"));
        return 0;
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public com.bytedance.ies.abmock.datacenter.storage.e a() {
        com.bytedance.ies.abmock.datacenter.storage.e r0 = this.f2687b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.ies.abmock.datacenter.event.a.a().a("CenterConfig", new $$Lambda$h$NogGSbEL0VlTfvowkhXw9zUyvWU(this));
        return this.f2687b;
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public void a(DataStorageProvider.a r3) {
        DataStorageProvider.a r4 = (DataStorageProvider.a) ZeusTransformUtils.wrapperContextForParams(r3, DataStorageProvider.a.class, "com.obric.memorydata.plugin");
        this.f2686a.add(r4);
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public com.bytedance.ies.abmock.datacenter.storage.e b() {
        com.bytedance.ies.abmock.datacenter.storage.e r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.ies.abmock.datacenter.event.a.a().a("libraConfig", new $$Lambda$h$xWJvVWhMSs7IgVgFdRqMg6PXa4(this));
        return this.c;
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public com.bytedance.ies.abmock.datacenter.storage.e c() {
        com.bytedance.ies.abmock.datacenter.storage.e r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.ies.abmock.datacenter.event.a.a().a("unRegisterConfig", new $$Lambda$h$kKyYXIeQBtziA6bGpgCj_SGUpek(this));
        return this.d;
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public com.bytedance.ies.abmock.datacenter.storage.e d() {
        com.bytedance.ies.abmock.datacenter.storage.e r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.ies.abmock.datacenter.event.a.a().a("preciseExposureConfig", new $$Lambda$h$8FPnW3CPulqIPD8mplgCdDvWH9A(this));
        return this.e;
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public com.bytedance.ies.abmock.datacenter.storage.e e() {
        com.bytedance.ies.abmock.datacenter.storage.e r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.ies.abmock.datacenter.event.a.a().a("metaConfig", new $$Lambda$h$ocrB4Nzl9BhjzX2XHKsiGn40M(this));
        return this.f;
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public com.bytedance.ies.abmock.datacenter.storage.e f() {
        com.bytedance.ies.abmock.datacenter.storage.e r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.ies.abmock.datacenter.event.a.a().a("launchConfig", new $$Lambda$h$jdeLE8w9NAXd6Rch1JT7DcD0EBY(this));
        return this.g;
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public com.bytedance.ies.abmock.datacenter.storage.e g() {
        com.bytedance.ies.abmock.datacenter.storage.e r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.ies.abmock.datacenter.event.a.a().a("hybridConfig", new $$Lambda$h$BNOysWSez8LWucXIhCjGr8Ep83E(this));
        return this.h;
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public com.bytedance.ies.abmock.datacenter.storage.e h() {
        com.bytedance.ies.abmock.datacenter.storage.e r0 = this.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.ies.abmock.datacenter.event.a.a().a("cdnConfig", new $$Lambda$h$WRhHy95bWjfdlDCQ9FpkhJPINCY(this));
        return this.i;
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public com.bytedance.ies.abmock.datacenter.storage.e i() {
        com.bytedance.ies.abmock.datacenter.storage.e r0 = this.j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.ies.abmock.datacenter.event.a.a().a("cdnRowConfig", new $$Lambda$h$zsnoNFIoZscdQkWKgp0jF209Zgw(this));
        return this.j;
    }

    @Override // com.bytedance.ies.abmock.datacenter.DataStorageProvider
    public com.bytedance.ies.abmock.datacenter.storage.e j() {
        com.bytedance.ies.abmock.datacenter.storage.e r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.ies.abmock.datacenter.event.a.a().a("cdnInfoConfig", new $$Lambda$h$MDv6wbZz__k83PHQO4j1cAWlJ70(this));
        return this.k;
    }
}
