package com.bytedance.api.location;

import android.content.Context;
import com.bytedance.api.location.a.c;
import com.bytedance.bdlocation.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteLocationClientOption f1014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f1015b;

    public a(Context r3) {
        this.f1015b = new com.bytedance.api.location.a.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    private static <T> T a(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }

    public a a(ByteLocationClientOption r2) {
        a(r2, "option should not null");
        this.f1014a = r2;
        return this;
    }

    public a a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        a(r4, "listener should not null");
        this.f1015b.a(r4);
        return this;
    }

    public void a() {
        Logger.i("ByteLocationClient: startLocation() is executed.");
        this.f1015b.a(this.f1014a);
    }

    public a b(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        a(r4, "listener should not null");
        this.f1015b.b(r4);
        return this;
    }

    public void b() {
        Logger.i("ByteLocationClient: release() is executed.");
        this.f1015b.d();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.i("ByteLocationClient: release() has an error and the message: %s", e.getLocalizedMessage());
        e.printStackTrace();
    }
}
