package com.bytedance.android.live.recharge.platform.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.LiveTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/core/ui/DiamondFitTextView;", "Lcom/bytedance/android/live/core/widget/LiveTextView;", "", "size", "", "setDesTextSize", "", "getAvailableWidth", "()I", "availableWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DiamondFitTextView extends LiveTextView {
    public float c;
    public float d;
    public int e;
    public String f;
    public String g;

    /* JADX WARN: Multi-variable type inference failed */
    private final int getAvailableWidth() {
        ViewParent r0 = getParent();
        int r2 = 0;
        if ((r0 instanceof ViewGroup) == false) goto L15;
        ViewGroup r1 = (ViewGroup) r0;
        if (r1.getWidth() != 0) goto L7;
        return 0;
    L7:
        int r3 = r1.getChildCount();
        int r4 = 0;
    L8:
        if (r2 >= r3) goto L14;
        if (r1.getChildAt(r2) == this) goto L12;
        r4 = r4 + r1.getChildAt(r2).getWidth();
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return (r1.getWidth() - r4) - 20;
    L15:
        return 0;
    }

    public DiamondFitTextView(Context r2) {
        this(r2, null);
    }

    public final void setDesTextSize(float r1) {
        this.d = r1;
    }

    public final void y(String r3) {
        if (r3 != null) goto L4;
    L6:
        setTextSize(0, this.c);
        z(r3, this.d, false);
        return;
    L4:
        if (r3.length() <= 5) goto L6;
        this.c = s1.f(15.0f);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiamondFitTextView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        new TextPaint();
        if (r5 == null) goto L5;
        TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{2130974755});
        this.d = r6.getDimensionPixelSize(0, s1.f(13.0f));
        r6.recycle();
    L5:
        new TextPaint().set(getPaint());
        this.c = getTextSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(String r4, float r5, boolean r6) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (r5 == 0.0f) goto L13;
        if (r6 == false) goto L9;
        y(r4);
        return;
    L9:
        SpannableStringBuilder r7 = new SpannableStringBuilder(Intrinsics.stringPlus(r4, this.g));
        AbsoluteSizeSpan r0 = new AbsoluteSizeSpan((int) r5);
        Intrinsics.checkNotNull(r4);
        int r8 = r4.length();
        int r1 = r4.length();
        String r2 = this.g;
        Intrinsics.checkNotNull(r2);
        r7.setSpan(r0, r8, r1 + r2.length(), 33);
        ForegroundColorSpan r9 = new ForegroundColorSpan(s1.h(this.e));
        int r3 = r4.length();
        int r10 = r4.length();
        String r12 = this.g;
        Intrinsics.checkNotNull(r12);
        r7.setSpan(r9, r3, r10 + r12.length(), 33);
        setText(r7);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        if (r1 == r3) goto L5;
        boolean r5 = getParent() instanceof ViewGroup;
        y(this.f);
        return;
    }
}
