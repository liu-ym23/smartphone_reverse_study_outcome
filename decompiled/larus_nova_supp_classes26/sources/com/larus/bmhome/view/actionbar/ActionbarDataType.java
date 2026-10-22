package com.larus.bmhome.view.actionbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/view/actionbar/ActionbarDataType;", "", "typeVal", "", "<init>", "(Ljava/lang/String;II)V", "getTypeVal", "()I", "ORDER", "BOT", "VIEW_TYPE_EXPERT_SWITCH", "VIEW_TYPE_GPT_4_SWITCH", "VIEW_TYPE_ACTION_BAR_HEADER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionbarDataType extends Enum<ActionbarDataType> {
    public static final ActionbarDataType BOT = null;
    public static final ActionbarDataType ORDER = null;
    public static final ActionbarDataType VIEW_TYPE_ACTION_BAR_HEADER = null;
    public static final ActionbarDataType VIEW_TYPE_EXPERT_SWITCH = null;
    public static final ActionbarDataType VIEW_TYPE_GPT_4_SWITCH = null;
    public static final /* synthetic */ ActionbarDataType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int typeVal;

    public static EnumEntries<ActionbarDataType> getEntries() {
        return b;
    }

    static {
        ActionbarDataType r0 = new ActionbarDataType("ORDER", 0, 0);
        ORDER = r0;
        ActionbarDataType r1 = new ActionbarDataType("BOT", 1, 1);
        BOT = r1;
        ActionbarDataType r3 = new ActionbarDataType("VIEW_TYPE_EXPERT_SWITCH", 2, -3);
        VIEW_TYPE_EXPERT_SWITCH = r3;
        ActionbarDataType r5 = new ActionbarDataType("VIEW_TYPE_GPT_4_SWITCH", 3, -2);
        VIEW_TYPE_GPT_4_SWITCH = r5;
        ActionbarDataType r6 = new ActionbarDataType("VIEW_TYPE_ACTION_BAR_HEADER", 4, -1);
        VIEW_TYPE_ACTION_BAR_HEADER = r6;
        ActionbarDataType[] r8 = {r0, r1, r3, r5, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static ActionbarDataType[] values() {
        return (ActionbarDataType[]) a.clone();
    }

    public final int getTypeVal() {
        return this.typeVal;
    }

    public static ActionbarDataType valueOf(String r1) {
        return (ActionbarDataType) a.a(ActionbarDataType.class, r1);
    }

    public ActionbarDataType(String r1, int r2, int r3) {
        super(r1, r2);
        this.typeVal = r3;
    }
}
