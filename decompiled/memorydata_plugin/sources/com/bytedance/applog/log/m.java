package com.bytedance.applog.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f1637a;

    public m() {
        this.f1637a = new l();
        a(System.currentTimeMillis());
    }

    public l a() {
        return this.f1637a;
    }

    public m a(int r2) {
        this.f1637a.a(r2);
        return this;
    }

    public m a(long r2) {
        this.f1637a.a(r2);
        return this;
    }

    public m a(String r2) {
        this.f1637a.a(r2);
        return this;
    }

    public m a(Throwable r2) {
        this.f1637a.a(r2);
        return this;
    }

    public m a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f1637a.a(r4);
        return this;
    }

    public m b(int r2) {
        this.f1637a.b(r2);
        return this;
    }

    public m b(String r2) {
        this.f1637a.b(r2);
        return this;
    }

    public m c(String r2) {
        this.f1637a.c(r2);
        return this;
    }
}
