package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/sharelinkpanel/CopiedLinkToThirdAppHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CopiedLinkToThirdAppHolder extends RecyclerView.ViewHolder {
    public final ImageView a;
    public final TextView b;
    public final View c;

    public CopiedLinkToThirdAppHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.c = r2;
        this.a = (ImageView) r2.findViewById(2131375773);
        this.b = (TextView) r2.findViewById(2131375867);
    }
}
