package n4b;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.tencent.qqmusic.third.api.contract.Keys;
import jkb.e;
import kotlin.jvm.internal.Intrinsics;
import n6b.c;
import o6b.b;
import org.json.JSONObject;
import s5c.d;
import z5c.g2;
import z5c.i2;
import z5c.m1;
import z5c.n0;
import z5c.o0;
import z5c.q2;
import z5c.w2;
import z5c.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements c<b> {
    public final Chat a;
    public final boolean b;

    /* JADX INFO: renamed from: n4b.a$a, reason: collision with other inner class name */
    public static final class C0264a {
    }

    static {
    }

    public a(Chat r1) {
        this.a = r1;
        if (r1 == null) goto L5;
        boolean r2 = r1.isSecret();
    L6:
        this.b = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // n6b.c
    public final void g(b r7) {
        b r8 = r7;
        Intrinsics.checkNotNullParameter(r8, "preMessageResponse");
        if (this.b == true) goto L6;
        return;
    L6:
        if (this.a == null) goto L11;
        Log.d("SChatMessageSendHT", "message send success hit point trigger");
        s5c.a r0 = m1.d;
        s5c.a r2 = w2.c.a(this.a.getId());
        s5c.a r3 = x2.c;
        s5c.a r4 = g2.c.a(r8.b);
        r3.getClass();
        d r5 = d.b.b(r3, r4).plus(q2.c.a(r8.a.getcId()));
        i2 r6 = i2.c;
        String r9 = ChatParamUtils.a;
        d r10 = r5.plus(r6.a(ChatParamUtils.k(r8.a.getType())));
        r0.getClass();
        JSONObject r11 = d.b.b(r0, r2).plus(r10).toJson();
        Statistics.sendEvent("im_s_send_message_dev", r11);
        Log.d("SChatMessageSendHT", "message send success " + r11);
        return;
    }

    @Override // n6b.c
    public final void a(ErrorResult r7, Message r8) {
        Intrinsics.checkNotNullParameter(r7, Keys.API_RETURN_KEY_ERROR);
        Intrinsics.checkNotNullParameter(r8, "preMessage");
        if (this.b == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        return;
    L8:
        Log.d("SChatMessageSendHT", "message send failed hit point trigger");
        s5c.a r1 = m1.c;
        s5c.a r2 = w2.c.a(this.a.getId());
        s5c.a r3 = x2.d;
        s5c.a r4 = q2.c.a(r8.getcId());
        r3.getClass();
        d r5 = d.b.b(r3, r4);
        i2 r6 = i2.c;
        String r9 = ChatParamUtils.a;
        d r10 = r5.plus(r6.a(ChatParamUtils.k(r8.getType()))).plus(n0.c.a(String.valueOf(r7.getCode())));
        String r11 = r7.getDebugMsg();
        if (r11 == null) goto L11;
        r10.plus(o0.c.a(r11));
    L11:
        r1.getClass();
        JSONObject r12 = d.b.b(r1, r2).plus(r10).toJson();
        Statistics.sendEvent("im_s_send_message_dev", r12);
        Log.d("SChatMessageSendHT", "message send failed " + r12);
    }

    @Override // n6b.c
    public final void k(e r7, Message r8) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        if (this.b == true) goto L6;
        return;
    L6:
        if (r7.c == true) goto L9;
        return;
    L9:
        if (this.a != null) goto L11;
        return;
    L11:
        Log.d("SChatMessageSendHT", "message send terminate hit point trigger");
        s5c.a r1 = m1.c;
        s5c.a r2 = w2.c.a(this.a.getId());
        s5c.a r3 = x2.d;
        n0 r4 = n0.c;
        Integer r5 = r7.b;
        if (r5 == null) goto L15;
        String r6 = r5.toString();
        if (r6 == null) goto L15;
    L16:
        s5c.a r9 = r4.a(r6);
        r3.getClass();
        d r10 = d.b.b(r3, r9).plus(o0.c.a(r7.a));
        if (r8 == null) goto L19;
        r10.plus(q2.c.a(r8.getcId()));
        i2 r11 = i2.c;
        String r12 = ChatParamUtils.a;
        r10.plus(r11.a(ChatParamUtils.k(r8.getType())));
    L19:
        r1.getClass();
        JSONObject r13 = d.b.b(r1, r2).plus(r10).toJson();
        Statistics.sendEvent("im_s_send_message_dev", r13);
        Log.d("SChatMessageSendHT", "message send terminate " + r13);
        return;
    L15:
        r6 = "-1";
        goto L16
    }
}
