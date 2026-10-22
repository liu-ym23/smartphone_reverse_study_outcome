package com.ss.android.lark.keyboard.biz.emoji.inject;

import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.widget.RoundedIconTextView;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ EmojiTopPlugin a;

    public a(EmojiTopPlugin r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Chat r5 = (Chat) r4;
        EmojiTopPlugin r0 = this.a;
        Intrinsics.checkNotNull(r5);
        RoundedIconTextView r1 = r0.d;
        if (r1 == null) goto L22;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L9:
        if (r3 != null) goto L12;
        return;
    L12:
        if (r5.isGroup() == false) goto L14;
    L16:
        int r6 = 0;
    L18:
        if (r3.leftMargin == r6) goto L24;
        r3.leftMargin = r6;
        r1.setLayoutParams(r3);
        return;
    L24:
        return;
    L14:
        if (com.ss.android.lark.keyboard.utils.b.a(r5) == true) goto L16;
        r6 = UIHelper.dp2px(12.0f);
        goto L18
    L8:
        r3 = null;
        goto L9
    }
}
