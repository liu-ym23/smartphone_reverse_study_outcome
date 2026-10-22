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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 S2\u00020\u0001:\u0001SB§\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010=\u001a\u00020>J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J°\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020\t2\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020\u0003HÖ\u0001J\t\u0010R\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b9\u0010-\"\u0004\b:\u0010/R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001b\"\u0004\b<\u0010\u001d¨\u0006T"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/ExpandedImageTextActionInfo;", "", "type", "", "action", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "clickWithCollapse", "", "actionIcon", "actionIconResId", "actionIconDark", "actionIconDarkResId", "actionBgColor", "actionTitle", "actionTitleColor", "actionTitleColorDark", "actionIntentType", "actionIntent", "<init>", "(ILjava/lang/String;Landroid/content/Intent;ZLjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "getClickWithCollapse", "()Z", "setClickWithCollapse", "(Z)V", "getActionIcon", "setActionIcon", "getActionIconResId", "setActionIconResId", "getActionIconDark", "setActionIconDark", "getActionIconDarkResId", "()Ljava/lang/Integer;", "setActionIconDarkResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getActionBgColor", "setActionBgColor", "getActionTitle", "setActionTitle", "getActionTitleColor", "setActionTitleColor", "getActionTitleColorDark", "setActionTitleColorDark", "getActionIntentType", "setActionIntentType", "getActionIntent", "setActionIntent", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(ILjava/lang/String;Landroid/content/Intent;ZLjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/obric/memorydata/memory/island/gr/ExpandedImageTextActionInfo;", "equals", "other", "hashCode", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExpandedImageTextActionInfo {
    public static final int ACTION_INTENT_TYPE_ACTIVITY = 1;
    public static final int ACTION_INTENT_TYPE_BROADCAST = 2;
    public static final int ACTION_INTENT_TYPE_SERVICE = 3;
    public static final a Companion = null;
    public static final int TYPE_CIRCLE = 0;
    public static final int TYPE_PROGRESS = 1;
    public static final int TYPE_TEXT = 2;
    private String action;
    private String actionBgColor;
    private String actionIcon;
    private String actionIconDark;
    private Integer actionIconDarkResId;
    private int actionIconResId;
    private String actionIntent;
    private Integer actionIntentType;
    private String actionTitle;
    private String actionTitleColor;
    private String actionTitleColorDark;
    private boolean clickWithCollapse;
    private Intent intent;
    private int type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/ExpandedImageTextActionInfo$Companion;", "", "<init>", "()V", "TYPE_CIRCLE", "", "TYPE_PROGRESS", "TYPE_TEXT", "ACTION_INTENT_TYPE_ACTIVITY", "ACTION_INTENT_TYPE_BROADCAST", "ACTION_INTENT_TYPE_SERVICE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public ExpandedImageTextActionInfo(int r1, String r2, Intent r3, boolean r4, String r5, int r6, String r7, Integer r8, String r9, String r10, String r11, String r12, Integer r13, String r14) {
        this.type = r1;
        this.action = r2;
        this.intent = r3;
        this.clickWithCollapse = r4;
        this.actionIcon = r5;
        this.actionIconResId = r6;
        this.actionIconDark = r7;
        this.actionIconDarkResId = r8;
        this.actionBgColor = r9;
        this.actionTitle = r10;
        this.actionTitleColor = r11;
        this.actionTitleColorDark = r12;
        this.actionIntentType = r13;
        this.actionIntent = r14;
    }

    public /* synthetic */ ExpandedImageTextActionInfo(int r19, String r20, Intent r21, boolean r22, String r23, int r24, String r25, Integer r26, String r27, String r28, String r29, String r30, Integer r31, String r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 1) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r33 & 4) == 0) goto L13;
        Intent r6 = null;
    L15:
        if ((r33 & 8) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r33 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r33 & 64) == 0) goto L25;
        String r10 = null;
    L27:
        if ((r33 & 128) == 0) goto L29;
        Integer r11 = null;
    L31:
        if ((r33 & 256) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r33 & 512) == 0) goto L37;
        String r13 = null;
    L39:
        if ((r33 & 1024) == 0) goto L41;
        String r14 = null;
    L43:
        if ((r33 & 2048) == 0) goto L45;
        String r15 = null;
    L47:
        if ((r33 & 4096) == 0) goto L49;
        Integer r16 = 2;
    L51:
        if ((r33 & 8192) == 0) goto L53;
        String r17 = null;
    L54:
        this(r4, r5, r6, r7, r8, r24, r10, r11, r12, r13, r14, r15, r16, r17);
        return;
    L53:
        r17 = r32;
        goto L54
    L49:
        r16 = r31;
        goto L51
    L45:
        r15 = r30;
        goto L47
    L41:
        r14 = r29;
        goto L43
    L37:
        r13 = r28;
        goto L39
    L33:
        r12 = r27;
        goto L35
    L29:
        r11 = r26;
        goto L31
    L25:
        r10 = r25;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public static /* synthetic */ ExpandedImageTextActionInfo copy$default(ExpandedImageTextActionInfo r15, int r16, String r17, Intent r18, boolean r19, String r20, int r21, String r22, Integer r23, String r24, String r25, String r26, String r27, Integer r28, String r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        int r2 = r15.type;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = r15.action;
    L11:
        if ((r30 & 4) == 0) goto L13;
        Intent r4 = r15.intent;
    L15:
        if ((r30 & 8) == 0) goto L17;
        boolean r5 = r15.clickWithCollapse;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = r15.actionIcon;
    L23:
        if ((r30 & 32) == 0) goto L25;
        int r7 = r15.actionIconResId;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r8 = r15.actionIconDark;
    L31:
        if ((r30 & 128) == 0) goto L33;
        Integer r9 = r15.actionIconDarkResId;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r10 = r15.actionBgColor;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r11 = r15.actionTitle;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r12 = r15.actionTitleColor;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r13 = r15.actionTitleColorDark;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        Integer r14 = r15.actionIntentType;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        String r1 = r15.actionIntent;
    L59:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L57:
        r1 = r29;
        goto L59
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final int component1() {
        return this.type;
    }

    public final String component10() {
        return this.actionTitle;
    }

    public final String component11() {
        return this.actionTitleColor;
    }

    public final String component12() {
        return this.actionTitleColorDark;
    }

    public final Integer component13() {
        return this.actionIntentType;
    }

    public final String component14() {
        return this.actionIntent;
    }

    public final String component2() {
        return this.action;
    }

    public final Intent component3() {
        return this.intent;
    }

    public final boolean component4() {
        return this.clickWithCollapse;
    }

    public final String component5() {
        return this.actionIcon;
    }

    public final int component6() {
        return this.actionIconResId;
    }

    public final String component7() {
        return this.actionIconDark;
    }

    public final Integer component8() {
        return this.actionIconDarkResId;
    }

    public final String component9() {
        return this.actionBgColor;
    }

    public final ExpandedImageTextActionInfo copy(int r17, String r18, Intent r19, boolean r20, String r21, int r22, String r23, Integer r24, String r25, String r26, String r27, String r28, Integer r29, String r30) {
        return new ExpandedImageTextActionInfo(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExpandedImageTextActionInfo.class) == true) goto L8;
        return false;
    L8:
        ExpandedImageTextActionInfo r6 = (ExpandedImageTextActionInfo) ZeusTransformUtils.preCheckCast(r5, ExpandedImageTextActionInfo.class, "com.obric.memorydata.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.intent, r6.intent) == true) goto L18;
        return false;
    L18:
        if (this.clickWithCollapse == r6.clickWithCollapse) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actionIcon, r6.actionIcon) == true) goto L24;
        return false;
    L24:
        if (this.actionIconResId == r6.actionIconResId) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.actionIconDark, r6.actionIconDark) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.actionIconDarkResId, r6.actionIconDarkResId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.actionBgColor, r6.actionBgColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.actionTitle, r6.actionTitle) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.actionTitleColor, r6.actionTitleColor) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.actionTitleColorDark, r6.actionTitleColorDark) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.actionIntentType, r6.actionIntentType) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.actionIntent, r6.actionIntent) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getActionBgColor() {
        return this.actionBgColor;
    }

    public final String getActionIcon() {
        return this.actionIcon;
    }

    public final String getActionIconDark() {
        return this.actionIconDark;
    }

    public final Integer getActionIconDarkResId() {
        return this.actionIconDarkResId;
    }

    public final int getActionIconResId() {
        return this.actionIconResId;
    }

    public final String getActionIntent() {
        return this.actionIntent;
    }

    public final Integer getActionIntentType() {
        return this.actionIntentType;
    }

    public final String getActionTitle() {
        return this.actionTitle;
    }

    public final String getActionTitleColor() {
        return this.actionTitleColor;
    }

    public final String getActionTitleColorDark() {
        return this.actionTitleColorDark;
    }

    public final boolean getClickWithCollapse() {
        return this.clickWithCollapse;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.type) * 31;
        String r1 = this.action;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Intent r5 = this.intent;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Boolean.hashCode(this.clickWithCollapse)) * 31;
        String r8 = this.actionIcon;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + Integer.hashCode(this.actionIconResId)) * 31;
        String r11 = this.actionIconDark;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.actionIconDarkResId;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.actionBgColor;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.actionTitle;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.actionTitleColor;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.actionTitleColorDark;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.actionIntentType;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.actionIntent;
        if (r32 == null) goto L47;
        r2 = r32.hashCode();
    L47:
        return r31 + r2;
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setAction(String r1) {
        this.action = r1;
    }

    public final void setActionBgColor(String r1) {
        this.actionBgColor = r1;
    }

    public final void setActionIcon(String r1) {
        this.actionIcon = r1;
    }

    public final void setActionIconDark(String r1) {
        this.actionIconDark = r1;
    }

    public final void setActionIconDarkResId(Integer r1) {
        this.actionIconDarkResId = r1;
    }

    public final void setActionIconResId(int r1) {
        this.actionIconResId = r1;
    }

    public final void setActionIntent(String r1) {
        this.actionIntent = r1;
    }

    public final void setActionIntentType(Integer r1) {
        this.actionIntentType = r1;
    }

    public final void setActionTitle(String r1) {
        this.actionTitle = r1;
    }

    public final void setActionTitleColor(String r1) {
        this.actionTitleColor = r1;
    }

    public final void setActionTitleColorDark(String r1) {
        this.actionTitleColorDark = r1;
    }

    public final void setClickWithCollapse(boolean r1) {
        this.clickWithCollapse = r1;
    }

    public final void setIntent(Intent r1) {
        this.intent = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandComponents", "ExpandedImageTextActionInfo.toJSONObject: type=" + this.type + ", action=" + this.action);
        JSONObject r0 = new JSONObject();
        r0.put("type", this.type);
        r0.put("action", this.action);
        r0.put("clickWithCollapse", this.clickWithCollapse);
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ExpandedImageTextActionInfo(type=").append(this.type).append(", action=").append(this.action).append(", intent=").append(this.intent).append(", clickWithCollapse=").append(this.clickWithCollapse).append(", actionIcon=").append(this.actionIcon).append(", actionIconResId=").append(this.actionIconResId).append(", actionIconDark=").append(this.actionIconDark).append(", actionIconDarkResId=").append(this.actionIconDarkResId).append(", actionBgColor=").append(this.actionBgColor).append(", actionTitle=").append(this.actionTitle).append(", actionTitleColor=").append(this.actionTitleColor).append(", actionTitleColorDark=");
        r0.append(this.actionTitleColorDark).append(", actionIntentType=").append(this.actionIntentType).append(", actionIntent=").append(this.actionIntent).append(')');
        return r0.toString();
    }
}
