package com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.d90;
import com.bytedance.android.livesdk.config.vc1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/explaincard/NormalCardBtn;", "Landroid/widget/FrameLayout;", "", "text", "", "setDesText", "setInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NormalCardBtn extends FrameLayout {
    public NormalCardBtn(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NormalCardBtn(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final void setDesText(String r4) {
        TextView r0 = new TextView(getContext());
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        r4 = s1.B(2131920417);
    L11:
        r0.setText(r4);
        r0.setGravity(17);
        if (((vc1) d90.a.getValue()).a() != 1) goto L14;
        r0.setTextSize(14.0f);
    L15:
        r0.setTypeface(Typeface.defaultFromStyle(1));
        r0.setTextColor(ContextCompat.getColor(getContext(), 2131101254));
        removeAllViews();
        addView(r0, new LinearLayout.LayoutParams(-1, -1));
        return;
    L14:
        r0.setTextSize(12.0f);
        goto L15
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void setInfo(String r8) {
        Integer r0 = Integer.valueOf(Color.parseColor("#FE2C55"));     // Catch: IllegalArgumentException -> L4
    L5:
        if (r0 == null) goto L7;
        int r1 = r0.intValue();
        float r3 = 2;
        float[] r2 = {UtilityKotlinExtentionsKt.h(r3), UtilityKotlinExtentionsKt.h(r3), UtilityKotlinExtentionsKt.h(r3), UtilityKotlinExtentionsKt.h(r3), UtilityKotlinExtentionsKt.h(r3), UtilityKotlinExtentionsKt.h(r3), UtilityKotlinExtentionsKt.h(r3), UtilityKotlinExtentionsKt.h(r3)};
        ShapeDrawable r4 = new ShapeDrawable(new RoundRectShape(r2, new RectF(0.0f, 0.0f, 0.0f, 0.0f), r2));
        r4.getPaint().setColor(r1);
        r4.setBounds(new Rect(0, 0, getHeight(), getBottom()));
        setBackground(r4);
    L7:
        setDesText(r8);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public NormalCardBtn(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ NormalCardBtn(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
