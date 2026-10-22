package tf0;

import com.bytedance.android.live.liveinteract.linkbase.api.SeatItemId;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001a"}, d2 = {"Ltf0/d;", "", "Lcom/bytedance/android/live/liveinteract/linkbase/api/SeatItemId;", "itemId", "Lcom/bytedance/android/live/liveinteract/linkbase/api/SeatItemId;", "a", "()Lcom/bytedance/android/live/liveinteract/linkbase/api/SeatItemId;", "f", "(Lcom/bytedance/android/live/liveinteract/linkbase/api/SeatItemId;)V", "", "visible", "I", "d", "()I", "setVisible", "(I)V", "", "userId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "position", "b", "setPosition", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class d {

    @SerializedName("item_id")
    private SeatItemId itemId;

    @SerializedName("position")
    private int position;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("visible")
    private int visible;

    public d() {
        this(0);
    }

    public String toString() {
        return "{itemId = " + this.itemId.name() + ", visible = " + this.visible + ", userId = " + this.userId + ", position = " + this.position + '}';
    }

    public final SeatItemId a() {
        return this.itemId;
    }

    public final int b() {
        return this.position;
    }

    public final String c() {
        return this.userId;
    }

    public final int d() {
        return this.visible;
    }

    public d(int r3) {
        SeatItemId r4 = SeatItemId.UNKNOWN;
        Intrinsics.checkNotNullParameter(r4, "itemId");
        Intrinsics.checkNotNullParameter("", "userId");
        this.itemId = r4;
        this.visible = 0;
        this.userId = "";
        this.position = -1;
    }

    public boolean e(d r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if ((!Intrinsics.areEqual(getClass(), r5.getClass())) == true) goto L21;
        if (this.itemId == r5.itemId) goto L13;
    L19:
        return false;
    L13:
        if (this.visible != r5.visible) goto L19;
        if (Intrinsics.areEqual(this.userId, r5.userId) == false) goto L19;
        if (this.position != r5.position) goto L19;
        return true;
    }

    public final void f(SeatItemId r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.itemId = r2;
    }
}
