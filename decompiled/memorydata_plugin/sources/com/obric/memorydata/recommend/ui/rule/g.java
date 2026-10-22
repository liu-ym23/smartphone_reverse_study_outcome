package com.obric.memorydata.recommend.ui.rule;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.q;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0017\u0018\u0019B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u001c\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/RuleMemorySettingAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/recommend/settings/CategoryInfo;", "Lcom/obric/memorydata/recommend/ui/rule/RuleMemorySettingAdapter$CategoryListViewHolder;", "context", "Landroid/content/Context;", "onCategorySettingChanged", "Lkotlin/Function2;", "", "", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "switchStatus", "item", "isChecked", "Companion", "CategoryListViewHolder", "AppSettingDiffCallback", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g extends q<com.obric.memorydata.recommend.settings.h, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12748a = null;
    private final Context c;
    private final Function2<Integer, Boolean, Unit> d;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/RuleMemorySettingAdapter$AppSettingDiffCallback;", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/recommend/settings/CategoryInfo;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a extends com.obric.oui.orecyclerview.widget.i.e<com.obric.memorydata.recommend.settings.h> {
        public a() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(com.obric.memorydata.recommend.settings.h r1, com.obric.memorydata.recommend.settings.h r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            if (r1.b() != r2.b()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean a(com.obric.memorydata.recommend.settings.h r3, com.obric.memorydata.recommend.settings.h r4) {
            return a2((com.obric.memorydata.recommend.settings.h) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.recommend.settings.h.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.recommend.settings.h) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.recommend.settings.h.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(com.obric.memorydata.recommend.settings.h r1, com.obric.memorydata.recommend.settings.h r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean b(com.obric.memorydata.recommend.settings.h r3, com.obric.memorydata.recommend.settings.h r4) {
            return b2((com.obric.memorydata.recommend.settings.h) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.recommend.settings.h.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.recommend.settings.h) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.recommend.settings.h.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/RuleMemorySettingAdapter$CategoryListViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "switch", "Lcom/obric/oui/lisitem/OCardListItem;", "<init>", "(Lcom/obric/memorydata/recommend/ui/rule/RuleMemorySettingAdapter;Lcom/obric/oui/lisitem/OCardListItem;)V", "getSwitch", "()Lcom/obric/oui/lisitem/OCardListItem;", "bindView", "", "item", "Lcom/obric/memorydata/recommend/settings/CategoryInfo;", "index", "", LBSLightLocationTraceLogger.TOTAL, "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class b extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f12749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OCardListItem f12750b;

        public b(g r2, OCardListItem r3) {
            Intrinsics.checkNotNullParameter(r3, "switch");
            this.f12749a = r2;
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            this.f12750b = r3;
        }

        private static final void a(g r0, com.obric.memorydata.recommend.settings.h r1, CompoundButton r2, boolean r3) {
            g.a(r0, r1, r3);
            g.a(r0).invoke(Integer.valueOf(r1.b()), Boolean.valueOf(r3));
        }

        public static /* synthetic */ void lambda$So_pKZpRJtCnuzWHKwc7dTnVdqg(g r0, com.obric.memorydata.recommend.settings.h r1, CompoundButton r2, boolean r3) {
            a(r0, r1, r2, r3);
        }

        public final void a(final com.obric.memorydata.recommend.settings.h r6, int r7, int r8) {
            Intrinsics.checkNotNullParameter(r6, "item");
            OCardListItem r0 = this.f12750b;
            final g r5 = this.f12749a;
            if (r8 >= 2) goto L5;
            OCardListItem.a(r0, 0, false, 2, null);
        L12:
            r0.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r6.a(), CharSequence.class, "com.obric.memorydata.plugin"));
            OSwitch r9 = r0.getEndSwitch();
            if (r9 == null) goto L16;
            r9.setOnCheckedChangeListener(null);
            r9.setChecked(r6.c());
            r9.setOnCheckedChangeListener(new $$Lambda$g$b$So_pKZpRJtCnuzWHKwc7dTnVdqg(r5, r6));
            return;
        L16:
            return;
        L5:
            if (r7 != 0) goto L8;
            OCardListItem.a(r0, 1, false, 2, null);
            goto L12
        L8:
            if (r7 != (r8 - 1)) goto L10;
            OCardListItem.a(r0, 3, false, 2, null);
            goto L12
        L10:
            OCardListItem.a(r0, 2, false, 2, null);
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/RuleMemorySettingAdapter$Companion;", "", "<init>", "()V", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12748a = new c(null);
    }

    public g(Context r4, Function2<? super Integer, ? super Boolean, Unit> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Function2<Integer, Boolean, Unit> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "onCategorySettingChanged");
        super((com.obric.oui.orecyclerview.widget.i.e) ZeusTransformUtils.preCheckCast(new a(), com.obric.oui.orecyclerview.widget.i.e.class, "com.obric.memorydata.plugin"));
        this.c = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.d = r7;
    }

    public static final /* synthetic */ Function2 a(g r0) {
        return r0.d;
    }

    private final void a(com.obric.memorydata.recommend.settings.h r10, boolean r11) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GuideAppCategoryAdapter", "switchStatus " + r10.a() + ", isChecked: " + r11, false, 4, null);
        List<com.obric.memorydata.recommend.settings.h> r9 = a();
        Intrinsics.checkNotNullExpressionValue(r9, "getCurrentList(...)");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Object r0 = r12.next();
        if (((com.obric.memorydata.recommend.settings.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.recommend.settings.h.class, "com.obric.memorydata.plugin")).b() != r10.b()) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L12:
        com.obric.memorydata.recommend.settings.h r13 = (com.obric.memorydata.recommend.settings.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.recommend.settings.h.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L21;
        r13.a(r11);
        return;
    L21:
        return;
    L8:
        r1 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    public static final /* synthetic */ void a(g r0, com.obric.memorydata.recommend.settings.h r1, boolean r2) {
        r0.a(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(b r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        com.obric.memorydata.recommend.settings.h r0 = (com.obric.memorydata.recommend.settings.h) ZeusTransformUtils.preCheckCast(b(r10), com.obric.memorydata.recommend.settings.h.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GuideAppCategoryAdapter", "onBindViewHolder item " + r0.a(), false, 4, null);
        Intrinsics.checkNotNull(r0);
        r9.a(r0, r10, d());
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"), r4);
    }

    public b b(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        OCardListItem r9 = new OCardListItem(this.c, null, 0, 6, null);
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r9.setCardType(0);
        OCardListItem.a(r9, 0, false, 2, null);
        r9.setDefaultCustomEndView(1);
        r9.e(true);
        r9.f(false);
        return new b(this, r9);
    }
}
