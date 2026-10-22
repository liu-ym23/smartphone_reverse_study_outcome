package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u8.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCheck;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "", "checked", "", "setChecked", "Landroid/widget/ImageView;", "getIcon", "light", "setCheckedIconLight", "", "str", "setTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OListItemCheck extends OListItemGeneral {
    public OListItemCheck(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        setTrailingImageView(getResources().getDrawable(e.o_ic_radio_tick_checked));
        getMTrailingElement().setVisibility(8);
    }

    public final ImageView getIcon() {
        View r10 = getMTrailingElement().getChildAt(0);
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.widget.ImageView");
        return (ImageView) r10;
    }

    public final void setChecked(boolean r10) {
        FrameLayout r11 = getMTrailingElement();
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void setCheckedIconLight(boolean r10) {
    }

    public final void setTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "str");
        setTitleString(r10);
    }
}
