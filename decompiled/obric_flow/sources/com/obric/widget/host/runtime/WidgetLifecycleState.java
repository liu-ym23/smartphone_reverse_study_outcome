package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetLifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "PERSISTED", "ATTACHED_HIDDEN", "VISIBLE_LOADING", "VISIBLE_READY", "HIDDEN_DIRTY", "VISIBLE_STALE", "DESTROYED", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WidgetLifecycleState extends Enum<WidgetLifecycleState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WidgetLifecycleState[] $VALUES = null;
    public static final WidgetLifecycleState ATTACHED_HIDDEN = null;
    public static final WidgetLifecycleState DESTROYED = null;
    public static final WidgetLifecycleState HIDDEN_DIRTY = null;
    public static final WidgetLifecycleState PERSISTED = null;
    public static final WidgetLifecycleState VISIBLE_LOADING = null;
    public static final WidgetLifecycleState VISIBLE_READY = null;
    public static final WidgetLifecycleState VISIBLE_STALE = null;

    private static final /* synthetic */ WidgetLifecycleState[] $values() {
        return new WidgetLifecycleState[]{PERSISTED, ATTACHED_HIDDEN, VISIBLE_LOADING, VISIBLE_READY, HIDDEN_DIRTY, VISIBLE_STALE, DESTROYED};
    }

    static {
        PERSISTED = new WidgetLifecycleState("PERSISTED", 0);
        ATTACHED_HIDDEN = new WidgetLifecycleState("ATTACHED_HIDDEN", 1);
        VISIBLE_LOADING = new WidgetLifecycleState("VISIBLE_LOADING", 2);
        VISIBLE_READY = new WidgetLifecycleState("VISIBLE_READY", 3);
        HIDDEN_DIRTY = new WidgetLifecycleState("HIDDEN_DIRTY", 4);
        VISIBLE_STALE = new WidgetLifecycleState("VISIBLE_STALE", 5);
        DESTROYED = new WidgetLifecycleState("DESTROYED", 6);
        WidgetLifecycleState[] r5 = $values();
        $VALUES = r5;
        $ENTRIES = EnumEntriesKt.enumEntries(r5);
    }

    private WidgetLifecycleState(String r5, int r10) {
        super(r5, r10);
    }

    public static EnumEntries<WidgetLifecycleState> getEntries() {
        return $ENTRIES;
    }

    public static WidgetLifecycleState valueOf(String r5) {
        return (WidgetLifecycleState) Enum.valueOf(WidgetLifecycleState.class, r5);
    }

    public static WidgetLifecycleState[] values() {
        return (WidgetLifecycleState[]) $VALUES.clone();
    }
}
