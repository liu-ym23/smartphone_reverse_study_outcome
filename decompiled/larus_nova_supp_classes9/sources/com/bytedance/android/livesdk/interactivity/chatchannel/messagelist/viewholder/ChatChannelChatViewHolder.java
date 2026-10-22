package com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.bytedance.android.livesdk.r3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wb2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/ChatChannelChatViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/PadAdjustViewHolder;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelChatViewHolder extends PadAdjustViewHolder {
    public static final int e = 0;
    public static final int f = 0;
    public final HSImageView a;
    public final TextView b;
    public final TextView c;
    public d.a d;

    public static final class a {
    }

    static {
        e = s1.f(36.0f);
        f = s1.f(18.0f);
    }

    public ChatChannelChatViewHolder(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        this.a = r4.findViewById(2131363623);
        TextView r0 = (TextView) r4.findViewById(2131380897);
        this.b = r0;
        TextView r5 = (TextView) r4.findViewById(2131388414);
        this.c = r5;
        if (r5 == null) goto L5;
        r5.setMovementMethod(u.a());
    L5:
        Boolean r6 = o62.d.a;
        if (o62.d.a.booleanValue() == false) goto L10;
        if (r0 == null) goto L11;
        r0.setShadowLayer(o62.d.c, 0.0f, 0.0f, o62.d.b);
        return;
    L11:
        return;
    }

    public final void T3(ImageModel r3, String r4) {
        ImageLoader.bindImage(this.a, r3);
        HSImageView r5 = this.a;
        if (r5 == null) goto L6;
        r5.setImportantForAccessibility(1);
        r5.setFocusable(true);
        r3.c(r5, r4 + "头像", true);
        return;
    }
}
