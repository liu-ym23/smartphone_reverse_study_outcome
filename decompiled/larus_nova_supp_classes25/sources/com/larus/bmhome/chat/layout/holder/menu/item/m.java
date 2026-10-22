package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import com.larus.bmhome.chat.bean.ChatMsgDeleteScene;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility$ActionType;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m extends a {
    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131907182) goto L5;
        return true;
    L5:
        return false;
    }

    public m() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r6, View r7, ef8.b r8) {
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "menuContext");
        com.larus.bmhome.chat.api.q0.a r9 = r8.b;
        if (r9 == null) goto L11;
        IChatMessageShareAbility r10 = r9.J9();
        if (r10 == null) goto L11;
        IChatMessageShareAbility$ActionType r0 = IChatMessageShareAbility$ActionType.DELETE;
        Message r1 = r8.a;
        com.larus.bmhome.chat.api.q0 r11 = r8.c;
        if (r11 == null) goto L9;
        List r12 = r11.getCurrentList();
    L10:
        r10.yt(r0, r1, r12, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EXT_KEY_CLICK_FROM", "long_press_answer"), TuplesKt.to("EXT_KEY_SCENE", ChatMsgDeleteScene.longPressMenu)}));
        goto L11
    L9:
        r12 = null;
    L11:
        return true;
    }
}
