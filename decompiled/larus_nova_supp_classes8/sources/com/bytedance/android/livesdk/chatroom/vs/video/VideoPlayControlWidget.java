package com.bytedance.android.livesdk.chatroom.vs.video;

import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.view.PlayPauseView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import nic.l;
import oic.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/VideoPlayControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoPlayControlWidget extends LiveRecyclableWidget {
    public static final /* synthetic */ int e = 0;
    public PlayPauseView a;
    public CompositeDisposable b;
    public VideoContext c;
    public final d d;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VideoPlayControlWidget a;

        public b(VideoPlayControlWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            VideoPlayControlWidget r4 = this.a;
            int r0 = VideoPlayControlWidget.e;
            PlayPauseView r5 = r4.a;
            if (r5 == null) goto L5;
            r5.d();
        L5:
            VideoContext r6 = this.a.c;
            if (r6 == null) goto L8;
            r6.pause();
        L8:
            int r7 = com.bytedance.android.livesdk.chatroom.vs.video.d.a;
            com.bytedance.android.livesdk.chatroom.vs.video.d.a(((Widget) this.a).dataCenter);
            com.bytedance.android.livesdk.chatroom.vs.video.d.b(((Widget) this.a).dataCenter, "livesdk_vs_right_video_pause_play_icon_click", null);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ VideoPlayControlWidget a;

        public c(VideoPlayControlWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            VideoPlayControlWidget r4 = this.a;
            int r0 = VideoPlayControlWidget.e;
            PlayPauseView r5 = r4.a;
            if (r5 == null) goto L5;
            r5.e();
        L5:
            VideoContext r6 = this.a.c;
            if (r6 == null) goto L8;
            r6.play();
        L8:
            int r7 = com.bytedance.android.livesdk.chatroom.vs.video.d.a;
            com.bytedance.android.livesdk.chatroom.vs.video.d.b(((Widget) this.a).dataCenter, "livesdk_vs_right_video_pause_play_icon_click", null);
            if (r3.l(((Widget) this.a).context) == false) goto L12;
            r3.q(((Widget) this.a).context, "已继续播放");
            return;
        }
    }

    public static final class d extends l.a {
        public final /* synthetic */ VideoPlayControlWidget a;

        public d(VideoPlayControlWidget r1) {
            this.a = r1;
        }

        public final void W(f r1, tic.a r2) {
            VideoPlayControlWidget r3 = this.a;
            int r4 = VideoPlayControlWidget.e;
            r3.wq(true);
        }

        public final void b(f r1, tic.a r2) {
            VideoPlayControlWidget r3 = this.a;
            int r4 = VideoPlayControlWidget.e;
            r3.wq(false);
        }

        public final void s(f r1, tic.a r2) {
            VideoPlayControlWidget r3 = this.a;
            int r4 = VideoPlayControlWidget.e;
            r3.wq(false);
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567585;
    }

    public final void onUnload() {
        this.b.dispose();
    }

    public VideoPlayControlWidget() {
        this.b = new CompositeDisposable();
        this.d = new d(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        VideoContext r0 = this.c;
        if (r0 == null) goto L6;
        r0.K0(this.d);
        return;
    }

    public final void onInit(Object[] r2) {
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L5;
        View r4 = r3.findViewById(2131386527);
    L6:
        this.a = (PlayPauseView) r4;
        VideoContext r5 = VideoContext.n0(((Widget) this).context);
        this.c = r5;
        if (r5 == null) goto L10;
        r5.D0(this.d);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onLoad(Object[] r1) {
        this.b = new CompositeDisposable();
        PlayPauseView r2 = this.a;
        if (r2 == null) goto L5;
        r2.a();
    L5:
        VideoContext r3 = this.c;
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.isPlaying() == true) goto L12;
        wq(false);
        return;
    }

    public final void wq(boolean r3) {
        if (r3 == false) goto L14;
        r3.c(this.a, "暂停", true);
        PlayPauseView r4 = this.a;
        if (r4 == null) goto L7;
        r4.setOnClickListener(new b(this));
    L7:
        PlayPauseView r5 = this.a;
        if (r5 != null) goto L10;
        return;
    L10:
        if (r5.getPlayStatus() == true) goto L26;
        PlayPauseView r6 = this.a;
        if (r6 == null) goto L27;
        r6.e();
        return;
    L27:
        return;
    L26:
        return;
    L14:
        r3.c(this.a, "播放", true);
        PlayPauseView r7 = this.a;
        if (r7 == null) goto L17;
        r7.setOnClickListener(new c(this));
    L17:
        PlayPauseView r8 = this.a;
        if (r8 != null) goto L20;
        return;
    L20:
        if (r8.getPlayStatus() != true) goto L30;
        PlayPauseView r9 = this.a;
        if (r9 == null) goto L31;
        r9.d();
        return;
    L31:
        return;
    }
}
