package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
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

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback r5) {
        this.mLastEventType = 0;
        this.mLastEventPosition = -1;
        this.mLastEventCount = -1;
        this.mLastEventPayload = null;
        this.mWrapped = r5;
    }

    public void dispatchLastEvent() {
        int r5 = this.mLastEventType;
        if (r5 != 0) goto L6;
        return;
    L6:
        if (r5 != 1) goto L8;
        this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
    L15:
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
        return;
    L8:
        if (r5 != 2) goto L10;
        this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        goto L15
    L10:
        if (r5 != 3) goto L15;
        this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        goto L15
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int r10, int r11, Object r12) {
        if (this.mLastEventType != 3) goto L12;
        int r5 = this.mLastEventPosition;
        int r13 = this.mLastEventCount;
        if (r10 > (r5 + r13)) goto L12;
        int r14 = r10 + r11;
        if (r14 < r5) goto L12;
        if (this.mLastEventPayload != r12) goto L12;
        this.mLastEventPosition = Math.min(r10, r5);
        this.mLastEventCount = Math.max(r13 + r5, r14) - this.mLastEventPosition;
        return;
    L12:
        dispatchLastEvent();
        this.mLastEventPosition = r10;
        this.mLastEventCount = r11;
        this.mLastEventPayload = r12;
        this.mLastEventType = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int r5, int r10) {
        if (this.mLastEventType != 1) goto L10;
        int r11 = this.mLastEventPosition;
        if (r5 < r11) goto L10;
        int r12 = this.mLastEventCount;
        if (r5 > (r11 + r12)) goto L10;
        this.mLastEventCount = r12 + r10;
        this.mLastEventPosition = Math.min(r5, r11);
        return;
    L10:
        dispatchLastEvent();
        this.mLastEventPosition = r5;
        this.mLastEventCount = r10;
        this.mLastEventType = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int r5, int r10) {
        dispatchLastEvent();
        this.mWrapped.onMoved(r5, r10);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int r5, int r10) {
        if (this.mLastEventType != 2) goto L10;
        int r11 = this.mLastEventPosition;
        if (r11 < r5) goto L10;
        if (r11 > (r5 + r10)) goto L10;
        this.mLastEventCount += r10;
        this.mLastEventPosition = r5;
        return;
    L10:
        dispatchLastEvent();
        this.mLastEventPosition = r5;
        this.mLastEventCount = r10;
        this.mLastEventType = 2;
    }
}
