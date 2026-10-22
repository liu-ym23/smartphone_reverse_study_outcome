package com.ss.android.lark.flow.chat.message.mergeforward;

import android.view.View;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.c;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import w4b.u;
import w4b.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMergeForwardContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<c>, c> {
    public final boolean g;
    public final IMMessageKeys.Blocks h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FlowMergeForwardContentBlock a;
        public final /* synthetic */ y6b.a<c> b;

        public a(FlowMergeForwardContentBlock r1, y6b.a<c> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            w r5 = ChatCoreModule.a().getMergeForwardDependnecy();
            m2b.a r0 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).c;
            y6b.a<c> r1 = this.b;
            u r2 = MessagePermissionUtil.a;
            r5.d(r0, r1);
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ m<y6b.a<c>> a;
        public final /* synthetic */ FlowMergeForwardContentBlock b;
        public final /* synthetic */ y6b.a<c> c;

        public b(m<y6b.a<c>> r1, FlowMergeForwardContentBlock r2, y6b.a<c> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 != null) goto L10;
            return false;
        L10:
            return r5.e(this.b, this.c);
        L5:
            r5 = null;
            goto L6
        }
    }

    public final j getKey() {
        return this.h;
    }

    public FlowMergeForwardContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = false;
        this.h = IMMessageKeys.Blocks.MERGE_FORWARD_CONTENT;
    }

    public void update(m<y6b.a<c>> r4, q<y6b.a<c>> r5, y6b.a<c> r6) {
        Intrinsics.checkNotNullParameter(r4, "cell");
        Intrinsics.checkNotNullParameter(r5, "layout");
        Intrinsics.checkNotNullParameter(r6, "data");
        com.ss.android.lark.flow.chat.message.mergeforward.a r7 = (com.ss.android.lark.flow.chat.message.mergeforward.a) r5.c(this.h, IMMessageKeys.Slots.CONTENT, new FlowMergeForwardContentBlock$update$blockView$1(this));
        View r0 = r7.b;
        if (r6.d() == false) goto L5;
        int r1 = 2131102022;
    L6:
        r0.setBackgroundResource(r1);
        r7.b.setOnClickListener(new a(this, r6));
        r7.b.setOnLongClickListener(new b(r4, this, r6));
        pxa.a r8 = r6.b().i;
        TextView r9 = r7.c;
        if (r8 == null) goto L9;
        String r2 = r8.a;
    L10:
        r9.setText(r2);
        ThreadReplyExposureView r10 = r7.d;
        r10.setMaxShowingReplyCount(4);
        r10.setShowTailEllipsis(true);
        r10.setShowLastedItems(false);
        if (r8 == null) goto L13;
        List r11 = r8.c;
    L14:
        r10.f(null, r11);
        r10.d(UIUtils.getColor(r10.getContext(), 2131102043), UIUtils.getColor(r10.getContext(), 2131102043));
        return;
    L13:
        r11 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = 2131106781;
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}
