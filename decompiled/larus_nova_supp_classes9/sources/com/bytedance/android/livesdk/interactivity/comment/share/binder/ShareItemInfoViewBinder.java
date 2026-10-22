package com.bytedance.android.livesdk.interactivity.comment.share.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashSet;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ShareItemInfoViewBinder extends me.drakeet.multitype.b<com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a, ViewHolder> {
    public final HashSet<String> b;
    public final b c;
    public final a d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/share/binder/ShareItemInfoViewBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final HSImageView a;
        public final TextView b;
        public final TextView c;
        public final TextView d;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131376157);
            this.b = (TextView) r2.findViewById(2131391606);
            this.c = (TextView) r2.findViewById(2131390479);
            this.d = (TextView) r2.findViewById(2131364779);
        }
    }

    public interface a {
        void e(com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r1);
    }

    public interface b {
        void a(com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r1);
    }

    public ShareItemInfoViewBinder(b r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "shareItemShowHandler");
        Intrinsics.checkNotNullParameter(r3, "shareItemClickHandler");
        this.c = r2;
        this.d = r3;
        this.b = new HashSet();
    }

    public final void b(RecyclerView.ViewHolder r5, Object r6) {
        ViewHolder r7 = (ViewHolder) r5;
        final com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r8 = (com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a) r6;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        ImageUtil.loadImageWithRadius(r7.a, r8.f(), 0, 8);
        r7.b.setText(r8.i());
        r7.c.setText(r8.h());
        r7.d.setText(r8.a());
        r7.d.setOnClickListener(x0.a(new ShareItemInfoViewBinder$onBindViewHolder$1(this, r8)));
        r3.a(((RecyclerView.ViewHolder) r7).itemView, r8.i() + " " + r8.h());
        r3.c(r7.d, r8.a(), true);
        ((RecyclerView.ViewHolder) r7).itemView.setBackground(new d72.a(ColorProtector.parseColor("#F4F3F4"), r8.b, r8.c));
        if (Intrinsics.areEqual(r8.a, "micro_app") == false) goto L12;
        IInteractivityInjectService r9 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r9 == null) goto L8;
        r9.preloadMiniApp(r8.d());
    L8:
        if (this.b.contains(r8.g()) == true) goto L12;
        this.b.add(r8.g());
        IInteractivityInjectService r10 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r10 == null) goto L12;
        r10.onShowMiniAppItem(r8.d());
    L12:
        this.c.a(r8);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ViewHolder(r3.inflate(2131567941, r4, false));
    }
}
