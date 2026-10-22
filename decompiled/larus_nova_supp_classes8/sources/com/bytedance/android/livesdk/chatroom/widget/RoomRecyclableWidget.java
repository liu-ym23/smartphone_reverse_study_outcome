package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.IRoomPreloadTaskManager;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadOpt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u0011\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\fJ\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00038D@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/g0;", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "getRoomContext", "dataContext", "", "setRoomContext", "handleRoomVisible", "Ljava/lang/Runnable;", "runnable", "runWithRoomVisible", "Lh80/a;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "consumer", "runWithRoomEntered", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "runWithRoomPreload", "", "isVisible", "onRoomVisible", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "getDataContext", "()Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "setDataContext", "(Lcom/bytedance/android/livesdk/chatroom/RoomContext;)V", "<init>", "()V", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RoomRecyclableWidget extends LiveRecyclableWidget implements g0 {
    private RoomContext dataContext;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RoomRecyclableWidget a;

        public a(RoomRecyclableWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) sh6.c.b((sh6.b) r2);
            if (r3 == null) goto L6;
            boolean r4 = r3.booleanValue();
            this.a.onRoomVisible(r4);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ h80.a a;

        public b(h80.a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.accept(sh6.c.b((sh6.b) r2));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ h80.a a;

        public c(h80.a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.accept(sh6.c.b((sh6.b) r2));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ RoomRecyclableWidget a;
        public final /* synthetic */ Runnable b;

        public d(RoomRecyclableWidget r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Boolean r6 = (Boolean) sh6.c.b((sh6.b) r5);
            if (r6 != null) goto L5;
            return;
        L5:
            if (r6.booleanValue() == true) goto L8;
            r6 = null;
        L8:
            if (r6 == null) goto L36;
            r6.booleanValue();
            MultiRoomConfig r7 = MultiRoomConfig.INSTANCE;
            PreloadOpt r0 = r7.getPreloadOpt();
            if (r0 != null) goto L12;
        L33:
            this.b.run();
            return;
        L12:
            if (r0.getPostVisibleTask() != true) goto L33;
            RoomContext r1 = this.a.getRoomContext();
            if (r1 == null) goto L18;
            com.bytedance.live.datacontext.n r2 = r1.isPostTask();
            if (r2 == null) goto L18;
            Boolean r3 = (Boolean) r2.getValue();
        L20:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L33;
            DataCenter r4 = ((Widget) this.a).dataCenter;
            if (r4 == null) goto L32;
            IRoomPreloadTaskManager r8 = (IRoomPreloadTaskManager) r4.get("data_preload_task_manager", null);
            if (r8 == null) goto L32;
            Runnable r9 = this.b;
            PreloadOpt r10 = r7.getPreloadOpt();
            if (r10 == null) goto L30;
            Long r11 = r10.getPostRoomInnerTaskDelayTime();
            if (r11 == null) goto L30;
            long r12 = r11.longValue();
        L31:
            r8.postTask(r9, r12, this.a.getClass().getSimpleName());
            return;
        L30:
            r12 = 0;
        L32:
            this.b.run();
            return;
        L18:
            r3 = null;
            goto L20
        }
    }

    public void onRoomVisible(boolean r1) {
    }

    public final RoomContext getDataContext() {
        if (this.dataContext != null) goto L13;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("data_current_is_preview", Boolean.FALSE);
    L9:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L13;
        return RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
    L7:
        r1 = null;
    L13:
        return this.dataContext;
    }

    public RoomContext getRoomContext() {
        return getDataContext();
    }

    public void handleRoomVisible() {
        super.handleRoomVisible();
        RoomContext r0 = getRoomContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n r1 = r0.isRoomVisible();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L8:
        if (r2 == null) goto L10;
        onRoomVisible(r2.booleanValue());
    L10:
        RoomContext r3 = getRoomContext();
        if (r3 == null) goto L20;
        com.bytedance.live.datacontext.n r4 = r3.isRoomVisible();
        if (r4 == null) goto L21;
        Observable r5 = r4.a();
        if (r5 == null) goto L22;
        ObservableSubscribeProxy r6 = (ObservableSubscribeProxy) r5.as(autoDispose());
        if (r6 == null) goto L23;
        r6.subscribe(new a(this));
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public RoomRecyclableWidget() {
    }

    public final void runWithRoomEntered(h80.a<Room> r6) {
        Intrinsics.checkNotNullParameter(r6, "consumer");
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        Boolean r1 = (Boolean) r0.get("data_current_is_preview", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L9;
        setRoomContext(RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2));
    L9:
        RoomContext r2 = getDataContext();
        if (r2 != null) goto L12;
        return;
    L12:
        Room r3 = (Room) r2.getInteractionDataPrepared().getValue();
        if (r3 == null) goto L15;
        r6.accept(r3);
        return;
    L15:
        ((ObservableSubscribeProxy) r2.getInteractionDataPrepared().a().as(autoDispose())).subscribe(new b(r6));
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void runWithRoomPreload(h80.a<IRoom> r7) {
        Intrinsics.checkNotNullParameter(r7, "consumer");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L35;
        DataCenter r0 = ((Widget) this).dataCenter;
        IRoom r1 = null;
        if (r0 == null) goto L7;
        Boolean r2 = (Boolean) r0.get("data_current_is_preview", Boolean.FALSE);
    L9:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L11;
        setRoomContext(RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2));
    L11:
        RoomContext r3 = getDataContext();
        if (r3 != null) goto L14;
        return;
    L14:
        com.bytedance.live.datacontext.n r4 = r3.getPreloadRoom();
        if (r4 == null) goto L17;
        IRoom r5 = (IRoom) r4.getValue();
    L18:
        RoomContext r6 = getDataContext();
        if (r6 == null) goto L23;
        com.bytedance.live.datacontext.n r8 = r6.getFullRoom();
        if (r8 == null) goto L23;
        r1 = (IRoom) r8.getValue();
    L23:
        if (r1 == null) goto L25;
        return;
    L25:
        if (r5 == null) goto L27;
        r7.accept(r5);
        return;
    L27:
        com.bytedance.live.datacontext.n r9 = r3.getPreloadRoom();
        if (r9 == null) goto L37;
        Observable r10 = r9.a();
        if (r10 == null) goto L38;
        ObservableSubscribeProxy r11 = (ObservableSubscribeProxy) r10.as(autoDispose());
        if (r11 == null) goto L39;
        r11.subscribe(new c(r7));
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L17:
        r5 = null;
        goto L18
    L7:
        r2 = null;
        goto L9
    }

    public final void runWithRoomVisible(Runnable r4) {
        Intrinsics.checkNotNullParameter(r4, "runnable");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L25;
        RoomContext r0 = getRoomContext();
        Boolean r1 = null;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n r2 = r0.isRoomVisible();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
    L10:
        if (r3 != null) goto L12;
    L16:
        RoomContext r5 = getRoomContext();
        if (r5 == null) goto L27;
        com.bytedance.live.datacontext.n r6 = r5.isRoomVisible();
        if (r6 == null) goto L28;
        Observable r7 = r6.a();
        if (r7 == null) goto L29;
        ObservableSubscribeProxy r8 = (ObservableSubscribeProxy) r7.as(autoDispose());
        if (r8 == null) goto L30;
        r8.subscribe(new d(this, r4));
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L12:
        if (r3.booleanValue() == false) goto L14;
        r1 = r3;
    L14:
        if (r1 == null) goto L16;
        r1.booleanValue();
        r4.run();
    L9:
        r3 = null;
        goto L10
    L25:
        r4.run();
    }

    public final void setDataContext(RoomContext r1) {
        this.dataContext = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.g0
    public void setRoomContext(RoomContext r1) {
        this.dataContext = r1;
    }
}
