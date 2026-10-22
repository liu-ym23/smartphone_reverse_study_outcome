package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.oui.common.util.h;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.image.OImageAppIcon;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 62\u00020\u0001:\u0003678B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0002J\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\nJ\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\fJ\u0010\u0010*\u001a\u00020\u001a2\b\b\u0001\u0010+\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0012J\u000e\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u000eJ\u000e\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u0015J\u001f\u00102\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00103J\u000e\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u00069"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ImageStyleController;", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "context", "Landroid/content/Context;", "style", "", "(Landroid/content/Context;I)V", "height", "Ljava/lang/Integer;", "iconClipToMask", "", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconImageLoadDelegate", "Lcom/obric/oui/dialog/v2/common/IOImageLoadDelegate;", "iconRes", "iconStrokeEnabled", "iconUrl", "", "ignoreFixRatio", "imageView", "Landroid/view/View;", "topImageLoader", "Lcom/obric/oui/dialog/v2/common/IImageLoader;", "width", "attachBanner", "", "parent", "Landroid/widget/FrameLayout;", "attachIcon", "attachToHost", "host", "Lcom/obric/oui/dialog/v2/alert/style/AlertDialogHost;", "attachToParent", "dialogContainer", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "createImageView", "setIconClipToMask", "enabled", "setIconStrokeEnabled", "setImageDrawable", "drawable", "setImageResource", "res", "setImageUrl", "url", "setImageUrlLoadDelegate", "delegate", "setImageView", "view", "setSize", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setTopImageLoader", "loader", "Companion", "FixRatioLayout", "ImageStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13825a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13826b;
    private final int c;
    private Drawable d;
    private String e;
    private com.obric.oui.dialog.v2.common.b f;
    private com.obric.oui.dialog.v2.common.a g;
    private Integer h;
    private Integer i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private View n;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ImageStyleController$Companion;", "", "()V", "BANNER", "", "ICON", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ImageStyleController$FixRatioLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends FrameLayout {
        public b(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "context");
            super(r4);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r2, int r3) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r2) / 2, 1073741824));
        }
    }

    static {
        f13825a = new a(null);
    }

    public e(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f13826b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
    }

    private final View a() {
        View r0 = this.n;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.c == 0) goto L8;
    L10:
        ImageView r1 = new ImageView(this.f13826b);
    L11:
        r1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r2 = this.d;
        int r3 = this.m;
        String r4 = this.e;
        com.obric.oui.dialog.v2.common.a r5 = this.g;
        if (r5 == null) goto L16;
        if (r5 == null) goto L33;
        r5.a(r1);
    L33:
        return (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
    L16:
        if (r2 == null) goto L18;
        r1.setImageDrawable(r2);
        goto L33
    L18:
        if (r3 == 0) goto L20;
        r1.setImageResource(r3);
        goto L33
    L20:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L23;
    L26:
        boolean r7 = true;
    L27:
        if (r7 == true) goto L33;
        com.obric.oui.dialog.v2.common.b r8 = this.f;
        if (r8 == null) goto L33;
        r8.a(r1, r4);
        goto L33
    L23:
        if (r6.length() == 0) goto L26;
        r7 = false;
        goto L27
    L8:
        if (this.k == false) goto L10;
        OImageAppIcon r9 = new OImageAppIcon(this.f13826b, null, 0, 6, null);
        r9.setClipToMask(this.l);
        r1 = (ImageView) ZeusTransformUtils.preCheckCast(r9, ImageView.class, "com.obric.memorydata.plugin");
        goto L11
    }

    private final void a(Context r6, FrameLayout r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Integer r2 = this.i;
        int r3 = -2;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNull(r2);
        int r4 = r2.intValue();
    L6:
        Integer r5 = this.h;
        if (r5 == null) goto L9;
        Intrinsics.checkNotNull(r5);
        r3 = r5.intValue();
    L9:
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r4, r3);
        r0.gravity = 1;
        r0.topMargin = h.a(r8, 4);
        r0.bottomMargin = h.a(r8, 16);
        r7.addView(a(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r4 = -2;
        goto L6
    }

    private final void b(Context r6, FrameLayout r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Integer r2 = this.i;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNull(r2);
        int r3 = r2.intValue();
    L6:
        Integer r4 = this.h;
        if (r4 == null) goto L9;
        Intrinsics.checkNotNull(r4);
        int r5 = r4.intValue();
    L10:
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r3, r5);
        if (this.j == false) goto L13;
        FrameLayout r9 = new FrameLayout(r8);
    L14:
        r9.addView(a(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r7.addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(new b(r8), FrameLayout.class, "com.obric.memorydata.plugin");
        goto L14
    L9:
        r5 = -2;
        goto L10
    L5:
        r3 = -1;
        goto L6
    }

    @Override // com.obric.oui.dialog.v2.alert.style.g
    public void a(Context r3, d r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "dialogContainer");
        int r0 = this.c;
        if (r0 != 0) goto L5;
        FrameLayout r7 = r6.getIconSlot();
    L10:
        r7.setVisibility(0);
        if (this.c != 0) goto L13;
        a(r5, r7);
        return;
    L13:
        b(r5, r7);
        return;
    L5:
        if (r0 != 1) goto L8;
        r7 = r6.getBannerSlot();
        goto L10
    L8:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported style: ", Integer.valueOf(this.c)));
    }

    public final void a(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.d = r2;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.g
    public void a(AbstractDialog r3) {
        g.a.a((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.g
    public void a(com.obric.oui.dialog.v2.alert.style.b r3) {
        com.obric.oui.dialog.v2.alert.style.b r4 = (com.obric.oui.dialog.v2.alert.style.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.v2.alert.style.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "host");
        g.a.a((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void a(com.obric.oui.dialog.v2.common.a r3) {
        com.obric.oui.dialog.v2.common.a r4 = (com.obric.oui.dialog.v2.common.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.v2.common.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "loader");
        this.g = r4;
    }

    public final void a(com.obric.oui.dialog.v2.common.b r3) {
        com.obric.oui.dialog.v2.common.b r4 = (com.obric.oui.dialog.v2.common.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.v2.common.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        this.f = r4;
    }

    public final void a(Integer r1, Integer r2) {
        this.i = r1;
        this.h = r2;
        this.j = true;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.e = r2;
    }

    public final void a(boolean r1) {
        this.k = r1;
    }

    public final void b(boolean r1) {
        this.l = r1;
    }
}
