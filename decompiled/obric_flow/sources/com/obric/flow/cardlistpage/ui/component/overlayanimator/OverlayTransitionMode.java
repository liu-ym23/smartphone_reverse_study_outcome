package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/flow/cardlistpage/ui/component/overlayanimator/OverlayTransitionMode;", "", "DRAG", "SNAP", "ANIMATE", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum OverlayTransitionMode extends Enum<OverlayTransitionMode> {
    public static final OverlayTransitionMode ANIMATE = null;
    public static final OverlayTransitionMode DRAG = null;
    public static final OverlayTransitionMode SNAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OverlayTransitionMode[] f11642a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f11643b = null;

    static {
        OverlayTransitionMode r5 = new OverlayTransitionMode("DRAG", 0);
        DRAG = r5;
        OverlayTransitionMode r10 = new OverlayTransitionMode("SNAP", 1);
        SNAP = r10;
        OverlayTransitionMode r11 = new OverlayTransitionMode("ANIMATE", 2);
        ANIMATE = r11;
        OverlayTransitionMode[] r12 = {r5, r10, r11};
        f11642a = r12;
        f11643b = EnumEntriesKt.enumEntries(r12);
    }

    public static EnumEntries<OverlayTransitionMode> getEntries() {
        return f11643b;
    }

    public static OverlayTransitionMode valueOf(String r5) {
        return (OverlayTransitionMode) Enum.valueOf(OverlayTransitionMode.class, r5);
    }

    public static OverlayTransitionMode[] values() {
        return (OverlayTransitionMode[]) f11642a.clone();
    }
}
