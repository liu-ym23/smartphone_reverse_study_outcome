package com.ss.ugc.live.barrage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import plc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/ugc/live/barrage/view/BarrageLayout;", "Landroid/view/View;", "Lplc/a;", "", "enable", "", "setEnableTouch", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barrage_release"}, k = 1, mv = {1, 4, 0})
public final class BarrageLayout extends View implements a {
    public final ArrayList<AbsBarrageController> a;
    public AbsBarrageController b;
    public boolean c;

    public BarrageLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BarrageLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<AbsBarrageController> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().m();
        goto L4
    }

    @Override // plc.a
    public final void a(AbsBarrageController r3) {
        int r0 = this.a.size();
        if (r3 == null) goto L6;
        ListProtector.add(this.a, r0, r3);
        return;
    }

    @Override // plc.a
    public final void b(AbsBarrageController r2) {
        if (r2 == null) goto L5;
        this.a.remove(r2);
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        int r0 = this.a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        AbsBarrageController r2 = (AbsBarrageController) ListProtector.get(this.a, r1);
        r2.d(r4);
        r2.c(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (this.c == false) goto L35;
        int r0 = r5.getAction();
        if (r0 == 0) goto L25;
        if (r0 != 1) goto L8;
        AbsBarrageController r1 = this.b;
        if (r1 != null) goto L36;
    L33:
        return super.onTouchEvent(r5);
    L36:
        boolean r6 = r1.k(r5);     // Catch: Throwable -> L22
        this.b = null;
        return r6;
    L22:
        th = move-exception;
        this.b = null;
        throw th;
    L8:
        if (r0 != 2) goto L10;
    L12:
        AbsBarrageController r2 = this.b;
        if (r2 == null) goto L33;
        return r2.k(r5);
    L10:
        if (r0 == 3) goto L12;
    L25:
        Iterator<AbsBarrageController> r3 = this.a.iterator();
    L27:
        if (r3.hasNext() == false) goto L33;
        AbsBarrageController r4 = r3.next();
        if (r4.k(r5) == false) goto L27;
        this.b = r4;
        return true;
    L35:
        return super.onTouchEvent(r5);
    }

    @Override // plc.a
    public void setEnableTouch(boolean r1) {
        this.c = r1;
    }

    public BarrageLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new ArrayList();
        this.c = true;
    }

    public /* synthetic */ BarrageLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
