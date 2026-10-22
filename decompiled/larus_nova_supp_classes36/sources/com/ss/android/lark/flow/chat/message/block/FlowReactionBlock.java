package com.ss.android.lark.flow.chat.message.block;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.ReactionHandler;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.reaction.ReactionHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ugc.effectplatform.task.StrategyCacheClearTask;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import w4b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowReactionBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.c<?>, Object> implements e6b.d<y6b.c<?>, Object> {
    public final IMMessageKeys.Slots g;
    public final Lazy h;
    public final ReactionHandler i;

    public final j getKey() {
        return IMMessageKeys.Blocks.REACTION;
    }

    public FlowReactionBlock(g r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        super(r4);
        this.g = IMMessageKeys.Slots.BOTTOM;
        this.h = LazyKt.lazy(FlowReactionBlock$loginDependency$2.INSTANCE);
        this.i = new ReactionHandler(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getContext(), ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getChatId(), ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c);
    }

    public final void a(m<y6b.c<?>> r2, q<y6b.c<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        i.a.a(r2, r3);
        g(r3, IMMessageKeys.Blocks.REACTION, this.g);
    }

    public final void d(m r9, q r10, Object r11) {
        y6b.c r12 = (y6b.c) r11;
        Intrinsics.checkNotNullParameter(r9, "cell");
        Intrinsics.checkNotNullParameter(r10, "layout");
        Intrinsics.checkNotNullParameter(r12, "data");
        k r13 = r10.f(IMMessageKeys.Blocks.REACTION, this.g);
        if (r13 == null) goto L5;
        View r14 = r13.getView();
    L7:
        if ((r14 instanceof ReactionFlowLayout) == false) goto L9;
        ReactionFlowLayout r15 = (ReactionFlowLayout) r14;
    L10:
        if (r15 == null) goto L49;
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(UIHelper.dp2px(50.0f));
        r0.setColor(ContextCompat.getColor(r15.getContext(), 2131102026));
        r15.setTagBackground(r0);
        r15.setDivideLineColor(0);
        r15.setSeparatorWidth(UIHelper.dp2px(6.0f));
        r15.setExtraLineHeight(UIHelper.dp2px(6.0f));
        r15.setTextColor(2131102042);
        r15.setReactionPaddings(new int[]{0, 0, 0, 0});
        r15.setChildXOffset(0);
        r15.setChildYOffset(0);
        r15.setReactionTextSize(12);
        r15.setDisplayChangeEnable(true);
        r15.setReactionMaxWidth(u2b.j.d(r15.getContext(), f3b.b.a(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c)));
        if (r12.k1 == false) goto L15;
        ReactionFlowLayout.Align r3 = ReactionFlowLayout.Align.RIGHT;
    L16:
        r15.setAlign(r3);
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = ((u) this.h.getValue()).getUserId();
        Chat r5 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getChat();
        if (r5 == null) goto L27;
        String r6 = r5.getAnonymousId();
        if (r6 == null) goto L27;
        if (r6.length() <= 0) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L27;
        r4.element = r6;
        goto L27
    L23:
        r7 = false;
    L27:
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.e0() == true) goto L37;
        v4b.c r8 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).f;
        if (r8 != null) goto L31;
    L33:
        boolean r16 = false;
    L35:
        if ((!r16) == false) goto L37;
        boolean r17 = true;
    L38:
        r15.setTapAnimationEnabled(r17);
        String r18 = (String) r4.element;
        List r19 = r12.u;
        ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.isGroup();
        r15.a(k7b.a.c(r18, r19), true);
        r15.setVisibility(0);
        int[] r1 = {0, 0, 0, 0};
        r15.setPadding(r1[0], r1[1], r1[2], r1[3]);
        y6b.b r2 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.x8();
        if (r2 == null) goto L44;
        if (r2.q == false) goto L44;
        r15.setReactionClickListener(null);
        r15.setOnReactionMoreTrigger(null);
        r15.setOnReactionNameTrigger(null);
        return;
    L44:
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.e0() == true) goto L46;
        r15.setReactionClickListener(new d(this, r12, r4));
        r15.setOnReactionNameTrigger(new e(this, r12));
    L46:
        r15.setOnReactionMoreTrigger(new f(r12, this, r5));
        return;
    L31:
        if (r8.i != true) goto L33;
        r16 = true;
    L37:
        r17 = false;
        goto L38
    L15:
        r3 = ReactionFlowLayout.Align.LEFT;
        goto L16
    L49:
        return;
    L9:
        r15 = null;
        goto L10
    L5:
        r14 = null;
        goto L7
    }

    public void update(m<y6b.c<?>> r2, q<y6b.c<?>> r3, y6b.c<?> r4) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        Intrinsics.checkNotNullParameter(r4, "data");
        ReactionHitPoint.a(r4.c);
        if (r4.j() == false) goto L5;
    L15:
        IMMessageKeys.Blocks r5 = IMMessageKeys.Blocks.REACTION;
        ReactionFlowLayout r6 = r3.f(r5, this.g);
        if ((r6 instanceof ReactionFlowLayout) == false) goto L18;
        ReactionFlowLayout r7 = r6;
    L19:
        if (r7 == null) goto L21;
        r7.setup(CollectionsKt.emptyList());
    L21:
        g(r3, r5, this.g);
        return;
    L18:
        r7 = null;
        goto L19
    L5:
        if (r4.Y == true) goto L15;
        if (r4.l() == false) goto L15;
        if (r4.y == true) goto L15;
        if (r4.z == true) goto L15;
        r3.c(IMMessageKeys.Blocks.REACTION, this.g, new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.c) r3);
    }

    public static final void h(FlowReactionBlock r1, y6b.c r2, String r3, String r4) {
        r1.getClass();
        Map r5 = MapsKt.toMutableMap(ChatParamUtils.i(r2));
        r5.put(StrategyCacheClearTask.RequestResourceInfo.TYPE_EFFECT, r4);
        if (r3 == null) goto L5;
        r5.put("reaction_type", r3);
    L5:
        ChatHitPointNew.f(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r1).c.getChat(), INotificationHitPoint.NoticeType.REACTION, ChatHitPointNew.c(INotificationHitPoint.NoticeType.REACTION), r5);
    }
}
