package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/contact/base/common_ui/ContactErrorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "errorTextView", "Landroid/widget/TextView;", "initViews", BuildConfig.FLAVOR, "setOnRetryClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactErrorView extends FrameLayout {
    public TextView a;

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131559923, this, true);
        this.a = (TextView) findViewById(2131371744);
    }

    public ContactErrorView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a();
    }

    public final void setOnRetryClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("errorTextView");
        r0 = null;
    L5:
        r0.setOnClickListener(r2);
    }

    public ContactErrorView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        a();
    }

    public ContactErrorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a();
    }
}
