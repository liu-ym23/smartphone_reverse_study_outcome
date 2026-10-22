package com.bytedance.android.live.liveinteract.videotalk.dialog;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ n a;
    public final /* synthetic */ long b;

    public h(n r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        ILinkPlayerInfoBridge r1 = this.a.C;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getUserPosition());
    L6:
        Intrinsics.checkNotNull(r2);
        long r3 = r2.intValue();
        long r4 = this.b;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.v0(r3, "", r4, r8);
        ExceptionUtils.handleException(this.a.getContext(), r8);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
