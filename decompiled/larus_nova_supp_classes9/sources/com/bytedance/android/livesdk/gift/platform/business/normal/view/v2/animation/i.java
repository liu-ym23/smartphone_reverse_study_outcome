package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ py.k b;
    public final /* synthetic */ a5 c;

    public i(f r1, py.k r2, a5 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        f r0 = this.a;
        py.k r1 = this.b;
        a5 r2 = this.c;
        HSImageView r3 = r0.c;
        if (r3 == null) goto L5;
        r3.setController(null);
    L5:
        HSImageView r4 = r0.c;
        if (r4 == null) goto L8;
        r4.setVisibility(0);
    L8:
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = null;
        if (r2 == null) goto L20;
        TextView r6 = r0.h;
        if (r6 == null) goto L13;
        r6.setText(vh6.c.b(ur2.a.class).Lf(r2, "点击查看"));
    L13:
        TextView r7 = r0.h;
        if (r7 == null) goto L16;
        r7.setVisibility(0);
    L16:
        TextView r8 = r0.h;
        if (r8 == null) goto L19;
        r8.setAlpha(0.0f);
    L19:
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r0.h, "alpha", new float[]{0.0f, 1.0f});
        r5.element = r9;
        r9.setDuration(500);
    L20:
        Ref.BooleanRef r10 = new Ref.BooleanRef();
        r10.element = false;
        h r11 = new h(r0, r10, r5);
        ViewGroup r13 = r0.g;
        if (r13 == null) goto L24;
        r13.postDelayed(new g(r0, r10), 5000);
    L24:
        if (r1.isValid() == false) goto L28;
        HSImageView r14 = r0.c;
        if (r14 == null) goto L30;
        r14.setController(Fresco.newDraweeControllerBuilder().setControllerListener(r11).setUri((String) ListProtector.get(r1.getUrls(), 0)).setAutoPlayAnimations(false).build());
        return;
    L30:
        return;
    L28:
        r0.b();
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
