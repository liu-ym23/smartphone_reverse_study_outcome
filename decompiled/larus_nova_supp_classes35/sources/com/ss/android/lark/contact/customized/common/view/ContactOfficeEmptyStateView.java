package com.ss.android.lark.contact.customized.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.contact.customized.databinding.ContactDbEmptyStatePageBinding;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/contact/customized/common/view/ContactOfficeEmptyStateView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbEmptyStatePageBinding;", "setEmptyIcon", BuildConfig.FLAVOR, "resId", "setEmptyText", "text", BuildConfig.FLAVOR, "setEmptyActionText", "setOnActionClickListener", "listener", "Landroid/view/View$OnClickListener;", "setHideActionButton", "hide", BuildConfig.FLAVOR, "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactOfficeEmptyStateView extends FrameLayout {
    public final ContactDbEmptyStatePageBinding a;

    public ContactOfficeEmptyStateView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ContactOfficeEmptyStateView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setEmptyActionText(CharSequence r2) {
        this.a.b.setText(r2);
    }

    public final void setEmptyIcon(int r2) {
        this.a.c.setImageResource(r2);
    }

    public final void setEmptyText(CharSequence r2) {
        this.a.d.setText(r2);
    }

    public final void setHideActionButton(boolean r2) {
        TextView r0 = this.a.b;
        if ((!r2) == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setOnActionClickListener(View.OnClickListener r2) {
        this.a.b.setOnClickListener(r2);
    }

    public ContactOfficeEmptyStateView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        View r0 = LayoutInflater.from(r7).inflate(2131559907, this, false);
        addView(r0);
        int r1 = 2131371598;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r0, 2131371598);
        if (r3 == null) goto L36;
        r1 = 2131371599;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131371599)) == null) goto L36;
        r1 = 2131371600;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r0, 2131371600);
        if (r4 == null) goto L36;
        r1 = 2131371601;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r0, 2131371601);
        if (r5 == null) goto L36;
        this.a = new ContactDbEmptyStatePageBinding((FrameLayout) r0, r3, r4, r5);
        if (r8 == null) goto L37;
        TypedArray r10 = r7.obtainStyledAttributes(r8, new int[]{2130968744, 2130970204, 2130970280, 2130974495}, r9, 0);
        int r11 = r10.getResourceId(2, -1);
        if (r11 == (-1)) goto L15;
        r4.setImageResource(r11);
    L15:
        String r12 = r10.getString(3);
        if (r12 != null) goto L18;
    L21:
        boolean r2 = true;
    L22:
        if (r2 == true) goto L24;
        r5.setText(r12);
    L24:
        String r13 = r10.getString(0);
        if (r13 != null) goto L27;
    L30:
        boolean r6 = true;
    L31:
        if (r6 == true) goto L33;
        r3.setText(r13);
    L33:
        setHideActionButton(r10.getBoolean(1, false));
        r10.recycle();
        return;
    L27:
        if (r13.length() == 0) goto L30;
        r6 = false;
        goto L31
    L18:
        if (r12.length() == 0) goto L21;
        r2 = false;
        goto L22
    L37:
        return;
    L36:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public /* synthetic */ ContactOfficeEmptyStateView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
