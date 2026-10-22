package cmc;

import amc.g;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.ugc.live.sdk.msg.dispatch.f;
import com.ss.ugc.live.sdk.msg.network.i;
import com.ss.ugc.live.sdk.msg.task.HistoryHttpException;
import com.ss.ugc.live.sdk.msg.utils.j;
import com.ss.ugc.live.sdk.msg.utils.k;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.ugc.live.sdk.msg.utils.d {
    public String a;
    public String b;
    public volatile boolean c;
    public final i d;
    public final f e;
    public final j f;
    public final b g;
    public final com.ss.ugc.live.sdk.msg.c h;
    public final g i;

    public static final class a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ c a;

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            Intrinsics.checkNotNullParameter(r8, "msg");
            c r0 = this.a;
            r0.getClass();
            if (r8.what != 10001) goto L37;
            Object r9 = r8.obj;
            if (r9 == null) goto L35;
            tlc.b r10 = (tlc.b) r9;
            if (r0.h.isRunning() == true) goto L12;
            if (r0.h.j.f() == true) goto L12;
            return;
        L12:
            if (r0.c == true) goto L38;
            HashMap r1 = new HashMap();
            r1.putAll(r0.i.a());
            HashMap r2 = new HashMap();
            r2.put("fetch_rule", "0");
            com.ss.ugc.live.sdk.msg.c r3 = r0.h;
            if (r3.e == false) goto L17;
            r0.a = r3.c;
        L17:
            HashMap r4 = new HashMap();
            r4.put("support_cache", Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL);
            r4.put("cursor", r0.a);
            if (r0.b.length() <= 0) goto L20;
            boolean r5 = true;
        L21:
            if (r5 == true) goto L23;
        L27:
            r4.put("resp_content_type", "protobuf");
            r2.putAll(r4);
            if (r10.a.a > 0) goto L30;
        L32:
            com.ss.ugc.live.sdk.msg.network.f.a r6 = new com.ss.ugc.live.sdk.msg.network.f.a();
            r6.a.b = UriProtector.parse(r0.i.e()).buildUpon().appendEncodedPath("history/").build().toString();
            com.ss.ugc.live.sdk.msg.network.f.a r7 = r6.query(r1);
            com.ss.ugc.live.sdk.msg.network.f r11 = r7.a;
            r11.h = r2;
            r11.g = "application/x-www-form-urlencoded; charset=UTF-8";
            com.ss.ugc.live.sdk.msg.network.f r12 = r7.a();
            r0.c = true;
            fmc.g r13 = new fmc.g(fmc.d.a, r0.d, r0.e, r10.b);
            j r14 = r0.f;
            Intrinsics.checkNotNullParameter(r12, "request");
            Intrinsics.checkNotNullParameter(r14, "resultHandler");
            r12.k = new fmc.e(r13, System.currentTimeMillis());
            r13.c.b(r12, new fmc.f(r13, r14));
            return;
        L30:
            if (r0.h.j.f() == false) goto L32;
            r2.put("need_persist_msg_count", String.valueOf(r10.a.a));
            goto L32
        L23:
            if (TextUtils.equals(r0.a, r0.h.a) == true) goto L27;
            if ((!StringsKt.isBlank(r0.a)) == false) goto L27;
            r4.put("internal_ext", r0.b);
            goto L27
        L20:
            r5 = false;
            goto L21
        L38:
            return;
        L35:
            throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.HistoryMessageFetchRequest");
        }

        public b(c r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.d
    public final void b(k r4) {
        Intrinsics.checkNotNullParameter(r4, "whatResult");
        if ((r4.a instanceof fmc.d) == false) goto L27;
        this.c = false;
        this.h.e = false;
        fmc.d r0 = (fmc.d) r4.a;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r5 = r4.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "result");
        if ((r5 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L15;
        com.ss.ugc.live.sdk.msg.data.b r6 = (com.ss.ugc.live.sdk.msg.data.b) ((com.ss.ugc.live.sdk.msg.utils.g.c) r5).b;
        String r1 = r6.a();
        String r2 = "";
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        this.a = r1;
        String r3 = r6.b();
        if (r3 == null) goto L13;
        r2 = r3;
    L13:
        this.b = r2;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.h, "process common response, history cursor: " + this.a);
        r6.g.b(r6.e, r6.d.history_no_more.booleanValue() ^ true);
        return;
    L15:
        if ((r5 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L26;
        Throwable r7 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r5).b;
        if ((r7 instanceof HistoryHttpException) == true) goto L19;
        Throwable r8 = null;
    L20:
        HistoryHttpException r9 = (HistoryHttpException) r8;
        if (r9 == null) goto L29;
        vlc.i r10 = r9.getListener();
        if (r10 == null) goto L30;
        r10.a(r7);
        return;
    L30:
        return;
    L29:
        return;
    L19:
        r8 = r7;
        goto L20
    L26:
        throw new NoWhenBranchMatchedException();
    }

    public c(com.ss.ugc.live.sdk.msg.c r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "messageContext");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.h = r2;
        this.i = r3;
        this.a = "0";
        this.b = "";
        this.d = r3.d();
        this.e = r3.h();
        this.f = new j(this);
        this.g = new b(this, Looper.getMainLooper());
    }
}
