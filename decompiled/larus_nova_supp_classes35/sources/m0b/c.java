package m0b;

import android.content.Context;
import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends c0c.b implements AbsChameleonJsRuntime {
    public final /* synthetic */ AbsChameleonJsRuntime b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<AbsChameleonJsRuntime> d;

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void destroy() {
        this.b.destroy();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void init(Context r2, String r3, ChameleonBizType r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "bizType");
        this.b.init(r2, r3, r4);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void registerService(AbsChameleonService r2) {
        Intrinsics.checkNotNullParameter(r2, "service");
        this.b.registerService(r2);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void run() {
        this.b.run();
    }

    public final void lf(f0c.b r3) {
        Intrinsics.checkNotNullParameter(r3, "toState");
        ((AbsChameleonJsRuntime) this.d.b()).destroy();
        Intrinsics.checkNotNullParameter(r3, "toState");
    }

    public final void qf(g r1, g r2) {
        v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        AbsChameleonJsRuntime r5 = (AbsChameleonJsRuntime) k.b(r3.c(r4), AbsChameleonJsRuntime.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }

    @Inject
    public c(j r2, v r3, com.ss.android.lark.passportc.convention.b<AbsChameleonJsRuntime> r4) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "accessor");
        Intrinsics.checkNotNullParameter(r4, "proxy");
        super(r2);
        this.b = (AbsChameleonJsRuntime) r4.b();
        this.c = r3;
        this.d = r4;
    }
}
