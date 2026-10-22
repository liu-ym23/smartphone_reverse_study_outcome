package com.obric.assistant.chat.burypoint;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/chat/burypoint/ObricLeaveSecondaryMenuMethod;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LEAVE_METHOD_CLICK_MINI_ICON", "LEAVE_METHOD_CLICK_SKILL_IN_PANEL", "LEAVE_METHOD_CLICK_WHITE_AREA", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricLeaveSecondaryMenuMethod extends Enum<ObricLeaveSecondaryMenuMethod> {
    public static final ObricLeaveSecondaryMenuMethod LEAVE_METHOD_CLICK_MINI_ICON = null;
    public static final ObricLeaveSecondaryMenuMethod LEAVE_METHOD_CLICK_SKILL_IN_PANEL = null;
    public static final ObricLeaveSecondaryMenuMethod LEAVE_METHOD_CLICK_WHITE_AREA = null;
    public static final /* synthetic */ ObricLeaveSecondaryMenuMethod[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ObricLeaveSecondaryMenuMethod> getEntries() {
        return b;
    }

    static {
        ObricLeaveSecondaryMenuMethod r0 = new ObricLeaveSecondaryMenuMethod("LEAVE_METHOD_CLICK_MINI_ICON", 0, "click_mini_icon");
        LEAVE_METHOD_CLICK_MINI_ICON = r0;
        ObricLeaveSecondaryMenuMethod r1 = new ObricLeaveSecondaryMenuMethod("LEAVE_METHOD_CLICK_SKILL_IN_PANEL", 1, "click_skill_in_panel");
        LEAVE_METHOD_CLICK_SKILL_IN_PANEL = r1;
        ObricLeaveSecondaryMenuMethod r2 = new ObricLeaveSecondaryMenuMethod("LEAVE_METHOD_CLICK_WHITE_AREA", 2, "click_white_area");
        LEAVE_METHOD_CLICK_WHITE_AREA = r2;
        ObricLeaveSecondaryMenuMethod[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static ObricLeaveSecondaryMenuMethod[] values() {
        return (ObricLeaveSecondaryMenuMethod[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ObricLeaveSecondaryMenuMethod valueOf(String r1) {
        return (ObricLeaveSecondaryMenuMethod) a.a(ObricLeaveSecondaryMenuMethod.class, r1);
    }

    public ObricLeaveSecondaryMenuMethod(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
