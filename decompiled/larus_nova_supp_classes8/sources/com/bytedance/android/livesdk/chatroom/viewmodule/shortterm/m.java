package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.graphics.Rect;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdkapi.sti.IBigCardAnimExcuteListener;
import com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager;
import com.bytedance.android.livesdkapi.sti.ShortTermIcon;
import com.bytedance.android.livesdkapi.sti.ShortTermIndicatorEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ IBigCardAnimExcuteListener b;

    public m(p r1, wo1.g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        f r0 = this.a;
        IBigCardAnimExcuteListener r1 = this.b;
        r r2 = z51.a.d(r0.a());
        ShortTermIcon r3 = null;
        Object r4 = null;
        r3 = null;
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.j r5 = r2.D();
        if (r5 == null) goto L7;
        Object r6 = r5.getValue();
    L9:
        if ((r6 instanceof IShortTermIndicatorManager) == true) goto L11;
        r6 = null;
    L11:
        IShortTermIndicatorManager r7 = (IShortTermIndicatorManager) r6;
        if (r7 == null) goto L25;
        List r8 = r7.getIcons();
        if (r8 == null) goto L25;
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L24;
        Object r10 = r9.next();
        if (((ShortTermIcon) r10).getTypeId() != r0.q.type) goto L21;
        boolean r11 = true;
    L22:
        if (r11 == false) goto L17;
        r4 = r10;
        goto L24
    L21:
        r11 = false;
    L24:
        r3 = (ShortTermIcon) r4;
    L25:
        if (r3 == null) goto L33;
        Rect r12 = new Rect();
        r3.getView().getLocationOnScreen(new int[]{0, 0});
        r12.set(r3.getView().getLeft(), r3.getView().getTop(), r3.getView().getRight(), r3.getView().getBottom());
        r7.notify(new ShortTermIndicatorEvent.ReInitBigCardAnim(r3, r12, r1));
        return;
    L33:
        return;
    L7:
        r6 = null;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
