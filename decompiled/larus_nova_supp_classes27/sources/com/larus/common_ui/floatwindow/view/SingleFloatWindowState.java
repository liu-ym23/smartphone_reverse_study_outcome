package com.larus.common_ui.floatwindow.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common_ui/floatwindow/view/SingleFloatWindowState;", "", "<init>", "(Ljava/lang/String;I)V", "MINIMIZE", "MAXIMIZE", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SingleFloatWindowState extends Enum<SingleFloatWindowState> {
    public static final SingleFloatWindowState MAXIMIZE = null;
    public static final SingleFloatWindowState MINIMIZE = null;
    public static final /* synthetic */ SingleFloatWindowState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SingleFloatWindowState> getEntries() {
        return b;
    }

    static {
        SingleFloatWindowState r0 = new SingleFloatWindowState("MINIMIZE", 0);
        MINIMIZE = r0;
        SingleFloatWindowState r1 = new SingleFloatWindowState("MAXIMIZE", 1);
        MAXIMIZE = r1;
        SingleFloatWindowState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SingleFloatWindowState[] values() {
        return (SingleFloatWindowState[]) a.clone();
    }

    public static SingleFloatWindowState valueOf(String r1) {
        return (SingleFloatWindowState) r27.a.a(SingleFloatWindowState.class, r1);
    }

    public SingleFloatWindowState(String r1, int r2) {
        super(r1, r2);
    }
}
