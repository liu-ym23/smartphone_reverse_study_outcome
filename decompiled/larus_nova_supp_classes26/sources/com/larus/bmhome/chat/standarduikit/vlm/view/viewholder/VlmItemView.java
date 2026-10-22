package com.larus.bmhome.chat.standarduikit.vlm.view.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ao8.e;
import co8.b;
import co8.c;
import co8.d;
import co8.i;
import co8.j;
import co8.k;
import co8.m;
import co8.n;
import co8.o;
import co8.p;
import co8.q;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.vlm.RenderType;
import com.larus.bmhome.chat.standarduikit.vlm.view.l;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.common_ui.widget.shimmer.ShimmerMaskView;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusVlmImageItemViewMergeBinding;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 N2\u00020\u0001:\u0001NB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ³\u0001\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00112:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110;¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u000202\u0018\u0001082\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010>2:\b\u0002\u0010?\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110;¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(@\u0012\u0004\u0012\u000202\u0018\u000108¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u0002022\u0006\u0010C\u001a\u000205H\u0002J!\u0010D\u001a\u0002022\u0006\u0010C\u001a\u0002052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010EJ\u0010\u0010F\u001a\u0002022\u0006\u0010C\u001a\u000205H\u0002J\u0010\u0010G\u001a\u0002022\u0006\u0010C\u001a\u000205H\u0003J\u0010\u0010H\u001a\u0002022\u0006\u0010C\u001a\u000205H\u0002J\u0010\u0010I\u001a\u0002022\u0006\u0010C\u001a\u000205H\u0002J^\u0010J\u001a\u0002022\u0006\u00103\u001a\u00020\u00072:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110;¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u000202\u0018\u0001082\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010>H\u0002J:\u0010K\u001a\u0002022\b\u0010L\u001a\u0004\u0018\u0001052\b\b\u0002\u0010M\u001a\u00020\u00072\u001c\b\u0002\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u000202\u0018\u000108H\u0002R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b \u0010\u0018R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000f\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u000f\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u000f\u001a\u0004\b.\u0010/¨\u0006O"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/vlm/view/viewholder/VlmItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusVlmImageItemViewMergeBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusVlmImageItemViewMergeBinding;", "binding$delegate", "Lkotlin/Lazy;", "enableNewStyle", "", "getEnableNewStyle", "()Z", "enableNewStyle$delegate", "sourceView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getSourceView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "sourceView$delegate", "moreImageSize", "Lcom/larus/common_ui/widget/roundlayout/RoundTextView;", "getMoreImageSize", "()Lcom/larus/common_ui/widget/roundlayout/RoundTextView;", "moreImageSize$delegate", "mainImage", "getMainImage", "mainImage$delegate", "maskView", "Lcom/larus/common_ui/widget/shimmer/ShimmerMaskView;", "getMaskView", "()Lcom/larus/common_ui/widget/shimmer/ShimmerMaskView;", "maskView$delegate", "descriptionTitle", "Landroid/widget/TextView;", "getDescriptionTitle", "()Landroid/widget/TextView;", "descriptionTitle$delegate", "videoIcon", "Landroid/view/View;", "getVideoIcon", "()Landroid/view/View;", "videoIcon$delegate", "bindView", "", "position", "vlmRenderInfo", "Lcom/larus/bmhome/chat/standarduikit/vlm/view/VlmRenderInfo;", "enableShimmer", "onClickCard", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/util/Size;", "size", "onLongClickCard", "Lkotlin/Function0;", "onMobCardShow", "itemSize", "(ILcom/larus/bmhome/chat/standarduikit/vlm/view/VlmRenderInfo;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "setupVideoIcon", "vlmVlmRenderInfo", "setupLoadMainImage", "(Lcom/larus/bmhome/chat/standarduikit/vlm/view/VlmRenderInfo;Ljava/lang/Boolean;)V", "setupSourceImage", "setupMoreImageIcon", "setupVideoCaptionView", "setupLayout", "setupLayoutClick", "setupCardShow", "imageItem", "index", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VlmItemView extends ConstraintLayout {
    public static final /* synthetic */ int i = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public VlmItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VlmItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LarusVlmImageItemViewMergeBinding getBinding() {
        return (LarusVlmImageItemViewMergeBinding) this.a.getValue();
    }

    private final TextView getDescriptionTitle() {
        return (TextView) this.g.getValue();
    }

    private final boolean getEnableNewStyle() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    private final SimpleDraweeView getMainImage() {
        return (SimpleDraweeView) this.e.getValue();
    }

    private final ShimmerMaskView getMaskView() {
        return (ShimmerMaskView) this.f.getValue();
    }

    private final RoundTextView getMoreImageSize() {
        return (RoundTextView) this.d.getValue();
    }

    private final SimpleDraweeView getSourceView() {
        return (SimpleDraweeView) this.c.getValue();
    }

    private final View getVideoIcon() {
        return (View) this.h.getValue();
    }

    public static View S5(VlmItemView r0) {
        return r0.getBinding().g;
    }

    public static SimpleDraweeView T5(VlmItemView r0) {
        return r0.getBinding().b;
    }

    public static ShimmerMaskView U5(VlmItemView r0) {
        return r0.getBinding().c;
    }

    public static TextView V5(VlmItemView r0) {
        return r0.getBinding().f;
    }

    public static SimpleDraweeView Y5(VlmItemView r0) {
        return r0.getBinding().e;
    }

    public static RoundTextView k6(VlmItemView r0) {
        return r0.getBinding().d;
    }

    private final void setupLayout(l r5) {
        e1.x(getBinding().a);
        View r0 = getBinding().a;
        Size r2 = r5.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.getWidth();
    L6:
        Size r6 = r5.c;
        if (r6 == null) goto L9;
        r3 = r6.getHeight();
    L9:
        r0.setLayoutParams(new ViewGroup.LayoutParams(r4, r3));
        return;
    L5:
        r4 = 0;
        goto L6
    }

    private final void setupMoreImageIcon(l r4) {
        Integer r0 = r4.e;
        if (r0 != null) goto L5;
    L9:
        e1.o(getMoreImageSize());
        return;
    L5:
        if (r0.intValue() <= 0) goto L9;
        e1.x(getMoreImageSize());
        getMoreImageSize().setText("+" + r4.e);
    }

    private final void setupSourceImage(l r8) {
        String r0 = r8.f;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        e1.o(getSourceView());
        return;
    L12:
        e1.x(getSourceView());
        e.c(getSourceView(), r8, r8.f, null, null, null);
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void setupVideoCaptionView(l r2) {
        String r0 = r2.d;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        e1.o(getDescriptionTitle());
        return;
    L12:
        e1.x(getDescriptionTitle());
        getDescriptionTitle().setText(r2.d);
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void setupVideoIcon(l r2) {
        if (r2.h != RenderType.Picture) goto L6;
        e1.o(getVideoIcon());
        return;
    L6:
        e1.x(getVideoIcon());
    }

    public static Unit Z5(Boolean r1, VlmItemView r2) {
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L6;
        r2.getMaskView().a();
    L6:
        return Unit.INSTANCE;
    }

    public static Unit b6(Boolean r1, VlmItemView r2) {
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L6;
        r2.getMaskView().c();
    L6:
        return Unit.INSTANCE;
    }

    public static Unit i6(Boolean r1, VlmItemView r2) {
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L6;
        r2.getMaskView().a();
    L6:
        return Unit.INSTANCE;
    }

    public VlmItemView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new co8.l(r2, this));
        this.b = LazyKt.lazy(new m());
        this.c = LazyKt.lazy(new n(this));
        this.d = LazyKt.lazy(new o(this));
        this.e = LazyKt.lazy(new p(this));
        this.f = LazyKt.lazy(new q(this));
        this.g = LazyKt.lazy(new b(this));
        this.h = LazyKt.lazy(new c(this));
    }

    public static void c6(Function2 r2, int r3, VlmItemView r4) {
        if (r2 == null) goto L5;
        r2.invoke(Integer.valueOf(r3), new Size(r4.getMainImage().getWidth(), r4.getMainImage().getHeight()));
        return;
    }

    public /* synthetic */ VlmItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static Unit R5(Function2 r1, int r2, VlmItemView r3, View r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r1 == null) goto L6;
        r1.invoke(Integer.valueOf(r2), new Size(r3.getMainImage().getWidth(), r3.getMainImage().getHeight()));
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n6(final int r8, final l r9, final Boolean r10, final Function2<? super Integer, ? super Size, Unit> r11, final Function0<Boolean> r12, final Function2<? super Integer, ? super Size, Unit> r13) {
        if (r9 != null) goto L5;
        e1.o(getBinding().a);
        return;
    L5:
        setupLayout(r9);
        if (getEnableNewStyle() == false) goto L8;
    L9:
        GenericDraweeHierarchy r0 = getMainImage().getHierarchy();
        RoundingParams r1 = r0.getRoundingParams();
        if (r1 != null) goto L12;
        r1 = new RoundingParams();
    L12:
        r1.setCornersRadius(c7.a(v19.c.b(2130971480, null, 2131167331)));
        r0.setRoundingParams(r1);
    L13:
        String r2 = r9.g;
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        e.c(getMainImage(), r9, r2, new i(r10, this), new j(r10, this), new k(r10, this));
        setupSourceImage(r9);
        setupMoreImageIcon(r9);
        setupVideoCaptionView(r9);
        setupVideoIcon(r9);
        e1.d(getRootView(), new d(r11, r8, this));
        getRootView().setOnLongClickListener(new co8.e(r12));
        ExposureTrackerExtKt.a(getMainImage(), new co8.a(this, r9, r13, r8));
        return;
    L8:
        if (r9.k == false) goto L13;
        goto L9
    }
}
