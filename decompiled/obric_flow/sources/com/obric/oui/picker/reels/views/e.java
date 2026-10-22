package com.obric.oui.picker.reels.views;

import android.R;
import android.widget.TextView;
import com.obric.oui.orecyclerview.widget.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends x0 {
    public final TextView g;

    public e(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        super(r5);
        this.g = (TextView) r5.findViewById(R.id.text1);
    }
}
