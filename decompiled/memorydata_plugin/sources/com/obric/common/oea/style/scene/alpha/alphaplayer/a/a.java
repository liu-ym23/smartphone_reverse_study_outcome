package com.obric.common.oea.style.scene.alpha.alphaplayer.a;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0013J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/GLTextureView$Renderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "measureInternal", "", "viewWidth", "", "viewHeight", "videoWidth", "videoHeight", "onCompletion", "onFirstFrame", "setScaleType", "scaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "setSurfaceListener", "surfaceListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender$SurfaceListener;", "SurfaceListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public interface a extends SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, GLTextureView.m {

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.alpha.alphaplayer.a.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender$SurfaceListener;", "", "onSurfaceDestroyed", "", "onSurfacePrepared", "surface", "Landroid/view/Surface;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface InterfaceC0378a {
        void a(Surface r1);
    }

    void a();

    void a(float r1, float r2, float r3, float r4);

    void a(InterfaceC0378a r1);

    void a(ScaleType r1);

    void b();
}
