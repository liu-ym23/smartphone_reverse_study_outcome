package com.larus.bmhome.chat.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import c29.a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.RoundFrameLayoutWithLastMotion;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/search/view/SearchUnavailableView;", "Lcom/larus/bmhome/chat/layout/widget/RoundFrameLayoutWithLastMotion;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textView", "Landroid/widget/TextView;", "setText", "", ChatDraftItem.TYPE_TEXT, "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchUnavailableView extends RoundFrameLayoutWithLastMotion {
    public final TextView c;

    public SearchUnavailableView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SearchUnavailableView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
        this.c.setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchUnavailableView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        TextView r8 = new TextView(r5);
        this.c = r8;
        Intrinsics.checkNotNullParameter(r5, "context");
        r8.setTextColor(ContextCompat.getColor(r5, 2131103681));
        r8.setTextSize(0, i5.k());
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
        r9.gravity = 17;
        addView(r8, r9);
        getDelegate().a(c.b(2130970532, r8.getContext(), 2131102539));
        getDelegate().b(c.b(2130972087, r8.getContext(), 2131103162));
        getDelegate().d(12);
        a r10 = getDelegate();
        Intrinsics.checkNotNullParameter(r5, "context");
        r10.g(ContextCompat.getColor(r5, 2131105532));
        a r11 = getDelegate();
        Resources r12 = r11.b.getResources();
        r11.m = (int) ((1 * WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).density) + 0.5f);
        r11.c();
    }

    public /* synthetic */ SearchUnavailableView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
