package com.bytedance.android.livesdk.interactivity.api.expression;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.show.ShowEmojiListResponse.ResponseData")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/expression/ShowEmojiListResponse;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/expression/ShowEmojiInfo;", "defaultEmojis", "Ljava/util/List;", "getDefaultEmojis", "()Ljava/util/List;", "setDefaultEmojis", "(Ljava/util/List;)V", "seasonEmojis", "getSeasonEmojis", "setSeasonEmojis", BuildConfig.FLAVOR, "defaultEmojiExpire", "J", "getDefaultEmojiExpire", "()J", "setDefaultEmojiExpire", "(J)V", "<init>", "()V", "Companion", "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowEmojiListResponse implements Serializable, vh7.h {
    public static final a Companion = null;
    private static final long serialVersionUID = -8261076944491013552L;

    @SerializedName("default_emoji_expire")
    protected long defaultEmojiExpire;

    @SerializedName("default_emojis")
    protected List<ShowEmojiInfo> defaultEmojis;

    @SerializedName("season_emojis")
    protected List<ShowEmojiInfo> seasonEmojis;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShowEmojiListResponse() {
    }

    public final long getDefaultEmojiExpire() {
        return this.defaultEmojiExpire;
    }

    public final List<ShowEmojiInfo> getDefaultEmojis() {
        return this.defaultEmojis;
    }

    public final List<ShowEmojiInfo> getSeasonEmojis() {
        return this.seasonEmojis;
    }

    public ShowEmojiListResponse(am3.g r5) {
        this.defaultEmojis = new ArrayList();
        this.seasonEmojis = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L10;
        List<ShowEmojiInfo> r3 = this.seasonEmojis;
        ShowEmojiInfo r4 = new ShowEmojiInfo(r5);
    L15:
        r3.add(r4);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.defaultEmojiExpire = r5.j();
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L14:
        r3 = this.defaultEmojis;
        r4 = new ShowEmojiInfo(r5);
        goto L15
    L16:
        r5.d(r0);
    }

    public final void setDefaultEmojiExpire(long r1) {
        this.defaultEmojiExpire = r1;
    }

    public final void setDefaultEmojis(List<ShowEmojiInfo> r1) {
        this.defaultEmojis = r1;
    }

    public final void setSeasonEmojis(List<ShowEmojiInfo> r1) {
        this.seasonEmojis = r1;
    }
}
