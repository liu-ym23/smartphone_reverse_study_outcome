package com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 R2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001RB\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0017\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0002JL\u0010%\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020 2\b\b\u0002\u0010-\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020\u0016H\u0002J\u0018\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J6\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\u001b2\b\b\u0002\u0010:\u001a\u00020\u001b2\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010<H\u0002J\u0084\u0001\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u0002082\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000f0<2\u0006\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020*2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010C2\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010C2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010CH\u0002J\u0012\u0010F\u001a\u00020\u00162\b\u0010G\u001a\u0004\u0018\u00010*H\u0002J\u0016\u0010H\u001a\u00020\u00162\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00160CH\u0002J\u001a\u0010J\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010K\u001a\u00020 H\u0016J\u0010\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020NH\u0002J$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0P2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0006\u0010Q\u001a\u00020\u0016R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/imagegroup/legacy/view/ImageGroupLegacyView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/imagegroup/legacy/view/ImageGroupLegacyInput;", "Lcom/larus/bmhome/chat/standarduikit/imagegroup/legacy/view/ImageGroupLegacyOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "timingAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "currInflateView", "Landroid/view/View;", "widgetSize", "Landroid/util/Size;", "spanSize", "exposeImages", "", "bindData", "", "input", "output", "updateContainer", "isHead", "", "isTail", "updateUI", "useNewStyle", "currShowType", "", "(Ljava/lang/Integer;)Z", "handleMultiLayerUIV2", "updateLayerUI", "updateMultiLayerUIV2", "mobCardShow", "image", "imageItem", "Lcom/larus/im/bean/message/SearchImageInfo;", "moduleType", "", "targetWidth", "targetHeight", "index", "startMaskLoading", "maskView", "cancelMaskLoading", "adjustLayerUIV2Radius", "binding", "Lcom/larus/mainbot/impl/databinding/LarusMdImageGroupJoin6Binding;", "imagesData", "Lcom/larus/bmhome/chat/standarduikit/imagegroup/legacy/view/ImagesData;", "adjustUIV2Radius", "radiusView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "isTRCorner", "isBRCorner", "goneViews", "", "bindImage", "imageView", "imageViewList", "relativeIndex", "mobModuleType", "onFail", "Lkotlin/Function0;", "onSuccess", "onStart", "preloadImage", "imageUrl", "commonInternal", "execute", "sizeThatFits", "preferredMaxWidth", "updateSize", "sizeData", "Lcom/larus/bmhome/chat/standarduikit/imagegroup/legacy/view/SizeData;", "calPaddingValues", "Lkotlin/Pair;", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageGroupLegacyView extends FrameLayout {
    public static final /* synthetic */ int e = 0;
    public final ValueAnimator a;
    public Size b;
    public Size c;
    public final Set<View> d;

    public static final class a {
    }

    static {
    }

    public ImageGroupLegacyView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void d(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        post(new i(r3));
        return;
    L5:
        r3.invoke();
    }

    public ImageGroupLegacyView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{0, 1300});
        r5.setDuration(1300);
        r5.setRepeatCount(-1);
        r5.setRepeatMode(1);
        this.a = r5;
        this.b = new Size(0, 0);
        this.c = new Size(0, 0);
        this.d = new LinkedHashSet();
    }

    public static Pair c(boolean r0, boolean r1) {
        if (r0 == true) goto L8;
        if (r1 == false) goto L7;
        return TuplesKt.to(Integer.valueOf(i5.q()), Integer.valueOf(i5.Y()));
    L7:
        return TuplesKt.to(Integer.valueOf(i5.q()), Integer.valueOf(i5.r0()));
    L8:
        return TuplesKt.to(Integer.valueOf(i5.Y()), Integer.valueOf(i5.q()));
    }

    public static void a(ImageGroupLegacyView r3, SimpleDraweeView r4, List r5, int r6) {
        boolean r0 = true;
        if ((r6 & 2) == 0) goto L5;
        boolean r7 = true;
    L7:
        if ((r6 & 4) != 0) goto L11;
        r0 = false;
    L11:
        if ((r6 & 8) == 0) goto L13;
        r5 = null;
    L13:
        GenericDraweeHierarchy r8 = r4.getHierarchy();
        if (r7 == false) goto L16;
        float r9 = i5.r0();
    L17:
        if (r0 == false) goto L19;
        float r1 = i5.r0();
    L20:
        r8.setRoundingParams(RoundingParams.fromCornersRadii(0.0f, r9, r1, 0.0f));
        if (r5 == null) goto L26;
        Iterator r10 = r5.iterator();
    L24:
        if (r10.hasNext() == false) goto L28;
        e1.o((View) r10.next());
        goto L24
    L28:
        return;
    L26:
        return;
    L19:
        r1 = 0.0f;
        goto L20
    L16:
        r9 = 0.0f;
        goto L17
    L5:
        r7 = false;
        goto L7
    }

    public final void b(SimpleDraweeView r23, final List<? extends View> r24, final int r25, final int r26, final com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.a r27, final b r28, final int r29, final String r30, final Function0<Unit> r31, final Function0<Unit> r32, final Function0<Unit> r33) {
        final SearchImageInfo r15 = (SearchImageInfo) CollectionsKt.getOrNull(r27.b.a, r29);
        if (r15 != null) goto L5;
        return;
    L5:
        final String r6 = UUID.randomUUID().toString();
        String r0 = r15.getOriginThumbUrl();
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ImageGroupLegacyView$preloadImage$1(r0, null), 2, null);
        MessageImageLoader r7 = MessageImageLoader.a;
        String r8 = r27.c.a;
        MessageImageType r9 = MessageImageType.IMAGE;
        String r1 = r15.getThumbUrl();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r7.a(r8, r9, r23, r1, "markdown.image_group_cover_thumb", Integer.valueOf(r25), Integer.valueOf(r26), new p(r6, r15, r27, r29, r32), new q(r27, r6, r33), new r(r6, r27, r15, r29, r31), true);
        e1.d(r23, new s(r15, this, r28, r24, r25, r26, r29, r30, r27));
        r23.setOnLongClickListener(new t(r28));
    }
}
