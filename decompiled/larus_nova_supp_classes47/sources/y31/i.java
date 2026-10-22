package y31;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKExpandCollapseViewHolder;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends me.drakeet.multitype.b<a, PKExpandCollapseViewHolder> {
    public final PKExpandCollapseViewHolder.a b;

    public static final class a {
        public String a;
        public boolean b;

        public a() {
            this.a = "";
        }
    }

    public i(PKExpandCollapseViewHolder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        PKExpandCollapseViewHolder r5 = (PKExpandCollapseViewHolder) r3;
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.getClass();
        boolean r0 = r6.b;
        String r7 = r6.a;
        if (r0 == false) goto L9;
        TextView r1 = r5.a;
        if (TextUtils.isEmpty(r7) == false) goto L8;
        r7 = s1.B(2131920052);
    L8:
        r1.setText(r7);
        r5.b.setRotationX(180.0f);
    L14:
        r5.a.setTextColor(ColorProtector.parseColor("#99161823"));
        return;
    L9:
        TextView r2 = r5.a;
        if (TextUtils.isEmpty(r7) == false) goto L13;
        r7 = s1.B(2131920053);
    L13:
        r2.setText(r7);
        r5.b.setRotationX(0.0f);
        goto L14
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new PKExpandCollapseViewHolder(r4.inflate(2131566285, r5, false), this.b);
    }
}
