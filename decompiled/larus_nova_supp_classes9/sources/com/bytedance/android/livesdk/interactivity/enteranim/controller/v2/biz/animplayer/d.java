package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.apm.impl.protector.RunnableProtector;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends AnimPlayer<k32.a> {

    public class a implements Runnable {
        public final /* synthetic */ TextView a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setSelected(true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(TextView r1) {
            this.a = r1;
        }
    }

    public class b extends s72.c {
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ ViewGroup c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.b.removeView(this.c);
            ((v72.c.a) this.a).a();
        }

        @Override // s72.c, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
            com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2 = this.a;
            if (r2 == null) goto L6;
            ((v72.c.a) r2).b();
            return;
        }

        public b(com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r1, ViewGroup r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    @Nonnull
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.BigEnterAnim;
    }

    public d(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull k32.a r11, @Nonnull Context r13, @Nonnull AnimPlayer.a r14, @Nonnull ViewGroup r15, @Nonnull com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r16) {
        va.a r0 = r11.k;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup r3 = (ViewGroup) LayoutInflater.from(r13).inflate(2131567904, r15, false);
        ViewGroup r17 = (ViewGroup) r3.findViewById(2131378926);
        ViewGroup r1 = (ViewGroup) r3.findViewById(2131373269);
        r3.setX(r15.getWidth());
        r3.setY(0.0f);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -2);
        r4.gravity = 80;
        r15.addView(r3, r4);
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r3.getLayoutParams();
        r5.bottomMargin = r14.a;
        r3.setLayoutParams(r5);
        r17.setVisibility(0);
        r1.setVisibility(8);
        HSImageView r18 = r3.findViewById(2131376080);
        HSImageView r2 = r3.findViewById(2131376082);
        TextView r6 = (TextView) r3.findViewById(2131390291);
        if (r0.getAvatarPos() != 1) goto L8;
        r18.setVisibility(0);
        ImageLoader.bindImage(r18, r11.c);
    L10:
        if (r0.getIcon() != null) goto L12;
    L14:
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.b.b(r6, r0, this.b);
        r6.post(new a(r6));
        Animator r19 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.b(r3, new b(r16, r15, r3), 40, -40, -1, c(), false);
        r19.start();
        ((v72.c.a) r16).a.i = r19;
        return;
    L12:
        if (Lists.isEmpty(r0.getIcon().getUrls()) == true) goto L14;
        r2.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse((String) ListProtector.get(r0.getIcon().getUrls(), 0))).setAutoPlayAnimations(true).build());
        goto L14
    L8:
        r18.setVisibility(8);
        goto L10
    }
}
