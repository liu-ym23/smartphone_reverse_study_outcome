package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.ob;
import com.bytedance.android.livesdk.focus.LiveFocusContext;
import com.bytedance.android.livesdk.j5;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IBroadcastPlayer;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IBroadcastStream;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.focus.IFocusContext;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/AnchorPSAudioPlayerServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPSAudioPlayerServiceWidget extends MiddlewareRoomWidget {
    public final CompositeDisposable a;
    public com.bytedance.android.live.pushstream.d b;
    public LiveMode c;

    public static final class a implements IBroadcastStream {
        public final /* synthetic */ AnchorPSAudioPlayerServiceWidget a;

        public final IBroadcastPlayer createPlayer() {
            com.bytedance.android.live.pushstream.d r0 = this.a.b;
            if (r0 == null) goto L10;
            if (r0 == null) goto L11;
            uf2.d0 r1 = r0.getLiveCore();
            if (r1 == null) goto L12;
            r1.createPlayer();
            return null;
        L12:
            return null;
        L11:
            return null;
        L10:
            return null;
        }

        public final void startAudioPlayer() {
            com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(this.a.getComponentContext());
            if (r0 == null) goto L5;
            com.bytedance.android.live.pushstream.d r1 = r0.getLiveStream();
        L6:
            if (r1 == null) goto L11;
            uf2.d0 r2 = r1.getLiveCore();
            if (r2 == null) goto L12;
            r2.startAudioPlayer();
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public a(AnchorPSAudioPlayerServiceWidget r1) {
            this.a = r1;
        }
    }

    public static final class b implements as1.a.b {
        public final /* synthetic */ AnchorPSAudioPlayerServiceWidget a;

        public b(AnchorPSAudioPlayerServiceWidget r1) {
            this.a = r1;
        }

        @Override // as1.a.b
        public final void a(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "reason");
            com.bytedance.android.live.pushstream.d r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.P0(r2, r3);
            return;
        }
    }

    public AnchorPSAudioPlayerServiceWidget() {
        this.a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        ViewModel r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.pushstream.d r2 = r0.getLiveStream();
    L6:
        this.b = r2;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = ho1.a.d(getComponentContext());
        if (r3 == null) goto L9;
        LiveMode r4 = r3.getLiveMode();
    L10:
        this.c = r4;
        DataContext r5 = this.dataContext;
        if ((r5 instanceof RoomContext) == true) goto L13;
        r5 = null;
    L13:
        RoomContext r6 = (RoomContext) r5;
        if (r6 == null) goto L18;
        com.bytedance.live.datacontext.j r7 = r6.getTextAudioManager();
        if (r7 == null) goto L18;
        ViewModel r8 = (ViewModel) r7.getValue();
    L20:
        if ((r8 instanceof t52.a) == false) goto L23;
        r1 = r8;
    L23:
        t52.a r9 = (t52.a) r1;
        if (r9 == null) goto L27;
        r9.setLiveStream(new a(this));
    L27:
        if (((Boolean) j5.a.getValue()).booleanValue() == false) goto L29;
    L36:
        LiveMode r10 = this.c;
        if (r10 == LiveMode.VIDEO) goto L41;
        if (r10 == LiveMode.MEDIA) goto L41;
        return;
    L41:
        if (ob.a.getValue().booleanValue() == false) goto L47;
        as1.a r11 = new as1.a(this.a, ((Widget) this).dataCenter);
        b r12 = new b(this);
        Intrinsics.checkNotNullParameter(r12, "listener");
        r11.a = r12;
        IPerformanceStrategyManager r13 = jc1.k.f(IPerformanceStrategyManager.class);
        if (r13 == null) goto L48;
        r13.registerPerformanceStrategyTask(100, r11);
        return;
    L48:
        return;
    L47:
        return;
    L29:
        if (this.c != LiveMode.VIDEO) goto L36;
        RoomContext r14 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        Intrinsics.checkNotNull(r14);
        IFocusContext r15 = (IFocusContext) r14.getFocusContext().getValue();
        com.bytedance.android.live.pushstream.d r16 = this.b;
        if (r16 == null) goto L36;
        if (r15 == null) goto L36;
        nc1.a r17 = r16.e();
        if ((r15 instanceof LiveFocusContext) == false) goto L36;
        ((LiveFocusContext) r15).setVideoCaptureController(r17);
    L18:
        r8 = null;
        goto L20
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.a.isDisposed() == true) goto L5;
        this.a.dispose();
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.b = null;
        this.c = null;
    }
}
