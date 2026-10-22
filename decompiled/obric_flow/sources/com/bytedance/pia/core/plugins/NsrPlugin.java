package com.bytedance.pia.core.plugins;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.utils.k;
import com.bytedance.pia.nsr.h;
import dh.f;
import ko.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nh.c;
import nh.d;
import yg.b;
import ym.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/pia/core/plugins/NsrPlugin;", "Lnh/c;", "Lnh/d;", "runtime", "Lyg/b;", "manifest", "<init>", "(Lnh/d;Lyg/b;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NsrPlugin extends c {
    public NsrPlugin(d r5, b r10) {
        Intrinsics.checkNotNullParameter(r5, "runtime");
        Intrinsics.checkNotNullParameter(r10, "manifest");
        super(r5);
    }

    @Override // nh.c
    public final f a(j r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        r r10 = h.f7194a;
        WebResourceResponse r11 = h.a(((WebResourceRequest) r5.f23302a).getUrl().toString(), this.f20236b);
        if (r11 == null) goto L6;
        LoadFrom r12 = LoadFrom.f6957c;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "from");
        return new k(r11);
    L6:
        return null;
    }

    @Override // nh.c
    public final String c() {
        return "nsr";
    }

    @Override // nh.c
    public final void f() {
    }
}
