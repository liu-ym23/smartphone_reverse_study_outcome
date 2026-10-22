package com.obric.oui.tag;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/tag/OTextTag;", "Lcom/obric/oui/text/OTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTextTag extends OTextView {
    @JvmOverloads
    public OTextTag(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void a(boolean r10) {
        int r5 = getPaddingTop();
        int r11 = getPaddingEnd();
        int r12 = getPaddingBottom();
        int r13 = RangesKt.coerceAtLeast(getCompoundDrawablePadding(), 0);
        if (r10 == false) goto L5;
        int r14 = RangesKt.coerceAtLeast(r11 - r13, 0);
    L7:
        if (r14 == getPaddingStart()) goto L10;
        setPaddingRelative(r14, r5, r11, r12);
        return;
    L10:
        return;
    L5:
        r14 = r11;
        goto L7
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r5, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r5, r10, r11, r12);
        if (r5 == null) goto L5;
        boolean r13 = true;
    L6:
        a(r13);
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r5, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelative(r5, r10, r11, r12);
        if (r5 == null) goto L5;
        boolean r13 = true;
    L6:
        a(r13);
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // com.obric.oui.text.OTextView
    public /* bridge */ /* synthetic */ void setFakePressed(boolean r5) {
    }

    @JvmOverloads
    public OTextTag(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OTextTag(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OTextTag(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11, 8);
        setCompoundDrawableTintList(ColorStateList.valueOf(getCurrentTextColor()));
        boolean r12 = false;
        if (ArraysKt.getOrNull(getCompoundDrawables(), 0) == null) goto L5;
    L6:
        r12 = true;
    L7:
        a(r12);
        return;
    L5:
        if (ArraysKt.getOrNull(getCompoundDrawablesRelative(), 0) == null) goto L7;
        goto L6
    }
}
