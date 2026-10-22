package m11;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lm11/b;", "", "", "id", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "belongUserId", "b", "setBelongUserId", "(Ljava/lang/String;)V", "", "talking", "I", "e", "()I", "g", "(I)V", "silenceStatus", "d", "f", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("belong_user_id")
    private String belongUserId;

    @SerializedName("id")
    private final String id;

    @SerializedName("silence_status")
    private int silenceStatus;

    @SerializedName("talking")
    private int talking;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L14;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.belongUserId, r4.belongUserId) == true) goto L10;
        return false;
    L10:
        if (this.talking == r4.talking) goto L12;
        return false;
    L12:
        if (this.silenceStatus == r4.silenceStatus) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.belongUserId;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((((r3 + r1) * 31) + this.talking) * 31) + this.silenceStatus;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AiAssistantTalkStatus(id=" + this.id + ", belongUserId=" + this.belongUserId + ", talking=" + this.talking + ", silenceStatus=" + this.silenceStatus + ")";
    }

    public final String b() {
        return this.belongUserId;
    }

    public final String c() {
        return this.id;
    }

    public final int d() {
        return this.silenceStatus;
    }

    public final int e() {
        return this.talking;
    }

    public static b a(b r4) {
        String r0 = r4.id;
        String r1 = r4.belongUserId;
        int r2 = r4.talking;
        int r3 = r4.silenceStatus;
        r4.getClass();
        return new b(r0, r1, r2, r3);
    }

    public final void f(int r1) {
        this.silenceStatus = r1;
    }

    public final void g(int r1) {
        this.talking = r1;
    }

    public b(String r1, String r2, int r3, int r4) {
        this.id = r1;
        this.belongUserId = r2;
        this.talking = r3;
        this.silenceStatus = r4;
    }
}
