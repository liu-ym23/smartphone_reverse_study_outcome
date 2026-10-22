package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11674a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f11675b = null;

    static {
        int[] r5 = new int[ControllerState.values().length];
        r5[ControllerState.OPENED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
    L26:
        r5[ControllerState.HIDDEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
    L34:
        r5[ControllerState.ALPHA_HIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
    L28:
        r5[ControllerState.SCROLLING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
    L9:
        f11674a = r5;
        int[] r10 = new int[OverlayTransitionMode.values().length];
        r10[OverlayTransitionMode.DRAG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
    L30:
        r10[OverlayTransitionMode.SNAP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
    L22:
        r10[OverlayTransitionMode.ANIMATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
    L13:
        f11675b = r10;
    }
}
