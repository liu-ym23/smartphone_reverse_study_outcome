package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028g@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\n8g@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\u00168&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/base/model/message/o2;", "Lvh7/c;", "", "getFinishToast", "()Ljava/lang/String;", "setFinishToast", "(Ljava/lang/String;)V", "finishToast", "getGuestFinishToast", "guestFinishToast", "", "getFinishReason", "()I", "setFinishReason", "(I)V", "finishReason", "", "getFinishRoomId", "()J", "finishRoomId", "getFinishUserIdString", "finishUserIdString", "", "getNeedToast", "()Z", "setNeedToast", "(Z)V", "needToast", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o2 extends vh7.c<o2> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "reason")
    int getFinishReason();

    @FieldName(name = "finish_room_id")
    long getFinishRoomId();

    @FieldName(name = "finish_toast")
    String getFinishToast();

    String getFinishUserIdString();

    @FieldName(name = "guest_finish_toast")
    String getGuestFinishToast();

    boolean getNeedToast();

    void setFinishReason(int r1);

    void setFinishToast(String r1);

    void setNeedToast(boolean r1);
}
