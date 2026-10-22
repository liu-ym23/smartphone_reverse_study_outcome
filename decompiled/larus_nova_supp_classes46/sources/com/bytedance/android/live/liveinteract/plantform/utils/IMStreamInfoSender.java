package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.model.SyncStreamInfo;
import io.reactivex.disposables.Disposable;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class IMStreamInfoSender implements q {
    public final LinkedList<SyncStreamInfo> a;
    public final int b;
    public final int c;
    public final Lazy d;
    public LinkApis e;
    public Long f;

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.q
    public final void onClose() {
        if (((Disposable) this.d.getValue()).isDisposed() == true) goto L6;
        ((Disposable) this.d.getValue()).dispose();
        return;
    }

    public IMStreamInfoSender() {
        this.a = new LinkedList();
        this.b = 25600;
        this.c = jc1.k.n(IMiddleWareHostContext.class).liveId();
        this.d = LazyKt.lazy(new IMStreamInfoSender$internalTask$2(this));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.q
    public final void a(String r6, JSONObject r7) {
        if (((Disposable) this.d.getValue()).isDisposed() == true) goto L14;
        if (r7 == null) goto L14;
        LinkedList<SyncStreamInfo> r0 = this.a;
        monitor-enter(r0);
        this.a.add(new SyncStreamInfo(com.bytedance.android.livesdk.utils.ntp.e.a(), r6, r7.toString()));     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        ALogger.e("IMStreamInfoPipe", "sendStreamInfo but internalTask is disposed");
    }
}
