package io.noties.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class l implements h.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<h.c> f16389b;

    public l(String r3, List<h.c> r4) {
        List<h.c> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f16388a = r3;
        this.f16389b = r5;
    }

    @Override // io.noties.a.h.f
    public String a() {
        return this.f16388a;
    }

    @Override // io.noties.a.h.f
    public List<h.c> b() {
        return this.f16389b;
    }

    public String toString() {
        return k.a(this);
    }
}
