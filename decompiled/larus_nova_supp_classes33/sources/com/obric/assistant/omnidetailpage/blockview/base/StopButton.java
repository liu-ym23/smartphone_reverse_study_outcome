package com.obric.assistant.omnidetailpage.blockview.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBindings;
import com.obric.assistant.card.databinding.ObricOmniStopButtonBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/base/StopButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniStopButtonBinding;", "setLoading", "", "isLoading", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopButton extends FrameLayout {
    public final ObricOmniStopButtonBinding a;

    public StopButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StopButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setLoading(boolean r4) {
        ObricOmniStopButtonBinding r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 == false) goto L7;
        r0.b.setVisibility(4);
        r0.c.setVisibility(0);
        setEnabled(false);
        return;
    L7:
        r0.b.setVisibility(0);
        r0.c.setVisibility(8);
        setEnabled(true);
    }

    public StopButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131564047, this);
        int r5 = 2131367812;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(this, 2131367812);
        if (r6 == null) goto L9;
        r5 = 2131379091;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(this, 2131379091);
        if (r7 == null) goto L9;
        this.a = new ObricOmniStopButtonBinding(this, r6, r7);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ StopButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
