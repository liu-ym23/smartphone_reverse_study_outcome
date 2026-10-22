package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.search.CardType;
import com.larus.bmhome.chat.search.SearchBoxStyle;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.chat.search.factory.NewVideoSingleRowRecyclerFactory;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemShowType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SearchListBox extends xc8.h implements com.larus.bmhome.chat.api.c0 {
    public static final LruCache<String, oi8.k> E = null;
    public Function3<? super pi8.k, ? super oi8.k, ? super oi8.c, Unit> A;
    public List<b> B;
    public Function4<? super Long, ? super Integer, ? super ItemData, ? super oi8.k, Unit> C;
    public ExpandCardViewMode D;
    public final ItemDecorationWrapper p;
    public final HorizontalOverScrollRV q;
    public x3 r;
    public final Lazy s;
    public boolean t;
    public oi8.c u;
    public int v;
    public float w;
    public float x;
    public oi8.k y;
    public Function3<? super pi8.l, ? super oi8.k, ? super oi8.c, Unit> z;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/SearchListBox$ItemDecorationWrapper;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "_delegate", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "updateItemDecoration", "decoration", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class ItemDecorationWrapper extends RecyclerView.ItemDecoration {
        public RecyclerView.ItemDecoration a;

        public ItemDecorationWrapper() {
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            super.getItemOffsets(r2, r3, r4, r5);
            RecyclerView.ItemDecoration r0 = this.a;
            if (r0 == null) goto L6;
            r0.getItemOffsets(r2, r3, r4, r5);
            return;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.item.SearchListBox$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0063a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[SearchBoxStyle.values().length];
                r0[SearchBoxStyle.singleRowNormal.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[SearchBoxStyle.singleRowTiny.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[SearchBoxStyle.doubleColumnVideo.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[SearchBoxStyle.doubleColumnImage.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[SearchBoxStyle.singleRowVideoNew.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[SearchBoxStyle.doubleColumnMixedMedia.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }

        public static oi8.k a(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "messageId");
            if (r6 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            oi8.k r1 = null;
            if (r0 == false) goto L12;
            return null;
        L12:
            String r7 = r5 + '_' + r6.hashCode();
            oi8.k r2 = (oi8.k) SearchListBox.E.get(r7);
            if (r2 == null) goto L22;
            return r2;
        L22:
            r1 = (oi8.k) GsonProtectorUtils.fromJson(new Gson(), r6, oi8.k.class);     // Catch: JsonSyntaxException -> L17
        L19:
            if (r1 == null) goto L21;
            SearchListBox.E.put(r7, r1);
        L21:
            return r1;
        L17:
            e = move-exception;
            FLogger.a.e("SearchListBox", "convertDataBean:" + g2a.d.d(r6), e);
            goto L19
        L5:
            if (r6.length() == 0) goto L8;
            r0 = false;
            goto L9
        }
    }

    public static final class b {
        public final long a;
        public boolean b;

        public b() {
            this(0);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            if (this.b == false) goto L5;
            int r2 = 1231;
        L7:
            return r1 + r2;
        L5:
            r2 = 1237;
            goto L7
        }

        public final String toString() {
            return "ExposureInfo(time=" + this.a + ", exposed=" + this.b + ')';
        }

        public /* synthetic */ b(int r3) {
            this(0, false);
        }

        public b(long r1, boolean r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public static final class c implements pi8.c {
        public final /* synthetic */ Message a;

        public c(Message r1) {
            this.a = r1;
        }

        @Override // pi8.c
        public final void a(Integer r11) {
            int r0 = MultimodalSendCostTrace.a;
            MultimodalSendCostTrace.b(this.a.getLocalMessageId() + r11, this.a.getLocalMessageId(), this.a.getConversationId(), null, AttachmentAreaType.NO_CLEAR, null, null, null);
        }

        @Override // pi8.c
        public final void b(String r9, Integer r10) {
            int r0 = MultimodalSendCostTrace.a;
            MultimodalSendCostTrace.e(this.a.getLocalMessageId() + r10, r9, this.a.getMessageId(), "search_card", true, MapsKt.mapOf(new Pair[]{TuplesKt.to("search_card_type", "large"), TuplesKt.to("index", String.valueOf(r10))}));
        }

        @Override // pi8.c
        public final void c(Throwable r10, String r11, Integer r12) {
            int r0 = com.larus.bmhome.chat.trace.multimodal.a.a;
            com.larus.bmhome.chat.trace.multimodal.a.a(this.a.getLocalMessageId() + r12, this.a.getMessageId(), "[image_load_failed]: err:" + r10, r11, "search_card", true, MapsKt.mapOf(new Pair[]{TuplesKt.to("search_card_type", "large"), TuplesKt.to("index", String.valueOf(r12))}));
        }
    }

    static {
        E = new LruCache(10);
    }

    private final e4 getSearchSingleRowVideoBox() {
        return (e4) this.s.getValue();
    }

    public final x3 getSearchDetailBox() {
        return this.r;
    }

    public SearchListBox(final Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        ItemDecorationWrapper r0 = new ItemDecorationWrapper();
        this.p = r0;
        HorizontalOverScrollRV r1 = new HorizontalOverScrollRV(r6, null, 6, 0);
        r1.setOverScrollMode(2);
        addView(r1);
        r1.setTag("search_list_recycler_view");
        r1.addItemDecoration(r0);
        r1.setNestedScrollingEnabled(false);
        this.q = r1;
        this.s = LazyKt.lazy(new y3(r6));
        this.u = new oi8.c(null, null, 15);
        this.v = -1;
        this.B = new ArrayList();
        this.D = ExpandCardViewMode.NORMAL;
    }

    @Override // com.larus.bmhome.chat.api.c0
    public final void c(com.larus.bmhome.chat.layout.widget.handler.l r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.z = r2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L4;
        Integer r0 = Integer.valueOf(r5.getActionMasked());
    L6:
        if (r0 != null) goto L9;
    L11:
        if (r0 != null) goto L14;
    L20:
        return super.dispatchTouchEvent(r5);
    L14:
        if (r0.intValue() != 2) goto L20;
        if (Math.abs(r5.getX() - this.w) <= Math.abs(r5.getY() - this.x)) goto L18;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L20
    L18:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L20
    L9:
        if (r0.intValue() != 0) goto L11;
        this.w = r5.getX();
        this.x = r5.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L20
    L4:
        r0 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.api.c0
    public final void f(com.larus.bmhome.chat.layout.widget.handler.m r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.A = r2;
    }

    @Override // com.larus.bmhome.chat.api.c0
    public final void g(Message r12) {
        Intrinsics.checkNotNullParameter(r12, "message");
        String r0 = r12.getMessageId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        oi8.k r1 = a.a(r0, r12.getContent());
        if (r1 != null) goto L8;
        r1 = new oi8.k(Boolean.FALSE, 3);
    L8:
        this.y = r1;
        String r2 = r12.getContent();
        int r3 = 0;
        if (r2 != null) goto L11;
    L14:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L47;
        String r5 = r12.getContent();
        if (r5 != null) goto L21;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == false) goto L47;
        zd9.h r7 = zd9.h.a;     // Catch: Throwable -> L46
        String r8 = r12.getContent();     // Catch: Throwable -> L46
        if (r8 != null) goto L28;
    L31:
        boolean r9 = true;
    L32:
        if (r9 == false) goto L259;
    L43:
        Object r10 = null;
    L44:
        ic8.b0 r11 = (ic8.b0) r10;     // Catch: Throwable -> L46
    L48:
        if (r11 == null) goto L50;
        Integer r13 = r11.b();
    L51:
        if (r13 != null) goto L53;
    L62:
        oi8.k r14 = this.y;
        if (r14 == null) goto L67;
        com.larus.bmhome.chat.search.b r15 = r14.e();
        if (r15 == null) goto L67;
        oi8.c r16 = r15.b();
    L68:
        this.u = r16;
        int r17 = com.larus.bmhome.chat.search.a.a;
        if (r16 == null) goto L71;
        oi8.e r18 = r16.c();
    L73:
        if (com.larus.bmhome.chat.search.a.c(r18, null) != null) goto L93;
        if (r16 == null) goto L79;
        Integer r19 = r16.a();
        if (r19 == null) goto L79;
        int r20 = r19.intValue();
    L80:
        if (r16 == null) goto L84;
        Integer r21 = r16.b();
        if (r21 == null) goto L84;
        int r22 = r21.intValue();
    L86:
        if (r20 != 4) goto L90;
        if (r22 != 1) goto L90;
    L92:
        boolean r23 = true;
    L94:
        if (r23 == false) goto L114;
        x3 r24 = this.r;
        if (r24 == null) goto L103;
        ViewParent r25 = r24.getParent();
        if ((r25 instanceof ViewGroup) == false) goto L100;
        ViewGroup r26 = (ViewGroup) r25;
    L101:
        if (r26 == null) goto L103;
        r26.removeView(this.r);
        goto L103
    L100:
        r26 = null;
    L103:
        x3 r27 = new x3(getContext());
        this.r = r27;
        addView(r27);
        x3 r28 = this.r;
        if (r28 == null) goto L106;
        r28.setRecyclerView(this.q);
    L106:
        this.t = true;
        if (r12.getMessageStatusLocal() == 21) goto L109;
    L113:
        this.v = r12.getMessageStatusLocal();
    L130:
        if (com.larus.bmhome.chat.search.a.d(r12) == false) goto L132;
        getSearchSingleRowVideoBox().setSearchHeaderText(getContext().getString(2131908717));
    L132:
        c r29 = new c(r12);
        if (com.larus.bmhome.chat.search.a.e(r12) == false) goto L135;
    L144:
        ViewParent r30 = getSearchSingleRowVideoBox().getParent();
        if ((r30 instanceof ViewGroup) == false) goto L147;
        ViewGroup r31 = (ViewGroup) r30;
    L148:
        if (r31 == null) goto L150;
        r31.removeView(getSearchSingleRowVideoBox());
    L150:
        addView(getSearchSingleRowVideoBox());
        Map r32 = r12.getExt();
        if (r32 == null) goto L153;
        String r33 = (String) r32.get("is_from_deep_search");
    L155:
        if (Intrinsics.areEqual(r33, "1") == false) goto L185;
        e4 r34 = getSearchSingleRowVideoBox();
        TextView r35 = (TextView) r34.findViewById(2131385497);
        if (r35 == null) goto L184;
        r35.setTypeface(Typeface.DEFAULT_BOLD);
        r35.setTextColor(ContextCompat.getColor(r34.getContext(), v19.c.b(2130972079, r34.getContext(), 2131103136)));
        r35.setTextSize(20.0f);
        ViewGroup.LayoutParams r36 = r35.getLayoutParams();
        if (r36 == null) goto L183;
        boolean r37 = r36 instanceof LinearLayout.LayoutParams;
        if (r37 == false) goto L163;
        LinearLayout.LayoutParams r38 = (LinearLayout.LayoutParams) r36;
    L164:
        if (r38 == null) goto L166;
        r38.setMarginStart(i5.h());
    L166:
        if (r37 == false) goto L168;
        LinearLayout.LayoutParams r39 = (LinearLayout.LayoutParams) r36;
    L169:
        if (r39 == null) goto L171;
        r39.setMarginEnd(i5.h());
    L171:
        if (r37 == false) goto L173;
        LinearLayout.LayoutParams r40 = (LinearLayout.LayoutParams) r36;
    L174:
        if (r40 == null) goto L176;
        r40.bottomMargin = i5.q();
    L176:
        if (r37 == false) goto L178;
        LinearLayout.LayoutParams r41 = (LinearLayout.LayoutParams) r36;
    L179:
        if (r41 == null) goto L181;
        r41.topMargin = i5.z();
    L181:
        r35.setLayoutParams(r36);
        goto L184
    L178:
        r41 = null;
        goto L179
    L173:
        r40 = null;
        goto L174
    L168:
        r39 = null;
        goto L169
    L163:
        r38 = null;
        goto L164
    L183:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L184:
        this.q.getLayoutManager();
        setPadding(-i5.h(), 0, -i5.h(), 0);
    L185:
        getSearchSingleRowVideoBox().setRecyclerView(this.q);
    L186:
        oi8.k r42 = this.y;
        if (r42 != null) goto L189;
        return;
    L189:
        oi8.c r43 = this.u;
        ListAdapter r44 = this.q.getAdapter();
        if ((r44 instanceof ListAdapter) == false) goto L192;
        ListAdapter r45 = r44;
    L193:
        if (r45 == null) goto L195;
        List r46 = r45.getCurrentList();
    L196:
        boolean r47 = this.t;
        if (r43 == null) goto L201;
        Integer r48 = r43.b();
        if (r48 == null) goto L201;
        int r49 = r48.intValue();
    L202:
        if (r43 == null) goto L206;
        Integer r50 = r43.a();
        if (r50 == null) goto L206;
        int r51 = r50.intValue();
    L208:
        switch(a.C0063a.a[com.larus.bmhome.chat.search.a.b(r43, r12).ordinal()]) {
            case 1: goto L216;
            case 2: goto L215;
            case 3: goto L214;
            case 4: goto L213;
            case 5: goto L212;
            case 6: goto L211;
            default: goto L210;
        };
    L211:
        pi8.d r52 = new pi8.n();
    L217:
        b4 r53 = new b4(this, r42, r43);
        LinkedHashMap r54 = new LinkedHashMap();
        String r110 = r12.getMessageId();
        if (r110 == null) goto L220;
        r54.put("message_id", r110);
    L220:
        Unit r111 = Unit.INSTANCE;
        ListAdapter r112 = r52.c(r53, r29, r54);
        RecyclerView.LayoutManager r55 = r52.b(getContext());
        RecyclerView.ItemDecoration r56 = r52.a();
        pi8.a r57 = r52.d();
        if ((r52 instanceof pi8.p) == false) goto L223;
        com.larus.platform.service.z2.a.w3();
    L223:
        HorizontalOverScrollRV r58 = this.q;
        r58.setPadding(0, r58.getPaddingTop(), 0, r58.getPaddingBottom());
        ItemDecorationWrapper r59 = this.p;
        r59.getClass();
        Intrinsics.checkNotNullParameter(r56, "decoration");
        r59.a = r56;
        this.q.setLayoutManager(r55);
        this.q.setAdapter(r112);
        pi8.o r60 = r57.a(r42, r43);
        if (r60.b == false) goto L226;
        this.q.setOnTouchListener(null);
    L227:
        Iterator<T> r61 = r60.a.iterator();
    L229:
        if (r61.hasNext() == false) goto L252;
        ItemData r62 = (ItemData) r61.next();
        if (r46 == null) goto L245;
        Iterator r63 = r46.iterator();
    L234:
        if (r63.hasNext() == false) goto L245;
        Object r64 = r63.next();
        if ((r64 instanceof ItemData) == false) goto L238;
        ItemData r65 = (ItemData) r64;
    L239:
        if (r65 == null) goto L241;
        String r66 = r65.getId();
    L243:
        if (Intrinsics.areEqual(r66, r62.getId()) == false) goto L234;
    L247:
        if ((r64 instanceof ItemData) == false) goto L249;
        ItemData r67 = (ItemData) r64;
    L250:
        if (r67 == null) goto L229;
        r62.setItemShowType(r67.getItemShowType());
        goto L229
    L249:
        r67 = null;
        goto L250
    L241:
        r66 = null;
        goto L243
    L238:
        r65 = null;
    L245:
        r64 = null;
        goto L247
    L252:
        r112.submitList(r60.a);
        int r113 = r60.a.size();
        ArrayList r68 = new ArrayList(r113);
        int r69 = 0;
    L253:
        if (r69 >= r113) goto L255;
        r68.add(new b(r3));
        r69 = r69 + 1;
        goto L253
    L255:
        this.B = r68;
        return;
    L226:
        this.q.setOnTouchListener(new a4());
        goto L227
    L212:
        r52 = new NewVideoSingleRowRecyclerFactory();
        goto L217
    L213:
        r52 = new pi8.m();
        goto L217
    L214:
        r52 = new pi8.p();
        goto L217
    L215:
        r52 = new pi8.r(r47, r49, r51);
        goto L217
    L216:
        r52 = new pi8.i();
        goto L217
    L210:
        throw new NoWhenBranchMatchedException();
    L206:
        r51 = 0;
    L201:
        r49 = 0;
        goto L202
    L195:
        r46 = null;
        goto L196
    L192:
        r45 = null;
        goto L193
    L153:
        r33 = null;
        goto L155
    L147:
        r31 = null;
        goto L148
    L135:
        if (com.larus.bmhome.chat.search.a.d(r12) == true) goto L144;
        ViewParent r70 = this.q.getParent();
        if ((r70 instanceof ViewGroup) == false) goto L140;
        ViewGroup r71 = (ViewGroup) r70;
    L141:
        if (r71 == null) goto L143;
        r71.removeView(this.q);
    L143:
        addView(this.q);
        goto L186
    L140:
        r71 = null;
        goto L141
    L109:
        if (this.v != 20) goto L113;
        x3 r72 = this.r;
        if (r72 == null) goto L113;
        r72.postDelayed(new z3(this), 800);
        goto L113
    L114:
        x3 r73 = this.r;
        if (r73 == null) goto L122;
        ViewParent r74 = r73.getParent();
        if ((r74 instanceof ViewGroup) == false) goto L119;
        ViewGroup r75 = (ViewGroup) r74;
    L120:
        if (r75 == null) goto L122;
        r75.removeView(this.r);
        goto L122
    L119:
        r75 = null;
    L122:
        ViewParent r76 = this.q.getParent();
        if ((r76 instanceof ViewGroup) == false) goto L125;
        ViewGroup r77 = (ViewGroup) r76;
    L126:
        if (r77 == null) goto L128;
        r77.removeView(this.q);
    L128:
        addView(this.q);
        this.t = false;
        goto L130
    L125:
        r77 = null;
    L90:
        if (r20 != 5) goto L93;
        if (r22 != 1) goto L93;
    L84:
        r22 = 1;
    L79:
        r20 = 0;
    L93:
        r23 = false;
        goto L94
    L71:
        r18 = null;
    L67:
        r16 = null;
        goto L68
    L53:
        if (r11.a() == null) goto L62;
        oi8.k r78 = this.y;
        if (r78 == null) goto L57;
        r78.f(new com.larus.bmhome.chat.search.b(0));
    L57:
        oi8.k r79 = this.y;
        if (r79 == null) goto L62;
        com.larus.bmhome.chat.search.b r80 = r79.e();
        if (r80 == null) goto L62;
        r80.g(new oi8.c(r11.b(), r11.a(), 12));
        goto L62
    L50:
        r13 = null;
        goto L51
    L259:
        Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L36
        r7.getClass();     // Catch: Throwable -> L36
        r10 = Result.constructor-impl(zd9.h.b.fromJson(r8, new c4().getType()));     // Catch: Throwable -> L36
    L38:
        Throwable r82 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L46
        if (r82 == null) goto L42;
        com.larus.im.internal.delegate.c0 r83 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L46
        StringBuilder r84 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L46
        Intrinsics.checkNotNullParameter(r82, "<this>");     // Catch: Throwable -> L46
        r84.append(ExceptionsKt.stackTraceToString(r82));     // Catch: Throwable -> L46
        r83.e("GsonHolder", r84.toString());     // Catch: Throwable -> L46
    L42:
        if (Result.isFailure-impl(r10) == false) goto L44;
    L36:
        th = move-exception;
        Result.Companion r85 = Result.Companion;     // Catch: Throwable -> L46
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L46
        goto L38
    L28:
        if (StringsKt.isBlank(r8) == true) goto L31;
        r9 = false;
    L46:
        FLogger.a.e("SearchListBox", "parse abversion struct err! content=" + g2a.d.d(r12.getContent()));
        goto L47
    L21:
        if (StringsKt.contains$default(r5, "ABVersion", false, 2, null) != true) goto L23;
        r6 = true;
    L47:
        r11 = null;
        goto L48
    L11:
        if (r2.length() == 0) goto L14;
        r4 = false;
        goto L16
    }

    public final void setFullVisibleStatus(boolean r13) {
        if (r13 == true) goto L32;
        this.q.clearOnScrollListeners();
        ListAdapter r14 = this.q.getAdapter();
        if ((r14 instanceof ListAdapter) == false) goto L7;
        ListAdapter r15 = r14;
    L8:
        if (r15 != null) goto L10;
        return;
    L10:
        long r1 = SystemClock.elapsedRealtime();
        Iterator<T> r3 = this.B.iterator();
        int r5 = 0;
    L12:
        if (r3.hasNext() == false) goto L31;
        Object r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        b r8 = (b) r6;
        Object r9 = CollectionsKt.getOrNull(r15.getCurrentList(), r5);
        if ((r9 instanceof ItemData) == false) goto L19;
        ItemData r10 = (ItemData) r9;
    L20:
        if (r10 == null) goto L21;
        if (r8.b == false) goto L30;
        Function4<? super Long, ? super Integer, ? super ItemData, ? super oi8.k, Unit> r11 = this.C;
        if (r11 == null) goto L30;
        Long r12 = Long.valueOf(r1 - r8.a);
        Integer r16 = Integer.valueOf(r5);
        oi8.k r17 = this.y;
        if (r17 == null) goto L28;
        r11.invoke(r12, r16, r10, r17);
        goto L30
    L28:
        return;
    L30:
        r8.b = false;
        r5 = r7;
        goto L12
    L21:
        return;
    L19:
        r10 = null;
        goto L20
    L31:
        return;
    L7:
        r15 = null;
        goto L8
    L32:
        LinearLayoutManager r18 = this.q.getLayoutManager();
        if ((r18 instanceof LinearLayoutManager) == false) goto L35;
        LinearLayoutManager r19 = r18;
    L36:
        if (r19 != null) goto L38;
        return;
    L38:
        ListAdapter r2 = this.q.getAdapter();
        if ((r2 instanceof ListAdapter) == false) goto L41;
        ListAdapter r4 = r2;
    L42:
        if (r4 != null) goto L44;
        return;
    L44:
        Iterator r20 = r4.getCurrentList().iterator();
    L46:
        if (r20.hasNext() == false) goto L53;
        Object r21 = r20.next();
        if ((r21 instanceof ItemData) == false) goto L50;
        ItemData r22 = (ItemData) r21;
    L51:
        if (r22 == null) goto L46;
        r22.setItemShowType(ItemShowType.ITEM_SHOW_TYPE_NONE);
        goto L46
    L50:
        r22 = null;
        goto L51
    L53:
        int r23 = r19.findFirstVisibleItemPosition();
        int r24 = r19.findLastVisibleItemPosition();
        if (r23 > r24) goto L86;
    L55:
        if (r23 >= 0) goto L57;
    L60:
        Object r25 = CollectionsKt.getOrNull(r4.getCurrentList(), r23);
        if ((r25 instanceof ItemData) == false) goto L63;
        ItemData r26 = (ItemData) r25;
    L64:
        if (r26 == null) goto L65;
        View r27 = r19.findViewByPosition(r23);
        if (r27 == null) goto L68;
        Rect r28 = new Rect();
        boolean r29 = r27.getGlobalVisibleRect(r28);
        float r30 = r28.width() / RangesKt.coerceAtLeast(r27.getWidth(), 0.1f);
        float r31 = r28.height() / RangesKt.coerceAtLeast(r27.getHeight(), 0.1f);
        if (r29 == true) goto L72;
    L84:
        if (r23 == r24) goto L86;
        r23 = r23 + 1;
        goto L55
    L72:
        if (r30 < 0.5f) goto L84;
        if (r31 < 0.5f) goto L84;
        if (r26.getItemShowType() != ItemShowType.ITEM_SHOW_TYPE_NONE) goto L84;
        r26.setItemShowType(ItemShowType.ITEM_SHOW_TYPE_AUTO);
        Function3<? super pi8.l, ? super oi8.k, ? super oi8.c, Unit> r32 = this.z;
        if (r32 == null) goto L83;
        pi8.l r33 = new pi8.l(r26, r23, r27.getWidth(), r27.getHeight());
        oi8.k r34 = this.y;
        if (r34 == null) goto L81;
        r32.invoke(r33, r34, this.u);
        goto L83
    L81:
        return;
    L83:
        ListProtector.set(this.B, r23, new b(SystemClock.elapsedRealtime(), true));
        goto L84
    L68:
        return;
    L65:
        return;
    L63:
        r26 = null;
        goto L64
    L57:
        if (((ArrayList) this.B).size() <= r23) goto L60;
        if (((b) ListProtector.get(this.B, r23)).b == true) goto L84;
    L86:
        oi8.k r110 = this.y;
        if (r110 != null) goto L89;
        return;
    L89:
        setupCardScrollShowReporter(r110);
        return;
    L41:
        r4 = null;
        goto L42
    L35:
        r19 = null;
        goto L36
    }

    public final void setSearchDetailBox(x3 r1) {
        this.r = r1;
    }

    @Override // com.larus.bmhome.chat.api.c0
    public void setupCardScrollShowReporter(final oi8.k r3) {
        Intrinsics.checkNotNullParameter(r3, "searchListData");
        this.q.clearOnScrollListeners();
        this.q.addOnScrollListener(new AnonymousClass1(this, r3));
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r4, boolean r5) {
        Lazy r0 = com.larus.bmhome.utils.z1.a;
        boolean r1 = com.larus.bmhome.utils.z1.b(getBoxType(), getImmerseBgColor());
        if (r1 != true) goto L11;
        if (r4 == false) goto L7;
        if (r5 == true) goto L7;
        ExpandCardViewMode r6 = ExpandCardViewMode.EXPAND_SHARE;
    L19:
        this.D = r6;
        oi8.k r7 = this.y;
        if (r7 == null) goto L48;
        com.larus.bmhome.chat.search.b r8 = r7.e();
        if (r8 == null) goto L49;
        oi8.c r9 = r8.b();
        if (r9 == null) goto L50;
        oi8.e r10 = r9.c();
        if (r10 == null) goto L51;
        Integer r11 = r10.a();
        if (r11 == null) goto L52;
        int r12 = r11.intValue();
        CardType r13 = CardType.MixedMedia;
        if (r12 != r13.value) goto L53;
        e4 r2 = getSearchSingleRowVideoBox();
        ExpandCardViewMode r3 = this.D;
        CardType.Companion.getClass();
        CardType r14 = CardType.a.a(r12);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "msgExpandMode");
        if (r14 != r13) goto L34;
        int r15 = i5.E() + i5.j0();
    L36:
        if (r3 != ExpandCardViewMode.EXPAND_SHARE) goto L38;
    L41:
        Resources r16 = AppHost.a.getApplication().getResources();
        int r17 = WindowDisplayMetricsOverride.apply(r16, r16.getDisplayMetrics()).widthPixels - r15;
    L42:
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(r17, -2);
        LinearLayout r19 = r2.a;
        if (r19 == null) goto L54;
        r19.setLayoutParams(r18);
        return;
    L54:
        return;
    L38:
        if (r3 == ExpandCardViewMode.EXPAND_PIC) goto L41;
        Resources r20 = AppHost.a.getApplication().getResources();
        r17 = WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics()).widthPixels;
        goto L42
    L34:
        r15 = 0;
        goto L36
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L7:
        if (r4 == true) goto L10;
        if (r5 == false) goto L10;
        r6 = ExpandCardViewMode.EXPAND_PIC;
    L10:
        r6 = ExpandCardViewMode.EXPAND;
        goto L19
    L11:
        if (r1 == true) goto L47;
        if (r4 == false) goto L15;
        if (r5 == true) goto L15;
        r6 = ExpandCardViewMode.NORMAL_SHARE;
    L15:
        if (r4 == true) goto L18;
        if (r5 == false) goto L18;
        r6 = ExpandCardViewMode.NORMAL_PIC;
    L18:
        r6 = ExpandCardViewMode.NORMAL;
        goto L19
    L47:
        throw new NoWhenBranchMatchedException();
    }

    public static final void n(SearchListBox r7, int r8, oi8.k r9) {
        ListAdapter r0 = r7.q.getAdapter();
        ItemData r2 = null;
        if ((r0 instanceof ListAdapter) == false) goto L5;
        ListAdapter r1 = r0;
    L6:
        if (r1 == null) goto L27;
        b r3 = (b) CollectionsKt.getOrNull(r7.B, r8);
        if (r3 == null) goto L28;
        Object r4 = CollectionsKt.getOrNull(r1.getCurrentList(), r8);
        if ((r4 instanceof ItemData) == false) goto L14;
        r2 = (ItemData) r4;
    L14:
        if (r2 == null) goto L29;
        ItemShowType r5 = r2.getItemShowType();
        ItemShowType r6 = ItemShowType.ITEM_SHOW_TYPE_NONE;
        if (r5 == r6) goto L30;
        r2.setItemShowType(r6);
        long r10 = SystemClock.elapsedRealtime();
        if (r3.b == false) goto L26;
        Function4<? super Long, ? super Integer, ? super ItemData, ? super oi8.k, Unit> r11 = r7.C;
        if (r11 == null) goto L24;
        r11.invoke(Long.valueOf(r10 - r3.a), Integer.valueOf(r8), r2, r9);
    L24:
        r3.b = false;
        return;
    L26:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void i(int r2, int r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r4, "outSpec");
        super.i(r2, r3, r4);
    }
}
