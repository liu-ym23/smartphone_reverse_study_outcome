package com.obric.aiproactive.ui.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0019\u001a\u001bB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0014\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/aiproactive/ui/list/SensingEventAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "events", "", "Lcom/obric/aiproactive/ui/list/SensingEvent;", "<init>", "(Ljava/util/List;)V", "", "expandedEventIds", "", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getItemCount", "updateEvents", "nextEvents", "Companion", "EventViewHolder", "FooterViewHolder", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i extends RecyclerView.Adapter<RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<h> f6713b;
    private Set<String> c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/list/SensingEventAdapter$Companion;", "", "<init>", "()V", "TYPE_ITEM", "", "TYPE_FOOTER", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/ui/list/SensingEventAdapter$EventViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvTime", "Landroid/widget/TextView;", "getTvTime", "()Landroid/widget/TextView;", "tvContent", "getTvContent", "vDot", "getVDot", "()Landroid/view/View;", "vDivider", "getVDivider", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f6714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextView f6715b;
        private final View t;
        private final View u;

        public b(View r6) {
            Intrinsics.checkNotNullParameter(r6, "view");
            super(r6);
            View r0 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.tv_time, OaidModel.KEY_ID, "tv_time"));
            Intrinsics.checkNotNullExpressionValue(r0, "findViewById(...)");
            this.f6714a = (TextView) ZeusTransformUtils.preCheckCast(r0, TextView.class, "com.obric.memorydata.plugin");
            View r1 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.tv_content, OaidModel.KEY_ID, "tv_content"));
            Intrinsics.checkNotNullExpressionValue(r1, "findViewById(...)");
            this.f6715b = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin");
            View r2 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.v_dot, OaidModel.KEY_ID, "v_dot"));
            Intrinsics.checkNotNullExpressionValue(r2, "findViewById(...)");
            this.t = r2;
            View r7 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.v_divider, OaidModel.KEY_ID, "v_divider"));
            Intrinsics.checkNotNullExpressionValue(r7, "findViewById(...)");
            this.u = r7;
        }

        public final TextView a() {
            return this.f6714a;
        }

        public final TextView b() {
            return this.f6715b;
        }

        public final View c() {
            return this.t;
        }

        public final View d() {
            return this.u;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/list/SensingEventAdapter$FooterViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends RecyclerView.v {
        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6716a = null;

        static {
            int[] r0 = new int[SensingEventDotTone.values().length];
            r0[SensingEventDotTone.HIGHLIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SensingEventDotTone.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f6716a = r0;
        }
    }

    static {
        f6712a = new a(null);
    }

    public i(List<h> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "events");
        this.f6713b = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));
        this.c = SetsKt.emptySet();
    }

    private static final Unit a(RecyclerView.v r2, i r3, String r4) {
        int r5 = ((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin")).o();
        if (r5 == (-1)) goto L6;
        r3.c = j.a(r3.c, r4);
        r3.e(r5);
    L6:
        return Unit.INSTANCE;
    }

    private static final void a(final RecyclerView.v r6, Object r7, h r8, boolean r9, Function0 r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        if (((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).b().getTag() == r7) goto L6;
        return;
    L6:
        if ((!j.a(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).b(), (CharSequence) ZeusTransformUtils.preCheckCast(r8.b(), CharSequence.class, "com.obric.memorydata.plugin"), 2)) == true) goto L9;
        j.a(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).b(), r8.b(), false);
        return;
    L9:
        if (r9 == false) goto L11;
        String r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_sensing_event_collapse, TypedValues.Custom.S_STRING, "ai_proactive_sensing_event_collapse"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        j.a(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).b(), j.a(r8.b(), r12), Typography.nbsp + r12, Integer.MAX_VALUE, r11);
        return;
    L11:
        String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_sensing_event_expand, TypedValues.Custom.S_STRING, "ai_proactive_sensing_event_expand"));
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        j.a(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).b(), j.a(r8.b(), r13, new $$Lambda$i$yIoZsH28440x2M1iv3nYkD81y4(r6)), Typography.nbsp + r13, 2, r11);
    }

    private static final boolean a(RecyclerView.v r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "candidate");
        return j.a(((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin")).b(), r4, 2);
    }

    /* JADX INFO: renamed from: lambda$SGyzYitBq6h4QgObI_Nk-QGR-VU, reason: not valid java name */
    public static /* synthetic */ Unit m307lambda$SGyzYitBq6h4QgObI_NkQGRVU(RecyclerView.v r0, i r1, String r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$X7DejV1eF-3nnLa9ldXAD_-2UfU, reason: not valid java name */
    public static /* synthetic */ void m308lambda$X7DejV1eF3nnLa9ldXAD_2UfU(RecyclerView.v r0, Object r1, h r2, boolean r3, Function0 r4) {
        a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$yIoZsH28440x2M1iv3nY-kD81y4, reason: not valid java name */
    public static /* synthetic */ boolean m309lambda$yIoZsH28440x2M1iv3nYkD81y4(RecyclerView.v r0, CharSequence r1) {
        return a(r0, r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r1) {
        if (r1 != this.f6713b.size()) goto L5;
        return 1;
    L5:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        LayoutInflater r4 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r6 != 0) goto L5;
        View r7 = ZeusTransformUtils.inflate(r4, ZeusTransformUtils.mapRes(R.layout.item_sensing_event, "layout", "item_sensing_event"), r5, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r7);
        Object r8 = new b(r7);
    L7:
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(r8, RecyclerView.v.class, "com.obric.memorydata.plugin");
    L5:
        View r9 = ZeusTransformUtils.inflate(r4, ZeusTransformUtils.mapRes(R.layout.item_sensing_footer, "layout", "item_sensing_footer"), r5, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r9);
        r8 = new c(r9);
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(final RecyclerView.v r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        if (ZeusTransformUtils.instanceOf(r9, b.class) == false) goto L21;
        final h r11 = (h) ZeusTransformUtils.preCheckCast(this.f6713b.get(r10), h.class, "com.obric.memorydata.plugin");
        final String r0 = j.a(r11);
        final boolean r6 = this.c.contains(r0);
        ((b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin")).a().setText((CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        final Function0 r7 = new $$Lambda$i$SGyzYitBq6h4QgObI_NkQGRVU(r9, this, r0);
        final Object r4 = new Object();
        ((b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin")).b().setTag(r4);
        j.a(((b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin")).b(), r11.b(), r6);
        ((b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin")).b().post(new $$Lambda$i$X7DejV1eF3nnLa9ldXAD_2UfU(r9, r4, r11, r6, r7));
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        SensingEventDotTone r12 = r11.c();
        int r13 = d.f6716a[r12.ordinal()];
        if (r13 != 1) goto L7;
        int r14 = R.color.ai_proactive_sensing_dot_highlight;
        String r3 = "ai_proactive_sensing_dot_highlight";
    L12:
        int r15 = r8.getColor(ZeusTransformUtils.mapRes(r14, TypedValues.Custom.S_COLOR, r3));
        Drawable r16 = ((b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin")).c().getBackground();
        if (ZeusTransformUtils.instanceOf(r16, GradientDrawable.class) == false) goto L15;
        GradientDrawable r17 = (GradientDrawable) ZeusTransformUtils.preCheckCast(r16, GradientDrawable.class, "com.obric.memorydata.plugin");
    L16:
        if (r17 == null) goto L18;
        r17.setColor(r15);
    L19:
        ((b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin")).d().setVisibility(0);
        return;
    L18:
        GradientDrawable r18 = new GradientDrawable();
        r18.setShape(1);
        r18.setColor(r15);
        ((b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin")).c().setBackground((Drawable) ZeusTransformUtils.preCheckCast(r18, Drawable.class, "com.obric.memorydata.plugin"));
        goto L19
    L15:
        r17 = null;
        goto L16
    L7:
        if (r13 != 2) goto L10;
        r14 = R.color.ai_proactive_sensing_dot_normal;
        r3 = "ai_proactive_sensing_dot_normal";
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(List<h> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "nextEvents");
        this.f6713b.clear();
        this.f6713b.addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
        Set<String> r0 = this.c;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new HashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r2.add(j.a((h) ZeusTransformUtils.preCheckCast(r9.next(), h.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        this.c = j.a(r0, (Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.memorydata.plugin"));
        h();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.f6713b.size() + 1;
    }
}
