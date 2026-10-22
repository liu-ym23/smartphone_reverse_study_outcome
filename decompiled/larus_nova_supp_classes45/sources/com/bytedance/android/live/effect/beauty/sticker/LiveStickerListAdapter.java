package com.bytedance.android.live.effect.beauty.sticker;

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
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.base.RenderTriggerType;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.ui.LiveStickerComposerListAdapterKt;
import com.bytedance.android.live.effect.sticker.ui.MarqueeTextView;
import com.bytedance.android.live.effect.sticker.ui.StickerItemView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;
import com.ss.android.ugc.effectmanager.effect.listener.IUpdateTagListener;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\n\u000bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/sticker/LiveStickerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/sticker/LiveStickerListAdapter$StickerViewHolder;", "Lcom/bytedance/android/live/effect/api/k$f;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "n", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "a", "StickerViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStickerListAdapter extends RecyclerView.Adapter<StickerViewHolder> implements k.f {
    public static final /* synthetic */ int q = 0;
    public long a;
    public final List<Sticker> b;
    public final List<Long> c;
    public LiveStickerComposerListAdapterKt.b d;
    public i e;
    public Sticker f;
    public final List<Long> g;
    public final Map<Long, Long> h;
    public boolean i;
    public final HashSet<Integer> j;
    public boolean k;
    public com.bytedance.android.live.effect.base.e l;
    public final List<Sticker> m;
    public final LiveEffectContextFactoryDelegate$Type n;
    public final k o;
    public final String p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/sticker/LiveStickerListAdapter$StickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StickerViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final View b;
        public final View c;
        public final View d;
        public final View e;
        public final MarqueeTextView f;
        public final TextView g;

        public StickerViewHolder(StickerItemView r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131374931);
            this.b = r2.findViewById(2131385784);
            this.c = r2.findViewById(2131370173);
            this.d = r2.findViewById(2131378977);
            this.e = r2.findViewById(2131370082);
            this.f = (MarqueeTextView) r2.findViewById(2131388772);
            this.g = (TextView) r2.findViewById(2131387347);
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveStickerListAdapter a;
        public final /* synthetic */ StickerViewHolder b;

        public b(LiveStickerListAdapter r1, StickerViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            LiveStickerListAdapter r7 = this.a;
            long r0 = r7.a;
            if (r0 != 0) goto L5;
            return;
        L5:
            r7.a = 0;
            List<Long> r8 = r7.c;
            ArrayList r9 = (ArrayList) r8;
            int r11 = r9.indexOf(Long.valueOf(r0));
            if (r11 < 0) goto L8;
            this.a.notifyItemChanged(r11, 1);
        L8:
            View r12 = this.b.b;
            if (r12 == null) goto L11;
            r12.setVisibility(0);
        L11:
            LiveStickerComposerListAdapterKt.b r13 = this.a.d;
            if (r13 == null) goto L15;
            r13.a(null, null);
            return;
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public final /* synthetic */ LiveStickerListAdapter a;
        public final /* synthetic */ Sticker b;

        public c(LiveStickerListAdapter r1, Sticker r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<Boolean> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            r3.onNext(Boolean.valueOf(this.a.o.q(this.b)));
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
            View r3 = this.b.d;
            if (r3 == null) goto L7;
            r3.setVisibility(8);
        L7:
            View r4 = this.b.c;
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

    public static final class e implements IIsTagNeedUpdatedListener {
        public final /* synthetic */ StickerViewHolder a;

        public final void onTagNeedNotUpdate() {
            View r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.setVisibility(8);
            return;
        }

        public final void onTagNeedUpdate() {
            View r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.setVisibility(0);
            return;
        }

        public e(StickerViewHolder r1) {
            this.a = r1;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ LiveStickerListAdapter a;
        public final /* synthetic */ int b;
        public final /* synthetic */ StickerViewHolder c;

        public static final class a implements IUpdateTagListener {
            public final /* synthetic */ f a;
            public final /* synthetic */ Sticker b;

            /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.sticker.LiveStickerListAdapter$f$a$a, reason: collision with other inner class name */
            public static final class C0186a implements IIsTagNeedUpdatedListener {
                public final /* synthetic */ a a;

                public final void onTagNeedNotUpdate() {
                    View r0 = this.a.a.c.e;
                    if (r0 == null) goto L6;
                    r0.setVisibility(8);
                    return;
                }

                public final void onTagNeedUpdate() {
                    View r0 = this.a.a.c.e;
                    if (r0 == null) goto L6;
                    r0.setVisibility(0);
                    return;
                }

                public C0186a(a r1) {
                    this.a = r1;
                }
            }

            public a(f r1, Sticker r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void onFinally() {
                LiveStickerListAdapter r0 = this.a.a;
                Sticker r1 = this.b;
                C0186a r2 = new C0186a(this);
                int r3 = LiveStickerListAdapter.q;
                r0.z2(r1, r2);
            }
        }

        public f(LiveStickerListAdapter r1, int r2, StickerViewHolder r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            Sticker r11 = (Sticker) ListProtector.get(this.a.b, this.b);
            if (r11 != null) goto L5;
            return;
        L5:
            long r0 = r11.getId();
            LiveStickerListAdapter r2 = this.a;
            if (r0 != r2.a) goto L8;
            return;
        L8:
            r2.o.n(r11.getRealId(), r11.getTagsUpdatedAt(), new a(this, r11));
            if (LiveEffectSettings.LIVE_EFFECT_REPORT_FIRST_FRAME_RENDER_LOG.getValue().booleanValue() == false) goto L11;
            LiveStickerListAdapter r1 = this.a;
            com.bytedance.android.live.effect.base.e r3 = new com.bytedance.android.live.effect.base.e();
            r3.f = System.currentTimeMillis();
            r3.d = RenderTriggerType.SelectByUser;
            Unit r4 = Unit.INSTANCE;
            r1.l = r3;
        L11:
            LiveStickerListAdapter r5 = this.a;
            r5.k = true;
            if (r5.o.q(r11) == false) goto L14;
        L16:
            LiveStickerListAdapter r6 = this.a;
            long r7 = r6.a;
            r6.a = r11.getId();
            List<Long> r8 = this.a.c;
            ArrayList r12 = (ArrayList) r8;
            if (r12.contains(Long.valueOf(r7)) == false) goto L21;
            List<Long> r13 = this.a.c;
            ArrayList r14 = (ArrayList) r13;
            int r15 = r14.indexOf(Long.valueOf(r7));
            if (r15 < 0) goto L21;
            this.a.notifyItemChanged(r15, 1);
        L21:
            LiveStickerListAdapter r16 = this.a;
            StickerViewHolder r17 = this.c;
            if (r16.a == 0) goto L24;
            boolean r18 = true;
        L25:
            r16.B2(r17, r11, r18);
            com.bytedance.android.live.effect.base.e r19 = this.a.l;
            if (r19 == null) goto L28;
            r19.g = System.currentTimeMillis();
            r19.e = true;
            r19.b = r11;
            String r21 = this.a.p;
            Intrinsics.checkNotNullParameter(r21, "<set-?>");
            r19.c = r21;
        L28:
            LiveStickerListAdapter r22 = this.a;
            LiveStickerComposerListAdapterKt.b r23 = r22.d;
            if (r23 == null) goto L33;
            r23.a(r11, r22.l);
            return;
        L33:
            return;
        L24:
            r18 = false;
            goto L25
        L14:
            if (this.a.a == r11.getId()) goto L16;
            this.a.h.put(Long.valueOf(r11.getId()), Long.valueOf(System.currentTimeMillis()));
            LiveStickerListAdapter r24 = this.a;
            r24.f = r11;
            List<Long> r25 = r24.g;
            ArrayList r26 = (ArrayList) r25;
            r26.add(Long.valueOf(r11.getId()));
            LiveStickerListAdapter r27 = this.a;
            r27.o.g(d0.c, r11, r27);
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.n;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        StickerViewHolder r3 = (StickerViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        this.j.remove(Integer.valueOf(r3.getAdapterPosition()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A2(MarqueeTextView r2, boolean r3) {
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

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r8, Sticker r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        r9.setDownloaded(true);
        r9.setStickerPanel(r8);
        Sticker r1 = this.f;
        if (r1 != null) goto L7;
    L22:
        List<Long> r11 = this.g;
        ArrayList r12 = (ArrayList) r11;
        if (r12.contains(Long.valueOf(r9.getId())) == false) goto L30;
        List<Long> r13 = this.c;
        ArrayList r14 = (ArrayList) r13;
        int r15 = r14.indexOf(Long.valueOf(r9.getId()));
        if (r15 >= 0) goto L27;
    L29:
        List<Long> r16 = this.g;
        ArrayList r17 = (ArrayList) r16;
        r17.remove(Long.valueOf(r9.getId()));
        goto L30
    L27:
        if (r15 >= ((ArrayList) this.b).size()) goto L29;
        ListProtector.set(this.b, r15, r9);
    L30:
        List<Long> r18 = this.c;
        ArrayList r19 = (ArrayList) r18;
        int r21 = r19.indexOf(Long.valueOf(r9.getId()));
        if (r21 < 0) goto L34;
        notifyItemChanged(r21, 1);
        return;
    L34:
        return;
    L7:
        if (r1.getId() != r9.getId()) goto L22;
        long r2 = this.a;
        long r3 = r9.getId();
        this.a = r3;
        List<Sticker> r5 = this.b;
        List<Long> r6 = this.c;
        ArrayList r7 = (ArrayList) r6;
        ListProtector.set(r5, r7.indexOf(Long.valueOf(r3)), r9);
        List<Long> r4 = this.c;
        ArrayList r22 = (ArrayList) r4;
        if (r22.contains(Long.valueOf(r2)) == false) goto L13;
        List<Long> r23 = this.c;
        ArrayList r24 = (ArrayList) r23;
        int r25 = r24.indexOf(Long.valueOf(r2));
        if (r25 < 0) goto L13;
        notifyItemChanged(r25, 1);
    L13:
        com.bytedance.android.live.effect.base.e r26 = this.l;
        if (r26 == null) goto L19;
        r26.g = System.currentTimeMillis();
        r26.e = false;
        r26.b = r9;
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r26.c = r8;
    L19:
        LiveStickerComposerListAdapterKt.b r27 = this.d;
        if (r27 == null) goto L22;
        r27.a(r9, this.l);
        goto L22
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r3, Sticker r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        List<Long> r5 = this.c;
        ArrayList r6 = (ArrayList) r5;
        int r7 = r6.indexOf(Long.valueOf(r4.getId()));
        if (r7 < 0) goto L8;
        notifyItemChanged(r7, 1);
        return;
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((StickerViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new StickerViewHolder(new StickerItemView(r5.getContext(), null, 6, 0));
    }

    public final void y2(StickerViewHolder r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        int r0 = 0;
        if (r12 != 0) goto L27;
        AppCompatTextView r13 = r11.f;
        if (r13 == null) goto L7;
        r13.setText("无");
    L7:
        ImageView r14 = r11.a;
        if (r14 == null) goto L10;
        r14.setImageResource(2131250396);
    L10:
        View r15 = r11.d;
        if (r15 == null) goto L13;
        r15.setVisibility(4);
    L13:
        View r16 = r11.c;
        if (r16 == null) goto L16;
        r16.setVisibility(4);
    L16:
        View r17 = r11.e;
        if (r17 == null) goto L19;
        r17.setVisibility(4);
    L19:
        View r18 = r11.b;
        if (r18 != null) goto L22;
    L26:
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new b(this, r11));
        return;
    L22:
        if (this.a == 0) goto L25;
        r0 = 4;
    L25:
        r18.setVisibility(r0);
        goto L26
    L27:
        Sticker r1 = (Sticker) ListProtector.get(this.b, r12);
        if (r1 != null) goto L31;
        return;
    L31:
        if (r1.isDownloaded() == true) goto L33;
        Observable.create(new c(this, r1)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r1, r11));
    L33:
        ImageView r2 = r11.a;
        UrlModel r3 = r1.getIcon();
        if (r3 == null) goto L36;
        py.k r4 = r3.toImgModel();
    L37:
        ImageUtil.loadImage(r2, r4, 0);
        View r5 = r11.d;
        if (r5 != null) goto L40;
    L44:
        View r6 = r11.c;
        if (r6 != null) goto L47;
    L51:
        boolean r7 = true;
        if (this.a != r1.getId()) goto L54;
        boolean r8 = true;
    L55:
        AppCompatTextView r9 = r11.f;
        if (r9 == null) goto L58;
        r9.setText(r1.getName());
    L58:
        B2(r11, r1, r8);
        String r19 = r1.getTopTips();
        if (r19 != null) goto L61;
    L64:
        if (r7 == true) goto L68;
        TextView r21 = r11.g;
        if (r21 == null) goto L71;
        r21.setVisibility(0);
        r11.g.setText(r1.getTopTips());
    L71:
        z2(r1, new e(r11));
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new f(this, r12, r11));
        return;
    L68:
        TextView r22 = r11.g;
        if (r22 == null) goto L71;
        r22.setVisibility(8);
        goto L71
    L61:
        if (r19.length() == 0) goto L64;
        r7 = false;
        goto L64
    L54:
        r8 = false;
        goto L55
    L47:
        if (r1.isDownloaded() == false) goto L49;
        int r23 = 8;
    L50:
        r6.setVisibility(r23);
        goto L51
    L49:
        r23 = 0;
        goto L50
    L40:
        if (r1.isDownloading() == false) goto L42;
        int r24 = 0;
    L43:
        r5.setVisibility(r24);
        goto L44
    L42:
        r24 = 8;
        goto L43
    L36:
        r4 = null;
        goto L37
    }

    public final void z2(Sticker r4, IIsTagNeedUpdatedListener r5) {
        List r0 = r4.getTags();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L17;
        List r2 = r4.getTags();
        if (r2 == null) goto L17;
        if (r2.contains("new") != true) goto L17;
        this.o.b(r4.getRealId(), r4.getTagsUpdatedAt(), r5);
        return;
    L17:
        r5.onTagNeedNotUpdate();
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public LiveStickerListAdapter(LiveEffectContextFactoryDelegate$Type r2, k r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "presenter");
        Intrinsics.checkNotNullParameter(r4, "panel");
        this.n = r2;
        this.o = r3;
        this.p = r4;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.g = new ArrayList();
        this.h = new LinkedHashMap();
        this.j = new HashSet();
        this.m = new ArrayList();
    }

    public final void B2(StickerViewHolder r4, Sticker r5, boolean r6) {
        if (r6 == false) goto L16;
        View r7 = r4.b;
        if (r7 == null) goto L7;
        r7.setVisibility(0);
    L7:
        r5.setDownloaded(true);
        View r2 = r4.c;
        if (r2 == null) goto L11;
        r2.setVisibility(4);
    L11:
        if (r5.getName() == null) goto L15;
        String r8 = r5.getName();
        Intrinsics.checkNotNull(r8);
        if (r8.length() <= 5) goto L15;
        A2(r4.f, true);
        return;
    L15:
        A2(r4.f, false);
        return;
    L16:
        View r9 = r4.b;
        if (r9 == null) goto L19;
        r9.setVisibility(4);
    L19:
        A2(r4.f, false);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8, List r9) {
        StickerViewHolder r11 = (StickerViewHolder) r7;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r9, "payloads");
        boolean r0 = false;
        int r1 = 0;
        if (r9.isEmpty() == false) goto L15;
        y2(r11, r8);
        if (this.j.contains(Integer.valueOf(r8)) == true) goto L51;
        this.j.add(Integer.valueOf(r8));
        Sticker r12 = (Sticker) ListProtector.get(this.b, r8);
        if (r12 != null) goto L10;
        return;
    L10:
        if (this.k == false) goto L12;
        this.k = false;
        return;
    L12:
        i r13 = this.e;
        if (r13 == null) goto L47;
        r13.a(r12, r8 + 1);
        return;
    L47:
        return;
    L51:
        return;
    L15:
        if (r8 != 0) goto L23;
        View r14 = r11.b;
        if (r14 != null) goto L19;
        return;
    L19:
        if (this.a == 0) goto L22;
        r1 = 4;
    L22:
        r14.setVisibility(r1);
        return;
    L23:
        Sticker r15 = (Sticker) ListProtector.get(this.b, r8);
        if (r15 == null) goto L52;
        View r16 = r11.d;
        int r2 = 8;
        if (r16 != null) goto L29;
    L33:
        View r17 = r11.c;
        if (r17 == null) goto L41;
        if (r15.isDownloaded() == true) goto L39;
        r2 = 0;
    L39:
        r17.setVisibility(r2);
    L41:
        if (this.a != r15.getId()) goto L43;
        r0 = true;
    L43:
        B2(r11, r15, r0);
        return;
    L29:
        if (r15.isDownloading() == false) goto L31;
        int r3 = 0;
    L32:
        r16.setVisibility(r3);
        goto L33
    L31:
        r3 = 8;
        goto L32
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r3, Sticker r4, ExceptionResult r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        f2.b(2131916413, 0);
        List<Long> r6 = this.c;
        ArrayList r7 = (ArrayList) r6;
        int r8 = r7.indexOf(Long.valueOf(r4.getId()));
        Sticker r9 = (Sticker) CollectionsKt.getOrNull(this.b, r8);
        if (r9 == null) goto L7;
        r9.setDownloading(false);
    L7:
        if (r8 < 0) goto L9;
        notifyItemChanged(r8, 1);
    L9:
        com.bytedance.android.live.effect.base.e r11 = this.l;
        if (r11 == null) goto L13;
        List<String> r12 = LiveEffectContext.h;
        ((com.bytedance.android.live.effect.api.f) LiveEffectContext.a.a(this.n).f.getValue()).a(r11, "live_take_detail");
        return;
    }
}
