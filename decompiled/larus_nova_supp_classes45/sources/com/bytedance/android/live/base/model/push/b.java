package com.bytedance.android.live.base.model.push;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.CommonPushMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000f¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/base/model/push/b;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "buttonText", "getButtonText", "setButtonText", "scheme", "getScheme", "setScheme", "", "duration", "J", "getDuration", "()J", "setDuration", "(J)V", "scene", "getScene", "setScene", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends o0 implements h {
    public CharSequence a;

    @SerializedName("button")
    protected String buttonText;

    @SerializedName("text")
    protected String content;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("icon")
    protected ImageModel icon;

    @SerializedName("scene")
    protected String scene;

    @SerializedName("schema")
    protected String scheme;

    @SerializedName("title")
    protected String title;

    public b() {
        ((o0) this).type = MessageType.COMMON_PUSH_MESSAGE;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final String getTitle() {
        return this.title;
    }

    public b(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.scene = am3.h.c(r5);
        goto L3
    L8:
        this.duration = r5.j();
        goto L3
    L9:
        this.scheme = am3.h.c(r5);
        goto L3
    L10:
        this.buttonText = am3.h.c(r5);
        goto L3
    L11:
        this.content = am3.h.c(r5);
        goto L3
    L12:
        this.title = am3.h.c(r5);
        goto L3
    L13:
        this.icon = x.a(r5);
        goto L3
    L14:
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
        ((o0) this).type = MessageType.COMMON_PUSH_MESSAGE;
    }

    public final void setButtonText(String r1) {
        this.buttonText = r1;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setScene(String r1) {
        this.scene = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }
}
