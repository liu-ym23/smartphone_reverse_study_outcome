package com.larus.community.impl.share;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.larus.community.impl.databinding.LarusCommunitySegmentedControlItemViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010\u0011\u001a\u00020\u000f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/community/impl/share/CreationShareSegmentedControlView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "singleImageControlView", "Lcom/larus/community/impl/share/CreationShareSegmentedControlItemView;", "puzzleImageControlView", "onSelectionChanged", "Lkotlin/Function1;", "", "setupViews", "setOnSelectionChangedListener", "listener", "setSelectedPosition", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationShareSegmentedControlView extends LinearLayout {
    public final CreationShareSegmentedControlItemView a;
    public final CreationShareSegmentedControlItemView b;
    public Function1<? super Integer, Unit> c;

    public CreationShareSegmentedControlView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CreationShareSegmentedControlView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setOnSelectionChangedListener(Function1<? super Integer, Unit> r1) {
        this.c = r1;
    }

    public final void setSelectedPosition(int r3) {
        Function1<? super Integer, Unit> r0 = this.c;
        if (r0 == null) goto L6;
        r0.invoke(Integer.valueOf(r3));
    L6:
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L13;
        this.a.setSelected(false);
        this.b.setSelected(true);
        return;
    L13:
        return;
    L10:
        this.a.setSelected(true);
        this.b.setSelected(false);
    }

    public CreationShareSegmentedControlView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        LayoutInflater.from(r4).inflate(2131563119, this, true);
        CreationShareSegmentedControlItemView r7 = (CreationShareSegmentedControlItemView) findViewById(2131386657);
        this.a = r7;
        CreationShareSegmentedControlItemView r8 = (CreationShareSegmentedControlItemView) findViewById(2131383474);
        this.b = r8;
        LarusCommunitySegmentedControlItemViewBinding r0 = r7.b;
        if (r0 == null) goto L5;
        r0.b.setImageResource(2131240168);
        r0.c.setText(2131909338);
    L5:
        LarusCommunitySegmentedControlItemViewBinding r1 = r8.b;
        if (r1 == null) goto L8;
        r1.b.setImageResource(2131240165);
        r1.c.setText(2131909337);
    L8:
        setPadding(0, i5.h(), 0, i5.h());
        r7.setSelected(true);
        r8.setSelected(false);
        r7.setOnClickListener(new k(this));
        r8.setOnClickListener(new l(this));
    }

    public /* synthetic */ CreationShareSegmentedControlView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
