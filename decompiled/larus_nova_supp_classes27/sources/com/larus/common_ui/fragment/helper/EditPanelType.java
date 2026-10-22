package com.larus.common_ui.fragment.helper;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/fragment/helper/EditPanelType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "NONE", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EditPanelType extends Enum<EditPanelType> {
    public static final EditPanelType IMAGE = null;
    public static final EditPanelType NONE = null;
    public static final EditPanelType VIDEO = null;
    public static final /* synthetic */ EditPanelType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<EditPanelType> getEntries() {
        return b;
    }

    static {
        EditPanelType r0 = new EditPanelType("IMAGE", 0);
        IMAGE = r0;
        EditPanelType r1 = new EditPanelType("VIDEO", 1);
        VIDEO = r1;
        EditPanelType r3 = new EditPanelType("NONE", 2);
        NONE = r3;
        EditPanelType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static EditPanelType[] values() {
        return (EditPanelType[]) a.clone();
    }

    public static EditPanelType valueOf(String r1) {
        return (EditPanelType) a.a(EditPanelType.class, r1);
    }

    public EditPanelType(String r1, int r2) {
        super(r1, r2);
    }
}
