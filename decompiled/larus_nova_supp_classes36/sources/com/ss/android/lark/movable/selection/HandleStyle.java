package com.ss.android.lark.movable.selection;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/movable/selection/HandleStyle;", "", "<init>", "(Ljava/lang/String;I)V", "LINE", "NORMAL", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum HandleStyle extends Enum<HandleStyle> {
    public static final HandleStyle LINE = null;
    public static final HandleStyle NORMAL = null;
    public static final /* synthetic */ HandleStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HandleStyle> getEntries() {
        return b;
    }

    static {
        HandleStyle r0 = new HandleStyle("LINE", 0);
        LINE = r0;
        HandleStyle r1 = new HandleStyle("NORMAL", 1);
        NORMAL = r1;
        HandleStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static HandleStyle[] values() {
        return (HandleStyle[]) a.clone();
    }

    public static HandleStyle valueOf(String r1) {
        return (HandleStyle) r27.a.a(HandleStyle.class, r1);
    }

    public HandleStyle(String r1, int r2) {
        super(r1, r2);
    }
}
