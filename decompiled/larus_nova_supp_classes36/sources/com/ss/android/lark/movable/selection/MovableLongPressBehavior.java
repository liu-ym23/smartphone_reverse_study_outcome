package com.ss.android.lark.movable.selection;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/movable/selection/MovableLongPressBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "PARTIAL_SELECTION", "SELECT_ALL_AND_DISPATCH", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum MovableLongPressBehavior extends Enum<MovableLongPressBehavior> {
    public static final MovableLongPressBehavior PARTIAL_SELECTION = null;
    public static final MovableLongPressBehavior SELECT_ALL_AND_DISPATCH = null;
    public static final /* synthetic */ MovableLongPressBehavior[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MovableLongPressBehavior> getEntries() {
        return b;
    }

    static {
        MovableLongPressBehavior r0 = new MovableLongPressBehavior("PARTIAL_SELECTION", 0);
        PARTIAL_SELECTION = r0;
        MovableLongPressBehavior r1 = new MovableLongPressBehavior("SELECT_ALL_AND_DISPATCH", 1);
        SELECT_ALL_AND_DISPATCH = r1;
        MovableLongPressBehavior[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MovableLongPressBehavior[] values() {
        return (MovableLongPressBehavior[]) a.clone();
    }

    public static MovableLongPressBehavior valueOf(String r1) {
        return (MovableLongPressBehavior) r27.a.a(MovableLongPressBehavior.class, r1);
    }

    public MovableLongPressBehavior(String r1, int r2) {
        super(r1, r2);
    }
}
