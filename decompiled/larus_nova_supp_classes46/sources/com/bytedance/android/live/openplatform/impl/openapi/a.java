package com.bytedance.android.live.openplatform.impl.openapi;

import com.bytedance.android.live.openplatform.impl.base.openapi.OpenApiErrorInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yo0.b;
import yo0.c;
import yo0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements b {
    public final ConcurrentHashMap<String, c> a;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.openapi.a$a, reason: collision with other inner class name */
    public static final class C0182a {
    }

    static {
    }

    public a() {
        this.a = new ConcurrentHashMap();
    }

    @Override // yo0.b
    public final void b(AbsOpenApiHandler r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.a.put(r3.d, r3);
    }

    @Override // yo0.b
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        this.a.remove(r2);
    }

    @Override // yo0.b
    public final void a(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        c r5 = this.a.get(r2);
        if (r5 != null) goto L6;
        int r6 = qo0.a.a;
        qo0.a.b("OpenApiService", "无法处理该事件发送，params = " + r4, null);
        return;
    L6:
        r5.sendEvent(r3, r4);
    }

    @Override // yo0.b
    public final void c(String r2, JSONObject r3, yo0.a.InterfaceC0296a r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        c r5 = this.a.get(r2);
        if (r5 != null) goto L6;
        int r6 = qo0.a.a;
        qo0.a.b("OpenApiService", "无法处理该方法调用，params = " + r3, null);
        d.a.C0297a r7 = d.a.d;
        OpenApiErrorInfo r8 = OpenApiErrorInfo.INTERNAL_ERROR;
        r7.getClass();
        r4.a(d.a.C0297a.b(r8, null).a());
        return;
    L6:
        r5.a(r3, r4);
    }
}
