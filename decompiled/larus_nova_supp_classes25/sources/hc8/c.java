package hc8;

import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.auth.model.PluginAuth;
import com.larus.bmhome.chat.auth.model.PluginAuthType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements b {
    public static final c a = null;
    public static final b b = null;

    public c() {
    }

    static {
        a = new c();
        b = ILegacyChatUiServiceDelegate.b.E8();
    }

    @Override // hc8.b
    public final String b() {
        b r0 = b;
        if (r0 == null) goto L6;
        String r1 = r0.b();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // hc8.b
    public final String c() {
        b r0 = b;
        if (r0 == null) goto L6;
        String r1 = r0.c();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // hc8.b
    public final String i() {
        b r0 = b;
        if (r0 == null) goto L6;
        String r1 = r0.i();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // hc8.b
    public final String l() {
        b r0 = b;
        if (r0 == null) goto L6;
        String r1 = r0.l();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // hc8.b
    public final String n() {
        b r0 = b;
        if (r0 == null) goto L6;
        String r1 = r0.n();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // hc8.b
    public final boolean a(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        b r0 = b;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.a(r3) != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // hc8.b
    public final a f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        b r0 = b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f(r2);
    }

    @Override // hc8.b
    public final PluginAuth h(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        b r0 = b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h(r2);
    }

    @Override // hc8.b
    public final boolean j(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        b r0 = b;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.j(r3) != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // hc8.b
    public final boolean e(Message r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "botId");
        b r0 = b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e(r2, r3) != true) goto L7;
        return true;
    }

    @Override // hc8.b
    public final PluginAuthType k(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "pluginId");
        b r0 = b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k(r2, r3);
    }

    @Override // hc8.b
    public final void m(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "botId");
        b r0 = b;
        if (r0 == null) goto L6;
        r0.m(r2, r3);
        return;
    }

    @Override // hc8.b
    public final String d(Message r2, BotModel r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "bot");
        b r0 = b;
        if (r0 == null) goto L6;
        String r6 = r0.d(r2, r3, r4, r5);
        if (r6 == null) goto L6;
        return r6;
    L6:
        return "";
    }

    @Override // hc8.b
    public final void g(Message r8, Message r9, BotModel r10, PluginAuthType r11, u7 r12) {
        Intrinsics.checkNotNullParameter(r8, "authMsg");
        Intrinsics.checkNotNullParameter(r10, "bot");
        Intrinsics.checkNotNullParameter(r11, "state");
        b r1 = b;
        if (r1 == null) goto L6;
        r1.g(r8, r9, r10, r11, r12);
        return;
    }
}
