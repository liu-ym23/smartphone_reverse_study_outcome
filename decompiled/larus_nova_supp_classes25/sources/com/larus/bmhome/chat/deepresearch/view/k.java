package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.im.bean.message.block.Block;
import com.larus.mainbot.impl.databinding.LarusBlockItemPlaceholderBinding;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k extends AbsBlockView {
    public LarusBlockItemPlaceholderBinding b;

    public k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(Block r2, Map<String, Object> r3) {
        LarusBlockItemPlaceholderBinding r4 = this.b;
        if (r4 == null) goto L11;
        FrameLayout r5 = r4.a;
        if (r5 == null) goto L12;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L10;
        r6.height = 0;
        r5.setLayoutParams(r6);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L12:
        return;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = LayoutInflater.from(r2).inflate(2131561838, this, false);
        addView(r4);
        if (r4 == null) goto L7;
        this.b = new LarusBlockItemPlaceholderBinding((FrameLayout) r4);
        return;
    L7:
        throw new NullPointerException("rootView");
    }
}
