package com.larus.bmhome.chat.standarduikit.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0002*+B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u001e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007J(\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J.\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/search/view/PureVideoItemView;", "Lcom/larus/common_ui/widget/roundlayout/RoundFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textDesc", "Landroid/widget/TextView;", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageIcon", "adaptiveItemWidth", "overSeaSourceIcon", "Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "updateAdaptiveWidth", "", "itemWidth", "bindData", "data", "Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardViewData;", "callback", "Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardViewCallback;", "position", "updateCover", "output", "cardSize", "Lcom/larus/bmhome/chat/standarduikit/search/view/PureVideoItemView$CardSizeSpec;", "updateIcon", "isOversea", "", "iconUrl", "", "hostPageUrl", "messageId", "getAdaptiveCardSize", "mode", "Lcom/larus/bmhome/chat/search/factory/ExpandCardViewMode;", "updateLayoutParams", "Companion", "CardSizeSpec", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PureVideoItemView extends RoundFrameLayout {
    public static final /* synthetic */ int g = 0;
    public final TextView b;
    public final SimpleDraweeView c;
    public final SimpleDraweeView d;
    public int e;
    public final MarkdownSourceImageView f;

    public static final class a {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "CardSizeSpec(width=" + this.a + ", height=" + this.b + ')';
        }

        public a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ExpandCardViewMode.values().length];
                r0[ExpandCardViewMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[ExpandCardViewMode.EXPAND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[ExpandCardViewMode.EXPAND_PIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[ExpandCardViewMode.NORMAL_PIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[ExpandCardViewMode.NORMAL_SHARE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[ExpandCardViewMode.EXPAND_SHARE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }

        public static a a(ExpandCardViewMode r2) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            switch(a.a[r2.ordinal()]) {
                case 1: goto L8;
                case 2: goto L8;
                case 3: goto L8;
                case 4: goto L8;
                case 5: goto L9;
                case 6: goto L9;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L9:
            return new a(i5.r(), i5.F());
        L8:
            return new a(i5.s(), i5.G());
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PureVideoItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = FrameLayout.inflate(r2, 2131561845, this);
        this.b = (TextView) r5.findViewById(2131388420);
        this.c = r5.findViewById(2131374973);
        this.d = r5.findViewById(2131374977);
        this.f = r5.findViewById(2131387008);
        a r6 = b.a(ExpandCardViewMode.NORMAL);
        setLayoutParams(new FrameLayout.LayoutParams(r6.a, r6.b));
    }
}
