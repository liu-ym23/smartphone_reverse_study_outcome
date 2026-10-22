package com.ss.android.lark.inline.ai.asr.subprompt;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import slb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "subPromptAdapter", "Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptAdapter;", "setData", "", "data", "", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "setOnOperateClickListener", "listener", "Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptAdapter$OnOperateClickListener;", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SubPromptRecyclerView extends RecyclerView {
    public final SubPromptAdapter a;

    public static final class a {
    }

    static {
    }

    public SubPromptRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SubPromptRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setData(List<j> r6) {
        SubPromptAdapter r0 = this.a;
        r0.getClass();
        DiffUtil.calculateDiff(new SubPromptAdapter.DiffCallback(r0.a, r6, r0.c, r0.b), false).dispatchUpdatesTo(r0);
        r0.a = r6;
    }

    public final void setOnOperateClickListener(SubPromptAdapter.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        SubPromptAdapter r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.d = r3;
    }

    public SubPromptRecyclerView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        SubPromptAdapter r5 = new SubPromptAdapter();
        this.a = r5;
        setAdapter(r5);
        setLayoutManager(new LinearLayoutManager(r2, 0, false));
        addItemDecoration(new AnonymousClass1(r2));
        setItemAnimator(null);
    }

    public /* synthetic */ SubPromptRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
