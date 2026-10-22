package ym8;

import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public String a;
    public boolean b;
    public ym8.a c;
    public wm8.a d;
    public final Lazy e;

    public static final class a {
    }

    public static final class b implements xm8.b {
        public final /* synthetic */ c a;

        @Override // xm8.b
        public final void a() {
            wm8.a r0 = this.a.d;
            boolean r1 = true;
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == true) goto L48;
            wm8.a r3 = this.a.d;
            if (r3 != null) goto L12;
        L14:
            boolean r4 = false;
        L15:
            if (r4 == true) goto L52;
            wm8.a r5 = this.a.d;
            if (r5 != null) goto L20;
        L22:
            r1 = false;
        L23:
            if (r1 == false) goto L36;
            ym8.a r6 = this.a.c;
            if (r6 == null) goto L33;
            Message r7 = r6.a;
            if (r7 == null) goto L33;
            String r8 = r7.getMessageId();
            if (r8 == null) goto L33;
            wm8.a r9 = this.a.d;
            if (r9 == null) goto L33;
            r9.g(r8);
        L33:
            wm8.a r10 = this.a.d;
            if (r10 == null) goto L49;
            r10.f();
            return;
        L49:
            return;
        L36:
            c r11 = this.a;
            wm8.a r12 = r11.d;
            if (r12 == null) goto L51;
            ym8.a r13 = r11.c;
            if (r13 == null) goto L43;
            Message r14 = r13.a;
            if (r14 == null) goto L43;
            String r15 = r14.getMessageId();
        L44:
            if (r15 != null) goto L46;
            r15 = "";
        L46:
            r12.h(r15);
            return;
        L43:
            r15 = null;
            goto L44
        L51:
            return;
        L20:
            if (r5.d() == true) goto L22;
        L52:
            return;
        L12:
            if (r3.e6() != true) goto L14;
            r4 = true;
            goto L15
        L48:
            return;
        L5:
            if (r0.i0() != true) goto L7;
            r2 = true;
            goto L8
        }

        @Override // xm8.b
        public final void onViewAttachedToWindow() {
            this.a.b(false);
        }

        public b(c r1) {
            this.a = r1;
        }
    }

    static {
    }

    public c() {
        this.e = LazyKt.lazy(new ym8.b(this));
    }

    public final boolean a(Message r6) {
        if (r6 != null) goto L5;
        return true;
    L5:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("hideReal.isServerLoading :.isServerLoading : ");
        r2.append(d.I0(r6));
        r2.append("==  data.messageStatusLocal : ");
        r2.append(r6.getMessageStatusLocal());
        r2.append("  data.isTyping : ");
        r2.append(d.Q0(r6));
        r2.append("  dependency?.isFirst(data) != true : ");
        wm8.a r3 = this.d;
        if (r3 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        r2.append(!r4);
        r2.append("  dependency?.hasQuestion(data) != true : ");
        wm8.a r5 = this.d;
        if (r5 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        r2.append(!r7);
        r1.i("RealNameVerifiedViewModel", r2.toString());
        if (d.I0(r6) == false) goto L20;
        return true;
    L20:
        if (r6.getMessageStatusLocal() == 21) goto L22;
        return true;
    L22:
        if (d.Q0(r6) == true) goto L42;
        wm8.a r8 = this.d;
        if (r8 != null) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == false) goto L43;
        wm8.a r10 = this.d;
        if (r10 != null) goto L33;
    L35:
        boolean r11 = false;
    L36:
        if (r11 == false) goto L44;
        return false;
    L44:
        return true;
    L33:
        if (r10.i(r6) != true) goto L35;
        r11 = true;
        goto L36
    L43:
        return true;
    L26:
        if (r8.e(r6) != true) goto L28;
        r9 = true;
        goto L29
    L42:
        return true;
    L14:
        if (r5.i(r6) != true) goto L16;
        r7 = true;
        goto L17
    L8:
        if (r3.e(r6) != true) goto L10;
        r4 = true;
        goto L11
    }

    public final void b(boolean r5) {
        if (r5 == true) goto L9;
        ym8.a r6 = this.c;
        if (r6 == null) goto L6;
        Message r7 = r6.a;
    L8:
        if (a(r7) == true) goto L9;
        return;
    L6:
        r7 = null;
    L9:
        wm8.a r8 = this.d;
        if (r8 == null) goto L27;
        Pair[] r0 = new Pair[2];
        ym8.a r1 = this.c;
        String r2 = "";
        if (r1 == null) goto L17;
        Message r3 = r1.a;
        if (r3 == null) goto L17;
        String r4 = r3.getMessageId();
        if (r4 == null) goto L17;
    L18:
        r0[0] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r4);
        wm8.a r9 = this.d;
        if (r9 == null) goto L24;
        String r10 = r9.getBotId();
        if (r10 == null) goto L24;
        r2 = r10;
    L24:
        r0[1] = TuplesKt.to("bot_id", r2);
        r8.a(MapsKt.mapOf(r0));
        return;
    L17:
        r4 = "";
        goto L18
    }
}
