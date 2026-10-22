package com.obric.oui.lisitem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.e;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/obric/oui/lisitem/SettingsTrailingView;", "Landroid/widget/LinearLayout;", "", "text", "", "setTrailingText", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImage", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Landroid/widget/ImageView;", "g", "Landroid/widget/ImageView;", "getIconImageView", "()Landroid/widget/ImageView;", "setIconImageView", "(Landroid/widget/ImageView;)V", "iconImageView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingsTrailingView extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f6905c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f6906g;

    @JvmOverloads
    public SettingsTrailingView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public SettingsTrailingView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public SettingsTrailingView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        View r13 = LayoutInflater.from(r10).inflate(h.o_settings_trailing_view_2, this, false);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-1, -2);
        r14.gravity = 8388629;
        addView(r13, r14);
        View r15 = findViewById(f.trailingText);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.trailingText)");
        this.f6905c = (TextView) r15;
        View r16 = findViewById(f.trailingImage);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.trailingImage)");
        ImageView r17 = (ImageView) r16;
        this.f6906g = r17;
        r17.setImageDrawable(r10.getDrawable(e.ic_arrow_forward_list_item));
    }

    public /* synthetic */ SettingsTrailingView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final ImageView getIconImageView() {
        return this.f6906g;
    }

    public final TextView getTextView() {
        return this.f6905c;
    }

    public final void setIconImageView(ImageView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6906g = r10;
    }

    public final void setTextView(TextView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6905c = r10;
    }

    public final void setTrailingImage(Drawable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f6906g.setImageDrawable(r10);
    }

    public final void setTrailingText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        this.f6905c.setText(r10);
    }
}
