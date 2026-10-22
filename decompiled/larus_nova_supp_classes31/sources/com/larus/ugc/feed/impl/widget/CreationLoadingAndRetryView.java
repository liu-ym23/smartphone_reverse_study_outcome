package com.larus.ugc.feed.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.larus.ugc.feed.impl.databinding.LarusCommunityCreationLoadingAndRetryLayoutKmpBinding;
import com.larus.ugc.feed.impl.loading.CreationTemplateLoadingAdapter;
import com.larus.utils.e1;
import com.larus.utils.i;
import com.tencent.open.log.TraceLevel;
import e1a.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\f2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0018\u0010\u0016\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u000bJ\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/ugc/feed/impl/widget/CreationLoadingAndRetryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/ugc/feed/impl/databinding/LarusCommunityCreationLoadingAndRetryLayoutKmpBinding;", "onRetryClickListener", "Lkotlin/Function0;", "", "emptyViewCreator", "Landroid/view/View;", "emptyView", "setOnRetryClickListener", "bindItemDecoration", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "trySetEmptyView", "view", "setEmptyCreator", "updateStatus", "state", "Lcom/larus/ugc/feed/api/state/PageState;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationLoadingAndRetryView extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public final LarusCommunityCreationLoadingAndRetryLayoutKmpBinding a;
    public Function0<Unit> b;
    public Function0<? extends View> c;
    public View d;

    public CreationLoadingAndRetryView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setEmptyCreator(Function0<? extends View> r1) {
        this.c = r1;
    }

    public final void setOnRetryClickListener(Function0<Unit> r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationLoadingAndRetryView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        LayoutInflater.from(r4).inflate(2131561961, this);
        int r6 = 2131379091;
        UnresponsiveRecyclerView r0 = (UnresponsiveRecyclerView) ViewBindings.findChildViewById(this, 2131379091);
        if (r0 == null) goto L15;
        r6 = 2131384145;
        if (((TextView) ViewBindings.findChildViewById(this, 2131384145)) == null) goto L15;
        r6 = 2131384472;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(this, 2131384472);
        if (r1 == null) goto L15;
        this.a = new LarusCommunityCreationLoadingAndRetryLayoutKmpBinding(this, r0, r1);
        if (c7.d(Integer.valueOf(i.d(r4))) <= 500.0f) goto L11;
        int r7 = 3;
    L12:
        r0.setLayoutManager(new StaggeredGridLayoutManager(r7, 1));
        r0.setAdapter(new CreationTemplateLoadingAdapter());
        e1.d(r1, new a(this));
        return;
    L11:
        r7 = 2;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r6)));
    }
}
