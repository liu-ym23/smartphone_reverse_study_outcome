package bs8;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JR\u0010\u001d\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0005\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/larus/bmhome/taskskill/model/RecentExposedSkillResponse;", "", "slots", "", "Lcom/larus/bmhome/taskskill/model/ExposedSkillSlot;", "isDefault", "", "updatedAt", "", "hasFilled", "config", "Lcom/larus/bmhome/taskskill/model/ExposedSkillConfig;", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/larus/bmhome/taskskill/model/ExposedSkillConfig;)V", "getSlots", "()Ljava/util/List;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUpdatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHasFilled", "getConfig", "()Lcom/larus/bmhome/taskskill/model/ExposedSkillConfig;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/larus/bmhome/taskskill/model/ExposedSkillConfig;)Lcom/larus/bmhome/taskskill/model/RecentExposedSkillResponse;", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("config")
    private final b config;

    @SerializedName("has_filled")
    private final Boolean hasFilled;

    @SerializedName("is_default")
    private final Boolean isDefault;

    @SerializedName("slots")
    private final List<com.larus.bmhome.taskskill.model.a> slots;

    @SerializedName("updated_at")
    private final Long updatedAt;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.slots, r6.slots) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isDefault, r6.isDefault) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.updatedAt, r6.updatedAt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hasFilled, r6.hasFilled) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.config, r6.config) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<com.larus.bmhome.taskskill.model.a> r0 = this.slots;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isDefault;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.updatedAt;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.hasFilled;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        b r13 = this.config;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "RecentExposedSkillResponse(slots=" + this.slots + ", isDefault=" + this.isDefault + ", updatedAt=" + this.updatedAt + ", hasFilled=" + this.hasFilled + ", config=" + this.config + ')';
    }

    public i() {
        this.slots = null;
        this.isDefault = null;
        this.updatedAt = null;
        this.hasFilled = null;
        this.config = null;
    }

    public final b a() {
        return this.config;
    }

    public final List<com.larus.bmhome.taskskill.model.a> b() {
        return this.slots;
    }
}
