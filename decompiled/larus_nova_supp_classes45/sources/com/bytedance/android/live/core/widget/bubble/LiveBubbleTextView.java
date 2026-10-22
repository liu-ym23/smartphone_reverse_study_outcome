package com.bytedance.android.live.core.widget.bubble;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/widget/bubble/LiveBubbleTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBubbleTextView extends AppCompatTextView {
    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return super/*android.widget.TextView*/.createAccessibilityNodeInfo();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performLongClick() {
        return super/*android.widget.TextView*/.performLongClick();
    L4:
        Intrinsics.checkNotNullParameter(getText(), "text");
        return false;
    }

    public LiveBubbleTextView(Context r2) {
        this(r2, null);
    }

    public LiveBubbleTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super/*android.widget.TextView*/.onVisibilityChanged(r2, r3);     // Catch: NullPointerException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public LiveBubbleTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}
