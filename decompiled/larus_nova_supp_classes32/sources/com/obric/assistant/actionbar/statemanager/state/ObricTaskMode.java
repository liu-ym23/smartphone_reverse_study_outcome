package com.obric.assistant.actionbar.statemanager.state;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/obric/assistant/actionbar/statemanager/state/ObricTaskMode;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "STANDARD", "PRO", "isOAutoTask", NameKeys.UnloadStrategy_No_Strategy, "isComplexTask", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricTaskMode extends Enum<ObricTaskMode> {
    public static final ObricTaskMode PRO = null;
    public static final ObricTaskMode STANDARD = null;
    public static final /* synthetic */ ObricTaskMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ObricTaskMode> getEntries() {
        return b;
    }

    static {
        ObricTaskMode r0 = new ObricTaskMode("STANDARD", 0, "standard");
        STANDARD = r0;
        ObricTaskMode r1 = new ObricTaskMode("PRO", 1, "pro");
        PRO = r1;
        ObricTaskMode[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static ObricTaskMode[] values() {
        return (ObricTaskMode[]) a.clone();
    }

    public final boolean isComplexTask() {
        if (this != PRO) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOAutoTask() {
        if (this != STANDARD) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getValue() {
        return this.value;
    }

    public static ObricTaskMode valueOf(String r1) {
        return (ObricTaskMode) a.a(ObricTaskMode.class, r1);
    }

    public ObricTaskMode(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
