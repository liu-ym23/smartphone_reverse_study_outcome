package ph8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017Jj\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/markdown/memory/MemoryItem;", "", "memoryTitle", "", "memoryStatus", "memoryIconUrl", "memoryIconUrlDark", "memoryTipConfig", "", "Lcom/larus/bmhome/chat/markdown/memory/MemoryTipConfig;", "memoryLoading", "", "memoryLoadingHide", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getMemoryTitle", "()Ljava/lang/String;", "getMemoryStatus", "getMemoryIconUrl", "getMemoryIconUrlDark", "getMemoryTipConfig", "()Ljava/util/List;", "getMemoryLoading", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMemoryLoadingHide", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/markdown/memory/MemoryItem;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class e {

    @SerializedName("memory_icon_url")
    private final String memoryIconUrl;

    @SerializedName("memory_icon_url_dark")
    private final String memoryIconUrlDark;

    @SerializedName("memory_loading")
    private final Boolean memoryLoading;

    @SerializedName("memory_loading_hide")
    private final Boolean memoryLoadingHide;

    @SerializedName("memory_action_tag")
    private final String memoryStatus;

    @SerializedName("memory_actions")
    private final List<f> memoryTipConfig;

    @SerializedName("memory_action_title")
    private final String memoryTitle;

    public e() {
        Boolean r7 = Boolean.FALSE;
        this(null, null, null, null, null, r7, r7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.memoryTitle, r6.memoryTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.memoryStatus, r6.memoryStatus) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.memoryIconUrl, r6.memoryIconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.memoryIconUrlDark, r6.memoryIconUrlDark) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.memoryTipConfig, r6.memoryTipConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.memoryLoading, r6.memoryLoading) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.memoryLoadingHide, r6.memoryLoadingHide) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.memoryTitle;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.memoryStatus;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.memoryIconUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.memoryIconUrlDark;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<f> r13 = this.memoryTipConfig;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.memoryLoading;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.memoryLoadingHide;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryItem(memoryTitle=" + this.memoryTitle + ", memoryStatus=" + this.memoryStatus + ", memoryIconUrl=" + this.memoryIconUrl + ", memoryIconUrlDark=" + this.memoryIconUrlDark + ", memoryTipConfig=" + this.memoryTipConfig + ", memoryLoading=" + this.memoryLoading + ", memoryLoadingHide=" + this.memoryLoadingHide + ')';
    }

    public final String a() {
        return this.memoryIconUrl;
    }

    public final String b() {
        return this.memoryIconUrlDark;
    }

    public final Boolean c() {
        return this.memoryLoading;
    }

    public final Boolean d() {
        return this.memoryLoadingHide;
    }

    public final String e() {
        return this.memoryStatus;
    }

    public final List<f> f() {
        return this.memoryTipConfig;
    }

    public final String g() {
        return this.memoryTitle;
    }

    public e(String r1, String r2, String r3, String r4, List<f> r5, Boolean r6, Boolean r7) {
        this.memoryTitle = r1;
        this.memoryStatus = r2;
        this.memoryIconUrl = r3;
        this.memoryIconUrlDark = r4;
        this.memoryTipConfig = r5;
        this.memoryLoading = r6;
        this.memoryLoadingHide = r7;
    }
}
