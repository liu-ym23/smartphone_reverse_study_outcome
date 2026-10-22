package com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import com.bytedance.android.livesdk.message.model.vh;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.im.WorldChatData")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010\nR*\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0014\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/square/f;", "Lh52/d;", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "publicAreaCommon", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getPublicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "setPublicAreaCommon", "(Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;)V", "getPublicAreaCommon$annotations", "()V", "Lcom/bytedance/android/live/base/model/message/m0;", "common", "Lcom/bytedance/android/live/base/model/message/m0;", "getCommon", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommon", "(Lcom/bytedance/android/live/base/model/message/m0;)V", BuildConfig.FLAVOR, "messageId", "J", "getMessageId", "()J", "setMessageId", "(J)V", BuildConfig.FLAVOR, "messageIdStr", "Ljava/lang/String;", "getMessageIdStr", "()Ljava/lang/String;", "setMessageIdStr", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "Lcom/bytedance/android/livesdk/message/model/vh;", "originRoom", "Lcom/bytedance/android/livesdk/message/model/vh;", "j", "()Lcom/bytedance/android/livesdk/message/model/vh;", "setOriginRoom", "(Lcom/bytedance/android/livesdk/message/model/vh;)V", "eventTime", "i", "setEventTime", "<init>", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements h52.d, h {
    public boolean a;

    @SerializedName("common")
    protected m0 common;

    @SerializedName("content")
    protected String content;

    @SerializedName("display_text")
    protected a5 displayText;

    @SerializedName("event_time")
    protected long eventTime;

    @SerializedName("msg_id")
    protected long messageId;

    @SerializedName("msg_id_str")
    protected String messageIdStr;

    @SerializedName("origin_room")
    protected vh originRoom;

    @SerializedName("public_area_common")
    protected IPublicAreaCommon publicAreaCommon;

    @SerializedName("user")
    protected IBaseUser user;

    @Override // h52.d
    public final long e() {
        long r0 = this.messageId;
        if (r0 > 0) goto L8;
        m0 r1 = this.common;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getMessageId();
    L8:
        return r0;
    }

    public f() {
        this.a = true;
    }

    @Override // h52.d
    public final String h() {
        return d().getTag();
    }

    @Override // h52.d
    public final IBaseUser a() {
        return this.user;
    }

    @Override // h52.d
    public final MessagePluginType b() {
        return MessagePluginType.SquareChatMessagePlugin;
    }

    @Override // h52.d
    public final a5 c() {
        return this.displayText;
    }

    @Override // h52.d
    public final MessageModelType d() {
        return MessageModelType.Square;
    }

    @Override // h52.d
    public final IPublicAreaCommon f() {
        return this.publicAreaCommon;
    }

    @Override // h52.d
    public final String g() {
        return this.content;
    }

    public final long i() {
        return this.eventTime;
    }

    public final vh j() {
        return this.originRoom;
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.livesdkapi.message.IPublicAreaCommon, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.message.m0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public f(am3.g r5) {
        this.a = true;
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.publicAreaCommon = vh7.f.a(r5, IPublicAreaCommon.class);
        goto L3
    L8:
        this.eventTime = r5.j();
        goto L3
    L9:
        this.originRoom = new vh(r5);
        goto L3
    L10:
        this.messageIdStr = am3.h.c(r5);
        goto L3
    L11:
        this.displayText = vh7.f.a(r5, a5.class);
        goto L3
    L12:
        this.user = vh7.f.a(r5, IBaseUser.class);
        goto L3
    L13:
        this.content = am3.h.c(r5);
        goto L3
    L14:
        this.messageId = r5.j();
        goto L3
    L15:
        this.common = vh7.f.a(r5, m0.class);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L16:
        r5.d(r0);
    }
}
