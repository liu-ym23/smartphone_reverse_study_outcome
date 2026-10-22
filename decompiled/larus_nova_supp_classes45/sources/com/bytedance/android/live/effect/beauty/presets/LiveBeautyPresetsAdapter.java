package com.bytedance.android.live.effect.beauty.presets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsAdapter$PresetsItemViewHolder;", "a", "PresetsItemViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautyPresetsAdapter extends RecyclerView.Adapter<PresetsItemViewHolder> {
    public List<BeautifyPreset> a;
    public a b;
    public boolean c;
    public final LiveBeautyPresetsHelper d;
    public final boolean e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsAdapter$PresetsItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PresetsItemViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final View b;
        public final ImageView c;
        public final ImageView d;
        public final View e;

        public PresetsItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131382884);
            this.b = r2.findViewById(2131363806);
            this.c = (ImageView) r2.findViewById(2131368790);
            this.d = (ImageView) r2.findViewById(2131384275);
            this.e = r2.findViewById(2131385784);
        }
    }

    public interface a {
        void a(BeautifyPreset r1);

        void b(BeautifyPreset r1);

        void c(BeautifyPreset r1);
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveBeautyPresetsAdapter a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ BeautifyPreset c;

        public b(LiveBeautyPresetsAdapter r1, Map r2, BeautifyPreset r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LiveBeautyPresetsAdapter r5 = this.a;
            if (r5.c == false) goto L6;
            r5.B2(false);
            return;
        L6:
            if ((!this.b.isEmpty()) == false) goto L15;
            ALogger.i("LiveBeautyPresetsTrace", "click repel item, presetId = " + this.c.getPresetId());
            if (this.b.values().contains("livedigitavatar") == false) goto L11;
            f2.b(2131916360, 0);
            return;
        L11:
            if (this.b.values().contains(d0.c) == false) goto L22;
            f2.b(2131916432, 0);
            return;
        L22:
            return;
        L15:
            if ((!Intrinsics.areEqual(this.a.d.j(), this.c.getPresetId())) == false) goto L19;
            a r6 = this.a.b;
            if (r6 == null) goto L24;
            r6.c(this.c);
            return;
        L24:
            return;
        L19:
            ALogger.i("LiveBeautyPresetsTrace", "click same item, presetId = " + this.c.getPresetId());
        }
    }

    public static final class c implements View.OnLongClickListener {
        public final /* synthetic */ LiveBeautyPresetsAdapter a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ BeautifyPreset c;

        public c(LiveBeautyPresetsAdapter r1, Map r2, BeautifyPreset r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r4) {
            if ((!this.b.isEmpty()) == false) goto L10;
            ALogger.i("LiveBeautyPresetsTrace", "click repel item, presetId = " + this.c.getPresetId());
            if (this.b.values().contains("livedigitavatar") == false) goto L8;
            f2.b(2131916360, 0);
        L11:
            return true;
        L8:
            if (this.b.values().contains(d0.c) == false) goto L11;
            f2.b(2131916432, 0);
            goto L11
        L10:
            this.a.B2(true);
            goto L11
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ LiveBeautyPresetsAdapter a;
        public final /* synthetic */ BeautifyPreset b;

        public d(LiveBeautyPresetsAdapter r1, BeautifyPreset r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            a r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.b(this.b);
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ LiveBeautyPresetsAdapter a;
        public final /* synthetic */ BeautifyPreset b;

        public e(LiveBeautyPresetsAdapter r1, BeautifyPreset r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            a r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.a(this.b);
            return;
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final void B2(boolean r3) {
        if (this.c == r3) goto L6;
        this.c = r3;
        notifyItemRangeChanged(0, this.a.size(), PresetOperationType.EDIT_MODE);
        return;
    }

    public LiveBeautyPresetsAdapter(LiveBeautyPresetsHelper r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "helper");
        this.d = r2;
        this.e = r3;
        this.a = CollectionsKt.emptyList();
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        z2((PresetsItemViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        LayoutInflater r5 = LayoutInflater.from(r3.getContext());
        if (this.e == false) goto L5;
        int r0 = 2131565890;
    L7:
        return new PresetsItemViewHolder(r5.inflate(r0, r3, false));
    L5:
        r0 = 2131565889;
        goto L7
    }

    public final void y2(PresetsItemViewHolder r2, int r3) {
        if (Intrinsics.areEqual(((BeautifyPreset) ListProtector.get(this.a, r3)).getPresetId(), this.d.j()) == false) goto L5;
        r2.e.setVisibility(0);
        return;
    L5:
        r2.e.setVisibility(8);
    }

    public final void z2(PresetsItemViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        if (r7 >= 0) goto L5;
    L25:
        ALogger.e("LiveBeautyPresetsTrace", "Invalid position " + r7 + " with presets size " + this.a.size());
        return;
    L5:
        if (r7 >= this.a.size()) goto L25;
        BeautifyPreset r8 = (BeautifyPreset) ListProtector.get(this.a, r7);
        r6.a.setText(r8.getPresetName());
        ImageView r0 = r6.c;
        int r2 = 0;
        if (this.c == false) goto L10;
        int r1 = 0;
    L11:
        r0.setVisibility(r1);
        ImageView r3 = r6.d;
        if (this.c == false) goto L14;
        int r4 = 0;
    L15:
        r3.setVisibility(r4);
        View r5 = r6.e;
        if (Intrinsics.areEqual(this.d.j(), r8.getPresetId()) == true) goto L19;
        r2 = 8;
    L19:
        r5.setVisibility(r2);
        Map<Long, String> r9 = this.d.h(r8);
        if ((!r9.isEmpty()) == false) goto L22;
        ((RecyclerView.ViewHolder) r6).itemView.setAlpha(0.5f);
    L23:
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new b(this, r9, r8));
        ((RecyclerView.ViewHolder) r6).itemView.setOnLongClickListener(new c(this, r9, r8));
        r6.c.setOnClickListener(new d(this, r8));
        r6.d.setOnClickListener(new e(this, r8));
        return;
    L22:
        ((RecyclerView.ViewHolder) r6).itemView.setAlpha(1.0f);
        goto L23
    L14:
        r4 = 8;
        goto L15
    L10:
        r1 = 8;
        goto L11
    }

    public final void A2(List<BeautifyPreset> r2, PresetOperationType r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r2;     // Catch: Throwable -> L20
        int r5 = com.bytedance.android.live.effect.beauty.presets.c.a[r3.ordinal()];     // Catch: Throwable -> L20
        if (r5 != 1) goto L6;
        notifyDataSetChanged();     // Catch: Throwable -> L20
    L23:
        return;
    L6:
        if (r5 != 2) goto L8;
        notifyItemInserted(r4);     // Catch: Throwable -> L20
        notifyItemRangeChanged(0, this.a.size(), PresetOperationType.ADD_PRESET);     // Catch: Throwable -> L20
        goto L23
    L8:
        if (r5 != 3) goto L10;
        notifyItemRemoved(r4);     // Catch: Throwable -> L20
        goto L23
    L10:
        if (r5 != 4) goto L12;
        notifyItemChanged(r4);     // Catch: Throwable -> L20
        goto L23
    L12:
        if (r5 != 5) goto L23;
        notifyItemRangeChanged(0, this.a.size(), PresetOperationType.SELECT_PRESET);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "LiveBeautyPresetsAdapter#setData ", th);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6, List r7) {
        PresetsItemViewHolder r8 = (PresetsItemViewHolder) r5;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r7, "payloads");
        if (r7.isEmpty() == false) goto L5;
        z2(r8, r6);
        return;
    L5:
        Iterator r9 = r7.iterator();
    L7:
        if (r9.hasNext() == false) goto L33;
        Object r0 = r9.next();
        if ((r0 instanceof PresetOperationType) == false) goto L7;
        switch(com.bytedance.android.live.effect.beauty.presets.c.b[((PresetOperationType) r0).ordinal()]) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L22;
            case 6: goto L13;
            default: goto L7;
        };
    L13:
        ImageView r1 = r8.c;
        int r2 = 0;
        if (this.c == false) goto L16;
        int r3 = 0;
    L17:
        r1.setVisibility(r3);
        ImageView r4 = r8.d;
        if (this.c == true) goto L21;
        r2 = 8;
    L21:
        r4.setVisibility(r2);
        y2(r8, r6);
        goto L7
    L16:
        r3 = 8;
        goto L17
    L22:
        y2(r8, r6);
        goto L7
    }
}
