package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.permissionsync.RoomPermissionSyncApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p2 implements Runnable {
    public final /* synthetic */ PermissionCheckSyncWidget a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ p2 a;

        public a(p2 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Response r4 = (Response) r3;
            if (r4 == null) goto L8;
            RoomPermissionSyncApi.CheckPermissionResponse r1 = (RoomPermissionSyncApi.CheckPermissionResponse) ((BaseResponse) r4).data;
            if (r1 == null) goto L8;
            if (r1.getAllow() != true) goto L8;
            return;
        L8:
            if (r4 == null) goto L12;
            RoomPermissionSyncApi.CheckPermissionResponse r5 = (RoomPermissionSyncApi.CheckPermissionResponse) ((BaseResponse) r4).data;
            if (r5 == null) goto L12;
            String r6 = r5.getText();
        L13:
            if (r6 != null) goto L15;
        L19:
            r6 = com.bytedance.android.live.core.utils.s1.B(2131919570);
        L20:
            com.bytedance.android.live.core.utils.f2.i(((Widget) this.a.a).context, r6, 1);
            xs2.b.a().post(new zg1.h1(54));
            return;
        L15:
            if (r6.length() <= 0) goto L17;
            boolean r2 = true;
        L18:
            if (r2 == true) goto L20;
        L17:
            r2 = false;
        L12:
            r6 = null;
            goto L13
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public p2(PermissionCheckSyncWidget r1) {
        this.a = r1;
    }

    public final void a() {
        com.bytedance.android.livesdk.service.l.d().getClass();
        com.bytedance.android.live.network.c r0 = com.bytedance.android.live.network.c.b();
        if (r0 == null) goto L35;
        RoomPermissionSyncApi r1 = (RoomPermissionSyncApi) r0.e(RoomPermissionSyncApi.class);
        if (r1 == null) goto L36;
        HashMap r2 = new HashMap();
        r2.put("trigger", String.valueOf(this.a.d));
        RoomContext r3 = this.a.getDataContext();
        if (r3 != null) goto L10;
        r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L10:
        String r7 = "";
        if (r3 == null) goto L18;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L18;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L18;
        String r6 = String.valueOf(r5.id);
        if (r6 == null) goto L18;
    L19:
        r2.put("room_id", r6);
        RoomContext r8 = this.a.getDataContext();
        if (r8 != null) goto L22;
        r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L22:
        if (r8 == null) goto L33;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L33;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L33;
        User r11 = r10.getOwner();
        if (r11 == null) goto L33;
        String r12 = r11.getIdStr();
        if (r12 == null) goto L33;
        r7 = r12;
    L33:
        r2.put("anchor_id", r7);
        this.a.b.add(r1.checkPermission(r2).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new a(this), b.a));
        return;
    L18:
        r6 = "";
        goto L19
    L36:
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
