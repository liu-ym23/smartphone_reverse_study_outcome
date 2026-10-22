package com.bytedance.android.annie.api.card;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.annie.api.view.RadiusLayout;
import com.bytedance.android.annie.card.base.b;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010\"\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\"\u0010$\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019¨\u0006."}, d2 = {"Lcom/bytedance/android/annie/api/card/HybridCard;", "Lcom/bytedance/android/annie/api/view/RadiusLayout;", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", "Landroid/view/View;", "getHybridView", "Lcom/bytedance/android/annie/api/card/IHybridComponent$a;", "listener", "", "setJSBridgeListener", "", "radius", "setRadius", "c", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", "getMCurrentHybridComponent", "()Lcom/bytedance/android/annie/api/card/IHybridComponent;", "setMCurrentHybridComponent", "(Lcom/bytedance/android/annie/api/card/IHybridComponent;)V", "mCurrentHybridComponent", "", "d", "Z", "getDestroyedFlag", "()Z", "setDestroyedFlag", "(Z)V", "destroyedFlag", "e", "getMReleasedFlag", "setMReleasedFlag", "mReleasedFlag", "g", "getLoadSuccess", "setLoadSuccess", "loadSuccess", "h", "isPreRender", "setPreRender", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public abstract class HybridCard extends RadiusLayout implements IHybridComponent {
    public static final /* synthetic */ int i = 0;
    public IHybridComponent c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    public HybridCard(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public HybridCard(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 4, 0);
    }

    public void a(Uri r1, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r1, a.KEY_SCHEMA);
    }

    public void b() {
    }

    public void c(b r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxCallback");
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean canGoBack() {
        return false;
    }

    public void d() {
    }

    public abstract void e(Activity r1);

    public void f(int r1, int r10) {
    }

    public abstract void g(boolean r1, String r10);

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public abstract /* synthetic */ String getBizKey();

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* bridge */ /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ void goBack() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void hide() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean isPopup() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void show() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void addOnPreDrawListener() {
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L6;
        r0.addOnPreDrawListener();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void close() {
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public String containerId() {
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.containerId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public View getHybridView() {
        IHybridComponent r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHybridView();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final IHybridComponent.HybridType hybridType() {
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L7;
        IHybridComponent.HybridType r1 = r0.hybridType();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return IHybridComponent.HybridType.H5;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void release() {
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public final boolean getDestroyedFlag() {
        return this.d;
    }

    public final boolean getLoadSuccess() {
        return this.g;
    }

    public final IHybridComponent getMCurrentHybridComponent() {
        return this.c;
    }

    public final boolean getMReleasedFlag() {
        return this.e;
    }

    public final void setDestroyedFlag(boolean r1) {
        this.d = r1;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void setJSBridgeListener(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L6;
        r0.setJSBridgeListener(r10);
        return;
    }

    public final void setLoadSuccess(boolean r1) {
        this.g = r1;
    }

    public final void setMCurrentHybridComponent(IHybridComponent r1) {
        this.c = r1;
    }

    public final void setMReleasedFlag(boolean r1) {
        this.e = r1;
    }

    public final void setPreRender(boolean r1) {
        this.h = r1;
    }

    @Override // com.bytedance.android.annie.api.view.RadiusLayout, a7.b
    public void setRadius(float r10) {
        if (hybridType() != IHybridComponent.HybridType.LYNX) goto L5;
        super.setRadius(r10);
        return;
    L5:
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L10;
        r0.setRadius(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L6;
        r0.updateData(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void load(String r10, Map<String, ? extends Object> r11) {
        this.f = true;
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L6;
        r0.load(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void registerMethod(String r10, f.b r11) {
        Intrinsics.checkNotNullParameter(r10, a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L6;
        r0.registerMethod(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final <T> void sendJsEvent(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "data");
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L6;
        r0.sendJsEvent(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final <P, R> void registerMethod(String r10, g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L6;
        r0.registerMethod(r10, r11);
        return;
    }

    public HybridCard(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ HybridCard(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }

    @Override // com.bytedance.android.annie.api.view.RadiusLayout, a7.b
    public void setRadius(float r10, float r11, float r12, float r13) {
        if (hybridType() != IHybridComponent.HybridType.LYNX) goto L5;
        super.setRadius(r10, r11, r12, r13);
        return;
    L5:
        IHybridComponent r0 = this.c;
        if (r0 == null) goto L10;
        r0.setRadius(r10, r11, r12, r13);
        return;
    }
}
