package com.obric.memorydata.recommend.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.obric.memory.model.MemoryData;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryCardBinding;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryDataBinding;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\f\u0010\u0019\u001a\u00020\t*\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryDataViewHolder;", "Lcom/obric/memorydata/recommend/ui/list/MemoryCardViewHolder;", "stubBinding", "Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryDataBinding;", "binding", "Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryCardBinding;", "<init>", "(Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryDataBinding;Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryCardBinding;)V", "title", "", "originContent", "bulletCount", "", "memoryData", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem$MemoryEntity;", "bind", "", "memoryItem", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "updateViewVisibility", "expanded", "", "processContent", Params.CONTENT, "adjustContentView", "appendMarkdownParagraph", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ItemRecommendMemoryDataBinding f12699b;
    private String t;
    private String u;
    private int v;
    private f.b w;

    public e(ItemRecommendMemoryDataBinding r2, ItemRecommendMemoryCardBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "stubBinding");
        Intrinsics.checkNotNullParameter(r3, "binding");
        super(r3);
        this.f12699b = r2;
        this.t = "";
        this.u = "";
    }

    private static final void a(f.b r6, e r7, f.b r8, View r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryItemViewHolder", "rootView onclick", false, 4, null);
        r6.a(!r6.b());
        r7.a(r8.b());
        r7.c(r8.b());
    }

    private final void a(String r9) {
        int r2 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), "\n- ", 0, false, 6, null);
        if (r2 == (-1)) goto L5;
        String r3 = r9.substring(0, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        this.t = b(r3);
        this.v = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"\n- "}, false, 0, 6, null).size() - 1;
    L6:
        this.u = b(r9);
        return;
    L5:
        this.t = b(r9);
        this.v = 0;
        goto L6
    }

    private final void a(boolean r3) {
        if (r3 == false) goto L7;
        this.f12699b.createTimeText.setVisibility(0);
        this.f12699b.observationText.setVisibility(0);
        this.f12699b.llExpandContainer.setVisibility(8);
        this.f12699b.ivCollapse.setVisibility(0);
        if (this.v <= 0) goto L9;
        this.f12699b.tvMarkdownBulletCount.setVisibility(0);
        this.f12699b.getRoot().requestLayout();
        return;
    L9:
        return;
    L7:
        this.f12699b.createTimeText.setVisibility(8);
        this.f12699b.observationText.setVisibility(8);
        this.f12699b.llExpandContainer.setVisibility(0);
        this.f12699b.ivCollapse.setVisibility(8);
    }

    private final String b(String r2) {
        return "### " + r2;
    }

    private static final void b(f.b r6, e r7, f.b r8, View r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryItemViewHolder", "markdownContent onclick", false, 4, null);
        r6.a(!r6.b());
        r7.a(r8.b());
        r7.c(r8.b());
    }

    private final void c(boolean r44) {
        if (r44 == false) goto L5;
        String r1 = this.u;
    L6:
        String r5 = r1;
        com.larus.business.markdown.api.a r2 = com.obric.memorydata.markdown.a.f9973a.b();
        if (r2 == null) goto L9;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f12699b.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "getContext(...)");
        com.larus.business.markdown.api.model.h r4 = com.larus.business.markdown.api.a.b.a(r2, r3, 0, r5, true, new com.larus.business.markdown.api.model.c(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 10, Resources.getSystem().getDisplayMetrics()))), Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics()))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -98305, null), null, null, null, 224, null);
    L10:
        this.f12699b.markdownContent.setMarkdown(r4);
        long r6 = 0;
        TextView r7 = this.f12699b.updateTimeText;
        if (r44 == false) goto L18;
        StringBuilder r8 = new StringBuilder();
        r8.append(at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_update_time, TypedValues.Custom.S_STRING, "recommend_memory_general_update_time")));
        com.obric.memorydata.recommend.ui.a r9 = com.obric.memorydata.recommend.ui.a.f12641a;
        f.b r0 = this.w;
        if (r0 == null) goto L17;
        MemoryData r10 = r0.a();
        if (r10 == null) goto L17;
        r6 = com.obric.memorydata.recommend.model.a.b(r10);
    L17:
        String r11 = r9.a(r6);
    L24:
        r8.append(r11);
        String r12 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L18:
        r8 = new StringBuilder();
        r8.append(at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_update_time, TypedValues.Custom.S_STRING, "recommend_memory_general_update_time")));
        com.obric.memorydata.recommend.ui.a r13 = com.obric.memorydata.recommend.ui.a.f12641a;
        f.b r14 = this.w;
        if (r14 == null) goto L23;
        MemoryData r15 = r14.a();
        if (r15 == null) goto L23;
        r6 = com.obric.memorydata.recommend.model.a.b(r15);
    L23:
        r11 = r13.b(r6);
        goto L24
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = this.t;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$QuxUtooqVFa4HAd4f_M5rgOa-QI, reason: not valid java name */
    public static /* synthetic */ void m1153lambda$QuxUtooqVFa4HAd4f_M5rgOaQI(f.b r0, e r1, f.b r2, View r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$W9xVTC2FywuzAy4psFm592PLNG4(f.b r0, e r1, f.b r2, View r3) {
        b(r0, r1, r2, r3);
    }

    @Override // com.obric.memorydata.recommend.ui.list.d, com.obric.memorydata.recommend.ui.list.j
    public void a(f r11) {
        Intrinsics.checkNotNullParameter(r11, "memoryItem");
        super.a(r11);
        ViewGroup.MarginLayoutParams r1 = null;
        if (ZeusTransformUtils.instanceOf(r11, f.b.class) == false) goto L5;
        final f.b r12 = (f.b) ZeusTransformUtils.preCheckCast(r11, f.b.class, "com.obric.memorydata.plugin");
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        this.w = r12;
        String r0 = r12.a().content;
        Intrinsics.checkNotNullExpressionValue(r0, Params.CONTENT);
        a(r0);
        a(r12.b());
        c(r12.b());
        if (this.v <= 0) goto L16;
        this.f12699b.tvMarkdownBulletCount.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_item_bullet_count, TypedValues.Custom.S_STRING, "recommend_memory_item_bullet_count"), new Object[]{Integer.valueOf(this.v)}), CharSequence.class, "com.obric.memorydata.plugin"));
        ViewGroup.LayoutParams r2 = this.f12699b.ivExpand.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.MarginLayoutParams.class) == false) goto L13;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L13:
        if (r1 == null) goto L21;
        r1.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())));
        float r3 = 2;
    L15:
        r1.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())));
    L21:
        this.f12699b.getRoot().setOnClickListener(new $$Lambda$e$QuxUtooqVFa4HAd4f_M5rgOaQI(r12, this, r12));
        this.f12699b.markdownContent.setOnClickListener(new $$Lambda$e$W9xVTC2FywuzAy4psFm592PLNG4(r12, this, r12));
        TextView r4 = this.f12699b.observationText;
        String r5 = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_observation, TypedValues.Custom.S_STRING, "recommend_memory_general_observation")) + r12.a().observation;
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r10 = this.f12699b.createTimeText;
        String r13 = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_create_time, TypedValues.Custom.S_STRING, "recommend_memory_general_create_time")) + com.obric.memorydata.recommend.ui.a.f12641a.a(com.obric.memorydata.recommend.model.a.a(r12.a()));
        Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");
        r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L16:
        this.f12699b.tvMarkdownBulletCount.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        ViewGroup.LayoutParams r6 = this.f12699b.ivExpand.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L19;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L19:
        if (r1 == null) goto L21;
        r1.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
        r3 = 0;
        goto L15
    L5:
        r12 = null;
        goto L6
    }
}
