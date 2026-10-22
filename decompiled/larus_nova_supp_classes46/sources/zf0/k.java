package zf0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.SimpleGuestApplyFootHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k extends me.drakeet.multitype.b<d, SimpleGuestApplyFootHolder> {
    public k() {
    }

    public final void b(RecyclerView.ViewHolder r6, Object r7) {
        SimpleGuestApplyFootHolder r8 = (SimpleGuestApplyFootHolder) r6;
        d r9 = (d) r7;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "item");
        int r10 = r9.getType();
        View r0 = ((RecyclerView.ViewHolder) r8).itemView;
        if (r0 == null) goto L44;
        TextView r1 = (TextView) r0;
        switch(r10) {
            case 0: goto L37;
            case 1: goto L32;
            case 2: goto L27;
            case 3: goto L22;
            case 4: goto L17;
            case 5: goto L12;
            case 6: goto L7;
            default: goto L51;
        };
    L7:
        r8.T3(s1.f(60.0f));
        View r11 = ((RecyclerView.ViewHolder) r8).itemView;
        if (r11 == null) goto L11;
        ((TextView) r11).setText(2131920724);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L12:
        r8.T3(-1);
        View r12 = ((RecyclerView.ViewHolder) r8).itemView;
        if (r12 == null) goto L16;
        ((TextView) r12).setText(2131920724);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L17:
        r8.T3(s1.f(60.0f));
        View r13 = ((RecyclerView.ViewHolder) r8).itemView;
        if (r13 == null) goto L21;
        ((TextView) r13).setText(2131921198);
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L22:
        r8.T3(-1);
        View r14 = ((RecyclerView.ViewHolder) r8).itemView;
        if (r14 == null) goto L26;
        ((TextView) r14).setText(2131921198);
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L27:
        r8.T3(-1);
        View r15 = ((RecyclerView.ViewHolder) r8).itemView;
        if (r15 == null) goto L31;
        ((TextView) r15).setText(2131921199);
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L32:
        r8.T3(s1.f(60.0f));
        View r16 = ((RecyclerView.ViewHolder) r8).itemView;
        if (r16 == null) goto L36;
        ((TextView) r16).setText(2131918005);
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L37:
        r8.T3(s1.f(60.0f));
        View r17 = ((RecyclerView.ViewHolder) r8).itemView;
        if (r17 == null) goto L41;
        ((TextView) r17).setText(2131918004);
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L51:
        return;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new SimpleGuestApplyFootHolder(r4.inflate(2131566247, r5, false));
    }
}
