package p00;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lp00/c;", "", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "", "shouldPopup", "Z", "getShouldPopup", "()Z", "followScope", "getFollowScope", "prompts", "getPrompts", "livebroadcastbase-api_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("follow_scope")
    private final boolean followScope;

    @SerializedName("prompts")
    private final String prompts;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("follow_sync_popup")
    private final boolean shouldPopup;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L14;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L8;
        return false;
    L8:
        if (this.shouldPopup == r4.shouldPopup) goto L10;
        return false;
    L10:
        if (this.followScope == r4.followScope) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prompts, r4.prompts) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r0 = this.schema;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.shouldPopup;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.followScope;
        if (r8 == true) goto L13;
        r5 = r8;
    L13:
        int r9 = (r7 + r5) * 31;
        String r11 = this.prompts;
        if (r11 == null) goto L17;
        r1 = r11.hashCode();
    L17:
        return r9 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PreCreateInfo(schema=" + this.schema + ", shouldPopup=" + this.shouldPopup + ", followScope=" + this.followScope + ", prompts=" + this.prompts + ")";
    }
}
