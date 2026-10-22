package com.bytedance.android.livesdk.chatroom.vs.video;

import android.widget.TextView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.videoshop.context.VideoContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import nic.l;
import oic.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/VideoProgressAreaWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProgressAreaWidget extends LiveRecyclableWidget {
    public VideoContext a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public long e;
    public long f;
    public final a g;

    public static final class a extends l.a {
        public final /* synthetic */ VideoProgressAreaWidget a;

        public a(VideoProgressAreaWidget r1) {
            this.a = r1;
        }

        public final void q(f r3, tic.a r4, int r5, int r6) {
            if (r3 == null) goto L4;
            r5 = r3.getCurrentPosition();
        L4:
            VideoProgressAreaWidget r7 = this.a;
            if (r3 == null) goto L7;
            r6 = r3.getDuration();
        L7:
            r7.e = r6;
            VideoProgressAreaWidget r8 = this.a;
            VideoProgressAreaWidget.wq(r8, r5, Long.valueOf(r8.e));
        }
    }

    public final int getLayoutId() {
        return 2131567456;
    }

    public final void onUnload() {
    }

    public VideoProgressAreaWidget() {
        this.b = LazyKt.lazy(new VideoProgressAreaWidget$currentPlayTime$2(this));
        this.c = LazyKt.lazy(new VideoProgressAreaWidget$seekBar$2(this));
        this.d = LazyKt.lazy(new VideoProgressAreaWidget$totalVideoTime$2(this));
        this.f = -1;
        this.g = new a(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        VideoContext r0 = this.a;
        if (r0 == null) goto L5;
        r0.K0(this.g);
    L5:
        this.a = null;
    }

    public final void onInit(Object[] r2) {
        VideoContext r3 = VideoContext.n0(((Widget) this).context);
        this.a = r3;
        if (r3 == null) goto L6;
        r3.D0(this.g);
        return;
    }

    public final void onLoad(Object[] r2) {
        ((PlayerSeekBar) this.c.getValue()).setOnSSSeekBarChangeListener(new e(this));
    }

    public static final void wq(VideoProgressAreaWidget r12, long r13, Long r15) {
        ((TextView) r12.b.getValue()).setText(p6.c(r13));
        if (r15 == null) goto L12;
        r15.longValue();
        if (((Widget) r12).containerView.getAlpha() <= 0) goto L7;
        boolean r8 = true;
    L8:
        PlayerSeekBar.m((PlayerSeekBar) r12.c.getValue(), r13, r15.longValue(), false, r8, 0, 16);
        if (r15.longValue() <= 0) goto L13;
        ((TextView) r12.d.getValue()).setText(p6.c(r15.longValue()));
        return;
    L13:
        return;
    L7:
        r8 = false;
        goto L8
    }
}
