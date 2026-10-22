package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PSMessageViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/ui/MessageViewHolder;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PSMessageViewHolder extends MessageViewHolder {
    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    @Deprecated(message = "不需要实现该方法")
    public final void U3(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1, int r2, g52.e r3) {
    }

    public PSMessageViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }
}
