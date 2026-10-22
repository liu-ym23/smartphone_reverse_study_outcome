package mfa;

import com.larus.platform.api.g1;
import com.obric.assistant.permission.IObricPermissionServiceImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ g1.c a;

    public /* synthetic */ d(g1.c r1) {
        this.a = r1;
    }

    public final Object invoke() {
        g1.c r0 = this.a;
        int r1 = IObricPermissionServiceImpl.b;
        if (r0 == null) goto L6;
        r0.onSettingPageReturn();
    L6:
        return Unit.INSTANCE;
    }
}
