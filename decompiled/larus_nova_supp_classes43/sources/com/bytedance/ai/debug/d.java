package com.bytedance.ai.debug;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.ai.widget.view.WidgetBoxView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final boolean a;
    public final Function0<Boolean> b;
    public boolean c;
    public boolean d;
    public float e;
    public float f;
    public float g;
    public float h;

    public static final class a implements com.bytedance.ai.lynx.g.b {
        public final /* synthetic */ d a;
        public final /* synthetic */ View b;

        @Override // com.bytedance.ai.lynx.g.b
        public final boolean onTouchEvent(MotionEvent r10) {
            return this.a.b(this.b, r10);
        }

        public a(d r1, View r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class b implements WidgetBoxView.b {
        public final /* synthetic */ d a;
        public final /* synthetic */ View b;

        @Override // com.bytedance.ai.widget.view.WidgetBoxView.b
        public final boolean onTouchEvent(MotionEvent r10) {
            return this.a.b(this.b, r10);
        }

        public b(d r1, View r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(View r10) {
        if (r10 != 0) goto L5;
        return;
    L5:
        if ((r10 instanceof com.bytedance.ai.lynx.g) == false) goto L9;
        a r1 = new a(this, r10);
        ((com.bytedance.ai.lynx.g) r10).j = r1;
        return;
    L9:
        if ((r10 instanceof WidgetBoxView) == false) goto L12;
        b r11 = new b(this, r10);
        ((WidgetBoxView) r10).j = r11;
        return;
    L12:
        r10.setOnTouchListener(new c(this));
    }

    public d(boolean r10, Function0<Boolean> r11) {
        Intrinsics.checkNotNullParameter(r11, "onTap");
        this.a = r10;
        this.b = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(View r10, MotionEvent r11) {
        Integer r1 = null;
        if ((r10 instanceof com.bytedance.ai.lynx.g) == false) goto L8;
        Object r0 = ((com.bytedance.ai.lynx.g) r10).getDebugOverlay();
        if ((r0 instanceof e) == false) goto L15;
        e r12 = (e) r0;
    L16:
        if (r11 == null) goto L18;
        r1 = Integer.valueOf(r11.getActionMasked());
    L18:
        boolean r13 = true;
        if (r1 != null) goto L22;
    L35:
        if (r1 == null) goto L62;
        if (r1.intValue() != 2) goto L62;
        if (this.c == true) goto L43;
        return false;
    L43:
        if (this.a == false) goto L57;
        if (r12 == null) goto L57;
        float r14 = ViewConfiguration.get(r10.getContext()).getScaledTouchSlop();
        if (this.d == true) goto L53;
        if (Math.abs(r11.getX() - this.e) <= r14) goto L50;
    L51:
        this.d = true;
        goto L53
    L50:
        if (Math.abs(r11.getY() - this.f) > r14) goto L51;
    L53:
        if (this.d == false) goto L57;
        r12.b(r10.getWidth(), r10.getHeight(), r11.getX() - this.g, r11.getY() - this.h);
        r10.invalidate();
        return true;
    L57:
        if (IAISDKDebugService.a.p(r10, r11.getX(), r11.getY()) == true) goto L60;
        this.c = false;
    L60:
        return this.c;
    L62:
        if (r1 != null) goto L65;
    L80:
        if (r1 != null) goto L83;
    L85:
        return false;
    L83:
        if (r1.intValue() != 3) goto L85;
        this.c = false;
        this.d = false;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        goto L85
    L65:
        if (r1.intValue() != 1) goto L80;
        if (this.d == false) goto L71;
        this.c = false;
        this.d = false;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        return true;
    L71:
        if (this.c == true) goto L73;
    L77:
        r13 = false;
    L78:
        this.c = false;
        this.d = false;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        return r13;
    L73:
        if (IAISDKDebugService.a.p(r10, r11.getX(), r11.getY()) == false) goto L77;
        if (((Boolean) this.b.invoke()).booleanValue() == false) goto L77;
    L22:
        if (r1.intValue() != 0) goto L35;
        if (r12 != null) goto L25;
    L27:
        r13 = false;
    L28:
        this.c = r13;
        this.d = false;
        this.e = r11.getX();
        this.f = r11.getY();
        if (r12 == null) goto L34;
        RectF r15 = r12.a(r10.getWidth(), r10.getHeight());
        if (r15 == null) goto L34;
        this.g = r11.getX() - r15.left;
        this.h = r11.getY() - r15.top;
    L34:
        return this.c;
    L25:
        if (IAISDKDebugService.a.p(r10, r11.getX(), r11.getY()) == false) goto L27;
    L15:
        r12 = null;
        goto L16
    L8:
        if ((r10 instanceof WidgetBoxView) == false) goto L12;
        Object r16 = ((WidgetBoxView) r10).getDebugOverlay();
        if ((r16 instanceof e) == false) goto L15;
        r12 = (e) r16;
        goto L16
    L12:
        Object r17 = r10.getForeground();
        if ((r17 instanceof e) == false) goto L15;
        r12 = (e) r17;
        goto L16
    }
}
