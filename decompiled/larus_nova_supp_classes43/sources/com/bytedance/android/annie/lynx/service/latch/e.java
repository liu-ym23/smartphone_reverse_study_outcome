package com.bytedance.android.annie.lynx.service.latch;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements IHybridComponent {
    public JSBridgeManager a;

    public e() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ void addOnPreDrawListener() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ boolean canGoBack() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String containerId() {
        return "LatchMockHybridComponent";
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final View getHybridView() {
        return null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ void goBack() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void hide() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ boolean isPopup() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
    }

    @Override // a7.b
    public final /* synthetic */ void setRadius(float r1) {
    }

    @Override // a7.b
    public final /* synthetic */ void setRadius(float r1, float r10, float r11, float r12) {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void show() {
    }

    public static void a() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String getBizKey() {
        JSBridgeManager r0 = this.a;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeManager");
        r0 = null;
    L7:
        return r0.g();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void release() {
        JSBridgeManager r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeManager");
        r0 = null;
    L6:
        r0.release();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void close() {
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final IHybridComponent.HybridType hybridType() {
        return IHybridComponent.HybridType.LYNX;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void setJSBridgeListener(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateData(Map r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateGlobalProps(Map r1) {
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void load(String r1, Map r10) {
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        JSBridgeManager r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeManager");
        r0 = null;
    L6:
        r0.registerMethod(r10, r11);
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void sendJsEvent(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "data");
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final <P, R> void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        JSBridgeManager r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeManager");
        r0 = null;
    L6:
        r0.registerMethod(r10, r11);
    }
}
