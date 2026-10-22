package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\nR*\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\r\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/l;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/m;", "secretChatInfo", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/m;", "getSecretChatInfo", "()Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/m;", "setSecretChatInfo", "(Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/m;)V", "getSecretChatInfo$annotations", "()V", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/c;", "channelInfo", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/c;", "getChannelInfo", "()Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/c;", "setChannelInfo", "(Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/c;)V", "getChannelInfo$annotations", "<init>", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l implements vh7.h {

    @SerializedName("secret_chat_channel")
    protected c channelInfo;

    @SerializedName("secret_chat_resp")
    protected m secretChatInfo;

    public l() {
    }

    public l(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.secretChatInfo = new m(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.channelInfo = new c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }
}
