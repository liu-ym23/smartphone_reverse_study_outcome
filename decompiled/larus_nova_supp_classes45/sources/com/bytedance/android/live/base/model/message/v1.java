package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface v1 extends vh7.c<v1> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "card_list")
    List<com.bytedance.android.livesdk.chatroom.model.interact.e> getCardList();

    @FieldName(name = "from_user")
    com.bytedance.android.livesdk.chatroom.model.interact.k getFromUser();

    @FieldName(name = "to_user")
    com.bytedance.android.livesdk.chatroom.model.interact.k getToUser();
}
