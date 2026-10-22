package com.obric.common.oea.style.scene.alpha;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import i4.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import zm.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/AlphaView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "getController", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "getStatus", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "Lsp/a;", "listener", "Lsp/a;", "getListener", "()Lsp/a;", "setListener", "(Lsp/a;)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PlayerController f11342a;

    @JvmOverloads
    public AlphaView(Context r5) {
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final PlayerController getController() {
        if (this.f11342a != null) goto L16;
        Object r5 = getContext();
    L6:
        if ((r5 instanceof ContextWrapper) == false) goto L11;
        if ((r5 instanceof LifecycleOwner) == true) goto L9;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L6
    L9:
        LifecycleOwner r10 = (LifecycleOwner) r5;
    L12:
        if (r10 == null) goto L15;
        Context r11 = getContext();
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r10, "lifecycleOwner");
        a r12 = new a(23);
        r12.f17503c = r11;
        r12.d = r10;
        r12.f17502b = AlphaVideoViewType.GL_SURFACE_VIEW;
        AlphaVideoViewType r13 = AlphaVideoViewType.GL_TEXTURE_VIEW;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.f17502b = r13;
        PlayerController r14 = new PlayerController(r12);
        c r15 = new c(this, 11);
        Intrinsics.checkNotNullParameter(r15, "playerAction");
        r14.f = r15;
        Unit r16 = Unit.INSTANCE;
        this.f11342a = r14;
        goto L16
    L15:
        throw new IllegalStateException("AlphaView must be attached to a LifecycleOwner (Activity or Fragment).");
    L11:
        r10 = null;
    L16:
        PlayerController r17 = this.f11342a;
        Intrinsics.checkNotNull(r17);
        return r17;
    }

    public final sp.a getListener() {
        return null;
    }

    public final PlayerState getStatus() {
        PlayerController r5 = this.f11342a;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.e;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, zp.k] */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        PlayerController r5 = getController();
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "parentView");
        ?? r10 = r5.f11345c;
        if (r10 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r10.c(this);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, zp.k] */
    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PlayerController r5 = this.f11342a;
        if (r5 == null) goto L8;
        Intrinsics.checkNotNullParameter(this, "parentView");
        ?? r10 = r5.f11345c;
        if (r10 != 0) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L7:
        r10.d(this);
    L8:
        PlayerController r11 = this.f11342a;
        if (r11 == null) goto L11;
        r11.f(PlayerController.c(7, null));
    L11:
        this.f11342a = null;
    }

    public final void setListener(sp.a r5) {
    }

    @JvmOverloads
    public AlphaView(Context r5, AttributeSet r10) {
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ AlphaView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public AlphaView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
    }
}
