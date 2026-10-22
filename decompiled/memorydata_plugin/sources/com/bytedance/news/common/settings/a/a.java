package com.bytedance.news.common.settings.a;

import com.bytedance.news.common.settings.api.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f2909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2910b;
    private com.bytedance.news.common.settings.internal.a c;

    public a(String r3, i r4) {
        this.f2909a = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
        this.f2910b = r3;
        this.c = com.bytedance.news.common.settings.internal.a.a();
    }

    @Override // com.bytedance.news.common.settings.api.i
    public String a(String r2) {
        return b(r2, "");
    }

    @Override // com.bytedance.news.common.settings.api.i
    public void a() {
        this.f2909a.a();
    }

    @Override // com.bytedance.news.common.settings.api.i
    public void a(String r2, String r3) {
        this.f2909a.a(r2, r3);
        this.c.a(r2, r3);
    }

    @Override // com.bytedance.news.common.settings.api.i
    public String b(String r2, String r3) {
        String r4 = this.f2909a.b(r2, r3);
        this.c.a(r2, r4);
        return r4;
    }

    @Override // com.bytedance.news.common.settings.api.i
    public boolean b(String r1) {
        return this.f2909a.b(r1);
    }
}
