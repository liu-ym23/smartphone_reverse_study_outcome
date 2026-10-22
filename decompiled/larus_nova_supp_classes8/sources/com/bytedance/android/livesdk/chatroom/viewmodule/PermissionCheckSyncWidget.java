package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.message.model.zh;
import com.bytedance.android.livesdk.wrds.syncdata.PermissionCheckTriggerSyncModel;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/PermissionCheckSyncWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PermissionCheckSyncWidget extends RoomRecyclableWidget {
    public final CompositeDisposable a;
    public final CompositeDisposable b;
    public final WeakHandler c;
    public int d;

    public static final class a implements WeakHandler.IHandler {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void handleMsg(Message r1) {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PermissionCheckSyncWidget a;

        public b(PermissionCheckSyncWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            dc2.c.b r9 = (dc2.c.b) r8;
            PermissionCheckSyncWidget r0 = this.a;
            if (r9 == null) goto L5;
            zh r10 = (zh) r9.b;
        L6:
            r0.getClass();
            if (r10 != null) goto L10;
            return;
        L10:
            if (r10.b() < 1) goto L13;
            r0.d = r10.b();
            r0.c.postDelayed(new p2(r0), Random.Default.nextLong(r10.a() * 1000));
            return;
        L13:
            return;
        L5:
            r10 = null;
            goto L6
        }
    }

    public final void onInit(Object[] r1) {
    }

    public PermissionCheckSyncWidget() {
        this.a = new CompositeDisposable();
        this.b = new CompositeDisposable();
        this.c = new WeakHandler(Looper.getMainLooper(), a.a);
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.c.removeCallbacksAndMessages(null);
        this.a.clear();
        this.b.clear();
    }

    public final void onLoad(Object[] r5) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        RoomContext r6 = getDataContext();
        if (r6 != null) goto L5;
        r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L5:
        if (r6 != null) goto L7;
        return;
    L7:
        PermissionCheckTriggerSyncModel r7 = dc2.b.a(com.bytedance.android.livesdk.chatroom.utils.n3.g(r6), PermissionCheckSyncWidget$onLoad$1$roomDataSyncModel$1.INSTANCE);
        this.a.add(r7.getPermissionCheckTriggerSyncData().b().subscribe(new b(this)));
    }
}
