package com.obric.oui.tab.optimize;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import cn.nubia.neopush.commons.Constant;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import hs.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import r9.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabBar;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lhs/a;", "listener", "", "setOnTabSelectedListener", "(Lhs/a;)V", "", Constant.ClientMessageType.SHOW, "setShowTopLine", "(Z)V", "<set-?>", "a", "I", "getSelectedIndex", "()I", "selectedIndex", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f14686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f14687c;
    public boolean d;

    static {
        new c();
    }

    @JvmOverloads
    public OBottomTabBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final int getSelectedIndex() {
        return this.f14685a;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.d == false) goto L10;
        r10.save();
        r10.drawLine(0.0f, this.f14686b / 2.0f, getWidth(), this.f14686b, this.f14687c);
        r10.restore();
        return;
    }

    public final void setOnTabSelectedListener(a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
    }

    public final void setShowTopLine(boolean r5) {
        this.d = r5;
        invalidate();
    }

    @JvmOverloads
    public OBottomTabBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OBottomTabBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OBottomTabBar(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14685a = -1;
        Paint r12 = new Paint();
        r12.setStyle(Paint.Style.FILL);
        r12.setColor(getResources().getColor(R$color.oui_line_2));
        this.f14687c = r12;
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setPadding((int) getResources().getDimension(R$dimen.oui_p_container_2), com.lynx.tasm.utils.a.C(this, 4.5d), (int) getResources().getDimension(R$dimen.oui_p_container_2), com.lynx.tasm.utils.a.B(2, this));
        float r13 = com.lynx.tasm.utils.a.A(0.6f, this);
        this.f14686b = r13;
        r12.setStrokeWidth(r13);
        setWillNotDraw(false);
        this.d = true;
    }
}
