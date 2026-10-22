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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0001BBa\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u008d\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0002\u0010\u0016J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0017\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0098\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u0005HÖ\u0001J\"\u00108\u001a\u0002092\u0006\u0010\r\u001a\u00020\u000e2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u0005H\u0016J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\u0015\u0010>\u001a\u0002092\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b?J\u0018\u0010@\u001a\u0002092\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u0005H\u0016R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u0011\u0010\u001eR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b%\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b&\u0010\u001aR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!¨\u0006C"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskSpec;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", ActivityLifecycle.NAME, "", "taskMode", "", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "templateId", "taskStatus", "enableStatus", "ext", "", "parcel", "Landroid/os/Parcel;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Landroid/os/Parcel;)V", "shortInstruct", "isShortInstructEnable", "", "actions", "", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "getEnableStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExt", "()Ljava/util/Map;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "()Ljava/lang/String;", "getShortInstruct", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskMode", "getTaskStatus", "getTemplateId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskSpec;", "equals", "other", "", "hashCode", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "toString", "writeSubClassExtensionFieldToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "writeToParcel", "flags", "Companion", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ShortcutTaskSpec extends EventTaskSpec {
    public static final Parcelable.Creator<ShortcutTaskSpec> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    private final List<ShortcutTaskAction> actions;
    private final Integer enableStatus;
    private final Map<String, String> ext;
    private final Boolean isShortInstructEnable;
    private final String name;
    private final String shortInstruct;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskSpec$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskSpec;", "FIELD_VERSION", "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/eventkit/eventstaskmanager/ShortcutTaskSpec$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskSpec;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskSpec;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<ShortcutTaskSpec> {
        public b() {
        }

        public ShortcutTaskSpec a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            EventTaskSpec r1 = EventTaskSpec.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTaskSpec");
            return (ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(r1, ShortcutTaskSpec.class, "com.obric.memorydata.plugin");
        }

        public ShortcutTaskSpec[] a(int r1) {
            return new ShortcutTaskSpec[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ShortcutTaskSpec createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ShortcutTaskSpec[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new b();
    }

    public ShortcutTaskSpec(String r14, Integer r15, TaskKnowledge r16, String r17, Integer r18, Integer r19, Map<String, String> r20, Parcel r21) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r21, "parcel");
        if (r15 != null) goto L6;
    L8:
        Integer r2 = r15;
    L9:
        if (r18 != null) goto L12;
    L14:
        Integer r5 = r18;
    L15:
        if (r19 != null) goto L18;
    L20:
        Integer r6 = r19;
    L21:
        this(r14, r2, r16, r17, r5, r6, r7, r21.readString(), k.a(r21), r21.createTypedArrayList(ShortcutTaskAction.CREATOR));
        readExtensionFieldFromParcel$eventstaskkit_release(r21);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r21, 0);
        return;
    L18:
        if (r19.intValue() != (-1)) goto L20;
        r6 = null;
        goto L21
    L12:
        if (r18.intValue() != (-1)) goto L14;
        r5 = null;
        goto L15
    L6:
        if (r15.intValue() != (-1)) goto L8;
        r2 = null;
        goto L9
    }

    public ShortcutTaskSpec(String r13, Integer r14, TaskKnowledge r15, String r16, Integer r17, Integer r18, Map<String, String> r19, String r20, Boolean r21, List<ShortcutTaskAction> r22) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        List<ShortcutTaskAction> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        super(3, r13, r14, r15, r16, r17, r18, r10);
        this.name = r13;
        this.taskMode = r14;
        this.taskKnowledge = r15;
        this.templateId = r16;
        this.taskStatus = r17;
        this.enableStatus = r18;
        this.ext = r10;
        this.shortInstruct = r20;
        this.isShortInstructEnable = r21;
        this.actions = r11;
    }

    public /* synthetic */ ShortcutTaskSpec(String r12, Integer r13, TaskKnowledge r14, String r15, Integer r16, Integer r17, Map r18, String r19, Boolean r20, List r21, int r22, DefaultConstructorMarker r23) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        List r4 = null;
        if ((r22 & 2) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r22 & 4) == 0) goto L9;
        TaskKnowledge r5 = null;
    L11:
        if ((r22 & 8) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r22 & 16) == 0) goto L17;
        Integer r7 = null;
    L19:
        if ((r22 & 32) == 0) goto L21;
        Integer r8 = null;
    L23:
        if ((r22 & 64) == 0) goto L26;
        r1 = null;
    L26:
        if ((r22 & 128) == 0) goto L28;
        String r9 = null;
    L30:
        if ((r22 & 256) == 0) goto L32;
        Boolean r10 = null;
    L34:
        if ((r22 & 512) != 0) goto L37;
        r4 = r2;
    L37:
        this(r12, r3, r5, r6, r7, r8, r1, r9, r10, r4);
        return;
    L32:
        r10 = r20;
        goto L34
    L28:
        r9 = r19;
        goto L30
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

    public static /* synthetic */ ShortcutTaskSpec copy$default(ShortcutTaskSpec r12, String r13, Integer r14, TaskKnowledge r15, String r16, Integer r17, Integer r18, Map r19, String r20, Boolean r21, List r22, int r23, Object r24) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        List<ShortcutTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        if ((r23 & 1) == 0) goto L5;
        String r4 = r12.getName();
    L7:
        if ((r23 & 2) == 0) goto L9;
        Integer r5 = r12.getTaskMode();
    L11:
        if ((r23 & 4) == 0) goto L13;
        TaskKnowledge r6 = r12.getTaskKnowledge();
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r7 = r12.getTemplateId();
    L19:
        if ((r23 & 16) == 0) goto L21;
        Integer r8 = r12.getTaskStatus();
    L23:
        if ((r23 & 32) == 0) goto L25;
        Integer r9 = r12.getEnableStatus();
    L27:
        if ((r23 & 64) == 0) goto L30;
        r2 = r12.getExt();
    L30:
        if ((r23 & 128) == 0) goto L32;
        String r10 = r12.shortInstruct;
    L34:
        if ((r23 & 256) == 0) goto L36;
        Boolean r11 = r12.isShortInstructEnable;
    L38:
        if ((r23 & 512) == 0) goto L41;
        r3 = r12.actions;
    L41:
        return r12.copy(r4, r5, r6, r7, r8, r9, r2, r10, r11, r3);
    L36:
        r11 = r21;
        goto L38
    L32:
        r10 = r20;
        goto L34
    L25:
        r9 = r18;
        goto L27
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
        r4 = r13;
        goto L7
    }

    public final String component1() {
        return getName();
    }

    public final List<ShortcutTaskAction> component10() {
        return this.actions;
    }

    public final Integer component2() {
        return getTaskMode();
    }

    public final TaskKnowledge component3() {
        return getTaskKnowledge();
    }

    public final String component4() {
        return getTemplateId();
    }

    public final Integer component5() {
        return getTaskStatus();
    }

    public final Integer component6() {
        return getEnableStatus();
    }

    public final Map<String, String> component7() {
        return getExt();
    }

    public final String component8() {
        return this.shortInstruct;
    }

    public final Boolean component9() {
        return this.isShortInstructEnable;
    }

    public final ShortcutTaskSpec copy(String r14, Integer r15, TaskKnowledge r16, String r17, Integer r18, Integer r19, Map<String, String> r20, String r21, Boolean r22, List<ShortcutTaskAction> r23) {
        return new ShortcutTaskSpec(r14, r15, r16, r17, r18, r19, (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin"), r21, r22, (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ShortcutTaskSpec.class) == true) goto L8;
        return false;
    L8:
        ShortcutTaskSpec r6 = (ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(r5, ShortcutTaskSpec.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(getName(), r6.getName()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getTaskMode(), r6.getTaskMode()) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getTaskKnowledge(), r6.getTaskKnowledge()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getTemplateId(), r6.getTemplateId()) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(getTaskStatus(), r6.getTaskStatus()) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(getEnableStatus(), r6.getEnableStatus()) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(getExt(), r6.getExt()) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.shortInstruct, r6.shortInstruct) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.isShortInstructEnable, r6.isShortInstructEnable) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final List<ShortcutTaskAction> getActions() {
        return this.actions;
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

    public final String getShortInstruct() {
        return this.shortInstruct;
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

    public int hashCode() {
        int r1 = 0;
        if (getName() != null) goto L5;
        int r0 = 0;
    L6:
        int r2 = r0 * 31;
        if (getTaskMode() != null) goto L9;
        int r3 = 0;
    L10:
        int r4 = (r2 + r3) * 31;
        if (getTaskKnowledge() != null) goto L13;
        int r5 = 0;
    L14:
        int r6 = (r4 + r5) * 31;
        if (getTemplateId() != null) goto L17;
        int r7 = 0;
    L18:
        int r8 = (r6 + r7) * 31;
        if (getTaskStatus() != null) goto L21;
        int r9 = 0;
    L22:
        int r10 = (r8 + r9) * 31;
        if (getEnableStatus() != null) goto L25;
        int r11 = 0;
    L26:
        int r12 = (r10 + r11) * 31;
        if (getExt() != null) goto L29;
        int r13 = 0;
    L30:
        int r14 = (r12 + r13) * 31;
        String r15 = this.shortInstruct;
        if (r15 != null) goto L33;
        int r16 = 0;
    L34:
        int r17 = (r14 + r16) * 31;
        Boolean r18 = this.isShortInstructEnable;
        if (r18 != null) goto L37;
        int r19 = 0;
    L38:
        int r20 = (r17 + r19) * 31;
        List<ShortcutTaskAction> r21 = this.actions;
        if (r21 == null) goto L43;
        r1 = r21.hashCode();
    L43:
        return r20 + r1;
    L37:
        r19 = r18.hashCode();
        goto L38
    L33:
        r16 = r15.hashCode();
        goto L34
    L29:
        r13 = getExt().hashCode();
        goto L30
    L25:
        r11 = getEnableStatus().hashCode();
        goto L26
    L21:
        r9 = getTaskStatus().hashCode();
        goto L22
    L17:
        r7 = getTemplateId().hashCode();
        goto L18
    L13:
        r5 = getTaskKnowledge().hashCode();
        goto L14
    L9:
        r3 = getTaskMode().hashCode();
        goto L10
    L5:
        r0 = getName().hashCode();
        goto L6
    }

    public final Boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public String toString() {
        return "ShortcutTaskSpec(name=" + getName() + ", taskMode=" + getTaskMode() + ", taskKnowledge=" + getTaskKnowledge() + ", templateId=" + getTemplateId() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", ext=" + getExt() + ", shortInstruct=" + this.shortInstruct + ", isShortInstructEnable=" + this.isShortInstructEnable + ", actions=" + this.actions + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeString(this.shortInstruct);
        k.a(r2, this.isShortInstructEnable);
        r2.writeTypedList(this.actions);
        writeExtensionFieldToParcel$eventstaskkit_release(r2);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r2);
    }
}
