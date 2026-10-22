package com.ss.android.lark.inline.ai.ui.prompts;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "promptsAdapter", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter;", "onShadowChangeListener", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsRecyclerView$OnShadowChangeListener;", "setData", "", "promptGroups", "", "Lcom/ss/android/lark/inline/ai/api/ui/PromptGroup;", "setOnPromptClickListener", "listener", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$OnPromptClickListener;", "setOnShadowChangeListener", "Companion", "OnShadowChangeListener", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class PromptsRecyclerView extends RecyclerView {
    public final PromptsAdapter a;
    public b b;

    public static final class a {
    }

    public interface b {
        void a(boolean r1);
    }

    static {
    }

    public PromptsRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PromptsRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setData(List<PromptGroup> r9) {
        PromptsAdapter r0 = this.a;
        r0.getClass();
        ArrayList r2 = null;
        if (r9 == null) goto L24;
        ArrayList r3 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L23;
        PromptGroup r4 = (PromptGroup) r10.next();
        String r5 = r4.getTitle();
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L17;
        r3.add(new PromptsAdapter.c(true, r4.getTitle(), null));
    L17:
        ArrayList<Prompt> r7 = r4.getPrompts();
        if (r7 == null) goto L7;
        Iterator<T> r8 = r7.iterator();
    L21:
        if (r8.hasNext() == false) goto L7;
        r3.add(new PromptsAdapter.c(false, null, (Prompt) r8.next()));
        goto L21
    L11:
        if (r5.length() == 0) goto L14;
        r6 = false;
        goto L15
    L23:
        r2 = r3;
    L24:
        DiffUtil.calculateDiff(new PromptsAdapter.DiffCallback(r0.a, r2), false).dispatchUpdatesTo(r0);
        r0.a = r2;
    }

    public final void setOnPromptClickListener(PromptsAdapter.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        PromptsAdapter r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.b = r3;
    }

    public final void setOnShadowChangeListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    public PromptsRecyclerView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        PromptsAdapter r5 = new PromptsAdapter();
        this.a = r5;
        setAdapter(r5);
        setLayoutManager(new LinearLayoutManager(r2, 1, false));
        addItemDecoration(new AnonymousClass1(this, r2));
        setItemAnimator(null);
    }

    public /* synthetic */ PromptsRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
