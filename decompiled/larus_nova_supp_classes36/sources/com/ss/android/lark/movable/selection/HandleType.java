package com.ss.android.lark.movable.selection;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/movable/selection/HandleType;", "", "<init>", "(Ljava/lang/String;I)V", "START", "END", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum HandleType extends Enum<HandleType> {
    public static final HandleType END = null;
    public static final HandleType START = null;
    public static final /* synthetic */ HandleType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HandleType> getEntries() {
        return b;
    }

    static {
        HandleType r0 = new HandleType("START", 0);
        START = r0;
        HandleType r1 = new HandleType("END", 1);
        END = r1;
        HandleType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static HandleType[] values() {
        return (HandleType[]) a.clone();
    }

    public static HandleType valueOf(String r1) {
        return (HandleType) r27.a.a(HandleType.class, r1);
    }

    public HandleType(String r1, int r2) {
        super(r1, r2);
    }
}
