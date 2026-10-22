package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.jv;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q1 extends BaseControllerListener<Object> {
    public final /* synthetic */ PortraitToolbarMoreBehavior a;

    public class a extends BaseAnimationListener {
        public int a;
        public final /* synthetic */ Animatable b;
        public final /* synthetic */ q1 c;

        public final void onAnimationStop(AnimatedDrawable2 r5) {
            Disposable r6 = this.c.a.Y;
            if (r6 == null) goto L5;
            r6.dispose();
            this.c.a.Y = null;
        L5:
            PortraitToolbarMoreBehavior r7 = this.c.a;
            jv r0 = jv.a;
            r7.Y = Observable.timer(r0.getValue().f(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new o1(this), new p1());
            com.bytedance.android.livesdk.log.u.l().b("livesdk_live_quickshareicon_show");
            if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.r.getValue()).booleanValue() == false) goto L8;
            return;
        L8:
            com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.b.s;
            if (((Integer) r8.getValue()).intValue() < r0.getValue().a()) goto L11;
            return;
        L11:
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r1 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.c.a.g);
            ToolbarButton r2 = ToolbarButton.MORE;
            int r3 = pp1.c.o;
            r1.b(r2, pp1.c.a.a("一键召唤粉丝助力"));
            com.bytedance.android.livesdk.log.u.l().b("livesdk_live_quicksharebubble_show");
            com.bytedance.android.livesdk.sharedpref.f.d(r8, Integer.valueOf(((Integer) r8.getValue()).intValue() + 1));
        }

        public a(q1 r1, Animatable r2) {
            this.c = r1;
            this.b = r2;
            this.a = -1;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
            if (r2 >= this.a) goto L5;
            this.b.stop();
        L5:
            this.a = r2;
        }
    }

    public q1(PortraitToolbarMoreBehavior r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, @Nullable Object r2, @Nullable Animatable r3) {
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r3).setAnimationListener(new a(this, r3));
        return;
    }
}
