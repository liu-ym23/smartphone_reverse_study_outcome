package com.lynx.tasm.behavior;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.obric.flow.cardlistpage.data.FakeWidgetCardModel;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f10312c;
    public final /* synthetic */ float d;
    public final /* synthetic */ Object e;

    public /* synthetic */ p0(Object r5, int r10, int r11, float r12, float r13) {
        this.f10310a = r11;
        this.e = r5;
        this.f10311b = r10;
        this.f10312c = r12;
        this.d = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10310a) {
            case 0: goto L22;
            default: goto L4;
        };
    L4:
        com.obric.flow.cardlistpage.ui.component.feedlist.s r5 = (com.obric.flow.cardlistpage.ui.component.feedlist.s) this.e;
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Iterator r10 = r5.f11602j.f7569a.iterator();
        int r11 = 0;
    L6:
        if (r10.hasNext() == false) goto L11;
        if ((r10.next() instanceof FakeWidgetCardModel) == true) goto L12;
        r11 = r11 + 1;
    L12:
        if (r11 != (-1)) goto L15;
        r11 = this.f10311b;
    L15:
        RecyclerView r12 = r5.e;
        RecyclerView.ViewHolder r13 = r12.findViewHolderForAdapterPosition(r11);
        if (r13 == null) goto L29;
        View r14 = r13.itemView;
        Intrinsics.checkNotNull(r12);
        r12.getLocationOnScreen(new int[2]);
        int[] r15 = new int[2];
        r14.getLocationOnScreen(r15);
        float r16 = (r14.getWidth() / 2.0f) + r15[0];
        float r17 = (r14.getHeight() / 2.0f) + r15[1];
        float r18 = this.f10312c;
        float r19 = r18 - r16;
        float r110 = this.d;
        float r20 = r110 - r17;
        kq.b r21 = r5.f11607o;
        if (r21 == null) goto L28;
        Intrinsics.checkNotNullParameter(r13, "vh");
        r21.d = true;
        long r22 = SystemClock.uptimeMillis();
        r21.f19462c = r22;
        MotionEvent r111 = MotionEvent.obtain(r22, r22, 0, r18 - r19, r110 - r20, 0);
        Intrinsics.checkNotNull(r111);
        r21.f19460a.a(r111);
        r21.f19461b.startDrag(r13);
        r111.recycle();
        return;
    L28:
        return;
    L29:
        return;
    L11:
        r11 = -1;
        goto L12
    L22:
        LynxBaseUI r23 = ((PaintingContext) this.e).f10169a.v(this.f10311b);
        if (r23 == null) goto L30;
        r23.scrollBy(this.f10312c, this.d);
        return;
    }
}
