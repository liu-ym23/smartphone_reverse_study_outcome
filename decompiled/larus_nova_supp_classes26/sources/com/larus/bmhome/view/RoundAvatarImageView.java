package com.larus.bmhome.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J6\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/view/RoundAvatarImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "setAvatarUrl", ShareType.URL, "", "bizTag", "needResize", "", "controllerListener", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoundAvatarImageView extends SimpleDraweeView {
    public static final /* synthetic */ int a = 0;

    public RoundAvatarImageView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        init(r2, null);
    }

    public RoundAvatarImageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        init(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init(Context r6, AttributeSet r7) {
        if (r7 == null) goto L5;
        TypedArray r8 = r6.obtainStyledAttributes(r7, new int[]{2130968895});
        int r9 = r8.getResourceId(0, -1);
        r8.recycle();
    L6:
        GenericDraweeHierarchy r10 = getHierarchy();
        RoundingParams r2 = getHierarchy().getRoundingParams();
        if (r2 == null) goto L10;
        RoundingParams r0 = r2.setRoundAsCircle(true);
        if (r0 == null) goto L10;
    L11:
        r10.setRoundingParams(r0);
        if (r9 != (-1)) goto L14;
        r9 = 2131240119;
    L14:
        r10.setPlaceholderImage(r9);
        r10.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
    L10:
        r0 = RoundingParams.asCircle();
        goto L11
    L5:
        r9 = -1;
        goto L6
    }

    public RoundAvatarImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        init(r2, r3);
    }

    public static void f(final RoundAvatarImageView r2, String r3, String r4, final boolean r5, int r6) {
        if ((r6 & 4) == 0) goto L5;
        r5 = false;
    L5:
        r2.getClass();
        final BaseControllerListener r1 = null;
        ImageLoaderKt.y(r2, r3, r4, new c4(r2, r1, r5), 4);
    }
}
