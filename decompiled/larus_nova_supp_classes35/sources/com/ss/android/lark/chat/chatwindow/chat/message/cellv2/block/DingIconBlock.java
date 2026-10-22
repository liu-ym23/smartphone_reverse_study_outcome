package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.ViewGroup;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DingIconBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;
    public final int h;
    public final int i;
    public final int j;

    public static final class a {
    }

    static {
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public DingIconBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.DING_ICON;
        this.h = UIUtils.dp2px(getContext(), 24.0f);
        this.i = UIUtils.dp2px(getContext(), 25.0f);
        this.j = UIUtils.dp2px(getContext(), 1.0f);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys$Slots.DING_ICON);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r3, com.ss.android.lark.blueprint.q<y6b.a<?>> r4, y6b.a<?> r5) {
        Intrinsics.checkNotNullParameter(r3, "cell");
        Intrinsics.checkNotNullParameter(r4, "layout");
        Intrinsics.checkNotNullParameter(r5, Keys.API_RETURN_KEY_DATA);
        y6b.c r6 = (y6b.c) r5;
        if (r6.T == true) goto L6;
        g(r4, this.g, IMMessageKeys$Slots.DING_ICON);
        return;
    L6:
        com.ss.android.lark.blueprint.k r7 = r4.c(this.g, IMMessageKeys$Slots.DING_ICON, new DingIconBlock$update$blockView$1(this));
        if (r6.getType() != Message.Type.IMAGE) goto L9;
    L18:
        LKUIRoundedImageView r8 = r7.getView();
        int r0 = this.j;
        r8.setPadding(r0, r0, 0, 0);
        ViewGroup.LayoutParams r9 = r7.getView().getLayoutParams();
        int r1 = this.i;
        r9.width = r1;
        r9.height = r1;
    L20:
        if (r6.d() == false) goto L22;
        float r10 = 8.0f;
    L23:
        r7.getView().setCornerRadiusDP(r10, 0.0f, 0.0f, 0.0f);
        return;
    L22:
        r10 = com.ss.android.lark.chat.utils.f0.a(r6, 10.0f, 2.0f)[0];
        goto L23
    L9:
        if (r6.getType() == Message.Type.STICKER) goto L18;
        if (r6.getType() == Message.Type.LOCATION) goto L18;
        if (r6.getType() == Message.Type.SHARE_USER_CARD) goto L18;
        if (r6.d() == true) goto L18;
        r7.getView().setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r11 = r7.getView().getLayoutParams();
        int r2 = this.h;
        r11.width = r2;
        r11.height = r2;
        goto L20
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
