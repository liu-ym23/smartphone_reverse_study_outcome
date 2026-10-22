package com.bytedance.ai.ex.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/ex/widget/WindowLifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "ATTACHED", "VISIBLE", "FOCUSED", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WindowLifecycleState extends Enum<WindowLifecycleState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WindowLifecycleState[] $VALUES = null;
    public static final WindowLifecycleState ATTACHED = null;
    public static final WindowLifecycleState FOCUSED = null;
    public static final WindowLifecycleState VISIBLE = null;

    private static final /* synthetic */ WindowLifecycleState[] $values() {
        return new WindowLifecycleState[]{ATTACHED, VISIBLE, FOCUSED};
    }

    static {
        ATTACHED = new WindowLifecycleState("ATTACHED", 0);
        VISIBLE = new WindowLifecycleState("VISIBLE", 1);
        FOCUSED = new WindowLifecycleState("FOCUSED", 2);
        WindowLifecycleState[] r5 = $values();
        $VALUES = r5;
        $ENTRIES = EnumEntriesKt.enumEntries(r5);
    }

    private WindowLifecycleState(String r5, int r10) {
        super(r5, r10);
    }

    public static EnumEntries<WindowLifecycleState> getEntries() {
        return $ENTRIES;
    }

    public static WindowLifecycleState valueOf(String r5) {
        return (WindowLifecycleState) Enum.valueOf(WindowLifecycleState.class, r5);
    }

    public static WindowLifecycleState[] values() {
        return (WindowLifecycleState[]) $VALUES.clone();
    }
}
