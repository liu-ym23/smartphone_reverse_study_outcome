package com.bytedance.android.live.schema.api;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class WebcastRedirectReportInfo {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public final Map<String, String> b() {
        return (Map) this.a.getValue();
    }

    public final Map<String, String> c() {
        return (Map) this.b.getValue();
    }

    public WebcastRedirectReportInfo() {
        this.a = LazyKt.lazy(WebcastRedirectReportInfo$category$2.INSTANCE);
        this.b = LazyKt.lazy(WebcastRedirectReportInfo$extras$2.INSTANCE);
        this.c = LazyKt.lazy(WebcastRedirectReportInfo$metric$2.INSTANCE);
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        b().put(r2, r3);
    }
}
