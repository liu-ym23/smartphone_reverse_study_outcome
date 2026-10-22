package com.larksuite.component.card.component.table;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.ss.android.lark.utils.LarkContext;
import j08.b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H\u0014J\n\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larksuite/component/card/component/table/TableMarkdownUI;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/lynx/tasm/behavior/ui/view/AndroidView;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "itemView", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "mPaint", "Landroid/graphics/Paint;", "mLinearGradient", "Landroid/graphics/LinearGradient;", "mMaskHeight", "", "createView", "Landroid/content/Context;", "getMarkDownView", "needShowMask", "", "afterDispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawMask", "onLayoutUpdated", "resetMaskHeight", "getStartColor", "", "getEndColor", "findLynxUIByIdSelector", "idSelector", "", "ui", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TableMarkdownUI extends UIGroup<com.lynx.tasm.behavior.ui.view.a> {
    public static final /* synthetic */ int d = 0;
    public LynxBaseUI a;
    public final Paint b;
    public float c;

    public static final class a {
    }

    static {
    }

    public final void onLayoutUpdated() {
        super/*com.lynx.tasm.behavior.ui.LynxUI*/.onLayoutUpdated();
        float r0 = b.a(LarkContext.getApplication(), 55.0f);
        if (getHeight() >= r0) goto L5;
        r0 = b.a(LarkContext.getApplication(), 32.0f);
    L5:
        this.c = r0;
        float r1 = b.a(LarkContext.getApplication(), 4.0f);
        float r3 = getHeight() - this.c;
        float r5 = getHeight() - r1;
        int r2 = ContextCompat.getColor(getLynxContext().getContext(), 2131100557);
        this.b.setShader(new LinearGradient(0.0f, r3, 0.0f, r5, Color.argb(0, Color.red(r2), Color.green(r2), Color.blue(r2)), ContextCompat.getColor(getLynxContext().getContext(), 2131100557), Shader.TileMode.CLAMP));
    }

    public TableMarkdownUI(LynxContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        Paint r4 = new Paint();
        this.b = r4;
        this.c = b.a(LarkContext.getApplication(), 55.0f);
        r4.setAntiAlias(true);
    }

    public static LynxBaseUI M(LynxBaseUI r4) {
        if (r4 == null) goto L10;
        if (r4.getIdSelector() == null) goto L10;
        if (Intrinsics.areEqual(r4.getIdSelector(), "markdown-item") == false) goto L10;
        return r4;
    L10:
        if (r4 != null) goto L12;
        return null;
    L12:
        Iterator r5 = r4.getChildren().iterator();
    L14:
        if (r5.hasNext() == false) goto L26;
        LynxBaseUI r2 = (LynxBaseUI) r5.next();
        if (r2 == null) goto L18;
        String r3 = r2.getIdSelector();
    L19:
        if (r3 != null) goto L21;
    L23:
        LynxBaseUI r6 = M(r2);
        if (r6 == null) goto L14;
        return r6;
    L21:
        if (Intrinsics.areEqual(r2.getIdSelector(), "markdown-item") == false) goto L23;
        return r2;
    L18:
        r3 = null;
        goto L19
    L26:
        return null;
    }

    public final void afterDispatchDraw(Canvas r8) {
        super.afterDispatchDraw(r8);
        if (this.a != null) goto L5;
        this.a = M(this);
    L5:
        LynxBaseUI r0 = this.a;
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L15;
        if (r8 == null) goto L16;
        r8.drawRect(0.0f, getHeight() - this.c, getWidth(), getHeight(), this.b);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r0.getHeight() <= getHeight()) goto L10;
        r1 = true;
        goto L11
    }

    public final View createView(Context r2) {
        return new com.lynx.tasm.behavior.ui.view.a(r2);
    }
}
