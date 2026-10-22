package com.bytedance.android.live.effect.sticker.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveGestureMagicAdapter extends RecyclerView.Adapter implements com.bytedance.android.live.effect.api.k.f {

    public class a extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final View b;
        public final View c;
        public final ProgressBar d;

        public a(View r2) {
            super(r2);
            this.a = (ImageView) r2.findViewById(2131374931);
            this.b = r2.findViewById(2131363806);
            this.c = r2.findViewById(2131370173);
            this.d = (ProgressBar) r2.findViewById(2131378977);
        }
    }

    public LiveGestureMagicAdapter() {
        throw null;
    }

    public final int getItemCount() {
        if (Lists.isEmpty(null) == false) goto L6;
        return 0;
    L6:
        throw null;
    }

    public final int getItemViewType(int r1) {
        return 1;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r1, Sticker r2) {
        throw null;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r1, Sticker r2) {
        throw null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, final int r6) {
        if (getItemViewType(r6) != 1) goto L13;
        a r7 = (a) r5;
        Sticker r0 = (Sticker) ListProtector.get(null, r6);
        int r3 = 0;
        ImageUtil.loadImage(r7.a, r0.getIcon().toImgModel(), 0);
        r7.b.setVisibility(8);
        ProgressBar r1 = r7.d;
        if (r0.isDownloading() == false) goto L7;
        int r2 = 0;
    L8:
        r1.setVisibility(r2);
        View r4 = r7.c;
        if (r0.isDownloaded() == false) goto L11;
        r3 = 8;
    L11:
        r4.setVisibility(r3);
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new b(this, r6));
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        return new a(LayoutInflater.from(r4.getContext()).inflate(2131565906, r4, false));
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r1, Sticker r2, ExceptionResult r3) {
        f2.b(2131916385, 0);
        throw null;
    }
}
