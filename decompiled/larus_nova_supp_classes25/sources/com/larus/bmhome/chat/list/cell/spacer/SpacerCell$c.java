package com.larus.bmhome.chat.list.cell.spacer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public /* synthetic */ class SpacerCell$c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[SpacerAnimationState.values().length];
        r0[SpacerAnimationState.WAITING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
    L26:
        r0[SpacerAnimationState.COLLAPSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
    L34:
        r0[SpacerAnimationState.EXPAND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
    L28:
        r0[SpacerAnimationState.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
    L9:
        a = r0;
        int[] r1 = new int[SpacerCell$FollowLatestResult.values().length];
        r1[SpacerCell$FollowLatestResult.APPLIED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
    L30:
        r1[SpacerCell$FollowLatestResult.DEFERRED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
    L22:
        r1[SpacerCell$FollowLatestResult.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
    L13:
        b = r1;
    }
}
