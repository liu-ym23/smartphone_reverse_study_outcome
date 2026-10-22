package com.ss.android.lark.flow.chat.message.downgrade.block;

import android.view.View;
import com.bytedance.lark.pb.basic.v1.VideoChatContent;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockVideoChatContentBinding;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeVideoChatContent;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mgb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowVideoChatContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<c>, Object> {
    public final IMMessageKeys.Blocks g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VideoChatContent.MeetingCard.Status.values().length];
            r0[VideoChatContent.MeetingCard.Status.JOINABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[VideoChatContent.MeetingCard.Status.FULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ FlowVideoChatContentBlock a;
        public final /* synthetic */ y6b.a<c> b;

        public b(FlowVideoChatContentBlock r1, y6b.a<c> r2) {
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

    public final j getKey() {
        return this.g;
    }

    public FlowVideoChatContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.FLOW_VIDEO_CHAT_CONTENT;
    }

    public void update(m<y6b.a<c>> r16, q<y6b.a<c>> r17, y6b.a<c> r18) {
        Intrinsics.checkNotNullParameter(r16, "cell");
        Intrinsics.checkNotNullParameter(r17, "layout");
        Intrinsics.checkNotNullParameter(r18, "data");
        FlowChatMessageV2BlockVideoChatContentBinding r2 = (FlowChatMessageV2BlockVideoChatContentBinding) r17.c(this.g, IMMessageKeys.Slots.CONTENT, new FlowVideoChatContentBlock$update$blockView$1(this)).a;
        LarkDowngradeVideoChatContent r4 = (LarkDowngradeVideoChatContent) ((v5b.a) ((c) r18.b())).a;
        r2.d.setText(r4.getTitle());
        int r5 = a.a[r4.getStatus().ordinal()];
        String r6 = "";
        if (r5 != 1) goto L5;
    L15:
        int r7 = 2131890147;
        int r8 = 2131102059;
        int r9 = 2131102049;
    L16:
        r2.c.setText(UIUtils.getString(getContext(), r7) + r6);
        r2.c.setTextColor(UIUtils.getColor(getContext(), r8));
        r2.b.setImageDrawable(UDIconUtils.getIconDrawable(getContext(), 2131235475, UIUtils.getColor(getContext(), r9)));
        r2.a.setOnClickListener(new b(this, r18));
        f(r2.a, r16, r18);
        return;
    L5:
        if (r5 == 2) goto L15;
        long r10 = r4.getEndTimeMs() - r4.getStartTimeMs();
        if (r10 < 0) goto L14;
        long r11 = r10 / ((long) AudioViewModel.ASR_SESSION_IDLE);
        long r12 = 3600;
        long r13 = r11 / r12;
        long r14 = 60;
        long r15 = (r11 % r12) / r14;
        long r19 = r11 % r14;
        if (r13 <= 0) goto L12;
        StringCompanionObject r20 = StringCompanionObject.INSTANCE;
        String r21 = String.format(Locale.getDefault(), "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r13), Long.valueOf(r15), Long.valueOf(r19)}, 3));
    L13:
        r6 = r21;
        goto L14
    L12:
        StringCompanionObject r22 = StringCompanionObject.INSTANCE;
        r21 = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r15), Long.valueOf(r19)}, 2));
    L14:
        r6 = " · " + r6;
        r7 = 2131890146;
        r8 = 2131102041;
        r9 = 2131102042;
        goto L16
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}
