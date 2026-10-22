package com.bytedance.android.live.adapter.binding;

import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/adapter/binding/SimpleSettingViewHolder;", "Lcom/bytedance/android/live/adapter/binding/BaseSettingViewHolder;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleSettingViewHolder extends BaseSettingViewHolder {
    public final ImageView d;

    public SimpleSettingViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.d = (ImageView) r2.findViewById(2131375994);
    }
}
