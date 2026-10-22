package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.link.model.a4;
import com.bytedance.android.livesdk.link.model.z3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ActContentAreaViewBinder extends me.drakeet.multitype.b<a, ActContentAreaViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActContentAreaViewBinder$ActContentAreaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ActContentAreaViewHolder extends RecyclerView.ViewHolder {
        public ActContentAreaViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public static final class a {
        public final a4 a;

        public a(a4 r1) {
            this.a = r1;
        }
    }

    public ActContentAreaViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r6, Object r7) {
        ActContentAreaViewHolder r8 = (ActContentAreaViewHolder) r6;
        a r9 = (a) r7;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "item");
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "areaData");
        a4 r0 = r9.a;
        int r2 = 0;
        if (r0 == null) goto L15;
        String r1 = r0.getTitle();
        if (r1 == null) goto L15;
        if (r1.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L15;
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) r8).itemView.findViewById(2131378908));
        ((TextView) ((RecyclerView.ViewHolder) r8).itemView.findViewById(2131391606)).setText(r1);
        goto L15
    L9:
        r3 = false;
    L15:
        a4 r10 = r9.a;
        if (r10 == null) goto L41;
        z3 r12 = r10.getContent();
        if (r12 == null) goto L42;
        Integer r4 = r12.getType();
        if (r4 == null) goto L23;
        r2 = r4.intValue();
    L23:
        if (r2 != 0) goto L28;
        TextView r5 = (TextView) ((RecyclerView.ViewHolder) r8).itemView.findViewById(2131390392);
        if (r5 == null) goto L27;
        r5.setText(r12.getText());
        r5.setLineSpacing(4.0f, 1.0f);
        UtilityKotlinExtentionsKt.w(r5);
    L27:
        UtilityKotlinExtentionsKt.t(((RecyclerView.ViewHolder) r8).itemView.findViewById(2131376140));
        return;
    L28:
        Integer r13 = r12.getType();
        if (r13 != null) goto L32;
        return;
    L32:
        if (r13.intValue() != 1) goto L44;
        k r14 = r12.getImage();
        if (r14 == null) goto L45;
        UtilityKotlinExtentionsKt.t(((RecyclerView.ViewHolder) r8).itemView.findViewById(2131390392));
        HSImageView r15 = ((RecyclerView.ViewHolder) r8).itemView.findViewById(2131376140);
        ImageLoader.bindImage(r15, r14);
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) r8).itemView.findViewById(2131376140));
        if (r14.getWidth() != 0) goto L38;
        return;
    L38:
        if (r14.getHeight() == 0) goto L47;
        int r16 = s1.y() - s1.f(32.0f);
        int r17 = (int) ((((double) r16) / ((double) r14.getWidth())) * ((double) r14.getHeight()));
        r15.getLayoutParams().width = r16;
        r15.getLayoutParams().height = r17;
        r15.requestLayout();
        return;
    L47:
        return;
    L45:
        return;
    L44:
        return;
    L42:
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ActContentAreaViewHolder(r4.inflate(2131566014, r5, false));
    }
}
