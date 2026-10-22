package com.bytedance.android.live.openplatform.impl.minigameaudience.launch;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AudienceLaunchMgContextService a;
    public final /* synthetic */ Function0 b;

    public a(AudienceLaunchMgContextService r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        IBaseUser r3 = (IBaseUser) r2;
        int r4 = qo0.a.a;
        qo0.a.c(this.a.a, "login success");
        this.b.invoke();
    }
}
