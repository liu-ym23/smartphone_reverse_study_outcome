package qsb;

import com.bytedance.apm.ApmAgent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;
import z5c.l3;
import z5c.s2;
import z5c.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    public d(String r1, long r2, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void a() {
        String r1 = this.a;
        long r2 = this.b;
        int r4 = this.c;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L8
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L8
        if (r1 == null) goto L6;
        r6.put("reason", r1);     // Catch: Throwable -> L8
    L6:
        r7.put("cost", r2);     // Catch: Throwable -> L8
        ApmAgent.monitorStatusAndEvent("emoji_get_emoji_panel", r4, r6, r7, null);     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.exceptionOrNull-impl(r3);
        if (r8 == null) goto L13;
        Log.e("EmojiMonitor", "emoji_get_emoji_panel error", r8);
    L13:
        int r9 = this.c;
        long r10 = this.b;
        String r11 = this.a;
        s5c.d r12 = s5c.d.b.b(l3.e.a(String.valueOf(r9)), z.c.a(String.valueOf(r10)));     // Catch: Throwable -> L19
        if (r11 == null) goto L17;
        r12 = r12.plus(s2.c.a(r11));     // Catch: Throwable -> L19
    L17:
        Statistics.sendEvent("emoji_get_emoji_panel", r12.toJson());     // Catch: Throwable -> L19
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L8:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
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
