package com.obric.aiproactive.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.aiproactive.ui.databinding.ItemProactiveEndBinding;
import com.obric.aiproactive.ui.databinding.ItemProactiveMinuteHeaderBinding;
import com.obric.aiproactive.ui.databinding.ItemProactiveNowProcessedBinding;
import com.obric.aiproactive.ui.databinding.ItemProactiveRecommendationAdoptedBinding;
import com.obric.aiproactive.ui.databinding.ItemProactiveRecommendationBinding;
import com.obric.aiproactive.ui.databinding.ItemProactiveRecommendationNowBinding;
import com.obric.aiproactive.ui.databinding.ItemProactiveSectionHeaderBinding;
import com.obric.aiproactive.ui.databinding.ItemProactiveTipBinding;
import com.obric.aiproactive.ui.databinding.LayoutGuidedPreferenceEntryCardBinding;
import com.obric.aiproactive.ui.feedback.ProactiveVoteStore;
import com.obric.aiproactive.ui.util.l;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\f./0123456789B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u0014\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0006\u0010$\u001a\u00020\u0013J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\u001aH\u0016J\u001f\u0010)\u001a\u0004\u0018\u00010\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010-R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "mode", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Mode;", "listener", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;", "voteStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore;", "<init>", "(Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Mode;Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore;)V", "items", "", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "shownCardIds", "", "", "guidedPreferenceEntryClickListener", "Lkotlin/Function0;", "", "setOnGuidedPreferenceEntryClickListener", "submitItems", "newItems", "getItems", "currentItems", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onViewAttachedToWindow", "onViewRecycled", "resetCardShowTracking", "checkAndReportVisibleCards", "layoutManager", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "getItemCount", "recommendationRank", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "adapterPosition", "(Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;I)Ljava/lang/Integer;", "Mode", "Listener", "TipViewHolder", "DayViewHolder", "MinuteViewHolder", "NowProcessedViewHolder", "GuidedPreferenceEntryViewHolder", "AllRecommendationViewHolder", "NowRecommendationViewHolder", "RecommendationAdoptedViewHolder", "EndViewHolder", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveListAdapter extends RecyclerView.Adapter<RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f6685a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Mode f6686b;
    private final f c;
    private final ProactiveVoteStore d;
    private List<? extends com.obric.aiproactive.ui.model.j> e;
    private final Set<String> f;
    private Function0<Unit> g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "NOW", "ALL", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode ALL = null;
        public static final Mode NOW = null;

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{NOW, ALL};
        }

        static {
            NOW = new Mode("NOW", 0);
            ALL = new Mode("ALL", 1);
            Mode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.memorydata.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$AllRecommendationViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/aiproactive/ui/databinding/ItemProactiveRecommendationBinding;", "listener", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;", "voteStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore;", "<init>", "(Lcom/obric/aiproactive/ui/list/ProactiveListAdapter;Lcom/obric/aiproactive/ui/databinding/ItemProactiveRecommendationBinding;Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore;)V", "bind", "", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "bindStatusChip", "bindHistoryActions", "uiState", "Lcom/obric/aiproactive/ui/list/HistoryRecommendationCardUiState;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProactiveListAdapter f6687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ItemProactiveRecommendationBinding f6688b;
        private final f t;
        private final ProactiveVoteStore u;

        public a(ProactiveListAdapter r3, ItemProactiveRecommendationBinding r4, f r5, ProactiveVoteStore r6) {
            f r7 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "binding");
            Intrinsics.checkNotNullParameter(r7, "listener");
            Intrinsics.checkNotNullParameter(r6, "voteStore");
            this.f6687a = r3;
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f6688b = r4;
            this.t = r7;
            this.u = r6;
        }

        private static final void a(a r0, com.obric.aiproactive.ui.model.j.f r1, ProactiveListAdapter r2, View r3) {
            r0.t.a(r1, ProactiveListAdapter.a(r2, r1, r0.o()));
        }

        private final void a(final com.obric.aiproactive.ui.model.j.f r18, com.obric.aiproactive.ui.list.b r19) {
            this.f6688b.llActions.removeAllViews();
            LinearLayout r0 = this.f6688b.llActions;
            if (r19.c().isEmpty() == false) goto L5;
            int r1 = 8;
        L6:
            r0.setVisibility(r1);
            LayoutInflater r9 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6688b.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            int r10 = ZeusTransformUtils.getResources(this.f6688b.getRoot(), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.proactive_action_button_gap, "dimen", "proactive_action_button_gap"));
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r19.c(), Iterable.class, "com.obric.memorydata.plugin");
            final ProactiveListAdapter r11 = this.f6687a;
            Iterator r12 = r2.iterator();
            int r13 = 0;
        L8:
            if (r12.hasNext() == false) goto L25;
            Object r3 = r12.next();
            int r14 = r13 + 1;
            if (r13 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            final com.obric.aiproactive.ui.list.a r5 = (com.obric.aiproactive.ui.list.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.list.a.class, "com.obric.memorydata.plugin");
            View r4 = ZeusTransformUtils.inflate(r9, ZeusTransformUtils.mapRes(R.layout.item_proactive_now_action_chip, "layout", "item_proactive_now_action_chip"), (ViewGroup) ZeusTransformUtils.preCheckCast(this.f6688b.llActions, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.oui.button.OButton");
            final OButton r15 = (OButton) ZeusTransformUtils.preCheckCast(r4, OButton.class, "com.obric.memorydata.plugin");
            r15.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.e(), CharSequence.class, "com.obric.memorydata.plugin"));
            r15.setSelected(r5.c());
            r15.setEnabled(r5.d());
            r15.setAlpha(1.0f);
            Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r15.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (r5.c() == false) goto L15;
            int r7 = R.color.ai_proactive_demo_text_disabled;
            String r8 = "ai_proactive_demo_text_disabled";
        L16:
            r15.setTextColor(r6.getColor(ZeusTransformUtils.mapRes(r7, TypedValues.Custom.S_COLOR, r8)));
            if (r5.d() == false) goto L19;
            View.OnClickListener r16 = new $$Lambda$ProactiveListAdapter$a$7vtbnxHiOPtCg22NwXfSt1jISzI(r15, this, r18, r11, r5);
        L20:
            r15.setOnClickListener(r16);
            TextView r17 = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.memorydata.plugin");
            if (r13 <= 0) goto L23;
            int r20 = r10;
        L24:
            com.obric.aiproactive.ui.util.g.a(r17, r20, GravityCompat.START);
            this.f6688b.llActions.addView((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"));
            TextView r21 = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.memorydata.plugin");
            LinearLayout r22 = this.f6688b.llActions;
            Intrinsics.checkNotNullExpressionValue(r22, "llActions");
            com.obric.aiproactive.ui.util.g.a(r21, (View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.memorydata.plugin"));
            r13 = r14;
            goto L8
        L23:
            r20 = 0;
            goto L24
        L19:
            r16 = null;
            goto L20
        L15:
            r7 = R.color.ai_proactive_demo_text_primary;
            r8 = "ai_proactive_demo_text_primary";
            goto L16
        L25:
            return;
        L5:
            r1 = 0;
            goto L6
        }

        private static final void a(OButton r2, a r3, com.obric.aiproactive.ui.model.j.f r4, ProactiveListAdapter r5, com.obric.aiproactive.ui.list.a r6, View r7) {
            b.a(ProactiveListAdapter.e(), (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
            r3.t.a(r4, ProactiveListAdapter.a(r5, r4, r3.o()), r6.a(), r6.b());
        }

        private static final boolean a(a r0, com.obric.aiproactive.ui.model.j.f r1, View r2) {
            r0.t.a(r1);
            return true;
        }

        private final void b(com.obric.aiproactive.ui.model.j.f r7) {
            com.obric.aiproactive.ui.list.b r0 = com.obric.aiproactive.ui.list.c.a(r7);
            int r2 = 0;
            this.f6688b.llStatusChip.setVisibility(0);
            this.f6688b.tvStatusEmoji.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0.a(), CharSequence.class, "com.obric.memorydata.plugin"));
            AppCompatTextView r1 = this.f6688b.tvStatusEmoji;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L5;
            int r3 = 0;
        L6:
            r1.setVisibility(r3);
            ImageView r4 = this.f6688b.imgStatus;
            if (r0.b() != null) goto L10;
            r2 = 8;
        L10:
            r4.setVisibility(r2);
            Integer r5 = r0.b();
            if (r5 == null) goto L13;
            this.f6688b.imgStatus.setImageResource(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue());
        L13:
            a(r7, r0);
            return;
        L5:
            r3 = 8;
            goto L6
        }

        public static /* synthetic */ void lambda$7vtbnxHiOPtCg22NwXfSt1jISzI(OButton r0, a r1, com.obric.aiproactive.ui.model.j.f r2, ProactiveListAdapter r3, com.obric.aiproactive.ui.list.a r4, View r5) {
            a(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ boolean lambda$ghfmWSvaRIOFlWgzxX8fNP2QkpA(a r0, com.obric.aiproactive.ui.model.j.f r1, View r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$z2luPOuZ4A7GvoyxJqDSYUa8FmI(a r0, com.obric.aiproactive.ui.model.j.f r1, ProactiveListAdapter r2, View r3) {
            a(r0, r1, r2, r3);
        }

        public final void a(final com.obric.aiproactive.ui.model.j.f r6) {
            Intrinsics.checkNotNullParameter(r6, "item");
            ConstraintLayout r0 = this.f6688b.getRoot();
            final ProactiveListAdapter r1 = this.f6687a;
            r0.setOnClickListener(new $$Lambda$ProactiveListAdapter$a$z2luPOuZ4A7GvoyxJqDSYUa8FmI(this, r6, r1));
            this.f6688b.getRoot().setOnLongClickListener(new $$Lambda$ProactiveListAdapter$a$ghfmWSvaRIOFlWgzxX8fNP2QkpA(this, r6));
            com.obric.aiproactive.ui.util.j r2 = com.obric.aiproactive.ui.util.j.f6886a;
            MarkdownTextView r3 = this.f6688b.tvContent;
            Intrinsics.checkNotNullExpressionValue(r3, "tvContent");
            r2.a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin"), r6.d());
            b r4 = ProactiveListAdapter.e();
            MarkdownTextView r5 = this.f6688b.tvContent;
            Intrinsics.checkNotNullExpressionValue(r5, "tvContent");
            View r7 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin");
            ConstraintLayout r8 = this.f6688b.getRoot();
            Intrinsics.checkNotNullExpressionValue(r8, "getRoot(...)");
            b.a(r4, r7, (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
            this.f6688b.tvMeta.setVisibility(8);
            this.f6688b.tvNotRecommend.setVisibility(8);
            this.f6688b.basicLine.setVisibility(8);
            com.obric.aiproactive.ui.artifact.a r9 = com.obric.aiproactive.ui.artifact.a.f6542a;
            LinearLayout r10 = this.f6688b.llArtifacts;
            Intrinsics.checkNotNullExpressionValue(r10, "llArtifacts");
            r9.a(r10, r6.b().getArtifacts());
            b(r6);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Companion;", "", "<init>", "()V", "performLightTapHaptic", "", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "forwardTextInteractionToRoot", "textView", "root", "VIEW_TYPE_TIP", "", "VIEW_TYPE_NOW_PROCESSED", "VIEW_TYPE_DAY", "VIEW_TYPE_MINUTE", "VIEW_TYPE_RECOMMENDATION_ALL", "VIEW_TYPE_RECOMMENDATION_NOW", "VIEW_TYPE_RECOMMENDATION_ADOPTED", "VIEW_TYPE_END", "VIEW_TYPE_GUIDED_PREFERENCE_ENTRY", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        private final void a(View r3) {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            b r2 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
            Result.m1421constructorimpl(Boolean.valueOf(r3.performHapticFeedback(3)));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
        }

        private final void a(View r1, final View r2) {
            r1.setClickable(true);
            r1.setLongClickable(true);
            r1.setOnClickListener(new $$Lambda$ProactiveListAdapter$b$xepFE7Ih8LETNiDshbSBAqKlQv4(r2));
            r1.setOnLongClickListener(new $$Lambda$ProactiveListAdapter$b$GJKoUgI1sK6cXKLCEtN0zj_FtQ(r2));
        }

        public static final /* synthetic */ void a(b r0, View r1) {
            r0.a(r1);
        }

        public static final /* synthetic */ void a(b r0, View r1, View r2) {
            r0.a(r1, r2);
        }

        private static final void b(View r0, View r1) {
            r0.performClick();
        }

        private static final boolean c(View r0, View r1) {
            return r0.performLongClick();
        }

        /* JADX INFO: renamed from: lambda$G-JKoUgI1sK6cXKLCEtN0zj_FtQ, reason: not valid java name */
        public static /* synthetic */ boolean m304lambda$GJKoUgI1sK6cXKLCEtN0zj_FtQ(View r0, View r1) {
            return c(r0, r1);
        }

        public static /* synthetic */ void lambda$xepFE7Ih8LETNiDshbSBAqKlQv4(View r0, View r1) {
            b(r0, r1);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$DayViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/aiproactive/ui/databinding/ItemProactiveSectionHeaderBinding;", "listener", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;", "<init>", "(Lcom/obric/aiproactive/ui/databinding/ItemProactiveSectionHeaderBinding;Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;)V", "bind", "", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$DayHeader;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ItemProactiveSectionHeaderBinding f6689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f6690b;

        public c(ItemProactiveSectionHeaderBinding r4, f r5) {
            f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "binding");
            Intrinsics.checkNotNullParameter(r6, "listener");
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f6689a = r4;
            this.f6690b = r6;
        }

        private static final void a(c r0, com.obric.aiproactive.ui.model.j.a r1, View r2) {
            r0.f6690b.a(r1);
        }

        public static /* synthetic */ void lambda$9oz8ZXA7hfQZ65s9VOcArKYFW2o(c r0, com.obric.aiproactive.ui.model.j.a r1, View r2) {
            a(r0, r1, r2);
        }

        public final void a(final com.obric.aiproactive.ui.model.j.a r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            this.f6689a.tvSectionTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.d(), CharSequence.class, "com.obric.memorydata.plugin"));
            this.f6689a.tvSectionCount.setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r5.e()), CharSequence.class, "com.obric.memorydata.plugin"));
            ImageView r0 = this.f6689a.ivSectionArrow;
            if (r5.f() == false) goto L5;
            float r1 = 90.0f;
        L6:
            r0.setRotation(r1);
            this.f6689a.getRoot().setOnClickListener(new $$Lambda$ProactiveListAdapter$c$9oz8ZXA7hfQZ65s9VOcArKYFW2o(this, r5));
            return;
        L5:
            r1 = 0.0f;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$EndViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/aiproactive/ui/databinding/ItemProactiveEndBinding;", "<init>", "(Lcom/obric/aiproactive/ui/databinding/ItemProactiveEndBinding;)V", "bind", "", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$End;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ItemProactiveEndBinding f6691a;

        public d(ItemProactiveEndBinding r4) {
            Intrinsics.checkNotNullParameter(r4, "binding");
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f6691a = r4;
        }

        public final void a(com.obric.aiproactive.ui.model.j.b r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.f6691a.tvEnd.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$GuidedPreferenceEntryViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/aiproactive/ui/databinding/LayoutGuidedPreferenceEntryCardBinding;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Lcom/obric/aiproactive/ui/databinding/LayoutGuidedPreferenceEntryCardBinding;Lkotlin/jvm/functions/Function0;)V", "bind", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class e extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LayoutGuidedPreferenceEntryCardBinding f6692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function0<Unit> f6693b;

        public e(LayoutGuidedPreferenceEntryCardBinding r4, Function0<Unit> r5) {
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "binding");
            Intrinsics.checkNotNullParameter(r6, "onClick");
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f6692a = r4;
            this.f6693b = r6;
        }

        private static final void a(e r0, View r1) {
            r0.f6693b.invoke();
        }

        /* JADX INFO: renamed from: lambda$lpqCTZNrrE5-hHl78jlN81XaOag, reason: not valid java name */
        public static /* synthetic */ void m305lambda$lpqCTZNrrE5hHl78jlN81XaOag(e r0, View r1) {
            a(r0, r1);
        }

        public final void a() {
            this.f6692a.getRoot().setOnClickListener(new $$Lambda$ProactiveListAdapter$e$lpqCTZNrrE5hHl78jlN81XaOag(this));
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001f\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\bH&J\u001f\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ/\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0003H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;", "", "onTipKnown", "", "onDayHeaderClick", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$DayHeader;", "onRecommendationClick", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "rank", "", "(Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;Ljava/lang/Integer;)V", "onRecommendationLongClick", "onPrimaryActionClick", "onSummaryActionClick", "actionIndex", "action", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "(Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;Ljava/lang/Integer;ILcom/obric/aiproactive/api/AiProactiveActionExecuteItem;)V", "onIgnoreClick", "onCardShow", "onGuidedPreferenceEntryClick", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface f {

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            public static void a(f r2) {
                f r3 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
            }
        }

        void a();

        void a(com.obric.aiproactive.ui.model.j.a r1);

        void a(com.obric.aiproactive.ui.model.j.f r1);

        void a(com.obric.aiproactive.ui.model.j.f r1, Integer r2);

        void a(com.obric.aiproactive.ui.model.j.f r1, Integer r2, int r3, com.obric.aiproactive.api.b r4);

        void b();

        void b(com.obric.aiproactive.ui.model.j.f r1, Integer r2);

        void c(com.obric.aiproactive.ui.model.j.f r1, Integer r2);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$MinuteViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/aiproactive/ui/databinding/ItemProactiveMinuteHeaderBinding;", "<init>", "(Lcom/obric/aiproactive/ui/databinding/ItemProactiveMinuteHeaderBinding;)V", "bind", "", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$MinuteHeader;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class g extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ItemProactiveMinuteHeaderBinding f6694a;

        public g(ItemProactiveMinuteHeaderBinding r4) {
            Intrinsics.checkNotNullParameter(r4, "binding");
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f6694a = r4;
        }

        public final void a(com.obric.aiproactive.ui.model.j.d r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.f6694a.tvMinute.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$NowProcessedViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/aiproactive/ui/databinding/ItemProactiveNowProcessedBinding;", "<init>", "(Lcom/obric/aiproactive/ui/databinding/ItemProactiveNowProcessedBinding;)V", "bind", "", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$NowProcessed;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class h extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ItemProactiveNowProcessedBinding f6695a;

        public h(ItemProactiveNowProcessedBinding r4) {
            Intrinsics.checkNotNullParameter(r4, "binding");
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f6695a = r4;
        }

        public final void a(com.obric.aiproactive.ui.model.j.e r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.f6695a.tvMessage.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$NowRecommendationViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/aiproactive/ui/databinding/ItemProactiveRecommendationNowBinding;", "listener", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;", "voteStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore;", "<init>", "(Lcom/obric/aiproactive/ui/list/ProactiveListAdapter;Lcom/obric/aiproactive/ui/databinding/ItemProactiveRecommendationNowBinding;Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore;)V", "bind", "", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "bindSummaryActionChips", "uiState", "Lcom/obric/aiproactive/ui/list/NowRecommendationCardUiState;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class i extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProactiveListAdapter f6696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ItemProactiveRecommendationNowBinding f6697b;
        private final f t;
        private final ProactiveVoteStore u;

        public i(ProactiveListAdapter r3, ItemProactiveRecommendationNowBinding r4, f r5, ProactiveVoteStore r6) {
            f r7 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "binding");
            Intrinsics.checkNotNullParameter(r7, "listener");
            Intrinsics.checkNotNullParameter(r6, "voteStore");
            this.f6696a = r3;
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f6697b = r4;
            this.t = r7;
            this.u = r6;
        }

        private static final void a(i r0, com.obric.aiproactive.ui.model.j.f r1, ProactiveListAdapter r2, View r3) {
            r0.t.a(r1, ProactiveListAdapter.a(r2, r1, r0.o()));
        }

        private static final void a(com.obric.aiproactive.ui.list.d r1, OButton r2, i r3, com.obric.aiproactive.ui.model.j.f r4, ProactiveListAdapter r5, com.obric.aiproactive.ui.list.f r6, com.obric.aiproactive.api.b r7, View r8) {
            if (r1.i() == true) goto L5;
            return;
        L5:
            b.a(ProactiveListAdapter.e(), (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
            r3.t.a(r4, ProactiveListAdapter.a(r5, r4, r3.o()), r6.a(), r7);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v25 */
        private final void a(final com.obric.aiproactive.ui.model.j.f r18, final com.obric.aiproactive.ui.list.d r19) {
            this.f6697b.llActionItems.removeAllViews();
            int r10 = ZeusTransformUtils.getResources(this.f6697b.getRoot(), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.proactive_action_button_gap, "dimen", "proactive_action_button_gap"));
            LayoutInflater r11 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6697b.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r19.f(), Iterable.class, "com.obric.memorydata.plugin");
            final ProactiveListAdapter r12 = this.f6696a;
            Iterator r13 = r0.iterator();
            boolean r14 = false;
            int r1 = 0;
        L4:
            if (r13.hasNext() == false) goto L20;
            Object r2 = r13.next();
            int r15 = r1 + 1;
            if (r1 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            final com.obric.aiproactive.ui.list.f r6 = (com.obric.aiproactive.ui.list.f) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.ui.list.f.class, "com.obric.memorydata.plugin");
            final com.obric.aiproactive.api.b r7 = r6.b();
            String r3 = r6.c();
            View r4 = ZeusTransformUtils.inflate(r11, ZeusTransformUtils.mapRes(R.layout.item_proactive_now_action_chip, "layout", "item_proactive_now_action_chip"), (ViewGroup) ZeusTransformUtils.preCheckCast(this.f6697b.llActionItems, ViewGroup.class, "com.obric.memorydata.plugin"), r14, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.oui.button.OButton");
            final OButton r5 = (OButton) ZeusTransformUtils.preCheckCast(r4, OButton.class, "com.obric.memorydata.plugin");
            r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            r5.setEnabled(r19.i());
            r5.setSelected(r19.j());
            r5.setAlpha(1.0f);
            if (r19.j() == false) goto L11;
            r5.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(com.obric.aiproactive.ui.list.e.a(true)));
        L11:
            TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin");
            if (r1 <= 0) goto L14;
            ?? r9 = r10;
        L16:
            if (r19.h() == false) goto L18;
            int r16 = GravityCompat.END;
        L19:
            com.obric.aiproactive.ui.util.g.a(r8, r9, r16);
            r5.setOnClickListener(new $$Lambda$ProactiveListAdapter$i$_tkxGAAQvFTXWJ7PCuomm67TobU(r19, r5, this, r18, r12, r6, r7));
            this.f6697b.llActionItems.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"));
            TextView r17 = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin");
            LinearLayout r20 = this.f6697b.llActions;
            Intrinsics.checkNotNullExpressionValue(r20, "llActions");
            com.obric.aiproactive.ui.util.g.a(r17, (View) ZeusTransformUtils.preCheckCast(r20, View.class, "com.obric.memorydata.plugin"));
            r1 = r15;
            r10 = r10;
            r14 = false;
            goto L4
        L18:
            r16 = GravityCompat.START;
            goto L19
        L14:
            r9 = r14;
            goto L16
        }

        private static final void b(i r3, com.obric.aiproactive.ui.model.j.f r4, ProactiveListAdapter r5, View r6) {
            b r7 = ProactiveListAdapter.e();
            OButton r0 = r3.f6697b.btnIgnore;
            Intrinsics.checkNotNullExpressionValue(r0, "btnIgnore");
            b.a(r7, (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
            r3.t.b(r4, ProactiveListAdapter.a(r5, r4, r3.o()));
        }

        public static /* synthetic */ void lambda$_mELWp36SDPDbdpweH3ehM7SpHw(i r0, com.obric.aiproactive.ui.model.j.f r1, ProactiveListAdapter r2, View r3) {
            a(r0, r1, r2, r3);
        }

        public static /* synthetic */ void lambda$_tkxGAAQvFTXWJ7PCuomm67TobU(com.obric.aiproactive.ui.list.d r0, OButton r1, i r2, com.obric.aiproactive.ui.model.j.f r3, ProactiveListAdapter r4, com.obric.aiproactive.ui.list.f r5, com.obric.aiproactive.api.b r6, View r7) {
            a(r0, r1, r2, r3, r4, r5, r6, r7);
        }

        public static /* synthetic */ void lambda$oD4DWv0BliC06ii4HwK3HXgJ8to(i r0, com.obric.aiproactive.ui.model.j.f r1, ProactiveListAdapter r2, View r3) {
            b(r0, r1, r2, r3);
        }

        public final void a(final com.obric.aiproactive.ui.model.j.f r10) {
            Intrinsics.checkNotNullParameter(r10, "item");
            ConstraintLayout r0 = this.f6697b.getRoot();
            final ProactiveListAdapter r1 = this.f6696a;
            r0.setOnClickListener(new $$Lambda$ProactiveListAdapter$i$_mELWp36SDPDbdpweH3ehM7SpHw(this, r10, r1));
            this.f6697b.getRoot().setOnLongClickListener(null);
            int r2 = 0;
            this.f6697b.getRoot().setLongClickable(false);
            com.obric.aiproactive.ui.list.d r3 = com.obric.aiproactive.ui.list.e.a(r10);
            com.obric.aiproactive.ui.util.j r4 = com.obric.aiproactive.ui.util.j.f6886a;
            AppCompatTextView r5 = this.f6697b.tvContent;
            Intrinsics.checkNotNullExpressionValue(r5, "tvContent");
            r4.a((TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin"), r10.d());
            com.obric.aiproactive.ui.util.j r6 = com.obric.aiproactive.ui.util.j.f6886a;
            AppCompatTextView r7 = this.f6697b.tvSubtitle;
            Intrinsics.checkNotNullExpressionValue(r7, "tvSubtitle");
            r6.a((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin"), r3.c());
            com.obric.aiproactive.ui.util.j r8 = com.obric.aiproactive.ui.util.j.f6886a;
            AppCompatTextView r9 = this.f6697b.tvContent;
            Intrinsics.checkNotNullExpressionValue(r9, "tvContent");
            r8.b((TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.memorydata.plugin"));
            com.obric.aiproactive.ui.util.j r11 = com.obric.aiproactive.ui.util.j.f6886a;
            AppCompatTextView r12 = this.f6697b.tvSubtitle;
            Intrinsics.checkNotNullExpressionValue(r12, "tvSubtitle");
            r11.b((TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.memorydata.plugin"));
            l r13 = l.f6890a;
            AppCompatTextView r14 = this.f6697b.tvContent;
            Intrinsics.checkNotNullExpressionValue(r14, "tvContent");
            TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.memorydata.plugin");
            ConstraintLayout r16 = this.f6697b.getRoot();
            Intrinsics.checkNotNullExpressionValue(r16, "getRoot(...)");
            r13.a(r15, (View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"));
            l r17 = l.f6890a;
            AppCompatTextView r18 = this.f6697b.tvSubtitle;
            Intrinsics.checkNotNullExpressionValue(r18, "tvSubtitle");
            TextView r19 = (TextView) ZeusTransformUtils.preCheckCast(r18, TextView.class, "com.obric.memorydata.plugin");
            ConstraintLayout r20 = this.f6697b.getRoot();
            Intrinsics.checkNotNullExpressionValue(r20, "getRoot(...)");
            r17.a(r19, (View) ZeusTransformUtils.preCheckCast(r20, View.class, "com.obric.memorydata.plugin"));
            FrameLayout r21 = this.f6697b.contentSlot;
            if (r3.e() == false) goto L5;
            int r22 = 0;
        L6:
            r21.setVisibility(r22);
            AppCompatTextView r23 = this.f6697b.tvSubtitle;
            if (r3.d() == false) goto L9;
            int r24 = 0;
        L10:
            r23.setVisibility(r24);
            this.f6697b.tvBadgeEmoji.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.memorydata.plugin"));
            AppCompatTextView r25 = this.f6697b.tvBadgeEmoji;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L13;
            int r26 = 0;
        L14:
            r25.setVisibility(r26);
            ImageView r27 = this.f6697b.ivBadgeIcon;
            if (r3.b() == null) goto L17;
            int r28 = 0;
        L18:
            r27.setVisibility(r28);
            Integer r29 = r3.b();
            if (r29 == null) goto L21;
            this.f6697b.ivBadgeIcon.setImageResource(((Number) ZeusTransformUtils.preCheckCast(r29, Number.class, "com.obric.memorydata.plugin")).intValue());
        L21:
            this.f6697b.flBadge.setAlpha(1.0f);
            this.f6697b.tvContent.setAlpha(1.0f);
            this.f6697b.contentSlot.setAlpha(1.0f);
            this.f6697b.tvSubtitle.setAlpha(1.0f);
            com.obric.aiproactive.ui.artifact.a r30 = com.obric.aiproactive.ui.artifact.a.f6542a;
            LinearLayout r31 = this.f6697b.llArtifacts;
            Intrinsics.checkNotNullExpressionValue(r31, "llArtifacts");
            r30.a(r31, r10.b().getArtifacts());
            LinearLayout r32 = this.f6697b.llActions;
            if (r3.h() == false) goto L24;
            int r33 = GravityCompat.END;
        L25:
            r32.setGravity(r33);
            a(r10, r3);
            OButton r34 = this.f6697b.btnIgnore;
            if (r3.g() == true) goto L29;
            r2 = 8;
        L29:
            r34.setVisibility(r2);
            OButton r35 = this.f6697b.btnIgnore;
            final ProactiveListAdapter r36 = this.f6696a;
            r35.setOnClickListener(new $$Lambda$ProactiveListAdapter$i$oD4DWv0BliC06ii4HwK3HXgJ8to(this, r10, r36));
            return;
        L24:
            r33 = GravityCompat.START;
            goto L25
        L17:
            r28 = 8;
            goto L18
        L13:
            r26 = 8;
            goto L14
        L9:
            r24 = 8;
            goto L10
        L5:
            r22 = 8;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$RecommendationAdoptedViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/aiproactive/ui/databinding/ItemProactiveRecommendationAdoptedBinding;", "listener", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;", "<init>", "(Lcom/obric/aiproactive/ui/list/ProactiveListAdapter;Lcom/obric/aiproactive/ui/databinding/ItemProactiveRecommendationAdoptedBinding;Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;)V", "bind", "", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "bindAdoptedSummaryActionChips", "uiState", "Lcom/obric/aiproactive/ui/list/NowRecommendationCardUiState;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class j extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProactiveListAdapter f6698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ItemProactiveRecommendationAdoptedBinding f6699b;
        private final f t;

        public j(ProactiveListAdapter r3, ItemProactiveRecommendationAdoptedBinding r4, f r5) {
            f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "binding");
            Intrinsics.checkNotNullParameter(r6, "listener");
            this.f6698a = r3;
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f6699b = r4;
            this.t = r6;
        }

        private static final void a(j r0, com.obric.aiproactive.ui.model.j.f r1, ProactiveListAdapter r2, View r3) {
            r0.t.a(r1, ProactiveListAdapter.a(r2, r1, r0.o()));
        }

        private final void a(com.obric.aiproactive.ui.model.j.f r10, com.obric.aiproactive.ui.list.d r11) {
            this.f6699b.llActionItems.removeAllViews();
            int r12 = ZeusTransformUtils.getResources(this.f6699b.getRoot(), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.proactive_action_button_gap, "dimen", "proactive_action_button_gap"));
            LayoutInflater r1 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6699b.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.f(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            int r3 = 0;
        L4:
            if (r13.hasNext() == false) goto L13;
            Object r4 = r13.next();
            int r5 = r3 + 1;
            if (r3 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            String r6 = ((com.obric.aiproactive.ui.list.f) ZeusTransformUtils.preCheckCast(r4, com.obric.aiproactive.ui.list.f.class, "com.obric.memorydata.plugin")).c();
            View r7 = ZeusTransformUtils.inflate(r1, ZeusTransformUtils.mapRes(R.layout.item_proactive_now_action_chip, "layout", "item_proactive_now_action_chip"), (ViewGroup) ZeusTransformUtils.preCheckCast(this.f6699b.llActionItems, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.oui.button.OButton");
            OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r7, OButton.class, "com.obric.memorydata.plugin");
            r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
            r8.setEnabled(false);
            r8.setSelected(true);
            r8.setAlpha(1.0f);
            r8.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(com.obric.aiproactive.ui.list.e.a(true)));
            TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.memorydata.plugin");
            if (r3 <= 0) goto L11;
            int r14 = r12;
        L12:
            com.obric.aiproactive.ui.util.g.a(r9, r14, GravityCompat.START);
            this.f6699b.llActionItems.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
            TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.memorydata.plugin");
            LinearLayout r16 = this.f6699b.llActions;
            Intrinsics.checkNotNullExpressionValue(r16, "llActions");
            com.obric.aiproactive.ui.util.g.a(r15, (View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"));
            r3 = r5;
            goto L4
        L11:
            r14 = 0;
            goto L12
        }

        /* JADX INFO: renamed from: lambda$Ox8H-fTU9cNihuc3nywRYfu3I4o, reason: not valid java name */
        public static /* synthetic */ void m306lambda$Ox8HfTU9cNihuc3nywRYfu3I4o(j r0, com.obric.aiproactive.ui.model.j.f r1, ProactiveListAdapter r2, View r3) {
            a(r0, r1, r2, r3);
        }

        public final void a(final com.obric.aiproactive.ui.model.j.f r10) {
            Intrinsics.checkNotNullParameter(r10, "item");
            ConstraintLayout r0 = this.f6699b.getRoot();
            final ProactiveListAdapter r1 = this.f6698a;
            r0.setOnClickListener(new $$Lambda$ProactiveListAdapter$j$Ox8HfTU9cNihuc3nywRYfu3I4o(this, r10, r1));
            this.f6699b.getRoot().setOnLongClickListener(null);
            int r2 = 0;
            this.f6699b.getRoot().setLongClickable(false);
            com.obric.aiproactive.ui.list.d r3 = com.obric.aiproactive.ui.list.e.a(r10);
            com.obric.aiproactive.ui.util.j r4 = com.obric.aiproactive.ui.util.j.f6886a;
            AppCompatTextView r5 = this.f6699b.tvContent;
            Intrinsics.checkNotNullExpressionValue(r5, "tvContent");
            r4.a((TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin"), r10.d());
            com.obric.aiproactive.ui.util.j r6 = com.obric.aiproactive.ui.util.j.f6886a;
            AppCompatTextView r7 = this.f6699b.tvSubtitle;
            Intrinsics.checkNotNullExpressionValue(r7, "tvSubtitle");
            r6.a((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin"), r3.c());
            com.obric.aiproactive.ui.util.j r8 = com.obric.aiproactive.ui.util.j.f6886a;
            AppCompatTextView r9 = this.f6699b.tvContent;
            Intrinsics.checkNotNullExpressionValue(r9, "tvContent");
            r8.b((TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.memorydata.plugin"));
            com.obric.aiproactive.ui.util.j r11 = com.obric.aiproactive.ui.util.j.f6886a;
            AppCompatTextView r12 = this.f6699b.tvSubtitle;
            Intrinsics.checkNotNullExpressionValue(r12, "tvSubtitle");
            r11.b((TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.memorydata.plugin"));
            l r13 = l.f6890a;
            AppCompatTextView r14 = this.f6699b.tvContent;
            Intrinsics.checkNotNullExpressionValue(r14, "tvContent");
            TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.memorydata.plugin");
            ConstraintLayout r16 = this.f6699b.getRoot();
            Intrinsics.checkNotNullExpressionValue(r16, "getRoot(...)");
            r13.a(r15, (View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"));
            l r17 = l.f6890a;
            AppCompatTextView r18 = this.f6699b.tvSubtitle;
            Intrinsics.checkNotNullExpressionValue(r18, "tvSubtitle");
            TextView r19 = (TextView) ZeusTransformUtils.preCheckCast(r18, TextView.class, "com.obric.memorydata.plugin");
            ConstraintLayout r20 = this.f6699b.getRoot();
            Intrinsics.checkNotNullExpressionValue(r20, "getRoot(...)");
            r17.a(r19, (View) ZeusTransformUtils.preCheckCast(r20, View.class, "com.obric.memorydata.plugin"));
            FrameLayout r21 = this.f6699b.contentSlot;
            if (r3.e() == false) goto L5;
            int r22 = 0;
        L6:
            r21.setVisibility(r22);
            AppCompatTextView r23 = this.f6699b.tvSubtitle;
            if (r3.d() == false) goto L9;
            int r24 = 0;
        L10:
            r23.setVisibility(r24);
            this.f6699b.tvBadgeEmoji.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.memorydata.plugin"));
            AppCompatTextView r25 = this.f6699b.tvBadgeEmoji;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L13;
            int r26 = 0;
        L14:
            r25.setVisibility(r26);
            ImageView r27 = this.f6699b.ivBadgeIcon;
            if (r3.b() != null) goto L18;
            r2 = 8;
        L18:
            r27.setVisibility(r2);
            Integer r28 = r3.b();
            if (r28 == null) goto L21;
            this.f6699b.ivBadgeIcon.setImageResource(((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.memorydata.plugin")).intValue());
        L21:
            this.f6699b.flBadge.setAlpha(1.0f);
            this.f6699b.tvContent.setAlpha(1.0f);
            this.f6699b.contentSlot.setAlpha(1.0f);
            this.f6699b.tvSubtitle.setAlpha(1.0f);
            com.obric.aiproactive.ui.artifact.a r29 = com.obric.aiproactive.ui.artifact.a.f6542a;
            LinearLayout r30 = this.f6699b.llArtifacts;
            Intrinsics.checkNotNullExpressionValue(r30, "llArtifacts");
            r29.a(r30, r10.b().getArtifacts());
            this.f6699b.btnIgnore.setVisibility(8);
            this.f6699b.llActions.setGravity(GravityCompat.START);
            a(r10, r3);
            return;
        L13:
            r26 = 8;
            goto L14
        L9:
            r24 = 8;
            goto L10
        L5:
            r22 = 8;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$TipViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/aiproactive/ui/databinding/ItemProactiveTipBinding;", "listener", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;", "<init>", "(Lcom/obric/aiproactive/ui/databinding/ItemProactiveTipBinding;Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;)V", "bind", "", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Tip;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class k extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ItemProactiveTipBinding f6700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f6701b;

        public k(ItemProactiveTipBinding r4, f r5) {
            f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "binding");
            Intrinsics.checkNotNullParameter(r6, "listener");
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f6700a = r4;
            this.f6701b = r6;
        }

        private static final void a(k r0, View r1) {
            r0.f6701b.a();
        }

        public static /* synthetic */ void lambda$unSvNses0MEIIF15O5oDLspBZeE(k r0, View r1) {
            a(r0, r1);
        }

        public final void a(com.obric.aiproactive.ui.model.j.g r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L5;
            this.f6700a.tvTip.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        L5:
            this.f6700a.btnKnown.setOnClickListener(new $$Lambda$ProactiveListAdapter$k$unSvNses0MEIIF15O5oDLspBZeE(this));
        }
    }

    static {
        f6685a = new b(null);
    }

    public ProactiveListAdapter(Mode r3, f r4, ProactiveVoteStore r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "mode");
        Intrinsics.checkNotNullParameter(r6, "listener");
        Intrinsics.checkNotNullParameter(r5, "voteStore");
        this.f6686b = r3;
        this.c = r6;
        this.d = r5;
        this.e = CollectionsKt.emptyList();
        this.f = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Integer a(ProactiveListAdapter r0, com.obric.aiproactive.ui.model.j.f r1, int r2) {
        return r0.a(r1, r2);
    }

    private final Integer a(com.obric.aiproactive.ui.model.j.f r9, int r10) {
        Integer r11 = Integer.valueOf(r10);
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r0 >= 0) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == true) goto L16;
        r11 = null;
    L16:
        if (r11 == null) goto L18;
        int r12 = r11.intValue();
    L30:
        return com.obric.aiproactive.ui.list.g.a(this.e, r12);
    L18:
        Iterator<? extends com.obric.aiproactive.ui.model.j> r13 = this.e.iterator();
        int r2 = 0;
    L20:
        if (r13.hasNext() == false) goto L28;
        if (((com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin")).a() != r9.a()) goto L24;
        boolean r5 = true;
    L25:
        if (r5 == true) goto L26;
        r2 = r2 + 1;
        goto L20
    L26:
        r12 = r2;
        goto L30
    L24:
        r5 = false;
        goto L25
    L28:
        r12 = -1;
        goto L30
    L10:
        if (((com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(this.e.get(r0), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin")).a() != r9.a()) goto L12;
        r1 = true;
        goto L13
    L5:
        if (r0 >= ((Collection) ZeusTransformUtils.preCheckCast(this.e, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r4 = true;
        goto L8
    }

    public static final /* synthetic */ List a(ProactiveListAdapter r0) {
        return r0.e;
    }

    private static final Unit b(ProactiveListAdapter r1) {
        Function0<Unit> r0 = r1.g;
        if (r0 == null) goto L5;
        r0.invoke();
    L7:
        return Unit.INSTANCE;
    L5:
        r1.c.b();
        goto L7
    }

    public static final /* synthetic */ b e() {
        return f6685a;
    }

    /* JADX INFO: renamed from: lambda$Zzb7SZvb8062ooKkd-uF6VrOHB0, reason: not valid java name */
    public static /* synthetic */ Unit m303lambda$Zzb7SZvb8062ooKkduF6VrOHB0(ProactiveListAdapter r0) {
        return b(r0);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r5) {
        com.obric.aiproactive.ui.model.j r6 = (com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(this.e.get(r5), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiproactive.ui.model.j.g.class) == false) goto L6;
        return 1;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiproactive.ui.model.j.e.class) == false) goto L9;
        return 2;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiproactive.ui.model.j.c.class) == false) goto L12;
        return 9;
    L12:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiproactive.ui.model.j.a.class) == false) goto L15;
        return 3;
    L15:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiproactive.ui.model.j.d.class) == false) goto L18;
        return 4;
    L18:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiproactive.ui.model.j.f.class) == false) goto L29;
        if (this.f6686b != Mode.NOW) goto L25;
        if (((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r6, com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendStatus() != 2) goto L25;
        return 7;
    L25:
        if (this.f6686b != Mode.NOW) goto L27;
        return 6;
    L27:
        return 5;
    L29:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiproactive.ui.model.j.b.class) == false) goto L33;
        return 8;
    L33:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        LayoutInflater r0 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        switch(r6) {
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L4;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        ItemProactiveRecommendationBinding r7 = ItemProactiveRecommendationBinding.inflate(r0, r5, false);
        Intrinsics.checkNotNullExpressionValue(r7, "inflate(...)");
        Object r8 = new a(this, r7, this.c, this.d);
    L14:
        Object r4 = ZeusTransformUtils.preCheckCast(r8, RecyclerView.v.class, "com.obric.memorydata.plugin");
    L16:
        return (RecyclerView.v) r4;
    L5:
        LayoutGuidedPreferenceEntryCardBinding r9 = LayoutGuidedPreferenceEntryCardBinding.inflate(r0, r5, false);
        Intrinsics.checkNotNullExpressionValue(r9, "inflate(...)");
        r8 = new e(r9, new $$Lambda$ProactiveListAdapter$Zzb7SZvb8062ooKkduF6VrOHB0(this));
        goto L14
    L6:
        ItemProactiveEndBinding r10 = ItemProactiveEndBinding.inflate(r0, r5, false);
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        Object r11 = new d(r10);
    L12:
        r4 = ZeusTransformUtils.preCheckCast(r11, RecyclerView.v.class, "com.obric.memorydata.plugin");
        goto L16
    L7:
        ItemProactiveRecommendationAdoptedBinding r12 = ItemProactiveRecommendationAdoptedBinding.inflate(r0, r5, false);
        Intrinsics.checkNotNullExpressionValue(r12, "inflate(...)");
        r8 = new j(this, r12, this.c);
        goto L14
    L8:
        ItemProactiveRecommendationNowBinding r13 = ItemProactiveRecommendationNowBinding.inflate(r0, r5, false);
        Intrinsics.checkNotNullExpressionValue(r13, "inflate(...)");
        r8 = new i(this, r13, this.c, this.d);
        goto L14
    L9:
        ItemProactiveMinuteHeaderBinding r14 = ItemProactiveMinuteHeaderBinding.inflate(r0, r5, false);
        Intrinsics.checkNotNullExpressionValue(r14, "inflate(...)");
        r11 = new g(r14);
        goto L12
    L10:
        ItemProactiveSectionHeaderBinding r15 = ItemProactiveSectionHeaderBinding.inflate(r0, r5, false);
        Intrinsics.checkNotNullExpressionValue(r15, "inflate(...)");
        r8 = new c(r15, this.c);
        goto L14
    L11:
        ItemProactiveNowProcessedBinding r16 = ItemProactiveNowProcessedBinding.inflate(r0, r5, false);
        Intrinsics.checkNotNullExpressionValue(r16, "inflate(...)");
        r11 = new h(r16);
        goto L12
    L13:
        ItemProactiveTipBinding r17 = ItemProactiveTipBinding.inflate(r0, r5, false);
        Intrinsics.checkNotNullExpressionValue(r17, "inflate(...)");
        r8 = new k(r17, this.c);
        goto L14
    }

    public final List<com.obric.aiproactive.ui.model.j> a() {
        return this.e;
    }

    public final void a(LinearLayoutManager r6) {
        Intrinsics.checkNotNullParameter(r6, "layoutManager");
        int r0 = r6.o();
        int r7 = r6.p();
        if (r0 == (-1)) goto L20;
        if (r7 == (-1)) goto L23;
        if (r0 > r7) goto L22;
    L7:
        boolean r1 = false;
        if (r0 >= 0) goto L10;
    L12:
        if (r1 == false) goto L18;
        com.obric.aiproactive.ui.model.j r2 = (com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(this.e.get(r0), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiproactive.ui.model.j.f.class) == false) goto L18;
        String r3 = ((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendId();
        if (this.f.contains(r3) == true) goto L18;
        this.f.add(r3);
        this.c.c((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin"), com.obric.aiproactive.ui.list.g.a(this.e, r0));
    L18:
        if (r0 == r7) goto L24;
        r0 = r0 + 1;
        goto L7
    L24:
        return;
    L10:
        if (r0 >= ((Collection) ZeusTransformUtils.preCheckCast(this.e, Collection.class, "com.obric.memorydata.plugin")).size()) goto L12;
        r1 = true;
        goto L12
    L22:
        return;
    L23:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.a(r2);
        r2.c.animate().cancel();
        r2.c.setTranslationY(0.0f);
        r2.c.setTranslationX(0.0f);
        r2.c.setAlpha(1.0f);
        r2.c.setScaleX(1.0f);
        r2.c.setScaleY(1.0f);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        if (ZeusTransformUtils.instanceOf(r4, k.class) == false) goto L6;
        k r6 = (k) ZeusTransformUtils.preCheckCast(r4, k.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.j r3 = this.e.get(r5);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.aiproactive.ui.model.ProactiveListItem.Tip");
        r6.a((com.obric.aiproactive.ui.model.j.g) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.model.j.g.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, h.class) == false) goto L9;
        h r7 = (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.j r8 = this.e.get(r5);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.aiproactive.ui.model.ProactiveListItem.NowProcessed");
        r7.a((com.obric.aiproactive.ui.model.j.e) ZeusTransformUtils.preCheckCast(r8, com.obric.aiproactive.ui.model.j.e.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, e.class) == false) goto L12;
        ((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin")).a();
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L15;
        c r9 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.j r10 = this.e.get(r5);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.aiproactive.ui.model.ProactiveListItem.DayHeader");
        r9.a((com.obric.aiproactive.ui.model.j.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiproactive.ui.model.j.a.class, "com.obric.memorydata.plugin"));
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r4, g.class) == false) goto L18;
        g r11 = (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.j r12 = this.e.get(r5);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.obric.aiproactive.ui.model.ProactiveListItem.MinuteHeader");
        r11.a((com.obric.aiproactive.ui.model.j.d) ZeusTransformUtils.preCheckCast(r12, com.obric.aiproactive.ui.model.j.d.class, "com.obric.memorydata.plugin"));
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L21;
        a r13 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.j r14 = this.e.get(r5);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.obric.aiproactive.ui.model.ProactiveListItem.Recommendation");
        r13.a((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r14, com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin"));
        return;
    L21:
        if (ZeusTransformUtils.instanceOf(r4, i.class) == false) goto L24;
        i r15 = (i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.j r16 = this.e.get(r5);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.obric.aiproactive.ui.model.ProactiveListItem.Recommendation");
        r15.a((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r16, com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin"));
        return;
    L24:
        if (ZeusTransformUtils.instanceOf(r4, j.class) == false) goto L27;
        j r17 = (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.j r18 = this.e.get(r5);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.obric.aiproactive.ui.model.ProactiveListItem.Recommendation");
        r17.a((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r18, com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin"));
        return;
    L27:
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L38;
        d r19 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.j r20 = this.e.get(r5);
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.obric.aiproactive.ui.model.ProactiveListItem.End");
        r19.a((com.obric.aiproactive.ui.model.j.b) ZeusTransformUtils.preCheckCast(r20, com.obric.aiproactive.ui.model.j.b.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void a(List<? extends com.obric.aiproactive.ui.model.j> r4) {
        final List<? extends com.obric.aiproactive.ui.model.j> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "newItems");
        DiffUtil.DiffResult r0 = DiffUtil.calculateDiff((DiffUtil.Callback) ZeusTransformUtils.preCheckCast(new ProactiveListAdapter$submitItems$diffResult$1(this, r5), DiffUtil.Callback.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "calculateDiff(...)");
        this.e = r5;
        r0.dispatchUpdatesTo((ListUpdateCallback) ZeusTransformUtils.preCheckCast(new ProactiveListAdapter$submitItems$1(this), ListUpdateCallback.class, "com.obric.memorydata.plugin"));
    }

    public final void a(Function0<Unit> r3) {
        this.g = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public final List<com.obric.aiproactive.ui.model.j> b() {
        return this.e;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b(RecyclerView.v r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.b(r2);
        r2.c.animate().cancel();
        r2.c.setTranslationY(0.0f);
        r2.c.setTranslationX(0.0f);
        r2.c.setAlpha(1.0f);
        r2.c.setScaleX(1.0f);
        r2.c.setScaleY(1.0f);
    }

    public final void c() {
        this.f.clear();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.e.size();
    }
}
