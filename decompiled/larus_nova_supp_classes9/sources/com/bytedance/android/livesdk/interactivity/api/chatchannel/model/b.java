package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ForMain
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "msgId", "J", "e", "()J", "setMsgId", "(J)V", BuildConfig.FLAVOR, "content", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", "b", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "rtfContent", "g", "setRtfContent", "emojiContent", "c", "setEmojiContent", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "h", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "imEmojiDisplayName", "d", "setImEmojiDisplayName", BuildConfig.FLAVOR, "needShowIdentity", "I", "f", "()I", "setNeedShowIdentity", "(I)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName("content")
    protected String content;

    @SerializedName("display_text")
    protected a5 displayText;

    @SerializedName("emoji_content")
    protected a5 emojiContent;

    @SerializedName("interactive_emoji_display_name")
    protected String imEmojiDisplayName;

    @SerializedName("msg_id")
    protected long msgId;

    @SerializedName("show_identity")
    protected int needShowIdentity;

    @SerializedName("rtf_content")
    protected a5 rtfContent;

    @SerializedName("user")
    protected IBaseUser user;

    public b() {
    }

    public final String a() {
        return this.content;
    }

    public final a5 b() {
        return this.displayText;
    }

    public final a5 c() {
        return this.emojiContent;
    }

    public final String d() {
        return this.imEmojiDisplayName;
    }

    public final long e() {
        return this.msgId;
    }

    public final int f() {
        return this.needShowIdentity;
    }

    public final a5 g() {
        return this.rtfContent;
    }

    public final IBaseUser h() {
        return this.user;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public b(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L6;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.imEmojiDisplayName = am3.h.c(r5);
        goto L3
    L8:
        this.needShowIdentity = r5.i();
        goto L3
    L9:
        this.emojiContent = vh7.f.a(r5, a5.class);
        goto L3
    L10:
        this.rtfContent = vh7.f.a(r5, a5.class);
        goto L3
    L11:
        this.user = vh7.f.a(r5, IBaseUser.class);
        goto L3
    L12:
        this.displayText = vh7.f.a(r5, a5.class);
        goto L3
    L13:
        this.content = am3.h.c(r5);
        goto L3
    L14:
        this.msgId = r5.j();
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
