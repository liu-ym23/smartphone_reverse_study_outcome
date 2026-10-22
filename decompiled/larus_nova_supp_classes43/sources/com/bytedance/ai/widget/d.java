package com.bytedance.ai.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.view.WidgetBoxView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements com.bytedance.ai.utils.i {
    public static final List<String> i = null;
    public final WidgetContainer a;
    public MotionEvent b;
    public boolean c;
    public String d;
    public View e;
    public final Handler f;
    public boolean g;
    public final b h;

    public static final class a {
    }

    public final void b() {
        this.g = false;
        this.f.removeCallbacks(this.h);
    }

    static {
        com.bytedance.ai.settings.a<Integer> r0 = com.bytedance.ai.settings.b.a;
        i = com.bytedance.ai.settings.b.l.a();
    }

    public final boolean c() {
        if (this.c == true) goto L5;
    L7:
        return false;
    L5:
        if (CollectionsKt.contains(i, this.d) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ai.utils.h
    public final Float getLastMotionX() {
        MotionEvent r0 = this.b;
        if (r0 == null) goto L8;
        float r1 = r0.getRawX();
        View r10 = this.e;
        int[] r11 = new int[2];
        if (r10 == null) goto L10;
        r10.getLocationOnScreen(r11);
    L10:
        return Float.valueOf(r1 - r11[0]);
    L8:
        return null;
    }

    @Override // com.bytedance.ai.utils.h
    public final Float getLastMotionY() {
        MotionEvent r0 = this.b;
        if (r0 == null) goto L8;
        float r1 = r0.getRawY();
        View r10 = this.e;
        int[] r11 = new int[2];
        if (r10 == null) goto L10;
        r10.getLocationOnScreen(r11);
    L10:
        return Float.valueOf(r1 - r11[1]);
    L8:
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.ai.widget.b] */
    public d(WidgetContainer r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetContainer");
        this.a = r10;
        this.f = new Handler(Looper.getMainLooper());
        this.h = new b(this);
    }

    @Override // com.bytedance.ai.utils.i
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        if (c() == true) goto L5;
        return false;
    L5:
        Integer r0 = null;
        if (r10 == null) goto L8;
        Integer r11 = Integer.valueOf(r10.getAction());
    L9:
        if (r11 != null) goto L12;
    L14:
        boolean r12 = true;
        if (r11 != null) goto L18;
    L39:
        if (r11 != null) goto L42;
    L45:
        if (r11 != null) goto L48;
    L50:
        return false;
    L48:
        if (r11.intValue() != 3) goto L50;
        b();
        goto L50
    L42:
        if (r11.intValue() != 1) goto L45;
        boolean r13 = this.g;
        b();
        return r13;
    L18:
        if (r11.intValue() != 2) goto L39;
        View r14 = this.e;
        if (r14 == null) goto L24;
        Context r15 = r14.getContext();
        if (r15 == null) goto L24;
        r0 = Integer.valueOf(ViewConfiguration.get(r15).getScaledTouchSlop());
    L24:
        if (r0 == null) goto L36;
        r0.intValue();
        View r16 = this.e;
        if (r16 == null) goto L36;
        float r17 = r10.getX();
        float r18 = r10.getY();
        if (r17 < (-r0.intValue())) goto L36;
        if (r18 < (-r0.intValue())) goto L36;
        if (r17 >= ((r16.getRight() - r16.getLeft()) + r0.intValue())) goto L36;
        if (r18 >= ((r16.getBottom() - r16.getTop()) + r0.intValue())) goto L36;
    L37:
        if (r12 == true) goto L50;
        b();
    L36:
        r12 = false;
        goto L37
    L12:
        if (r11.intValue() != 0) goto L14;
        this.b = r10;
        b();
        com.bytedance.ai.utils.g.a.d("WidgetLongPressController", "this=" + this + ", send delay LongClick");
        this.f.postDelayed(this.h, ((long) ViewConfiguration.getLongPressTimeout()) + 300);
        goto L50
    L8:
        r11 = null;
        goto L9
    }

    @Override // com.bytedance.ai.utils.i
    public final void a(WidgetBoxView r10, String r11) {
        View r0 = this.e;
        View.OnLongClickListener r1 = null;
        if (r0 == null) goto L5;
        r0.setOnTouchListener(null);
    L5:
        View r12 = this.e;
        if (r12 == null) goto L8;
        r12.setOnLongClickListener(null);
    L8:
        this.e = r10;
        this.d = r11;
        if (c() == true) goto L11;
        b();
    L11:
        View r13 = this.e;
        if (r13 == null) goto L15;
        r13.setOnTouchListener(new c(this));
    L15:
        if (CollectionsKt.contains(i, this.d) == false) goto L20;
        this.c = true;
        if (c() == true) goto L20;
        b();
    L20:
        if (c() == false) goto L28;
        View r14 = this.e;
        if (r14 == null) goto L29;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 == null) goto L26;
        r1 = r15.s(this.a);
    L26:
        r14.setOnLongClickListener(r1);
        return;
    L29:
        return;
    }
}
