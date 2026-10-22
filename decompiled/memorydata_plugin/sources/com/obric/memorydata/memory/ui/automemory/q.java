package com.obric.memorydata.memory.ui.automemory;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.material.card.MaterialCardView;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000e2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryRecommendCollectionCardView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "iconView", "Landroid/widget/ImageView;", "titleView", "Lcom/obric/oui/text/OTextView;", "subtitleView", "addButton", "onAddClick", "Lkotlin/Function0;", "", "bind", "item", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardItem;", "setOnAddClickListener", "listener", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class q extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f10714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OTextView f10715b;
    private final OTextView c;
    private final FrameLayout d;
    private Function0<Unit> e;

    public q(Context r24) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RecyclerView.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        setClickable(true);
        setFocusable(true);
        LinearLayout r13 = new LinearLayout(r1);
        r13.setOrientation(1);
        float r14 = 16;
        float r15 = 14;
        r13.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r15, Resources.getSystem().getDisplayMetrics())));
        r13.setMinimumHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 118, Resources.getSystem().getDisplayMetrics())));
        r13.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ImageView r9 = new ImageView(r1);
        r9.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_recommend_collection, "drawable", "ic_auto_memory_recommend_collection"));
        r9.setScaleType(ImageView.ScaleType.CENTER);
        float r7 = 28;
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics()))), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.f10714a = r9;
        OTextView r6 = new OTextView(r1, null, 0, null, 14, null);
        r6.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
        r6.setTypeface(Typeface.create(r6.getTypeface(), 400, false));
        r6.setTextSize(16.0f);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-1, -2);
        r3.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 22, Resources.getSystem().getDisplayMetrics()));
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.f10715b = r6;
        OTextView r11 = new OTextView(r1, null, 0, null, 14, null);
        r11.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        r11.setTypeface(Typeface.create(r11.getTypeface(), 400, false));
        r11.setTextSize(12.0f);
        r11.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())), 0, 0);
        r11.setMaxLines(1);
        r11.setLineSpacing(0.0f, 1.1f);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        this.c = r11;
        r13.addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"));
        r13.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        r13.addView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"));
        addView((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"));
        FrameLayout r4 = new FrameLayout(r1);
        GradientDrawable r5 = new GradientDrawable();
        r5.setShape(1);
        r5.setColor(r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, TypedValues.Custom.S_COLOR, "oui_fill_element_2")));
        r4.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r5, Drawable.class, "com.obric.memorydata.plugin"));
        r4.setClickable(true);
        r4.setFocusable(true);
        ImageView r8 = new ImageView(r1);
        r8.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_memory_detail_add, "drawable", "ic_memory_detail_add"));
        r8.setImageTintList(ColorStateList.valueOf(r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_advanced_fill_icon_as_action, TypedValues.Custom.S_COLOR, "oui_advanced_fill_icon_as_action"))));
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics())));
        r2.gravity = 17;
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r4.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
        r4.setOnClickListener(new $$Lambda$q$XNb2JUIYwjyP9hpEdRwHiXuiWNQ(this));
        this.d = r4;
        View r10 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())));
        r12.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        r12.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics()));
        r12.rightMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r15, Resources.getSystem().getDisplayMetrics()));
        Unit r16 = Unit.INSTANCE;
        addView(r10, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r12, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        setOnClickListener(new $$Lambda$q$CHq8rcMpS_k9LrOzjHE7NJIZyc(this));
    }

    private static final void a(q r0, View r1) {
        Function0<Unit> r2 = r0.e;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }

    private static final void b(q r0, View r1) {
        Function0<Unit> r2 = r0.e;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }

    /* JADX INFO: renamed from: lambda$CH-q8rcMpS_k9LrOzjHE7NJIZyc, reason: not valid java name */
    public static /* synthetic */ void m816lambda$CHq8rcMpS_k9LrOzjHE7NJIZyc(q r0, View r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$XNb2JUIYwjyP9hpEdRwHiXuiWNQ(q r0, View r1) {
        a(r0, r1);
    }

    public final void a(d r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        MemoryRuleEntity r8 = r7.a();
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics())));
        r0.setColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_3, TypedValues.Custom.S_COLOR, "oui_basic_bg_base_3")));
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.memorydata.plugin"));
        this.f10715b.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.getTitle(), CharSequence.class, "com.obric.memorydata.plugin"));
        OTextView r1 = this.c;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.getTriggerMode(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r2) == false) goto L7;
        r2 = (String) ZeusTransformUtils.preCheckCast(SequencesKt.firstOrNull(StringsKt.lineSequence((CharSequence) ZeusTransformUtils.preCheckCast(r8.getContent(), CharSequence.class, "com.obric.memorydata.plugin"))), String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        n.f10710a.a(this.f10714a, r8);
    }

    public final void a(Function0<Unit> r3) {
        this.e = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }
}
