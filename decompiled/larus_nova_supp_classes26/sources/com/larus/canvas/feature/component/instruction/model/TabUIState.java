package com.larus.canvas.feature.component.instruction.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/TabUIState;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_LOADING", "STATE_SHOW", "STATE_ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabUIState extends Enum<TabUIState> {
    public static final TabUIState STATE_ERROR = null;
    public static final TabUIState STATE_LOADING = null;
    public static final TabUIState STATE_SHOW = null;
    public static final /* synthetic */ TabUIState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TabUIState> getEntries() {
        return b;
    }

    static {
        TabUIState r0 = new TabUIState("STATE_LOADING", 0);
        STATE_LOADING = r0;
        TabUIState r1 = new TabUIState("STATE_SHOW", 1);
        STATE_SHOW = r1;
        TabUIState r3 = new TabUIState("STATE_ERROR", 2);
        STATE_ERROR = r3;
        TabUIState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static TabUIState[] values() {
        return (TabUIState[]) a.clone();
    }

    public static TabUIState valueOf(String r1) {
        return (TabUIState) r27.a.a(TabUIState.class, r1);
    }

    public TabUIState(String r1, int r2) {
        super(r1, r2);
    }
}
