package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u extends BaseAnimationListener {
    public final /* synthetic */ v a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ u a;

        public a(u r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            v r9 = this.a.a;
            o r0 = r9.a;
            if (r0.m != null) goto L5;
            ALogger.i("InteractAnimation.InteractEmojiAnimationTask" + this.a.a.a.b, "sender anim stopped, currentAnimation is cleared");
            return;
        L5:
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r1 = r9.b.getPathEmoji();
            Intrinsics.checkNotNull(r1);
            v r10 = this.a.a;
            r0.q(r1, (EPointF) r10.c.element, (EPointF) r10.d.element, r10.e, r10.f.getEmojiCategory());
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ u a;

        public b(u r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            o r4 = this.a.a.a;
            if (r4.m != null) goto L5;
            ALogger.i("InteractAnimation.InteractEmojiAnimationTask" + this.a.a.a.b, "path animation end since emoji cleared");
            return;
        L5:
            o.n(r4);
        }
    }

    public u(v r1) {
        this.a = r1;
    }

    public final void onAnimationStart(AnimatedDrawable2 r4) {
        v r5 = this.a;
        InteractAnimationController.c r0 = r5.a.m;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d != true) goto L16;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r6 = r5.b.getPathEmoji();
        if (r6 == null) goto L10;
        long r1 = r6.getStart();
        this.a.a.l.add(Observable.timer(r1, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)));
    L10:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r7 = this.a.b.getReceiverEmoji();
        if (r7 == null) goto L15;
        long r2 = r7.getStart();
        this.a.a.l.add(Observable.timer(r2, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)));
        return;
    L15:
        return;
    }

    public final void onAnimationStop(AnimatedDrawable2 r7) {
        Iterator<g> r8 = this.a.a.a.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().e();
        goto L4
    L6:
        HSImageView r9 = this.a.a.f;
        Intrinsics.checkNotNull(r9);
        UtilityKotlinExtentionsKt.t(r9);
        v r10 = this.a;
        o r0 = r10.a;
        InteractAnimationController.c r1 = r0.m;
        if (r1 != null) goto L11;
        ALogger.i("InteractAnimation.InteractEmojiAnimationTask" + this.a.a.b, "sender anim stopped, currentAnimation is cleared");
        return;
    L11:
        if (r1.d != true) goto L13;
        return;
    L13:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r2 = r10.b.getPathEmoji();
        Intrinsics.checkNotNull(r2);
        v r11 = this.a;
        r0.q(r2, (EPointF) r11.c.element, (EPointF) r11.d.element, r11.e, r11.f.getEmojiCategory());
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        if (r3 < (r2.getFrameCount() - 1)) goto L6;
        r2.stop();
        return;
    }
}
