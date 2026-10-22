package com.bytedance.android.livesdk.interactivity.api.chatchannel.message;

import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.im.RoomChannelSecretStatusMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/message/m;", "Ly32/a;", BuildConfig.FLAVOR, "SecretStatus", "J", "G", "()J", "setSecretStatus", "(J)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m extends y32.a implements vh7.h {

    @SerializedName("SecretStatus")
    protected long SecretStatus;

    public m() {
    }

    @Override // y32.a
    public final InteractivityMessageType E() {
        return InteractivityMessageType.RoomChannelSecretChatStatus;
    }

    public final long G() {
        return this.SecretStatus;
    }

    public m(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.SecretStatus = r5.j();
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }
}
