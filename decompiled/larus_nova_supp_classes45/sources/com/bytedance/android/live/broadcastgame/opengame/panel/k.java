package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.content.SharedPreferences;
import com.bytedance.android.livesdk.utils.v5;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements Runnable {
    public final /* synthetic */ ShowTipsHelper a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;

    public k(ShowTipsHelper r1, Ref.ObjectRef r2, String r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        ShowTipsHelper r0 = this.a;
        if (r0.e == false) goto L6;
        return;
    L6:
        if (((Boolean) r0.i.invoke()).booleanValue() == true) goto L8;
        return;
    L8:
        SharedPreferences r1 = (SharedPreferences) this.a.c.getValue();
        this.a.getClass();
        if (r1.getInt(new SimpleDateFormat("YYYY-MM-dd").format(new Date()), 0) < 2) goto L11;
        return;
    L11:
        String r2 = com.bytedance.android.live.broadcastgame.opengame.service.e.a;
        String r3 = (String) this.b.element;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        com.bytedance.android.live.broadcastgame.opengame.service.e.a = r3;
        this.a.j.invoke();
        ShowTipsHelper r4 = this.a;
        String r5 = this.c;
        r4.e = true;
        String r6 = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        ((SharedPreferences) r4.c.getValue()).edit().putInt(r6, ((SharedPreferences) r4.c.getValue()).getInt(r6, 0) + 1).putBoolean(r6 + r5, true).apply();
        v5.b().edit().putInt("live.key.SHOW_START_GAME_TIP_COUNT", this.d + 1).apply();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
