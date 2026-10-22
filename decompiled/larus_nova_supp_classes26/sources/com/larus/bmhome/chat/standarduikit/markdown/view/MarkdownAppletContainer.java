package com.larus.bmhome.chat.standarduikit.markdown.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.google.android.material.card.MaterialCardView;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0019\u0018\u0000 32\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005:\u00013B\u001d\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J!\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020\u0011H\u0002J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u0015J\u001a\u0010*\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u00020,H\u0016J5\u0010-\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u00010,2\b\u00100\u001a\u0004\u0018\u00010,2\b\u00101\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0002\u00102R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/markdown/view/MarkdownAppletContainer;", "Lcom/google/android/material/card/MaterialCardView;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/markdown/view/MarkdownAppletContainerInput;", "Lcom/larus/bmhome/chat/standarduikit/markdown/view/MarkdownAppletContainerOutput;", "Lcom/larus/business/markdown/api/view/IMarkdownMarginFreeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "appletWidget", "Lcom/larus/bmhome/chat/layout/widget/AppletWidget;", "size", "Landroid/util/Size;", "isFullWidth", "", "appletWidgetView", "Landroid/view/View;", "bindData", "", "input", "output", "generateExposureCallback", "com/larus/bmhome/chat/standarduikit/markdown/view/MarkdownAppletContainer$generateExposureCallback$1", "mixtureCardId", "", "renderData", "(Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/standarduikit/markdown/view/MarkdownAppletContainer$generateExposureCallback$1;", "registerAutoExposureManager", "exposureManager", "Lcom/larus/bmhome/chat/exposure/ExposureManager;", "lastContainerConfig", "Lcom/larus/bmhome/chat/standarduikit/markdown/view/AppletContainerUIConfig;", "updateContainUI", "containerUIConfig", "isFullBlock", "onViewRecycled", "data", "Lcom/larus/bmhome/chat/layout/widget/RecycleData;", "resetForSkip", "sizeThatFits", "preferredMaxWidth", "", "onMarkdownMarginChanged", "left", "top", "right", "bottom", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownAppletContainer extends MaterialCardView implements nw8.a {
    public static final /* synthetic */ int e = 0;
    public AppletWidget a;
    public Size b;
    public boolean c;
    public bm8.a d;

    public static final class a {
    }

    static {
    }

    public MarkdownAppletContainer(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MarkdownAppletContainer(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        setCardElevation(0.0f);
        setCardBackgroundColor(null);
        setImportantForAccessibility(2);
        this.b = new Size(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(bm8.a r5, boolean r6) {
        bm8.a r0 = this.d;
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        if (r5 == null) goto L8;
        int r3 = r5.hashCode();
    L9:
        if (r2 == r3) goto L28;
        if (r5 == null) goto L12;
        r1 = Intrinsics.areEqual(r5.a, Boolean.TRUE);
    L12:
        if (r1 == false) goto L19;
        Integer r4 = r5.c;
        if (r4 == null) goto L16;
        setStrokeColor(r4.intValue());
    L16:
        Integer r7 = r5.d;
        if (r7 == null) goto L19;
        setStrokeWidth(r7.intValue());
    L19:
        if (r5 == null) goto L28;
        Float r8 = r5.b;
        if (r8 == null) goto L28;
        float r9 = r8.floatValue();
        if (r6 == false) goto L25;
        setCardBackgroundColor(ContextCompat.getColor(getContext(), 2131102529));
        setRadius(r9);
        goto L28
    L25:
        AppletWidget r10 = this.a;
        if (r10 == null) goto L28;
        r10.j(Float.valueOf(r9), Float.valueOf(r9), Float.valueOf(r9), Float.valueOf(r9));
    L28:
        this.d = r5;
        return;
    L8:
        r3 = 0;
        goto L9
    L5:
        r2 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nw8.a
    public final void k(Integer r6, Integer r7, Integer r8, Integer r9) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.c == false) goto L11;
        r6 = 0;
    L11:
        boolean r2 = true;
        if (r6 != null) goto L14;
    L16:
        boolean r10 = false;
    L17:
        if (r7 == null) goto L22;
        if (r1.topMargin == r7.intValue()) goto L22;
        r1.topMargin = r7.intValue();
        r10 = true;
    L22:
        if (this.c == false) goto L24;
        r8 = 0;
    L24:
        if (r8 != null) goto L26;
    L28:
        if (r9 != null) goto L30;
    L32:
        r2 = r10;
    L33:
        if (r2 == false) goto L36;
        setLayoutParams(r1);
    L36:
        if (getVisibility() == 0) goto L39;
        setVisibility(0);
        return;
    L39:
        return;
    L30:
        if (r1.bottomMargin == r9.intValue()) goto L32;
        r1.bottomMargin = r9.intValue();
        goto L33
    L26:
        if (r1.rightMargin == r8.intValue()) goto L28;
        r1.rightMargin = r8.intValue();
        r10 = true;
        goto L28
    L14:
        if (r1.leftMargin == r6.intValue()) goto L16;
        r1.leftMargin = r6.intValue();
        r10 = true;
        goto L17
    L5:
        r1 = null;
        goto L6
    }
}
