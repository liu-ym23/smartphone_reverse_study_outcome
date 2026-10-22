package com.bytedance.android.live.effect.beauty.smallitem;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ LiveSmallItemBeautyTemplateAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ LiveSmallItemBeautyTemplateAdapter.AbsSmallItemViewHolder c;

    public static final class a implements Runnable {
        public final /* synthetic */ f0 a;

        public a(f0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.notifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f0(LiveSmallItemBeautyTemplateAdapter r1, int r2, LiveSmallItemBeautyTemplateAdapter.AbsSmallItemViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.f.put(this.b, Boolean.FALSE);
        ((RecyclerView.ViewHolder) this.c).itemView.findViewById(2131371913).setVisibility(8);
        ((RecyclerView.ViewHolder) this.c).itemView.findViewById(2131373068).setVisibility(0);
        LiveSmallItemBeautyTemplateAdapter r4 = this.a;
        LiveSmallItemBeautyTemplateAdapter.a r0 = r4.e;
        if (r0 == null) goto L5;
        r0.a((Sticker) ListProtector.get(r4.a, this.b));
    L5:
        ((RecyclerView.ViewHolder) this.c).itemView.post(new a(this));
    }
}
