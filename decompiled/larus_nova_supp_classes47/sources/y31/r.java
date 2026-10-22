package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKTitleSelectViewHolder;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r extends me.drakeet.multitype.b<s.a, PKTitleSelectViewHolder> {
    public r() {
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        PKTitleSelectViewHolder r6 = (PKTitleSelectViewHolder) r4;
        s.a r7 = (s.a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "item");
        CharSequence r0 = r7.a;
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
    L7:
        r6.b = r1;
        ((TextView) r6.a.findViewById(2131388772)).setVisibility(0);
        ((TextView) r6.a.findViewById(2131388772)).setText(r7.a);
        ((TextView) r6.a.findViewById(2131388772)).setTextColor(ColorProtector.parseColor("#c0161823"));
        return;
    L6:
        r1 = "";
        goto L7
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new PKTitleSelectViewHolder(r4.inflate(2131566386, r5, false));
    }
}
