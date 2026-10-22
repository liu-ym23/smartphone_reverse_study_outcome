package com.obric.memorydata.recommend.guide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.i;
import com.obric.oui.orecyclerview.widget.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0011\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideFeatureAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/recommend/guide/GuideFeatureItem;", "Lcom/obric/memorydata/recommend/guide/GuideFeatureAdapter$ViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "ViewHolder", "FeatureDiff", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends q<d, C0673c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12522a = null;
    private final Context c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideFeatureAdapter$Companion;", "", "<init>", "()V", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideFeatureAdapter$FeatureDiff;", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/recommend/guide/GuideFeatureItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b extends i.e<d> {
        public b() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(d r1, d r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1.a(), r2.a());
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean a(d r3, d r4) {
            return a2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(d r1, d r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean b(d r3, d r4) {
            return b2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.guide.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/recommend/guide/GuideFeatureAdapter$ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "cardItem", "Lcom/obric/oui/lisitem/OCardListItem;", "<init>", "(Lcom/obric/memorydata/recommend/guide/GuideFeatureAdapter;Lcom/obric/oui/lisitem/OCardListItem;)V", "getCardItem", "()Lcom/obric/oui/lisitem/OCardListItem;", "bind", "", "item", "Lcom/obric/memorydata/recommend/guide/GuideFeatureItem;", "position", "", LBSLightLocationTraceLogger.TOTAL, "disableIconOutlineClip", "iconView", "Landroid/widget/ImageView;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class C0673c extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f12523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OCardListItem f12524b;

        public C0673c(c r2, OCardListItem r3) {
            Intrinsics.checkNotNullParameter(r3, "cardItem");
            this.f12523a = r2;
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            this.f12524b = r3;
        }

        private final void a(ImageView r1) {
            r1.setClipToOutline(false);
            r1.setOutlineProvider(null);
        }

        public final void a(d r23, int r24, int r25) {
            Intrinsics.checkNotNullParameter(r23, "item");
            OCardListItem r3 = this.f12524b;
            if (r25 < 2) goto L10;
            if (r24 != 0) goto L7;
            OCardListItem.a(r3, 1, false, 2, null);
        L11:
            r3.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r23.a(), CharSequence.class, "com.obric.memorydata.plugin"));
            r3.c(true);
            r3.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r23.b(), CharSequence.class, "com.obric.memorydata.plugin"));
            r3.d(true);
            if (r23.d() == null) goto L16;
            a(r3.getIconView());
            com.obric.memorydata.utils.icon.b r9 = com.obric.memorydata.utils.icon.b.f13229a;
            Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r10, "getContext(...)");
            com.obric.memorydata.utils.icon.b.a(r9, r10, r3.getIconView(), r23.d(), null, 0, null, null, null, null, false, 1016, null);
        L14:
            r3.b(true);
            return;
        L16:
            if (r23.c() == null) goto L18;
            a(r3.getIconView());
            com.obric.memorydata.utils.icon.b r11 = com.obric.memorydata.utils.icon.b.f13229a;
            Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r12, "getContext(...)");
            com.obric.memorydata.utils.icon.b.a(r11, r12, r3.getIconView(), null, r23.c(), 4, null);
            goto L14
        L18:
            r3.getIconView().setImageDrawable(null);
            r3.b(false);
            return;
        L7:
            if (r24 != (r25 - 1)) goto L9;
            OCardListItem.a(r3, 3, false, 2, null);
            goto L11
        L9:
            OCardListItem.a(r3, 2, false, 2, null);
            goto L11
        L10:
            OCardListItem.a(r3, 0, false, 2, null);
            goto L11
        }
    }

    static {
        f12522a = new a(null);
    }

    public c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super((i.e) ZeusTransformUtils.preCheckCast(new b(), i.e.class, "com.obric.memorydata.plugin"));
        this.c = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(C0673c r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        d r0 = b(r5);
        Intrinsics.checkNotNullExpressionValue(r0, "getItem(...)");
        r4.a((d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin"), r5, d());
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((C0673c) ZeusTransformUtils.preCheckCast(r3, C0673c.class, "com.obric.memorydata.plugin"), r4);
    }

    public C0673c b(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        OCardListItem r9 = new OCardListItem(this.c, null, 0, 6, null);
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r9.setCardType(1);
        OCardListItem.a(r9, 0, false, 2, null);
        r9.f(false);
        r9.d(true);
        r9.c(true);
        r9.b(true);
        return new C0673c(this, r9);
    }
}
