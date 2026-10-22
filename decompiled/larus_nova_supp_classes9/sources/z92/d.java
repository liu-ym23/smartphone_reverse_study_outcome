package z92;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$ViewBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.m;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.hover.HoverMessageViewHolder;
import g52.e;
import kotlin.jvm.internal.Intrinsics;
import u42.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements j<a, HoverMessageViewHolder> {
    public static final PublicScreenConfig$ViewBinderType a = null;
    public static final d b = null;

    public d() {
    }

    static {
        b = new d();
        a = PublicScreenConfig$ViewBinderType.HOVER_AREA;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final PublicScreenConfig$ViewBinderType a() {
        return a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final PSMessageViewHolder c(LayoutInflater r3, ViewGroup r4, g52.c r5) {
        Intrinsics.checkNotNullParameter(r3, "layoutInflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        HoverMessageViewHolder.e.getClass();
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r6 = r3.inflate(2131566775, r4, false);
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        com.bytedance.live.datacontext.j<l> r7 = m.a(null);
        if (r7 == null) goto L7;
        l r8 = (l) r7.getValue();
        if (r8 == null) goto L7;
        e52.a r9 = r8.getTextConfig();
    L8:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.e(r6, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.a(false, null, r9));
        return new HoverMessageViewHolder(r6);
    L7:
        r9 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void b(PSMessageViewHolder r3, i r4, int r5, e r6) {
        HoverMessageViewHolder r7 = (HoverMessageViewHolder) r3;
        a r8 = (a) r4;
        Intrinsics.checkNotNullParameter(r7, "viewHolder");
        Intrinsics.checkNotNullParameter(r8, "item");
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "item");
        f.a("HoverMessageViewHolder bind");
        HoverMessageViewHolder.a r9 = HoverMessageViewHolder.e;
        View r10 = ((RecyclerView.ViewHolder) r7).itemView;
        TextView r0 = r7.b;
        TextView r1 = r7.c;
        HSImageView r11 = r7.d;
        r9.getClass();
        HoverMessageViewHolder.a.a(r10, r0, r1, r11, r8);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void d(PSMessageViewHolder r2, i r3, int r4, e r5) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, "item");
        j.a.a(this, r2, r3, r4, r5);
    }
}
