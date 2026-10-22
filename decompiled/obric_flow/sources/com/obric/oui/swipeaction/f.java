package com.obric.oui.swipeaction;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f14620a = null;

    static {
        int[] r5 = new int[OSwipeLayout.DragEdge.values().length];
        f14620a = r5;
        r5[OSwipeLayout.DragEdge.Top.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L12:
        f14620a[OSwipeLayout.DragEdge.Bottom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L14:
        f14620a[OSwipeLayout.DragEdge.Left.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L18:
        f14620a[OSwipeLayout.DragEdge.Right.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
        return;
    }
}
