package com.bytedance.ies.bullet.service.webkit;

import android.webkit.WebView;
import bd.f;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDispatcher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f6157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebView f6158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f6159c;
    public final WebChromeClientDispatcher d;
    public final Lazy e;

    public d(c r5, com.bytedance.ies.bullet.service.base.c r10) {
        Intrinsics.checkNotNullParameter(r5, "webKitService");
        Intrinsics.checkNotNullParameter(r10, "config");
        this.f6157a = r5;
        this.f6159c = new f();
        this.d = new WebChromeClientDispatcher();
        this.e = LazyKt.lazy(new WebViewDelegate$globalPropsHandler$2(this));
    }
}
