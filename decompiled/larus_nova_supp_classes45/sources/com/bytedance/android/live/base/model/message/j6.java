package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LowPcuGuideData;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.LowPcuGuideMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/base/model/message/j6;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/depend/model/live/LowPcuGuideData;", "lowPcuGuideData", "Lcom/bytedance/android/livesdkapi/depend/model/live/LowPcuGuideData;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class j6 extends com.bytedance.android.livesdk.message.model.o0 implements vh7.h {

    @SerializedName("low_pcu_guide_info")
    public LowPcuGuideData lowPcuGuideData;

    public j6() {
        ((com.bytedance.android.livesdk.message.model.o0) this).type = MessageType.LOW_PCU_GUIDE;
    }

    public j6(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.lowPcuGuideData = new LowPcuGuideData(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        ((com.bytedance.android.livesdk.message.model.o0) this).type = MessageType.LOW_PCU_GUIDE;
    }
}
