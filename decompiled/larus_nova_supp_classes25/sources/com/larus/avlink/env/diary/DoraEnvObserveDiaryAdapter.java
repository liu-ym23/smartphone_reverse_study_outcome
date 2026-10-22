package com.larus.avlink.env.diary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kc8.t;
import kc8.v0;
import kc8.y;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/avlink/env/diary/model/DiaryItem;", "Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryAdapter$DiaryViewHolder;", "onItemClickListener", "Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryAdapter$OnItemClickListener;", "<init>", "(Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryAdapter$OnItemClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "OnItemClickListener", "DiaryViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveDiaryAdapter extends ListAdapter<l98.a, DiaryViewHolder> {
    public final a a;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryAdapter$DiaryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onItemClickListener", "Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryAdapter$OnItemClickListener;", "<init>", "(Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryAdapter;Landroid/view/View;Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryAdapter$OnItemClickListener;)V", "container", "Landroidx/constraintlayout/widget/ConstraintLayout;", "constraintLayout", "kotlin.jvm.PlatformType", "title", "Landroid/widget/TextView;", "tvDay", "tvYearMonth", "tvWeekday", "statusIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "statusText", "topCover", "bottomCover", "blockView", "Lcom/larus/mainbot/api/block/ui/AbsBlockContainerView;", "bind", "", "diaryItem", "Lcom/larus/avlink/env/diary/model/DiaryItem;", "bindBlock", "generateBlockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "bindDateInfo", "bindContentState", "isToday", "", "updateConstraints", "forceTopAlign", "bindEmotionInfo", "bindClickListeners", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class DiaryViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int m = 0;
        public final a a;
        public final ConstraintLayout b;
        public final ConstraintLayout c;
        public final TextView d;
        public final TextView e;
        public final TextView f;
        public final TextView g;
        public final SimpleDraweeView h;
        public final TextView i;
        public final View j;
        public final View k;
        public final hk9.a l;

        public DiaryViewHolder(View r6, a r7) {
            Intrinsics.checkNotNullParameter(r6, "itemView");
            Intrinsics.checkNotNullParameter(r7, "onItemClickListener");
            super(r6);
            this.a = r7;
            ConstraintLayout r8 = r6.findViewById(2131369032);
            this.b = r8;
            ConstraintLayout r0 = r6.findViewById(2131369031);
            this.c = r0;
            this.d = (TextView) r6.findViewById(2131369077);
            this.e = (TextView) r6.findViewById(2131369035);
            this.f = (TextView) r6.findViewById(2131369083);
            this.g = (TextView) r6.findViewById(2131369082);
            this.h = r6.findViewById(2131369057);
            this.i = (TextView) r6.findViewById(2131369058);
            this.j = r6.findViewById(2131369081);
            this.k = r6.findViewById(2131369014);
            int r1 = ra8.a.a;
            hk9.a r2 = ra8.a.a(r6.getContext());
            r2.setId(View.generateViewId());
            r0.addView(r2, new ConstraintLayout.LayoutParams(-1, -2));
            this.l = r2;
            Context r9 = r6.getContext();
            Resources r3 = r9.getResources();
            int r4 = ((WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels - (r9.getResources().getDimensionPixelSize(v19.c.b(2130971208, r9, 2131166786)) * 2)) * 6) / 4;
            ViewGroup.LayoutParams r10 = r8.getLayoutParams();
            r10.height = r4;
            r8.setLayoutParams(r10);
            r8.requestLayout();
        }

        public final void T3(boolean r9, boolean r10) {
            hk9.a r0 = this.l;
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.getId();
            ConstraintSet r2 = new ConstraintSet();
            r2.clone(this.c);
            if (r9 == false) goto L9;
            if (r10 == true) goto L9;
            r2.clear(2131369077, 3);
            r2.connect(2131369077, 4, r1, 3);
            r2.setMargin(2131369077, 4, c7.b(4));
            r2.clear(r1, 3);
            r2.connect(r1, 4, 0, 4);
            r2.constrainHeight(r1, -2);
            r2.setVerticalBias(r1, 1.0f);
            r0.setLayoutFromBottom(true);
        L10:
            r2.applyTo(this.c);
            if (r10 == false) goto L13;
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            return;
        L13:
            if (r9 == false) goto L15;
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            return;
        L15:
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            return;
        L9:
            r2.clear(2131369077, 4);
            r2.connect(2131369077, 3, 0, 3);
            r2.connect(r1, 3, 2131369077, 4);
            r2.setMargin(r1, 3, c7.b(4));
            r2.connect(r1, 4, 0, 4);
            r2.constrainHeight(r1, 0);
            r2.setVerticalBias(r1, 0.0f);
            r0.setLayoutFromBottom(false);
            goto L10
        }
    }

    public interface a {
        void FO(View r1, l98.a r2);

        void Zx(l98.a r1);
    }

    public DoraEnvObserveDiaryAdapter(a r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClickListener");
        super(new DiaryDiffCallback());
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r60, int r61) {
        final DiaryViewHolder r0 = (DiaryViewHolder) r60;
        Intrinsics.checkNotNullParameter(r0, "holder");
        final l98.a r2 = (l98.a) getItem(r61);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "diaryItem");
        int r3 = ia8.d.a;
        boolean r4 = ia8.d.f(r2.c());
        String r5 = r2.c();
        if (r5 == null) goto L7;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L7;
        long r7 = r6.longValue();
    L9:
        if (r7 <= 0) goto L11;
        r0.e.setText(ia8.d.a(r7));
        r0.f.setText(ia8.d.e(r7));
        r0.g.setText(ia8.d.d(r7));
    L12:
        List<Block> r8 = r2.a();
        if (r8 != null) goto L15;
        r8 = CollectionsKt.emptyList();
    L15:
        Message r9 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
        Boolean r14 = Boolean.TRUE;
        kc8.f r13 = new kc8.f(r9, r14, true, false, null, null, 504);
        hk9.a r10 = r0.l;
        final Ref.BooleanRef r11 = new Ref.BooleanRef();
        r11.element = true;
        final Ref.BooleanRef r12 = new Ref.BooleanRef();
        int r15 = y.J;
        y.a r16 = new y.a();
        r16.p = new d();
        r16.q = Boolean.FALSE;
        y r17 = r16.a();
        int r18 = v0.p;
        v0.a r19 = new v0.a();
        int r110 = m0.a;
        r19.b = Integer.valueOf(m0.b(((RecyclerView.ViewHolder) r0).itemView.getContext()) - i5.Z());
        r19.a = r14;
        r19.c = true;
        r19.d = true;
        r19.g = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        i5.m();
        i5.E();
        r19.m = h98.i.a(new e(r11, r12, r0));
        r19.h = new f();
        v0 r20 = r19.a();
        int r21 = kc8.b.y;
        kc8.b.a r22 = new kc8.b.a();
        r22.a = r20;
        r22.n = new t(true);
        r22.b = r17;
        r10.b(kc8.b.class, r22.a());
        int r23 = ra8.a.a;
        ra8.a.d(r0.l, r8, r13, false);
        r0.d.setText(r2.g());
        r0.T3(r4, false);
        l98.b r24 = r2.d();
        TouchInterceptConstraintLayout r25 = null;
        if (r24 == null) goto L18;
        String r26 = r24.b();
    L19:
        if (r26 != null) goto L21;
    L24:
        boolean r27 = true;
    L25:
        if (r27 == false) goto L27;
        r0.h.setVisibility(4);
    L32:
        if (r24 == null) goto L34;
        String r28 = r24.a();
    L35:
        if (r28 != null) goto L37;
    L40:
        boolean r29 = true;
    L41:
        if (r29 == false) goto L43;
        r0.i.setVisibility(8);
    L48:
        ((RecyclerView.ViewHolder) r0).itemView.setOnClickListener(new b(r0, r2));
        ((RecyclerView.ViewHolder) r0).itemView.setOnLongClickListener(new c(r0, r2));
        Object r30 = ((RecyclerView.ViewHolder) r0).itemView;
        if ((r30 instanceof TouchInterceptConstraintLayout) == false) goto L51;
        r25 = (TouchInterceptConstraintLayout) r30;
    L51:
        if (r25 == null) goto L53;
        r25.setInterceptTouchEvents(true);
    L53:
        if (r4 == false) goto L56;
        r0.b.post(new com.larus.avlink.env.diary.a(r0));
        return;
    L56:
        return;
    L43:
        r0.i.setVisibility(0);
        TextView r31 = r0.i;
        if (r24 == null) goto L46;
        String r32 = r24.a();
    L47:
        r31.setText(r32);
        goto L48
    L46:
        r32 = null;
        goto L47
    L37:
        if (r28.length() == 0) goto L40;
        r29 = false;
        goto L41
    L34:
        r28 = null;
        goto L35
    L27:
        r0.h.setVisibility(0);
        SimpleDraweeView r33 = r0.h;
        if (r24 == null) goto L30;
        String r34 = r24.b();
    L31:
        ImageLoaderKt.u(r33, r34, "dora_diary_emotion");
        goto L32
    L30:
        r34 = null;
        goto L31
    L21:
        if (r26.length() == 0) goto L24;
        r27 = false;
        goto L25
    L18:
        r26 = null;
        goto L19
    L11:
        r0.e.setText("");
        r0.f.setText("");
        r0.g.setText("");
    L7:
        r7 = 0;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131563345, r3, false);
        Intrinsics.checkNotNull(r5);
        return new DiaryViewHolder(r5, this.a);
    }
}
