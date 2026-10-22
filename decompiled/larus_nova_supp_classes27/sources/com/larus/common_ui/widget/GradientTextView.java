package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J0\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0015R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/common_ui/widget/GradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableGradient", "", "", "init", "onLayout", "changed", "left", "top", "right", "bottom", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GradientTextView extends AppCompatTextView {
    public static final int b = 0;
    public static final int c = 0;
    public boolean a;

    public static final class a {
    }

    static {
        b = ColorProtector.parseColor("#FFFF37A3");
        c = ColorProtector.parseColor("#FF9C4EFF");
    }

    public GradientTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = true;
    }

    public GradientTextView(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "attrs");
        super(r5, r6);
        this.a = true;
        if (r6 == null) goto L6;
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130971621});
        this.a = r7.getBoolean(0, true);
        r7.recycle();
        return;
    }

    public GradientTextView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        super(r4, r5, r6);
        this.a = true;
        if (r5 == null) goto L6;
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130971621});
        this.a = r7.getBoolean(0, true);
        r7.recycle();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        super.onLayout(r9, r10, r11, r12, r13);
        if (this.a == false) goto L8;
        LinearGradient r14 = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, b, c, Shader.TileMode.CLAMP);
        if (r9 == false) goto L9;
        getPaint().setShader(r14);
        return;
    L9:
        return;
    }
}
