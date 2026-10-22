package com.bytedance.android.live.effect.common;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.MarqueeTextView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerListAdapter$StickerViewHolder;", "", "StickerViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonStickerListAdapter extends RecyclerView.Adapter<StickerViewHolder> {
    public final Lazy a;
    public final Lazy b;
    public final List<Sticker> c;
    public final List<Long> d;
    public long e;
    public boolean f;
    public final LiveEffectContextFactoryDelegate$Type g;
    public final LiveEffectScene h;
    public final String i;
    public final o j;
    public final com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.c k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerListAdapter$StickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StickerViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final ImageView b;
        public final View c;
        public final View d;
        public final View e;
        public final View f;
        public final MarqueeTextView g;
        public final TextView h;

        public StickerViewHolder(View r2) {
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
        return ((ArrayList) this.c).size();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        StickerViewHolder r4 = (StickerViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewAttachedToWindow(r4);
        ((RecyclerView.ViewHolder) r4).itemView.post(new k(this, r4));
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r3) {
        StickerViewHolder r4 = (StickerViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewDetachedFromWindow(r4);
        ((RecyclerView.ViewHolder) r4).itemView.post(new l(this, r4));
    }

    public final void z2(Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        List<Long> r0 = this.d;
        ArrayList r1 = (ArrayList) r0;
        int r2 = r1.indexOf(Long.valueOf(r4.getId()));
        if (r2 < 0) goto L6;
        ListProtector.set(this.c, r2, r4);
        notifyItemChanged(r2, "payload");
        return;
    }

    public static void E2(Sticker r2, StickerViewHolder r3) {
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
    public final void A2(Sticker r6, StickerViewHolder r7) {
        if (this.f == true) goto L16;
        boolean r2 = true;
        if (r6.isAigcSticker() == true) goto L8;
    L17:
        if (r2 == false) goto L24;
        View r8 = r7.a;
        if (r8 == null) goto L21;
        r8.setVisibility(4);
    L21:
        AppCompatTextView r9 = r7.g;
        if (r9 == null) goto L31;
        r9.setTextColor(-1);
        return;
    L31:
        return;
    L24:
        View r11 = r7.a;
        if (r11 == null) goto L27;
        r11.setVisibility(0);
    L27:
        AppCompatTextView r12 = r7.g;
        if (r12 == null) goto L33;
        r12.setTextColor(s1.h(2131107417));
        return;
    L33:
        return;
    L8:
        if ((!((com.bytedance.android.live.effect.sticker.presenter.s) this.b.getValue()).i(r6.getId()).isEmpty()) == true) goto L10;
    L12:
        boolean r13 = false;
    L14:
        if (this.h != LiveEffectScene.Live) goto L17;
        if (r13 == true) goto L17;
    L10:
        if (((com.bytedance.android.live.effect.sticker.presenter.s) this.b.getValue()).g(r6.getId()) == false) goto L12;
        r13 = true;
    L16:
        r2 = false;
        goto L17
    }

    public final void B2(Sticker r5, StickerViewHolder r6) {
        int r1 = 0;
        if (r5.isAigcSticker() == true) goto L5;
    L7:
        View r0 = r6.e;
        if (r0 != null) goto L10;
    L14:
        View r7 = r6.d;
        if (r7 != null) goto L17;
        return;
    L17:
        if (r5.isDownloaded() == false) goto L19;
        r1 = 8;
    L19:
        r7.setVisibility(r1);
        return;
    L10:
        if (r5.isDownloading() == false) goto L12;
        int r3 = 0;
    L13:
        r0.setVisibility(r3);
        goto L14
    L12:
        r3 = 8;
        goto L13
    L5:
        if (((com.bytedance.android.live.effect.sticker.presenter.s) this.b.getValue()).k == true) goto L7;
        r5.setDownloaded(false);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C2(MarqueeTextView r2, boolean r3) {
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

    public final void D2(Sticker r8, StickerViewHolder r9) {
        if (this.e != r8.getId()) goto L5;
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
        C2(r9.g, true);
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
        C2(r9.g, false);
        goto L27
    L23:
        View r5 = r9.c;
        if (r5 == null) goto L26;
        r5.setVisibility(4);
    L26:
        C2(r9.g, false);
        goto L27
    L5:
        r0 = false;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((StickerViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new StickerViewHolder(this.j.a.a(r2.getContext()));
    }

    public final void y2(StickerViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Sticker r7 = (Sticker) ListProtector.get(this.c, r6);
        if ((r5.b instanceof SimpleDraweeView) == false) goto L11;
        PipelineDraweeControllerBuilder r0 = Fresco.newDraweeControllerBuilder();
        UrlModel r2 = r7.getIcon();
        if (r2 == null) goto L9;
        List<String> r3 = r2.getUrlList();
        if (r3 == null) goto L9;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
    L10:
        AbstractDraweeController r1 = r0.setUri(r4).setAutoPlayAnimations(true).build();
        r5.b.setController(r1);
    L16:
        AppCompatTextView r8 = r5.g;
        if (r8 == null) goto L19;
        r8.setText(r7.getName());
    L19:
        A2(r7, r5);
        ((com.bytedance.android.live.effect.api.l) this.a.getValue()).a(r7.getEffect(), true, new m(this, r7, r5));
        D2(r7, r5);
        E2(r7, r5);
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new n(this, r7));
        return;
    L9:
        r4 = null;
        goto L10
    L11:
        UrlModel r9 = r7.getIcon();
        if (r9 == null) goto L16;
        py.k r11 = r9.toImgModel();
        if (r11 == null) goto L16;
        ImageUtil.loadImage(r5.b, r11, 0);
        goto L16
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        StickerViewHolder r5 = (StickerViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.isEmpty() == false) goto L5;
        y2(r5, r3);
        return;
    L5:
        Sticker r6 = (Sticker) ListProtector.get(this.c, r3);
        A2(r6, r5);
        B2(r6, r5);
        D2(r6, r5);
        E2(r6, r5);
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new n(this, r6));
    }

    public LiveCommonStickerListAdapter(LiveEffectContextFactoryDelegate$Type r2, LiveEffectScene r3, String r4, o r5, LiveCommonStickerListView$stickerListAdapterListener$2.a r6) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "tabKey");
        Intrinsics.checkNotNullParameter(r5, "styleConfig");
        Intrinsics.checkNotNullParameter(r6, "liveStickerListAdapterListener");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.a = LazyKt.lazy(new LiveCommonStickerListAdapter$liveStickerDownloadHelper$2(this));
        this.b = LazyKt.lazy(new LiveCommonStickerListAdapter$aigcTaskManager$2(this));
        this.c = new ArrayList();
        this.d = new ArrayList();
    }
}
