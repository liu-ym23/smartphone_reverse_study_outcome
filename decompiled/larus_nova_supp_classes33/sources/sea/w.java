package sea;

import android.content.Context;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class w implements Function0 {
    public /* synthetic */ w() {
    }

    public final Object invoke() {
        g r0 = g.a;
        Context r1 = AppHost.a.getApplication().getApplicationContext();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intent r2 = new Intent();
        r2.setPackage(r1.getPackageName());
        r2.setAction("com.obric.assistant.obric.live.pending.action");
        r2.putExtra("live_state", -103);
        FLogger.a.e("ObricStateUtils", "getContentPendingIntent with intent " + r2 + ", extras: " + r2.getExtras());
        r1.sendBroadcast(r2);
        return Unit.INSTANCE;
    }
}
