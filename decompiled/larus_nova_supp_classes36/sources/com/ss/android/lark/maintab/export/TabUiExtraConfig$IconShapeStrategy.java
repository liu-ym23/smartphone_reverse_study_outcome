package com.ss.android.lark.maintab.export;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabUiExtraConfig$IconShapeStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "CIRCLE", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum TabUiExtraConfig$IconShapeStrategy extends Enum<TabUiExtraConfig$IconShapeStrategy> {
    public static final TabUiExtraConfig$IconShapeStrategy CIRCLE = null;
    public static final /* synthetic */ TabUiExtraConfig$IconShapeStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TabUiExtraConfig$IconShapeStrategy> getEntries() {
        return b;
    }

    static {
        TabUiExtraConfig$IconShapeStrategy r0 = new TabUiExtraConfig$IconShapeStrategy();
        CIRCLE = r0;
        TabUiExtraConfig$IconShapeStrategy[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public TabUiExtraConfig$IconShapeStrategy() {
        super("CIRCLE", 0);
    }

    public static TabUiExtraConfig$IconShapeStrategy[] values() {
        return (TabUiExtraConfig$IconShapeStrategy[]) a.clone();
    }

    public static TabUiExtraConfig$IconShapeStrategy valueOf(String r1) {
        return (TabUiExtraConfig$IconShapeStrategy) r27.a.a(TabUiExtraConfig$IconShapeStrategy.class, r1);
    }
}
