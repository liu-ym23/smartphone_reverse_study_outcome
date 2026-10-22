package com.ss.android.lark.maintab.export.model;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/maintab/export/model/EdgeExpandType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "AUTO", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum EdgeExpandType extends Enum<EdgeExpandType> {
    public static final EdgeExpandType AUTO = null;
    public static final EdgeExpandType NONE = null;
    public static final /* synthetic */ EdgeExpandType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<EdgeExpandType> getEntries() {
        return b;
    }

    static {
        EdgeExpandType r0 = new EdgeExpandType("NONE", 0);
        NONE = r0;
        EdgeExpandType r1 = new EdgeExpandType("AUTO", 1);
        AUTO = r1;
        EdgeExpandType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static EdgeExpandType[] values() {
        return (EdgeExpandType[]) a.clone();
    }

    public static EdgeExpandType valueOf(String r1) {
        return (EdgeExpandType) a.a(EdgeExpandType.class, r1);
    }

    public EdgeExpandType(String r1, int r2) {
        super(r1, r2);
    }
}
