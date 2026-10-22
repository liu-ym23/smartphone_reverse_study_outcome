package com.bytedance.android.livesdk.interactivity.seek;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/seek/EpisodePlayEventNotifyWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodePlayEventNotifyWidget extends RoomRecyclableWidget {
    public b a;

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        b r0 = this.a;
        if (r0 == null) goto L13;
        IVSPlayerService r1 = r0.b;
        if (r1 == null) goto L9;
        IPlayerProgressService r2 = r1.provideVSProgressService(r0.i);
        if (r2 == null) goto L9;
        r2.removeProgressChangeListener(r0.e);
    L9:
        Disposable r3 = r0.d;
        if (r3 == null) goto L12;
        r3.dispose();
    L12:
        r0.d = null;
    L13:
        b r4 = this.a;
        if (r4 == null) goto L17;
        jc1.b.a r5 = jc1.b.b;
        Intrinsics.checkNotNullParameter(r5, "onFirstShowPlayListener");
        r4.a.remove(r5);
        return;
    }

    public EpisodePlayEventNotifyWidget() {
    }

    public final void onLoad(Object[] r3) {
        b r4 = new b(((Widget) this).context, ((Widget) this).dataCenter);
        this.a = r4;
        r4.c = getRoomContext();
        IVSPlayerService r0 = k.f(IVSPlayerService.class);
        if (r0 == null) goto L19;
        r4.b = r0;
        IPlayerProgressService r1 = r0.provideVSProgressService(r4.i);
        if (r1 == null) goto L8;
        r1.addProgressChangeListener(r4.e);
    L8:
        RoomContext r2 = r4.c;
        if (r2 == null) goto L19;
        if (r2.isVSFirstShow() != true) goto L19;
        r4.g = com.bytedance.android.livesdk.interactivity.common.utils.f.a(r4.i);
        IVSPlayerService r5 = r4.b;
        if (r5 == null) goto L19;
        IPlayerProgressService r6 = r5.provideVSProgressService(r4.i);
        if (r6 == null) goto L19;
        PlayerProgressServiceContext r7 = r6.provideContext(r4.i);
        if (r7 == null) goto L19;
        r4.d = r7.getPlayTimeInfo().a().subscribe(new a(r4));
    L19:
        b r8 = this.a;
        if (r8 == null) goto L23;
        jc1.h r9 = jc1.b.b;
        Intrinsics.checkNotNullParameter(r9, "onFirstShowPlayListener");
        r8.a.add(r9);
        return;
    }
}
