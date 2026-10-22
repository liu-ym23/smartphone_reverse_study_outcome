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
import z5c.b2;
import z5c.l3;
import z5c.s2;
import z5c.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;

    public f(boolean r1, String r2, long r3, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void a() {
        boolean r1 = this.a;
        String r2 = this.b;
        long r3 = this.c;
        int r5 = this.d;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L12
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L12
        if (r1 == false) goto L6;
        String r4 = Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL;
    L7:
        r7.put("from_local", r4);     // Catch: Throwable -> L12
        if (r2 == null) goto L10;
        r7.put("reason", r2);     // Catch: Throwable -> L12
    L10:
        r8.put("cost", r3);     // Catch: Throwable -> L12
        ApmAgent.monitorStatusAndEvent("emoji_get_mru_reactions", r5, r7, r8, null);     // Catch: Throwable -> L12
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L17;
        Log.e("EmojiMonitor", "emoji_get_mru_reactions error", r10);
    L17:
        int r11 = this.d;
        boolean r12 = this.a;
        long r13 = this.c;
        String r14 = this.b;
        s5c.d r15 = s5c.d.b.b(l3.e.a(String.valueOf(r11)), b2.c.a(String.valueOf(r12))).plus(z.c.a(String.valueOf(r13)));     // Catch: Throwable -> L23
        if (r14 == null) goto L21;
        r15 = r15.plus(s2.c.a(r14));     // Catch: Throwable -> L23
    L21:
        Statistics.sendEvent("emoji_get_mru_reactions", r15.toJson());     // Catch: Throwable -> L23
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L6:
        r4 = "0";
    L12:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
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
