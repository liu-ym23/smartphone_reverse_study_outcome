package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000 C2\u00020\u0001:\u0001CBa\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u00102\u001a\u00020\u0003H\u0016J\"\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\u0003H\u0016J\u0015\u0010:\u001a\u0002042\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b;J\u001d\u0010<\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010=\u001a\u00020\u0003H\u0000¢\u0006\u0002\b>J\u0015\u0010?\u001a\u0002042\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b@J\u0018\u0010A\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010B\u001a\u00020\u0003H\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010)¨\u0006D"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTask;", "Landroid/os/Parcelable;", "type", "", OaidModel.KEY_ID, "", ActivityLifecycle.NAME, "taskStatus", "enableStatus", "createTime", "", "ext", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEnableStatus", "()Ljava/lang/Integer;", "setEnableStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "setTaskKnowledge", "(Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;)V", "taskMode", "getTaskMode", "()I", "setTaskMode", "(I)V", "getTaskStatus", "setTaskStatus", "templateId", "getTemplateId", "setTemplateId", "getType", "describeContents", "onReadSubClassExtensionField", "", "parcel", "Landroid/os/Parcel;", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "readExtensionFieldFromParcel", "readExtensionFieldFromParcel$eventstaskkit_release", "readSubClassExtensionFieldFromParcel", "ourVersion", "readSubClassExtensionFieldFromParcel$eventstaskkit_release", "writeExtensionFieldToParcel", "writeExtensionFieldToParcel$eventstaskkit_release", "writeToParcel", "flags", "Companion", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class EventTask implements Parcelable {
    public static final Parcelable.Creator<EventTask> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 3;
    private Long createTime;
    private Integer enableStatus;
    private Map<String, String> ext;
    private String id;
    private final String name;
    private TaskKnowledge taskKnowledge;
    private int taskMode;
    private Integer taskStatus;
    private String templateId;
    private final int type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTask$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "FIELD_VERSION", "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/eventkit/eventstaskmanager/EventTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/EventTask;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<EventTask> {
        public b() {
        }

        public EventTask a(Parcel r15) {
            Intrinsics.checkNotNullParameter(r15, "parcel");
            int r14 = r15.readInt();
            String r1 = j.a(r15);
            String r2 = j.a(r15);
            int r0 = r15.readInt();
            int r3 = r15.readInt();
            long r4 = r15.readLong();
            if (Build.VERSION.SDK_INT < 33) goto L7;
            LinkedHashMap r6 = new LinkedHashMap();
            r15.readMap(r6, String.class.getClassLoader(), String.class, String.class);
            if ((!r6.isEmpty()) == true) goto L19;
        L18:
            r6 = null;
        L19:
            if (r14 == 1) goto L29;
            if (r14 == 2) goto L36;
            if (r14 != 3) goto L26;
            return new ShortcutTask(r1, r2, Integer.valueOf(r0), Integer.valueOf(r3), Long.valueOf(r4), r6, r15);
        L26:
            throw new IllegalArgumentException("Unknown event task type: " + r14);
        L36:
            return new ConditionTask(r1, r2, Integer.valueOf(r0), Integer.valueOf(r3), Long.valueOf(r4), r6, r15);
        L29:
            return new TimerTaskV2(r1, r2, Integer.valueOf(r0), Integer.valueOf(r3), Long.valueOf(r4), r6, r15);
        L7:
            Bundle r7 = r15.readBundle(EventTask.class.getClassLoader());
            if (r7 == null) goto L18;
            LinkedHashMap r9 = new LinkedHashMap();
            Set<String> r10 = r7.keySet();
            Intrinsics.checkNotNullExpressionValue(r10, "bundle.keySet()");
            Iterator<T> r11 = r10.iterator();
        L11:
            if (r11.hasNext() == false) goto L16;
            String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
            String r13 = r7.getString(r12);
            if (r13 == null) goto L11;
            Intrinsics.checkNotNullExpressionValue(r12, "key");
            Intrinsics.checkNotNullExpressionValue(r13, "it");
            r9.put(r12, r13);
            goto L11
        L16:
            if ((!r9.isEmpty()) == false) goto L18;
            r6 = r9;
            goto L19
        }

        public EventTask[] a(int r1) {
            return new EventTask[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EventTask createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EventTask[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new b();
    }

    public EventTask(int r3, String r4, String r5, Integer r6, Integer r7, Long r8, Map<String, String> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        this.type = r3;
        this.id = r4;
        this.name = r5;
        this.taskStatus = r6;
        this.enableStatus = r7;
        this.createTime = r8;
        this.ext = r10;
    }

    public /* synthetic */ EventTask(int r9, String r10, String r11, Integer r12, Integer r13, Long r14, Map r15, int r16, DefaultConstructorMarker r17) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        if ((r16 & 2) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r16 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r16 & 8) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r16 & 16) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r16 & 32) == 0) goto L21;
        Long r6 = null;
    L23:
        if ((r16 & 64) == 0) goto L25;
        r0 = null;
    L25:
        this(r9, r1, r3, r4, r5, r6, r0);
        return;
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public final TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    public final int getTaskMode() {
        return this.taskMode;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final int getType() {
        return this.type;
    }

    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r11) {
        Intrinsics.checkNotNullParameter(r11, "parcel");
        int r0 = r11.readInt();
        ClassLoader r1 = EventTask.class.getClassLoader();
        if (r0 <= 3) goto L5;
        int r3 = 3;
    L6:
        int r5 = 1;
    L7:
        if (r5 > r3) goto L24;
        if (r5 == 1) goto L22;
        TaskKnowledge r8 = null;
        String r9 = null;
        if (r5 == 2) goto L18;
        if (r5 != 3) goto L23;
        Object r7 = r11.readValue(r1);
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L17;
        r9 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
    L17:
        this.templateId = r9;
    L23:
        r5 = r5 + 1;
        goto L7
    L18:
        Object r10 = ParcelUtils.INSTANCE.readValueSafely(r11, r1);
        if (ZeusTransformUtils.instanceOf(r10, TaskKnowledge.class) == false) goto L21;
        r8 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(r10, TaskKnowledge.class, "com.obric.memorydata.plugin");
    L21:
        this.taskKnowledge = r8;
        goto L23
    L22:
        Object r12 = r11.readValue(r1);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Int");
        this.taskMode = ((Integer) ZeusTransformUtils.preCheckCast(r12, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L24:
        if (r5 > r0) goto L26;
        ParcelUtils.INSTANCE.skipValueSafely(r11, r1);
        r5 = r5 + 1;
        goto L24
    L26:
        return;
    L5:
        r3 = r0;
        goto L6
    }

    public final void readSubClassExtensionFieldFromParcel$eventstaskkit_release(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        int r0 = r4.readInt();
        if (r0 > r5) goto L6;
        r5 = r0;
    L6:
        ClassLoader r1 = EventTask.class.getClassLoader();
        int r2 = 1;
    L7:
        if (r2 > r5) goto L9;
        onReadSubClassExtensionField(r4, r1, r2);
        r2 = r2 + 1;
    L9:
        if (r2 > r0) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r4, r1);
        r2 = r2 + 1;
        goto L9
    }

    public void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    public void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public final void setTaskKnowledge(TaskKnowledge r1) {
        this.taskKnowledge = r1;
    }

    public final void setTaskMode(int r1) {
        this.taskMode = r1;
    }

    public void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    public final void setTemplateId(String r1) {
        this.templateId = r1;
    }

    public final void writeExtensionFieldToParcel$eventstaskkit_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(3);
        r2.writeValue(Integer.valueOf(this.taskMode));
        r2.writeValue(this.taskKnowledge);
        r2.writeValue(this.templateId);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeInt(this.type);
        r5.writeString(getId());
        r5.writeString(getName());
        Integer r7 = getTaskStatus();
        int r0 = -1;
        if (r7 == null) goto L5;
        int r8 = r7.intValue();
    L6:
        r5.writeInt(r8);
        Integer r9 = getEnableStatus();
        if (r9 == null) goto L9;
        r0 = r9.intValue();
    L9:
        r5.writeInt(r0);
        Long r10 = getCreateTime();
        if (r10 == null) goto L12;
        long r1 = r10.longValue();
    L13:
        r5.writeLong(r1);
        if (Build.VERSION.SDK_INT < 33) goto L16;
        r5.writeMap(getExt());
        return;
    L16:
        Bundle r11 = new Bundle();
        Map<String, String> r4 = getExt();
        if (r4 == null) goto L22;
        Iterator<Map.Entry<String, String>> r12 = r4.entrySet().iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r11.putString((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
    L22:
        r5.writeBundle(r11);
        return;
    L12:
        r1 = -1;
        goto L13
    L5:
        r8 = -1;
        goto L6
    }
}
