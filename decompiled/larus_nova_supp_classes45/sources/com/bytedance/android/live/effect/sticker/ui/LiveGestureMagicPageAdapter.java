package com.bytedance.android.live.effect.sticker.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveGestureMagicPageAdapter extends RecyclerView.Adapter<a> {

    public class a extends RecyclerView.ViewHolder {
        public a(View r4) {
            super(r4);
            ImageView r0 = (ImageView) r4.findViewById(2131374931);
            RecyclerView r1 = r4.findViewById(2131384076);
            r1.setLayoutManager(new LinearLayoutManager(r4.getContext(), 0, false));
            r1.addItemDecoration(new LiveGestureListItemDecoration());
        }
    }

    public interface b {
        void a(Boolean r1, Sticker r2);
    }

    public final int getItemCount() {
        if (Lists.isEmpty(null) == false) goto L6;
        return 0;
    L6:
        throw null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        a r4 = (a) r2;
        new ArrayList();
        EffectCategoryResponse r5 = (EffectCategoryResponse) ListProtector.get(null, r3);
        new ImageModel();
        new ArrayList();
        r5.getId();
        throw null;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        return new a(LayoutInflater.from(r4.getContext()).inflate(2131565904, r4, false));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2, List r3) {
        a r4 = (a) r1;
        EffectCategoryResponse r5 = (EffectCategoryResponse) ListProtector.get(null, r2);
        new ImageModel();
        new ArrayList();
        r5.getId();
        throw null;
    }
}
