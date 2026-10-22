package com.obric.oui.lisitem;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/lisitem/ListItemHeightMode;", "", "DEFAULT", "COMPACT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ListItemHeightMode extends Enum<ListItemHeightMode> {
    public static final ListItemHeightMode COMPACT = null;
    public static final ListItemHeightMode DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListItemHeightMode[] f13540a = null;

    static {
        ListItemHeightMode r5 = new ListItemHeightMode("DEFAULT", 0);
        DEFAULT = r5;
        ListItemHeightMode r10 = new ListItemHeightMode("COMPACT", 1);
        COMPACT = r10;
        f13540a = new ListItemHeightMode[]{r5, r10};
    }

    public static ListItemHeightMode valueOf(String r5) {
        return (ListItemHeightMode) Enum.valueOf(ListItemHeightMode.class, r5);
    }

    public static ListItemHeightMode[] values() {
        return (ListItemHeightMode[]) f13540a.clone();
    }
}
