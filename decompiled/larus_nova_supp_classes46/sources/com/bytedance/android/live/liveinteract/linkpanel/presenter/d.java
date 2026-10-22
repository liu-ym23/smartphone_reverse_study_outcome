package com.bytedance.android.live.liveinteract.linkpanel.presenter;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ ILinkPlayerInfoBridge b;
    public final /* synthetic */ long c;

    public d(b r1, ILinkPlayerInfoBridge r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        IBaseUser r0 = this.b.getUser();
        Intrinsics.checkNotNull(r0);
        String r1 = r0.getIdString();
        IBaseUser r2 = this.b.getUser();
        Intrinsics.checkNotNull(r2);
        String r3 = o.a(r2);
        long r4 = this.c;
        SimpleDateFormat r5 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        InteractLinkFullLinkMonitor.n(r1, r3, System.currentTimeMillis() - r4, r8);
        ExceptionUtils.handleException(((BaseTalkInviteListContract$View) this.a.b).getContext(), r8);
    }
}
