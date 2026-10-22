package com.obric.oui.tag;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "use OTextTag")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/tag/OTag;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "tagSize", "I", "getTagSize$annotations", "()V", "bgStartColor", "bgEndColor", "", "bordered", "Z", "borderColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OTag extends AppCompatTextView {

    @ColorInt
    private int bgEndColor;

    @ColorInt
    private int bgStartColor;

    @ColorInt
    private int borderColor;
    private boolean bordered;
    private int tagSize;

    @JvmOverloads
    public OTag(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OTag(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OTag(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        TypedArray r13 = r10.getTheme().obtainStyledAttributes(r11, l.OTag, 0, 0);
        this.tagSize = r13.getInteger(l.OTag_oui_size, 0);     // Catch: Throwable -> L19
        this.bordered = r13.getBoolean(l.OTag_oui_bordered, false);     // Catch: Throwable -> L19
        this.borderColor = r13.getColor(l.OTag_oui_borderColor, 0);     // Catch: Throwable -> L19
        this.bgStartColor = r13.getColor(l.OTag_oui_bgGradientStartColor, 0);     // Catch: Throwable -> L19
        this.bgEndColor = r13.getColor(l.OTag_oui_bgGradientEndColor, 0);     // Catch: Throwable -> L19
        r13.recycle();
        int r14 = this.tagSize;
        int r15 = 3;
        if (r14 == 0) goto L10;
        if (r14 == 2) goto L9;
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        int r17 = MathKt.roundToInt(TypedValue.applyDimension(1, 1, r16.getDisplayMetrics()));
    L8:
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        int r19 = MathKt.roundToInt(TypedValue.applyDimension(1, r15, r18.getDisplayMetrics()));
    L11:
        setPadding(r19, r17, r19, r17);
        if (this.bgStartColor != 0) goto L14;
    L16:
        GradientDrawable r20 = new GradientDrawable();
    L17:
        Resources r21 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r21, "Resources.getSystem()");
        r20.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 2, r21.getDisplayMetrics())));
        setBackground(r20);
        return;
    L14:
        if (this.bgEndColor == 0) goto L16;
        r20 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{this.bgStartColor, this.bgEndColor});
        goto L17
    L9:
        Resources r22 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r22, "Resources.getSystem()");
        r17 = MathKt.roundToInt(TypedValue.applyDimension(1, 2, r22.getDisplayMetrics()));
        r15 = 4;
        goto L8
    L10:
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        r19 = MathKt.roundToInt(TypedValue.applyDimension(1, 3, r23.getDisplayMetrics()));
        Resources r24 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r24, "Resources.getSystem()");
        r17 = MathKt.roundToInt(TypedValue.applyDimension(1, 1, r24.getDisplayMetrics()));
    L19:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    public /* synthetic */ OTag(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private static /* synthetic */ void getTagSize$annotations() {
    }
}
