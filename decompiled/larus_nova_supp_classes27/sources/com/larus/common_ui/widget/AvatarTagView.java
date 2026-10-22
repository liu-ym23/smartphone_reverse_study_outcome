package com.larus.common_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_res.common_ui.databinding.LarusLayoutAvatarTagViewBinding;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u0007J$\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/common_ui/widget/AvatarTagView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusLayoutAvatarTagViewBinding;", "setStrokeBackgroundDrawable", "", "corner", "", "normalColor", "pressedColor", "setup", "iconLightUrl", "", "iconDarkUrl", "enableCircle", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarTagView extends FrameLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusLayoutAvatarTagViewBinding a;

    public static final class a {
    }

    static {
    }

    public AvatarTagView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AvatarTagView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public AvatarTagView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131562742, this);
        int r5 = 2131363735;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(this, 2131363735);
        if (r6 == null) goto L9;
        r5 = 2131363737;
        CircleFrameLayout r7 = (CircleFrameLayout) ViewBindings.findChildViewById(this, 2131363737);
        if (r7 == null) goto L9;
        this.a = new LarusLayoutAvatarTagViewBinding(this, r6, r7);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public static void a(AvatarTagView r3, String r4, String r5) {
        r3.a.c.a(true);
        SimpleDraweeView r6 = r3.a.b;
        r6.getHierarchy().setFailureImage(2131240889);
        boolean r0 = h.a;
        if (h.b(r6.getContext()) == false) goto L5;
        FLogger.a.d("AvatarTagView", "[setupAvatarTag] iconDarkUrl: " + r5);
        r4 = r5;
    L6:
        ImageLoaderKt.v(r6, r4, "bot_ic_avatar_tag", null, new z19.a());
        return;
    L5:
        FLogger.a.d("AvatarTagView", "[setupAvatarTag] iconLightUrl: " + r4);
        goto L6
    }

    public /* synthetic */ AvatarTagView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
