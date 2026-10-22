package com.obric.common.oea.style.scene.alpha;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017J\"\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/AlphaView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;", "getListener", "()Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;", "setListener", "(Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;)V", "playerController", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "findLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getController", "getStatus", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "onAttachedToWindow", "", "onDetachedFromWindow", "pause", "release", "resume", CommonConsts.APM_INNER_EVENT_COST_START, "file", "Ljava/io/File;", "loop", "", "scaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "AlphaPlayerListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f7771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PlayerController f7772b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;", "", "onEnd", "", "onStart", "onVideoSizeChanged", "videoWidth", "", "videoHeight", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface a {
        void a();

        void a(int r1, int r2);

        void b();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b¸\u0006\u0000"}, d2 = {"com/obric/common/oea/style/scene/alpha/AlphaView$getController$1$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IPlayerAction;", "endAction", "", "onVideoSizeChanged", "videoWidth", "", "videoHeight", "scaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "startAction", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements com.obric.common.oea.style.scene.alpha.alphaplayer.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlphaView f7773a;

        b(AlphaView r1) {
            this.f7773a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.b
        public void a() {
            a r0 = this.f7773a.getListener();
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.b
        public void a(int r2, int r3, ScaleType r4) {
            Intrinsics.checkNotNullParameter(r4, "scaleType");
            a r1 = this.f7773a.getListener();
            if (r1 == null) goto L6;
            r1.a(r2, r3);
            return;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.b
        public void b() {
            a r0 = this.f7773a.getListener();
            if (r0 == null) goto L6;
            r0.b();
            return;
        }
    }

    public AlphaView(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
    }

    public AlphaView(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin"), 0, 4, null);
    }

    public AlphaView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
    }

    public /* synthetic */ AlphaView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = (AttributeSet) ZeusTransformUtils.preCheckCast(null, AttributeSet.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final LifecycleOwner a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r1, LifecycleOwner.class) == true) goto L8;
        r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "currentContext.baseContext");
        goto L4
    L8:
        return (LifecycleOwner) ZeusTransformUtils.preCheckCast(r1, LifecycleOwner.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    }

    private final PlayerController getController() {
        if (this.f7772b != null) goto L9;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        LifecycleOwner r1 = a(r0);
        if (r1 == null) goto L8;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        com.obric.common.oea.style.scene.alpha.alphaplayer.model.a r3 = new com.obric.common.oea.style.scene.alpha.alphaplayer.model.a(r4, r1);
        r3.a(AlphaVideoViewType.GL_TEXTURE_VIEW);
        PlayerController r2 = new PlayerController(r3, null, 2, null);
        r2.setPlayerAction((com.obric.common.oea.style.scene.alpha.alphaplayer.b) ZeusTransformUtils.preCheckCast(new b(this), com.obric.common.oea.style.scene.alpha.alphaplayer.b.class, "com.obric.memorydata.plugin"));
        Unit r5 = Unit.INSTANCE;
        this.f7772b = r2;
        goto L9
    L8:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("AlphaView must be attached to a LifecycleOwner (Activity or Fragment)."), Throwable.class, "com.obric.memorydata.plugin"));
    L9:
        PlayerController r6 = this.f7772b;
        Intrinsics.checkNotNull(r6);
        return r6;
    }

    public final void a() {
        PlayerController r0 = this.f7772b;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.f7772b = (PlayerController) ZeusTransformUtils.preCheckCast(null, PlayerController.class, "com.obric.memorydata.plugin");
    }

    public final a getListener() {
        return this.f7771a;
    }

    public final PlayerState getStatus() {
        PlayerController r0 = this.f7772b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getStatus();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getController().attachAlphaView((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PlayerController r0 = this.f7772b;
        if (r0 == null) goto L5;
        r0.detachAlphaView((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
    L5:
        a();
    }

    public final void setListener(a r3) {
        this.f7771a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }
}
