package com.larus.bmhome.bot.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.item.ItemTextArrow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yb8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/bot/view/ServiceBotSettingFrescoTextArrowView;", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "frescoView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "initFresco", "", "setIconUrl", "lightUrl", "", "darkUrl", "setSubTextValue", ChatDraftItem.TYPE_TEXT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ServiceBotSettingFrescoTextArrowView extends ItemTextArrow {
    public SimpleDraweeView l;

    public ServiceBotSettingFrescoTextArrowView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.l = a.a(this, getImageView());
    }

    public final void setSubTextValue(String r3) {
        if (r3 != null) goto L4;
        r3 = "";
    L4:
        getSubTextView().setText(r3);
        int r0 = 0;
        if (r3.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        TextView r1 = getSubTextView();
        if (r4 == true) goto L12;
        r0 = 8;
    L12:
        r1.setVisibility(r0);
        ConstraintLayout.LayoutParams r2 = getTextView().getLayoutParams();
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L15;
        ConstraintLayout.LayoutParams r5 = r2;
    L16:
        if (r5 != null) goto L18;
        return;
    L18:
        if (r4 == false) goto L20;
        int r6 = getSubTextView().getId();
    L21:
        r5.endToStart = r6;
        getTextView().setLayoutParams(r5);
        return;
    L20:
        r6 = getArrowView().getId();
        goto L21
    L15:
        r5 = null;
        goto L16
    L7:
        r4 = false;
        goto L8
    }

    public ServiceBotSettingFrescoTextArrowView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.l = a.a(this, getImageView());
    }

    public ServiceBotSettingFrescoTextArrowView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        this.l = a.a(this, getImageView());
    }
}
