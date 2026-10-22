package com.larus.dora.impl.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/impl/view/DoraItemTitleTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "setEnabled", "enabled", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraItemTitleTextView extends AppCompatTextView {
    public DoraItemTitleTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        x(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnabled(boolean r2) {
        if (r2 == false) goto L4;
        float r0 = 1.0f;
    L5:
        setAlpha(r0);
        super/*android.widget.TextView*/.setEnabled(r2);
        return;
    L4:
        r0 = 0.3f;
        goto L5
    }

    public DoraItemTitleTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        x(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(Context r6, AttributeSet r7) {
        TypedArray r8 = r6.obtainStyledAttributes(r7, new int[]{R.attr.textColor, R.attr.text, R.attr.textFontWeight, 2130972009, 2130972012, 2130972013});
        String r0 = r8.getString(1);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        setText(r0);
        setTextColor(ContextCompat.getColor(r6, 2131103136));
        setTextSize(0, i5.q());
        if (Build.VERSION.SDK_INT < 28) goto L8;
        setTypeface(Typeface.create(getTypeface(), r8.getInteger(2, 400), getTypeface().isItalic()));
    L8:
        setSingleLine(false);
        setMaxLines(2);
        setEllipsize(TextUtils.TruncateAt.END);
        setTextAlignment(5);
        int r9 = r8.getResources().getDimensionPixelSize(c.b(2130971208, null, 2131166786));
        int r1 = getPaddingTop();
        int r2 = getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r9 + ",top:" + r1 + ",end:" + r9 + ",bottom:" + r2);
        setPaddingRelative(r9, r1, r9, r2);
        r8.recycle();
    }

    public DoraItemTitleTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        x(r2, r3);
    }
}
