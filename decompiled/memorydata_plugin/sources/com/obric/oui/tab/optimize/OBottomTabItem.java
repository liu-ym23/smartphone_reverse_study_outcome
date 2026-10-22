package com.obric.oui.tab.optimize;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J&\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\bH\u0007J\u0010\u0010'\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017¨\u0006)"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabItem;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defaultSelectTextColor", "", "defaultTextColor", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "iconContainer", "Landroid/widget/FrameLayout;", "selectBgColor", "selectedBg", "Landroid/graphics/drawable/Drawable;", "selectedIconDrawable", "getSelectedIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectedIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "unselectedIconDrawable", "getUnselectedIconDrawable", "setUnselectedIconDrawable", "refreshIconDrawableOnSelect", "", BuildConfig.FLAVOR, "", "setImageAndTextTintColor", "selectedColor", "unSelectedColor", "bgColor", "setSelected", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabItem extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14554a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f14555b;
    private final FrameLayout c;
    private final int d;
    private final int e;
    private int f;
    private final ImageView g;
    private final TextView h;
    private Drawable i;
    private Drawable j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabItem$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14554a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomTabItem(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OBottomTabItem(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setClickable(false);
        setFocusable(false);
        ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(R.layout.o_tab_bottom_item, "layout", "o_tab_bottom_item"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.icon_container, OaidModel.KEY_ID, "icon_container"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.icon_container)");
        this.c = (FrameLayout) ZeusTransformUtils.preCheckCast(r9, FrameLayout.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.icon)");
        this.g = (ImageView) ZeusTransformUtils.preCheckCast(r10, ImageView.class, "com.obric.memorydata.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.title)");
        this.h = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.memorydata.plugin");
        int r12 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_fg, TypedValues.Custom.S_COLOR, "oui_accent_fg"));
        this.e = r12;
        int r13 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_text_3b, TypedValues.Custom.S_COLOR, "oui_text_3b"));
        this.d = r13;
        int r0 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_bg_low_contrast, TypedValues.Custom.S_COLOR, "oui_accent_bg_low_contrast"));
        this.f = r0;
        a(r12, r13, r0);
    }

    public /* synthetic */ OBottomTabItem(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static /* synthetic */ void a(OBottomTabItem r3, int r4, int r5, int r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r4 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_fg, TypedValues.Custom.S_COLOR, "oui_accent_fg"));
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_text_3b, TypedValues.Custom.S_COLOR, "oui_text_3b"));
    L9:
        if ((r7 & 4) == 0) goto L11;
        r6 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_bg_low_contrast, TypedValues.Custom.S_COLOR, "oui_accent_bg_low_contrast"));
    L11:
        r3.a(r4, r5, r6);
    }

    private final void a(boolean r3) {
        Drawable r0 = this.i;
        if (r0 == null) goto L12;
        Drawable r1 = this.j;
        if (r1 == null) goto L12;
        ImageView r2 = this.g;
        if (r3 == false) goto L10;
        r2.setImageDrawable(r0);
        return;
    L10:
        r2.setImageDrawable(r1);
        return;
    L12:
        b.d("optimize.OBottomTabItem", "please set selectedIconDrawable and unselectedIconDrawable");
    }

    public final void a(int r8, int r9, int r10) {
        ColorStateList r0 = new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{r8, r9});
        this.f14555b = null;
        this.f = r10;
        this.g.setImageTintList(r0);
        this.h.setTextColor(r0);
    }

    public final ImageView getIcon() {
        return this.g;
    }

    public final Drawable getSelectedIconDrawable() {
        return this.i;
    }

    public final TextView getTitle() {
        return this.h;
    }

    public final Drawable getUnselectedIconDrawable() {
        return this.j;
    }

    public final void setImageAndTextTintColor(int r7) {
        a(this, r7, 0, 0, 6, null);
    }

    @Override // android.view.View
    public void setSelected(boolean r3) {
        super.setSelected(r3);
        a(r3);
        TextView r2 = this.h;
        if (r3 == false) goto L5;
        int r4 = R.style.Label_S_Thick;
        String r1 = "Label_S_Thick";
    L6:
        r2.setTextAppearance(ZeusTransformUtils.mapRes(r4, "style", r1));
        return;
    L5:
        r4 = R.style.Label_S;
        r1 = "Label_S";
        goto L6
    }

    public final void setSelectedIconDrawable(Drawable r1) {
        this.i = r1;
    }

    public final void setUnselectedIconDrawable(Drawable r1) {
        this.j = r1;
    }
}
