package com.obric.memorydata.recommend.guide;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.i;
import com.obric.oui.orecyclerview.widget.q;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000545678B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020#H\u0016J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J&\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\u0014\u0010,\u001a\u00020\u000b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.J\u0018\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/recommend/guide/GuideAppRow;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "onAppSettingChanged", "Lkotlin/Function2;", "", "", "", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "getItemViewType", "", "position", "getItemId", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "marginHandler", "Landroid/view/ViewGroup$MarginLayoutParams;", "getMarginHandler", "()Lkotlin/jvm/functions/Function2;", "setMarginHandler", "(Lkotlin/jvm/functions/Function2;)V", "cardType", "getCardType", "()I", "setCardType", "(I)V", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "onAttachedToRecyclerView", "rv", "onDetachedFromRecyclerView", "onBindViewHolder", "holder", "payloads", "", "", "submitCategories", "categories", "", "Lcom/obric/memorydata/recommend/settings/CategoryItem;", "expandTouchArea", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "extraDp", "Companion", "HeaderViewHolder", "DescViewHolder", "AppViewHolder", "RowDiff", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends q<com.obric.memorydata.recommend.guide.b, RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12511a = null;
    private final Context c;
    private final Function2<Set<String>, Boolean, Unit> d;
    private Function2<? super ViewGroup.MarginLayoutParams, ? super Integer, Unit> e;
    private int f;
    private RecyclerView g;

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.guide.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter$AppViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "switch", "Lcom/obric/oui/lisitem/OCardListItem;", "<init>", "(Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter;Lcom/obric/oui/lisitem/OCardListItem;)V", "getSwitch", "()Lcom/obric/oui/lisitem/OCardListItem;", "setChecked", "", "bind", "row", "Lcom/obric/memorydata/recommend/guide/GuideAppRow$App;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class C0671a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f12512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OCardListItem f12513b;

        public C0671a(a r2, OCardListItem r3) {
            Intrinsics.checkNotNullParameter(r3, "switch");
            this.f12512a = r2;
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            this.f12513b = r3;
        }

        private static final void a(com.obric.memorydata.recommend.settings.c r0, a r1, CompoundButton r2, boolean r3) {
            if (r3 == r0.d()) goto L6;
            a.a(r1).invoke(SetsKt.setOf(r0.b()), Boolean.valueOf(r3));
            return;
        }

        public static /* synthetic */ void lambda$sGPQZWGVpGOoCIcElFXp86Ug3Bk(com.obric.memorydata.recommend.settings.c r0, a r1, CompoundButton r2, boolean r3) {
            a(r0, r1, r2, r3);
        }

        public final void a() {
            OSwitch r1 = this.f12513b.getEndSwitch();
            if (r1 == null) goto L6;
            r1.setChecked(true);
            return;
        }

        public final void a(com.obric.memorydata.recommend.guide.b.a r24) {
            Intrinsics.checkNotNullParameter(r24, "row");
            RunLog.INSTANCE.debug("GuideAppFlattenAdapter", "bind row: " + r24);
            final com.obric.memorydata.recommend.settings.c r2 = r24.a();
            OCardListItem r3 = this.f12513b;
            final a r4 = this.f12512a;
            OSwitch r5 = r3.getEndSwitch();
            if (r5 == null) goto L6;
            r5.setOnCheckedChangeListener(null);
        L6:
            if (r24.c() >= 2) goto L8;
            OCardListItem.a(r3, 0, false, 2, null);
        L15:
            com.obric.memorydata.utils.icon.b r10 = com.obric.memorydata.utils.icon.b.f13229a;
            Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r11, "getContext(...)");
            com.obric.memorydata.utils.icon.b.a(r10, r11, r3.getIconView(), r2.b(), null, 0, null, null, null, null, false, 1016, null);
            r3.b(true);
            r3.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin"));
            r3.c(true);
            OSwitch r0 = r3.getEndSwitch();
            if (r0 == null) goto L18;
            r0.setChecked(r2.d());
        L18:
            r3.setEnabled(r2.c());
            OSwitch r1 = r3.getEndSwitch();
            if (r1 == null) goto L22;
            r1.setOnCheckedChangeListener(new $$Lambda$a$a$sGPQZWGVpGOoCIcElFXp86Ug3Bk(r2, r4));
            return;
        L22:
            return;
        L8:
            if (r24.b() != 0) goto L11;
            OCardListItem.a(r3, 1, false, 2, null);
            goto L15
        L11:
            if (r24.b() != (r24.c() - 1)) goto L13;
            OCardListItem.a(r3, 3, false, 2, null);
            goto L15
        L13:
            OCardListItem.a(r3, 2, false, 2, null);
            goto L15
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter$Companion;", "", "<init>", "()V", "TAG", "", "TYPE_HEADER", "", "TYPE_APP", "TYPE_DESC", "OPEN_ALL", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter$DescViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter;Landroid/view/View;)V", "desc", "Landroid/widget/TextView;", "bind", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class c extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f12514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextView f12515b;

        public c(a r3, View r4) {
            Intrinsics.checkNotNullParameter(r4, "itemView");
            this.f12514a = r3;
            super(r4);
            View r5 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.tv_guide_app_desc, OaidModel.KEY_ID, "tv_guide_app_desc"));
            Intrinsics.checkNotNullExpressionValue(r5, "findViewById(...)");
            this.f12515b = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin");
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            this.f12515b.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter$HeaderViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter;Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "openAll", "bind", "", ActivityLifecycle.NAME, "", "onOpenAll", "Lkotlin/Function1;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class d extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f12516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextView f12517b;
        private final TextView t;

        public d(a r5, View r6) {
            Intrinsics.checkNotNullParameter(r6, "itemView");
            this.f12516a = r5;
            super(r6);
            View r7 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.tv_guide_app_category, OaidModel.KEY_ID, "tv_guide_app_category"));
            Intrinsics.checkNotNullExpressionValue(r7, "findViewById(...)");
            this.f12517b = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin");
            View r8 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.tv_guide_app_open_all, OaidModel.KEY_ID, "tv_guide_app_open_all"));
            Intrinsics.checkNotNullExpressionValue(r8, "findViewById(...)");
            this.t = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.memorydata.plugin");
        }

        private static final void a(Function1 r1, String r2, View r3) {
            ((Function1) ZeusTransformUtils.wrapperContextForParams(r1, Function1.class, "com.obric.memorydata.plugin")).invoke(r2);
        }

        public static /* synthetic */ void lambda$BtnFmxqh54pZEBuOTsicu4QfQng(Function1 r0, String r1, View r2) {
            a(r0, r1, r2);
        }

        public final void a(final String r4, Function1<? super String, Unit> r5) {
            final Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r6, "onOpenAll");
            this.f12517b.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
            this.t.setOnClickListener(new $$Lambda$a$d$BtnFmxqh54pZEBuOTsicu4QfQng(r6, r4));
            a.a(this.f12516a, (View) ZeusTransformUtils.preCheckCast(this.t, View.class, "com.obric.memorydata.plugin"), 24);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter$RowDiff;", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/recommend/guide/GuideAppRow;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class e extends i.e<com.obric.memorydata.recommend.guide.b> {
        public e() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(com.obric.memorydata.recommend.guide.b r2, com.obric.memorydata.recommend.guide.b r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItem");
            Intrinsics.checkNotNullParameter(r3, "newItem");
            if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.recommend.guide.b.c.class) == false) goto L9;
            if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.recommend.guide.b.c.class) == false) goto L9;
            String r1 = ((com.obric.memorydata.recommend.guide.b.c) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.recommend.guide.b.c.class, "com.obric.memorydata.plugin")).a();
            String r4 = ((com.obric.memorydata.recommend.guide.b.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.recommend.guide.b.c.class, "com.obric.memorydata.plugin")).a();
        L20:
            return Intrinsics.areEqual(r1, r4);
        L9:
            if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.recommend.guide.b.C0672b.class) == false) goto L14;
            if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.recommend.guide.b.C0672b.class) == false) goto L14;
            r1 = ((com.obric.memorydata.recommend.guide.b.C0672b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.recommend.guide.b.C0672b.class, "com.obric.memorydata.plugin")).a();
            r4 = ((com.obric.memorydata.recommend.guide.b.C0672b) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.recommend.guide.b.C0672b.class, "com.obric.memorydata.plugin")).a();
        L14:
            if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.recommend.guide.b.a.class) == true) goto L16;
        L18:
            return false;
        L16:
            if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.recommend.guide.b.a.class) == false) goto L18;
            r1 = ((com.obric.memorydata.recommend.guide.b.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.recommend.guide.b.a.class, "com.obric.memorydata.plugin")).a().b();
            r4 = ((com.obric.memorydata.recommend.guide.b.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.recommend.guide.b.a.class, "com.obric.memorydata.plugin")).a().b();
            goto L20
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean a(com.obric.memorydata.recommend.guide.b r3, com.obric.memorydata.recommend.guide.b r4) {
            return a2((com.obric.memorydata.recommend.guide.b) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.recommend.guide.b.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.recommend.guide.b) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.recommend.guide.b.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(com.obric.memorydata.recommend.guide.b r1, com.obric.memorydata.recommend.guide.b r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean b(com.obric.memorydata.recommend.guide.b r3, com.obric.memorydata.recommend.guide.b r4) {
            return b2((com.obric.memorydata.recommend.guide.b) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.recommend.guide.b.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.recommend.guide.b) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.recommend.guide.b.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f12511a = new b(null);
    }

    public a(Context r4, Function2<? super Set<String>, ? super Boolean, Unit> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Function2<Set<String>, Boolean, Unit> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "onAppSettingChanged");
        super((i.e) ZeusTransformUtils.preCheckCast(new e(), i.e.class, "com.obric.memorydata.plugin"));
        this.c = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.d = r7;
        b_(true);
    }

    private static final Unit a(a r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "catName");
        Set<String> r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        int r1 = r9.d();
        int r3 = 0;
        int r5 = 0;
        int r6 = -1;
    L3:
        if (r3 >= r1) goto L12;
        com.obric.memorydata.recommend.guide.b r7 = (com.obric.memorydata.recommend.guide.b) ZeusTransformUtils.preCheckCast(r9.b(r3), com.obric.memorydata.recommend.guide.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.recommend.guide.b.a.class) == false) goto L11;
        if (Intrinsics.areEqual(((com.obric.memorydata.recommend.guide.b.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.recommend.guide.b.a.class, "com.obric.memorydata.plugin")).a().e(), r10) == false) goto L11;
        if (r6 != (-1)) goto L10;
        r6 = r3;
    L10:
        r5 = r5 + 1;
        r0.add(((com.obric.memorydata.recommend.guide.b.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.recommend.guide.b.a.class, "com.obric.memorydata.plugin")).a().b());
    L11:
        r3 = r3 + 1;
        goto L3
    L12:
        r9.d.invoke(r0, true);
        if (r6 < 0) goto L17;
        if (r5 <= 0) goto L17;
        r9.a(r6, r5, "open_all");
    L17:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Function2 a(a r0) {
        return r0.d;
    }

    private final void a(final View r3, final int r4) {
        ViewParent r2 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L5;
        final View r5 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        r5.post(new $$Lambda$a$PCpnHnqpDF83MbVqrHSI965gPgM(r3, r4, r5));
        return;
    L5:
        r5 = null;
        goto L6
    }

    private static final void a(View r2, int r3, View r4) {
        Rect r0 = new Rect();
        r2.getHitRect(r0);
        int r5 = (int) (ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getDisplayMetrics().density * r3);
        r0.top -= r5;
        r0.bottom += r5;
        r0.left -= r5;
        r0.right += r5;
        r4.setTouchDelegate(new TouchDelegate(r0, r2));
    }

    public static final /* synthetic */ void a(a r0, View r1, int r2) {
        r0.a(r1, r2);
    }

    public static /* synthetic */ Unit lambda$Jh4uYX1iC5KSbJVkFUQB9hdSKj8(a r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$PCpnHnqpDF83MbVqrHSI965gPgM(View r0, int r1, View r2) {
        a(r0, r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r2) {
        com.obric.memorydata.recommend.guide.b r1 = (com.obric.memorydata.recommend.guide.b) ZeusTransformUtils.preCheckCast(b(r2), com.obric.memorydata.recommend.guide.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.recommend.guide.b.c.class) == false) goto L6;
        return 1;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.recommend.guide.b.a.class) == false) goto L9;
        return 2;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.recommend.guide.b.C0672b.class) == false) goto L13;
        return 3;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        if (r14 != 1) goto L5;
        View r15 = ZeusTransformUtils.inflate(LayoutInflater.from(this.c), ZeusTransformUtils.mapRes(R.layout.item_guide_category_header, "layout", "item_guide_category_header"), r13, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r15, "inflate(...)");
        Object r16 = new d(this, r15);
    L10:
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(r16, RecyclerView.v.class, "com.obric.memorydata.plugin");
    L5:
        if (r14 == 2) goto L7;
        View r17 = ZeusTransformUtils.inflate(LayoutInflater.from(this.c), ZeusTransformUtils.mapRes(R.layout.item_guide_category_desc, "layout", "item_guide_category_desc"), r13, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r17, "inflate(...)");
        r16 = new c(this, r17);
        goto L10
    L7:
        OCardListItem r18 = new OCardListItem(this.c, null, 0, 6, null);
        r18.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r18.setCardType(this.f);
        OCardListItem.a(r18, 0, false, 2, null);
        r18.setDefaultCustomEndView(1);
        r18.e(true);
        r18.f(false);
        r16 = new C0671a(this, r18);
        goto L10
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        com.obric.memorydata.recommend.guide.b r0 = (com.obric.memorydata.recommend.guide.b) ZeusTransformUtils.preCheckCast(b(r7), com.obric.memorydata.recommend.guide.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.recommend.guide.b.C0672b r3 = null;
        ViewGroup.MarginLayoutParams r4 = null;
        com.obric.memorydata.recommend.guide.b.a r5 = null;
        if (ZeusTransformUtils.instanceOf(r6, d.class) == false) goto L19;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.recommend.guide.b.c.class) == false) goto L7;
        com.obric.memorydata.recommend.guide.b.c r1 = (com.obric.memorydata.recommend.guide.b.c) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.recommend.guide.b.c.class, "com.obric.memorydata.plugin");
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        ViewGroup.LayoutParams r2 = r6.c.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.MarginLayoutParams.class) == false) goto L13;
        r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L13:
        if (r4 == null) goto L17;
        Function2<? super ViewGroup.MarginLayoutParams, ? super Integer, Unit> r8 = this.e;
        if (r8 == null) goto L17;
        r8.invoke(r4, Integer.valueOf(r7));
    L17:
        ((d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.memorydata.plugin")).a(r1.a(), new $$Lambda$a$Jh4uYX1iC5KSbJVkFUQB9hdSKj8(this));
        return;
    L7:
        r1 = null;
        goto L8
    L19:
        if (ZeusTransformUtils.instanceOf(r6, C0671a.class) == false) goto L27;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.recommend.guide.b.a.class) == false) goto L23;
        r5 = (com.obric.memorydata.recommend.guide.b.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.recommend.guide.b.a.class, "com.obric.memorydata.plugin");
    L23:
        if (r5 != null) goto L25;
        return;
    L25:
        ((C0671a) ZeusTransformUtils.preCheckCast(r6, C0671a.class, "com.obric.memorydata.plugin")).a(r5);
        return;
    L27:
        if (ZeusTransformUtils.instanceOf(r6, c.class) == true) goto L29;
        return;
    L29:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.recommend.guide.b.C0672b.class) == false) goto L31;
        r3 = (com.obric.memorydata.recommend.guide.b.C0672b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.recommend.guide.b.C0672b.class, "com.obric.memorydata.plugin");
    L31:
        if (r3 != null) goto L33;
        return;
    L33:
        ((c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin")).a(r3.a());
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r3, int r4, List<Object> r5) {
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.isEmpty() == false) goto L7;
        super.a(r3, r4, r6);
        return;
    L7:
        if (r6.contains("open_all") == true) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, C0671a.class) == false) goto L13;
        ((C0671a) ZeusTransformUtils.preCheckCast(r3, C0671a.class, "com.obric.memorydata.plugin")).a();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "rv");
        super.a(r2);
        this.g = r2;
    }

    public final void a(List<com.obric.memorydata.recommend.settings.i> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "categories");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L12;
        com.obric.memorydata.recommend.settings.i r2 = (com.obric.memorydata.recommend.settings.i) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.memorydata.recommend.settings.i.class, "com.obric.memorydata.plugin");
        r0.add(new com.obric.memorydata.recommend.guide.b.c(r2.b()));
        List<com.obric.memorydata.recommend.settings.c> r3 = r2.a();
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r5 = 0;
    L7:
        if (r4.hasNext() == false) goto L10;
        r0.add(new com.obric.memorydata.recommend.guide.b.a((com.obric.memorydata.recommend.settings.c) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.recommend.settings.c.class, "com.obric.memorydata.plugin"), r5, r3.size()));
        r5 = r5 + 1;
        goto L7
    L10:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2.d(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r0.add(new com.obric.memorydata.recommend.guide.b.C0672b(r2.d()));
        goto L4
    L12:
        b(r0);
    }

    public final void a(Function2<? super ViewGroup.MarginLayoutParams, ? super Integer, Unit> r3) {
        this.e = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "rv");
        super.b(r2);
        this.g = null;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long c(int r3) {
        com.obric.memorydata.recommend.guide.b r2 = (com.obric.memorydata.recommend.guide.b) ZeusTransformUtils.preCheckCast(b(r3), com.obric.memorydata.recommend.guide.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.recommend.guide.b.c.class) == false) goto L7;
        StringBuilder r4 = new StringBuilder().append("h:");
        String r5 = ((com.obric.memorydata.recommend.guide.b.c) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.recommend.guide.b.c.class, "com.obric.memorydata.plugin")).a();
    L12:
        return r4.append(r5).toString().hashCode();
    L7:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.recommend.guide.b.a.class) == false) goto L10;
        r4 = new StringBuilder().append("a:");
        r5 = ((com.obric.memorydata.recommend.guide.b.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.recommend.guide.b.a.class, "com.obric.memorydata.plugin")).a().b();
        goto L12
    L10:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.recommend.guide.b.C0672b.class) == false) goto L14;
        r4 = new StringBuilder().append("d:");
        r5 = ((com.obric.memorydata.recommend.guide.b.C0672b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.recommend.guide.b.C0672b.class, "com.obric.memorydata.plugin")).a();
        goto L12
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
