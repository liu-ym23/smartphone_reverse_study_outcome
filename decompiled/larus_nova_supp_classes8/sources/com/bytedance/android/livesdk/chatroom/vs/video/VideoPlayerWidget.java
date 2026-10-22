package com.bytedance.android.livesdk.chatroom.vs.video;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.ui.LoadingAnimView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdkapi.paid.PaidPrivilegeItem;
import com.bytedance.android.livesdkapi.paid.SimpleVideoItem;
import com.bytedance.android.livesdkapi.util.VSVideoUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import java.util.List;
import jm1.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nic.l;
import nic.p;
import oic.f;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/VideoPlayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoPlayerWidget extends LiveRecyclableWidget {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public List<SimpleVideoItem> d;
    public PaidPrivilegeItem e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public boolean n;
    public final b o;
    public final g p;
    public final com.bytedance.android.livesdk.chatroom.vs.video.b q;

    public static final class a implements Runnable {
        public final /* synthetic */ VideoPlayerWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public a(VideoPlayerWidget r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FrameLayout r1 = (FrameLayout) this.a.c.getValue();     // Catch: Throwable -> L5
            r1.getLocationOnScreen(new int[2]);     // Catch: Throwable -> L5
            this.a.q.Aj(this.b, this.c);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        }
    }

    public static final class b extends l.a {
        public final /* synthetic */ VideoPlayerWidget a;

        public b(VideoPlayerWidget r1) {
            this.a = r1;
        }

        public final void N(VideoInfo r3) {
            int r0 = r3.getValueInt(1);
            int r4 = r3.getValueInt(2);
            this.a.Aq(r0, r4);
        }

        public final void B(p r3, tic.a r4) {
            VideoPlayerWidget.wq(this.a);
            DataCenter r5 = ((Widget) this.a).dataCenter;
            if (r5 == null) goto L5;
            r5.put("video_start_play_ts", Long.valueOf(System.currentTimeMillis()));
        L5:
            int r6 = d.a;
            d.b(((Widget) this.a).dataCenter, "livesdk_vs_right_sub_panel_right_video_play", null);
        }

        public final void I(f r1, tic.a r2) {
            VideoPlayerWidget.wq(this.a);
        }

        public final void W(f r5, tic.a r6) {
            VideoPlayerWidget.wq(this.a);
            DataCenter r7 = ((Widget) this.a).dataCenter;
            long r0 = -1;
            if (r7 == null) goto L8;
            Long r8 = (Long) r7.get("video_start_play_ts", -1L);
            if (r8 == null) goto L8;
            r0 = r8.longValue();
        L8:
            if (r0 >= 0) goto L13;
            DataCenter r9 = ((Widget) this.a).dataCenter;
            if (r9 == null) goto L14;
            r9.put("video_start_play_ts", Long.valueOf(System.currentTimeMillis()));
            return;
        L14:
            return;
        }

        public final void Y(f r1, tic.a r2) {
            this.a.zq();
        }

        public final void b(f r2, tic.a r3) {
            int r4 = d.a;
            d.a(((Widget) this.a).dataCenter);
            VideoPlayerWidget.wq(this.a);
            VideoPlayerWidget r5 = this.a;
            int r6 = r5.f + 1;
            List<SimpleVideoItem> r7 = r5.d;
            int r0 = 0;
            if (r7 == null) goto L5;
            int r8 = r7.size();
        L6:
            if (r8 > r6) goto L8;
            r6 = 0;
        L8:
            List<SimpleVideoItem> r9 = this.a.d;
            if (r9 == null) goto L11;
            r0 = r9.size();
        L11:
            if (r0 <= 0) goto L21;
            List<SimpleVideoItem> r10 = this.a.d;
            if (r10 == null) goto L22;
            SimpleVideoItem r11 = (SimpleVideoItem) ListProtector.get(r10, r6);
            if (r11 != null) goto L17;
            return;
        L17:
            if (r11.getVideoModelStr() == null) goto L24;
            VideoPlayerWidget r12 = this.a;
            r12.f = r6;
            r12.xq();
            return;
        L24:
            return;
        L22:
            return;
        L21:
            return;
        L5:
            r8 = 0;
            goto L6
        }

        public final void s(f r1, tic.a r2) {
            this.a.yq();
        }

        public final void v(f r2, tic.a r3, Error r4) {
            StringBuilder r5 = new StringBuilder();
            String r6 = null;
            if (r4 == null) goto L5;
            Integer r0 = Integer.valueOf(r4.code);
        L6:
            r5.append(String.valueOf(r0));
            if (r4 == null) goto L9;
            r6 = r4.description;
        L9:
            r5.append(r6);
            ALogger.i("SimpleVideoPlayerWidget", r5.toString());
            return;
        L5:
            r0 = null;
            goto L6
        }

        public final void w(f r1, tic.a r2, long r3) {
            this.a.zq();
        }

        public final void x(f r1, tic.a r2, boolean r3) {
            VideoPlayerWidget.wq(this.a);
            this.a.yq();
        }

        public final void m(f r1, tic.a r2, int r3, int r4) {
            this.a.Aq(r3, r4);
        }
    }

    public final int getLayoutId() {
        return 2131567586;
    }

    public final void onUnload() {
        g r0 = this.p;
        if (r0 == null) goto L5;
        r0.pause();
    L5:
        g r1 = this.p;
        if (r1 == null) goto L9;
        r1.release();
        return;
    }

    public final void xq() {
        List<SimpleVideoItem> r0 = this.d;
        if (r0 != null) goto L5;
    L6:
        List<SimpleVideoItem> r1 = this.d;
        if (r1 == null) goto L9;
        int r2 = r1.size();
    L10:
        int r3 = this.f;
        if (r2 <= r3) goto L48;
        List<SimpleVideoItem> r4 = this.d;
        if (r4 == null) goto L49;
        SimpleVideoItem r5 = (SimpleVideoItem) ListProtector.get(r4, r3);
        if (r5 == null) goto L50;
        String r6 = r5.getVideoModelStr();
        if (r6 != null) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r6) == false) goto L23;
        return;
    L23:
        FrameLayout r7 = (FrameLayout) this.c.getValue();
        if (r7 == null) goto L51;
        VideoModel r8 = VSVideoUtils.INSTANCE.getVideoModel(r6);
        if (r8 == null) goto L29;
        String r9 = r8.getVideoRefStr(2);
        if (r9 == null) goto L29;
    L30:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L33;
        r10.put("current_playing_video_id", r9);
    L33:
        long r11 = 0;
        if (this.i == false) goto L43;
        if (r8 == null) goto L37;
        int r12 = r8.getVideoRefInt(3);
    L38:
        int r13 = r12 * BubbleId.PadCast;
        long r14 = this.q.oS().getLong(r9, 0);
        if (r14 >= (r13 - 10000)) goto L42;
        r11 = r14;
    L42:
        this.i = false;
        goto L43
    L37:
        r12 = 0;
    L43:
        long r15 = r11;
        g r16 = this.p;
        if (r16 == null) goto L46;
        r16.play(r6, r7, r15, null);
    L46:
        zq();
        return;
    L29:
        r9 = "";
        goto L30
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L9:
        r2 = 0;
        goto L10
    L5:
        if (r0.isEmpty() != true) goto L6;
    }

    public final void yq() {
        List<SimpleVideoItem> r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        VSVideoUtils r1 = VSVideoUtils.INSTANCE;
        List<SimpleVideoItem> r2 = this.d;
        if (r2 == null) goto L12;
        SimpleVideoItem r3 = (SimpleVideoItem) ListProtector.get(r2, this.f);
        if (r3 == null) goto L12;
        String r4 = r3.getVideoModelStr();
    L13:
        VideoModel r5 = r1.getVideoModel(r4);
        if (r5 == null) goto L17;
        String r6 = r5.getVideoRefStr(2);
        if (r6 == null) goto L17;
    L18:
        SharedPreferences.Editor r7 = this.q.oS().edit();
        VideoContext r8 = VideoContext.n0(((Widget) this).context);     // Catch: JSONException -> L24
        if (r8 == null) goto L26;
        TTVideoEngine r9 = r8.o0();     // Catch: JSONException -> L24
        if (r9 == null) goto L26;
        long r10 = r9.getCurrentPlaybackTime();     // Catch: JSONException -> L24
    L27:
        r7.putLong(r6, r10);     // Catch: JSONException -> L24
    L30:
        r7.apply();
        return;
    L26:
        r10 = 0;
    L24:
        e = move-exception;
        ALogger.e("VSVideoProgressUtil", "save local progress failed " + e);
    L17:
        r6 = "";
    L12:
        r4 = null;
        goto L13
    L5:
        if (r0.isEmpty() != true) goto L7;
    }

    public final void zq() {
        if (tb1.c.a == false) goto L10;
        DouyinLoadingLayout r0 = (DouyinLoadingLayout) this.b.getValue();
        if (r0 == null) goto L7;
        r0.b();
    L7:
        DouyinLoadingLayout r1 = (DouyinLoadingLayout) this.b.getValue();
        if (r1 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r1);
        return;
    L17:
        return;
    L10:
        LoadingAnimView r2 = (LoadingAnimView) this.a.getValue();
        if (r2 == null) goto L13;
        r2.m = true;
        r2.c.setVisibility(4);
        r2.b();
    L13:
        LoadingAnimView r3 = (LoadingAnimView) this.a.getValue();
        if (r3 == null) goto L19;
        UtilityKotlinExtentionsKt.w(r3);
        return;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        g r0 = this.p;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isPlaying() != true) goto L7;
    L8:
        this.n = r1;
        g r2 = this.p;
        if (r2 == null) goto L11;
        r2.pause();
    L11:
        yq();
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (this.n == false) goto L8;
        g r0 = this.p;
        if (r0 == null) goto L9;
        r0.resume();
        return;
    L9:
        return;
    }

    public static final void wq(VideoPlayerWidget r1) {
        DouyinLoadingLayout r0 = (DouyinLoadingLayout) r1.b.getValue();
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r0);
    L5:
        DouyinLoadingLayout r2 = (DouyinLoadingLayout) r1.b.getValue();
        if (r2 == null) goto L8;
        r2.c();
    L8:
        LoadingAnimView r3 = (LoadingAnimView) r1.a.getValue();
        if (r3 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r3);
    L11:
        LoadingAnimView r4 = (LoadingAnimView) r1.a.getValue();
        if (r4 == null) goto L15;
        r4.m = false;
        r4.c();
        return;
    }

    public final void onInit(Object[] r4) {
        VideoContext r5 = VideoContext.n0(((Widget) this).context);
        if (r5 == null) goto L5;
        r5.D0(this.o);
    L5:
        DataCenter r6 = ((Widget) this).dataCenter;
        List<SimpleVideoItem> r0 = null;
        if (r6 == null) goto L8;
        PaidPrivilegeItem r7 = (PaidPrivilegeItem) r6.get("paid_privilege_item", new PaidPrivilegeItem());
    L9:
        this.e = r7;
        if (r7 == null) goto L12;
        r0 = r7.getVideoList();
    L12:
        this.d = r0;
        return;
    L8:
        r7 = null;
        goto L9
    }

    public final void onLoad(Object[] r3) {
        PaidPrivilegeItem r4 = this.e;
        if (r4 == null) goto L5;
        int r5 = r4.getClickVideoIndex();
    L6:
        this.f = r5;
        FrameLayout r6 = (FrameLayout) this.c.getValue();
        if (r6 == null) goto L13;
        VideoContext r0 = VideoContext.n0(((Widget) this).context);
        if (r0 == null) goto L13;
        if (r0.f == r6) goto L13;
        r0.f = r6;
        r0.e = null;
    L13:
        xq();
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public VideoPlayerWidget(g r3, com.bytedance.android.livesdk.chatroom.vs.video.b r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.p = r3;
        this.q = r4;
        this.a = LazyKt.lazy(new VideoPlayerWidget$mLoadingView$2(this));
        this.b = LazyKt.lazy(new VideoPlayerWidget$mDouyinLoadingView$2(this));
        this.c = LazyKt.lazy(new VideoPlayerWidget$mVideoContainer$2(this));
        this.i = true;
        int r5 = x1.h();
        this.j = r5;
        int r0 = x1.g();
        this.k = (r5 * 9) / 16;
        this.l = r5;
        this.m = RangesKt.coerceAtMost((r5 * 16) / 9, r0);
        this.n = true;
        this.o = new b(this);
    }

    public final void Aq(int r4, int r5) {
        this.h = r5;
        this.g = r4;
        if (r5 <= 0) goto L33;
        if (r4 > 0) goto L7;
        return;
    L7:
        if (r4 > r5) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L15;
        FrameLayout r0 = (FrameLayout) this.c.getValue();
        if (r0 == null) goto L14;
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L14:
        this.q.Aj(r4, r5);
        return;
    L15:
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 != null) goto L18;
    L21:
        int r7 = this.j;
    L22:
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 != null) goto L25;
    L28:
        int r9 = this.k;
    L29:
        FrameLayout r2 = (FrameLayout) this.c.getValue();
        if (r2 == null) goto L35;
        r2.setLayoutParams(new FrameLayout.LayoutParams(r7, r9));
        a1.j(r2, 17);
        r2.post(new a(this, r7, r9));
        return;
    L35:
        return;
    L25:
        if (z.m(r8, true) == true) goto L28;
        r9 = this.l;
        goto L29
    L18:
        if (z.m(r6, true) == true) goto L21;
        r7 = this.m;
        goto L22
    L9:
        r1 = false;
        goto L10
    }
}
