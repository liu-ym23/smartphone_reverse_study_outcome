package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface b1 extends vh7.c<b1> {
    public static final int GUEST_BATTLE_CREATE = 1;
    public static final int GUEST_BATTLE_FINISH = 4;
    public static final int GUEST_BATTLE_NONE = 0;
    public static final int GUEST_BATTLE_PAUSE = 5;
    public static final int GUEST_BATTLE_RESUME = 6;
    public static final int GUEST_BATTLE_SHOW_RESULT = 3;
    public static final int GUEST_BATTLE_UPDATE = 2;

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "battle_info")
    com.bytedance.android.livesdk.chatroom.model.interact.a0 getBattleInfo();

    @FieldName(name = "finish_content")
    a1 getFinishContent();

    @FieldName(name = "finish_toast")
    String getFinishToast();

    @FieldName(name = "msg_type")
    int getMsgType();

    @FieldName(name = "update_content")
    d1 getUpdateContent();
}
