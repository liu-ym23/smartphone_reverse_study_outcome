package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/trade/AnchorShelfDisplayTradeLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorShelfDisplayTradeLayout extends LinearLayout {

    public interface a {
        int a();

        int b();

        int c();
    }

    public static final class b {
        public final TextView a;
        public final TextView b;
        public final View c;

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            this.c = r2;
            this.a = (TextView) r2.findViewById(2131389314);
            this.b = (TextView) r2.findViewById(2131389313);
        }
    }

    public AnchorShelfDisplayTradeLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorShelfDisplayTradeLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(d r19, final a r20) {
        a r8 = r20;
        Intrinsics.checkNotNullParameter(r19, "unitList");
        Intrinsics.checkNotNullParameter(r8, "config");
        if (r19.b.isEmpty() == false) goto L5;
        return;
    L5:
        removeAllViews();
        Iterator<T> r10 = r19.b.iterator();
    L7:
        if (r10.hasNext() == false) goto L16;
        final c r11 = (c) r10.next();
        r19.getType();
        View r12 = LayoutInflater.from(getContext()).inflate(2131566952, this, false);
        final b r13 = new b(r12);
        Intrinsics.checkNotNullParameter(r11, "unit");
        Intrinsics.checkNotNullParameter(r8, "config");
        TextView r14 = r13.a;
        double r2 = CastDoubleProtector.parseDouble(r11.b);     // Catch: Throwable -> L11
    L12:
        final long r5 = (long) Math.floor(r2);
        com.bytedance.android.live.openplatform.impl.base.utils.text.c r15 = new com.bytedance.android.live.openplatform.impl.base.utils.text.c(new SpannableStringBuilder());
        r15.d(r20.a(), new AnchorShelfDisplayTradeLayout$TradeUnitViewHolder$buildText$$inlined$buildSpannedString$lambda$1(r13, r20, r5, r11));
        if (r5 < 10000) goto L15;
        com.bytedance.android.live.openplatform.impl.base.utils.text.b.a.a(r15, UtilityKotlinExtentionsKt.i(2));
        r15.d(r20.c(), new AnchorShelfDisplayTradeLayout$TradeUnitViewHolder$buildText$$inlined$buildSpannedString$lambda$2(r13, r20, r5, r11));
    L15:
        r14.setText(new SpannedString(r15.a));
        r13.b.setText(r11.a);
        r13.b.setTextSize(r20.b());
        addView(r12);
        r8 = r20;
    L11:
        r2 = 0.0d;
        goto L12
    }

    public AnchorShelfDisplayTradeLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ AnchorShelfDisplayTradeLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
