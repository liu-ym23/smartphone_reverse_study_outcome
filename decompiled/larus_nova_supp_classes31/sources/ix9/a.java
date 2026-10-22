package ix9;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.model.chat.i0;
import com.larus.platform.service.z2;
import com.larus.suggest.impl.wcb.policy.z;
import com.larus.suggest.impl.wcb.render.g;
import com.larus.suggest.impl.wcb.render.n;
import com.larus.suggest.impl.wcb.render.p;
import com.larus.suggest.impl.wcb.render.q;
import com.larus.suggest.impl.wcb.request.WcbRequestPipeline;
import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import hx9.k;
import ic8.k0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements d {
    public final k a;
    public final lx9.c b;
    public final WcbRequestPipeline c;
    public final String d;
    public final boolean e;
    public final g f;
    public final i0 g;
    public final gx9.b h;
    public boolean i;
    public boolean j;
    public final b k;
    public final C0061a l;

    /* JADX INFO: renamed from: ix9.a$a, reason: collision with other inner class name */
    public static final class C0061a implements f09.a.b {
        public final /* synthetic */ a a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            q r0 = this.a.c.h;
            if (r0 == null) goto L6;
            r0.c();
        L6:
            if (this.a.g.e() == true) goto L8;
            return;
        L8:
            a r1 = this.a;
            gx9.b r2 = r1.h;
            String r13 = r1.d;
            int r6 = r1.g.d();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r13, "conversationId");
            if (r13.length() != 0) goto L11;
            boolean r3 = true;
        L12:
            if (r3 == true) goto L16;
            if (r6 <= 1) goto L16;
            com.larus.im.d.e().getMessageListFromLocal(new MessageListRequest(r13, 0, 0, r6, 0, null, false, 118, null), new gx9.c(r2, r13));
            return;
        L16:
            FLogger.a.w("ChatWcbMessageCleaner", "skip clearHistoryWcbMessages, cvsId=" + r13 + " limit=" + r6);
            return;
        L11:
            r3 = false;
            goto L12
        }

        public final void onAppForeground() {
            a r0 = this.a;
            if (r0.i == true) goto L5;
            return;
        L5:
            if (r0.j == true) goto L13;
            z r2 = r0.b.b.get();
            if (r2 != null) goto L10;
            return;
        L10:
            a r1 = this.a;
            r1.c.a(a.e(r1, r2, WcbRequestTrigger.FOREGROUND, "app_foreground", null, null, 56));
            return;
        }

        public C0061a(a r1) {
            this.a = r1;
        }
    }

    public static final class b implements ICoreInputAbility.d {
        public final /* synthetic */ a a;

        public final void a() {
        }

        public final void c() {
        }

        public b(a r1) {
            this.a = r1;
        }

        public final void b(ICoreInputAbility.OnSendParams r9) {
            Intrinsics.checkNotNullParameter(r9, "params");
            a r10 = this.a;
            if (r10.i == true) goto L5;
            return;
        L5:
            if (r10.j == true) goto L82;
            y r11 = r10.a.d();
            Object r0 = null;
            if (r11 == null) goto L10;
            e r12 = r11.h();
        L11:
            if (r12 == null) goto L13;
            String r13 = r12.a;
        L15:
            if (Intrinsics.areEqual(r13, this.a.d) == true) goto L17;
            return;
        L17:
            List<Message> r14 = this.a.a.a();
            a r1 = this.a;
            Iterator<T> r15 = r14.iterator();
        L19:
            if (r15.hasNext() == false) goto L67;
            Object r2 = r15.next();
            Message r3 = (Message) r2;
            boolean r5 = false;
            if (Intrinsics.areEqual(r3.getConversationId(), r1.d) == false) goto L65;
            if (com.larus.bmhome.chat.bean.d.i0(r3) == false) goto L28;
            if (com.larus.bmhome.chat.bean.d.w(r3) == true) goto L28;
        L47:
            boolean r4 = false;
        L48:
            if (r4 == false) goto L65;
            if (com.larus.bmhome.chat.bean.d.W0(r3) == false) goto L65;
            Map r6 = r3.getBusinessExt();
            if (r6 == null) goto L54;
            String r7 = (String) r6.get("transient_wcb_loading_session_id");
        L55:
            if (r7 != null) goto L57;
        L60:
            boolean r8 = true;
        L61:
            if (r8 == false) goto L65;
            if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.x(r3).get("wcb_render_status"), "DEPRECATED") == true) goto L65;
            r5 = true;
            goto L65
        L57:
            if (r7.length() == 0) goto L60;
            r8 = false;
            goto L61
        L54:
            r7 = null;
        L28:
            if (com.larus.bmhome.chat.bean.d.T(r3) == true) goto L47;
            if (com.larus.bmhome.chat.bean.d.p0(r3) == true) goto L47;
            if (com.larus.bmhome.chat.bean.d.C0(r3) == true) goto L35;
        L37:
            MessageStatus r16 = r3.getMessageStatus();
            if (r16 != null) goto L40;
        L42:
            boolean r17 = false;
        L43:
            if (r17 == false) goto L45;
        L46:
            r4 = true;
            goto L48
        L45:
            if (b0.f(r3) == false) goto L47;
        L40:
            if (r16.isVisible() != true) goto L42;
            r17 = true;
            goto L43
        L35:
            if (r3.getRegenVisible() == true) goto L37;
        L65:
            if (r5 == false) goto L19;
            r0 = r2;
        L67:
            Message r18 = (Message) r0;
            if (r18 != null) goto L70;
            return;
        L70:
            FLogger.a.i("WcbLog", "[Controller] consume wcb on send, conv_id=" + this.a.d + ", localId=" + r18.getLocalMessageId());
            this.a.d();
            return;
        L13:
            r13 = null;
            goto L15
        L10:
            r12 = null;
            goto L11
        }
    }

    @Override // ix9.d
    public final void onCreate() {
        this.i = true;
        ICoreInputAbility r0 = (ICoreInputAbility) this.a.e.getValue();
        if (r0 == null) goto L5;
        r0.Jm(this.k);
    L5:
        AppHost.a.a().j(this.l);
    }

    public final void d() {
        if (this.j == false) goto L5;
        return;
    L5:
        z r0 = this.b.b.get();
        if (r0 != null) goto L8;
        return;
    L8:
        this.j = true;
        r0.h().m(this.d, r0.getScene());
    }

    @Override // ix9.d
    public final void onDestroy() {
        ICoreInputAbility r0 = (ICoreInputAbility) this.a.e.getValue();
        if (r0 == null) goto L5;
        r0.XG(this.k);
    L5:
        WcbRequestPipeline r1 = this.c;
        r1.d();
        CoroutineScopeKt.cancel$default(r1.d, null, 1, null);
        this.i = false;
        AppHost.a.a().c(this.l);
    }

    @Override // ix9.d
    public final boolean c() {
        d();
        return true;
    }

    @Override // ix9.d
    public final void a(lx9.a r13) {
        Intrinsics.checkNotNullParameter(r13, "change");
        if (this.i == true) goto L5;
        return;
    L5:
        boolean r0 = r13 instanceof lx9.a.c;
        p r1 = null;
        String r2 = null;
        if (r0 == true) goto L9;
        this.f.b = null;
    L9:
        if (this.j == false) goto L12;
        return;
    L12:
        if ((r13 instanceof lx9.a.C0066a) == false) goto L26;
        WcbRequestPipeline r3 = this.c;
        z r4 = ((lx9.a.C0066a) r13).a;
        WcbRequestTrigger r5 = WcbRequestTrigger.INITIAL;
        if (this.e == false) goto L16;
        String r14 = "enter_chat_cvs_changed";
    L17:
        String r6 = r14;
        int r7 = p0.a;
        de8.c r8 = this.a.c();
        if (r8 == null) goto L20;
        String r9 = r8.q();
    L21:
        String r10 = p0.a(r9);
        de8.c r11 = this.a.c();
        if (r11 == null) goto L24;
        r2 = r11.r();
    L24:
        r3.a(e(this, r4, r5, r6, new k0(r10, p0.a(r2), null, null, 12), null, 48));
        return;
    L20:
        r9 = null;
        goto L21
    L16:
        r14 = "enter_chat";
        goto L17
    L26:
        if ((r13 instanceof lx9.a.b) == false) goto L31;
        WcbRequestPipeline r12 = this.c;
        z r15 = ((lx9.a.b) r13).b;
        WcbRequestTrigger r16 = WcbRequestTrigger.MODE_SWITCH;
        Message r17 = this.a.b();
        if (r17 == null) goto L30;
        int r18 = p.b;
        r1 = p.a.a(r17);
    L30:
        r12.a(e(this, r15, r16, "task_mode_changed", null, r1, 40));
        return;
    L31:
        if (r0 == false) goto L33;
        return;
    L33:
        if ((r13 instanceof lx9.a.d) == false) goto L36;
        FLogger.a.w("WcbLog", "unsupported main wcb pipeline policy key=" + ((lx9.a.d) r13).a);
        return;
    L36:
        throw new NoWhenBranchMatchedException();
    }

    @Override // ix9.d
    public final Set<Message> h9(List<Message> r3) {
        Intrinsics.checkNotNullParameter(r3, "messages");
        return this.f.a(r3, this.d);
    }

    @Override // ix9.d
    public final void u8(List<Message> r6) {
        Intrinsics.checkNotNullParameter(r6, "messages");
        g r1 = this.f;
        String r2 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "messages");
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        n.b r0 = r1.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r6.isEmpty() == true) goto L14;
        Iterator<T> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        if (g.b((Message) r7.next(), r2, r0) == false) goto L10;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L23;
        r1.a = true;
        r1.b = null;
        r1.c = null;
        return;
    L23:
        return;
    L14:
        r8 = false;
        goto L15
    }

    @Override // ix9.d
    public final void b(Message r10, k0 r11) {
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r11, "params");
        z r2 = this.b.b.get();
        if (r2 != null) goto L5;
        return;
    L5:
        WcbRequestPipeline r0 = this.c;
        WcbRequestTrigger r3 = WcbRequestTrigger.REGENERATE;
        int r1 = p.b;
        r0.a(new com.larus.suggest.impl.wcb.request.c(r2, r3, r11, "regenerate", p.a.a(r10), 2, false));
    }

    public a(k r2, lx9.c r3, WcbRequestPipeline r4, String r5, boolean r6, g r7) {
        Intrinsics.checkNotNullParameter(r2, "environment");
        Intrinsics.checkNotNullParameter(r3, "policySelection");
        Intrinsics.checkNotNullParameter(r4, "pipeline");
        Intrinsics.checkNotNullParameter(r5, "initializedConversationId");
        Intrinsics.checkNotNullParameter(r7, "initialDisplayState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = z2.a.M0();
        this.h = new gx9.b();
        this.k = new b(this);
        this.l = new C0061a(this);
    }

    public static com.larus.suggest.impl.wcb.request.c e(a r15, z r16, WcbRequestTrigger r17, String r18, k0 r19, p r20, int r21) {
        if ((r21 & 8) == 0) goto L5;
        k0 r10 = new k0(null, null, null, null, 15);
    L7:
        if ((r21 & 16) == 0) goto L9;
        p r12 = null;
    L11:
        if ((r21 & 32) == 0) goto L13;
        int r13 = r16.getScene();
    L14:
        r15.getClass();
        return new com.larus.suggest.impl.wcb.request.c(r16, r17, r10, r18, r12, r13, false);
    L13:
        r13 = 0;
        goto L14
    L9:
        r12 = r20;
        goto L11
    L5:
        r10 = r19;
        goto L7
    }
}
