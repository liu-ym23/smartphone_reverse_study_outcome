package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.ReactionHandler;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.bubble.IBubbleBodyBgStyleProvider;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.reaction.ReactionHitPoint;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReactionBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.c<?>, Object> implements e6b.d<y6b.c<?>, Object> {
    public final IMMessageKeys$Blocks g;
    public final Lazy h;
    public final ReactionHandler i;
    public final IMMessageKeys$Slots j;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IBubbleBodyBgStyleProvider.Style.values().length];
            r0[IBubbleBodyBgStyleProvider.Style.Normal.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[IBubbleBodyBgStyleProvider.Style.Clean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public ReactionBlock(com.ss.android.lark.blueprint.g r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        super(r4);
        this.g = IMMessageKeys$Blocks.REACTION;
        this.h = LazyKt.lazy(ReactionBlock$loginDependency$2.INSTANCE);
        this.i = new ReactionHandler(this.c.getContext(), this.c.getChatId(), this.c);
        this.j = IMMessageKeys$Slots.FOOTER;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.c<?>> r2, com.ss.android.lark.blueprint.q<y6b.c<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, this.j);
    }

    @Override // e6b.d
    public final void d(com.ss.android.lark.blueprint.m<y6b.c<?>> r8, com.ss.android.lark.blueprint.q<y6b.c<?>> r9, y6b.c<?> r10) {
        y6b.c<?> r11 = r10;
        Intrinsics.checkNotNullParameter(r8, "cell");
        Intrinsics.checkNotNullParameter(r9, "layout");
        Intrinsics.checkNotNullParameter(r11, Keys.API_RETURN_KEY_DATA);
        com.ss.android.lark.blueprint.k r12 = r9.f(this.g, this.j);
        if (r12 == null) goto L5;
        View r13 = r12.getView();
    L7:
        if ((r13 instanceof ReactionFlowLayout) == false) goto L9;
        ReactionFlowLayout r14 = (ReactionFlowLayout) r13;
    L10:
        if (r14 != null) goto L13;
        return;
    L13:
        if ((r9 instanceof IBubbleBodyBgStyleProvider) == false) goto L15;
        IBubbleBodyBgStyleProvider r15 = (IBubbleBodyBgStyleProvider) r9;
    L16:
        if (r15 == null) goto L19;
        IBubbleBodyBgStyleProvider.Style r16 = r15.m();
        if (r16 == null) goto L19;
    L20:
        int r17 = b.a[r16.ordinal()];
        if (r17 == 1) goto L26;
        if (r17 != 2) goto L25;
        Context r18 = getContext();
        int r5 = p3b.a.W;
        Drawable r19 = UIUtils.getDrawable(r18, 2131232598);
        ((GradientDrawable) r19).setColor(v4b.a.E);
        r14.setTagBackground(r19);
        r14.setTextColor(v4b.a.F);
        r14.setReactionPaddings(new int[]{0, 0, 0, 0});
    L35:
        r14.setChildXOffset(0);
        r14.setChildYOffset(0);
        r14.setReactionTextSize(11);
        r14.setDisplayChangeEnable(true);
        r14.setReactionMaxWidth(u2b.j.d(getContext(), f3b.b.a(this.c)));
        String r1 = ((w4b.u) this.h.getValue()).getUserId();
        Chat r6 = this.c.getChat();
        if (r6 == null) goto L45;
        String r7 = r6.getAnonymousId();
        if (r7 == null) goto L45;
        if (r7.length() <= 0) goto L42;
        boolean r20 = true;
    L43:
        if (r20 == false) goto L45;
        r1 = r7;
        goto L45
    L42:
        r20 = false;
    L45:
        r14.setMaxNameCount(5);
        if (this.c.e0() == true) goto L56;
        v4b.c r21 = this.f;
        if (r21 != null) goto L50;
    L52:
        boolean r22 = false;
    L54:
        if ((!r22) == false) goto L56;
        boolean r23 = true;
    L57:
        r14.setTapAnimationEnabled(r23);
        List<ReactionInfo> r24 = r11.u;
        this.c.isGroup();
        r14.a(k7b.a.c(r1, r24), true);
        r14.setVisibility(0);
        int[] r4 = {0, 0, 0, 0};
        r14.setPadding(r4[0], r4[1], r4[2], r4[3]);
        y6b.b r25 = this.c.x8();
        if (r25 == null) goto L63;
        if (r25.q == false) goto L63;
        r14.setReactionClickListener(null);
        r14.setOnReactionMoreTrigger(null);
        r14.setOnReactionNameTrigger(null);
        return;
    L63:
        if (this.c.e0() == true) goto L65;
        r14.setReactionClickListener(new g0(this, r11, r1));
        r14.setOnReactionNameTrigger(new h0(this, r11));
    L65:
        r14.setOnReactionMoreTrigger(new i0(this, r11));
        return;
    L50:
        if (r21.i != true) goto L52;
        r22 = true;
    L56:
        r23 = false;
        goto L57
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        Context r26 = getContext();
        boolean r27 = r11.i;
        int r28 = p3b.a.W;
        Drawable r29 = UIUtils.getDrawable(r26, 2131232598);
        GradientDrawable r2 = (GradientDrawable) r29;
        if (r27 == false) goto L29;
        int r30 = v4b.a.f;
    L30:
        r2.setColor(r30);
        r14.setTagBackground(r29);
        if (r11.i == false) goto L33;
        int r31 = v4b.a.g;
    L34:
        r14.setTextColor(r31);
        r14.setReactionPaddings(new int[]{0, 0, 0, 0});
        goto L35
    L33:
        r31 = v4b.a.F;
        goto L34
    L29:
        r30 = v4b.a.E;
    L19:
        r16 = IBubbleBodyBgStyleProvider.Style.Normal;
        goto L20
    L15:
        r15 = null;
        goto L16
    L9:
        r14 = null;
        goto L10
    L5:
        r13 = null;
        goto L7
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.c<?>> r2, com.ss.android.lark.blueprint.q<y6b.c<?>> r3, y6b.c<?> r4) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        ReactionHitPoint.a(r4.c);
        if (r4.j() == false) goto L5;
    L15:
        ReactionFlowLayout r5 = r3.f(this.g, this.j);
        if ((r5 instanceof ReactionFlowLayout) == false) goto L18;
        ReactionFlowLayout r6 = r5;
    L19:
        if (r6 == null) goto L21;
        r6.setup(null);
    L21:
        g(r3, this.g, this.j);
        return;
    L18:
        r6 = null;
        goto L19
    L5:
        if (r4.Y == true) goto L15;
        if (r4.l() == false) goto L15;
        if (r4.y == true) goto L15;
        if (r4.z == true) goto L15;
        r3.c(this.g, this.j, new AnonymousClass1(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.c<?>> r1, com.ss.android.lark.blueprint.q<y6b.c<?>> r2, y6b.c<?> r3) {
        update2(r1, r2, r3);
    }

    public static final void h(ReactionBlock r1, y6b.c r2, String r3, String r4) {
        r1.getClass();
        Map r5 = MapsKt.toMutableMap(ChatParamUtils.i(r2));
        r5.put("effect", r4);
        if (r3 == null) goto L5;
        r5.put("reaction_type", r3);
    L5:
        ChatHitPointNew.f(r1.c.getChat(), "reaction", ChatHitPointNew.c("reaction"), r5);
    }
}
