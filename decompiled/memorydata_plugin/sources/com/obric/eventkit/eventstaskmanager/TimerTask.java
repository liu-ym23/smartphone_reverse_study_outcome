package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.eventkit.utils.CronHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "use TimerTaskV2 instead")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bu\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0017\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011HÆ\u0003J\u0082\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\nH\u0016J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\nHÖ\u0001J\u0006\u0010<\u001a\u000208J\t\u0010=\u001a\u00020\u0006HÖ\u0001J\u0006\u0010>\u001a\u00020?J\u0018\u0010@\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\nH\u0016R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001e\u0010\r\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001e¨\u0006D"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "Lcom/obric/eventkit/eventstaskmanager/BaseTask;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "cronExpr", "", ActivityLifecycle.NAME, "action", OaidModel.KEY_ID, "", "nextScheduleTime", "", "taskStatus", "enableStatus", "createTime", "ext", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)V", "getAction", "()Ljava/lang/String;", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCronExpr", "getEnableStatus", "()Ljava/lang/Integer;", "setEnableStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getId", "setId", "getName", "getNextScheduleTime", "setNextScheduleTime", "getTaskStatus", "setTaskStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "describeContents", "equals", "", "other", "", "hashCode", "isRepeat", "toString", "toTimerTaskV2", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskV2;", "writeToParcel", "", "flags", "CREATOR", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "()V", "INVALID_INT_VALUE", "", "INVALID_LONG_VALUE", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<TimerTask> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public TimerTask a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new TimerTask(r1);
        }

        public TimerTask[] a(int r1) {
            return new TimerTask[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TimerTask createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TimerTask[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public TimerTask(Parcel r15) {
        Intrinsics.checkNotNullParameter(r15, "parcel");
        this(j.a(r15), r15.readString(), j.a(r15), Integer.valueOf(r15.readInt()), Long.valueOf(r15.readLong()), Integer.valueOf(r15.readInt()), Integer.valueOf(r15.readInt()), Long.valueOf(r15.readLong()), null, 256, null);
        if (Build.VERSION.SDK_INT < 33) goto L7;
        LinkedHashMap r1 = new LinkedHashMap();
        r15.readMap(r1, TimerTask.class.getClassLoader(), String.class, String.class);
        if ((!r1.isEmpty()) == false) goto L17;
        this.ext = r1;
    L17:
        Integer r16 = this.id;
        if (r16 != null) goto L21;
    L23:
        Long r17 = this.nextScheduleTime;
        if (r17 != null) goto L27;
    L29:
        Integer r18 = this.taskStatus;
        if (r18 != null) goto L33;
    L35:
        Integer r19 = this.enableStatus;
        if (r19 != null) goto L39;
    L41:
        Long r110 = this.createTime;
        if (r110 != null) goto L45;
        return;
    L45:
        if (r110.longValue() != (-1)) goto L51;
        this.createTime = null;
        return;
    L51:
        return;
    L39:
        if (r19.intValue() != (-1)) goto L41;
        this.enableStatus = null;
        goto L41
    L33:
        if (r18.intValue() != (-1)) goto L35;
        this.taskStatus = null;
        goto L35
    L27:
        if (r17.longValue() != (-1)) goto L29;
        this.nextScheduleTime = null;
        goto L29
    L21:
        if (r16.intValue() != (-1)) goto L23;
        this.id = null;
        goto L23
    L7:
        Bundle r111 = r15.readBundle(TimerTask.class.getClassLoader());
        if (r111 == null) goto L17;
        LinkedHashMap r0 = new LinkedHashMap();
        Set<String> r2 = r111.keySet();
        Intrinsics.checkNotNullExpressionValue(r2, "it.keySet()");
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        String r5 = r111.getString(r4);
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        Intrinsics.checkNotNullExpressionValue(r5, "it.getString(key) ?: \"\"");
        r0.put(r4, r5);
        goto L11
    L16:
        this.ext = r0;
        goto L17
    }

    public TimerTask(String r3, String r4, String r5, Integer r6, Long r7, Integer r8, Integer r9, Long r10, Map<String, String> r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "cronExpr");
        Intrinsics.checkNotNullParameter(r5, "action");
        this.cronExpr = r3;
        this.name = r4;
        this.action = r5;
        this.id = r6;
        this.nextScheduleTime = r7;
        this.taskStatus = r8;
        this.enableStatus = r9;
        this.createTime = r10;
        this.ext = r12;
    }

    public /* synthetic */ TimerTask(String r15, String r16, String r17, Integer r18, Long r19, Integer r20, Integer r21, Long r22, Map r23, int r24, DefaultConstructorMarker r25) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        if ((r24 & 2) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r24 & 8) == 0) goto L9;
        Integer r8 = null;
    L11:
        if ((r24 & 16) == 0) goto L13;
        Long r9 = null;
    L15:
        if ((r24 & 32) == 0) goto L17;
        Integer r10 = null;
    L19:
        if ((r24 & 64) == 0) goto L21;
        Integer r11 = null;
    L23:
        if ((r24 & 128) == 0) goto L25;
        Long r12 = null;
    L27:
        if ((r24 & 256) == 0) goto L29;
        Map r13 = null;
    L30:
        this(r15, r6, r17, r8, r9, r10, r11, r12, r13);
        return;
    L29:
        r13 = r1;
        goto L30
    L25:
        r12 = r22;
        goto L27
    L21:
        r11 = r21;
        goto L23
    L17:
        r10 = r20;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public static /* synthetic */ TimerTask copy$default(TimerTask r11, String r12, String r13, String r14, Integer r15, Long r16, Integer r17, Integer r18, Long r19, Map r20, int r21, Object r22) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        if ((r21 & 1) == 0) goto L5;
        String r3 = r11.cronExpr;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r4 = r11.name;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r5 = r11.action;
    L15:
        if ((r21 & 8) == 0) goto L17;
        Integer r6 = r11.id;
    L19:
        if ((r21 & 16) == 0) goto L21;
        Long r7 = r11.nextScheduleTime;
    L23:
        if ((r21 & 32) == 0) goto L25;
        Integer r8 = r11.taskStatus;
    L27:
        if ((r21 & 64) == 0) goto L29;
        Integer r9 = r11.enableStatus;
    L31:
        if ((r21 & 128) == 0) goto L33;
        Long r10 = r11.createTime;
    L35:
        if ((r21 & 256) == 0) goto L37;
        Map<String, String> r1 = r11.ext;
    L39:
        return r11.copy(r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L37:
        r1 = r2;
        goto L39
    L33:
        r10 = r19;
        goto L35
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
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
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "cronExpr");
        Intrinsics.checkNotNullParameter(r14, "action");
        return new TimerTask(r12, r13, r14, r15, r16, r17, r18, r19, r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TimerTask.class) == true) goto L8;
        return false;
    L8:
        TimerTask r6 = (TimerTask) ZeusTransformUtils.preCheckCast(r5, TimerTask.class, "com.obric.memorydata.plugin");
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

    public final void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
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
        long r1 = -1;
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
        Map<String, String> r5 = this.ext;
        if (r5 == null) goto L29;
        Iterator<Map.Entry<String, String>> r16 = r5.entrySet().iterator();
    L27:
        if (r16.hasNext() == false) goto L29;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r15.putString((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
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
