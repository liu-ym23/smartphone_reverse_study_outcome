package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarQuickLoader {
    public static final Set<Integer> a = null;
    public static final Lazy b = null;

    static {
        a = SetsKt.setOf(new Integer[]{1, 5, 7});
        b = LazyKt.lazy(ToolbarQuickLoader$preloadViewTag$2.INSTANCE);
    }

    public static View a(ViewGroup r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "data");
        int r4 = r3.a;
        if (r4 != 1) goto L6;
        ImageView r5 = new ImageView(r2.getContext());
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r5.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r5.setImageResource(2131243760);
    L12:
        if (r5 == null) goto L14;
        r5.setTag(Integer.valueOf(((Number) b.getValue()).intValue()));
        r2.addView(r5);
    L14:
        return r5;
    L6:
        if (r4 != 5) goto L9;
        r5 = new ImageView(r2.getContext());
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r5.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r5.setImageResource(2131251032);
        goto L12
    L9:
        if (r4 != 7) goto L11;
        r5 = new ImageView(r2.getContext());
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r5.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r5.setImageResource(2131243764);
        goto L12
    L11:
        r5 = null;
        goto L12
    }
}
