package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.widget.TextView;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UnknownContentBlock implements com.ss.android.lark.blueprint.i<y6b.a<?>, v5b.a<?>> {
    public final com.ss.android.lark.blueprint.g a;
    public final IMMessageKeys$Blocks b;

    public final Class<v5b.a<?>> b() {
        return null;
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.b;
    }

    public UnknownContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.a = r2;
        this.b = IMMessageKeys$Blocks.UNKNOWN_CONTENT;
    }

    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2) {
        com.ss.android.lark.blueprint.i.a.a(r1, r2);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r3, com.ss.android.lark.blueprint.q<y6b.a<?>> r4, y6b.a<?> r5) {
        Intrinsics.checkNotNullParameter(r3, "cell");
        Intrinsics.checkNotNullParameter(r4, "layout");
        Intrinsics.checkNotNullParameter(r5, Keys.API_RETURN_KEY_DATA);
        TextView r6 = (TextView) r4.c(this.b, IMMessageKeys$Slots.CONTENT, new UnknownContentBlock$update$textView$1(this)).getView();
        zz7.a.d(r6, LarkFont.TITLE3);
        r6.setText(UIHelper.mustacheFormat(2131892299));
        boolean r7 = r5.h();
        int r8 = p3b.a.W;
        if (r7 == false) goto L5;
        int r9 = v4b.a.e;
    L6:
        r6.setTextColor(r9);
        return;
    L5:
        r9 = v4b.a.D;
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r1, com.ss.android.lark.blueprint.q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }

    public final void c(BlueprintCell r1, com.ss.android.lark.blueprint.q r2, Object r3, Object r4) {
        com.ss.android.lark.blueprint.i.a.b(this, r1, r2, (y6b.a) r3, (v5b.a) r4);
    }
}
