package com.obric.aiagent.assistant_card.provider_core.bean;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/assistant_card/provider_core/bean/ActionType;", NameKeys.UnloadStrategy_No_Strategy, "type", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ACTION_ON_CLICK", "ACTION_ON_LONG_CLICK", "assistant-card-provider-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType ACTION_ON_CLICK = null;
    public static final ActionType ACTION_ON_LONG_CLICK = null;
    public static final /* synthetic */ ActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<ActionType> getEntries() {
        return b;
    }

    static {
        ActionType r0 = new ActionType("ACTION_ON_CLICK", 0, "on_click");
        ACTION_ON_CLICK = r0;
        ActionType r1 = new ActionType("ACTION_ON_LONG_CLICK", 1, "on_long_click");
        ACTION_ON_LONG_CLICK = r1;
        ActionType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static ActionType[] values() {
        return (ActionType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static ActionType valueOf(String r1) {
        return (ActionType) a.a(ActionType.class, r1);
    }

    public ActionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
