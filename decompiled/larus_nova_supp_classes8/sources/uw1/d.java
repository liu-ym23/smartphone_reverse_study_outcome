package uw1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.squarefeed.viewholder.SimpleLiveViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements b90.a {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    public final BaseViewHolder<Object> a(ViewGroup r9, Object[] r10) {
        View r3 = LayoutInflater.from(r9.getContext()).inflate(2131566259, r9, false);
        e r11 = this.a;
        return new SimpleLiveViewHolder(r3, r11.c, r11.d, r11.b, r11.e);
    }
}
