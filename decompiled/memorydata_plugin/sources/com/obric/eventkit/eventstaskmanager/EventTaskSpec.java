package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000 .2\u00020\u0001:\u0001.Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001d\u001a\u00020\u0003H\u0016J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0003H\u0016J\u0015\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b&J\u001d\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020\u0003H\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b+J\u0018\u0010,\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010-\u001a\u00020\u0003H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "Landroid/os/Parcelable;", "type", "", ActivityLifecycle.NAME, "", "taskMode", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "templateId", "taskStatus", "enableStatus", "ext", "", "(ILjava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;)V", "getEnableStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExt", "()Ljava/util/Map;", "getName", "()Ljava/lang/String;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskMode", "getTaskStatus", "getTemplateId", "getType", "()I", "describeContents", "onReadSubClassExtensionField", "", "parcel", "Landroid/os/Parcel;", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "readExtensionFieldFromParcel", "readExtensionFieldFromParcel$eventstaskkit_release", "readSubClassExtensionFieldFromParcel", "ourVersion", "readSubClassExtensionFieldFromParcel$eventstaskkit_release", "writeExtensionFieldToParcel", "writeExtensionFieldToParcel$eventstaskkit_release", "writeToParcel", "flags", "Companion", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class EventTaskSpec implements Parcelable {
    public static final Parcelable.Creator<EventTaskSpec> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    private final Integer enableStatus;
    private final Map<String, String> ext;
    private final String name;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;
    private final int type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "FIELD_VERSION", "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/eventkit/eventstaskmanager/EventTaskSpec$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<EventTaskSpec> {
        public b() {
        }

        public EventTaskSpec a(Parcel r15) {
            Intrinsics.checkNotNullParameter(r15, "parcel");
            int r14 = r15.readInt();
            String r1 = r15.readString();
            int r0 = r15.readInt();
            TaskKnowledge r3 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(r15.readParcelable(EventTaskSpec.class.getClassLoader()), TaskKnowledge.class, "com.obric.memorydata.plugin");
            String r5 = r15.readString();
            int r2 = r15.readInt();
            int r6 = r15.readInt();
            if (Build.VERSION.SDK_INT < 33) goto L7;
            LinkedHashMap r4 = new LinkedHashMap();
            r15.readMap(r4, String.class.getClassLoader(), String.class, String.class);
            if ((!r4.isEmpty()) == false) goto L18;
            LinkedHashMap r7 = r4;
        L20:
            if (r14 == 2) goto L27;
            if (r14 != 3) goto L25;
            return new ShortcutTaskSpec(r1, Integer.valueOf(r0), r3, r5, Integer.valueOf(r2), Integer.valueOf(r6), r7, r15);
        L25:
            throw new IllegalArgumentException("Unknown event task type: " + r14);
        L27:
            return new ConditionTaskSpec(r1, Integer.valueOf(r0), r3, r5, Integer.valueOf(r2), Integer.valueOf(r6), r7, r15);
        L18:
            r7 = null;
            goto L20
        L7:
            Bundle r8 = r15.readBundle(EventTaskSpec.class.getClassLoader());
            if (r8 == null) goto L18;
            LinkedHashMap r9 = new LinkedHashMap();
            Set<String> r10 = r8.keySet();
            Intrinsics.checkNotNullExpressionValue(r10, "bundle.keySet()");
            Iterator<T> r11 = r10.iterator();
        L11:
            if (r11.hasNext() == false) goto L16;
            String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
            String r13 = r8.getString(r12);
            if (r13 == null) goto L11;
            Intrinsics.checkNotNullExpressionValue(r12, "key");
            Intrinsics.checkNotNullExpressionValue(r13, "it");
            r9.put(r12, r13);
            goto L11
        L16:
            if ((!r9.isEmpty()) == false) goto L18;
            r7 = r9;
            goto L20
        }

        public EventTaskSpec[] a(int r1) {
            return new EventTaskSpec[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EventTaskSpec createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EventTaskSpec[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new b();
    }

    public EventTaskSpec(int r3, String r4, Integer r5, TaskKnowledge r6, String r7, Integer r8, Integer r9, Map<String, String> r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        this.type = r3;
        this.name = r4;
        this.taskMode = r5;
        this.taskKnowledge = r6;
        this.templateId = r7;
        this.taskStatus = r8;
        this.enableStatus = r9;
        this.ext = r11;
    }

    public /* synthetic */ EventTaskSpec(int r10, String r11, Integer r12, TaskKnowledge r13, String r14, Integer r15, Integer r16, Map r17, int r18, DefaultConstructorMarker r19) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin");
        if ((r18 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r18 & 4) == 0) goto L9;
        Integer r4 = null;
    L11:
        if ((r18 & 8) == 0) goto L13;
        TaskKnowledge r5 = null;
    L15:
        if ((r18 & 16) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r18 & 32) == 0) goto L21;
        Integer r7 = null;
    L23:
        if ((r18 & 64) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r18 & 128) == 0) goto L29;
        r1 = null;
    L29:
        this(r10, r2, r4, r5, r6, r7, r8, r1);
        return;
    L25:
        r8 = r16;
        goto L27
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public String getName() {
        return this.name;
    }

    public TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    public Integer getTaskMode() {
        return this.taskMode;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public final int getType() {
        return this.type;
    }

    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        int r3 = r4.readInt();
        ClassLoader r0 = EventTaskSpec.class.getClassLoader();
        if (r3 <= 0) goto L5;
        int r1 = 0;
    L6:
        int r2 = 1;
    L7:
        if (r2 > r1) goto L9;
        r2 = r2 + 1;
    L9:
        if (r2 > r3) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r4, r0);
        r2 = r2 + 1;
        goto L9
    L11:
        return;
    L5:
        r1 = r3;
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

    public final void writeExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeInt(this.type);
        r5.writeString(getName());
        Integer r0 = getTaskMode();
        int r1 = -1;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        r5.writeInt(r2);
        r5.writeParcelable(getTaskKnowledge(), r6);
        r5.writeString(getTemplateId());
        Integer r7 = getTaskStatus();
        if (r7 == null) goto L9;
        int r8 = r7.intValue();
    L10:
        r5.writeInt(r8);
        Integer r9 = getEnableStatus();
        if (r9 == null) goto L13;
        r1 = r9.intValue();
    L13:
        r5.writeInt(r1);
        if (Build.VERSION.SDK_INT < 33) goto L16;
        r5.writeMap(getExt());
        return;
    L16:
        Bundle r10 = new Bundle();
        Map<String, String> r4 = getExt();
        if (r4 == null) goto L22;
        Iterator<Map.Entry<String, String>> r11 = r4.entrySet().iterator();
    L20:
        if (r11.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r10.putString((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.memorydata.plugin"));
    L22:
        r5.writeBundle(r10);
        return;
    L9:
        r8 = -1;
        goto L10
    L5:
        r2 = -1;
        goto L6
    }
}
