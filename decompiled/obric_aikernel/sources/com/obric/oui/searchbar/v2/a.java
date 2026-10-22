package com.obric.oui.searchbar.v2;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f7236b = null;

    static {
        int[] r10 = new int[OSearchBar.Companion.SearchBarState.values().length];
        f7235a = r10;
        OSearchBar.Companion.SearchBarState r11 = OSearchBar.Companion.SearchBarState.RESTING;
        r10[r11.ordinal()] = 1;
        int[] r12 = new int[OSearchBar.Companion.SearchBarState.values().length];
        f7236b = r12;
        r12[r11.ordinal()] = 1;
        r12[OSearchBar.Companion.SearchBarState.ACTIVE.ordinal()] = 2;
        r12[OSearchBar.Companion.SearchBarState.VALUE.ordinal()] = 3;
    }
}
