package wg8;

import android.app.Application;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.adapter.h0;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.api.d0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.api.z;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRegenForImmerseSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightStubRegenForImmerseSlotCell;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.showcase.x;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.instruction.g;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.MarkDownSelectorSettings;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import dg8.t;
import ic8.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import t19.s;
import va8.a0;
import va8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final /* synthetic */ int k = 0;
    public BaseMessageListCell<?> a;
    public i b;
    public boolean c;
    public boolean d;
    public Message e;
    public final z f;
    public final Lazy g;
    public long h;
    public long i;
    public final b j;

    public static final class a {
    }

    public static final class b implements Runnable {
        public int a;
        public CustomMarkdownTextView b;
        public final /* synthetic */ c c;

        public final void a() {
            int r1 = this.a;
            boolean r3 = true;
            if (r1 != 1) goto L159;
            c r2 = this.c;
            r2.getClass();
            FLogger r4 = FLogger.a;
            StringBuilder r5 = new StringBuilder("performSingleClick, msg:");
            Message r6 = r2.e;
            if (r6 == null) goto L7;
            String r7 = r6.getMessageId();
        L8:
            r5.append(r7);
            r4.i("MiddleTextComponent", r5.toString());
            BaseMessageListCell<?> r8 = r2.a;
            if (r8 == null) goto L13;
            Fragment r9 = lf8.a.d(r8);
            if (r9 == null) goto L13;
            t1a.b r10 = s1a.a.g(r9);
        L14:
            if (r10 == null) goto L16;
            y r11 = (y) r10.getAbility(y.class);
        L17:
            if (r10 == null) goto L19;
            f1 r12 = (f1) r10.getAbility(f1.class);
        L20:
            if (r10 == null) goto L22;
            g r13 = (g) r10.getAbility(g.class);
        L23:
            if (r10 == null) goto L25;
            u7 r14 = (u7) r10.getAbility(u7.class);
        L26:
            if (r10 == null) goto L28;
            o r15 = (o) r10.getAbility(o.class);
        L29:
            if (r10 == null) goto L31;
            x r16 = (x) r10.getAbility(x.class);
        L32:
            if (r10 == null) goto L34;
            xa8.d r17 = (xa8.d) r10.getAbility(xa8.d.class);
        L35:
            Message r18 = r2.e;
            if (r18 == null) goto L169;
            if (r12 == null) goto L41;
            r12.Ro();
        L41:
            if (com.larus.bmhome.chat.bean.d.G0(r18) == false) goto L117;
            if (t.h(r11) == true) goto L117;
            Intrinsics.checkNotNullParameter(r18, "<this>");
            Map r19 = r18.getExt();
            if (r19 == null) goto L47;
            String r20 = (String) r19.get("action_bar_key");
        L49:
            if (Intrinsics.areEqual(r20, "coco_record") == true) goto L117;
            IFlowSdkDepend r21 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r21 == null) goto L59;
            r21.P();
            Fragment r22 = ChatServiceImpl.a.f();
            if (r22 == null) goto L59;
            l r23 = s1a.a.g(r22).getAbility(l.class);
            if (r23 == null) goto L59;
            if (r23.Lo() != true) goto L59;
            boolean r24 = true;
        L60:
            if (r24 == false) goto L62;
            s r25 = s.a;
            Application r26 = FlowRuntime.a().getApplication();
            r25.getClass();
            s.s(r26, 2131911054);
            goto L169
        L62:
            BaseMessageListCell<?> r27 = r2.a;
            if (r27 == null) goto L65;
            q0 r28 = lf8.a.b(r27);
        L66:
            if (r11 == null) goto L68;
            wc9.e r29 = r11.h();
        L69:
            BaseMessageListCell<?> r110 = r2.a;
            if (r110 == null) goto L76;
            Fragment r111 = lf8.a.d(r110);
            if (r111 == null) goto L76;
            t1a.b r112 = s1a.a.g(r111);
            if (r112 == null) goto L76;
            ss8.g r30 = (ss8.g) r112.getAbility(ss8.g.class);
        L77:
            if (r14 != null) goto L79;
        L81:
            boolean r113 = false;
        L82:
            if (r113 == false) goto L117;
            if (r29 != null) goto L85;
        L87:
            boolean r31 = false;
        L88:
            if (r31 == false) goto L117;
            if (r30 != null) goto L91;
        L93:
            boolean r32 = false;
        L94:
            if (r32 == true) goto L117;
            if (r28 == null) goto L97;
            String r33 = r28.W();
        L98:
            if (r13 == null) goto L100;
            List r34 = r13.tq();
        L101:
            if (r15 == null) goto L103;
            Boolean r114 = Boolean.valueOf(r15.i0());
        L104:
            if (r16 == null) goto L106;
            Boolean r115 = Boolean.valueOf(r16.e6());
        L108:
            if (h0.f(r18, r33, r34, r114, r115) == true) goto L110;
        L115:
            r2.f(r18);
            goto L117
        L110:
            if (com.larus.bmhome.chat.bean.d.P0(r18) == true) goto L115;
            if (r28 == null) goto L117;
            Function4<q0, Message, Integer, Boolean, Unit> r35 = r28.K7();
            if (r35 == null) goto L117;
            r35.invoke(r28, r18, 1, Boolean.FALSE);
            goto L117
        L106:
            r115 = null;
            goto L108
        L103:
            r114 = null;
            goto L104
        L100:
            r34 = null;
            goto L101
        L97:
            r33 = null;
            goto L98
        L91:
            if (r30.bc(ChatUIBlockConfig.DISABLE_MESSAGE_INTERACTION) != true) goto L93;
            r32 = true;
            goto L94
        L85:
            if (r29.h() == true) goto L87;
            r31 = true;
            goto L88
        L79:
            if (r14.W1() == true) goto L81;
            r113 = true;
        L76:
            r30 = null;
            goto L77
        L68:
            r29 = null;
            goto L69
        L65:
            r28 = null;
        L59:
            r24 = false;
            goto L60
        L47:
            r20 = null;
        L117:
            if (com.larus.bmhome.chat.bean.d.G0(r18) == true) goto L169;
            if (r2.c == true) goto L131;
            IObricContinuousTalkService r36 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
            if (r36 != null) goto L123;
        L125:
            boolean r37 = false;
        L126:
            r4.i("MiddleTextComponent", "tryInterruptContinuousTts, messageId=" + r18.getMessageId() + ", replyId=" + r18.getReplyId() + ", interrupted=" + r37);
            if (r37 == false) goto L131;
            if (r17 == null) goto L169;
            r17.ZM("interrupted");
            goto L169
        L123:
            if (r36.e(r18.getMessageId()) != true) goto L125;
            r37 = true;
        L131:
            if (r18.getContentType() != 1) goto L133;
        L147:
            IChatRepoService r38 = zh8.a.a;
            if (Intrinsics.areEqual(r18.getMessageId(), r38.x1().c().o6()) == true) goto L150;
        L157:
            r2.f(r18);
            goto L169
        L150:
            if (r2.c == true) goto L157;
            r38.getReceiver().c().i6("TextCell txt performSingleClick", true);
            if (r17 == null) goto L154;
            r17.ZM("interrupted");
        L154:
            IObricContinuousTalkService r39 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
            if (r39 == null) goto L157;
            r39.b();
            goto L157
        L133:
            if (r18.getContentType() == 9999) goto L147;
            if (com.larus.bmhome.chat.bean.d.x0(r18) == false) goto L157;
            IChatRepoService r40 = zh8.a.a;
            if (Intrinsics.areEqual(r18.getMessageId(), r40.getReceiver().c().q6()) == false) goto L157;
            if (r2.c == true) goto L157;
            r40.getReceiver().c().i6("TextCell multiContent performSingleClick", true);
            if (r17 == null) goto L144;
            r17.ZM("interrupted");
        L144:
            IObricContinuousTalkService r41 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
            if (r41 == null) goto L157;
            r41.b();
        L169:
            this.a = 0;
            return;
        L34:
            r17 = null;
            goto L35
        L31:
            r16 = null;
            goto L32
        L28:
            r15 = null;
            goto L29
        L25:
            r14 = null;
            goto L26
        L22:
            r13 = null;
            goto L23
        L19:
            r12 = null;
            goto L20
        L16:
            r11 = null;
        L13:
            r10 = null;
            goto L14
        L7:
            r7 = null;
            goto L8
        L159:
            if (r1 != 2) goto L162;
            this.c.h = SystemClock.elapsedRealtime();
            this.c.b(this.b, false);
            goto L169
        L162:
            if (r1 != 3) goto L169;
            if (((MarkDownSelectorSettings) this.c.g.getValue()).getTripleClickStrategy() > 0) goto L167;
            r3 = false;
        L167:
            if (r3 == false) goto L169;
            this.c.i = SystemClock.elapsedRealtime();
            c.d(this.c, this.b);
            goto L169
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

        public b(c r1) {
            this.c = r1;
        }
    }

    /* JADX INFO: renamed from: wg8.c$c, reason: collision with other inner class name */
    public static final class C0093c implements d0 {
        public final /* synthetic */ CustomMarkdownTextView a;
        public final /* synthetic */ c b;

        public C0093c(CustomMarkdownTextView r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void a(final View r4, int r5, int r6) {
            if (Intrinsics.areEqual(r4, this.a) == true) goto L5;
            return;
        L5:
            if ((r4 instanceof CustomMarkdownTextView) == true) goto L8;
            return;
        L8:
            if (r6 == 2) goto L10;
            return;
        L10:
            if (((MarkDownSelectorSettings) this.b.g.getValue()).getDoubleClickShiftStrategy() <= 0) goto L12;
            boolean r7 = true;
        L13:
            if (r7 == false) goto L18;
            final c r8 = this.b;
            ((CustomMarkdownTextView) r4).postDelayed(new d(r8, r4), 100);
            return;
        L18:
            return;
        L12:
            r7 = false;
            goto L13
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void b(SelectionRangeType r1, int r2, int r3, boolean r4, boolean r5, Rect r6, String r7) {
            d0.a.a(r1, r7);
        }
    }

    static {
    }

    public final void e() {
        b r0 = this.j;
        r0.a = 0;
        i r1 = this.b;
        if (r1 == null) goto L6;
        r1.removeCallbacks(r0);
        return;
    }

    public c() {
        this.f = ILegacyChatUiServiceDelegate.b.F8();
        this.g = LazyKt.lazy(new wg8.a());
        this.j = new b(this);
    }

    public final void f(Message r8) {
        boolean r3 = true;
        if (SetsKt.setOf(new Integer[]{22, 12}).contains(Integer.valueOf(r8.getMessageStatusLocal())) == false) goto L94;
        BaseMessageListCell<?> r0 = this.a;
        wc9.e r4 = null;
        if (r0 == null) goto L46;
        List r1 = r0.c;
        if (r1 == null) goto L46;
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Object r5 = r2.next();
        if ((((BaseMessageSlotCell) r5) instanceof MessageInboxRightRegenForImmerseSlotCell) == false) goto L10;
    L15:
        BaseMessageSlotCell r6 = (BaseMessageSlotCell) r5;
        if (r6 == null) goto L46;
        if ((r6 instanceof MessageInboxRightRegenForImmerseSlotCell) == false) goto L20;
        MessageInboxRightRegenForImmerseSlotCell r7 = (MessageInboxRightRegenForImmerseSlotCell) r6;
    L21:
        if (r7 == null) goto L46;
        Intrinsics.checkNotNullParameter(r8, "data");
        p r9 = r7.m();
        if (r9 != null) goto L25;
    L27:
        boolean r10 = false;
    L28:
        a0 r11 = r7.r();
        if (r11 == null) goto L31;
        wc9.e r12 = r11.h();
    L32:
        if (r10 == true) goto L46;
        if (r12 != null) goto L35;
    L37:
        boolean r13 = false;
    L38:
        if (r13 == false) goto L46;
        p r14 = r7.m();
        if (r14 == null) goto L43;
        r14.O5(false);
    L43:
        va8.s r15 = (va8.s) r7.h.getValue();
        if (r15 == null) goto L46;
        r15.h40(r8);
        goto L46
    L35:
        if (r12.h() == true) goto L37;
        r13 = true;
        goto L38
    L31:
        r12 = null;
        goto L32
    L25:
        if (r9.W1() != true) goto L27;
        r10 = true;
        goto L28
    L20:
        r7 = null;
        goto L21
    L14:
        r5 = null;
    L46:
        BaseMessageListCell<?> r16 = this.a;
        if (r16 == null) goto L95;
        List r17 = r16.c;
        if (r17 == null) goto L96;
        Iterator r18 = r17.iterator();
    L52:
        if (r18.hasNext() == false) goto L56;
        Object r19 = r18.next();
        if ((((BaseMessageSlotCell) r19) instanceof MessageInboxRightStubRegenForImmerseSlotCell) == false) goto L52;
    L57:
        BaseMessageSlotCell r20 = (BaseMessageSlotCell) r19;
        if (r20 != null) goto L60;
        return;
    L60:
        if ((r20 instanceof MessageInboxRightStubRegenForImmerseSlotCell) == false) goto L62;
        MessageInboxRightStubRegenForImmerseSlotCell r21 = (MessageInboxRightStubRegenForImmerseSlotCell) r20;
    L63:
        if (r21 == null) goto L98;
        Intrinsics.checkNotNullParameter(r8, "data");
        p r22 = r21.m();
        if (r22 != null) goto L67;
    L69:
        boolean r23 = false;
    L70:
        a0 r24 = r21.r();
        if (r24 == null) goto L73;
        r4 = r24.h();
    L73:
        if (r23 == true) goto L99;
        if (r4 != null) goto L76;
    L78:
        r3 = false;
    L79:
        if (r3 == false) goto L101;
        p r25 = r21.m();
        if (r25 == null) goto L84;
        r25.O5(false);
    L84:
        va8.s r26 = (va8.s) r21.h.getValue();
        if (r26 == null) goto L100;
        r26.h40(r8);
        return;
    L100:
        return;
    L101:
        return;
    L76:
        if (r4.h() == true) goto L78;
    L99:
        return;
    L67:
        if (r22.W1() != true) goto L69;
        r23 = true;
        goto L70
    L98:
        return;
    L62:
        r21 = null;
        goto L63
    L56:
        r19 = null;
        goto L57
    L96:
        return;
    L95:
        return;
    }

    public static void d(c r4, CustomMarkdownTextView r5) {
        r4.getClass();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("performTripleClick, msg:");
        Message r2 = r4.e;
        if (r2 == null) goto L5;
        String r3 = r2.getMessageId();
    L6:
        r1.append(r3);
        r1.append(", isReClick:");
        r1.append(false);
        r0.i("MiddleTextComponent", r1.toString());
        r4.c(r5, "triple_click_text", 3, false);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void b(CustomMarkdownTextView r4, boolean r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("performDoubleClick, msg:");
        Message r2 = this.e;
        if (r2 == null) goto L5;
        String r3 = r2.getMessageId();
    L6:
        r1.append(r3);
        r1.append(", isReClick:");
        r1.append(r5);
        r0.i("MiddleTextComponent", r1.toString());
        c(r4, "double_click_text", 2, r5);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void a(Message r9, CustomMarkdownTextView r10, long r11) {
        boolean r1 = false;
        if (this.d == false) goto L6;
        this.d = false;
        return;
    L6:
        long r2 = SystemClock.elapsedRealtime();
        if ((r2 - this.i) > 300) goto L9;
        return;
    L9:
        this.e = r9;
        if ((SystemClock.elapsedRealtime() - r11) >= 100) goto L12;
        boolean r12 = true;
    L13:
        this.c = r12;
        if ((r2 - this.h) <= 300) goto L16;
    L22:
        b r13 = this.j;
        int r14 = r13.a + 1;
        r13.a = r14;
        r13.b = r10;
        if (r14 != 1) goto L25;
        r1 = true;
    L25:
        if (r1 == false) goto L30;
        i r15 = this.b;
        if (r15 == null) goto L31;
        r15.postDelayed(r13, 300);
        return;
    L31:
        return;
    L30:
        return;
    L16:
        if (((MarkDownSelectorSettings) this.g.getValue()).getTripleClickStrategy() <= 0) goto L18;
        boolean r16 = true;
    L19:
        if (r16 == false) goto L22;
        d(this, r10);
        this.i = r2;
        return;
    L18:
        r16 = false;
        goto L19
    L12:
        r12 = false;
        goto L13
    }

    public final void c(CustomMarkdownTextView r11, String r12, int r13, boolean r14) {
        BaseMessageListCell<?> r0 = this.a;
        q0 r1 = null;
        if (r0 == null) goto L7;
        Fragment r2 = lf8.a.d(r0);
        if (r2 == null) goto L7;
        t1a.b r3 = s1a.a.g(r2);
    L8:
        if (r3 == null) goto L10;
        f1 r4 = (f1) r3.getAbility(f1.class);
    L11:
        BaseMessageListCell<?> r5 = this.a;
        if (r5 == null) goto L14;
        r1 = lf8.a.b(r5);
    L14:
        if (r11 != null) goto L16;
        return;
    L16:
        Message r6 = this.e;
        if (r6 != null) goto L19;
        return;
    L19:
        if (r4 == null) goto L21;
        r4.Ro();
    L21:
        if (r1 == null) goto L26;
        z r7 = this.f;
        if (r7 == null) goto L27;
        Message r8 = t.c(r6);
        int r9 = od8.h0.a;
        z.a.b(r7, r1, r11, r8, !CollectionsKt.contains(CollectionsKt.arrayListOf(new Integer[]{14, 29, 12, 13}), j.b(r6)), r12, r13, r14, new C0093c(r11, this), 32);
        return;
    L27:
        return;
    L26:
        return;
    L10:
        r4 = null;
    L7:
        r3 = null;
        goto L8
    }
}
