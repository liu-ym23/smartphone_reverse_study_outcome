package com.bytedance.android.live.livepkaudience.dialog;

import android.app.Activity;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b extends b0<BasePkAudienceInviteListContract$View> {
    public abstract void d(boolean r1, boolean r2);

    public abstract void e(boolean r1);

    public abstract void f();

    public abstract void g(LinkPlayerInfo r1);

    public abstract void h(List r1, BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1.AnonymousClass1.a.C0113a r2);

    public abstract void i(Activity r1);

    public b(BasePkAudienceInviteListContract$View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }
}
