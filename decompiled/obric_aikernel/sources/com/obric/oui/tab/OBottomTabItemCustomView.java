package com.obric.oui.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.crash.entity.EventBody;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.c;
import u8.d;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "使用 optimize 包下的 OBottomTabItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R.\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R4\u0010$\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001b8\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/obric/oui/tab/OBottomTabItemCustomView;", "Landroid/widget/RelativeLayout;", "", "selected", "", "setSelected", "Landroid/widget/ImageView;", "h", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "Landroid/content/res/ColorStateList;", EventBody.KEY_VALUE, "j", "Landroid/content/res/ColorStateList;", "getTextColor", "()Landroid/content/res/ColorStateList;", "setTextColor", "(Landroid/content/res/ColorStateList;)V", "textColor", "", "k", "Ljava/lang/Integer;", "getSelectedBgColor", "()Ljava/lang/Integer;", "setSelectedBgColor", "(Ljava/lang/Integer;)V", "getSelectedBgColor$annotations", "()V", "selectedBgColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBottomTabItemCustomView extends RelativeLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7504c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f7505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageView f7506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextView f7507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f7508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Integer f7509k;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OBottomTabItemCustomView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OBottomTabItemCustomView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r10).inflate(h.o_tab_bottom_item, this, true);
        View r12 = findViewById(f.icon_container);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.icon_container)");
        FrameLayout r13 = (FrameLayout) r12;
        View r14 = findViewById(f.icon);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.icon)");
        this.f7506h = (ImageView) r14;
        View r15 = findViewById(f.title);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.title)");
        this.f7507i = (TextView) r15;
        this.f7504c = ContextCompat.getColor(getContext(), c.oui_text_3);
        this.f7505g = ContextCompat.getColor(getContext(), c.oui_accent_fg);
    }

    public /* synthetic */ OBottomTabItemCustomView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ int[] a() {
        return RelativeLayout.SELECTED_STATE_SET;
    }

    @Deprecated(message = "2024.11.4 最新的设计规范移除了选中状态的背景色")
    public static /* synthetic */ void getSelectedBgColor$annotations() {
    }

    public final ImageView getIcon() {
        return this.f7506h;
    }

    public final Integer getSelectedBgColor() {
        return this.f7509k;
    }

    public final ColorStateList getTextColor() {
        return this.f7508j;
    }

    public final TextView getTitle() {
        return this.f7507i;
    }

    @Override // android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        if (r10 == false) goto L11;
        ColorStateList r11 = this.f7508j;
        if (r11 == null) goto L7;
        int r12 = r11.getColorForState(a(), this.f7505g);
    L8:
        this.f7507i.setTextColor(r12);
        if (this.f7506h.getDrawable() == null) goto L19;
    L17:
        ImageView r13 = this.f7506h;
        Drawable r14 = DrawableCompat.wrap(r13.getDrawable());
        r14.setTint(r12);
        Unit r15 = Unit.INSTANCE;
        r13.setImageDrawable(r14);
        return;
    L19:
        return;
    L7:
        r12 = this.f7505g;
        goto L8
    L11:
        ColorStateList r16 = this.f7508j;
        if (r16 == null) goto L14;
        r12 = r16.getDefaultColor();
    L15:
        this.f7507i.setTextColor(r12);
        if (this.f7506h.getDrawable() != null) goto L17;
        return;
    L14:
        r12 = this.f7504c;
        goto L15
    }

    public final void setSelectedBgColor(Integer r10) {
        this.f7509k = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        GradientDrawable r11 = new GradientDrawable();
        r11.setShape(0);
        r11.setCornerRadius(getResources().getDimension(d.oui_r_m1));
        r11.setColor(r10.intValue());
        Unit r12 = Unit.INSTANCE;
    }

    public final void setTextColor(ColorStateList r10) {
        this.f7508j = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        this.f7507i.setTextColor(r10.getDefaultColor());
        if (this.f7506h.getDrawable() == null) goto L9;
        ImageView r11 = this.f7506h;
        Drawable r12 = DrawableCompat.wrap(r11.getDrawable());
        r12.setTint(r10.getDefaultColor());
        Unit r13 = Unit.INSTANCE;
        r11.setImageDrawable(r12);
        return;
    }
}
