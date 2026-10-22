package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusExpandTextViewBinding;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0017J+\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010$\u001a\u00020%J#\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010(R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/larus/common_ui/widget/ExpandTextview;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusExpandTextViewBinding;", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusExpandTextViewBinding;", "expandNow", "", "getExpandNow", "()Z", "setExpandNow", "(Z)V", "getTextLine", "", "content", "", "immerseBgColor", "(Ljava/lang/String;Ljava/lang/Integer;)I", "setContent", "", "tail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "setContentTextColor", "color", "setContentTextAlpha", "alpha", "", "setContentTextMaxLine", "lines", "setExpandTextColor", "getContentView", "Landroid/widget/TextView;", "createStaticLayout", "Landroid/text/Layout;", "(Ljava/lang/String;Ljava/lang/Integer;)Landroid/text/Layout;", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpandTextview extends FrameLayout {
    public final LarusExpandTextViewBinding a;
    public boolean b;

    public static final class a {
    }

    static {
    }

    public final TextView getContentView() {
        return this.a.b;
    }

    public final LarusExpandTextViewBinding getBinding() {
        return this.a;
    }

    public final boolean getExpandNow() {
        return this.b;
    }

    public ExpandTextview(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setContentTextAlpha(float r2) {
        this.a.b.setAlpha(r2);
    }

    public final void setContentTextColor(int r2) {
        this.a.b.setTextColor(r2);
    }

    public final void setContentTextMaxLine(int r2) {
        this.a.b.setMaxLines(r2);
    }

    public final void setExpandNow(boolean r1) {
        this.b = r1;
    }

    public final void setExpandTextColor(int r2) {
        this.a.c.setTextColor(r2);
    }

    public ExpandTextview(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        ConstraintLayout r5 = LayoutInflater.from(r3).inflate(2131562329, this, false);
        addView(r5);
        int r6 = 2131367858;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r5, 2131367858);
        if (r0 == null) goto L9;
        r6 = 2131371898;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r5, 2131371898);
        if (r1 == null) goto L9;
        this.a = new LarusExpandTextViewBinding(r5, r0, r1);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }

    public final void a(String r17, String r18, Integer r110) {
        Intrinsics.checkNotNullParameter(r17, "content");
        if (o0.d(r18) == false) goto L5;
        this.a.c.setText(r18);
    L5:
        AppHost.Companion r1 = AppHost.a;
        Resources r2 = r1.getApplication().getResources();
        if (r110 == null) goto L8;
        int r3 = WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).widthPixels - ((r2.getDimensionPixelSize(c.b(2130971163, null, 2131166696)) + r2.getDimensionPixelSize(c.b(2130971505, null, 2131167379))) + r2.getDimensionPixelSize(c.b(2130971390, null, 2131167150)));
    L9:
        int r14 = r3;
        this.a.b.setMaxWidth(r14);
        Resources r4 = r1.getApplication().getResources();
        if (r110 == null) goto L12;
        int r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).widthPixels - ((r4.getDimensionPixelSize(c.b(2130971163, null, 2131166696)) + r4.getDimensionPixelSize(c.b(2130971505, null, 2131167379))) + r4.getDimensionPixelSize(c.b(2130971390, null, 2131167150)));
    L13:
        int r6 = r5;
        if (Build.VERSION.SDK_INT < 23) goto L16;
        StaticLayout r7 = StaticLayout.Builder.obtain(r17, 0, r17.length(), this.a.b.getPaint(), r6).build();
    L17:
        Intrinsics.checkNotNull(r7);
        if (r7 == null) goto L31;
        int r8 = r7.getLineCount();
        int r9 = this.a.b.getMaxLines();
        if (r9 <= 0) goto L22;
        int r10 = r9;
    L23:
        if (r8 <= r10) goto L25;
        String r11 = r17.substring(0, r7.getLineEnd(r9 - 2)) + TextUtils.ellipsize(r17.substring(r7.getLineStart(r9 - 1), r17.length()), this.a.b.getPaint(), r7.getWidth() - this.a.c.getPaint().measureText(r18), TextUtils.TruncateAt.END);
        this.b = true;
        ViewGroup.LayoutParams r12 = this.a.a.getLayoutParams();
        r12.width = r14;
        this.a.a.setLayoutParams(r12);
        this.a.c.setVisibility(0);
    L29:
        this.a.b.setText(r11);
        return;
    L25:
        this.a.c.setVisibility(8);
        if (r110 != null) goto L28;
        this.a.b.setGravity(17);
    L28:
        this.b = false;
        r11 = r17;
        goto L29
    L22:
        r10 = 2;
        goto L23
    L31:
        return;
    L16:
        r7 = new StaticLayout(r17, this.a.b.getPaint(), r6, Layout.Alignment.ALIGN_NORMAL, this.a.b.getLineSpacingMultiplier(), this.a.b.getLineSpacingExtra(), this.a.b.getIncludeFontPadding());
        goto L17
    L12:
        r5 = r4.getDimensionPixelSize(c.b(2130971394, null, 2131167157));
        goto L13
    L8:
        r3 = r2.getDimensionPixelSize(c.b(2130971394, null, 2131167157));
        goto L9
    }
}
