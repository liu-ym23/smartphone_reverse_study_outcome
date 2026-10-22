package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.z;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdk.config.et0;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\t\n\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/LiveStickerComposerListAdapterKt;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/sticker/ui/LiveStickerComposerListAdapterKt$StickerViewHolder;", "Lcom/bytedance/android/live/effect/api/k$f;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "a", "b", "StickerViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStickerComposerListAdapterKt extends RecyclerView.Adapter<StickerViewHolder> implements com.bytedance.android.live.effect.api.k.f {
    public static final /* synthetic */ int b = 0;
    public boolean a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/LiveStickerComposerListAdapterKt$StickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public static final class a {
    }

    public interface b {
        void a(Sticker r1, com.bytedance.android.live.effect.base.e r2);
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public final /* synthetic */ LiveStickerComposerListAdapterKt a;
        public final /* synthetic */ Sticker b;

        public c(LiveStickerComposerListAdapterKt r1, Sticker r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<Boolean> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            if (this.b.isAigcSticker() == false) goto L6;
            LiveStickerComposerListAdapterKt r4 = this.a;
            int r1 = LiveStickerComposerListAdapterKt.b;
            r4.getClass();
            throw null;
        L6:
            this.a.getClass();
            throw null;
        }
    }

    public static final class d implements Observer<Boolean> {
        public final /* synthetic */ Sticker a;
        public final /* synthetic */ StickerViewHolder b;

        public final void onComplete() {
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public final void onNext(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L11;
            this.a.setDownloading(false);
            this.a.setDownloaded(true);
            View r3 = this.b.e;
            if (r3 == null) goto L7;
            r3.setVisibility(8);
        L7:
            View r4 = this.b.d;
            if (r4 == null) goto L12;
            r4.setVisibility(8);
            return;
        L12:
            return;
        }

        public d(Sticker r1, StickerViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ LiveStickerComposerListAdapterKt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Ref.BooleanRef c;
        public final /* synthetic */ Ref.BooleanRef d;

        public e(LiveStickerComposerListAdapterKt r1, int r2, Ref.BooleanRef r3, Ref.BooleanRef r4, StickerViewHolder r5, Sticker r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            if (((Boolean) et0.a.getValue()).booleanValue() == false) goto L5;
        L18:
            this.a.getClass();
            Sticker r8 = (Sticker) ListProtector.get(null, this.b);
            this.a.getClass();
            if (LiveEffectScene.Live == null) goto L21;
        L26:
            r8.getRealId();
            r8.getTagsUpdatedAt();
            throw null;
        L21:
            if (this.c.element == false) goto L26;
            if (this.d.element == true) goto L26;
            f2.b(2131916328, 0);
            return;
        L5:
            if (((k81) ft0.a.getValue()).b() == false) goto L18;
            this.a.getClass();
            if (LiveEffectScene.Live != null) goto L18;
            List<String> r0 = LiveEffectContext.h;
            if ((!LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(d0.d).isEmpty()) == false) goto L18;
            LiveStickerComposerListAdapterKt r1 = this.a;
            Context r9 = r7.getContext();
            r1.getClass();
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_interactive_extension_conflict_popup", MapsKt.mapOf(TuplesKt.to("action_type", "show")), new Object[]{IRoom.class});
            z0.a().getClass();
            x0.d r2 = new x0.d();
            r2.b = r9;
            r2.a = 4;
            r2.l = false;
            r2.c = "请先退出当前互动特效";
            r2.d = "最多可同时使用一种特效/互动特效";
            com.bytedance.android.live.effect.sticker.ui.c r11 = com.bytedance.android.live.effect.sticker.ui.c.a;
            x0.c[] r3 = r2.g;
            x0.c r4 = r3[0];
            if (r4 != null) goto L13;
            r4 = new x0.c();
            r3[0] = r4;
        L13:
            r4.a = "我知道了";
            r4.b = r11;
            x0.c[] r12 = r2.g;
            x0.c r5 = r12[0];
            if (r5 != null) goto L16;
            r5 = new x0.c();
            r12[0] = r5;
        L16:
            r5.c = true;
            x0.b.g(new x0(r2.b, r2));
        }
    }

    static {
    }

    public LiveStickerComposerListAdapterKt() {
        throw null;
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return null;
    }

    public final int getItemCount() {
        throw null;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter((StickerViewHolder) r2, "holder");
        int r3 = LiveStickerSelectDialogFactory.a;
        Intrinsics.checkNotNullParameter(null, "liveEffectScene");
        z.a(null);
        throw null;
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        StickerViewHolder r3 = (StickerViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        if (r3.getAdapterPosition() >= 0) goto L5;
        return;
    L5:
        r3.getAdapterPosition();
        throw null;
    }

    public static void B2(StickerViewHolder r2, Sticker r3) {
        String r0 = r3.getTopTips();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        TextView r4 = r2.h;
        if (r4 == null) goto L17;
        r4.setVisibility(0);
        r2.h.setText(r3.getTopTips());
        return;
    L17:
        return;
    L13:
        TextView r5 = r2.h;
        if (r5 == null) goto L19;
        r5.setVisibility(8);
        return;
    L19:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.live.effect.sticker.ui.LiveStickerComposerListAdapterKt$onDownloadSuccess$1] */
    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(final String r2, final Sticker r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ?? r0 = new LiveStickerComposerListAdapterKt$onDownloadSuccess$1(this, r3, r2);
        if (r3.isAigcSticker() == true) goto L9;
        r0.m755invoke();
        return;
    L9:
        throw null;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r1, Sticker r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.getId();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((StickerViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new StickerViewHolder(new StickerItemView(r5.getContext(), null, 6, 0));
    }

    public final void y2(StickerViewHolder r16, int r17) {
        Intrinsics.checkNotNullParameter(r16, "holder");
        Sticker r6 = (Sticker) ListProtector.get(null, r17);
        if (r6.isDownloaded() == true) goto L5;
        Observable.create(new c(this, r6)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r6, r16));
    L5:
        Ref.BooleanRef r3 = new Ref.BooleanRef();
        boolean r0 = false;
        r3.element = false;
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        r4.element = false;
        boolean r1 = r6.isAigcSticker();
        r3.element = r1;
        if (r1 == true) goto L66;
        View r2 = r16.a;
        if (r2 == null) goto L10;
        r2.setVisibility(4);
    L10:
        AppCompatTextView r5 = r16.g;
        if (r5 == null) goto L13;
        r5.setTextColor(-1);
    L13:
        ImageView r7 = r16.b;
        UrlModel r8 = r6.getIcon();
        if (r8 == null) goto L16;
        py.k r9 = r8.toImgModel();
    L17:
        ImageUtil.loadImage(r7, r9, 0);
        View r11 = r16.e;
        if (r11 != null) goto L20;
    L24:
        View r12 = r16.d;
        if (r12 == null) goto L32;
        if (r6.isDownloaded() == false) goto L29;
        int r13 = 8;
    L30:
        r12.setVisibility(r13);
        goto L32
    L29:
        r13 = 0;
    L32:
        if (0 != r6.getId()) goto L34;
        boolean r14 = true;
    L35:
        AppCompatTextView r15 = r16.g;
        if (r15 == null) goto L38;
        r15.setText(r6.getName());
    L38:
        A2(r16, r6, r14);
        B2(r16, r6);
        List r18 = r6.getTags();
        if (r18 != null) goto L41;
    L42:
        r0 = true;
    L43:
        if (r0 == true) goto L51;
        List r19 = r6.getTags();
        if (r19 == null) goto L51;
        if (r19.contains("new") != true) goto L51;
        r6.getRealId();
        r6.getTagsUpdatedAt();
        throw null;
    L51:
        View r21 = r16.f;
        if (r21 == null) goto L54;
        r21.setVisibility(8);
    L54:
        ((RecyclerView.ViewHolder) r16).itemView.setOnClickListener(new e(this, r17, r3, r4, r16, r6));
        if (LiveEffectSettings.LIVE_ANCHOR_PREVIEW_ENABLE_CAMPAIGN_EFFECT_INSERT.getValue().booleanValue() == true) goto L57;
    L63:
        if (r17 == 0) goto L65;
        return;
    L65:
        throw null;
    L57:
        if (0 <= 0) goto L63;
        if (this.a == true) goto L63;
        this.a = true;
        throw null;
    L41:
        if (r18.isEmpty() == false) goto L43;
    L34:
        r14 = false;
        goto L35
    L20:
        if (r6.isDownloading() == false) goto L22;
        int r110 = 0;
    L23:
        r11.setVisibility(r110);
        goto L24
    L22:
        r110 = 8;
        goto L23
    L16:
        r9 = null;
        goto L17
    L66:
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z2(MarqueeTextView r2, boolean r3) {
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

    public final void A2(StickerViewHolder r5, Sticker r6, boolean r7) {
        if (r7 == false) goto L16;
        View r3 = r5.c;
        if (r3 == null) goto L7;
        r3.setVisibility(0);
    L7:
        r6.setDownloaded(true);
        View r4 = r5.d;
        if (r4 == null) goto L11;
        r4.setVisibility(4);
    L11:
        if (r6.getName() == null) goto L15;
        String r0 = r6.getName();
        Intrinsics.checkNotNull(r0);
        if (r0.length() <= 5) goto L15;
        z2(r5.g, true);
    L20:
        ((RecyclerView.ViewHolder) r5).itemView.setFocusable(true);
        ((RecyclerView.ViewHolder) r5).itemView.setImportantForAccessibility(1);
        View r8 = ((RecyclerView.ViewHolder) r5).itemView;
        String r9 = r6.getName();
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        if (r7 == false) goto L25;
        String r11 = " 已选中";
    L26:
        r8.setContentDescription(r9.concat(r11));
        return;
    L25:
        r11 = " 未选中";
    L15:
        z2(r5.g, false);
        goto L20
    L16:
        View r12 = r5.c;
        if (r12 == null) goto L19;
        r12.setVisibility(4);
    L19:
        z2(r5.g, false);
        goto L20
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8, List r9) {
        StickerViewHolder r11 = (StickerViewHolder) r7;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r9, "payloads");
        if (r9.isEmpty() == false) goto L5;
        y2(r11, r8);
        return;
    L5:
        Sticker r12 = (Sticker) ListProtector.get(null, r8);
        View r13 = r11.e;
        int r0 = 8;
        boolean r1 = false;
        if (r13 != null) goto L8;
    L12:
        View r14 = r11.d;
        if (r14 == null) goto L20;
        if (r12.isDownloaded() == true) goto L18;
        r0 = 0;
    L18:
        r14.setVisibility(r0);
    L20:
        if (0 != r12.getId()) goto L22;
        r1 = true;
    L22:
        A2(r11, r12, r1);
        com.bytedance.android.live.effect.sticker.k.k.getClass();
        if (LiveEffectSettings.LIVE_ENABLE_MULTI_ANCHOR_EFFECT_SHARE.getValue().booleanValue() == false) goto L27;
        B2(r11, r12);
        return;
    L27:
        return;
    L8:
        if (r12.isDownloading() == false) goto L10;
        int r2 = 0;
    L11:
        r13.setVisibility(r2);
        goto L12
    L10:
        r2 = 8;
        goto L11
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r1, Sticker r2, ExceptionResult r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        f2.b(2131916413, 0);
        r2.getId();
        throw null;
    }
}
