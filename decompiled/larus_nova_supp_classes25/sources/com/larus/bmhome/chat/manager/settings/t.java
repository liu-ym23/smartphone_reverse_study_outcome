package com.larus.bmhome.chat.manager.settings;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t {
    public t() {
    }

    public static ItemTextArrow a(ItemGroup r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "group");
        String r5 = r2.getContext().getString(r3);
        Intrinsics.checkNotNullParameter(r2, "group");
        Intrinsics.checkNotNullParameter(r5, ChatDraftItem.TYPE_TEXT);
        ItemTextArrow r0 = new ItemTextArrow(r2.getContext());
        r0.setText(r5);
        r0.setTextFontWeight(500);
        r0.setImageSrc(r4);
        r2.addView(r0);
        ViewGroup.LayoutParams r6 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) r6;
        r7.width = -1;
        r7.height = -2;
        return r0;
    }

    public static ItemTextToggle b(ItemGroup r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "group");
        ItemTextToggle r0 = new ItemTextToggle(r2.getContext());
        r0.setText(r0.getContext().getString(r3));
        r0.setTextFontWeight(500);
        r0.setImageSrc(r4);
        r2.addView(r0);
        ViewGroup.LayoutParams r5 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
        r6.width = -1;
        r6.height = -2;
        return r0;
    }
}
