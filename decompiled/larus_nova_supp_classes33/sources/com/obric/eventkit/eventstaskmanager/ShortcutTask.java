package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b.\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0001OBu\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010(\u001a\u0004\u0018\u00010\u001a\u0012\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010+\u001a\u00020\u0011\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\bK\u0010LBY\b\u0016\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010(\u001a\u0004\u0018\u00010\u001a\u0012\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bK\u0010MJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001dHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010 \u001a\u00020\u0011HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!HÆ\u0003J\u008a\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010+\u001a\u00020\u00112\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0!HÆ\u0001¢\u0006\u0004\b-\u0010.J\t\u0010/\u001a\u00020\u0014HÖ\u0001R$\u0010$\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010%\u001a\u0004\u0018\u00010\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u00100\u001a\u0004\b5\u00102R$\u0010&\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u00106\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u00109R$\u0010'\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u00106\u001a\u0004\b:\u0010\u0018\"\u0004\b;\u00109R$\u0010(\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010<\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010?R0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0019\u0010*\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b*\u00100\u001a\u0004\bE\u00102R\u0017\u0010+\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b+\u0010F\u001a\u0004\b+\u0010GR\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006¢\u0006\f\n\u0004\b,\u0010H\u001a\u0004\bI\u0010J¨\u0006P"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTask;", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "equals", "hashCode", "", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "", "component5", "()Ljava/lang/Long;", "", "component6", "component7", "component8", "", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction;", "component9", "id", "name", "taskStatus", "enableStatus", "createTime", "ext", "shortInstruct", "isShortInstructEnable", "actions", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;ZLjava/util/List;)Lcom/obric/eventkit/eventstaskmanager/ShortcutTask;", "toString", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "Ljava/lang/Integer;", "getTaskStatus", "setTaskStatus", "(Ljava/lang/Integer;)V", "getEnableStatus", "setEnableStatus", "Ljava/lang/Long;", "getCreateTime", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getShortInstruct", "Z", "()Z", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;ZLjava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ShortcutTask extends EventTask {
    public static final Parcelable.Creator<ShortcutTask> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private final List<ShortcutTaskAction> actions;
    private Long createTime;
    private Integer enableStatus;
    private Map<String, String> ext;
    private String id;
    private final boolean isShortInstructEnable;
    private final String name;
    private final String shortInstruct;
    private Integer taskStatus;

    public static final class a implements Parcelable.Creator<ShortcutTask> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTask createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            Object r3 = EventTask.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTask");
            return (ShortcutTask) r3;
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTask[] newArray(int r1) {
            return new ShortcutTask[r1];
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public ShortcutTask(String r14, String r15, Integer r16, Integer r17, Long r18, Map<String, String> r19, Parcel r20) {
        Intrinsics.checkNotNullParameter(r20, "parcel");
        if (r16 != null) goto L6;
    L8:
        Integer r3 = r16;
    L9:
        if (r17 != null) goto L12;
    L14:
        Integer r4 = r17;
    L15:
        if (r18 != null) goto L18;
    L20:
        Long r5 = r18;
    L21:
        String r7 = r20.readString();
        if (r20.readInt() == 0) goto L24;
        boolean r8 = true;
    L25:
        List r0 = r20.createTypedArrayList(ShortcutTaskAction.CREATOR);
        if (r0 != null) goto L28;
        r0 = CollectionsKt.emptyList();
    L28:
        this(r14, r15, r3, r4, r5, r19, r7, r8, r0);
        readExtensionFieldFromParcel$eventstaskkit_release(r20);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r20, 0);
        return;
    L24:
        r8 = false;
        goto L25
    L18:
        if (r18.longValue() != (-1)) goto L20;
        r5 = null;
        goto L21
    L12:
        if (r17.intValue() != (-1)) goto L14;
        r4 = null;
        goto L15
    L6:
        if (r16.intValue() != (-1)) goto L8;
        r3 = null;
        goto L9
    }

    public ShortcutTask(String r11, String r12, Integer r13, Integer r14, Long r15, Map<String, String> r16, String r17, boolean r18, List<ShortcutTaskAction> r19) {
        Intrinsics.checkNotNullParameter(r19, "actions");
        super(3, r11, r12, r13, r14, r15, r16);
        this.id = r11;
        this.name = r12;
        this.taskStatus = r13;
        this.enableStatus = r14;
        this.createTime = r15;
        this.ext = r16;
        this.shortInstruct = r17;
        this.isShortInstructEnable = r18;
        this.actions = r19;
    }

    public /* synthetic */ ShortcutTask(String r14, String r15, Integer r16, Integer r17, Long r18, Map r19, String r20, boolean r21, List r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 32) == 0) goto L5;
        Map r9 = null;
    L7:
        if ((r23 & 64) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r23 & 128) == 0) goto L13;
        boolean r11 = false;
    L14:
        this(r14, r15, r16, r17, r18, r9, r10, r11, r22);
        return;
    L13:
        r11 = r21;
        goto L14
    L9:
        r10 = r20;
        goto L11
    L5:
        r9 = r19;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortcutTask copy$default(ShortcutTask r10, String r11, String r12, Integer r13, Integer r14, Long r15, Map r16, String r17, boolean r18, List r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.getId();
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.getName();
    L11:
        if ((r20 & 4) == 0) goto L13;
        Integer r4 = r10.getTaskStatus();
    L15:
        if ((r20 & 8) == 0) goto L17;
        Integer r5 = r10.getEnableStatus();
    L19:
        if ((r20 & 16) == 0) goto L21;
        Long r6 = r10.getCreateTime();
    L23:
        if ((r20 & 32) == 0) goto L25;
        Map r7 = r10.getExt();
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.shortInstruct;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r9 = r10.isShortInstructEnable;
    L35:
        if ((r20 & 256) == 0) goto L37;
        List r1 = r10.actions;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return getName();
    }

    public final Integer component3() {
        return getTaskStatus();
    }

    public final Integer component4() {
        return getEnableStatus();
    }

    public final Long component5() {
        return getCreateTime();
    }

    public final Map<String, String> component6() {
        return getExt();
    }

    public final String component7() {
        return this.shortInstruct;
    }

    public final boolean component8() {
        return this.isShortInstructEnable;
    }

    public final List<ShortcutTaskAction> component9() {
        return this.actions;
    }

    public final ShortcutTask copy(String r12, String r13, Integer r14, Integer r15, Long r16, Map<String, String> r17, String r18, boolean r19, List<ShortcutTaskAction> r20) {
        Intrinsics.checkNotNullParameter(r20, "actions");
        return new ShortcutTask(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (r3 == null) goto L8;
        Class<?> r1 = r3.getClass();
    L10:
        if (Intrinsics.areEqual(ShortcutTask.class, r1) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTask");
        return Intrinsics.areEqual(getId(), ((ShortcutTask) r3).getId());
    L8:
        r1 = null;
        goto L10
    }

    public final List<ShortcutTaskAction> getActions() {
        return this.actions;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public final String getShortInstruct() {
        return this.shortInstruct;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public int hashCode() {
        String r0 = getId();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
    }

    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    public void setExt(Map<String, String> r1) {
        this.ext = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    public String toString() {
        return "ShortcutTask(id=" + getId() + ", name=" + getName() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", createTime=" + getCreateTime() + ", ext=" + getExt() + ", shortInstruct=" + this.shortInstruct + ", isShortInstructEnable=" + this.isShortInstructEnable + ", actions=" + this.actions + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(0);
    }

    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeString(this.shortInstruct);
        r2.writeInt(this.isShortInstructEnable ? 1 : 0);
        r2.writeTypedList(this.actions);
        writeExtensionFieldToParcel$eventstaskkit_release(r2);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r2);
    }
}
