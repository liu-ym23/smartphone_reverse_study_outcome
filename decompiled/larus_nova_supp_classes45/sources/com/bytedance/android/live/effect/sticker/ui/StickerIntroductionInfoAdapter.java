package com.bytedance.android.live.effect.sticker.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerIntroductionInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/sticker/ui/StickerIntroductionInfoAdapter$StickerIntroductionInfoItemView;", "<init>", "()V", "StickerIntroductionInfoItemView", "StickerIntroductionInfoType", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerIntroductionInfoAdapter extends RecyclerView.Adapter<StickerIntroductionInfoItemView> {
    public final List<Sticker.EffectSubTipInfo> a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerIntroductionInfoAdapter$StickerIntroductionInfoItemView;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StickerIntroductionInfoItemView extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;
        public final TextView b;

        public StickerIntroductionInfoItemView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131376324);
            this.b = (TextView) r2.findViewById(2131390806);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerIntroductionInfoAdapter$StickerIntroductionInfoType;", "", "Normal", "PlaceHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StickerIntroductionInfoType extends Enum<StickerIntroductionInfoType> {
        public static final StickerIntroductionInfoType Normal = null;
        public static final StickerIntroductionInfoType PlaceHolder = null;
        public static final /* synthetic */ StickerIntroductionInfoType[] a = null;

        static {
            StickerIntroductionInfoType r1 = new StickerIntroductionInfoType("Normal", 0);
            Normal = r1;
            StickerIntroductionInfoType r2 = new StickerIntroductionInfoType("PlaceHolder", 1);
            PlaceHolder = r2;
            a = new StickerIntroductionInfoType[]{r1, r2};
        }

        public static StickerIntroductionInfoType valueOf(String r1) {
            return (StickerIntroductionInfoType) r27.a.a(StickerIntroductionInfoType.class, r1);
        }

        public static StickerIntroductionInfoType[] values() {
            return (StickerIntroductionInfoType[]) a.clone();
        }

        public StickerIntroductionInfoType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public StickerIntroductionInfoAdapter() {
        this.a = new ArrayList();
    }

    public final int getItemViewType(int r2) {
        if (((Sticker.EffectSubTipInfo) ListProtector.get(this.a, r2)).getTipImageUrl().length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        StickerIntroductionInfoType r4 = StickerIntroductionInfoType.PlaceHolder;
    L10:
        return r4.ordinal();
    L8:
        r4 = StickerIntroductionInfoType.Normal;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        StickerIntroductionInfoItemView r5 = (StickerIntroductionInfoItemView) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        AbstractDraweeController r0 = Fresco.newDraweeControllerBuilder().setUri(((Sticker.EffectSubTipInfo) ListProtector.get(this.a, r4)).getTipImageUrl()).setAutoPlayAnimations(true).build();
        SimpleDraweeView r1 = r5.a;
        if (r1 == null) goto L5;
        r1.setController(r0);
    L5:
        TextView r6 = r5.b;
        if (r6 == null) goto L9;
        r6.setText(((Sticker.EffectSubTipInfo) ListProtector.get(this.a, r4)).getTip());
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 == StickerIntroductionInfoType.Normal.ordinal()) goto L7;
        View r6 = new View(r4.getContext());
        r6.setLayoutParams(new RecyclerView.LayoutParams(s1.f(90.0f), s1.f(90.0f)));
        Unit r7 = Unit.INSTANCE;
        return new StickerIntroductionInfoItemView(r6);
    L7:
        return new StickerIntroductionInfoItemView(LayoutInflater.from(r4.getContext()).inflate(2131565909, r4, false));
    }
}
