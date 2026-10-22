package com.larus.account.saas.ui.web;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import j48.a;
import j48.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/larus/account/saas/ui/web/FlowAccountSaasWebErrorView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "listener", "", "setOnCloseClickListener", "setOnRefreshClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class FlowAccountSaasWebErrorView extends FrameLayout {
    public static final /* synthetic */ int e = 0;
    public final View a;
    public final View b;
    public View.OnClickListener c;
    public View.OnClickListener d;

    public FlowAccountSaasWebErrorView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowAccountSaasWebErrorView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
    }

    public final void setOnCloseClickListener(View.OnClickListener r1) {
        this.c = r1;
    }

    public final void setOnRefreshClickListener(View.OnClickListener r1) {
        this.d = r1;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
    }

    public FlowAccountSaasWebErrorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (getBackground() != null) goto L5;
        setBackgroundResource(2131100111);
    L5:
        LayoutInflater.from(r2).inflate(2131558439, this, true);
        View r5 = findViewById(2131362023);
        this.a = r5;
        View r6 = findViewById(2131362024);
        this.b = r6;
        r5.setOnClickListener(new a(this));
        r6.setOnClickListener(new b(this));
    }

    public /* synthetic */ FlowAccountSaasWebErrorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
