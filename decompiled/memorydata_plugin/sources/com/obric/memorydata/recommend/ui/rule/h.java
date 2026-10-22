package com.obric.memorydata.recommend.ui.rule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import com.obric.memorydata.database.entity.BlockMemoryContentEntity;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ItemBlockMemoryTitleBinding;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.bb;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "viewModel", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentViewModel;", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentViewModel;Landroidx/fragment/app/FragmentActivity;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "showEditCustomContentDialog", "item", "Lcom/obric/memorydata/database/entity/BlockMemoryContentEntity;", "Companion", "TitleViewHolder", "AbsItemRuleViewHolder", "DefaultViewHolder", "CustomViewHolder", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h extends q<com.obric.memorydata.recommend.ui.rule.a, RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12751a = null;
    private final BlockMemoryContentViewModel c;
    private final FragmentActivity d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b¦\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter$AbsItemRuleViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "listItem", "Lcom/obric/oui/lisitem/OCardListItem;", "<init>", "(Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter;Lcom/obric/oui/lisitem/OCardListItem;)V", "getListItem", "()Lcom/obric/oui/lisitem/OCardListItem;", "bind", "", "itemContent", "", "isFirstItem", "", "isLastItem", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public abstract class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f12752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OCardListItem f12753b;

        public a(h r2, OCardListItem r3) {
            Intrinsics.checkNotNullParameter(r3, "listItem");
            this.f12752a = r2;
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            this.f12753b = r3;
        }

        public final OCardListItem a() {
            return this.f12753b;
        }

        public final void a(String r4, boolean r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "itemContent");
            OCardListItem r3 = this.f12753b;
            if (r5 == false) goto L6;
            if (r6 == false) goto L6;
            int r7 = 0;
        L11:
            OCardListItem.a(r3, r7, false, 2, null);
            r3.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
            r3.setIcon(ZeusTransformUtils.mapRes(R.drawable.ic_block_screen_memory_rule, "drawable", "ic_block_screen_memory_rule"));
            r3.c(true);
            r3.b(true);
            return;
        L6:
            if (r5 == false) goto L8;
            r7 = 1;
            goto L11
        L8:
            if (r6 == false) goto L10;
            r7 = 3;
            goto L11
        L10:
            r7 = 2;
            goto L11
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter$Companion;", "", "<init>", "()V", "VIEW_TYPE_TITLE", "", "VIEW_TYPE_DEFAULT", "VIEW_TYPE_CUSTOM", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter$CustomViewHolder;", "Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter$AbsItemRuleViewHolder;", "Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter;", "listItem", "Lcom/obric/oui/lisitem/OCardListItem;", "<init>", "(Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter;Lcom/obric/oui/lisitem/OCardListItem;)V", "bind", "", "item", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem$Custom;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f12754b;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/recommend/ui/rule/ShieldContentAdapter$CustomViewHolder$bind$1", "Lcom/obric/oui/popover/OnLongClickListenerEx;", "onLongClick", "", "view", "Landroid/view/View;", "rawPos", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends com.obric.oui.popover.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f12755a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.memorydata.recommend.ui.rule.a.C0686a f12756b;
            final /* synthetic */ h c;

            a(c r1, com.obric.memorydata.recommend.ui.rule.a.C0686a r2, h r3) {
                this.f12755a = r1;
                this.f12756b = r2;
                this.c = r3;
            }

            private static final Unit a(h r1, BlockMemoryContentEntity r2) {
                Intrinsics.checkNotNullParameter(r2, "it");
                h.b(r1).deleteCustomShieldContent(r2);
                return Unit.INSTANCE;
            }

            private static final Unit a(h r2, com.obric.memorydata.recommend.ui.rule.a.C0686a r3, BlockMemoryContentEntity r4) {
                Intrinsics.checkNotNullParameter(r4, "it");
                h.a(r2, (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(h.a(r2), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), r3.a());
                return Unit.INSTANCE;
            }

            public static /* synthetic */ Unit lambda$5SUv43vbT6c5BGuvCkKxjIhJPNU(h r0, BlockMemoryContentEntity r1) {
                return a(r0, r1);
            }

            public static /* synthetic */ Unit lambda$fIrHt999tc7eH8FNNomgLiTclok(h r0, com.obric.memorydata.recommend.ui.rule.a.C0686a r1, BlockMemoryContentEntity r2) {
                return a(r0, r1, r2);
            }

            @Override // com.obric.oui.popover.f
            public boolean a(View r10, int[] r11) {
                Intrinsics.checkNotNullParameter(r10, "view");
                Intrinsics.checkNotNullParameter(r11, "rawPos");
                View r12 = this.f12755a.c;
                Intrinsics.checkNotNullExpressionValue(r12, "itemView");
                ViewParent r0 = this.f12755a.c.getParent();
                if (ZeusTransformUtils.instanceOf(r0, RecyclerView.class) == false) goto L5;
                RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r0, RecyclerView.class, "com.obric.memorydata.plugin");
            L7:
                if (bb.a(r12, r1) == false) goto L9;
                int r13 = 80;
            L10:
                View r4 = (View) ZeusTransformUtils.preCheckCast(this.f12755a.a().getContentContainer(), View.class, "com.obric.memorydata.plugin");
                BlockMemoryContentEntity r6 = this.f12756b.a();
                final h r2 = this.c;
                Function1 r7 = new $$Lambda$h$c$a$5SUv43vbT6c5BGuvCkKxjIhJPNU(r2);
                final h r3 = this.c;
                final com.obric.memorydata.recommend.ui.rule.a.C0686a r9 = this.f12756b;
                new com.obric.memorydata.recommend.ui.rule.c(r4, r11, r6, r7, new $$Lambda$h$c$a$fIrHt999tc7eH8FNNomgLiTclok(r3, r9)).a(r13);
                return true;
            L9:
                r13 = 48;
                goto L10
            L5:
                r1 = null;
                goto L7
            }
        }

        public c(h r2, OCardListItem r3) {
            Intrinsics.checkNotNullParameter(r3, "listItem");
            this.f12754b = r2;
            super(r2, r3);
        }

        public final void a(com.obric.memorydata.recommend.ui.rule.a.C0686a r6) {
            Intrinsics.checkNotNullParameter(r6, "item");
            super.a(r6.a().getContent(), r6.b(), r6.c());
            com.obric.oui.popover.a.f14317a.a((View) ZeusTransformUtils.preCheckCast(a().getContentContainer(), View.class, "com.obric.memorydata.plugin"), (com.obric.oui.popover.f) ZeusTransformUtils.preCheckCast(new a(this, r6, this.f12754b), com.obric.oui.popover.f.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter$DefaultViewHolder;", "Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter$AbsItemRuleViewHolder;", "Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter;", "listItem", "Lcom/obric/oui/lisitem/OCardListItem;", "<init>", "(Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter;Lcom/obric/oui/lisitem/OCardListItem;)V", "bind", "", "item", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem$Default;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class d extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f12757b;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/recommend/ui/rule/ShieldContentAdapter$DefaultViewHolder$bind$1", "Lcom/obric/oui/popover/OnLongClickListenerEx;", "onLongClick", "", "view", "Landroid/view/View;", "rawPos", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends com.obric.oui.popover.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ h f12758a;

            a(h r1) {
                this.f12758a = r1;
            }

            @Override // com.obric.oui.popover.f
            public boolean a(View r7, int[] r8) {
                Intrinsics.checkNotNullParameter(r7, "view");
                Intrinsics.checkNotNullParameter(r8, "rawPos");
                com.obric.oui.toast.a.C0786a.a(com.obric.oui.toast.a.f14807a, (Context) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(h.a(this.f12758a), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), at.a(ZeusTransformUtils.mapRes(R.string.screen_observation_default_rule_long_click_tips, TypedValues.Custom.S_STRING, "screen_observation_default_rule_long_click_tips")), 0, 4, null);
                return true;
            }
        }

        public d(h r2, OCardListItem r3) {
            Intrinsics.checkNotNullParameter(r3, "listItem");
            this.f12757b = r2;
            super(r2, r3);
        }

        public final void a(com.obric.memorydata.recommend.ui.rule.a.b r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            super.a(r4.a(), r4.b(), r4.c());
            com.obric.oui.popover.a.f14317a.a((View) ZeusTransformUtils.preCheckCast(a().getContentContainer(), View.class, "com.obric.memorydata.plugin"), (com.obric.oui.popover.f) ZeusTransformUtils.preCheckCast(new a(this.f12757b), com.obric.oui.popover.f.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter$TitleViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/memorydata/recommend/databinding/ItemBlockMemoryTitleBinding;", "<init>", "(Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter;Lcom/obric/memorydata/recommend/databinding/ItemBlockMemoryTitleBinding;)V", "bind", "", "item", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem$Title;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class e extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f12759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ItemBlockMemoryTitleBinding f12760b;

        public e(h r3, ItemBlockMemoryTitleBinding r4) {
            Intrinsics.checkNotNullParameter(r4, "binding");
            this.f12759a = r3;
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f12760b = r4;
        }

        public final void a(com.obric.memorydata.recommend.ui.rule.a.c r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.f12760b.tvTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f12751a = new b(null);
    }

    public h(BlockMemoryContentViewModel r4, FragmentActivity r5) {
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r5, FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r6, "activity");
        super((com.obric.oui.orecyclerview.widget.i.e) ZeusTransformUtils.preCheckCast(new i(), com.obric.oui.orecyclerview.widget.i.e.class, "com.obric.memorydata.plugin"));
        this.c = r4;
        this.d = r6;
    }

    public static final /* synthetic */ FragmentActivity a(h r0) {
        return r0.d;
    }

    private static final Unit a(h r1, BlockMemoryContentEntity r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "validatedContent");
        r1.c.updateEntity(r2, r3);
        return Unit.INSTANCE;
    }

    private final void a(FragmentActivity r10, final BlockMemoryContentEntity r11) {
        new com.obric.memorydata.recommend.ui.rule.d((FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r10, FragmentActivity.class, "com.obric.memorydata.plugin"), false, r11.getContent(), null, new $$Lambda$h$lEPB2gquJSylDeidjt1L9aRxmP4(this, r11), true, 10, null).a();
    }

    public static final /* synthetic */ void a(h r2, FragmentActivity r3, BlockMemoryContentEntity r4) {
        r2.a((FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin"), r4);
    }

    public static final /* synthetic */ BlockMemoryContentViewModel b(h r0) {
        return r0.c;
    }

    public static /* synthetic */ Unit lambda$lEPB2gquJSylDeidjt1L9aRxmP4(h r0, BlockMemoryContentEntity r1, String r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r2) {
        com.obric.memorydata.recommend.ui.rule.a r1 = (com.obric.memorydata.recommend.ui.rule.a) ZeusTransformUtils.preCheckCast(b(r2), com.obric.memorydata.recommend.ui.rule.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.recommend.ui.rule.a.c.class) == false) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.recommend.ui.rule.a.b.class) == false) goto L9;
        return 1;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.recommend.ui.rule.a.C0686a.class) == false) goto L13;
        return 2;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "parent");
        LayoutInflater r3 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r19 != 0) goto L5;
        ItemBlockMemoryTitleBinding r1 = ItemBlockMemoryTitleBinding.inflate(r3, r18, false);
        Intrinsics.checkNotNullExpressionValue(r1, "inflate(...)");
        Object r0 = ZeusTransformUtils.preCheckCast(new e(this, r1), RecyclerView.v.class, "com.obric.memorydata.plugin");
    L14:
        return (RecyclerView.v) r0;
    L5:
        if (r19 == 1) goto L10;
        if (r19 != 2) goto L9;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, "getContext(...)");
        OCardListItem r2 = new OCardListItem(r12, null, 0, 6, null);
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r2.setCardType(0);
        OCardListItem.a(r2, 0, false, 2, null);
        r2.f(false);
        Object r4 = new c(this, r2);
    L11:
        r0 = ZeusTransformUtils.preCheckCast(r4, RecyclerView.v.class, "com.obric.memorydata.plugin");
        goto L14
    L9:
        throw new IllegalArgumentException("Invalid view type");
    L10:
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r13, "getContext(...)");
        OCardListItem r5 = new OCardListItem(r13, null, 0, 6, null);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r5.setCardType(0);
        OCardListItem.a(r5, 0, false, 2, null);
        r5.f(false);
        r4 = new d(this, r5);
        goto L11
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        com.obric.memorydata.recommend.ui.rule.a r2 = (com.obric.memorydata.recommend.ui.rule.a) ZeusTransformUtils.preCheckCast(b(r4), com.obric.memorydata.recommend.ui.rule.a.class, "com.obric.memorydata.plugin");
        c r1 = null;
        e r5 = null;
        d r6 = null;
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.recommend.ui.rule.a.c.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L7;
        r5 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin");
    L7:
        if (r5 == null) goto L26;
        r5.a((com.obric.memorydata.recommend.ui.rule.a.c) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.recommend.ui.rule.a.c.class, "com.obric.memorydata.plugin"));
        return;
    L26:
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.recommend.ui.rule.a.b.class) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L14;
        r6 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
    L14:
        if (r6 == null) goto L28;
        r6.a((com.obric.memorydata.recommend.ui.rule.a.b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.recommend.ui.rule.a.b.class, "com.obric.memorydata.plugin"));
        return;
    L28:
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.recommend.ui.rule.a.C0686a.class) == false) goto L25;
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L21;
        r1 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin");
    L21:
        if (r1 == null) goto L30;
        r1.a((com.obric.memorydata.recommend.ui.rule.a.C0686a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.recommend.ui.rule.a.C0686a.class, "com.obric.memorydata.plugin"));
        return;
    L30:
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    }
}
