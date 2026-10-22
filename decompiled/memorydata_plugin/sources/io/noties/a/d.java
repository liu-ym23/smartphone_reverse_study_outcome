package io.noties.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class d implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<h.f> f16379b;

    public d(String r3, List<h.f> r4) {
        List<h.f> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f16378a = r3;
        this.f16379b = r5;
    }

    @Override // io.noties.a.h.a
    public String a() {
        return this.f16378a;
    }

    @Override // io.noties.a.h.a
    public List<h.f> b() {
        return this.f16379b;
    }

    public String toString() {
        return k.a(this);
    }
}
