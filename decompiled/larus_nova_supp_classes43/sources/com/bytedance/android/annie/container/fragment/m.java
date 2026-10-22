package com.bytedance.android.annie.container.fragment;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.annie.card.AnnieCard;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements Runnable {
    public final /* synthetic */ AnnieFragment a;
    public final /* synthetic */ Ref.ObjectRef<AnnieCard> b;
    public final /* synthetic */ FrameLayout c;

    public m(AnnieFragment r1, Ref.ObjectRef<AnnieCard> r10, FrameLayout r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void a() {
        if (((Boolean) this.a.I.getValue()).booleanValue() == false) goto L18;
        AnnieCard r0 = (AnnieCard) this.b.element;
        ViewParent r1 = null;
        if (r0 == null) goto L7;
        ViewParent r10 = r0.getParent();
    L8:
        if (r10 != null) goto L10;
        this.c.addView((View) this.b.element);
        return;
    L10:
        com.bytedance.android.annie.param.a r11 = this.a.f;
        if (r11 == null) goto L21;
        x8.b r12 = r11.d;
        if (r12 == null) goto L22;
        StringBuilder r13 = new StringBuilder("annie card already has a parent. card status: parent=");
        AnnieCard r14 = (AnnieCard) this.b.element;
        if (r14 == null) goto L17;
        r1 = r14.getParent();
    L17:
        r13.append(r1);
        r13.append(", others=");
        r13.append(this.b.element);
        r12.e("AnnieFragment", r13.toString());
        return;
    L22:
        return;
    L21:
        return;
    L7:
        r10 = null;
        goto L8
    L18:
        this.c.addView((View) this.b.element);
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
