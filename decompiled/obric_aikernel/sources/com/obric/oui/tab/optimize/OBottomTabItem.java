package com.obric.oui.tab.optimize;

import android.R;
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
import androidx.core.content.ContextCompat;
import ea.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.c;
import u8.f;
import u8.h;
import u8.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001$B\u001d\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012¨\u0006%"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabItem;", "Landroid/widget/RelativeLayout;", "", "selected", "", "setSelected", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/graphics/drawable/Drawable;", "l", "Landroid/graphics/drawable/Drawable;", "getUnselectedIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setUnselectedIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "unselectedIconDrawable", "Landroid/widget/TextView;", "j", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "k", "getSelectedIconDrawable", "setSelectedIconDrawable", "selectedIconDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBottomTabItem extends RelativeLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7611c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f7612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ImageView f7614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextView f7615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f7616k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f7617l;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OBottomTabItem(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OBottomTabItem(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r10).inflate(h.o_tab_bottom_item, this, true);
        View r12 = findViewById(f.icon_container);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.icon_container)");
        FrameLayout r13 = (FrameLayout) r12;
        View r14 = findViewById(f.icon);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.icon)");
        this.f7614i = (ImageView) r14;
        View r15 = findViewById(f.title);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.title)");
        this.f7615j = (TextView) r15;
        int r16 = ContextCompat.getColor(getContext(), c.oui_accent_fg);
        this.f7612g = r16;
        int r17 = ContextCompat.getColor(getContext(), c.oui_text_3b);
        this.f7611c = r17;
        int r18 = ContextCompat.getColor(getContext(), c.oui_accent_bg_low_contrast);
        this.f7613h = r18;
        b(r16, r17, r18);
    }

    public /* synthetic */ OBottomTabItem(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    private final void a(boolean r10) {
        Drawable r11 = this.f7616k;
        if (r11 == null) goto L12;
        Drawable r12 = this.f7617l;
        if (r12 == null) goto L12;
        ImageView r13 = this.f7614i;
        if (r10 == false) goto L10;
        r13.setImageDrawable(r11);
        return;
    L10:
        r13.setImageDrawable(r12);
        return;
    L12:
        b.j("optimize.OBottomTabItem", "please set selectedIconDrawable and unselectedIconDrawable");
    }

    public static /* synthetic */ void c(OBottomTabItem r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = ContextCompat.getColor(r10.getContext(), c.oui_accent_fg);
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = ContextCompat.getColor(r10.getContext(), c.oui_text_3b);
    L9:
        if ((r14 & 4) == 0) goto L11;
        r13 = ContextCompat.getColor(r10.getContext(), c.oui_accent_bg_low_contrast);
    L11:
        r10.b(r11, r12, r13);
    }

    @JvmOverloads
    public final void b(int r10, int r11, int r12) {
        ColorStateList r13 = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{r10, r11});
        this.f7613h = r12;
        this.f7614i.setImageTintList(r13);
        this.f7615j.setTextColor(r13);
    }

    public final ImageView getIcon() {
        return this.f7614i;
    }

    public final Drawable getSelectedIconDrawable() {
        return this.f7616k;
    }

    public final TextView getTitle() {
        return this.f7615j;
    }

    public final Drawable getUnselectedIconDrawable() {
        return this.f7617l;
    }

    @JvmOverloads
    public final void setImageAndTextTintColor(int r10) {
        c(this, r10, 0, 0, 6, null);
    }

    @Override // android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        a(r10);
        TextView r11 = this.f7615j;
        if (r10 == false) goto L5;
        int r12 = k.Label_S_Thick;
    L6:
        r11.setTextAppearance(r12);
        return;
    L5:
        r12 = k.Label_S;
        goto L6
    }

    public final void setSelectedIconDrawable(Drawable r10) {
        this.f7616k = r10;
    }

    public final void setUnselectedIconDrawable(Drawable r10) {
        this.f7617l = r10;
    }
}
