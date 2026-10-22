package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import com.obric.eventkit.utils.CronHelper;
import com.obric.sva.sdk.data.ISmModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Deprecated(message = "use TimerTaskV2 instead")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b \b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0001GBw\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019¢\u0006\u0004\bC\u0010DB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bC\u0010EJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\t\u0010\u000e\u001a\u00020\rHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010\u0010\u001a\u00020\rHÆ\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0012J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0012J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019HÆ\u0003J\u0084\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b$\u0010%J\t\u0010&\u001a\u00020\rHÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003R\u0017\u0010\u001b\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b.\u0010-R\u0017\u0010\u001d\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b/\u0010-R$\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00100\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u00103R$\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00104\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u00107R$\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u00100\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u00103R$\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u00100\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u00103R$\u0010\"\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u00104\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u00107R0\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "Lcom/obric/eventkit/eventstaskmanager/BaseTask;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "isRepeat", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskV2;", "toTimerTaskV2", "", "component1", "component2", "component3", "component4", "()Ljava/lang/Integer;", "", "component5", "()Ljava/lang/Long;", "component6", "component7", "component8", "", "component9", "cronExpr", "name", "action", "id", "nextScheduleTime", "taskStatus", "enableStatus", "createTime", "ext", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getCronExpr", "()Ljava/lang/String;", "getName", "getAction", "Ljava/lang/Integer;", "getId", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Long;", "getNextScheduleTime", "setNextScheduleTime", "(Ljava/lang/Long;)V", "getTaskStatus", "setTaskStatus", "getEnableStatus", "setEnableStatus", "getCreateTime", "setCreateTime", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class TimerTask extends BaseTask {
    public static final a CREATOR = null;
    private static final int INVALID_INT_VALUE = -1;
    private static final long INVALID_LONG_VALUE = -1;
    private final String action;
    private Long createTime;
    private final String cronExpr;
    private Integer enableStatus;
    private Map<String, String> ext;
    private Integer id;
    private final String name;
    private Long nextScheduleTime;
    private Integer taskStatus;

    static {
        CREATOR = new a();
    }

    public TimerTask(Parcel r14) {
        Intrinsics.checkNotNullParameter(r14, "parcel");
        this(TimerTaskKt.a(r14), r14.readString(), TimerTaskKt.a(r14), Integer.valueOf(r14.readInt()), Long.valueOf(r14.readLong()), Integer.valueOf(r14.readInt()), Integer.valueOf(r14.readInt()), Long.valueOf(r14.readLong()), null, ISmModel.VERSION_0100, null);
        if (Build.VERSION.SDK_INT < 33) goto L7;
        LinkedHashMap r0 = new LinkedHashMap();
        r14.readMap(r0, TimerTask.class.getClassLoader(), String.class, String.class);
        if ((!r0.isEmpty()) == false) goto L16;
    L6:
        this.ext = r0;
    L16:
        Integer r15 = this.id;
        if (r15 != null) goto L20;
    L22:
        Long r16 = this.nextScheduleTime;
        if (r16 != null) goto L26;
    L28:
        Integer r17 = this.taskStatus;
        if (r17 != null) goto L32;
    L34:
        Integer r18 = this.enableStatus;
        if (r18 != null) goto L38;
    L40:
        Long r19 = this.createTime;
        if (r19 != null) goto L44;
        return;
    L44:
        if (r19.longValue() != INVALID_LONG_VALUE) goto L50;
        this.createTime = null;
        return;
    L50:
        return;
    L38:
        if (r18.intValue() != (-1)) goto L40;
        this.enableStatus = null;
        goto L40
    L32:
        if (r17.intValue() != (-1)) goto L34;
        this.taskStatus = null;
        goto L34
    L26:
        if (r16.longValue() != INVALID_LONG_VALUE) goto L28;
        this.nextScheduleTime = null;
        goto L28
    L20:
        if (r15.intValue() != (-1)) goto L22;
        this.id = null;
        goto L22
    L7:
        Bundle r110 = r14.readBundle(TimerTask.class.getClassLoader());
        if (r110 == null) goto L16;
        r0 = new LinkedHashMap();
        Iterator<T> r1 = r110.keySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L6;
        String r2 = (String) r1.next();
        String r3 = r110.getString(r2);
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r0.put(r2, r3);
        goto L11
    }

    public TimerTask(String r2, String r3, String r4, Integer r5, Long r6, Integer r7, Integer r8, Long r9, Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r2, "cronExpr");
        Intrinsics.checkNotNullParameter(r4, "action");
        this.cronExpr = r2;
        this.name = r3;
        this.action = r4;
        this.id = r5;
        this.nextScheduleTime = r6;
        this.taskStatus = r7;
        this.enableStatus = r8;
        this.createTime = r9;
        this.ext = r10;
    }

    public /* synthetic */ TimerTask(String r14, String r15, String r16, Integer r17, Long r18, Integer r19, Integer r20, Long r21, Map r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r23 & 8) == 0) goto L9;
        Integer r7 = null;
    L11:
        if ((r23 & 16) == 0) goto L13;
        Long r8 = null;
    L15:
        if ((r23 & 32) == 0) goto L17;
        Integer r9 = null;
    L19:
        if ((r23 & 64) == 0) goto L21;
        Integer r10 = null;
    L23:
        if ((r23 & 128) == 0) goto L25;
        Long r11 = null;
    L27:
        if ((r23 & ISmModel.VERSION_0100) == 0) goto L29;
        Map r12 = null;
    L30:
        this(r14, r5, r16, r7, r8, r9, r10, r11, r12);
        return;
    L29:
        r12 = r22;
        goto L30
    L25:
        r11 = r21;
        goto L27
    L21:
        r10 = r20;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimerTask copy$default(TimerTask r10, String r11, String r12, String r13, Integer r14, Long r15, Integer r16, Integer r17, Long r18, Map r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.cronExpr;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.name;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.action;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Integer r5 = r10.id;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Long r6 = r10.nextScheduleTime;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Integer r7 = r10.taskStatus;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Integer r8 = r10.enableStatus;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Long r9 = r10.createTime;
    L35:
        if ((r20 & ISmModel.VERSION_0100) == 0) goto L37;
        Map r1 = r10.ext;
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
        return this.cronExpr;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.action;
    }

    public final Integer component4() {
        return this.id;
    }

    public final Long component5() {
        return this.nextScheduleTime;
    }

    public final Integer component6() {
        return this.taskStatus;
    }

    public final Integer component7() {
        return this.enableStatus;
    }

    public final Long component8() {
        return this.createTime;
    }

    public final Map<String, String> component9() {
        return this.ext;
    }

    public final TimerTask copy(String r12, String r13, String r14, Integer r15, Long r16, Integer r17, Integer r18, Long r19, Map<String, String> r20) {
        Intrinsics.checkNotNullParameter(r12, "cronExpr");
        Intrinsics.checkNotNullParameter(r14, "action");
        return new TimerTask(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TimerTask) == true) goto L8;
        return false;
    L8:
        TimerTask r6 = (TimerTask) r5;
        if (Intrinsics.areEqual(this.cronExpr, r6.cronExpr) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.nextScheduleTime, r6.nextScheduleTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.taskStatus, r6.taskStatus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.enableStatus, r6.enableStatus) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getCronExpr() {
        return this.cronExpr;
    }

    public final Integer getEnableStatus() {
        return this.enableStatus;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getNextScheduleTime() {
        return this.nextScheduleTime;
    }

    public final Integer getTaskStatus() {
        return this.taskStatus;
    }

    public int hashCode() {
        int r0 = this.cronExpr.hashCode() * 31;
        String r1 = this.name;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.action.hashCode()) * 31;
        Integer r5 = this.id;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.nextScheduleTime;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.taskStatus;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.enableStatus;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.createTime;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Map<String, String> r20 = this.ext;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return r19 + r2;
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final boolean isRepeat() {
        return CronHelper.INSTANCE.isTimeRecurring(this.cronExpr);
    }

    public final void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    public final void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    public final void setExt(Map<String, String> r1) {
        this.ext = r1;
    }

    public final void setId(Integer r1) {
        this.id = r1;
    }

    public final void setNextScheduleTime(Long r1) {
        this.nextScheduleTime = r1;
    }

    public final void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    public String toString() {
        return "TimerTask(cronExpr=" + this.cronExpr + ", name=" + this.name + ", action=" + this.action + ", id=" + this.id + ", nextScheduleTime=" + this.nextScheduleTime + ", taskStatus=" + this.taskStatus + ", enableStatus=" + this.enableStatus + ", createTime=" + this.createTime + ", ext=" + this.ext + ')';
    }

    public final TimerTaskV2 toTimerTaskV2() {
        Integer r0 = this.id;
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L7:
        return new TimerTaskV2(r1, this.name, this.taskStatus, this.enableStatus, this.createTime, this.ext, this.cronExpr, this.action, this.nextScheduleTime);
    L5:
        r1 = null;
        goto L7
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parcel");
        r6.writeString(this.cronExpr);
        r6.writeString(this.name);
        r6.writeString(this.action);
        Integer r8 = this.id;
        int r0 = -1;
        if (r8 == null) goto L5;
        int r9 = r8.intValue();
    L6:
        r6.writeInt(r9);
        Long r10 = this.nextScheduleTime;
        long r1 = INVALID_LONG_VALUE;
        if (r10 == null) goto L9;
        long r3 = r10.longValue();
    L10:
        r6.writeLong(r3);
        Integer r11 = this.taskStatus;
        if (r11 == null) goto L13;
        int r12 = r11.intValue();
    L14:
        r6.writeInt(r12);
        Integer r13 = this.enableStatus;
        if (r13 == null) goto L17;
        r0 = r13.intValue();
    L17:
        r6.writeInt(r0);
        Long r14 = this.createTime;
        if (r14 == null) goto L20;
        r1 = r14.longValue();
    L20:
        r6.writeLong(r1);
        if (Build.VERSION.SDK_INT < 33) goto L23;
        r6.writeMap(this.ext);
        return;
    L23:
        Bundle r15 = new Bundle();
        Map<String, String> r2 = this.ext;
        if (r2 == null) goto L29;
        Iterator<Map.Entry<String, String>> r4 = r2.entrySet().iterator();
    L27:
        if (r4.hasNext() == false) goto L29;
        Map.Entry<String, String> r5 = r4.next();
        r15.putString(r5.getKey(), r5.getValue());
    L29:
        r6.writeBundle(r15);
        return;
    L13:
        r12 = -1;
        goto L14
    L9:
        r3 = -1;
        goto L10
    L5:
        r9 = -1;
        goto L6
    }
}
