package com.obric.assistant.view;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.window.materials.BlurSceneType;
import com.obric.assistant.window.materials.services.IWindowMaterialService;
import com.obric.oui.material.OMaterialHelper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n extends View {
    public final BlurSceneType a;
    public int b;
    public int c;
    public Function1<? super Integer, Unit> d;
    public final int e;
    public final Lazy f;
    public final Lazy g;
    public final AtomicBoolean h;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        ViewCompat.setWindowInsetsAnimationCallback(this, null);
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        super.onDetachedFromWindow();
        FLogger r1 = FLogger.a;
        r1.i("ObricChatBottomBlurView", "onDetachedFromWindow");
        if (this.h.compareAndSet(true, false) == false) goto L9;
        r1.i("ObricChatBottomBlurView", "clearBlur");
        com.obric.oui.blur.a r2 = getMaskMaterialConfig().g;
        if (r2 == null) goto L7;
        r2.c = 1.0f;
    L7:
        OMaterialHelper.q(this, 0);
        OMaterialHelper.t(this, null);
        return;
    }

    private final int getBlurSrcType() {
        return ((Number) this.f.getValue()).intValue();
    }

    private final com.obric.oui.material.c getMaskMaterialConfig() {
        return (com.obric.oui.material.c) this.g.getValue();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FLogger r0 = FLogger.a;
        r0.i("ObricChatBottomBlurView", "onAttachedToWindow");
        ViewCompat.setOnApplyWindowInsetsListener(this, new k(this));
        if (this.a != BlurSceneType.WINDOW) goto L5;
        ViewCompat.setWindowInsetsAnimationCallback(this, new ObricChatBottomBlurView$setShowBelowNavigationBar$2(this));
    L5:
        ViewCompat.requestApplyInsets(this);
        IWindowMaterialService r1 = (IWindowMaterialService) ServiceManager.get().getService(IWindowMaterialService.class);
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L14;
        r0.i("ObricChatBottomBlurView", "setBlur: blur is not enabled");
        return;
    L14:
        if (this.h.compareAndSet(false, true) == false) goto L18;
        r0.i("ObricChatBottomBlurView", "setBlur");
        OMaterialHelper.p(this, getMaskMaterialConfig(), getBlurSrcType());
        OMaterialHelper.t(this, this);
        return;
    L18:
        return;
    L8:
        if (r1.b(getContext()) != true) goto L10;
        r2 = true;
        goto L11
    }

    public final int getBlurHeight() {
        return this.e;
    }

    public final void a(View r4) {
        float r0 = this.b - this.c;
        if (r4.getTranslationY() != r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r4.setTranslationY(r0);
        FLogger.a.i("ObricChatBottomBlurView", "updateTranslationY: navigationBarHeight=" + this.b + ", imeBottom=" + this.c + ", translationY=" + r0);
        return;
    L9:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void setBlurAlpha(float r2) {
        com.obric.oui.blur.a r0 = getMaskMaterialConfig().g;
        if (r0 == null) goto L6;
        r0.c = r2;
    L6:
        if (this.h.get() == false) goto L9;
        OMaterialHelper.p(this, getMaskMaterialConfig(), getBlurSrcType());
        return;
    }

    public final void setOnImeBottomChangedListener(Function1<? super Integer, Unit> r3) {
        this.d = r3;
        if (this.a != BlurSceneType.WINDOW) goto L7;
        if (r3 == null) goto L8;
        r3.invoke(Integer.valueOf(this.c));
        return;
    L8:
        return;
    }

    public n(final Context r2, BlurSceneType r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "blurSceneType");
        super(r2);
        this.a = r3;
        this.e = i5.w();
        this.f = LazyKt.lazy(new l(this));
        this.g = LazyKt.lazy(new m(r2));
        this.h = new AtomicBoolean(false);
    }
}
