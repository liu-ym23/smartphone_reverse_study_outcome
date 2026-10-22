package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.annotation.IgnoreStyleCheck;
import com.bytedance.android.live.base.model.user.api.IAnchorLevel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.User.AnchorLevel")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001AB\u0007¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\f\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\"\u0010\"\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010%\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\"\u0010(\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\"\u0010+\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0014\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b5\u00100\u001a\u0004\b6\u00102\"\u0004\b7\u00104R$\u00108\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b8\u00100\u001a\u0004\b9\u00102\"\u0004\b:\u00104R$\u0010;\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b;\u00100\u001a\u0004\b<\u00102\"\u0004\b=\u00104¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/base/model/user/AnchorLevel;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "other", "", "initWith", "", "o", "", "equals", "", "hashCode", "level", "I", "getLevel", "()I", "setLevel", "(I)V", "", "experience", "J", "getExperience", "()J", "setExperience", "(J)V", "lowestExperienceThisLevel", "getLowestExperienceThisLevel", "setLowestExperienceThisLevel", "highestExperienceThisLevel", "getHighestExperienceThisLevel", "setHighestExperienceThisLevel", "taskStartExperience", "getTaskStartExperience", "setTaskStartExperience", "taskStartTime", "getTaskStartTime", "setTaskStartTime", "taskDecreaseExperience", "getTaskDecreaseExperience", "setTaskDecreaseExperience", "taskTargetExperience", "getTaskTargetExperience", "setTaskTargetExperience", "taskEndTime", "getTaskEndTime", "setTaskEndTime", "Lpy/k;", "profileDialogBg", "Lpy/k;", "getProfileDialogBg", "()Lpy/k;", "setProfileDialogBg", "(Lpy/k;)V", "profileDialogBackBg", "getProfileDialogBackBg", "setProfileDialogBackBg", "stageLevelIcon", "getStageLevelIcon", "setStageLevelIcon", "levelIcon", "getLevelIcon", "setLevelIcon", "<init>", "()V", "Companion", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
@IgnoreStyleCheck
public final class AnchorLevel extends FlexModelBase<IAnchorLevel> implements IAnchorLevel, vh7.h {
    public static final a Companion = null;
    private static final int HASH_31 = 31;
    private static final int HASH_32 = 32;

    @SerializedName("experience")
    protected long experience;

    @SerializedName("highest_experience_this_level")
    protected long highestExperienceThisLevel;

    @SerializedName("level")
    protected int level;

    @SerializedName("small_icon")
    protected py.k levelIcon;

    @SerializedName("lowest_experience_this_level")
    protected long lowestExperienceThisLevel;

    @SerializedName("profile_dialog_bg_back")
    protected py.k profileDialogBackBg;

    @SerializedName("profile_dialog_bg")
    protected py.k profileDialogBg;

    @SerializedName("stage_level")
    protected py.k stageLevelIcon;

    @SerializedName("task_decrease_experience")
    protected long taskDecreaseExperience;

    @SerializedName("task_end_time")
    protected long taskEndTime;

    @SerializedName("task_start_experience")
    protected long taskStartExperience;

    @SerializedName("task_start_time")
    protected long taskStartTime;

    @SerializedName("task_target_experience")
    protected long taskTargetExperience;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AnchorLevel() {
        super(IAnchorLevel.class);
    }

