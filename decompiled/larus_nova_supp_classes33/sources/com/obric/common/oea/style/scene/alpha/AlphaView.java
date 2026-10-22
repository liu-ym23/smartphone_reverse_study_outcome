package com.obric.common.oea.style.scene.alpha;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/AlphaView;", "Landroid/widget/FrameLayout;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "getController", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "getStatus", "Lcom/obric/common/oea/style/scene/alpha/AlphaView$a;", "listener", "Lcom/obric/common/oea/style/scene/alpha/AlphaView$a;", "getListener", "()Lcom/obric/common/oea/style/scene/alpha/AlphaView$a;", "setListener", "(Lcom/obric/common/oea/style/scene/alpha/AlphaView$a;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaView extends FrameLayout {
    public PlayerController a;

    public interface a {
    }

    public static final class b implements nja.b {
        public final /* synthetic */ AlphaView a;

        @Override // nja.b
        public final void a() {
            this.a.getListener();
        }

        @Override // nja.b
        public final void b() {
            this.a.getListener();
        }

        public b(AlphaView r1) {
            this.a = r1;
        }

        @Override // nja.b
        public final void c(ScaleType r2) {
            Intrinsics.checkNotNullParameter(r2, "scaleType");
            this.a.getListener();
        }
    }

    public AlphaView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AlphaView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final a getListener() {
        return null;
    }

    public final void setListener(a r1) {
    }

    private final PlayerController getController() {
        if (this.a != null) goto L16;
        Context r0 = getContext();
    L6:
        if ((r0 instanceof ContextWrapper) == false) goto L11;
        if ((r0 instanceof LifecycleOwner) == true) goto L9;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L6
    L9:
        LifecycleOwner r1 = (LifecycleOwner) r0;
    L12:
        if (r1 == null) goto L15;
        pja.a r2 = new pja.a(getContext(), r1);
        AlphaVideoViewType r3 = AlphaVideoViewType.GL_TEXTURE_VIEW;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.a = r3;
        PlayerController r4 = new PlayerController(r2);
        b r5 = new b(this);
        Intrinsics.checkNotNullParameter(r5, "playerAction");
        r4.h = r5;
        Unit r6 = Unit.INSTANCE;
        this.a = r4;
        goto L16
    L15:
        throw new IllegalStateException("AlphaView must be attached to a LifecycleOwner (Activity or Fragment).");
    L11:
        r1 = null;
    L16:
        PlayerController r7 = this.a;
        Intrinsics.checkNotNull(r7);
        return r7;
    }

    public final PlayerState getStatus() {
        PlayerController r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        PlayerController r0 = getController();
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "parentView");
        tja.a r1 = r0.d;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r1.d(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PlayerController r0 = this.a;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(this, "parentView");
        tja.a r1 = r0.d;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L7:
        r1.b(this);
    L8:
        PlayerController r2 = this.a;
        if (r2 == null) goto L11;
        r2.e(PlayerController.c(7, null));
    L11:
        this.a = null;
    }

    public AlphaView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ AlphaView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
