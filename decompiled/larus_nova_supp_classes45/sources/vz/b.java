package vz;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u000f\u001a\u0004\b*\u0010\u0011R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018¨\u0006-"}, d2 = {"Lvz/b;", "", "", "policyId", "Ljava/lang/String;", "getPolicyId", "()Ljava/lang/String;", "policyName", "getPolicyName", "owner", "getOwner", "description", "getDescription", "", "liveRoomStatePolicyPriority", "Ljava/lang/Integer;", "getLiveRoomStatePolicyPriority", "()Ljava/lang/Integer;", "category", "getCategory", "", "event", "Ljava/util/Set;", "getEvent", "()Ljava/util/Set;", "intent", "getIntent", "source", "getSource", "", "conditions", "Ljava/util/Map;", "getConditions", "()Ljava/util/Map;", "", "permission", "Ljava/lang/Boolean;", "getPermission", "()Ljava/lang/Boolean;", "reason", "getReason", "affectedStrategy", "getAffectedStrategy", "affectedResources", "getAffectedResources", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("affectedResources")
    private final Set<Integer> affectedResources;

    @SerializedName("affectedStrategy")
    private final Integer affectedStrategy;

    @SerializedName("category")
    private final String category;

    @SerializedName("conditions")
    private final Map<String, String> conditions;

    @SerializedName("description")
    private final String description;

    @SerializedName("event")
    private final Set<Integer> event;

    @SerializedName("intent")
    private final Integer intent;

    @SerializedName("liveRoomStatePolicyPriority")
    private final Integer liveRoomStatePolicyPriority;

    @SerializedName("owner")
    private final String owner;

    @SerializedName("permission")
    private final Boolean permission;

    @SerializedName("policyId")
    private final String policyId;

    @SerializedName("policyName")
    private final String policyName;

    @SerializedName("reason")
    private final String reason;

    @SerializedName("source")
    private final String source;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L34;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.policyId, r4.policyId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.policyName, r4.policyName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.owner, r4.owner) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r4.description) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.liveRoomStatePolicyPriority, r4.liveRoomStatePolicyPriority) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.category, r4.category) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.event, r4.event) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.intent, r4.intent) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.source, r4.source) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.conditions, r4.conditions) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.permission, r4.permission) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.reason, r4.reason) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.affectedStrategy, r4.affectedStrategy) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.affectedResources, r4.affectedResources) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public final int hashCode() {
        String r0 = this.policyId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.policyName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.owner;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.description;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        Integer r14 = this.liveRoomStatePolicyPriority;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.category;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        Set<Integer> r21 = this.event;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        Integer r24 = this.intent;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        String r27 = this.source;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        Map<String, String> r31 = this.conditions;
        if (r31 == null) goto L41;
        int r32 = r31.hashCode();
    L42:
        int r33 = (r29 + r32) * 31;
        Boolean r34 = this.permission;
        if (r34 == null) goto L45;
        int r35 = r34.hashCode();
    L46:
        int r36 = (r33 + r35) * 31;
        String r37 = this.reason;
        if (r37 == null) goto L49;
        int r38 = r37.hashCode();
    L50:
        int r39 = (r36 + r38) * 31;
        Integer r41 = this.affectedStrategy;
        if (r41 == null) goto L53;
        int r42 = r41.hashCode();
    L54:
        int r43 = (r39 + r42) * 31;
        Set<Integer> r44 = this.affectedResources;
        if (r44 == null) goto L58;
        r1 = r44.hashCode();
    L58:
        return r43 + r1;
    L53:
        r42 = 0;
        goto L54
    L49:
        r38 = 0;
        goto L50
    L45:
        r35 = 0;
        goto L46
    L41:
        r32 = 0;
        goto L42
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
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
        return "RoomStatusPolicyConfig(policyId=" + this.policyId + ", policyName=" + this.policyName + ", owner=" + this.owner + ", description=" + this.description + ", liveRoomStatePolicyPriority=" + this.liveRoomStatePolicyPriority + ", category=" + this.category + ", event=" + this.event + ", intent=" + this.intent + ", source=" + this.source + ", conditions=" + this.conditions + ", permission=" + this.permission + ", reason=" + this.reason + ", affectedStrategy=" + this.affectedStrategy + ", affectedResources=" + this.affectedResources + ")";
    }
}
