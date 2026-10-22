package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/widget/UIContextStrategy;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum UIContextStrategy extends Enum<UIContextStrategy> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UIContextStrategy[] f2914a = null;

    static {
        UIContextStrategy[] r5 = {new UIContextStrategy("DEFAULT", 0), new UIContextStrategy("ALWAYS", 1)};
        f2914a = r5;
        EnumEntriesKt.enumEntries(r5);
    }

    public UIContextStrategy(String r5, int r10) {
        super(r5, r10);
    }

    public static UIContextStrategy valueOf(String r5) {
        return (UIContextStrategy) Enum.valueOf(UIContextStrategy.class, r5);
    }

    public static UIContextStrategy[] values() {
        return (UIContextStrategy[]) f2914a.clone();
    }
}
