package com.ss.android.lark.maintab.export;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabUiExtraConfig$IconTintStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "NEVER", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum TabUiExtraConfig$IconTintStrategy extends Enum<TabUiExtraConfig$IconTintStrategy> {
    public static final TabUiExtraConfig$IconTintStrategy NEVER = null;
    public static final /* synthetic */ TabUiExtraConfig$IconTintStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TabUiExtraConfig$IconTintStrategy> getEntries() {
        return b;
    }

    static {
        TabUiExtraConfig$IconTintStrategy r0 = new TabUiExtraConfig$IconTintStrategy();
        NEVER = r0;
        TabUiExtraConfig$IconTintStrategy[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public TabUiExtraConfig$IconTintStrategy() {
        super("NEVER", 0);
    }

    public static TabUiExtraConfig$IconTintStrategy[] values() {
        return (TabUiExtraConfig$IconTintStrategy[]) a.clone();
    }

    public static TabUiExtraConfig$IconTintStrategy valueOf(String r1) {
        return (TabUiExtraConfig$IconTintStrategy) r27.a.a(TabUiExtraConfig$IconTintStrategy.class, r1);
    }
}
