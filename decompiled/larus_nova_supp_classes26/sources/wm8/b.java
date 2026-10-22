package wm8;

import android.content.Context;
import by7.g;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.auth.o0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.s3;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.platform.service.q;
import com.larus.utils.f;
import java.util.Arrays;
import java.util.Map;
import kc8.y;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import lg8.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements a {
    public final Context a;
    public final kc8.b b;

    @Override // wm8.a
    public final void b() {
        String r0 = o0.a;
        o0.a = null;
    }

    @Override // wm8.a
    public final String c() {
        String r0 = o0.a;
        return o0.a;
    }

    @Override // wm8.a
    public final boolean d() {
        return AccountService.a.isLogin().booleanValue();
    }

    @Override // wm8.a
    public final boolean e6() {
        kc8.b r0 = this.b;
        if (r0 == null) goto L9;
        y r1 = r0.a;
        if (r1 == null) goto L9;
        Function0 r2 = r1.q;
        if (r2 == null) goto L9;
        return ((Boolean) r2.invoke()).booleanValue();
    L9:
        return false;
    }

    @Override // wm8.a
    public final void f() {
        i3 r0 = i3.a;
        s3.a.b();
    }

    @Override // wm8.a
    public final String getBotId() {
        kc8.b r0 = this.b;
        if (r0 == null) goto L12;
        y r1 = r0.a;
        if (r1 == null) goto L12;
        Function0 r2 = r1.l;
        if (r2 == null) goto L12;
        BotModel r3 = (BotModel) r2.invoke();
        if (r3 == null) goto L12;
        String r4 = r3.getBotId();
        if (r4 == null) goto L12;
        return r4;
    L12:
        return "";
    }

    @Override // wm8.a
    public final boolean i0() {
        kc8.b r0 = this.b;
        if (r0 == null) goto L9;
        y r1 = r0.a;
        if (r1 == null) goto L9;
        Boolean r2 = r1.g;
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    @Override // wm8.a
    public final void a(Map r4) {
        Intrinsics.checkNotNullParameter("adult_validation_button_show", "name");
        Intrinsics.checkNotNullParameter(r4, "params");
        g.d.onEvent("adult_validation_button_show", new JSONObject(r4));
    }

    @Override // wm8.a
    public final boolean e(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        kc8.b r0 = this.b;
        if (r0 == null) goto L9;
        y r1 = r0.a;
        if (r1 == null) goto L9;
        q0 r3 = r1.x;
        if (r3 == null) goto L9;
        return h.b(r3, r2);
    L9:
        return false;
    }

    @Override // wm8.a
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        o0.a = r2;
    }

    @Override // wm8.a
    public final void h(String r6) {
        Intrinsics.checkNotNullParameter(r6, "messageId");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r7 = String.format("%s/inapp/authentication?hide_title_bar=1&bot_id=%s&message_id=%s", Arrays.copyOf(new Object[]{AppHost.a.d(), getBotId(), r6}, 3));
        Context r1 = this.a;
        if (r1 == null) goto L6;
        q.a.e(r1, f.c(new Pair[]{TuplesKt.to("link_url", r7)}), null);
        return;
    }

    @Override // wm8.a
    public final boolean i(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        kc8.b r0 = this.b;
        if (r0 == null) goto L9;
        y r1 = r0.a;
        if (r1 == null) goto L9;
        q0 r3 = r1.x;
        if (r3 == null) goto L9;
        return h.a(r3, r2);
    L9:
        return false;
    }

    public b(Context r1, kc8.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
