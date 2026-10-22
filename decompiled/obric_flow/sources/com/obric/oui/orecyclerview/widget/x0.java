package com.obric.oui.orecyclerview.widget;

import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x0 {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS = null;
    static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;

    @NonNull
    public final View itemView;
    a0 mBindingAdapter;
    int mFlags;
    boolean mInChangeScrap;
    private int mIsRecyclableCount;
    long mItemId;
    int mItemViewType;
    WeakReference<RecyclerView> mNestedRecyclerView;
    int mOldPosition;
    RecyclerView mOwnerRecyclerView;
    List<Object> mPayloads;

    @VisibleForTesting
    int mPendingAccessibilityState;
    int mPosition;
    int mPreLayoutPosition;
    q0 mScrapContainer;
    x0 mShadowedHolder;
    x0 mShadowingHolder;
    List<Object> mUnmodifiedPayloads;
    private int mWasImportantForAccessibilityBeforeHidden;

    static {
        FULLUPDATE_PAYLOADS = Collections.emptyList();
    }

    public x0(View r5) {
        this.mPosition = -1;
        this.mOldPosition = -1;
        this.mItemId = -1;
        this.mItemViewType = -1;
        this.mPreLayoutPosition = -1;
        this.mShadowedHolder = null;
        this.mShadowingHolder = null;
        this.mPayloads = null;
        this.mUnmodifiedPayloads = null;
        this.mIsRecyclableCount = 0;
        this.mScrapContainer = null;
        this.mInChangeScrap = false;
        this.mWasImportantForAccessibilityBeforeHidden = 0;
        this.mPendingAccessibilityState = -1;
        if (r5 == null) goto L7;
        this.itemView = r5;
        return;
    L7:
        throw new IllegalArgumentException("itemView may not be null");
    }

    public void addChangePayload(Object r5) {
        if (r5 != null) goto L6;
        addFlags(1024);
        return;
    L6:
        if ((1024 & this.mFlags) == 0) goto L8;
        return;
    L8:
        if (this.mPayloads != null) goto L10;
        ArrayList r10 = new ArrayList();
        this.mPayloads = r10;
        this.mUnmodifiedPayloads = Collections.unmodifiableList(r10);
    L10:
        this.mPayloads.add(r5);
    }

    public void addFlags(int r5) {
        this.mFlags = r5 | this.mFlags;
    }

    public void clearOldPosition() {
        this.mOldPosition = -1;
        this.mPreLayoutPosition = -1;
    }

    public void clearPayload() {
        List<Object> r5 = this.mPayloads;
        if (r5 == null) goto L5;
        r5.clear();
    L5:
        this.mFlags &= -1025;
    }

    public void clearReturnedFromScrapFlag() {
        this.mFlags &= -33;
    }

    public void clearTmpDetachFlag() {
        this.mFlags &= -257;
    }

    public boolean doesTransientStatePreventRecycling() {
        if ((this.mFlags & 16) == 0) goto L5;
    L7:
        return false;
    L5:
        if (ViewCompat.hasTransientState(this.itemView) == false) goto L7;
        return true;
    }

    public void flagRemovedAndOffsetPosition(int r5, int r10, boolean r11) {
        addFlags(8);
        offsetPosition(r10, r11);
        this.mPosition = r5;
    }

    public final int getAbsoluteAdapterPosition() {
        RecyclerView r5 = this.mOwnerRecyclerView;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.B(this);
    }

    @Deprecated
    public final int getAdapterPosition() {
        return getBindingAdapterPosition();
    }

    @Nullable
    public final a0 getBindingAdapter() {
        return this.mBindingAdapter;
    }

    public final int getBindingAdapterPosition() {
        if (this.mBindingAdapter != null) goto L5;
        return -1;
    L5:
        RecyclerView r5 = this.mOwnerRecyclerView;
        if (r5 != null) goto L8;
        return -1;
    L8:
        a0 r10 = r5.getAdapter();
        if (r10 != null) goto L11;
        return -1;
    L11:
        int r11 = this.mOwnerRecyclerView.B(this);
        if (r11 != (-1)) goto L15;
        return -1;
    L15:
        return r10.findRelativeAdapterPositionIn(this.mBindingAdapter, this, r11);
    }

    public final long getItemId() {
        return this.mItemId;
    }

    public final int getItemViewType() {
        return this.mItemViewType;
    }

    public final int getLayoutPosition() {
        int r5 = this.mPreLayoutPosition;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        return this.mPosition;
    }

    public final int getOldPosition() {
        return this.mOldPosition;
    }

    @Deprecated
    public final int getPosition() {
        int r5 = this.mPreLayoutPosition;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        return this.mPosition;
    }

    public List<Object> getUnmodifiedPayloads() {
        if ((this.mFlags & 1024) != 0) goto L14;
        List<Object> r5 = this.mPayloads;
        if (r5 == null) goto L12;
        if (r5.size() == 0) goto L12;
        return this.mUnmodifiedPayloads;
    L12:
        return FULLUPDATE_PAYLOADS;
    L14:
        return FULLUPDATE_PAYLOADS;
    }

    public boolean hasAnyOfTheFlags(int r5) {
        if ((this.mFlags & r5) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAdapterPositionUnknown() {
        if ((this.mFlags & 512) == 0) goto L5;
    L8:
        return true;
    L5:
        if (isInvalid() == true) goto L8;
        return false;
    }

    public boolean isAttachedToTransitionOverlay() {
        if (this.itemView.getParent() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.itemView.getParent() == this.mOwnerRecyclerView) goto L7;
        return true;
    }

    public boolean isBound() {
        if ((this.mFlags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isInvalid() {
        if ((this.mFlags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRecyclable() {
        if ((this.mFlags & 16) == 0) goto L5;
    L7:
        return false;
    L5:
        if (ViewCompat.hasTransientState(this.itemView) == true) goto L7;
        return true;
    }

    public boolean isRemoved() {
        if ((this.mFlags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isScrap() {
        if (this.mScrapContainer == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTmpDetached() {
        if ((this.mFlags & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUpdated() {
        if ((this.mFlags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean needsUpdate() {
        if ((this.mFlags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void offsetPosition(int r5, boolean r10) {
        if (this.mOldPosition != (-1)) goto L6;
        this.mOldPosition = this.mPosition;
    L6:
        if (this.mPreLayoutPosition != (-1)) goto L8;
        this.mPreLayoutPosition = this.mPosition;
    L8:
        if (r10 == false) goto L10;
        this.mPreLayoutPosition += r5;
    L10:
        this.mPosition += r5;
        if (this.itemView.getLayoutParams() == null) goto L14;
        ((RecyclerView.LayoutParams) this.itemView.getLayoutParams()).f13770c = true;
        return;
    }

    public void onEnteredHiddenState(RecyclerView r5) {
        int r10 = this.mPendingAccessibilityState;
        if (r10 == (-1)) goto L5;
        this.mWasImportantForAccessibilityBeforeHidden = r10;
    L7:
        if (r5.H() == false) goto L9;
        this.mPendingAccessibilityState = 4;
        r5.f13748o0.add(this);
        return;
    L9:
        ViewCompat.setImportantForAccessibility(this.itemView, 4);
        return;
    L5:
        this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
        goto L7
    }

    public void onLeftHiddenState(RecyclerView r5) {
        int r10 = this.mWasImportantForAccessibilityBeforeHidden;
        if (r5.H() == false) goto L5;
        this.mPendingAccessibilityState = r10;
        r5.f13748o0.add(this);
    L6:
        this.mWasImportantForAccessibilityBeforeHidden = 0;
        return;
    L5:
        ViewCompat.setImportantForAccessibility(this.itemView, r10);
        goto L6
    }

    public void resetInternal() {
        if (RecyclerView.f13723x0 == true) goto L5;
    L9:
        this.mFlags = 0;
        this.mPosition = -1;
        this.mOldPosition = -1;
        this.mItemId = -1;
        this.mPreLayoutPosition = -1;
        this.mIsRecyclableCount = 0;
        this.mShadowedHolder = null;
        this.mShadowingHolder = null;
        clearPayload();
        this.mWasImportantForAccessibilityBeforeHidden = 0;
        this.mPendingAccessibilityState = -1;
        RecyclerView.k(this);
        return;
    L5:
        if (isTmpDetached() == false) goto L9;
        throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
    }

    public void saveOldPosition() {
        if (this.mOldPosition != (-1)) goto L6;
        this.mOldPosition = this.mPosition;
        return;
    }

    public void setFlags(int r5, int r10) {
        int r11 = r5 & r10;
        this.mFlags = r11 | (this.mFlags & (~r10));
    }

    public final void setIsRecyclable(boolean r5) {
        int r10 = this.mIsRecyclableCount;
        if (r5 == false) goto L5;
        int r11 = r10 - 1;
    L6:
        this.mIsRecyclableCount = r11;
        if (r11 >= 0) goto L13;
        this.mIsRecyclableCount = 0;
        if (RecyclerView.f13723x0 == true) goto L12;
        Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
    L20:
        if (RecyclerView.f13724y0 == false) goto L23;
        Log.d("RecyclerView", "setIsRecyclable val:" + r5 + ":" + this);
        return;
    L23:
        return;
    L12:
        throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
    L13:
        if (r5 == true) goto L16;
        if (r11 != 1) goto L16;
        this.mFlags |= 16;
    L16:
        if (r5 == false) goto L20;
        if (r11 != 0) goto L20;
        this.mFlags &= -17;
        goto L20
    L5:
        r11 = r10 + 1;
        goto L6
    }

    public void setScrapContainer(q0 r5, boolean r10) {
        this.mScrapContainer = r5;
        this.mInChangeScrap = r10;
    }

    public boolean shouldBeKeptAsChild() {
        if ((this.mFlags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean shouldIgnore() {
        if ((this.mFlags & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void stopIgnoring() {
        this.mFlags &= -129;
    }

    public String toString() {
        if (getClass().isAnonymousClass() == false) goto L5;
        String r5 = "ViewHolder";
    L6:
        StringBuilder r10 = ai.j0.w(r5, "{");
        r10.append(Integer.toHexString(hashCode()));
        r10.append(" position=");
        r10.append(this.mPosition);
        r10.append(" id=");
        r10.append(this.mItemId);
        r10.append(", oldPos=");
        r10.append(this.mOldPosition);
        r10.append(", pLpos:");
        r10.append(this.mPreLayoutPosition);
        StringBuilder r11 = new StringBuilder(r10.toString());
        if (isScrap() == false) goto L14;
        r11.append(" scrap ");
        if (this.mInChangeScrap == false) goto L11;
        String r12 = "[changeScrap]";
    L12:
        r11.append(r12);
        goto L14
    L11:
        r12 = "[attachedScrap]";
    L14:
        if (isInvalid() == false) goto L17;
        r11.append(" invalid");
    L17:
        if (isBound() == true) goto L20;
        r11.append(" unbound");
    L20:
        if (needsUpdate() == false) goto L23;
        r11.append(" update");
    L23:
        if (isRemoved() == false) goto L26;
        r11.append(" removed");
    L26:
        if (shouldIgnore() == false) goto L29;
        r11.append(" ignored");
    L29:
        if (isTmpDetached() == false) goto L32;
        r11.append(" tmpDetached");
    L32:
        if (isRecyclable() == true) goto L35;
        r11.append(" not recyclable(" + this.mIsRecyclableCount + ")");
    L35:
        if (isAdapterPositionUnknown() == false) goto L38;
        r11.append(" undefined adapter position");
    L38:
        if (this.itemView.getParent() != null) goto L40;
        r11.append(" no parent");
    L40:
        r11.append("}");
        return r11.toString();
    L5:
        r5 = getClass().getSimpleName();
        goto L6
    }

    public void unScrap() {
        this.mScrapContainer.k(this);
    }

    public boolean wasReturnedFromScrap() {
        if ((this.mFlags & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
