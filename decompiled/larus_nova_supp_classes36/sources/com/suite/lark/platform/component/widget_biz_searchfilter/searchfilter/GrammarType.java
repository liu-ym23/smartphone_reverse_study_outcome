package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/GrammarType;", "", "<init>", "(Ljava/lang/String;I)V", "UnSupport", "From", "With", "InChat", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum GrammarType extends Enum<GrammarType> {
    public static final GrammarType From = null;
    public static final GrammarType InChat = null;
    public static final GrammarType UnSupport = null;
    public static final GrammarType With = null;
    public static final /* synthetic */ GrammarType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<GrammarType> getEntries() {
        return b;
    }

    static {
        GrammarType r0 = new GrammarType("UnSupport", 0);
        UnSupport = r0;
        GrammarType r1 = new GrammarType("From", 1);
        From = r1;
        GrammarType r3 = new GrammarType("With", 2);
        With = r3;
        GrammarType r5 = new GrammarType("InChat", 3);
        InChat = r5;
        GrammarType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static GrammarType[] values() {
        return (GrammarType[]) a.clone();
    }

    public static GrammarType valueOf(String r1) {
        return (GrammarType) r27.a.a(GrammarType.class, r1);
    }

    public GrammarType(String r1, int r2) {
        super(r1, r2);
    }
}
