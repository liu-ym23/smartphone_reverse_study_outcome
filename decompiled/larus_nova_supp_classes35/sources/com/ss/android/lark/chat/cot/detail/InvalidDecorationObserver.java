package com.ss.android.lark.chat.cot.detail;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/InvalidDecorationObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onChanged", BuildConfig.FLAVOR, "onItemRangeChanged", "positionStart", BuildConfig.FLAVOR, "itemCount", "payload", BuildConfig.FLAVOR, "onItemRangeInserted", "onItemRangeRemoved", "onItemRangeMoved", "fromPosition", "toPosition", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InvalidDecorationObserver extends RecyclerView.AdapterDataObserver {
    public final RecyclerView a;

    public final void onChanged() {
        this.a.invalidateItemDecorations();
    }

    public InvalidDecorationObserver(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.a = r2;
    }

    public final void onItemRangeChanged(int r1, int r2) {
        this.a.invalidateItemDecorations();
    }

    public final void onItemRangeInserted(int r1, int r2) {
        this.a.invalidateItemDecorations();
    }

    public final void onItemRangeRemoved(int r1, int r2) {
        this.a.invalidateItemDecorations();
    }

    public final void onItemRangeChanged(int r1, int r2, Object r3) {
        this.a.invalidateItemDecorations();
    }

    public final void onItemRangeMoved(int r1, int r2, int r3) {
        this.a.invalidateItemDecorations();
    }
}
