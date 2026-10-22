package com.larus.uaigc.chat.block.createloading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.larus.uaigc.chat.markdown.placeholder.ShimmerTextPlaceHolderView;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationTextPlaceholderBinding;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\r2\b\b\u0001\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/chat/block/createloading/CreationLoadingBlockView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetMarkdownCreationTextPlaceholderBinding;", "updateView", "", "loadingText", "", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "updatePaddingTop", "padding", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationLoadingBlockView extends FrameLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusWidgetMarkdownCreationTextPlaceholderBinding a;

    public CreationLoadingBlockView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CreationLoadingBlockView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a(int r8) {
        ShimmerTextPlaceHolderView r0 = this.a.b;
        int r1 = r0.getPaddingStart();
        int r2 = r0.getPaddingEnd();
        int r3 = r0.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r0.getClass().getSimpleName() + ",source:,start:" + r1 + ",top:" + r8 + ",end:" + r2 + ",bottom:" + r3);
        r0.setPaddingRelative(r1, r8, r2, r3);
    }

    public CreationLoadingBlockView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LarusWidgetMarkdownCreationTextPlaceholderBinding r5 = LarusWidgetMarkdownCreationTextPlaceholderBinding.a(LayoutInflater.from(r2), null, false);
        this.a = r5;
        addView(r5.a);
    }

    public /* synthetic */ CreationLoadingBlockView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
