package com.larus.common_ui.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusViewLoadingWithRetryBinding;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;
import z19.s;
import z19.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u0015\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H\u0002J\u0015\u0010\u0017\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/common_ui/widget/LoadingWithRetryView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusViewLoadingWithRetryBinding;", "alignTopMode", "", "setAlignTopMode", "", "setOnRetryListener", "listener", "Landroid/view/View$OnClickListener;", "showLoading", "showRetry", "retryText", "", "(Ljava/lang/Integer;)V", "", "showTextTipsOnly", "tipText", "showTipsActionText", "tipsActionText", "setTipsAction", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingWithRetryView extends LinearLayout {
    public static final /* synthetic */ int c = 0;
    public final LarusViewLoadingWithRetryBinding a;
    public boolean b;

    public final void a() {
        this.b = true;
        setGravity(0);
        this.a.h.setVisibility(8);
        this.a.c.setVisibility(8);
        ViewGroup.LayoutParams r0 = this.a.d.getLayoutParams();
        if (r0 == null) goto L6;
        r0.width = i5.J();
        r0.height = i5.J();
        return;
    }

    public final void b() {
        this.a.a.setVisibility(0);
        this.a.d.setVisibility(0);
        this.a.e.setVisibility(8);
        this.a.g.setVisibility(4);
        if (this.b == false) goto L11;
        setGravity(0);
        ViewGroup.LayoutParams r0 = this.a.d.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L8:
        if (r1 == null) goto L12;
        r1.topMargin = i5.E();
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public LoadingWithRetryView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void c(Integer r4) {
        if (r4 != null) goto L4;
        String r5 = null;
    L5:
        this.a.a.setVisibility(0);
        this.a.d.setVisibility(8);
        this.a.e.setVisibility(0);
        this.a.g.setVisibility(0);
        this.a.b.setVisibility(8);
        if (r5 == null) goto L9;
        this.a.f.setText(r5);
    L9:
        if (this.b == false) goto L12;
        setGravity(17);
        return;
    L12:
        return;
    L4:
        r5 = getContext().getString(r4.intValue());
        goto L5
    }

    public final void d(Integer r4) {
        if (r4 != null) goto L4;
        String r5 = null;
    L5:
        this.a.a.setVisibility(0);
        this.a.d.setVisibility(8);
        this.a.e.setVisibility(8);
        this.a.g.setVisibility(0);
        this.a.b.setVisibility(8);
        if (r5 == null) goto L9;
        this.a.f.setText(r5);
    L9:
        if (this.b == false) goto L12;
        setGravity(0);
        return;
    L12:
        return;
    L4:
        r5 = getContext().getString(r4.intValue());
        goto L5
    }

    public final void setOnRetryListener(final View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        setOnClickListener(new t(this, r2));
    }

    public final void setTipsAction(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(this.a.b, new s(r3));
    }

    public LoadingWithRetryView(Context r13, AttributeSet r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14);
        LayoutInflater.from(r13).inflate(2131563212, this);
        int r0 = 2131362149;
        TextView r4 = (TextView) ViewBindings.findChildViewById(this, 2131362149);
        if (r4 == null) goto L19;
        r0 = 2131364418;
        View r5 = ViewBindings.findChildViewById(this, 2131364418);
        if (r5 == null) goto L19;
        r0 = 2131379052;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(this, 2131379052);
        if (r6 == null) goto L19;
        r0 = 2131384137;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(this, 2131384137);
        if (r1 == null) goto L19;
        r0 = 2131384145;
        TextView r11 = (TextView) ViewBindings.findChildViewById(this, 2131384145);
        if (r11 == null) goto L19;
        r0 = 2131388753;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(this, 2131388753);
        if (r9 == null) goto L19;
        r0 = 2131389127;
        View r10 = ViewBindings.findChildViewById(this, 2131389127);
        if (r10 == null) goto L19;
        this.a = new LarusViewLoadingWithRetryBinding(this, r4, r5, r6, r1, r11, r9, r10);
        setOrientation(1);
        TypedArray r15 = r13.obtainStyledAttributes(r14, new int[]{R.attr.textColor, R.attr.background});
        setBackgroundColor(r15.getColor(1, ContextCompat.getColor(r13, c.b(2130970529, r13, 2131102529))));
        int r16 = r15.getColor(0, ContextCompat.getColor(r13, c.b(2130972079, r13, 2131103136)));
        r1.setColorFilter(r16);
        r11.setTextColor(r16);
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }
}
