package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.RealTimeChatLikeMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/base/model/message/l6;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "", "Lcom/bytedance/android/live/base/model/message/a6;", "refreshMap", "Ljava/util/Map;", "E", "()Ljava/util/Map;", "setRefreshMap", "(Ljava/util/Map;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class l6 extends com.bytedance.android.livesdk.message.model.o0 implements vh7.h {

    @SerializedName("need_refresh")
    protected Map<Long, a6> refreshMap;

    public l6() {
        ((com.bytedance.android.livesdk.message.model.o0) this).type = MessageType.REALTIME_CHAT_LIKE;
    }

    public final Map<Long, a6> E() {
        return this.refreshMap;
    }

    public l6(am3.g r12) {
        this.refreshMap = new HashMap();
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L27;
        if (r2 != 1) goto L8;
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r12);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        long r6 = r12.c();
        Long r3 = null;
        a6 r8 = null;
    L11:
        int r9 = r12.f();
        if (r9 == (-1)) goto L18;
        if (r9 != 1) goto L14;
        r3 = Long.valueOf(r12.j());
        goto L11
    L14:
        if (r9 != 2) goto L15;
        r8 = new a6(r12);
        goto L11
    L15:
        am3.h.e(r12);
        goto L11
    L18:
        r12.d(r6);
        Map<Long, a6> r4 = this.refreshMap;
        if (r3 == null) goto L25;
        if (r8 == null) goto L23;
        r4.put(r3, r8);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r12);
        goto L3
    L27:
        r12.d(r0);
        ((com.bytedance.android.livesdk.message.model.o0) this).type = MessageType.REALTIME_CHAT_LIKE;
    }
}
