package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import u8.d;
import u8.f;
import u8.h;
import u8.l;
import u9.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u00100\u001a\u0004\u0018\u00010\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00067"}, d2 = {"Lcom/obric/oui/lisitem/OListItemSettings;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "", "text", "", "setTrailingText", "", "minWidth", "setTrailingViewMinWidth", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "", "enabled", "setListItemSettingsEnabled", "getContentDefaultOneChildWidth", "Lcom/obric/oui/lisitem/ListItemHeightMode;", "mode", "setListItemHeightMode", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "A", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "settingsTrailingView", "Lcom/obric/oui/layout/OUIFrameLayout;", "C", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentImgBackground", "Landroid/widget/FrameLayout;", "B", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "mTitleInfo", EventBody.KEY_VALUE, "D", "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "trailingTextString", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OListItemSettings extends OListItemGeneral {
    private final SettingsTrailingView A;
    public FrameLayout B;
    public OUIFrameLayout C;
    private String D;
    private int E;
    private ListItemHeightMode F;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final ViewGroup f6903z;

    public OListItemSettings(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.E = r10.getResources().getDimensionPixelSize(d.oui_listitem_content_width_large);
        this.F = ListItemHeightMode.DEFAULT;
        View r12 = findViewById(f.ll_root);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.ll_root)");
        this.f6903z = (ViewGroup) r12;
        this.A = new SettingsTrailingView(r10, null, 0, 6, null);
        View r13 = findViewById(f.title_info);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.title_info)");
        this.B = (FrameLayout) r13;
        View r14 = findViewById(f.iv_content_img_background);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.iv_content_img_background)");
        this.C = (OUIFrameLayout) r14;
        TypedArray r15 = r10.obtainStyledAttributes(r11, l.OListItemGeneral);
        setTrailingTextString(r15.getString(l.OListItemGeneral_oui_list_item_trailing_text));
        r15.recycle();
        if (getContentImage() == null) goto L9;
        OUIFrameLayout r16 = this.C;
        if (r16 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
    L7:
        r16.setVisibility(0);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void d() {
        LayoutInflater.from(getContext()).inflate(h.o_listitem_settings, this);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return this.E;
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r10 = this.C;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
    L5:
        return r10;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r10 = this.B;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleInfo");
    L5:
        return r10;
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.A;
    }

    public final String getTrailingTextString() {
        return this.D;
    }

    public final void setContentImgBackground(OUIFrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.C = r10;
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(Drawable r10) {
        this.A.setTrailingImage(r10);
    }

    public final void setListItemHeightMode(ListItemHeightMode r10) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        if (this.F != r10) goto L5;
        return;
    L5:
        int r11 = b.f13145a[r10.ordinal()];
        if (r11 != 1) goto L8;
        Resources r12 = getResources();
        int r13 = d.oui_listitem_content_width_large;
    L13:
        int r14 = r12.getDimensionPixelSize(r13);
        this.f6903z.setMinimumHeight(r14);
        getMClContent().setMinimumHeight(r14);
        getMClContent().setMinHeight(r14);
        ViewGroup.LayoutParams r15 = getMTrailingElement().getLayoutParams();
        if (r15 != null) goto L16;
    L20:
        this.E = r14;
        i();
        this.F = r10;
        return;
    L16:
        if ((r15 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        int r16 = (r14 - getMClContent().getPaddingTop()) - getMClContent().getPaddingBottom();
        ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) r15;
        if (r16 >= r17.matchConstraintMinHeight) goto L20;
        FrameLayout r18 = getMTrailingElement();
        r17.matchConstraintMinHeight = r16;
        Unit r19 = Unit.INSTANCE;
        r18.setLayoutParams(r15);
        goto L20
    L8:
        if (r11 != 2) goto L11;
        r12 = getResources();
        r13 = d.oui_listitem_content_width_middle;
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void setListItemSettingsEnabled(boolean r10) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r10);
        if (r10 == false) goto L5;
        FrameLayout r11 = getMLeadingElement();
        float r12 = 1.0f;
    L6:
        r11.setAlpha(r12);
        getMClContent().setAlpha(r12);
        getMContentElement().setAlpha(r12);
        return;
    L5:
        r11 = getMLeadingElement();
        r12 = 0.3f;
        goto L6
    }

    public final void setMTitleInfo(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.B = r10;
    }

    public final void setTrailingText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        this.A.setTrailingText(r10);
    }

    public final void setTrailingTextString(String r10) {
        this.D = r10;
        i();
        String r11 = this.D;
        if (r11 == null) goto L5;
        setTrailingText(r11);
    L5:
        setTrailingView(this.A);
    }

    public final void setTrailingViewMinWidth(int r10) {
        ViewGroup.LayoutParams r11 = getMTrailingElement().getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        FrameLayout r12 = getMTrailingElement();
        ((ConstraintLayout.LayoutParams) r11).matchConstraintMinWidth = r10;
        Unit r13 = Unit.INSTANCE;
        r12.setLayoutParams(r11);
        return;
    }
}
