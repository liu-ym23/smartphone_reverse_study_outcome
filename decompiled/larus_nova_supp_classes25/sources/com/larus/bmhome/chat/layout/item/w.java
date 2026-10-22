package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.larus.bmhome.databinding.LarusItemEduContinueShotBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w extends xc8.h {
    public final LarusItemEduContinueShotBinding p;

    public w(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        View r4 = LayoutInflater.from(r3).inflate(2131562564, this, false);
        addView(r4);
        if (r4 == null) goto L7;
        TextView r5 = (TextView) r4;
        this.p = new LarusItemEduContinueShotBinding(r5, r5);
        return;
    L7:
        throw new NullPointerException("rootView");
    }
}
