package com.larus.bmhome.chat.standarduikit.imagegroup.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.widget.FrameLayout;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 R2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001RB\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0017\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0002JL\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020 2\b\b\u0002\u0010-\u001a\u00020 H\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020\u0016H\u0002J \u00101\u001a\u00020\u00162\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\u001bH\u0002J6\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\u001b2\b\b\u0002\u0010:\u001a\u00020\u001b2\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010<H\u0002J\u0084\u0001\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u0002082\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000f0<2\u0006\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020*2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010C2\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010C2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010CH\u0002J\u0012\u0010F\u001a\u00020\u00162\b\u0010G\u001a\u0004\u0018\u00010*H\u0002J\u0016\u0010H\u001a\u00020\u00162\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00160CH\u0002J\u001a\u0010J\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010K\u001a\u00020 H\u0016J\u0010\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020NH\u0002J$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0P2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0006\u0010Q\u001a\u00020\u0016R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/imagegroup/view/ImageGroupView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/imagegroup/view/ImageGroupViewInput;", "Lcom/larus/bmhome/chat/standarduikit/imagegroup/view/ImageGroupViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "timingAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "currInflateView", "Landroid/view/View;", "widgetSize", "Landroid/util/Size;", "spanSize", "exposeImages", "", "bindData", "", "input", "output", "updateContainer", "isHead", "", "isTail", "updateUI", "useNewStyle", "currShowType", "", "(Ljava/lang/Integer;)Z", "handleMultiLayerUIV2", "updateLayerUI", "updateMultiLayerUIV2", "mobCardShow", "image", "imageItem", "Lcom/larus/im/bean/message/SearchImageInfo;", "moduleType", "", "targetWidth", "targetHeight", "index", "startMaskLoading", "maskView", "cancelMaskLoading", "adjustLayerUIV2Radius", "binding", "Lcom/larus/mainbot/impl/databinding/LarusMdImageGroupJoin6Binding;", "imagesCount", "isTopImageStyle", "adjustUIV2Radius", "radiusView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "isTRCorner", "isBRCorner", "goneViews", "", "bindImage", "imageView", "imageViewList", "relativeIndex", "mobModuleType", "onFail", "Lkotlin/Function0;", "onSuccess", "onStart", "preloadImage", "imageUrl", "commonInternal", "execute", "sizeThatFits", "preferredMaxWidth", "updateSize", "sizeData", "Lcom/larus/bmhome/chat/standarduikit/imagegroup/view/SizeData;", "calPaddingValues", "Lkotlin/Pair;", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageGroupView extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public ImageGroupView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public ImageGroupView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{0, 1300});
        r5.setDuration(1300);
        r5.setRepeatCount(-1);
        r5.setRepeatMode(1);
        new Size(0, 0);
        new Size(0, 0);
        new LinkedHashSet();
    }
}
