package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 92\u00020\u0001:\u00019Ba\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0099\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\"\u00100\u001a\u0002012\u0006\u0010\r\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0005H\u0016J\u0015\u00105\u001a\u0002012\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b6J\u0018\u00107\u001a\u0002012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0005H\u0016R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010\u001fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b,\u0010\u001fR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006:"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTaskSpec;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", ActivityLifecycle.NAME, "", "taskMode", "", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "templateId", "taskStatus", "enableStatus", "ext", "", "parcel", "Landroid/os/Parcel;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Landroid/os/Parcel;)V", "actions", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", "conditions", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "periodicPolicy", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "triggerControlPolicy", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;)V", "getActions", "()Ljava/util/List;", "getConditions", "()Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "getEnableStatus", "()Ljava/lang/Integer;", "setEnableStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExt", "()Ljava/util/Map;", "getName", "()Ljava/lang/String;", "getPeriodicPolicy", "()Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskMode", "getTaskStatus", "getTemplateId", "getTriggerControlPolicy", "()Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeSubClassExtensionFieldToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "writeToParcel", "flags", "Companion", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ConditionTaskSpec extends EventTaskSpec {
    public static final Parcelable.Creator<ConditionTaskSpec> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    private final List<ConditionTaskAction> actions;
    private final ConditionGroup conditions;
    private Integer enableStatus;
    private final Map<String, String> ext;
    private final String name;
    private final PeriodicPolicy periodicPolicy;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;
    private final TriggerControlPolicy triggerControlPolicy;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTaskSpec$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskSpec;", "FIELD_VERSION", "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/eventkit/eventstaskmanager/ConditionTaskSpec$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskSpec;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/ConditionTaskSpec;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<ConditionTaskSpec> {
        public b() {
        }

        public ConditionTaskSpec a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            EventTaskSpec r1 = EventTaskSpec.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionTaskSpec");
            return (ConditionTaskSpec) ZeusTransformUtils.preCheckCast(r1, ConditionTaskSpec.class, "com.obric.memorydata.plugin");
        }

        public ConditionTaskSpec[] a(int r1) {
            return new ConditionTaskSpec[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ConditionTaskSpec createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ConditionTaskSpec[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new b();
    }

    public ConditionTaskSpec(String r15, Integer r16, TaskKnowledge r17, String r18, Integer r19, Integer r20, Map<String, String> r21, Parcel r22) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r22, "parcel");
        if (r16 != null) goto L6;
    L8:
        Integer r3 = r16;
    L9:
        if (r19 != null) goto L12;
    L14:
        Integer r5 = r19;
    L15:
        if (r20 != null) goto L18;
    L20:
        Integer r6 = r20;
    L21:
        this(r15, r3, r17, r18, r5, r6, r7, r22.createTypedArrayList(ConditionTaskAction.CREATOR), (ConditionGroup) ZeusTransformUtils.preCheckCast(r22.readParcelable(ConditionGroup.class.getClassLoader()), ConditionGroup.class, "com.obric.memorydata.plugin"), (PeriodicPolicy) ZeusTransformUtils.preCheckCast(r22.readParcelable(PeriodicPolicy.class.getClassLoader()), PeriodicPolicy.class, "com.obric.memorydata.plugin"), (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(r22.readParcelable(TriggerControlPolicy.class.getClassLoader()), TriggerControlPolicy.class, "com.obric.memorydata.plugin"));
        readExtensionFieldFromParcel$eventstaskkit_release(r22);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r22, 0);
        return;
    L18:
        if (r20.intValue() != (-1)) goto L20;
        r6 = null;
        goto L21
    L12:
        if (r19.intValue() != (-1)) goto L14;
        r5 = null;
        goto L15
    L6:
        if (r16.intValue() != (-1)) goto L8;
        r3 = null;
        goto L9
    }

    public ConditionTaskSpec(String r13, Integer r14, TaskKnowledge r15, String r16, Integer r17, Integer r18, Map<String, String> r19, List<ConditionTaskAction> r20, ConditionGroup r21, PeriodicPolicy r22, TriggerControlPolicy r23) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        List<ConditionTaskAction> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        super(2, r13, r14, r15, r16, r17, r18, r10);
        this.name = r13;
        this.taskMode = r14;
        this.taskKnowledge = r15;
        this.templateId = r16;
        this.taskStatus = r17;
        this.enableStatus = r18;
        this.ext = r10;
        this.actions = r11;
        this.conditions = r21;
        this.periodicPolicy = r22;
        this.triggerControlPolicy = r23;
    }

    public /* synthetic */ ConditionTaskSpec(String r12, Integer r13, TaskKnowledge r14, String r15, Integer r16, Integer r17, Map r18, List r19, ConditionGroup r20, PeriodicPolicy r21, TriggerControlPolicy r22, int r23, DefaultConstructorMarker r24) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        TriggerControlPolicy r4 = null;
        if ((r23 & 2) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r23 & 4) == 0) goto L9;
        TaskKnowledge r5 = null;
    L11:
        if ((r23 & 8) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r23 & 16) == 0) goto L17;
        Integer r7 = null;
    L19:
        if ((r23 & 32) == 0) goto L21;
        Integer r8 = null;
    L23:
        if ((r23 & 64) == 0) goto L26;
        r1 = null;
    L26:
        if ((r23 & 128) == 0) goto L29;
        r2 = null;
    L29:
        if ((r23 & 256) == 0) goto L31;
        ConditionGroup r9 = null;
    L33:
        if ((r23 & 512) == 0) goto L35;
        PeriodicPolicy r10 = null;
    L37:
        if ((r23 & 1024) != 0) goto L40;
        r4 = r22;
    L40:
        this(r12, r3, r5, r6, r7, r8, r1, r2, r9, r10, r4);
        return;
    L35:
        r10 = r21;
        goto L37
    L31:
        r9 = r20;
        goto L33
    L21:
        r8 = r17;
        goto L23
    L17:
        r7 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public final List<ConditionTaskAction> getActions() {
        return this.actions;
    }

    public final ConditionGroup getConditions() {
        return this.conditions;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Map<String, String> getExt() {
        return this.ext;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public String getName() {
        return this.name;
    }

    public final PeriodicPolicy getPeriodicPolicy() {
        return this.periodicPolicy;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Integer getTaskMode() {
        return this.taskMode;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public String getTemplateId() {
        return this.templateId;
    }

    public final TriggerControlPolicy getTriggerControlPolicy() {
        return this.triggerControlPolicy;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeTypedList(this.actions);
        r2.writeParcelable(this.conditions, r3);
        r2.writeParcelable(this.periodicPolicy, r3);
        r2.writeParcelable(this.triggerControlPolicy, r3);
        writeExtensionFieldToParcel$eventstaskkit_release(r2);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r2);
    }
}
