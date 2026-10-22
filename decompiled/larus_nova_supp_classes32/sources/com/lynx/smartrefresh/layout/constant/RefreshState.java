package com.lynx.smartrefresh.layout.constant;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum RefreshState extends Enum<RefreshState> {
    public static final RefreshState LoadFinish = null;
    public static final RefreshState LoadReleased = null;
    public static final RefreshState Loading = null;
    public static final RefreshState None = null;
    public static final RefreshState PullDownCanceled = null;
    public static final RefreshState PullDownToRefresh = null;
    public static final RefreshState PullUpCanceled = null;
    public static final RefreshState PullUpToLoad = null;
    public static final RefreshState RefreshFinish = null;
    public static final RefreshState RefreshReleased = null;
    public static final RefreshState Refreshing = null;
    public static final RefreshState ReleaseToLoad = null;
    public static final RefreshState ReleaseToRefresh = null;
    public static final RefreshState ReleaseToTwoLevel = null;
    public static final RefreshState TwoLevel = null;
    public static final RefreshState TwoLevelFinish = null;
    public static final RefreshState TwoLevelReleased = null;
    public static final /* synthetic */ RefreshState[] a = null;
    public final boolean isDragging;
    public final boolean isFinishing;
    public final boolean isFooter;
    public final boolean isHeader;
    public final boolean isOpening;
    public final boolean isReleaseToOpening;
    public final boolean isTwoLevel;

    static {
        RefreshState r9 = new RefreshState("None", 0, 0, false, false, false, false, false);
        None = r9;
        RefreshState r0 = new RefreshState("PullDownToRefresh", 1, 1, true, false, false, false, false);
        PullDownToRefresh = r0;
        RefreshState r1 = new RefreshState("PullUpToLoad", 2, 2, true, false, false, false, false);
        PullUpToLoad = r1;
        RefreshState r2 = new RefreshState("PullDownCanceled", 3, 1, false, false, false, false, false);
        PullDownCanceled = r2;
        RefreshState r3 = new RefreshState("PullUpCanceled", 4, 2, false, false, false, false, false);
        PullUpCanceled = r3;
        RefreshState r4 = new RefreshState("ReleaseToRefresh", 5, 1, true, false, false, false, true);
        ReleaseToRefresh = r4;
        RefreshState r5 = new RefreshState("ReleaseToLoad", 6, 2, true, false, false, false, true);
        ReleaseToLoad = r5;
        RefreshState r6 = new RefreshState("ReleaseToTwoLevel", 7, 1, true, false, false, true, true);
        ReleaseToTwoLevel = r6;
        RefreshState r7 = new RefreshState("TwoLevelReleased", 8, 1, false, false, false, true, false);
        TwoLevelReleased = r7;
        RefreshState r8 = new RefreshState("RefreshReleased", 9, 1, false, false, false, false, false);
        RefreshReleased = r8;
        RefreshState r10 = new RefreshState("LoadReleased", 10, 2, false, false, false, false, false);
        LoadReleased = r10;
        RefreshState r20 = new RefreshState("Refreshing", 11, 1, false, true, false, false, false);
        Refreshing = r20;
        RefreshState r11 = new RefreshState("Loading", 12, 2, false, true, false, false, false);
        Loading = r11;
        RefreshState r12 = new RefreshState("TwoLevel", 13, 1, false, true, false, true, false);
        TwoLevel = r12;
        RefreshState r13 = new RefreshState("RefreshFinish", 14, 1, false, false, true, false, false);
        RefreshFinish = r13;
        RefreshState r14 = new RefreshState("LoadFinish", 15, 2, false, false, true, false, false);
        LoadFinish = r14;
        RefreshState r15 = new RefreshState("TwoLevelFinish", 16, 1, false, false, true, true, false);
        TwoLevelFinish = r15;
        a = new RefreshState[]{r9, r0, r1, r2, r3, r4, r5, r6, r7, r8, r10, r20, r11, r12, r13, r14, r15};
    }

    public static RefreshState[] values() {
        return (RefreshState[]) a.clone();
    }

    public RefreshState toFooter() {
        if (this.isHeader == true) goto L5;
    L8:
        return this;
    L5:
        if (this.isTwoLevel == true) goto L8;
        return values()[ordinal() + 1];
    }

    public RefreshState toHeader() {
        if (this.isFooter == true) goto L5;
    L8:
        return this;
    L5:
        if (this.isTwoLevel == true) goto L8;
        return values()[ordinal() - 1];
    }

    public static RefreshState valueOf(String r1) {
        return (RefreshState) a.a(RefreshState.class, r1);
    }

    public RefreshState(String r2, int r3, int r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9) {
        super(r2, r3);
        boolean r10 = false;
        if (r4 != 1) goto L5;
        boolean r0 = true;
    L6:
        this.isHeader = r0;
        if (r4 != 2) goto L9;
        r10 = true;
    L9:
        this.isFooter = r10;
        this.isDragging = r5;
        this.isOpening = r6;
        this.isFinishing = r7;
        this.isTwoLevel = r8;
        this.isReleaseToOpening = r9;
        return;
    L5:
        r0 = false;
        goto L6
    }
}
