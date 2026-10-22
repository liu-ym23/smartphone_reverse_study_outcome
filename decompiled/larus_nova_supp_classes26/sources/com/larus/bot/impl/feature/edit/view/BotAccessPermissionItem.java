package com.larus.bot.impl.feature.edit.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bot.impl.databinding.LarusItemBotAccessPermissionBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/larus/bot/impl/feature/edit/view/BotAccessPermissionItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bot/impl/databinding/LarusItemBotAccessPermissionBinding;", "value", "", "itemSelected", "getItemSelected", "()Z", "setItemSelected", "(Z)V", "showLoading", "", "hideLoading", "isLoading", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotAccessPermissionItem extends ConstraintLayout {
    public final LarusItemBotAccessPermissionBinding a;

    public BotAccessPermissionItem(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BotAccessPermissionItem(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void R5() {
        ImageView r0 = this.a.c;
        if (getItemSelected() == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        this.a.d.setVisibility(8);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public final void S5() {
        this.a.c.setVisibility(8);
        this.a.d.setVisibility(0);
    }

    public final boolean getItemSelected() {
        if (this.a.c.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setItemSelected(boolean r2) {
        ImageView r0 = this.a.c;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BotAccessPermissionItem(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        LayoutInflater.from(r11).inflate(2131562505, this);
        int r14 = 2131372860;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372860);
        if (r3 == null) goto L38;
        r14 = 2131376297;
        ImageView r0 = (ImageView) ViewBindings.findChildViewById(this, 2131376297);
        if (r0 == null) goto L38;
        r14 = 2131376632;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(this, 2131376632);
        if (r8 == null) goto L38;
        r14 = 2131378977;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(this, 2131378977);
        if (r6 == null) goto L38;
        r14 = 2131390392;
        TextView r9 = (TextView) ViewBindings.findChildViewById(this, 2131390392);
        if (r9 == null) goto L38;
        this.a = new LarusItemBotAccessPermissionBinding(this, r3, r0, r8, r6, r9);
        TypedArray r15 = r11.obtainStyledAttributes(r12, new int[]{R.attr.text, 2130972027, 2130972028, 2130972029});
        r0.setImageResource(r15.getResourceId(1, 0));
        r0.setColorFilter(ContextCompat.getColor(r11, 2131103136));
        String r16 = r15.getString(0);
        if (r16 != null) goto L15;
        r16 = "";
    L15:
        r9.setText(r16);
        if (r15.getBoolean(3, false) == false) goto L18;
        int r17 = 0;
    L19:
        r8.setVisibility(r17);
        if (r15.getBoolean(2, false) == false) goto L35;
        ViewGroup.LayoutParams r18 = r0.getLayoutParams();
        if (r18 == null) goto L34;
        r18.width = i5.C();
        r18.height = i5.C();
        r0.setLayoutParams(r18);
        ViewGroup.LayoutParams r19 = r9.getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r19;
    L27:
        if (r110 == null) goto L29;
        r110.setMarginStart(i5.q());
    L29:
        if (r110 == null) goto L31;
        r110.setMarginEnd(i5.q());
    L31:
        if (r110 == null) goto L35;
        r9.setLayoutParams(r110);
        goto L35
    L26:
        r110 = null;
        goto L27
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L35:
        r15.recycle();
        return;
    L18:
        r17 = 8;
    L38:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r14)));
    }

    public /* synthetic */ BotAccessPermissionItem(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
