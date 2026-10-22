package y31;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKTitleViewHolder;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s extends me.drakeet.multitype.b<a, PKTitleViewHolder> {
    public final boolean b;

    public static final class a {
        public CharSequence a;
        public boolean b;
        public boolean c;
        public boolean d;
        public int e;
        public String f;

        public a() {
            this.f = "";
        }
    }

    public s(boolean r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r5, Object r6) {
        PKTitleViewHolder r7 = (PKTitleViewHolder) r5;
        a r8 = (a) r6;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "item");
        r7.d = r8;
        CharSequence r0 = r8.a;
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
    L7:
        r7.b = r1;
        boolean r2 = r8.c;
        r7.c = r2;
        View r3 = r7.a;
        if (r2 == false) goto L10;
        int r4 = 75;
    L11:
        a1.k(r3, UtilityKotlinExtentionsKt.i(r4));
        int r9 = 0;
        ((TextView) r7.a.findViewById(2131388772)).setVisibility(0);
        ((TextView) r7.a.findViewById(2131388772)).setText(r8.a);
        ((TextView) r7.a.findViewById(2131388772)).setTextColor(ColorProtector.parseColor("#c0161823"));
        View r10 = r7.a.findViewById(2131369197);
        if (r8.b == true) goto L15;
        r9 = 8;
    L15:
        r10.setVisibility(r9);
        if (r7.e == true) goto L18;
        return;
    L18:
        if (r8.c == true) goto L22;
        a1.k(r7.a, UtilityKotlinExtentionsKt.i(32));
        ((TextView) r7.a.findViewById(2131388772)).setPadding(((TextView) r7.a.findViewById(2131388772)).getPaddingLeft(), ((TextView) r7.a.findViewById(2131388772)).getPaddingTop(), ((TextView) r7.a.findViewById(2131388772)).getPaddingRight(), UtilityKotlinExtentionsKt.i(4));
        return;
    L22:
        return;
    L10:
        r4 = 34;
    L6:
        r1 = "";
        goto L7
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new PKTitleViewHolder(r4.inflate(2131566288, r5, false), this.b);
    }
}
