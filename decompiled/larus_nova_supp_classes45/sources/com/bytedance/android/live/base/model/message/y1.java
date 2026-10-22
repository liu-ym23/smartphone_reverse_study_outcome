package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/base/model/message/y1;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/g;", "getPairInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/g;", "pairInfo", "", "getToast", "()Ljava/lang/String;", "toast", "", "getFinishReason", "()I", "finishReason", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y1 extends vh7.c<y1> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "finish_reason")
    int getFinishReason();

    @FieldName(name = "pair_info")
    com.bytedance.android.livesdk.chatroom.model.interact.g getPairInfo();

    @FieldName(name = "toast")
    String getToast();
}
