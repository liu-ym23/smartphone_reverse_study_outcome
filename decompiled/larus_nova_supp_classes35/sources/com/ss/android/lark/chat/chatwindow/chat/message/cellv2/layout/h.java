package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class h extends a {
    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public Map<v, Integer> z() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(IMMessageKeys$Slots.CONTENT, 2131364916), TuplesKt.to(IMMessageKeys$Slots.HEADER, 2131364916), TuplesKt.to(IMMessageKeys$Slots.FOOTER, 2131364916)});
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public /* bridge */ /* synthetic */ void l(Object r1) {
        A((y6b.a) r1);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public LKUIRoundLinearLayout y(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LKUIRoundLinearLayout r5 = LayoutInflater.from(r4.getContext()).inflate(2131559304, r4, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.layout.LKUIRoundLinearLayout");
        return r5;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public final void B(LKUIRoundLinearLayout r2, y6b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "bodyLayout");
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        a.C(this, r2, r3);
        r2.setBackgroundColor(p3b.a.b(r3.h()));
        r2.setPadding(UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 12.0f));
    }

    public h(com.ss.android.lark.blueprint.g r2, BlueprintCell r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3, r4);
    }
}
