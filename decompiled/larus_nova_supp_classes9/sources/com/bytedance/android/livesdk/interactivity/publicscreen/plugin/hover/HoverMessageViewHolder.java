package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.hover;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.message.t3;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/hover/HoverMessageViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PSMessageViewHolder;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HoverMessageViewHolder extends PSMessageViewHolder {
    public static final a e = null;
    public final TextView b;
    public final TextView c;
    public final HSImageView d;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(View r1, TextView r2, TextView r3, HSImageView r4, z92.a r5) {
            Intrinsics.checkNotNullParameter(r1, "itemView");
            Intrinsics.checkNotNullParameter(r2, "titleView");
            Intrinsics.checkNotNullParameter(r3, "subTitleView");
            Intrinsics.checkNotNullParameter(r4, "iconView");
            Intrinsics.checkNotNullParameter(r5, "model");
            t3 r6 = r5.k;
            if (r6.getHeight() <= 0) goto L5;
            int r0 = UtilityKotlinExtentionsKt.i(r6.getHeight());
        L6:
            a1.k(r1, r0);
            r2.setText(r6.I1());
            r3.setText(r6.U());
            ImageModel r7 = r6.S0();
            if (r7 != null) goto L9;
            UtilityKotlinExtentionsKt.t(r4);
            return;
        L9:
            UtilityKotlinExtentionsKt.w(r4);
            a1.p(r4, UtilityKotlinExtentionsKt.i(r7.getWidth()));
            a1.k(r4, UtilityKotlinExtentionsKt.i(r7.getHeight()));
            ImageUtil.loadImage(r4, r7, 0);
            return;
        L5:
            r0 = -2;
            goto L6
        }
    }

    static {
        e = new a();
    }

    public HoverMessageViewHolder(View r2) {
        super(r2);
        this.b = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131388772);
        this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131387553);
        this.d = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376297);
    }
}
