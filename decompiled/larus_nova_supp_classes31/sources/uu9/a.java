package uu9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 C2\u00020\u0001:\u0001CB¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\fHÆ\u0003JÁ\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010>\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0007HÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0016\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"¨\u0006D"}, d2 = {"Lcom/larus/settings/provider/home/ConversationGroupExperimentConfig;", "", "enable", "", "enableMergeMainConversation", "enableDragAndDrop", "defaultGroupType", "", "defaultSortType", "socialIndependentGroup", "enableAddLocalFolder", "pinPagingConfig", "Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;", "socialPagingConfig", "projectPagingConfig", "projectConversationPagingConfig", "deviceConversationPagingConfig", "chatPagingConfig", "projectListUpdateStrategy", "conversationMemoryMutation", "enableArchive", "archivedPageConfig", "<init>", "(ZZZIIZZLcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;IZZLcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;)V", "getEnable", "()Z", "getEnableMergeMainConversation", "getEnableDragAndDrop", "getDefaultGroupType", "()I", "getDefaultSortType", "getSocialIndependentGroup", "getEnableAddLocalFolder", "getPinPagingConfig", "()Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;", "getSocialPagingConfig", "getProjectPagingConfig", "getProjectConversationPagingConfig", "getDeviceConversationPagingConfig", "getChatPagingConfig", "getProjectListUpdateStrategy", "getConversationMemoryMutation", "getEnableArchive", "getArchivedPageConfig", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a {
    public static final a a = null;

    @SerializedName("archive_paging_config")
    private final c archivedPageConfig;

    @SerializedName("chat_paging_config")
    private final c chatPagingConfig;

    @SerializedName("conversation_memory_mutation")
    private final boolean conversationMemoryMutation;

    @SerializedName("default_group_type")
    private final int defaultGroupType;

    @SerializedName("default_sort_type")
    private final int defaultSortType;

    @SerializedName("device_conversation_paging_config")
    private final c deviceConversationPagingConfig;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_add_local_folder")
    private final boolean enableAddLocalFolder;

    @SerializedName("enable_archive")
    private final boolean enableArchive;

    @SerializedName("enable_drag_and_drop")
    private final boolean enableDragAndDrop;

    @SerializedName("enable_merge_main_conversation")
    private final boolean enableMergeMainConversation;

    @SerializedName("pin_paging_config")
    private final c pinPagingConfig;

    @SerializedName("project_conversation_paging_config")
    private final c projectConversationPagingConfig;

    @SerializedName("project_list_update_strategy")
    private final int projectListUpdateStrategy;

    @SerializedName("project_paging_config")
    private final c projectPagingConfig;

    @SerializedName("social_independent_group")
    private final boolean socialIndependentGroup;

    @SerializedName("social_paging_config")
    private final c socialPagingConfig;

    /* JADX INFO: renamed from: uu9.a$a, reason: collision with other inner class name */
    public static final class C0080a {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (this.enableMergeMainConversation == r6.enableMergeMainConversation) goto L15;
        return false;
    L15:
        if (this.enableDragAndDrop == r6.enableDragAndDrop) goto L18;
        return false;
    L18:
        if (this.defaultGroupType == r6.defaultGroupType) goto L21;
        return false;
    L21:
        if (this.defaultSortType == r6.defaultSortType) goto L24;
        return false;
    L24:
        if (this.socialIndependentGroup == r6.socialIndependentGroup) goto L27;
        return false;
    L27:
        if (this.enableAddLocalFolder == r6.enableAddLocalFolder) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pinPagingConfig, r6.pinPagingConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.socialPagingConfig, r6.socialPagingConfig) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.projectPagingConfig, r6.projectPagingConfig) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.projectConversationPagingConfig, r6.projectConversationPagingConfig) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.deviceConversationPagingConfig, r6.deviceConversationPagingConfig) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.chatPagingConfig, r6.chatPagingConfig) == true) goto L48;
        return false;
    L48:
        if (this.projectListUpdateStrategy == r6.projectListUpdateStrategy) goto L51;
        return false;
    L51:
        if (this.conversationMemoryMutation == r6.conversationMemoryMutation) goto L54;
        return false;
    L54:
        if (this.enableArchive == r6.enableArchive) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.archivedPageConfig, r6.archivedPageConfig) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableMergeMainConversation == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableDragAndDrop == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (((((r4 + r5) * 31) + this.defaultGroupType) * 31) + this.defaultSortType) * 31;
        if (this.socialIndependentGroup == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.enableAddLocalFolder == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        c r11 = this.pinPagingConfig;
        int r12 = 0;
        if (r11 != null) goto L25;
        int r13 = 0;
    L26:
        int r14 = (r10 + r13) * 31;
        c r15 = this.socialPagingConfig;
        if (r15 != null) goto L29;
        int r16 = 0;
    L30:
        int r17 = (r14 + r16) * 31;
        c r18 = this.projectPagingConfig;
        if (r18 != null) goto L33;
        int r19 = 0;
    L34:
        int r20 = (r17 + r19) * 31;
        c r21 = this.projectConversationPagingConfig;
        if (r21 != null) goto L37;
        int r22 = 0;
    L38:
        int r23 = (r20 + r22) * 31;
        c r24 = this.deviceConversationPagingConfig;
        if (r24 != null) goto L41;
        int r25 = 0;
    L42:
        int r26 = (r23 + r25) * 31;
        c r27 = this.chatPagingConfig;
        if (r27 != null) goto L45;
        int r28 = 0;
    L46:
        int r29 = (((r26 + r28) * 31) + this.projectListUpdateStrategy) * 31;
        if (this.conversationMemoryMutation == false) goto L49;
        int r30 = 1231;
    L50:
        int r31 = (r29 + r30) * 31;
        if (this.enableArchive == true) goto L54;
        r1 = 1237;
    L54:
        int r32 = (r31 + r1) * 31;
        c r33 = this.archivedPageConfig;
        if (r33 == null) goto L59;
        r12 = r33.hashCode();
    L59:
        return r32 + r12;
    L49:
        r30 = 1237;
        goto L50
    L45:
        r28 = r27.hashCode();
        goto L46
    L41:
        r25 = r24.hashCode();
        goto L42
    L37:
        r22 = r21.hashCode();
        goto L38
    L33:
        r19 = r18.hashCode();
        goto L34
    L29:
        r16 = r15.hashCode();
        goto L30
    L25:
        r13 = r11.hashCode();
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ConversationGroupExperimentConfig(enable=" + this.enable + ", enableMergeMainConversation=" + this.enableMergeMainConversation + ", enableDragAndDrop=" + this.enableDragAndDrop + ", defaultGroupType=" + this.defaultGroupType + ", defaultSortType=" + this.defaultSortType + ", socialIndependentGroup=" + this.socialIndependentGroup + ", enableAddLocalFolder=" + this.enableAddLocalFolder + ", pinPagingConfig=" + this.pinPagingConfig + ", socialPagingConfig=" + this.socialPagingConfig + ", projectPagingConfig=" + this.projectPagingConfig + ", projectConversationPagingConfig=" + this.projectConversationPagingConfig + ", deviceConversationPagingConfig=" + this.deviceConversationPagingConfig + ", chatPagingConfig=" + this.chatPagingConfig + ", projectListUpdateStrategy=" + this.projectListUpdateStrategy + ", conversationMemoryMutation=" + this.conversationMemoryMutation + ", enableArchive=" + this.enableArchive + ", archivedPageConfig=" + this.archivedPageConfig + ')';
    }

    static {
        a = new a(0);
    }

    public final c a() {
        return this.archivedPageConfig;
    }

    public final c b() {
        return this.chatPagingConfig;
    }

    public final boolean c() {
        return this.conversationMemoryMutation;
    }

    public final int d() {
        return this.defaultGroupType;
    }

    public final int e() {
        return this.defaultSortType;
    }

    public final c f() {
        return this.deviceConversationPagingConfig;
    }

    public final boolean g() {
        return this.enable;
    }

    public final boolean h() {
        return this.enableAddLocalFolder;
    }

    public final boolean i() {
        return this.enableArchive;
    }

    public final boolean j() {
        return this.enableDragAndDrop;
    }

    public final boolean k() {
        return this.enableMergeMainConversation;
    }

    public final c l() {
        return this.pinPagingConfig;
    }

    public final c m() {
        return this.projectConversationPagingConfig;
    }

    public final int n() {
        return this.projectListUpdateStrategy;
    }

    public final c o() {
        return this.projectPagingConfig;
    }

    public final boolean p() {
        return this.socialIndependentGroup;
    }

    public final c q() {
        return this.socialPagingConfig;
    }

    public a(int r9) {
        c r10 = new c(100, 100, 100);
        c r0 = new c(3, 10, 20);
        c r1 = new c(5, 10, 20);
        c r5 = new c(5, 10, 20);
        c r6 = new c(5, 10, 20);
        c r2 = new c(20, 20, 20);
        c r4 = new c(20, 20, 20);
        this.enable = true;
        this.enableMergeMainConversation = false;
        this.enableDragAndDrop = true;
        this.defaultGroupType = 0;
        this.defaultSortType = 0;
        this.socialIndependentGroup = true;
        this.enableAddLocalFolder = false;
        this.pinPagingConfig = r10;
        this.socialPagingConfig = r0;
        this.projectPagingConfig = r1;
        this.projectConversationPagingConfig = r5;
        this.deviceConversationPagingConfig = r6;
        this.chatPagingConfig = r2;
        this.projectListUpdateStrategy = 0;
        this.conversationMemoryMutation = true;
        this.enableArchive = true;
        this.archivedPageConfig = r4;
    }
}
