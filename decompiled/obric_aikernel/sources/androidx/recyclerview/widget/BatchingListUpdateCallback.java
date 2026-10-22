package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    int mLastEventCount;
    Object mLastEventPayload;
    int mLastEventPosition;
    int mLastEventType;
    final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback r10) {
        this.mLastEventType = 0;
        this.mLastEventPosition = -1;
        this.mLastEventCount = -1;
        this.mLastEventPayload = null;
        this.mWrapped = r10;
    }

    public void dispatchLastEvent() {
        int r10 = this.mLastEventType;
        if (r10 != 0) goto L6;
        return;
    L6:
        if (r10 != 1) goto L8;
        this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
    L15:
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
        return;
    L8:
        if (r10 != 2) goto L10;
        this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        goto L15
    L10:
        if (r10 != 3) goto L15;
        this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        goto L15
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int r10, int r11, Object r12) {
        if (this.mLastEventType != 3) goto L12;
        int r13 = this.mLastEventPosition;
        int r14 = this.mLastEventCount;
        if (r10 > (r13 + r14)) goto L12;
        int r15 = r10 + r11;
        if (r15 < r13) goto L12;
        if (this.mLastEventPayload != r12) goto L12;
        this.mLastEventPosition = Math.min(r10, r13);
        this.mLastEventCount = Math.max(r14 + r13, r15) - this.mLastEventPosition;
        return;
    L12:
        dispatchLastEvent();
        this.mLastEventPosition = r10;
        this.mLastEventCount = r11;
        this.mLastEventPayload = r12;
        this.mLastEventType = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int r10, int r11) {
        if (this.mLastEventType != 1) goto L10;
        int r12 = this.mLastEventPosition;
        if (r10 < r12) goto L10;
        int r13 = this.mLastEventCount;
        if (r10 > (r12 + r13)) goto L10;
        this.mLastEventCount = r13 + r11;
        this.mLastEventPosition = Math.min(r10, r12);
        return;
    L10:
        dispatchLastEvent();
        this.mLastEventPosition = r10;
        this.mLastEventCount = r11;
        this.mLastEventType = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int r10, int r11) {
        dispatchLastEvent();
        this.mWrapped.onMoved(r10, r11);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int r10, int r11) {
        if (this.mLastEventType != 2) goto L10;
        int r12 = this.mLastEventPosition;
        if (r12 < r10) goto L10;
        if (r12 > (r10 + r11)) goto L10;
        this.mLastEventCount += r11;
        this.mLastEventPosition = r10;
        return;
    L10:
        dispatchLastEvent();
        this.mLastEventPosition = r10;
        this.mLastEventCount = r11;
        this.mLastEventType = 2;
    }
}
