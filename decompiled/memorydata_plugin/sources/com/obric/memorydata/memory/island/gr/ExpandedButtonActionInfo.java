package com.obric.memorydata.memory.island.gr;

import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0001:BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010+\u001a\u00020,J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J^\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\nHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006;"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/ExpandedButtonActionInfo;", "", "action", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "clickWithCollapse", "", "actionTitle", "actionIconResId", "", "actionIntentType", "dismissKeyguard", "<init>", "(Ljava/lang/String;Landroid/content/Intent;ZLjava/lang/String;ILjava/lang/Integer;Ljava/lang/Boolean;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "getClickWithCollapse", "()Z", "setClickWithCollapse", "(Z)V", "getActionTitle", "setActionTitle", "getActionIconResId", "()I", "setActionIconResId", "(I)V", "getActionIntentType", "()Ljava/lang/Integer;", "setActionIntentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDismissKeyguard", "()Ljava/lang/Boolean;", "setDismissKeyguard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Landroid/content/Intent;ZLjava/lang/String;ILjava/lang/Integer;Ljava/lang/Boolean;)Lcom/obric/memorydata/memory/island/gr/ExpandedButtonActionInfo;", "equals", "other", "hashCode", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExpandedButtonActionInfo {
    public static final int ACTION_INTENT_TYPE_ACTIVITY = 1;
    public static final int ACTION_INTENT_TYPE_BROADCAST = 2;
    public static final int ACTION_INTENT_TYPE_SERVICE = 3;
    public static final a Companion = null;
    private String action;
    private int actionIconResId;
    private Integer actionIntentType;
    private String actionTitle;
    private boolean clickWithCollapse;
    private Boolean dismissKeyguard;
    private Intent intent;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/ExpandedButtonActionInfo$Companion;", "", "<init>", "()V", "ACTION_INTENT_TYPE_ACTIVITY", "", "ACTION_INTENT_TYPE_BROADCAST", "ACTION_INTENT_TYPE_SERVICE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public ExpandedButtonActionInfo(String r1, Intent r2, boolean r3, String r4, int r5, Integer r6, Boolean r7) {
        this.action = r1;
        this.intent = r2;
        this.clickWithCollapse = r3;
        this.actionTitle = r4;
        this.actionIconResId = r5;
        this.actionIntentType = r6;
        this.dismissKeyguard = r7;
    }

    public /* synthetic */ ExpandedButtonActionInfo(String r11, Intent r12, boolean r13, String r14, int r15, Integer r16, Boolean r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Intent r4 = null;
    L11:
        if ((r18 & 8) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r18 & 32) == 0) goto L17;
        Integer r8 = 2;
    L19:
        if ((r18 & 64) == 0) goto L21;
        Boolean r9 = null;
    L22:
        this(r3, r4, r13, r6, r15, r8, r9);
        return;
    L21:
        r9 = r17;
        goto L22
    L17:
        r8 = r16;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public static /* synthetic */ ExpandedButtonActionInfo copy$default(ExpandedButtonActionInfo r5, String r6, Intent r7, boolean r8, String r9, int r10, Integer r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.action;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.intent;
    L8:
        Intent r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.clickWithCollapse;
    L11:
        boolean r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.actionTitle;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.actionIconResId;
    L17:
        int r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.actionIntentType;
    L20:
        Integer r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.dismissKeyguard;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.action;
    }

    public final Intent component2() {
        return this.intent;
    }

    public final boolean component3() {
        return this.clickWithCollapse;
    }

    public final String component4() {
        return this.actionTitle;
    }

    public final int component5() {
        return this.actionIconResId;
    }

    public final Integer component6() {
        return this.actionIntentType;
    }

    public final Boolean component7() {
        return this.dismissKeyguard;
    }

    public final ExpandedButtonActionInfo copy(String r9, Intent r10, boolean r11, String r12, int r13, Integer r14, Boolean r15) {
        return new ExpandedButtonActionInfo(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExpandedButtonActionInfo.class) == true) goto L8;
        return false;
    L8:
        ExpandedButtonActionInfo r6 = (ExpandedButtonActionInfo) ZeusTransformUtils.preCheckCast(r5, ExpandedButtonActionInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intent, r6.intent) == true) goto L15;
        return false;
    L15:
        if (this.clickWithCollapse == r6.clickWithCollapse) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionTitle, r6.actionTitle) == true) goto L21;
        return false;
    L21:
        if (this.actionIconResId == r6.actionIconResId) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.actionIntentType, r6.actionIntentType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.dismissKeyguard, r6.dismissKeyguard) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final int getActionIconResId() {
        return this.actionIconResId;
    }

    public final Integer getActionIntentType() {
        return this.actionIntentType;
    }

    public final String getActionTitle() {
        return this.actionTitle;
    }

    public final boolean getClickWithCollapse() {
        return this.clickWithCollapse;
    }

    public final Boolean getDismissKeyguard() {
        return this.dismissKeyguard;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public int hashCode() {
        String r0 = this.action;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Intent r4 = this.intent;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + Boolean.hashCode(this.clickWithCollapse)) * 31;
        String r7 = this.actionTitle;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + Integer.hashCode(this.actionIconResId)) * 31;
        Integer r10 = this.actionIntentType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.dismissKeyguard;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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

    public final void setAction(String r1) {
        this.action = r1;
    }

    public final void setActionIconResId(int r1) {
        this.actionIconResId = r1;
    }

    public final void setActionIntentType(Integer r1) {
        this.actionIntentType = r1;
    }

    public final void setActionTitle(String r1) {
        this.actionTitle = r1;
    }

    public final void setClickWithCollapse(boolean r1) {
        this.clickWithCollapse = r1;
    }

    public final void setDismissKeyguard(Boolean r1) {
        this.dismissKeyguard = r1;
    }

    public final void setIntent(Intent r1) {
        this.intent = r1;
    }

    public final JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandComponents", "ExpandedButtonActionInfo.toJSONObject: action=" + this.action + ", actionTitle=" + this.actionTitle + ", clickWithCollapse=" + this.clickWithCollapse);
        JSONObject r0 = new JSONObject();
        String r1 = this.action;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("action", r1);
        r0.put("clickWithCollapse", this.clickWithCollapse);
        String r3 = this.actionTitle;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.put("actionTitle", r2);
        Boolean r4 = this.dismissKeyguard;
        if (r4 == null) goto L12;
        r0.put("dismissKeyguard", r4.booleanValue());
    L12:
        return r0;
    }

    public String toString() {
        return "ExpandedButtonActionInfo(action=" + this.action + ", intent=" + this.intent + ", clickWithCollapse=" + this.clickWithCollapse + ", actionTitle=" + this.actionTitle + ", actionIconResId=" + this.actionIconResId + ", actionIntentType=" + this.actionIntentType + ", dismissKeyguard=" + this.dismissKeyguard + ')';
    }
}
