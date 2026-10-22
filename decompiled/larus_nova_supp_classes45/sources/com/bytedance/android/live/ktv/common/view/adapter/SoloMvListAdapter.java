package com.bytedance.android.live.ktv.common.view.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.soloktv.view.MvControlTabWrapper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/SoloMvListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloMvListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public List<? extends com.bytedance.android.live.ktv.common.view.adapter.a> a;
    public final b b;

    public static final class a {
    }

    static {
        c = s1.f(66.0f);
        d = s1.f(115.0f);
        e = s1.f(5.0f);
        f = 1;
        g = 3;
    }

    public final int getItemCount() {
        List<? extends com.bytedance.android.live.ktv.common.view.adapter.a> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public SoloMvListAdapter(MvControlTabWrapper.onMvListUpdate.1 r2) {
        Intrinsics.checkNotNullParameter(r2, "adapterClickCb");
        this.b = r2;
    }

    public final int getItemViewType(int r2) {
        List<? extends com.bytedance.android.live.ktv.common.view.adapter.a> r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.ktv.common.view.adapter.a r3 = (com.bytedance.android.live.ktv.common.view.adapter.a) ListProtector.get(r0, r2);
    L7:
        if ((r3 instanceof d) == false) goto L11;
        return g;
    L11:
        if ((r3 instanceof c) == false) goto L18;
        if (((c) r3).a.g() == false) goto L16;
        return 0;
    L16:
        return f;
    L18:
        return f;
    L5:
        r3 = null;
        goto L7
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        com.bytedance.android.live.ktv.common.view.adapter.a r1 = null;
        if ((r4 instanceof UploadImgVh) == false) goto L35;
        List<? extends com.bytedance.android.live.ktv.common.view.adapter.a> r0 = this.a;
        if (r0 == null) goto L7;
        com.bytedance.android.live.ktv.common.view.adapter.a r6 = (com.bytedance.android.live.ktv.common.view.adapter.a) ListProtector.get(r0, r5);
    L9:
        if ((r6 instanceof d) == false) goto L12;
        r1 = r6;
    L12:
        d r2 = (d) r1;
        if (r2 == null) goto L48;
        UploadImgVh r7 = (UploadImgVh) r4;
        Bitmap r8 = r2.a;
        if (r8 != null) goto L25;
        TextView r9 = r7.a;
        if (r9 == null) goto L19;
        r9.setText(2131922627);
    L19:
        ImageView r11 = r7.b;
        if (r11 == null) goto L22;
        r11.setImageResource(2131253175);
        KtvUtilsKt.a(r11, UtilityKotlinExtentionsKt.i(32));
    L22:
        View r12 = r7.c;
        if (r12 == null) goto L49;
        r12.setBackgroundColor(s1.h(2131107728));
        return;
    L49:
        return;
    L25:
        TextView r3 = r7.a;
        if (r3 == null) goto L28;
        r3.setText(2131922577);
    L28:
        ImageView r13 = r7.b;
        if (r13 == null) goto L31;
        r13.setImageResource(2131250386);
        KtvUtilsKt.a(r13, UtilityKotlinExtentionsKt.i(32));
    L31:
        View r14 = r7.c;
        if (r14 == null) goto L51;
        r14.setBackground(new BitmapDrawable(r8));
        return;
    L51:
        return;
    L48:
        return;
    L7:
        r6 = null;
        goto L9
    L35:
        if ((r4 instanceof SoloMvListVh) == false) goto L53;
        List<? extends com.bytedance.android.live.ktv.common.view.adapter.a> r15 = this.a;
        if (r15 == null) goto L39;
        com.bytedance.android.live.ktv.common.view.adapter.a r16 = (com.bytedance.android.live.ktv.common.view.adapter.a) ListProtector.get(r15, r5);
    L41:
        if ((r16 instanceof c) == false) goto L44;
        r1 = r16;
    L44:
        c r17 = (c) r1;
        if (r17 == null) goto L54;
        ((SoloMvListVh) r4).T3(r17, r5, r17.b);
        return;
    L54:
        return;
    L39:
        r16 = null;
        goto L41
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 == g) goto L10;
        if (r5 != 0) goto L7;
        LinearLayout r6 = new LinearLayout(r4.getContext());
        ViewGroup.MarginLayoutParams r7 = new ViewGroup.MarginLayoutParams(c, d);
        int r0 = e;
        r7.leftMargin = r0;
        r7.rightMargin = r0;
        Unit r1 = Unit.INSTANCE;
        r6.setLayoutParams(r7);
        r6.setOrientation(1);
        RecyclerView.ViewHolder r2 = new OfficialMvListVh(r6, this.b);
    L9:
        return r2;
    L7:
        FrameLayout r8 = new FrameLayout(r4.getContext());
        int r3 = PersonalMvListVh.j;
        ViewGroup.MarginLayoutParams r9 = new ViewGroup.MarginLayoutParams(PersonalMvListVh.j, PersonalMvListVh.k);
        int r11 = e;
        r9.leftMargin = r11;
        r9.rightMargin = r11;
        Unit r12 = Unit.INSTANCE;
        r8.setLayoutParams(r9);
        r2 = new PersonalMvListVh(r8, this.b);
        goto L9
    L10:
        return new UploadImgVh(LayoutInflater.from(r4.getContext()).inflate(2131567467, r4, false), this.b);
    }
}
