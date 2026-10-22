package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.obric.assistant.card.databinding.ObricOmniBlockTaskHeaderBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 J2\u00020\u0001:\u0002IJB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJF\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a0\u001e2 \b\u0002\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0 Jd\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00152\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a0\u001e2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001a0\u001e2 \b\u0002\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0 J6\u0010$\u001a\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u001e\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0 H\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0015H\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0015H\u0002J\u0016\u00101\u001a\u00020\u001a2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u00102\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0015H\u0002J \u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0002J\u0016\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010:\u001a\u00020\u001aH\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000eH\u0002J\u0010\u0010>\u001a\u0002082\u0006\u0010=\u001a\u00020\u000eH\u0002J\u0018\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020A2\u0006\u0010=\u001a\u00020\u000eH\u0002J\b\u0010B\u001a\u00020\u0007H\u0002J\b\u0010C\u001a\u00020\u0007H\u0002J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020<H\u0002J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020<H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/TaskHeaderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockTaskHeaderBinding;", "additionTips", "", "", "resourceBar", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "attachmentsByDisplayKey", "", "Lcom/obric/assistant/omnidetailpage/model/HeaderAttachment;", "isExpanded", "", "needToggle", "collapseConfig", "Lcom/obric/assistant/omnidetailpage/blockview/TaskHeaderView$CollapseConfig;", "bind", "", "item", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$Header;", "onItemClick", "Lkotlin/Function1;", "onAttachmentClick", "Lkotlin/Function3;", "Landroid/view/View;", "expanded", "onExpandChanged", "bindAttachments", "attachments", "bindPlaceholder", "resetPlaceholderState", "bindNormalBlock", "textBlock", "Lcom/larus/im/bean/message/block/TextBlock;", "bindQuickBlock", "updateToggleView", "show", "prepareForMeasure", "isQuick", "applyExpandState", "bindAdditionTips", "updateCollapseState", "buildCollapseConfig", "primaryFullLines", "additionPreviewFullLines", "totalBudget", "buildAdditionPreviewText", "", "tips", "renderExpandedAdditionTips", "createAdditionTipTextView", "Landroid/widget/TextView;", "tip", "buildSingleAdditionText", "appendAdditionSpan", "builder", "Landroid/text/SpannableStringBuilder;", "resolveAdditionPrefixColor", "resolveAdditionContentColor", "dp", "value", "measureFullLineCount", "textView", "resolveTextWidth", "CollapseConfig", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskHeaderView extends FrameLayout {
    public static final /* synthetic */ int h = 0;
    public final ObricOmniBlockTaskHeaderBinding a;
    public List<String> b;
    public final mt8.a c;
    public Map<String, ifa.a> d;
    public boolean e;
    public boolean f;
    public a g;

    public static final class a {
        public final boolean a;
        public final int b;
        public final int c;

        public a() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (((r0 * 31) + this.b) * 31) + this.c;
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "CollapseConfig(needToggle=" + this.a + ", primaryCollapsedLines=" + this.b + ", additionPreviewCollapsedLines=" + this.c + ')';
        }

        public /* synthetic */ a(int r2) {
            int r3 = TaskHeaderView.h;
            this(false, 4, 0);
        }

        public a(boolean r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
    }

    static {
    }

    public TaskHeaderView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TaskHeaderView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void b(boolean r8) {
        ObricOmniBlockTaskHeaderBinding r0 = this.a;
        if (r0 == null) goto L39;
        if (r8 == false) goto L6;
        TextView r9 = r0.g;
    L7:
        Intrinsics.checkNotNull(r9);
        TextView r1 = r0.f;
        LinearLayout r2 = r0.d;
        if (this.e == false) goto L10;
        int r3 = Integer.MAX_VALUE;
    L11:
        r9.setMaxLines(r3);
        if (this.e == false) goto L14;
        TextUtils.TruncateAt r4 = null;
    L15:
        r9.setEllipsize(r4);
        if (this.b.isEmpty() == false) goto L19;
        r1.setVisibility(8);
        r2.setVisibility(8);
    L36:
        e(this.f, this.e);
        return;
    L19:
        if (this.e == false) goto L32;
        r1.setVisibility(8);
        r2.setVisibility(0);
        ObricOmniBlockTaskHeaderBinding r10 = this.a;
        if (r10 == null) goto L36;
        LinearLayout r11 = r10.d;
        if (r11 == null) goto L36;
        if (r11.getChildCount() == this.b.size()) goto L36;
        r11.removeAllViews();
        Iterator<T> r5 = this.b.iterator();
    L30:
        if (r5.hasNext() == false) goto L36;
        String r6 = (String) r5.next();
        AppCompatTextView r7 = new AppCompatTextView(getContext());
        SpannableStringBuilder r12 = new SpannableStringBuilder();
        a(r12, r6);
        r7.setText(r12);
        r7.setTextSize(0, r7.getResources().getDimension(2131165902));
        r7.setTypeface(Typeface.create("sans-serif-medium", 0));
        r7.setLineSpacing(r7.getResources().getDimension(2131166203), 1.0f);
        r7.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-1, -2);
        r13.topMargin = c(6);
        r7.setLayoutParams(r13);
        r11.addView(r7);
        goto L30
    L32:
        r2.setVisibility(8);
        if (this.g.c <= 0) goto L35;
        r1.setVisibility(0);
        r1.setMaxLines(this.g.c);
        r1.setEllipsize(TextUtils.TruncateAt.END);
        goto L36
    L35:
        r1.setVisibility(8);
        goto L36
    L14:
        r4 = TextUtils.TruncateAt.END;
        goto L15
    L10:
        r3 = this.g.b;
        goto L11
    L6:
        r9 = r0.h;
        goto L7
    }

    public final int c(int r3) {
        Resources r0 = getResources();
        return MathKt.roundToInt(r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final int d(TextView r10) {
        CharSequence r0 = r10.getText();
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r2 = r1;
        if (r2.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        return 0;
    L14:
        int r4 = (r10.getWidth() - r10.getPaddingStart()) - r10.getPaddingEnd();
        if (r4 <= 0) goto L17;
    L16:
        int r5 = r4;
        if (r5 > 0) goto L42;
        return 0;
    L42:
        return new StaticLayout(r2, r10.getPaint(), r5, Layout.Alignment.ALIGN_NORMAL, r10.getLineSpacingMultiplier(), r10.getLineSpacingExtra(), r10.getIncludeFontPadding()).getLineCount();
    L17:
        r4 = (r10.getMeasuredWidth() - r10.getPaddingStart()) - r10.getPaddingEnd();
        if (r4 > 0) goto L16;
        ObricOmniBlockTaskHeaderBinding r6 = this.a;
        if (r6 == null) goto L25;
        LinearLayout r7 = r6.a;
        if (r7 == null) goto L25;
        int r8 = r7.getWidth();
    L26:
        ObricOmniBlockTaskHeaderBinding r9 = this.a;
        if (r9 == null) goto L31;
        LinearLayout r11 = r9.a;
        if (r11 == null) goto L31;
        int r12 = r11.getPaddingStart();
    L32:
        ObricOmniBlockTaskHeaderBinding r13 = this.a;
        if (r13 == null) goto L37;
        LinearLayout r14 = r13.a;
        if (r14 == null) goto L37;
        int r15 = r14.getPaddingEnd();
    L38:
        r4 = RangesKt.coerceAtLeast(r8 - (r12 + r15), 0);
    L37:
        r15 = 0;
    L31:
        r12 = 0;
    L25:
        r8 = 0;
        goto L26
    L11:
        r3 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void a(SpannableStringBuilder r7, String r8) {
        int r0 = r7.length();
        r7.append("补充：");
        r7.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), v19.c.b(2130972081, getContext(), 2131103143))), r0, r7.length(), 33);
        int r1 = r7.length();
        r7.append(r8);
        r7.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136))), r1, r7.length(), 33);
    }

    public final void e(boolean r3, boolean r4) {
        ObricOmniBlockTaskHeaderBinding r0 = this.a;
        if (r0 == null) goto L10;
        ImageView r1 = r0.c;
        if (r1 == null) goto L10;
        if (r3 == false) goto L8;
        int r2 = 0;
    L9:
        r1.setVisibility(r2);
        goto L10
    L8:
        r2 = 8;
    L10:
        if (r3 == true) goto L12;
        return;
    L12:
        ObricOmniBlockTaskHeaderBinding r5 = this.a;
        if (r5 == null) goto L21;
        ImageView r6 = r5.c;
        if (r6 == null) goto L22;
        if (r4 == false) goto L18;
        float r7 = 180.0f;
    L19:
        r6.setRotation(r7);
        return;
    L18:
        r7 = 0.0f;
        goto L19
    L22:
        return;
    }

    public TaskHeaderView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.b = CollectionsKt.emptyList();
        mt8.a r14 = InputViewCreatorDelegate.b.e(r11);
        this.c = r14;
        this.d = MapsKt.emptyMap();
        this.g = new a(0);
        View r15 = LayoutInflater.from(r11).inflate(2131564044, this, false);
        addView(r15);
        int r16 = 2131372652;
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(r15, 2131372652);
        if (r0 == null) goto L21;
        r16 = 2131375912;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r15, 2131375912);
        if (r4 == null) goto L21;
        r16 = 2131378581;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131378581);
        if (r5 == null) goto L21;
        r16 = 2131378582;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131378582);
        if (r6 == null) goto L21;
        r16 = 2131390034;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r15, 2131390034);
        if (r7 == null) goto L21;
        r16 = 2131390035;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r15, 2131390035);
        if (r8 == null) goto L21;
        r16 = 2131390036;
        if (((TextView) ViewBindings.findChildViewById(r15, 2131390036)) == null) goto L21;
        r16 = 2131390037;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131390037);
        if (r9 == null) goto L21;
        this.a = new ObricOmniBlockTaskHeaderBinding((LinearLayout) r15, r0, r4, r5, r6, r7, r8, r9);
        r0.addView(r14.getView(), new FrameLayout.LayoutParams(-1, -2));
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }

    public /* synthetic */ TaskHeaderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
