package com.larus.av_call.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.av_call.databinding.LarusRealtimeBottomMoreBtnBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/av_call/util/RealtimeBottomMoreBtn;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/av_call/databinding/LarusRealtimeBottomMoreBtnBinding;", "getBinding", "()Lcom/larus/av_call/databinding/LarusRealtimeBottomMoreBtnBinding;", "setImageResource", "", "resId", "setIconVisible", "visible", "", "loadImage", "url", "", "tag", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RealtimeBottomMoreBtn extends FrameLayout {
    public final LarusRealtimeBottomMoreBtnBinding a;

    public RealtimeBottomMoreBtn(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RealtimeBottomMoreBtn(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final LarusRealtimeBottomMoreBtnBinding getBinding() {
        return this.a;
    }

    public final void setIconVisible(boolean r2) {
        SimpleDraweeView r0 = this.a.b;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 4;
        goto L6
    }

    public final void setImageResource(int r3) {
        this.a.b.setVisibility(0);
        this.a.b.setImageResource(r3);
    }

    public RealtimeBottomMoreBtn(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(2131563095, this, false);
        addView(r5);
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r5, 2131392477);
        if (r6 == null) goto L7;
        this.a = new LarusRealtimeBottomMoreBtnBinding((FrameLayout) r5, r6);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131392477)));
    }

    public /* synthetic */ RealtimeBottomMoreBtn(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
