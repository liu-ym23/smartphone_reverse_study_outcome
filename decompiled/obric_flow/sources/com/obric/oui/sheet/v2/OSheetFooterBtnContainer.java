package com.obric.oui.sheet.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.common.oui.R$dimen;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetFooterBtnContainer;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/button/OButton;", "a", "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "setBtnNegative", "(Lcom/obric/oui/button/OButton;)V", "btnNegative", "b", "getBtnPositive", "setBtnPositive", "btnPositive", "Landroid/view/View;", "c", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "setHorizontal_space", "(Landroid/view/View;)V", "horizontal_space", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSheetFooterBtnContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OButton f14435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButton f14436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f14437c;

    @JvmOverloads
    public OSheetFooterBtnContainer(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final OButton getBtnNegative() {
        return this.f14435a;
    }

    public final OButton getBtnPositive() {
        return this.f14436b;
    }

    public final View getHorizontal_space() {
        return this.f14437c;
    }

    public final void setBtnNegative(OButton r5) {
        this.f14435a = r5;
    }

    public final void setBtnPositive(OButton r5) {
        this.f14436b = r5;
    }

    public final void setHorizontal_space(View r5) {
        this.f14437c = r5;
    }

    @JvmOverloads
    public OSheetFooterBtnContainer(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(0);
        int r11 = getResources().getDimensionPixelSize(R$dimen.oui_p_container_large_1);
        int r12 = com.lynx.tasm.utils.a.B(8, this);
        setPadding(r11, r12, r11, r12);
    }
}
