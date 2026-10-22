package com.larus.bmhome.auth;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/auth/ActionBarConfig$ActionBarReplaceMode;", "", "model", "", "<init>", "(Ljava/lang/String;II)V", "getModel", "()I", "UNKNOWN", "REPLACE_ALL", "INSERT_AHEAD", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ActionBarConfig$ActionBarReplaceMode extends Enum<ActionBarConfig$ActionBarReplaceMode> {
    public static final ActionBarConfig$ActionBarReplaceMode INSERT_AHEAD = null;
    public static final ActionBarConfig$ActionBarReplaceMode REPLACE_ALL = null;
    public static final ActionBarConfig$ActionBarReplaceMode UNKNOWN = null;
    public static final /* synthetic */ ActionBarConfig$ActionBarReplaceMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int model;

    public static EnumEntries<ActionBarConfig$ActionBarReplaceMode> getEntries() {
        return b;
    }

    static {
        ActionBarConfig$ActionBarReplaceMode r0 = new ActionBarConfig$ActionBarReplaceMode("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        ActionBarConfig$ActionBarReplaceMode r1 = new ActionBarConfig$ActionBarReplaceMode("REPLACE_ALL", 1, 1);
        REPLACE_ALL = r1;
        ActionBarConfig$ActionBarReplaceMode r2 = new ActionBarConfig$ActionBarReplaceMode("INSERT_AHEAD", 2, 2);
        INSERT_AHEAD = r2;
        ActionBarConfig$ActionBarReplaceMode[] r5 = {r0, r1, r2};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ActionBarConfig$ActionBarReplaceMode[] values() {
        return (ActionBarConfig$ActionBarReplaceMode[]) a.clone();
    }

    public final int getModel() {
        return this.model;
    }

    public static ActionBarConfig$ActionBarReplaceMode valueOf(String r1) {
        return (ActionBarConfig$ActionBarReplaceMode) a.a(ActionBarConfig$ActionBarReplaceMode.class, r1);
    }

    public ActionBarConfig$ActionBarReplaceMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.model = r3;
    }
}
