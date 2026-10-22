package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ai.ex.widget.WidgetView;
import com.obric.common.oui.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\fJ\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCheck;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "checked", "", "setChecked", "(Z)V", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", WidgetView.UI_MODE_LIGHT, "setCheckedIconLight", "", "str", "setTitle", "(Ljava/lang/String;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OListItemCheck extends OListItemGeneral {
    public OListItemCheck(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        setTrailingImageView(getResources().getDrawable(R$drawable.o_ic_radio_tick_checked));
        getMTrailingElement().setVisibility(8);
    }

    public final ImageView getIcon() {
        View r5 = getMTrailingElement().getChildAt(0);
        if (r5 == null) goto L7;
        return (ImageView) r5;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }

    public final void setChecked(boolean r5) {
        FrameLayout r10 = getMTrailingElement();
        if (r5 == false) goto L5;
        int r11 = 0;
    L6:
        r10.setVisibility(r11);
        return;
    L5:
        r11 = 8;
        goto L6
    }

    public final void setCheckedIconLight(boolean r5) {
    }

    public final void setTitle(String r5) {
        Intrinsics.checkNotNullParameter(r5, "str");
        setTitleString(r5);
    }
}
