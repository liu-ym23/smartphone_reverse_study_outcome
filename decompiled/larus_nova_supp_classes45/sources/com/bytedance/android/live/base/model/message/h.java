package com.bytedance.android.live.base.model.message;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.GuideChatConf")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/base/model/message/h;", "", "", "type", "J", "getType", "()J", "setType", "(J)V", "imageId", "b", "setImageId", "", "imageIdStr", "Ljava/lang/String;", "getImageIdStr", "()Ljava/lang/String;", "setImageIdStr", "(Ljava/lang/String;)V", "imageText", "c", "setImageText", "Lpy/k;", "emoji", "Lpy/k;", "a", "()Lpy/k;", "setEmoji", "(Lpy/k;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h implements vh7.h {

    @SerializedName("emoji")
    protected py.k emoji;

    @SerializedName("image_id")
    protected long imageId;

    @SerializedName("image_id_str")
    protected String imageIdStr;

    @SerializedName("image_text")
    protected String imageText;

    @SerializedName("type")
    protected long type;

    public h() {
    }

    public final py.k a() {
        return this.emoji;
    }

    public final long b() {
        return this.imageId;
    }

    public final String c() {
        return this.imageText;
    }

    public final long getType() {
        return this.type;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public h(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.type = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.imageId = r5.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.imageIdStr = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.imageText = am3.h.c(r5);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.emoji = vh7.f.a(r5, py.k.class);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
