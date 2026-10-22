package com.larus.photopicker.v2.impl.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/larus/photopicker/v2/impl/viewmodel/MediaSelectorViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "curPosition", "", "getCurPosition", "()I", "setCurPosition", "(I)V", "recyclerViewCanScroll", "Landroidx/lifecycle/MutableLiveData;", "getRecyclerViewCanScroll", "()Landroidx/lifecycle/MutableLiveData;", "bottomSelectorHeight", "getBottomSelectorHeight", "injectInputFooterHeight", "getInjectInputFooterHeight", "notifyRecyclerViewCanScroll", "", "canScroll", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaSelectorViewModel extends ViewModel {
    private final MutableLiveData<Integer> bottomSelectorHeight;
    private int curPosition;
    private final MutableLiveData<Integer> injectInputFooterHeight;
    private final MutableLiveData<Integer> recyclerViewCanScroll;

    public MediaSelectorViewModel() {
        this.curPosition = -1;
        this.recyclerViewCanScroll = new MutableLiveData(-1);
        this.bottomSelectorHeight = new MutableLiveData(-1);
        this.injectInputFooterHeight = new MutableLiveData(0);
    }

    public final MutableLiveData<Integer> getBottomSelectorHeight() {
        return this.bottomSelectorHeight;
    }

    public final int getCurPosition() {
        return this.curPosition;
    }

    public final MutableLiveData<Integer> getInjectInputFooterHeight() {
        return this.injectInputFooterHeight;
    }

    public final MutableLiveData<Integer> getRecyclerViewCanScroll() {
        return this.recyclerViewCanScroll;
    }

    public final void notifyRecyclerViewCanScroll(boolean r2) {
        MutableLiveData<Integer> r0 = this.recyclerViewCanScroll;
        if (r2 == false) goto L5;
        int r3 = 1;
    L6:
        r0.setValue(Integer.valueOf(r3));
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void setCurPosition(int r1) {
        this.curPosition = r1;
    }
}
