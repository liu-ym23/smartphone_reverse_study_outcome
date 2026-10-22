package com.larus.bmhome.chat.api;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface d0 {

    public static final class a {
        public static void a(SelectionRangeType r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "rangeType");
            Intrinsics.checkNotNullParameter(r2, "selectedText");
        }
    }

    void a(View r1, int r2, int r3);

    void b(SelectionRangeType r1, int r2, int r3, boolean r4, boolean r5, Rect r6, String r7);
}
