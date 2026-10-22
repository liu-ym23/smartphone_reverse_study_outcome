package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes3.dex */
public final enum RecyclerView$Adapter$StateRestorationPolicy extends Enum<RecyclerView$Adapter$StateRestorationPolicy> {
    public static final RecyclerView$Adapter$StateRestorationPolicy ALLOW = null;
    public static final RecyclerView$Adapter$StateRestorationPolicy PREVENT = null;
    public static final RecyclerView$Adapter$StateRestorationPolicy PREVENT_WHEN_EMPTY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecyclerView$Adapter$StateRestorationPolicy[] f13767a = null;

    static {
        RecyclerView$Adapter$StateRestorationPolicy r5 = new RecyclerView$Adapter$StateRestorationPolicy("ALLOW", 0);
        ALLOW = r5;
        RecyclerView$Adapter$StateRestorationPolicy r10 = new RecyclerView$Adapter$StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1);
        PREVENT_WHEN_EMPTY = r10;
        RecyclerView$Adapter$StateRestorationPolicy r11 = new RecyclerView$Adapter$StateRestorationPolicy("PREVENT", 2);
        PREVENT = r11;
        f13767a = new RecyclerView$Adapter$StateRestorationPolicy[]{r5, r10, r11};
    }

    public static RecyclerView$Adapter$StateRestorationPolicy valueOf(String r5) {
        return (RecyclerView$Adapter$StateRestorationPolicy) Enum.valueOf(RecyclerView$Adapter$StateRestorationPolicy.class, r5);
    }

    public static RecyclerView$Adapter$StateRestorationPolicy[] values() {
        return (RecyclerView$Adapter$StateRestorationPolicy[]) f13767a.clone();
    }
}
