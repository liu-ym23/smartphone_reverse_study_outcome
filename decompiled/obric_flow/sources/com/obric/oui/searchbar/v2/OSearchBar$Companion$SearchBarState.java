package com.obric.oui.searchbar.v2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState", "", "Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;", "RESTING", "ACTIVE", "VALUE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSearchBar$Companion$SearchBarState extends Enum<OSearchBar$Companion$SearchBarState> {
    public static final OSearchBar$Companion$SearchBarState ACTIVE = null;
    public static final OSearchBar$Companion$SearchBarState RESTING = null;
    public static final OSearchBar$Companion$SearchBarState VALUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSearchBar$Companion$SearchBarState[] f14288a = null;

    static {
        OSearchBar$Companion$SearchBarState r5 = new OSearchBar$Companion$SearchBarState("RESTING", 0);
        RESTING = r5;
        OSearchBar$Companion$SearchBarState r10 = new OSearchBar$Companion$SearchBarState("ACTIVE", 1);
        ACTIVE = r10;
        OSearchBar$Companion$SearchBarState r11 = new OSearchBar$Companion$SearchBarState("VALUE", 2);
        VALUE = r11;
        f14288a = new OSearchBar$Companion$SearchBarState[]{r5, r10, r11};
    }

    public static OSearchBar$Companion$SearchBarState valueOf(String r5) {
        return (OSearchBar$Companion$SearchBarState) Enum.valueOf(OSearchBar$Companion$SearchBarState.class, r5);
    }

    public static OSearchBar$Companion$SearchBarState[] values() {
        return (OSearchBar$Companion$SearchBarState[]) f14288a.clone();
    }
}
