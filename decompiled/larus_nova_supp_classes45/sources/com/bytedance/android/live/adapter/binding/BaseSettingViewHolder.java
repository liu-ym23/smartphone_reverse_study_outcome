package com.bytedance.android.live.adapter.binding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.nc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mx.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/adapter/binding/BaseSettingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseSettingViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final TextView b;
    public final ImageView c;

    public BaseSettingViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (TextView) r2.findViewById(2131391543);
        this.b = (TextView) r2.findViewById(2131391540);
        this.c = (ImageView) r2.findViewById(2131384095);
    }

    public final void T3(a r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        this.a.setText(r6.e);
        this.b.setText(r6.f);
        TextView r0 = this.b;
        int r2 = 0;
        if (r6.f.length() <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        int r3 = 0;
    L10:
        r0.setVisibility(r3);
        if (((Boolean) nc.a.getValue()).booleanValue() == false) goto L19;
        Long r4 = r6.k;
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L17:
        if (((int) r5) != 3) goto L19;
        this.c.getLayoutParams().height = s1.f(12.0f);
        this.c.getLayoutParams().width = s1.f(12.0f);
        this.c.setImageDrawable(null);
        this.c.setBackgroundResource(2131251358);
        this.c.setTranslationY(-s1.f(3.0f));
    L20:
        ImageView r7 = this.c;
        if (r6.h == true) goto L24;
        r2 = 8;
    L24:
        r7.setVisibility(r2);
        return;
    L15:
        r5 = 0;
    L19:
        this.c.getLayoutParams().height = s1.f(6.0f);
        this.c.getLayoutParams().width = s1.f(6.0f);
        this.c.setBackgroundResource(0);
        this.c.setImageResource(2131251416);
        this.c.setTranslationY(0.0f);
        goto L20
    L9:
        r3 = 8;
        goto L10
    L5:
        r1 = false;
        goto L7
    }
}
