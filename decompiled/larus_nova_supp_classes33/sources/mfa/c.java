package mfa;

import android.content.Intent;
import com.larus.platform.api.g1;
import com.obric.assistant.permission.IObricPermissionServiceImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements Function2 {
    public final /* synthetic */ g1.c a;

    public /* synthetic */ c(g1.c r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3) {
        g1.c r0 = this.a;
        ((Integer) r2).intValue();
        Intent r4 = (Intent) r3;
        int r5 = IObricPermissionServiceImpl.b;
        if (r0 == null) goto L6;
        r0.onSettingPageReturn();
    L6:
        return Unit.INSTANCE;
    }
}
