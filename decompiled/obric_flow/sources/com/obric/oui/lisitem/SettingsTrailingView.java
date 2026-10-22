package com.obric.oui.lisitem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/obric/oui/lisitem/SettingsTrailingView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", MessageIndication.CONTENT_TYPE_TEXT, "", "setTrailingText", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImage", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getIconImageView", "()Landroid/widget/ImageView;", "setIconImageView", "(Landroid/widget/ImageView;)V", "iconImageView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SettingsTrailingView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f13596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f13597b;

    @JvmOverloads
    public SettingsTrailingView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final ImageView getIconImageView() {
        return this.f13597b;
    }

    public final TextView getTextView() {
        return this.f13596a;
    }

    public final void setIconImageView(ImageView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13597b = r5;
    }

    public final void setTextView(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13596a = r5;
    }

    public final void setTrailingImage(Drawable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.f13597b.setImageDrawable(r5);
    }

    public final void setTrailingText(String r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        this.f13596a.setText(r5);
    }

    @JvmOverloads
    public SettingsTrailingView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ SettingsTrailingView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public SettingsTrailingView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        View r12 = LayoutInflater.from(r5).inflate(R$layout.o_settings_trailing_view_2, this, false);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-1, -2);
        r13.gravity = 8388629;
        addView(r12, r13);
        this.f13596a = (TextView) findViewById(R$id.trailingText);
        ImageView r14 = (ImageView) findViewById(R$id.trailingImage);
        this.f13597b = r14;
        r14.setImageDrawable(r5.getDrawable(R$drawable.ic_arrow_forward_list_item));
    }
}
