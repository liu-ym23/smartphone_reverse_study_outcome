package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.HeadTextBlock;
import com.larus.mainbot.impl.databinding.LarusBlockItemHeadTextBinding;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v extends AbsBlockView {
    public LarusBlockItemHeadTextBinding b;

    public v(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(Block r7, Map<String, Object> r8) {
        LarusBlockItemHeadTextBinding r9 = this.b;
        if (r9 == null) goto L16;
        we8.a.b(r9.b, i5.t(), false, null, null, 12);
        TextView r10 = r9.b;
        if (r7 == null) goto L13;
        BlockContent r11 = r7.getContent();
        if (r11 == null) goto L13;
        HeadTextBlock r12 = r11.getHeadTextBlock();
        if (r12 == null) goto L13;
        String r13 = r12.text;
        if (r13 == null) goto L13;
    L14:
        r10.setText(r13);
        return;
    L13:
        r13 = "";
        goto L14
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = LayoutInflater.from(r2).inflate(2131561832, this, false);
        addView(r4);
        if (r4 == null) goto L7;
        TextView r5 = (TextView) r4;
        this.b = new LarusBlockItemHeadTextBinding(r5, r5);
        return;
    L7:
        throw new NullPointerException("rootView");
    }
}
