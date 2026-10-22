package qsb;

import com.bytedance.apm.ApmAgent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;
import z5c.c1;
import z5c.l3;
import z5c.s2;
import z5c.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;

    public h(String r1, String r2, long r3, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void a() {
        String r1 = this.a;
        String r2 = this.b;
        long r3 = this.c;
        int r5 = this.d;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L8
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L8
        r7.put("image_key", r1);     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        r7.put("reason", r2);     // Catch: Throwable -> L8
    L6:
        r8.put("cost", r3);     // Catch: Throwable -> L8
        ApmAgent.monitorStatusAndEvent("emoji_load_image", r5, r7, r8, null);     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r9 = Result.exceptionOrNull-impl(r4);
        if (r9 == null) goto L13;
        Log.e("EmojiMonitor", "emoji_load_image error", r9);
    L13:
        int r10 = this.d;
        String r11 = this.a;
        long r12 = this.c;
        String r13 = this.b;
        s5c.d r14 = s5c.d.b.b(l3.e.a(String.valueOf(r10)), c1.c.a(r11)).plus(z.c.a(String.valueOf(r12)));     // Catch: Throwable -> L19
        if (r13 == null) goto L17;
        r14 = r14.plus(s2.c.a(r13));     // Catch: Throwable -> L19
    L17:
        Statistics.sendEvent("emoji_load_image", r14.toJson());     // Catch: Throwable -> L19
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L8:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
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
