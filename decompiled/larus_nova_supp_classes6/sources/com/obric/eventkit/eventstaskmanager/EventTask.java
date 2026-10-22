package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u0000 J2\u00020\u0001:\u0001KBc\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u000103¢\u0006\u0004\bH\u0010IJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR$\u0010#\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R0\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u0001038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0017\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u001c\u001a\u0004\bF\u0010\u001e\"\u0004\bG\u0010 ¨\u0006L"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTask;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeExtensionFieldToParcel", "readExtensionFieldFromParcel$eventstaskkit_release", "readExtensionFieldFromParcel", "ourVersion", "readSubClassExtensionFieldFromParcel$eventstaskkit_release", "(Landroid/os/Parcel;I)V", "readSubClassExtensionFieldFromParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "describeContents", "type", "I", "getType", "()I", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "taskStatus", "Ljava/lang/Integer;", "getTaskStatus", "()Ljava/lang/Integer;", "setTaskStatus", "(Ljava/lang/Integer;)V", "enableStatus", "getEnableStatus", "setEnableStatus", "", "createTime", "Ljava/lang/Long;", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "", "ext", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "taskMode", "getTaskMode", "setTaskMode", "(I)V", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "setTaskKnowledge", "(Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;)V", "templateId", "getTemplateId", "setTemplateId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public class EventTask implements Parcelable {
    public static final Parcelable.Creator<EventTask> CREATOR = null;
    public static final b Companion = null;
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

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public EventTask(int r1, String r2, String r3, Integer r4, Integer r5, Long r6, Map<String, String> r7) {
        this.type = r1;
        this.id = r2;
        this.name = r3;
        this.taskStatus = r4;
        this.enableStatus = r5;
        this.createTime = r6;
        this.ext = r7;
    }

    public /* synthetic */ EventTask(int r8, String r9, String r10, Integer r11, Integer r12, Long r13, Map r14, int r15, DefaultConstructorMarker r16) {
        Map r1 = null;
        if ((r15 & 2) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r15 & 4) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r15 & 8) == 0) goto L13;
        Integer r3 = null;
    L15:
        if ((r15 & 16) == 0) goto L17;
        Integer r4 = null;
    L19:
        if ((r15 & 32) == 0) goto L21;
        Long r5 = null;
    L23:
        if ((r15 & 64) != 0) goto L26;
        r1 = r14;
    L26:
        this(r8, r0, r2, r3, r4, r5, r1);
        return;
    L21:
        r5 = r13;
        goto L23
    L17:
        r4 = r12;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r0 = r9;
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

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        int r0 = r10.readInt();
        ClassLoader r1 = EventTask.class.getClassLoader();
        if (r0 <= 3) goto L5;
        int r3 = 3;
    L6:
        int r5 = 1;
    L7:
        if (r5 > r3) goto L23;
        if (r5 == 1) goto L21;
        TaskKnowledge r7 = null;
        String r8 = null;
        if (r5 == 2) goto L17;
        if (r5 != 3) goto L22;
        Object r6 = r10.readValue(r1);
        if ((r6 instanceof String) == false) goto L16;
        r8 = (String) r6;
    L16:
        this.templateId = r8;
    L22:
        r5 = r5 + 1;
        goto L7
    L17:
        Object r9 = ParcelUtils.INSTANCE.readValueSafely(r10, r1);
        if ((r9 instanceof TaskKnowledge) == false) goto L20;
        r7 = (TaskKnowledge) r9;
    L20:
        this.taskKnowledge = r7;
        goto L22
    L21:
        Object r11 = r10.readValue(r1);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Int");
        this.taskMode = ((Integer) r11).intValue();
    L23:
        if (r5 > r0) goto L25;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r1);
        r5 = r5 + 1;
        goto L23
    L25:
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

    public void setExt(Map<String, String> r1) {
        this.ext = r1;
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
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        r4.writeInt(this.type);
        r4.writeString(getId());
        r4.writeString(getName());
        Integer r6 = getTaskStatus();
        int r0 = -1;
        if (r6 == null) goto L5;
        int r7 = r6.intValue();
    L6:
        r4.writeInt(r7);
        Integer r8 = getEnableStatus();
        if (r8 == null) goto L9;
        r0 = r8.intValue();
    L9:
        r4.writeInt(r0);
        Long r9 = getCreateTime();
        if (r9 == null) goto L12;
        long r1 = r9.longValue();
    L13:
        r4.writeLong(r1);
        if (Build.VERSION.SDK_INT < 33) goto L16;
        r4.writeMap(getExt());
        return;
    L16:
        Bundle r10 = new Bundle();
        Map<String, String> r2 = getExt();
        if (r2 == null) goto L22;
        Iterator<Map.Entry<String, String>> r3 = r2.entrySet().iterator();
    L20:
        if (r3.hasNext() == false) goto L22;
        Map.Entry<String, String> r11 = r3.next();
        r10.putString(r11.getKey(), r11.getValue());
    L22:
        r4.writeBundle(r10);
        return;
    L12:
        r1 = -1;
        goto L13
    L5:
        r7 = -1;
        goto L6
    }
}
