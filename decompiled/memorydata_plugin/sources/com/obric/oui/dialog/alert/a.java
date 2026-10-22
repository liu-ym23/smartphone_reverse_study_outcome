package com.obric.oui.dialog.alert;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 /2\u00020\u0001:\u0003/01B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u0013H\u0002J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\nJ\u0010\u0010#\u001a\u00020\u00182\b\b\u0001\u0010$\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000fJ\u000e\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\fJ\u000e\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0013J\u001f\u0010+\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u00062"}, d2 = {"Lcom/obric/oui/dialog/alert/ImageStyleController;", "Lcom/obric/oui/dialog/alert/StyleController;", "context", "Landroid/content/Context;", "style", "", "(Landroid/content/Context;I)V", "height", "Ljava/lang/Integer;", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconImageLoadDelegate", "Lcom/obric/oui/dialog/alert/view/IOImageLoadDelegate;", "iconRes", "iconUrl", "", "ignoreFixRatio", "", "imageView", "Landroid/view/View;", "topImageLoader", "Lcom/obric/oui/dialog/alert/OAlertDialogBuilder$IImageLoader;", "width", "attachBanner", "", "parent", "Landroid/widget/FrameLayout;", "attachIcon", "attachToDialog", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "attachToParent", "createImageView", "setImageDrawable", "drawable", "setImageResource", "res", "setImageUrl", "url", "setImageUrlLoadDelegate", "delegate", "setImageView", "view", "setSize", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setTopImageLoader", "loader", "Companion", "FixRatioLayout", "ImageStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0746a f13792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13793b;
    private final int c;
    private Drawable d;
    private String e;
    private com.obric.oui.dialog.alert.view.a f;
    private c.a g;
    private Integer h;
    private Integer i;
    private boolean j;
    private int k;
    private View l;

    /* JADX INFO: renamed from: com.obric.oui.dialog.alert.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/alert/ImageStyleController$Companion;", "", "()V", "BANNER", "", "ICON", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0746a {
        private C0746a() {
        }

        public /* synthetic */ C0746a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/alert/ImageStyleController$FixRatioLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        f13792a = new C0746a(null);
    }

    public a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f13793b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
    }

    private final View a() {
        View r0 = this.l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ImageView r1 = new ImageView(this.f13793b);
        r1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r2 = this.d;
        int r3 = this.k;
        String r4 = this.e;
        c.a r5 = this.g;
        if (r5 == null) goto L10;
        if (r5 == null) goto L27;
        r5.a(r1);
    L27:
        return (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
    L10:
        if (r2 == null) goto L12;
        r1.setImageDrawable(r2);
        goto L27
    L12:
        if (r3 == 0) goto L14;
        r1.setImageResource(r3);
        goto L27
    L14:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L27;
        com.obric.oui.dialog.alert.view.a r8 = this.f;
        if (r8 == null) goto L27;
        r8.a(r1, r4);
        goto L27
    L17:
        if (r6.length() == 0) goto L20;
        r7 = false;
        goto L21
    }

    private final void b(Context r6, FrameLayout r7) {
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
        r0.topMargin = h.a(r8, 28);
        r7.addView(a(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r4 = -2;
        goto L6
    }

    private final void c(Context r6, FrameLayout r7) {
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

    @Override // com.obric.oui.dialog.alert.e
    public void a(Context r3, FrameLayout r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (this.c != 0) goto L5;
        b(r5, r4);
        return;
    L5:
        c(r5, r4);
    }

    public final void a(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.d = r2;
    }

    @Override // com.obric.oui.dialog.alert.e
    public void a(com.obric.oui.dialog.alert.b r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
    }

    public final void a(c.a r3) {
        c.a r4 = (c.a) ZeusTransformUtils.wrapperContextForParams(r3, c.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "loader");
        this.g = r4;
    }

    public final void a(com.obric.oui.dialog.alert.view.a r3) {
        com.obric.oui.dialog.alert.view.a r4 = (com.obric.oui.dialog.alert.view.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.alert.view.a.class, "com.obric.memorydata.plugin");
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
}
