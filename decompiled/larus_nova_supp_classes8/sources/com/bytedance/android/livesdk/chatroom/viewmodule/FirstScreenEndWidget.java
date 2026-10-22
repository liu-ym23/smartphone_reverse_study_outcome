package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live.PRELOAD_STAGE;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live.RoomPreloadStage;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/FirstScreenEndWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FirstScreenEndWidget extends MiddlewareRoomRecyclableWidget {
    public final String a;
    public long b;
    public boolean c;
    public final long d;
    public long e;
    public final Bundle f;

    public static final class a implements Runnable {
        public final /* synthetic */ FirstScreenEndWidget a;

        public a(FirstScreenEndWidget r1) {
            this.a = r1;
        }

        public final void a() {
            FirstScreenEndWidget r0 = this.a;
            if (r0.e <= 0) goto L5;
            return;
        L5:
            if (r0.b > 0) goto L7;
            return;
        L7:
            if (r0.c == true) goto L25;
            Bundle r1 = r0.f;
            if (r1 == null) goto L26;
            r0.e = r1.getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", -1);
            ALogger.w(this.a.a, "onRoomVisible::  dataCenter:: " + ((Widget) this.a).dataCenter.hashCode() + " startEnterTime::  " + this.a.e);
            FirstScreenEndWidget r2 = this.a;
            long r3 = r2.e;
            if (r3 <= 0) goto L19;
            long r8 = r2.b - r3;
            r2.c = true;
            if (r8 > 0) goto L15;
            boolean r4 = fh1.e.a;
            fh1.e.f(r2.d, "1", true);
        L16:
            DataCenter r5 = ((Widget) this.a).dataCenter;
            if (r5 == null) goto L27;
            r5.put("cmd_fs_widget_loaded", Boolean.TRUE);
            return;
        L27:
            return;
        L15:
            boolean r6 = fh1.e.a;
            fh1.e.f(r2.d, String.valueOf(r8), true);
            goto L16
        L19:
            r2.c = true;
            boolean r7 = fh1.e.a;
            fh1.e.f(r2.d, "1", true);
            DataCenter r9 = ((Widget) this.a).dataCenter;
            if (r9 == null) goto L29;
            r9.put("cmd_fs_widget_loaded", Boolean.TRUE);
            return;
        L29:
            return;
        L26:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        this.b = -1;
        this.e = -1;
        this.c = false;
    }

    public final void onLoad(Object[] r5) {
        this.b = System.currentTimeMillis();
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L8;
        RoomPreloadStage r7 = com.bytedance.android.live.core.utils.z.p(r6);
        if (r7 == null) goto L8;
        r7.updatePreloadStage(PRELOAD_STAGE.PRELOAD_COMPONENT_FINISH);
    L8:
        if (this.c == false) goto L10;
    L17:
        runWithRoomVisible(new a(this));
        return;
    L10:
        if (this.e <= 0) goto L17;
        if (isViewValid() == false) goto L17;
        String r8 = String.valueOf(this.b - this.e);
        boolean r0 = fh1.e.a;
        fh1.e.f(this.d, r8, false);
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L16;
        r9.put("cmd_fs_widget_loaded", Boolean.TRUE);
    L16:
        this.c = true;
        goto L17
    }

    public FirstScreenEndWidget(long r1, long r3, Bundle r5) {
        this.d = r1;
        this.e = r3;
        this.f = r5;
        this.a = "FirstScreen_TAG";
        this.b = -1;
    }
}
