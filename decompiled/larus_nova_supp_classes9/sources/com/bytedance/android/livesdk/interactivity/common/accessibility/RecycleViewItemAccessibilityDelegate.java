package com.bytedance.android.livesdk.interactivity.common.accessibility;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/accessibility/RecycleViewItemAccessibilityDelegate;", "Landroidx/recyclerview/widget/RecyclerViewAccessibilityDelegate$ItemDelegate;", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecycleViewItemAccessibilityDelegate extends RecyclerViewAccessibilityDelegate.ItemDelegate {
    public RecycleViewItemAccessibilityDelegate(RecyclerViewAccessibilityDelegate r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerViewDelegate");
        super(r2);
    }

    public final void onInitializeAccessibilityNodeInfo(View r8, AccessibilityNodeInfoCompat r9) {
        Intrinsics.checkNotNullParameter(r8, "host");
        Intrinsics.checkNotNullParameter(r9, "info");
        super.onInitializeAccessibilityNodeInfo(r8, r9);
        if (TextUtils.isEmpty(r9.getText()) == true) goto L5;
        return;
    L5:
        TextView r10 = (TextView) r8.findViewById(2131388367);
        if (r10 != null) goto L8;
        return;
    L8:
        String r11 = r10.getText().toString();
        if (r11 == null) goto L26;
        String r1 = StringsKt.trimStart(r11).toString();
    L12:
        if (r1.length() <= 0) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L23;
        if (StringsKt.startsWith$default(r1, "$", false, 2, null) == false) goto L23;
        String r14 = StringsKt.replaceFirst$default(r1, "$", BuildConfig.FLAVOR, false, 4, null);
        if (r14 == null) goto L22;
        r1 = StringsKt.trimStart(r14).toString();
        goto L12
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L23:
        r9.setContentDescription(r1);
        return;
    L14:
        r13 = false;
        goto L15
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
