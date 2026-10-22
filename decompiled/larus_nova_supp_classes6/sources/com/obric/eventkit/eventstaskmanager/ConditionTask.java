package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.sva.sdk.data.ISmModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\b\u0087\b\u0018\u0000 i2\u00020\u0001:\u0001jB\u0085\u0001\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010-\u001a\u0004\u0018\u00010\u001a\u0012\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0006\u00100\u001a\u00020\"\u0012\u0006\u00101\u001a\u00020$\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u00103\u001a\u00020\u001a¢\u0006\u0004\bf\u0010gBY\b\u0016\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010-\u001a\u0004\u0018\u00010\u001a\u0012\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bf\u0010hJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001dHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fHÆ\u0003J\t\u0010#\u001a\u00020\"HÆ\u0003J\t\u0010%\u001a\u00020$HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010&HÆ\u0003J\t\u0010(\u001a\u00020\u001aHÆ\u0003J\u009e\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\b\u0002\u00100\u001a\u00020\"2\b\b\u0002\u00101\u001a\u00020$2\n\b\u0002\u00102\u001a\u0004\u0018\u00010&2\b\b\u0002\u00103\u001a\u00020\u001aHÆ\u0001¢\u0006\u0004\b4\u00105J\t\u00106\u001a\u00020\u0014HÖ\u0001R$\u0010)\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010*\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u00107\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R$\u0010+\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010>\u001a\u0004\b?\u0010\u0018\"\u0004\b@\u0010AR$\u0010,\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010>\u001a\u0004\bB\u0010\u0018\"\u0004\bC\u0010AR$\u0010-\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010D\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010GR0\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR(\u0010/\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u00100\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u00101\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u00102\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u00103\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006k"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "", "other", "", "equals", "hashCode", "", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "", "component5", "()Ljava/lang/Long;", "", "component6", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", "component7", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "component8", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "component9", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "component10", "component11", "id", "name", "taskStatus", "enableStatus", "createTime", "ext", "actions", "conditions", "periodicPolicy", "triggerControlPolicy", "nextTriggerTime", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;J)Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "toString", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "Ljava/lang/Integer;", "getTaskStatus", "setTaskStatus", "(Ljava/lang/Integer;)V", "getEnableStatus", "setEnableStatus", "Ljava/lang/Long;", "getCreateTime", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "getConditions", "()Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "setConditions", "(Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;)V", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "getPeriodicPolicy", "()Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "setPeriodicPolicy", "(Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;)V", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "getTriggerControlPolicy", "()Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "setTriggerControlPolicy", "(Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;)V", "J", "getNextTriggerTime", "()J", "setNextTriggerTime", "(J)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;J)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ConditionTask extends EventTask {
    public static final Parcelable.Creator<ConditionTask> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private List<ConditionTaskAction> actions;
    private ConditionGroup conditions;
    private Long createTime;
    private Integer enableStatus;
    private Map<String, String> ext;
    private String id;
    private String name;
    private long nextTriggerTime;
    private PeriodicPolicy periodicPolicy;
    private Integer taskStatus;
    private TriggerControlPolicy triggerControlPolicy;

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public ConditionTask(String r16, String r17, Integer r18, Integer r19, Long r20, Map<String, String> r21, Parcel r22) {
        Intrinsics.checkNotNullParameter(r22, "parcel");
        if (r18 != null) goto L6;
    L8:
        Integer r3 = r18;
    L9:
        if (r19 != null) goto L12;
    L14:
        Integer r4 = r19;
    L15:
        if (r20 != null) goto L18;
    L20:
        Long r5 = r20;
    L21:
        List r0 = r22.createTypedArrayList(ConditionTaskAction.CREATOR);
        if (r0 != null) goto L24;
        r0 = CollectionsKt.emptyList();
    L24:
        List r7 = r0;
        Parcelable r1 = r22.readParcelable(ConditionGroup.class.getClassLoader());
        Intrinsics.checkNotNull(r1);
        ConditionGroup r8 = (ConditionGroup) r1;
        Parcelable r2 = r22.readParcelable(PeriodicPolicy.class.getClassLoader());
        Intrinsics.checkNotNull(r2);
        this(r16, r17, r3, r4, r5, r21, r7, r8, (PeriodicPolicy) r2, (TriggerControlPolicy) r22.readParcelable(TriggerControlPolicy.class.getClassLoader()), r22.readLong());
        readExtensionFieldFromParcel$eventstaskkit_release(r22);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r22, 0);
        return;
    L18:
        if (r20.longValue() != (-1)) goto L20;
        r5 = null;
        goto L21
    L12:
        if (r19.intValue() != (-1)) goto L14;
        r4 = null;
        goto L15
    L6:
        if (r18.intValue() != (-1)) goto L8;
        r3 = null;
        goto L9
    }

    public ConditionTask(String r13, String r14, Integer r15, Integer r16, Long r17, Map<String, String> r18, List<ConditionTaskAction> r19, ConditionGroup r20, PeriodicPolicy r21, TriggerControlPolicy r22, long r23) {
        Intrinsics.checkNotNullParameter(r19, "actions");
        Intrinsics.checkNotNullParameter(r20, "conditions");
        Intrinsics.checkNotNullParameter(r21, "periodicPolicy");
        super(2, r13, r14, r15, r16, r17, r18);
        this.id = r13;
        this.name = r14;
        this.taskStatus = r15;
        this.enableStatus = r16;
        this.createTime = r17;
        this.ext = r18;
        this.actions = r19;
        this.conditions = r20;
        this.periodicPolicy = r21;
        this.triggerControlPolicy = r22;
        this.nextTriggerTime = r23;
    }

    public /* synthetic */ ConditionTask(String r17, String r18, Integer r19, Integer r20, Long r21, Map r22, List r23, ConditionGroup r24, PeriodicPolicy r25, TriggerControlPolicy r26, long r27, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 32) == 0) goto L5;
        Map r9 = null;
    L7:
        if ((r29 & ISmModel.VERSION_0200) == 0) goto L9;
        TriggerControlPolicy r13 = null;
    L11:
        if ((r29 & ISmModel.VERSION_0400) == 0) goto L13;
        long r14 = 0;
    L14:
        this(r17, r18, r19, r20, r21, r9, r23, r24, r25, r13, r14);
        return;
    L13:
        r14 = r27;
        goto L14
    L9:
        r13 = r26;
        goto L11
    L5:
        r9 = r22;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConditionTask copy$default(ConditionTask r14, String r15, String r16, Integer r17, Integer r18, Long r19, Map r20, List r21, ConditionGroup r22, PeriodicPolicy r23, TriggerControlPolicy r24, long r25, int r27, Object r28) {
        if ((r27 & 1) == 0) goto L5;
        String r2 = r14.getId();
    L7:
        if ((r27 & 2) == 0) goto L9;
        String r3 = r14.getName();
    L11:
        if ((r27 & 4) == 0) goto L13;
        Integer r4 = r14.getTaskStatus();
    L15:
        if ((r27 & 8) == 0) goto L17;
        Integer r5 = r14.getEnableStatus();
    L19:
        if ((r27 & 16) == 0) goto L21;
        Long r6 = r14.getCreateTime();
    L23:
        if ((r27 & 32) == 0) goto L25;
        Map r7 = r14.getExt();
    L27:
        if ((r27 & 64) == 0) goto L29;
        List r8 = r14.actions;
    L31:
        if ((r27 & 128) == 0) goto L33;
        ConditionGroup r9 = r14.conditions;
    L35:
        if ((r27 & ISmModel.VERSION_0100) == 0) goto L37;
        PeriodicPolicy r10 = r14.periodicPolicy;
    L39:
        if ((r27 & ISmModel.VERSION_0200) == 0) goto L41;
        TriggerControlPolicy r11 = r14.triggerControlPolicy;
    L43:
        if ((r27 & ISmModel.VERSION_0400) == 0) goto L45;
        long r12 = r14.nextTriggerTime;
    L47:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final String component1() {
        return getId();
    }

    public final TriggerControlPolicy component10() {
        return this.triggerControlPolicy;
    }

    public final long component11() {
        return this.nextTriggerTime;
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

    public final List<ConditionTaskAction> component7() {
        return this.actions;
    }

    public final ConditionGroup component8() {
        return this.conditions;
    }

    public final PeriodicPolicy component9() {
        return this.periodicPolicy;
    }

    public final ConditionTask copy(String r15, String r16, Integer r17, Integer r18, Long r19, Map<String, String> r20, List<ConditionTaskAction> r21, ConditionGroup r22, PeriodicPolicy r23, TriggerControlPolicy r24, long r25) {
        Intrinsics.checkNotNullParameter(r21, "actions");
        Intrinsics.checkNotNullParameter(r22, "conditions");
        Intrinsics.checkNotNullParameter(r23, "periodicPolicy");
        return new ConditionTask(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (r3 == null) goto L8;
        Class<?> r1 = r3.getClass();
    L10:
        if (Intrinsics.areEqual(ConditionTask.class, r1) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionTask");
        return Intrinsics.areEqual(getId(), ((ConditionTask) r3).getId());
    L8:
        r1 = null;
        goto L10
    }

    public final List<ConditionTaskAction> getActions() {
        return this.actions;
    }

    public final ConditionGroup getConditions() {
        return this.conditions;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Long getCreateTime() {
        return this.createTime;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Map<String, String> getExt() {
        return this.ext;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public String getId() {
        return this.id;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public String getName() {
        return this.name;
    }

    public final long getNextTriggerTime() {
        return this.nextTriggerTime;
    }

    public final PeriodicPolicy getPeriodicPolicy() {
        return this.periodicPolicy;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public final TriggerControlPolicy getTriggerControlPolicy() {
        return this.triggerControlPolicy;
    }

    public int hashCode() {
        String r0 = getId();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setActions(List<ConditionTaskAction> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.actions = r2;
    }

    public final void setConditions(ConditionGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.conditions = r2;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setExt(Map<String, String> r1) {
        this.ext = r1;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setId(String r1) {
        this.id = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public final void setNextTriggerTime(long r1) {
        this.nextTriggerTime = r1;
    }

    public final void setPeriodicPolicy(PeriodicPolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.periodicPolicy = r2;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    public final void setTriggerControlPolicy(TriggerControlPolicy r1) {
        this.triggerControlPolicy = r1;
    }

    public String toString() {
        return "ConditionTask(id=" + getId() + ", name=" + getName() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", createTime=" + getCreateTime() + ", ext=" + getExt() + ", actions=" + this.actions + ", conditions=" + this.conditions + ", periodicPolicy=" + this.periodicPolicy + ", triggerControlPolicy=" + this.triggerControlPolicy + ", nextTriggerTime=" + this.nextTriggerTime + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        super.writeToParcel(r3, r4);
        r3.writeTypedList(this.actions);
        r3.writeParcelable(this.conditions, r4);
        r3.writeParcelable(this.periodicPolicy, r4);
        r3.writeParcelable(this.triggerControlPolicy, r4);
        r3.writeLong(this.nextTriggerTime);
        writeExtensionFieldToParcel$eventstaskkit_release(r3);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r3);
    }
}
