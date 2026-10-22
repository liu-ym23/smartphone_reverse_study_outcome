package c59;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.dynamic.dsl.DslActionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0000HÆ\u0003J_\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0000HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00008\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00008\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006&"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "", "type", "Lcom/larus/dora/impl/dynamic/dsl/DslActionType;", "url", "", "data", "", "tracker", "Lcom/larus/dora/impl/dynamic/dsl/DslActionTracker;", "successAction", "failureAction", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslActionType;Ljava/lang/String;Ljava/util/Map;Lcom/larus/dora/impl/dynamic/dsl/DslActionTracker;Lcom/larus/dora/impl/dynamic/dsl/DslAction;Lcom/larus/dora/impl/dynamic/dsl/DslAction;)V", "getType", "()Lcom/larus/dora/impl/dynamic/dsl/DslActionType;", "getUrl", "()Ljava/lang/String;", "getData", "()Ljava/util/Map;", "getTracker", "()Lcom/larus/dora/impl/dynamic/dsl/DslActionTracker;", "getSuccessAction", "()Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "getFailureAction", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("action_data")
    private final Map<String, Object> data;

    @SerializedName("failure_action")
    private final b failureAction;

    @SerializedName("success_action")
    private final b successAction;

    @SerializedName("action_tracker")
    private final c tracker;

    @SerializedName("action_type")
    private final DslActionType type;

    @SerializedName("action_url")
    private final String url;

    public b() {
        this(null, null, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tracker, r6.tracker) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.successAction, r6.successAction) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.failureAction, r6.failureAction) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        DslActionType r0 = this.type;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.url;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Object> r7 = this.data;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        c r10 = this.tracker;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        b r13 = this.successAction;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        b r16 = this.failureAction;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DslAction(type=" + this.type + ", url=" + this.url + ", data=" + this.data + ", tracker=" + this.tracker + ", successAction=" + this.successAction + ", failureAction=" + this.failureAction + ')';
    }

    public final Map<String, Object> a() {
        return this.data;
    }

    public final b b() {
        return this.failureAction;
    }

    public final b c() {
        return this.successAction;
    }

    public final c d() {
        return this.tracker;
    }

    public final String e() {
        return this.url;
    }

    public final DslActionType getType() {
        return this.type;
    }

    public b(DslActionType r3, String r4, Map r5, c r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = null;
    L14:
        this.type = r3;
        this.url = r4;
        this.data = r5;
        this.tracker = r6;
        this.successAction = null;
        this.failureAction = null;
    }
}
