package com.bytedance.android.livesdk.interactivity.common.accessibility;

import androidx.core.view.AccessibilityDelegateCompat;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.bytedance.android.livesdk.chatroom.widget.LiveMessageRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/accessibility/MessageRvAccessibilityDelegate;", "Landroidx/recyclerview/widget/RecyclerViewAccessibilityDelegate;", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MessageRvAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
    public final RecycleViewItemAccessibilityDelegate a;

    public final AccessibilityDelegateCompat getItemDelegate() {
        return this.a;
    }

    public MessageRvAccessibilityDelegate(LiveMessageRecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super(r2);
        this.a = new RecycleViewItemAccessibilityDelegate(this);
    }
}
