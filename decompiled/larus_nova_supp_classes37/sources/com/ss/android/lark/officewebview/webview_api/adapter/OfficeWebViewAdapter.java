package com.ss.android.lark.officewebview.webview_api.adapter;

import android.view.View;
import android.webkit.WebSettings;
import com.bytedance.ee.lark.component.AbstractNativeComponent;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeWebViewAdapter implements pxb.a {
    public final OfficeWebView a;
    public final Lazy b;

    public static final class a implements pxb.b {
        public final WebSettings a;

        @Override // pxb.b
        public final boolean a() {
            return this.a.getJavaScriptEnabled();
        }

        public a(WebSettings r2) {
            Intrinsics.checkNotNullParameter(r2, "webSettings");
            this.a = r2;
        }
    }

    @Override // pxb.a
    public final void c() {
        Intrinsics.checkNotNullParameter("LarkNativeComponentConfig", AppbrandHostConstants.Schema_Meta.NAME);
        this.a.removeJavascriptInterface("LarkNativeComponentConfig");
    }

    @Override // pxb.a
    public final qxb.b getBridge() {
        return new com.ss.android.lark.officewebview.webview_api.adapter.a(this.a);
    }

    @Override // pxb.a
    public final txb.b getServiceManager() {
        return (txb.b) this.b.getValue();
    }

    @Override // pxb.a
    public final pxb.b getSettings() {
        return new a(this.a.getSettings());
    }

    public final int hashCode() {
        return System.identityHashCode(this.a);
    }

    @Override // pxb.a
    public final View getView() {
        return this.a;
    }

    public OfficeWebViewAdapter(OfficeWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "officeWebView");
        this.a = r2;
        this.b = LazyKt.lazy(new OfficeWebViewAdapter$serviceManagerImpl$2(this));
    }

    @Override // pxb.a
    public final void b(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "obj");
        Intrinsics.checkNotNullParameter("LarkNativeComponentConfig", AppbrandHostConstants.Schema_Meta.NAME);
        this.a.addJavascriptInterface(r3, "LarkNativeComponentConfig");
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L5;
        return true;
    L5:
        OfficeWebView r2 = null;
        if ((r4 instanceof OfficeWebViewAdapter) == false) goto L8;
        OfficeWebViewAdapter r5 = (OfficeWebViewAdapter) r4;
    L9:
        if (r5 == null) goto L12;
        r2 = r5.a;
    L12:
        if (r2 == this.a) goto L16;
        return false;
    L16:
        return true;
    L8:
        r5 = null;
        goto L9
    }

    @Override // pxb.a
    public final void a(String r2, AbstractNativeComponent.a.a r3) {
        Intrinsics.checkNotNullParameter(r2, "script");
        c r0 = new c(r3);
        this.a.evaluateJavascript(r2, r0);
    }
}
