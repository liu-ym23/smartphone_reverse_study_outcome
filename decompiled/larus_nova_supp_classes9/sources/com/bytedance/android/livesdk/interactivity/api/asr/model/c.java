package com.bytedance.android.livesdk.interactivity.api.asr.model;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.interaction.SendAnchorAudioResponse.ResponseData")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/asr/model/c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "msgId", "Ljava/lang/Long;", "Lcom/bytedance/android/livesdkapi/message/Text;", "rtfContent", "Lcom/bytedance/android/livesdkapi/message/Text;", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", BuildConfig.FLAVOR, "showIdentity", "I", "b", "()I", "setShowIdentity", "(I)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "identityLabel", "Lcom/bytedance/android/live/base/model/ImageModel;", "a", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIdentityLabel", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("identity_label")
    protected ImageModel identityLabel;

    @SerializedName("msg_id")
    public Long msgId;

    @SerializedName("rtf_content")
    public Text rtfContent;

    @SerializedName("show_identity")
    protected int showIdentity;

    @SerializedName("user")
    public User user;

    public c() {
    }

    public final ImageModel a() {
        return this.identityLabel;
    }

    public final int b() {
        return this.showIdentity;
    }

    public c(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.msgId = Long.valueOf(r5.j());
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.rtfContent = _Text_ProtoDecoder.decodeStatic(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.user = new User(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.showIdentity = r5.i();
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.identityLabel = x.a(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
