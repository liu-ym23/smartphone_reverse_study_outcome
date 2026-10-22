package com.bytedance.android.live.effect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.beauty.LiveBeautyTemplateDetailFragment;
import com.bytedance.android.livesdk.r3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/adapter/LiveBeautyTemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/adapter/LiveBeautyTemplateAdapter$ViewHolder;", "a", "b", "ViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautyTemplateAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final int a;
    public final LiveEffectContextFactoryDelegate$Type b;
    public final List<o90.a> c;
    public final Context d;
    public int e;
    public final b f;
    public final boolean g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/adapter/LiveBeautyTemplateAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final SimpleDraweeView b;
        public final TextView c;
        public final View d;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131364341);
            this.b = r2.findViewById(2131376045);
            this.c = (TextView) r2.findViewById(2131390975);
            this.d = r2.findViewById(2131375762);
        }
    }

    public static final class a {
    }

    public interface b {
        void onItemClick(int r1);
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r11) {
        final ViewHolder r12 = (ViewHolder) r9;
        Intrinsics.checkNotNullParameter(r12, "holder");
        o90.a r0 = (o90.a) ListProtector.get(this.c, r11);
        String r1 = r0.b;
        UrlModel r2 = r0.c;
        boolean r3 = true;
        if (r11 != this.e) goto L5;
        final boolean r4 = true;
    L6:
        View r5 = r12.a;
        if (r4 == false) goto L9;
        int r6 = 0;
    L10:
        r5.setVisibility(r6);
        if (r4 == false) goto L13;
        r12.c.setTextColor(this.d.getResources().getColor(2131107400));
    L15:
        if (r2.getUri() == null) goto L25;
        List<String> r7 = r2.getUrlList();
        if (r7 != null) goto L19;
    L22:
        if (r3 == true) goto L25;
        ImageModel r8 = new ImageModel();
        r8.setUri(r2.getUri());
        r8.setUrls(r2.getUrlList());
    L26:
        ImageLoader.bindImage(r12.b, r8);
        r12.c.setText(r1);
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new i90.a(this, r11));
        r3.e(((RecyclerView.ViewHolder) r12).itemView, new AnonymousClass2(r4, r12));
        return;
    L19:
        if (r7.isEmpty() == true) goto L22;
        r3 = false;
    L25:
        r8 = new ImageModel();
        r8.setUrls(CollectionsKt.listOf("https://lf9-effect-302.byteeffecttos.com/obj/ies.fe.effect/33c2f82e844b18d9255431322385bdb7"));
        goto L26
    L13:
        r12.c.setTextColor(this.d.getResources().getColor(2131107401));
        goto L15
    L9:
        r6 = 4;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ViewHolder(LayoutInflater.from(this.d).inflate(this.a, r4, false));
    }

    public LiveBeautyTemplateAdapter(Context r2, LiveBeautyTemplateDetailFragment.e r3, q90.b r4, LiveEffectContextFactoryDelegate$Type r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "template");
        Intrinsics.checkNotNullParameter(r5, "type");
        this.c = new ArrayList();
        this.g = true;
        this.d = r2;
        this.b = r5;
        this.e = m90.b.c.c(r5).intValue();
        this.f = r3;
        int r6 = r4.a;
        if (r6 != (-1)) goto L5;
        r6 = 2131565901;
    L5:
        this.a = r6;
    }
}
