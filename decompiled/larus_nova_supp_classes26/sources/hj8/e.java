package hj8;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cotdetail.CotDetailDialogFragment;
import com.larus.bmhome.chat.cotdetail.CotDetailFragment;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.ClarificationAnswerDetailFragment;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.FloatingThinkDetailRootFragment;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.g;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolView;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolViewStage;
import com.larus.bmhome.clarification.b2;
import com.larus.bmhome.clarification.i2;
import com.larus.bmhome.interactionpanel.w;
import com.larus.bmhome.interactionpanel.x;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.InteractionAskBlock;
import com.larus.im.bean.message.block.InteractionAskContent;
import com.larus.im.bean.message.block.InteractionAskIcon;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import gj8.f;
import java.util.List;
import kc8.y;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends jc8.b<hj8.a> {
    public f d;

    public static final class a implements jj8.b {
        public final Message a;
        public final Block b;
        public final ChatParam c;
        public final Function0<kc8.b> d;
        public final Function0<Unit> e;

        public final w c() {
            Message r0 = this.a;
            if (r0 == null) goto L6;
            w r1 = x.b(r0, this.b);
            if (r1 == null) goto L6;
            return r1;
        L6:
            kc8.b r2 = (kc8.b) this.d.invoke();
            if (r2 == null) goto L11;
            y r3 = r2.a;
            if (r3 == null) goto L11;
            Fragment r4 = r3.a;
        L13:
            if ((r4 instanceof fe8.a) == false) goto L15;
            fe8.a r5 = (fe8.a) r4;
        L16:
            if (r5 == null) goto L19;
            return r5.vF();
        L19:
            return null;
        L15:
            r5 = null;
        L11:
            r4 = null;
            goto L13
        }

        @Override // jj8.b
        public final void a(InteractionAskBlock r12) {
            Message r0 = null;
            if (r12 == null) goto L5;
            String r1 = r12.getClarifyId();
        L6:
            Message r2 = this.a;
            if (r2 == null) goto L9;
            String r3 = r2.getMessageId();
        L10:
            Message r4 = this.a;
            if (r4 == null) goto L13;
            String r5 = r4.getReplyId();
        L14:
            Message r6 = this.a;
            if (r6 == null) goto L17;
            String r7 = r6.getConversationId();
        L18:
            ChatParam r8 = this.c;
            if (r8 == null) goto L21;
            String r9 = r8.d;
        L22:
            if (r8 == null) goto L24;
            String r10 = r8.c;
        L25:
            if (r8 == null) goto L27;
            String r11 = r8.e;
        L28:
            w r13 = c();
            JSONObject r14 = new JSONObject();
            Intrinsics.checkNotNullParameter(r14, "params");
            if (r1 != null) goto L95;
        L33:
            if (r3 == null) goto L35;
            r14.put(MusicAppletPage.KEY_MESSAGE_ID, r3);     // Catch: JSONException -> L31
        L35:
            if (r5 == null) goto L37;
            r14.put("reply_id", r5);     // Catch: JSONException -> L31
        L37:
            if (r7 == null) goto L39;
            r14.put(MusicAppletPage.KEY_CONVERSATION_ID, r7);     // Catch: JSONException -> L31
        L39:
            if (r9 == null) goto L41;
            r14.put("current_page", r9);     // Catch: JSONException -> L31
        L41:
            if (r10 == null) goto L43;
            r14.put("previous_page", r10);     // Catch: JSONException -> L31
        L43:
            if (r11 == null) goto L45;
            r14.put("chat_type", r11);     // Catch: JSONException -> L31
        L45:
            r14.put("card_type", "clarify");     // Catch: JSONException -> L31
            x.a(r14, r13);     // Catch: JSONException -> L31
        L48:
            i2.a("click_card", r14, null);
            kc8.b r15 = (kc8.b) this.d.invoke();
            if (r15 == null) goto L53;
            y r16 = r15.a;
            if (r16 == null) goto L53;
            Fragment r17 = r16.a;
        L55:
            if ((r17 instanceof FloatingThinkDetailRootFragment) == false) goto L57;
            FloatingThinkDetailRootFragment r18 = (FloatingThinkDetailRootFragment) r17;
        L59:
            if (r18 == null) goto L77;
            if (r18.isAdded() == false) goto L97;
            if (r12 != null) goto L65;
            return;
        L65:
            if (r18.getChildFragmentManager().findFragmentByTag("ClarificationAnswerDetailFragment") != null) goto L99;
            FragmentTransaction r19 = r18.getChildFragmentManager().beginTransaction();
            r19.setCustomAnimations(2130772410, 2130772411, 2130772409, 2130772412);
            InteractionAskBlock r20 = ClarificationAnswerDetailFragment.j;
            y r21 = r18.e;
            g r22 = r18.d;
            if (r22 == null) goto L70;
            r0 = r22.j();
        L70:
            ClarificationAnswerDetailFragment r110 = ClarificationAnswerDetailFragment.c.a(r12, r21, r0);
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r19, r110, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "ClarificationAnswerDetailFragment", 2131368894) == true) goto L74;
            r19.replace(2131368894, r110, "ClarificationAnswerDetailFragment");
        L74:
            r19.addToBackStack("floating_think_child_page");
            r19.commitAllowingStateLoss();
            r18.g.setEnabled(true);
            return;
        L99:
            return;
        L97:
            return;
        L77:
            if ((r17 instanceof CotDetailFragment) == false) goto L79;
            CotDetailFragment r23 = (CotDetailFragment) r17;
        L80:
            if (r23 == null) goto L93;
            Message r24 = this.a;
            if (r12 == null) goto L101;
            Message r25 = r23.getParentFragment();
            if ((r25 instanceof CotDetailDialogFragment) == false) goto L87;
            r0 = (CotDetailDialogFragment) r25;
        L87:
            if (r0 == null) goto L100;
            y r26 = r23.g;
            Intrinsics.checkNotNullParameter(r12, "interactionAskBlock");
            if (r0.getChildFragmentManager().findFragmentByTag("ClarificationAnswerDetailFragment") != null) goto L102;
            InteractionAskBlock r27 = ClarificationAnswerDetailFragment.j;
            r0.X90(ClarificationAnswerDetailFragment.c.a(r12, r26, r24), "ClarificationAnswerDetailFragment");
            return;
        L102:
            return;
        L100:
            return;
        L101:
            return;
        L93:
            this.e.invoke();
            return;
        L79:
            r23 = null;
            goto L80
        L57:
            r18 = null;
        L53:
            r17 = null;
        L31:
            e = move-exception;
            FLogger.a.e("ClarificationTracer", "error in ClarificationTracer mobClarificationCardClick " + e.getLocalizedMessage());
            goto L48
        L95:
            r14.put("clarify_id", r1);     // Catch: JSONException -> L31
            goto L33
        L27:
            r11 = null;
            goto L28
        L24:
            r10 = null;
            goto L25
        L21:
            r9 = null;
            goto L22
        L17:
            r7 = null;
            goto L18
        L13:
            r5 = null;
            goto L14
        L9:
            r3 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }

        @Override // jj8.b
        public final void b(InteractionAskBlock r12) {
            if (r12 == null) goto L5;
            String r1 = r12.getClarifyId();
        L6:
            Message r2 = this.a;
            if (r2 == null) goto L9;
            String r3 = r2.getMessageId();
        L10:
            Message r4 = this.a;
            if (r4 == null) goto L13;
            String r5 = r4.getReplyId();
        L14:
            Message r6 = this.a;
            if (r6 == null) goto L17;
            String r7 = r6.getConversationId();
        L18:
            if (r12 == null) goto L20;
            List r13 = r12.getQuestions();
        L21:
            if (r13 != null) goto L23;
            r13 = CollectionsKt.emptyList();
        L23:
            Integer r14 = Integer.valueOf(r13.size());
            ChatParam r8 = this.c;
            if (r8 == null) goto L26;
            String r9 = r8.d;
        L27:
            if (r8 == null) goto L29;
            String r10 = r8.c;
        L30:
            if (r8 == null) goto L32;
            String r11 = r8.e;
        L33:
            w r15 = c();
            JSONObject r16 = new JSONObject();
            Intrinsics.checkNotNullParameter(r16, "params");
            if (r1 != null) goto L57;
        L38:
            if (r3 == null) goto L40;
            r16.put(MusicAppletPage.KEY_MESSAGE_ID, r3);     // Catch: JSONException -> L36
        L40:
            if (r5 == null) goto L42;
            r16.put("reply_id", r5);     // Catch: JSONException -> L36
        L42:
            if (r7 == null) goto L44;
            r16.put(MusicAppletPage.KEY_CONVERSATION_ID, r7);     // Catch: JSONException -> L36
        L44:
            if (r14 == null) goto L46;
            r16.put("question_cnt", r14.intValue());     // Catch: JSONException -> L36
        L46:
            if (r9 == null) goto L48;
            r16.put("current_page", r9);     // Catch: JSONException -> L36
        L48:
            if (r10 == null) goto L50;
            r16.put("previous_page", r10);     // Catch: JSONException -> L36
        L50:
            if (r11 == null) goto L52;
            r16.put("chat_type", r11);     // Catch: JSONException -> L36
        L52:
            r16.put("card_type", "clarify");     // Catch: JSONException -> L36
            x.a(r16, r15);     // Catch: JSONException -> L36
        L55:
            i2.a("show_card", r16, null);
            return;
        L36:
            e = move-exception;
            FLogger.a.e("ClarificationTracer", "error in ClarificationTracer mobClarificationCardShow " + e.getLocalizedMessage());
            goto L55
        L57:
            r16.put("clarify_id", r1);     // Catch: JSONException -> L36
            goto L38
        L32:
            r11 = null;
            goto L33
        L29:
            r10 = null;
            goto L30
        L26:
            r9 = null;
            goto L27
        L20:
            r13 = null;
            goto L21
        L17:
            r7 = null;
            goto L18
        L13:
            r5 = null;
            goto L14
        L9:
            r3 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }

        public a(Message r2, Block r3, ChatParam r4, c r5, d r6) {
            Intrinsics.checkNotNullParameter(r5, "blockDependConfigProvider");
            Intrinsics.checkNotNullParameter(r6, "openFallbackDetail");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public final String c() {
        return "InteractionAskCotTipBlockHolder";
    }

    public e() {
    }

    public final jc8.d f(jc8.a r2) {
        hj8.a r3 = (hj8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [hj8.c] */
    /* JADX WARN: Type inference failed for: r8v0, types: [hj8.d] */
    public final void g(jc8.a r28) {
        final hj8.a r1 = (hj8.a) r28;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        kc8.b r2 = jc8.c.a(this, kc8.b.class);
        Message r4 = r1.j();
        Block r5 = ((jc8.a) r1).a;
        Function0 r10 = null;
        if (r2 == null) goto L9;
        y r3 = r2.a;
        if (r3 == null) goto L9;
        Function0 r6 = r3.m;
        if (r6 == null) goto L9;
        ChatParam r7 = (ChatParam) r6.invoke();
    L10:
        a r9 = new a(r4, r5, r7, new c(this), new d(this, r1));
        f r8 = this.d;
        if (r8 == null) goto L81;
        InteractionAskBlock r11 = r1.i;
        if (r2 == null) goto L17;
        kc8.x r12 = r2.i;
        if (r12 == null) goto L17;
        Integer r13 = r12.a;
    L18:
        jj8.a r14 = new jj8.a(r11, r13);
        Intrinsics.checkNotNullParameter(r14, "vmData");
        jj8.e r15 = (jj8.e) r8.b.getValue();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "vmData");
        r15.a = r14;
        r15.b = r9;
        jj8.e r16 = (jj8.e) r8.b.getValue();
        jj8.a r17 = r16.a;
        if (r17 == null) goto L21;
        InteractionAskBlock r18 = r17.a;
    L22:
        if (r18 == null) goto L24;
        Integer r19 = r18.getStatus();
    L25:
        if (r18 == null) goto L29;
        InteractionAskContent r20 = r18.getThinkingContent();
        if (r20 == null) goto L29;
        String r110 = r20.getProcessingStatusText();
    L30:
        if (r18 == null) goto L36;
        InteractionAskContent r21 = r18.getThinkingContent();
        if (r21 == null) goto L36;
        InteractionAskIcon r22 = r21.getIcon();
        if (r22 == null) goto L36;
        String r111 = r22.getUrlLight();
    L37:
        if (r18 == null) goto L43;
        InteractionAskContent r23 = r18.getThinkingContent();
        if (r23 == null) goto L43;
        InteractionAskIcon r24 = r23.getIcon();
        if (r24 == null) goto L43;
        String r112 = r24.getUrlDark();
    L44:
        int r25 = b2.b;
        if (r19 != null) goto L48;
    L50:
        GenericToolViewStage r26 = GenericToolViewStage.FINISHED;
    L51:
        GenericToolViewStage r113 = r26;
        jj8.a r27 = r16.a;
        if (r27 == null) goto L54;
        Integer r114 = r27.b;
    L55:
        if (r27 == null) goto L61;
        InteractionAskBlock r29 = r27.a;
        if (r29 == null) goto L61;
        Integer r30 = r29.getStatus();
        if (r30 == null) goto L61;
        int r31 = r30.intValue();
    L62:
        boolean r32 = false;
        if (r31 <= r25) goto L65;
        boolean r210 = true;
    L66:
        jl8.f r33 = new jl8.f(r111, r112, r110, r113, null, null, 0, r114, r210, false, false, 0, 0, 0, 15984);
        final jj8.e r34 = (jj8.e) r8.b.getValue();
        final jj8.a r35 = r34.a;
        if (r35 == null) goto L73;
        InteractionAskBlock r36 = r35.a;
        if (r36 == null) goto L73;
        Integer r37 = r36.getStatus();
        if (r37 == null) goto L73;
        int r38 = r37.intValue();
    L74:
        if (r38 <= r25) goto L76;
        r32 = true;
    L76:
        Function0 r39 = new jj8.c(r35, r34);
        if (r32 == false) goto L79;
        r10 = new jj8.d(r35, r34);
    L79:
        ((GenericToolView) r8.a.getValue()).a(r33, new jl8.g(r39, r10));
        return;
    L73:
        r38 = b2.a;
        goto L74
    L65:
        r210 = false;
    L61:
        r31 = b2.a;
        goto L62
    L54:
        r114 = null;
        goto L55
    L48:
        if (r19.intValue() != r25) goto L50;
        r26 = GenericToolViewStage.LOADING;
    L43:
        r112 = null;
    L36:
        r111 = null;
    L29:
        r110 = null;
        goto L30
    L24:
        r19 = null;
        goto L25
    L21:
        r18 = null;
    L17:
        r13 = null;
        goto L18
    L81:
        return;
    L9:
        r7 = null;
        goto L10
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        f r0 = new f(r2.getContext());
        this.d = r0;
        return (GenericToolView) r0.a.getValue();
    }
}
