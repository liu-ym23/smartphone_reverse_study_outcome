package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.holder.BaseSettingHolder;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.holder.SettingNormalHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import np1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/adapter/AudiencePortraitSettingAdapter;", "Lnp1/b;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/holder/BaseSettingHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePortraitSettingAdapter<T extends b> extends RecyclerView.Adapter<BaseSettingHolder<T>> {
    public final List<? extends T> a;
    public final boolean b;

    public final int getItemCount() {
        return this.a.size();
    }

    public final int getItemViewType(int r2) {
        return ((b) ListProtector.get(this.a, r2)).getType();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        BaseSettingHolder r3 = (BaseSettingHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        r3.U3();
    }

    public AudiencePortraitSettingAdapter(List<? extends T> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "models");
        this.a = r2;
        this.b = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        BaseSettingHolder r4 = (BaseSettingHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.T3((b) ListProtector.get(this.a, r3));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 == 1) goto L5;
        SettingNormalHolder r4 = new SettingNormalHolder(r2);
    L6:
        View r5 = ((RecyclerView.ViewHolder) r4).itemView;
        if (this.b == false) goto L9;
        r5.setBackgroundResource(2131249737);
        a1.m(r5, (int) UtilityKotlinExtentionsKt.h(16.0f));
        a1.n(r5, UtilityKotlinExtentionsKt.i(16));
    L10:
        return r4;
    L9:
        r5.setBackgroundColor(0);
        goto L10
    L5:
        r4 = new SettingNormalHolder(r2);
        goto L6
    }
}
