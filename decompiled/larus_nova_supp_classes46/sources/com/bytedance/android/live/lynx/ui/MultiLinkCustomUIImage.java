package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.lynx.tasm.ui.image.UIImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/MultiLinkCustomUIImage;", "Lcom/lynx/tasm/ui/image/UIImage;", "Lcom/bytedance/android/live/lynx/ui/MultiLinkCustomFrescoImageView;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkCustomUIImage extends UIImage<MultiLinkCustomFrescoImageView> {
    public MultiLinkCustomUIImage(LynxContext r1) {
        super(r1);
    }

    public final View createView(Context r8) {
        ((UIImage) this).mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        Intrinsics.checkNotNull(r8);
        return new MultiLinkCustomFrescoImageView(r8, ((UIImage) this).mDraweeControllerBuilder, null, null, this);
    }

    /* JADX INFO: renamed from: createView, reason: collision with other method in class */
    public final FrescoImageView m521createView(Context r8) {
        ((UIImage) this).mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        Intrinsics.checkNotNull(r8);
        return new MultiLinkCustomFrescoImageView(r8, ((UIImage) this).mDraweeControllerBuilder, null, null, this);
    }
}
