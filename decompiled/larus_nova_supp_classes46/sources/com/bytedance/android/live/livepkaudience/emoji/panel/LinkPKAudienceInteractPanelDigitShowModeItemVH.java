package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelDigitShowModeItemVH;", "Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelItemBaseVH;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPKAudienceInteractPanelDigitShowModeItemVH extends LinkPKAudienceInteractPanelItemBaseVH {
    public g a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LinkPKAudienceInteractPanelDigitShowModeItemVH a;

        public a(LinkPKAudienceInteractPanelDigitShowModeItemVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            r2.setTag(2);
            g r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.e(r2);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LinkPKAudienceInteractPanelDigitShowModeItemVH a;

        public b(LinkPKAudienceInteractPanelDigitShowModeItemVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            r2.setTag(1);
            g r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.e(r2);
            return;
        }
    }

    public LinkPKAudienceInteractPanelDigitShowModeItemVH(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363386)).setOnClickListener(new a(this));
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392239)).setOnClickListener(new b(this));
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.LinkPKAudienceInteractPanelItemBaseVH
    public final void T3(g r9) {
        Intrinsics.checkNotNullParameter(r9, "panelItem");
        this.a = r9;
        LinearLayout r0 = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363387);
        UtilityKotlinExtentionsKt.t(r0);
        int r2 = 0;
        r0.setSelected(false);
        LinearLayout r1 = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392240);
        UtilityKotlinExtentionsKt.t(r1);
        r1.setSelected(false);
        Object r10 = r9.b();
        if (r10 == null) goto L22;
        c r11 = (c) r10;
        int[] r3 = r11.a;
        int r4 = r3.length;
    L6:
        if (r2 >= r4) goto L14;
        int r7 = r3[r2];
        if (r7 == 1) goto L12;
        if (r7 != 2) goto L13;
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) this).itemView.findViewById(2131363387));
    L13:
        r2 = r2 + 1;
        goto L6
    L12:
        UtilityKotlinExtentionsKt.w(((RecyclerView.ViewHolder) this).itemView.findViewById(2131392240));
        goto L13
    L14:
        int r12 = r11.b;
        if (r12 == 1) goto L19;
        if (r12 != 2) goto L28;
        ((LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363387)).setSelected(true);
        return;
    L28:
        return;
    L19:
        ((LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131392240)).setSelected(true);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.emoji.panel.DigitShowModeData");
    }
}
