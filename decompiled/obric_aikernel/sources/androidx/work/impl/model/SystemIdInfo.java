package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {OaidModel.KEY_ID})}, primaryKeys = {"work_spec_id", "generation"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SystemIdInfo {

    @ColumnInfo(defaultValue = NetConst.NOT_ENCRYPT_VERISON_CODE)
    private final int generation;

    @JvmField
    @ColumnInfo(name = "system_id")
    public final int systemId;

    @JvmField
    @ColumnInfo(name = "work_spec_id")
    public final String workSpecId;

    public SystemIdInfo(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "workSpecId");
        this.workSpecId = r10;
        this.generation = r11;
        this.systemId = r12;
    }

    public static /* synthetic */ SystemIdInfo copy$default(SystemIdInfo r10, String r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.workSpecId;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.generation;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.systemId;
    L12:
        return r10.copy(r11, r12, r13);
    }

    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    public final int component3() {
        return this.systemId;
    }

    public final SystemIdInfo copy(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "workSpecId");
        return new SystemIdInfo(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemIdInfo) == true) goto L8;
        return false;
    L8:
        SystemIdInfo r11 = (SystemIdInfo) r10;
        if (Intrinsics.areEqual(this.workSpecId, r11.workSpecId) == true) goto L12;
        return false;
    L12:
        if (this.generation == r11.generation) goto L15;
        return false;
    L15:
        if (this.systemId == r11.systemId) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public int hashCode() {
        return (((this.workSpecId.hashCode() * 31) + Integer.hashCode(this.generation)) * 31) + Integer.hashCode(this.systemId);
    }

    public String toString() {
        return "SystemIdInfo(workSpecId=" + this.workSpecId + ", generation=" + this.generation + ", systemId=" + this.systemId + ')';
    }
}
