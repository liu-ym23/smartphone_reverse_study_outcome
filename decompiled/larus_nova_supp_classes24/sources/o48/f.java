package o48;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.awemeopen.domain.user.login.normal.NormalLogin;
import com.larus.api.serviceimpl.auth.NormalLoginService;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ u64.c a;
    public final /* synthetic */ NormalLoginService b;
    public final /* synthetic */ Activity c;

    public /* synthetic */ f(NormalLogin.login.afterHostLogin.1.a.b r1, NormalLoginService r2, Activity r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r6) {
        final u64.c r0 = this.a;
        final NormalLoginService r1 = this.b;
        final Activity r2 = this.c;
        boolean r7 = ((Boolean) r6).booleanValue();
        int r3 = NormalLoginService.a;
        if (r7 == false) goto L8;
        i3 r8 = i3.a;
        if (r8.f() == false) goto L7;
        r8.g(TriggerLoginScene.TRIGGER_LOGIN_TOURIST_AUTH);
        r0.onSuccess(false);
    L10:
        return Unit.INSTANCE;
    L7:
        r1.getClass();
        Looper r4 = Looper.myLooper();
        Intrinsics.checkNotNull(r4);
        new Handler(r4).post(new g(r0, r1, r2));
        goto L10
    L8:
        r0.onSuccess(false);
        goto L10
    }
}
