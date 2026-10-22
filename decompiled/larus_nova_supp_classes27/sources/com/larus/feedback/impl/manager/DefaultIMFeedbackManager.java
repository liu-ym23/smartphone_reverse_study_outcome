package com.larus.feedback.impl.manager;

import com.larus.common.apphost.AppHost;
import com.larus.feedback.impl.gateway.FlowFeedbackRemoteGateway;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.api.d3;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import hq9.n3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import q99.i;
import q99.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DefaultIMFeedbackManager extends p99.d {
    public static final /* synthetic */ int g = 0;
    public final i b;
    public b c;
    public String d;
    public boolean e;
    public d f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/feedback/impl/manager/DefaultIMFeedbackManager$PendingPhase;", "", "<init>", "(Ljava/lang/String;I)V", "WAIT_STREAM_END", "WAIT_PAUSE_TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PendingPhase extends Enum<PendingPhase> {
        public static final PendingPhase WAIT_PAUSE_TIMEOUT = null;
        public static final PendingPhase WAIT_STREAM_END = null;
        public static final /* synthetic */ PendingPhase[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PendingPhase> getEntries() {
            return b;
        }

        static {
            PendingPhase r0 = new PendingPhase("WAIT_STREAM_END", 0);
            WAIT_STREAM_END = r0;
            PendingPhase r1 = new PendingPhase("WAIT_PAUSE_TIMEOUT", 1);
            WAIT_PAUSE_TIMEOUT = r1;
            PendingPhase[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static PendingPhase[] values() {
            return (PendingPhase[]) a.clone();
        }

        public static PendingPhase valueOf(String r1) {
            return (PendingPhase) r27.a.a(PendingPhase.class, r1);
        }

        public PendingPhase(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final q99.e a;
        public final PendingPhase b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PendingState(delivery=" + this.a + ", phase=" + this.b + ')';
        }

        public b(q99.e r2, PendingPhase r3) {
            Intrinsics.checkNotNullParameter(r2, "delivery");
            Intrinsics.checkNotNullParameter(r3, "phase");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements IIMCallback<Message> {
        public final /* synthetic */ DefaultIMFeedbackManager a;
        public final /* synthetic */ q99.e b;
        public final /* synthetic */ q99.d c;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.d("DefaultIMFeedbackManager", "handleResolvedDelivery: find message fail, error = " + r4);
            this.a.m(this.b, this.c);
        }

        public final void onSuccess(Object r10) {
            Message r11 = (Message) r10;
            Intrinsics.checkNotNullParameter(r11, "result");
            FLogger r0 = FLogger.a;
            r0.d("DefaultIMFeedbackManager", "handleResolvedDelivery: find message success");
            DefaultIMFeedbackManager r1 = this.a;
            q99.e r3 = this.b;
            q99.d r4 = this.c;
            r1.getClass();
            Integer r5 = r11.getFeedback();
            boolean r7 = true;
            if (r5 != null) goto L5;
        L10:
            boolean r6 = false;
        L11:
            if (r6 == false) goto L14;
            r0.d("DefaultIMFeedbackManager", "handleResolvedMessage: no-op, feedback = " + r11.getFeedback());
            return;
        L14:
            if (r11.getMessageStatusLocal() != 22) goto L16;
        L41:
            r0.d("DefaultIMFeedbackManager", "handleResolvedMessage: no-op, messageStatusLocal = " + r11.getMessageStatusLocal());
            return;
        L16:
            if (r11.getMessageStatusLocal() == 23) goto L41;
            i r8 = r1.b;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r11, "message");
            if (((Boolean) r8.o.invoke(r11)).booleanValue() == true) goto L22;
            r0.d("DefaultIMFeedbackManager", "handleResolvedMessage: no-op, message can't show like/dislike");
            return;
        L22:
            if (r11.getMessageStatusLocal() != 20) goto L24;
        L27:
            String r12 = r11.getMessageId();
            if (r12 != null) goto L32;
            r12 = r3.b;
            if (r12 != null) goto L32;
            r12 = r4.e();
        L32:
            q99.e r13 = q99.e.a(r3, null, r12, null, 125);
            String r9 = r13.b;
            if (r9 != null) goto L35;
        L38:
            if (r7 == false) goto L40;
            r0.d("DefaultIMFeedbackManager", "waitForStreamEnd: no-op, messageId = null");
            return;
        L40:
            r0.d("DefaultIMFeedbackManager", "waitForStreamEnd: messageId = " + r9);
            r1.l(false, "wait_for_stream_end");
            r1.c = new b(r13, PendingPhase.WAIT_STREAM_END);
            return;
        L35:
            if (r9.length() == 0) goto L38;
            r7 = false;
            goto L38
        L24:
            if (com.larus.im.bean.message.a.w0(r11) == true) goto L27;
            r0.d("DefaultIMFeedbackManager", "handleResolvedMessage: try show popup");
            r1.m(r3, r4);
            return;
        L5:
            if (r5.intValue() <= 0) goto L7;
            boolean r14 = true;
        L8:
            if (r14 != true) goto L10;
            r6 = true;
            goto L11
        L7:
            r14 = false;
            goto L8
        }

        public c(DefaultIMFeedbackManager r1, q99.e r2, q99.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // p99.d
    public final void h() {
        l(false, "page_disappear");
    }

    public final void n() {
        b r0 = this.c;
        if (r0 != null) goto L7;
        FLogger.a.d("DefaultIMFeedbackManager", "handlePauseTimeout: no-op, pendingState = null");
        return;
    L7:
        if (r0.b == PendingPhase.WAIT_PAUSE_TIMEOUT) goto L10;
        FLogger.a.d("DefaultIMFeedbackManager", "handlePauseTimeout: no-op, phase = " + r0.b);
        return;
    L10:
        q99.e r1 = r0.a;
        boolean r2 = this.b.b();
        boolean r3 = ((Boolean) this.b.g.invoke()).booleanValue();
        String r4 = null;
        if (r2 == false) goto L19;
        if (r3 == true) goto L19;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("handlePauseTimeout: show popup, messageId = ");
        r6.append(r1.b);
        r6.append(", sectionId = ");
        q99.d r7 = r1.f;
        if (r7 == null) goto L17;
        r4 = r7.h();
    L17:
        r6.append(r4);
        r5.d("DefaultIMFeedbackManager", r6.toString());
        p(r1);
        return;
    L19:
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("handlePauseTimeout: no-op, isActive = ");
        r9.append(r2);
        r9.append(", isInputting = ");
        r9.append(r3);
        r9.append(", messageId = ");
        r9.append(r1.b);
        r9.append(", sectionId = ");
        q99.d r10 = r1.f;
        if (r10 == null) goto L22;
        r4 = r10.h();
    L22:
        r9.append(r4);
        r8.d("DefaultIMFeedbackManager", r9.toString());
    }

    @Override // p99.d
    public final i e() {
        return this.b;
    }

    @Override // p99.d
    public final void f(q99.e r3) {
        Intrinsics.checkNotNullParameter(r3, "delivery");
        q99.d r0 = r3.f;
        if (r0 != null) goto L7;
        Integer r1 = r3.c;
        if (r1 == null) goto L9;
        query(new q99.c(r1.intValue()), new f(r3, this));
        return;
    L9:
        return;
    L7:
        o(r3, r0);
    }

    @Override // p99.d
    public final void g(Message r8) {
        Intrinsics.checkNotNullParameter(r8, "message");
        b r1 = this.c;
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.b == PendingPhase.WAIT_STREAM_END) goto L8;
        return;
    L8:
        q99.e r2 = r1.a;
        String r3 = r2.b;
        if (r3 != null) goto L11;
        return;
    L11:
        String r4 = r8.getMessageId();
        String r5 = com.larus.im.bean.message.a.L(r8);
        if (Intrinsics.areEqual(r3, r4) == false) goto L14;
    L16:
        FLogger r6 = FLogger.a;
        r6.d("DefaultIMFeedbackManager", "handleMessageStreamEnd: messageId = " + r4 + ", status = " + r8.getMessageStatusLocal());
        Integer r7 = r8.getFeedback();
        if (r7 == null) goto L24;
        boolean r9 = true;
        if (r7.intValue() <= 0) goto L21;
        boolean r10 = true;
    L22:
        if (r10 != true) goto L24;
    L25:
        if (r9 == false) goto L29;
        r6.d("DefaultIMFeedbackManager", "handleMessageStreamEnd: no-op, feedback = " + r8.getFeedback());
        l(false, "message_stream_end_already_feedback");
        return;
    L29:
        if (r8.getMessageStatusLocal() != 22) goto L31;
    L41:
        r6.d("DefaultIMFeedbackManager", "handleMessageStreamEnd: no-op, messageStatusLocal = " + r8.getMessageStatusLocal());
        l(false, "message_stream_end_invalid_status");
        return;
    L31:
        if (r8.getMessageStatusLocal() == 23) goto L41;
        i r11 = this.b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r8, "message");
        if (((Boolean) r11.o.invoke(r8)).booleanValue() == true) goto L37;
        r6.d("DefaultIMFeedbackManager", "handleMessageStreamEnd: no-op, message can't show like/dislike");
        l(false, "message_stream_end_cant_show_like_dislike");
        return;
    L37:
        q99.d r12 = r2.f;
        if (r12 == null) goto L43;
        m(r2, r12);
        return;
    L43:
        return;
    L21:
        r10 = false;
    L24:
        r9 = false;
        goto L25
    L14:
        if (Intrinsics.areEqual(r3, r5) == true) goto L16;
    }

    @Override // p99.d
    public final void i(boolean r1) {
        if (r1 == true) goto L4;
        return;
    L4:
        n();
    }

    @Override // p99.d
    public final void j(String r4) {
        Intrinsics.checkNotNullParameter(r4, "newSectionId");
        String r0 = this.d;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L17:
        this.d = r4;
        return;
    L11:
        if (r4.length() <= 0) goto L13;
        r1 = true;
    L13:
        if (r1 == false) goto L17;
        if (Intrinsics.areEqual(this.d, r4) == true) goto L17;
        l(true, "section_changed");
        goto L17
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // p99.d
    public final void k(String r2) {
        if (r2 != null) goto L4;
    L5:
        l(false, "user_manual_feedback");
        return;
    L4:
        if (Intrinsics.areEqual(r2, this.d) == true) goto L5;
    }

    public final void p(q99.e r18) {
        FLogger r10 = FLogger.a;
        r10.d("DefaultIMFeedbackManager", "showPopupNow: delivery = " + r18);
        boolean r12 = false;
        l(false, "show_popup_now");
        q99.d r13 = r18.f;
        if (r13 != null) goto L5;
        return;
    L5:
        String r0 = r13.h();
        if (r0 != null) goto L8;
        r0 = this.d;
    L8:
        this.d = r0;
        this.e = true;
        i r4 = this.b;
        Intrinsics.checkNotNullParameter(r18, "delivery");
        Intrinsics.checkNotNullParameter(r4, "host");
        q99.d r1 = r18.f;
        if (r1 == null) goto L31;
        String r5 = r4.k;
        if (r5 == null) goto L31;
        o99.a r7 = r4.q;
        Function0<String> r2 = r4.l;
        if (r2 == null) goto L17;
        String r3 = (String) r2.invoke();
    L18:
        if (r3 != null) goto L21;
        r3 = "";
    L21:
        if (r3.length() != 0) goto L23;
        boolean r6 = true;
    L24:
        if (r6 == false) goto L26;
        r3 = "res://" + AppHost.a.getApplication().getPackageName() + "/2131240119";
    L26:
        n3 r8 = a(r1, r3, r18, r4, r5, r4.j, r7);
        Intrinsics.checkNotNullParameter(r8, "notificationRequest");
        if (d3.a.c(r8) == false) goto L31;
        if (r7 == null) goto L30;
        r7.h();
    L30:
        r12 = true;
        goto L31
    L23:
        r6 = false;
        goto L24
    L17:
        r3 = null;
    L31:
        r10.d("DefaultIMFeedbackManager", "showPopupNow: showNotification result = " + r12);
        if (r12 == false) goto L35;
        Integer r9 = r18.c;
        String r11 = r13.b();
        long r14 = System.currentTimeMillis();
        Map r15 = MapsKt.createMapBuilder();
        r15.put("message_id", r18.b);
        r15.put("section_id", this.d);
        r15.put("conversation_id", r18.a);
        Unit r16 = Unit.INSTANCE;
        j r17 = new j(r9, r11, r14, MapsKt.build(r15));
        Intrinsics.checkNotNullParameter(r17, "request");
        this.a.c(r17);
        t99.a.c(r18.d, null, r18.b, (JSONObject) this.b.p.invoke("feedback_popup_show", r18), 18);
        return;
    }

    public DefaultIMFeedbackManager(i r2, FlowFeedbackRemoteGateway r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "remoteGateway");
        super(r3);
        this.b = r2;
        this.d = r2.a();
    }

    @Override // p99.c
    public final void b(q99.e r8, i r9) {
        Intrinsics.checkNotNullParameter(r8, "delivery");
        Intrinsics.checkNotNullParameter(r9, "host");
        super.b(r8, r9);
        t99.a.b(r8.d, null, r8.b, "dislike", (JSONObject) r9.p.invoke("feedback_popup_click", r8), 34);
    }

    @Override // p99.c
    public final void c(q99.e r8, i r9) {
        Intrinsics.checkNotNullParameter(r8, "delivery");
        Intrinsics.checkNotNullParameter(r9, "host");
        super.c(r8, r9);
        t99.a.b(r8.d, null, r8.b, "like", (JSONObject) r9.p.invoke("feedback_popup_click", r8), 34);
    }

    public final void l(boolean r5, String r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("clearPending: reason = ");
        r1.append(r6);
        r1.append(", hasTimer = ");
        if (this.f == null) goto L5;
        boolean r7 = true;
    L6:
        r1.append(r7);
        r1.append(", pendingPhase = ");
        b r8 = this.c;
        if (r8 == null) goto L9;
        PendingPhase r9 = r8.b;
    L10:
        r1.append(r9);
        r1.append(", messageId = ");
        b r10 = this.c;
        if (r10 == null) goto L15;
        q99.e r11 = r10.a;
        if (r11 == null) goto L15;
        String r12 = r11.b;
    L16:
        r1.append(r12);
        r1.append(", sectionId = ");
        b r13 = this.c;
        if (r13 == null) goto L23;
        q99.e r14 = r13.a;
        if (r14 == null) goto L23;
        q99.d r15 = r14.f;
        if (r15 == null) goto L23;
        String r16 = r15.h();
    L24:
        r1.append(r16);
        r1.append(", resetShownState = ");
        r1.append(r5);
        r0.d("DefaultIMFeedbackManager", r1.toString());
        d r17 = this.f;
        if (r17 == null) goto L27;
        t0.a.removeCallbacks(r17);
    L27:
        this.f = null;
        this.c = null;
        if (r5 == false) goto L31;
        this.e = false;
        return;
    L31:
        return;
    L23:
        r16 = null;
    L15:
        r12 = null;
        goto L16
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.larus.feedback.impl.manager.d, java.lang.Runnable] */
    public final void m(q99.e r7, q99.d r8) {
        FLogger r0 = FLogger.a;
        r0.d("DefaultIMFeedbackManager", "dispatchReady: delivery = " + r7 + ", model = " + r8);
        Integer r1 = r8.c();
        if (r1 != null) goto L6;
    L13:
        String r2 = r8.h();
        if (r2 != null) goto L16;
        r2 = this.d;
    L16:
        this.d = r2;
        if (r8.c() != null) goto L20;
        r0.d("DefaultIMFeedbackManager", "dispatchReady: no-op, feedbackScene = null");
        return;
    L20:
        Integer r9 = r8.c();
        if (r9 != null) goto L24;
    L46:
        p(r7);
        return;
    L24:
        if (r9.intValue() != 7) goto L46;
        l(false, "dispatch_ready_section_interact");
        this.c = new b(r7, PendingPhase.WAIT_PAUSE_TIMEOUT);
        d r10 = this.f;
        if (r10 == null) goto L28;
        r0.d("DefaultIMFeedbackManager", "startPauseTimer: replace existing timer");
        t0.a.removeCallbacks(r10);
    L28:
        b r11 = this.c;
        StringBuilder r12 = new StringBuilder("startPauseTimer: schedule 10000ms, phase = ");
        String r3 = null;
        if (r11 == null) goto L31;
        PendingPhase r4 = r11.b;
    L32:
        r12.append(r4);
        r12.append(", messageId = ");
        if (r11 == null) goto L37;
        q99.e r5 = r11.a;
        if (r5 == null) goto L37;
        String r6 = r5.b;
    L38:
        r12.append(r6);
        r12.append(", sectionId = ");
        if (r11 == null) goto L45;
        q99.e r13 = r11.a;
        if (r13 == null) goto L45;
        q99.d r14 = r13.f;
        if (r14 == null) goto L45;
        r3 = r14.h();
    L45:
        r12.append(r3);
        r0.d("DefaultIMFeedbackManager", r12.toString());
        ?? r15 = new d(this);
        t0.a.postDelayed(r15, 10000);
        this.f = r15;
        return;
    L37:
        r6 = null;
        goto L38
    L31:
        r4 = null;
        goto L32
    L6:
        if (r1.intValue() != 7) goto L13;
        if (this.e == false) goto L13;
        if (Intrinsics.areEqual(this.d, r8.h()) == false) goto L13;
        r0.d("DefaultIMFeedbackManager", "handleResolvedDelivery: no-op, hasShownInCurrentSection = " + this.e + ", currentSectionId = " + this.d + ", sectionId = " + r8.h());
    }

    public final void o(q99.e r5, q99.d r6) {
        FLogger r0 = FLogger.a;
        r0.d("DefaultIMFeedbackManager", "handleResolvedDelivery: delivery = " + r5 + ", model = " + r6);
        if (Intrinsics.areEqual(r6.f(), Boolean.TRUE) == true) goto L5;
    L15:
        r0.d("DefaultIMFeedbackManager", "handleResolvedDelivery: no-op, needShow = " + r6.f() + ", isActive = " + this.b.b());
        return;
    L5:
        if (this.b.b() == false) goto L15;
        String r1 = r5.b;
        if (r1 != null) goto L10;
        r1 = r6.e();
    L10:
        q99.e r7 = q99.e.a(r5, null, r1, null, 125);
        if (r1 != null) goto L13;
        m(r7, r6);
        return;
    L13:
        com.larus.im.d.e().m(r1, new c(this, r7, r6));
    }

    @Override // p99.c
    public final void d(q99.e r2, i r3, q99.a r4) {
        Intrinsics.checkNotNullParameter(r2, "delivery");
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "result");
        t99.a.a(r2.d, (JSONObject) r3.p.invoke("complete_dislike_reason", r2));
    }
}
