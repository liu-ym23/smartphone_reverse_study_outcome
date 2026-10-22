package com.obric.oui.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "use OTextTag")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/tag/OTag;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgEndColor", "bgStartColor", "borderColor", "bordered", "", "tagSize", "getTagSize$annotations", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTag extends AppCompatTextView {
    private int bgEndColor;
    private int bgStartColor;
    private int borderColor;
    private boolean bordered;
    private int tagSize;

    public OTag(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OTag(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OTag(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r8);
        TypedArray r11 = r9.getTheme().obtainStyledAttributes(r10, R.styleable.OTag, 0, 0);
        this.tagSize = r11.getInteger(ZeusTransformUtils.mapRes(R.styleable.OTag_oui_size, "styleable", "OTag_oui_size"), 0);     // Catch: Throwable -> L18
        this.bordered = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTag_oui_bordered, "styleable", "OTag_oui_bordered"), false);     // Catch: Throwable -> L18
        this.borderColor = r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OTag_oui_borderColor, "styleable", "OTag_oui_borderColor"), 0);     // Catch: Throwable -> L18
        this.bgStartColor = r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OTag_oui_bgGradientStartColor, "styleable", "OTag_oui_bgGradientStartColor"), 0);     // Catch: Throwable -> L18
        this.bgEndColor = r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OTag_oui_bgGradientEndColor, "styleable", "OTag_oui_bgGradientEndColor"), 0);     // Catch: Throwable -> L18
        r11.recycle();
        int r12 = this.tagSize;
        if (r12 == 0) goto L9;
        if (r12 == 2) goto L8;
        int r13 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1);
        int r14 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 3);
    L10:
        setPadding(r14, r13, r14, r13);
        if (this.bgStartColor != 0) goto L13;
    L15:
        GradientDrawable r15 = new GradientDrawable();
    L16:
        r15.setCornerRadius(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2));
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r15, Drawable.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        if (this.bgEndColor == 0) goto L15;
        r15 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{this.bgStartColor, this.bgEndColor});
        goto L16
    L8:
        r13 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2);
        r14 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
        goto L10
    L9:
        r14 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 3);
        r13 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1);
    L18:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public /* synthetic */ OTag(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private static /* synthetic */ void getTagSize$annotations() {
    }
}