    public int hashCode() {
        int r1 = 0;
        if (getLevelIcon() == null) goto L7;
        py.k r0 = getLevelIcon();
        if (r0 == null) goto L7;
        int r2 = r0.hashCode();
    L8:
        int r3 = ((((((((((((((((((r2 * 31) + getLevel()) * 31) + ((int) (getExperience() ^ (getExperience() >>> 32)))) * 31) + ((int) (getLowestExperienceThisLevel() ^ (getLowestExperienceThisLevel() >>> 32)))) * 31) + ((int) (getHighestExperienceThisLevel() ^ (getHighestExperienceThisLevel() >>> 32)))) * 31) + ((int) (getTaskStartExperience() ^ (getTaskStartExperience() >>> 32)))) * 31) + ((int) (getTaskStartTime() ^ (getTaskStartTime() >>> 32)))) * 31) + ((int) (getTaskDecreaseExperience() ^ (getTaskDecreaseExperience() >>> 32)))) * 31) + ((int) (getTaskTargetExperience() ^ (getTaskTargetExperience() >>> 32)))) * 31) + ((int) (getTaskEndTime() ^ (getTaskEndTime() >>> 32)))) * 31;
        if (getProfileDialogBg() == null) goto L13;
        py.k r4 = getProfileDialogBg();
        if (r4 == null) goto L13;
        int r5 = r4.hashCode();
    L14:
        int r6 = (r3 + r5) * 31;
        if (getProfileDialogBackBg() == null) goto L19;
        py.k r7 = getProfileDialogBackBg();
        if (r7 == null) goto L19;
        int r8 = r7.hashCode();
    L20:
        int r9 = (r6 + r8) * 31;
        if (getStageLevelIcon() == null) goto L25;
        py.k r11 = getStageLevelIcon();
        if (r11 == null) goto L25;
        int r12 = r11.hashCode();
    L26:
        int r13 = (r9 + r12) * 31;
        if (getLevelIcon() == null) goto L32;
        py.k r14 = getLevelIcon();
        if (r14 == null) goto L32;
        r1 = r14.hashCode();
    L32:
        return r13 + r1;
    L25:
        r12 = 0;
    L19:
        r8 = 0;
    L13:
        r5 = 0;
    L7:
        r2 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public long getExperience() {
        return this.experience;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public long getHighestExperienceThisLevel() {
        return this.highestExperienceThisLevel;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public int getLevel() {
        return this.level;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public py.k getLevelIcon() {
        return this.levelIcon;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public long getLowestExperienceThisLevel() {
        return this.lowestExperienceThisLevel;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public py.k getProfileDialogBackBg() {
        return this.profileDialogBackBg;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public py.k getProfileDialogBg() {
        return this.profileDialogBg;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public py.k getStageLevelIcon() {
        return this.stageLevelIcon;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public long getTaskDecreaseExperience() {
        return this.taskDecreaseExperience;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public long getTaskEndTime() {
        return this.taskEndTime;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public long getTaskStartExperience() {
        return this.taskStartExperience;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public long getTaskStartTime() {
        return this.taskStartTime;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public long getTaskTargetExperience() {
        return this.taskTargetExperience;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object, py.k] */
    public AnchorLevel(am3.g r5) {
        super(IAnchorLevel.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            default: goto L7;
        };
    L8:
        this.levelIcon = vh7.f.a(r5, py.k.class);
        goto L3
    L9:
        this.stageLevelIcon = vh7.f.a(r5, py.k.class);
        goto L3
    L10:
        this.profileDialogBackBg = vh7.f.a(r5, py.k.class);
        goto L3
    L11:
        this.profileDialogBg = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        this.taskEndTime = r5.j();
        goto L3
    L13:
        this.taskTargetExperience = r5.j();
        goto L3
    L14:
        this.taskDecreaseExperience = r5.j();
        goto L3
    L15:
        this.taskStartTime = r5.j();
        goto L3
    L16:
        this.taskStartExperience = r5.j();
        goto L3
    L17:
        this.highestExperienceThisLevel = r5.j();
        goto L3
    L18:
        this.lowestExperienceThisLevel = r5.j();
        goto L3
    L19:
        this.experience = r5.j();
        goto L3
    L20:
        this.level = (int) r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L21:
        r5.d(r0);
        setThreadSafe(true);
    }

    private final void initWith(IAnchorLevel r3) {
        setLevel(r3.getLevel());
        setExperience(r3.getExperience());
        setLowestExperienceThisLevel(r3.getLowestExperienceThisLevel());
        setHighestExperienceThisLevel(r3.getHighestExperienceThisLevel());
        setTaskStartExperience(r3.getTaskStartExperience());
        setTaskStartTime(r3.getTaskStartTime());
        setTaskDecreaseExperience(r3.getTaskDecreaseExperience());
        setTaskTargetExperience(r3.getTaskTargetExperience());
        setTaskEndTime(r3.getTaskEndTime());
        setProfileDialogBg(r3.getProfileDialogBg());
        setProfileDialogBackBg(r3.getProfileDialogBackBg());
        setStageLevelIcon(r3.getStageLevelIcon());
        setLevelIcon(r3.getLevelIcon());
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L72:
        return false;
    L8:
        if ((!Intrinsics.areEqual(AnchorLevel.class, r8.getClass())) == true) goto L72;
        AnchorLevel r9 = (AnchorLevel) r8;
        if (getLevel() == r9.getLevel()) goto L14;
        return false;
    L14:
        if (getExperience() == r9.getExperience()) goto L17;
        return false;
    L17:
        if (getLowestExperienceThisLevel() == r9.getLowestExperienceThisLevel()) goto L20;
        return false;
    L20:
        if (getHighestExperienceThisLevel() == r9.getHighestExperienceThisLevel()) goto L23;
        return false;
    L23:
        if (getTaskStartExperience() == r9.getTaskStartExperience()) goto L26;
        return false;
    L26:
        if (getTaskStartTime() == r9.getTaskStartTime()) goto L29;
        return false;
    L29:
        if (getTaskDecreaseExperience() == r9.getTaskDecreaseExperience()) goto L32;
        return false;
    L32:
        if (getTaskTargetExperience() == r9.getTaskTargetExperience()) goto L35;
        return false;
    L35:
        if (getTaskEndTime() == r9.getTaskEndTime()) goto L38;
        return false;
    L38:
        if (getProfileDialogBg() == null) goto L41;
        boolean r2 = !Intrinsics.areEqual(getProfileDialogBg(), r9.getProfileDialogBg());
    L44:
        if (r2 == false) goto L47;
        return false;
    L47:
        if (getProfileDialogBackBg() == null) goto L50;
        boolean r3 = !Intrinsics.areEqual(getProfileDialogBackBg(), r9.getProfileDialogBackBg());
    L53:
        if (r3 == false) goto L56;
        return false;
    L56:
        if (getStageLevelIcon() == null) goto L59;
        boolean r4 = !Intrinsics.areEqual(getStageLevelIcon(), r9.getStageLevelIcon());
    L62:
        if (r4 == false) goto L65;
        return false;
    L65:
        if (getLevelIcon() == null) goto L68;
        return Intrinsics.areEqual(getLevelIcon(), r9.getLevelIcon());
    L68:
        if (r9.getLevelIcon() == null) goto L74;
        return false;
    L74:
        return true;
    L59:
        if (r9.getStageLevelIcon() == null) goto L61;
        r4 = true;
        goto L62
    L61:
        r4 = false;
        goto L62
    L50:
        if (r9.getProfileDialogBackBg() == null) goto L52;
        r3 = true;
        goto L53
    L52:
        r3 = false;
        goto L53
    L41:
        if (r9.getProfileDialogBg() == null) goto L43;
        r2 = true;
        goto L44
    L43:
        r2 = false;
        goto L44
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setExperience(long r1) {
        this.experience = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setHighestExperienceThisLevel(long r1) {
        this.highestExperienceThisLevel = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setLevel(int r1) {
        this.level = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setLevelIcon(py.k r1) {
        this.levelIcon = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setLowestExperienceThisLevel(long r1) {
        this.lowestExperienceThisLevel = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setProfileDialogBackBg(py.k r1) {
        this.profileDialogBackBg = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setProfileDialogBg(py.k r1) {
        this.profileDialogBg = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setStageLevelIcon(py.k r1) {
        this.stageLevelIcon = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setTaskDecreaseExperience(long r1) {
        this.taskDecreaseExperience = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setTaskEndTime(long r1) {
        this.taskEndTime = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setTaskStartExperience(long r1) {
        this.taskStartExperience = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setTaskStartTime(long r1) {
        this.taskStartTime = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.api.IAnchorLevel
    public void setTaskTargetExperience(long r1) {
        this.taskTargetExperience = r1;
    }

    public static final /* synthetic */ void access$initWith(AnchorLevel r0, IAnchorLevel r1) {
        r0.initWith(r1);
    }
}
