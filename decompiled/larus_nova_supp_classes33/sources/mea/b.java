package mea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.receiver.GRIslandReceiver;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static Intent a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intent r0 = new Intent(r3, GRIslandReceiver.class);
        r0.setPackage(r3.getPackageName());
        r0.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r0.putExtra("live_state", -102);
        FLogger.a.e("GRStateActionUtils", "getContentPendingIntent with intent " + r0 + ", extras: " + r0.getExtras());
        return r0;
    }

    public static Intent b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intent r0 = new Intent(r3, GRIslandReceiver.class);
        r0.setPackage(r3.getPackageName());
        r0.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r0.putExtra("live_state", -1007);
        FLogger.a.e("GRStateActionUtils", "getContentPendingIntent with intent " + r0 + ", extras: " + r0.getExtras());
        return r0;
    }

    public static Intent e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intent r0 = new Intent(r3, GRIslandReceiver.class);
        r0.setPackage(r3.getPackageName());
        r0.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r0.putExtra("live_state", -104);
        FLogger.a.e("GRStateActionUtils", "getContentPendingIntent with intent " + r0 + ", extras: " + r0.getExtras());
        return r0;
    }

    public static Intent g(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intent r0 = new Intent(r3, GRIslandReceiver.class);
        r0.setPackage(r3.getPackageName());
        r0.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r0.putExtra("live_state", -105);
        FLogger.a.e("GRStateActionUtils", "getContentPendingIntent with intent " + r0 + ", extras: " + r0.getExtras());
        return r0;
    }

    public static Intent c(Context r2, ObricState r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "obricState");
        Intent r0 = new Intent(r2, GRIslandReceiver.class);
        r0.setPackage(r2.getPackageName());
        r0.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r0.putExtra("live_state", -108);
        r0.putExtra("is_complex_task_scene", true);
        sea.b.a.getClass();
        sea.b.f(r0, r3);
        FLogger.a.e("GRStateActionUtils", "getSidecarAuthorizeIntent(), extras: " + r0.getExtras());
        return r0;
    }

    public static Intent d(Context r4, ObricState r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "obricState");
        FLogger r0 = FLogger.a;
        r0.i("GRStateActionUtils", "jumpToChatPage with obricState: " + r5);
        Intent r1 = new Intent(r4, GRIslandReceiver.class);
        r1.setPackage(r4.getPackageName());
        r1.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r1.putExtra("live_state", -106);
        if (r5.getScene() != ObricInteractionScene.COMPLEX_TASK_SCENE) goto L5;
        boolean r6 = true;
    L6:
        r1.putExtra("is_complex_task_scene", r6);
        r0.e("GRStateActionUtils", "getContentPendingIntent with intent " + r1 + ", extras: " + r1.getExtras());
        return r1;
    L5:
        r6 = false;
        goto L6
    }

    public static Intent f(Context r2, boolean r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intent r0 = new Intent(r2, GRIslandReceiver.class);
        r0.setPackage(r2.getPackageName());
        r0.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r0.putExtra("live_state", -107);
        r0.putExtra("auto_enter_call_user", r3);
        a.getClass();
        r0.putExtra("source_from", "dynamic_island");
        sea.b.a.getClass();
        sea.b.e(r0, r4);
        FLogger.a.e("GRStateActionUtils", "getOAutoVirtualScreenIntent(), extras: " + r0.getExtras());
        return r0;
    }
}
