package com.bytedance.android.live.room;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.room.IRoomPreloadTaskManager;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadOpt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MiddlewareRoomContext a;
        public final /* synthetic */ DataCenter b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Runnable d;

        public a(MiddlewareRoomContext r1, DataCenter r2, String r3, Runnable r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r9) {
            sh6.b r10 = (sh6.b) r9;
            Boolean r0 = (Boolean) sh6.c.b(r10);
            Boolean r1 = Boolean.TRUE;
            if (Intrinsics.areEqual(r0, r1) == false) goto L41;
            MultiRoomConfig r2 = MultiRoomConfig.INSTANCE;
            PreloadOpt r3 = r2.getPreloadOpt();
            int r4 = 0;
            if (r3 != null) goto L7;
        L36:
            this.d.run();
            StringBuilder r5 = new StringBuilder("补充执行：des: ");
            r5.append(this.c);
            r5.append(", dataCenter:");
            DataCenter r6 = this.b;
            if (r6 == null) goto L39;
            r4 = r6.hashCode();
        L39:
            r5.append(r4);
            r5.append(", isRoomVisible:");
            r5.append((Boolean) sh6.c.b(r10));
            ALogger.i("onValueChanged->preStartRoomLoad", r5.toString());
            return;
        L7:
            if (r3.getPostVisibleTask() != true) goto L36;
            MiddlewareRoomContext r7 = this.a;
            IRoomPreloadTaskManager r8 = null;
            if (r7 == null) goto L13;
            com.bytedance.live.datacontext.n r12 = r7.isPostTask();
            if (r12 == null) goto L13;
            Boolean r13 = (Boolean) r12.getValue();
        L15:
            if (Intrinsics.areEqual(r13, r1) == false) goto L36;
            DataCenter r14 = this.b;
            if (r14 == null) goto L19;
            r8 = (IRoomPreloadTaskManager) r14.get("data_preload_task_manager", null);
        L19:
            StringBuilder r15 = new StringBuilder("补充执行 + post 任务：des: ");
            r15.append(this.c);
            r15.append(", dataCenter:");
            DataCenter r16 = this.b;
            if (r16 == null) goto L22;
            int r17 = r16.hashCode();
        L23:
            r15.append(r17);
            r15.append(", isRoomVisible:");
            r15.append((Boolean) sh6.c.b(r10));
            ALogger.i("onValueChanged->preStartRoomLoad", r15.toString());
            if (r8 == null) goto L32;
            Runnable r18 = this.d;
            PreloadOpt r19 = r2.getPreloadOpt();
            if (r19 == null) goto L30;
            Long r20 = r19.getPostRoomInnerTaskDelayTime();
            if (r20 == null) goto L30;
            long r22 = r20.longValue();
        L31:
            r8.postTask(r18, r22, this.c);
            return;
        L30:
            r22 = 0;
            goto L31
        L32:
            int r23 = y.a;
            this.d.run();
            StringBuilder r24 = new StringBuilder("补充执行，post以后 dataCenter为null，直接执行：des: ");
            r24.append(this.c);
            r24.append(", dataCenter:");
            DataCenter r25 = this.b;
            if (r25 == null) goto L35;
            r4 = r25.hashCode();
        L35:
            r24.append(r4);
            r24.append(", isRoomVisible:");
            r24.append((Boolean) sh6.c.b(r10));
            ALogger.i("onValueChanged->preStartRoomLoad", r24.toString());
            return;
        L22:
            r17 = 0;
        L13:
            r13 = null;
            goto L15
        }
    }

    static {
    }

    public static void a(DataCenter r4, CompositeDisposable r5, String r6, Runnable r7) {
        Intrinsics.checkNotNullParameter(r6, "des");
        Intrinsics.checkNotNullParameter(r7, "runnable");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L24;
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r4, 0, 2);
        Boolean r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n r2 = r0.isRoomVisible();
    L8:
        if (r2 == null) goto L11;
        r1 = (Boolean) r2.getValue();
    L11:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L18;
        r7.run();
        StringBuilder r8 = new StringBuilder("直接执行：des: ");
        r8.append(r6);
        r8.append(", dataCenter:");
        if (r4 == null) goto L15;
        int r9 = r4.hashCode();
    L16:
        r8.append(r9);
        r8.append(", isRoomVisible: true");
        ALogger.i("runnable.run->preStartRoomLoad", r8.toString());
        return;
    L15:
        r9 = 0;
        goto L16
    L18:
        if (r2 == null) goto L26;
        Observable r3 = r2.a();
        if (r3 == null) goto L27;
        Disposable r10 = r3.subscribe(new a(r0, r4, r6, r7));
        if (r10 == null) goto L28;
        RxUtilKt.c(r10, r5);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L7:
        r2 = null;
        goto L8
    L24:
        r7.run();
    }
}
