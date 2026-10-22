package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.room.IRoomPreloadTaskManager;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadOpt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b \u0010!J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0014\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0014\u0010\u0014\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/h0;", "Lcom/bytedance/live/datacontext/DataContext;", "getRoomContext", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "getMiddlewareRoomContext", "roomContext", "", "setRoomContext", "Lcom/bytedance/android/livesdk/chatroom/IRoomContextService;", "getRoomContextService", "handleRoomVisible", "Ljava/lang/Runnable;", "runnable", "runWithRoomVisible", "Lh80/a;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "consumer", "runWithRoomEntered", "runWithRoomPreload", "", "isVisible", "onRoomVisible", "dataContext", "Lcom/bytedance/live/datacontext/DataContext;", "dataService", "Lcom/bytedance/android/livesdk/chatroom/IRoomContextService;", "getDataService", "()Lcom/bytedance/android/livesdk/chatroom/IRoomContextService;", "setDataService", "(Lcom/bytedance/android/livesdk/chatroom/IRoomContextService;)V", "<init>", "()V", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiddlewareRoomRecyclableWidget extends LiveRecyclableWidget implements h0 {
    protected DataContext dataContext;
    private IRoomContextService dataService;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MiddlewareRoomRecyclableWidget a;

        public a(MiddlewareRoomRecyclableWidget r1) {
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
        public final /* synthetic */ MiddlewareRoomRecyclableWidget a;
        public final /* synthetic */ Runnable b;

        public d(MiddlewareRoomRecyclableWidget r1, Runnable r2) {
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
            MiddlewareRoomContext r1 = this.a.getMiddlewareRoomContext();
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

    public MiddlewareRoomContext getMiddlewareRoomContext() {
        DataContext r0 = this.dataContext;
        if ((r0 instanceof MiddlewareRoomContext) == true) goto L6;
        r0 = null;
    L6:
        return (MiddlewareRoomContext) r0;
    }

    public void handleRoomVisible() {
        MiddlewareRoomContext r0 = getMiddlewareRoomContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n r1 = r0.isRoomVisible();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L8:
        if (r2 == null) goto L10;
        onRoomVisible(r2.booleanValue());
    L10:
        MiddlewareRoomContext r3 = getMiddlewareRoomContext();
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

    public MiddlewareRoomRecyclableWidget() {
    }

    public final IRoomContextService getDataService() {
        return this.dataService;
    }

    public DataContext getRoomContext() {
        return this.dataContext;
    }

    public IRoomContextService getRoomContextService() {
        return this.dataService;
    }

    public final void runWithRoomEntered(h80.a<IRoom> r3) {
        Intrinsics.checkNotNullParameter(r3, "consumer");
        DataContext r0 = this.dataContext;
        if (r0 != null) goto L5;
        return;
    L5:
        IRoomContextService r1 = this.dataService;
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.o r2 = r1.getRoomDataContext(r0);
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.n r4 = r2.getInteractionDataPrepared();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
    L13:
        if (r5 == null) goto L15;
        r3.accept(r5);
        return;
    L15:
        IRoomContextService r6 = this.dataService;
        if (r6 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.o r7 = r6.getRoomDataContext(r0);
        if (r7 == null) goto L29;
        com.bytedance.live.datacontext.n r8 = r7.getInteractionDataPrepared();
        if (r8 == null) goto L30;
        Observable r9 = r8.a();
        if (r9 == null) goto L31;
        ObservableSubscribeProxy r10 = (ObservableSubscribeProxy) r9.as(autoDispose());
        if (r10 == null) goto L32;
        r10.subscribe(new b(r3));
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L12:
        r5 = null;
        goto L13
    }

    public final void runWithRoomPreload(h80.a<IRoom> r4) {
        Intrinsics.checkNotNullParameter(r4, "consumer");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L5;
        return;
    L5:
        if (getMiddlewareRoomContext() != null) goto L7;
        return;
    L7:
        MiddlewareRoomContext r0 = getMiddlewareRoomContext();
        IRoom r1 = null;
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n r2 = r0.getPreloadRoom();
        if (r2 == null) goto L12;
        IRoom r3 = (IRoom) r2.getValue();
    L13:
        MiddlewareRoomContext r5 = getMiddlewareRoomContext();
        if (r5 == null) goto L18;
        com.bytedance.live.datacontext.n r6 = r5.getFullRoom();
        if (r6 == null) goto L18;
        r1 = (IRoom) r6.getValue();
    L18:
        if (r1 == null) goto L20;
        return;
    L20:
        if (r3 == null) goto L22;
        r4.accept(r3);
        return;
    L22:
        MiddlewareRoomContext r7 = getMiddlewareRoomContext();
        if (r7 == null) goto L34;
        com.bytedance.live.datacontext.n r8 = r7.getPreloadRoom();
        if (r8 == null) goto L35;
        Observable r9 = r8.a();
        if (r9 == null) goto L36;
        ObservableSubscribeProxy r10 = (ObservableSubscribeProxy) r9.as(autoDispose());
        if (r10 == null) goto L37;
        r10.subscribe(new c(r4));
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L12:
        r3 = null;
        goto L13
    }

    public final void runWithRoomVisible(Runnable r4) {
        Intrinsics.checkNotNullParameter(r4, "runnable");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L25;
        MiddlewareRoomContext r0 = getMiddlewareRoomContext();
        Boolean r1 = null;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n r2 = r0.isRoomVisible();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
    L10:
        if (r3 != null) goto L12;
    L16:
        MiddlewareRoomContext r5 = getMiddlewareRoomContext();
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

    public final void setDataService(IRoomContextService r1) {
        this.dataService = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.h0
    public void setRoomContext(MiddlewareRoomContext r1) {
        this.dataContext = r1;
        this.dataService = jc1.k.f(IRoomContextService.class);
    }
}
