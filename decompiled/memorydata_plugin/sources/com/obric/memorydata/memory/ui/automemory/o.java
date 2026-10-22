package com.obric.memorydata.memory.ui.automemory;

import android.content.Context;
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
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryMyCollectionCardView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "iconView", "Landroid/widget/ImageView;", "titleView", "Lcom/obric/oui/text/OTextView;", "subtitleView", "newDotView", "Landroid/view/View;", "bind", "", "item", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardItem;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class o extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f10711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OTextView f10712b;
    private final OTextView c;
    private final View d;

    public o(Context r22) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r22, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RecyclerView.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        setClickable(true);
        setFocusable(true);
        LinearLayout r13 = new LinearLayout(r1);
        r13.setOrientation(1);
        float r3 = 16;
        r13.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 14, Resources.getSystem().getDisplayMetrics())));
        r13.setMinimumHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 118, Resources.getSystem().getDisplayMetrics())));
        r13.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ImageView r15 = new ImageView(r1);
        r15.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_recommend_collection, "drawable", "ic_auto_memory_recommend_collection"));
        r15.setScaleType(ImageView.ScaleType.CENTER);
        float r4 = 28;
        r15.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics()))), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.f10711a = r15;
        OTextView r9 = new OTextView(r1, null, 0, null, 14, null);
        r9.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
        r9.setTextSize(16.0f);
        r9.setMaxLines(1);
        r9.setEllipsize(TextUtils.TruncateAt.END);
        r9.setTypeface(Typeface.create(r9.getTypeface(), 400, false));
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-1, -2);
        r5.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 22, Resources.getSystem().getDisplayMetrics()));
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.f10712b = r9;
        LinearLayout r6 = new LinearLayout(r1);
        r6.setOrientation(0);
        r6.setGravity(16);
        r6.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())), 0, 0);
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        OTextView r10 = new OTextView(r1, null, 0, null, 14, null);
        r10.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        r10.setTypeface(Typeface.create(r10.getTypeface(), 400, false));
        r10.setTextSize(12.0f);
        r10.setMaxLines(1);
        r10.setEllipsize(TextUtils.TruncateAt.END);
        r10.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.c = r10;
        View r7 = new View(r1);
        GradientDrawable r8 = new GradientDrawable();
        r8.setShape(1);
        r8.setColor(r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6")));
        r7.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r8, Drawable.class, "com.obric.memorydata.plugin"));
        float r11 = 8;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r11, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r11, Resources.getSystem().getDisplayMetrics())));
        r2.leftMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 6, Resources.getSystem().getDisplayMetrics()));
        r7.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.d = r7;
        r6.addView((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"));
        r6.addView(r7);
        r13.addView((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"));
        r13.addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"));
        r13.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        addView((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"));
    }

    public final void a(d r11) {
        Intrinsics.checkNotNullParameter(r11, "item");
        MemoryRuleEntity r0 = r11.a();
        GradientDrawable r1 = new GradientDrawable();
        int r2 = 0;
        r1.setShape(0);
        boolean r5 = true;
        r1.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics())));
        r1.setColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_3, TypedValues.Custom.S_COLOR, "oui_basic_bg_base_3")));
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r1, Drawable.class, "com.obric.memorydata.plugin"));
        n.f10710a.a(this.f10711a, r0);
        this.f10712b.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0.getTitle(), CharSequence.class, "com.obric.memorydata.plugin"));
        this.c.setText((CharSequence) ZeusTransformUtils.preCheckCast(c.f10614a.a(r0.getMemoryCount(), r11.b()), CharSequence.class, "com.obric.memorydata.plugin"));
        View r10 = this.d;
        if (r11.b() > 0) goto L6;
        r5 = false;
    L6:
        if (r5 == true) goto L9;
        r2 = 8;
    L9:
        r10.setVisibility(r2);
    }
}
