package com.bytedance.android.annie.card.web;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.ies.web.jsbridge2.c0;
import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class e implements com.bytedance.android.annie.card.base.b {
    public final com.bytedance.android.annie.card.base.b a;

    public e() {
        this(null);
    }

    public void A(WebView r10) {
        Intrinsics.checkNotNullParameter(r10, "webView");
    }

    public void B(WebView r1) {
    }

    public void C() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void b(c0 r10) {
        Intrinsics.checkNotNullParameter(r10, "call");
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void c(JSONObject r10, c0 r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "call");
    }

    public void d(WebView r1) {
    }

    public void e(WebView r1) {
    }

    public void f(String r1, ValueCallback<String> r10) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void n(LynxView r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
    }

    public void o() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onBeforeLynxEnvInitialize(boolean r1) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onLynxEnvInitialized() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onRelease() {
    }

    public void p(String r1, GeolocationPermissions.Callback r10) {
    }

    public void q(WebView r1) {
    }

    public void r() {
    }

    public void s(WebView r1, String r10) {
    }

    public void t(WebView r1, int r10) {
    }

    public void u(WebView r1, WebResourceRequest r10, WebResourceError r11) {
    }

    public void v(WebView r1, WebResourceRequest r10, WebResourceResponse r11) {
    }

    public void w() {
    }

    public void x(String r1) {
    }

    public void y() {
    }

    public void z(View r1, WebChromeClient.CustomViewCallback r10) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeGlobalPropsInitialize() {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeGlobalPropsInitialize();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeInitialPropsInitialize() {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeInitialPropsInitialize();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeJsbRegister() {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeJsbRegister();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onCardLoadStart() {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onCardLoadStart();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onEngineLoadEnd() {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onEngineLoadEnd();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onEngineLoadStart() {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onEngineLoadStart();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onGlobalPropsInitialized() {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onGlobalPropsInitialized();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onInitialPropsInitialized() {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onInitialPropsInitialized();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onJsbRegistered() {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onJsbRegistered();
        return;
    }

    public e(com.bytedance.android.annie.card.base.b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void m(boolean r10) {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.m(r10);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeCreateRenderData(View r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeCreateRenderData(r10);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public void g(View r10, String r11) {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.g(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public void h(View r10, com.bytedance.android.annie.card.web.resource.a r11) {
        Intrinsics.checkNotNullParameter(r11, "resourceInfo");
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.h(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onCreateRenderData(View r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        Intrinsics.checkNotNullParameter(r11, "stateKeys");
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onCreateRenderData(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onTemplateLoaded(View r10, boolean r11) {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onTemplateLoaded(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public void i(LynxView r10, String r11, String r12) {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.i(r10, r11, r12);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public void j(View r10, String r11, String r12) {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.j(r10, r11, r12);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public void k(View r10, String r11, Bitmap r12, boolean r13) {
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.k(r10, r11, r12, r13);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void l(String r10, AnnieResType r11, IHybridComponent.HybridType r12, Map<String, Long> r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "resType");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "performInfo");
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.l(r10, r11, r12, r13);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeLoadRequest(String r10, AnnieResType r11, IHybridComponent.HybridType r12, Map<String, Object> r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "resType");
        Intrinsics.checkNotNullParameter(r12, "type");
        com.bytedance.android.annie.card.base.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeLoadRequest(r10, r11, r12, r13);
        return;
    }
}
