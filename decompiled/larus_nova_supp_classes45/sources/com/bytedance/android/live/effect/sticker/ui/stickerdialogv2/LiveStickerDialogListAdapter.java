package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.MarqueeTextView;
import com.bytedance.android.live.effect.sticker.ui.StickerItemView;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/LiveStickerDialogListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/LiveStickerDialogListAdapter$StickerViewHolder;", "StickerViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStickerDialogListAdapter extends RecyclerView.Adapter<StickerViewHolder> {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final List<Sticker> d;
    public final List<Long> e;
    public long f;
    public final LiveEffectContextFactoryDelegate$Type g;
    public final LiveEffectScene h;
    public final String i;
    public final String j;
    public final WeakReference<RecyclerView> k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/LiveStickerDialogListAdapter$StickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StickerViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final ImageView b;
        public final View c;
        public final View d;
        public final View e;
        public final View f;
        public final MarqueeTextView g;
        public final TextView h;

        public StickerViewHolder(StickerItemView r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131374741);
            this.b = (ImageView) r2.findViewById(2131374931);
            this.c = r2.findViewById(2131385784);
            this.d = r2.findViewById(2131370173);
            this.e = r2.findViewById(2131378977);
            this.f = r2.findViewById(2131370082);
            this.g = (MarqueeTextView) r2.findViewById(2131388772);
            this.h = (TextView) r2.findViewById(2131387347);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.d).size();
    }

    public final StickerDialogUIViewModel z2() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.h;
        r0.getClass();
        return (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r1, StickerDialogUIViewModel.class);
    }

    public final void C2() {
        StickerDialogUIViewModel r0 = z2();
        if (r0 == null) goto L7;
        LiveData<Sticker> r1 = r0.getCurrentSelectStickerData();
        if (r1 == null) goto L7;
        Sticker r2 = (Sticker) r1.getValue();
    L8:
        if (r2 == null) goto L10;
        long r3 = r2.getId();
    L11:
        long r4 = this.f;
        this.f = r3;
        List<Long> r5 = this.e;
        ArrayList r6 = (ArrayList) r5;
        int r7 = r6.indexOf(Long.valueOf(r3));
        if (r2 == null) goto L17;
        if (r7 < 0) goto L17;
        if (r7 >= ((ArrayList) this.d).size()) goto L17;
        ListProtector.set(this.d, r7, r2);
    L17:
        List<Long> r8 = this.e;
        ArrayList r9 = (ArrayList) r8;
        if (r9.contains(Long.valueOf(r4)) == true) goto L20;
    L22:
        List<Long> r11 = this.e;
        ArrayList r12 = (ArrayList) r11;
        if (r12.contains(Long.valueOf(this.f)) == true) goto L25;
        return;
    L25:
        if (r4 == this.f) goto L29;
        notifyItemChanged(r7, "payload");
        return;
    L29:
        return;
    L20:
        if (r4 == this.f) goto L22;
        List<Long> r13 = this.e;
        ArrayList r14 = (ArrayList) r13;
        notifyItemChanged(r14.indexOf(Long.valueOf(r4)), "payload");
        goto L22
    L10:
        r3 = 0;
    L7:
        r2 = null;
        goto L8
    }

    public final void B2(Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        List<Long> r0 = this.e;
        ArrayList r1 = (ArrayList) r0;
        int r2 = r1.indexOf(Long.valueOf(r4.getId()));
        if (r2 < 0) goto L6;
        ListProtector.set(this.d, r2, r4);
        notifyItemChanged(r2, "payload");
        return;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        StickerViewHolder r4 = (StickerViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewAttachedToWindow(r4);
        ((RecyclerView.ViewHolder) r4).itemView.post(new e(this, r4));
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r3) {
        StickerViewHolder r4 = (StickerViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewDetachedFromWindow(r4);
        Sticker r5 = (Sticker) CollectionsKt.getOrNull(this.d, r4.getAdapterPosition());
        if (r5 == null) goto L8;
        StickerDialogUIViewModel r0 = z2();
        if (r0 == null) goto L9;
        r0.onStickerViewDetached(this.i, r5);
        return;
    L9:
        return;
    }

    public final void y2(List<Sticker> r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        StickerDialogUIViewModel r0 = z2();
        if (r0 == null) goto L7;
        LiveData<Sticker> r1 = r0.getCurrentSelectStickerData();
        if (r1 == null) goto L7;
        Sticker r2 = (Sticker) r1.getValue();
    L8:
        if (r2 == null) goto L10;
        long r3 = r2.getId();
    L11:
        this.f = r3;
        ((ArrayList) this.d).clear();
        ArrayList r4 = (ArrayList) this.d;
        r4.addAll(r5);
        ((ArrayList) this.e).clear();
        List<Long> r6 = this.e;
        List<Sticker> r7 = this.d;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = ((ArrayList) r7).iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        r8.add(Long.valueOf(((Sticker) r9.next()).getId()));
        goto L13
    L15:
        ((ArrayList) r6).addAll(r8);
        notifyDataSetChanged();
        return;
    L10:
        r3 = 0;
    L7:
        r2 = null;
        goto L8
    }

    public static void D2(Sticker r4, StickerViewHolder r5) {
        View r0 = r5.e;
        int r1 = 8;
        if (r0 != null) goto L5;
    L9:
        View r6 = r5.d;
        if (r6 != null) goto L12;
        return;
    L12:
        if (r4.isDownloaded() == true) goto L15;
        r1 = 0;
    L15:
        r6.setVisibility(r1);
        return;
    L5:
        if (r4.isDownloading() == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        goto L9
    L7:
        r3 = 8;
        goto L8
    }

    public static void G2(Sticker r2, StickerViewHolder r3) {
        if (r2.getTopTips().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        TextView r1 = r3.h;
        if (r1 == null) goto L14;
        r1.setVisibility(0);
        r3.h.setText(r2.getTopTips());
        return;
    L14:
        return;
    L10:
        TextView r4 = r3.h;
        if (r4 == null) goto L16;
        r4.setVisibility(8);
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void A2(StickerViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        Sticker r11 = (Sticker) ListProtector.get(this.d, r9);
        UrlModel r0 = r11.getIcon();
        if (r0 == null) goto L7;
        py.k r1 = r0.toImgModel();
        if (r1 == null) goto L7;
        ImageUtil.loadImage(r8.b, r1, 0);
    L7:
        AppCompatTextView r2 = r8.g;
        if (r2 == null) goto L11;
        r2.setText(r11.getName());
    L11:
        if (r11.isAigcSticker() == true) goto L13;
        View r3 = r8.a;
        if (r3 == null) goto L40;
        r3.setVisibility(4);
    L40:
        AppCompatTextView r4 = r8.g;
        if (r4 == null) goto L43;
        r4.setTextColor(-1);
    L43:
        ((com.bytedance.android.live.effect.sticker.presenter.o) this.a.getValue()).g(r11, true, new f(this, r11, r8));
        F2(r11, r8);
        G2(r11, r8);
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new g(this, r11));
        return;
    L13:
        if (((com.bytedance.android.live.effect.sticker.presenter.s) this.b.getValue()).k == true) goto L16;
        r11.setDownloaded(false);
    L16:
        if ((!((com.bytedance.android.live.effect.sticker.presenter.s) this.b.getValue()).i(r11.getId()).isEmpty()) == true) goto L18;
    L20:
        boolean r5 = false;
    L22:
        if (d.a[this.h.ordinal()] != 1) goto L43;
        if (r5 == true) goto L31;
        View r6 = r8.a;
        if (r6 == null) goto L28;
        r6.setVisibility(0);
    L28:
        AppCompatTextView r7 = r8.g;
        if (r7 == null) goto L43;
        r7.setTextColor(s1.h(2131107417));
        goto L43
    L31:
        View r12 = r8.a;
        if (r12 == null) goto L34;
        r12.setVisibility(4);
    L34:
        AppCompatTextView r13 = r8.g;
        if (r13 == null) goto L43;
        r13.setTextColor(-1);
        goto L43
    L18:
        if (((com.bytedance.android.live.effect.sticker.presenter.s) this.b.getValue()).g(r11.getId()) == false) goto L20;
        r5 = true;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E2(MarqueeTextView r2, boolean r3) {
        if (r2 == 0) goto L4;
        r2.setMarqueeEnable(r3);
    L4:
        if (r2 == 0) goto L6;
        r2.setSelected(r3);
    L6:
        if (r2 == 0) goto L11;
        if (r3 == false) goto L9;
        TextUtils.TruncateAt r0 = TextUtils.TruncateAt.MARQUEE;
    L10:
        r2.setEllipsize(r0);
        goto L11
    L9:
        r0 = null;
    L11:
        if (r2 == 0) goto L17;
        if (r3 == false) goto L14;
        int r4 = 8388611;
    L15:
        r2.setGravity(r4);
        return;
    L14:
        r4 = 17;
        goto L15
    }

    public final void F2(Sticker r8, StickerViewHolder r9) {
        if (this.f != r8.getId()) goto L5;
        boolean r0 = true;
    L6:
        String r1 = "";
        if (r0 == false) goto L23;
        View r3 = r9.c;
        if (r3 == null) goto L11;
        r3.setVisibility(0);
    L11:
        r8.setDownloaded(true);
        View r4 = r9.d;
        if (r4 == null) goto L15;
        r4.setVisibility(4);
    L15:
        if (r8.getName() == null) goto L22;
        String r2 = r8.getName();
        if (r2 != null) goto L20;
        r2 = "";
    L20:
        if (r2.length() <= 5) goto L22;
        E2(r9.g, true);
    L27:
        ((RecyclerView.ViewHolder) r9).itemView.setFocusable(true);
        ((RecyclerView.ViewHolder) r9).itemView.setImportantForAccessibility(1);
        View r11 = ((RecyclerView.ViewHolder) r9).itemView;
        String r12 = r8.getName();
        if (r12 == null) goto L31;
        r1 = r12;
    L31:
        if (r0 == false) goto L33;
        String r13 = " 已选中";
    L34:
        r11.setContentDescription(r1.concat(r13));
        return;
    L33:
        r13 = " 未选中";
    L22:
        E2(r9.g, false);
        goto L27
    L23:
        View r5 = r9.c;
        if (r5 == null) goto L26;
        r5.setVisibility(4);
    L26:
        E2(r9.g, false);
        goto L27
    L5:
        r0 = false;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        A2((StickerViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new StickerViewHolder(new StickerItemView(r5.getContext(), null, 6, 0));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        StickerViewHolder r5 = (StickerViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.isEmpty() == false) goto L5;
        A2(r5, r3);
        return;
    L5:
        Sticker r6 = (Sticker) ListProtector.get(this.d, r3);
        D2(r6, r5);
        F2(r6, r5);
        G2(r6, r5);
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new g(this, r6));
    }

    public LiveStickerDialogListAdapter(LiveEffectContextFactoryDelegate$Type r2, LiveEffectScene r3, String r4, String r5, WeakReference<RecyclerView> r6) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "tabKey");
        Intrinsics.checkNotNullParameter(r5, "parentTabKey");
        Intrinsics.checkNotNullParameter(r6, "recyclerViewWeakReference");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.a = LazyKt.lazy(new LiveStickerDialogListAdapter$stickerDataManager$2(this));
        this.b = LazyKt.lazy(new LiveStickerDialogListAdapter$aigcTaskManager$2(this));
        this.c = LazyKt.lazy(new LiveStickerDialogListAdapter$stickerPresenter$2(this));
        this.d = new ArrayList();
        this.e = new ArrayList();
    }
}
