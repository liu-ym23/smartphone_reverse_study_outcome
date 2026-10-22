package com.ss.android.lark.flow.chat.message.block;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowHideContentBlock implements i<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>, com.ss.android.lark.chat.base.view.vo.message.e> {
    public final g a;
    public final IMMessageKeys.Blocks b;
    public final Context c;

    public final Class<com.ss.android.lark.chat.base.view.vo.message.e> b() {
        return null;
    }

    public final Context getContext() {
        return this.c;
    }

    public final j getKey() {
        return this.b;
    }

    public FlowHideContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.a = r2;
        this.b = IMMessageKeys.Blocks.HIDE_CONTENT;
        this.c = r2.getContext();
    }

    public final void a(m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r2, q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        i.a.a(r2, r3);
        k r4 = r3.f(this.b, IMMessageKeys.Slots.CONTENT);
        TextChatView2 r5 = null;
        if (r4 == null) goto L5;
        View r6 = r4.getView();
    L7:
        if ((r6 instanceof TextChatView2) == false) goto L9;
        r5 = (TextChatView2) r6;
    L9:
        if (r5 == null) goto L14;
        LKUILightTextView r7 = r5.getLightTextView();
        if (r7 == null) goto L15;
        r7.w();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r6 = null;
        goto L7
    }

    public void update(m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r3, q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r4, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r5) {
        Intrinsics.checkNotNullParameter(r3, "cell");
        Intrinsics.checkNotNullParameter(r4, "layout");
        Intrinsics.checkNotNullParameter(r5, "data");
        TextView r6 = (TextView) r4.c(this.b, IMMessageKeys.Slots.CONTENT, new FlowHideContentBlock$update$textView$1(this)).getView();
        r6.setTextSize(vgb.a.a(17.0f));
        if (r5.h() == false) goto L5;
        int r7 = UIUtils.getColor(this.c, 2131102054);
    L6:
        r6.setTextColor(r7);
        r6.setText("转发层数过多，内容已被隐藏");
        return;
    L5:
        r7 = UIUtils.getColor(this.c, 2131102042);
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }

    public final void c(BlueprintCell r1, q r2, Object r3, Object r4) {
        i.a.b(this, r1, r2, (y6b.a) r3, (com.ss.android.lark.chat.base.view.vo.message.e) r4);
    }
}
