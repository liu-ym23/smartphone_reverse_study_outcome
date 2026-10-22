package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSTextMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.interactivityshare.ItemShareLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/messagemodel/PSInteractivityShareMessageViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PSTextMessageViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSInteractivityShareMessageViewHolder extends PSTextMessageViewHolder {
    public final ItemShareLayout k;
    public final HSImageView l;
    public final TextView m;
    public final View n;
    public final Function2<m1, Context, Unit> o;

    public PSInteractivityShareMessageViewHolder(View r2, Function2<? super m1, ? super Context, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "onShareItemClick");
        super(r2, null);
        this.o = r3;
        this.k = (ItemShareLayout) r2.findViewById(2131377403);
        this.l = r2.findViewById(2131376157);
        this.m = (TextView) r2.findViewById(2131390975);
        this.n = r2.findViewById(2131386072);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.PSTextMessageViewHolder
    public final void X3(e52.a r2, s r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r3, "model");
        int r5 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.a(r4, null, r2);
        this.k.setTouchBackgroundColor(r5);
    }
}
