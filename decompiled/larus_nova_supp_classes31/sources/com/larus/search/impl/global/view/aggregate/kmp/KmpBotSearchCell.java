package com.larus.search.impl.global.view.aggregate.kmp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.flow.search.kmp.api.model.BotCreatorInfo;
import com.bytedance.flow.search.kmp.api.model.BotIconImageKmp;
import com.bytedance.flow.search.kmp.api.model.BotSearchResultItem;
import com.bytedance.flow.search.kmp.api.model.BotStatisticKmp;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.Position;
import com.bytedance.flow.search.kmp.api.model.RecommendBotKmp;
import com.bytedance.flow.search.kmp.api.model.SearchHighlightInfo;
import com.bytedance.flow.search.kmp.api.model.payload.BotPayload;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.utils.a4;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.extension.aggregate_search_ui.api.kmp.KmpISearchEventTrackerAbility;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.search.impl.global.view.SearchResultItemView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0002J$\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010!2\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010!H\u0002J$\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010!2\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010!H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006*"}, d2 = {"Lcom/larus/search/impl/global/view/aggregate/kmp/KmpBotSearchCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/search/impl/global/view/aggregate/kmp/KmpBotSearchCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "resultItemView", "Lcom/larus/search/impl/global/view/SearchResultItemView;", "currentSourceData", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "currentPayload", "Lcom/bytedance/flow/search/kmp/api/model/payload/BotPayload;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "convertToGlobalItem", "Lcom/larus/search/impl/global/model/GlobalSearchResultItem;", "kmpItem", "Lcom/bytedance/flow/search/kmp/api/model/BotSearchResultItem;", "botEventHelper", "com/larus/search/impl/global/view/aggregate/kmp/KmpBotSearchCell$botEventHelper$1", "Lcom/larus/search/impl/global/view/aggregate/kmp/KmpBotSearchCell$botEventHelper$1;", "rebindCurrentView", "dispatchClickAction", "data", "mapHighlightInfos", "", "Lcom/larus/search/impl/global/model/SearchHighlightInfo;", "highlights", "Lcom/bytedance/flow/search/kmp/api/model/SearchHighlightInfo;", "mapPositions", "Lcom/larus/search/impl/global/model/Position;", "positions", "Lcom/bytedance/flow/search/kmp/api/model/Position;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpBotSearchCell extends BaseSearchListCell<com.larus.search.impl.global.view.aggregate.kmp.b> {
    public final int a;
    public SearchResultItemView b;
    public FlowSearchData c;
    public BotPayload d;
    public final b e;

    public static final class a {
    }

    public static final class b implements SearchResultItemView.b {
        public final /* synthetic */ KmpBotSearchCell a;

        public static final class a implements p0 {
            public final /* synthetic */ RecommendBot a;
            public final /* synthetic */ KmpBotSearchCell b;
            public final /* synthetic */ int c;

            public final void confirm() {
                BotStatusCacheDelegate r0 = BotStatusCacheDelegate.b;
                String r1 = this.a.o();
                if (r1 != null) goto L5;
                r1 = "";
            L5:
                r0.a(r1, false);
                KmpBotSearchCell r2 = this.b;
                int r3 = this.c;
                BotPayload r4 = r2.d;
                FlowSearchData r5 = null;
                if (r4 == null) goto L12;
                ws9.b r6 = KmpBotSearchCell.c(r4.j);
                SearchResultItemView r7 = r2.b;
                if (r7 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
                r7 = null;
            L11:
                r7.a(r6, r3, r2.e);
            L12:
                KmpBotSearchCell r8 = this.b;
                FlowSearchData r9 = r8.c;
                if (r9 == null) goto L15;
                r5 = FlowSearchData.a(r9, -2, null, 5);
            L15:
                KmpBotSearchCell.b(r8, r5);
            }

            public a(RecommendBot r1, KmpBotSearchCell r2, int r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        /* JADX INFO: renamed from: com.larus.search.impl.global.view.aggregate.kmp.KmpBotSearchCell$b$b, reason: collision with other inner class name */
        public static final class C0020b implements u {
            public C0020b() {
            }

            public final void cancel() {
            }
        }

        public b(KmpBotSearchCell r1) {
            this.a = r1;
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void a(RecommendBot r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "data");
            BotStatusCacheDelegate r0 = BotStatusCacheDelegate.b;
            String r6 = r4.o();
            if (r6 != null) goto L5;
            r6 = "";
        L5:
            r0.a(r6, true);
            KmpBotSearchCell r7 = this.a;
            BotPayload r1 = r7.d;
            FlowSearchData r2 = null;
            if (r1 == null) goto L12;
            ws9.b r3 = KmpBotSearchCell.c(r1.j);
            SearchResultItemView r8 = r7.b;
            if (r8 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
            r8 = null;
        L11:
            r8.a(r3, r5, r7.e);
        L12:
            KmpBotSearchCell r9 = this.a;
            FlowSearchData r10 = r9.c;
            if (r10 == null) goto L15;
            r2 = FlowSearchData.a(r10, -1, null, 5);
        L15:
            KmpBotSearchCell.b(r9, r2);
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void b(RecommendBot r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "data");
            RecyclerView r0 = this.a.getParent();
            if (r0 == null) goto L5;
            Context r1 = r0.getContext();
        L7:
            if ((r1 instanceof FragmentActivity) == false) goto L9;
            FragmentActivity r2 = (FragmentActivity) r1;
        L10:
            if (r2 != null) goto L12;
            return;
        L12:
            a4.a.getClass();
            a4.a(a4.b);
            CommonDialog.a r3 = new CommonDialog.a();
            r3.i(r2.getString(2131901554));
            r3.g(r2.getString(2131900204));
            CommonDialog.a.f(r3, new a(r6, this.a, r7), r2.getString(2131900203), false, 12);
            CommonDialog.a.e(r3, new C0020b(), r2.getString(2131900202), 4);
            CommonDialog r8 = r3.a();
            FragmentManager r9 = r2.getSupportFragmentManager();
            LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, null, r4);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r8, r4) == true) goto L21;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
        L16:
            r8.show(r9, null);
            return;
        L21:
            return;
        L9:
            r2 = null;
            goto L10
        L5:
            r1 = null;
            goto L7
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void c(RecommendBot r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "data");
            KmpBotSearchCell r6 = this.a;
            FlowSearchData r7 = r6.c;
            FlowSearchData r0 = null;
            if (r7 == null) goto L5;
            r0 = FlowSearchData.a(r7, -3, null, 5);
        L5:
            KmpBotSearchCell.b(r6, r0);
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void d(RecommendBot r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "data");
            KmpBotSearchCell r3 = this.a;
            KmpBotSearchCell.b(r3, r3.c);
        }
    }

    static {
    }

    public KmpBotSearchCell() {
        this.a = 2131562635;
        this.e = new b(this);
    }

    public final int getLayoutId() {
        return this.a;
    }

    public static ws9.b c(BotSearchResultItem r46) {
        ArrayList r1 = null;
        if (r46 == null) goto L5;
        RecommendBotKmp r2 = r46.a;
        if (r2 == null) goto L21;
        String r4 = r2.a;
        String r5 = r2.b;
        Integer r6 = r2.c;
        BotIconImageKmp r3 = r2.e;
        if (r3 == null) goto L11;
        BotIconImage r8 = new BotIconImage(r3.a, r3.b, r3.c, r3.d, null, 16, null);
    L12:
        String r13 = r2.g;
        String r14 = r2.f;
        BotCreatorInfo r7 = r2.d;
        if (r7 == null) goto L15;
        com.larus.im.bean.bot.BotCreatorInfo r18 = new com.larus.im.bean.bot.BotCreatorInfo(r7.a, r7.b, null, 4, null);
    L16:
        BotStatisticKmp r9 = r2.h;
        if (r9 == null) goto L19;
        BotStatistic r19 = new BotStatistic(r9.a, r9.b);
    L20:
        RecommendBot r10 = new RecommendBot(r4, r5, r6, null, r8, 0, 0, 0, r2.j, r2.k, null, r18, r19, null, r14, null, null, null, null, r2.i, null, r13, null, null, null, null, null, null, null, null, null, null, null, null, false, null, -18966056, 8191);
    L22:
        List r11 = r46.b;
        if (r11 == null) goto L50;
        List r12 = r11;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r16 = r12.iterator();
    L26:
        if (r16.hasNext() == false) goto L48;
        SearchHighlightInfo r17 = (SearchHighlightInfo) r16.next();
        if (r17 == null) goto L30;
        String r20 = r17.a;
    L31:
        if (r17 == null) goto L33;
        List r21 = r17.b;
    L34:
        if (r21 == null) goto L46;
        List r22 = r21;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r23 = r22.iterator();
    L37:
        if (r23.hasNext() == false) goto L47;
        Position r111 = (Position) r23.next();
        if (r111 == null) goto L41;
        Integer r112 = r111.a;
    L42:
        if (r111 == null) goto L44;
        Integer r113 = r111.b;
    L45:
        r110.add(new ws9.d(r112, r113));
        goto L37
    L44:
        r113 = null;
        goto L45
    L41:
        r112 = null;
    L47:
        r15.add(new ws9.e(r20, r110));
        goto L26
    L46:
        r110 = null;
        goto L47
    L33:
        r21 = null;
        goto L34
    L30:
        r20 = null;
        goto L31
    L48:
        r1 = r15;
    L50:
        return new ws9.b(r10, r1, r46.c);
    L19:
        r19 = null;
        goto L20
    L15:
        r18 = null;
        goto L16
    L11:
        r8 = null;
        goto L12
    L21:
        r10 = null;
        goto L22
    L5:
        return new ws9.b(null, 7);
    }

    public final void onViewCreated(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        SearchResultItemView r7 = (SearchResultItemView) r6.findViewById(2131385572);
        this.b = r7;
        SearchResultItemView r0 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r7 = null;
    L5:
        View r8 = r7.findViewById(2131363723);
        if (r8 == null) goto L12;
        ViewGroup.LayoutParams r3 = r8.getLayoutParams();
        if (r3 == null) goto L11;
        r3.width = i5.d0();
        r3.height = i5.d0();
        r8.setLayoutParams(r3);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L12:
        SearchResultItemView r9 = this.b;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r9 = null;
    L15:
        View r10 = r9.findViewById(2131363623);
        if (r10 == null) goto L22;
        ViewGroup.LayoutParams r4 = r10.getLayoutParams();
        if (r4 == null) goto L21;
        r4.width = i5.d0();
        r4.height = i5.d0();
        r10.setLayoutParams(r4);
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L22:
        SearchResultItemView r11 = this.b;
        if (r11 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r11 = null;
    L25:
        View r12 = r11.findViewById(2131388462);
        if (r12 == null) goto L28;
        r12.setMinimumHeight(i5.g0());
        r12.setPadding(0, i5.Y(), 0, 0);
    L28:
        SearchResultItemView r13 = this.b;
        if (r13 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r13 = null;
    L31:
        View r14 = r13.findViewById(2131368849);
        if (r14 == null) goto L38;
        r14.setVisibility(4);
        r14.setMinimumHeight(0);
        ViewGroup.LayoutParams r5 = r14.getLayoutParams();
        if (r5 == null) goto L37;
        r5.height = 0;
        r14.setLayoutParams(r5);
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L38:
        SearchResultItemView r15 = this.b;
        if (r15 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r15 = null;
    L41:
        View r16 = r15.findViewById(2131362231);
        if (r16 == null) goto L48;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L47;
        r17.width = i5.d0();
        r17.height = i5.d0();
        r16.setLayoutParams(r17);
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L48:
        SearchResultItemView r18 = this.b;
        if (r18 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
    L52:
        View r19 = r0.findViewById(2131362230);
        if (r19 == null) goto L59;
        ViewGroup.LayoutParams r1 = r19.getLayoutParams();
        if (r1 == null) goto L58;
        r1.width = i5.J();
        r1.height = i5.J();
        r19.setLayoutParams(r1);
        return;
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L59:
        return;
    L51:
        r0 = r18;
        goto L52
    }

    public static final void b(KmpBotSearchCell r2, FlowSearchData r3) {
        if (r3 != null) goto L4;
        r2.getClass();
        return;
    L4:
        BotPayload r0 = r2.d;
        if (r0 == null) goto L9;
        t1a.b r1 = ((ISearchDataPayload) r0).g;
        if (r1 == null) goto L9;
        KmpISearchEventTrackerAbility r4 = (KmpISearchEventTrackerAbility) r1.o(Reflection.getOrCreateKotlinClass(KmpISearchEventTrackerAbility.class));
    L10:
        if (r4 == null) goto L12;
        r4.trackSearchResultClick(r3);
    L12:
        BotPayload r5 = r2.d;
        if (r5 == null) goto L17;
        r5.a(new aw5.a.b(r3));
        return;
    L17:
        return;
    L9:
        r4 = null;
        goto L10
    }

    public final void onBindView(View r2, ei9.f r3, int r4) {
        com.larus.search.impl.global.view.aggregate.kmp.b r5 = (com.larus.search.impl.global.view.aggregate.kmp.b) r3;
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r5, "state");
        BotPayload r6 = r5.a;
        this.c = ((ISearchDataPayload) r6).h;
        this.d = r6;
        ws9.b r7 = c(r6.j);
        SearchResultItemView r8 = this.b;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resultItemView");
        r8 = null;
    L5:
        r8.a(r7, r4, this.e);
    }
}
