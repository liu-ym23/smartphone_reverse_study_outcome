package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/flow/cardlistpage/ui/component/overlayanimator/ControllerState;", "", "", NotificationCompat.CATEGORY_STATUS, "I", "getStatus", "()I", "HIDDEN", "SCROLLING", "OPENED", "ALPHA_HIDDEN", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum ControllerState extends Enum<ControllerState> {
    public static final ControllerState ALPHA_HIDDEN = null;
    public static final ControllerState HIDDEN = null;
    public static final ControllerState OPENED = null;
    public static final ControllerState SCROLLING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ControllerState[] f11640a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f11641b = null;
    private final int status;

    static {
        ControllerState r5 = new ControllerState("HIDDEN", 0, 0);
        HIDDEN = r5;
        ControllerState r10 = new ControllerState("SCROLLING", 1, 1);
        SCROLLING = r10;
        ControllerState r11 = new ControllerState("OPENED", 2, 2);
        OPENED = r11;
        ControllerState r12 = new ControllerState("ALPHA_HIDDEN", 3, 3);
        ALPHA_HIDDEN = r12;
        ControllerState[] r13 = {r5, r10, r11, r12};
        f11640a = r13;
        f11641b = EnumEntriesKt.enumEntries(r13);
    }

    public ControllerState(String r5, int r10, int r11) {
        super(r5, r10);
        this.status = r11;
    }

    public static EnumEntries<ControllerState> getEntries() {
        return f11641b;
    }

    public static ControllerState valueOf(String r5) {
        return (ControllerState) Enum.valueOf(ControllerState.class, r5);
    }

    public static ControllerState[] values() {
        return (ControllerState[]) f11640a.clone();
    }

    public final int getStatus() {
        return this.status;
    }
}
