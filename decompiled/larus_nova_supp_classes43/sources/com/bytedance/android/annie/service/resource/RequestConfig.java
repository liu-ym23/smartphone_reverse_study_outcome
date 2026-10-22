package com.bytedance.android.annie.service.resource;

import android.webkit.WebResourceRequest;
import com.bytedance.android.annie.api.resource.AnnieResType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RequestConfig {
    public final AnnieResType a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public String h;
    public final boolean i;
    public final Lazy j;
    public WebResourceRequest k;
    public boolean l;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof RequestConfig) == true) goto L9;
        return false;
    L9:
        if (this.a == ((RequestConfig) r10).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "RequestConfig(resType=" + this.a + ')';
    }

    public final Map<String, Object> a() {
        return (Map) this.j.getValue();
    }

    public RequestConfig(AnnieResType r10) {
        Intrinsics.checkNotNullParameter(r10, "resType");
        this.a = r10;
        if (com.bytedance.android.annie.ng.g.g == true) goto L5;
    L8:
        boolean r11 = true;
    L9:
        this.i = r11;
        this.j = LazyKt.lazy(RequestConfig$customParams$2.INSTANCE);
        return;
    L5:
        if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L8;
        r11 = false;
        goto L9
    }
}
