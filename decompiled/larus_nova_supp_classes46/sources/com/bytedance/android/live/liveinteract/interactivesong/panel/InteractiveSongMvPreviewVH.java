package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/InteractiveSongMvPreviewVH;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/IMvPreviewViewHolder;", "Lcom/bytedance/android/live/liveinteract/interactivesong/panel/i;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractiveSongMvPreviewVH extends IMvPreviewViewHolder<i> {
    public final ViewGroup c;
    public final ViewGroup d;
    public final HSImageView e;
    public final ViewGroup f;
    public final TextView g;
    public final View h;

    public InteractiveSongMvPreviewVH(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.c = (ViewGroup) r2.findViewById(2131380544);
        this.d = (ViewGroup) r2.findViewById(2131380543);
        this.e = r2.findViewById(2131380545);
        this.f = (ViewGroup) r2.findViewById(2131380546);
        this.g = (TextView) r2.findViewById(2131380547);
        this.h = r2.findViewById(2131380548);
    }

    public final void T3(final int r5, Object r6) {
        final i r7 = (i) r6;
        Intrinsics.checkNotNullParameter(r7, "mvPanel");
        if (r7.b == false) goto L7;
        View r0 = this.h;
        if (r0 == null) goto L10;
        r0.setVisibility(0);
    L10:
        HSImageView r1 = ((IMvPreviewViewHolder) this).b;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverBg");
    L13:
        IOrderSingMVInfo r3 = r7.a;
        if (r3 == null) goto L18;
        IMVBaseInfo r4 = r3.getMvBaseInfo();
        if (r4 == null) goto L18;
        String r8 = r4.getCoverUrl();
    L19:
        r1.setImageURI(r8);
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new InteractiveSongMvPreviewVH$onBind$1(this, r5, r7));
        IOrderSingMVInfo r9 = r7.a;
        if (r9 != null) goto L22;
    L34:
        ViewGroup r10 = this.c;
        if (r10 == null) goto L37;
        r10.setVisibility(8);
    L37:
        int r11 = r7.c;
        if (r11 != 1) goto L46;
        ViewGroup r12 = this.f;
        if (r12 == null) goto L42;
        r12.setVisibility(0);
    L42:
        TextView r13 = this.g;
        if (r13 == null) goto L57;
        r13.setText(s1.B(2131918133));
        return;
    L57:
        return;
    L46:
        if (r11 != 2) goto L53;
        ViewGroup r14 = this.f;
        if (r14 == null) goto L50;
        r14.setVisibility(0);
    L50:
        TextView r15 = this.g;
        if (r15 == null) goto L59;
        r15.setText(s1.B(2131918132));
        return;
    L59:
        return;
    L53:
        ViewGroup r16 = this.f;
        if (r16 == null) goto L61;
        r16.setVisibility(8);
        return;
    L61:
        return;
    L22:
        if (r9.isHighQuality() != true) goto L34;
        ViewGroup r17 = this.c;
        if (r17 == null) goto L26;
        r17.setVisibility(0);
    L26:
        ViewGroup r18 = this.d;
        if (r18 == null) goto L30;
        r18.setBackground(s1.m(2131249596));
    L30:
        if (r7.a.isLocked() == false) goto L37;
        HSImageView r19 = this.e;
        if (r19 == null) goto L37;
        r19.setVisibility(0);
    L18:
        r8 = null;
        goto L19
    L7:
        View r2 = this.h;
        if (r2 == null) goto L10;
        r2.setVisibility(8);
        goto L10
    }
}
