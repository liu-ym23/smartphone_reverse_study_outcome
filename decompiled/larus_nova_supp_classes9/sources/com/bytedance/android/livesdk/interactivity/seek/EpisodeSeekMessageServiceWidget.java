package com.bytedance.android.livesdk.interactivity.seek;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/seek/EpisodeSeekMessageServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeSeekMessageServiceWidget extends RoomRecyclableWidget {
    public final a a;
    public h b;

    public static final class a implements jc1.h {
        public final /* synthetic */ EpisodeSeekMessageServiceWidget a;

        public final void h(long r1) {
        }

        public a(EpisodeSeekMessageServiceWidget r1) {
            this.a = r1;
        }

        public final void a(long r3) {
            EpisodeInteractivityTracer.c("first show play resume, time point: " + r3);
            if (com.bytedance.android.livesdk.interactivity.common.utils.f.a(((Widget) this.a).dataCenter) == false) goto L8;
            h r4 = this.a.b;
            if (r4 == null) goto L9;
            r4.a();
            return;
        L9:
            return;
        }

        public final void b(long r3) {
            EpisodeInteractivityTracer.c("first show play pause, try stop, time point: " + r3);
            h r4 = this.a.b;
            if (r4 == null) goto L6;
            r4.b(false);
            return;
        }

        public final void c(long r3) {
            EpisodeInteractivityTracer.c("first show seek start, try stop, time point: " + r3);
            h r4 = this.a.b;
            if (r4 == null) goto L6;
            r4.b(true);
            return;
        }

        public final void d(long r1) {
            if (com.bytedance.android.livesdk.interactivity.common.utils.f.a(((Widget) this.a).dataCenter) == false) goto L8;
            h r2 = this.a.b;
            if (r2 == null) goto L9;
            r2.a();
            return;
        L9:
            return;
        }

        public final void e(long r10) {
            EpisodeInteractivityTracer.c("first show play success, try start, time point: " + r10);
            EpisodeSeekMessageServiceWidget r0 = this.a;
            r0.getClass();
            long r1 = ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) * r10;
            long r5 = (r10 * 1000) + r1;
            long r2 = r1 + ((r10 + 1) * 1000);
            StringBuilder r11 = new StringBuilder();
            r11.append(r5);
            r11.append('_');
            r11.append(r2);
            String r13 = r11.toString();
            RoomContext r14 = r0.getRoomContext();
            if (r14 == null) goto L10;
            j r15 = r14.getSeekMessageManager();
            if (r15 == null) goto L10;
            vlc.d r16 = (vlc.d) r15.getValue();
            if (r16 == null) goto L10;
            q52.b.a(r16, r13);
        L10:
            if (com.bytedance.android.livesdk.interactivity.common.utils.f.a(((Widget) this.a).dataCenter) == false) goto L15;
            h r17 = this.a.b;
            if (r17 == null) goto L16;
            r17.a();
            return;
        L16:
            return;
        }

        public final void f(long r3) {
            EpisodeInteractivityTracer.c("first show back to latest, try stop, time point: " + r3);
            h r4 = this.a.b;
            if (r4 == null) goto L6;
            r4.b(true);
            return;
        }

        public final void g(boolean r3) {
            EpisodeInteractivityTracer.c("on message fetch mode switch, seek: " + r3);
            if (r3 == true) goto L5;
        L9:
            h r4 = this.a.b;
            if (r4 == null) goto L15;
            r4.b(true);
            return;
        L15:
            return;
        L5:
            if (com.bytedance.android.livesdk.interactivity.common.utils.f.c(((Widget) this.a).dataCenter) == false) goto L9;
            h r5 = this.a.b;
            if (r5 == null) goto L13;
            r5.a();
            return;
        }
    }

    public static final class b implements c {
        public final /* synthetic */ EpisodeSeekMessageServiceWidget a;

        @Override // com.bytedance.android.livesdk.interactivity.seek.c
        public final void start() {
            RoomContext r0 = this.a.getRoomContext();
            if (r0 == null) goto L8;
            j r1 = r0.getSeekMessageManager();
            if (r1 == null) goto L9;
            r1.c(EpisodeSeekMessageServiceWidget$startMessage$1.INSTANCE);
            return;
        L9:
            return;
        }

        public b(EpisodeSeekMessageServiceWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.seek.c
        public final void stop(final boolean r3) {
            RoomContext r0 = this.a.getRoomContext();
            if (r0 == null) goto L8;
            j r1 = r0.getSeekMessageManager();
            if (r1 == null) goto L9;
            r1.c(new EpisodeSeekMessageServiceWidget$stopMessage$1(r3));
            return;
        L9:
            return;
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        this.b = null;
        EpisodeInteractivityTracer.c("unregister first show listener");
        jc1.b.b(this.a);
    }

    public EpisodeSeekMessageServiceWidget() {
        this.a = new a(this);
    }

    public final void onLoad(Object[] r2) {
        this.b = new h(new b(this));
        RoomContext r3 = getRoomContext();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isVSFirstShow() != true) goto L9;
        EpisodeInteractivityTracer.c("register first show listener");
        jc1.b.a(this.a);
        return;
    }
}
