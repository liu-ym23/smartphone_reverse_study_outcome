package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.common.style.a;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(30)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/selection/OActionSheetButton;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "str", "", "setText", "(Ljava/lang/String;)V", "", "color", "setTextColor", "(I)V", "Lcom/obric/oui/text/OTextView;", "h", "Lcom/obric/oui/text/OTextView;", "getTvTitle", "()Lcom/obric/oui/text/OTextView;", "setTvTitle", "(Lcom/obric/oui/text/OTextView;)V", "getTvTitle$annotations", "()V", "tvTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionSheetButton extends OUIFrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OTextView f14381h;

    public OActionSheetButton(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, 0, 12);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_button, this);
        ViewParent r11 = (ViewGroup) findViewById(R$id.ll_root);
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        a r12 = (a) r11;
        if (r12 == null) goto L11;
        r12.setChangeAlphaWhenPress(false);
    L11:
        setTvTitle((OTextView) findViewById(R$id.tv_content_title));
        setRadius((int) getResources().getDimension(R$dimen.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r11 instanceof a) == false) goto L4;
        goto L4
    }

    public static /* synthetic */ void getTvTitle$annotations() {
    }

    public final OTextView getTvTitle() {
        OTextView r5 = this.f14381h;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        return null;
    }

    public final void setText(String r5) {
        Intrinsics.checkNotNullParameter(r5, "str");
        getTvTitle().setText(r5);
    }

    public final void setTextColor(@ColorInt int r5) {
        getTvTitle().setTextColor(r5);
    }

    public final void setTvTitle(OTextView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14381h = r5;
    }
}
