package com.bytedance.android.live.effect.beauty.newtemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.r3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/newtemp/LiveOneTapBeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/newtemp/LiveOneTapBeautyAdapter$ViewHolder;", "a", "b", "ViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOneTapBeautyAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final int a;
    public final LiveEffectContextFactoryDelegate$Type b;
    public final List<o90.a> c;
    public final Context d;
    public int e;
    public final b f;
    public final boolean g;
    public final Set<String> h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/newtemp/LiveOneTapBeautyAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public int a;
        public final View b;
        public final SimpleDraweeView c;
        public final TextView d;
        public final View e;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = -1;
            this.b = r2.findViewById(2131364341);
            this.c = r2.findViewById(2131376045);
            this.d = (TextView) r2.findViewById(2131390975);
            this.e = r2.findViewById(2131375762);
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

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r4) {
        ViewHolder r5 = (ViewHolder) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewAttachedToWindow(r5);
        int r6 = r5.a;
        if (r6 == (-1)) goto L8;
        o90.a r0 = (o90.a) ListProtector.get(this.c, r6);
        if (this.h.contains(r0.d) == true) goto L9;
        this.h.add(r0.d);
        ALogger.i("LiveOneTapBeautyAdapter", "show item = " + r0.b + ' ' + r0.d + ", position = " + r6);
        y2(true, r0, r6);
        return;
    L9:
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r11) {
        final ViewHolder r12 = (ViewHolder) r9;
        Intrinsics.checkNotNullParameter(r12, "holder");
        boolean r0 = false;
        if (r11 != 0) goto L5;
        a1.m(((RecyclerView.ViewHolder) r12).itemView, UtilityKotlinExtentionsKt.i(0));
    L7:
        if (r11 != (getItemCount() - 1)) goto L9;
        a1.n(((RecyclerView.ViewHolder) r12).itemView, UtilityKotlinExtentionsKt.i(22));
    L10:
        r12.a = r11;
        o90.a r1 = (o90.a) ListProtector.get(this.c, r11);
        String r2 = r1.b;
        UrlModel r3 = r1.c;
        if (r11 != this.e) goto L13;
        final boolean r4 = true;
    L14:
        View r5 = r12.b;
        if (r4 == false) goto L17;
        int r6 = 0;
    L18:
        r5.setVisibility(r6);
        if (r4 == false) goto L21;
        r12.d.setTextColor(this.d.getResources().getColor(2131107400));
    L23:
        if (r3.getUri() == null) goto L32;
        List<String> r7 = r3.getUrlList();
        if (r7 != null) goto L27;
    L28:
        r0 = true;
    L29:
        if (r0 == true) goto L32;
        ImageModel r8 = new ImageModel();
        r8.setUri(r3.getUri());
        r8.setUrls(r3.getUrlList());
    L33:
        ImageLoader.bindImage(r12.c, r8);
        r12.d.setText(r2);
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new com.bytedance.android.live.effect.beauty.newtemp.b(this, r11));
        r3.e(((RecyclerView.ViewHolder) r12).itemView, new AnonymousClass2(r4, r12));
        return;
    L27:
        if (r7.isEmpty() == false) goto L29;
    L32:
        r8 = new ImageModel();
        r8.setUrls(CollectionsKt.listOf("https://lf9-effect-302.byteeffecttos.com/obj/ies.fe.effect/33c2f82e844b18d9255431322385bdb7"));
        goto L33
    L21:
        r12.d.setTextColor(this.d.getResources().getColor(2131107401));
        goto L23
    L17:
        r6 = 4;
        goto L18
    L13:
        r4 = false;
        goto L14
    L9:
        a1.n(((RecyclerView.ViewHolder) r12).itemView, UtilityKotlinExtentionsKt.i(0));
        goto L10
    L5:
        a1.m(((RecyclerView.ViewHolder) r12).itemView, UtilityKotlinExtentionsKt.i(22));
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ViewHolder(LayoutInflater.from(this.d).inflate(this.a, r4, false));
    }

    public static void y2(boolean r2, o90.a r3, int r4) {
        HashMap r0 = new HashMap();
        r0.put("position", String.valueOf(r4 + 1));
        r0.put("beauty_effect_name", r3.b);
        r0.put("beauty_effect_id", r3.d);
        IUserService r5 = k.f(IUserService.class);
        if (r5 == null) goto L8;
        com.bytedance.android.livesdk.user.f r6 = r5.user();
        if (r6 == null) goto L8;
        String r7 = r6.n();
        if (r7 == null) goto L8;
    L9:
        r0.put("anchor_id", r7);
        if (r2 == false) goto L12;
        String r8 = "livesdk_live_takepage_beauty_effect_show";
    L13:
        u.l().sendLog(r8, r0, new Object[0]);
        return;
    L12:
        r8 = "livesdk_live_takepage_beauty_effect_select";
    L8:
        r7 = "0";
        goto L9
    }

    public LiveOneTapBeautyAdapter(Context r2, LiveOneTapBeautyListFragment.d r3, q90.b r4, LiveEffectContextFactoryDelegate$Type r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "template");
        Intrinsics.checkNotNullParameter(r5, "type");
        this.c = new ArrayList();
        this.g = true;
        this.h = new LinkedHashSet();
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
