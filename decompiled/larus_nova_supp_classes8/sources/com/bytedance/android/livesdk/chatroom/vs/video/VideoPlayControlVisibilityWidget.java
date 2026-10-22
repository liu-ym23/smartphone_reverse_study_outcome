package com.bytedance.android.livesdk.chatroom.vs.video;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/VideoPlayControlVisibilityWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoPlayControlVisibilityWidget extends LiveRecyclableWidget {
    public Observable<Long> a;
    public Disposable b;
    public boolean c;
    public AnimatorSet d;
    public final com.bytedance.android.livesdk.chatroom.vs.video.b e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VideoPlayControlVisibilityWidget a;

        public b(VideoPlayControlVisibilityWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            VideoPlayControlVisibilityWidget r3 = this.a;
            if (r3.c == false) goto L6;
            r3.qb();
            VideoPlayControlVisibilityWidget.wq(this.a);
            return;
        L6:
            r3.qb();
            this.a.xq(true);
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void qb() {
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L10:
        this.b = null;
        return;
    L5:
        if (r0.isDisposed() == false) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    public final void onUnload() {
        qb();
        AnimatorSet r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.d = null;
    }

    public VideoPlayControlVisibilityWidget(com.bytedance.android.livesdk.chatroom.vs.video.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.e = r2;
        this.c = true;
    }

    public static final void wq(VideoPlayControlVisibilityWidget r6) {
        final List<View> r0 = r6.e.vf();
        AnimatorSet r1 = r6.d;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        final ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add(ObjectAnimator.ofFloat((View) r3.next(), "alpha", new float[]{1.0f, 0.0f}));
        goto L7
    L9:
        AnimatorSet r4 = new AnimatorSet();
        r6.d = r4;
        r4.setDuration(300);
        h.a(r4, new VideoPlayControlVisibilityWidget$hidePlayControlView$$inlined$apply$lambda$1(r0, r2));
        r4.playTogether(r2);
        r4.start();
        r6.c = false;
    }

    public final void onLoad(Object[] r2) {
        xq(false);
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L6;
        r3.setOnClickListener(new b(this));
        return;
    }

    public final void xq(boolean r6) {
        final List<View> r0 = this.e.vf();
        AnimatorSet r1 = this.d;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        if (r6 == false) goto L11;
        final ArrayList r7 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r7.add(ObjectAnimator.ofFloat((View) r2.next(), "alpha", new float[]{0.0f, 1.0f}));
        goto L8
    L10:
        AnimatorSet r3 = new AnimatorSet();
        this.d = r3;
        r3.setDuration(300);
        h.a(r3, new VideoPlayControlVisibilityWidget$showPlayControlView$$inlined$apply$lambda$1(r0, r7));
        r3.playTogether(r7);
        r3.start();
    L15:
        this.c = true;
        Disposable r8 = null;
        this.a = null;
        this.a = Observable.timer(5, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper());
        Disposable r4 = this.b;
        if (r4 == null) goto L18;
        r4.dispose();
    L18:
        Observable<Long> r5 = this.a;
        if (r5 == null) goto L21;
        r8 = RxUtilKt.n(r5, new VideoPlayControlVisibilityWidget$startHideViewTask$1(this));
    L21:
        this.b = r8;
        return;
    L11:
        Iterator<T> r9 = r0.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        View r10 = (View) r9.next();
        r10.setVisibility(0);
        r10.setAlpha(1.0f);
        goto L13
    }
}
