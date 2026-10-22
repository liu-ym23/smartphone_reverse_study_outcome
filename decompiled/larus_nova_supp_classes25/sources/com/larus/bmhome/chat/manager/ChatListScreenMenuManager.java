package com.larus.bmhome.chat.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.ConversationChangeModel;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.InputDialog;
import com.larus.common_ui.dialog.y0;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.api.z3;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import tx9.f3;
import tx9.w3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListScreenMenuManager {
    public static final /* synthetic */ int a = 0;

    public static final class a implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ Context a;
        public final /* synthetic */ FragmentManager b;
        public final /* synthetic */ ConversationModel c;
        public final /* synthetic */ ConversationChangeModel d;
        public final /* synthetic */ wh8.a e;
        public final /* synthetic */ t0 f;

        public final void confirm() {
            int r0 = ChatListScreenMenuManager.a;
            ChatListScreenMenuManager.c(this.a, this.b, this.c, this.d, this.e, this.f, true);
        }

        public a(Context r1, FragmentManager r2, ConversationModel r3, ConversationChangeModel r4, wh8.a r5, t0 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class b implements com.larus.common_ui.dialog.u {
        public b() {
        }

        public final void cancel() {
        }
    }

    public static final class c implements y0 {
        public final /* synthetic */ ConversationModel a;
        public final /* synthetic */ wc9.e b;
        public final /* synthetic */ BotModel c;
        public final /* synthetic */ t0 d;
        public final /* synthetic */ by7.e e;

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, ChatDraftItem.TYPE_TEXT);
            ConversationModel r0 = this.a;
            if (r0 == null) goto L5;
            r0.updateConversationName(this.b.a, r3);
        L5:
            int r4 = com.larus.bmhome.chat.trace.i0.a;
            int r5 = ChatListScreenMenuManager.a;
            JSONObject r6 = ChatListScreenMenuManager.h(this.b, this.c, this.d);
            by7.e r1 = this.e;
            Intrinsics.checkNotNullParameter(r6, "params");
            com.larus.bmhome.chat.trace.i0.a("edit_chat_name", r6, r1);
        }

        public c(ConversationModel r1, wc9.e r2, BotModel r3, t0 r4, by7.e r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class d implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ wc9.e a;
        public final /* synthetic */ BotModel b;
        public final /* synthetic */ t0 c;
        public final /* synthetic */ by7.e d;

        public final void cancel() {
            int r0 = com.larus.bmhome.chat.trace.i0.a;
            int r1 = ChatListScreenMenuManager.a;
            JSONObject r2 = ChatListScreenMenuManager.h(this.a, this.b, this.c);
            by7.e r3 = this.d;
            Intrinsics.checkNotNullParameter(r2, "params");
            com.larus.bmhome.chat.trace.i0.a("cancel_edit_chat_name", r2, r3);
        }

        public d(wc9.e r1, BotModel r2, t0 r3, by7.e r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class e implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ LifecycleOwner b;
        public final /* synthetic */ wh8.a c;
        public final /* synthetic */ View d;
        public final /* synthetic */ View e;
        public final /* synthetic */ Fragment f;
        public final /* synthetic */ wc9.e g;
        public final /* synthetic */ View h;
        public final /* synthetic */ t0 i;
        public final /* synthetic */ x0 j;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r15) {
            this.a.removeOnAttachStateChangeListener(this);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), null, null, new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1(this.c, this.d, this.e, this.f, this.g, this.h, this.b, this.i, this.j, null), 3, null);
        }

        public e(View r1, LifecycleOwner r2, wh8.a r3, View r4, View r5, Fragment r6, wc9.e r7, View r8, t0 r9, x0 r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }
    }

    static {
    }

    public ChatListScreenMenuManager() {
    }

    public static JSONObject b(wc9.e r3) {
        JSONObject r0 = new JSONObject();
        r0.put("object_type", "chat");
        if (r3 == null) goto L14;
        String r4 = r3.I;
        if (r4 == null) goto L14;
        if (r4.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L14;
    L15:
        r0.put("project_id", r4);
        return r0;
    L9:
        r1 = false;
    L14:
        r4 = "-";
        goto L15
    }

    public static boolean e(wh8.a r1) {
        if (r1 == null) goto L8;
        BotModel r2 = r1.b;
        if (r2 == null) goto L8;
        BotCreatorInfo r3 = r2.getBotCreatorInfo();
        if (r3 == null) goto L8;
        String r4 = r3.getId();
    L10:
        return Intrinsics.areEqual(r4, AccountService.a.getUserId());
    L8:
        r4 = null;
        goto L10
    }

    public static Integer f(wh8.a r0) {
        if (r0 == null) goto L6;
        BotModel r1 = r0.b;
        if (r1 == null) goto L6;
        return r1.getBotType();
    L6:
        return null;
    }

    public static String g(wh8.a r3) {
        ChatControlTrace r0 = ChatControlTrace.b;
        if (r3 == null) goto L7;
        wc9.e r1 = r3.a;
        if (r1 == null) goto L7;
        Integer r2 = r1.v;
    L9:
        return r0.g(r2, f(r3), e(r3));
    L7:
        r2 = null;
        goto L9
    }

    public static void a(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public static JSONObject h(wc9.e r5, BotModel r6, t0 r7) {
        JSONObject r0 = new JSONObject();
        String r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.getBotId();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.put("bot_id", r2);
        r0.put("conversation_id", r5.a);
        r0.put("object_type", "chat");
        String r3 = r5.I;
        if (r3 != null) goto L11;
    L18:
        r3 = "-";
    L19:
        r0.put("project_id", r3);
        ChatControlTrace r4 = ChatControlTrace.b;
        Integer r8 = r5.v;
        if (r6 == null) goto L22;
        Integer r9 = r6.getBotType();
    L23:
        if (r6 == null) goto L27;
        BotCreatorInfo r10 = r6.getBotCreatorInfo();
        if (r10 == null) goto L27;
        String r11 = r10.getId();
    L28:
        r0.put("chat_type", r4.g(r8, r9, Intrinsics.areEqual(r11, AccountService.a.getUserId())));
        if (r7 == null) goto L31;
        String r12 = r7.a;
    L32:
        if (r12 == null) goto L34;
        r0.put("click_from", r7.a);
    L34:
        if (r7 == null) goto L36;
        String r13 = r7.b;
    L37:
        if (r13 == null) goto L39;
        r0.put("current_page", r7.b);
    L39:
        if (r7 == null) goto L41;
        r1 = r7.e;
    L41:
        if (r1 == null) goto L43;
        r0.put("is_navigation_sidebar", r7.e);
    L43:
        return r0;
    L36:
        r13 = null;
        goto L37
    L31:
        r12 = null;
    L27:
        r11 = null;
        goto L28
    L22:
        r9 = null;
        goto L23
    L11:
        if (r3.length() <= 0) goto L13;
        boolean r14 = true;
    L14:
        if (r14 == true) goto L17;
        r3 = null;
    L17:
        if (r3 != null) goto L19;
    L13:
        r14 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public static void c(final Context r30, FragmentManager r31, ConversationModel r32, final ConversationChangeModel r33, final wh8.a r34, t0 r35, boolean r36) {
        Intrinsics.checkNotNullParameter(r30, "context");
        Intrinsics.checkNotNullParameter(r31, "manager");
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("deleteConversation started conversationId=");
        if (r34 == null) goto L7;
        wc9.e r9 = r34.a;
        if (r9 == null) goto L7;
        String r10 = r9.a;
    L8:
        r2.append(r10);
        r2.append(" confirmed=");
        r2.append(r36);
        r2.append(" clickFrom=");
        if (r35 == null) goto L11;
        String r11 = r35.a;
    L12:
        r2.append(r11);
        r1.i("ChatListScreenMenuManager", r2.toString());
        if (NetworkUtils.isNetworkAvailable(r30) == false) goto L228;
        if (r34 == null) goto L16;
        wc9.e r3 = r34.a;
    L18:
        if (ic8.n.D(r3) == false) goto L35;
        if (r34 == null) goto L28;
        wc9.e r4 = r34.a;
        if (r4 == null) goto L28;
        Integer r5 = r4.f;
        if (r5 == null) goto L28;
        if (r5.intValue() != 1) goto L28;
        boolean r6 = true;
    L29:
        if (r6 == true) goto L35;
        if (r36 == true) goto L35;
        if (r31.isStateSaved() == true) goto L231;
        CommonDialog.a r12 = new CommonDialog.a();
        r12.i(r30.getString(2131901554));
        r12.g(r30.getString(2131901553));
        CommonDialog.a.f(r12, new a(r30, r31, r32, r33, r34, r35), r30.getString(2131900203), false, 12);
        CommonDialog.a.e(r12, new b(), r30.getString(2131900202), 4);
        a(r12.a(), r31);
        return;
    L231:
        return;
    L28:
        r6 = false;
    L35:
        StringBuilder r0 = new StringBuilder("deleteConversation step01 isSocialScene=");
        if (r34 == null) goto L40;
        wc9.e r7 = r34.a;
        if (r7 == null) goto L40;
        Boolean r8 = Boolean.valueOf(ve8.c.a(r7));
    L41:
        r0.append(r8);
        r0.append("isChatOnly=");
        if (r34 == null) goto L44;
        wc9.e r13 = r34.a;
    L45:
        r0.append(ic8.n.m(r13));
        r1.i("ChatListScreenMenuManager", r0.toString());
        com.larus.audio.p0 r14 = AudioServiceDelegate.a.getAudioConfig();
        if (r34 == null) goto L48;
        BotModel r15 = r34.b;
    L50:
        if (r14.n(r15) == false) goto L52;
        String r16 = "1";
    L53:
        if (r34 == null) goto L59;
        wc9.e r17 = r34.a;
        if (r17 == null) goto L59;
        if (ve8.c.a(r17) != true) goto L59;
        boolean r18 = true;
    L60:
        if (r18 == false) goto L63;
        if (r32 == null) goto L229;
        ConversationModel.delete$default(r32, r34.a, null, 2, null);
    L229:
        r1.i("ChatListScreenMenuManager", "deleteConversation ended");
        return;
    L63:
        if (r34 == null) goto L65;
        wc9.e r19 = r34.a;
    L67:
        if (ic8.n.m(r19) == false) goto L69;
        CommonDialog.a r20 = new CommonDialog.a();
        r20.i(r30.getString(2131908261));
        r20.g(r30.getString(2131908260));
        CommonDialog.a.f(r20, new v(r32), r30.getString(2131901586), false, 12);
        CommonDialog.a.e(r20, new w(), r30.getString(2131908312), 4);
        r20.z = false;
        a(r20.a(), r31);
        goto L229
    L69:
        if (r34 == null) goto L73;
        BotModel r21 = r34.b;
        if (r21 == null) goto L73;
        String r22 = r21.getBotId();
    L75:
        if (r22 != null) goto L77;
        String r110 = "";
    L78:
        if (r34 == null) goto L82;
        wc9.e r23 = r34.a;
        if (r23 == null) goto L82;
        String r111 = r23.a;
    L83:
        ChatControlTrace r24 = ChatControlTrace.b;
        if (r34 == null) goto L88;
        wc9.e r112 = r34.a;
        if (r112 == null) goto L88;
        Integer r113 = r112.v;
    L89:
        String r114 = r24.g(r113, f(r34), e(r34));
        if (r35 == null) goto L92;
        String r115 = r35.a;
    L93:
        if (r35 == null) goto L95;
        String r116 = r35.b;
    L96:
        if (r35 == null) goto L98;
        String r25 = r35.d;
    L99:
        if (r34 == null) goto L101;
        String r26 = r34.e;
    L102:
        if (r35 == null) goto L104;
        String r27 = r35.e;
    L105:
        if (r34 == null) goto L114;
        wc9.e r28 = r34.a;
        if (r28 == null) goto L114;
        Integer r29 = r28.t;
        if (r29 == null) goto L114;
        if (r29.intValue() != 8) goto L114;
        boolean r37 = true;
    L115:
        if (r37 == false) goto L117;
        String r38 = "archived";
    L118:
        String r210 = r38;
        if (r34 == null) goto L121;
        wc9.e r39 = r34.a;
    L122:
        f3.a(r110, r111, r114, r115, r116, b(r39), r25, r16, r26, r27, r210, 64);
        StringBuilder r40 = new StringBuilder("deleteConversation step02 conversationType=");
        if (r34 == null) goto L127;
        wc9.e r41 = r34.a;
        if (r41 == null) goto L127;
        Integer r42 = r41.j;
    L128:
        r40.append(r42);
        r40.append("isLocal=");
        if (r34 == null) goto L133;
        wc9.e r43 = r34.a;
        if (r43 == null) goto L133;
        Integer r44 = r43.f;
    L134:
        r40.append(r44);
        r1.i("ChatListScreenMenuManager", r40.toString());
        if (r34 == null) goto L144;
        wc9.e r45 = r34.a;
        if (r45 == null) goto L144;
        Integer r46 = r45.j;
        if (r46 == null) goto L144;
        if (r46.intValue() != 3) goto L144;
        boolean r47 = true;
    L145:
        if (r47 == false) goto L154;
        Lazy r48 = q3.a;
        z3 r49 = q3.a();
        if (r49 == null) goto L154;
        BotModel r50 = r34.b;
        if (r50 == null) goto L154;
        final String r51 = r50.getBotId();
        if (r51 == null) goto L154;
        r49.n(new com.larus.bmhome.chat.manager.e(r51));
    L154:
        if (r34 == null) goto L163;
        wc9.e r52 = r34.a;
        if (r52 == null) goto L163;
        Integer r53 = r52.f;
        if (r53 == null) goto L163;
        if (r53.intValue() != 1) goto L163;
        boolean r54 = true;
    L164:
        if (r54 == false) goto L171;
        if (r32 == null) goto L181;
        BotModel r55 = r34.b;
        if (r55 == null) goto L169;
        String r56 = r55.getBotId();
    L170:
        r32.deleteRecommendBot(r56, new m(r33, r34, r30));
        goto L181
    L169:
        r56 = null;
    L181:
        if (r34 == null) goto L187;
        wc9.e r57 = r34.a;
        if (r57 == null) goto L187;
        if (ic8.n.r(r57) != true) goto L187;
        boolean r117 = true;
    L188:
        if (r117 == true) goto L229;
        if (r34 == null) goto L193;
        BotModel r58 = r34.b;
        if (r58 == null) goto L193;
        String r59 = r58.getBotId();
    L194:
        if (r59 != null) goto L196;
        String r118 = "";
    L197:
        if (r35 == null) goto L199;
        String r119 = r35.a;
    L200:
        if (r34 == null) goto L204;
        BotModel r60 = r34.b;
        if (r60 == null) goto L204;
        String r61 = r60.getBgImgUrl();
    L206:
        if (com.larus.utils.o0.d(r61) == false) goto L208;
        String r120 = "1";
    L209:
        if (r35 == null) goto L211;
        String r211 = r35.d;
    L212:
        if (r34 == null) goto L214;
        String r212 = r34.e;
    L215:
        if (r35 == null) goto L217;
        String r121 = r35.b;
    L218:
        if (r35 == null) goto L220;
        String r122 = r35.c;
    L221:
        if (r35 == null) goto L223;
        String r62 = r35.e;
    L224:
        if (r35 == null) goto L226;
        by7.e r213 = r35.f;
    L227:
        w3.a(r118, r119, r121, r120, r122, null, r211, r212, null, null, null, r16, r62, r213, 81120);
        goto L229
    L226:
        r213 = null;
        goto L227
    L223:
        r62 = null;
        goto L224
    L220:
        r122 = null;
        goto L221
    L217:
        r121 = null;
        goto L218
    L214:
        r212 = null;
        goto L215
    L211:
        r211 = null;
        goto L212
    L208:
        r120 = "0";
    L204:
        r61 = null;
        goto L206
    L199:
        r119 = null;
        goto L200
    L196:
        r118 = r59;
    L193:
        r59 = null;
    L187:
        r117 = false;
        goto L188
    L171:
        if (r32 == null) goto L181;
        if (r34 == null) goto L174;
        wc9.e r63 = r34.a;
    L175:
        if (r34 == null) goto L179;
        BotModel r64 = r34.b;
        if (r64 == null) goto L179;
        String r65 = r64.getBotId();
    L180:
        r32.delete(r63, r65);
    L179:
        r65 = null;
        goto L180
    L174:
        r63 = null;
    L163:
        r54 = false;
    L144:
        r47 = false;
    L133:
        r44 = null;
    L127:
        r42 = null;
        goto L128
    L121:
        r39 = null;
        goto L122
    L117:
        r38 = "normal";
    L114:
        r37 = false;
        goto L115
    L104:
        r27 = null;
        goto L105
    L101:
        r26 = null;
        goto L102
    L98:
        r25 = null;
        goto L99
    L95:
        r116 = null;
        goto L96
    L92:
        r115 = null;
    L88:
        r113 = null;
    L82:
        r111 = null;
        goto L83
    L77:
        r110 = r22;
    L73:
        r22 = null;
        goto L75
    L65:
        r19 = null;
    L59:
        r18 = false;
        goto L60
    L52:
        r16 = "0";
        goto L53
    L48:
        r15 = null;
        goto L50
    L44:
        r13 = null;
    L40:
        r8 = null;
        goto L41
    L16:
        r3 = null;
        goto L18
    L228:
        r1.i("ChatListScreenMenuManager", "deleteConversation step04 network disabled");
        t19.s.a.getClass();
        t19.s.b(r30, 2131908800, false);
        goto L229
    L11:
        r11 = null;
    L7:
        r10 = null;
        goto L8
    }

    public static void d(Context r16, FragmentManager r17, wc9.e r18, BotModel r19, ConversationModel r20, t0 r21, by7.e r22, String r23) {
        List r11 = CollectionsKt.emptyList();
        Boolean r12 = Boolean.TRUE;
        String r13 = r16.getString(2131905460);
        Intrinsics.checkNotNullParameter(r13, "title");
        if (r23 != null) goto L8;
        String r1 = r18.c;
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        String r14 = r1;
    L9:
        c r15 = new c(r20, r18, r19, r21, r22);
        Intrinsics.checkNotNullParameter(r15, "listener");
        d r2 = new d(r18, r19, r21, r22);
        Intrinsics.checkNotNullParameter(r2, "listener");
        InputDialog r3 = new InputDialog();
        r3.e = r12;
        r3.f = r13;
        r3.g = r14;
        r3.k = null;
        r3.l = r15;
        r3.m = null;
        r3.n = r2;
        r3.h = 40;
        r3.i = r11;
        r3.j = false;
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, null, r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r3, r4) == false) goto L17;
    L14:
        int r0 = com.larus.bmhome.chat.trace.i0.a;
        JSONObject r5 = h(r18, r19, r21);
        Intrinsics.checkNotNullParameter(r5, "params");
        com.larus.bmhome.chat.trace.i0.a("click_edit_chat_name", r5, r22);
        return;
    L17:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        r3.show(r17, null);
        goto L14
    L8:
        r14 = r23;
        goto L9
    }

    public static void i(final View r19, final FragmentManager r20, final x0 r21, final Function0 r22, final ConversationModel r23, final ConversationChangeModel r24, final wh8.a r25, final u0 r26, final t0 r27, final Fragment r28) {
        Intrinsics.checkNotNullParameter(r19, "v");
        Intrinsics.checkNotNullParameter(r20, "manager");
        Intrinsics.checkNotNullParameter(r21, "screenMenu");
        Intrinsics.checkNotNullParameter(r22, "menuViewHolder");
        FLogger r1 = FLogger.a;
        StringBuilder r4 = new StringBuilder("showScreenMenu ");
        BotModel r6 = null;
        if (r25 == null) goto L5;
        String r7 = r25.d();
    L6:
        r4.append(r7);
        r1.i("ChatListScreenMenuManager", r4.toString());
        r19.setPressed(false);
        r19.invalidate();
        Drawable r5 = r19.getBackground();
        r19.setBackgroundResource(v19.c.b(2130972363, r19.getContext(), 2131243651));
        Bitmap r14 = Bitmap.createBitmap(r19.getWidth(), r19.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r8 = new Canvas(r14);
        List<Integer> r9 = r26.d;
        if (r9 != null) goto L9;
        r9 = CollectionsKt.emptyList();
    L9:
        List r10 = CollectionsKt.distinct(r9);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L18;
        View r13 = r19.findViewById(((Number) r12.next()).intValue());
        if (r13 == null) goto L15;
        Pair r15 = TuplesKt.to(r13, Float.valueOf(r13.getAlpha()));
    L16:
        if (r15 == null) goto L11;
        r11.add(r15);
        goto L11
    L15:
        r15 = null;
        goto L16
    L18:
        Iterator r16 = r11.iterator();
    L20:
        if (r16.hasNext() == false) goto L59;
        ((View) ((Pair) r16.next()).component1()).setAlpha(0.0f);
        goto L20
    L59:
        r19.draw(r8);     // Catch: Throwable -> L52
        Iterator r17 = r11.iterator();
    L25:
        if (r17.hasNext() == false) goto L27;
        Pair r18 = (Pair) r17.next();
        ((View) r18.component1()).setAlpha(((Number) r18.component2()).floatValue());
        goto L25
    L27:
        r19.setBackground(r5);
        com.larus.audio.p0 r29 = AudioServiceDelegate.a.getAudioConfig();
        if (r25 == null) goto L31;
        r6 = r25.b;
    L31:
        if (r29.n(r6) == false) goto L33;
        String r30 = "1";
    L34:
        final String r110 = r30;
        if (r25 != null) goto L37;
    L39:
        final boolean r31 = false;
    L40:
        if (r25 == null) goto L49;
        wc9.e r32 = r25.a;
        if (r32 == null) goto L49;
        Integer r33 = r32.t;
        if (r33 == null) goto L49;
        if (r33.intValue() != 8) goto L49;
        final boolean r34 = true;
    L50:
        r21.i(new n(r26, r19));
        r21.j(r19, r26.b, r14, new o(r22, r25, r28, r26, r34, r31, r19, r21, r27, r110, r23, r20, r24));
        return;
    L49:
        r34 = false;
        goto L50
    L37:
        if (r25.c() != true) goto L39;
        r31 = true;
        goto L40
    L33:
        r30 = "0";
    L52:
        th = move-exception;
        Iterator r0 = r11.iterator();
    L55:
        if (r0.hasNext() == false) goto L57;
        Pair r2 = (Pair) r0.next();
        ((View) r2.component1()).setAlpha(((Number) r2.component2()).floatValue());
        goto L55
    L57:
        r19.setBackground(r5);
        throw th;
    L5:
        r7 = null;
        goto L6
    }
}
