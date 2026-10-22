package com.larus.bmhome.taskskill.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006%"}, d2 = {"Lcom/larus/bmhome/taskskill/model/ExposedSkillSlot;", "", "slot", "", "skillName", "", "skillDisplayName", "skillType", "skillId", MusicAppletPage.KEY_SOURCE, "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getSlot", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSkillName", "()Ljava/lang/String;", "getSkillDisplayName", "getSkillType", "getSkillId", "getSource", "toTaskSkill", "Lcom/larus/bmhome/taskskill/model/TaskSkill;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/taskskill/model/ExposedSkillSlot;", "equals", "", "other", "hashCode", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {
    public static final /* synthetic */ int a = 0;

    @SerializedName("skill_display_name")
    private final String skillDisplayName;

    @SerializedName("skill_id")
    private final String skillId;

    @SerializedName("skill_name")
    private final String skillName;

    @SerializedName("skill_type")
    private final Integer skillType;

    @SerializedName("slot")
    private final Integer slot;

    @SerializedName(MusicAppletPage.KEY_SOURCE)
    private final Integer source;

    /* JADX INFO: renamed from: com.larus.bmhome.taskskill.model.a$a, reason: collision with other inner class name */
    public static final class C0036a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.slot, r6.slot) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.skillName, r6.skillName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.skillDisplayName, r6.skillDisplayName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.skillType, r6.skillType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.skillId, r6.skillId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.slot;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.skillName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.skillDisplayName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.skillType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.skillId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.source;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "ExposedSkillSlot(slot=" + this.slot + ", skillName=" + this.skillName + ", skillDisplayName=" + this.skillDisplayName + ", skillType=" + this.skillType + ", skillId=" + this.skillId + ", source=" + this.source + ')';
    }

    public final TaskSkill b() {
        String r0 = this.skillName;
        if (r0 != null) goto L5;
    L16:
        return null;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        String r4 = r0;
    L8:
        if (r4 == null) goto L16;
        String r5 = this.skillId;
        String r7 = this.skillDisplayName;
        Integer r1 = this.skillType;
        if (r1 == null) goto L13;
        int r2 = r1.intValue();
    L15:
        return new TaskSkill(r4, r5, null, r7, false, r2, true, null, null, 16148);
    L13:
        r2 = SkillType.SYSTEM.getValue();
        goto L15
    L7:
        r4 = null;
        goto L8
    }

    public final Integer a() {
        return this.slot;
    }

    public a(Integer r3, String r4, String r5, Integer r6, String r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = null;
    L17:
        this.slot = r3;
        this.skillName = r4;
        this.skillDisplayName = r5;
        this.skillType = r6;
        this.skillId = r7;
        this.source = null;
    }
}
