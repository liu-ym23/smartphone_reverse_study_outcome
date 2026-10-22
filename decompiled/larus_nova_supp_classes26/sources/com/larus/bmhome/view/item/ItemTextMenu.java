package com.larus.bmhome.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextMenu;", "Lcom/larus/bmhome/view/item/ItemTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "subTextView", "Landroid/widget/TextView;", "getSubTextView", "()Landroid/widget/TextView;", "menuArrowView", "Landroid/widget/ImageView;", "getMenuArrowView", "()Landroid/widget/ImageView;", "menuClickAreaView", "Landroid/view/View;", "init", "", "updateTextViewLayout", "setImageSrc", "resId", "setSubText", ShareType.TEXT, "", "setOnMenuClickListener", "listener", "Landroid/view/View$OnClickListener;", "setMenuEnabled", "enabled", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ItemTextMenu extends ItemTextView {
    public final TextView c;
    public final ImageView d;
    public final View e;

    /* JADX WARN: Multi-variable type inference failed */
    private final void T5() {
        ImageView r0 = this.d;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, -2);
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.endToEnd = 0;
        Unit r4 = Unit.INSTANCE;
        addView(r0, r1);
        TextView r2 = this.c;
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(-2, -2);
        r3.topToTop = 0;
        r3.bottomToBottom = 0;
        r3.endToStart = this.d.getId();
        r3.setMarginEnd(i5.Y());
        addView(r2, r3);
        View r5 = this.e;
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(0, 0);
        r6.topToTop = 0;
        r6.bottomToBottom = 0;
        r6.startToStart = this.c.getId();
        r6.endToEnd = 0;
        addView(r5, r6);
        U5();
    }

    public final void U5() {
        ConstraintLayout.LayoutParams r0 = getTextView().getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r1 = r0;
    L6:
        if (r1 == null) goto L15;
        int r2 = 0;
        ((ViewGroup.MarginLayoutParams) r1).width = 0;
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.startToEnd = getImageView().getId();
        r1.endToStart = this.c.getId();
        if (getImageView().getVisibility() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        r2 = i5.q();
    L13:
        r1.setMarginStart(r2);
        r1.setMarginEnd(i5.h());
        getTextView().setGravity(8388627);
        getTextView().setLayoutParams(r1);
        return;
    L10:
        r3 = false;
        goto L11
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final ImageView getMenuArrowView() {
        return this.d;
    }

    public final TextView getSubTextView() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextMenu(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        TextView r6 = new TextView(getContext());
        r6.setId(2131392531);
        r6.setTextColor(ContextCompat.getColor(r6.getContext(), c.b(2130972081, r6.getContext(), 2131103143)));
        r6.setTextSize(0, i5.t());
        r6.setGravity(8388629);
        r6.setIncludeFontPadding(false);
        this.c = r6;
        ImageView r7 = new ImageView(getContext());
        r7.setId(2131392536);
        r7.setImageResource(c.b(2130971886, r7.getContext(), 2131242254));
        r7.setVisibility(0);
        this.d = r7;
        View r8 = new View(getContext());
        r8.setId(2131392527);
        r8.setBackgroundColor(0);
        r8.setImportantForAccessibility(2);
        this.e = r8;
        T5();
    }

    @Override // com.larus.bmhome.view.item.ItemTextView
    public void setImageSrc(int r1) {
        super.setImageSrc(r1);
        U5();
    }

    public final void setMenuEnabled(boolean r2) {
        this.e.setEnabled(r2);
    }

    public final void setOnMenuClickListener(View.OnClickListener r2) {
        this.e.setOnClickListener(r2);
        View r0 = this.e;
        if (r2 == null) goto L5;
        boolean r3 = true;
    L6:
        r0.setClickable(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void setSubText(String r3) {
        this.c.setText(r3);
        TextView r0 = this.c;
        int r1 = 0;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r1 = 8;
    L11:
        r0.setVisibility(r1);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextMenu(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        super(r4, r5);
        TextView r6 = new TextView(getContext());
        r6.setId(2131392531);
        r6.setTextColor(ContextCompat.getColor(r6.getContext(), c.b(2130972081, r6.getContext(), 2131103143)));
        r6.setTextSize(0, i5.t());
        r6.setGravity(8388629);
        r6.setIncludeFontPadding(false);
        this.c = r6;
        ImageView r7 = new ImageView(getContext());
        r7.setId(2131392536);
        r7.setImageResource(c.b(2130971886, r7.getContext(), 2131242254));
        r7.setVisibility(0);
        this.d = r7;
        View r8 = new View(getContext());
        r8.setId(2131392527);
        r8.setBackgroundColor(0);
        r8.setImportantForAccessibility(2);
        this.e = r8;
        T5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextMenu(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "attrs");
        super(r3, r4, r5);
        TextView r6 = new TextView(getContext());
        r6.setId(2131392531);
        r6.setTextColor(ContextCompat.getColor(r6.getContext(), c.b(2130972081, r6.getContext(), 2131103143)));
        r6.setTextSize(0, i5.t());
        r6.setGravity(8388629);
        r6.setIncludeFontPadding(false);
        this.c = r6;
        ImageView r7 = new ImageView(getContext());
        r7.setId(2131392536);
        r7.setImageResource(c.b(2130971886, r7.getContext(), 2131242254));
        r7.setVisibility(0);
        this.d = r7;
        View r8 = new View(getContext());
        r8.setId(2131392527);
        r8.setBackgroundColor(0);
        r8.setImportantForAccessibility(2);
        this.e = r8;
        T5();
    }
}
