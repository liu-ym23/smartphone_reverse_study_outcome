package com.ss.android.lark.maintab.export.model;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/maintab/export/model/SubPageType;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_SCREEN", "SPLIT_SCREEN", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum SubPageType extends Enum<SubPageType> {
    public static final SubPageType FULL_SCREEN = null;
    public static final SubPageType SPLIT_SCREEN = null;
    public static final /* synthetic */ SubPageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SubPageType> getEntries() {
        return b;
    }

    static {
        SubPageType r0 = new SubPageType("FULL_SCREEN", 0);
        FULL_SCREEN = r0;
        SubPageType r1 = new SubPageType("SPLIT_SCREEN", 1);
        SPLIT_SCREEN = r1;
        SubPageType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SubPageType[] values() {
        return (SubPageType[]) a.clone();
    }

    public static SubPageType valueOf(String r1) {
        return (SubPageType) a.a(SubPageType.class, r1);
    }

    public SubPageType(String r1, int r2) {
        super(r1, r2);
    }
}
