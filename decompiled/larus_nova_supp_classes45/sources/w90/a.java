package w90;

import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiRes;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lw90/a;", "", "Lcom/bytedance/android/live/emoji/online/model/OnlineSmallEmojiRes;", "resources", "Lcom/bytedance/android/live/emoji/online/model/OnlineSmallEmojiRes;", "getResources", "()Lcom/bytedance/android/live/emoji/online/model/OnlineSmallEmojiRes;", "", "emojiStatus", "I", "a", "()I", "iosResources", "getIosResources", "iosEmojiStatus", "getIosEmojiStatus", "liveemoji-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("android_emoji_status")
    private final int emojiStatus;

    @SerializedName("ios_emoji_status")
    private final int iosEmojiStatus;

    @SerializedName("ios_emoji_resource")
    private final OnlineSmallEmojiRes iosResources;

    @SerializedName("android_emoji_resource")
    private final OnlineSmallEmojiRes resources;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L14;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.resources, r4.resources) == true) goto L8;
        return false;
    L8:
        if (this.emojiStatus == r4.emojiStatus) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.iosResources, r4.iosResources) == true) goto L12;
        return false;
    L12:
        if (this.iosEmojiStatus == r4.iosEmojiStatus) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        OnlineSmallEmojiRes r0 = this.resources;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.emojiStatus) * 31;
        OnlineSmallEmojiRes r4 = this.iosResources;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.iosEmojiStatus;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OnlineSmallEmojiResponse(resources=" + this.resources + ", emojiStatus=" + this.emojiStatus + ", iosResources=" + this.iosResources + ", iosEmojiStatus=" + this.iosEmojiStatus + ")";
    }

    public final int a() {
        return this.emojiStatus;
    }

    public final OnlineSmallEmojiRes getResources() {
        return this.resources;
    }
}
