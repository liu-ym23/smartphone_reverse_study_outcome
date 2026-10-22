package com.bytedance.android.live.liveinteract.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/MarqueeTextSwitcher;", "Landroid/widget/TextSwitcher;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setCurrentText", "", "text", "", "setText", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MarqueeTextSwitcher extends TextSwitcher {
    public MarqueeTextSwitcher(Context r2) {
        this(r2, null);
    }

    @Override // android.widget.TextSwitcher
    public void setCurrentText(CharSequence r3) {
        super.setCurrentText(r3);
        Object r0 = getCurrentView();
        if ((r0 instanceof MarqueeTextView) == true) goto L5;
        r0 = null;
    L5:
        MarqueeTextView r1 = (MarqueeTextView) r0;
        if (r1 == null) goto L9;
        r1.setOriginText(r3);
        return;
    }

    @Override // android.widget.TextSwitcher
    public void setText(CharSequence r3) {
        super.setText(r3);
        Object r0 = getCurrentView();
        if ((r0 instanceof MarqueeTextView) == true) goto L5;
        r0 = null;
    L5:
        MarqueeTextView r1 = (MarqueeTextView) r0;
        if (r1 == null) goto L9;
        r1.setOriginText(r3);
        return;
    }

    public MarqueeTextSwitcher(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
