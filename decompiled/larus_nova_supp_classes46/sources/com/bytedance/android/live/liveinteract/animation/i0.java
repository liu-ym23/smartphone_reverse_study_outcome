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
public final class i0 extends BaseAnimationListener {
    public final /* synthetic */ y.g a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ i0 a;

        public a(i0 r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            y r9 = this.a.a.a;
            if (r9.o != null) goto L5;
            ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask" + this.a.a.a.b, "sender anim stopped, currentAnimation is cleared");
            return;
        L5:
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r10 = r9.l;
            if (r10 == null) goto L14;
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r11 = r10.interactEmoji();
            if (r11 == null) goto L15;
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r1 = r11.getPathEmoji();
            if (r1 == null) goto L16;
            y.g r12 = this.a.a;
            y r0 = r12.a;
            EPointF r2 = (EPointF) r12.b.element;
            EPointF r3 = (EPointF) r12.c.element;
            EPointF r4 = r12.d;
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r13 = r0.l;
            Intrinsics.checkNotNull(r13);
            r0.r(r1, r2, r3, r4, r13.getEmojiCategory());
            return;
        L16:
            return;
        L15:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i0 a;

        public b(i0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            y r4 = this.a.a.a;
            if (r4.o != null) goto L5;
            ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask" + this.a.a.a.b, "path animation end since emoji cleared");
            return;
        L5:
            y.m(r4);
        }
    }

    public i0(y.g r1) {
        this.a = r1;
    }

    public final void onAnimationStart(AnimatedDrawable2 r4) {
        y r5 = this.a.a;
        InteractAnimationController.c r0 = r5.o;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d != true) goto L26;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r6 = r5.l;
        if (r6 == null) goto L14;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r7 = r6.interactEmoji();
        if (r7 == null) goto L14;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r8 = r7.getPathEmoji();
        if (r8 == null) goto L14;
        long r1 = r8.getStart();
        this.a.a.n.add(Observable.timer(r1, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)));
    L14:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r9 = this.a.a.l;
        if (r9 == null) goto L23;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r10 = r9.interactEmoji();
        if (r10 == null) goto L24;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r11 = r10.getReceiverEmoji();
        if (r11 == null) goto L25;
        long r2 = r11.getStart();
        this.a.a.n.add(Observable.timer(r2, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)));
        return;
    L25:
        return;
    L24:
        return;
    L23:
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
        y r10 = this.a.a;
        InteractAnimationController.c r0 = r10.o;
        if (r0 != null) goto L11;
        ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask" + this.a.a.b, "sender anim stopped, currentAnimation is cleared");
        return;
    L11:
        if (r0.d != true) goto L13;
        return;
    L13:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r11 = r10.l;
        if (r11 == null) goto L22;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r12 = r11.interactEmoji();
        if (r12 == null) goto L23;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r1 = r12.getPathEmoji();
        if (r1 == null) goto L24;
        y.g r13 = this.a;
        y r2 = r13.a;
        EPointF r3 = (EPointF) r13.b.element;
        EPointF r4 = (EPointF) r13.c.element;
        EPointF r5 = r13.d;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r14 = r2.l;
        Intrinsics.checkNotNull(r14);
        r2.r(r1, r3, r4, r5, r14.getEmojiCategory());
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        if (r3 < (r2.getFrameCount() - 1)) goto L6;
        r2.stop();
        return;
    }
}
