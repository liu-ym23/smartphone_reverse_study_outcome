package k62;

import ak6.g;
import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelGiftViewHolder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wb2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements qb2.e {
    public final /* synthetic */ ChatChannelGiftViewHolder a;
    public final /* synthetic */ TextView b;

    @Override // qb2.e
    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    @Override // qb2.e
    public final void b(g r7) {
        Intrinsics.checkNotNullParameter(r7, "rendResult");
        TextView r0 = this.b;
        SpannableString r8 = r7.a;
        int r3 = 0;
        Object[] r1 = r8.getSpans(0, r8.length(), h.class);
        int r2 = r1.length;
    L3:
        if (r3 >= r2) goto L5;
        h r4 = (h) r1[r3];
        r4.a = this.a.d;
        r3 = r3 + 1;
        goto L3
    L5:
        Unit r5 = Unit.INSTANCE;
        r0.setText(r8);
    }

    public d(ChatChannelGiftViewHolder r1, TextView r2) {
        this.a = r1;
        this.b = r2;
    }
}
