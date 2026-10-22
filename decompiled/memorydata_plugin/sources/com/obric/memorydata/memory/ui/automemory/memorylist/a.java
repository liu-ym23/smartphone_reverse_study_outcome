package com.obric.memorydata.memory.ui.automemory.memorylist;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.database.entity.y;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.q;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003*+,B=\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J$\u0010 \u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070%J\u001c\u0010&\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0015\u0010'\u001a\u0004\u0018\u00010\u00152\u0006\u0010(\u001a\u00020\u0012¢\u0006\u0002\u0010)R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "onItemClick", "Lkotlin/Function1;", "Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;", "", "onItemLongClick", "Lkotlin/Function3;", "Landroid/view/View;", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "isSelectionMode", "", "selectedItemIds", "", "", "getItemId", "position", "", "getItemViewType", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "submitGroups", "groups", "", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListGroup;", "commitCallback", "Lkotlin/Function0;", "updateSelection", "findItemPosition", "itemId", "(J)Ljava/lang/Integer;", "DayTitleViewHolder", "CardViewHolder", "ListItemDiffCallback", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends q<com.obric.memorydata.memory.ui.automemory.memorylist.c, RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<y, Unit> f10693a;
    private final Function3<y, View, int[], Unit> c;
    private boolean d;
    private Set<Long> e;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u001e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailAdapter$CardViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "cardView", "Lcom/obric/oui/lisitem/OCardListItem;", "contentView", "Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "onItemClick", "Lkotlin/Function1;", "Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;", "", "onItemLongClick", "Lkotlin/Function3;", "Landroid/view/View;", "", "<init>", "(Lcom/obric/oui/lisitem/OCardListItem;Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "bind", "row", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem$MemoryCard;", "isSelectionMode", "", "isSelected", "updateSelection", "item", "updateItemChrome", "positionInGroup", "", "groupSize", "updateBottomGap", "hasGroupBottomGap", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0535a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C0536a f10694a = null;
        private static final DateTimeFormatter w = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OCardListItem f10695b;
        private final MarkdownTextView t;
        private final Function1<y, Unit> u;
        private final Function3<y, View, int[], Unit> v;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.a$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailAdapter$CardViewHolder$Companion;", "", "<init>", "()V", "GROUP_BOTTOM_GAP_DP", "", "TIME_FORMAT", "Ljava/time/format/DateTimeFormatter;", "getTIME_FORMAT", "()Ljava/time/format/DateTimeFormatter;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private static final class C0536a {
            private C0536a() {
            }

            public /* synthetic */ C0536a(DefaultConstructorMarker r1) {
                this();
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.a$a$b */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailAdapter$CardViewHolder$bind$3", "Lcom/obric/oui/popover/OnLongClickListenerEx;", "onLongClick", "", "view", "Landroid/view/View;", "rawPos", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b extends com.obric.oui.popover.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0535a f10696a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ y f10697b;

            b(C0535a r1, y r2) {
                this.f10696a = r1;
                this.f10697b = r2;
            }

            @Override // com.obric.oui.popover.f
            public boolean a(View r2, int[] r3) {
                Intrinsics.checkNotNullParameter(r2, "view");
                Intrinsics.checkNotNullParameter(r3, "rawPos");
                C0535a.a(this.f10696a).invoke(this.f10697b, C0535a.b(this.f10696a), r3);
                return true;
            }
        }

        static {
            f10694a = new C0536a(null);
            DateTimeFormatter r0 = DateTimeFormatter.ofPattern("HH:mm", Locale.CHINA);
            Intrinsics.checkNotNullExpressionValue(r0, "ofPattern(...)");
            w = r0;
        }

        public C0535a(OCardListItem r3, MarkdownTextView r4, Function1<? super y, Unit> r5, Function3<? super y, ? super View, ? super int[], Unit> r6) {
            Function1<y, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Function3<y, View, int[], Unit> r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "cardView");
            Intrinsics.checkNotNullParameter(r4, "contentView");
            Intrinsics.checkNotNullParameter(r7, "onItemClick");
            Intrinsics.checkNotNullParameter(r8, "onItemLongClick");
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            this.f10695b = r3;
            this.t = r4;
            this.u = r7;
            this.v = r8;
        }

        public static final /* synthetic */ Function3 a(C0535a r0) {
            return r0.v;
        }

        private final void a(int r6, int r7) {
            OCardListItem r0 = this.f10695b;
            int r1 = r7 - 1;
            int r3 = 1;
            if (r6 >= r1) goto L5;
            boolean r4 = true;
        L6:
            r0.g(r4);
            if (r7 > 1) goto L9;
            r3 = 0;
        L14:
            OCardListItem.a(this.f10695b, r3, false, 2, null);
            return;
        L9:
            if (r6 == 0) goto L14;
            if (r6 != r1) goto L13;
            r3 = 3;
            goto L14
        L13:
            r3 = 2;
            goto L14
        L5:
            r4 = false;
            goto L6
        }

        private static final void a(C0535a r0, y r1, View r2) {
            r0.u.invoke(r1);
        }

        private static final void a(C0535a r0, y r1, OCheckBox r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "<unused var>");
            r0.u.invoke(r1);
        }

        private final void a(boolean r5) {
            ViewGroup.LayoutParams r0 = this.f10695b.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r0, RecyclerView.LayoutParams.class) == false) goto L5;
            RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r0, RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin");
        L6:
            if (r1 != null) goto L8;
            r1 = new RecyclerView.LayoutParams(-1, -2);
        L8:
            if (r5 == false) goto L10;
            int r6 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        L11:
            r1.bottomMargin = r6;
            this.f10695b.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            return;
        L10:
            r6 = 0;
            goto L11
        L5:
            r1 = null;
            goto L6
        }

        public static final /* synthetic */ OCardListItem b(C0535a r0) {
            return r0.f10695b;
        }

        private static final void b(C0535a r0, y r1, View r2) {
            r0.u.invoke(r1);
        }

        /* JADX INFO: renamed from: lambda$4DNh-E7egIIOIWGA0M52J1SFnpE, reason: not valid java name */
        public static /* synthetic */ void m808lambda$4DNhE7egIIOIWGA0M52J1SFnpE(C0535a r0, y r1, View r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$XT14ip43c5Yw4CkUf9KgWtEYdT4(C0535a r0, y r1, View r2) {
            b(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$unrOMZ4wcow_3PvrZqZBe30GU1g(C0535a r0, y r1, OCheckBox r2, boolean r3) {
            a(r0, r1, r2, r3);
        }

        public final void a(final y r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "item");
            if (r3 == false) goto L16;
            OCheckBoxLayout r5 = this.f10695b.getStartCheckBox();
            if (r5 == null) goto L7;
            r5.setOnCheckedChangeListener(null);
        L7:
            this.f10695b.a(true);
            OCheckBoxLayout r6 = this.f10695b.getStartCheckBox();
            if (r6 == null) goto L10;
            r6.setChecked(r4);
        L10:
            OCheckBoxLayout r7 = this.f10695b.getStartCheckBox();
            if (r7 == null) goto L13;
            r7.setOnClickListener(new $$Lambda$a$a$XT14ip43c5Yw4CkUf9KgWtEYdT4(this, r2));
        L13:
            OCheckBoxLayout r8 = this.f10695b.getStartCheckBox();
            if (r8 == null) goto L22;
            r8.setOnCheckedChangeListener(new $$Lambda$a$a$unrOMZ4wcow_3PvrZqZBe30GU1g(this, r2));
        L22:
            this.f10695b.setSelected(r4);
            return;
        L16:
            this.f10695b.a(false);
            OCheckBoxLayout r9 = this.f10695b.getStartCheckBox();
            if (r9 == null) goto L19;
            r9.setOnClickListener(null);
        L19:
            OCheckBoxLayout r10 = this.f10695b.getStartCheckBox();
            if (r10 == null) goto L22;
            r10.setOnCheckedChangeListener(null);
            goto L22
        }

        public final void a(com.obric.memorydata.memory.ui.automemory.memorylist.c.b r13, boolean r14, boolean r15) {
            Intrinsics.checkNotNullParameter(r13, "row");
            final y r0 = r13.b();
            OTextView r1 = this.f10695b.b(1);
            if (r1 == null) goto L5;
            r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0.c(), CharSequence.class, "com.obric.memorydata.plugin"));
        L5:
            OTextView r2 = this.f10695b.b(1);
            if (r2 == null) goto L8;
            r2.setMaxLines(1);
        L8:
            OTextView r3 = this.f10695b.c(1);
            if (r3 == null) goto L11;
            r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(w.format((TemporalAccessor) ZeusTransformUtils.preCheckCast(Instant.ofEpochMilli(r0.b()).atZone(ZoneId.systemDefault()), TemporalAccessor.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin"));
        L11:
            String r4 = r0.e();
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L15;
            r4 = null;
        L15:
            if (r4 != null) goto L17;
            r4 = StringsKt.replace$default(r0.d(), "-", "", false, 4, null);
        L17:
            this.t.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
            MarkdownTextView r5 = this.t;
            ViewGroup.LayoutParams r6 = r5.getLayoutParams();
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics()));
            r5.setLayoutParams(r6);
            this.t.setMovementMethod(null);
            this.t.setMaxLines(2);
            this.t.setEllipsize(TextUtils.TruncateAt.END);
            this.t.setHorizontallyScrolling(false);
            this.t.setLineSpacing(0.0f, 1.2f);
            a(r13.c(), r13.d());
            a(r13.e());
            a(r0, r14, r15);
            this.f10695b.setOnContentClickListener(new $$Lambda$a$a$4DNhE7egIIOIWGA0M52J1SFnpE(this, r0));
            com.obric.oui.popover.a.f14317a.a((View) ZeusTransformUtils.preCheckCast(this.f10695b.getContentContainer(), View.class, "com.obric.memorydata.plugin"), (com.obric.oui.popover.f) ZeusTransformUtils.preCheckCast(new b(this, r0), com.obric.oui.popover.f.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailAdapter$DayTitleViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvDayTitle", "Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "bind", "", "item", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem$DayTitle;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OSectionTitleBar f10698a;

        public b(View r4) {
            Intrinsics.checkNotNullParameter(r4, "itemView");
            super(r4);
            View r5 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.tv_day_title, OaidModel.KEY_ID, "tv_day_title"));
            Intrinsics.checkNotNullExpressionValue(r5, "findViewById(...)");
            this.f10698a = (OSectionTitleBar) ZeusTransformUtils.preCheckCast(r5, OSectionTitleBar.class, "com.obric.memorydata.plugin");
        }

        public final void a(com.obric.memorydata.memory.ui.automemory.memorylist.c.a r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.f10698a.setTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailAdapter$ListItemDiffCallback;", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c extends com.obric.oui.orecyclerview.widget.i.e<com.obric.memorydata.memory.ui.automemory.memorylist.c> {
        public c() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(com.obric.memorydata.memory.ui.automemory.memorylist.c r4, com.obric.memorydata.memory.ui.automemory.memorylist.c r5) {
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.automemory.memorylist.c.a.class) == false) goto L8;
            if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.automemory.memorylist.c.a.class) == false) goto L8;
            return Intrinsics.areEqual(((com.obric.memorydata.memory.ui.automemory.memorylist.c.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.automemory.memorylist.c.a.class, "com.obric.memorydata.plugin")).b(), ((com.obric.memorydata.memory.ui.automemory.memorylist.c.a) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.automemory.memorylist.c.a.class, "com.obric.memorydata.plugin")).b());
        L8:
            if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class) == true) goto L10;
            return false;
        L10:
            if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class) == true) goto L12;
            return false;
        L12:
            if (((com.obric.memorydata.memory.ui.automemory.memorylist.c.b) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class, "com.obric.memorydata.plugin")).b().a() != ((com.obric.memorydata.memory.ui.automemory.memorylist.c.b) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class, "com.obric.memorydata.plugin")).b().a()) goto L18;
            return true;
        L18:
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean a(com.obric.memorydata.memory.ui.automemory.memorylist.c r3, com.obric.memorydata.memory.ui.automemory.memorylist.c r4) {
            return a2((com.obric.memorydata.memory.ui.automemory.memorylist.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.automemory.memorylist.c.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.automemory.memorylist.c) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.automemory.memorylist.c.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(com.obric.memorydata.memory.ui.automemory.memorylist.c r1, com.obric.memorydata.memory.ui.automemory.memorylist.c r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean b(com.obric.memorydata.memory.ui.automemory.memorylist.c r3, com.obric.memorydata.memory.ui.automemory.memorylist.c r4) {
            return b2((com.obric.memorydata.memory.ui.automemory.memorylist.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.automemory.memorylist.c.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.automemory.memorylist.c) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.automemory.memorylist.c.class, "com.obric.memorydata.plugin"));
        }
    }

    public a(Function1<? super y, Unit> r4, Function3<? super y, ? super View, ? super int[], Unit> r5) {
        Function1<y, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function3<y, View, int[], Unit> r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "onItemClick");
        Intrinsics.checkNotNullParameter(r7, "onItemLongClick");
        super((com.obric.oui.orecyclerview.widget.i.e) ZeusTransformUtils.preCheckCast(new c(), com.obric.oui.orecyclerview.widget.i.e.class, "com.obric.memorydata.plugin"));
        this.f10693a = r6;
        this.c = r7;
        this.e = SetsKt.emptySet();
        b_(true);
    }

    private static final void a(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final boolean a(View r0, MotionEvent r1) {
        return false;
    }

    public static /* synthetic */ boolean lambda$Uc5C8OX1ye_6Wy_iMwuCSZiegtc(View r0, MotionEvent r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$eh8-t0YcCaQ6Wrzl-2y648qkVvI, reason: not valid java name */
    public static /* synthetic */ void m807lambda$eh8t0YcCaQ6Wrzl2y648qkVvI(Function0 r0) {
        a(r0);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r2) {
        com.obric.memorydata.memory.ui.automemory.memorylist.c r1 = (com.obric.memorydata.memory.ui.automemory.memorylist.c) ZeusTransformUtils.preCheckCast(b(r2), com.obric.memorydata.memory.ui.automemory.memorylist.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.memory.ui.automemory.memorylist.c.a.class) == false) goto L6;
        return 1;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class) == false) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r22, int r23) {
        Intrinsics.checkNotNullParameter(r22, "parent");
        if (r23 != 1) goto L5;
        View r1 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.item_auto_memory_collection_day_title, "layout", "item_auto_memory_collection_day_title"), r22, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "inflate(...)");
        Object r0 = ZeusTransformUtils.preCheckCast(new b(r1), RecyclerView.v.class, "com.obric.memorydata.plugin");
    L11:
        return (RecyclerView.v) r0;
    L5:
        if (r23 != 2) goto L8;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "getContext(...)");
        OCardListItem r2 = new OCardListItem(r7, null, 0, 6, null);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RecyclerView.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r2.setCardType(0);
        OCardListItem.a(r2, 0, false, 2, null);
        r2.setDefaultCustomStartView(0);
        OCardListItem.a(r2, 1, 1, false, 4, null);
        r2.e(false);
        r2.f(false);
        r2.c(false);
        r2.d(false);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "getContext(...)");
        MarkdownTextView r6 = new MarkdownTextView(r3, null, 0, 6, null);
        r6.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        r6.setTextSize(14.0f);
        r6.setMaxLines(2);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextIsSelectable(false);
        r6.setFocusable(false);
        r6.setClickable(false);
        r6.setLongClickable(false);
        r6.setOnTouchListener($$Lambda$a$Uc5C8OX1ye_6Wy_iMwuCSZiegtc.INSTANCE);
        r2.getTitleContainer().addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), 2, new ViewGroup.LayoutParams(-1, -2));
        r0 = ZeusTransformUtils.preCheckCast(new C0535a(r2, r6, this.f10693a, this.c), RecyclerView.v.class, "com.obric.memorydata.plugin");
        goto L11
    L8:
        throw new IllegalStateException(("Unknown viewType=" + r23).toString());
    }

    public final Integer a(long r8) {
        List<com.obric.memorydata.memory.ui.automemory.memorylist.c> r7 = a();
        Intrinsics.checkNotNullExpressionValue(r7, "getCurrentList(...)");
        Iterator<com.obric.memorydata.memory.ui.automemory.memorylist.c> r9 = r7.iterator();
        boolean r0 = false;
        int r1 = 0;
    L4:
        if (r9.hasNext() == false) goto L14;
        com.obric.memorydata.memory.ui.automemory.memorylist.c r2 = (com.obric.memorydata.memory.ui.automemory.memorylist.c) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.memorydata.memory.ui.automemory.memorylist.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L15;
        r1 = r1 + 1;
    L15:
        Integer r10 = Integer.valueOf(r1);
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L18;
        r0 = true;
    L18:
        if (r0 == true) goto L24;
        return null;
    L24:
        return r10;
    L8:
        if (((com.obric.memorydata.memory.ui.automemory.memorylist.c.b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class, "com.obric.memorydata.plugin")).b().a() != r8) goto L10;
        r3 = true;
        goto L11
    L14:
        r1 = -1;
        goto L15
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        com.obric.memorydata.memory.ui.automemory.memorylist.c r8 = (com.obric.memorydata.memory.ui.automemory.memorylist.c) ZeusTransformUtils.preCheckCast(b(r7), com.obric.memorydata.memory.ui.automemory.memorylist.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.automemory.memorylist.c.a.class) == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).a((com.obric.memorydata.memory.ui.automemory.memorylist.c.a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.automemory.memorylist.c.a.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class) == false) goto L10;
        ((C0535a) ZeusTransformUtils.preCheckCast(r6, C0535a.class, "com.obric.memorydata.plugin")).a((com.obric.memorydata.memory.ui.automemory.memorylist.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class, "com.obric.memorydata.plugin"), this.d, this.e.contains(Long.valueOf(((com.obric.memorydata.memory.ui.automemory.memorylist.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class, "com.obric.memorydata.plugin")).b().a())));
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r7, int r8, List<Object> r9) {
        List<Object> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r10, "payloads");
        com.obric.memorydata.memory.ui.automemory.memorylist.c r0 = (com.obric.memorydata.memory.ui.automemory.memorylist.c) ZeusTransformUtils.preCheckCast(b(r8), com.obric.memorydata.memory.ui.automemory.memorylist.c.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L5;
    L7:
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(r3.next(), "payload_selection") == false) goto L9;
        r4 = true;
    L13:
        if (r4 == true) goto L15;
    L20:
        super.a(r7, r8, r10);
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r7, C0535a.class) == false) goto L20;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class) == false) goto L20;
        ((C0535a) ZeusTransformUtils.preCheckCast(r7, C0535a.class, "com.obric.memorydata.plugin")).a(((com.obric.memorydata.memory.ui.automemory.memorylist.c.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class, "com.obric.memorydata.plugin")).b(), this.d, this.e.contains(Long.valueOf(((com.obric.memorydata.memory.ui.automemory.memorylist.c.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.automemory.memorylist.c.b.class, "com.obric.memorydata.plugin")).b().a())));
        return;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final void a(List<com.obric.memorydata.memory.ui.automemory.memorylist.b> r3, Function0<Unit> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        final Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "groups");
        Intrinsics.checkNotNullParameter(r6, "commitCallback");
        a(f.a(r5), new $$Lambda$a$eh8t0YcCaQ6Wrzl2y648qkVvI(r6));
    }

    public final void a(boolean r3, Set<Long> r4) {
        Set<Long> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "selectedItemIds");
        this.d = r3;
        this.e = r5;
        if (d() <= 0) goto L6;
        a(0, d(), "payload_selection");
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long c(int r2) {
        return ((com.obric.memorydata.memory.ui.automemory.memorylist.c) ZeusTransformUtils.preCheckCast(b(r2), com.obric.memorydata.memory.ui.automemory.memorylist.c.class, "com.obric.memorydata.plugin")).a();
    }
}
