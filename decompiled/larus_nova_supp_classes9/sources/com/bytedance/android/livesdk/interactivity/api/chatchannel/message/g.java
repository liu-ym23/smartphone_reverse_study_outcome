package com.bytedance.android.livesdk.interactivity.api.chatchannel.message;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.im.RoomChannelEmojiChatMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/message/g;", "Ly32/a;", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "getUser", "()Lcom/bytedance/android/live/base/model/user/User;", "setUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", BuildConfig.FLAVOR, "emojiId", "J", "getEmojiId", "()J", "H", "(J)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "emojiContent", "Lcom/bytedance/android/livesdkapi/message/Text;", "getEmojiContent", "()Lcom/bytedance/android/livesdkapi/message/Text;", "G", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", BuildConfig.FLAVOR, "defaultContent", "Ljava/lang/String;", "getDefaultContent", "()Ljava/lang/String;", "setDefaultContent", "(Ljava/lang/String;)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g extends y32.a implements vh7.h {
    public boolean b;

    @SerializedName("default_content")
    protected String defaultContent;

    @SerializedName("emoji_content")
    protected Text emojiContent;

    @SerializedName("emoji_id")
    protected long emojiId;

    @SerializedName("user")
    protected User user;

    public g() {
    }

    @Override // y32.a
    public final InteractivityMessageType E() {
        return InteractivityMessageType.RoomChannelEmojiChat;
    }

    public final String getDefaultContent() {
        return this.defaultContent;
    }

    public final Text getEmojiContent() {
        return this.emojiContent;
    }

    public final User getUser() {
        return this.user;
    }

    public g(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.user = new User(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.emojiId = r5.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.emojiContent = _Text_ProtoDecoder.decodeStatic(r5);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.defaultContent = am3.h.c(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }

    public final void G(Text r1) {
        this.emojiContent = r1;
    }

    public final void H(long r1) {
        this.emojiId = r1;
    }

    public final void setDefaultContent(String r1) {
        this.defaultContent = r1;
    }

    public final void setUser(User r1) {
        this.user = r1;
    }
}
