package com.ss.android.lark.flow.chat.message.downgrade.block;

import android.view.View;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockCalendarContentBinding;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeCalendarContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowCalendarContentBlock extends b<y6b.a<mgb.a>, Object> {
    public final IMMessageKeys.Blocks g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FlowCalendarContentBlock a;
        public final /* synthetic */ y6b.a<mgb.a> b;

        public a(FlowCalendarContentBlock r1, y6b.a<mgb.a> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r4 = ((b) this.a).c.getChatId();
            if (r4 != null) goto L5;
            return;
        L5:
            int r0 = com.ss.android.lark.flow.chat.message.a.a;
            com.ss.android.lark.flow.chat.message.a.a(this.a.getContext(), r4, this.b.A());
        }
    }

    public final j getKey() {
        return this.g;
    }

    public FlowCalendarContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.FLOW_CALENDAR_CONTENT;
    }

    public void update(m<y6b.a<mgb.a>> r5, q<y6b.a<mgb.a>> r6, y6b.a<mgb.a> r7) {
        Intrinsics.checkNotNullParameter(r5, "cell");
        Intrinsics.checkNotNullParameter(r6, "layout");
        Intrinsics.checkNotNullParameter(r7, "data");
        FlowChatMessageV2BlockCalendarContentBinding r8 = (FlowChatMessageV2BlockCalendarContentBinding) r6.c(this.g, IMMessageKeys.Slots.CONTENT, new FlowCalendarContentBlock$update$blockView$1(this)).a;
        LarkDowngradeCalendarContent r0 = (LarkDowngradeCalendarContent) ((v5b.a) ((mgb.a) r7.b())).a;
        r8.d.setText(r0.getTitle());
        r8.c.setText(UIUtils.getString(getContext(), 2131890148));
        r8.c.setTextColor(UIUtils.getColor(getContext(), 2131102039));
        r8.b.setImageDrawable(UDIconUtils.getIconDrawable(getContext(), 2131235455, UIUtils.getColor(getContext(), 2131102039)));
        r8.a.setOnClickListener(new a(this, r7));
        f(r8.a, r5, r7);
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}
