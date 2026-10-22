package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutViewState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "shortcutViewState", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState;", "skipAttachmentPanel", "", "<init>", "(Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState;Z)V", "getShortcutViewState", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState;", "getSkipAttachmentPanel", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LatestPhotoShortcutViewState implements w1a.b {
    private final ShortcutViewState shortcutViewState;
    private final boolean skipAttachmentPanel;

    public LatestPhotoShortcutViewState() {
        ShortcutViewState r2 = null;
        this(r2, false, 3, r2);
    }

    public static /* synthetic */ LatestPhotoShortcutViewState copy$default(LatestPhotoShortcutViewState r0, ShortcutViewState r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.shortcutViewState;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.skipAttachmentPanel;
    L9:
        return r0.copy(r1, r2);
    }

    public final ShortcutViewState component1() {
        return this.shortcutViewState;
    }

    public final boolean component2() {
        return this.skipAttachmentPanel;
    }

    public final LatestPhotoShortcutViewState copy(ShortcutViewState r2, boolean r3) {
        return new LatestPhotoShortcutViewState(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LatestPhotoShortcutViewState) == true) goto L8;
        return false;
    L8:
        LatestPhotoShortcutViewState r6 = (LatestPhotoShortcutViewState) r5;
        if (Intrinsics.areEqual(this.shortcutViewState, r6.shortcutViewState) == true) goto L12;
        return false;
    L12:
        if (this.skipAttachmentPanel == r6.skipAttachmentPanel) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ShortcutViewState r0 = this.shortcutViewState;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        if (this.skipAttachmentPanel == false) goto L9;
        int r3 = 1231;
    L11:
        return r2 + r3;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LatestPhotoShortcutViewState(shortcutViewState=" + this.shortcutViewState + ", skipAttachmentPanel=" + this.skipAttachmentPanel + ')';
    }

    public final ShortcutViewState getShortcutViewState() {
        return this.shortcutViewState;
    }

    public final boolean getSkipAttachmentPanel() {
        return this.skipAttachmentPanel;
    }

    public LatestPhotoShortcutViewState(ShortcutViewState r1, boolean r2) {
        this.shortcutViewState = r1;
        this.skipAttachmentPanel = r2;
    }

    public /* synthetic */ LatestPhotoShortcutViewState(ShortcutViewState r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        this(r1, r2);
    }
}
