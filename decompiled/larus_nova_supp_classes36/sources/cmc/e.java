package cmc;

import amc.g;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.ugc.live.sdk.msg.dispatch.f;
import com.ss.ugc.live.sdk.msg.network.i;
import com.ss.ugc.live.sdk.msg.utils.j;
import fmc.k;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import vlc.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements com.ss.ugc.live.sdk.msg.utils.d {
    public volatile boolean a;
    public final i b;
    public final f c;
    public final j d;
    public m e;
    public tlc.e f;
    public final b g;
    public final com.ss.ugc.live.sdk.msg.c h;
    public final g i;

    public static final class a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ e a;

        @Override // android.os.Handler
        public final void handleMessage(Message r7) {
            Intrinsics.checkNotNullParameter(r7, "msg");
            e r0 = this.a;
            r0.getClass();
            if (r7.what == 19873) goto L6;
            return;
        L6:
            if (r0.a == true) goto L17;
            com.ss.ugc.live.sdk.msg.utils.a.c(r0.h, "top message internal fetch");
            HashMap r8 = new HashMap();
            r8.putAll(r0.i.a());
            HashMap r1 = new HashMap();
            HashMap r2 = new HashMap();
            r2.put("support_cache", Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL);
            r2.put("resp_content_type", "protobuf");
            r1.putAll(r2);
            com.ss.ugc.live.sdk.msg.network.f.a r3 = new com.ss.ugc.live.sdk.msg.network.f.a();
            tlc.e r4 = r0.f;
            if (r4 == null) goto L13;
            String r5 = r4.a;
            if (r5 == null) goto L13;
        L14:
            r3.a.b = UriProtector.parse(r5).buildUpon().appendEncodedPath("top_message/").build().toString();
            com.ss.ugc.live.sdk.msg.network.f.a r9 = r3.query(r8);
            com.ss.ugc.live.sdk.msg.network.f r6 = r9.a;
            r6.h = r1;
            r6.g = "application/x-www-form-urlencoded; charset=UTF-8";
            com.ss.ugc.live.sdk.msg.network.f r10 = r9.a();
            r0.a = true;
            fmc.i r11 = new fmc.i(k.a, r0.b, r0.c, false);
            r0.h.i.b(r11, r10, r0.d);
            return;
        L13:
            r5 = r0.i.e();
            goto L14
        }

        public b(e r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.d
    public final void b(com.ss.ugc.live.sdk.msg.utils.k r3) {
        Intrinsics.checkNotNullParameter(r3, "whatResult");
        mmc.c r0 = r3.a;
        if ((r0 instanceof k) == false) goto L16;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r4 = r3.b;
        ((k) r0).getClass();
        Intrinsics.checkNotNullParameter(r4, "result");
        if ((r4 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L10;
        com.ss.ugc.live.sdk.msg.data.a r5 = (com.ss.ugc.live.sdk.msg.data.a) ((com.ss.ugc.live.sdk.msg.utils.g.c) r4).b;
        m r1 = this.e;
        if (r1 == null) goto L17;
        r1.a(r5.e);
        return;
    L17:
        return;
    L10:
        if ((r4 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L15;
        Throwable r6 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r4).b;
        m r2 = this.e;
        if (r2 == null) goto L19;
        r2.b(r6);
        return;
    L19:
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public e(com.ss.ugc.live.sdk.msg.c r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "messageContext");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.h = r2;
        this.i = r3;
        this.b = r3.d();
        this.c = r3.h();
        this.d = new j(this);
        this.g = new b(this, Looper.getMainLooper());
    }
}
