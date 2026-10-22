package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.eventkit.utils.CronHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b!\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0001NBw\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0019\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c\u0012\u0006\u0010'\u001a\u00020\u0013\u0012\u0006\u0010(\u001a\u00020\u0013\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\bJ\u0010KBY\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0019\u0012\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bJ\u0010LJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0011J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001cHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0013HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0013HÆ\u0003J\u0012\u0010 \u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b \u0010\u001bJ\u0084\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c2\b\b\u0002\u0010'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u00132\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b*\u0010+J\t\u0010,\u001a\u00020\u0013HÖ\u0001J\t\u0010-\u001a\u00020\u0004HÖ\u0001J\u0013\u00100\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010.HÖ\u0003R$\u0010!\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b6\u00103R$\u0010#\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u00107\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010:R$\u0010$\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u00107\u001a\u0004\b;\u0010\u0017\"\u0004\b<\u0010:R$\u0010%\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010=\u001a\u0004\b>\u0010\u001b\"\u0004\b?\u0010@R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0017\u0010'\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b'\u00101\u001a\u0004\bF\u00103R\u0017\u0010(\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b(\u00101\u001a\u0004\bG\u00103R$\u0010)\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010=\u001a\u0004\bH\u0010\u001b\"\u0004\bI\u0010@¨\u0006O"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskV2;", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "", "isRepeat", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "toTimerTask", "", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "", "component5", "()Ljava/lang/Long;", "", "component6", "component7", "component8", "component9", "id", "name", "taskStatus", "enableStatus", "createTime", "ext", "cronExpr", "action", "nextScheduleTime", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/eventkit/eventstaskmanager/TimerTaskV2;", "toString", "hashCode", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "Ljava/lang/Integer;", "getTaskStatus", "setTaskStatus", "(Ljava/lang/Integer;)V", "getEnableStatus", "setEnableStatus", "Ljava/lang/Long;", "getCreateTime", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getCronExpr", "getAction", "getNextScheduleTime", "setNextScheduleTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class TimerTaskV2 extends EventTask {
    public static final Parcelable.Creator<TimerTaskV2> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private final String action;
    private Long createTime;
    private final String cronExpr;
    private Integer enableStatus;
    private Map<String, String> ext;
    private String id;
    private final String name;
    private Long nextScheduleTime;
    private Integer taskStatus;

    public static final class a implements Parcelable.Creator<TimerTaskV2> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTaskV2 createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            Object r3 = EventTask.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.TimerTaskV2");
            return (TimerTaskV2) r3;
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTaskV2[] newArray(int r1) {
            return new TimerTaskV2[r1];
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

    public TimerTaskV2(String r16, String r17, Integer r18, Integer r19, Long r20, Map<String, String> r21, Parcel r22) {
        Intrinsics.checkNotNullParameter(r22, "parcel");
        if (r18 != null) goto L6;
    L8:
        Integer r3 = r18;
    L9:
        if (r19 != null) goto L12;
    L14:
        Integer r4 = r19;
    L16:
        if (r20 != null) goto L19;
    L21:
        Long r5 = r20;
    L22:
        String r7 = TimerTaskKt.a(r22);
        String r8 = TimerTaskKt.a(r22);
        Long r6 = Long.valueOf(r22.readLong());
        if (r6.longValue() == (-1)) goto L25;
        boolean r1 = true;
    L26:
        if (r1 == false) goto L28;
        Long r9 = r6;
    L29:
        this(r16, r17, r3, r4, r5, r21, r7, r8, r9);
        readExtensionFieldFromParcel$eventstaskkit_release(r22);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r22, 0);
        return;
    L28:
        r9 = null;
        goto L29
    L25:
        r1 = false;
        goto L26
    L19:
        if (r20.longValue() != (-1)) goto L21;
        r5 = null;
        goto L22
    L12:
        if (r19.intValue() != (-1)) goto L14;
        r4 = null;
        goto L16
    L6:
        if (r18.intValue() != (-1)) goto L8;
        r3 = null;
        goto L9
    }

    public TimerTaskV2(String r12, String r13, Integer r14, Integer r15, Long r16, Map<String, String> r17, String r18, String r19, Long r20) {
        Intrinsics.checkNotNullParameter(r18, "cronExpr");
        Intrinsics.checkNotNullParameter(r19, "action");
        super(1, r12, r13, r14, r15, r16, r17);
        this.id = r12;
        this.name = r13;
        this.taskStatus = r14;
        this.enableStatus = r15;
        this.createTime = r16;
        this.ext = r17;
        this.cronExpr = r18;
        this.action = r19;
        this.nextScheduleTime = r20;
    }

    public /* synthetic */ TimerTaskV2(String r14, String r15, Integer r16, Integer r17, Long r18, Map r19, String r20, String r21, Long r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r23 & 4) == 0) goto L13;
        Integer r6 = null;
    L15:
        if ((r23 & 8) == 0) goto L17;
        Integer r7 = null;
    L19:
        if ((r23 & 16) == 0) goto L21;
        Long r8 = null;
    L23:
        if ((r23 & 32) == 0) goto L25;
        Map r9 = null;
    L27:
        if ((r23 & 256) == 0) goto L29;
        Long r12 = null;
    L30:
        this(r4, r5, r6, r7, r8, r9, r20, r21, r12);
        return;
    L29:
        r12 = r22;
        goto L30
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimerTaskV2 copy$default(TimerTaskV2 r10, String r11, String r12, Integer r13, Integer r14, Long r15, Map r16, String r17, String r18, Long r19, int r20, Object r21) {
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
        String r8 = r10.cronExpr;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = r10.action;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Long r1 = r10.nextScheduleTime;
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
        return this.cronExpr;
    }

    public final String component8() {
        return this.action;
    }

    public final Long component9() {
        return this.nextScheduleTime;
    }

    public final TimerTaskV2 copy(String r12, String r13, Integer r14, Integer r15, Long r16, Map<String, String> r17, String r18, String r19, Long r20) {
        Intrinsics.checkNotNullParameter(r18, "cronExpr");
        Intrinsics.checkNotNullParameter(r19, "action");
        return new TimerTaskV2(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TimerTaskV2) == true) goto L8;
        return false;
    L8:
        TimerTaskV2 r6 = (TimerTaskV2) r5;
        if (Intrinsics.areEqual(getId(), r6.getId()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getName(), r6.getName()) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getTaskStatus(), r6.getTaskStatus()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getEnableStatus(), r6.getEnableStatus()) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(getCreateTime(), r6.getCreateTime()) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(getExt(), r6.getExt()) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cronExpr, r6.cronExpr) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.nextScheduleTime, r6.nextScheduleTime) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public final String getCronExpr() {
        return this.cronExpr;
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

    public final Long getNextScheduleTime() {
        return this.nextScheduleTime;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public int hashCode() {
        int r1 = 0;
        if (getId() != null) goto L5;
        int r0 = 0;
    L6:
        int r2 = r0 * 31;
        if (getName() != null) goto L9;
        int r3 = 0;
    L10:
        int r4 = (r2 + r3) * 31;
        if (getTaskStatus() != null) goto L13;
        int r5 = 0;
    L14:
        int r6 = (r4 + r5) * 31;
        if (getEnableStatus() != null) goto L17;
        int r7 = 0;
    L18:
        int r8 = (r6 + r7) * 31;
        if (getCreateTime() != null) goto L21;
        int r9 = 0;
    L22:
        int r10 = (r8 + r9) * 31;
        if (getExt() != null) goto L25;
        int r11 = 0;
    L26:
        int r12 = (((((r10 + r11) * 31) + this.cronExpr.hashCode()) * 31) + this.action.hashCode()) * 31;
        Long r13 = this.nextScheduleTime;
        if (r13 == null) goto L31;
        r1 = r13.hashCode();
    L31:
        return r12 + r1;
    L25:
        r11 = getExt().hashCode();
        goto L26
    L21:
        r9 = getCreateTime().hashCode();
        goto L22
    L17:
        r7 = getEnableStatus().hashCode();
        goto L18
    L13:
        r5 = getTaskStatus().hashCode();
        goto L14
    L9:
        r3 = getName().hashCode();
        goto L10
    L5:
        r0 = getId().hashCode();
        goto L6
    }

    public final boolean isRepeat() {
        return CronHelper.INSTANCE.isTimeRecurring(this.cronExpr);
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

    public final void setNextScheduleTime(Long r1) {
        this.nextScheduleTime = r1;
    }

    public void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    public String toString() {
        return "TimerTaskV2(id=" + getId() + ", name=" + getName() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", createTime=" + getCreateTime() + ", ext=" + getExt() + ", cronExpr=" + this.cronExpr + ", action=" + this.action + ", nextScheduleTime=" + this.nextScheduleTime + ')';
    }

    public final TimerTask toTimerTask() {
        String r1 = this.cronExpr;
        String r2 = getName();
        String r3 = this.action;
        String r0 = getId();
        if (r0 == null) goto L5;
        Integer r4 = StringsKt.toIntOrNull(r0);
    L7:
        return new TimerTask(r1, r2, r3, r4, this.nextScheduleTime, getTaskStatus(), getEnableStatus(), getCreateTime(), getExt());
    L5:
        r4 = null;
        goto L7
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(0);
    }

    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        super.writeToParcel(r3, r4);
        r3.writeString(this.cronExpr);
        r3.writeString(this.action);
        Long r5 = this.nextScheduleTime;
        if (r5 == null) goto L5;
        long r0 = r5.longValue();
    L6:
        r3.writeLong(r0);
        writeExtensionFieldToParcel$eventstaskkit_release(r3);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r3);
        return;
    L5:
        r0 = -1;
        goto L6
    }
}
