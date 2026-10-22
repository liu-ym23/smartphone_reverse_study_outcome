package sd0;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lsd0/c;", "", "", "msgId", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "f", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "itemId", "b", "", "title", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "itemType", "c", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", "a", "()Lcom/bytedance/android/live/base/model/message/a5;", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c {

    @SerializedName("display_text")
    private final a5 displayText;

    @SerializedName("item_id")
    private final Long itemId;

    @SerializedName("item_type")
    private final Long itemType;

    @SerializedName("msg_id")
    private final Long msgId;

    @SerializedName("title")
    private final String title;

    @SerializedName("user")
    private final IBaseUser user;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L18;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.msgId, r4.msgId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.user, r4.user) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.itemId, r4.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.itemType, r4.itemType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.displayText, r4.displayText) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.msgId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        IBaseUser r4 = this.user;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.itemId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.title;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.itemType;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        a5 r16 = this.displayText;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoShareResponse(msgId=" + this.msgId + ", user=" + this.user + ", itemId=" + this.itemId + ", title=" + this.title + ", itemType=" + this.itemType + ", displayText=" + this.displayText + ")";
    }

    public c() {
        this.msgId = null;
        this.user = null;
        this.itemId = null;
        this.title = null;
        this.itemType = null;
        this.displayText = null;
    }

    public final a5 a() {
        return this.displayText;
    }

    public final Long b() {
        return this.itemId;
    }

    public final Long c() {
        return this.itemType;
    }

    public final Long d() {
        return this.msgId;
    }

    public final String e() {
        return this.title;
    }

    public final IBaseUser f() {
        return this.user;
    }
}
