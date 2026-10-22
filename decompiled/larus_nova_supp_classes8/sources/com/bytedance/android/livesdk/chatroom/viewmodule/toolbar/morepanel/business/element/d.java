package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.ShareReportResult;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements Observer<Response<ShareReportResult>> {
    public final /* synthetic */ RoomContext a;
    public final /* synthetic */ DataCenter b;

    public final void onComplete() {
    }

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        ALogger.e("MoreMixSharePanel", "sendShare error: " + r3.getMessage());
    }

    public final void onNext(Object r8) {
        Response r9 = (Response) r8;
        Intrinsics.checkNotNullParameter(r9, "t");
        RoomContext r0 = this.a;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L8:
        ShareReportResult r10 = (ShareReportResult) ((BaseResponse) r9).data;
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10.getDeltaIntimacy() <= 0) goto L20;
        if (r2 == null) goto L21;
        DataCenter r3 = this.b;
        if (r3 == null) goto L22;
        vlc.d r4 = (vlc.d) r3.get("data_message_manager", null);
        if (r4 == null) goto L23;
        r4.j(ag1.c.e(r2.id, r10.getDisplayText(), (User) this.a.getUser().getValue()), true);
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

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        RoomContext r0 = this.a;
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.i r1 = r0.getCompositeDisposable();
        if (r1 == null) goto L11;
        CompositeDisposable r3 = (CompositeDisposable) r1.getValue();
        if (r3 == null) goto L12;
        r3.add(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public d(RoomContext r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }
}
