package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.PanelStickyHeaderDecoration;
import com.larus.bmhome.chat.component.bottom.core.inputtext.m1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.o1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import com.larus.bmhome.input.api.officemention.OfficeMentionService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MentionPanelListView {
    public static final /* synthetic */ int v = 0;
    public final Context a;
    public final Function1<Boolean, Unit> b;
    public final LayoutInflater c;
    public final PanelAdapter d;
    public final int e;
    public Function0<Unit> f;
    public int g;
    public Integer h;
    public int i;
    public List<? extends y> j;
    public List<? extends y> k;
    public String l;
    public boolean m;
    public boolean n;
    public int o;
    public f p;
    public int q;
    public Function1<? super String, ? extends gc8.c> r;
    public final Interpolator s;
    public final int t;
    public final RecyclerView u;

    public final class PanelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public List<? extends y> a;
        public String b;
        public boolean c;
        public final /* synthetic */ MentionPanelListView d;

        public final int getItemCount() {
            return this.a.size();
        }

        public PanelAdapter(MentionPanelListView r1) {
            this.d = r1;
            this.a = CollectionsKt.emptyList();
            this.b = "";
            this.c = true;
        }

        public final int getItemViewType(int r2) {
            y r3 = (y) ListProtector.get(this.a, r2);
            if ((r3 instanceof y.a) == false) goto L6;
            return 0;
        L6:
            if ((r3 instanceof y.d) == false) goto L9;
            return 1;
        L9:
            if ((r3 instanceof y.c) == false) goto L12;
            return 3;
        L12:
            if (Intrinsics.areEqual(r3, y.b.a) == false) goto L16;
            return 2;
        L16:
            throw new NoWhenBranchMatchedException();
        }

        public final void onViewRecycled(RecyclerView.ViewHolder r4) {
            Intrinsics.checkNotNullParameter(r4, "holder");
            if ((r4 instanceof c) == false) goto L5;
            c r0 = (c) r4;
        L6:
            if (r0 == null) goto L10;
            d r1 = r0.a;
            if (r1 == null) goto L10;
            OfficeMentionService.b.h(r1.b);
            r1.g = false;
        L10:
            ExposeXTrackerExtKt.e(r4.itemView);
            super.onViewRecycled(r4);
            return;
        L5:
            r0 = null;
            goto L6
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r18, int r19) {
            Intrinsics.checkNotNullParameter(r18, "holder");
            View r2 = r18.itemView;
            r2.animate().cancel();
            float r3 = 0.0f;
            r2.setTranslationY(0.0f);
            y r4 = (y) ListProtector.get(this.a, r19);
            if ((r4 instanceof y.a) == false) goto L13;
            View r1 = r18.itemView;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.TextView");
            TextView r5 = (TextView) r1;
            r5.setText(((y.a) r4).a);
            if (this.c == false) goto L7;
            r3 = 1.0f;
        L7:
            r5.setAlpha(r3);
            if (this.c == false) goto L10;
            int r6 = 0;
        L11:
            r5.setImportantForAccessibility(r6);
            return;
        L10:
            r6 = 2;
            goto L11
        L13:
            if ((r4 instanceof y.d) == false) goto L217;
            MentionPanelListView r7 = this.d;
            d r8 = ((c) r18).a;
            final y.d r9 = (y.d) r4;
            String r10 = this.b;
            int r11 = MentionPanelListView.v;
            r7.getClass();
            View r12 = r8.a;
            final String r13 = r9.p;
            final Function0<Unit> r14 = r9.q;
            ExposeXTrackerExtKt.e(r12);
            if (r13 == null) goto L19;
            if (r14 == null) goto L19;
            ExposeXTrackerExtKt.b(r12, new b0(r14, r13));
        L19:
            r8.a.setOnClickListener(new z(r9));
            t1 r15 = r9.f;
            if (r15 == null) goto L22;
            o1.a(r8.e, r9.a, r15.b);
            o1.a(r8.f, r9.e, r15.c);
        L26:
            TextView r16 = r8.f;
            if ((!StringsKt.isBlank(r9.e)) == false) goto L29;
            int r17 = 0;
        L30:
            r16.setVisibility(r17);
            String r20 = r9.j;
            if (r20 != null) goto L33;
        L36:
            boolean r21 = true;
        L37:
            boolean r22 = !r21;
            com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r23 = r9.k;
            if (r23 != null) goto L40;
        L48:
            boolean r24 = false;
        L49:
            String r110 = r9.n;
            if (r110 != null) goto L52;
        L55:
            boolean r111 = true;
        L56:
            if (r111 == true) goto L66;
            String r112 = r9.o;
            if (r112 != null) goto L60;
        L63:
            boolean r113 = true;
        L64:
            if (r113 == true) goto L66;
            boolean r114 = true;
        L67:
            com.larus.bmhome.chat.referenceicon.b r115 = r9.l;
            if (r115 == null) goto L70;
            Integer r116 = r115.b;
        L71:
            if (r115 == null) goto L75;
            List<String> r117 = r115.a;
            if (r117 == null) goto L75;
            String r118 = (String) CollectionsKt.firstOrNull(r117);
        L76:
            String r119 = r9.m;
            if (r119 == null) goto L81;
            Function1<? super String, ? extends gc8.c> r120 = r7.r;
            if (r120 == null) goto L81;
            gc8.c r121 = (gc8.c) r120.invoke(r119);
        L83:
            if (r9.m == null) goto L85;
            boolean r122 = true;
        L86:
            if (r114 == false) goto L96;
            if (r116 != null) goto L96;
            if (r118 != null) goto L96;
            if (r24 == true) goto L96;
            if (r22 == true) goto L96;
            if ((r121 instanceof gc8.c.a) == true) goto L96;
            if ((r121 instanceof gc8.c.b) == true) goto L96;
            boolean r25 = true;
        L97:
            if (r25 == true) goto L99;
        L101:
            boolean r26 = false;
        L103:
            if (r26 == true) goto L105;
            OfficeMentionService.b.h(r8.b);
            ImageLoaderKt.u(r8.b, null, "mention_panel_icon");
        L105:
            r8.g = r25;
            r8.b.getHierarchy().setRoundingParams(new RoundingParams());
            GenericDraweeHierarchy r0 = r8.b.getHierarchy();
            ScalingUtils.ScaleType r27 = ScalingUtils.ScaleType.CENTER_INSIDE;
            r0.setActualImageScaleType(r27);
            SimpleDraweeView r28 = r8.b;
            if (r114 == true) goto L110;
            if (r122 == true) goto L110;
            boolean r123 = false;
        L111:
            r28.setClipToOutline(r123);
            View r29 = r8.d;
            if (r114 == false) goto L114;
        L117:
            boolean r124 = true;
        L118:
            if (r124 == false) goto L120;
            int r125 = 0;
        L121:
            r29.setVisibility(r125);
            r8.c.setText(r9.i);
            TextView r30 = r8.c;
            if (r116 != null) goto L130;
            if (r118 != null) goto L130;
            if (r22 == true) goto L130;
            if (r24 == true) goto L130;
            if (r114 == true) goto L130;
            if (r9.i == null) goto L130;
            boolean r126 = true;
        L131:
            if (r126 == false) goto L133;
            int r127 = 0;
        L134:
            r30.setVisibility(r127);
            SimpleDraweeView r31 = r8.b;
            if (r8.c.getVisibility() != 0) goto L137;
            boolean r128 = true;
        L139:
            if ((!r128) == false) goto L141;
            int r129 = 0;
        L142:
            r31.setVisibility(r129);
            if (r116 == null) goto L146;
            r8.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            r8.b.setImageTintList(null);
            r8.b.setActualImageResource(r116.intValue());
            Unit r32 = Unit.INSTANCE;
        L229:
            return;
        L146:
            if (r118 == null) goto L148;
            r8.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            r8.b.setImageTintList(null);
            r8.b.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            r8.b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(c7.b(6)));
            ImageLoaderKt.u(r8.b, r118, "mention_attachment_thumbnail");
            Unit r33 = Unit.INSTANCE;
            goto L229
        L148:
            if (r24 == false) goto L168;
            r8.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            r8.b.setImageTintList(null);
            ImageLoaderKt.e(r8.b);
            if (r23 == null) goto L229;
            Integer r34 = Integer.valueOf(r23.b);
            if (r34.intValue() == 0) goto L154;
            boolean r35 = true;
        L155:
            if (r35 == false) goto L157;
            Integer r130 = r34;
        L158:
            if (r130 != null) goto L161;
            r130 = OfficeMentionService.b.m(r23.d);
        L161:
            if (r130 != null) goto L163;
        L165:
            FLogger.a.i("MentionPanelListView", "[ReferenceIconTrace] path=mention_panel stage=load_document_icon overload=url");
            OfficeMentionService.b.e(r8.b, r23.d);
        L166:
            Unit r36 = Unit.INSTANCE;
            goto L229
        L163:
            if (r130.intValue() == 0) goto L165;
            MessageReferenceIconStore r37 = MessageReferenceIconStore.a;
            MessageReferenceIconStore.j(r23.d, r130.intValue());
            FLogger.a.i("MentionPanelListView", "[ReferenceIconTrace] path=mention_panel stage=load_document_icon overload=obj_type objType=" + r130);
            OfficeMentionService.b.l(r8.b, r130.intValue());
            goto L166
        L157:
            r130 = null;
            goto L158
        L154:
            r35 = false;
            goto L155
        L168:
            if ((r121 instanceof gc8.c.a) == false) goto L171;
            r8.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            r8.b.setImageTintList(null);
            r8.b.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            ImageLoaderKt.e(r8.b);
            r8.b.setActualImageResource(((gc8.c.a) r121).a);
            Unit r38 = Unit.INSTANCE;
            goto L229
        L171:
            if ((r121 instanceof gc8.c.b) == false) goto L173;
            r8.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            r8.b.setImageTintList(null);
            r8.b.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            ImageLoaderKt.u(r8.b, ((gc8.c.b) r121).a, "mention_panel_conversation_icon");
            Unit r39 = Unit.INSTANCE;
            goto L229
        L173:
            if (r22 == false) goto L182;
            SimpleDraweeView r40 = r8.b;
            if (r122 == false) goto L177;
            ImageView.ScaleType r41 = ImageView.ScaleType.CENTER_CROP;
        L178:
            r40.setScaleType(r41);
            r8.b.setImageTintList(null);
            GenericDraweeHierarchy r42 = r8.b.getHierarchy();
            if (r122 == false) goto L181;
            r27 = ScalingUtils.ScaleType.CENTER_CROP;
        L181:
            r42.setActualImageScaleType(r27);
            ImageLoaderKt.u(r8.b, r9.j, "mention_panel_icon");
            Unit r43 = Unit.INSTANCE;
            goto L229
        L177:
            r41 = ImageView.ScaleType.CENTER_INSIDE;
            goto L178
        L182:
            if (r114 == false) goto L195;
            r8.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            r8.b.setImageTintList(null);
            if (r26 == true) goto L186;
            ImageLoaderKt.e(r8.b);
        L186:
            OfficeMentionService r44 = OfficeMentionService.b;
            SimpleDraweeView r45 = r8.b;
            String r46 = r9.n;
            String r47 = "";
            if (r46 != null) goto L189;
            r46 = "";
        L189:
            String r48 = r9.o;
            if (r48 == null) goto L193;
            r47 = r48;
        L193:
            r44.f(r45, r46, r47);
            Unit r49 = Unit.INSTANCE;
            goto L229
        L195:
            if (Intrinsics.areEqual(r9.b.a, MemoryActionTag.MEMORY_ACTION_TAG_ADD) == false) goto L200;
            if (r9.g == null) goto L200;
            r8.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageLoaderKt.e(r8.b);
            r8.b.setImageResource(r9.g.intValue());
            SimpleDraweeView r50 = r8.b;
            Context r51 = r7.a;
            r50.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r51, v19.c.b(2130972079, r51, 2131103136))));
            Unit r52 = Unit.INSTANCE;
        L200:
            if (r9.h != null) goto L202;
        L204:
            r8.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageLoaderKt.e(r8.b);
            Integer r53 = r9.g;
            if (r53 == null) goto L207;
            r8.b.setActualImageResource(r53.intValue());
        L207:
            SimpleDraweeView r54 = r8.b;
            Integer r55 = r9.g;
            if (r55 != null) goto L211;
        L213:
            ColorStateList r131 = null;
        L214:
            r54.setImageTintList(r131);
            Unit r56 = Unit.INSTANCE;
            goto L229
        L211:
            if (r55.intValue() != 2131241523) goto L213;
            r131 = ContextCompat.getColorStateList(r7.a, R.color.holo_blue_light);
            goto L214
        L202:
            if (r9.g == null) goto L204;
            r8.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageLoaderKt.e(r8.b);
            r8.b.setImageResource(r9.g.intValue());
            r8.b.setImageTintList(ColorStateList.valueOf(r9.h.a));
            Unit r57 = Unit.INSTANCE;
            goto L229
        L141:
            r129 = 8;
            goto L142
        L137:
            r128 = false;
            goto L139
        L133:
            r127 = 8;
        L130:
            r126 = false;
            goto L131
        L120:
            r125 = 8;
            goto L121
        L114:
            if (r9.i != null) goto L117;
            r124 = false;
        L110:
            r123 = true;
            goto L111
        L99:
            if (r8.g == false) goto L101;
            r26 = true;
        L96:
            r25 = false;
            goto L97
        L85:
            r122 = false;
        L81:
            r121 = null;
        L75:
            r118 = null;
            goto L76
        L70:
            r116 = null;
            goto L71
        L60:
            if (StringsKt.isBlank(r112) == true) goto L63;
            r113 = false;
        L66:
            r114 = false;
            goto L67
        L52:
            if (StringsKt.isBlank(r110) == true) goto L55;
            r111 = false;
            goto L56
        L40:
            if (r23.b == 0) goto L42;
        L45:
            boolean r58 = true;
        L46:
            if (r58 != true) goto L48;
            r24 = true;
            goto L49
        L42:
            if ((!StringsKt.isBlank(r23.d)) == true) goto L45;
            r58 = false;
            goto L46
        L33:
            if (StringsKt.isBlank(r20) == true) goto L36;
            r21 = false;
            goto L37
        L29:
            r17 = 8;
            goto L30
        L22:
            TextView r59 = r8.e;
            String r60 = r9.a;
            List<String> r61 = r9.d;
            if (r61 != null) goto L25;
            r61 = CollectionsKt.listOf(r10);
        L25:
            o1.b(r59, r60, r61);
            r8.f.setText(r9.e);
            goto L26
        L217:
            if ((r4 instanceof y.c) == false) goto L225;
            MentionPanelListView r62 = this.d;
            View r63 = r18.itemView;
            Intrinsics.checkNotNull(r63, "null cannot be cast to non-null type android.widget.TextView");
            TextView r64 = (TextView) r63;
            final y.c r65 = (y.c) r4;
            int r66 = MentionPanelListView.v;
            r62.getClass();
            final String r67 = r65.b;
            final Function0<Unit> r68 = r65.c;
            ExposeXTrackerExtKt.e(r64);
            if (r67 == null) goto L223;
            if (r68 == null) goto L223;
            ExposeXTrackerExtKt.b(r64, new b0(r68, r67));
        L223:
            r64.setOnClickListener(new a0(r65));
            return;
        L225:
            if (Intrinsics.areEqual(r4, y.b.a) == false) goto L228;
            return;
        L228:
            throw new NoWhenBranchMatchedException();
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r12, int r13) {
            Intrinsics.checkNotNullParameter(r12, "parent");
            if (r13 != 0) goto L5;
            MentionPanelListView r0 = this.d;
            int r1 = MentionPanelListView.v;
            return new e(r0.i(r12));
        L5:
            if (r13 == 2) goto L15;
            if (r13 == 3) goto L9;
            MentionPanelListView r2 = this.d;
            View r5 = r2.c.inflate(2131562606, r12, false);
            SimpleDraweeView r6 = r5.findViewById(2131381888);
            r6.setOutlineProvider(new d0());
            View r8 = r5.findViewById(2131381889);
            GradientDrawable r14 = new GradientDrawable();
            r14.setShape(1);
            r14.setColor(ContextCompat.getColor(r8.getContext(), R.color.transparent));
            int r3 = c7.b(1);
            Context r4 = r2.a;
            r14.setStroke(r3, ContextCompat.getColor(r4, v19.c.b(2130972086, r4, 2131103159)));
            r8.setBackground(r14);
            Intrinsics.checkNotNull(r5);
            Intrinsics.checkNotNull(r6);
            TextView r7 = (TextView) r5.findViewById(2131381891);
            Intrinsics.checkNotNull(r8);
            return new c(new d(r5, r6, r7, r8, (TextView) r5.findViewById(2131381892), (TextView) r5.findViewById(2131381887)));
        L9:
            View r15 = this.d.c.inflate(2131562605, r12, false);
            Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type android.widget.TextView");
            return new e((TextView) r15);
        L15:
            return new b(m1.a(this.d.c, r12));
        }

        public final void y2(final List<? extends y> r4, String r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "newItems");
            Intrinsics.checkNotNullParameter(r5, "newHighlightKeyword");
            final List<? extends y> r0 = this.a;
            if (Intrinsics.areEqual(this.b, r5) == true) goto L5;
        L8:
            final boolean r1 = true;
        L9:
            DiffUtil.DiffResult r2 = DiffUtil.calculateDiff(new MentionPanelListView$PanelAdapter$submitItems$diff$1(r0, r4, r1));
            this.a = r4;
            this.b = r5;
            this.c = r6;
            r2.dispatchUpdatesTo(this);
            return;
        L5:
            if (this.c != r6) goto L8;
            r1 = false;
            goto L9
        }
    }

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {
        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final d a;

        public c(d r2) {
            Intrinsics.checkNotNullParameter(r2, "views");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class d {
        public final View a;
        public final SimpleDraweeView b;
        public final TextView c;
        public final View d;
        public final TextView e;
        public final TextView f;
        public boolean g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            if (this.g == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "RowViews(root=" + this.a + ", icon=" + this.b + ", iconText=" + this.c + ", iconBorder=" + this.d + ", title=" + this.e + ", description=" + this.f + ", usesOfficeAvatar=" + this.g + ')';
        }

        public d(View r2, SimpleDraweeView r3, TextView r4, View r5, TextView r6, TextView r7) {
            Intrinsics.checkNotNullParameter(r2, "root");
            Intrinsics.checkNotNullParameter(r3, "icon");
            Intrinsics.checkNotNullParameter(r4, "iconText");
            Intrinsics.checkNotNullParameter(r5, "iconBorder");
            Intrinsics.checkNotNullParameter(r6, "title");
            Intrinsics.checkNotNullParameter(r7, "description");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = false;
        }
    }

    public static final class e extends RecyclerView.ViewHolder {
        public e(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class f {
        public final g0 a;
        public final int b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "VisibleRowAnchor(key=" + this.a + ", offsetFromListTopPx=" + this.b + ", sectionHeaderAtTop=" + this.c + ')';
        }

        public f(g0 r2, int r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class g implements View.OnLayoutChangeListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ MentionPanelListView b;
        public final /* synthetic */ LinearLayoutManager c;
        public final /* synthetic */ Integer d;
        public final /* synthetic */ f e;

        public g(int r1, MentionPanelListView r2, LinearLayoutManager r3, Integer r4, f r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            if (this.a != this.b.o) goto L12;
            View r10 = this.c.findViewByPosition(this.d.intValue());
            if (r10 != null) goto L7;
            this.b.p = null;
            this.c.scrollToPositionWithOffset(0, 0);
            return;
        L7:
            int r11 = this.b.u.getPaddingTop() + this.e.b;
            int r12 = RangesKt.coerceAtLeast(this.c.getDecoratedTop(r10) - r11, 0);
            if (r12 <= 0) goto L10;
            this.b.j(r12);
            this.c.scrollToPositionWithOffset(this.d.intValue(), this.e.b);
            MentionPanelListView r13 = this.b;
            r13.u.addOnLayoutChangeListener(new h(r13, this.a, this.d, this.e, this.c));
            return;
        L10:
            MentionPanelListView.a(this.b, this.a, this.d.intValue(), this.e.b, this.c);
            return;
        }
    }

    public static final class h implements View.OnLayoutChangeListener {
        public final /* synthetic */ MentionPanelListView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Integer c;
        public final /* synthetic */ f d;
        public final /* synthetic */ LinearLayoutManager e;

        public h(MentionPanelListView r1, int r2, Integer r3, f r4, LinearLayoutManager r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            MentionPanelListView.a(this.a, this.b, this.c.intValue(), this.d.b, this.e);
        }
    }

    static {
    }

    public final List<y> e() {
        if (this.m == false) goto L13;
        List<? extends y> r0 = this.j;
        List<? extends y> r1 = r0;
        Integer r2 = this.h;
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        int r4 = r3 - g(r0);
        int r5 = 0;
        int r6 = RangesKt.coerceAtLeast(r4, 0);
        int r7 = this.e;
        int r8 = Math.max(2, ((r6 + r7) - 1) / r7);
        ArrayList r9 = new ArrayList(r8);
    L9:
        if (r5 >= r8) goto L15;
        r9.add(y.b.a);
        r5 = r5 + 1;
        goto L9
    L15:
        return CollectionsKt.plus(r1, r9);
    L7:
        r3 = this.g;
        goto L8
    L13:
        return this.j;
    }

    public static final void b(MentionPanelListView r3) {
        Function0<Unit> r0 = r3.f;
        if (r0 == null) goto L19;
        LinearLayoutManager r1 = r3.u.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r2 = r1;
    L9:
        if (r2 == null) goto L20;
        int r4 = r2.findLastVisibleItemPosition();
        if (r4 != (-1)) goto L15;
        return;
    L15:
        if (r4 < (r3.d.getItemCount() - 2)) goto L18;
        r0.invoke();
        return;
    L18:
        return;
    L20:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public static int h(List r3) {
        boolean r1 = true;
        if ((!r3.isEmpty()) == false) goto L17;
        List r4 = r3;
        if ((r4 instanceof Collection) == true) goto L7;
    L9:
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L15;
        if (Intrinsics.areEqual((y) r5.next(), y.b.a) == true) goto L11;
        r1 = false;
    L15:
        if (r1 == false) goto L17;
        return 6;
    L7:
        if (r4.isEmpty() == false) goto L9;
    L17:
        return 8;
    }

    public final void c(List<? extends y> r5) {
        int r6 = c7.b(Integer.valueOf(h(r5)));
        int r0 = c7.b(6) + this.q;
        if (this.u.getPaddingTop() == r6) goto L5;
    L7:
        RecyclerView r1 = this.u;
        r1.setPadding(r1.getPaddingLeft(), r6, this.u.getPaddingRight(), r0);
        return;
    L5:
        if (this.u.getPaddingBottom() != r0) goto L7;
    }

    public final void d(f r10) {
        this.u.stopScroll();
        LinearLayoutManager r0 = this.u.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r6 = r0;
    L6:
        if (r6 != null) goto L9;
        return;
    L9:
        if (r10 == null) goto L31;
        PanelAdapter r1 = this.d;
        g0 r3 = r10.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        Iterator<? extends y> r2 = r1.a.iterator();
        int r4 = 0;
    L12:
        if (r2.hasNext() == false) goto L24;
        y r5 = r2.next();
        if ((r5 instanceof y.d) == false) goto L16;
        y.d r7 = (y.d) r5;
    L17:
        if (r7 == null) goto L19;
        g0 r8 = r7.c;
    L21:
        if (Intrinsics.areEqual(r8, r3) == true) goto L25;
        r4 = r4 + 1;
    L25:
        Integer r9 = Integer.valueOf(r4);
        if (r9.intValue() == (-1)) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == false) goto L31;
        Integer r12 = r9;
    L32:
        if (r12 == null) goto L41;
        if (r10 == null) goto L41;
        if (r10.c == true) goto L39;
        this.p = null;
        j(0);
        r6.scrollToPositionWithOffset(0, 0);
        return;
    L39:
        j(0);
        r6.scrollToPositionWithOffset(r12.intValue(), r10.b);
        this.u.addOnLayoutChangeListener(new g(this.o, this, r6, r12, r10));
        return;
    L41:
        this.p = null;
        j(0);
        r6.scrollToPositionWithOffset(0, 0);
        return;
    L28:
        r11 = false;
        goto L29
    L19:
        r8 = null;
        goto L21
    L16:
        r7 = null;
        goto L17
    L24:
        r4 = -1;
    L31:
        r12 = null;
        goto L32
    L5:
        r6 = null;
        goto L6
    }

    public final void f(boolean r4) {
        this.o++;
        if (r4 == false) goto L5;
        this.p = null;
    L5:
        int r5 = this.u.getChildCount();
        int r0 = 0;
    L6:
        if (r0 >= r5) goto L8;
        View r1 = this.u.getChildAt(r0);
        r1.animate().cancel();
        r1.setTranslationY(0.0f);
        r0 = r0 + 1;
        goto L6
    }

    public final int g(List<? extends y> r3) {
        return c7.b(Integer.valueOf(h(r3) + 6)) + (r3.size() * this.e);
    }

    public final TextView i(ViewGroup r4) {
        View r5 = this.c.inflate(2131562603, r4, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.TextView");
        TextView r6 = (TextView) r5;
        r6.setText("");
        r6.setTypeface(Typeface.create("sans-serif-medium", 0));
        return r6;
    }

    public final void j(int r2) {
        this.q = RangesKt.coerceAtLeast(r2, 0);
        c(this.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MentionPanelListView(Context r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "onContentHeightChanged");
        this.a = r4;
        this.b = r5;
        this.c = LayoutInflater.from(r4);
        PanelAdapter r6 = new PanelAdapter(this);
        this.d = r6;
        Intrinsics.checkNotNullParameter(r4, "context");
        this.e = r4.getResources().getDimensionPixelSize(v19.c.b(2130971481, r4, 2131167332));
        this.g = c7.b(360);
        this.j = CollectionsKt.emptyList();
        this.k = CollectionsKt.emptyList();
        this.l = "";
        this.n = true;
        this.s = PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        int r0 = c7.b(8);
        this.t = r0;
        RecyclerView r1 = new RecyclerView(r4);
        r1.setPadding(0, r0, 0, c7.b(6));
        r1.setLayoutManager(new LinearLayoutManager(r1.getContext()));
        r1.setAdapter(r6);
        r1.setItemAnimator(null);
        ExposeXTrackerExtKt.c(r1);
        r1.addItemDecoration(new PanelStickyHeaderDecoration(new MentionPanelListView$view$1$1(r6), new c0(this)));
        r1.addOnScrollListener(new MentionPanelListView$view$1$3(this));
        this.u = r1;
    }

    public static final void a(MentionPanelListView r2, int r3, int r4, int r5, LinearLayoutManager r6) {
        if (r3 != r2.o) goto L14;
        View r7 = r6.findViewByPosition(r4);
        if (r7 == null) goto L16;
        int r8 = (r2.u.getPaddingTop() + r5) - r6.getDecoratedTop(r7);
        if (r8 == 0) goto L17;
        int r9 = r2.u.getChildCount();
        int r10 = 0;
    L12:
        if (r10 >= r9) goto L18;
        View r11 = r2.u.getChildAt(r10);
        r11.setTranslationY(r8);
        r11.animate().translationY(0.0f).setDuration(250).setInterpolator(r2.s).start();
        r10 = r10 + 1;
        goto L12
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
