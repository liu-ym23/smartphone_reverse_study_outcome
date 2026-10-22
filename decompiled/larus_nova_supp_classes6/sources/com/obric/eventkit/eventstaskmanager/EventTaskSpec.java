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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\t\b\u0017\u0018\u0000 52\u00020\u0001:\u00016Bo\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010.¢\u0006\u0004\b3\u00104J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR\u001c\u0010*\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"R\u001c\u0010,\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b-\u0010\"R(\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010.8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00067"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeExtensionFieldToParcel", "readExtensionFieldFromParcel$eventstaskkit_release", "readExtensionFieldFromParcel", "ourVersion", "readSubClassExtensionFieldFromParcel$eventstaskkit_release", "(Landroid/os/Parcel;I)V", "readSubClassExtensionFieldFromParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "describeContents", "type", "I", "getType", "()I", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "taskMode", "Ljava/lang/Integer;", "getTaskMode", "()Ljava/lang/Integer;", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "templateId", "getTemplateId", "taskStatus", "getTaskStatus", "enableStatus", "getEnableStatus", "", "ext", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public class EventTaskSpec implements Parcelable {
    public static final Parcelable.Creator<EventTaskSpec> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private final Integer enableStatus;
    private final Map<String, String> ext;
    private final String name;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;
    private final int type;

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public EventTaskSpec(int r1, String r2, Integer r3, TaskKnowledge r4, String r5, Integer r6, Integer r7, Map<String, String> r8) {
        this.type = r1;
        this.name = r2;
        this.taskMode = r3;
        this.taskKnowledge = r4;
        this.templateId = r5;
        this.taskStatus = r6;
        this.enableStatus = r7;
        this.ext = r8;
    }

    public /* synthetic */ EventTaskSpec(int r9, String r10, Integer r11, TaskKnowledge r12, String r13, Integer r14, Integer r15, Map r16, int r17, DefaultConstructorMarker r18) {
        Map r2 = null;
        if ((r17 & 2) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r17 & 4) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r17 & 8) == 0) goto L13;
        TaskKnowledge r4 = null;
    L15:
        if ((r17 & 16) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r17 & 32) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r17 & 64) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r17 & 128) != 0) goto L30;
        r2 = r16;
    L30:
        this(r9, r1, r3, r4, r5, r6, r7, r2);
        return;
    L25:
        r7 = r15;
        goto L27
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

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        int r0 = r5.readInt();
        ClassLoader r1 = EventTaskSpec.class.getClassLoader();
        if (r0 <= 0) goto L5;
        int r2 = 0;
    L6:
        int r3 = 1;
    L7:
        if (r3 > r2) goto L9;
        r3 = r3 + 1;
    L9:
        if (r3 > r0) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r5, r1);
        r3 = r3 + 1;
        goto L9
    L11:
        return;
    L5:
        r2 = r0;
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

    public final void writeExtensionFieldToParcel$eventstaskkit_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        r4.writeInt(this.type);
        r4.writeString(getName());
        Integer r0 = getTaskMode();
        int r1 = -1;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        r4.writeInt(r2);
        r4.writeParcelable(getTaskKnowledge(), r5);
        r4.writeString(getTemplateId());
        Integer r6 = getTaskStatus();
        if (r6 == null) goto L9;
        int r7 = r6.intValue();
    L10:
        r4.writeInt(r7);
        Integer r8 = getEnableStatus();
        if (r8 == null) goto L13;
        r1 = r8.intValue();
    L13:
        r4.writeInt(r1);
        if (Build.VERSION.SDK_INT < 33) goto L16;
        r4.writeMap(getExt());
        return;
    L16:
        Bundle r9 = new Bundle();
        Map<String, String> r3 = getExt();
        if (r3 == null) goto L22;
        Iterator<Map.Entry<String, String>> r10 = r3.entrySet().iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        Map.Entry<String, String> r11 = r10.next();
        r9.putString(r11.getKey(), r11.getValue());
    L22:
        r4.writeBundle(r9);
        return;
    L9:
        r7 = -1;
        goto L10
    L5:
        r2 = -1;
        goto L6
    }
}
