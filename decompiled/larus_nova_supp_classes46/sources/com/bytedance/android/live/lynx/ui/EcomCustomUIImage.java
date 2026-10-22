package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.lynx.tasm.ui.image.UIImage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/EcomCustomUIImage;", "Lcom/lynx/tasm/ui/image/UIImage;", "Lcom/bytedance/android/live/lynx/ui/ECCustomFrescoImageView;", "", "durationMs", "", "setFadeDuration", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcomCustomUIImage extends UIImage<ECCustomFrescoImageView> {

    public static final class a extends com.lynx.tasm.ui.image.l {
        public final /* synthetic */ EcomCustomUIImage a;

        public a(EcomCustomUIImage r1) {
            this.a = r1;
        }

        public final void onImageLoadFailed(String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorMsg");
            m7a.a r0 = new m7a.a(this.a.getSign(), "error");
            r0.a("errMsg", r4);
            this.a.getLynxContext().getEventEmitter().sendCustomEvent(r0);
            EventEmitter r5 = this.a.getLynxContext().getEventEmitter();
            this.a.getSign();
            r5.sendInternalEvent(new m7a.c());
        }

        public final void onImageLoadSuccess(int r4, int r5) {
            if (EcomCustomUIImage.M(this.a) != null) goto L5;
            return;
        L5:
            if (EcomCustomUIImage.M(this.a).containsKey("load") == false) goto L9;
            m7a.a r0 = new m7a.a(this.a.getSign(), "load");
            r0.a("height", Integer.valueOf(r5));
            r0.a("width", Integer.valueOf(r4));
            this.a.getLynxContext().getEventEmitter().sendCustomEvent(r0);
            return;
        }
    }

    public EcomCustomUIImage(LynxContext r1) {
        super(r1);
    }

    public static final /* synthetic */ Map M(EcomCustomUIImage r0) {
        return ((LynxBaseUI) r0).mEvents;
    }

    public final ECCustomFrescoImageView N(Context r4) {
        ((UIImage) this).mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        Intrinsics.checkNotNull(r4);
        ECCustomFrescoImageView r0 = new ECCustomFrescoImageView(r4, ((UIImage) this).mDraweeControllerBuilder, null, null);
        r0.setImageLoaderCallback(new a(this));
        r0.setFadeDuration(300);
        return r0;
    }

    public final /* bridge */ /* synthetic */ View createView(Context r1) {
        return N(r1);
    }

    @LynxProp(name = "fade-duration")
    public final void setFadeDuration(int r2) {
        if (getView() == null) goto L6;
        ((ECCustomFrescoImageView) getView()).setFadeDuration(r2);
        return;
    }

    /* JADX INFO: renamed from: createView, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ FrescoImageView m517createView(Context r1) {
        return N(r1);
    }
}
