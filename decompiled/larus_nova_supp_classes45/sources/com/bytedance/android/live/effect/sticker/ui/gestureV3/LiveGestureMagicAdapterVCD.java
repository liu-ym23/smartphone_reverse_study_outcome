package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.sticker.ui.LiveGestureMagicPageAdapter;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveGestureMagicAdapterVCD extends RecyclerView.Adapter<a> implements k.f {
    public final k a;
    public final LiveEffectContextFactoryDelegate$Type b;
    public LiveGestureMagicPageAdapter.b c;
    public Sticker d;
    public final List<Sticker> e;
    public EffectCategoryResponse f;
    public Sticker g;

    public class a extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final View b;
        public final View c;
        public final ProgressBar d;
        public final View e;

        public a(View r2) {
            super(r2);
            this.a = (ImageView) r2.findViewById(2131374931);
            this.b = r2.findViewById(2131363806);
            this.c = r2.findViewById(2131370173);
            this.d = (ProgressBar) r2.findViewById(2131378977);
            this.e = r2.findViewById(2131384112);
        }
    }

    public final int getItemCount() {
        if (Lists.isEmpty(this.e) == false) goto L7;
        return 0;
    L7:
        return ((ArrayList) this.e).size();
    }

    public LiveGestureMagicAdapterVCD(LiveEffectContextFactoryDelegate$Type r2) {
        this.b = r2;
        List<String> r0 = LiveEffectContext.h;
        this.a = LiveEffectContext.a.a(r2).b().r();
        this.e = new ArrayList();
    }

    public final int z2(Sticker r3) {
        int r0 = 0;
    L4:
        if (r0 >= ((ArrayList) this.e).size()) goto L10;
        if (Sticker.equals(r3, (Sticker) ListProtector.get(this.e, r0)) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        ListProtector.set(this.e, r0, r3);
        return r0;
    L10:
        return -1;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r5, Sticker r6) {
        Logger.d("LiveGestureMagicAdapterVCD", "download success response: " + this.f.getId() + " sticker: " + r6.getId() + " path: " + r6.getUnzipPath());
        if (r6.getId() != this.g.getId()) goto L8;
        LiveGestureMagicPageAdapter.b r7 = this.c;
        if (r7 == null) goto L8;
        r7.a(Boolean.FALSE, this.d);
        this.d = r6;
        this.c.a(Boolean.TRUE, r6);
    L8:
        if (z2(r6) < 0) goto L11;
        notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r4, Sticker r5) {
        Logger.d("LiveGestureMagicAdapterVCD", "download start response: " + this.f.getId() + " sticker: " + r5.getId() + " path: " + r5.getUnzipPath());
        if (z2(r5) < 0) goto L6;
        notifyDataSetChanged();
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        final a r7 = (a) r5;
        final Sticker r8 = (Sticker) ListProtector.get(this.e, r6);
        int r2 = 0;
        ImageUtil.loadImage(r7.a, r8.getIcon().toImgModel(), 0);
        Sticker r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        r7.b.setVisibility(8);
    L8:
        ProgressBar r1 = r7.d;
        if (r8.isDownloading() == false) goto L11;
        int r3 = 0;
    L12:
        r1.setVisibility(r3);
        View r4 = r7.c;
        if (r8.isDownloaded() == false) goto L15;
    L16:
        r2 = 8;
    L17:
        r4.setVisibility(r2);
        y2(r8, new c(r7));
        StringBuilder r9 = new StringBuilder();
        Sticker r11 = this.d;
        if (r11 != null) goto L20;
    L22:
        r9.append("未选中 ");
    L23:
        r9.append(r8.getName());
        ((RecyclerView.ViewHolder) r7).itemView.setContentDescription(r9);
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new com.bytedance.android.live.effect.sticker.ui.gestureV3.a(this, r8, r7));
        return;
    L20:
        if (Sticker.equals(r11, r8) == false) goto L22;
        r9.append("已选中 ");
        goto L23
    L15:
        if (r8.isDownloading() == false) goto L17;
    L11:
        r3 = 8;
        goto L12
    L5:
        if (Sticker.equals(r0, r8) == false) goto L7;
        r7.b.setVisibility(0);
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        return new a(LayoutInflater.from(r4.getContext()).inflate(2131565906, r4, false));
    }

    public final void y2(Sticker r3, IIsTagNeedUpdatedListener r4) {
        if (r3 != null) goto L4;
    L10:
        r4.onTagNeedNotUpdate();
        return;
    L4:
        if (Lists.isEmpty(r3.getTags()) == true) goto L10;
        if (r3.getTags().contains("new") == false) goto L10;
        this.a.b(r3.getRealId(), r3.getTagsUpdatedAt(), r4);
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r3, Sticker r4, ExceptionResult r5) {
        f2.b(2131916385, 0);
        Logger.d("LiveGestureMagicAdapterVCD", "download fail response: " + this.f.getId() + " sticker: " + r4.getId() + " path: " + r4.getUnzipPath());
        if (z2(r4) < 0) goto L6;
        notifyDataSetChanged();
        return;
    }
}
