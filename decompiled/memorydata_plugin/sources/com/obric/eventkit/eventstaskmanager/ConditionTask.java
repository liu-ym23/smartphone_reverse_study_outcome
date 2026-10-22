package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u0000 `2\u00020\u0001:\u0001`BW\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB\u0083\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t¢\u0006\u0002\u0010\u0019J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010J\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0017\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\t\u0010M\u001a\u00020\u0013HÆ\u0003J\t\u0010N\u001a\u00020\u0015HÆ\u0003J\u009c\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0096\u0002J\b\u0010U\u001a\u00020\u0006H\u0016J\"\u0010V\u001a\u00020W2\u0006\u0010\f\u001a\u00020\r2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020\u0006H\u0016J\t\u0010[\u001a\u00020\u0003HÖ\u0001J\u0015\u0010\\\u001a\u00020W2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b]J\u0018\u0010^\u001a\u00020W2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010_\u001a\u00020\u0006H\u0016R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b>\u0010(\"\u0004\b?\u0010*R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006a"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", OaidModel.KEY_ID, "", ActivityLifecycle.NAME, "taskStatus", "", "enableStatus", "createTime", "", "ext", "", "parcel", "Landroid/os/Parcel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Landroid/os/Parcel;)V", "actions", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", "conditions", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "periodicPolicy", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "triggerControlPolicy", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "nextTriggerTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;J)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "getConditions", "()Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "setConditions", "(Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEnableStatus", "()Ljava/lang/Integer;", "setEnableStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getNextTriggerTime", "()J", "setNextTriggerTime", "(J)V", "getPeriodicPolicy", "()Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "setPeriodicPolicy", "(Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;)V", "getTaskStatus", "setTaskStatus", "getTriggerControlPolicy", "()Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "setTriggerControlPolicy", "(Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;J)Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "equals", "", "other", "", "hashCode", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "toString", "writeSubClassExtensionFieldToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "writeToParcel", "flags", "Companion", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ConditionTask extends EventTask {
    public static final Parcelable.Creator<ConditionTask> CREATOR = null;
    public static final a Companion = null;
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTask$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "FIELD_VERSION", "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/eventkit/eventstaskmanager/ConditionTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<ConditionTask> {
        public b() {
        }

        public ConditionTask a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            EventTask r1 = EventTask.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionTask");
            return (ConditionTask) ZeusTransformUtils.preCheckCast(r1, ConditionTask.class, "com.obric.memorydata.plugin");
        }

        public ConditionTask[] a(int r1) {
            return new ConditionTask[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ConditionTask createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ConditionTask[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new b();
    }

    public ConditionTask(String r16, String r17, Integer r18, Integer r19, Long r20, Map<String, String> r21, Parcel r22) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
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
        List r0 = r22.createTypedArrayList(ConditionTaskAction.CREATOR);
        if (r0 != null) goto L25;
        r0 = CollectionsKt.emptyList();
    L25:
        List r7 = r0;
        Parcelable r1 = r22.readParcelable(ConditionGroup.class.getClassLoader());
        Intrinsics.checkNotNull(r1);
        ConditionGroup r8 = (ConditionGroup) ZeusTransformUtils.preCheckCast(r1, ConditionGroup.class, "com.obric.memorydata.plugin");
        Parcelable r2 = r22.readParcelable(PeriodicPolicy.class.getClassLoader());
        Intrinsics.checkNotNull(r2);
        this(r16, r17, r3, r4, r5, r6, r7, r8, (PeriodicPolicy) ZeusTransformUtils.preCheckCast(r2, PeriodicPolicy.class, "com.obric.memorydata.plugin"), (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(r22.readParcelable(TriggerControlPolicy.class.getClassLoader()), TriggerControlPolicy.class, "com.obric.memorydata.plugin"), r22.readLong());
        readExtensionFieldFromParcel$eventstaskkit_release(r22);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r22, 0);
        return;
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

    public ConditionTask(String r14, String r15, Integer r16, Integer r17, Long r18, Map<String, String> r19, List<ConditionTaskAction> r20, ConditionGroup r21, PeriodicPolicy r22, TriggerControlPolicy r23, long r24) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        List<ConditionTaskAction> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "actions");
        Intrinsics.checkNotNullParameter(r21, "conditions");
        Intrinsics.checkNotNullParameter(r22, "periodicPolicy");
        super(2, r14, r15, r16, r17, r18, r11);
        this.id = r14;
        this.name = r15;
        this.taskStatus = r16;
        this.enableStatus = r17;
        this.createTime = r18;
        this.ext = r11;
        this.actions = r12;
        this.conditions = r21;
        this.periodicPolicy = r22;
        this.triggerControlPolicy = r23;
        this.nextTriggerTime = r24;
    }

    public /* synthetic */ ConditionTask(String r17, String r18, Integer r19, Integer r20, Long r21, Map r22, List r23, ConditionGroup r24, PeriodicPolicy r25, TriggerControlPolicy r26, long r27, int r29, DefaultConstructorMarker r30) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        if ((r29 & 32) == 0) goto L5;
        Map r9 = null;
    L7:
        if ((r29 & 512) == 0) goto L9;
        TriggerControlPolicy r13 = null;
    L11:
        if ((r29 & 1024) == 0) goto L13;
        long r14 = 0;
    L14:
        this(r17, r18, r19, r20, r21, r9, r10, r24, r25, r13, r14);
        return;
    L13:
        r14 = r27;
        goto L14
    L9:
        r13 = r26;
        goto L11
    L5:
        r9 = r1;
        goto L7
    }

    public static /* synthetic */ ConditionTask copy$default(ConditionTask r14, String r15, String r16, Integer r17, Integer r18, Long r19, Map r20, List r21, ConditionGroup r22, PeriodicPolicy r23, TriggerControlPolicy r24, long r25, int r27, Object r28) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        List<ConditionTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        if ((r27 & 1) == 0) goto L5;
        String r4 = r14.getId();
    L7:
        if ((r27 & 2) == 0) goto L9;
        String r5 = r14.getName();
    L11:
        if ((r27 & 4) == 0) goto L13;
        Integer r6 = r14.getTaskStatus();
    L15:
        if ((r27 & 8) == 0) goto L17;
        Integer r7 = r14.getEnableStatus();
    L19:
        if ((r27 & 16) == 0) goto L21;
        Long r8 = r14.getCreateTime();
    L23:
        if ((r27 & 32) == 0) goto L26;
        r2 = r14.getExt();
    L26:
        if ((r27 & 64) == 0) goto L29;
        r3 = r14.actions;
    L29:
        if ((r27 & 128) == 0) goto L31;
        ConditionGroup r9 = r14.conditions;
    L33:
        if ((r27 & 256) == 0) goto L35;
        PeriodicPolicy r10 = r14.periodicPolicy;
    L37:
        if ((r27 & 512) == 0) goto L39;
        TriggerControlPolicy r11 = r14.triggerControlPolicy;
    L41:
        if ((r27 & 1024) == 0) goto L43;
        long r12 = r14.nextTriggerTime;
    L45:
        return r14.copy(r4, r5, r6, r7, r8, r2, r3, r9, r10, r11, r12);
    L43:
        r12 = r25;
        goto L45
    L39:
        r11 = r24;
        goto L41
    L35:
        r10 = r23;
        goto L37
    L31:
        r9 = r22;
        goto L33
    L21:
        r8 = r19;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
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

    public final ConditionTask copy(String r16, String r17, Integer r18, Integer r19, Long r20, Map<String, String> r21, List<ConditionTaskAction> r22, ConditionGroup r23, PeriodicPolicy r24, TriggerControlPolicy r25, long r26) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "actions");
        Intrinsics.checkNotNullParameter(r23, "conditions");
        Intrinsics.checkNotNullParameter(r24, "periodicPolicy");
        return new ConditionTask(r16, r17, r18, r19, r20, r8, r9, r23, r24, r25, r26);
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
        ConditionTask r4 = (ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.memorydata.plugin");
        return Intrinsics.areEqual(getId(), r4.getId());
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

    public final void setActions(List<ConditionTaskAction> r3) {
        List<ConditionTaskAction> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.actions = r4;
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
    public void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
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
        StringBuilder r0 = new StringBuilder();
        r0.append("ConditionTask(id=").append(getId()).append(", name=").append(getName()).append(", taskStatus=").append(getTaskStatus()).append(", enableStatus=").append(getEnableStatus()).append(", createTime=").append(getCreateTime()).append(", ext=").append(getExt()).append(", actions=").append(this.actions).append(", conditions=").append(this.conditions).append(", periodicPolicy=").append(this.periodicPolicy).append(", triggerControlPolicy=").append(this.triggerControlPolicy).append(", nextTriggerTime=").append(this.nextTriggerTime).append(')');
        return r0.toString();
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(0);
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
