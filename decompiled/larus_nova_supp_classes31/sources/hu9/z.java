package hu9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/larus/settings/provider/creation/UserAddCreationConfig;", "", "enableAddCreation", "", "showCreationMine", "showCreationOthers", "showNumberOfUses", "showPromptMineDetails", "createTabIsFirst", "<init>", "(ZZZZZZ)V", "getEnableAddCreation", "()Z", "getShowCreationMine", "getShowCreationOthers", "getShowNumberOfUses", "getShowPromptMineDetails", "getCreateTabIsFirst", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class z {
    public static final z a = null;
    public static final z b = null;

    @SerializedName("creation_tab_is_first")
    private final boolean createTabIsFirst;

    @SerializedName("enable_add_creation")
    private final boolean enableAddCreation;

    @SerializedName("show_creation_mine")
    private final boolean showCreationMine;

    @SerializedName("show_creation_others")
    private final boolean showCreationOthers;

    @SerializedName("show_number_of_uses")
    private final boolean showNumberOfUses;

    @SerializedName("show_prompt_mine_details")
    private final boolean showPromptMineDetails;

    public static final class a {
    }

    public z() {
        this(false, false, false, false, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z) == true) goto L8;
        return false;
    L8:
        z r6 = (z) r5;
        if (this.enableAddCreation == r6.enableAddCreation) goto L12;
        return false;
    L12:
        if (this.showCreationMine == r6.showCreationMine) goto L15;
        return false;
    L15:
        if (this.showCreationOthers == r6.showCreationOthers) goto L18;
        return false;
    L18:
        if (this.showNumberOfUses == r6.showNumberOfUses) goto L21;
        return false;
    L21:
        if (this.showPromptMineDetails == r6.showPromptMineDetails) goto L24;
        return false;
    L24:
        if (this.createTabIsFirst == r6.createTabIsFirst) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enableAddCreation == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.showCreationMine == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.showCreationOthers == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.showNumberOfUses == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.showPromptMineDetails == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.createTabIsFirst == true) goto L27;
        r1 = 1237;
    L27:
        return r10 + r1;
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
        return "UserAddCreationConfig(enableAddCreation=" + this.enableAddCreation + ", showCreationMine=" + this.showCreationMine + ", showCreationOthers=" + this.showCreationOthers + ", showNumberOfUses=" + this.showNumberOfUses + ", showPromptMineDetails=" + this.showPromptMineDetails + ", createTabIsFirst=" + this.createTabIsFirst + ')';
    }

    static {
        a = new z(true, true, true, true, 32);
        b = new z(false, false, false, false, 63);
    }

    public final boolean a() {
        return this.createTabIsFirst;
    }

    public final boolean b() {
        return this.enableAddCreation;
    }

    public final boolean c() {
        return this.showCreationMine;
    }

    public final boolean d() {
        return this.showCreationOthers;
    }

    public z(boolean r3, boolean r4, boolean r5, boolean r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r7 & 16) == 0) goto L15;
        r6 = false;
    L15:
        if ((r7 & 32) == 0) goto L17;
        boolean r8 = true;
    L18:
        this.enableAddCreation = r3;
        this.showCreationMine = r4;
        this.showCreationOthers = r5;
        this.showNumberOfUses = false;
        this.showPromptMineDetails = r6;
        this.createTabIsFirst = r8;
        return;
    L17:
        r8 = false;
        goto L18
    }
}
