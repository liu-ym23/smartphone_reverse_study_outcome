package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H$J\b\u0010\b\u001a\u00020\u0007H$J\b\u0010\t\u001a\u00020\u0007H$J\b\u0010\n\u001a\u00020\u0007H$J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleOnLoadMoreListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "()V", "lastIndex", "", "onLoadingUp", "", "onLoadingDown", "onScrollIdle", "onScrolled", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "dx", "dy", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class MmSubtitleOnLoadMoreListener extends RecyclerView.OnScrollListener {
    public int a;

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public MmSubtitleOnLoadMoreListener() {
    }

    public final void onScrollStateChanged(RecyclerView r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        LinearLayoutManager r6 = r4.getLayoutManager();
        if ((r6 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r7 = r6;
    L6:
        if (r7 != null) goto L8;
        return;
    L8:
        int r0 = r7.findFirstVisibleItemPosition();
        int r1 = r7.findLastVisibleItemPosition();
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L12;
    L14:
        if (r1 < this.a) goto L18;
        this.a = r1;
        if ((r7.getItemCount() - 1) != r1) goto L18;
        j();
    L18:
        if (r5 != 0) goto L21;
        l();
        return;
    L21:
        return;
    L12:
        k();
        goto L14
    L5:
        r7 = null;
        goto L6
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        LinearLayoutManager r5 = r2.getLayoutManager();
        if ((r5 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r6 = r5;
    L6:
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.findLastVisibleItemPosition() >= 0) goto L11;
        return;
    L11:
        if (r6.getChildCount() == 0) goto L16;
        m();
        return;
    L16:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
