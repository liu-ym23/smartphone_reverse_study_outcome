package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001b\u001a\u00020\u00172\b\b\u0001\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001dJ\u0010\u0010\u001f\u001a\u00020\u00172\b\b\u0001\u0010!\u001a\u00020\nJ\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001dJ\u000e\u0010'\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/contact/base/common_ui/ContactSimpleItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarView", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "nameView", "Landroid/widget/TextView;", "descView", "actionBtn", "Lcom/larksuite/component/ui/button/LKUIButton;", "actionBtnStatus", "splitLine", "Landroid/view/View;", "initViews", BuildConfig.FLAVOR, "avatar", "avatarModel", "Lcom/larksuite/component/ui/avatar/AvatarModel;", "setName", IPortraitService.NAME, BuildConfig.FLAVOR, "nameResId", "setDesc", "descStr", "descResId", "setActionBtn", "btnStr", "clickListener", "Landroid/view/View$OnClickListener;", "btnResId", "disableActionBtn", "disableBtnStr", "disableResId", "setSplitLine", "enable", BuildConfig.FLAVOR, "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactSimpleItemView extends FrameLayout {
    public TextView a;
    public TextView b;
    public View c;

    public final void a() {
        ConstraintLayout r0 = LayoutInflater.from(getContext()).inflate(2131559924, this, false);
        addView(r0);
        int r1 = 2131362061;
        if (ViewBindings.findChildViewById(r0, 2131362061) == null) goto L17;
        r1 = 2131362062;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131362062)) == null) goto L17;
        r1 = 2131363623;
        if (ViewBindings.findChildViewById(r0, 2131363623) == null) goto L17;
        r1 = 2131368819;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r0, 2131368819);
        if (r2 == null) goto L17;
        r1 = 2131380593;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r0, 2131380593);
        if (r3 == null) goto L17;
        r1 = 2131387114;
        View r4 = ViewBindings.findChildViewById(r0, 2131387114);
        if (r4 == null) goto L17;
        this.a = r3;
        this.b = r2;
        this.c = r4;
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public ContactSimpleItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a();
    }

    public final void setDesc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "descStr");
        TextView r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descView");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nameView");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public final void setSplitLine(boolean r2) {
        View r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("splitLine");
        r0 = null;
    L5:
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    public final void setDesc(int r2) {
        TextView r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descView");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public final void setName(int r2) {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nameView");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public ContactSimpleItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        a();
    }

    public ContactSimpleItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a();
    }
}
