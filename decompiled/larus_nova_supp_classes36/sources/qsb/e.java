package qsb;

import com.bytedance.apm.ApmAgent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;
import z5c.a0;
import z5c.l3;
import z5c.s2;
import z5c.v0;
import z5c.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ int e;

    public e(boolean r1, String r2, int r3, long r4, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void a() {
        boolean r1 = this.a;
        String r2 = this.b;
        int r3 = this.c;
        long r4 = this.d;
        int r6 = this.e;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L12
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L12
        if (r1 == false) goto L6;
        String r5 = Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL;
    L7:
        r8.put("full_request", r5);     // Catch: Throwable -> L12
        if (r2 == null) goto L10;
        r8.put("reason", r2);     // Catch: Throwable -> L12
    L10:
        r9.put("count", r3);     // Catch: Throwable -> L12
        r9.put("cost", r4);     // Catch: Throwable -> L12
        ApmAgent.monitorStatusAndEvent("emoji_get_emojis", r6, r8, r9, null);     // Catch: Throwable -> L12
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L17;
        Log.e("EmojiMonitor", "emoji_get_emojis error", r11);
    L17:
        int r12 = this.e;
        boolean r13 = this.a;
        int r14 = this.c;
        long r15 = this.d;
        String r16 = this.b;
        s5c.d r17 = s5c.d.b.b(l3.e.a(String.valueOf(r12)), v0.c.a(String.valueOf(r13))).plus(a0.c.a(String.valueOf(r14))).plus(z.c.a(String.valueOf(r15)));     // Catch: Throwable -> L23
        if (r16 == null) goto L21;
        r17 = r17.plus(s2.c.a(r16));     // Catch: Throwable -> L23
    L21:
        Statistics.sendEvent("emoji_get_emojis", r17.toJson());     // Catch: Throwable -> L23
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L6:
        r5 = "0";
    L12:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
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
