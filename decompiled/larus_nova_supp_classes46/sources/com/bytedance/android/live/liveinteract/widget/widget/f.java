package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends FrameLayout {
    public Map<Integer, View> a;
    public String b;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            Intrinsics.checkNotNullParameter(r2, "id");
            super.onFinalImageSet(r2, (ImageInfo) r3, r4);
            if ((r4 instanceof AnimatedDrawable2) == false) goto L6;
            ((AnimatedDrawable2) r4).setAnimationListener(new g(this));
            return;
        }
    }

    static {
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void b(String r4) {
        PipelineDraweeControllerBuilder r0 = Fresco.newDraweeControllerBuilder();
        HSImageView r2 = a(2131389454);
        if (r2 == null) goto L5;
        DraweeController r3 = r2.getController();
    L6:
        AbstractDraweeController r5 = r0.setOldController(r3).setUri(r4).setControllerListener(new b(this)).setAutoPlayAnimations(true).build();
        HSImageView r1 = a(2131389454);
        if (r1 == null) goto L10;
        r1.setController(r5);
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void c(String r4) {
        boolean r1 = true;
        if ((!Intrinsics.areEqual(r4, this.b)) == false) goto L13;
        if (r4 != null) goto L6;
    L9:
        if (r1 == false) goto L11;
        this.b = vm2.d.a0().unkownMediaAnim;
        goto L13
    L11:
        this.b = r4;
        goto L13
    L6:
        if (r4.length() == 0) goto L9;
        r1 = false;
    L13:
        if (a(2131389454).getVisibility() != 8) goto L16;
        a(2131389454).setVisibility(0);
        b(this.b);
        return;
    }

    public f(Context r4, IBaseUser r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "user");
        super(r4);
        this.a = new LinkedHashMap();
        this.b = vm2.d.a0().unkownMediaAnim;
        LayoutInflater.from(r4).inflate(2131566145, this);
        py.k r6 = r5.getAvatarThumbKt();
        if (r6 == null) goto L7;
        List r7 = r6.getUrls();
        if (r7 == null) goto L7;
        String r8 = (String) ListProtector.get(r7, 0);
    L8:
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        ImageLoader.d r9 = ImageLoader.load(qy.a.a(r8));
        r9.d = new IterativeBoxBlurPostProcessor(4, 20);
        r9.a(a(2131389469));
        ImageLoader.bindDrawableResource(a(2131389554), 2131249019);
        ImageLoader.load(qy.a.a(r8)).a(a(2131389463));
        return;
    L7:
        r8 = null;
        goto L8
    }
}
