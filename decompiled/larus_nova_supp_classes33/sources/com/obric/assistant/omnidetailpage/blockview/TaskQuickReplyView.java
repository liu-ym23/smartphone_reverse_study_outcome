package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.obric.assistant.card.databinding.ObricOmniBlockQuickReplyBinding;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\\\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00142\u001a\b\u0002\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u00172\u001a\b\u0002\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u0017J\u0006\u0010\u0019\u001a\u00020\u0010J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u001fH\u0002JB\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00072\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u0017H\u0002J \u0010&\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0010H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/TaskQuickReplyView;", "Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockQuickReplyBinding;", "verticalSpacingPx", "exposureObserveStages", "", "bind", "", "item", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$QuickReply;", "onItemClick", "Lkotlin/Function1;", "", "onQuickReplyClick", "Lkotlin/Function2;", "onQuickReplyShow", "onRecycled", "updateContentHorizontalPadding", "useCompactIndent", "", "bindItemView", "Lcom/obric/assistant/card/databinding/ObricOmniBlockQuickReplyItemBinding;", "Lcom/larus/im/bean/message/block/QuickReplyItem;", "resolveItemWidth", "registerItemExpose", "itemView", "Landroid/view/View;", "quickReplyItem", "sourceIndex", "buildExposeCellId", "releaseItemExposures", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskQuickReplyView extends OmniDetailVerticalLineFrameLayout {
    public static final /* synthetic */ int f = 0;
    public final ObricOmniBlockQuickReplyBinding c;
    public final int d;
    public final List<Integer> e;

    public static final class a {
    }

    static {
    }

    public TaskQuickReplyView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TaskQuickReplyView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public TaskQuickReplyView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(2131564041, this, false);
        addView(r5);
        LinearLayout r0 = (LinearLayout) ViewBindings.findChildViewById(r5, 2131383541);
        if (r0 == null) goto L7;
        this.c = new ObricOmniBlockQuickReplyBinding((LinearLayout) r5, r0);
        this.d = getResources().getDimensionPixelSize(2131165877);
        this.e = CollectionsKt.listOf(new Integer[]{0, 1, 2});
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131383541)));
    }

    public /* synthetic */ TaskQuickReplyView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
