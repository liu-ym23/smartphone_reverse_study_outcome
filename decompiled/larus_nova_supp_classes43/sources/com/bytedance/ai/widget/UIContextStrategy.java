package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/widget/UIContextStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "ALWAYS", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UIContextStrategy extends Enum<UIContextStrategy> {
    public static final UIContextStrategy ALWAYS = null;
    public static final UIContextStrategy DEFAULT = null;
    public static final /* synthetic */ UIContextStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UIContextStrategy> getEntries() {
        return b;
    }

    static {
        UIContextStrategy r0 = new UIContextStrategy("DEFAULT", 0);
        DEFAULT = r0;
        UIContextStrategy r1 = new UIContextStrategy("ALWAYS", 1);
        ALWAYS = r1;
        UIContextStrategy[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static UIContextStrategy[] values() {
        return (UIContextStrategy[]) a.clone();
    }

    public static UIContextStrategy valueOf(String r1) {
        return (UIContextStrategy) r27.a.a(UIContextStrategy.class, r1);
    }

    public UIContextStrategy(String r1, int r10) {
        super(r1, r10);
    }
}
