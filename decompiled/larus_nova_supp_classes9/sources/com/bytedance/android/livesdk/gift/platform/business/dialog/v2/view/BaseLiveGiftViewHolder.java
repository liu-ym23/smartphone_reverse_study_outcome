package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class BaseLiveGiftViewHolder<T extends AbsPanel<?>> extends RecyclerView.ViewHolder implements View.OnAttachStateChangeListener {
    public int a;

    public abstract void T3(T r1);

    public void onViewAttachedToWindow(View r1) {
    }

    public void onViewDetachedFromWindow(View r1) {
    }

    public BaseLiveGiftViewHolder(View r1) {
        super(r1);
        r1.addOnAttachStateChangeListener(this);
    }
}
