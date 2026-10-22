package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0087\b\u0018\u0000 H2\u00020\u0001:\u0001IB\u008f\u0001\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e¢\u0006\u0004\bE\u0010FBc\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bE\u0010GJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0012J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0012J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eHÆ\u0003J\u009a\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00182\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b+\u0010,J\t\u0010-\u001a\u00020\u000fHÖ\u0001J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\u0013\u00101\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003R\u001c\u0010!\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u00102\u001a\u0004\b3\u00104R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b6\u0010\u0012R\u001c\u0010#\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\b8\u00109R\u001c\u0010$\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u00102\u001a\u0004\b:\u00104R\u001c\u0010%\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\b;\u0010\u0012R\u001c\u0010&\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u00105\u001a\u0004\b<\u0010\u0012R(\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010=\u001a\u0004\b>\u0010?R\u0019\u0010(\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b(\u00102\u001a\u0004\b@\u00104R\u0019\u0010)\u001a\u0004\u0018\u00010\u001b8\u0006¢\u0006\f\n\u0004\b)\u0010A\u001a\u0004\b)\u0010\u001dR\u001f\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b*\u0010B\u001a\u0004\bC\u0010D¨\u0006J"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskSpec;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "", "component1", "component2", "()Ljava/lang/Integer;", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "component3", "component4", "component5", "component6", "", "component7", "component8", "", "component9", "()Ljava/lang/Boolean;", "", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction;", "component10", "name", "taskMode", "taskKnowledge", "templateId", "taskStatus", "enableStatus", "ext", "shortInstruct", "isShortInstructEnable", "actions", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskSpec;", "toString", "hashCode", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getTaskMode", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTemplateId", "getTaskStatus", "getEnableStatus", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "getShortInstruct", "Ljava/lang/Boolean;", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ShortcutTaskSpec extends EventTaskSpec {
    public static final Parcelable.Creator<ShortcutTaskSpec> CREATOR = null;
    public static final b Companion = null;
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

    public static final class a implements Parcelable.Creator<ShortcutTaskSpec> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTaskSpec createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            Object r3 = EventTaskSpec.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTaskSpec");
            return (ShortcutTaskSpec) r3;
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTaskSpec[] newArray(int r1) {
            return new ShortcutTaskSpec[r1];
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

    public ShortcutTaskSpec(String r11, Integer r12, TaskKnowledge r13, String r14, Integer r15, Integer r16, Map<String, String> r17, String r18, Boolean r19, List<ShortcutTaskAction> r20) {
        super(3, r11, r12, r13, r14, r15, r16, r17);
        this.name = r11;
        this.taskMode = r12;
        this.taskKnowledge = r13;
        this.templateId = r14;
        this.taskStatus = r15;
        this.enableStatus = r16;
        this.ext = r17;
        this.shortInstruct = r18;
        this.isShortInstructEnable = r19;
        this.actions = r20;
    }

    public /* synthetic */ ShortcutTaskSpec(String r11, Integer r12, TaskKnowledge r13, String r14, Integer r15, Integer r16, Map r17, String r18, Boolean r19, List r20, int r21, DefaultConstructorMarker r22) {
        List r2 = null;
        if ((r21 & 2) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r21 & 4) == 0) goto L9;
        TaskKnowledge r3 = null;
    L11:
        if ((r21 & 8) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r21 & 16) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r21 & 32) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r21 & 64) == 0) goto L25;
        Map r7 = null;
    L27:
        if ((r21 & 128) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r21 & 256) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r21 & 512) != 0) goto L38;
        r2 = r20;
    L38:
        this(r11, r1, r3, r4, r5, r6, r7, r8, r9, r2);
        return;
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortcutTaskSpec copy$default(ShortcutTaskSpec r11, String r12, Integer r13, TaskKnowledge r14, String r15, Integer r16, Integer r17, Map r18, String r19, Boolean r20, List r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.getName();
    L7:
        if ((r22 & 2) == 0) goto L9;
        Integer r3 = r11.getTaskMode();
    L11:
        if ((r22 & 4) == 0) goto L13;
        TaskKnowledge r4 = r11.getTaskKnowledge();
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.getTemplateId();
    L19:
        if ((r22 & 16) == 0) goto L21;
        Integer r6 = r11.getTaskStatus();
    L23:
        if ((r22 & 32) == 0) goto L25;
        Integer r7 = r11.getEnableStatus();
    L27:
        if ((r22 & 64) == 0) goto L29;
        Map r8 = r11.getExt();
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.shortInstruct;
    L35:
        if ((r22 & 256) == 0) goto L37;
        Boolean r10 = r11.isShortInstructEnable;
    L39:
        if ((r22 & 512) == 0) goto L41;
        List r1 = r11.actions;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
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

    public final ShortcutTaskSpec copy(String r13, Integer r14, TaskKnowledge r15, String r16, Integer r17, Integer r18, Map<String, String> r19, String r20, Boolean r21, List<ShortcutTaskAction> r22) {
        return new ShortcutTaskSpec(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShortcutTaskSpec) == true) goto L8;
        return false;
    L8:
        ShortcutTaskSpec r6 = (ShortcutTaskSpec) r5;
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

    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public String getName() {
        return this.name;
    }

    public final String getShortInstruct() {
        return this.shortInstruct;
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

    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public String toString() {
        return "ShortcutTaskSpec(name=" + getName() + ", taskMode=" + getTaskMode() + ", taskKnowledge=" + getTaskKnowledge() + ", templateId=" + getTemplateId() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", ext=" + getExt() + ", shortInstruct=" + this.shortInstruct + ", isShortInstructEnable=" + this.isShortInstructEnable + ", actions=" + this.actions + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeString(this.shortInstruct);
        Boolean r4 = this.isShortInstructEnable;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r4 == null) goto L5;
        ?? r5 = r4.booleanValue();
    L6:
        r2.writeInt(r5);
        r2.writeTypedList(this.actions);
        writeExtensionFieldToParcel$eventstaskkit_release(r2);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r2);
        return;
    L5:
        r5 = -1;
        goto L6
    }

    public ShortcutTaskSpec(String r14, Integer r15, TaskKnowledge r16, String r17, Integer r18, Integer r19, Map<String, String> r20, Parcel r21) {
        Intrinsics.checkNotNullParameter(r21, "parcel");
        Boolean r0 = null;
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
        String r8 = r21.readString();
        Intrinsics.checkNotNullParameter(r21, "<this>");
        int r3 = r21.readInt();
        if (r3 == (-1)) goto L26;
        if (r3 == 0) goto L25;
        r0 = Boolean.TRUE;
        goto L26
    L25:
        r0 = Boolean.FALSE;
    L26:
        this(r14, r2, r16, r17, r5, r6, r20, r8, r0, r21.createTypedArrayList(ShortcutTaskAction.CREATOR));
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
}
