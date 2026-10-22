package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.drawable.Animatable;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ IconMoveAnimationTasklet a;
    public final /* synthetic */ FrameLayout b;
    public final /* synthetic */ HSImageView c;
    public final /* synthetic */ Ref.IntRef d;
    public final /* synthetic */ Ref.IntRef e;
    public final /* synthetic */ Function1 f;

    public final void onFailure(String r3, Throwable r4) {
        super.onFailure(r3, r4);
        ALogger.d("InteractAnimation.IconMoveAnimationTasklet", this.a + " load failed");
        IconMoveAnimationTasklet r5 = this.a;
        FrameLayout r6 = this.b;
        HSImageView r0 = this.c;
        r5.getClass();
        r6.post(new k(r5, r0, r6));
        Ref.IntRef r7 = this.e;
        boolean r1 = true;
        int r8 = r7.element + 1;
        r7.element = r8;
        if ((this.d.element + r8) < ((ArrayList) this.a.c).size()) goto L12;
        Function1 r9 = this.f;
        if (r9 != null) goto L7;
        return;
    L7:
        if (this.d.element > 0) goto L10;
        r1 = false;
    L10:
        Unit r10 = (Unit) r9.invoke(Boolean.valueOf(r1));
        return;
    }

    public final void onFinalImageSet(String r4, Object r5, Animatable r6) {
        super.onFinalImageSet(r4, (ImageInfo) r5, r6);
        ALogger.d("InteractAnimation.IconMoveAnimationTasklet", this.a + " load success");
        if ((r6 instanceof AnimatedDrawable2) == false) goto L10;
        IconMoveAnimationTasklet r7 = this.a;
        AnimatedDrawable2 r8 = (AnimatedDrawable2) r6;
        FrameLayout r9 = this.b;
        HSImageView r0 = this.c;
        r7.getClass();
        r8.setLoopCount(1);
        com.bytedance.android.live.core.utils.fresco.c.c(r8);
        r8.setAnimationListener(new i(r7, r0, r8, r9));
        Ref.IntRef r10 = this.d;
        int r11 = r10.element + 1;
        r10.element = r11;
        if ((r11 + this.e.element) < ((ArrayList) this.a.c).size()) goto L11;
        Function1 r12 = this.f;
        if (r12 == null) goto L12;
        Unit r13 = (Unit) r12.invoke(Boolean.TRUE);
        return;
    L12:
        return;
    L11:
        return;
    }

    public h(IconMoveAnimationTasklet r1, FrameLayout r2, HSImageView r3, Ref.IntRef r4, Ref.IntRef r5, Function1 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
