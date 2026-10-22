package com.bytedance.android.live.adapter.binding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/adapter/binding/SwitchSettingViewHolder;", "Lcom/bytedance/android/live/adapter/binding/BaseSettingViewHolder;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SwitchSettingViewHolder extends BaseSettingViewHolder {
    public final LiveSwitchButton d;
    public final TextView e;
    public final ImageView f;

    public SwitchSettingViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.d = r2.findViewById(2131386014);
        this.e = (TextView) r2.findViewById(2131390483);
        this.f = (ImageView) r2.findViewById(2131376651);
    }
}
