package com.ss.android.lark.guide.ui.common.popup;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/guide/ui/common/popup/OverlayType;", "", "<init>", "(Ljava/lang/String;I)V", "POPUP_WINDOW", "VIEW", "guide-ui_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum OverlayType extends Enum<OverlayType> {
    public static final OverlayType POPUP_WINDOW = null;
    public static final OverlayType VIEW = null;
    public static final /* synthetic */ OverlayType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OverlayType> getEntries() {
        return b;
    }

    static {
        OverlayType r0 = new OverlayType("POPUP_WINDOW", 0);
        POPUP_WINDOW = r0;
        OverlayType r1 = new OverlayType("VIEW", 1);
        VIEW = r1;
        OverlayType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OverlayType[] values() {
        return (OverlayType[]) a.clone();
    }

    public static OverlayType valueOf(String r1) {
        return (OverlayType) a.a(OverlayType.class, r1);
    }

    public OverlayType(String r1, int r2) {
        super(r1, r2);
    }
}
