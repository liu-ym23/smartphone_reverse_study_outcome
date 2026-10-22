package com.bytedance.android.livesdk.interactivity.api.expression;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.show.ShowEmojiInfo")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/expression/ShowEmojiInfo;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "emojiId", "J", "getEmojiId", "()J", "setEmojiId", "(J)V", BuildConfig.FLAVOR, "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", BuildConfig.FLAVOR, "loadedBefore", "Z", "getLoadedBefore", "()Z", "setLoadedBefore", "(Z)V", "<init>", "()V", "Companion", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowEmojiInfo implements Serializable, vh7.h {
    public static final a Companion = null;
    private static final long serialVersionUID = -4765097929532159131L;

    @SerializedName("emoji_id")
    protected long emojiId;

    @SerializedName("image")
    protected ImageModel image;
    private transient boolean loadedBefore;

    @SerializedName("name")
    protected String name;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShowEmojiInfo() {
    }

    public final long getEmojiId() {
        return this.emojiId;
    }

    public final ImageModel getImage() {
        return this.image;
    }

    public final boolean getLoadedBefore() {
        return this.loadedBefore;
    }

    public final String getName() {
        return this.name;
    }

    public ShowEmojiInfo(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.emojiId = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.name = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.image = x.a(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public final void setEmojiId(long r1) {
        this.emojiId = r1;
    }

    public final void setImage(ImageModel r1) {
        this.image = r1;
    }

    public final void setLoadedBefore(boolean r1) {
        this.loadedBefore = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }
}
