package com.ss.android.lark.inline.ai.creationai.label;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/label/LabelRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "labelAdapter", "Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter;", "setData", "", "data", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "setOnOperateClickListener", "listener", "Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter$OnOperateClickListener;", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LabelRecyclerView extends RecyclerView {
    public final LabelAdapter a;

    public static final class a {
    }

    static {
    }

    public LabelRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LabelRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setData(List<MenuItem> r4) {
        LabelAdapter r0 = this.a;
        r0.getClass();
        DiffUtil.calculateDiff(new LabelAdapter.DiffCallback(r0.a, r4), false).dispatchUpdatesTo(r0);
        r0.a = r4;
    }

    public final void setOnOperateClickListener(LabelAdapter.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        LabelAdapter r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.b = r3;
    }

    public LabelRecyclerView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LabelAdapter r5 = new LabelAdapter();
        this.a = r5;
        setNestedScrollingEnabled(false);
        setAdapter(r5);
        setLayoutManager(new AnonymousClass1(r2));
        addItemDecoration(new AnonymousClass2());
        setItemAnimator(null);
    }

    public /* synthetic */ LabelRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
