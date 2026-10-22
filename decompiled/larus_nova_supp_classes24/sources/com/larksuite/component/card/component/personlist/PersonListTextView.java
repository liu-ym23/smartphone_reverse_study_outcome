package com.larksuite.component.card.component.personlist;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonListTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "scrollTo", "", "x", "", "y", "onDraw", "canvas", "Landroid/graphics/Canvas;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonListTextView extends AppCompatTextView {
    public final void scrollTo(int r1, int r2) {
    }

    public PersonListTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        TraceEvent.beginSection("PersonListTextView.onDraw");
        super/*android.widget.TextView*/.onDraw(r2);
        TraceEvent.endSection("PersonListTextView.onDraw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PersonListTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        TextPaint r4 = getPaint();
        g.a.getClass();
        r4.setTextSize(g.h(null));
        getPaint().setColor(UIHelper.getColor(2131106620));
        getPaint().setAntiAlias(true);
        setHighlightColor(0);
        if (com.larksuite.component.card.component.e.b != null) goto L5;
        com.larksuite.component.card.component.e.b = new com.larksuite.component.card.component.e();
    L5:
        setMovementMethod(com.larksuite.component.card.component.e.b);
    }
}
