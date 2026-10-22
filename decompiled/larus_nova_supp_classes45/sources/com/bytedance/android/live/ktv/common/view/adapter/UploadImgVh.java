package com.bytedance.android.live.ktv.common.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/UploadImgVh;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UploadImgVh extends RecyclerView.ViewHolder {
    public final TextView a;
    public final ImageView b;
    public final View c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.e();
        }
    }

    public UploadImgVh(View r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "adapterClickCb");
        super(r2);
        this.a = (TextView) r2.findViewById(2131391660);
        this.b = (ImageView) r2.findViewById(2131376710);
        View r4 = r2.findViewById(2131372878);
        this.c = r4;
        r4.setOnClickListener(new a(r3));
    }
}
