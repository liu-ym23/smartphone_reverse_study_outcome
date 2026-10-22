package com.larus.canvas.feature.component.logic.provider;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/canvas/feature/component/logic/provider/CanvasGallerySidebarItemType;", "", "<init>", "(Ljava/lang/String;I)V", "SHARE", "TO_VIDEO", "EDIT", "SHAREPNESS", "EXPAND", "ERASE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CanvasGallerySidebarItemType extends Enum<CanvasGallerySidebarItemType> {
    public static final CanvasGallerySidebarItemType EDIT = null;
    public static final CanvasGallerySidebarItemType ERASE = null;
    public static final CanvasGallerySidebarItemType EXPAND = null;
    public static final CanvasGallerySidebarItemType SHARE = null;
    public static final CanvasGallerySidebarItemType SHAREPNESS = null;
    public static final CanvasGallerySidebarItemType TO_VIDEO = null;
    public static final /* synthetic */ CanvasGallerySidebarItemType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CanvasGallerySidebarItemType> getEntries() {
        return b;
    }

    static {
        CanvasGallerySidebarItemType r0 = new CanvasGallerySidebarItemType("SHARE", 0);
        SHARE = r0;
        CanvasGallerySidebarItemType r1 = new CanvasGallerySidebarItemType("TO_VIDEO", 1);
        TO_VIDEO = r1;
        CanvasGallerySidebarItemType r3 = new CanvasGallerySidebarItemType("EDIT", 2);
        EDIT = r3;
        CanvasGallerySidebarItemType r5 = new CanvasGallerySidebarItemType("SHAREPNESS", 3);
        SHAREPNESS = r5;
        CanvasGallerySidebarItemType r7 = new CanvasGallerySidebarItemType("EXPAND", 4);
        EXPAND = r7;
        CanvasGallerySidebarItemType r9 = new CanvasGallerySidebarItemType("ERASE", 5);
        ERASE = r9;
        CanvasGallerySidebarItemType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static CanvasGallerySidebarItemType[] values() {
        return (CanvasGallerySidebarItemType[]) a.clone();
    }

    public static CanvasGallerySidebarItemType valueOf(String r1) {
        return (CanvasGallerySidebarItemType) r27.a.a(CanvasGallerySidebarItemType.class, r1);
    }

    public CanvasGallerySidebarItemType(String r1, int r2) {
        super(r1, r2);
    }
}
