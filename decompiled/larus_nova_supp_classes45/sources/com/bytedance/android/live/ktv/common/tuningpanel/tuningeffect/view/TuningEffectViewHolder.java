package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdk.utils.x0;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningEffectViewHolder extends RecyclerView.ViewHolder {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public h e;

    public static final class a {
    }

    static {
    }

    public final HSImageView T3() {
        return (HSImageView) this.c.getValue();
    }

    public TuningEffectViewHolder(final View r4, final cc0.a r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "tuningEffectInnerCallback");
        super(r4);
        this.a = LazyKt.lazy(new TuningEffectViewHolder$tuningCoverContainer$2(r4));
        Lazy r0 = LazyKt.lazy(new TuningEffectViewHolder$selectedBorder$2(r4));
        this.b = r0;
        this.c = LazyKt.lazy(new TuningEffectViewHolder$cover$2(r4));
        Lazy r6 = LazyKt.lazy(new TuningEffectViewHolder$title$2(r4));
        this.d = r6;
        SimpleDraweeView r1 = T3();
        if (r1 == null) goto L5;
        r1.setOnClickListener(x0.a(new AnonymousClass1(this, r5)));
    L5:
        TextView r7 = (TextView) r6.getValue();
        if (r7 == null) goto L8;
        KtvOrderSongThemeManager.d(r7, 10);
    L8:
        View r8 = (View) r0.getValue();
        if (r8 == null) goto L12;
        KtvOrderSongThemeManager.c(r8, KtvOrderSongThemeManager.x);
        return;
    }
}
