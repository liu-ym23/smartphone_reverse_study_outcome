package com.larus.bmhome.chat.markdown.reference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mainbot.impl.databinding.LarusReferenceListZoomInViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/ReferenceListZoomInView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusReferenceListZoomInViewBinding;", "setReferenceListRecyclerViewAdapter", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getSearchReferenceList", "Landroidx/recyclerview/widget/RecyclerView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ReferenceListZoomInView extends FrameLayout {
    public final LarusReferenceListZoomInViewBinding a;

    public ReferenceListZoomInView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ReferenceListZoomInView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final RecyclerView getSearchReferenceList() {
        return this.a.c;
    }

    public final void setReferenceListRecyclerViewAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r2) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        this.a.c.setAdapter(r2);
    }

    public ReferenceListZoomInView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ConstraintLayout r6 = LayoutInflater.from(r3).inflate(2131563100, this, false);
        addView(r6);
        int r7 = 2131379669;
        View r0 = ViewBindings.findChildViewById(r6, 2131379669);
        if (r0 == null) goto L9;
        r7 = 2131385561;
        RecyclerView r1 = ViewBindings.findChildViewById(r6, 2131385561);
        if (r1 == null) goto L9;
        this.a = new LarusReferenceListZoomInViewBinding(r6, r0, r1);
        r1.setLayoutManager(new LinearLayoutManager(r3));
        r1.addItemDecoration(new AnonymousClass1(this));
        r1.addOnLayoutChangeListener(new q(this));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public /* synthetic */ ReferenceListZoomInView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
