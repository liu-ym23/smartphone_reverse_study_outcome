package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001CB\u009b\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010%\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:¢\u0006\u0004\b?\u0010@Bc\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010%\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b?\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R$\u0010!\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010$R(\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001f\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u00101\u001a\u0004\u0018\u0001008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0019\u00106\u001a\u0004\u0018\u0001058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0019\u0010;\u001a\u0004\u0018\u00010:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006D"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTaskSpec;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "taskMode", "Ljava/lang/Integer;", "getTaskMode", "()Ljava/lang/Integer;", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "templateId", "getTemplateId", "taskStatus", "getTaskStatus", "enableStatus", "getEnableStatus", "setEnableStatus", "(Ljava/lang/Integer;)V", "", "ext", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "conditions", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "getConditions", "()Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "periodicPolicy", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "getPeriodicPolicy", "()Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "triggerControlPolicy", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "getTriggerControlPolicy", "()Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;)V", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ConditionTaskSpec extends EventTaskSpec {
    public static final Parcelable.Creator<ConditionTaskSpec> CREATOR = null;
    public static final b Companion = null;
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

    public static final class a implements Parcelable.Creator<ConditionTaskSpec> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTaskSpec createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            Object r3 = EventTaskSpec.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionTaskSpec");
            return (ConditionTaskSpec) r3;
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTaskSpec[] newArray(int r1) {
            return new ConditionTaskSpec[r1];
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

    public ConditionTaskSpec(String r15, Integer r16, TaskKnowledge r17, String r18, Integer r19, Integer r20, Map<String, String> r21, Parcel r22) {
        Intrinsics.checkNotNullParameter(r22, "parcel");
        if (r16 != null) goto L6;
    L8:
        Integer r2 = r16;
    L9:
        if (r19 != null) goto L12;
    L14:
        Integer r5 = r19;
    L15:
        if (r20 != null) goto L18;
    L20:
        Integer r6 = r20;
    L21:
        this(r15, r2, r17, r18, r5, r6, r21, r22.createTypedArrayList(ConditionTaskAction.CREATOR), r22.readParcelable(ConditionGroup.class.getClassLoader()), r22.readParcelable(PeriodicPolicy.class.getClassLoader()), r22.readParcelable(TriggerControlPolicy.class.getClassLoader()));
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
        r2 = null;
        goto L9
    }

    public ConditionTaskSpec(String r11, Integer r12, TaskKnowledge r13, String r14, Integer r15, Integer r16, Map<String, String> r17, List<ConditionTaskAction> r18, ConditionGroup r19, PeriodicPolicy r20, TriggerControlPolicy r21) {
        super(2, r11, r12, r13, r14, r15, r16, r17);
        this.name = r11;
        this.taskMode = r12;
        this.taskKnowledge = r13;
        this.templateId = r14;
        this.taskStatus = r15;
        this.enableStatus = r16;
        this.ext = r17;
        this.actions = r18;
        this.conditions = r19;
        this.periodicPolicy = r20;
        this.triggerControlPolicy = r21;
    }

    public /* synthetic */ ConditionTaskSpec(String r12, Integer r13, TaskKnowledge r14, String r15, Integer r16, Integer r17, Map r18, List r19, ConditionGroup r20, PeriodicPolicy r21, TriggerControlPolicy r22, int r23, DefaultConstructorMarker r24) {
        TriggerControlPolicy r2 = null;
        if ((r23 & 2) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r23 & 4) == 0) goto L9;
        TaskKnowledge r3 = null;
    L11:
        if ((r23 & 8) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r23 & 16) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r23 & 32) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r23 & 64) == 0) goto L25;
        Map r7 = null;
    L27:
        if ((r23 & 128) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r23 & 256) == 0) goto L33;
        ConditionGroup r9 = null;
    L35:
        if ((r23 & 512) == 0) goto L37;
        PeriodicPolicy r10 = null;
    L39:
        if ((r23 & 1024) != 0) goto L42;
        r2 = r22;
    L42:
        this(r12, r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }

    public final List<ConditionTaskAction> getActions() {
        return this.actions;
    }

    public final ConditionGroup getConditions() {
        return this.conditions;
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

    public final PeriodicPolicy getPeriodicPolicy() {
        return this.periodicPolicy;
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

    public final TriggerControlPolicy getTriggerControlPolicy() {
        return this.triggerControlPolicy;
    }

    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(0);
    }

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
