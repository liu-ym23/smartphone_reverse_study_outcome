package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.facebook.drawee.controller.ControllerListener;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxUI;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class WebcastImage extends LynxUI<ImageView> {
    public boolean a;
    public int b;
    public String c;
    public Animatable d;

    public class a implements ControllerListener {
        public final /* synthetic */ WebcastImage a;

        public final void onFailure(String r1, Throwable r2) {
        }

        public final void onIntermediateImageFailed(String r1, Throwable r2) {
        }

        public final void onIntermediateImageSet(String r1, @Nullable Object r2) {
        }

        public final void onRelease(String r1) {
        }

        public final void onSubmit(String r1, Object r2) {
        }

        public a(WebcastImage r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, @Nullable Object r2, @Nullable Animatable r3) {
            this.a.d = r3;
        }
    }

    public final void M() {
        if (TextUtils.isEmpty(this.c) == false) goto L5;
        return;
    L5:
        if (getView() != null) goto L8;
        return;
    L8:
        if (ImageUtil.isActivityOK(((ImageView) getView()).getContext()) == true) goto L10;
        return;
    L10:
        Animatable r0 = this.d;
        if (r0 != null) goto L13;
    L15:
        this.d = null;
        FrescoLoader.with(((ImageView) getView()).getContext()).load(this.c).actualScaleType(ImageView.ScaleType.CENTER_CROP).autoPlayAnimations(this.a).fadeDuration(this.b).controllerListener(new a(this)).into((ImageView) getView());
        return;
    L13:
        if (r0.isRunning() == false) goto L15;
        this.d.stop();
        goto L15
    }

    @LynxUIMethod
    public void startAnim() {
        Animatable r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == true) goto L9;
        this.d.start();
        return;
    }

    @LynxUIMethod
    public void stopAnim() {
        Animatable r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        this.d.stop();
        return;
    }

    public WebcastImage(LynxContext r1) {
        super(r1);
        this.a = false;
        this.b = 300;
        this.c = "";
    }

    public final View createView(Context r2) {
        return new ImageView(r2);
    }

    @LynxProp(name = "auto-play")
    public void setAutoPlay(boolean r1) {
        this.a = r1;
        M();
    }

    @LynxProp(name = "fade-duration")
    public void setFadeDuration(int r1) {
        this.b = r1;
        M();
    }

    @LynxProp(name = "src")
    public void setSrc(String r2) {
        this.c = r2;
        if (getView() != null) goto L5;
    L8:
        M();
        return;
    L5:
        if (TextUtils.isEmpty(this.c) == false) goto L7;
        ((ImageView) getView()).setVisibility(8);
        goto L8
    L7:
        ((ImageView) getView()).setVisibility(0);
        goto L8
    }
}
