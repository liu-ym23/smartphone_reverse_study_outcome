package com.larus.bmhome.chat.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import c29.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.RoundFrameLayoutWithLastMotion;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ti8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007J#\u0010\u0019\u001a\u00020\u0013*\u00020\u000b2\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001dJ\u0014\u0010\u001e\u001a\u00020\u0013*\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/search/view/SearchImageCardView;", "Lcom/larus/bmhome/chat/layout/widget/RoundFrameLayoutWithLastMotion;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageMetrics", "Lcom/larus/common_ui/widget/roundlayout/RoundTextView;", "imageMask", "Lcom/larus/common_ui/widget/roundlayout/RoundFrameLayout;", "sourceIcon", "Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "setImageData", "", "viewData", "Lcom/larus/bmhome/chat/search/view/SearchImageCardViewData;", "extra", "", "", "updateRoundingParams", "block", "Lkotlin/Function1;", "Lcom/facebook/drawee/generic/RoundingParams;", "Lkotlin/ExtensionFunctionType;", "setRounding", "Lcom/larus/common_ui/widget/roundlayout/RoundViewDelegate;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchImageCardView extends RoundFrameLayoutWithLastMotion {
    public static final /* synthetic */ int f = 0;
    public final SimpleDraweeView c;
    public final RoundTextView d;
    public final RoundFrameLayout e;

    public SearchImageCardView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SearchImageCardView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static void a(a r2, b r3) {
        int r1 = 0;
        if (r3.g == false) goto L5;
        int r0 = r3.f;
    L6:
        r2.i = r0;
        r2.c();
        if (r3.h == false) goto L9;
        int r4 = r3.f;
    L10:
        r2.j = r4;
        r2.c();
        if (r3.i == false) goto L13;
        int r5 = r3.f;
    L14:
        r2.k = r5;
        r2.c();
        if (r3.j == false) goto L17;
        r1 = r3.f;
    L17:
        r2.l = r1;
        r2.c();
        return;
    L13:
        r5 = 0;
        goto L14
    L9:
        r4 = 0;
        goto L10
    L5:
        r0 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchImageCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = FrameLayout.inflate(r2, 2131563115, this);
        this.c = r5.findViewById(2131374973);
        this.d = r5.findViewById(2131375022);
        this.e = r5.findViewById(2131375021);
        MarkdownSourceImageView r6 = (MarkdownSourceImageView) r5.findViewById(2131387008);
    }

    public /* synthetic */ SearchImageCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
