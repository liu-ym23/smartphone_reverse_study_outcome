package com.ss.android.lark.flow.chat.message.block;

import android.view.View;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.coremd.utils.MessageStyleHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowUnknownContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>, com.ss.android.lark.chat.base.view.vo.message.e> {
    public final IMMessageKeys.Blocks g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ FlowUnknownContentBlock a;
        public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> b;

        public b(FlowUnknownContentBlock r1, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r4 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).c.getChatId();
            if (r4 != null) goto L5;
            return;
        L5:
            int r0 = com.ss.android.lark.flow.chat.message.a.a;
            com.ss.android.lark.flow.chat.message.a.a(this.a.getContext(), r4, this.b.A());
        }
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public FlowUnknownContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.FLOW_UNKNOWN_CONTENT;
    }

    public final void a(m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r2, q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        i.a.a(r2, r3);
        k r4 = r3.f(this.g, IMMessageKeys.Slots.CONTENT);
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
        TextView r6 = (TextView) r4.c(this.g, IMMessageKeys.Slots.CONTENT, new FlowUnknownContentBlock$update$textView$1(this)).getView();
        r6.setTextSize(vgb.a.a(17.0f));
        if (MessageStyleHelper.b(r5) == false) goto L5;
        int r7 = 2131102067;
    L6:
        r6.setTextColor(UIUtils.getColor(getContext(), r7));
        r6.setPaintFlags(r6.getPaintFlags() | 8);
        r6.setText(UIUtils.getString(getContext(), 2131890175));
        r6.setOnClickListener(new b(this, r5));
        return;
    L5:
        r7 = 2131102042;
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}
