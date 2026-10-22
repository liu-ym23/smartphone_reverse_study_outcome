package qsb;

import com.bytedance.apm.ApmAgent;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import z5c.b2;
import z5c.f1;
import z5c.l3;
import z5c.s2;
import z5c.y1;
import z5c.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;

        public a(boolean r1, String r2, long r3, int r5) {
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
            ApmAgent.monitorStatusAndEvent("sticker_get_customized_stickers", r5, r7, r8, null);     // Catch: Throwable -> L12
            Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
        L14:
            Throwable r10 = Result.exceptionOrNull-impl(r9);
            if (r10 == null) goto L17;
            Log.e("EmojiMonitor", "sticker_get_customized_stickers error", r10);
        L17:
            int r11 = this.d;
            boolean r12 = this.a;
            long r13 = this.c;
            String r14 = this.b;
            s5c.d r15 = s5c.d.b.b(l3.e.a(String.valueOf(r11)), b2.c.a(String.valueOf(r12))).plus(z.c.a(String.valueOf(r13)));     // Catch: Throwable -> L23
            if (r14 == null) goto L21;
            r15 = r15.plus(s2.c.a(r14));     // Catch: Throwable -> L23
        L21:
            Statistics.sendEvent("sticker_get_customized_stickers", r15.toJson());     // Catch: Throwable -> L23
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

    public static final class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(int r1, boolean r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            int r0 = this.a;
            boolean r1 = this.b;
            String r2 = this.c;
            String r3 = this.d;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
            s5c.d r5 = s5c.d.b.b(l3.e.a(String.valueOf(r0)), f1.c.a(String.valueOf(r1))).plus(y1.c.a(r2));     // Catch: Throwable -> L8
            if (r3 == null) goto L6;
            r5 = r5.plus(s2.c.a(r3));     // Catch: Throwable -> L8
        L6:
            Statistics.sendEvent("reaction_to_message", r5.toJson());     // Catch: Throwable -> L8
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
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

    static {
    }

    public c() {
    }

    public static void a(boolean r8, long r9, int r11, String r12) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(r8, r12, r9, r11));
    }

    public static void b(boolean r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new b(r4, r2, r3, r5));
    }
}
